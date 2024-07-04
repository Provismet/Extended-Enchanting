package com.provismet.ExtendedEnchanting.utility.tags;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class EEEntityTypeTags {
    public static final TagKey<EntityType<?>> HAS_WEAPON = EEEntityTypeTags.of("has_weapon");
    public static final TagKey<EntityType<?>> NO_LAUNCH = EEEntityTypeTags.of("cannot_launch");

    private static TagKey<EntityType<?>> of (String name) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, ExtendedEnchantingMain.identifier(name));
    }
}
