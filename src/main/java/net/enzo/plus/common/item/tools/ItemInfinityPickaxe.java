package net.enzo.plus.common.item.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.enzo.plus.PlusMod;
import net.enzo.plus.common.entities.EntityImmortalItem;
import net.enzo.plus.common.item.InfinityItems;
import net.enzo.plus.common.misc.DamageSourceInfinity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import java.util.List;

public class ItemInfinityPickaxe extends ItemPickaxe {
    private static final Item.ToolMaterial opPick = EnumHelper.addToolMaterial("INFINITY_PICKAXE", 9999, 9999, 999999F, 999.0F, 32);

    public ItemInfinityPickaxe() {
        super(opPick);
        setUnlocalizedName("infinity_rpickaxe");
        setTextureName("plus:tools/infinity_pickaxe/infinity_pickaxe");
        setCreativeTab(PlusMod.tab);
        setMaxDamage(0);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.block;
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
            if(victim.capabilities.isCreativeMode && !victim.isDead && victim.getHealth() > 0 && !InfinityItems.isPlus(victim) && !stack.getTagCompound().getBoolean("farm")){
                victim.func_110142_aN().func_94547_a(new DamageSourceInfinity(player), victim.getHealth(), victim.getHealth());
                victim.setHealth(0);
                victim.onDeath(new EntityDamageSource("infinity", player));
                //player.addStat(Achievements.creative_kill, 1);
                return true;
            } else if (victim.capabilities.isCreativeMode && !victim.isDead && victim.getHealth() > 0 && !InfinityItems.isPlus(victim) && stack.getTagCompound().getBoolean("farm")) {
                //player.getEntityWorld().spawnEntityInWorld(new EntityXPOrb(player.getEntityWorld(), player.posX, player.posZ, player.posY, 883));
                player.addExperienceLevel(696969);
                for (int i = 0; i < 43; i++) {
                    entity.worldObj.spawnEntityInWorld(new EntityLightningBolt(entity.worldObj, entity.posX, entity.posY, entity.posZ));
                }
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
