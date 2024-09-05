package net.enzo.plus.common.item;

import net.enzo.plus.PlusMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemMixedIngot extends Item {
    public ItemMixedIngot() {
        this.setUnlocalizedName("mixed_ingot");
        this.setTextureName("plus:resources/mixed_ingot/mixed_ingot");
        this.setCreativeTab(PlusMod.tab); // Materials tab?
        // Is in Materials tab temporarily
    }
    @SuppressWarnings({"unchecked", "rawtypes"})  // WHY INTELLIJ?
    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List tooltip, boolean idk) {
        tooltip.add(EnumChatFormatting.DARK_GRAY + "" +EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip.mixed.desc"));
    }
}
