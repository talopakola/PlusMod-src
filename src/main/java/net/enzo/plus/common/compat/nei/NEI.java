package net.enzo.plus.common.compat.nei;

import codechicken.nei.api.API;
import net.minecraft.item.ItemStack;

public class NEI {
    public static void items() {
        AbsoluteShapedRecipeHandler shaped = new AbsoluteShapedRecipeHandler();
        AbsoluteShapelessRecipeHandler shapeless = new AbsoluteShapelessRecipeHandler();
        API.registerRecipeHandler(shaped);
        API.registerRecipeHandler(shapeless);
        API.registerUsageHandler(shaped);
        API.registerUsageHandler(shapeless);
    }

    public static void hide(ItemStack stack) {
        API.hideItem(stack);
    }
}
