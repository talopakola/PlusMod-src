package net.enzo.plus.common.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class InfinityBlocks {
    public static Block absolute;
    public static Block mixedBlock;
    public static Block star;
    public static Block reality;
    public static Block coke;

    public static void consumeUniverse() {
        absolute = GameRegistry.registerBlock(new BlockAbsoluteCraftingTable(), "absolute_craft");
        //coke = GameRegistry.registerBlock(new BlockInfintiyChest(), "Infinity_Chest");

        mixedBlock = GameRegistry.registerBlock(new BlockMixedBlock(), "mixed_block");
        //absolute = GameRegistry.registerBlock(new BlockStarCore(), "tile_star_core"); bruh
        star = GameRegistry.registerBlock(new BlockStarCore(), "tile_star_core");
        reality = GameRegistry.registerBlock(new BlockReality(), "Block_Reality");
    }
}
