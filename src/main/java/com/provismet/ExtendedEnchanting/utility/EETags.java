package com.provismet.ExtendedEnchanting.utility;

import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class EETags {
    private static TagKey<DamageType> createDamageTypeTag (String name) {
        return TagKey.of(RegistryKeys.DAMAGE_TYPE, ExtendedEnchantingMain.identifier(name));
    }

    private static TagKey<EntityType<?>> createEntityTypeTag (String name) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, ExtendedEnchantingMain.identifier(name));
    }

    public static class Entity {
        public static final TagKey<EntityType<?>> HAS_WEAPON = EETags.createEntityTypeTag("has_weapon");
        public static final TagKey<EntityType<?>> NO_LAUNCH = EETags.createEntityTypeTag("cannot_launch");
    }

    public static class Damage {
        public static final TagKey<DamageType> MELEE_STRIKE = EETags.createDamageTypeTag("melee");
        public static final TagKey<DamageType> DIRECT_ATTACK = EETags.createDamageTypeTag("direct_attack");
        public static final TagKey<DamageType> COMBUSTION = EETags.createDamageTypeTag("combustion");
    }
}
