package com.provismet.ExtendedEnchanting.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Slice;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin (EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }
    
    @ModifyVariable(method="attack", at=@At("STORE"), ordinal=3,
        slice=@Slice(from=@At(value="INVOKE", target="Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"))
    )
    private boolean stopSweeping (boolean original) {
        if (EnchantmentHelper.getLevel(Enchantments.SWEEPING, this.getMainHandStack()) == 0) return false;
        return original;
    }
}
