package com.flansmod.common.network;

import com.flansmod.client.FlansModClient;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketGunRecoil extends PacketBase {
  public float recoilPitch;
  
  public float recoilYaw;
  
  public float decreaseRecoilPitch;
  
  public float decreaseRecoilYaw;
  
  public float sustainedRecoilPitch;
  
  public float sustainedRecoilYaw;
  
  public PacketGunRecoil() {}
  
  public PacketGunRecoil(float recoilPitch, float recoilYaw, float decreaseRecoilPitch, float decreaseRecoilYaw, float sustainedRecoilPitch, float sustainedRecoilYaw) {
    this.recoilPitch = recoilPitch;
    this.recoilYaw = recoilYaw;
    this.decreaseRecoilPitch = decreaseRecoilPitch;
    this.decreaseRecoilYaw = decreaseRecoilYaw;
    this.sustainedRecoilPitch = sustainedRecoilPitch;
    this.sustainedRecoilYaw = sustainedRecoilYaw;
  }
  
  public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    data.writeFloat(this.recoilPitch);
    data.writeFloat(this.recoilYaw);
    data.writeFloat(this.decreaseRecoilPitch);
    data.writeFloat(this.decreaseRecoilYaw);
    data.writeFloat(this.sustainedRecoilPitch);
    data.writeFloat(this.sustainedRecoilYaw);
  }
  
  public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    this.recoilPitch = data.readFloat();
    this.recoilYaw = data.readFloat();
    this.decreaseRecoilPitch = data.readFloat();
    this.decreaseRecoilYaw = data.readFloat();
    this.sustainedRecoilPitch = data.readFloat();
    this.sustainedRecoilYaw = data.readFloat();
  }
  
  public void handleServerSide(EntityPlayerMP playerEntity) {}
  
  @SideOnly(Side.CLIENT)
  public void handleClientSide(EntityPlayer clientPlayer) {
    if (!clientPlayer.func_70093_af()) {
      if (FlansModClient.peepee >= 0.0F && FlansModClient.peepee < 20.0F) {
        FlansModClient.playerRecoilPitch += this.recoilPitch;
        FlansModClient.playerRecoilYaw += this.recoilYaw;
      } else if (FlansModClient.peepee >= 20.0F) {
        FlansModClient.playerRecoilPitch += this.recoilPitch + this.sustainedRecoilPitch * (FlansModClient.peepee - 20.0F) / 80.0F - this.recoilPitch * (FlansModClient.peepee - 20.0F) / 80.0F;
        FlansModClient.playerRecoilYaw += this.recoilYaw + this.sustainedRecoilYaw * (FlansModClient.peepee - 20.0F) / 80.0F - this.recoilYaw * (FlansModClient.peepee - 20.0F) / 80.0F;
      } 
      if (FlansModClient.peepee < 100.0F) {
        FlansModClient.previousPeepee = FlansModClient.peepee;
        FlansModClient.peepee += 10.0F;
      } 
      FlansModClient.sustainedRecoilPitch = this.sustainedRecoilPitch;
      FlansModClient.sustainedRecoilYaw = this.sustainedRecoilYaw;
    } else {
      if (FlansModClient.peepee >= 0.0F && FlansModClient.peepee < 20.0F) {
        FlansModClient.playerRecoilPitch += this.recoilPitch / this.decreaseRecoilPitch;
        FlansModClient.playerRecoilYaw += this.recoilYaw / this.decreaseRecoilYaw;
      } else if (FlansModClient.peepee >= 20.0F) {
        FlansModClient.playerRecoilPitch += this.recoilPitch / this.decreaseRecoilPitch + this.sustainedRecoilPitch / this.decreaseRecoilPitch * (FlansModClient.peepee - 20.0F) / 80.0F - this.recoilPitch / this.decreaseRecoilPitch * (FlansModClient.peepee - 20.0F) / 80.0F;
        FlansModClient.playerRecoilYaw += this.recoilYaw / this.decreaseRecoilYaw + this.sustainedRecoilYaw / this.decreaseRecoilYaw * (FlansModClient.peepee - 20.0F) / 80.0F - this.recoilYaw / this.decreaseRecoilYaw * (FlansModClient.peepee - 20.0F) / 80.0F;
      } 
      if (FlansModClient.peepee < 100.0F) {
        FlansModClient.previousPeepee = FlansModClient.peepee;
        FlansModClient.peepee += 6.0F;
      } 
      FlansModClient.sustainedRecoilPitch = this.sustainedRecoilPitch / this.decreaseRecoilPitch;
      FlansModClient.sustainedRecoilYaw = this.sustainedRecoilYaw / this.decreaseRecoilYaw;
    } 
  }
}
