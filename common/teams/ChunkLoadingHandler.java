package com.flansmod.common.teams;

import java.util.List;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;

public class ChunkLoadingHandler implements ForgeChunkManager.LoadingCallback {
  public void ticketsLoaded(List<ForgeChunkManager.Ticket> tickets, World world) {
    for (ForgeChunkManager.Ticket ticket : tickets) {
      String s = ticket.getModData().func_74779_i("ShortName");
      TeamsMap map = (TeamsManager.getInstance()).maps.get(s);
      if (ticket != null && map != null)
        map.forceChunkLoading(ticket); 
    } 
  }
}
