package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketBlockerino extends PacketBase {
  public int lefty;
  
  public int righty;
  
  public int topy;
  
  public int bottomy;
  
  public int minigunSpeed;
  
  public int entityID;
  
  public PacketBlockerino() {}
  
  public PacketBlockerino(int left, int right, int top, int bottom, int minigun) {
    this.lefty = left;
    this.righty = right;
    this.topy = top;
    this.bottomy = bottom;
    this.minigunSpeed = minigun;
  }
  
  public PacketBlockerino(EntityPlayer player, int left, int right, int top, int bottom, int minigun) {
    this.entityID = player.func_145782_y();
    this.lefty = left;
    this.righty = right;
    this.topy = top;
    this.bottomy = bottom;
    this.minigunSpeed = minigun;
    System.out.println(this.lefty + "public packerino");
  }
  
  public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    System.out.println(this.lefty + "was written");
    data.writeByte(this.lefty);
    data.writeByte(this.righty);
    data.writeByte(this.topy);
    data.writeByte(this.bottomy);
    data.writeByte(this.minigunSpeed);
    data.writeInt(this.entityID);
  }
  
  public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    this.lefty = data.readByte();
    this.righty = data.readByte();
    this.topy = data.readByte();
    this.bottomy = data.readByte();
    this.minigunSpeed = data.readByte();
    this.entityID = data.readInt();
  }
  
  public void handleServerSide(EntityPlayerMP playerEntity) {
    PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)playerEntity, Side.SERVER);
    data.isBlockingLeft = this.lefty;
    data.isBlockingRight = this.righty;
    data.isBlockingTop = this.topy;
    data.isBlockingBottom = this.bottomy;
    data.minigunSpeed = this.minigunSpeed;
    System.out.println(this.lefty + "this one is based packet");
    FlansMod.getPacketHandler().sendToAllAround(new PacketBlockerinoInfo(playerEntity, this.lefty, this.righty, this.topy, this.minigunSpeed), playerEntity.field_70165_t, playerEntity.field_70163_u, playerEntity.field_70161_v, 25.0F, playerEntity.field_71093_bK);
  }
  
  public void handleClientSide(EntityPlayer clientPlayer) {
    FlansMod.log("Received off hand gun select packet on client. Skipping. Did you mean to send a PacketOffHandGunInfo?");
  }
}
