package com.provismet.datagen.ExtendedEnchanting;

import com.provismet.ExtendedEnchanting.registries.EEEnchantments;

import com.provismet.ExtendedEnchanting.utility.EEDamageTypes;
import com.provismet.lilylib.container.DamageTypeContainer;
import com.provismet.lilylib.container.EnchantmentContainer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LanguageGenerator extends FabricLanguageProvider {
    protected LanguageGenerator (FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations (RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.LEECHING_ASPECT, "Leeching Aspect", "Heals the user when critically striking a target.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.FROST_ASPECT, "Frost Aspect", "Partially freezes the target on hit.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.LIGHTNING_ASPECT, "Lightning Aspect", "Build up static charge on struck targets.");

        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.INITIATIVE, "Initiative", "Deal increased damage to full health targets.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.GLASS, "Glass", "Deal increased damage when on full health.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.SOLITUDE, "Solitude", "Deal more damage when this is the only enchantment on the item.");

        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.DUAL_STRIKE, "Dual Strike", "Attack a secondary target with each hit.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.FEINT, "Feint", "Jump back after striking a target.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.RAMPAGE, "Rampage", "Gain strength and speed after killing an enemy.");

        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.LAUNCH, "Launch", "Launches the target in the air on hit.");

        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.WEAPON_PROTECTION, "Weapon Protection", "Grants increased protection against attackers wielding melee weapons.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.COMBUSTION_PROTECTION, "Combustion Protection", "Grants increased protection to fire and explosion damage.");

        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.SUN_HEART, "Heart of the Sun", "Grants health over time and ignites attackers when exposed to sunlight.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.MOON_HEART, "Heart of the Moon", "Prevents phantom spawns and inflicts slowness on attackers when exposed to moonlight.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.BRIMSTONE_HEART, "Heart of Brimstone", "Grants speed and health regeneration when on fire in the Nether.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.VOID_HEART, "Heart of the Void", "Saves you from fall damage and the void when in the End.");

        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.REPLANT, "Green Thumb", "Replants crops that are broken with a hoe.");
        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.SOIL_WALKER, "Soil Walker", "Prevents you from converting farmland into dirt when landing on it.");

        LanguageGenerator.addEnchantment(translationBuilder, EEEnchantments.CHORUS_CURSE, "Curse of Chorus", "Randomly teleport when attacked.");

        LanguageGenerator.addDeathMessage(translationBuilder, EEDamageTypes.STATIC, "was electrified", "was electrified by");
    }

    private static void addEnchantment (TranslationBuilder translationBuilder, EnchantmentContainer enchantment, String name, String description) {
        translationBuilder.add(enchantment.getTranslationKey(), name);
        translationBuilder.add(enchantment.getTranslationKey("desc"), description);
    }

    private static void addDeathMessage (TranslationBuilder translationBuilder, DamageTypeContainer damageType, String message, String mobMessage) {
        translationBuilder.add(damageType.getDeathTranslationKey(), "%1$s " + message);
        translationBuilder.add(damageType.getDeathTranslationKey() + ".player", "%1$s " + mobMessage + " %2$s");
    }
}
