package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.AdditionalDamageEnchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class GlassEnchantment extends AdditionalDamageEnchantment {
    public GlassEnchantment () {
        super(Rarity.RARE, EnchantmentTarget.WEAPON);
    }

    @Override
    public float getAttackDamage (int level, EquipmentSlot slot, LivingEntity user, LivingEntity target) {
        if (slot == EquipmentSlot.MAINHAND && user.getHealth() >= user.getMaxHealth()) return level * 5f;
        return 0f;
    }

    @Override
    public int getMaxLevel () {
        return 3;
    }
}
