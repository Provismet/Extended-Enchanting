package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.AspectEnchantment;

import com.provismet.CombatPlusCore.utility.CPCItemTags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class FrostAspectEnchantment extends AspectEnchantment {
    public FrostAspectEnchantment () {
        super(Enchantment.properties(
                CPCItemTags.ASPECT_ENCHANTABLE,
                CPCItemTags.ASPECT_PRIMARY_ENCHANTABLE,
                5,
                2,
                Enchantment.leveledCost(10, 20),
                Enchantment.leveledCost(25, 20),
                4,
                EquipmentSlot.MAINHAND
        ));
    }

    @Override
    public void postChargedHit (int level, LivingEntity user, LivingEntity target) {
        super.postChargedHit(level, user, target);
        int ticks = Math.min(target.getFrozenTicks() + level * 45, target.getMinFreezeDamageTicks() + 260);
        target.setFrozenTicks(ticks);
    }
}
