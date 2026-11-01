package com.provismet.extendedenchanting.datagen;

import com.provismet.extendedenchanting.registries.EEEnchantments;
import com.provismet.extendedenchanting.utility.EEDamageTypes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

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
    public void buildRegistry (RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.ENCHANTMENT, EEEnchantments::bootstrap);
        registryBuilder.add(Registries.DAMAGE_TYPE, EEDamageTypes::bootstrap);
    }
}
