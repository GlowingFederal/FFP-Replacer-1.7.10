package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketVaccine extends PacketBase {
  public void handleServerSide(EntityPlayerMP playerEntity) {}
  
  public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {}
  
  public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {}
  
  @SideOnly(Side.CLIENT)
  public void handleClientSide(EntityPlayer clientPlayer) {
    Entity last = clientPlayer.field_70154_o;
    clientPlayer.field_70154_o = null;
    last.field_70153_n = null;
    clientPlayer.func_70078_a(last);
    if (FlansMod.lastRidden == null)
      System.out.println("uh oh stinky fall out of planes boo boo"); 
  }
}
