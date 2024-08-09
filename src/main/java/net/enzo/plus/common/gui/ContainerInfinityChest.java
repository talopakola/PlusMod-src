package net.enzo.plus.common.gui;

import net.enzo.plus.common.gui.slot.InfinitySlot;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerInfinityChest extends Container {
    private IInventory lowerChestInventory;
    private int numRows;
    public ContainerInfinityChest(InventoryPlayer p_i1806_1_, IInventory p_i1806_2_)
    {
        this.lowerChestInventory = p_i1806_2_;
        this.numRows = p_i1806_2_.getSizeInventory() / 13;
        p_i1806_2_.openInventory();
        int i = (this.numRows - 4) * 18;
        int j;
        int k;
        int g = 108;
        int toSkip = 19;
        int base = 11;
        int base2 = 46;

        for (int l = 0; l < 9; l++) {
            for (int m = 0; m < 13; m++) {
                this.addSlotToContainer(new InfinitySlot(p_i1806_2_, m + l * 13, 13 + m * 18, 11 + l * 18));
                // Ok, I think I can understand this math!
                // (Inventory, id[columns + rows * rows], X[X first slot + rows * 18], Y[Y first slot + columns * 18]
                // 18 is the pixel quantity for skip on every slot.
            }
        }

        for (int l = 0; l < 3; l++) {
            for (int m = 0; m < 9; m++) {
                this.addSlotToContainer(new Slot(p_i1806_1_, m + l * 9 + 9, 46 + m * 18, 176 + l * 18));
                // Ok, I think I can understand this math!
                // (Inventory, id[columns + rows * 9 + 9], X[X first slot + rows * 18], Y[Y first slot + columns * 18]
                // 18 is the pixel quantity for skip on every slot.
            }
        }

        for (int l = 0; l < 9; l++) {
            this.addSlotToContainer(new Slot(p_i1806_1_, l, 46 + l * 18, 234));
            // Ok, I think I can understand this math!
            // (Inventory, id[rows], X[X first slot + rows * 18], Y[Y first slot (don't have so much math here,
            // because is the fast 9 bar slots, and it has only 1 column)]
            // 18 is the pixel quantity for skip on every slot.
        }

        /*for (j = 0; j < 3; ++j)
        {
            for (k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(p_i1806_1_, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
            }
        }*/

        /*for (j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new Slot(p_i1806_1_, j, 8 + j * 18, 161 + i));
        }*/
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return this.lowerChestInventory.isUseableByPlayer(p_75145_1_);
    }

    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ < this.numRows * 13)
            {
                if (!this.mergeItemStack(itemstack1, this.numRows * 13, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 13, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);
        this.lowerChestInventory.closeInventory();
    }

    public IInventory getLowerChestInventory()
    {
        return this.lowerChestInventory;
    }
}