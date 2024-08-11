package net.enzo.plus.common;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {
    public static boolean gottaGoFast = true;
    public static boolean craftOnly = false;
    public static boolean boringChest = false;
    public static boolean infinityStorage = true;
    public static boolean boringSword = false;
    public static boolean father = true;

    public static void letsConfigurate(File file) {
        Configuration conf = new Configuration(file);

        try {
            conf.load();

            gottaGoFast = conf.get("General", "Sonic Speed", gottaGoFast, "Set if Infinity armor gave you sonic speed").getBoolean(true);
            craftOnly = conf.get("General", "Crafting Only", craftOnly, "Set if the game just accept crafting, for MineTweaker porpoises").getBoolean(false);
            boringChest = conf.get("General", "Boring Chest", boringChest, "Set if chest hold just 64 items per stack!").getBoolean(false);
            boringSword = conf.get("General", "Boring Sword", boringSword, "Set if Infinity Sword have 100 looting (true is no, false is ye)").getBoolean(false);

            infinityStorage = conf.get("Compat", "Infinity Storage", infinityStorage, "Set if Plus can actually add a Infinity Storage Upgrade recipe for Storage drawers").getBoolean(true);
            father = conf.get("Compat", "Father????", father, "Set if Plus will be compatible with Avaritia").getBoolean(true);
        } catch (Exception e) {
            System.out.println("The reality is in collapse...");
            e.printStackTrace();
        } finally {
            conf.save();
        }
    }
}
