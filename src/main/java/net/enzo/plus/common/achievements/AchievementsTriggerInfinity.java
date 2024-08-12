package net.enzo.plus.common.achievements;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.*;
import net.enzo.plus.common.Config;
import net.enzo.plus.common.blocks.InfinityBlocks;
import net.enzo.plus.common.compat.Compat;
import net.enzo.plus.common.item.InfinityItems;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;

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
            if (event.crafting.getItem() == InfinityItems.infinity_banana && Compat.father && Config.father) {
                event.player.addStat(Achievements.banana, 1);
            }
        }
    }
}
