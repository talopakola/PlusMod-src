package net.enzo.plus.common.misc;

import cpw.mods.fml.common.registry.GameRegistry;
import net.enzo.plus.common.blocks.InfinityBlocks;
import net.enzo.plus.common.crafting.AbsoluteCraftingManager;
import net.enzo.plus.common.item.InfinityItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MakeTheThings {
    public static void makeAll() {
        GameRegistry.addShapelessRecipe(new ItemStack(InfinityItems.mixed), Items.gold_ingot, Items.iron_ingot, Items.diamond, Items.coal, Items.emerald);
        GameRegistry.addShapedRecipe(new ItemStack(InfinityBlocks.absolute), "XXX", "XDX", "XXX", 'X', InfinityItems.mixed, 'D', Blocks.crafting_table);
        GameRegistry.addShapedRecipe(new ItemStack(InfinityBlocks.mixedBlock), "XXX","XXX","XXX", 'X', InfinityItems.mixed);
        GameRegistry.addShapedRecipe(new ItemStack(InfinityBlocks.star), "XXX", "XXX", "XXX", 'X', InfinityItems.star_core);
        GameRegistry.addShapedRecipe(new ItemStack(InfinityBlocks.reality), "XXX", "XXX", "XXX", 'X', InfinityItems.realityCristal);

        //AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityBlocks.absolute), "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", "XXXXXXXXX", 'X', new ItemStack(InfinityItems.mixed)); // Test
        //AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.star), "XXXXXXXXX", "XNNNNNNNX", "XNNMMMNNX", "XNNMMMNNX", "XNNMMMNNX", "XSESESESX", /*SEX*/"XNNSSSNNX", "XXXSSSXXX", "XXXXXXXXX", 'X', InfinityItems.mixed, 'N', Items.nether_star, 'M', Items.iron_ingot, 'S', Blocks.stone, 'E', Blocks.end_stone);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.star), "XXXXXXXXX", "XNNNNNNNX", "XNNMMMNNX", "XNNMMMNNX", "XNNMMMNNX", "XESESESEX", /*SEX*/"XNNSSSNNX", "XXXSSSXXX", "XXXXXXXXX", 'X', InfinityItems.mixed, 'N', Items.nether_star, 'M', Items.iron_ingot, 'S', Blocks.stone, 'E', Blocks.end_stone);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.star_core), "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", "TTTXXXTTT", 'T', Blocks.tnt, 'X', InfinityItems.star);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.realityCristal), "   CC    ", "  CMMC   ", "  CNSC   ", "  CEDC   ", "  CMMC   ", "  CNSC   ", "  CEDC   ", "  CMMC   ", "   CC    ", 'C', InfinityItems.star_core, 'M', InfinityItems.mixed, 'E', Blocks.end_stone, 'S', InfinityItems.star, 'N', Items.nether_star, 'D', InfinityBlocks.mixedBlock);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.existence), "CCCCCCCCC", "CSDDSDDSC", "CDSSDSSDC", "CSDDSDDSC", "CDSSDSSDC", "CCCCCCCCC", "         ", "         ", "         ", 'C', InfinityItems.realityCristal, 'S', InfinityItems.star, 'D', InfinityItems.star_core);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_sword), "       II", "      III", "     III ", "    III  ", " D III   ", "  DII    ", "  XD     ", " X  D    ", "D        ", 'D', InfinityItems.star, 'X', InfinityItems.star_core, 'S', InfinityItems.mixed, 'I', InfinityItems.existence);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_pickaxe), " EEEEEEE ", "EEEEEEEEE", "EE  X  EE", "    X    ", "    X    ", "    X    ", "    X    ", "    X    ", "    X    ", 'E', InfinityItems.existence, 'X', InfinityItems.star_core);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_axe),"  EEEE   ", " EEEEEE  ", " EEEEE   ", "  E X    ", "    X    ","    X    ","    X    ","    X    ","    X    ", 'E', InfinityItems.existence, 'X', InfinityItems.star_core);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_shovel), "      EEE", "     EEBE", "     EEEE", "     XEE ", "    X    ", "   X     ", "  X      ", " X       ", "X        ", 'E', InfinityItems.existence, 'B', InfinityBlocks.star, 'X', InfinityItems.star_core);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_boots), " DDD DDD ", " DCD DCD ", " DED DED ", " DED DED ", " DED DED ", " DED DED ", "DDED DEDD", "DEED DEED", "DDDD DDDD", 'D', InfinityItems.star_core, 'C', InfinityItems.realityCristal, 'E', InfinityItems.realityCristal);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_leggings), " EEEEEEE ", " ECCBCCE ", " ECEEECE ", " ECE ECE ", " ECE ECE ", " ECE ECE ", " ECE ECE ", " ECE ECE ", " EEE EEE ", 'E', InfinityItems.existence, 'B', InfinityBlocks.star, 'C', InfinityItems.realityCristal);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_chest), "EEEEEEEEE", "EDDSSSDDE", "EEESSSEEE", "  ECCCE  ", "  ECCCE  ", "  ECCCE  ", "  ECCCE  ", "  ECCCE  ", "  EEEEE  ", 'E', InfinityItems.existence, 'D', InfinityItems.star_core, 'S', InfinityItems.star, 'C', InfinityItems.realityCristal);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_helmet), " EEEEEEE ", " EDDDDDE ", " ECCDCCE ", " EDDDDDE ", " EDDDDDE ", " ESSDSSE ", " E     E ", "         ", "         ", 'E', InfinityItems.existence, 'C', InfinityItems.realityCristal, 'D', InfinityItems.star_core, 'S', InfinityItems.star);
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_apple), "EEEEEEEEE", "EEEEEEEEE", "EEEEEEEEE", "EEEAAAEEE", "EEEAAAEEE", "EEEAAAEEE", "EEEEEEEEE", "EEEEEEEEE", "EEEEEEEEE", 'E', InfinityItems.star, 'A', new ItemStack(Items.golden_apple, 1, 1));
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(InfinityItems.infinity_bow), "    SL   ", "   S L   ", "  D  L   ", " D   L   ", "C    B   ", " D   L   ", "  D  L   ", "   S L   ", "    SL   ", 'S', InfinityItems.existence, 'L', Blocks.wool, 'C', InfinityItems.realityCristal, 'D', InfinityItems.star_core, 'B', InfinityBlocks.star);
    }
}
