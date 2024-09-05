package net.enzo.plus.common.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.enzo.plus.common.Config;
import net.enzo.plus.common.item.util.ItemBlockReality;
import net.enzo.plus.common.tiles.TileAbsoluteCraftingTable;
import net.enzo.plus.common.tiles.TileInfinityChest;
import net.minecraft.block.Block;

public class InfinityBlocks {
    public static Block absolute;
    public static Block mixedBlock;
    public static Block star;
    public static Block reality;
    public static Block coke;
    public static Block comp;

    public static void consumeUniverse() {
        absolute = GameRegistry.registerBlock(new BlockAbsoluteCraftingTable(), "absolute_craft");
        mixedBlock = GameRegistry.registerBlock(new BlockMixedBlock(), "mixed_block");
        //absolute = GameRegistry.registerBlock(new BlockStarCore(), "tile_star_core"); bruh
        star = GameRegistry.registerBlock(new BlockStarCore(), "tile_star_core");
        reality = GameRegistry.registerBlock(BlockReality.instance, ItemBlockReality.class, "Block_Reality");
        if (Config.craftOnly)
            return;

        coke = GameRegistry.registerBlock(new BlockInfinityChest(), "Infinity_Chest");
        //comp = GameRegistry.registerBlock(new BlockCompressor(), "Plus_Compressor");
        // I gave up to try to do this, it simply crashes independent what I do.
        // I'm almost making a pact with the devil just to make this SHIT works
        GameRegistry.registerTileEntity(TileAbsoluteCraftingTable.class, "Plus_Absolute_Crafting");
        GameRegistry.registerTileEntity(TileInfinityChest.class, "Plus_Tile_Entity");
        //GameRegistry.registerTileEntity(TileCompressor.class, "Tile_Compressor_Entity");
        /*7377577274 bugs solved just registering the tile entities...
        * WHY I'M SO STUPID, WHY GOD, ANSWER ME, I SWEAR, WHY I'M SO FUCKING DUMB?????
        * */
    }
}
