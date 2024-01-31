package com.provismet.ExtendedEnchanting;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantRandomlyLootFunction;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.provismet.ExtendedEnchanting.config.EESettings;
import com.provismet.ExtendedEnchanting.registries.EEEnchantments;
import com.provismet.ExtendedEnchanting.registries.EEParticleTypes;
import com.provismet.ExtendedEnchanting.utility.EEGameRules;

public class ExtendedEnchantingMain implements ModInitializer {
	public static final String MODID = "extended-enchanting";
    public static final Logger LOGGER = LoggerFactory.getLogger("Extended Enchanting");

	public static Identifier identifier (String path) {
		return Identifier.of(MODID, path);
	}

	@Override
	public void onInitialize () {
		EEEnchantments.register();
		EEParticleTypes.register();
		EEGameRules.register();
		EESettings.read();

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin() || EESettings.shouldOverrideDatapacks()) {
				if (LootTables.BASTION_TREASURE_CHEST.equals(id) || LootTables.BASTION_HOGLIN_STABLE_CHEST.equals(id)) {
					tableBuilder.pool(
						LootPool.builder().rolls(BinomialLootNumberProvider.create(1, 0.05f))
							.with(ItemEntry.builder(Items.DIAMOND_CHESTPLATE).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.BRIMSTONE_HEART)))
							.with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.BRIMSTONE_HEART)))
					);
				}
				else if (LootTables.END_CITY_TREASURE_CHEST.equals(id)) {
					tableBuilder.pool(
						LootPool.builder().rolls(BinomialLootNumberProvider.create(1, 0.05f))
							.with(ItemEntry.builder(Items.DIAMOND_CHESTPLATE).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.VOID_HEART)))
							.with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.VOID_HEART)))
					)
					.pool(
						LootPool.builder().rolls(BinomialLootNumberProvider.create(1, 0.025f))
							.with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.SOLITUDE)))
							.with(ItemEntry.builder(Items.DIAMOND_SWORD).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.SOLITUDE)))
					);
				}
				else if (LootTables.WOODLAND_MANSION_CHEST.equals(id) || LootTables.ANCIENT_CITY_CHEST.equals(id)) {
					tableBuilder.pool(
						LootPool.builder().rolls(BinomialLootNumberProvider.create(1, 0.05f))
							.with(ItemEntry.builder(Items.DIAMOND_CHESTPLATE).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.SUN_HEART)))
							.with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.SUN_HEART)))
							.with(ItemEntry.builder(Items.DIAMOND_CHESTPLATE).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.MOON_HEART)))
							.with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.MOON_HEART)))
					)
					.pool(
						LootPool.builder().rolls(BinomialLootNumberProvider.create(1, 0.025f))
							.with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.SOLITUDE)))
							.with(ItemEntry.builder(Items.DIAMOND_SWORD).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.SOLITUDE)))
					);
				}
				else if (LootTables.HERO_OF_THE_VILLAGE_ARMORER_GIFT_GAMEPLAY.equals(id)) {
					tableBuilder.pool(
						LootPool.builder().rolls(BinomialLootNumberProvider.create(1, 0.005f))
							.with(ItemEntry.builder(Items.DIAMOND_CHESTPLATE).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.SUN_HEART)))
							.with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.SUN_HEART)))
							.with(ItemEntry.builder(Items.DIAMOND_CHESTPLATE).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.MOON_HEART)))
							.with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.MOON_HEART)))
							.with(ItemEntry.builder(Items.DIAMOND_CHESTPLATE).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.BRIMSTONE_HEART)))
							.with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.BRIMSTONE_HEART)))
							.with(ItemEntry.builder(Items.DIAMOND_CHESTPLATE).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.VOID_HEART)))
							.with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.VOID_HEART)))
					);
				}
				else if (LootTables.HERO_OF_THE_VILLAGE_WEAPONSMITH_GIFT_GAMEPLAY.equals(id)) {
					tableBuilder.pool(
						LootPool.builder().rolls(BinomialLootNumberProvider.create(1, 0.005f))
							.with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.SOLITUDE)))
							.with(ItemEntry.builder(Items.DIAMOND_SWORD).apply(new EnchantRandomlyLootFunction.Builder().add(EEEnchantments.SOLITUDE)))
					);
				}
			}
		});
	}
}