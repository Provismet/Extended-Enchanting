package com.provismet.ExtendedEnchanting.enchantment.effect.singleEntity;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.provismet.ExtendedEnchanting.interfaces.IMixinLivingEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record ShockEnchantmentEffect (LevelBasedValue ticks) implements EnchantmentEntityEffect {
    public static final MapCodec<ShockEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(LevelBasedValue.CODEC.fieldOf("ticks").forGetter(ShockEnchantmentEffect::ticks)).apply(instance, ShockEnchantmentEffect::new));

    @Override
    public void apply (ServerLevel world, int level, EnchantedItemInUse context, Entity target, Vec3 pos) {
        int ticks = (int)this.ticks.calculate(level);
        ((IMixinLivingEntity)target).extended_Enchanting$applyStatic(ticks);
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec () {
        return CODEC;
    }
}
