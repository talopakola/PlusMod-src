package net.enzo.plus.common.item;

import net.enzo.plus.PlusMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemStarIngot extends Item {
    public ItemStarIngot() {
        setUnlocalizedName("star_ingot");
        setTextureName("plus:star_ingot");
        setCreativeTab(PlusMod.tab);
    }

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return EnumRarity.rare;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List tooltip, boolean idk) {
        tooltip.add(EnumChatFormatting.DARK_GRAY + "" +EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip.star.desc"));
    }

    // Cool random function
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (player.isSneaking()) {
            player.worldObj.createExplosion(player, player.posX,player.posY,player.posZ, 10.0F, true);
        } else {
            player.setFire(Integer.MAX_VALUE);
        }
        return stack;
    }
}
