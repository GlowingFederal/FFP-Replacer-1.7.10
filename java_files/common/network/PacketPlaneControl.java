package com.flansmod.common.network;

import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class PacketPlaneControl extends PacketDriveableControl {
  public boolean gear;
  
  public boolean doors;
  
  public boolean wings;
  
  public boolean flare;
  
  public boolean flaps;
  
  public int state;
  
  public PacketPlaneControl() {}
  
  public PacketPlaneControl(EntityDriveable driveable) {
    super(driveable);
    EntityPlane plane = (EntityPlane)driveable;
    this.gear = plane.varGear;
    this.doors = plane.varDoor;
    this.wings = plane.varWing;
    this.state = plane.anim.state;
    this.flaps = plane.varFlap;
  }
  
  public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    super.encodeInto(ctx, data);
    data.writeBoolean(this.gear);
    data.writeBoolean(this.doors);
    data.writeBoolean(this.wings);
    data.writeBoolean(this.flaps);
    data.writeInt(this.state);
  }
  
  public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    super.decodeInto(ctx, data);
    this.gear = data.readBoolean();
    this.doors = data.readBoolean();
    this.wings = data.readBoolean();
    this.flaps = data.readBoolean();
    this.state = data.readInt();
  }
  
  protected void updateDriveable(EntityDriveable driveable, boolean clientSide) {
    super.updateDriveable(driveable, clientSide);
    EntityPlane plane = (EntityPlane)driveable;
    plane.varDoor = this.doors;
    plane.varGear = this.gear;
    plane.varWing = this.wings;
    plane.varFlap = this.flaps;
    plane.anim.state = this.state;
  }
}
