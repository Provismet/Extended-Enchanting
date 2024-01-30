package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;

public class HeartMoonEnchantment extends AbstractHeartEnchantment {
    public HeartMoonEnchantment () {
        super(Rarity.VERY_RARE);
    }

    @Override
    public void tick (LivingEntity user) {
        if (!user.getWorld().isClient() && user.getWorld().isNight() && user.getWorld().isSkyVisible(user.getBlockPos()) && !user.isWet()) {
            // No Phantoms
            if (user.age % 5000 == 0 && user instanceof ServerPlayerEntity serverPlayer) {
                serverPlayer.resetStat(Stats.CUSTOM.getOrCreateStat(Stats.TIME_SINCE_REST));
            }
        }
    }

    @Override
    public void onUserDamaged (LivingEntity user, Entity attacker, int level) {
        super.onUserDamaged(user, attacker, level);
        if (!user.getWorld().isClient() && user.getWorld().isNight() && user.getWorld().isSkyVisible(user.getBlockPos()) && !user.isWet()) {
            if (attacker instanceof LivingEntity living) {
                living.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 1), user);
                user.getEquippedStack(EquipmentSlot.CHEST).damage(5, user, p -> p.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
            }
        }
    }
}
