package net.enzo.plus.common.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class InfinityBlocks {
    public static Block absolute;
    public static Block mixedBlock;
    public static Block star;

    public static void consumeUniverse() {
        absolute = GameRegistry.registerBlock(new BlockAbsoluteCraftingTable(), "absolute_craft");

        mixedBlock = GameRegistry.registerBlock(new BlockMixedBlock(), "mixed_block");
        //absolute = GameRegistry.registerBlock(new BlockStarCore(), "tile_star_core"); bruh
        star = GameRegistry.registerBlock(new BlockStarCore(), "tile_star_core");
    }
}
