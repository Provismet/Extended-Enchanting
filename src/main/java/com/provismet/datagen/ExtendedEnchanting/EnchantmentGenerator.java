package com.provismet.datagen.ExtendedEnchanting;

import com.provismet.ExtendedEnchanting.registries.EEEnchantments;
import com.provismet.lilylib.datagen.provider.LilyEnchantmentProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EnchantmentGenerator extends LilyEnchantmentProvider {
    public EnchantmentGenerator (FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void generate (RegistryWrapper.WrapperLookup wrapperLookup, EnchantmentBuilder builder) {
        builder.add(EEEnchantments.LEECHING_ASPECT);
        builder.add(EEEnchantments.FROST_ASPECT);
        builder.add(EEEnchantments.LIGHTNING_ASPECT);

        builder.add(EEEnchantments.INITIATIVE);
        builder.add(EEEnchantments.GLASS);
        builder.add(EEEnchantments.SOLITUDE);

        builder.add(EEEnchantments.DUAL_STRIKE);
        builder.add(EEEnchantments.FEINT);
        builder.add(EEEnchantments.RAMPAGE);

        builder.add(EEEnchantments.LAUNCH);

        builder.add(EEEnchantments.WEAPON_PROTECTION);
        builder.add(EEEnchantments.COMBUSTION_PROTECTION);

        builder.add(EEEnchantments.SUN_HEART);
        builder.add(EEEnchantments.MOON_HEART);
        builder.add(EEEnchantments.BRIMSTONE_HEART);
        builder.add(EEEnchantments.VOID_HEART);

        builder.add(EEEnchantments.REPLANT);
        builder.add(EEEnchantments.SOIL_WALKER);

        builder.add(EEEnchantments.CHORUS_CURSE);
    }
}
