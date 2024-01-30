package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.ExtendedEnchanting.utility.EETags;

import net.minecraft.entity.damage.DamageSource;

public class CombustionProtectionEnchantment extends AbstractProtectionEnchantment {
    public CombustionProtectionEnchantment () {
        super(Rarity.RARE);
    }
    
    @Override
    public int getProtectionAmount (int level, DamageSource source) {
        if (source.isIn(EETags.COMBUSTION)) return (int)(level * 1.5f);
        return super.getProtectionAmount(level, source);
    }
}
