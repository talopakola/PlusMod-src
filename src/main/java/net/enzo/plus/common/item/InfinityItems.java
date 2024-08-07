package net.enzo.plus.common.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.enzo.plus.common.item.tools.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

public class InfinityItems {
    // Debug
    public static Item debug;
    //Resources
    public static Item mixed;
    public static Item star;
    public static Item star_core;
    public static Item realityCristal;
    public static Item existence;
    public static Item infinity_sword;
    public static Item infinity_pickaxe;
    public static Item infinity_axe;
    public static Item infinity_shovel;

    public static Item infinity_helmet;
    public static Item infinity_chest;
    public static Item infinity_leggings;
    public static Item infinity_boots;

    public static EnumRarity infinity = EnumHelper.addRarity("INFINITY", EnumChatFormatting.RED, "Infinity"); // Why the fuck exist a "display name"?

    public static void letsRegisterEmAll(){
        debug = butSetItFirst(new ItemTest(), "itemTest");
        mixed = butSetItFirst(new ItemMixedIngot(), "mixed_ingot");
        star = butSetItFirst(new ItemStarIngot(), "star_ingot");
        star_core = butSetItFirst(new ItemStarCore(), "star_core");
        realityCristal = butSetItFirst(new ItemRealityCristal(), "reality_cristal");
        existence = butSetItFirst(new ItemExistenceIngot(), "existence_ingot");
        infinity_sword = butSetItFirst(new ItemInfinitySword(), "infinity_sword");
        infinity_pickaxe = butSetItFirst(new ItemInfinityPickaxe(), "infinity_pickaxe");
        infinity_axe = butSetItFirst(new ItemInfinityAxe(), "infinity_axe");
        infinity_shovel = butSetItFirst(new ItemInfinityShovel(), "infinity_shovel");

        infinity_helmet = butSetItFirst(new ItemInfinityArmor(0), "infinity_armor_0");
        infinity_chest = butSetItFirst(new ItemInfinityArmor(1), "infinity_armor_1");
        infinity_leggings = butSetItFirst(new ItemInfinityArmor(2), "infinity_armor_2");
        infinity_boots = butSetItFirst(new ItemInfinityArmor(3), "infinity_armor_3");

        MinecraftForge.EVENT_BUS.register(new ItemInfinityArmor.abilityHandler()); // OWO
    }

    public static boolean isPlus(EntityPlayer player) {
        if(player.getEquipmentInSlot(1) == null || player.getEquipmentInSlot(2) == null
                || player.getEquipmentInSlot(3) == null || player.getEquipmentInSlot(4) == null)
            return false;
        if(player.getEquipmentInSlot(1).getItem() == infinity_boots || player.getEquipmentInSlot(2).getItem() == infinity_leggings
                || player.getEquipmentInSlot(3).getItem() == infinity_chest || player.getEquipmentInSlot(4).getItem() == infinity_helmet)
            return true;
        else
            return false;
    }

    public static Item butSetItFirst(Item item, String name) {
        GameRegistry.registerItem(item, name);
        return item;
    }
}
