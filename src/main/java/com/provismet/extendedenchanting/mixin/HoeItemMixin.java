package com.provismet.extendedenchanting.mixin;

import com.provismet.extendedenchanting.registries.EEEnchantmentComponentTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(HoeItem.class)
public abstract class HoeItemMixin extends Item {
    public HoeItemMixin (Properties settings) {
        super(settings);
    }

    @Override
    public boolean mineBlock (ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity miner) {
        boolean returnVal = super.mineBlock(stack, world, state, pos, miner);

        if (returnVal && world instanceof ServerLevel serverWorld && EnchantmentHelper.has(stack, EEEnchantmentComponentTypes.REPLANT)) {
            if (state.getBlock() instanceof CropBlock crops && crops.getAge(state) == crops.getMaxAge()) serverWorld.setBlockAndUpdate(pos, crops.getStateForAge(0));
            else if (state.getBlock() instanceof NetherWartBlock netherWart) serverWorld.setBlockAndUpdate(pos, netherWart.defaultBlockState());
        }
        return returnVal;
    }

    @Override
    public boolean canDestroyBlock (ItemStack stack, BlockState state, Level world, BlockPos pos, LivingEntity user) {
        if (!user.hasInfiniteMaterials() && EnchantmentHelper.has(user.getMainHandItem(), EEEnchantmentComponentTypes.REPLANT)) {
            if (state.getBlock() instanceof CropBlock crops) return crops.getAge(state) == crops.getMaxAge();
            else if (state.getBlock() instanceof NetherWartBlock) return state.getValue(BlockStateProperties.AGE_3) == 3;
        }
        return super.canDestroyBlock(stack, state, world, pos, user);
    }
}
