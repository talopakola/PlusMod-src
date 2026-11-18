package net.enzo.plus.common.blocks;

import net.enzo.plus.PlusMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockStarCore extends Block {
    public BlockStarCore() {
        super(Material.iron);
        setBlockName("tile_star_core");
        setBlockTextureName("plus:tile_star_core");
        setCreativeTab(PlusMod.tab);
        setHardness(15F);
        setResistance(15F);
        setHarvestLevel("pickaxe", 2);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
        return true;
    }
}
