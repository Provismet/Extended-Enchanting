package com.provismet.datagen.ExtendedEnchanting;

import com.provismet.ExtendedEnchanting.registries.EEEnchantments;
import com.provismet.ExtendedEnchanting.utility.EEDamageTypes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ExtendedEnchantingDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator (FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(EnchantmentGenerator::new);
        pack.addProvider(DamageTypeGenerator::new);
        pack.addProvider(LanguageGenerator::new);
        pack.addProvider(EntityTypeTagGenerator::new);
        pack.addProvider(EnchantmentTagGenerator::new);
        pack.addProvider(ItemTagGenerator::new);
        pack.addProvider(DamageTypeTagGenerator::new);
    }

    @Override
    public void buildRegistry (RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, EEEnchantments::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.DAMAGE_TYPE, EEDamageTypes::bootstrap);
    }
}
