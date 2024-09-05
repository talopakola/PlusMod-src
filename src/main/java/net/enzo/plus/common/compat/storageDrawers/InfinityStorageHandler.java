package net.enzo.plus.common.compat.storageDrawers;

import com.jaquadro.minecraft.storagedrawers.core.ModItems;
import com.jaquadro.minecraft.storagedrawers.item.ItemUpgradeCreative;
import net.enzo.plus.common.blocks.InfinityBlocks;
import net.enzo.plus.common.crafting.AbsoluteCraftingManager;
import net.enzo.plus.common.item.InfinityItems;
import net.minecraft.item.ItemStack;

public class InfinityStorageHandler {
    public static void storageTheUniverse() {
        AbsoluteCraftingManager.getInstance().addRecipe(new ItemStack(ModItems.upgradeCreative), "    X    ", "   XXX   ", "  XDDDX  ", " CDDDDDC ", "CDDDBDDDC", " CDDDDDC ", "  XDDDX  ", "   XXX   ", "    X    ", 'X', InfinityItems.existence, 'D',new ItemStack(ModItems.upgrade, 1, 6), 'C', InfinityItems.realityCristal, 'B', InfinityBlocks.reality
        );
    }
}
