package net.enzo.plus.common.item.tools;

import net.enzo.plus.PlusMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemInfinityBow extends Item {
    private IIcon[] iconArray;
    public ItemInfinityBow() {
        this.maxStackSize = 1;
        this.setMaxDamage(9999);
        this.setUnlocalizedName("infinity_bow");
        this.setTextureName("plus:infinity_bow_standby");
        this.setCreativeTab(PlusMod.tab);
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }
}
