// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports
package net.enzo.plus.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelInfinityChest extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer top;
	private final ModelRenderer holder;

	@Deprecated
	public ModelInfinityChest() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -7.0F, -11.0F, -7.0F, 14, 11, 14, 0.0F));

		top = new ModelRenderer(this);
		top.setRotationPoint(0.0F, 24.0F, 0.0F);
		top.cubeList.add(new ModelBox(top, 0, 25, -7.0F, -14.0F, -7.0F, 14, 3, 14, 0.0F));

		holder = new ModelRenderer(this);
		holder.setRotationPoint(0.0F, 0.0F, 0.0F);
		top.addChild(holder);
		holder.cubeList.add(new ModelBox(holder, 0, 0, -1.0F, -12.0F, -9.0F, 2, 4, 2, 0.0F));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		top.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}