package net.enzo.plus.common.compat;

import cpw.mods.fml.common.Loader;
import net.enzo.plus.Lumberjack;
import net.enzo.plus.common.compat.minetweaker.Tweaker;
import net.enzo.plus.common.compat.nei.NEI;
import org.apache.logging.log4j.Level;

public class Compat {
    public static boolean nei;
    public static boolean tweak;

    public static void compatible() {
        nei = Loader.isModLoaded("NotEnoughItems");
        tweak = Loader.isModLoaded("MineTweaker3");
    }

    public static void loadIt() {
        if(nei){
            try
            {
                NEI.items();
            }
            catch(Throwable e)
            {
                System.out.println(e + " God of Gods are not polished, polish it");
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
        }
    }
}
