package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.AspectEnchantment;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class FrostAspectEnchantment extends AspectEnchantment {
    public FrostAspectEnchantment () {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND);
    }

    @Override
    public void postChargedHit (int level, LivingEntity user, LivingEntity target) {
        super.postChargedHit(level, user, target);
        int ticks = target.getFrozenTicks();
        target.setFrozenTicks(ticks + level * 25);
    }
    
    @Override
    public int getMinPower (int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxPower (int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
