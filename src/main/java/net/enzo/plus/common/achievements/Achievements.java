package net.enzo.plus.common.achievements;

import cpw.mods.fml.common.FMLCommonHandler;
import net.enzo.plus.common.Config;
import net.enzo.plus.common.blocks.InfinityBlocks;
import net.enzo.plus.common.compat.Compat;
import net.enzo.plus.common.item.InfinityItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

public class Achievements {
    public static Achievement mixed;
    public static Achievement star;
    public static Achievement abs;
    public static Achievement core;
    public static Achievement coke;
    public static Achievement reality;
    public static Achievement existence;
    public static Achievement banana;
    public static Achievement apple;
    public static Achievement bedrock;

    public static AchievementPage page;

    public static void conquerTheWorld() {
        mixed = new InfinityAchievements("mixed", 0, 0, InfinityItems.mixed, null);
        star = new InfinityAchievements("star", 1, 2, InfinityItems.star, mixed);
        abs = new InfinityAchievements("abs", -2, 0, Item.getItemFromBlock(InfinityBlocks.absolute), mixed);
        coke = new InfinityAchievements("coke", -2, -5, Item.getItemFromBlock(InfinityBlocks.coke), abs);
        core = new InfinityAchievements("core", 3, 2, InfinityItems.star_core, star);
        reality = new InfinityAchievements("reality", 5, -4, InfinityItems.realityCristal, core).setSpecial();
        existence = new InfinityAchievements("existence", 1, -6, InfinityItems.existence, reality).setSpecial();
        apple = new InfinityAchievements("iApple", -5, -5, InfinityItems.infinity_apple, abs).setSpecial();
        if (Compat.father && Config.father)
            banana = new InfinityAchievements("banana", -4, 1, InfinityItems.infinity_banana, mixed);
        //bedrock = new InfinityAchievements("breakB", 1, 5, Item.getItemFromBlock(Blocks.bedrock), existence).setSpecial();

        page = new AchievementPage("Plus", InfinityAchievements.achievements.toArray(new Achievement[InfinityAchievements.achievements.size()]));
        AchievementPage.registerAchievementPage(page);

        AchievementsTriggerInfinity tigger = new AchievementsTriggerInfinity();
        FMLCommonHandler.instance().bus().register(tigger);
        MinecraftForge.EVENT_BUS.register(tigger);
    }
}
