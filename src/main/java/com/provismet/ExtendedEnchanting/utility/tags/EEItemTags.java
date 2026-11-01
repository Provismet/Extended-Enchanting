package com.provismet.ExtendedEnchanting.utility.tags;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public abstract class EEItemTags {
    public static final TagKey<Item> HOE_ENCHANTABLE = EEItemTags.of("hoe_enchantable");

    private static TagKey<Item> of (String name) {
        return TagKey.create(Registries.ITEM, ExtendedEnchantingMain.identifier(name));
    }
}
