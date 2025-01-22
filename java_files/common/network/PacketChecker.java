package com.flansmod.common.network;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.eventhandlers.ServerTickEvent;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketChecker extends PacketBase {
  public void handleServerSide(EntityPlayerMP playerEntity) {
    if (playerEntity.field_70154_o != null) {
      Entity last = playerEntity.field_70154_o;
      playerEntity.func_70078_a(null);
      last.field_70153_n = null;
      ServerTickEvent.remount.add(new Object[] { playerEntity, last });
      last.field_70159_w = 0.0D;
      last.field_70181_x = 0.0D;
      last.field_70179_y = 0.0D;
      if (last instanceof EntitySeat) {
        EntitySeat seat = (EntitySeat)last;
        EntityDriveable plane = seat.driveable;
        plane.field_70159_w = 0.0D;
        plane.field_70181_x = 0.1D;
        plane.field_70179_y = 0.0D;
        (plane.getDriveableData()).emergencyMode = true;
        System.out.println("emergency mode additional layer 3 attemtped to work");
      } 
    } 
  }
  
  public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {}
  
  public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {}
  
  public void handleClientSide(EntityPlayer clientPlayer) {}
}
