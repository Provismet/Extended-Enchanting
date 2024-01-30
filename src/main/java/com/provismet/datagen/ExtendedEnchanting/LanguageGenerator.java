package com.provismet.datagen.ExtendedEnchanting;

import com.provismet.ExtendedEnchanting.registries.EEEnchantments;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.enchantment.Enchantment;

public class LanguageGenerator extends FabricLanguageProvider {
    protected LanguageGenerator(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations (TranslationBuilder translationBuilder) {
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.LEECHING_ASPECT, "Leeching Aspect", "Heals the user when striking a target.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.FROST_ASPECT, "Frost Aspect", "Partially freezes the target on hit.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.LIGHTNING_ASPECT, "Lightning Aspect", "Build up static charge on struck targets.");

        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.INITIATIVE, "Initiative", "Deal increased damage to full health targets.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.GLASS, "Glass", "Deal increased damage when on full health.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.SOLITUDE, "Solitude", "Deal more damage when this is the only enchantment on the item.");

        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.DUAL_STRIKE, "Dual Strike", "Attack a secondary target with each hit.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.BACK_FOOT, "Feint", "Jump back after striking a target.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.RAMPAGE, "Rampage", "Gain strength and speed after killing an enemy.");

        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.LAUNCH, "Launch", "Launches the target in the air on hit.");

        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.WEAPON_PROTECTION, "Weapon Protection", "Grants increased protection against attackers wielding melee weapons.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.COMBUSTION_PROTECTION, "Combustion Protection", "Grants increased protection to fire and explosion damage.");

        LanguageGenerator.addDeathMessage(translationBuilder, "static_shock", "was electrified", "was electrified by");
    }

    private static void addEnchantment (TranslationBuilder translationBuilder, Enchantment enchantment, String name, String description) {
        translationBuilder.add(enchantment, name);
        translationBuilder.add(enchantment.getTranslationKey() + ".desc", description);
    }

    private static void addDeathMessage (TranslationBuilder translationBuilder, String damageId, String message, String mobMessage) {
        translationBuilder.add("death.attack.extended-enchanting." + damageId, "%1$s " + message);
        translationBuilder.add("death.attack.extended-enchanting." + damageId + ".player", "%1$s " + mobMessage + " %2$s");
    }
}
