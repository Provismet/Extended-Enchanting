package com.provismet.extendedenchanting;

import com.provismet.combatplus.api.loot.functions.EnchantRandomlyFromKeyLootFunction;
import com.provismet.extendedenchanting.registries.EEEnchantmentComponentTypes;
import com.provismet.extendedenchanting.registries.EELambdas;
import com.provismet.extendedenchanting.registries.EESingleEntityEnchantmentEffects;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.BinomialDistributionGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.provismet.extendedenchanting.config.EESettings;
import com.provismet.extendedenchanting.registries.EEEnchantments;
import com.provismet.extendedenchanting.registries.EEParticleTypes;

public class ExtendedEnchantingMain implements ModInitializer {
	public static final String MODID = "extended-enchanting";
    public static final Logger LOGGER = LoggerFactory.getLogger("Extended Enchanting");

	public static Identifier identifier (String path) {
		return Identifier.fromNamespaceAndPath(MODID, path);
	}

	@Override
	public void onInitialize () {
		EEEnchantmentComponentTypes.init();
		EESingleEntityEnchantmentEffects.register();
		EELambdas.register();
		EEParticleTypes.register();
		EESettings.read();

		LootTableEvents.MODIFY.register((key, tableBuilder, source, wrapperLookup) -> {
			if (source.isBuiltin() || EESettings.shouldOverrideDatapacks()) {
				if (BuiltInLootTables.BASTION_TREASURE.equals(key) || BuiltInLootTables.BASTION_HOGLIN_STABLE.equals(key)) {
					tableBuilder.withPool(
						LootPool.lootPool().setRolls(BinomialDistributionGenerator.binomial(1, 0.05f))
							.add(LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.BRIMSTONE_HEART)))
							.add(LootItem.lootTableItem(Items.BOOK).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.BRIMSTONE_HEART)))
					);
				}
				else if (BuiltInLootTables.END_CITY_TREASURE.equals(key)) {
					tableBuilder.withPool(
						LootPool.lootPool().setRolls(BinomialDistributionGenerator.binomial(1, 0.05f))
							.add(LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.VOID_HEART)))
							.add(LootItem.lootTableItem(Items.BOOK).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.VOID_HEART)))
					)
					.withPool(
						LootPool.lootPool().setRolls(BinomialDistributionGenerator.binomial(1, 0.025f))
							.add(LootItem.lootTableItem(Items.BOOK).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.SOLITUDE)))
							.add(LootItem.lootTableItem(Items.DIAMOND_SWORD).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.SOLITUDE)))
					);
				}
				else if (BuiltInLootTables.WOODLAND_MANSION.equals(key) || BuiltInLootTables.ANCIENT_CITY.equals(key)) {
					tableBuilder.withPool(
						LootPool.lootPool().setRolls(BinomialDistributionGenerator.binomial(1, 0.05f))
							.add(LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.SUN_HEART)))
							.add(LootItem.lootTableItem(Items.BOOK).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.SUN_HEART)))
							.add(LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.MOON_HEART)))
							.add(LootItem.lootTableItem(Items.BOOK).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.MOON_HEART)))
					)
					.withPool(
						LootPool.lootPool().setRolls(BinomialDistributionGenerator.binomial(1, 0.025f))
							.add(LootItem.lootTableItem(Items.BOOK).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.SOLITUDE)))
							.add(LootItem.lootTableItem(Items.DIAMOND_SWORD).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.SOLITUDE)))
					);
				}
				else if (BuiltInLootTables.ARMORER_GIFT.equals(key)) {
					tableBuilder.withPool(
						LootPool.lootPool().setRolls(BinomialDistributionGenerator.binomial(1, 0.005f))
							.add(LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.SUN_HEART)))
							.add(LootItem.lootTableItem(Items.BOOK).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.SUN_HEART)))
							.add(LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.MOON_HEART)))
							.add(LootItem.lootTableItem(Items.BOOK).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.MOON_HEART)))
							.add(LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.BRIMSTONE_HEART)))
							.add(LootItem.lootTableItem(Items.BOOK).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.BRIMSTONE_HEART)))
							.add(LootItem.lootTableItem(Items.DIAMOND_CHESTPLATE).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.VOID_HEART)))
							.add(LootItem.lootTableItem(Items.BOOK).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.VOID_HEART)))
					);
				}
				else if (BuiltInLootTables.WEAPONSMITH_GIFT.equals(key)) {
					tableBuilder.withPool(
						LootPool.lootPool().setRolls(BinomialDistributionGenerator.binomial(1, 0.005f))
							.add(LootItem.lootTableItem(Items.BOOK).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.SOLITUDE)))
							.add(LootItem.lootTableItem(Items.DIAMOND_SWORD).apply(EnchantRandomlyFromKeyLootFunction.create().option(EEEnchantments.SOLITUDE)))
					);
				}
			}
		});
	}
}