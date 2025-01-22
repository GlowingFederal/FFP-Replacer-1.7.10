package com.flansmod.common.network;

import com.flansmod.common.FlansMod;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.Packet;
import net.minecraft.server.MinecraftServer;

@Sharable
public class PacketHandler extends MessageToMessageCodec<FMLProxyPacket, PacketBase> {
  private EnumMap<Side, FMLEmbeddedChannel> channels;
  
  private LinkedList<Class<? extends PacketBase>> packets = new LinkedList<>();
  
  private boolean modInitialised = false;
  
  public boolean registerPacket(Class<? extends PacketBase> cl) {
    if (this.packets.size() > 256) {
      FlansMod.log("Packet limit exceeded in Flan's Mod packet handler by packet " + cl.getCanonicalName() + ".");
      return false;
    } 
    if (this.packets.contains(cl)) {
      FlansMod.log("Tried to register " + cl.getCanonicalName() + " packet class twice.");
      return false;
    } 
    if (this.modInitialised) {
      FlansMod.log("Tried to register packet " + cl.getCanonicalName() + " after mod initialisation.");
      return false;
    } 
    this.packets.add(cl);
    return true;
  }
  
  protected void encode(ChannelHandlerContext ctx, PacketBase msg, List<Object> out) throws Exception {
    ByteBuf encodedData = Unpooled.buffer();
    Class<? extends PacketBase> cl = (Class)msg.getClass();
    if (!this.packets.contains(cl))
      throw new NullPointerException("Packet not registered : " + cl.getCanonicalName()); 
    byte discriminator = (byte)this.packets.indexOf(cl);
    encodedData.writeByte(discriminator);
    msg.encodeInto(ctx, encodedData);
    FMLProxyPacket proxyPacket = new FMLProxyPacket(encodedData.copy(), (String)ctx.channel().attr(NetworkRegistry.FML_CHANNEL).get());
    out.add(proxyPacket);
  }
  
  protected void decode(ChannelHandlerContext ctx, FMLProxyPacket msg, List<Object> out) throws Exception {
    INetHandler netHandler;
    ByteBuf encodedData = msg.payload();
    byte discriminator = encodedData.readByte();
    Class<? extends PacketBase> cl = this.packets.get(discriminator);
    if (cl == null)
      throw new NullPointerException("Packet not registered for discriminator : " + discriminator); 
    PacketBase packet = cl.newInstance();
    packet.decodeInto(ctx, encodedData.slice());
    switch (FMLCommonHandler.instance().getEffectiveSide()) {
      case CLIENT:
        packet.handleClientSide(getClientPlayer());
        break;
      case SERVER:
        netHandler = (INetHandler)ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
        packet.handleServerSide(((NetHandlerPlayServer)netHandler).field_147369_b);
        break;
    } 
  }
  
  public void initialise() {
    this.channels = NetworkRegistry.INSTANCE.newChannel("FlansMod", new ChannelHandler[] { (ChannelHandler)this });
    registerPacket((Class)PacketCurrentMissile.class);
    registerPacket((Class)PacketAAGunAngles.class);
    registerPacket((Class)PacketBaseEdit.class);
    registerPacket((Class)PacketBreakSound.class);
    registerPacket((Class)PacketBuyArmour.class);
    registerPacket((Class)PacketBuyWeapon.class);
    registerPacket((Class)PacketCraftDriveable.class);
    registerPacket((Class)PacketDriveableControl.class);
    registerPacket((Class)PacketDriveableDamage.class);
    registerPacket((Class)PacketDriveableGUI.class);
    registerPacket((Class)PacketDriveableKey.class);
    registerPacket((Class)PacketDriveableKeyHeld.class);
    registerPacket((Class)PacketFlak.class);
    registerPacket((Class)PacketExplosion.class);
    registerPacket((Class)PacketGunFire.class);
    registerPacket((Class)PacketGunMode.class);
    registerPacket((Class)PacketGunPaint.class);
    registerPacket((Class)PacketGunSpread.class);
    registerPacket((Class)PacketKillMessage.class);
    registerPacket((Class)PacketMechaControl.class);
    registerPacket((Class)PacketMGFire.class);
    registerPacket((Class)PacketMGMount.class);
    registerPacket((Class)PacketOffHandGunInfo.class);
    registerPacket((Class)PacketParticle.class);
    registerPacket((Class)PacketPlaneControl.class);
    registerPacket((Class)PacketPlaySound.class);
    registerPacket((Class)PacketReload.class);
    registerPacket((Class)PacketRepairDriveable.class);
    registerPacket((Class)PacketRoundFinished.class);
    registerPacket((Class)PacketSeatUpdates.class);
    registerPacket((Class)PacketSeatCheck.class);
    registerPacket((Class)PacketSelectOffHandGun.class);
    registerPacket((Class)PacketTeamInfo.class);
    registerPacket((Class)PacketTeamSelect.class);
    registerPacket((Class)PacketVehicleControl.class);
    registerPacket((Class)PacketVoteCast.class);
    registerPacket((Class)PacketVoting.class);
    registerPacket((Class)PacketRequestDebug.class);
    registerPacket((Class)PacketFlashBang.class);
    registerPacket((Class)PacketImpactPoint.class);
    registerPacket((Class)PacketModConfig.class);
    registerPacket((Class)PacketGunRecoil.class);
    registerPacket((Class)PacketGunState.class);
    registerPacket((Class)PacketBlood.class);
    registerPacket((Class)PacketChecker.class);
    registerPacket((Class)PacketVaccine.class);
  }
  
