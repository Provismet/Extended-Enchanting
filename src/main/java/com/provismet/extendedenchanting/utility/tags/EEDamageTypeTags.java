package com.provismet.extendedenchanting.utility.tags;

import com.provismet.extendedenchanting.ExtendedEnchantingMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;

public class EEDamageTypeTags {
    public static final TagKey<DamageType> MELEE_STRIKE = EEDamageTypeTags.of("melee");
    public static final TagKey<DamageType> COMBUSTION = EEDamageTypeTags.of("combustion");

    private static TagKey<DamageType> of (String name) {
        return TagKey.create(Registries.DAMAGE_TYPE, ExtendedEnchantingMain.identifier(name));
    }
}
