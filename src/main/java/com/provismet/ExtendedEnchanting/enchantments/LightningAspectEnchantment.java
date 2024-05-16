package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.AspectEnchantment;
import com.provismet.CombatPlusCore.utility.CPCItemTags;
import com.provismet.ExtendedEnchanting.interfaces.IMixinLivingEntity;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class LightningAspectEnchantment extends AspectEnchantment {
    public LightningAspectEnchantment () {
        super(Enchantment.properties(
                CPCItemTags.ASPECT_ENCHANTABLE,
                3,
                2,
                Enchantment.leveledCost(20, 10),
                Enchantment.leveledCost(70, 10),
                4,
                EquipmentSlot.MAINHAND
        ));
    }
    
    @Override
    public void postChargedHit (int level, LivingEntity user, LivingEntity target) {
        super.postChargedHit(level, user, target);
        ((IMixinLivingEntity)target).applyStatic(level);
    }
}
