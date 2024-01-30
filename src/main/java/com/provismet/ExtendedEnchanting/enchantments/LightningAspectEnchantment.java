package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.AspectEnchantment;
import com.provismet.ExtendedEnchanting.interfaces.IMixinLivingEntity;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class LightningAspectEnchantment extends AspectEnchantment {
    public LightningAspectEnchantment () {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND);
    }
    
    @Override
    public void postChargedHit (int level, LivingEntity user, LivingEntity target) {
        super.postChargedHit(level, user, target);
        ((IMixinLivingEntity)target).applyStatic(level);
    }

    @Override
    public int getMinPower (int level) {
        return 20 + 10 * (level - 1);
    }

    @Override
    public int getMaxPower (int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public int getMaxLevel () {
        return 2;
    }
}
