package net.enzo.plus.common.misc;

import cpw.mods.fml.common.registry.GameRegistry;
import net.enzo.plus.Lumberjack;
import net.enzo.plus.common.Config;
import net.enzo.plus.common.blocks.InfinityBlocks;
import net.enzo.plus.common.crafting.AbsoluteCraftingManager;
import net.enzo.plus.common.item.InfinityItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MakeTheThings {
    public static void makeAll() {
        OreDictionary.registerOre("itemMixedIngot", InfinityItems.mixed);
        OreDictionary.registerOre("itemStarCore", InfinityItems.star_core);
        OreDictionary.registerOre("itemStarIngot", InfinityItems.star);
        OreDictionary.registerOre("itemRealityCristal", InfinityItems.realityCristal);
        OreDictionary.registerOre("itemExistenceIngot", InfinityItems.existence);
        OreDictionary.registerOre("itemExistenceNugget", new ItemStack(InfinityItems.nugget, 1, 0));
        OreDictionary.registerOre("itemRealityNugget", new ItemStack(InfinityItems.nugget, 1, 1));
        OreDictionary.registerOre("itemStarNugget", new ItemStack(InfinityItems.nugget, 1, 2));
        OreDictionary.registerOre("itemMixedNugget", new ItemStack(InfinityItems.nugget, 1, 3));

        OreDictionary.registerOre("blockMixed", InfinityBlocks.mixedBlock);
        OreDictionary.registerOre("blockStarCore", InfinityBlocks.star);
        OreDictionary.registerOre("blockRealityCristal", InfinityBlocks.reality);


        GameRegistry.addShapedRecipe(new ItemStack(InfinityBlocks.absolute), "XXX", "XDX", "XXX", 'X', InfinityItems.mixed, 'D', Blocks.crafting_table);
        GameRegistry.addShapelessRecipe(new ItemStack(InfinityItems.mixed), Items.gold_ingot, Items.iron_ingot, Items.diamond, Items.coal, Items.emerald);
        GameRegistry.addShapedRecipe(new ItemStack(InfinityBlocks.mixedBlock), "XXX","XXX","XXX", 'X', InfinityItems.mixed);
        GameRegistry.addShapedRecipe(new ItemStack(InfinityBlocks.star), "XXX", "XXX", "XXX", 'X', InfinityItems.star_core);
        GameRegistry.addShapedRecipe(new ItemStack(InfinityBlocks.reality), "XXX", "XXX", "XXX", 'X', InfinityItems.realityCristal);

        GameRegistry.addShapelessRecipe(new ItemStack(InfinityItems.nugget, 9, 0), InfinityItems.existence);
        GameRegistry.addShapelessRecipe(new ItemStack(InfinityItems.nugget, 9, 1), InfinityItems.realityCristal);
        GameRegistry.addShapelessRecipe(new ItemStack(InfinityItems.nugget, 9, 2), InfinityItems.star);
        GameRegistry.addShapelessRecipe(new ItemStack(InfinityItems.nugget, 9, 3), InfinityItems.mixed);
        GameRegistry.addShapedRecipe(new ItemStack(InfinityItems.existence), "XXX", "XXX", "XXX", 'X', new ItemStack(InfinityItems.nugget, 1, 0));
        GameRegistry.addShapedRecipe(new ItemStack(InfinityItems.realityCristal), "XXX", "XXX", "XXX", 'X', new ItemStack(InfinityItems.nugget, 1, 1));
        GameRegistry.addShapedRecipe(new ItemStack(InfinityItems.star), "XXX", "XXX", "XXX", 'X', new ItemStack(InfinityItems.nugget, 1, 2));
        GameRegistry.addShapedRecipe(new ItemStack(InfinityItems.mixed), "XXX", "XXX", "XXX", 'X', new ItemStack(InfinityItems.nugget, 1, 3));

        Lumberjack.debug(AbsoluteCraftingManager.getInstance().getRecipeList());
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.star), "XXXXXXXXX", "XNNNNNNNX", "XNNMMMNNX", "XNNMMMNNX", "XNNMMMNNX", "XESESESEX", /*SEX*/"XNNSSSNNX", "XXXSSSXXX", "XXXXXXXXX", 'X', InfinityItems.mixed, 'N', Items.nether_star, 'M', Items.iron_ingot, 'S', Blocks.stone, 'E', Blocks.end_stone);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.star_core), "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", 'T', Blocks.tnt, 'X', InfinityItems.star);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.realityCristal), "   CC    ", "  CMMC   ", "  CNSC   ", "  CEDC   ", "  CMMC   ", "  CNSC   ", "  CEDC   ", "  CMMC   ", "   CC    ", 'C', InfinityItems.star_core, 'M', InfinityItems.mixed, 'E', Blocks.end_stone, 'S', InfinityItems.star, 'N', Items.nether_star, 'D', InfinityBlocks.mixedBlock);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.existence), "CCCCCCCCC", "CSDDSDDSC", "CDSSDSSDC", "CSDDSDDSC", "CDSSDSSDC", "CCCCCCCCC", "         ", "         ", "         ", 'C', InfinityItems.realityCristal, 'S', InfinityItems.star, 'D', InfinityItems.star_core);

        if (Config.craftOnly)
            return;
        /*System.out.println(CompressorManager.getRecipes());
        CompressorManager.addRecipe(new ItemStack(Items.golden_apple, 1, 1), new ItemStack(Items.golden_apple, 1, 0));
        System.out.println(CompressorManager.getRecipes());*/
        //AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityBlocks.absolute), "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", 'X', new ItemStack(InfinityItems.mixed)); // Test
        //AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.star), "XXXXXXXXX", "XNNNNNNNX", "XNNMMMNNX", "XNNMMMNNX", "XNNMMMNNX", "XSESESESX", /*SEX*/"XNNSSSNNX", "XXXSSSXXX", "XXXXXXXXX", 'X', InfinityItems.mixed, 'N', Items.nether_star, 'M', Items.iron_ingot, 'S', Blocks.stone, 'E', Blocks.end_stone);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_sword), "       II", "      III", "     III ", "    III  ", " D III   ", "  DII    ", "  XD     ", " X  D    ", "K        ", 'D', InfinityItems.star, 'X', InfinityItems.star_core, 'S', InfinityItems.mixed, 'I', InfinityItems.existence, 'K', InfinityItems.realityCristal);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_pickaxe), " EEEEEEE ", "EEEEEEEEE", "EE  X  EE", "    X    ", "    X    ", "    X    ", "    X    ", "    X    ", "    X    ", 'E', InfinityItems.existence, 'X', InfinityItems.star_core);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_axe),"  EEEE   ", " EEEEEE  ", " EEEEE   ", "  E X    ", "    X    ","    X    ","    X    ","    X    ","    X    ", 'E', InfinityItems.existence, 'X', InfinityItems.star_core);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_shovel), "      EEE", "     EEBE", "     EEEE", "     XEE ", "    X    ", "   X     ", "  X      ", " X       ", "X        ", 'E', InfinityItems.existence, 'B', InfinityBlocks.star, 'X', InfinityItems.star_core);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_boots), " DDD DDD ", " DCD DCD ", " DED DED ", " DED DED ", " DED DED ", " DED DED ", "DDED DEDD", "DEED DEED", "DDDD DDDD", 'D', InfinityItems.star_core, 'C', InfinityItems.realityCristal, 'E', InfinityItems.realityCristal);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_leggings), " EEEEEEE ", " ECCBCCE ", " ECEEECE ", " ECE ECE ", " ECE ECE ", " ECE ECE ", " ECE ECE ", " ECE ECE ", " EEE EEE ", 'E', InfinityItems.existence, 'B', InfinityBlocks.star, 'C', InfinityItems.realityCristal);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_chest), "EEEEEEEEE", "EDDSSSDDE", "EEESSSEEE", "  ECCCE  ", "  ECCCE  ", "  ECCCE  ", "  ECCCE  ", "  ECCCE  ", "  EEEEE  ", 'E', InfinityItems.existence, 'D', InfinityItems.star_core, 'S', InfinityItems.star, 'C', InfinityItems.realityCristal);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_helmet), " EEEEEEE ", " EDDDDDE ", " ECCDCCE ", " EDDDDDE ", " EDDDDDE ", " ESSDSSE ", " E     E ", "         ", "         ", 'E', InfinityItems.existence, 'C', InfinityItems.realityCristal, 'D', InfinityItems.star_core, 'S', InfinityItems.star);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_apple), "EEEEEEEEE", "EEEEEEEEE", "EEEEEEEEE", "EEEAAAEEE", "EEEAAAEEE", "EEEAAAEEE", "EEEEEEEEE", "EEEEEEEEE", "EEEEEEEEE", 'E', InfinityItems.existence, 'A', new ItemStack(Items.golden_apple, 1, 1));
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_bow), "    SL   ", "   S L   ", "  D  L   ", " D   L   ", "C    B   ", " D   L   ", "  D  L   ", "   S L   ", "    SL   ", 'S', InfinityItems.existence, 'L', Blocks.wool, 'C', InfinityItems.realityCristal, 'D', InfinityItems.star_core, 'B', InfinityBlocks.star);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityBlocks.coke), "OOOOOOOOO","OOOOOOOOO","OOOOOOOOO","OOXXXXXOO","OOXXXXXOO","OOXXXXXOO","OOOOOOOOO","OOOOOOOOO","OOOOOOOOO", 'O', InfinityItems.realityCristal, 'X', Blocks.chest);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_hoe), " IIID    ", "IIIII    ", " IIII    ", "    D    ", "    D    ", "    D    ", "    D    ", "    D    ", "    S    ", 'I', InfinityItems.existence, 'D', InfinityItems.realityCristal, 'S', InfinityItems.star);
        Lumberjack.debug(AbsoluteCraftingManager.getInstance().getRecipeList());
    }
}
