package com.provismet.ExtendedEnchanting.registries;

import com.provismet.ExtendedEnchanting.particles.StaticChargeParticle;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry.PendingParticleFactory;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;

public class EEParticleFactories {
    private static <T extends ParticleEffect> void register (ParticleType<T> particle, PendingParticleFactory<T> constructor) {
        ParticleFactoryRegistry.getInstance().register(particle, constructor);
    }

    public static void register () {
        register(EEParticleTypes.STATIC_CHARGE, StaticChargeParticle.Factory::new);
    }
}
