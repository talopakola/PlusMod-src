package net.enzo.plus.client.render;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.TextureStitchEvent;

public class UniversalRenderEvents {
    private static final int cosmicCount = 12;
    public static String[] cosmicTextures = new String[cosmicCount];

    static {
        for (int i=0; i<cosmicCount; i++) {
            cosmicTextures[i] = "plus:misc/cosmic"+i;
        }
    }

    public static FloatBuffer cosmicUVs = BufferUtils.createFloatBuffer(4 * cosmicTextures.length);
    public static IIcon[] cosmicIcons = new IIcon[cosmicTextures.length];

    @SubscribeEvent
    public void letsMakeAQuilt(TextureStitchEvent.Pre event) {
        if (event.map.getTextureType() != 1) { return; }

        for (int i=0; i<cosmicTextures.length; i++) {
            IIcon icon = event.map.registerIcon(cosmicTextures[i]);
            cosmicIcons[i] = icon;
        }
    }

    @SubscribeEvent
    public void weMadeAQuilt(TextureStitchEvent.Post event) {
        if (event.map.getTextureType() != 1) { return; }

        MeguminRenderShenanigans.bindItemTexture();
    }

    @SubscribeEvent
    public void pushTheCosmicFancinessToTheLimit(RenderTickEvent event) {
        if (event.phase == Phase.START) {
            cosmicUVs = BufferUtils.createFloatBuffer(4 * cosmicIcons.length);
            IIcon icon;
            for (int i=0; i<cosmicIcons.length; i++) {
                icon = cosmicIcons[i];

                cosmicUVs.put(icon.getMinU());
                cosmicUVs.put(icon.getMinV());
                cosmicUVs.put(icon.getMaxU());
                cosmicUVs.put(icon.getMaxV());
            }
            cosmicUVs.flip();
        }
    }

    @SubscribeEvent
    public void makeCosmicStuffLessDumbInGUIs(GuiScreenEvent.DrawScreenEvent.Pre event) {
        MeguminRenderShenanigans.inventoryRender = true;
    }

    @SubscribeEvent
    public void finishMakingCosmicStuffLessDumbInGUIs(GuiScreenEvent.DrawScreenEvent.Post event) {
        MeguminRenderShenanigans.inventoryRender = false;
    }
}
