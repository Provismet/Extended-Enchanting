package com.provismet.ExtendedEnchanting.mixin;

import com.provismet.ExtendedEnchanting.registries.EEEnchantmentComponentTypes;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.state.property.Properties;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(HoeItem.class)
public abstract class HoeItemMixin extends MiningToolItem {
    protected HoeItemMixin (ToolMaterial material, TagKey<Block> effectiveBlocks, Settings settings) {
        super(material, effectiveBlocks, settings);
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
    public boolean canMine (BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        if (!miner.isCreative() && EnchantmentHelper.hasAnyEnchantmentsWith(miner.getMainHandStack(), EEEnchantmentComponentTypes.REPLANT)) {
            if (state.getBlock() instanceof CropBlock crops) return crops.getAge(state) == crops.getMaxAge();
            else if (state.getBlock() instanceof NetherWartBlock) return state.get(Properties.AGE_3) == 3;
        }
        return super.canMine(state, world, pos, miner);
    }
}
