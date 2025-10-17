package com.provismet.ExtendedEnchanting.config;

import com.provismet.CombatPlusCore.utility.CPCConfig;
import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import com.provismet.lilylib.util.json.JsonBuilder;
import com.provismet.lilylib.util.json.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class EESettings {
    private static final Path FILE = CPCConfig.getConfigDirectory().resolve("extended-enchanting.json");

    private static boolean overrideDatapacks = true;

    public static void write () {
        String jsonString = new JsonBuilder()
            .append(CPCConfig.KEY_OVERRIDE_DATAPACK_LOOT_TABLES, overrideDatapacks)
            .toString();
        
        try (FileWriter writer = new FileWriter(FILE.toFile())) {
            writer.write(jsonString);
        }
        catch (IOException e) {
            ExtendedEnchantingMain.LOGGER.error("Error whilst saving config: ", e);
        }
    }

    public static void read () {
        try {
            JsonReader reader = JsonReader.file(FILE.toFile());
            if (reader == null) {
                EESettings.write();
                return;
            }

            reader.getBoolean(CPCConfig.KEY_OVERRIDE_DATAPACK_LOOT_TABLES).ifPresent(val -> EESettings.overrideDatapacks = val);
        }
        catch (FileNotFoundException e) {
            ExtendedEnchantingMain.LOGGER.info("No config found for Extended Enchanting, creating one now.");
            EESettings.write();
        }
        catch (Exception e2) {
            ExtendedEnchantingMain.LOGGER.error("Error whilst parsing config:", e2);
        }
    }

    public static boolean shouldOverrideDatapacks () {
        return EESettings.overrideDatapacks;
    }
}
