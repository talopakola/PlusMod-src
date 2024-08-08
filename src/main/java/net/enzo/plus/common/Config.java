package net.enzo.plus.common;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
    public static boolean gottaGoFast = true;
    public static boolean craftOnly = false;

    public static void letsConfigurate(File file) {
        Configuration conf = new Configuration(file);

        try {
            conf.load();

            gottaGoFast = conf.get("General", "Sonic Speed", gottaGoFast, "Set if Infinity armor gave you sonic speed").getBoolean(true);
            craftOnly = conf.get("General", "Crafting Only", craftOnly, "Set if the game just accept craftings, for MineTweaker porpouses").getBoolean(false);
        } catch (Exception e) {
            System.out.println("The reality is in collapse...");
            e.printStackTrace();
        } finally {
            conf.save();
        }
    }
}
