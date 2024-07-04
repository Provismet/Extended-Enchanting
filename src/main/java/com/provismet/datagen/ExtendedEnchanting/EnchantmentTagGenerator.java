package com.provismet.datagen.ExtendedEnchanting;

import java.util.concurrent.CompletableFuture;

import com.provismet.CombatPlusCore.utility.tag.CPCEnchantmentTags;
import com.provismet.ExtendedEnchanting.registries.EEEnchantments;

import com.provismet.ExtendedEnchanting.utility.tags.EEEnchantmentTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.EnchantmentTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEnchantmentTags;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.EnchantmentTags;

public class EnchantmentTagGenerator extends EnchantmentTagProvider {
    public EnchantmentTagGenerator(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure (WrapperLookup arg) {
        getOrCreateTagBuilder(EEEnchantmentTags.HEART)
            .add(EEEnchantments.SUN_HEART.getKey())
            .add(EEEnchantments.MOON_HEART.getKey())
            .add(EEEnchantments.BRIMSTONE_HEART.getKey())
            .add(EEEnchantments.VOID_HEART.getKey());

        getOrCreateTagBuilder(EEEnchantmentTags.HEART_EXCLUSIVE)
            .addOptionalTag(EEEnchantmentTags.HEART);

        getOrCreateTagBuilder(EEEnchantmentTags.LAUNCH_EXCLUSIVE)
            .add(Enchantments.KNOCKBACK);

        getOrCreateTagBuilder(CPCEnchantmentTags.ADDITIONAL_DAMAGE)
            .add(EEEnchantments.GLASS.getKey())
            .add(EEEnchantments.INITIATIVE.getKey())
            .add(EEEnchantments.SOLITUDE.getKey());

        getOrCreateTagBuilder(CPCEnchantmentTags.ASPECT)
            .add(EEEnchantments.LEECHING_ASPECT.getKey())
            .add(EEEnchantments.LIGHTNING_ASPECT.getKey())
            .add(EEEnchantments.FROST_ASPECT.getKey());
        
        getOrCreateTagBuilder(CPCEnchantmentTags.WEAPON_UTILITY)
            .add(EEEnchantments.FEINT.getKey())
            .add(EEEnchantments.DUAL_STRIKE.getKey())
            .add(EEEnchantments.RAMPAGE.getKey());

        getOrCreateTagBuilder(ConventionalEnchantmentTags.ENTITY_DEFENSE_ENHANCEMENTS)
            .add(EEEnchantments.COMBUSTION_PROTECTION.getKey())
            .add(EEEnchantments.WEAPON_PROTECTION.getKey());

        getOrCreateTagBuilder(EnchantmentTags.ARMOR_EXCLUSIVE_SET)
            .add(EEEnchantments.COMBUSTION_PROTECTION.getKey())
            .add(EEEnchantments.WEAPON_PROTECTION.getKey());

        getOrCreateTagBuilder(EnchantmentTags.BOOTS_EXCLUSIVE_SET)
            .add(EEEnchantments.SOIL_WALKER.getKey());

        getOrCreateTagBuilder(EnchantmentTags.TREASURE)
            .add(EEEnchantments.SOLITUDE.getKey())
            .add(EEEnchantments.CHORUS_CURSE.getKey())
            .addOptionalTag(EEEnchantmentTags.HEART);

        getOrCreateTagBuilder(EnchantmentTags.NON_TREASURE)
            .add(EEEnchantments.LEECHING_ASPECT.getKey())
            .add(EEEnchantments.FROST_ASPECT.getKey())
            .add(EEEnchantments.LIGHTNING_ASPECT.getKey())
            .add(EEEnchantments.INITIATIVE.getKey())
            .add(EEEnchantments.GLASS.getKey())
            .add(EEEnchantments.DUAL_STRIKE.getKey())
            .add(EEEnchantments.FEINT.getKey())
            .add(EEEnchantments.RAMPAGE.getKey())
            .add(EEEnchantments.LAUNCH.getKey())
            .add(EEEnchantments.WEAPON_PROTECTION.getKey())
            .add(EEEnchantments.COMBUSTION_PROTECTION.getKey())
            .add(EEEnchantments.REPLANT.getKey())
            .add(EEEnchantments.SOIL_WALKER.getKey());

        getOrCreateTagBuilder(EnchantmentTags.IN_ENCHANTING_TABLE)
            .add(EEEnchantments.LEECHING_ASPECT.getKey())
            .add(EEEnchantments.FROST_ASPECT.getKey())
            .add(EEEnchantments.LIGHTNING_ASPECT.getKey())
            .add(EEEnchantments.INITIATIVE.getKey())
            .add(EEEnchantments.GLASS.getKey())
            .add(EEEnchantments.DUAL_STRIKE.getKey())
            .add(EEEnchantments.FEINT.getKey())
            .add(EEEnchantments.RAMPAGE.getKey())
            .add(EEEnchantments.LAUNCH.getKey())
            .add(EEEnchantments.WEAPON_PROTECTION.getKey())
            .add(EEEnchantments.COMBUSTION_PROTECTION.getKey())
            .add(EEEnchantments.REPLANT.getKey())
            .add(EEEnchantments.SOIL_WALKER.getKey());

        getOrCreateTagBuilder(EnchantmentTags.CURSE)
            .add(EEEnchantments.CHORUS_CURSE.getKey());

        getOrCreateTagBuilder(EnchantmentTags.ON_MOB_SPAWN_EQUIPMENT)
            .add(EEEnchantments.SOLITUDE.getKey())
            .add(EEEnchantments.RAMPAGE.getKey())
            .add(EEEnchantments.LAUNCH.getKey())
            .add(EEEnchantments.WEAPON_PROTECTION.getKey())
            .add(EEEnchantments.FROST_ASPECT.getKey())
            .add(EEEnchantments.LIGHTNING_ASPECT.getKey());

        getOrCreateTagBuilder(EnchantmentTags.ON_TRADED_EQUIPMENT)
            .add(EEEnchantments.LEECHING_ASPECT.getKey())
            .add(EEEnchantments.FROST_ASPECT.getKey())
            .add(EEEnchantments.LIGHTNING_ASPECT.getKey())
            .add(EEEnchantments.INITIATIVE.getKey())
            .add(EEEnchantments.GLASS.getKey())
            .add(EEEnchantments.DUAL_STRIKE.getKey())
            .add(EEEnchantments.FEINT.getKey())
            .add(EEEnchantments.RAMPAGE.getKey())
            .add(EEEnchantments.LAUNCH.getKey());

        getOrCreateTagBuilder(EnchantmentTags.ON_RANDOM_LOOT)
            .add(EEEnchantments.LEECHING_ASPECT.getKey())
            .add(EEEnchantments.FROST_ASPECT.getKey())
            .add(EEEnchantments.LIGHTNING_ASPECT.getKey())
            .add(EEEnchantments.INITIATIVE.getKey())
            .add(EEEnchantments.GLASS.getKey())
            .add(EEEnchantments.DUAL_STRIKE.getKey())
            .add(EEEnchantments.FEINT.getKey())
            .add(EEEnchantments.RAMPAGE.getKey())
            .add(EEEnchantments.LAUNCH.getKey())
            .add(EEEnchantments.WEAPON_PROTECTION.getKey())
            .add(EEEnchantments.COMBUSTION_PROTECTION.getKey())
            .add(EEEnchantments.REPLANT.getKey())
            .add(EEEnchantments.SOIL_WALKER.getKey())
            .add(EEEnchantments.CHORUS_CURSE.getKey());

        getOrCreateTagBuilder(EnchantmentTags.TRADEABLE)
            .add(EEEnchantments.LEECHING_ASPECT.getKey())
            .add(EEEnchantments.FROST_ASPECT.getKey())
            .add(EEEnchantments.LIGHTNING_ASPECT.getKey())
            .add(EEEnchantments.INITIATIVE.getKey())
            .add(EEEnchantments.GLASS.getKey())
            .add(EEEnchantments.DUAL_STRIKE.getKey())
            .add(EEEnchantments.FEINT.getKey())
            .add(EEEnchantments.RAMPAGE.getKey())
            .add(EEEnchantments.LAUNCH.getKey())
            .add(EEEnchantments.WEAPON_PROTECTION.getKey())
            .add(EEEnchantments.COMBUSTION_PROTECTION.getKey())
            .add(EEEnchantments.REPLANT.getKey())
            .add(EEEnchantments.SOIL_WALKER.getKey())
            .add(EEEnchantments.CHORUS_CURSE.getKey());
    }
}
