package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.tag.ItemTags;

public abstract class AbstractHeartEnchantment extends Enchantment {
    protected AbstractHeartEnchantment () {
        super(Enchantment.properties(
                ItemTags.CHEST_ARMOR_ENCHANTABLE,
                1,
                1,
                Enchantment.constantCost(50),
                Enchantment.constantCost(75),
                8,
                EquipmentSlot.CHEST)
        );
    }
    
    public abstract void tick (LivingEntity user);

    public void offTick (LivingEntity user) {
        
    }

    @Override
    protected boolean canAccept (Enchantment other) {
        return super.canAccept(other) && !(other instanceof AbstractHeartEnchantment);
    }

    @Override
    public boolean isTreasure () {
        return true;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer () {
        return false;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }
}