  public void postInitialise() {
    if (this.modInitialised)
      return; 
    this.modInitialised = true;
    Collections.sort(this.packets, new Comparator<Class<? extends PacketBase>>() {
          public int compare(Class<? extends PacketBase> c1, Class<? extends PacketBase> c2) {
            int com = String.CASE_INSENSITIVE_ORDER.compare(c1.getCanonicalName(), c2.getCanonicalName());
            if (com == 0)
              com = c1.getCanonicalName().compareTo(c2.getCanonicalName()); 
            return com;
          }
        });
  }
  
  @SideOnly(Side.CLIENT)
  private EntityPlayer getClientPlayer() {
    return (EntityPlayer)(Minecraft.func_71410_x()).field_71439_g;
  }
  
  public void sendToAll(PacketBase packet) {
    ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
    ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(packet);
  }
  
  public void sendTo(PacketBase packet, EntityPlayerMP player) {
    ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
    ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
    ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(packet);
  }
  
  public void sendToAllAround(PacketBase packet, NetworkRegistry.TargetPoint point) {
    ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
    ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
    ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(packet);
  }
  
  public void sendToDimension(PacketBase packet, int dimensionID) {
    ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
    ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(Integer.valueOf(dimensionID));
    ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(packet);
  }
  
  public void sendToServer(PacketBase packet) {
    ((FMLEmbeddedChannel)this.channels.get(Side.CLIENT)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
    ((FMLEmbeddedChannel)this.channels.get(Side.CLIENT)).writeAndFlush(packet);
  }
  
  public void sendToAll(Packet packet) {
    MinecraftServer.func_71276_C().func_71203_ab().func_148540_a(packet);
  }
  
  public void sendTo(Packet packet, EntityPlayerMP player) {
    player.field_71135_a.func_147359_a(packet);
  }
  
  public void sendToAllAround(Packet packet, NetworkRegistry.TargetPoint point) {
    MinecraftServer.func_71276_C().func_71203_ab().func_148541_a(point.x, point.y, point.z, point.range, point.dimension, packet);
  }
  
  public void sendToDimension(Packet packet, int dimensionID) {
    MinecraftServer.func_71276_C().func_71203_ab().func_148537_a(packet, dimensionID);
  }
  
  public void sendToServer(Packet packet) {
    (Minecraft.func_71410_x()).field_71439_g.field_71174_a.func_147297_a(packet);
  }
  
  public void sendToAllAround(PacketBase packet, double x, double y, double z, float range, int dimension) {
    sendToAllAround(packet, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
  }
  
  public void sendToDonut(PacketBase packet, double x, double y, double z, float minRange, float maxRange, int dimension) {
    List players;
    if (FMLCommonHandler.instance().getSide().isClient()) {
      players = (Minecraft.func_71410_x()).field_71441_e.field_73010_i;
    } else {
      players = (MinecraftServer.func_71276_C().func_71203_ab()).field_72404_b;
    } 
    for (Object p : players) {
      if (p instanceof EntityPlayerMP) {
        EntityPlayerMP pl = (EntityPlayerMP)p;
        if (pl.field_71093_bK == dimension) {
          double dist = Math.sqrt((pl.field_70165_t - x) * (pl.field_70165_t - x) + (pl.field_70163_u - y) * (pl.field_70163_u - y) + (pl.field_70161_v - z) * (pl.field_70161_v - z));
          if (dist > minRange && dist < maxRange)
            sendTo(packet, pl); 
        } 
      } 
    } 
  }
}
