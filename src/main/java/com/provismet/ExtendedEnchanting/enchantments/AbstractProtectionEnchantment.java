package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;

public class AbstractProtectionEnchantment extends ProtectionEnchantment {
    protected static final EquipmentSlot[] ARMOUR = new EquipmentSlot[] {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public AbstractProtectionEnchantment (Properties properties) {
        super(properties, Type.PROJECTILE);
    }

    @Override
    public int getProtectionAmount (int level, DamageSource source) {
        return 0;
    }
}
