package com.provismet.ExtendedEnchanting.registries;

import com.provismet.CombatPlusCore.enchantments.AdditionalDamageEnchantment;
import com.provismet.CombatPlusCore.enchantments.AspectEnchantment;
import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import com.provismet.ExtendedEnchanting.enchantments.FrostAspectEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.GlassEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.InitiativeEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.LeechingEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EEEnchantments {
    public static final AspectEnchantment LEECHING = new LeechingEnchantment();
    public static final AspectEnchantment FROST_ASPECT = new FrostAspectEnchantment();

    public static final AdditionalDamageEnchantment INITIATIVE = new InitiativeEnchantment();
    public static final AdditionalDamageEnchantment GLASS = new GlassEnchantment();

    private static void register (Enchantment enchantment, String name) {
        Registry.register(Registries.ENCHANTMENT, ExtendedEnchantingMain.identifier(name), enchantment);
    }

    public static void register () {
        register(LEECHING, "leeching");
        register(FROST_ASPECT, "frost_aspect");

        register(INITIATIVE, "initiative");
        register(GLASS, "glass");
    }
}
