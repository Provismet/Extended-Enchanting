package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.entity.LivingEntity;

public class HeartMoonEnchantment extends AbstractHeartEnchantment {
    public HeartMoonEnchantment () {
        super(Rarity.RARE);
    }

    @Override
    public void tick (LivingEntity user) {
        if (!user.getWorld().isClient() && user.getWorld().isNight() && user.getWorld().isSkyVisible(user.getBlockPos()) && !user.isWet()) {
            // TODO
        }
    }
}
