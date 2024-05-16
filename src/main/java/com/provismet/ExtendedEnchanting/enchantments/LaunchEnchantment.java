package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.interfaces.CPCEnchantment;
import com.provismet.CombatPlusCore.utility.CPCEnchantmentHelper;
import com.provismet.ExtendedEnchanting.utility.EETags;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.math.Vec3d;

public class LaunchEnchantment extends Enchantment implements CPCEnchantment {
    public LaunchEnchantment () {
        super(Enchantment.properties(
                ItemTags.SWORD_ENCHANTABLE,
                5,
                2,
                Enchantment.leveledCost(5, 20),
                Enchantment.leveledCost(50, 20),
                2,
                EquipmentSlot.MAINHAND
        ));
    }
    
    @Override
    public void postChargedHit (int level, LivingEntity user, LivingEntity target) {
        if (!user.getWorld().isClient() && !target.getType().isIn(EETags.Entity.NO_LAUNCH)) {
            double strength = 1.0 - target.getAttributeValue(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE);
            if (strength <= 0) return;

            Vec3d velocity = new Vec3d(0.0, level * 0.15, 0.0).multiply(strength);
            target.addVelocity(velocity);
        }
    }

    @Override
    public boolean canAccept (Enchantment other) {
        return super.canAccept(other) &&
            !(other == Enchantments.KNOCKBACK) &&
            !CPCEnchantmentHelper.isOffhand(other);
    }
}
