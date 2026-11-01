package com.provismet.ExtendedEnchanting.mixin;

import com.provismet.ExtendedEnchanting.registries.EEEnchantmentComponentTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FarmBlock.class)
public abstract class FarmlandBlockMixin extends Block {
    public FarmlandBlockMixin (Properties settings) {
        super(settings);
    }
    
    @Inject(method="turnToDirt", at=@At("HEAD"), cancellable=true)
    private static void preventDirt (@Nullable Entity entity, BlockState state, Level world, BlockPos pos, CallbackInfo info) {
        if (entity instanceof LivingEntity living && EnchantmentHelper.has(living.getItemBySlot(EquipmentSlot.FEET), EEEnchantmentComponentTypes.SOIL_STEP)) info.cancel();
    }
}
