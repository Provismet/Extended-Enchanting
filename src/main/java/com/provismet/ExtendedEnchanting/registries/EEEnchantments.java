package com.provismet.ExtendedEnchanting.registries;

import com.provismet.CombatPlusCore.enchantments.AdditionalDamageEnchantment;
import com.provismet.CombatPlusCore.enchantments.AspectEnchantment;
import com.provismet.CombatPlusCore.enchantments.WeaponUtilityEnchantment;
import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import com.provismet.ExtendedEnchanting.enchantments.BackFootEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.DualStrikeEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.FrostAspectEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.GlassEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.InitiativeEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.LaunchEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.LeechingEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.RampageEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.SolitudeEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.WeaponProtectionEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EEEnchantments {
    public static final AspectEnchantment LEECHING = new LeechingEnchantment();
    public static final AspectEnchantment FROST_ASPECT = new FrostAspectEnchantment();

    public static final AdditionalDamageEnchantment INITIATIVE = new InitiativeEnchantment();
    public static final AdditionalDamageEnchantment GLASS = new GlassEnchantment();
    public static final AdditionalDamageEnchantment SOLITUDE = new SolitudeEnchantment();

    public static final WeaponUtilityEnchantment DUAL_STRIKE = new DualStrikeEnchantment();
    public static final WeaponUtilityEnchantment BACK_FOOT = new BackFootEnchantment();
    public static final WeaponUtilityEnchantment RAMPAGE = new RampageEnchantment();

    public static final LaunchEnchantment LAUNCH = new LaunchEnchantment();

    public static final WeaponProtectionEnchantment WEAPON_PROTECTION = new WeaponProtectionEnchantment();

    private static void register (Enchantment enchantment, String name) {
        Registry.register(Registries.ENCHANTMENT, ExtendedEnchantingMain.identifier(name), enchantment);
    }

    public static void register () {
        register(LEECHING, "leeching");
        register(FROST_ASPECT, "frost_aspect");

        register(INITIATIVE, "initiative");
        register(GLASS, "glass");
        register(SOLITUDE, "solitude");

        register(DUAL_STRIKE, "dual_strike");
        register(BACK_FOOT, "back_foot");
        register(RAMPAGE, "rampage");

        register(LAUNCH, "launch");

        register(WEAPON_PROTECTION, "weapon_protection");
    }
}
