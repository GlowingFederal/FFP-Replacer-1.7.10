package com.flansmod.common.teams;

import com.flansmod.common.PlayerData;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;

public class GametypeCTF extends Gametype {
  public boolean friendlyFire = false;
  
  public boolean autoBalance = true;
  
  public int time;
  
  public int autoBalanceInterval = 1200;
  
  public int flagReturnTime = 60;
  
  public GametypeCTF() {
    super("Capture the Flag", "CTF", 2);
  }
  
  public void roundStart() {}
  
  public void roundEnd() {}
  
  public void roundCleanup() {}
  
  public void tick() {}
  
  public void playerQuit(EntityPlayerMP player) {}
  
  public boolean playerCanAttack(EntityPlayerMP attacker, Team attackerTeam, EntityPlayerMP victim, Team victimTeam) {
    return (attackerTeam != victimTeam || this.friendlyFire);
  }
  
  public boolean playerAttacked(EntityPlayerMP player, DamageSource source) {
    if (getPlayerData(player) == null || (getPlayerData(player)).team == null)
      return false; 
    EntityPlayerMP attacker = getPlayerFromDamageSource(source);
    if (attacker != null) {
      if (getPlayerData(attacker) == null || (getPlayerData(attacker)).team == null)
        return false; 
      if ((getPlayerData(player)).team == (getPlayerData(attacker)).team)
        return this.friendlyFire; 
    } 
    if ((getPlayerData(player)).team == Team.spectators)
      return false; 
    return true;
  }
  
  public void playerKilled(EntityPlayerMP player, DamageSource source) {
    EntityPlayerMP attacker = getPlayerFromDamageSource(source);
    if (attacker != null) {
      if (attacker == player) {
        (getPlayerData(player)).score--;
      } else {
        (getPlayerData(attacker)).score++;
        (getPlayerData(attacker)).kills++;
      } 
    } else {
      (getPlayerData(player)).score--;
    } 
    (getPlayerData(player)).deaths++;
    if (player.field_70153_n instanceof EntityFlag) {
      Team flagTeam = teamsManager.getTeam(((EntityFlag)player.field_70153_n).getBase().getOwnerID());
      player.field_70153_n.func_70078_a(null);
      TeamsManager.messageAll("§f" + player.func_70005_c_() + " dropped the §" + flagTeam.textColour + flagTeam.name + "§f flag");
    } 
  }
  
  public void baseAttacked(ITeamBase base, DamageSource source) {}
  
  public void objectAttacked(ITeamObject object, DamageSource source) {}
  
  public void baseClickedByPlayer(ITeamBase base, EntityPlayerMP player) {
    if (base instanceof EntityFlagpole && ((EntityFlag)base.getFlag()).isHome)
      objectClickedByPlayer(base.getFlag(), player); 
  }
  
