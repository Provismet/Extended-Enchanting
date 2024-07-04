package com.provismet.ExtendedEnchanting.utility.tags;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public abstract class EEEnchantmentTags {
    public static final TagKey<Enchantment> HEART = EEEnchantmentTags.of("heart");

    public static final TagKey<Enchantment> HEART_EXCLUSIVE = EEEnchantmentTags.of("exclusive_set/heart");
    public static final TagKey<Enchantment> LAUNCH_EXCLUSIVE = EEEnchantmentTags.of("exclusive_set/launch");

    private static TagKey<Enchantment> of (String name) {
        return TagKey.of(RegistryKeys.ENCHANTMENT, ExtendedEnchantingMain.identifier(name));
    }
}
