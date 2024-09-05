package net.enzo.plus.common.item.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemInfinityApple extends ItemFood {
    public ItemInfinityApple(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
        super(p_i45339_1_, p_i45339_2_, p_i45339_3_);

        setMaxStackSize(0x7EEEEEEE);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean idk) {
        tooltip.add(EnumChatFormatting.DARK_GRAY + "" +EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip.Infinity_Apple.desc"));

        super.addInformation(stack, player, tooltip, idk);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1728000, 10));
        player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1728000, 10));
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1728000, 10));
        player.addPotionEffect(new PotionEffect(Potion.heal.id, 1728000, 10));
        player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1728000, 10));
        player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 1728000, 10));
        stack.stackSize++;
        // For some weird reason, absorption are obfuscated, lol.

        super.onFoodEaten(stack, world, player);
    }
}
