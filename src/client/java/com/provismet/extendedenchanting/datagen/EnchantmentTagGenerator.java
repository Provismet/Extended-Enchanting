package com.provismet.extendedenchanting.datagen;

import com.provismet.CombatPlusCore.api.tag.CombatPlusEnchantmentTags;
import com.provismet.extendedenchanting.registries.EEEnchantments;
import com.provismet.extendedenchanting.utility.tags.EEEnchantmentTags;
import com.provismet.lilylib.datagen.tag.LilyTagProviders;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEnchantmentTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.concurrent.CompletableFuture;

public class EnchantmentTagGenerator extends LilyTagProviders.LilyEnchantmentTagProvider {
    public EnchantmentTagGenerator(FabricPackOutput output, CompletableFuture<Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags (Provider arg) {
        this.builder(EEEnchantmentTags.HEART)
            .add(EEEnchantments.SUN_HEART.getKey())
            .add(EEEnchantments.MOON_HEART.getKey())
            .add(EEEnchantments.BRIMSTONE_HEART.getKey())
            .add(EEEnchantments.VOID_HEART.getKey());

        this.builder(EEEnchantmentTags.HEART_EXCLUSIVE)
            .addOptionalTag(EEEnchantmentTags.HEART);

        this.builder(EEEnchantmentTags.LAUNCH_EXCLUSIVE)
            .add(Enchantments.KNOCKBACK);

        this.builder(CombatPlusEnchantmentTags.ADDITIONAL_DAMAGE)
            .add(EEEnchantments.GLASS.getKey())
            .add(EEEnchantments.INITIATIVE.getKey())
            .add(EEEnchantments.SOLITUDE.getKey());

        this.builder(CombatPlusEnchantmentTags.ASPECT)
            .add(EEEnchantments.LEECHING_ASPECT.getKey())
            .add(EEEnchantments.LIGHTNING_ASPECT.getKey())
            .add(EEEnchantments.FROST_ASPECT.getKey());
        
        this.builder(CombatPlusEnchantmentTags.WEAPON_UTILITY)
            .add(EEEnchantments.FEINT.getKey())
            .add(EEEnchantments.DUAL_STRIKE.getKey())
            .add(EEEnchantments.RAMPAGE.getKey());

        this.builder(ConventionalEnchantmentTags.ENTITY_DEFENSE_ENHANCEMENTS)
            .add(EEEnchantments.COMBUSTION_PROTECTION.getKey())
            .add(EEEnchantments.WEAPON_PROTECTION.getKey());

        this.builder(EnchantmentTags.ARMOR_EXCLUSIVE)
            .add(EEEnchantments.COMBUSTION_PROTECTION.getKey())
            .add(EEEnchantments.WEAPON_PROTECTION.getKey());

        this.builder(EnchantmentTags.BOOTS_EXCLUSIVE)
            .add(EEEnchantments.SOIL_WALKER.getKey());

        this.builder(EnchantmentTags.TREASURE)
            .add(EEEnchantments.SOLITUDE.getKey())
            .add(EEEnchantments.CHORUS_CURSE.getKey())
            .addOptionalTag(EEEnchantmentTags.HEART);

        this.builder(EnchantmentTags.NON_TREASURE)
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

        this.builder(EnchantmentTags.IN_ENCHANTING_TABLE)
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

        this.builder(EnchantmentTags.CURSE)
            .add(EEEnchantments.CHORUS_CURSE.getKey());

        this.builder(EnchantmentTags.ON_MOB_SPAWN_EQUIPMENT)
            .add(EEEnchantments.SOLITUDE.getKey())
            .add(EEEnchantments.RAMPAGE.getKey())
            .add(EEEnchantments.LAUNCH.getKey())
            .add(EEEnchantments.WEAPON_PROTECTION.getKey())
            .add(EEEnchantments.FROST_ASPECT.getKey())
            .add(EEEnchantments.LIGHTNING_ASPECT.getKey());

        this.builder(EnchantmentTags.ON_TRADED_EQUIPMENT)
            .add(EEEnchantments.LEECHING_ASPECT.getKey())
            .add(EEEnchantments.FROST_ASPECT.getKey())
            .add(EEEnchantments.LIGHTNING_ASPECT.getKey())
            .add(EEEnchantments.INITIATIVE.getKey())
            .add(EEEnchantments.GLASS.getKey())
            .add(EEEnchantments.DUAL_STRIKE.getKey())
            .add(EEEnchantments.FEINT.getKey())
            .add(EEEnchantments.RAMPAGE.getKey())
            .add(EEEnchantments.LAUNCH.getKey());

        this.builder(EnchantmentTags.ON_RANDOM_LOOT)
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

        this.builder(EnchantmentTags.TRADEABLE)
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
