package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketModConfig extends PacketBase {
  public boolean hitCrossHairEnable = FlansMod.hitCrossHairEnable;
  
  public boolean bulletGuiEnable = FlansMod.bulletGuiEnable;
  
  public boolean crosshairEnable = FlansMod.crosshairEnable;
  
  public boolean gunCarryLimitEnable = FlansMod.gunCarryLimitEnable;
  
  public int gunCarryLimit = FlansMod.gunCarryLimit;
  
  public float driveableUpdateRange = FlansMod.driveableUpdateRange;
  
  public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    data.writeBoolean(this.hitCrossHairEnable);
    data.writeBoolean(this.bulletGuiEnable);
    data.writeBoolean(this.crosshairEnable);
    data.writeBoolean(this.gunCarryLimitEnable);
    data.writeInt(this.gunCarryLimit);
    data.writeFloat(this.driveableUpdateRange);
  }
  
  public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    this.hitCrossHairEnable = data.readBoolean();
    this.bulletGuiEnable = data.readBoolean();
    this.crosshairEnable = data.readBoolean();
    this.gunCarryLimitEnable = data.readBoolean();
    this.gunCarryLimit = data.readInt();
    this.driveableUpdateRange = data.readFloat();
  }
  
  public void handleServerSide(EntityPlayerMP playerEntity) {}
  
  @SideOnly(Side.CLIENT)
  public void handleClientSide(EntityPlayer clientPlayer) {
    FlansMod.hitCrossHairEnable = this.hitCrossHairEnable;
    FlansMod.bulletGuiEnable = this.bulletGuiEnable;
    FlansMod.crosshairEnable = this.crosshairEnable;
    FlansMod.gunCarryLimitEnable = this.gunCarryLimitEnable;
    FlansMod.gunCarryLimit = this.gunCarryLimit;
    FlansMod.driveableUpdateRange = this.driveableUpdateRange;
    FlansMod.log("Config synced successfully");
  }
}
