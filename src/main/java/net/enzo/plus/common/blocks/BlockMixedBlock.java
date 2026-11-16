package net.enzo.plus.common.blocks;

import net.enzo.plus.PlusMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockMixedBlock extends Block {

    protected BlockMixedBlock() {
        super(Material.iron);
        setBlockName("mixed_block");
        setBlockTextureName("plus:mixed_block");
        setResistance(100F);
        setHardness(13.543F);
        setHarvestLevel("pickaxe", 3);
        setCreativeTab(PlusMod.tab);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
        return true;
    }
}
