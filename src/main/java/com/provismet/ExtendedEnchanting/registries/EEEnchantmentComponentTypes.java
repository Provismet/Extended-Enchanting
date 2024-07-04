package com.provismet.ExtendedEnchanting.registries;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import net.minecraft.component.ComponentType;
import net.minecraft.enchantment.effect.EnchantmentEffectEntry;
import net.minecraft.enchantment.effect.EnchantmentValueEffect;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Unit;

import java.util.List;
import java.util.function.UnaryOperator;

public abstract class EEEnchantmentComponentTypes {
    public static final ComponentType<Unit> REPLANT = register("replant", builder -> builder.codec(Unit.CODEC));
    public static final ComponentType<Unit> SOIL_STEP = register("soil_step", builder -> builder.codec(Unit.CODEC));

    private static <T> ComponentType<T> register (String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, ExtendedEnchantingMain.identifier(name), (builderOperator.apply(ComponentType.builder())).build());
    }

    private static UnaryOperator<ComponentType.Builder<List<EnchantmentEffectEntry<EnchantmentValueEffect>>>> createValueCodec () {
        return builder -> builder.codec(EnchantmentEffectEntry.createCodec(EnchantmentValueEffect.CODEC, LootContextTypes.ENCHANTED_ENTITY).listOf());
    }

    public static void init () {}
}
