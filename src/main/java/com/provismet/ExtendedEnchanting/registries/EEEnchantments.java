package com.provismet.ExtendedEnchanting.registries;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EEEnchantments {

    private static void register (Enchantment enchantment, String name) {
        Registry.register(Registries.ENCHANTMENT, ExtendedEnchantingMain.identifier(name), enchantment);
    }

    public static void register () {

    }
}
