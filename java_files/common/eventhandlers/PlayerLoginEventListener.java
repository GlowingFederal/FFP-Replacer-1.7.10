package com.flansmod.common.eventhandlers;

import com.flansmod.common.FlansMod;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketModConfig;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayerMP;

public class PlayerLoginEventListener {
  public PlayerLoginEventListener() {
    FMLCommonHandler.instance().bus().register(this);
  }
  
  @EventHandler
  @SubscribeEvent
  public void OnPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
    FlansMod.packetHandler.sendTo((PacketBase)new PacketModConfig(), (EntityPlayerMP)event.player);
  }
}
