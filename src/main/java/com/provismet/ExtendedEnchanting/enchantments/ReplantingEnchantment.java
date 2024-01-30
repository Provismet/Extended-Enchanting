package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.ExtendedEnchanting.utility.EEEnchantmentTarget;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;

public class ReplantingEnchantment extends Enchantment {
    public ReplantingEnchantment () {
        super(Rarity.UNCOMMON, EEEnchantmentTarget.HOE, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }
    
    @Override
    public int getMinPower (int level) {
        return 10;
    }

    @Override
    public int getMaxPower (int level) {
        return 50;
    }
}
