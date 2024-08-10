package net.enzo.plus.common.compat.nei;

import codechicken.lib.gui.GuiDraw;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.ShapelessRecipeHandler;
import net.enzo.plus.common.crafting.AbsoluteCraftingManager;
import net.enzo.plus.common.crafting.AbsoluteCraftingShapeless;
import net.enzo.plus.client.gui.GUIAbsoluteCraftingTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbsoluteShapelessRecipeHandler extends ShapelessRecipeHandler {
    public class CachedExtremeShapelessRecipe extends CachedRecipe
    {
        public CachedExtremeShapelessRecipe() {
            ingredients = new ArrayList<PositionedStack>();
        }

        public CachedExtremeShapelessRecipe(ItemStack output) {
            this();
            setResult(output);
        }

        public CachedExtremeShapelessRecipe(Object[] input, ItemStack output) {
            this(Arrays.asList(input), output);
        }

        public CachedExtremeShapelessRecipe(List<?> input, ItemStack output) {
            this(output);
            setIngredients(input);
        }

        public void setIngredients(List<?> items) {
            ingredients.clear();
            for (int ingred = 0; ingred < items.size(); ingred++) {
                int ex = 3 + (ingred % 9) * 18;
                int wy = 3 + (ingred / 9) * 18;
                if(wy == 129){
                    if(ex == 3 || ex == 129)
                        ex -= 1;
                    else if(ex == 21 || ex == 147)
                        ex += 1;
                }
                PositionedStack stack = new PositionedStack(items.get(ingred), ex, wy);
                stack.setMaxSize(1);
                ingredients.add(stack);
            }
        }

        public void setResult(ItemStack output) {
            result = new PositionedStack(output, 201, 75);
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return getCycledIngredients(cycleticks / 20, ingredients);
        }

        @Override
        public PositionedStack getResult() {
            return result;
        }

        public ArrayList<PositionedStack> ingredients;
        public PositionedStack result;
    }

    public String getRecipeName() {
        return StatCollector.translateToLocal("crafting.abs.shapeless");
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals("abs") && getClass() == AbsoluteShapelessRecipeHandler.class) {
            List<IRecipe> allrecipes = AbsoluteCraftingManager.getInstance().getRecipeList();
            for (IRecipe irecipe : allrecipes) {
                CachedExtremeShapelessRecipe recipe = null;
                if (irecipe instanceof AbsoluteCraftingShapeless)
                    recipe = shapelessRecipe((AbsoluteCraftingShapeless) irecipe);

                if (recipe == null)
                    continue;

                arecipes.add(recipe);
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        List<IRecipe> allrecipes = AbsoluteCraftingManager.getInstance().getRecipeList();
        for (IRecipe irecipe : allrecipes) {
            if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getRecipeOutput(), result)) {
                CachedExtremeShapelessRecipe recipe = null;
                if (irecipe instanceof AbsoluteCraftingShapeless)
                    recipe = shapelessRecipe((AbsoluteCraftingShapeless) irecipe);

                if (recipe == null)
                    continue;

                arecipes.add(recipe);
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        List<IRecipe> allrecipes = AbsoluteCraftingManager.getInstance().getRecipeList();
        for (IRecipe irecipe : allrecipes) {
            CachedExtremeShapelessRecipe recipe = null;
            if (irecipe instanceof AbsoluteCraftingShapeless)
                recipe = shapelessRecipe((AbsoluteCraftingShapeless) irecipe);

            if (recipe == null)
                continue;

            if (recipe.contains(recipe.ingredients, ingredient)) {
                recipe.setIngredientPermutation(recipe.ingredients, ingredient);
                arecipes.add(recipe);
            }
        }
    }

    private CachedExtremeShapelessRecipe shapelessRecipe(AbsoluteCraftingShapeless recipe) {
        if(recipe.recipeItems == null) //because some mod subclasses actually do this
            return null;

        return new CachedExtremeShapelessRecipe(recipe.recipeItems, recipe.getRecipeOutput());
    }
    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(166, 74, 24, 18), "abs"));
    }

    @Override
    public String getOverlayIdentifier() {
        return "abs";
    }

    @Override
    public String getGuiTexture()
    {
        return "avaritia:textures/gui/extreme_nei.png";
    }

    @Override
    public void drawBackground(int recipe)
    {
        GL11.glColor4f(1, 1, 1, 1);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GuiDraw.changeTexture(getGuiTexture());
        GuiDraw.drawTexturedModalRect(-9, -20, 0, 0, 256, 208);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glDisable(GL11.GL_BLEND);
    }

    @Override
    public int recipiesPerPage()
    {
        return 1;
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass()
    {
        return GUIAbsoluteCraftingTable.class;
    }

}
