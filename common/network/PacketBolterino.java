package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class PacketBolterino extends PacketBase {
  public boolean held;
  
  public PacketBolterino() {}
  
  public PacketBolterino(boolean h) {
    this.held = h;
  }
  
  public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    data.writeBoolean(this.held);
  }
  
  public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    this.held = data.readBoolean();
  }
  
  public void handleServerSide(EntityPlayerMP playerEntity) {
    ItemStack currentItem = playerEntity.field_71071_by.func_70448_g();
    if (currentItem != null && currentItem.func_77973_b() != null && currentItem.func_77973_b() instanceof com.flansmod.common.guns.ItemGun) {
      float bkYaw = playerEntity.field_70177_z;
      float bkPitch = playerEntity.field_70125_A;
      playerEntity.field_70177_z = bkYaw;
      playerEntity.field_70125_A = bkPitch;
    } 
  }
  
  @SideOnly(Side.CLIENT)
  public void handleClientSide(EntityPlayer clientPlayer) {
    FlansMod.log("Received gun button packet on client. Skipping.");
    ItemStack currentItem = clientPlayer.field_71071_by.func_70448_g();
  }
}
