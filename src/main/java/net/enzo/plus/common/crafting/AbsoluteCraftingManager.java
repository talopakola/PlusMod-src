package net.enzo.plus.common.crafting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class AbsoluteCraftingManager {
    private static final AbsoluteCraftingManager instance = new AbsoluteCraftingManager();
    private List recipes = new ArrayList();

    public AbsoluteCraftingManager() {
    }

    public static final AbsoluteCraftingManager getInstance() {
        return instance;
    }

    public AbsoluteCraftingShaped addRecipe(ItemStack result, Object... recipe) {
        String s = "";
        int i = 0;
        int width = 0;
        int height = 0;
        if (recipe[i] instanceof String[]) {
            String[] astring = (String[])((String[])((String[])recipe[i++]));

            for(int l = 0; l < astring.length; ++l) {
                String s1 = astring[l];
                ++height;
                width = s1.length();
                s = s + s1;
            }
        } else {
            while(recipe[i] instanceof String) {
                String s2 = (String)recipe[i++];
                ++height;
                width = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;
        for(hashmap = new HashMap(); i < recipe.length; i += 2) {
            Character character = (Character)recipe[i];
            ItemStack itemstack1 = null;
            if (recipe[i + 1] instanceof Item) {
                itemstack1 = new ItemStack((Item)recipe[i + 1]);
            } else if (recipe[i + 1] instanceof Block) {
                itemstack1 = new ItemStack((Block)recipe[i + 1], 1, 32767);
            } else if (recipe[i + 1] instanceof ItemStack) {
                itemstack1 = (ItemStack)recipe[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] ingredients = new ItemStack[width * height];

        for(int i1 = 0; i1 < width * height; ++i1) {
            char c0 = s.charAt(i1);
            if (hashmap.containsKey(c0)) {
                ingredients[i1] = ((ItemStack)hashmap.get(c0)).copy();
            } else {
                ingredients[i1] = null;
            }
        }

        AbsoluteCraftingShaped shapedrecipes = new AbsoluteCraftingShaped(width, height, ingredients, result);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public AbsoluteCraftingShapedOre addExtremeShapedOreRecipe(ItemStack result, Object... recipe){
        AbsoluteCraftingShapedOre craft = new AbsoluteCraftingShapedOre(result, recipe);
        recipes.add(craft);
        return craft;
    }

    public AbsoluteCraftingShapeless addShapelessRecipe(ItemStack result, Object... ingredients) {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = ingredients;
        int i = ingredients.length;

        for(int j = 0; j < i; ++j) {
            Object object1 = aobject[j];
            if (object1 instanceof ItemStack) {
                arraylist.add(((ItemStack)object1).copy());
            } else if (object1 instanceof Item) {
                arraylist.add(new ItemStack((Item)object1));
            } else {
                if (!(object1 instanceof Block)) {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        AbsoluteCraftingShapeless recipe = new AbsoluteCraftingShapeless(result, arraylist);
        this.recipes.add(recipe);
        return recipe;
    }

    public ShapelessOreRecipe addShapelessOreRecipe(ItemStack result, Object ... ingredients){
        ShapelessOreRecipe recipe = new ShapelessOreRecipe(result, ingredients);
        recipes.add(recipe);
        return recipe;
    }

    public ItemStack findMatchingRecipe(InventoryCrafting matrix, World world) {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;

        int j;
        for(j = 0; j < matrix.getSizeInventory(); ++j) {
            ItemStack itemstack2 = matrix.getStackInSlot(j);
            if (itemstack2 != null) {
                if (i == 0) {
                    itemstack = itemstack2;
                }

                if (i == 1) {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable()) {
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;
            if (i1 < 0) {
                i1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        } else {
            for(j = 0; j < this.recipes.size(); ++j) {
                IRecipe irecipe = (IRecipe)this.recipes.get(j);
                if (irecipe.matches(matrix, world)) {
                    return irecipe.getCraftingResult(matrix);
                }
            }

            return null;
        }
    }

    public List getRecipeList() {
        return this.recipes;
    }
}
