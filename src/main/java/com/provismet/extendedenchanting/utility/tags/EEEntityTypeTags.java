package com.provismet.extendedenchanting.utility.tags;

import com.provismet.extendedenchanting.ExtendedEnchantingMain;
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
