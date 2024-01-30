package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.entity.LivingEntity;
import net.minecraft.world.dimension.DimensionTypes;

public class HeartNetherEnchantment extends AbstractHeartEnchantment {
    public HeartNetherEnchantment () {
        super();
    }

    @Override
    public void tick (LivingEntity user) {
        if (!user.getWorld().isClient() && user.getWorld().getDimensionKey() == DimensionTypes.THE_NETHER) {
            // TODO
        }
    }
    
}
