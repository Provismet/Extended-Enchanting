package com.provismet.extendedenchanting.registries;

import com.provismet.combatplus.api.enchantment.effect.doubleEntity.CodeExecutionDoubleEntityEffect;
import com.provismet.combatplus.api.enchantment.effect.singleEntity.CodeExecutionSingleEntityEffect;
import com.provismet.combatplus.api.item.interfaces.MeleeWeapon;
import com.provismet.combatplus.utility.CombatPlusRegistries;
import com.provismet.extendedenchanting.ExtendedEnchantingMain;
import com.provismet.extendedenchanting.interfaces.IMixinLivingEntity;
import com.provismet.lilylib.util.Relations;
import java.util.Optional;
import java.util.function.Predicate;
import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public abstract class EELambdas {
    public static void register () {
        registerSingleEntityEffects();
        registerDoubleEntityEffects();
        registerItemConditions();
    }

    private static void registerSingleEntityEffects () {
        register("reset_insomnia", (world, level, context, user, pos) -> {
            if (user.tickCount % 5000 == 0 && user instanceof ServerPlayer serverPlayer) {
                serverPlayer.resetStat(Stats.CUSTOM.get(Stats.TIME_SINCE_REST));
            }
        });

        register("void_heart", (world, level, context, userEntity, pos) -> {
            if (!(userEntity instanceof LivingEntity user)) return;
            if (user.level().dimensionTypeRegistration().is(BuiltinDimensionTypes.END.identifier())) {
                if (user.onGround() && user.fallDistance == 0f) {
                    ((IMixinLivingEntity)user).extended_Enchanting$setPreviousGroundPos(user.position());
                }
                else if (((IMixinLivingEntity)user).extended_Enchanting$getPreviousGroundPos() != null && user.getY() < user.level().getMinY() - 32) {
                    user.fallDistance = 0f;
                    Vec3 previousPos = ((IMixinLivingEntity)user).extended_Enchanting$getPreviousGroundPos();
                    user.teleportTo(previousPos.x(), previousPos.y() + 5, previousPos.z());
                    user.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 50));
                    user.getItemBySlot(EquipmentSlot.CHEST).hurtAndBreak(100, user, EquipmentSlot.CHEST);
                }
                else if (user.fallDistance >= user.getAttributeValue(Attributes.SAFE_FALL_DISTANCE)) {
                    user.fallDistance = 0f;
                    user.getItemBySlot(EquipmentSlot.CHEST).hurtAndBreak(2, user, EquipmentSlot.CHEST);
                }
            }
            else {
                ((IMixinLivingEntity)user).extended_Enchanting$setPreviousGroundPos(null);
            }
        });

        register("chorus_teleport", (world, level, context, userEntity, pos) -> {
            if (!(userEntity instanceof LivingEntity user)) return;

            for (int i = 0; i < 16; ++i) {
                double x = pos.x() + (user.getRandom().nextDouble() - 0.5) * 16.0;
                double y = Mth.clamp(pos.y() + (double)(user.getRandom().nextInt(16) - 8), world.getMinY(), world.getMinY() + world.getLogicalHeight() - 1);
                double z = pos.z() + (user.getRandom().nextDouble() - 0.5) * 16.0;

                if (user.isPassenger()) user.stopRiding();
                if (!user.randomTeleport(x, y, z, true, _ -> false)) continue;
                world.gameEvent(GameEvent.TELEPORT, pos, GameEvent.Context.of(user));

                SoundSource soundCategory;
                SoundEvent soundEvent;
                if (user instanceof Fox) {
                    soundEvent = SoundEvents.FOX_TELEPORT;
                    soundCategory = SoundSource.NEUTRAL;
                } else {
                    soundEvent = SoundEvents.CHORUS_FRUIT_TELEPORT;
                    soundCategory = SoundSource.PLAYERS;
                }
                world.playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent, soundCategory);
                user.resetFallDistance();
                break;
            }
        });
    }

    private static void registerDoubleEntityEffects () {
        register("dual_strike", ((world, level, context, userEntity, targetEntity, pos) -> {
            if (!(userEntity instanceof LivingEntity user) || !(targetEntity instanceof LivingEntity target)) return;

            Optional<Entity> optionalTarget = user.level().getEntities(
                target,
                target.getBoundingBox().inflate(2.5, 0.25, 2.5),
                entity -> entity instanceof LivingEntity potentialTarget && potentialTarget.canBeSeenAsEnemy() && !Relations.isFriendly(user, potentialTarget)
            )
                .stream()
                .reduce((entity1, entity2) -> entity1.distanceTo(target) < entity2.distanceTo(target) ? entity1 : entity2);

            if (optionalTarget.isPresent() && optionalTarget.get() instanceof LivingEntity otherTarget) {
                double damage = 1 + user.getAttributeValue(Attributes.ATTACK_DAMAGE) * level * 0.2;
                if (user instanceof Player player) otherTarget.hurtServer(world, user.damageSources().playerAttack(player), (float)damage);
                else otherTarget.hurtServer(world, user.damageSources().mobAttack(user), (float)damage);

                ItemStack heldItem = user.getMainHandItem();
                if (heldItem.getItem() instanceof MeleeWeapon melee) {
                    melee.postChargedHit(heldItem, user, otherTarget);

                    if (user.fallDistance > 0.0f && !user.onGround() && !user.onClimbable() && !user.isInWater() && !user.hasEffect(MobEffects.BLINDNESS) && !user.isPassenger()) {
                        melee.postCriticalHit(heldItem, user, otherTarget);
                    }
                }
            }
        }));
    }

    private static void registerItemConditions () {
        register("one_enchantment", (itemStack -> itemStack.getEnchantments().size() == 1));
    }

    private static void register (String name, Predicate<ItemStack> lambda) {
        Registry.register(CombatPlusRegistries.ITEM_LAMBDA_CONDITION, ExtendedEnchantingMain.identifier(name), lambda);
    }

    private static void register (String name, CodeExecutionSingleEntityEffect.Lambda lambda) {
        Registry.register(CombatPlusRegistries.SINGLE_ENTITY_LAMBDA, ExtendedEnchantingMain.identifier(name), lambda);
    }

    private static void register (String name, CodeExecutionDoubleEntityEffect.Lambda lambda) {
        Registry.register(CombatPlusRegistries.DOUBLE_ENTITY_LAMBDA, ExtendedEnchantingMain.identifier(name), lambda);
    }
}
