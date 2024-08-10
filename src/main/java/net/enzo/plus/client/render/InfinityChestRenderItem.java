package net.enzo.plus.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.enzo.plus.common.tiles.TileInfinityChest;
import net.enzo.plus.common.tiles.TileInfinityChestRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

@SideOnly(Side.CLIENT)
public class InfinityChestRenderItem implements IItemRenderer {
    private static final TileInfinityChest tileEntityInfinityChest = new TileInfinityChest();

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

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        if (type == ItemRenderType.ENTITY)
            TileInfinityChestRenderer.instance.renderTileEntityAt(tileEntityInfinityChest, -0.5F, -0.5F, -0.5F, 0);
        else
            TileInfinityChestRenderer.instance.renderTileEntityAt(tileEntityInfinityChest, 0, 0, 0, 0);
    }
}
