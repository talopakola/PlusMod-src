package net.enzo.plus.common.compat;

import cpw.mods.fml.common.Loader;
import net.enzo.plus.common.compat.nei.NEI;

public class Compat {
    public static boolean nei;

    public static void compatible() {
        nei = Loader.isModLoaded("NotEnoughItems");
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
        }
    }
}
