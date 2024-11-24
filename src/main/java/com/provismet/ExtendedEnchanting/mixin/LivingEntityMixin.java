package com.provismet.ExtendedEnchanting.mixin;

import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.provismet.ExtendedEnchanting.interfaces.IMixinLivingEntity;
import com.provismet.ExtendedEnchanting.registries.EEParticleTypes;
import com.provismet.ExtendedEnchanting.utility.EEDamageTypes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements IMixinLivingEntity {
    public LivingEntityMixin (EntityType<?> type, World world) {
        super(type, world);
    }
    
    @Unique
    private int staticTicks = 0;

    @Unique
    private Vec3d previousGroundPos = null;

    @Inject(method="tick", at=@At("HEAD"))
    private void applyEffectsOverTime (CallbackInfo info) {
        if (this.staticTicks > 0) {
            --this.staticTicks;
            if (this.age % 15 == 0 && this.getWorld() instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(EEParticleTypes.STATIC_CHARGE, this.getX(), (this.getY() + this.getEyeY()) / 2.0, this.getZ(), Math.max(1, Math.ceilDiv(this.staticTicks, 15)), 0, 0, 0, 0);
            }
        }
    }

    @Override
    public void extended_Enchanting$applyStatic (int amount) {
        this.staticTicks += amount;
        while (this.staticTicks >= 100) { // TODO: Compare this with an attribute maybe?
            this.staticTicks = Math.max(0, this.staticTicks - 100);
            if (this.getWorld() instanceof ServerWorld serverWorld) {
                this.damage(serverWorld, EEDamageTypes.STATIC.createDamageSource(this.getDamageSources()), 6f);
                serverWorld.spawnParticles(EEParticleTypes.DISCHARGE, this.getX(), (this.getY() + this.getEyeY()) / 2.0, this.getZ(), 1, 0, 0, 0, 0);
            }
        }
    }

    @Override
    public void extended_Enchanting$setPreviousGroundPos (Vec3d position) {
        this.previousGroundPos = position;
    }

    @Override
    public Vec3d extended_Enchanting$getPreviousGroundPos () {
        return this.previousGroundPos;
    }
}
