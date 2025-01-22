package com.flansmod.common.network;

import com.flansmod.client.TickHandlerClient;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketBlood extends PacketBase {
  public float blood;
  
  public float hemorrhaging;
  
  public int isBlockingLeft;
  
  public int isBlockingRight;
  
  public int isBlockingTop;
  
  public int isBlockingBottom;
  
  public PacketBlood() {}
  
  public PacketBlood(float blood, float hemorrhaging) {
    this.blood = blood;
    this.hemorrhaging = hemorrhaging;
  }
  
  public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    data.writeFloat(this.blood);
    data.writeFloat(this.hemorrhaging);
  }
  
  public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    this.blood = data.readFloat();
    this.hemorrhaging = data.readFloat();
  }
  
  public void handleServerSide(EntityPlayerMP player) {}
  
  @SideOnly(Side.CLIENT)
  public void handleClientSide(EntityPlayer clientPlayer) {
    TickHandlerClient.cringeBlood = this.blood;
    TickHandlerClient.cringeHemorrhaging = this.hemorrhaging;
  }
}
