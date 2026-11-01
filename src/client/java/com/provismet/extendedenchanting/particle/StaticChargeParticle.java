package com.provismet.extendedenchanting.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class StaticChargeParticle extends SimpleAnimatedParticle {
    protected StaticChargeParticle (ClientLevel world, double x, double y, double z, SpriteSet spriteProvider) {
        super(world, x, y, z, spriteProvider, 0f);
        this.lifetime += 5 + (int)(20.0 * this.random.nextDouble());

        this.xd = this.random.nextDouble() * 0.2- 0.1;
        this.yd = this.random.nextDouble() * 0.04 - 0.02;
        this.zd = this.random.nextDouble() * 0.2 - 0.1;
        this.gravity = 0;

        this.setSpriteFromAge(spriteProvider);
    }

    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteProvider;

        public Factory (SpriteSet spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle (SimpleParticleType defaultParticleType, ClientLevel clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ, RandomSource random) {
            return new StaticChargeParticle(clientWorld, x, y, z, this.spriteProvider);
        }
    }
}
