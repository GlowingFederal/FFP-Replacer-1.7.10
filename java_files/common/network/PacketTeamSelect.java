package com.flansmod.common.network;

import com.flansmod.client.gui.GuiTeamSelect;
import com.flansmod.common.FlansMod;
import com.flansmod.common.teams.PlayerClass;
import com.flansmod.common.teams.Team;
import com.flansmod.common.teams.TeamsManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketTeamSelect extends PacketBase {
  public boolean selectionPacket = false;
  
  public String selection;
  
  public boolean classChoicesPacket = false;
  
  public Team[] teams;
  
  public PlayerClass[] playerClasses;
  
  public boolean info = false;
  
  public PacketTeamSelect() {}
  
  public PacketTeamSelect(Team[] t, boolean i) {
    this.selectionPacket = false;
    this.classChoicesPacket = false;
    this.teams = t;
    this.info = i;
  }
  
  public PacketTeamSelect(Team[] t) {
    this(t, false);
  }
  
  public PacketTeamSelect(PlayerClass[] c) {
    this.selectionPacket = false;
    this.classChoicesPacket = true;
    this.playerClasses = c;
  }
  
  public PacketTeamSelect(String shortName, boolean classPacket) {
    this.selectionPacket = true;
    this.classChoicesPacket = classPacket;
    this.selection = shortName;
  }
  
  public void encodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    data.writeBoolean(this.selectionPacket);
    data.writeBoolean(this.classChoicesPacket);
    data.writeBoolean(this.info);
    if (this.selectionPacket) {
      writeUTF(data, this.selection);
    } else if (this.classChoicesPacket) {
      data.writeByte(this.playerClasses.length);
      for (PlayerClass playerClass : this.playerClasses)
        writeUTF(data, playerClass.shortName); 
    } else {
      data.writeByte(this.teams.length);
      for (Team team : this.teams)
        writeUTF(data, (team == null) ? "null" : team.shortName); 
    } 
  }
  
  public void decodeInto(ChannelHandlerContext ctx, ByteBuf data) {
    this.selectionPacket = data.readBoolean();
    this.classChoicesPacket = data.readBoolean();
    this.info = data.readBoolean();
    if (this.selectionPacket) {
      this.selection = readUTF(data);
    } else if (this.classChoicesPacket) {
      byte numClasses = data.readByte();
      this.playerClasses = new PlayerClass[numClasses];
      for (int i = 0; i < numClasses; i++)
        this.playerClasses[i] = PlayerClass.getClass(readUTF(data)); 
    } else {
      byte numTeams = data.readByte();
      this.teams = new Team[numTeams];
      for (int i = 0; i < numTeams; i++)
        this.teams[i] = Team.getTeam(readUTF(data)); 
    } 
  }
  
  public void handleServerSide(EntityPlayerMP playerEntity) {
    if (!this.selectionPacket) {
      FlansMod.log("Class / Team listing packet received on server. Rejecting.");
      return;
    } 
    if (this.classChoicesPacket) {
      TeamsManager.getInstance().playerSelectedClass(playerEntity, this.selection);
    } else {
      TeamsManager.getInstance().playerSelectedTeam(playerEntity, this.selection);
    } 
  }
  
  @SideOnly(Side.CLIENT)
  public void handleClientSide(EntityPlayer clientPlayer) {
    if (this.selectionPacket) {
      FlansMod.log("Class / Team selection packet received on client. Rejecting.");
      return;
    } 
    if (this.classChoicesPacket) {
      Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiTeamSelect(this.playerClasses));
    } else if (this.info) {
      GuiTeamSelect.teamChoices = this.teams;
    } else {
      Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiTeamSelect(this.teams));
    } 
  }
}
