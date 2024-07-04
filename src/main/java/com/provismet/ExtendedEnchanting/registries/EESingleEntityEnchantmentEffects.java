package com.provismet.ExtendedEnchanting.registries;

import com.mojang.serialization.MapCodec;
import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import com.provismet.ExtendedEnchanting.enchantment.effect.singleEntity.ShockEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public abstract class EESingleEntityEnchantmentEffects {
    public static void register () {
        register("shock_entity", ShockEnchantmentEffect.CODEC);
    }

    private static void register (String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
        Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, ExtendedEnchantingMain.identifier(name), codec);
    }
}
