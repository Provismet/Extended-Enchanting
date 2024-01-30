package com.provismet.ExtendedEnchanting.utility;

import com.provismet.ExtendedEnchanting.registries.EEEnchantments;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class ExtendedEnchantmentHelper {
    public static void tickHeartEnchantments (LivingEntity user) {
        ItemStack itemStack = user.getEquippedStack(EquipmentSlot.CHEST);
        
        if (EnchantmentHelper.getLevel(EEEnchantments.SUN_HEART, itemStack) > 0) EEEnchantments.SUN_HEART.tick(user);
        else EEEnchantments.SUN_HEART.offTick(user);

        if (EnchantmentHelper.getLevel(EEEnchantments.MOON_HEART, itemStack) > 0) EEEnchantments.MOON_HEART.tick(user);
        else EEEnchantments.MOON_HEART.offTick(user);

        if (EnchantmentHelper.getLevel(EEEnchantments.BRIMSTONE_HEART, itemStack) > 0) EEEnchantments.BRIMSTONE_HEART.tick(user);
        else EEEnchantments.BRIMSTONE_HEART.offTick(user);

        if (EnchantmentHelper.getLevel(EEEnchantments.VOID_HEART, itemStack) > 0) EEEnchantments.VOID_HEART.tick(user);
        else EEEnchantments.VOID_HEART.offTick(user);
    }
}
