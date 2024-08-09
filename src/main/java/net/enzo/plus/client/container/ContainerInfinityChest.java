package net.enzo.plus.client.container;

import net.enzo.plus.common.tiles.TileInfinityChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerInfinityChest extends Container {
    private TileInfinityChest tc;

    public ContainerInfinityChest(InventoryPlayer player, TileInfinityChest tc) {
        addSlotToContainer(new Slot(tc, 0,13, 11));

        this.tc = tc;
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return false;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
        return null;
    }
}
