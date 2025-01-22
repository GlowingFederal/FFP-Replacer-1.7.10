package com.flansmod.common.teams;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public interface ITeamBase {
  String getName();
  
  void setName(String paramString);
  
  void setBaseID(int paramInt);
  
  int getBaseID();
  
  int getDefaultOwnerID();
  
  void setDefaultOwnerID(int paramInt);
  
  int getOwnerID();
  
  void setOwnerID(int paramInt);
  
  void startRound();
  
  void roundCleanup();
  
  TeamsMap getMap();
  
  void setMap(TeamsMap paramTeamsMap);
  
  void setMapFirstTime(TeamsMap paramTeamsMap);
  
  List<ITeamObject> getObjects();
  
  void addObject(ITeamObject paramITeamObject);
  
  void tick();
  
  void destroy();
  
  Entity getEntity();
  
  double getPosX();
  
  double getPosY();
  
  double getPosZ();
  
  World getWorld();
  
  ITeamObject getFlag();
}
