package com.provismet.ExtendedEnchanting.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.provismet.ExtendedEnchanting.enchantments.AbstractHeartEnchantment;
import com.provismet.ExtendedEnchanting.interfaces.IMixinLivingEntity;
import com.provismet.ExtendedEnchanting.registries.EEParticleTypes;
import com.provismet.ExtendedEnchanting.utility.EEDamageTypes;
import com.provismet.ExtendedEnchanting.utility.ExtendedEnchantmentHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements IMixinLivingEntity {
    public LivingEntityMixin (EntityType<?> type, World world) {
        super(type, world);
    }
    
    @Unique
    private int staticCharge = 0;

    @Inject(method="tick", at=@At("HEAD"))
    private void applyEffectsOverTime (CallbackInfo info) {
        LivingEntity thisLiving = (LivingEntity)(Object)this;
        AbstractHeartEnchantment heartEnchantment = ExtendedEnchantmentHelper.getHeartEnchantment(thisLiving.getEquippedStack(EquipmentSlot.CHEST));
        if (heartEnchantment != null) heartEnchantment.tick(thisLiving);

        if (this.age % 25 == 0 && this.staticCharge > 0) {
            --this.staticCharge;
            if (this.getWorld().isClient()) {
                for (int i = 0; i < this.staticCharge * 2; ++i) {
                    this.getWorld().addParticle(EEParticleTypes.STATIC_CHARGE, this.getX(), (this.getY() + this.getEyeY()) / 2.0, this.getZ(), 0.0, 0.0, 0.0);
                }
            }
        }
    }

    @Override
    public void applyStatic (int amount) {
        this.staticCharge += amount;
        if (this.staticCharge >= 5) {
            this.staticCharge = 0;
            this.damage(EEDamageTypes.staticShock(this.getDamageSources()), 6f);
        }
    }
}
