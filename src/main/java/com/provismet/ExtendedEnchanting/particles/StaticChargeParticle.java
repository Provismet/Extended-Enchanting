package com.provismet.ExtendedEnchanting.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.AnimatedParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class StaticChargeParticle extends AnimatedParticle {
    protected StaticChargeParticle (ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider) {
        super(world, x, y, z, spriteProvider, 0f);
        this.maxAge += 5 + (int)(20.0 * this.random.nextDouble());

        this.velocityX = this.random.nextDouble() * 0.2- 0.1;
        this.velocityY = this.random.nextDouble() * 0.02 - 0.01;
        this.velocityZ = this.random.nextDouble() * 0.2 - 0.1;
        this.gravityStrength = 0;

        this.setSpriteForAge(spriteProvider);
    }
    
    @Environment(value=EnvType.CLIENT)
    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory (SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle (DefaultParticleType defaultParticleType, ClientWorld clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new StaticChargeParticle(clientWorld, x, y, z, this.spriteProvider);
        }
    }
}
