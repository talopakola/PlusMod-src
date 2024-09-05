package net.enzo.plus.common.blocks;

import net.enzo.plus.PlusMod;
import net.enzo.plus.common.tiles.TileAbsoluteCraftingTable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

public class BlockAbsoluteCraftingTable extends BlockContainer {

    public static Random randy = new Random();
    protected BlockAbsoluteCraftingTable() {
        super(Material.iron);
        setHardness(15F);
        setResistance(Float.MAX_VALUE); // LOL
        setBlockName("absolute_craft");
        setBlockTextureName("plus:absolute_craft");
        setHarvestLevel("pickaxe", 3);
        setLightLevel(5F);
        setCreativeTab(PlusMod.tab);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (world.isRemote) {
            return true;
        } else {
            entityPlayer.openGui(PlusMod.instance, 0, world, x,y,z);
            return true;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileAbsoluteCraftingTable();
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int wut)
    {
        TileAbsoluteCraftingTable craft = (TileAbsoluteCraftingTable) world.getTileEntity(x, y, z);

        if (craft != null)
        {
            for(int i = 1;i < 82;i++) {
                ItemStack itemstack = craft.getStackInSlot(i);

                if (itemstack != null) {
                    float f = this.randy.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.randy.nextFloat() * 0.8F + 0.1F;
                    float f2 = this.randy.nextFloat() * 0.8F + 0.1F;

                    while (itemstack.stackSize > 0) {
                        int j1 = this.randy.nextInt(21) + 10;

                        if (j1 > itemstack.stackSize) {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                        if (itemstack.hasTagCompound()) {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
                        }

                        float f3 = 0.05F;
                        entityitem.motionX = (double) ((float) this.randy.nextGaussian() * f3);
                        entityitem.motionY = (double) ((float) this.randy.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double) ((float) this.randy.nextGaussian() * f3);
                        world.spawnEntityInWorld(entityitem);
                    }
                }

                world.func_147453_f(x, y, z, block);
            }
        }

        super.breakBlock(world, x, y, z, block, wut);
    }
}
