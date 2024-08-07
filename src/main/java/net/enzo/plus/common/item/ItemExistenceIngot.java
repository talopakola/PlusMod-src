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

public class ItemExistenceIngot extends Item {
    public ItemExistenceIngot() {
        setUnlocalizedName("existence_ingot");
        setTextureName("plus:existence_ingot");
        setCreativeTab(PlusMod.tab);
    }

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return InfinityItems.infinity; // Why?
    } // To balance from other mods or IDK why.

    @Override
    public String getItemStackDisplayName(ItemStack p_77653_1_) {
        return ColorsText.rainbow(StatCollector.translateToLocal("item.existence_ingot.name"));
    } // FABULOSO -Talopakola
    // Absolute cinema, tem como não -Davi

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List tooltip, boolean idk) {
        tooltip.add(EnumChatFormatting.ITALIC+""+EnumChatFormatting.GRAY+ StatCollector.translateToLocal("lore.existence.desc"));
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
