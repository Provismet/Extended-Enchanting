package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;

public class AbstractProtectionEnchantment extends ProtectionEnchantment {
    public AbstractProtectionEnchantment (Rarity weight) {
        super(weight, Type.PROJECTILE, new EquipmentSlot[] {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});
    }

    @Override
    public int getProtectionAmount (int level, DamageSource source) {
        return 0;
    }
}
