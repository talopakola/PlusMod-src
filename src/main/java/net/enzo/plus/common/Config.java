package net.enzo.plus.common;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
    public static boolean gottaGoFast = true;

    public static void letsConfigurate(File file) {
        Configuration conf = new Configuration(file);

        try {
            conf.load();

            gottaGoFast = conf.get("General", "Sonic Speed", gottaGoFast, "Set if Infinity armor gave you sonic speed").getBoolean(true);
        } catch (Exception e) {
            System.out.println("Plus can't load configs, try reinstall the mod?");
            e.printStackTrace();
        } finally {
            conf.save();
        }
    }
}
