package net.enzo.plus.client.container;

import net.enzo.plus.common.gui.ContainerInfinityChest;
import net.enzo.plus.common.tiles.TileInfinityChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GUIInfinityChest extends GuiContainer {
    private static final ResourceLocation tex = new ResourceLocation("plus:textures/gui/infinity_chest_gui_old.png");
    // Game can't use the 516 texture...
    // Oh, isn't 516, is 512... IDC will use 256x

    public GUIInfinityChest(InventoryPlayer par1InventoryPlayer, World par2World, int x, int y, int z, TileInfinityChest table)
    {
        super(new ContainerInfinityChest(par1InventoryPlayer, table));
        this.ySize = 256;
        this.xSize = 256;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int i, int j)
    {
        // Faz o L
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
