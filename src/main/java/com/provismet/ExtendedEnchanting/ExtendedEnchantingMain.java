package com.provismet.ExtendedEnchanting;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.provismet.ExtendedEnchanting.registries.EEEnchantments;

public class ExtendedEnchantingMain implements ModInitializer {
	public static final String MODID = "extended-enchanting";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static Identifier identifier (String path) {
		return Identifier.of(MODID, path);
	}

	@Override
	public void onInitialize () {
		EEEnchantments.register();
	}
}