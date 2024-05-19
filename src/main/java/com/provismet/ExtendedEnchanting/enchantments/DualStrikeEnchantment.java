package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.WeaponUtilityEnchantment;
import com.provismet.CombatPlusCore.interfaces.MeleeWeapon;
import com.provismet.CombatPlusCore.utility.CPCItemTags;
import com.provismet.lilylib.util.Relations;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class DualStrikeEnchantment extends WeaponUtilityEnchantment {
    public DualStrikeEnchantment () {
        super(Enchantment.properties(
                CPCItemTags.WEAPON_UTILITY_ENCHANTABLE,
                CPCItemTags.WEAPON_UTILITY_PRIMARY_ENCHANTABLE,
                5,
                3,
                Enchantment.leveledCost(10, 5),
                Enchantment.leveledCost(20, 10),
                4,
                EquipmentSlot.MAINHAND
        ));
    }
    
    @Override
    public void postChargedHit (int level, LivingEntity user, LivingEntity target) {
        super.postChargedHit(level, user, target);
        LivingEntity otherTarget = user.getWorld().getClosestEntity(LivingEntity.class, TargetPredicate.createAttackable().setPredicate(entity -> {
            return !Relations.isFriendly(user, entity) && entity != target;
        }), user, target.getX(), target.getY(), target.getZ(), target.getBoundingBox().expand(2.5, 0.25, 2.5));

        if (otherTarget != null) {
            double damage = 1 + user.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) * level * 0.2;
            if (user instanceof PlayerEntity player) otherTarget.damage(user.getDamageSources().playerAttack(player), (float)damage);
            else otherTarget.damage(user.getDamageSources().mobAttack(user), (float)damage);

            ItemStack heldItem = user.getMainHandStack();
            if (heldItem.getItem() instanceof MeleeWeapon melee) {
                melee.postChargedHit(heldItem, user, otherTarget);

                if (user.fallDistance > 0.0f && !user.isOnGround() && !user.isClimbing() && !user.isTouchingWater() && !user.hasStatusEffect(StatusEffects.BLINDNESS) && !user.hasVehicle()) {
                    melee.postCriticalHit(heldItem, user, otherTarget);
                }
            }
        }
    }
}
