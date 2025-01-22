package com.flansmod.common.eventhandlers;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketBlood;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class ServerTickEvent {
  public static ArrayList<EntityPlayerMP> nightVisionPlayers = new ArrayList<>();
  
  public static ArrayList<Object[]> remount = new ArrayList();
  
  int tickCount;
  
  public ServerTickEvent() {
    this.tickCount = 0;
    FMLCommonHandler.instance().bus().register(this);
  }
  
  @SubscribeEvent
  public void tick(TickEvent.ServerTickEvent event) {
    switch (event.phase) {
      case END:
        if (this.tickCount >= 20) {
          ArrayList<EntityPlayerMP> playersToRemove = new ArrayList<>();
          for (EntityPlayerMP player : nightVisionPlayers) {
            if (player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() instanceof ItemGun) {
              ItemGun itemGun = (ItemGun)player.func_71045_bC().func_77973_b();
              ItemStack itemstack = player.func_71045_bC();
              AttachmentType scope = itemGun.type.getScope(itemstack);
              System.out.println("est");
              if (scope == null || (scope != null && !scope.hasNightVision)) {
                player.func_82170_o(Potion.field_76439_r.field_76415_H);
                playersToRemove.add(player);
              } 
              continue;
            } 
            player.func_82170_o(Potion.field_76439_r.field_76415_H);
            playersToRemove.add(player);
          } 
          this.tickCount = 0;
          for (EntityPlayerMP player : playersToRemove)
            nightVisionPlayers.remove(player); 
        } 
        this.tickCount++;
        break;
    } 
  }
  
  @SubscribeEvent
  public void onPlayerTick(TickEvent.PlayerTickEvent event) {
    EntityPlayer player = event.player;
    if (!player.field_70170_p.field_72995_K) {
      FlansMod.getPacketHandler().sendTo((PacketBase)new PacketBlood((PlayerHandler.getPlayerData(player)).blood, (PlayerHandler.getPlayerData(player)).hemorrhaging), (EntityPlayerMP)player);
      for (Object[] o : remount) {
        EntityPlayerMP mp = (EntityPlayerMP)o[0];
        if (o[1] instanceof EntitySeat) {
          EntitySeat seato = (EntitySeat)o[1];
          if (mp != null)
            mp.func_145747_a((IChatComponent)new ChatComponentText("Nu remount tried to save " + mp.getDisplayName())); 
          EntitySeat seat = (EntitySeat)o[1];
          EntityDriveable plane = seat.driveable;
          (plane.getDriveableData()).emergencyMode = true;
          if (plane instanceof EntityPlane)
            ((EntityPlane)plane).rebirth(); 
          if (plane instanceof EntityVehicle)
            ((EntityVehicle)plane).rebirthVehicle(); 
          System.out.println("icarus seatkick attempted to save you");
        } 
        ((EntityPlayer)o[0]).func_70078_a((Entity)o[1]);
        System.out.println("remount attempted to remount");
        if ((Entity)o[1] instanceof EntityDriveable) {
          EntityDriveable plane = (EntityDriveable)o[1];
          (plane.getDriveableData()).emergencyMode = true;
          if (plane instanceof EntityPlane)
            ((EntityPlane)plane).rebirth(); 
          if (plane instanceof EntityVehicle)
            ((EntityVehicle)plane).rebirthVehicle(); 
          System.out.println("icarus seatkick (for driveable) attempted to save you");
        } 
      } 
      remount.clear();
    } 
  }
}
