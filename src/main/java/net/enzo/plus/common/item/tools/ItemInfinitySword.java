package net.enzo.plus.common.item.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.enzo.plus.Lumberjack;
import net.enzo.plus.PlusMod;
import net.enzo.plus.common.Config;
import net.enzo.plus.common.entities.EntityImmortalItem;
import net.enzo.plus.common.item.InfinityItems;
import net.enzo.plus.common.item.util.ItemSwordCooler;
import net.enzo.plus.common.misc.DamageSourceInfinity;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import java.util.List;
import java.util.Random;

public class ItemInfinitySword extends ItemSwordCooler {
    public static Random randy = new Random();
    public IIcon color;
    public IIcon farmer;
    private static final ToolMaterial opSword = EnumHelper.addToolMaterial("INFINITY_SWORD", 32, 9999, 9999F, Float.MAX_VALUE /*Useless, but exists :D*/, 32);
    public ItemInfinitySword() {
        super(opSword);
        setUnlocalizedName("infinity_rsword");
        setTextureName("plus:tools/infinity_sword/infinity_sword");
        setCreativeTab(PlusMod.tab);
        setMaxDamage(0);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (player.isSneaking()) {
            NBTTagCompound tags = stack.getTagCompound();
            if (tags == null) {
                tags = new NBTTagCompound();
                stack.setTagCompound(tags);
            }
            tags.setBoolean("farm", !tags.getBoolean("farm"));
            for (int i = 0; i < randy.nextInt(30); i++) {
                world.spawnEntityInWorld(new EntityLightningBolt(world, player.posX, player.posY, player.posZ));
            }
            Lumberjack.info("Farmer: " + tags.getBoolean("farm"));
            player.swingItem();
        } else {
            stack.getItemUseAction();
        }

        return stack;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack p_77661_1_) {
        return EnumAction.block;
        // Ok, didn't work...
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    public void registerIcons(IIconRegister r) {
        super.registerIcons(r);

        this.itemIcon = r.registerIcon("plus:tools/infinity_sword/infinity_sword");
        color = r.registerIcon("plus:tools/infinity_sword/infinity_sword_color");

        farmer = r.registerIcon("plus:tools/infinity_sword/infinity_farm");
    }

    @Override
    public IIcon getIcon(ItemStack stack, int pass) {
        if (pass == 1) { return color; }
        NBTTagCompound tags = stack.getTagCompound();
        if(tags != null){
            if(tags.getBoolean("farm"))
                return farmer;
        }

        return itemIcon;

    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconIndex(ItemStack stack) {
        return getIcon(stack, 0);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List tooltip, boolean idk) {
        tooltip.add(EnumChatFormatting.DARK_GRAY + "" +EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip.sword.desc"));
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
        if (stack.getTagCompound().getBoolean("farm")) {
            EntityPlayer player2 = (EntityPlayer)player;
            player2.addExperienceLevel(696969);
            Lumberjack.info("Farmer: " + stack.getTagCompound().getBoolean("farm")); // Finally I'm using this log thing for something useful
            for (int i = 0; i < 5 /*to remember: put 43 lightning bolts to spawn in a single block, can lag the game XD*/; i++) {
                victim.worldObj.spawnEntityInWorld(new EntityLightningBolt(victim.worldObj, victim.posX, victim.posY, victim.posZ));
            }
        }
        victim.func_110142_aN().func_94547_a(new DamageSourceInfinity(player), victim.getHealth(), victim.getHealth());
        victim.setHealth(0);
        victim.onDeath(new EntityDamageSource("infinity", player));
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list) {
        ItemStack sword = new ItemStack(this);
        if (!Config.boringSword)
            sword.addEnchantment(Enchantment.looting, 100);
        //else
            //System.out.println("Plus: Shit PC :D");
        // Lol, why I did this?
        list.add(sword);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if(!entity.worldObj.isRemote && entity instanceof EntityPlayer) {
            if (stack.getTagCompound().getBoolean("farm")) {
                player.addExperienceLevel(696969);
                for (int i = 0; i < 43; i++) {
                    entity.worldObj.spawnEntityInWorld(new EntityLightningBolt(entity.worldObj, entity.posX, entity.posY, entity.posZ));
                }
            }
            EntityPlayer victim = (EntityPlayer)entity;
            if(victim.capabilities.isCreativeMode && !victim.isDead && victim.getHealth() > 0 && !InfinityItems.isPlus(victim) && !stack.getTagCompound().getBoolean("farm")){
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
