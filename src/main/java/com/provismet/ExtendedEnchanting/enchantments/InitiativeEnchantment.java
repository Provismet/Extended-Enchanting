package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.AdditionalDamageEnchantment;
import com.provismet.ExtendedEnchanting.utility.EEGameRules;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class InitiativeEnchantment extends AdditionalDamageEnchantment {
    public InitiativeEnchantment () {
        super(Rarity.RARE, EnchantmentTarget.WEAPON);
    }
    
    @Override
    public float getAttackDamage (int level, EquipmentSlot slot, LivingEntity user, LivingEntity target) {
        if (slot == EquipmentSlot.MAINHAND && target.getHealth() >= target.getMaxHealth()) {
            float damage = level * 2.2f;
            if (target instanceof PlayerEntity) damage *= (float)user.getWorld().getGameRules().get(EEGameRules.PLAYER_SPECIAL_DAMAGE_MOD).get();
            
            return damage;
        }
        return 0f;
    }

    @Override
    public int getMaxLevel () {
        return 5;
    }

    @Override
    public int getMinPower (int level) {
        return 10 + 5 * level;
    }

    @Override
    public int getMaxPower (int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public boolean isTreasure () {
        return true;
    }
}
