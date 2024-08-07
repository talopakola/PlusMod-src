package net.enzo.plus.common.item.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.enzo.plus.PlusMod;
import net.enzo.plus.common.entities.EntityImmortalItem;
import net.enzo.plus.common.item.InfinityItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import java.util.List;

public class ItemInfinityPickaxe extends ItemPickaxe {
    private static final Item.ToolMaterial opPick = EnumHelper.addToolMaterial("INFINITY_PICKAXE", 9999, 9999, 999999F, 999.0F, 32);

    public ItemInfinityPickaxe() {
        super(opPick);
        setUnlocalizedName("infinity_pickaxe");
        setTextureName("plus:infinity_pickaxe");
        setCreativeTab(PlusMod.tab);
        setMaxDamage(0);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list) {
        ItemStack pick = new ItemStack(this);
        pick.addEnchantment(Enchantment.fortune, 20);
        list.add(pick);
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
