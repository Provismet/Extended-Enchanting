package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.tag.ItemTags;

public class ReplantingEnchantment extends Enchantment {
    public ReplantingEnchantment () {
        super(Enchantment.properties(
                ItemTags.HOES,
                1,
                1,
                Enchantment.constantCost(20),
                Enchantment.constantCost(75),
                8,
                EquipmentSlot.MAINHAND
        ));
    }
}
