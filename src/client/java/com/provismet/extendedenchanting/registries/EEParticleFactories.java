package com.provismet.extendedenchanting.registries;

import com.provismet.extendedenchanting.particle.DischargeParticle;
import com.provismet.extendedenchanting.particle.StaticChargeParticle;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;

public abstract class EEParticleFactories {
    private static <T extends ParticleOptions> void register (ParticleType<T> particle, ParticleProviderRegistry.PendingParticleProvider<T> constructor) {
        ParticleProviderRegistry.getInstance().register(particle, constructor);
    }

    public static void register () {
        register(EEParticleTypes.STATIC_CHARGE, StaticChargeParticle.Factory::new);
        register(EEParticleTypes.DISCHARGE, DischargeParticle.Factory::new);
    }
}
