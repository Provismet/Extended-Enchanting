package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.ExtendedEnchanting.utility.EETags;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.ItemTags;

public class CombustionProtectionEnchantment extends AbstractProtectionEnchantment {
    public CombustionProtectionEnchantment () {
        super(Enchantment.properties(
                ItemTags.ARMOR_ENCHANTABLE,
                1,
                4,
                Enchantment.leveledCost(10, 5),
                Enchantment.leveledCost(20, 5),
                4,
                AbstractProtectionEnchantment.ARMOUR
        ));
    }
    
    @Override
    public int getProtectionAmount (int level, DamageSource source) {
        if (source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) return 0;
        if (source.isIn(EETags.Damage.COMBUSTION)) return (int)(level * 1.5f);
        return super.getProtectionAmount(level, source);
    }
}
