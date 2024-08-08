package net.enzo.plus.common.compat.minetweaker;

import minetweaker.IUndoableAction;
import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.oredict.IOreDictEntry;
import net.enzo.plus.common.crafting.AbsoluteCraftingManager;
import net.enzo.plus.common.crafting.AbsoluteCraftingShapedOre;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.plus.AbsoluteCrafting")
public class AbsoluteCrafting {
    @ZenMethod
    public static void addShapeless(IItemStack output, IIngredient[] ingredients){

        MineTweakerAPI.apply(new Add(new ShapelessOreRecipe(toStack(output), toObjects(ingredients))));
    }

    @ZenMethod
    public static void addShaped(IItemStack output, IIngredient[][] ingredients){
        int height = ingredients.length;
        int width = 0;
        for(IIngredient[] row : ingredients){
            if(width < row.length)
                width = row.length;
        }
        Object[] input = new Object[width * height];
        int x = 0;
        for(IIngredient[] row : ingredients){
            for(IIngredient ingredient : row){
                input[x++] = toActualObject(ingredient);
            }
        }

        MineTweakerAPI.apply(new Add(new AbsoluteCraftingShapedOre(toStack(output), input, width, height)));
    }


    @ZenMethod
    public static void remove(IItemStack target){
        MineTweakerAPI.apply(new Remove(toStack(target)));
    }

    private static class Add implements IUndoableAction {
        IRecipe recipe;

        public Add(IRecipe add){
            recipe = add;
        }

        @Override
        public void apply(){

            AbsoluteCraftingManager.getInstance().getRecipeList().add(recipe);
        }

        @Override
        public boolean canUndo(){
            return true;
        }

        @Override
        public void undo(){
            AbsoluteCraftingManager.getInstance().getRecipeList().remove(recipe);
        }

        @Override
        public String describe(){
            return "Adding Absolute Crafting Recipe for " + recipe.getRecipeOutput().getDisplayName();
        }

        @Override
        public String describeUndo(){
            return "Un-adding Absolute Crafting Recipe for " + recipe.getRecipeOutput().getDisplayName();
        }

        @Override
        public Object getOverrideKey() {
            return null;
        }

    }

    private static class Remove implements IUndoableAction {
        IRecipe recipe = null;
        ItemStack remove;

        public Remove(ItemStack rem){
            remove = rem;
        }

        @Override
        public void apply(){

            for(Object obj : AbsoluteCraftingManager.getInstance().getRecipeList()){
                if(obj instanceof IRecipe){
                    IRecipe craft = (IRecipe)obj;
                    if(craft.getRecipeOutput().isItemEqual(remove)) {
                        recipe = craft;
                        AbsoluteCraftingManager.getInstance().getRecipeList().remove(obj);
                        break;
                    }
                }
            }
        }

        @Override
        public boolean canUndo(){
            return recipe != null;
        }

        @Override
        public void undo(){
            AbsoluteCraftingManager.getInstance().getRecipeList().add(recipe);
        }

        @Override
        public String describe(){
            return "Removing Absolute Crafting Recipe for " + remove.getDisplayName();
        }

        @Override
        public String describeUndo(){
            return "Un-removing Absolute Crafting Recipe for " + remove.getDisplayName();
        }

        @Override
        public Object getOverrideKey() {
            return null;
        }

    }

    private static ItemStack toStack(IItemStack item){
        if (item == null) return null;
        else {
            Object internal = item.getInternal();
            if (internal == null || !(internal instanceof ItemStack)) {
                MineTweakerAPI.getLogger().logError("Not a valid item stack: " + item);
            }
            return (ItemStack) internal;
        }
    }

    private static Object toObject(IIngredient ingredient){
        if (ingredient == null) return null;
        else {
            if (ingredient instanceof IOreDictEntry) {
                return toString((IOreDictEntry)ingredient);
            } else if (ingredient instanceof IItemStack) {
                return toStack((IItemStack) ingredient);
            } else return null;
        }
    }

    private static Object[] toObjects(IIngredient[] list){
        if(list == null)
            return null;
        Object[] ingredients = new Object[list.length];
        for(int x = 0;x < list.length;x++){
            ingredients[x] = toObject(list[x]);
        }
        return ingredients;
    }

    private static Object toActualObject(IIngredient ingredient){
        if (ingredient == null) return null;
        else {
            if (ingredient instanceof IOreDictEntry) {
                return OreDictionary.getOres(toString((IOreDictEntry) ingredient));
            } else if (ingredient instanceof IItemStack) {
                return toStack((IItemStack) ingredient);
            } else return null;
        }
    }

    private static String toString(IOreDictEntry entry) {
        return ((IOreDictEntry) entry).getName();
    }

}
