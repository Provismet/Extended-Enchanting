package com.provismet.ExtendedEnchanting.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.stream.JsonReader;
import com.provismet.ExtendedEnchanting.ExtendedEnchantingMain;
import com.provismet.lilylib.util.JsonBuilder;

public class EESettings {
    private static boolean overrideDatapacks = true;

    public static void write () {
        JsonBuilder builder = new JsonBuilder();
        String jsonString = builder.start()
            .append("override_datapack_loot_tables", overrideDatapacks).newLine(false)
            .closeObject()
            .toString();
        
        try {
            FileWriter writer = new FileWriter("config/combat-plus/extended-enchanting.json");
            writer.write(jsonString);
            writer.close();
        }
        catch (IOException e) {
            ExtendedEnchantingMain.LOGGER.error("Error whilst saving config: ", e);
        }
    }

    public static void read () {
        try {
            FileReader reader = new FileReader("config/combat-plus/extended-enchanting.json");
            JsonReader parser = new JsonReader(reader);
            
            parser.beginObject();
            while (parser.hasNext()) {
                switch (parser.nextName()) {
                    case "override_datapack_loot_tables":
                        EESettings.overrideDatapacks = parser.nextBoolean();
                        break;
                
                    default:
                        break;
                }
            }
            parser.endObject();
            parser.close();
        }
        catch (FileNotFoundException e) {
            ExtendedEnchantingMain.LOGGER.info("No config found for Extended Enchanting, creating one now.");
            try {
                (new File("config/combat-plus")).mkdirs();
            }
            catch (Exception e3) {

            }
            EESettings.write();
        }
        catch (IOException e2) {
            ExtendedEnchantingMain.LOGGER.error("Error whilst parsing config:", e2);
        }
    }

    public static boolean shouldOverrideDatapacks () {
        return EESettings.overrideDatapacks;
    }
}
