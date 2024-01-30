package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.entity.LivingEntity;

public class HeartSunEnchantment extends AbstractHeartEnchantment {
    public HeartSunEnchantment () {
        super(Rarity.RARE);
    }

    @Override
    public void tick (LivingEntity user) {
        if (!user.getWorld().isClient() && user.getWorld().isDay() && user.getWorld().isSkyVisible(user.getBlockPos()) && !user.isWet()) {
            // TODO
        }
    }
    
}
