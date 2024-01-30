package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.OffHandEnchantment;
import com.provismet.CombatPlusCore.interfaces.CPCEnchantment;
import com.provismet.ExtendedEnchanting.utility.EETags;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.KnockbackEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class LaunchEnchantment extends Enchantment implements CPCEnchantment {
    public LaunchEnchantment () {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }
    
    @Override
    public void postChargedHit (int level, LivingEntity user, LivingEntity target) {
        if (!user.getWorld().isClient() && !target.getType().isIn(EETags.NO_LAUNCH)) target.addVelocity(0.0, level * 0.5, 0.0);
    }

    @Override
    public int getMaxLevel () {
        return 2;
    }

    @Override
    public int getMinPower(int level) {
        return 5 + 20 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public boolean canAccept (Enchantment other) {
        return super.canAccept(other) &&
            !(other instanceof KnockbackEnchantment) &&
            !(other instanceof OffHandEnchantment);
    }
}
