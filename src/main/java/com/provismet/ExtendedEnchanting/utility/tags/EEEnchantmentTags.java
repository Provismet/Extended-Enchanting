package com.provismet.ExtendedEnchanting.utility.tags;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;

public abstract class EEEnchantmentTags {
    public static final TagKey<Enchantment> HEART = EEEnchantmentTags.of("heart");

    public static final TagKey<Enchantment> HEART_EXCLUSIVE = EEEnchantmentTags.of("exclusive_set/heart");
    public static final TagKey<Enchantment> LAUNCH_EXCLUSIVE = EEEnchantmentTags.of("exclusive_set/launch");

    private static TagKey<Enchantment> of (String name) {
        return TagKey.create(Registries.ENCHANTMENT, ExtendedEnchantingMain.identifier(name));
    }
}
