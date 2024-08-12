package net.enzo.plus.common.achievements;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.*;
import net.enzo.plus.common.Config;
import net.enzo.plus.common.blocks.InfinityBlocks;
import net.enzo.plus.common.compat.Compat;
import net.enzo.plus.common.item.InfinityItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.event.world.BlockEvent.*;

public class AchievementsTriggerInfinity {
    @SubscribeEvent
    public void onItemCrafted(ItemCraftedEvent event) {
        if (event.crafting != null) {
            if (event.crafting.getItem() == InfinityItems.mixed) {
                event.player.addStat(Achievements.mixed, 1);
            }
            if (event.crafting.getItem() == InfinityItems.star) {
                event.player.addStat(Achievements.star, 1);
            }
            if (event.crafting.getItem() == Item.getItemFromBlock(InfinityBlocks.absolute)) {
                event.player.addStat(Achievements.abs, 1);
            }
            if (event.crafting.getItem() == InfinityItems.star_core) {
                event.player.addStat(Achievements.core, 1);
            }
            if (event.crafting.getItem() == Item.getItemFromBlock(InfinityBlocks.coke)) {
                event.player.addStat(Achievements.coke, 1);
            }
            if (event.crafting.getItem() == InfinityItems.realityCristal) {
                event.player.addStat(Achievements.reality, 1);
            }
            if (event.crafting.getItem() == InfinityItems.existence) {
                event.player.addStat(Achievements.existence, 1);
            }
            if (event.crafting.getItem() == InfinityItems.infinity_apple) {
                event.player.addStat(Achievements.apple, 1);
            }
            if (event.crafting.getItem() == InfinityItems.infinity_banana && Compat.father && Config.father) {
                event.player.addStat(Achievements.banana, 1);
            }
        }
    }

    @SubscribeEvent
    public void onPick(ItemPickupEvent event) {
        if (event.pickedUp.getEntityItem().isItemEqual(new ItemStack(Item.getItemFromBlock(Blocks.bedrock))) && event.player != null) {
            //event.player.addStat(Achievements.bedrock, 1);
            // HIHI HA
        }
    }
}
