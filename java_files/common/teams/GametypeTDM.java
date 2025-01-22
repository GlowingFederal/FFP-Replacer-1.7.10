package com.flansmod.common.teams;

import com.flansmod.common.PlayerData;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;

public class GametypeTDM extends Gametype {
  public boolean friendlyFire = false;
  
  public boolean autoBalance = true;
  
  public int scoreLimit = 25;
  
  public int newRoundTimer = 0;
  
  public int time;
  
  public int autoBalanceInterval = 1200;
  
  public GametypeTDM() {
    super("Team Deathmatch", "TDM", 2);
  }
  
  public void roundStart() {}
  
  public void roundEnd() {}
  
  public void roundCleanup() {}
  
  public void tick() {}
  
  public boolean needAutobalance() {
    return false;
  }
  
  public void autobalance() {}
  
  public void playerJoined(EntityPlayerMP player) {}
  
  public void playerQuit(EntityPlayerMP player) {}
  
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
  
  public boolean playerCanAttack(EntityPlayerMP attacker, Team attackerTeam, EntityPlayerMP victim, Team victimTeam) {
    return (attackerTeam != victimTeam || this.friendlyFire);
  }
  
  public void playerKilled(EntityPlayerMP player, DamageSource source) {
    EntityPlayerMP attacker = getPlayerFromDamageSource(source);
    if (attacker != null) {
      if (attacker == player) {
        (getPlayerData(player)).score--;
        (getPlayerData(player)).shekels--;
      } else if ((getPlayerData(attacker)).team == (getPlayerData(player)).team) {
        (getPlayerData(attacker)).score--;
      } else {
        givePoints(attacker, 1);
        (getPlayerData(attacker)).kills++;
        (getPlayerData(player)).shekels++;
        (getPlayerData(player)).shekels++;
        (getPlayerData(player)).shekels++;
        (getPlayerData(player)).totalScore++;
      } 
    } else {
      (getPlayerData(player)).score--;
      if ((getPlayerData(player)).shekels > 0)
        (getPlayerData(player)).shekels--; 
    } 
    (getPlayerData(player)).deaths++;
  }
  
  public void baseAttacked(ITeamBase base, DamageSource source) {}
  
  public void objectAttacked(ITeamObject object, DamageSource source) {}
  
  public void baseClickedByPlayer(ITeamBase base, EntityPlayerMP player) {}
  
  public void objectClickedByPlayer(ITeamObject object, EntityPlayerMP player) {}
  
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
    if (variable.toLowerCase().equals("scorelimit")) {
      this.scoreLimit = Integer.parseInt(value);
      return true;
    } 
    if (variable.toLowerCase().equals("friendlyfire")) {
      this.friendlyFire = Boolean.parseBoolean(value);
      return true;
    } 
    if (variable.toLowerCase().equals("autobalance")) {
      this.autoBalance = Boolean.parseBoolean(value);
      return true;
    } 
    return false;
  }
  
  public void readFromNBT(NBTTagCompound tags) {
    this.scoreLimit = tags.func_74762_e("TDMScoreLimit");
    this.friendlyFire = tags.func_74767_n("TDMFriendlyFire");
    this.autoBalance = tags.func_74767_n("TDMAutoBalance");
  }
  
  public void saveToNBT(NBTTagCompound tags) {
    tags.func_74768_a("TDMScoreLimit", this.scoreLimit);
    tags.func_74757_a("TDMFriendlyFire", this.friendlyFire);
    tags.func_74757_a("TDMAutoBalance", this.autoBalance);
  }
  
  public boolean sortScoreboardByTeam() {
    return true;
  }
  
  public boolean teamHasWon(Team team) {
    return (teamsManager.currentRound != null && team.score == teamsManager.currentRound.scoreLimit);
  }
}
