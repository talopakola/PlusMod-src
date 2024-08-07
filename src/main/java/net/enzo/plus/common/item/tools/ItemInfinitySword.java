package net.enzo.plus.common.item.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.enzo.plus.PlusMod;
import net.enzo.plus.common.entities.EntityImmortalItem;
import net.enzo.plus.common.item.InfinityItems;
import net.enzo.plus.common.misc.DamageSourceInfinity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import java.util.List;

public class ItemInfinitySword extends ItemSword {
    private static final ToolMaterial opSword = EnumHelper.addToolMaterial("INFINITY_SWORD", 32, 9999, 9999F, -3.0F, 32);
    public ItemInfinitySword() {
        super(opSword);
        setUnlocalizedName("infinity_sword");
        setTextureName("plus:infinity_sword");
        setCreativeTab(PlusMod.tab);
        setMaxDamage(0);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List tooltip, boolean idk) {
        tooltip.add(EnumChatFormatting.ITALIC+""+EnumChatFormatting.GRAY+ StatCollector.translateToLocal("tooltip.sword.desc"));
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase victim, EntityLivingBase player) {
        if(player.worldObj.isRemote)
            return true;
        if (victim instanceof EntityPlayer) {
            EntityPlayer pvp = (EntityPlayer)victim;
                if (InfinityItems.isPlus(pvp)) {
                    victim.attackEntityFrom(new DamageSourceInfinity(player), 4.0F);
                }
            return true;
        }
        victim.func_110142_aN().func_94547_a(new DamageSourceInfinity(player), victim.getHealth(), victim.getHealth());
        victim.setHealth(0);
        victim.onDeath(new EntityDamageSource("infinity", player));
        return true;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if(!entity.worldObj.isRemote && entity instanceof EntityPlayer) {
            EntityPlayer victim = (EntityPlayer)entity;
            if(victim.capabilities.isCreativeMode && !victim.isDead && victim.getHealth() > 0 && !InfinityItems.isPlus(victim)){
                victim.func_110142_aN().func_94547_a(new DamageSourceInfinity(player), victim.getHealth(), victim.getHealth());
                victim.setHealth(0);
                victim.onDeath(new EntityDamageSource("infinity", player));
                //player.addStat(Achievements.creative_kill, 1);
                return true;
            }
        }
        return false;
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
