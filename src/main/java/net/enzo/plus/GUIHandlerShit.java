package net.enzo.plus;

import cpw.mods.fml.common.network.IGuiHandler;
import net.enzo.plus.client.gui.GUIAbsoluteCraftingTable;
import net.enzo.plus.client.gui.GUIInfinityChest;
import net.enzo.plus.common.container.ContainerAbsoluteCraftingTable;
import net.enzo.plus.common.container.ContainerInfinityChest;
import net.enzo.plus.common.tiles.TileAbsoluteCraftingTable;
import net.enzo.plus.common.tiles.TileInfinityChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GUIHandlerShit implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0) // A FUCKING ERROR IS JUST BY SWITCHING SERVER WITH GUI
            return new ContainerAbsoluteCraftingTable(player.inventory, world, x, y, z, (TileAbsoluteCraftingTable)world.getTileEntity(x,y,z));
        if (ID == 1)
            return new ContainerInfinityChest(player.inventory, (TileInfinityChest)world.getTileEntity(x,y,z));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0)
            return new GUIAbsoluteCraftingTable(player.inventory, world, x, y, z, (TileAbsoluteCraftingTable)world.getTileEntity(x,y,z));
        if (ID == 1)
            return new GUIInfinityChest(player.inventory, world, x, y, z, (TileInfinityChest)world.getTileEntity(x, y, z));
        return null;
    }
}
