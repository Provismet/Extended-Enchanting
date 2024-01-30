package com.provismet.ExtendedEnchanting.asm;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;

public class HoeEnchantmentTarget extends HoeEnchantmentTargetMixin {
    @Override
    public boolean isAcceptableItem (Item item) {
        return item instanceof HoeItem;
    }
}

@Mixin(EnchantmentTarget.class)
abstract class HoeEnchantmentTargetMixin {
    @Shadow
    abstract boolean isAcceptableItem (Item item);
}
