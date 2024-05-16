package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.AdditionalDamageEnchantment;
import com.provismet.CombatPlusCore.utility.CPCItemTags;
import com.provismet.ExtendedEnchanting.utility.EEGameRules;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;

public class SolitudeEnchantment extends AdditionalDamageEnchantment {
    public SolitudeEnchantment () {
        super(Enchantment.properties(
                ItemTags.WEAPON_ENCHANTABLE,
                ItemTags.SHARP_WEAPON_ENCHANTABLE,
                1,
                1,
                Enchantment.constantCost(35),
                Enchantment.constantCost(75),
                8,
                EquipmentSlot.MAINHAND
        ));
    }
    
    @Override
    public float getAttackDamage (int level, EquipmentSlot slot, LivingEntity user, LivingEntity target) {
        if (slot == EquipmentSlot.MAINHAND) {
            ItemStack thisWeapon = user.getEquippedStack(slot);
            int numberOfEnchantments = thisWeapon.getEnchantments().getSize();
            if (numberOfEnchantments == 1) {
                float damage = 15f;
                if (target instanceof PlayerEntity) damage *= (float)user.getWorld().getGameRules().get(EEGameRules.PLAYER_SPECIAL_DAMAGE_MOD).get();
            
                return damage;
            }
        }
        return 0f;
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
