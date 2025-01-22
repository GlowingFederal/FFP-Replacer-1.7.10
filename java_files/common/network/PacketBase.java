package com.flansmod.common.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public abstract class PacketBase {
  public abstract void encodeInto(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf);
  
  public abstract void decodeInto(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf);
  
  public abstract void handleServerSide(EntityPlayerMP paramEntityPlayerMP);
  
  @SideOnly(Side.CLIENT)
  public abstract void handleClientSide(EntityPlayer paramEntityPlayer);
  
  public void writeUTF(ByteBuf data, String s) {
    ByteBufUtils.writeUTF8String(data, s);
  }
  
  public String readUTF(ByteBuf data) {
    return ByteBufUtils.readUTF8String(data);
  }
}
