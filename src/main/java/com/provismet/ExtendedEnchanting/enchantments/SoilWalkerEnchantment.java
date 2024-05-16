package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.enchantment.DepthStriderEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.tag.ItemTags;

public class SoilWalkerEnchantment extends AbstractBootsEnchantment {
    public SoilWalkerEnchantment () {
        super(Enchantment.properties(
                ItemTags.FOOT_ARMOR_ENCHANTABLE,
                2,
                1,
                Enchantment.constantCost(15),
                Enchantment.constantCost(50),
                8,
                EquipmentSlot.FEET
        ));
    }
    
    @Override
    protected boolean canAccept (Enchantment other) {
        return super.canAccept(other) &&
            !(other instanceof DepthStriderEnchantment) &&
            !(other instanceof FrostWalkerEnchantment);
    }
}
