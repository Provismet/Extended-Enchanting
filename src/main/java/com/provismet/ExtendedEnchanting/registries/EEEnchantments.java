package com.provismet.ExtendedEnchanting.registries;

import com.provismet.CombatPlusCore.enchantments.AdditionalDamageEnchantment;
import com.provismet.CombatPlusCore.enchantments.AspectEnchantment;
import com.provismet.CombatPlusCore.enchantments.WeaponUtilityEnchantment;
import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import com.provismet.ExtendedEnchanting.enchantments.AbstractHeartEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.AbstractProtectionEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.BackFootEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.CombustionProtectionEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.DualStrikeEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.FrostAspectEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.GlassEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.HeartEndEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.HeartMoonEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.HeartNetherEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.HeartSunEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.InitiativeEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.LaunchEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.LeechingEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.LightningAspectEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.RampageEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.SolitudeEnchantment;
import com.provismet.ExtendedEnchanting.enchantments.WeaponProtectionEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EEEnchantments {
    public static final AspectEnchantment LEECHING_ASPECT = new LeechingEnchantment();
    public static final AspectEnchantment FROST_ASPECT = new FrostAspectEnchantment();
    public static final AspectEnchantment LIGHTNING_ASPECT = new LightningAspectEnchantment();

    public static final AdditionalDamageEnchantment INITIATIVE = new InitiativeEnchantment();
    public static final AdditionalDamageEnchantment GLASS = new GlassEnchantment();
    public static final AdditionalDamageEnchantment SOLITUDE = new SolitudeEnchantment();

    public static final WeaponUtilityEnchantment DUAL_STRIKE = new DualStrikeEnchantment();
    public static final WeaponUtilityEnchantment BACK_FOOT = new BackFootEnchantment();
    public static final WeaponUtilityEnchantment RAMPAGE = new RampageEnchantment();

    public static final LaunchEnchantment LAUNCH = new LaunchEnchantment();

    public static final AbstractProtectionEnchantment WEAPON_PROTECTION = new WeaponProtectionEnchantment();
    public static final AbstractProtectionEnchantment COMBUSTION_PROTECTION = new CombustionProtectionEnchantment();

    public static final AbstractHeartEnchantment SUN_HEART = new HeartSunEnchantment();
    public static final AbstractHeartEnchantment MOON_HEART = new HeartMoonEnchantment();
    public static final AbstractHeartEnchantment NETHER_HEART = new HeartNetherEnchantment();
    public static final AbstractHeartEnchantment END_HEART = new HeartEndEnchantment();

    private static void register (Enchantment enchantment, String name) {
        Registry.register(Registries.ENCHANTMENT, ExtendedEnchantingMain.identifier(name), enchantment);
    }

    public static void register () {
        register(LEECHING_ASPECT, "leeching");
        register(FROST_ASPECT, "frost_aspect");
        register(LIGHTNING_ASPECT, "lighting_aspect");

        register(INITIATIVE, "initiative");
        register(GLASS, "glass");
        register(SOLITUDE, "solitude");

        register(DUAL_STRIKE, "dual_strike");
        register(BACK_FOOT, "back_foot");
        register(RAMPAGE, "rampage");

        register(LAUNCH, "launch");

        register(WEAPON_PROTECTION, "weapon_protection");
        register(COMBUSTION_PROTECTION, "combustion_protection");

        register(SUN_HEART, "sun_heart");
        register(MOON_HEART, "moon_heart");
        register(NETHER_HEART, "nether_heart");
        register(END_HEART, "end_heart");
    }
}
