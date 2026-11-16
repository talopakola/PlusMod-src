package net.enzo.plus.common.item.util;

import net.enzo.plus.common.blocks.BlockReality;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemBlockReality extends ItemBlock {

    public ItemBlockReality(final Block block) {
        super(block);
    }

    @SuppressWarnings({"unchecked", "rawTypes"})
    @Override
    public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
        p_77624_3_.add(EnumChatFormatting.DARK_GRAY + "" +EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip.blockReality.desc"));

        super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
    }
}
