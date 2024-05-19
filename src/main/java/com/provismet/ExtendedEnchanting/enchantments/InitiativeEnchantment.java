package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.AdditionalDamageEnchantment;
import com.provismet.CombatPlusCore.utility.CPCItemTags;
import com.provismet.ExtendedEnchanting.utility.EEGameRules;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class InitiativeEnchantment extends AdditionalDamageEnchantment {
    public InitiativeEnchantment () {
        super(Enchantment.properties(
                CPCItemTags.DAMAGE_ENCHANTABLE,
                CPCItemTags.DAMAGE_PRIMARY_ENCHANTABLE,
                5,
                5,
                Enchantment.leveledCost(10, 5),
                Enchantment.leveledCost(50, 5),
                3,
                EquipmentSlot.MAINHAND
        ));
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
    public boolean isTreasure () {
        return true;
    }
}
