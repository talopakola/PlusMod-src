package net.enzo.plus.common.container.slot;

import net.enzo.plus.common.Config;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class InfinitySlot extends Slot {
    public InfinitySlot(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
        super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
    }

    @Override
    public int getSlotStackLimit() {
        return !Config.boringChest ? Integer.MAX_VALUE : 64; // Future boring chest config placeholder
    }
}
