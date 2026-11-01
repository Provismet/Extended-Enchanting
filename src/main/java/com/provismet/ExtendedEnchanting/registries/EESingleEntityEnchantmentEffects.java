package com.provismet.ExtendedEnchanting.registries;

import com.mojang.serialization.MapCodec;
import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import com.provismet.ExtendedEnchanting.enchantment.effect.singleEntity.ShockEnchantmentEffect;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;

public abstract class EESingleEntityEnchantmentEffects {
    public static void register () {
        register("shock_entity", ShockEnchantmentEffect.CODEC);
    }

    private static void register (String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE, ExtendedEnchantingMain.identifier(name), codec);
    }
}
