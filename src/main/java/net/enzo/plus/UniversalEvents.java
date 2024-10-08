package net.enzo.plus;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.enzo.plus.client.InfinityText;
import net.enzo.plus.common.blocks.BlockReality;
import net.enzo.plus.common.item.InfinityItems;
import net.enzo.plus.common.item.ItemInfinityArmor;
import net.enzo.plus.common.item.tools.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.Random;

public class UniversalEvents {
    private static Random randy = new Random();

    @SubscribeEvent // Is SubscribeEvent not EventHandler, dumbass
    public void onTooltip(ItemTooltipEvent event) {
        if (event.itemStack.getItem() instanceof ItemInfinitySword || event.itemStack.getItem() instanceof ItemInfinityPickaxe || event.itemStack.getItem() instanceof ItemInfinityShovel || event.itemStack.getItem() instanceof ItemInfinityAxe) {
            for(int x = 0;x < event.toolTip.size();x++){
                if(event.toolTip.get(x).contains(StatCollector.translateToLocal("attribute.name.generic.attackDamage"))
                        || event.toolTip.get(x).contains(StatCollector.translateToLocal("Attack Damage"))){
                    event.toolTip.set(x, EnumChatFormatting.BLUE + "+" + InfinityText.rainbow(StatCollector.translateToLocal("tip.rInfinity")) + " " + EnumChatFormatting.BLUE + StatCollector.translateToLocal("attribute.name.generic.attackDamage"));
                    return;
                }
            }
        }
        if (event.itemStack.getItem() instanceof ItemInfinityArmor) {
            event.toolTip.add("");
            event.toolTip.add(EnumChatFormatting.BLUE + "+" + InfinityText.rainbow(StatCollector.translateToLocal("tip.rInfinity")) + EnumChatFormatting.RESET + " " + EnumChatFormatting.BLUE + StatCollector.translateToLocal("tip.armor"));
        }
        if (event.itemStack.getItem() instanceof  ItemInfinityHoe) {
            event.toolTip.add("");
            event.toolTip.add(EnumChatFormatting.BLUE + "+" + InfinityText.rainbow(StatCollector.translateToLocal("tip.rInfinity")) + " " + EnumChatFormatting.BLUE + StatCollector.translateToLocal("attribute.name.generic.attackDamage"));
        }

        // Lol, I forgot the event things.
        if (event.itemStack.getItem() == Item.getItemFromBlock(new BlockReality())) {
            event.toolTip.add(EnumChatFormatting.DARK_GRAY + "" +EnumChatFormatting.ITALIC + StatCollector.translateToLocal("tooltip.blockReality.desc"));
        }

        /*if (event.itemStack.getItem() instanceof Item || event.itemStack.getItem() instanceof ItemSpade || event.itemStack.getItem() instanceof ItemSword || event.itemStack.getItem() instanceof ItemAxe || event.itemStack.getItem() instanceof ItemPickaxe || event.itemStack.getItem() instanceof ItemHoe || event.itemStack.getItem() instanceof ItemSwordCooler) {
            Item item = event.itemStack.getItem();
            if (GuiScreen.isShiftKeyDown()) {
                event.toolTip.add(EnumChatFormatting.GOLD + "Rarity: " + EnumChatFormatting.RESET + "" + item.getRarity(new ItemStack(item)).rarityColor + item.getRarity(new ItemStack(item)).rarityName);
                Lumberjack.info("Seeing it's rarity!");
            }
        }*/

        //Idea for a new mod :D
    }

