package net.enzo.plus.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.enzo.plus.PlusMod;
import net.enzo.plus.common.entities.EntityImmortalItem;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemNugget extends Item {
    // Created with same ID just because I'm too lazy to create new class for every item.
    // Fair enough.
    public static final String[] types = new String[]{"existence_nugget", "reality_nugget", "star_nugget", "mixed_nugget"};

    @SideOnly(Side.CLIENT)
    public IIcon[] icons;

    public ItemNugget() {
        setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setUnlocalizedName("plus_nugget");
        this.setCreativeTab(PlusMod.tab);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
        icons = new IIcon[types.length];

        for (int x = 0; x < types.length; x++) {
            icons[x] = ir.registerIcon("plus:" + types[x]);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int dam) {
        return this.icons[dam % icons.length];
    }

    @SuppressWarnings({"unchecked", "rawTypes"})
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean wut) {
        int meta = stack.getItemDamage();
        if (meta == 0) {
            tooltip.add(EnumChatFormatting.DARK_GRAY + "" + EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip.existence_nugget.desc"));
        }

        super.addInformation(stack, player, tooltip, wut);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int i = MathHelper.clamp_int(stack.getItemDamage(), 0, types.length);
        return super.getUnlocalizedName() + "." + types[i];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int j = 0; j < types.length; ++j) {
            list.add(new ItemStack(item, 1, j));
        }
    }

    @Override
    public boolean hasCustomEntity (ItemStack stack)
    {
        int meta = stack.getItemDamage();
        return meta == 0;
    }

    @Override
    public Entity createEntity (World world, Entity location, ItemStack itemstack)
    {
        int meta = itemstack.getItemDamage();
        return (meta == 0) ? new EntityImmortalItem(world, location, itemstack) : null;
    }
}
