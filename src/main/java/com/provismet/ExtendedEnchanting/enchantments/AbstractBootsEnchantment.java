package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public abstract class AbstractBootsEnchantment extends Enchantment {
    protected AbstractBootsEnchantment (Rarity weight) {
        super(weight, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[] {EquipmentSlot.FEET});
    }
}
