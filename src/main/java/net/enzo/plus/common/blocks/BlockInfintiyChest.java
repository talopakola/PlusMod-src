package net.enzo.plus.common.blocks;

import net.enzo.plus.PlusMod;
import net.enzo.plus.common.tiles.TileInfinityChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockInfintiyChest extends BlockContainer {

    protected BlockInfintiyChest() {
        super(Material.iron);
        setBlockName("infinity_chest");
        setBlockTextureName("plus:infinity_chest"); // Lol
        setCreativeTab(PlusMod.tab);
        setHardness(100F);
        setHarvestLevel("pickaxe", 2);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (!world.isRemote)
            player.openGui(PlusMod.instance, 1, world, x, y, z);

        return true;
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileInfinityChest();
    }
}