  public void objectClickedByPlayer(ITeamObject object, EntityPlayerMP player) {
    if (teamsManager.currentRound == null)
      return; 
    if (object instanceof EntityFlag) {
      EntityFlag flag = (EntityFlag)object;
      if (flag.getBase().getOwnerID() > 1) {
        Team playerTeam = (getPlayerData(player)).team;
        PlayerData playerData = getPlayerData(player);
        Team flagTeam = teamsManager.getTeam(flag.getBase().getOwnerID());
        if (playerTeam != null && playerTeam != Team.spectators && flag.getBase().getMap() == teamsManager.currentRound.map)
          if (playerTeam == flagTeam) {
            if (flag.field_70154_o == null && !flag.isHome) {
              flag.reset();
              playerData.score += 2;
              (getPlayerData(player)).shekels++;
              (getPlayerData(player)).shekels++;
              TeamsManager.messageAll("§f" + player.func_70005_c_() + " returned the §" + flagTeam.textColour + flagTeam.name + "§f flag");
            } else if (player.field_70153_n instanceof EntityFlag) {
              EntityFlag otherFlag = (EntityFlag)player.field_70153_n;
              Team otherFlagTeam = teamsManager.getTeam(otherFlag.getBase().getOwnerID());
              if (otherFlagTeam != null && otherFlagTeam != Team.spectators && otherFlagTeam != flagTeam && flag.isHome) {
                playerTeam.score++;
                playerData.score += 10;
                (getPlayerData(player)).shekels++;
                (getPlayerData(player)).shekels++;
                (getPlayerData(player)).shekels++;
                (getPlayerData(player)).shekels++;
                (getPlayerData(player)).shekels++;
                (getPlayerData(player)).shekels++;
                otherFlag.reset();
                TeamsManager.messageAll("§f" + player.func_70005_c_() + " captured the §" + otherFlagTeam.textColour + otherFlagTeam.name + "§f flag");
              } 
            } 
          } else if (flag.field_70154_o == player) {
            flag.func_70078_a((Entity)null);
            TeamsManager.messageAll("§f" + player.func_70005_c_() + " dropped the §" + flagTeam.textColour + flagTeam.name + "§f flag");
          } else if (flag.field_70154_o == null) {
            if (flag.isHome)
              playerData.score += 3; 
            (getPlayerData(player)).shekels++;
            (getPlayerData(player)).shekels++;
            flag.func_70078_a((Entity)player);
            TeamsManager.messageAll("§f" + player.func_70005_c_() + " picked up the §" + flagTeam.textColour + flagTeam.name + "§f flag");
            flag.isHome = false;
          }  
      } 
    } 
  }
  
  public Vec3 getSpawnPoint(EntityPlayerMP player) {
    if (teamsManager.currentRound == null)
      return null; 
    PlayerData data = getPlayerData(player);
    List<ITeamObject> validSpawnPoints = new ArrayList<>();
    if (data.newTeam == null)
      return null; 
    ArrayList<ITeamBase> bases = teamsManager.currentRound.map.getBasesPerTeam(teamsManager.currentRound.getTeamID(data.newTeam));
    for (ITeamBase base : bases) {
      if (base.getMap() != teamsManager.currentRound.map)
        continue; 
      for (int i = 0; i < base.getObjects().size(); i++) {
        if (((ITeamObject)base.getObjects().get(i)).isSpawnPoint())
          validSpawnPoints.add(base.getObjects().get(i)); 
      } 
    } 
    if (validSpawnPoints.size() > 0) {
      ITeamObject spawnPoint = validSpawnPoints.get(rand.nextInt(validSpawnPoints.size()));
      return Vec3.func_72443_a(spawnPoint.getPosX(), spawnPoint.getPosY(), spawnPoint.getPosZ());
    } 
    return null;
  }
  
  public void playerRespawned(EntityPlayerMP player) {}
  
  public boolean setVariable(String variable, String value) {
    if (variable.toLowerCase().equals("friendlyfire")) {
      this.friendlyFire = Boolean.parseBoolean(value);
      return true;
    } 
    if (variable.toLowerCase().equals("autobalance")) {
      this.autoBalance = Boolean.parseBoolean(value);
      return true;
    } 
    if (variable.toLowerCase().equals("flagtime")) {
      this.flagReturnTime = Integer.parseInt(value);
      return true;
    } 
    return false;
  }
  
  public void readFromNBT(NBTTagCompound tags) {
    this.friendlyFire = tags.func_74767_n("CTFFriendlyFire");
    this.autoBalance = tags.func_74767_n("CTFAutoBalance");
    this.flagReturnTime = tags.func_74762_e("CTFFlagTime");
  }
  
  public void saveToNBT(NBTTagCompound tags) {
    tags.func_74757_a("CTFFriendlyFire", this.friendlyFire);
    tags.func_74757_a("CTFAutoBalance", this.autoBalance);
    tags.func_74768_a("CTFFlagTime", this.flagReturnTime);
  }
  
  public boolean sortScoreboardByTeam() {
    return true;
  }
  
  public boolean teamHasWon(Team team) {
    return (teamsManager.currentRound != null && team.score == teamsManager.currentRound.scoreLimit);
  }
}
