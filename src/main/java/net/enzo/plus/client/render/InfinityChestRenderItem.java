package net.enzo.plus.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.enzo.plus.common.tiles.TileInfinityChest;
import net.enzo.plus.common.tiles.TileInfinityChestRenderer;
import net.minecraft.client.model.ModelChest;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class InfinityChestRenderItem implements IItemRenderer {
    private static final TileInfinityChest tileEntityInfinityChest = new TileInfinityChest();
    ModelChest model = new ModelChest();

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
            TileInfinityChestRenderer.instance.renderTileEntityAt(tileEntityInfinityChest, -0.5F, -0.5F, -0.5F, 0);
    }
}
