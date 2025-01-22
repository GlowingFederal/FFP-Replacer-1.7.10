package com.flansmod.common.teams;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.types.EnumType;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Team extends InfoType {
  public static List<Team> teams = new ArrayList<>();
  
  public List<String> members = new ArrayList<>();
  
  public List<PlayerClass> classes = new ArrayList<>();
  
  public List<PlayerClass> classesLocked = new ArrayList<>();
  
  public static Team spectators;
  
  public int score = 0;
  
  public int teamColour = 16777215;
  
  public char textColour = 'f';
  
  public ItemStack hat;
  
  public ItemStack chest;
  
  public ItemStack legs;
  
  public ItemStack shoes;
  
  public Team(String s, String s1, int teamCol, char textCol) {
    super(new TypeFile(EnumType.team, s, "", false));
    this.shortName = s;
    this.name = s1;
    this.teamColour = teamCol;
    this.textColour = textCol;
    teams.add(this);
  }
  
  public Team(TypeFile file) {
    super(file);
    teams.add(this);
  }
  
  protected void preRead(TypeFile file) {}
  
  protected void postRead(TypeFile file) {}
  
  protected void read(String[] split, TypeFile file) {
    super.read(split, file);
    try {
      if (split[0].equals("TeamColour"))
        this.teamColour = (Integer.parseInt(split[1]) << 16) + (Integer.parseInt(split[2]) << 8) + Integer.parseInt(split[3]); 
      if (split[0].equals("TextColour")) {
        if (split[1].equals("Black"))
          this.textColour = '0'; 
        if (split[1].equals("Blue"))
          this.textColour = '1'; 
        if (split[1].equals("Green"))
          this.textColour = '2'; 
        if (split[1].equals("Aqua"))
          this.textColour = '3'; 
        if (split[1].equals("Red"))
          this.textColour = '4'; 
        if (split[1].equals("Purple"))
          this.textColour = '5'; 
        if (split[1].equals("Orange"))
          this.textColour = '6'; 
        if (split[1].equals("LGrey"))
          this.textColour = '7'; 
        if (split[1].equals("Grey"))
          this.textColour = '8'; 
        if (split[1].equals("LBlue"))
          this.textColour = '9'; 
        if (split[1].equals("LGreen"))
          this.textColour = 'a'; 
        if (split[1].equals("LAqua"))
          this.textColour = 'b'; 
        if (split[1].equals("Red"))
          this.textColour = 'c'; 
        if (split[1].equals("Pink"))
          this.textColour = 'd'; 
        if (split[1].equals("Yellow"))
          this.textColour = 'e'; 
        if (split[1].equals("White"))
          this.textColour = 'f'; 
      } 
      if (split[0].equals("Hat") || split[0].equals("Helmet")) {
        if (split[1].equals("None"))
          return; 
        for (Item item : FlansMod.armourItems) {
          ArmourType armour = ((ItemTeamArmour)item).type;
          if (armour != null && armour.shortName.equals(split[1]))
            this.hat = new ItemStack(item); 
        } 
      } 
      if (split[0].equals("Chest") || split[0].equals("Top")) {
        if (split[1].equals("None"))
          return; 
        for (Item item : FlansMod.armourItems) {
          ArmourType armour = ((ItemTeamArmour)item).type;
          if (armour != null && armour.shortName.equals(split[1]))
            this.chest = new ItemStack(item); 
        } 
      } 
      if (split[0].equals("Legs") || split[0].equals("Bottom")) {
        if (split[1].equals("None"))
          return; 
        for (Item item : FlansMod.armourItems) {
          ArmourType armour = ((ItemTeamArmour)item).type;
          if (armour != null && armour.shortName.equals(split[1]))
            this.legs = new ItemStack(item); 
        } 
      } 
      if (split[0].equals("Shoes") || split[0].equals("Boots")) {
        if (split[1].equals("None"))
          return; 
        for (Item item : FlansMod.armourItems) {
          ArmourType armour = ((ItemTeamArmour)item).type;
          if (armour != null && armour.shortName.equals(split[1]))
            this.shoes = new ItemStack(item); 
        } 
      } 
      if (split[0].equals("AddDefaultClass") || split[0].equals("AddClass"))
        this.classes.add(PlayerClass.getClass(split[1])); 
    } catch (Exception e) {
      System.out.println("Reading team file failed.");
      e.printStackTrace();
    } 
  }
  
  public static Team getTeam(String s) {
    for (Team team : teams) {
      if (team.shortName.equals(s))
        return team; 
    } 
    return null;
  }
  
  public void removePlayer(EntityPlayer player) {
    removePlayer(player.func_70005_c_());
  }
  
  public String removePlayer(String username) {
    this.members.remove(username);
    if (PlayerHandler.getPlayerData(username) != null)
      (PlayerHandler.getPlayerData(username)).team = null; 
    return username;
  }
  
  public EntityPlayer addPlayer(EntityPlayer player) {
    addPlayer(player.func_70005_c_());
    return player;
  }
  
  public String addPlayer(String username) {
    ArrayList<String> list = new ArrayList<>();
    list.add(username);
    for (Team team : teams)
      team.members.removeAll(list); 
    this.members.add(username);
    (PlayerHandler.getPlayerData(username)).newTeam = (PlayerHandler.getPlayerData(username)).team = this;
    return username;
  }
  
  public String removeWorstPlayer() {
    sortPlayers();
    if (this.members.size() == 0)
      return null; 
    return removePlayer(this.members.get(this.members.size() - 1));
  }
  
  public void sortPlayers() {
    Collections.sort(this.members, new ComparatorScore());
  }
  
  public static class ComparatorScore implements Comparator<String> {
    public int compare(String a, String b) {
      PlayerData dataA = PlayerHandler.getPlayerData(a);
      PlayerData dataB = PlayerHandler.getPlayerData(b);
      if (dataA == null || dataB == null)
        return 0; 
      return dataB.score - dataA.score;
    }
  }
  
  public float GetRecommendedScale() {
    return 50.0F;
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBase GetModel() {
    return null;
  }
}
