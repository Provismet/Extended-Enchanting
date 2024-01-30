package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.enchantment.DepthStriderEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.FrostWalkerEnchantment;

public class SoilWalkerEnchantment extends AbstractBootsEnchantment {
    public SoilWalkerEnchantment () {
        super(Rarity.RARE);
    }
    
    @Override
    protected boolean canAccept (Enchantment other) {
        return super.canAccept(other) &&
            !(other instanceof DepthStriderEnchantment) &&
            !(other instanceof FrostWalkerEnchantment);
    }

    @Override
    public int getMinPower (int level) {
        return 15;
    }

    @Override
    public int getMaxPower (int level) {
        return 50;
    }
}
