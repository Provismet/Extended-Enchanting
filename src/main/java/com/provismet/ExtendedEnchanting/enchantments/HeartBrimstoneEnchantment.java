package com.provismet.ExtendedEnchanting.enchantments;

import java.util.UUID;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.world.dimension.DimensionTypes;

public class HeartBrimstoneEnchantment extends AbstractHeartEnchantment {
    private static final UUID LAVA_SPEED = UUID.nameUUIDFromBytes("Extended Enchanting: Lava Speed".getBytes());

    public HeartBrimstoneEnchantment () {
        super(Rarity.VERY_RARE);
    }

    @Override
    public void tick (LivingEntity user) {
        if (!user.getWorld().isClient() && user.getWorld().getDimensionKey() == DimensionTypes.THE_NETHER) {
            EntityAttributeInstance speed = user.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
            if (speed == null) return;

            if (user.isOnFire()) {
                if (user.age % 20 == 0 && user.getHealth() <= user.getMaxHealth() - 3f && user.isAlive()) {
                    user.heal(4f);
                    user.getEquippedStack(EquipmentSlot.CHEST).damage(5, user, p -> p.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
                }

                if (speed.getModifier(LAVA_SPEED) == null)
                    speed.addTemporaryModifier(new EntityAttributeModifier(LAVA_SPEED, "Extended Enchanting: Heart of Brimstone", 0.03, EntityAttributeModifier.Operation.ADDITION));

                if (user.getRandom().nextDouble() < 0.1) {
                    user.getEquippedStack(EquipmentSlot.CHEST).damage(2, user, p -> p.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
                }
            }
            else if (speed.getModifier(LAVA_SPEED) != null) {
                speed.removeModifier(LAVA_SPEED);
            }
        }
    }

    @Override
    public void offTick (LivingEntity user) {
        super.offTick(user);
        EntityAttributeInstance speed = user.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);
        if (speed == null) return;

        if (speed.getModifier(LAVA_SPEED) != null) speed.removeModifier(LAVA_SPEED);
    }
    
}
