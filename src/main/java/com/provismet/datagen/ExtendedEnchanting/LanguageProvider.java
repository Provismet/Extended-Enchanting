package com.provismet.datagen.ExtendedEnchanting;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.enchantment.Enchantment;

public class LanguageProvider extends FabricLanguageProvider {
    protected LanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations (TranslationBuilder translationBuilder) {
        
    }

    private static void addEnchantment (TranslationBuilder translationBuilder, Enchantment enchantment, String name, String description) {
        translationBuilder.add(enchantment, name);
        translationBuilder.add(enchantment.getTranslationKey() + ".desc", description);
    }
}
