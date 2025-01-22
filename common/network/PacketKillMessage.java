package com.flansmod.common.network;

import com.flansmod.client.TickHandlerClient;
import com.flansmod.common.FlansMod;
import com.flansmod.common.types.InfoType;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketKillMessage extends PacketBase {
  public InfoType killedBy;
  
  public int itemDamage;
  
  public String killerName;
  
  public String killedName;
  
  public boolean headshot;
  
  public boolean dumbMessage = false;
  
  public float distance;
  
  public PacketKillMessage() {}
  
  public PacketKillMessage(boolean head, InfoType weapon, int itmDmg, String victim, String murderer, Float dist) {
    this.killedBy = weapon;
    this.itemDamage = itmDmg;
    this.killerName = murderer;
    this.killedName = victim;
    this.headshot = head;
    this.distance = dist.floatValue();
  }
  
  public PacketKillMessage(String murderer, String victim) {
    this.dumbMessage = true;
    this.killerName = murderer;
    this.killedName = victim;
  }
  
  public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    if (!this.dumbMessage) {
      data.writeBoolean(this.headshot);
      writeUTF(data, this.killedBy.shortName);
      data.writeInt(this.itemDamage);
      data.writeFloat(this.distance);
    } 
    data.writeBoolean(this.dumbMessage);
    writeUTF(data, this.killerName);
    writeUTF(data, this.killedName);
  }
  
  public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    if (!this.dumbMessage) {
      this.headshot = data.readBoolean();
      this.killedBy = InfoType.getType(readUTF(data));
      this.itemDamage = data.readInt();
      this.distance = data.readFloat();
    } 
    this.dumbMessage = data.readBoolean();
    this.killerName = readUTF(data);
    this.killedName = readUTF(data);
  }
  
  public void handleServerSide(EntityPlayerMP playerEntity) {
    FlansMod.log("Player kill Killer: " + this.killerName + " Killed " + this.killedName + " using: " + this.killedBy.shortName + " Headshot: " + this.headshot);
    FlansMod.log("Distance " + this.distance);
  }
  
  public void handleClientSide(EntityPlayer clientPlayer) {
    if (!this.dumbMessage) {
      TickHandlerClient.addKillMessage(this.headshot, this.killedBy, this.itemDamage, this.killerName, this.killedName);
    } else {
      TickHandlerClient.addKillMessageDumb(this.killerName, this.killedName);
    } 
  }
}
