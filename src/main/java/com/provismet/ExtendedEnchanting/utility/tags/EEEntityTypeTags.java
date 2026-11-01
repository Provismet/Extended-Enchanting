package com.provismet.ExtendedEnchanting.utility.tags;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class EEEntityTypeTags {
    public static final TagKey<EntityType<?>> HAS_WEAPON = EEEntityTypeTags.of("has_weapon");
    public static final TagKey<EntityType<?>> NO_LAUNCH = EEEntityTypeTags.of("cannot_launch");

    private static TagKey<EntityType<?>> of (String name) {
        return TagKey.create(Registries.ENTITY_TYPE, ExtendedEnchantingMain.identifier(name));
    }
}
