package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.utility.WeaponTypes;
import com.provismet.ExtendedEnchanting.utility.EETags;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.ItemTags;

public class WeaponProtectionEnchantment extends AbstractProtectionEnchantment {
    public WeaponProtectionEnchantment () {
        super(Enchantment.properties(
                ItemTags.ARMOR_ENCHANTABLE,
                1,
                4,
                Enchantment.leveledCost(10, 5),
                Enchantment.leveledCost(20, 5),
                4,
                AbstractProtectionEnchantment.ARMOUR
        ));
    }
    
    @Override
    public int getProtectionAmount (int level, DamageSource source) {
        if (source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) return 0;
        if (source.isIn(EETags.Damage.MELEE_STRIKE) || (!source.isIndirect() && source.getSource() instanceof LivingEntity living && living.getType().isIn(EETags.Entity.HAS_WEAPON))) return (int)(level * 1.5f);
        if (source.isIn(EETags.Damage.DIRECT_ATTACK) && source.getAttacker() instanceof LivingEntity living) {
            if (WeaponTypes.isMeleeWeapon(living.getMainHandStack())) return (int)(level * 1.5f);
        }
        return super.getProtectionAmount(level, source);
    }
}
