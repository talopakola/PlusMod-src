package net.enzo.plus.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTest extends Item {
    // Debug item, ignore it.
    public ItemTest() {
        this.setUnlocalizedName("itemTest");
        this.setTextureName("plus:itemTest");
        //this.setCreativeTab(CreativeTabs.tabMisc);
    }
}
