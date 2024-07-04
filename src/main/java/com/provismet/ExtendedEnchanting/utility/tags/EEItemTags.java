package com.provismet.ExtendedEnchanting.utility.tags;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public abstract class EEItemTags {
    public static final TagKey<Item> HOE_ENCHANTABLE = EEItemTags.of("hoe_enchantable");

    private static TagKey<Item> of (String name) {
        return TagKey.of(RegistryKeys.ITEM, ExtendedEnchantingMain.identifier(name));
    }
}