    @SubscribeEvent
    public void onDeath(LivingDeathEvent event) {
        if(event.entityLiving instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer)event.entityLiving;
            if(InfinityItems.isPlus(player) && !event.source.getDamageType().equals("infinity")){
                event.setCanceled(true);
                player.setHealth(player.getMaxHealth());
            }
        }
    }

    @SubscribeEvent
    public void onPlayerMine(PlayerInteractEvent event) {
        if(event.face == -1 || event.world.isRemote || event.action != PlayerInteractEvent.Action.LEFT_CLICK_BLOCK || event.entityPlayer.getHeldItem() == null || event.entityPlayer.capabilities.isCreativeMode)
            return;
        Block block = event.world.getBlock(event.x, event.y, event.z);
        int meta = event.world.getBlockMetadata(event.x, event.y, event.z);
        if(block.getBlockHardness(event.entityPlayer.worldObj, event.x, event.y, event.z) <= -1 &&
                event.entityPlayer.getHeldItem().getItem() == InfinityItems.infinity_pickaxe &&
                (block.getMaterial() == Material.rock || block.getMaterial() == Material.iron)){

            if(event.entityPlayer.getHeldItem().getTagCompound() != null && event.entityPlayer.getHeldItem().getTagCompound().getBoolean("hammer")) {
                InfinityItems.infinity_pickaxe.onBlockStartBreak(event.entityPlayer.getHeldItem(), event.x, event.y, event.z, event.entityPlayer); // I think I can delete this, but how I'm dumb, I'll let it here
            }
            else {

                if(block.quantityDropped(randy) == 0) {
                    ItemStack drop = block.getPickBlock(ToolHelper.raytraceFromEntity(event.world, event.entityPlayer, true, 10),
                            event.world, event.x, event.y, event.z, event.entityPlayer);
                    if(drop == null)
                        drop = new ItemStack(block, 1, meta);
                    dropItem(drop, event.entityPlayer.worldObj, event.x, event.y, event.z);
                }
                else
                    block.harvestBlock(event.world, event.entityPlayer, event.x, event.y, event.z, meta);
                event.entityPlayer.worldObj.setBlockToAir(event.x, event.y, event.z);
                event.world.playAuxSFX(2001, event.x, event.y, event.z, Block.getIdFromBlock(block) + (meta << 12));
                if (event.world.getBlock(event.x, event.y, event.z) == Blocks.bedrock) {
                    //event.entityPlayer.addStat(Achievements.bedrock, 1);
                }
            }
        }
    }

    public static void dropItem(ItemStack drop, World world, int x, int y, int z){
        float f = 0.7F;
        double d0 = (double)(randy.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d1 = (double)(randy.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        double d2 = (double)(randy.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
        EntityItem entityitem = new EntityItem(world, (double)x + d0, (double)y + d1, (double)z + d2, drop);
        entityitem.delayBeforeCanPickup = 10;
        world.spawnEntityInWorld(entityitem);
    }

    @SubscribeEvent
    public void onAttacked(LivingAttackEvent event) {
        if(!(event.entityLiving instanceof EntityPlayer))
            return;
        if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityPlayer)
            return;
        EntityPlayer player = (EntityPlayer)event.entityLiving;
        if(player.getHeldItem() != null && player.getHeldItem().getItem() == InfinityItems.infinity_sword && player.isUsingItem())
            event.setCanceled(true);
        if(InfinityItems.isPlus(player) && !event.source.damageType.equals("infinity"))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void onGetHurt(LivingHurtEvent event){
        if(!(event.entityLiving instanceof EntityPlayer))
            return;
        EntityPlayer player = (EntityPlayer)event.entityLiving;
        if(player.getHeldItem() != null && player.getHeldItem().getItem() == InfinityItems.infinity_sword && player.isUsingItem())
            event.setCanceled(true);
        if(InfinityItems.isPlus(player) && !event.source.damageType.equals("infinity"))
            event.setCanceled(true);
    }

    /*@SubscribeEvent
    public void onUse(PlayerUseItemEvent event) {
        if (event.item.getItem() == InfinityItems.infinity_banana) {
            float chance = randy.nextFloat();

            if (chance >= 0.5F)
                if (!InfinityItems.isPlus(event.entityPlayer) && !event.entityPlayer.capabilities.isCreativeMode && !event.entityPlayer.capabilities.isFlying)
                    event.entityPlayer.setHealth(0F);
                else
                    System.out.println(chance);
            else
                System.out.println("Wow, how lucky you are, now, the number is: " + chance + "F, and required number to die is >= 0.5F");
        } else if (event.item.getItem() == InfinityItems.infinity_bow || event.item.isItemEqual(new ItemStack(InfinityItems.infinity_bow)) || event.entityPlayer.getItemInUse().isItemEqual(new ItemStack(InfinityItems.infinity_bow)) || event.entityPlayer.getItemInUse().getItem() == InfinityItems.infinity_bow || event.entityPlayer.getHeldItem().isItemEqual(new ItemStack(InfinityItems.infinity_bow)) || event.entityPlayer.getHeldItem().getItem() == InfinityItems.infinity_bow) {
            float chance = randy.nextFloat();

            if (!InfinityItems.isPlus(event.entityPlayer))
                if (chance >= 0F /*I think on let just 50% of chance from this happens, but, will not combine with the message*) {
                    // TODO: 12/08/2024 Make a bits checker to see if player's computer are 32 or 64-bits (CurseForge accept this? IDK)
                    event.entityPlayer.addChatMessage(new ChatComponentText("You're unworthy of my power"));
                    String os = System.getProperty("os.arch");
                    if (os.contains("64")) {
                        event.entityPlayer.setFire((int) Long.MAX_VALUE);
                    } else {
                        event.entityPlayer.setFire(Integer.MAX_VALUE);
                    }
                }
        }
    }*/

    @SubscribeEvent
    public void SHITSHITSHIT(LivingEvent.LivingUpdateEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)event.entityLiving;
            if (player.isEating() && player.getHeldItem().isItemEqual(new ItemStack(InfinityItems.infinity_banana)) && !player.capabilities.isCreativeMode && player != null && !player.isDead && player.getHealth() >= 0.0F) {
                float chance = randy.nextFloat();
                //System.out.println("Randy = "+chance+"lol");
                /*if (chance >= 0.5F) {
                    System.out.println("died");
                } else {
                    System.out.println("Alive");
                }*/

                if (chance >= 0.5F) {
                    if (!InfinityItems.isPlus(player)) {
                        player.setHealth(0);
                        player.setDead();
                    }
                } else {
                    return;
                }
            }

            if (player.inventory.hasItem(InfinityItems.infinity_bow) && !player.capabilities.isCreativeMode && !player.isDead && player.getHealth() >= 0 && !InfinityItems.isPlus(player)) {
                player.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + " " + EnumChatFormatting.ITALIC + " " + EnumChatFormatting.BOLD + StatCollector.translateToLocal("tex.chat.un")));;
                    player.setHealth(0 /*player.getMaxHealth() - (int) Long.MAX_VALUE*/);
                    // To remember: Set health to less than -2.2250738585072014e-308 crash the game!
                    player.setDead();
                    player.setScore((int) Long.MIN_VALUE);
                    //player.performHurtAnimation();
                    // I hate minecraft event system
            } else {
                //System.out.println("Oh yea");
                // Remember, NEVER DO THAT AGAIN
            }

        }
    }
}
