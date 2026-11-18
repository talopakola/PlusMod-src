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
    //public static Block comp;

    public static void consumeUniverse() {
        absolute = GameRegistry.registerBlock(new BlockAbsoluteCraftingTable(), "absolute_craft");
        mixedBlock = GameRegistry.registerBlock(new BlockMixedBlock(), "mixed_block");
        star = GameRegistry.registerBlock(new BlockStarCore(), "tile_star_core");
        reality = GameRegistry.registerBlock(BlockReality.instance, ItemBlockReality.class, "Block_Reality");

        GameRegistry.registerTileEntity(TileAbsoluteCraftingTable.class, "Plus_Absolute_Crafting");
        GameRegistry.registerTileEntity(TileInfinityChest.class, "Plus_Tile_Entity");
        if (Config.craftOnly)
            return;

        coke = GameRegistry.registerBlock(new BlockInfinityChest(), "Infinity_Chest");
    }
}
