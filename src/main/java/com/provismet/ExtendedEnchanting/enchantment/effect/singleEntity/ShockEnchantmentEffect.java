package com.provismet.ExtendedEnchanting.enchantment.effect.singleEntity;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.provismet.ExtendedEnchanting.interfaces.IMixinLivingEntity;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record ShockEnchantmentEffect (EnchantmentLevelBasedValue ticks) implements EnchantmentEntityEffect {
    public static final MapCodec<ShockEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(EnchantmentLevelBasedValue.CODEC.fieldOf("ticks").forGetter(ShockEnchantmentEffect::ticks)).apply(instance, ShockEnchantmentEffect::new));

    @Override
    public void apply (ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        int ticks = (int)this.ticks.getValue(level);
        ((IMixinLivingEntity)target).extended_Enchanting$applyStatic(ticks);
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec () {
        return CODEC;
    }
}
