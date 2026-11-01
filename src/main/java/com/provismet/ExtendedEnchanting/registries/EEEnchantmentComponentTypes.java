package com.provismet.ExtendedEnchanting.registries;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.Unit;
import net.minecraft.world.item.enchantment.ConditionalEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.minecraft.world.level.storage.loot.Validatable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import java.util.List;
import java.util.function.UnaryOperator;

public abstract class EEEnchantmentComponentTypes {
    public static final DataComponentType<Unit> REPLANT = register("replant", builder -> builder.persistent(Unit.CODEC));
    public static final DataComponentType<Unit> SOIL_STEP = register("soil_step", builder -> builder.persistent(Unit.CODEC));

    private static <T> DataComponentType<T> register (String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return Registry.register(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, ExtendedEnchantingMain.identifier(name), (builderOperator.apply(DataComponentType.builder())).build());
    }

    private static UnaryOperator<DataComponentType.Builder<List<ConditionalEffect<EnchantmentValueEffect>>>> createValueCodec () {
        return builder -> builder.persistent(ConditionalEffect.codec(EnchantmentValueEffect.CODEC).listOf().validate(Validatable.listValidatorForContext(LootContextParamSets.ENCHANTED_ENTITY)));
    }

    public static void init () {}
}
