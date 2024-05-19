package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.WeaponUtilityEnchantment;

import com.provismet.CombatPlusCore.utility.CPCItemTags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class RampageEnchantment extends WeaponUtilityEnchantment {
    public RampageEnchantment () {
        super(Enchantment.properties(
                CPCItemTags.WEAPON_UTILITY_ENCHANTABLE,
                CPCItemTags.WEAPON_UTILITY_PRIMARY_ENCHANTABLE,
                5,
                3,
                Enchantment.leveledCost(5, 10),
                Enchantment.leveledCost(55, 10),
                3,
                EquipmentSlot.MAINHAND
        ));
    }
    
    @Override
    public void postKill (int level, LivingEntity user, LivingEntity target) {
        super.postKill(level, user, target);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 25 * level, 0), user);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 25 * level, 0), user);
    }
}
