package net.enzo.plus.common.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.enzo.plus.common.tiles.TileAbsoluteCraftingTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GUIHandlerShit implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) // A FUCKING ERROR IS JUST BY I SWITCH SERVER WITH GUI
            return new ContainerAbsoluteCraftingTable(player.inventory, world, x, y, z, (TileAbsoluteCraftingTable)world.getTileEntity(x,y,z));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0)
            return new GUIAbsoluteCraftingTable(player.inventory, world, x, y, z, (TileAbsoluteCraftingTable)world.getTileEntity(x,y,z));
        return null;
    }
}
