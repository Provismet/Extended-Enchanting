package com.provismet.extendedenchanting.registries;

import com.provismet.extendedenchanting.ExtendedEnchantingMain;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

public abstract class EEParticleTypes {
    public static final SimpleParticleType STATIC_CHARGE = FabricParticleTypes.simple();
    public static final SimpleParticleType DISCHARGE = FabricParticleTypes.simple();

    private static <T extends ParticleOptions> void register (ParticleType<T> particle, String name) {
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, ExtendedEnchantingMain.identifier(name), particle);
    }

    public static void register () {
        register(STATIC_CHARGE, "static_spark");
        register(DISCHARGE, "discharge");
    }
}
