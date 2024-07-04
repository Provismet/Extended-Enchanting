package com.provismet.ExtendedEnchanting.utility.tags;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class EEDamageTypeTags {
    public static final TagKey<DamageType> MELEE_STRIKE = EEDamageTypeTags.of("melee");
    public static final TagKey<DamageType> COMBUSTION = EEDamageTypeTags.of("combustion");

    private static TagKey<DamageType> of (String name) {
        return TagKey.of(RegistryKeys.DAMAGE_TYPE, ExtendedEnchantingMain.identifier(name));
    }
}
