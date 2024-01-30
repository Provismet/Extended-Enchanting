package com.provismet.ExtendedEnchanting.registries;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EEParticleTypes {
    public static final DefaultParticleType STATIC_CHARGE = FabricParticleTypes.simple();

    private static <T extends ParticleEffect> void register (ParticleType<T> particle, String name) {
        Registry.register(Registries.PARTICLE_TYPE, ExtendedEnchantingMain.identifier(name), particle);
    }

    public static void register () {
        register(STATIC_CHARGE, "static_spark");
    }
}
