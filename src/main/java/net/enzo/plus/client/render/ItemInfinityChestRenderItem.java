package net.enzo.plus.client.render;

import net.enzo.plus.Static;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemInfinityChestRenderItem implements IItemRenderer {
    protected ModelBase blockModel;
    protected ResourceLocation blockTexture;
    TileEntitySpecialRenderer render;
    private TileEntity entity;

    public ItemInfinityChestRenderItem(TileEntitySpecialRenderer render, TileEntity entity){
        blockModel = new ModelChest();
        blockTexture = new ResourceLocation(Static.MODID + ":" + "textures/blocks/infinity_chest_work.png");
        this.entity = entity;
        this.render = render;

    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch (type) {
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
            case ENTITY:
            case INVENTORY:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        switch (type) {
            case ENTITY: {
                return false;
            }
            case EQUIPPED: {
                return false;
            }
            case EQUIPPED_FIRST_PERSON: {
                return false;
            }
            case INVENTORY:// this case statement is required to get an inventory texture
            {
                return helper == ItemRendererHelper.INVENTORY_BLOCK;
            }
            default: {
                return false;
            }
        }
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();
                // rotates the item
                GL11.glRotatef(0, 0, 0, 1);
                GL11.glRotatef(0, 0, 1, 0);
                GL11.glRotatef(00, 1, 0, 0);
                GL11.glTranslatef(0.5f, 0.90f,0.3f);
                GL11.glScalef(-2F, -2F, -2F);
                Minecraft.getMinecraft().renderEngine
                        .bindTexture(this.blockTexture);
                // renders the item
                blockModel.render((Entity) data[1], 0.0f, 0.0f, 0.0f, 0.0f,
                        0.0f, 0.0225f);
                GL11.glPopMatrix();

            default:
                break;
            // Renders the Campfire on ground as a pickable item
        }
        switch (type) {
            case ENTITY:

                GL11.glPushMatrix();
                // rotates the item and translates the item
                GL11.glRotatef(0, 0, 0, 1);
                GL11.glRotatef(180, 0, 1, 0);
                GL11.glRotatef(180, 1, 0, 0);
                GL11.glTranslatef(0, -2.95f, 0f);
                GL11.glScalef(6F, 6F, 6F);
                Minecraft.getMinecraft().renderEngine
                        .bindTexture(this.blockTexture);
                // renders the item
                blockModel.render((Entity) data[1], 0.0f, 0.0f, 0.0f, 0.0f,
                        0.0f, 0.0225f);
                GL11.glPopMatrix();
            default:
                break;
        }
        switch (type) {
            case INVENTORY:

                GL11.glPushMatrix();
                // rotates the item and translates the item
                GL11.glRotatef(0, 0, 0, 1);
                GL11.glRotatef(45, 0, 1, 0);
                GL11.glRotatef(10, 1, 0, 0);
                GL11.glTranslatef(0f, -2.2f, 0f);
                GL11.glScalef(4.2F, 4.2F, 4.2F);
                Minecraft.getMinecraft().renderEngine
                        .bindTexture(this.blockTexture);
                // renders the item
                blockModel.render(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0225f);
                GL11.glPopMatrix();
            default:
                break;
        }

    }
    protected ResourceLocation getEntityTexture(Entity Campfire) {
        return this.blockTexture;
    }
}
