package net.enzo.plus.common.compat.avaritia;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import fox.spiteful.avaritia.crafting.Grinder;
import fox.spiteful.avaritia.items.LudicrousItems;
import net.enzo.plus.common.blocks.InfinityBlocks;
import net.enzo.plus.common.item.InfinityItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AvaritiaCompat {
    public static void father() /*Father??*/ {
        Grinder.catalyst.getInput().add(new ItemStack(InfinityItems.mixed));
        Grinder.catalyst.getInput().add(new ItemStack(InfinityItems.star));
        Grinder.catalyst.getInput().add(new ItemStack(InfinityItems.star_core));

        ExtremeCraftingManager.getInstance().addShapelessRecipe(new ItemStack(InfinityItems.infinity_banana), new ItemStack(LudicrousItems.resource, 1, 2), new ItemStack(Blocks.pumpkin), new ItemStack(Blocks.pumpkin), new ItemStack(Blocks.cactus), new ItemStack(Blocks.cactus), new ItemStack(InfinityBlocks.mixedBlock), new ItemStack(InfinityBlocks.mixedBlock), new ItemStack(InfinityBlocks.star), new ItemStack(InfinityBlocks.star), new ItemStack(Items.fish), new ItemStack(Items.fish), new ItemStack(LudicrousItems.singularity, 1, 0), new ItemStack(LudicrousItems.singularity, 1, 1), new ItemStack(LudicrousItems.singularity, 1, 2), new ItemStack(LudicrousItems.singularity, 1, 3), new ItemStack(LudicrousItems.singularity, 1, 4));
    }
}
