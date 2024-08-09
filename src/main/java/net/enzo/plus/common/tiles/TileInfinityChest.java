package net.enzo.plus.common.tiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TileInfinityChest extends TileInfinity implements IInventory, ISidedInventory {
    private ItemStack[] stackInv = new ItemStack[108];

    @Override
    public void readCustomNBT(NBTTagCompound tag) {
        for (int i = 0; i < stackInv.length; ++i) {
            stackInv[i] = ItemStack.loadItemStackFromNBT(tag.getCompoundTag("inv" + i));
        }
    }

    @Override
    public void writeCustomNBT(NBTTagCompound tag) {
        for (int x = 0; x < stackInv.length; ++x) {
            NBTTagCompound craft = new NBTTagCompound();
            stackInv[x].writeToNBT(craft);
            tag.setTag("inv" + x, craft);
        }
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[]{};
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return 108;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return stackInv[slot];
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {

    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return Integer.MAX_VALUE; // Oh, yeah
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return false;
    }
}
