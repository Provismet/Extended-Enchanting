package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.ExtendedEnchanting.utility.EETags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;

public class ReplantingEnchantment extends Enchantment {
    public ReplantingEnchantment () {
        super(Enchantment.properties(
            EETags.Items.HOE_ENCHANTABLE,
            1,
            1,
            Enchantment.constantCost(20),
            Enchantment.constantCost(75),
            8,
            EquipmentSlot.MAINHAND
        ));
    }
}
