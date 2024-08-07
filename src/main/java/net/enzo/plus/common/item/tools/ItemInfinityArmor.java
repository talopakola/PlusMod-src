package net.enzo.plus.common.item.tools;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.enzo.plus.PlusMod;
import net.enzo.plus.client.ColorsText;
import net.enzo.plus.common.PotionHelper;
import net.enzo.plus.common.entities.EntityImmortalItem;
import net.enzo.plus.common.item.InfinityItems;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingEvent.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static net.enzo.plus.common.item.tools.ItemInfinityArmor.abilityHandler.*;

public class ItemInfinityArmor extends ItemArmor {
    public static final ArmorMaterial infinite_armor = EnumHelper.addArmorMaterial("infinity", 9999, new int[]{6, 16, 12, 6}, 1000);
    public final int slot;
    public ItemInfinityArmor(int slot) {
        super(infinite_armor, 0, slot);
        this.slot = slot;
        setCreativeTab(PlusMod.tab);
        setUnlocalizedName("infinity_armor_"+slot);
        setTextureName("plus:infinity_"+slot); // This will not cause problems later?
        // IDK bro, I just do it
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (slot == 2) {
            return "plus:textures/models/infinity_layer_2.png";
        }
        return "plus:textures/models/infinity_layer_1.png";
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if(armorType == 0){
            player.setAir(300);
            player.getFoodStats().addStats(20, 20F);
            player.setScore(99566);
        }
        else if(armorType == 1){
            Collection effects = player.getActivePotionEffects();
            if(effects.size() > 0){
                ArrayList<Potion> bad = new ArrayList<Potion>();
                for(Object effect : effects){
                    if(effect instanceof PotionEffect){
                        PotionEffect potion = (PotionEffect)effect;
                        if(PotionHelper.badPotion(Potion.potionTypes[potion.getPotionID()]))
                            bad.add(Potion.potionTypes[potion.getPotionID()]);
                    }
                }
                if(bad.size() > 0){
                    for(Potion potion : bad){
                        player.removePotionEffect(potion.id);
                    }
                }
            }
        }
        else if(armorType == 2){
            if(player.isBurning())
                player.extinguish();
        }
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
    public String getItemStackDisplayName(ItemStack p_77653_1_) {
        return ColorsText.rainbow(StatCollector.translateToLocal("item.infinity_armor_" + slot + ".name"));
    } // Isso é incrível mano, não tem como

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return InfinityItems.infinity;
    }

    @Override
    public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List tooltip, boolean sex) {
        if (slot == 3) {
            tooltip.add(ColorsText.rainbow(StatCollector.translateToLocal("tooltip.sanic.desc"))); // SANIC
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack, int pass) {
        return false;
    }

    public static class abilityHandler {
        public static List<String> playersWithHat = new ArrayList<String>();
        public static List<String> playersWithChest = new ArrayList<String>();
        public static List<String> playersWithLeg = new ArrayList<String>();
        public static List<String> playersWithFoot = new ArrayList<String>();

        public static boolean playerHasHat(EntityPlayer player) {
            ItemStack armour = player.getCurrentArmor(3);
            return armour != null && armour.getItem() == InfinityItems.infinity_helmet;
        }

        public static boolean playerHasChest(EntityPlayer player) {
            ItemStack armour = player.getCurrentArmor(2);
            return armour != null && armour.getItem() == InfinityItems.infinity_chest;
        }

        public static boolean playerHasLeg(EntityPlayer player) {
            ItemStack armour = player.getCurrentArmor(1);
            return armour != null && armour.getItem() == InfinityItems.infinity_leggings;
        }

        public static boolean playerHasFoot(EntityPlayer player) {
            ItemStack armour = player.getCurrentArmor(0);
            return armour != null && armour.getItem() == InfinityItems.infinity_boots;
        }

        public static String playerKey(EntityPlayer player) {
            return player.getGameProfile().getName() +":"+ player.worldObj.isRemote;
        }

        // I'm so stupid...
        @SubscribeEvent
        public void updatePlayerAbilityStatus(LivingUpdateEvent event) {
            if (event.entityLiving instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer)event.entityLiving;
                String key = playerKey(player);

                // hat
                Boolean hasHat = playerHasHat(player);
                if (playersWithHat.contains(key)) {
                    if (hasHat) {

                    } else {
                        playersWithHat.remove(key);
                    }
                } else if (hasHat) {
                    playersWithHat.add(key);
                }

                // chest
                Boolean hasChest = playerHasChest(player);
                if (playersWithChest.contains(key)) {
                    if (hasChest) {
                        player.capabilities.allowFlying = true;
                    } else {
                        if (!player.capabilities.isCreativeMode) {
                            player.capabilities.allowFlying = false;
                            player.capabilities.isFlying = false;
                        }
                        playersWithChest.remove(key);
                    }
                } else if (hasChest) {
                    playersWithChest.add(key);
                }

                // legs
                Boolean hasLeg = playerHasLeg(player);
                if (playersWithLeg.contains(key)) {
                    if (hasLeg) {

                    } else {
                        playersWithLeg.remove(key);
                    }
                } else if (hasLeg) {
                    playersWithLeg.add(key);
                }

                // shoes
                Boolean hasFoot = playerHasFoot(player);
                if (playersWithFoot.contains(key)) {
                    if (hasFoot) {
                        boolean flying = player.capabilities.isFlying;
                        boolean swimming = player.isInsideOfMaterial(Material.water) || player.isInWater();
                        if (player.onGround || flying || swimming) {
                            boolean sneaking = player.isSneaking();

                            float speed = 0.15f
                                    * (flying ? 1.1f : 1.0f)
                                    * (sneaking ? 0.1f : 1.0f);

                            if (player.moveForward > 0f) {
                                player.moveFlying(0f, 1f, speed);
                            } else if (player.moveForward < 0f) {
                                player.moveFlying(0f, 1f, -speed * 0.3f);
                            }

                            if (player.moveStrafing != 0f) {
                                player.moveFlying(1f, 0f, speed * 0.5f * Math.signum(player.moveStrafing));
                            }
                        }
                    } else {
                        playersWithFoot.remove(key);
                    }
                } else if (hasFoot) {
                    playersWithFoot.add(key);
                }
            }
        }
        @SubscribeEvent
        public void jumpBoost(LivingJumpEvent event) {
            if (event.entityLiving instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer)event.entityLiving;
                String key = playerKey(player);

                if (playersWithFoot.contains(key)) {
                    player.motionY += 0.4f;
                }
            }
        }
    }
}
