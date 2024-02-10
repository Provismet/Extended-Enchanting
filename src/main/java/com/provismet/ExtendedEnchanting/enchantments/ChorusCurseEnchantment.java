package com.provismet.ExtendedEnchanting.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.event.GameEvent;

public class ChorusCurseEnchantment extends Enchantment {
    public ChorusCurseEnchantment () {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.CHEST});
    }
    
    @Override
    public int getMinPower(int level) {
        return 25;
    }

    @Override
    public int getMaxPower(int level) {
        return 50;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return !stack.isOf(Items.SHIELD) && super.isAcceptableItem(stack);
    }

    @Override
    public void onUserDamaged (LivingEntity user, Entity attacker, int level) {
        super.onUserDamaged(user, attacker, level);

        // This code is taken directly from the Chorus Fruit consume action.
        for (int i = 0; i < 16; ++i) {
            double x = user.getX() + (user.getRandom().nextDouble() - 0.5) * 16.0;
            double y = MathHelper.clamp(user.getY() + (double)(user.getRandom().nextInt(16) - 8), (double)user.getWorld().getBottomY(), (double)(user.getWorld().getBottomY() + ((ServerWorld)user.getWorld()).getLogicalHeight() - 1));
            double z = user.getZ() + (user.getRandom().nextDouble() - 0.5) * 16.0;

            if (user.hasVehicle()) {
                user.stopRiding();
            }
            Vec3d pos = user.getPos();
            if (!user.teleport(x, y, z, true)) continue;

            user.getWorld().emitGameEvent(GameEvent.TELEPORT, pos, GameEvent.Emitter.of(user));
            SoundEvent soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
            user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent, SoundCategory.PLAYERS, 1.0f, 1.0f);
            user.playSound(soundEvent, 1.0f, 1.0f);
            break;
        }
    }
}
