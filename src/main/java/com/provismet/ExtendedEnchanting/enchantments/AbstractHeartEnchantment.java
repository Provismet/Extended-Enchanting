package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public abstract class AbstractHeartEnchantment extends Enchantment {
    protected AbstractHeartEnchantment (Rarity weight) {
        super(weight, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.CHEST});
    }

    protected AbstractHeartEnchantment () {
        this(Rarity.VERY_RARE);
    }
    
    public abstract void tick (LivingEntity user);

    @Override
    protected boolean canAccept (Enchantment other) {
        return super.canAccept(other) && !(other instanceof AbstractHeartEnchantment);
    }

    @Override
    public int getMinPower (int level) {
        return 25;
    }

    @Override
    public int getMaxPower (int level) {
        return 75;
    }
}
