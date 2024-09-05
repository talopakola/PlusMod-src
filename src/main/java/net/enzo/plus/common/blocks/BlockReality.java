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

    private Timer timer = new Timer();

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int wut, float wut2, float wut3, float wut4) {
        player.addChatMessage(new ChatComponentText("You think click it will explode? Lol"));
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //player.addChatMessage(new ChatComponentText("Test, test"));
                world.createExplosion(player, x, y,z, 83.0F, true);
            }
        }, 10000); // HEHEHEHE
        /*try {
            world.wait(10);
            world.createExplosion(player, x, y,z, 5.0F, false);
        } catch (InterruptedException e) {
            System.out.println("Ehhhhhhh, it didn't work bro");
            throw new RuntimeException(e);
        }*/

        return true;
    }
}
