package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.OffHandEnchantment;
import com.provismet.CombatPlusCore.enchantments.WeaponUtilityEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

public class BackFootEnchantment extends WeaponUtilityEnchantment {
    public BackFootEnchantment () {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND);
    }

    @Override
    public void postChargedHit (int level, LivingEntity user, LivingEntity target) {
        super.postChargedHit(level, user, target);
        Vec3d velocity = new Vec3d(user.getX() - target.getX(), 0.0, user.getZ() - target.getZ()).normalize().multiply(1 + (level - 1) * 0.5).add(0.0, 0.1, 0.0);
        user.addVelocity(velocity);
    }
    
    @Override
    protected boolean canAccept (Enchantment other) {
        if (other instanceof OffHandEnchantment) return true;
        return super.canAccept(other);
    }

    @Override
    public int getMaxLevel () {
        return 2;
    }

    @Override
    public int getMinPower (int level) {
       return 10 + 10 * level;
    }

    @Override
    public int getMaxPower (int level) {
        return this.getMinPower(level) + 50;
    }
}
