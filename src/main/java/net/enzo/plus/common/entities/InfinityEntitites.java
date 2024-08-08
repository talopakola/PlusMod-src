package net.enzo.plus.common.entities;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.enzo.plus.PlusMod;

public class InfinityEntitites {
    public static void consumeTheLive() {
        EntityRegistry.registerModEntity(EntityHellArrow.class, "HellArrow", 1, PlusMod.instance, 32, 1, true);
        EntityRegistry.registerModEntity(EntityHellSubArrow.class, "SubHellArrow", 2, PlusMod.instance, 32, 2, true);
    }
}
