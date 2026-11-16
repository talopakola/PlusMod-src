package net.enzo.plus.common.crafting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class AbsoluteCraftingShapeless implements IRecipe {
    private final ItemStack recipeOutput;
    public final List recipeItems;

    public AbsoluteCraftingShapeless(ItemStack result, List ingredients) {
        this.recipeOutput = result;
        this.recipeItems = ingredients;
    }

    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }

    public boolean matches(InventoryCrafting matrix, World world) {
        ArrayList arraylist = new ArrayList(this.recipeItems);

        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                ItemStack itemstack = matrix.getStackInRowAndColumn(j, i);
                if (itemstack != null) {
                    boolean flag = false;
                    Iterator iterator = arraylist.iterator();

                    while(iterator.hasNext()) {
                        ItemStack itemstack1 = (ItemStack)iterator.next();
                        if (itemstack.getItem() == itemstack1.getItem() && (itemstack1.getItemDamage() == 32767 || itemstack.getItemDamage() == itemstack1.getItemDamage()) && (!itemstack1.hasTagCompound() || ItemStack.areItemStackTagsEqual(itemstack1, itemstack))) {
                            flag = true;
                            arraylist.remove(itemstack1);
                            break;
                        }
                    }

                    if (!flag) {
                        return false;
                    }
                }
            }
        }

        return arraylist.isEmpty();
    }

    public ItemStack getCraftingResult(InventoryCrafting matrix) {
        return this.recipeOutput.copy();
    }

    public int getRecipeSize() {
        return this.recipeItems.size();
    }
}
