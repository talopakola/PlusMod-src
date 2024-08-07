package net.enzo.plus.common.item;

import net.enzo.plus.PlusMod;
import net.enzo.plus.client.ColorsText;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemStarIngot extends Item {
    public ItemStarIngot() {
        setUnlocalizedName("star_ingot");
        setTextureName("plus:star_ingot");
        setCreativeTab(PlusMod.tab);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List tooltip, boolean idk) {
        tooltip.add(EnumChatFormatting.ITALIC+""+EnumChatFormatting.GRAY+ StatCollector.translateToLocal("tooltip.star.desc"));
    }

    // Cool random function
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (player.isSneaking()) {
            entity.worldObj.createExplosion(entity, entity.posX,entity.posY,entity.posZ, 10.0F, true);
        } else {
            entity.setFire(Integer.MAX_VALUE);
        }

        return true;
    }
}
