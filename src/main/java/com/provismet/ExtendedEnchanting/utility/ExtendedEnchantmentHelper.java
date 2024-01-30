package com.provismet.ExtendedEnchanting.utility;

import com.provismet.ExtendedEnchanting.enchantments.AbstractHeartEnchantment;
import com.provismet.ExtendedEnchanting.registries.EEEnchantments;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;

public class ExtendedEnchantmentHelper {
    public static AbstractHeartEnchantment getHeartEnchantment (ItemStack itemStack) {
        if (itemStack.isEmpty()) return null;
        if (EnchantmentHelper.getLevel(EEEnchantments.SUN_HEART, itemStack) > 0) return EEEnchantments.SUN_HEART;
        if (EnchantmentHelper.getLevel(EEEnchantments.MOON_HEART, itemStack) > 0) return EEEnchantments.MOON_HEART;
        if (EnchantmentHelper.getLevel(EEEnchantments.NETHER_HEART, itemStack) > 0) return EEEnchantments.NETHER_HEART;
        if (EnchantmentHelper.getLevel(EEEnchantments.END_HEART, itemStack) > 0) return EEEnchantments.END_HEART;
        return null;
    }
}
