package net.enzo.plus.client.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.enzo.plus.client.render.InfinityChestRenderItem;
import net.enzo.plus.client.render.RenderHellArrow;
import net.enzo.plus.common.blocks.BlockInfintiyChest;
import net.enzo.plus.common.entities.EntityHellArrow;
import net.enzo.plus.common.entities.EntityHellSubArrow;
import net.enzo.plus.common.proxy.CommonProxy;
import net.enzo.plus.common.tiles.TileInfinityChest;
import net.enzo.plus.common.tiles.TileInfinityChestRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    @Override
    public void before() {
        super.before();

    }

    @Override
    public void mid() {
        RenderHellArrow hellIscoming = new RenderHellArrow();
        RenderingRegistry.registerEntityRenderingHandler(EntityHellArrow.class, hellIscoming);
        RenderingRegistry.registerEntityRenderingHandler(EntityHellSubArrow.class, hellIscoming);
       /*
        * TileInfinityChestRenderer r = new TileInfinityChestRenderer();
        * RenderingRegistry.registerBlockHandler(99203, (ISimpleBlockRenderingHandler) r);
        */
    }

    @Override
    public void after() {

    }
}
