package com.provismet.datagen.ExtendedEnchanting;

import com.provismet.ExtendedEnchanting.registries.EEEnchantments;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.enchantment.Enchantment;

public class LanguageProvider extends FabricLanguageProvider {
    protected LanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations (TranslationBuilder translationBuilder) {
        LanguageProvider.addEnchantment(translationBuilder, EEEnchantments.LEECHING, "Leeching", "Heals the user when striking a target.");
        LanguageProvider.addEnchantment(translationBuilder, EEEnchantments.FROST_ASPECT, "Frost Aspect", "Partially freezes the target on hit.");
        LanguageProvider.addEnchantment(translationBuilder, EEEnchantments.INITIATIVE, "Initiative", "Deal increased damage to full health targets.");
        LanguageProvider.addEnchantment(translationBuilder, EEEnchantments.GLASS, "Glass", "Deal increased damage when on full health.");
    }

    private static void addEnchantment (TranslationBuilder translationBuilder, Enchantment enchantment, String name, String description) {
        translationBuilder.add(enchantment, name);
        translationBuilder.add(enchantment.getTranslationKey() + ".desc", description);
    }
}
