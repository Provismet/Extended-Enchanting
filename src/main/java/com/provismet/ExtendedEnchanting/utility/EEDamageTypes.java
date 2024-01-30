package com.provismet.ExtendedEnchanting.utility;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class EEDamageTypes {
    private static final RegistryKey<DamageType> STATIC = createDamageType("static_shock");

    public static final DamageSource staticShock (DamageSources sources) {
        return sources.create(STATIC);
    }

    private static final RegistryKey<DamageType> createDamageType (String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, ExtendedEnchantingMain.identifier(name));
    }
}
