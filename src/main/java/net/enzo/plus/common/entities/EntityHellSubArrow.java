package net.enzo.plus.common.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

public class EntityHellSubArrow extends EntityArrow {
    //HDUIDGSUIAYDGSAIYGDSAUYDGSAUYDGAs
    public EntityHellSubArrow(World world, double x,	double y, double z) {
        super(world, x, y, z);
    }

    public EntityHellSubArrow(World world, EntityLivingBase entity, EntityLivingBase entity2, float something, float otherthing) {
        super(world, entity, entity2, something, otherthing);
    }

    public EntityHellSubArrow(World world, EntityLivingBase entity, float something) {
        super(world, entity, something);

    }

    public EntityHellSubArrow(World world) {
        super(world);
    }

    @Override
    public void onUpdate() {
        this.rotationPitch = 0;
        this.rotationYaw = 0;
        super.onUpdate();

        if (EntityHellArrow.getInGround(this) && EntityHellArrow.getTicksInGround(this) >= 20) {
            this.setDead();
        }
    }
}
