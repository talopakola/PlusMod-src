package net.enzo.plus.common;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.potion.Potion;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class PotionHelper {
    private static ArrayList<Potion> badPotions;

    public static void healthInspection(){
        badPotions = new ArrayList<Potion>();
        try {
            Field stupidMojangPrivateVariable = ReflectionHelper.findField(Potion.class, "isBadEffect", "field_76418_K");

            for(Potion potion : Potion.potionTypes){
                if(potion != null && stupidMojangPrivateVariable.getBoolean(potion))
                    badPotions.add(potion);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean badPotion(Potion effect){
        return badPotions.contains(effect);
    }
}
