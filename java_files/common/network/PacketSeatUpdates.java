package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketSeatUpdates extends PacketBase {
  public int entityId;
  
  public int seatId;
  
  public float yaw;
  
  public float pitch;
  
  public float playerYaw;
  
  public float playerPitch;
  
  public boolean playYawSound;
  
  public boolean playPitchSound;
  
  public int yawSoundDelay;
  
  public int pitchSoundDelay;
  
  public PacketSeatUpdates() {}
  
  public PacketSeatUpdates(EntitySeat seat) {
    this.entityId = seat.driveable.func_145782_y();
    this.seatId = seat.seatInfo.id;
    this.yaw = seat.looking.getYaw();
    this.pitch = seat.looking.getPitch();
    this.playerYaw = seat.playerLooking.getYaw();
    this.playerPitch = seat.playerLooking.getPitch();
    this.playYawSound = seat.playYawSound;
    this.playPitchSound = seat.playPitchSound;
    this.yawSoundDelay = seat.yawSoundDelay;
    this.pitchSoundDelay = seat.pitchSoundDelay;
  }
  
  public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    data.writeInt(this.entityId);
    data.writeInt(this.seatId);
    data.writeFloat(this.yaw);
    data.writeFloat(this.pitch);
    data.writeFloat(this.playerYaw);
    data.writeFloat(this.playerPitch);
    data.writeBoolean(this.playYawSound);
    data.writeBoolean(this.playPitchSound);
    data.writeInt(this.yawSoundDelay);
    data.writeInt(this.pitchSoundDelay);
  }
  
  public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    this.entityId = data.readInt();
    this.seatId = data.readInt();
    this.yaw = data.readFloat();
    this.pitch = data.readFloat();
    this.playerYaw = data.readFloat();
    this.playerPitch = data.readFloat();
    this.playYawSound = data.readBoolean();
    this.playPitchSound = data.readBoolean();
    this.yawSoundDelay = data.readInt();
    this.pitchSoundDelay = data.readInt();
  }
  
  public void handleServerSide(EntityPlayerMP playerEntity) {
    EntityDriveable driveable = null;
    for (Object obj : playerEntity.field_70170_p.field_72996_f) {
      if (obj instanceof EntityDriveable && ((Entity)obj).func_145782_y() == this.entityId) {
        driveable = (EntityDriveable)obj;
        break;
      } 
    } 
    if (driveable != null) {
      (driveable.seats[this.seatId]).prevLooking = (driveable.seats[this.seatId]).looking.clone();
      (driveable.seats[this.seatId]).looking.setAngles(this.yaw, this.pitch, 0.0F);
      (driveable.seats[this.seatId]).prevPlayerLooking = (driveable.seats[this.seatId]).playerLooking.clone();
      (driveable.seats[this.seatId]).playerLooking.setAngles(this.playerYaw, this.playerPitch, 0.0F);
      (driveable.seats[this.seatId]).playYawSound = this.playYawSound;
      (driveable.seats[this.seatId]).playPitchSound = this.playPitchSound;
      (driveable.seats[this.seatId]).yawSoundDelay = this.yawSoundDelay;
      (driveable.seats[this.seatId]).pitchSoundDelay = this.pitchSoundDelay;
      FlansMod.getPacketHandler().sendToAllAround(this, driveable.field_70165_t, driveable.field_70163_u, driveable.field_70161_v, FlansMod.driveableUpdateRange, driveable.field_71093_bK);
    } 
  }
  
  @SideOnly(Side.CLIENT)
  public void handleClientSide(EntityPlayer clientPlayer) {
    EntityDriveable driveable = null;
    EntitySeat seat = null;
    for (Object obj : clientPlayer.field_70170_p.field_72996_f) {
      if (obj instanceof EntityDriveable && ((Entity)obj).func_145782_y() == this.entityId) {
        driveable = (EntityDriveable)obj;
        break;
      } 
    } 
    if (driveable != null) {
      if (driveable.seats[this.seatId] == null || (driveable.seats[this.seatId]).field_70153_n == clientPlayer)
        return; 
      (driveable.seats[this.seatId]).prevLooking = (driveable.seats[this.seatId]).looking.clone();
      (driveable.seats[this.seatId]).looking.setAngles(this.yaw, this.pitch, 0.0F);
      (driveable.seats[this.seatId]).prevPlayerLooking = (driveable.seats[this.seatId]).playerLooking.clone();
      (driveable.seats[this.seatId]).playerLooking.setAngles(this.playerYaw, this.playerPitch, 0.0F);
      (driveable.seats[this.seatId]).playYawSound = this.playYawSound;
      (driveable.seats[this.seatId]).playPitchSound = this.playPitchSound;
      (driveable.seats[this.seatId]).yawSoundDelay = this.yawSoundDelay;
      (driveable.seats[this.seatId]).pitchSoundDelay = this.pitchSoundDelay;
    } 
  }
}
