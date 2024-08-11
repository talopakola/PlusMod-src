package net.enzo.plus.common.compat;

import cpw.mods.fml.common.Loader;
import net.enzo.plus.Lumberjack;
import net.enzo.plus.common.compat.avaritia.AvaritiaCompat;
import net.enzo.plus.common.compat.minetweaker.Tweaker;
import net.enzo.plus.common.compat.nei.NEI;
import net.enzo.plus.common.compat.storageDrawers.InfinityStorageHandler;
import org.apache.logging.log4j.Level;
import net.enzo.plus.common.Config;

public class Compat {
    public static boolean nei;
    public static boolean tweak;
    public static boolean storage;
    public static  boolean father; // F-FA-FATHER??

    public static void compatible() {
        nei = Loader.isModLoaded("NotEnoughItems");
        tweak = Loader.isModLoaded("MineTweaker3");
        storage = Loader.isModLoaded("StorageDrawers");
        father = Loader.isModLoaded("Avaritia");
    }

    public static void loadIt() {
        if(nei){
            try
            {
                NEI.items();
            }
            catch(Throwable e)
            {
                System.out.println(e + " Plus has too many items");
            }

            if(tweak){
                try
                {
                    Tweaker.worstIdeaInMyLife();
                }
                catch(Throwable e){
                    Lumberjack.log(Level.INFO, e, "Maybe the worst idea on my life really was the worst :/");
                }
            }

            if (storage && Config.infinityStorage) {
                try {
                    InfinityStorageHandler.storageTheUniverse();
                } catch (Throwable e) {
                    Lumberjack.log(Level.INFO, e, "Can't support the infinity storage, try remake Big-Bang again");
                }
            }

            if (father && Config.father) {
                try {
                    AvaritiaCompat.father();
                } catch (Throwable e) {
                    Lumberjack.log(Level.INFO, e, "Father (Avaritia) leave to buy milk :C");
                }
            }
        }
    }
}
