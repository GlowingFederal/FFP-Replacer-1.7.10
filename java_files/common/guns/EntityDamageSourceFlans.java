package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketKillMessage;
import com.flansmod.common.teams.Team;
import com.flansmod.common.types.InfoType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class EntityDamageSourceFlans extends EntityDamageSourceIndirect {
  public InfoType weapon;
  
  public EntityPlayer shooter;
  
  public boolean headshot;
  
  public boolean melee;
  
  public EntityDamageSourceFlans(String s, Entity entity, EntityPlayer player, InfoType wep, boolean head, boolean isMelee) {
    super(s, entity, (Entity)player);
    this.weapon = wep;
    this.shooter = player;
    this.headshot = head;
    this.melee = isMelee;
  }
  
  public Entity getDamageSourceEntity() {
    return this.field_76386_o;
  }
  
  public IChatComponent func_151519_b(EntityLivingBase living) {
    if (!(living instanceof EntityPlayer) || this.shooter == null || PlayerHandler.getPlayerData(this.shooter) == null)
      return super.func_151519_b(living); 
    EntityPlayer player = (EntityPlayer)living;
    Team killedTeam = (PlayerHandler.getPlayerData(player)).team;
    Team killerTeam = (PlayerHandler.getPlayerData(this.shooter)).team;
    float dist = player.func_70032_d((Entity)this.shooter);
    if (this.weapon != null && this.shooter != null && this.shooter.func_70694_bm() != null && living != null)
      FlansMod.getPacketHandler().sendToDimension((PacketBase)new PacketKillMessage(this.headshot, this.weapon, this.shooter
            
            .func_70694_bm().func_77960_j(), ((killedTeam == null) ? "f" : 
            (String)Character.valueOf(killedTeam.textColour)) + player.func_70005_c_(), ((killerTeam == null) ? "f" : 
            (String)Character.valueOf(killerTeam.textColour)) + this.shooter.func_70005_c_(), 
            Float.valueOf(dist)), living.field_71093_bK); 
    return (IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_GRAY + "[" + EnumChatFormatting.RED + "Flansmod" + EnumChatFormatting.DARK_GRAY + "] " + EnumChatFormatting.ITALIC + EnumChatFormatting.DARK_RED + player
        
        .func_70005_c_() + EnumChatFormatting.RESET + EnumChatFormatting.GRAY + " Was killed by " + EnumChatFormatting.ITALIC + EnumChatFormatting.DARK_GREEN + this.shooter
        
        .func_70005_c_() + (FlansMod.showDistanceInKillMessage ? ("" + EnumChatFormatting.RESET + EnumChatFormatting.GRAY + " from " + EnumChatFormatting.ITALIC + EnumChatFormatting.DARK_AQUA + 
        
        String.format("%.1f", new Object[] { Float.valueOf(dist) }) + "m" + EnumChatFormatting.RESET + EnumChatFormatting.GRAY + " away") : ""));
  }
}
