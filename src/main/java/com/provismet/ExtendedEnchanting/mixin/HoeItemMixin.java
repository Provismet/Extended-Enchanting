package com.provismet.ExtendedEnchanting.mixin;

import com.provismet.ExtendedEnchanting.registries.EEEnchantmentComponentTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(HoeItem.class)
public abstract class HoeItemMixin extends Item {
    public HoeItemMixin (Settings settings) {
        super(settings);
    }

    @Override
    public boolean postMine (ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        boolean returnVal = super.postMine(stack, world, state, pos, miner);

        if (returnVal && world instanceof ServerWorld serverWorld && EnchantmentHelper.hasAnyEnchantmentsWith(stack, EEEnchantmentComponentTypes.REPLANT)) {
            if (state.getBlock() instanceof CropBlock crops && crops.getAge(state) == crops.getMaxAge()) serverWorld.setBlockState(pos, crops.withAge(0));
            else if (state.getBlock() instanceof NetherWartBlock netherWart) serverWorld.setBlockState(pos, netherWart.getDefaultState());
        }
        return returnVal;
    }

    @Override
    public boolean canMine (ItemStack stack, BlockState state, World world, BlockPos pos, LivingEntity user) {
        if (!user.isInCreativeMode() && EnchantmentHelper.hasAnyEnchantmentsWith(user.getMainHandStack(), EEEnchantmentComponentTypes.REPLANT)) {
            if (state.getBlock() instanceof CropBlock crops) return crops.getAge(state) == crops.getMaxAge();
            else if (state.getBlock() instanceof NetherWartBlock) return state.get(Properties.AGE_3) == 3;
        }
        return super.canMine(stack, state, world, pos, user);
    }
}
