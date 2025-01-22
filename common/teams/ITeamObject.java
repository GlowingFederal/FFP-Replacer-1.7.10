package com.flansmod.common.teams;

public interface ITeamObject {
  ITeamBase getBase();
  
  void onBaseSet(int paramInt);
  
  void onBaseCapture(int paramInt);
  
  void setBase(ITeamBase paramITeamBase);
  
  void tick();
  
  void destroy();
  
  double getPosX();
  
  double getPosY();
  
  double getPosZ();
  
  boolean isSpawnPoint();
  
  boolean forceChunkLoading();
}
