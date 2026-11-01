package com.provismet.ExtendedEnchanting.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

public class DischargeParticle extends SimpleAnimatedParticle {
    protected DischargeParticle (ClientLevel world, double x, double y, double z, SpriteSet spriteProvider) {
        super(world, x, y, z, spriteProvider, 0f);
        this.lifetime = 5;

        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        this.gravity = 0;

        this.setSpriteFromAge(spriteProvider);
        this.quadSize = 1.5f;
    }

    @Environment(value= EnvType.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteProvider;

        public Factory (SpriteSet spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle (SimpleParticleType defaultParticleType, ClientLevel clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ, RandomSource random) {
            return new DischargeParticle(clientWorld, x, y, z, this.spriteProvider);
        }
    }
}
