package net.enzo.plus.common.blocks;

import net.enzo.plus.PlusMod;
import net.enzo.plus.Static;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Timer;
import java.util.TimerTask;

public class BlockReality extends Block {

    public static final BlockReality instance = new BlockReality();

    public BlockReality() {
        super(Material.iron);
        setBlockName("reality");
        setBlockTextureName("plus:reality");
        setHardness(13F);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(PlusMod.tab);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
        return true;
    }
}
