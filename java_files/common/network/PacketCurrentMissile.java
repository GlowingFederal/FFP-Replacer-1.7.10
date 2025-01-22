package com.flansmod.common.network;

import com.flansmod.common.driveables.DriveableData;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.guns.ItemBullet;
import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class PacketCurrentMissile extends PacketBase {
  public int entityid;
  
  public ItemStack missile;
  
  public PacketCurrentMissile() {}
  
  public PacketCurrentMissile(int entityid, ItemStack missile) {
    this.entityid = entityid;
    this.missile = missile;
  }
  
  public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    data.writeInt(this.entityid);
    ByteBufUtils.writeItemStack(data, this.missile);
  }
  
  public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    this.entityid = data.readInt();
    this.missile = ByteBufUtils.readItemStack(data);
  }
  
  public void handleServerSide(EntityPlayerMP playerEntity) {
    Entity e = playerEntity.field_70170_p.func_73045_a(this.entityid);
    if (e != null && e instanceof EntityDriveable) {
      EntityDriveable v = (EntityDriveable)e;
      if (!v.field_70170_p.field_72995_K && System.currentTimeMillis() - v.lastshellswitchedat > 1000L) {
        v.lastshellswitchedat = System.currentTimeMillis();
        DriveableData dd = v.getDriveableData();
        ArrayList<ItemStack> notnull = new ArrayList<>();
        for (ItemStack is : dd.missiles) {
          if (is != null)
            notnull.add(is); 
        } 
        if (notnull.size() > 0) {
          ItemStack[] newmissiles = new ItemStack[(v.getDriveableType()).numMissileSlots];
          newmissiles[notnull.size() - 1] = notnull.get(0);
          int i = -1;
          for (ItemStack is : notnull) {
            i++;
            if (i == 0)
              continue; 
            newmissiles[i - 1] = is;
          } 
          dd.missiles = newmissiles;
          PacketPlaySound.sendSoundPacket(e.field_70165_t, e.field_70163_u, e.field_70161_v, 4.0D, e.field_71093_bK, "AnalogComputerSound", false);
        } 
      } 
    } 
  }
  
  public void handleClientSide(EntityPlayer clientPlayer) {
    Entity e = clientPlayer.field_70170_p.func_73045_a(this.entityid);
    if (e != null && e instanceof EntityDriveable && this.missile.func_77973_b() instanceof ItemBullet)
      ((EntityDriveable)e).currentAmmo = ((ItemBullet)this.missile.func_77973_b()).type.name; 
  }
}
