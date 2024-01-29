package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.WeaponUtilityEnchantment;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class RampageEnchantment extends WeaponUtilityEnchantment {
    public RampageEnchantment () {
        super(Rarity.RARE, EquipmentSlot.MAINHAND);
    }
    
    @Override
    public void postKill (int level, LivingEntity user, LivingEntity target) {
        super.postKill(level, user, target);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 10 * level, 0), user);
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10 * level, 0), user);
    }

    @Override
    public int getMaxLevel () {
        return 3;
    }

    @Override
    public int getMinPower (int level) {
        return 10 * (level - 1);
    }

    @Override
    public int getMaxPower (int level) {
        return this.getMinPower(level) + 50;
    }
}
