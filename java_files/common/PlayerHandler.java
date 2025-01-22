package com.flansmod.common;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.EntityDamageSourceFlans;
import com.flansmod.common.guns.EntityGrenade;
import com.flansmod.common.guns.GrenadeType;
import com.flansmod.common.guns.ShootableType;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketRequestDebug;
import com.flansmod.common.teams.TeamsManager;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class PlayerHandler {
  private static final Random rand = new Random();
  
  public static Map<String, PlayerData> serverSideData = new HashMap<>();
  
  public static Map<String, PlayerData> clientSideData = new HashMap<>();
  
  public static ArrayList<String> clientsToRemoveAfterThisRound = new ArrayList<>();
  
  public static int enginePower = 14539;
  
  public PlayerHandler() {
    MinecraftForge.EVENT_BUS.register(this);
    FMLCommonHandler.instance().bus().register(this);
  }
  
  @SubscribeEvent
  public void onEntityHurt(LivingAttackEvent event) {
    EntityLivingBase entity = event.entityLiving;
    if (event instanceof LivingAttackEvent) {
      if (entity.field_70154_o instanceof EntityDriveable && (((EntityDriveable)entity.field_70154_o).getDriveableType()).invinciblePilotType)
        event.setCanceled(true); 
      if (entity.field_70154_o instanceof EntitySeat && ((EntitySeat)entity.field_70154_o).seatInfo.invincible)
        event.setCanceled(true); 
    } 
  }
  
  @SubscribeEvent
  public void onLivingHurtEvent(LivingHurtEvent event) {
    float damage = event.ammount;
    if (damage > 0.0F && event.source instanceof EntityDamageSourceFlans) {
      GrenadeType grenadeType;
      EntityDamageSourceFlans source = (EntityDamageSourceFlans)event.source;
      ShootableType shootableType = null;
      Entity damageSouceEntity = source.getDamageSourceEntity();
      if (damageSouceEntity instanceof EntityBullet)
        BulletType bulletType = ((EntityBullet)damageSouceEntity).type; 
      if (damageSouceEntity instanceof EntityGrenade)
        grenadeType = ((EntityGrenade)damageSouceEntity).type; 
      if (grenadeType != null && ((ShootableType)grenadeType).ignoreArmorProbability > 0.0F && rand.nextFloat() < ((ShootableType)grenadeType).ignoreArmorProbability) {
        EntityLivingBase entity = event.entityLiving;
        float f1 = damage;
        damage = Math.max(damage - entity.func_110139_bj(), 0.0F);
        entity.func_110149_m(entity.func_110139_bj() - f1 - damage);
        damage *= ((ShootableType)grenadeType).ignoreArmorDamageFactor;
        if (damage != 0.0F) {
          float health = entity.func_110143_aJ();
          entity.func_70606_j(health - damage);
          entity.func_110142_aN().func_94547_a((DamageSource)source, health, damage);
          entity.func_110149_m(entity.func_110139_bj() - damage);
        } 
        event.setCanceled(true);
      } 
    } 
  }
  
  @SubscribeEvent
  public void onEntityKilled(LivingDeathEvent event) {
    EntityLivingBase entity = event.entityLiving;
    if (entity instanceof EntityPlayer)
      getPlayerData((EntityPlayer)entity).playerKilled(); 
  }
  
  public void serverTick() {
    for (WorldServer world : (MinecraftServer.func_71276_C()).field_71305_c) {
      for (Object player : world.field_73010_i)
        getPlayerData((EntityPlayer)player).tick((EntityPlayer)player); 
    } 
  }
  
  public void clientTick() {
    if ((Minecraft.func_71410_x()).field_71441_e != null)
      for (Object player : (Minecraft.func_71410_x()).field_71441_e.field_73010_i)
        getPlayerData((EntityPlayer)player).tick((EntityPlayer)player);  
  }
  
  public static PlayerData getPlayerData(EntityPlayer player) {
    if (player == null)
      return null; 
    return getPlayerData(player.func_70005_c_(), player.field_70170_p.field_72995_K ? Side.CLIENT : Side.SERVER);
  }
  
  public static PlayerData getPlayerData(String username) {
    return getPlayerData(username, Side.SERVER);
  }
  
  public static PlayerData getPlayerData(EntityPlayer player, Side side) {
    if (player == null)
      return null; 
    return getPlayerData(player.func_70005_c_(), side);
  }
  
  public static PlayerData getPlayerData(String username, Side side) {
    if (side.isClient()) {
      if (!clientSideData.containsKey(username))
        clientSideData.put(username, new PlayerData(username)); 
    } else if (!serverSideData.containsKey(username)) {
      serverSideData.put(username, new PlayerData(username));
    } 
    return side.isClient() ? clientSideData.get(username) : serverSideData.get(username);
  }
  
  @SubscribeEvent
  public void onPlayerEvent(PlayerEvent event) {
    if (event instanceof PlayerEvent.PlayerLoggedInEvent) {
      if (event.player instanceof EntityPlayerMP)
        FlansMod.packetHandler.sendTo((PacketBase)new PacketRequestDebug(false), (EntityPlayerMP)event.player); 
      EntityPlayer player = event.player;
      String username = player.func_70005_c_();
      if (!serverSideData.containsKey(username))
        serverSideData.put(username, new PlayerData(username)); 
      if (clientsToRemoveAfterThisRound.contains(username))
        clientsToRemoveAfterThisRound.remove(username); 
    } else if (event instanceof PlayerEvent.PlayerLoggedOutEvent) {
      EntityPlayer player = event.player;
      String username = player.func_70005_c_();
      if ((TeamsManager.getInstance()).currentRound == null) {
        serverSideData.remove(username);
      } else {
        clientsToRemoveAfterThisRound.add(username);
      } 
    } else if (event instanceof PlayerEvent.PlayerRespawnEvent) {
      EntityPlayer player = event.player;
      String username = player.func_70005_c_();
      if (!serverSideData.containsKey(username))
        serverSideData.put(username, new PlayerData(username)); 
    } 
  }
  
  public static void roundEnded() {
    for (String username : clientsToRemoveAfterThisRound)
      serverSideData.remove(username); 
  }
}
