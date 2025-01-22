package com.flansmod.common.eventhandlers;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.EntityGrenade;
import com.flansmod.common.guns.GrenadeType;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketKillMessage;
import com.flansmod.common.teams.Team;
import com.flansmod.common.types.InfoType;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class PlayerDeathEventListener {
  public PlayerDeathEventListener() {
    MinecraftForge.EVENT_BUS.register(this);
  }
  
  @EventHandler
  @SubscribeEvent
  public void PlayerDied(LivingDeathEvent DamageEvent) {
    Entity souceEntity = DamageEvent.source.func_76364_f();
    if (DamageEvent.source.func_76355_l().equalsIgnoreCase("explosion") && (souceEntity instanceof EntityGrenade || souceEntity instanceof EntityBullet) && DamageEvent.entityLiving instanceof EntityPlayer) {
      BulletType bulletType;
      EntityPlayer killer = null;
      EntityPlayer killed = (EntityPlayer)DamageEvent.entityLiving;
      if (souceEntity instanceof EntityGrenade) {
        killer = (EntityPlayer)((EntityGrenade)souceEntity).thrower;
        GrenadeType grenadeType = ((EntityGrenade)souceEntity).type;
      } else {
        killer = (EntityPlayer)((EntityBullet)souceEntity).owner;
        bulletType = ((EntityBullet)souceEntity).type;
      } 
      Team killerTeam = null;
      Team killedTeam = null;
      killerTeam = (PlayerHandler.getPlayerData(killer)).team;
      killedTeam = (PlayerHandler.getPlayerData(killed)).team;
      (PlayerHandler.getPlayerData(killed)).blood = 100.0F;
      (PlayerHandler.getPlayerData(killed)).minorBleed = 0;
      (PlayerHandler.getPlayerData(killed)).Bleed = 0;
      (PlayerHandler.getPlayerData(killed)).hemorrhaging = 0;
      FlansMod.getPacketHandler().sendToDimension((PacketBase)new PacketKillMessage(false, (InfoType)bulletType, killer
            
            .func_70694_bm().func_77960_j(), ((killedTeam == null) ? "f" : 
            (String)Character.valueOf(killedTeam.textColour)) + killed.getDisplayName(), ((killerTeam == null) ? "f" : 
            (String)Character.valueOf(killedTeam.textColour)) + killer.getDisplayName(), 
            Float.valueOf(killed.func_70032_d((Entity)killer))), DamageEvent.entityLiving.field_71093_bK);
      System.out.println(killer.getDisplayName() + " has killed " + killed.getDisplayName() + " with " + ((InfoType)bulletType).name + ". TickExisted:" + (killed.field_70173_aa / 20) + " KilledPos(X:" + (int)killed.field_70165_t + " Y:" + (int)killed.field_70163_u + " Z:" + (int)killed.field_70161_v + ") KillerPos(X:" + (int)killer.field_70165_t + " Y:" + (int)killer.field_70163_u + " Z:" + (int)killer.field_70161_v + ")");
      if (killed.func_82169_q(2) != null) {
        System.out.println("KilledPlayer:" + killed + " wear a " + killed.func_82169_q(2).func_77977_a());
      } else {
        System.out.println("KilledPlayer:" + killed + " wear nothing.");
      } 
      if (killer.func_82169_q(2) != null) {
        System.out.println("Killer:" + killer + " wear a " + killer.func_82169_q(2).func_77977_a());
      } else {
        System.out.println("Killer:" + killer + " wear nothing.");
      } 
      if (killed.field_70173_aa / 20 < FlansMod.noticeSpawnKillTime)
        System.out.println("Warning! PlayerName:" + killer.func_70005_c_() + " may do SPAWN KILL. Time:" + (killed.field_70173_aa / 20) + " " + killed.func_70005_c_() + " was killed."); 
    } 
  }
  
  @SubscribeEvent
  public void onPlayerDeath(LivingDeathEvent event) {
    if (event.entity instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer)event.entity;
      (PlayerHandler.getPlayerData(player)).blood = 100.0F;
      (PlayerHandler.getPlayerData(player)).minorBleed = 0;
      (PlayerHandler.getPlayerData(player)).Bleed = 0;
      (PlayerHandler.getPlayerData(player)).hemorrhaging = 0;
    } 
  }
  
  @EventHandler
  public void onRespawnPVPEVENT(PlayerEvent.PlayerRespawnEvent pvpevent) {
    EntityPlayer player = pvpevent.player;
    (PlayerHandler.getPlayerData(player)).blood = 100.0F;
    (PlayerHandler.getPlayerData(player)).minorBleed = 0;
    (PlayerHandler.getPlayerData(player)).Bleed = 0;
    (PlayerHandler.getPlayerData(player)).hemorrhaging = 0;
  }
}
