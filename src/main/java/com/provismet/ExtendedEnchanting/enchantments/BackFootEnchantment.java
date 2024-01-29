package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.OffHandEnchantment;
import com.provismet.CombatPlusCore.enchantments.WeaponUtilityEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class BackFootEnchantment extends WeaponUtilityEnchantment {
    public BackFootEnchantment () {
        super(Rarity.UNCOMMON, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND);
    }

    @Override
    public void postChargedHit (int level, LivingEntity user, LivingEntity target) {
        super.postChargedHit(level, user, target);
        if (!user.getWorld().isClient()) {
            double dx = target.getX() - user.getX();
            double dz = target.getZ() - user.getZ();
            user.takeKnockback(1.0, dx, dz);
        }
    }
    
    @Override
    protected boolean canAccept(Enchantment other) {
        if (other instanceof OffHandEnchantment) return true;
        return super.canAccept(other);
    }
}
