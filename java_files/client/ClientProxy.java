package com.flansmod.client;

import com.flansmod.client.debug.EntityDebugAABB;
import com.flansmod.client.debug.EntityDebugDot;
import com.flansmod.client.debug.EntityDebugVector;
import com.flansmod.client.debug.RenderDebugAABB;
import com.flansmod.client.debug.RenderDebugDot;
import com.flansmod.client.debug.RenderDebugVector;
import com.flansmod.client.gui.GuiArmourBox;
import com.flansmod.client.gui.GuiDriveableCrafting;
import com.flansmod.client.gui.GuiDriveableFuel;
import com.flansmod.client.gui.GuiDriveableInventory;
import com.flansmod.client.gui.GuiDriveableMenu;
import com.flansmod.client.gui.GuiDriveableRepair;
import com.flansmod.client.gui.GuiGunBox;
import com.flansmod.client.gui.GuiGunModTable;
import com.flansmod.client.gui.GuiMechaInventory;
import com.flansmod.client.gui.GuiPaintjobTable;
import com.flansmod.client.model.RenderAAGun;
import com.flansmod.client.model.RenderBullet;
import com.flansmod.client.model.RenderFlag;
import com.flansmod.client.model.RenderFlagpole;
import com.flansmod.client.model.RenderGrenade;
import com.flansmod.client.model.RenderGun;
import com.flansmod.client.model.RenderMG;
import com.flansmod.client.model.RenderMecha;
import com.flansmod.client.model.RenderNull;
import com.flansmod.client.model.RenderParachute;
import com.flansmod.client.model.RenderPlane;
import com.flansmod.client.model.RenderVehicle;
import com.flansmod.common.CommonProxy;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EntityWheel;
import com.flansmod.common.driveables.EnumPlaneMode;
import com.flansmod.common.driveables.PlaneType;
import com.flansmod.common.driveables.VehicleType;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.driveables.mechas.MechaType;
import com.flansmod.common.guns.EntityAAGun;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.EntityGrenade;
import com.flansmod.common.guns.EntityMG;
import com.flansmod.common.guns.GrenadeType;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.boxes.BlockGunBox;
import com.flansmod.common.guns.boxes.GunBoxType;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketBuyArmour;
import com.flansmod.common.network.PacketBuyWeapon;
import com.flansmod.common.network.PacketCraftDriveable;
import com.flansmod.common.network.PacketGiveItem;
import com.flansmod.common.network.PacketRepairDriveable;
import com.flansmod.common.paintjob.TileEntityPaintjobTable;
import com.flansmod.common.teams.ArmourBoxType;
import com.flansmod.common.teams.BlockArmourBox;
import com.flansmod.common.teams.EntityFlag;
import com.flansmod.common.teams.EntityFlagpole;
import com.flansmod.common.teams.TileEntitySpawner;
import com.flansmod.common.tools.EntityParachute;
import com.flansmod.common.types.InfoType;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLModContainer;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.discovery.ContainerType;
import cpw.mods.fml.common.discovery.ModCandidate;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.client.particle.EntityBlockDustFX;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.client.particle.EntityBubbleFX;
import net.minecraft.client.particle.EntityCloudFX;
import net.minecraft.client.particle.EntityCritFX;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityDropParticleFX;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.client.particle.EntityExplodeFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.client.particle.EntityFishWakeFX;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntityFootStepFX;
import net.minecraft.client.particle.EntityHeartFX;
import net.minecraft.client.particle.EntityHugeExplodeFX;
import net.minecraft.client.particle.EntityLargeExplodeFX;
import net.minecraft.client.particle.EntityLavaFX;
import net.minecraft.client.particle.EntityNoteFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.particle.EntitySnowShovelFX;
import net.minecraft.client.particle.EntitySpellParticleFX;
import net.minecraft.client.particle.EntitySplashFX;
import net.minecraft.client.particle.EntitySuspendFX;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class ClientProxy extends CommonProxy {
  public static String modelDir = "com.flansmod.client.model.";
  
  public static RenderGun gunRenderer;
  
  public static RenderGrenade grenadeRenderer;
  
  public static RenderPlane planeRenderer;
  
  public static RenderVehicle vehicleRenderer;
  
  public static RenderMecha mechaRenderer;
  
  public static String facts;
  
  public List<File> contentPacks;
  
  public void load() {
    (new FlansModClient()).load();
    gunRenderer = new RenderGun();
    grenadeRenderer = new RenderGrenade();
    planeRenderer = new RenderPlane();
    vehicleRenderer = new RenderVehicle();
    mechaRenderer = new RenderMecha();
    for (GunType gunType : GunType.guns.values())
      MinecraftForgeClient.registerItemRenderer(gunType.item, (IItemRenderer)gunRenderer); 
    for (GrenadeType grenadeType : GrenadeType.grenades)
      MinecraftForgeClient.registerItemRenderer(grenadeType.item, (IItemRenderer)grenadeRenderer); 
    for (PlaneType planeType : PlaneType.types)
      MinecraftForgeClient.registerItemRenderer(planeType.item, (IItemRenderer)planeRenderer); 
    for (VehicleType vehicleType : VehicleType.types)
      MinecraftForgeClient.registerItemRenderer(vehicleType.item, (IItemRenderer)vehicleRenderer); 
    for (MechaType mechaType : MechaType.types)
      MinecraftForgeClient.registerItemRenderer(mechaType.item, (IItemRenderer)mechaRenderer); 
    FMLCommonHandler.instance().bus().register(new KeyInputHandler());
    new TickHandlerClient();
    MinecraftForge.EVENT_BUS.register(new PlaneHUD());
    facts = "u";
    FlansMod.log(facts);
  }
  
  public void forceReload() {
    Minecraft.func_71410_x().func_110436_a();
  }
  
  public List<File> getContentList(Method method, ClassLoader classloader) {
    this.contentPacks = new ArrayList<>();
    for (File file : FlansMod.flanDir.listFiles()) {
      if (file.isDirectory() || zipJar.matcher(file.getName()).matches()) {
        try {
          method.invoke(classloader, new Object[] { file.toURI().toURL() });
          HashMap<String, Object> map = new HashMap<>();
          map.put("modid", "FlansMod");
          map.put("name", "Flan's Mod : " + file.getName());
          map.put("version", "1");
          FMLModContainer container = new FMLModContainer("com.flansmod.common.FlansMod", new ModCandidate(file, file, file.isDirectory() ? ContainerType.DIR : ContainerType.JAR), map);
          container.bindMetadata(MetadataCollection.from(null, ""));
          FMLClientHandler.instance().addModAsResource((ModContainer)container);
        } catch (Exception e) {
          FlansMod.log("Failed to load images for content pack : " + file.getName());
          e.printStackTrace();
        } 
        FlansMod.log("Loaded content pack : " + file.getName());
        this.contentPacks.add(file);
      } 
    } 
    FlansMod.log("Loaded textures and models.");
    return this.contentPacks;
  }
  
  public void registerRenderers() {
    RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, (Render)new RenderBullet());
    RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, (Render)new RenderGrenade());
    RenderingRegistry.registerEntityRenderingHandler(EntityPlane.class, (Render)new RenderPlane());
    RenderingRegistry.registerEntityRenderingHandler(EntityVehicle.class, (Render)new RenderVehicle());
    RenderingRegistry.registerEntityRenderingHandler(EntityAAGun.class, (Render)new RenderAAGun());
    RenderingRegistry.registerEntityRenderingHandler(EntityFlagpole.class, (Render)new RenderFlagpole());
    RenderingRegistry.registerEntityRenderingHandler(EntityFlag.class, (Render)new RenderFlag());
    RenderingRegistry.registerEntityRenderingHandler(EntitySeat.class, (Render)new RenderNull());
    RenderingRegistry.registerEntityRenderingHandler(EntityWheel.class, (Render)new RenderNull());
    RenderingRegistry.registerEntityRenderingHandler(EntityMG.class, (Render)new RenderMG());
    RenderingRegistry.registerEntityRenderingHandler(EntityParachute.class, (Render)new RenderParachute());
    RenderingRegistry.registerEntityRenderingHandler(EntityDebugDot.class, (Render)new RenderDebugDot());
    RenderingRegistry.registerEntityRenderingHandler(EntityDebugVector.class, (Render)new RenderDebugVector());
    RenderingRegistry.registerEntityRenderingHandler(EntityDebugAABB.class, (Render)new RenderDebugAABB());
    RenderingRegistry.registerEntityRenderingHandler(EntityMecha.class, (Render)new RenderMecha());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpawner.class, new TileEntitySpawnerRenderer());
  }
  
  public void doTutorialStuff(EntityPlayer player, EntityDriveable entityType) {
    player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.inventoryKey.func_151463_i()) + " to open the menu"));
    player.func_146105_b((IChatComponent)new ChatComponentText("Hold " + Keyboard.getKeyName((Minecraft.func_71410_x()).field_71474_y.field_74311_E.func_151463_i()) + " to get out"));
    player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.eject.func_151463_i()) + " to eject and ban passengers"));
    player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.openBorders.func_151463_i()) + " to allow passengers again"));
    if (entityType instanceof EntityPlane) {
      player.func_146105_b((IChatComponent)new ChatComponentText("Hold " + Keyboard.getKeyName(KeyInputHandler.nintendoSwitch.func_151463_i()) + " to switch seats"));
      player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.controlSwitchKey.func_151463_i()) + " for mouse control mode"));
      if ((PlaneType.getPlane(((EntityPlane)entityType).driveableType)).hasGear)
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.gearKey.func_151463_i()) + " to switch the gear")); 
      if ((PlaneType.getPlane(((EntityPlane)entityType).driveableType)).hasDoor)
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.doorKey.func_151463_i()) + " to switch the doors")); 
      if ((PlaneType.getPlane(((EntityPlane)entityType).driveableType)).hasAfterBurner)
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.trimKey.func_151463_i()) + " to toggle afterburner")); 
      if ((PlaneType.getPlane(((EntityPlane)entityType).driveableType)).mode == EnumPlaneMode.VTOL) {
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.modeKey.func_151463_i()) + " to switch VTOL mode"));
      } else if ((PlaneType.getPlane(((EntityPlane)entityType).driveableType)).mode != EnumPlaneMode.VTOL && (PlaneType.getPlane(((EntityPlane)entityType).driveableType)).mode == EnumPlaneMode.PLANE) {
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.modeKey.func_151463_i()) + " to toggle landing flaps"));
      } 
      if ((PlaneType.getPlane(((EntityPlane)entityType).driveableType)).carrierLandable || (PlaneType.getPlane(((EntityPlane)entityType).driveableType)).helipadLandable)
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.gunKey.func_151463_i()) + " to dock on helipad / floatplane hangar")); 
      if ((entityType.getDriveableType()).hasMagicArtilleryMode)
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.artilleryMode.func_151463_i()) + " to toggle magic ammo vision")); 
    } 
    if (entityType instanceof EntityVehicle) {
      player.func_146105_b((IChatComponent)new ChatComponentText("Hold " + Keyboard.getKeyName(KeyInputHandler.nintendoSwitch.func_151463_i()) + " to switch seats"));
      if ((((EntityVehicle)entityType).getVehicleType()).tank)
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.leftRollKey.func_151463_i()) + " to lock a tank turret / cannon")); 
      if ((((EntityVehicle)entityType).getVehicleType()).tank)
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.rightRollKey.func_151463_i()) + " to unlock a tank turret / cannon")); 
      if ((((EntityVehicle)entityType).getVehicleType()).thermalSight)
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.thermal.func_151463_i()) + " to toggle thermal sights")); 
      if ((entityType.getDriveableType()).hasMagicArtilleryMode)
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.artilleryMode.func_151463_i()) + " to toggle magic ammo vision")); 
      if ((entityType.getDriveableType()).hasRadar)
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.artilleryMode.func_151463_i()) + " to toggle active / passive radar")); 
      if ((entityType.getDriveableType()).hasScope)
        player.func_146105_b((IChatComponent)new ChatComponentText("Press " + Keyboard.getKeyName(KeyInputHandler.downKey.func_151463_i()) + " to toggle gun optic")); 
      player.func_146105_b((IChatComponent)new ChatComponentText("Hold the spacebar to brake"));
    } 
  }
  
  public void changeControlMode(EntityPlayer player) {
    if (FlansModClient.flipControlMode())
      player.func_146105_b((IChatComponent)new ChatComponentText("Mouse Control mode is now set to " + FlansModClient.controlModeMouse)); 
  }
  
  public boolean mouseControlEnabled() {
    return FlansModClient.controlModeMouse;
  }
  
  public Object getClientGui(int ID, EntityPlayer player, World world, int x, int y, int z) {
    if (((ID >= 6 && ID <= 10) || ID == 12) && player.field_70154_o == null)
      return null; 
    switch (ID) {
      case 0:
        return new GuiDriveableCrafting(player.field_71071_by, world, x, y, z);
      case 1:
        return new GuiDriveableRepair(player);
      case 2:
        return new GuiGunModTable(player.field_71071_by, world);
      case 5:
        return new GuiGunBox(player.field_71071_by, ((BlockGunBox)world.func_147439_a(x, y, z)).type, world);
      case 6:
        return new GuiDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 0);
      case 7:
        return new GuiDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 1);
      case 8:
        return new GuiDriveableFuel(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable);
      case 9:
        return new GuiDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 2);
      case 10:
        return new GuiMechaInventory(player.field_71071_by, world, (EntityMecha)((EntitySeat)player.field_70154_o).driveable);
      case 11:
        return new GuiArmourBox(player.field_71071_by, ((BlockArmourBox)world.func_147439_a(x, y, z)).type);
      case 12:
        return new GuiDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 3);
      case 13:
        return new GuiPaintjobTable(player.field_71071_by, world, (TileEntityPaintjobTable)world.func_147438_o(x, y, z));
    } 
    return null;
  }
  
  public void openDriveableMenu(EntityPlayer player, World world, EntityDriveable driveable) {
    FMLClientHandler.instance().getClient().func_147108_a((GuiScreen)new GuiDriveableMenu(player.field_71071_by, world, driveable));
  }
  
  private String getModelName(String in) {
    String[] split = in.split("\\.");
    if (split.length == 1)
      return "Model" + in; 
    if (split.length > 1) {
      String out = "Model" + split[split.length - 1];
      for (int i = split.length - 2; i >= 0; i--)
        out = split[i] + "." + out; 
      return out;
    } 
    return in;
  }
  
  public <T> T loadModel(String s, String shortName, Class<T> typeClass) {
    if (s == null || shortName == null)
      return null; 
    try {
      return typeClass.cast(Class.forName(modelDir + getModelName(s)).getConstructor(new Class[0]).newInstance(new Object[0]));
    } catch (Exception e) {
      FlansMod.log("Failed to load model : " + shortName + " (" + s + ")");
      if (FlansMod.printStackTrace)
        e.printStackTrace(); 
      return null;
    } 
  }
  
  public void loadSound(String contentPack, String type, String sound) {
    FlansModResourceHandler.getSound(sound);
  }
  
  public boolean isThePlayer(EntityPlayer player) {
    return (player == (FMLClientHandler.instance().getClient()).field_71439_g);
  }
  
  public EntityPlayer getThePlayer() {
    return (EntityPlayer)(FMLClientHandler.instance().getClient()).field_71439_g;
  }
  
  public boolean isOnSameTeamClientPlayer(EntityLivingBase entity) {
    return (FMLClientHandler.instance().getClient()).field_71439_g.func_142014_c(entity);
  }
  
  public void buyGun(GunBoxType type, InfoType gun) {
    FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketBuyWeapon(type, gun));
    FlansModClient.shootTimeLeft = FlansModClient.shootTimeRight = 10.0F;
    FlansModClient.stabTimeLeft = FlansModClient.stabTimeRight = 10;
  }
  
  public void buyArmour(String shortName, int piece, ArmourBoxType box) {
    FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketBuyArmour(box.shortName, shortName, piece));
    FlansModClient.shootTimeLeft = FlansModClient.shootTimeRight = 10.0F;
    FlansModClient.stabTimeLeft = FlansModClient.stabTimeRight = 10;
  }
  
  public void addItem(EntityPlayer player, int id) {
    super.addItem(player, id);
    if (player.field_70170_p.field_72995_K)
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGiveItem(57)); 
  }
  
  public void craftDriveable(EntityPlayer player, DriveableType type) {
    super.craftDriveable(player, type);
    if (player.field_70170_p.field_72995_K)
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketCraftDriveable(type.shortName)); 
  }
  
  public void repairDriveable(EntityPlayer driver, EntityDriveable driving, DriveablePart part) {
    super.repairDriveable(driver, driving, part);
    if (driver.field_70170_p.field_72995_K)
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketRepairDriveable(part.type)); 
  }
  
  public boolean isScreenOpen() {
    return ((Minecraft.func_71410_x()).field_71462_r != null);
  }
  
  public boolean isKeyDown(int key) {
    switch (key) {
      case 0:
        return keyDown((Minecraft.func_71410_x()).field_71474_y.field_74351_w.func_151463_i());
      case 1:
        return keyDown((Minecraft.func_71410_x()).field_71474_y.field_74368_y.func_151463_i());
      case 2:
        return keyDown((Minecraft.func_71410_x()).field_71474_y.field_74370_x.func_151463_i());
      case 3:
        return keyDown((Minecraft.func_71410_x()).field_71474_y.field_74366_z.func_151463_i());
      case 4:
        return keyDown((Minecraft.func_71410_x()).field_71474_y.field_74314_A.func_151463_i());
    } 
    return false;
  }
  
  public boolean keyDown(int keyCode) {
    boolean state = (keyCode < 0) ? Mouse.isButtonDown(keyCode + 100) : Keyboard.isKeyDown(keyCode);
    return state;
  }
  
  public void spawnParticle(String s, double x, double y, double z, double mx, double my, double mz) {
    try {
      this;
      doSpawnParticle(s, x, y, z, mx, my, mz);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
  }
  
  private static EntityFX doSpawnParticle(String p_72726_1_, double p_72726_2_, double p_72726_4_, double p_72726_6_, double p_72726_8_, double p_72726_10_, double p_72726_12_) {
    Minecraft mc = Minecraft.func_71410_x();
    WorldClient worldClient = mc.field_71441_e;
    if (mc != null && mc.field_71451_h != null && mc.field_71452_i != null) {
      EntityFireworkSparkFX entityFireworkSparkFX;
      EntityDiggingFX entityDiggingFX;
      int i = mc.field_71474_y.field_74362_aa;
      if (i == 1 && ((World)worldClient).field_73012_v.nextInt(3) == 0)
        i = 2; 
      double d6 = mc.field_71451_h.field_70165_t - p_72726_2_;
      double d7 = mc.field_71451_h.field_70163_u - p_72726_4_;
      double d8 = mc.field_71451_h.field_70161_v - p_72726_6_;
      EntityFX entityfx = null;
      if (p_72726_1_.equals("hugeexplosion")) {
        EntityHugeExplodeFX entityHugeExplodeFX;
        mc.field_71452_i.func_78873_a((EntityFX)(entityHugeExplodeFX = new EntityHugeExplodeFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_)));
      } else if (p_72726_1_.equals("largeexplode")) {
        EntityLargeExplodeFX entityLargeExplodeFX;
        mc.field_71452_i.func_78873_a((EntityFX)(entityLargeExplodeFX = new EntityLargeExplodeFX(mc.field_71446_o, (World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_)));
      } else if (p_72726_1_.equals("fireworksSpark")) {
        mc.field_71452_i.func_78873_a((EntityFX)(entityFireworkSparkFX = new EntityFireworkSparkFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, mc.field_71452_i)));
      } 
      if (entityFireworkSparkFX != null)
        return (EntityFX)entityFireworkSparkFX; 
      double d9 = 160.0D;
      if (d6 * d6 + d7 * d7 + d8 * d8 > d9 * d9)
        return null; 
      if (i > 1)
        return null; 
      if (p_72726_1_.equals("flansmod.flare"))
        EntityFlare entityFlare = new EntityFlare((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.smokeShell"))
        EntitySmokeShell entitySmokeShell = new EntitySmokeShell((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.smokeShellMustard"))
        EntitySmokeShellMustard entitySmokeShellMustard = new EntitySmokeShellMustard((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.smokeShellChlorine"))
        EntitySmokeShellChlorine entitySmokeShellChlorine = new EntitySmokeShellChlorine((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.gunSmoke"))
        EntitySmallSmoke entitySmallSmoke = new EntitySmallSmoke((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.shipSmoke"))
        EntityShipSmoke entityShipSmoke = new EntityShipSmoke((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.blood"))
        Entityblood entityblood = new Entityblood((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.overkill"))
        EntityOverKill entityOverKill = new EntityOverKill((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.FMNuke"))
        EntityFMNuke entityFMNuke = new EntityFMNuke((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.shipDeath"))
        EntityshipDeath entityshipDeath = new EntityshipDeath((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.tankDeath"))
        EntitytankDeath entitytankDeath = new EntitytankDeath((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.WaterSmoke"))
        EntityWaterSmoke entityWaterSmoke = new EntityWaterSmoke((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.WaterSmokeMini"))
        EntityWaterSmokeMini entityWaterSmokeMini = new EntityWaterSmokeMini((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.smoker"))
        EntitySmokeGrenade entitySmokeGrenade = new EntitySmokeGrenade((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.flasher"))
        EntityAPSGrenade entityAPSGrenade = new EntityAPSGrenade((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.flash"))
        EntityFlash entityFlash = new EntityFlash((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.smokeburst"))
        EntitySmokeBurst entitySmokeBurst = new EntitySmokeBurst((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.bigsmoke"))
        EntityBigSmoke entityBigSmoke = new EntityBigSmoke((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.debris1"))
        EntityDebris1 entityDebris1 = new EntityDebris1((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.fmflame"))
        EntityFMFlame entityFMFlame = new EntityFMFlame((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.fmtracer"))
        EntityFMTracer entityFMTracer = new EntityFMTracer((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.fmtracergreen"))
        EntityFMTracerGreen entityFMTracerGreen = new EntityFMTracerGreen((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.fmtracerred"))
        EntityFMTracerRed entityFMTracerRed = new EntityFMTracerRed((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.afterburn"))
        EntityAfterburn entityAfterburn = new EntityAfterburn((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.fmsmoke"))
        EntityFMSmoke entityFMSmoke = new EntityFMSmoke((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("flansmod.rocketexhaust"))
        EntityRocketexhaust entityRocketexhaust = new EntityRocketexhaust((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_); 
      if (p_72726_1_.equals("bubble")) {
        EntityBubbleFX entityBubbleFX = new EntityBubbleFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("suspended")) {
        EntitySuspendFX entitySuspendFX = new EntitySuspendFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("depthsuspend")) {
        EntityAuraFX entityAuraFX = new EntityAuraFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("townaura")) {
        EntityAuraFX entityAuraFX = new EntityAuraFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("crit")) {
        EntityCritFX entityCritFX = new EntityCritFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("magicCrit")) {
        EntityCritFX entityCritFX = new EntityCritFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        entityCritFX.func_70538_b(entityCritFX.func_70534_d() * 0.3F, entityCritFX.func_70542_f() * 0.8F, entityCritFX.func_70535_g());
        entityCritFX.func_94053_h();
      } else if (p_72726_1_.equals("smoke")) {
        EntitySmokeFX entitySmokeFX = new EntitySmokeFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("mobSpell")) {
        EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, 0.0D, 0.0D, 0.0D);
        entitySpellParticleFX.func_70538_b((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
      } else if (p_72726_1_.equals("mobSpellAmbient")) {
        EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, 0.0D, 0.0D, 0.0D);
        entitySpellParticleFX.func_82338_g(0.15F);
        entitySpellParticleFX.func_70538_b((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
      } else if (p_72726_1_.equals("spell")) {
        EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("instantSpell")) {
        EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        entitySpellParticleFX.func_70589_b(144);
      } else if (p_72726_1_.equals("witchMagic")) {
        EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        entitySpellParticleFX.func_70589_b(144);
        float f = ((World)worldClient).field_73012_v.nextFloat() * 0.5F + 0.35F;
        entitySpellParticleFX.func_70538_b(1.0F * f, 0.0F * f, 1.0F * f);
      } else if (p_72726_1_.equals("note")) {
        EntityNoteFX entityNoteFX = new EntityNoteFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("portal")) {
        EntityPortalFX entityPortalFX = new EntityPortalFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("enchantmenttable")) {
        EntityEnchantmentTableParticleFX entityEnchantmentTableParticleFX = new EntityEnchantmentTableParticleFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("explode")) {
        EntityExplodeFX entityExplodeFX = new EntityExplodeFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("flame")) {
        EntityFlameFX entityFlameFX = new EntityFlameFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("lava")) {
        EntityLavaFX entityLavaFX = new EntityLavaFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_);
      } else if (p_72726_1_.equals("footstep")) {
        EntityFootStepFX entityFootStepFX = new EntityFootStepFX(mc.field_71446_o, (World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_);
      } else if (p_72726_1_.equals("splash")) {
        EntitySplashFX entitySplashFX = new EntitySplashFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("wake")) {
        EntityFishWakeFX entityFishWakeFX = new EntityFishWakeFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("largesmoke")) {
        EntitySmokeFX entitySmokeFX = new EntitySmokeFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, 2.5F);
      } else if (p_72726_1_.equals("cloud")) {
        EntityCloudFX entityCloudFX = new EntityCloudFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("reddust")) {
        EntityReddustFX entityReddustFX = new EntityReddustFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, (float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
      } else if (p_72726_1_.equals("snowballpoof")) {
        EntityBreakingFX entityBreakingFX = new EntityBreakingFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, Items.field_151126_ay);
      } else if (p_72726_1_.equals("dripWater")) {
        EntityDropParticleFX entityDropParticleFX = new EntityDropParticleFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, Material.field_151586_h);
      } else if (p_72726_1_.equals("dripLava")) {
        EntityDropParticleFX entityDropParticleFX = new EntityDropParticleFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, Material.field_151587_i);
      } else if (p_72726_1_.equals("snowshovel")) {
        EntitySnowShovelFX entitySnowShovelFX = new EntitySnowShovelFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("slime")) {
        EntityBreakingFX entityBreakingFX = new EntityBreakingFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, Items.field_151123_aH);
      } else if (p_72726_1_.equals("heart")) {
        EntityHeartFX entityHeartFX = new EntityHeartFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
      } else if (p_72726_1_.equals("angryVillager")) {
        EntityHeartFX entityHeartFX = new EntityHeartFX((World)worldClient, p_72726_2_, p_72726_4_ + 0.5D, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        entityHeartFX.func_70536_a(81);
        entityHeartFX.func_70538_b(1.0F, 1.0F, 1.0F);
      } else if (p_72726_1_.equals("happyVillager")) {
        EntityAuraFX entityAuraFX = new EntityAuraFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
        entityAuraFX.func_70536_a(82);
        entityAuraFX.func_70538_b(1.0F, 1.0F, 1.0F);
      } else if (p_72726_1_.startsWith("iconcrack_")) {
        String[] astring = p_72726_1_.split("_", 3);
        int j = Integer.parseInt(astring[1]);
        if (astring.length > 2) {
          int k = Integer.parseInt(astring[2]);
          EntityBreakingFX entityBreakingFX = new EntityBreakingFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.func_150899_d(j), k);
        } else {
          EntityBreakingFX entityBreakingFX = new EntityBreakingFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.func_150899_d(j), 0);
        } 
      } else if (p_72726_1_.startsWith("blockcrack_")) {
        String[] astring = p_72726_1_.split("_", 3);
        Block block = Block.func_149729_e(Integer.parseInt(astring[1]));
        int k = Integer.parseInt(astring[2]);
        entityDiggingFX = (new EntityDiggingFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, block, k)).func_90019_g(k);
      } else if (p_72726_1_.startsWith("blockdust_")) {
        String[] astring = p_72726_1_.split("_", 3);
        Block block = Block.func_149729_e(Integer.parseInt(astring[1]));
        int k = Integer.parseInt(astring[2]);
        entityDiggingFX = (new EntityBlockDustFX((World)worldClient, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, block, k)).func_90019_g(k);
      } 
      if (entityDiggingFX != null)
        mc.field_71452_i.func_78873_a((EntityFX)entityDiggingFX); 
      return (EntityFX)entityDiggingFX;
    } 
    return null;
  }
  
  public float getMouseSensitivity() {
    return (Minecraft.func_71410_x()).field_71474_y.field_74341_c;
  }
}
