package net.enzo.plus.common.item;

import net.enzo.plus.PlusMod;
import net.enzo.plus.client.InfinityText;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemStarCore extends Item {
    public ItemStarCore() {
        setUnlocalizedName("star_core");
        setTextureName("plus:star_core");
        setCreativeTab(PlusMod.tab);
    }

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return EnumRarity.epic;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List tooltip, boolean idk) {
        tooltip.add(EnumChatFormatting.DARK_GRAY + "" +EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip.star_core.desc") + " " + InfinityText.rainbow(StatCollector.translateToLocal("star.desc.color")));
    }
}
