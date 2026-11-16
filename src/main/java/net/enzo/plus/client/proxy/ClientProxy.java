package net.enzo.plus.client.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.enzo.plus.client.render.*;
import net.enzo.plus.common.blocks.BlockInfinityChest;
import net.enzo.plus.common.entities.EntityHellArrow;
import net.enzo.plus.common.entities.EntityHellSubArrow;
import net.enzo.plus.common.item.InfinityItems;
import net.enzo.plus.common.proxy.CommonProxy;
import net.enzo.plus.common.tiles.TileInfinityChest;
import net.enzo.plus.common.tiles.TileInfinityChestRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
    @Override
    public void before() {
        super.before();

    }

    @Override
    public void mid() {
        // Hell Arrow Render.
        /**************************************************************/

        RenderHellArrow hellIscoming = new RenderHellArrow();
        RenderingRegistry.registerEntityRenderingHandler(EntityHellArrow.class, hellIscoming);
        RenderingRegistry.registerEntityRenderingHandler(EntityHellSubArrow.class, hellIscoming);

        /**************************************************************/
        // Megumin Shader Renders.
        /**************************************************************/

        MeguminItemRenderer explosion = new MeguminItemRenderer();
        MinecraftForgeClient.registerItemRenderer(InfinityItems.infinity_sword, explosion);

        /**************************************************************/
        // Tiles.
        /**************************************************************/

        ClientRegistry.bindTileEntitySpecialRenderer(TileInfinityChest.class, new TileInfinityChestRenderer());

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockInfinityChest.instance), new InfinityChestRenderItem());

        /**************************************************************/
        // Misc.
        /**************************************************************/

        UniversalRenderEvents explosionevents = new UniversalRenderEvents();
        MinecraftForge.EVENT_BUS.register(explosionevents);
        FMLCommonHandler.instance().bus().register(explosionevents);

        ShaderHelper.initShaders();
    }

    @Override
    public void after() {

    }
}
