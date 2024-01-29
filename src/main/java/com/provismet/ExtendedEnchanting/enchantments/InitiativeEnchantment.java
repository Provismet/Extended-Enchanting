package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.AdditionalDamageEnchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class InitiativeEnchantment extends AdditionalDamageEnchantment {
    public InitiativeEnchantment () {
        super(Rarity.RARE, EnchantmentTarget.WEAPON);
    }
    
    @Override
    public float getAttackDamage (int level, EquipmentSlot slot, LivingEntity user, LivingEntity target) {
        if (slot == EquipmentSlot.MAINHAND && target.getHealth() >= target.getMaxHealth()) return level * 3f;
        return 0f;
    }

    @Override
    public int getMaxLevel () {
        return 5;
    }

    @Override
    public boolean isTreasure () {
        return true;
    }
}
