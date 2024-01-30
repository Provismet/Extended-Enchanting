package com.provismet.ExtendedEnchanting.mixin;

import org.spongepowered.asm.mixin.Mixin;

import com.provismet.ExtendedEnchanting.registries.EEEnchantments;

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
    public HoeItemMixin (float attackDamage, float attackSpeed, ToolMaterial material, TagKey<Block> effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, effectiveBlocks, settings);
    }
    
    @Override
    public boolean postMine (ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        boolean returnVal = super.postMine(stack, world, state, pos, miner);

        if (returnVal && world instanceof ServerWorld serverWorld && EnchantmentHelper.getLevel(EEEnchantments.REPLANT, stack) > 0) {
            if (state.getBlock() instanceof CropBlock crops && crops.getAge(state) == crops.getMaxAge()) serverWorld.setBlockState(pos, crops.withAge(0));
        }
        return returnVal;
    }

    @Override
    public boolean canMine (BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        if (!miner.isCreative() && miner.getMainHandStack().getItem() == (HoeItem)(Object)this && EnchantmentHelper.getEquipmentLevel(EEEnchantments.REPLANT, miner) > 0) {
            if (state.getBlock() instanceof CropBlock crops) return crops.getAge(state) == crops.getMaxAge();
        }
        return super.canMine(state, world, pos, miner);
    }
}
