package net.enzo.plus.client.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.enzo.plus.client.render.RenderHellArrow;
import net.enzo.plus.common.entities.EntityHellArrow;
import net.enzo.plus.common.entities.EntityHellSubArrow;
import net.enzo.plus.common.proxy.CommonProxy;

public class ClientProxy extends CommonProxy {
    @Override
    public void before() {

    }

    @Override
    public void mid() {
        RenderHellArrow hellIscoming = new RenderHellArrow();
        RenderingRegistry.registerEntityRenderingHandler(EntityHellArrow.class, hellIscoming);
        RenderingRegistry.registerEntityRenderingHandler(EntityHellSubArrow.class, hellIscoming);
    }

    @Override
    public void after() {

    }
}
