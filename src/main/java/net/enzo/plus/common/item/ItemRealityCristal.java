package net.enzo.plus.common.item;

import net.enzo.plus.PlusMod;
import net.enzo.plus.client.ColorsText;
import net.enzo.plus.common.entities.EntityImmortalItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemRealityCristal extends Item {
    public ItemRealityCristal() {
        setUnlocalizedName("reality_cristal");
        setTextureName("plus:reality_cristal");
        setCreativeTab(PlusMod.tab);
    }

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return InfinityItems.infinity;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})  // WHY INTELLIJ?
    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List tooltip, boolean idk) {
        tooltip.add(EnumChatFormatting.ITALIC+""+EnumChatFormatting.GRAY+ ColorsText.rainbow(StatCollector.translateToLocal("tooltip.reality.desc")));
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        return new EntityImmortalItem(world, location, itemstack);
    }
}
