package com.provismet.ExtendedEnchanting.registries;

import com.provismet.CombatPlusCore.enchantment.effect.doubleEntity.CodeExecutionDoubleEntityEffect;
import com.provismet.CombatPlusCore.enchantment.effect.singleEntity.CodeExecutionSingleEntityEffect;
import com.provismet.CombatPlusCore.interfaces.MeleeWeapon;
import com.provismet.CombatPlusCore.utility.CPCRegistries;
import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import com.provismet.ExtendedEnchanting.interfaces.IMixinLivingEntity;
import com.provismet.lilylib.util.Relations;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.event.GameEvent;

import java.util.Optional;
import java.util.function.Predicate;

public abstract class EELambdas {
    public static void register () {
        registerSingleEntityEffects();
        registerDoubleEntityEffects();
        registerItemConditions();
    }

    private static void registerSingleEntityEffects () {
        register("reset_insomnia", (world, level, context, user, pos) -> {
            if (user.age % 5000 == 0 && user instanceof ServerPlayerEntity serverPlayer) {
                serverPlayer.resetStat(Stats.CUSTOM.getOrCreateStat(Stats.TIME_SINCE_REST));
            }
        });

        register("void_heart", (world, level, context, userEntity, pos) -> {
            if (!(userEntity instanceof LivingEntity user)) return;
            if (user.getWorld().getDimensionEntry().matchesId(DimensionTypes.THE_END.getValue())) {
                if (user.isOnGround() && user.fallDistance == 0f) {
                    ((IMixinLivingEntity)user).extended_Enchanting$setPreviousGroundPos(user.getPos());
                }
                else if (((IMixinLivingEntity)user).extended_Enchanting$getPreviousGroundPos() != null && user.getY() < user.getWorld().getBottomY() - 32) {
                    user.fallDistance = 0f;
                    Vec3d previousPos = ((IMixinLivingEntity)user).extended_Enchanting$getPreviousGroundPos();
                    user.requestTeleport(previousPos.getX(), previousPos.getY() + 5, previousPos.getZ());
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 50));
                    user.getEquippedStack(EquipmentSlot.CHEST).damage(100, user, EquipmentSlot.CHEST);
                }
                else if (user.fallDistance >= user.getAttributeValue(EntityAttributes.SAFE_FALL_DISTANCE)) {
                    user.fallDistance = 0f;
                    user.getEquippedStack(EquipmentSlot.CHEST).damage(2, user, EquipmentSlot.CHEST);
                }
            }
            else {
                ((IMixinLivingEntity)user).extended_Enchanting$setPreviousGroundPos(null);
            }
        });

        register("chorus_teleport", (world, level, context, userEntity, pos) -> {
            if (!(userEntity instanceof LivingEntity user)) return;

            for (int i = 0; i < 16; ++i) {
                double x = pos.getX() + (user.getRandom().nextDouble() - 0.5) * 16.0;
                double y = MathHelper.clamp(pos.getY() + (double)(user.getRandom().nextInt(16) - 8), world.getBottomY(), world.getBottomY() + world.getLogicalHeight() - 1);
                double z = pos.getZ() + (user.getRandom().nextDouble() - 0.5) * 16.0;

                if (user.hasVehicle()) user.stopRiding();
                if (!user.teleport(x, y, z, true)) continue;
                world.emitGameEvent(GameEvent.TELEPORT, pos, GameEvent.Emitter.of(user));

                SoundCategory soundCategory;
                SoundEvent soundEvent;
                if (user instanceof FoxEntity) {
                    soundEvent = SoundEvents.ENTITY_FOX_TELEPORT;
                    soundCategory = SoundCategory.NEUTRAL;
                } else {
                    soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                    soundCategory = SoundCategory.PLAYERS;
                }
                world.playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent, soundCategory);
                user.onLanding();
                break;
            }
        });
    }

    private static void registerDoubleEntityEffects () {
        register("dual_strike", ((world, level, context, userEntity, targetEntity, pos) -> {
            if (!(userEntity instanceof LivingEntity user) || !(targetEntity instanceof LivingEntity target)) return;

            Optional<Entity> optionalTarget = user.getWorld().getOtherEntities(
                target,
                target.getBoundingBox().expand(2.5, 0.25, 2.5),
                entity -> entity instanceof LivingEntity potentialTarget && potentialTarget.canTakeDamage() && !Relations.isFriendly(user, potentialTarget)
            )
                .stream()
                .reduce((entity1, entity2) -> entity1.distanceTo(target) < entity2.distanceTo(target) ? entity1 : entity2);

            if (optionalTarget.isPresent() && optionalTarget.get() instanceof LivingEntity otherTarget) {
                double damage = 1 + user.getAttributeValue(EntityAttributes.ATTACK_DAMAGE) * level * 0.2;
                if (user instanceof PlayerEntity player) otherTarget.damage(world, user.getDamageSources().playerAttack(player), (float)damage);
                else otherTarget.damage(world, user.getDamageSources().mobAttack(user), (float)damage);

                ItemStack heldItem = user.getMainHandStack();
                if (heldItem.getItem() instanceof MeleeWeapon melee) {
                    melee.postChargedHit(heldItem, user, otherTarget);

                    if (user.fallDistance > 0.0f && !user.isOnGround() && !user.isClimbing() && !user.isTouchingWater() && !user.hasStatusEffect(StatusEffects.BLINDNESS) && !user.hasVehicle()) {
                        melee.postCriticalHit(heldItem, user, otherTarget);
                    }
                }
            }
        }));
    }

    private static void registerItemConditions () {
        register("one_enchantment", (itemStack -> itemStack.getEnchantments().getSize() == 1));
    }

    private static void register (String name, Predicate<ItemStack> lambda) {
        Registry.register(CPCRegistries.ITEM_LAMBDA_CONDITION, ExtendedEnchantingMain.identifier(name), lambda);
    }

    private static void register (String name, CodeExecutionSingleEntityEffect.Lambda lambda) {
        Registry.register(CPCRegistries.SINGLE_ENTITY_LAMBDA, ExtendedEnchantingMain.identifier(name), lambda);
    }

    private static void register (String name, CodeExecutionDoubleEntityEffect.Lambda lambda) {
        Registry.register(CPCRegistries.DOUBLE_ENTITY_LAMBDA, ExtendedEnchantingMain.identifier(name), lambda);
    }
}
