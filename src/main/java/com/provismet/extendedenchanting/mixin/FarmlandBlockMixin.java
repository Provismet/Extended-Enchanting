package com.provismet.extendedenchanting.mixin;

import com.provismet.extendedenchanting.registries.EEEnchantmentComponentTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FarmlandBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FarmlandBlock.class)
public abstract class FarmlandBlockMixin extends Block {
    public FarmlandBlockMixin (Properties settings) {
        super(settings);
    }
    
    @Inject(method="fallOn", at=@At("HEAD"), cancellable=true)
    private static void preventDirt (Level level, BlockState state, BlockPos pos, Entity entity, double fallDistance, CallbackInfo info) {
        if (entity instanceof LivingEntity living && EnchantmentHelper.has(living.getItemBySlot(EquipmentSlot.FEET), EEEnchantmentComponentTypes.SOIL_STEP)) info.cancel();
    }
}
