package com.provismet.ExtendedEnchanting.mixin;

import com.provismet.ExtendedEnchanting.registries.EEEnchantmentComponentTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FarmlandBlock.class)
public abstract class FarmlandBlockMixin extends Block {
    public FarmlandBlockMixin (Settings settings) {
        super(settings);
    }
    
    @Inject(method="setToDirt", at=@At("HEAD"), cancellable=true)
    private static void preventDirt (@Nullable Entity entity, BlockState state, World world, BlockPos pos, CallbackInfo info) {
        if (entity instanceof LivingEntity living && EnchantmentHelper.hasAnyEnchantmentsWith(living.getEquippedStack(EquipmentSlot.FEET), EEEnchantmentComponentTypes.SOIL_STEP)) info.cancel();
    }
}
