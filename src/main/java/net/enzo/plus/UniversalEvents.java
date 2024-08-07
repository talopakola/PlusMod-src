package net.enzo.plus;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.enzo.plus.client.ColorsText;
import net.enzo.plus.common.item.InfinityItems;
import net.enzo.plus.common.item.tools.ItemInfinitySword;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class UniversalEvents {
    @SubscribeEvent // Is SubscribeEvent not EventHandler, dumbass
    public void onTooltip(ItemTooltipEvent event) {
        if (event.itemStack.getItem() instanceof ItemInfinitySword) {
            for(int x = 0;x < event.toolTip.size();x++){
                if(event.toolTip.get(x).contains(StatCollector.translateToLocal("attribute.name.generic.attackDamage"))
                        || event.toolTip.get(x).contains(StatCollector.translateToLocal("Attack Damage"))){
                    event.toolTip.set(x, EnumChatFormatting.BLUE + "+" + ColorsText.rainbow(StatCollector.translateToLocal("tip.infinity")) + " " + EnumChatFormatting.BLUE + StatCollector.translateToLocal("attribute.name.generic.attackDamage"));
                    return;
                }
            }
        }
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
}
