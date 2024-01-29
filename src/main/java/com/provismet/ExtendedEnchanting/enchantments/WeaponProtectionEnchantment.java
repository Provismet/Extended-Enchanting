package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.utility.WeaponTypes;
import com.provismet.ExtendedEnchanting.utility.EETags;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class WeaponProtectionEnchantment extends AbstractProtectionEnchantment {
    public WeaponProtectionEnchantment () {
        super(Rarity.RARE);
    }
    
    @Override
    public int getProtectionAmount (int level, DamageSource damageSource) {
        if (damageSource.isIn(EETags.MELEE_STRIKE)) return (int)(level * 1.5f);
        if (damageSource.isIn(EETags.DIRECT_ATTACK) && damageSource.getAttacker() instanceof LivingEntity living) {
            if (WeaponTypes.isMeleeWeapon(living.getMainHandStack())) return (int)(level * 1.5f);
        }
        return super.getProtectionAmount(level, damageSource);
    }
}
