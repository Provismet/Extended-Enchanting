package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.ExtendedEnchanting.utility.EETags;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.tag.DamageTypeTags;

public class CombustionProtectionEnchantment extends AbstractProtectionEnchantment {
    public CombustionProtectionEnchantment () {
        super(Rarity.RARE);
    }
    
    @Override
    public int getProtectionAmount (int level, DamageSource source) {
        if (source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) return 0;
        if (source.isIn(EETags.Damage.COMBUSTION)) return (int)(level * 1.5f);
        return super.getProtectionAmount(level, source);
    }
}
