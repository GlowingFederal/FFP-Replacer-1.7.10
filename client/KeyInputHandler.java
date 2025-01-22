package com.flansmod.client;

import com.flansmod.api.IControllable;
import com.flansmod.client.gui.GuiTeamScores;
import com.flansmod.client.gui.GuiTeamSelect;
import com.flansmod.common.FlansMod;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketBolterino;
import com.flansmod.common.network.PacketGunMode;
import com.flansmod.common.network.PacketReload;
import com.flansmod.common.network.PacketRequestDebug;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class KeyInputHandler {
  public static KeyBinding downKey = new KeyBinding("Down key / Gunsight", 29, "Flan's Mod");
  
  public static KeyBinding inventoryKey = new KeyBinding("Inventory key", 19, "Flan's Mod");
  
  public static KeyBinding gunKey = new KeyBinding("Docking Key", 34, "Flan's Mod");
  
  public static KeyBinding controlSwitchKey = new KeyBinding("Surface key / Control Switch key", 46, "Flan's Mod");
  
  public static KeyBinding bombKey = new KeyBinding("Undocking Key", 36, "Flan's Mod");
  
  public static KeyBinding reloadKey = new KeyBinding("Reload key", 19, "Flan's Mod");
  
  public static KeyBinding gunModeKey = new KeyBinding("Gun Mode", 33, "Flan's Mod");
  
  public static KeyBinding teamsMenuKey = new KeyBinding("Teams Menu Key", 34, "Flan's Mod");
  
  public static KeyBinding teamsScoresKey = new KeyBinding("Teams Scores Key", 35, "Flan's Mod");
  
  public static KeyBinding leftRollKey = new KeyBinding("Roll Left / Turret Lock", 44, "Flan's Mod");
  
  public static KeyBinding rightRollKey = new KeyBinding("Roll Right / Turret Unlock", 45, "Flan's Mod");
  
  public static KeyBinding gearKey = new KeyBinding("Gear Up / Down Key", 38, "Flan's Mod");
  
  public static KeyBinding doorKey = new KeyBinding("Radar Range / Door Toggle Key", 37, "Flan's Mod");
  
  public static KeyBinding modeKey = new KeyBinding("Dive Key / VTOL", 47, "Flan's Mod");
  
  public static KeyBinding flareKey = new KeyBinding("Flare Key / Ship Repair", 49, "Flan's Mod");
  
  public static KeyBinding trimKey = new KeyBinding("Afterburner / WEP Key", 33, "Flan's Mod");
  
  public static KeyBinding debugKey = new KeyBinding("Debug Key", 68, "Flan's Mod");
  
  public static KeyBinding reloadModelsKey = new KeyBinding("Reload Models Key", 67, "Flan's Mod");
  
  public static KeyBinding secondaryKey = new KeyBinding("Select Gun Underbarrel", 37, "Flan's Mod");
  
  public static KeyBinding nintendoSwitch = new KeyBinding("Bombsight Toggle", 33, "Flan's Mod");
  
  public static KeyBinding s0 = new KeyBinding("Driver Seat", 11, "Flan's Mod");
  
  public static KeyBinding s1 = new KeyBinding("Passenger Gun 1", 2, "Flan's Mod");
  
  public static KeyBinding s2 = new KeyBinding("Passenger Gun 2", 3, "Flan's Mod");
  
  public static KeyBinding s3 = new KeyBinding("Passenger Gun 3", 4, "Flan's Mod");
  
  public static KeyBinding s4 = new KeyBinding("Passenger Gun 4", 5, "Flan's Mod");
  
  public static KeyBinding s5 = new KeyBinding("Passenger Gun 5", 6, "Flan's Mod");
  
  public static KeyBinding s6 = new KeyBinding("Passenger Gun 6", 7, "Flan's Mod");
  
  public static KeyBinding s7 = new KeyBinding("Passenger Gun 7", 8, "Flan's Mod");
  
  public static KeyBinding s8 = new KeyBinding("Passenger Gun 8", 9, "Flan's Mod");
  
  public static KeyBinding s9 = new KeyBinding("Passenger Gun 9", 10, "Flan's Mod");
  
  public static KeyBinding eject = new KeyBinding("Kickout Passengers", 24, "Flan's Mod");
  
  public static KeyBinding openBorders = new KeyBinding("Allow Passengers", 25, "Flan's Mod");
  
  public static KeyBinding bolterino = new KeyBinding("Manual Gun Loading", 46, "Flan's Mod");
  
  public static KeyBinding thermal = new KeyBinding("Thermal / Night Sight", 21, "Flan's Mod");
  
  public static KeyBinding artilleryMode = new KeyBinding("Magic Camera", 22, "Flan's Mod");
  
  public static KeyBinding repairKey = new KeyBinding("Repair Key", 23, "Flan's Mod");
  
  public static KeyBinding activeRadar = new KeyBinding("Active Radar Toggle", 66, "Flan's Mod");
  
  public static KeyBinding switchWeapon = new KeyBinding("Ammo Switch", 48, "Flan's Mod");
  
  public static KeyBinding missileUp = new KeyBinding("Missile Up", 200, "Flan's Mod");
  
  public static KeyBinding missileDown = new KeyBinding("Missile Down", 208, "Flan's Mod");
  
  public static KeyBinding missileLeft = new KeyBinding("Missile Left", 203, "Flan's Mod");
  
  public static KeyBinding missileRight = new KeyBinding("Missile Right", 205, "Flan's Mod");
  
  Minecraft mc;
  
  public KeyInputHandler() {
    ClientRegistry.registerKeyBinding(downKey);
    ClientRegistry.registerKeyBinding(inventoryKey);
    ClientRegistry.registerKeyBinding(gunKey);
    ClientRegistry.registerKeyBinding(controlSwitchKey);
    ClientRegistry.registerKeyBinding(bombKey);
    ClientRegistry.registerKeyBinding(reloadKey);
    ClientRegistry.registerKeyBinding(gunModeKey);
    ClientRegistry.registerKeyBinding(teamsMenuKey);
    ClientRegistry.registerKeyBinding(teamsScoresKey);
    ClientRegistry.registerKeyBinding(leftRollKey);
    ClientRegistry.registerKeyBinding(rightRollKey);
    ClientRegistry.registerKeyBinding(gearKey);
    ClientRegistry.registerKeyBinding(doorKey);
    ClientRegistry.registerKeyBinding(trimKey);
    ClientRegistry.registerKeyBinding(modeKey);
    ClientRegistry.registerKeyBinding(flareKey);
    ClientRegistry.registerKeyBinding(debugKey);
    ClientRegistry.registerKeyBinding(reloadModelsKey);
    ClientRegistry.registerKeyBinding(secondaryKey);
    ClientRegistry.registerKeyBinding(nintendoSwitch);
    ClientRegistry.registerKeyBinding(s0);
    ClientRegistry.registerKeyBinding(s1);
    ClientRegistry.registerKeyBinding(s2);
    ClientRegistry.registerKeyBinding(s3);
    ClientRegistry.registerKeyBinding(s4);
    ClientRegistry.registerKeyBinding(s5);
    ClientRegistry.registerKeyBinding(s6);
    ClientRegistry.registerKeyBinding(s7);
    ClientRegistry.registerKeyBinding(s8);
    ClientRegistry.registerKeyBinding(s9);
    ClientRegistry.registerKeyBinding(eject);
    ClientRegistry.registerKeyBinding(openBorders);
    ClientRegistry.registerKeyBinding(thermal);
    ClientRegistry.registerKeyBinding(artilleryMode);
    ClientRegistry.registerKeyBinding(bolterino);
    ClientRegistry.registerKeyBinding(repairKey);
    ClientRegistry.registerKeyBinding(activeRadar);
    ClientRegistry.registerKeyBinding(switchWeapon);
    ClientRegistry.registerKeyBinding(missileUp);
    ClientRegistry.registerKeyBinding(missileDown);
    ClientRegistry.registerKeyBinding(missileLeft);
    ClientRegistry.registerKeyBinding(missileRight);
    this.mc = Minecraft.func_71410_x();
  }
  
  @SubscribeEvent
  public void onKeyInput(InputEvent.KeyInputEvent event) {
    if (FMLClientHandler.instance().isGUIOpen(GuiChat.class) || this.mc.field_71462_r != null)
      return; 
    EntityClientPlayerMP entityClientPlayerMP = this.mc.field_71439_g;
    Entity ridingEntity = ((EntityPlayer)entityClientPlayerMP).field_70154_o;
    if (teamsMenuKey.func_151468_f()) {
      this.mc.func_147108_a((GuiScreen)new GuiTeamSelect());
      return;
    } 
    if (teamsScoresKey.func_151468_f()) {
      this.mc.func_147108_a((GuiScreen)new GuiTeamScores());
      return;
    } 
    if (reloadKey.func_151468_f() && FlansModClient.shootTime(false) <= 0.0F) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketReload(false));
      return;
    } 
    if (gunModeKey.func_151468_f()) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunMode(1));
      return;
    } 
    if (bolterino.func_151468_f()) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketBolterino(true));
      return;
    } 
    if (secondaryKey.func_151468_f()) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunMode(2));
      return;
    } 
    if (debugKey.func_151468_f())
      if (FlansMod.DEBUG) {
        FlansMod.DEBUG = false;
      } else {
        FlansMod.packetHandler.sendToServer((PacketBase)new PacketRequestDebug());
      }  
    if (reloadModelsKey.func_151468_f())
      FlansModClient.reloadModels(Keyboard.isKeyDown(42)); 
    if (ridingEntity instanceof IControllable) {
      IControllable riding = (IControllable)ridingEntity;
      if (this.mc.field_71474_y.field_74351_w.func_151468_f())
        riding.pressKey(0, (EntityPlayer)entityClientPlayerMP); 
      if (this.mc.field_71474_y.field_74368_y.func_151468_f())
        riding.pressKey(1, (EntityPlayer)entityClientPlayerMP); 
      if (this.mc.field_71474_y.field_74370_x.func_151468_f())
        riding.pressKey(2, (EntityPlayer)entityClientPlayerMP); 
      if (this.mc.field_71474_y.field_74366_z.func_151468_f())
        riding.pressKey(3, (EntityPlayer)entityClientPlayerMP); 
      if (this.mc.field_71474_y.field_74314_A.func_151468_f())
        riding.pressKey(4, (EntityPlayer)entityClientPlayerMP); 
      if (downKey.func_151468_f())
        riding.pressKey(5, (EntityPlayer)entityClientPlayerMP); 
      if (this.mc.field_71474_y.field_74311_E.func_151468_f())
        riding.pressKey(6, (EntityPlayer)entityClientPlayerMP); 
      if (this.mc.field_71474_y.field_151445_Q.func_151468_f() || inventoryKey.func_151468_f())
        riding.pressKey(7, (EntityPlayer)entityClientPlayerMP); 
      if (bombKey.func_151468_f())
        riding.pressKey(8, (EntityPlayer)entityClientPlayerMP); 
      if (gunKey.func_151468_f())
        riding.pressKey(9, (EntityPlayer)entityClientPlayerMP); 
      if (controlSwitchKey.func_151468_f())
        riding.pressKey(10, (EntityPlayer)entityClientPlayerMP); 
      if (leftRollKey.func_151468_f())
        riding.pressKey(11, (EntityPlayer)entityClientPlayerMP); 
      if (rightRollKey.func_151468_f())
        riding.pressKey(12, (EntityPlayer)entityClientPlayerMP); 
      if (gearKey.func_151468_f())
        riding.pressKey(13, (EntityPlayer)entityClientPlayerMP); 
      if (doorKey.func_151468_f())
        riding.pressKey(14, (EntityPlayer)entityClientPlayerMP); 
      if (modeKey.func_151468_f())
        riding.pressKey(15, (EntityPlayer)entityClientPlayerMP); 
      if (trimKey.func_151468_f())
        riding.pressKey(16, (EntityPlayer)entityClientPlayerMP); 
      if (flareKey.func_151468_f())
        riding.pressKey(18, (EntityPlayer)entityClientPlayerMP); 
      if (nintendoSwitch.func_151468_f())
        riding.pressKey(19, (EntityPlayer)entityClientPlayerMP); 
      if (s0.func_151468_f())
        riding.pressKey(20, (EntityPlayer)entityClientPlayerMP); 
      if (s1.func_151468_f())
        riding.pressKey(21, (EntityPlayer)entityClientPlayerMP); 
      if (s2.func_151468_f())
        riding.pressKey(22, (EntityPlayer)entityClientPlayerMP); 
      if (s3.func_151468_f())
        riding.pressKey(23, (EntityPlayer)entityClientPlayerMP); 
      if (s4.func_151468_f())
        riding.pressKey(24, (EntityPlayer)entityClientPlayerMP); 
      if (s5.func_151468_f())
        riding.pressKey(25, (EntityPlayer)entityClientPlayerMP); 
      if (s6.func_151468_f())
        riding.pressKey(26, (EntityPlayer)entityClientPlayerMP); 
      if (s7.func_151468_f())
        riding.pressKey(27, (EntityPlayer)entityClientPlayerMP); 
      if (s8.func_151468_f())
        riding.pressKey(28, (EntityPlayer)entityClientPlayerMP); 
      if (s9.func_151468_f())
        riding.pressKey(29, (EntityPlayer)entityClientPlayerMP); 
      if (eject.func_151468_f())
        riding.pressKey(30, (EntityPlayer)entityClientPlayerMP); 
      if (openBorders.func_151468_f())
        riding.pressKey(31, (EntityPlayer)entityClientPlayerMP); 
      if (thermal.func_151468_f())
        riding.pressKey(32, (EntityPlayer)entityClientPlayerMP); 
      if (artilleryMode.func_151468_f())
        riding.pressKey(33, (EntityPlayer)entityClientPlayerMP); 
      if (repairKey.func_151468_f())
        riding.pressKey(34, (EntityPlayer)entityClientPlayerMP); 
      if (activeRadar.func_151468_f())
        riding.pressKey(35, (EntityPlayer)entityClientPlayerMP); 
      if (switchWeapon.func_151468_f())
        riding.pressKey(36, (EntityPlayer)entityClientPlayerMP); 
      if (missileUp.func_151468_f())
        riding.pressKey(37, (EntityPlayer)entityClientPlayerMP); 
      if (missileDown.func_151468_f())
        riding.pressKey(38, (EntityPlayer)entityClientPlayerMP); 
      if (missileLeft.func_151468_f())
        riding.pressKey(39, (EntityPlayer)entityClientPlayerMP); 
      if (missileRight.func_151468_f())
        riding.pressKey(40, (EntityPlayer)entityClientPlayerMP); 
    } 
  }
}
