package com.flansmod.common.teams;

import com.flansmod.common.PlayerData;
import com.flansmod.common.types.InfoType;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;

public class GametypeZombies extends Gametype {
  public boolean friendlyFire = false;
  
  public int humanPrepTime = 600;
  
  public GametypeZombies() {
    super("Zombies", "ZOM", 2);
  }
  
  public void roundStart() {}
  
  public void roundEnd() {}
  
  public void roundCleanup() {}
  
  public void tick() {
    if (teamsManager.roundTimeLeft + this.humanPrepTime - 200 == teamsManager.currentRound.timeLimit * 20 * 60)
      TeamsManager.messageAll("§cThe §4zombies §care upon us! 10 seconds to §4infection§c!"); 
    if (teamsManager.roundTimeLeft + this.humanPrepTime == teamsManager.currentRound.timeLimit * 20 * 60) {
      TeamsManager.messageAll("§cThe §4zombie plague §cis here!");
      zombifySomeone();
    } 
    if (teamsManager.roundTimeLeft + this.humanPrepTime < teamsManager.currentRound.timeLimit * 20 * 60 && teamsManager.roundTimeLeft % 200 == 0 && (teamsManager.currentRound.teams[1]).members.size() == 0)
      zombifySomeone(); 
  }
  
  public void zombifySomeone() {
    if ((teamsManager.currentRound.teams[0]).members.size() > 0) {
      EntityPlayerMP entityPlayerMP = teamsManager.getPlayer((teamsManager.currentRound.teams[0]).members.get(rand.nextInt((teamsManager.currentRound.teams[0]).members.size())));
      TeamsManager.messageAll("§4" + entityPlayerMP.func_70005_c_() + "§c was infected with the §4zombie plague§c!");
      entityPlayerMP.func_70097_a(DamageSource.field_76377_j, 1.0E9F);
    } 
  }
  
  public Team[] getTeamsCanSpawnAs(TeamsRound currentRound, EntityPlayer player) {
    if (teamsManager.roundTimeLeft + this.humanPrepTime > teamsManager.currentRound.timeLimit * 20 * 60)
      return new Team[] { currentRound.teams[0] }; 
    return new Team[] { currentRound.teams[1] };
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
  
  public boolean playerCanAttack(EntityPlayerMP attacker, Team attackerTeam, EntityPlayerMP victim, Team victimTeam) {
    return (attackerTeam != victimTeam || this.friendlyFire);
  }
  
  public void playerKilled(EntityPlayerMP player, DamageSource source) {
    PlayerData playerData = getPlayerData(player);
    EntityPlayerMP attacker = getPlayerFromDamageSource(source);
    if (attacker != null) {
      PlayerData attackerData = getPlayerData(attacker);
      if (attacker != player)
        if (attackerData.team == playerData.team) {
          if (isHuman(attackerData.team)) {
            attackerData.score++;
          } else {
            attackerData.zombieScore--;
          } 
        } else {
          if (isHuman(attackerData.team)) {
            attackerData.score++;
          } else if (isZombie(attackerData.team)) {
            attackerData.zombieScore++;
          } 
          attackerData.kills++;
        }  
    } 
    playerData.deaths++;
    if (teamsManager.roundTimeLeft + this.humanPrepTime <= teamsManager.currentRound.timeLimit * 20 * 60) {
      if (playerData.team != null)
        playerData.team.removePlayer((EntityPlayer)player); 
      playerData.team = playerData.newTeam = teamsManager.currentRound.teams[1];
      playerData.team.addPlayer((EntityPlayer)player);
      teamsManager.sendClassMenuToPlayer(player);
    } 
  }
  
  public boolean teamHasWon(Team team) {
    if (isHuman(team))
      return (teamsManager.roundTimeLeft == 1 && team.members.size() > 0); 
    if (isZombie(team))
      return (teamsManager.roundTimeLeft + this.humanPrepTime <= teamsManager.currentRound.timeLimit * 20 * 60 && (teamsManager.currentRound.teams[0]).members.size() == 0); 
    return false;
  }
  
  public boolean isHuman(Team team) {
    return (team == teamsManager.currentRound.teams[0]);
  }
  
  public boolean isZombie(Team team) {
    return (team == teamsManager.currentRound.teams[1]);
  }
  
  public Vec3 getSpawnPoint(EntityPlayerMP player) {
    if (teamsManager.currentRound == null)
      return null; 
    PlayerData data = getPlayerData(player);
    List<ITeamObject> validSpawnPoints = new ArrayList<>();
    if (data.newTeam == null)
      return null; 
    if (data.newTeam == Team.spectators) {
      ArrayList<ITeamBase> bases = teamsManager.currentRound.map.getBasesPerTeam(1);
      for (ITeamBase base : bases) {
        if (base.getMap() != teamsManager.currentRound.map)
          continue; 
        for (int i = 0; i < base.getObjects().size(); i++) {
          if (((ITeamObject)base.getObjects().get(i)).isSpawnPoint())
            validSpawnPoints.add(base.getObjects().get(i)); 
        } 
      } 
    } else {
      for (int k = 2; k < 4; k++) {
        ArrayList<ITeamBase> bases = teamsManager.currentRound.map.getBasesPerTeam(k);
        for (ITeamBase base : bases) {
          if (base.getMap() != teamsManager.currentRound.map)
            continue; 
          for (int i = 0; i < base.getObjects().size(); i++) {
            if (((ITeamObject)base.getObjects().get(i)).isSpawnPoint())
              validSpawnPoints.add(base.getObjects().get(i)); 
          } 
        } 
      } 
    } 
    if (validSpawnPoints.size() > 0) {
      ITeamObject spawnPoint = validSpawnPoints.get(rand.nextInt(validSpawnPoints.size()));
      return Vec3.func_72443_a(spawnPoint.getPosX(), spawnPoint.getPosY(), spawnPoint.getPosZ());
    } 
    return null;
  }
  
  public boolean showZombieScore() {
    return true;
  }
  
  public boolean playerCanLoot(ItemStack stack, InfoType infoType, EntityPlayer player, Team playerTeam) {
    return (playerTeam != teamsManager.currentRound.teams[1]);
  }
  
  public void readFromNBT(NBTTagCompound tags) {
    this.humanPrepTime = tags.func_74762_e("ZOMPrepTime");
  }
  
  public void saveToNBT(NBTTagCompound tags) {
    tags.func_74768_a("ZOMPrepTime", this.humanPrepTime);
  }
  
  public boolean setVariable(String variable, String value) {
    if (variable.toLowerCase().equals("humanpreptime")) {
      this.humanPrepTime = Integer.parseInt(value) * 20;
      return true;
    } 
    return false;
  }
}
