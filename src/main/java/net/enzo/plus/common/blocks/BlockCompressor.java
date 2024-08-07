package net.enzo.plus.common.blocks;

import net.enzo.plus.PlusMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCompressor extends Block {
    protected BlockCompressor() {
        super(Material.iron);
        setBlockName("compressor");
        setBlockTextureName("plus:compressor");
        setResistance(1000F);
        setHardness(13.543F);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(PlusMod.tab);
    }
}
