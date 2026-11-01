package com.provismet.ExtendedEnchanting.utility;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;

import com.provismet.lilylib.container.DamageTypeContainer;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.damagesource.DamageType;

public class EEDamageTypes {
    public static final DamageTypeContainer STATIC = new DamageTypeContainer(
        ExtendedEnchantingMain.identifier("static_shock"),
        new DamageType("static_shock", 0.1f)
    );

    public static void bootstrap (BootstrapContext<DamageType> registerable) {
        registerable.register(STATIC.getKey(), STATIC.getDamageType());
    }
}
