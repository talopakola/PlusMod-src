package net.enzo.plus;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.enzo.plus.client.render.ItemInfinityChestRenderItem;
import net.enzo.plus.common.Config;
import net.enzo.plus.common.PotionHelper;
import net.enzo.plus.common.blocks.InfinityBlocks;
import net.enzo.plus.common.compat.Compat;
import net.enzo.plus.common.entities.InfinityEntitites;
import net.enzo.plus.common.gui.GUIHandlerShit;
import net.enzo.plus.common.item.InfinityItems;
import net.enzo.plus.common.misc.MakeTheThings;
import net.enzo.plus.common.proxy.CommonProxy;
import net.enzo.plus.common.tiles.TileInfinityChest;
import net.enzo.plus.common.tiles.TileInfinityChestRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Static.MODID, version = Static.VERSION)
public class PlusMod
{
    @SidedProxy(serverSide = Static.COMMON, clientSide = Static.CLIENT)
    public static CommonProxy proxy;

    @Instance
    public static PlusMod instance;

    public static CreativeTabs tab = new CreativeTabs("plus") {
        @Override
        public Item getTabIconItem() {
            return InfinityItems.realityCristal;
        }
    };

    @EventHandler
    public void earlyNightmare(FMLPreInitializationEvent event)
    {
        instance = this;
        Config.letsConfigurate(event.getSuggestedConfigurationFile());
        InfinityItems.letsRegisterEmAll();
        InfinityBlocks.consumeUniverse();
        Compat.compatible();
        InfinityEntitites.consumeTheLive();
        proxy.before();
    }

    @EventHandler
    public void midNightmare(FMLInitializationEvent event)
    {
        TileInfinityChestRenderer render1 = new TileInfinityChestRenderer();
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(InfinityBlocks.coke), new ItemInfinityChestRenderItem(render1, new TileInfinityChest()));
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandlerShit());
        MakeTheThings.makeAll();
        MinecraftForge.EVENT_BUS.register(new UniversalEvents());
        proxy.mid();
    }

    @EventHandler
    public void postNightmare(FMLPostInitializationEvent event)
    {
        Compat.loadIt();
        PotionHelper.healthInspection();
        proxy.after();
    }
}
