package com.provismet.ExtendedEnchanting.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.provismet.ExtendedEnchanting.interfaces.IMixinLivingEntity;
import com.provismet.ExtendedEnchanting.registries.EEParticleTypes;
import com.provismet.ExtendedEnchanting.utility.EEDamageTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements IMixinLivingEntity {
    public LivingEntityMixin (EntityType<?> type, Level world) {
        super(type, world);
    }
    
    @Unique
    private int staticTicks = 0;

    @Unique
    private Vec3 previousGroundPos = null;

    @Inject(method="tick", at=@At("HEAD"))
    private void applyEffectsOverTime (CallbackInfo info) {
        if (this.staticTicks > 0) {
            --this.staticTicks;
            if (this.tickCount % 15 == 0 && this.level() instanceof ServerLevel serverWorld) {
                serverWorld.sendParticles(EEParticleTypes.STATIC_CHARGE, this.getX(), (this.getY() + this.getEyeY()) / 2.0, this.getZ(), Math.max(1, Math.ceilDiv(this.staticTicks, 15)), 0, 0, 0, 0);
            }
        }
    }

    @Override
    public void extended_Enchanting$applyStatic (int amount) {
        this.staticTicks += amount;
        while (this.staticTicks >= 100) { // TODO: Compare this with an attribute maybe?
            this.staticTicks = Math.max(0, this.staticTicks - 100);
            if (this.level() instanceof ServerLevel serverWorld) {
                this.hurtServer(serverWorld, EEDamageTypes.STATIC.createDamageSource(this.damageSources()), 6f);
                serverWorld.sendParticles(EEParticleTypes.DISCHARGE, this.getX(), (this.getY() + this.getEyeY()) / 2.0, this.getZ(), 1, 0, 0, 0, 0);
            }
        }
    }

    @Override
    public void extended_Enchanting$setPreviousGroundPos (Vec3 position) {
        this.previousGroundPos = position;
    }

    @Override
    public Vec3 extended_Enchanting$getPreviousGroundPos () {
        return this.previousGroundPos;
    }
}
