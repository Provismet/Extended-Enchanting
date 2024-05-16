package com.provismet.ExtendedEnchanting.enchantments;

import com.provismet.ExtendedEnchanting.interfaces.IMixinLivingEntity;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.dimension.DimensionTypes;

public class HeartVoidEnchantment extends AbstractHeartEnchantment {
    public HeartVoidEnchantment () {
        super();
    }

    @Override
    public void tick (LivingEntity user) {
        if (!user.getWorld().isClient()) {
            if (user.getWorld().getDimensionEntry().matchesId(DimensionTypes.THE_END.getValue())) {
                if (user.isOnGround() && user.fallDistance == 0f) {
                    ((IMixinLivingEntity)user).setPreviousGroundPos(user.getPos());
                }
                else if (((IMixinLivingEntity)user).getPreviousGroundPos() != null && user.getY() < user.getWorld().getBottomY() - 32) {
                    user.fallDistance = 0f;
                    Vec3d previousPos = ((IMixinLivingEntity)user).getPreviousGroundPos();
                    user.requestTeleport(previousPos.getX(), previousPos.getY() + 5, previousPos.getZ());
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 50));
                    user.getEquippedStack(EquipmentSlot.CHEST).damage(100, user, EquipmentSlot.CHEST);
                }
                else if (user.fallDistance >= user.getAttributeValue(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE)) {
                    user.fallDistance = 0f;
                    user.getEquippedStack(EquipmentSlot.CHEST).damage(2, user, EquipmentSlot.CHEST);
                }
            }
            else {
                ((IMixinLivingEntity)user).setPreviousGroundPos(null);
            }
        }
    }

    @Override
    public void offTick (LivingEntity user) {
        super.offTick(user);
        ((IMixinLivingEntity)user).setPreviousGroundPos(null);
    }
}
