package net.enzo.plus.common.item.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.enzo.plus.PlusMod;
import net.enzo.plus.common.entities.EntityImmortalItem;
import net.enzo.plus.common.item.InfinityItems;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInfinityAxe extends ItemAxe {
    private static final Item.ToolMaterial opAxe = EnumHelper.addToolMaterial("INFINITY_AXE", 9999, 9999, 999999F, 999.0F, 32);
    public ItemInfinityAxe() {
        super(opAxe);
        setUnlocalizedName("infinity_axe");
        setTextureName("plus:infinity_axe");
        setCreativeTab(PlusMod.tab);
        setMaxDamage(0);
    }


    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }

    @Override
    public boolean hasCustomEntity(ItemStack stack) {
        return true;
    }

    @Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        return new EntityImmortalItem(world, location, itemstack);
    }

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return InfinityItems.infinity;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack, int pass) {
        return false;
    }
}
