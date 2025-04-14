package com.provismet.ExtendedEnchanting.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.provismet.CombatPlusCore.utility.CPCConfig;
import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import com.provismet.lilylib.util.json.JsonBuilder;
import com.provismet.lilylib.util.json.JsonReader;

public class EESettings {
    private static final String FILE = "extended-enchanting.json";

    private static boolean overrideDatapacks = true;

    public static void write () {
        String jsonString = new JsonBuilder()
            .append(CPCConfig.KEY_OVERRIDE_DATAPACK_LOOT_TABLES, overrideDatapacks)
            .toString();
        
        try (FileWriter writer = new FileWriter(new File(CPCConfig.FOLDER, FILE))) {
            writer.write(jsonString);
        }
        catch (IOException e) {
            ExtendedEnchantingMain.LOGGER.error("Error whilst saving config: ", e);
        }
    }

    public static void read () {
        try {
            JsonReader reader = JsonReader.file(new File(CPCConfig.FOLDER, FILE));
            if (reader == null) {
                EESettings.write();
                return;
            }

            reader.getBoolean(CPCConfig.KEY_OVERRIDE_DATAPACK_LOOT_TABLES).ifPresent(val -> EESettings.overrideDatapacks = val);
        }
        catch (FileNotFoundException e) {
            ExtendedEnchantingMain.LOGGER.info("No config found for Extended Enchanting, creating one now.");
            new File(CPCConfig.FOLDER).mkdirs();
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
