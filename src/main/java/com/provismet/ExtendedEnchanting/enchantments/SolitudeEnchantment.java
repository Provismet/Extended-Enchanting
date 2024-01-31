package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.AdditionalDamageEnchantment;
import com.provismet.ExtendedEnchanting.utility.EEGameRules;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class SolitudeEnchantment extends AdditionalDamageEnchantment {
    public SolitudeEnchantment () {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON);
    }
    
    @Override
    public float getAttackDamage (int level, EquipmentSlot slot, LivingEntity user, LivingEntity target) {
        if (slot == EquipmentSlot.MAINHAND) {
            ItemStack thisWeapon = user.getEquippedStack(slot);
            int numberOfEnchantments = EnchantmentHelper.get(thisWeapon).size();
            if (numberOfEnchantments == 1) {
                float damage = 15f;
                if (target instanceof PlayerEntity) damage *= (float)user.getWorld().getGameRules().get(EEGameRules.PLAYER_SPECIAL_DAMAGE_MOD).get();
            
                return damage;
            }
        }
        return 0f;
    }

    @Override
    public int getMaxLevel () {
        return 1;
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

    @Override
    public boolean canAccept (Enchantment other) {
        return false;
    }
}
