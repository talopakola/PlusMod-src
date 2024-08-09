package net.enzo.plus.client.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.enzo.plus.client.render.RenderHellArrow;
import net.enzo.plus.common.entities.EntityHellArrow;
import net.enzo.plus.common.entities.EntityHellSubArrow;
import net.enzo.plus.common.proxy.CommonProxy;
import net.enzo.plus.common.tiles.TileInfinityChest;
import net.enzo.plus.common.tiles.TileInfinityChestRenderer;

public class ClientProxy extends CommonProxy {
    @Override
    public void before() {

    }

    @Override
    public void mid() {
        RenderHellArrow hellIscoming = new RenderHellArrow();
        RenderingRegistry.registerEntityRenderingHandler(EntityHellArrow.class, hellIscoming);
        RenderingRegistry.registerEntityRenderingHandler(EntityHellSubArrow.class, hellIscoming);

       /* TileInfinityChestRenderer r = new TileInfinityChestRenderer();
        RenderingRegistry.registerBlockHandler(99203, (ISimpleBlockRenderingHandler) r);*/
        ClientRegistry.bindTileEntitySpecialRenderer(TileInfinityChest.class, new TileInfinityChestRenderer());
    }

    @Override
    public void after() {

    }
}
