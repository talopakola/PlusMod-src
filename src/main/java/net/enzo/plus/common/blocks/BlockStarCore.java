package net.enzo.plus.common.blocks;

import net.enzo.plus.PlusMod;
import net.enzo.plus.common.item.InfinityItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

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
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(InfinityItems.star_core); // Hue Hue BR
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
        return true;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float idk2, float idk3, float idk4) {
        if (!player.isSneaking() && !world.isRemote){
            world.createExplosion(player, x, y, z, 10F, true); //Just to remember (Entity, x, y, z, explosion force, destroy blocks?)
        }

        return true;
    }
}
