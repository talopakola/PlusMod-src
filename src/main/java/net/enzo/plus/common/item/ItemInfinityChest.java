package net.enzo.plus.common.item;

import net.enzo.plus.common.blocks.BlockInfintiyChest;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemInfinityChest extends ItemBlock {
    public ItemInfinityChest(Block bl) {
        super(BlockInfintiyChest.instance);
        setUnlocalizedName("tile.infinity_chest.name");
        setMaxDamage(0);
    }
}
