package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.CombatPlusCore.enchantments.WeaponUtilityEnchantment;
import com.provismet.lilylib.util.Relations;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class DualStrikeEnchantment extends WeaponUtilityEnchantment {
    public DualStrikeEnchantment () {
        super(Rarity.UNCOMMON, EquipmentSlot.MAINHAND);
    }
    
    @Override
    public void postChargedHit (int level, LivingEntity user, LivingEntity target) {
        super.postChargedHit(level, user, target);
        if (user.getWorld() instanceof ServerWorld serverWorld) {
            LivingEntity otherTarget = serverWorld.getClosestEntity(LivingEntity.class, TargetPredicate.createAttackable().setPredicate(entity -> {
                return !Relations.isFriendly(user, entity);
            }), target, target.getX(), target.getY(), target.getZ(), target.getBoundingBox().expand(2.5, 0.25, 2.5));

            if (otherTarget != null) {
                if (user instanceof PlayerEntity player) target.damage(user.getDamageSources().playerAttack(player), level * 2.5f);
                else target.damage(user.getDamageSources().mobAttack(user), level * 2.5f);
            }
        }
    }
}
