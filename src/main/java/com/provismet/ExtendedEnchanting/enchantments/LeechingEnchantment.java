package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.AspectEnchantment;

import com.provismet.CombatPlusCore.utility.CPCItemTags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class LeechingEnchantment extends AspectEnchantment {
    public LeechingEnchantment () {
        super(Enchantment.properties(
                CPCItemTags.ASPECT_ENCHANTABLE,
                CPCItemTags.ASPECT_PRIMARY_ENCHANTABLE,
                3,
                2,
                Enchantment.leveledCost(10, 20),
                Enchantment.leveledCost(50, 20),
                6,
                EquipmentSlot.MAINHAND
        ));
    }
    
    @Override
    public void postCriticalHit (int level, LivingEntity user, LivingEntity target) {
        super.postCriticalHit(level, user, target);
        user.heal(level);
    }
}
