package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.WeaponUtilityEnchantment;
import com.provismet.CombatPlusCore.utility.CPCEnchantmentHelper;

import com.provismet.CombatPlusCore.utility.CPCItemTags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.math.Vec3d;

public class BackFootEnchantment extends WeaponUtilityEnchantment {
    public BackFootEnchantment () {
        super(Enchantment.properties(
                ItemTags.WEAPON_ENCHANTABLE,
                CPCItemTags.MELEE_WEAPON,
                2,
                2,
                Enchantment.leveledCost(10, 10),
                Enchantment.leveledCost(50, 10),
                4,
                EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND
        ));
    }

    @Override
    public void postChargedHit (int level, LivingEntity user, LivingEntity target) {
        super.postChargedHit(level, user, target);
        if (!user.getWorld().isClient()) {
            Vec3d velocity = new Vec3d(user.getX() - target.getX(), 0.0, user.getZ() - target.getZ()).normalize().multiply(1 + (level - 1) * 0.5).add(0.0, 0.1, 0.0);
            user.addVelocity(velocity);
            user.velocityModified = true;
        }
    }

    @Override
    protected boolean canAccept (Enchantment other) {
        if (CPCEnchantmentHelper.isOffhand(other)) return true;
        return super.canAccept(other);
    }
}
