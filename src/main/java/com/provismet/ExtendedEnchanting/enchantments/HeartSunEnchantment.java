package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class HeartSunEnchantment extends AbstractHeartEnchantment {
    public HeartSunEnchantment () {
        super();
    }

    @Override
    public void tick (LivingEntity user) {
        if (!user.getWorld().isClient() && user.getWorld().isDay() && user.getWorld().isSkyVisible(user.getBlockPos()) && !user.isWet()) {
            if (user.age % 40 == 0 && user.getHealth() < user.getMaxHealth() - 1f && user.isAlive()) {
                user.heal(2f);
                user.getEquippedStack(EquipmentSlot.CHEST).damage(10, user, EquipmentSlot.CHEST);
            }
        }
    }
    
    @Override
    public void onUserDamaged (LivingEntity user, Entity attacker, int level) {
        super.onUserDamaged(user, attacker, level);

        if (!user.getWorld().isClient() && user.getWorld().isDay() && user.getWorld().isSkyVisible(user.getBlockPos()) && !user.isWet()) {
            int fireTicks = attacker.getFireTicks() + 30;
            attacker.setFireTicks(Math.min(60, fireTicks));
            user.getEquippedStack(EquipmentSlot.CHEST).damage(2, user, EquipmentSlot.CHEST);
        }
    }
}
