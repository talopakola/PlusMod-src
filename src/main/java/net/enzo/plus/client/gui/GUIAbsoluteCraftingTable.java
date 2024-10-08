package net.enzo.plus.client.gui;

import net.enzo.plus.common.container.ContainerAbsoluteCraftingTable;
import net.enzo.plus.common.tiles.TileAbsoluteCraftingTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

//AbsoluteCraftingTable
public class GUIAbsoluteCraftingTable extends GuiContainer {
    private static final ResourceLocation tex = new ResourceLocation("plus:textures/gui/abs_crafting_gui.png");

    public GUIAbsoluteCraftingTable(InventoryPlayer par1InventoryPlayer, World par2World, int x, int y, int z, TileAbsoluteCraftingTable table)
    {
        super(new ContainerAbsoluteCraftingTable(par1InventoryPlayer, par2World, x, y, z, table));
        this.ySize = 256;
        this.xSize = 238;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(tex);
        int foo = (this.width - this.xSize) / 2;
        int bar = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(foo, bar, 0, 0, this.ySize, this.ySize);
    }
}
