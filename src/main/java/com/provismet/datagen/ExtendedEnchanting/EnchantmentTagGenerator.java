package com.provismet.datagen.ExtendedEnchanting;

import java.util.concurrent.CompletableFuture;

import com.provismet.CombatPlusCore.utility.CPCEnchantmentTags;
import com.provismet.ExtendedEnchanting.registries.EEEnchantments;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.EnchantmentTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalEnchantmentTags;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class EnchantmentTagGenerator extends EnchantmentTagProvider {
    public EnchantmentTagGenerator(FabricDataOutput output, CompletableFuture<WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure (WrapperLookup arg) {
        getOrCreateTagBuilder(CPCEnchantmentTags.ADDITIONAL_DAMAGE)
            .add(EEEnchantments.GLASS)
            .add(EEEnchantments.INITIATIVE)
            .add(EEEnchantments.SOLITUDE);

        getOrCreateTagBuilder(CPCEnchantmentTags.ASPECT)
            .add(EEEnchantments.LEECHING_ASPECT)
            .add(EEEnchantments.LIGHTNING_ASPECT)
            .add(EEEnchantments.FROST_ASPECT);
        
        getOrCreateTagBuilder(CPCEnchantmentTags.WEAPON_UTILITY)
            .add(EEEnchantments.BACK_FOOT)
            .add(EEEnchantments.DUAL_STRIKE)
            .add(EEEnchantments.RAMPAGE);

        getOrCreateTagBuilder(ConventionalEnchantmentTags.ENTITY_DEFENSE_ENHANCEMENT)
            .add(EEEnchantments.COMBUSTION_PROTECTION)
            .add(EEEnchantments.WEAPON_PROTECTION);
    }
    
}
