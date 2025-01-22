package com.flansmod.client;

import com.flansmod.api.IControllable;
import com.flansmod.client.gui.GuiDriveableController;
import com.flansmod.client.gui.GuiTeamScores;
import com.flansmod.client.model.GunAnimations;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.IScope;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.network.PacketBlood;
import com.flansmod.common.network.PacketTeamInfo;
import com.flansmod.common.teams.ArmourType;
import com.flansmod.common.teams.ItemTeamArmour;
import com.flansmod.common.teams.Team;
import com.flansmod.common.types.InfoType;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiScreen;
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
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Property;
import org.lwjgl.opengl.GL11;

public class FlansModClient extends FlansMod {
  public static boolean doneTutorial;
  
  public static boolean controlModeMouse;
  
  public static int controlModeSwitchTimer;
  
  public static float shootTimeLeft;
  
  public static float shootTimeRight;
  
  public static int stabTimeLeft;
  
  public static int stabTimeRight;
  
  public static float playerRecoilPitch;
  
  public static float playerRecoilYaw;
  
  public static float antiRecoilPitch;
  
  public static float antiRecoilYaw;
  
  public static int shotState;
  
  public static int lastBulletReload;
  
  public static int vehicleEngineRevs;
  
  public static int scopeTime;
  
  public static IScope currentScope;
  
  public static float zoomProgress;
  
  public static float lastZoomProgress;
  
  public static float stanceProgress;
  
  public static float lastStanceProgress;
  
  public static float lastZoomLevel;
  
  public static float lastFOVZoomLevel;
  
  public static float cringe;
  
  public static float pupperino;
  
  public ShaderGroup trueFacts;
  
  public static float originalMouseSensitivity;
  
  public static float originalFOV;
  
  public static int originalThirdPerson;
  
  public static boolean inPlane;
  
  public static PacketTeamInfo teamInfo;
  
  public static PacketBlood blood;
  
  public static int teamsScoreGUILock;
  
  public static AimType aimType;
  
  public static FlanMouseButton fireButton;
  
  public static FlanMouseButton aimButton;
  
  public static float fov;
  
  public static Minecraft minecraft;
  
  public static float peepee;
  
  public static float previousPeepee;
  
  public static float previousFOV;
  
  public static float poopoo;
  
  public static float originalPitch = 0.0F;
  
  public static float originalYaw;
  
  public static float sustainedRecoilPitch;
  
  public static float unsustainedRecoil;
  
  public static float sustainedRecoilYaw;
  
  public static float animator = 0.0F;
  
  public static float netRecoil = 0.0F;
  
  public static boolean hitMarker = false;
  
  public static boolean hitMarkerHeadshot = false;
  
  public static float hitMarkerPenAmount = 1.0F;
  
  public static boolean hitMarkerExplosion = false;
  
  public static int shieldHit;
  
  public static float recoilElevator = 0.0F;
  
  public static float sustainedElevator = 0.0F;
  
  public static float firstShotRecoil = 0.0F;
  
  public static int lamperino = 0;
  
  public static boolean starStruck = false;
  
  public static int screenShake;
  
  public void load() {
    log("Loading Flan's mod client side.");
    MinecraftForge.EVENT_BUS.register(this);
  }
  
  @SubscribeEvent
  public void renderOffHandGun(RenderPlayerEvent.Specials.Post event) {
    RenderPlayer renderer = event.renderer;
    EntityPlayer player = event.entityPlayer;
    float dt = event.partialRenderTick;
    PlayerData data = PlayerHandler.getPlayerData(player, Side.CLIENT);
    ItemStack gunStack = null;
    if (player instanceof net.minecraft.client.entity.EntityOtherPlayerMP) {
      gunStack = data.offHandGunStack;
    } else {
      ItemStack currentStack = player.func_71045_bC();
      if (currentStack == null || !(currentStack.func_77973_b() instanceof ItemGun) || !((ItemGun)currentStack.func_77973_b()).type.oneHanded || data.offHandGunSlot == 0)
        return; 
      gunStack = player.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
    } 
    if (gunStack == null || !(gunStack.func_77973_b() instanceof ItemGun))
      return; 
    GunType gunType = ((ItemGun)gunStack.func_77973_b()).type;
    GL11.glPushMatrix();
    renderer.field_77109_a.field_78113_g.func_78794_c(0.0625F);
    GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
    float f2 = 1.0F;
    GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
    GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
    GL11.glScalef(-1.0F, -1.0F, 1.0F);
    int k = gunStack.func_77973_b().func_82790_a(gunStack, 0);
    float f3 = (k >> 16 & 0xFF) / 255.0F;
    float f4 = (k >> 8 & 0xFF) / 255.0F;
    float f5 = (k & 0xFF) / 255.0F;
    GL11.glColor4f(f3, f4, f5, 1.0F);
    ClientProxy.gunRenderer.renderOffHandGun(player, gunStack);
    GL11.glPopMatrix();
  }
  
  private float interpolateRotation(float x, float y, float dT) {
    float f3;
    for (f3 = y - x; f3 < -180.0F; f3 += 360.0F);
    while (f3 >= 180.0F)
      f3 -= 360.0F; 
    return x + dT * f3;
  }
  
  @SubscribeEvent
  public void renderLiving(RenderPlayerEvent.Pre event) {
    PlayerData data = PlayerHandler.getPlayerData(event.entityPlayer, Side.CLIENT);
    if (data != null && data.snapshots[0] != null)
      data.snapshots[0].renderSnapshot(); 
    RendererLivingEntity.NAME_TAG_RANGE = 64.0F;
    RendererLivingEntity.NAME_TAG_RANGE_SNEAK = 32.0F;
    if (event.entity instanceof EntityPlayer && FlansModClient.teamInfo != null) {
      PacketTeamInfo teamInfo = FlansModClient.teamInfo;
      if (PacketTeamInfo.gametype != null) {
        String s = "No Gametype";
        PacketTeamInfo teamInfo2 = FlansModClient.teamInfo;
        if (!"No Gametype".equals(PacketTeamInfo.gametype)) {
          PacketTeamInfo teamInfo3 = FlansModClient.teamInfo;
          PacketTeamInfo.PlayerScoreData rendering = PacketTeamInfo.getPlayerScoreData(event.entity.func_70005_c_());
          PacketTeamInfo teamInfo4 = FlansModClient.teamInfo;
          PacketTeamInfo.PlayerScoreData thePlayer = PacketTeamInfo.getPlayerScoreData(minecraft.field_71439_g.func_70005_c_());
          Team renderingTeam = (rendering == null) ? Team.spectators : rendering.team.team;
          Team thePlayerTeam = (thePlayer == null) ? Team.spectators : thePlayer.team.team;
          if (data.skin == null)
            data.skin = ((AbstractClientPlayer)event.entityPlayer).func_110306_p(); 
          if (data.skin != null) {
            ResourceLocation skin = (rendering == null || rendering.playerClass == null) ? null : FlansModResourceHandler.getTexture((InfoType)rendering.playerClass);
            ((AbstractClientPlayer)event.entityPlayer).func_152121_a(MinecraftProfileTexture.Type.SKIN, (skin == null) ? data.skin : skin);
          } 
          if (thePlayerTeam == Team.spectators)
            return; 
          if (renderingTeam == Team.spectators) {
            event.setCanceled(true);
            return;
          } 
          if (renderingTeam != thePlayerTeam) {
            RendererLivingEntity.NAME_TAG_RANGE = 0.0F;
            RendererLivingEntity.NAME_TAG_RANGE_SNEAK = 0.0F;
            return;
          } 
          PacketTeamInfo teamInfo5 = FlansModClient.teamInfo;
          if (!PacketTeamInfo.sortedByTeam) {
            RendererLivingEntity.NAME_TAG_RANGE = 0.0F;
            RendererLivingEntity.NAME_TAG_RANGE_SNEAK = 0.0F;
          } 
        } 
      } 
    } 
  }
  
  public static float shootTime(boolean left) {
    return left ? shootTimeLeft : shootTimeRight;
  }
  
  public static int stabTime(boolean left) {
    return left ? stabTimeLeft : stabTimeRight;
  }
  
  public static void tick() {
    if (minecraft.field_71439_g == null || minecraft.field_71441_e == null)
      return; 
    if (PlayerHandler.getPlayerData((EntityPlayer)minecraft.field_71439_g) != null && (PlayerHandler.getPlayerData((EntityPlayer)minecraft.field_71439_g)).shieldHit > 0) {
      shieldHit = (PlayerHandler.getPlayerData((EntityPlayer)minecraft.field_71439_g)).shieldHit;
    } else {
      shieldHit = 0;
    } 
    if (lamperino > 0)
      lamperino--; 
    if (lamperino > 50)
      lamperino = 50; 
    if (lamperino <= 0)
      starStruck = false; 
    if (lamperino > 1) {
      starStruck = true;
      minecraft.field_71474_y.field_74333_Y = 0.4F + lamperino / 18.0F;
    } 
    List<Entity> foxes = minecraft.field_71439_g.field_70170_p.func_72839_b((Entity)minecraft.field_71439_g, AxisAlignedBB.func_72330_a(minecraft.field_71439_g.field_70165_t - 200.0D, minecraft.field_71439_g.field_70163_u - 500.0D, minecraft.field_71439_g.field_70161_v - 200.0D, minecraft.field_71439_g.field_70165_t + 200.0D, minecraft.field_71439_g.field_70163_u + 500.0D, minecraft.field_71439_g.field_70161_v + 200.0D));
    for (Entity stuff : foxes) {
      if (!(stuff instanceof EntityBullet))
        continue; 
      EntityBullet missile = (EntityBullet)stuff;
      if (missile != null) {
        if (!missile.type.starShell)
          continue; 
        if (lamperino < 100 && missile.type.starShell)
          lamperino += 2; 
      } 
    } 
    if (minecraft.field_71439_g.field_70154_o instanceof IControllable && minecraft.field_71462_r == null)
      minecraft.func_147108_a((GuiScreen)new GuiDriveableController((IControllable)minecraft.field_71439_g.field_70154_o)); 
    if (FlansModClient.teamInfo != null) {
      PacketTeamInfo teamInfo = FlansModClient.teamInfo;
      if (PacketTeamInfo.timeLeft > 0) {
        PacketTeamInfo teamInfo2 = FlansModClient.teamInfo;
        PacketTeamInfo.timeLeft--;
      } 
    } 
    if (teamsScoreGUILock > 0) {
      teamsScoreGUILock--;
      if (minecraft.field_71462_r == null)
        minecraft.func_147108_a((GuiScreen)new GuiTeamScores()); 
    } 
    if (shootTimeLeft > 0.0F)
      shootTimeLeft--; 
    if (shootTimeRight > 0.0F)
      shootTimeRight--; 
    if (stabTimeLeft > 0)
      stabTimeLeft--; 
    if (stabTimeRight > 0)
      stabTimeRight--; 
    if (scopeTime > 0)
      scopeTime--; 
    if (playerRecoilPitch > 0.0F || playerRecoilPitch < 0.0F) {
      playerRecoilPitch *= 0.95F;
      if (peepee >= 20.0F) {
        playerRecoilPitch *= 0.65F + 0.35F * (peepee - 20.0F) / 80.0F;
        peepee -= 3.0F;
      } else {
        playerRecoilPitch *= 0.65F;
        peepee = (float)(peepee * 0.88D);
      } 
    } 
    if (playerRecoilYaw > 0.0F || playerRecoilYaw < 0.0F)
      playerRecoilYaw *= 0.95F; 
    if (peepee > 105.0F)
      peepee = 100.0F; 
    if (screenShake == 0) {
      previousFOV = minecraft.field_71474_y.field_74334_X;
    } else {
      minecraft.field_71474_y.field_74334_X = previousFOV + 0.1F * screenShake * (1.0F + peepee / 70.0F);
    } 
    if (screenShake > 0)
      screenShake = 0; 
    if (screenShake < -100) {
      screenShake += 5;
    } else if (screenShake < -90) {
      screenShake = (int)(screenShake + 4.5D);
    } else if (screenShake < -80) {
      screenShake += 4;
    } else if (screenShake < -70) {
      screenShake = (int)(screenShake + 3.5D);
    } else if (screenShake < -60) {
      screenShake += 3;
    } else if (screenShake < -50) {
      screenShake = (int)(screenShake + 2.5D);
    } else if (screenShake < -40) {
      screenShake += 2;
    } else if (screenShake < -30) {
      screenShake = (int)(screenShake + 1.5D);
    } else if (screenShake < -15) {
      screenShake++;
    } else if (screenShake < 0) {
      screenShake = (int)(screenShake + 0.5F);
    } 
    if (peepee > 0.1F) {
      if (antiRecoilPitch < 69.0F)
        antiRecoilPitch += playerRecoilPitch; 
      if (antiRecoilYaw < 69.0F)
        antiRecoilYaw += playerRecoilYaw; 
    } 
    if (playerRecoilPitch > 0.0F) {
      minecraft.field_71439_g.field_70125_A -= playerRecoilPitch;
      netRecoil -= playerRecoilPitch;
      minecraft.field_71439_g.field_70177_z -= playerRecoilYaw;
    } 
    if (antiRecoilPitch > 0.01D && peepee < 20.0F) {
      minecraft.field_71439_g.field_70125_A += (peepee + 10.0F) / 30.0F * antiRecoilPitch * 0.3F;
      netRecoil += antiRecoilPitch * 0.2F;
      antiRecoilPitch *= 0.8F;
    } else if (peepee >= 20.0F) {
      float peepeeRatio = (peepee - 20.0F) / 80.0F;
      float recoilRatio = 0.9F * playerRecoilPitch / sustainedRecoilPitch;
      if (recoilRatio > 1.0F)
        recoilRatio = 0.95F; 
      antiRecoilPitch -= 0.3F * antiRecoilPitch - peepeeRatio * 0.3F * antiRecoilPitch + playerRecoilPitch * recoilRatio * peepeeRatio;
      minecraft.field_71439_g.field_70125_A = (float)(minecraft.field_71439_g.field_70125_A + (playerRecoilPitch * recoilRatio * peepeeRatio) + 0.3D * antiRecoilPitch - peepeeRatio * 0.3D * antiRecoilPitch);
      netRecoil = (float)(netRecoil + (playerRecoilPitch * recoilRatio * peepeeRatio) + 0.3D * antiRecoilPitch - peepeeRatio * 0.3D * antiRecoilPitch);
    } 
    if (peepee < 0.01D)
      netRecoil = (float)(netRecoil * 0.8D); 
    if (antiRecoilYaw > 0.0F)
      if (peepee < 7.0F) {
        minecraft.field_71439_g.field_70177_z += antiRecoilYaw * 0.1F;
        antiRecoilYaw *= 0.9F;
        if (antiRecoilPitch < 2.0F)
          antiRecoilPitch = 0.0F; 
      } else if (peepee < 20.0F && peepee >= 7.0F) {
        minecraft.field_71439_g.field_70177_z += antiRecoilYaw * 0.05F;
        antiRecoilYaw *= 0.95F;
      } else if (peepee < 40.0F && peepee >= 20.0F) {
        minecraft.field_71439_g.field_70177_z += antiRecoilYaw * 0.03F;
        antiRecoilYaw *= 0.97F;
      } else if (peepee < 60.0F && peepee >= 40.0F) {
        minecraft.field_71439_g.field_70177_z += antiRecoilYaw * 0.01F;
        antiRecoilYaw *= 0.99F;
      } else if (peepee < 80.0F && peepee >= 60.0F) {
        minecraft.field_71439_g.field_70177_z += antiRecoilYaw * 0.005F;
        antiRecoilYaw *= 0.995F;
      } else {
        minecraft.field_71439_g.field_70177_z += playerRecoilYaw * 0.1F;
        antiRecoilYaw -= playerRecoilYaw * 0.1F;
      }  
    if (currentScope == null)
      minecraft.field_71474_y.field_74336_f = true; 
    minecraft.field_71474_y.field_74362_aa = 0;
    RenderManager.field_85095_o = false;
    if (minecraft.field_71439_g != null)
      if (minecraft.field_71439_g.func_70115_ae()) {
        ShaderGroup test = (Minecraft.func_71410_x()).field_71460_t.func_147706_e();
        if (minecraft.field_71439_g.field_70154_o != null && 
          minecraft.field_71439_g.field_70154_o instanceof EntitySeat) {
          EntityDriveable entityCringe = ((EntitySeat)minecraft.field_71439_g.field_70154_o).driveable;
          if (minecraft.field_71439_g.field_70154_o instanceof EntitySeat)
            if (entityCringe != null && entityCringe.artilleryMode)
              minecraft.field_71474_y.field_74320_O = 1;  
          if (minecraft.field_71439_g.field_70154_o instanceof EntitySeat)
            if (entityCringe != null && entityCringe.thermalScoping) {
              if (!(Minecraft.func_71410_x()).field_71460_t.func_147702_a()) {
                (Minecraft.func_71410_x()).field_71460_t.func_147705_c();
                (Minecraft.func_71410_x()).field_71460_t.func_147705_c();
                (Minecraft.func_71410_x()).field_71460_t.func_147705_c();
                (Minecraft.func_71410_x()).field_71460_t.func_147705_c();
                (Minecraft.func_71410_x()).field_71460_t.func_147705_c();
                (Minecraft.func_71410_x()).field_71460_t.func_147705_c();
              } 
              minecraft.field_71474_y.field_74320_O = 0;
              minecraft.field_71474_y.field_74333_Y = 0.55F;
            } else {
              (Minecraft.func_71410_x()).field_71460_t.func_147703_b();
              if (!starStruck)
                minecraft.field_71474_y.field_74333_Y = 0.4F; 
            }  
          if (((EntitySeat)minecraft.field_71439_g.field_70154_o).seatInfo.passengerZoom != 1.0F || (entityCringe != null && entityCringe.aiming))
            minecraft.field_71474_y.field_74320_O = 0; 
        } 
      } else {
        (Minecraft.func_71410_x()).field_71460_t.func_147703_b();
        if (!starStruck)
          minecraft.field_71474_y.field_74333_Y = 0.4F; 
      }  
    for (GunAnimations g : gunAnimationsRight.values())
      g.update(); 
    for (GunAnimations g : gunAnimationsLeft.values())
      g.update(); 
    for (Object obj : minecraft.field_71441_e.field_73010_i) {
      EntityPlayer player = (EntityPlayer)obj;
      ItemStack currentItem = player.func_71045_bC();
      if (currentItem != null && currentItem.func_77973_b() instanceof ItemGun) {
        if (player == minecraft.field_71439_g && minecraft.field_71474_y.field_74320_O == 0) {
          player.func_71041_bz();
          continue;
        } 
        if (currentItem.func_77975_n() != EnumAction.bow && currentItem.func_77975_n() != EnumAction.block)
          continue; 
        player.func_71008_a(currentItem, 100);
      } 
    } 
    Item itemInHand = null;
    ItemStack itemstackInHand = minecraft.field_71439_g.field_71071_by.func_70448_g();
    if (itemstackInHand != null)
      itemInHand = itemstackInHand.func_77973_b(); 
    if (currentScope != null && (itemInHand == null || !(itemInHand instanceof ItemGun) || ((ItemGun)itemInHand).type.getCurrentScope(itemstackInHand) != currentScope)) {
      currentScope = null;
      minecraft.field_71474_y.field_74341_c = originalMouseSensitivity;
      minecraft.field_71474_y.field_74320_O = originalThirdPerson;
      if (minecraft.field_71439_g.field_71071_by.field_70460_b[3] == null)
        minecraft.field_71474_y.field_74334_X = originalFOV; 
    } 
    lastZoomProgress = zoomProgress;
    if (currentScope == null && zoomProgress - lastZoomProgress <= 0.01F) {
      zoomProgress *= 0.66F;
    } else {
      zoomProgress = 1.0F - (1.0F - zoomProgress) * 0.66F;
      minecraft.field_71474_y.field_74336_f = false;
    } 
    lastStanceProgress = stanceProgress;
    if (!inPlane) {
      stanceProgress *= 0.66F;
    } else {
      stanceProgress = 1.0F - (1.0F - stanceProgress) * 0.66F;
    } 
    if (minecraft.field_71439_g.field_70154_o instanceof IControllable) {
      inPlane = true;
      try {
        ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, minecraft.field_71460_t, Float.valueOf(((IControllable)minecraft.field_71439_g.field_70154_o).getPlayerRoll()), new String[] { "camRoll", "R", "field_78495_O" });
      } catch (Exception e) {
        log("I forgot to update obfuscated reflection D:");
        throw new RuntimeException(e);
      } 
      if (minecraft.field_71439_g.field_70154_o instanceof IControllable)
        try {
          ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, minecraft.field_71460_t, Float.valueOf(((IControllable)minecraft.field_71439_g.field_70154_o).getCameraDistance()), new String[] { "thirdPersonDistance", "E", "field_78490_B" });
        } catch (Exception e) {
          log("I forgot to update obfuscated reflection D:");
          throw new RuntimeException(e);
        }  
    } else if (inPlane) {
      try {
        ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, minecraft.field_71460_t, Float.valueOf(0.0F), new String[] { "camRoll", "R", "field_78495_O" });
      } catch (Exception e) {
        log("I forgot to update obfuscated reflection D:");
        throw new RuntimeException(e);
      } 
      try {
        ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, minecraft.field_71460_t, Float.valueOf(4.0F), new String[] { "thirdPersonDistance", "E", "field_78490_B" });
      } catch (Exception e) {
        log("I forgot to update obfuscated reflection D:");
        throw new RuntimeException(e);
      } 
      inPlane = false;
    } 
    if (controlModeSwitchTimer > 0)
      controlModeSwitchTimer--; 
  }
  
  public static void renderTick(float smoothing) {
    if (Math.abs(zoomProgress - lastZoomProgress) > 1.0E-4F) {
      float actualZoomProgress = lastZoomProgress + (zoomProgress - lastZoomProgress) * smoothing;
      float botchedZoomProgress = (zoomProgress > 0.8F) ? 1.0F : 0.0F;
      double zoomLevel = (botchedZoomProgress * lastZoomLevel + 1.0F - botchedZoomProgress);
      float FOVZoomLevel = actualZoomProgress * lastFOVZoomLevel + 1.0F - actualZoomProgress;
      if (Math.abs(zoomLevel - 1.0D) < 0.009999999776482582D)
        zoomLevel = 1.0D; 
      ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, minecraft.field_71460_t, Double.valueOf(zoomLevel), new String[] { "cameraZoom", "af", "field_78503_V" });
      if (minecraft.field_71439_g.field_71071_by.field_70460_b[3] == null)
        float f = (FOVZoomLevel - 1.0F) / 0.25F; 
    } 
    if (minecraft.field_71439_g != null && FlansModClient.cringe < 1.01D) {
      ItemStack stack = minecraft.field_71439_g.field_71071_by.field_70460_b[3];
      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour) {
        ArmourType cringe = ((ItemTeamArmour)stack.func_77973_b()).type;
        if ((cringe.faceArmor / cringe.headArmor) <= 0.1D || cringe.faceArmor == 1.0F || cringe.faceArmor == 0.0F) {
          if (minecraft.field_71474_y.field_74334_X > 100.0F) {
            minecraft.field_71474_y.field_74334_X = 110.0F;
            pupperino = 110.0F;
          } 
        } else if ((cringe.faceArmor / cringe.headArmor) > 0.1D && (cringe.faceArmor / cringe.headArmor) <= 0.3D) {
          if (minecraft.field_71474_y.field_74334_X > 95.0F) {
            minecraft.field_71474_y.field_74334_X = 95.0F;
            pupperino = 95.0F;
          } 
        } else if ((cringe.faceArmor / cringe.headArmor) > 0.3D && (cringe.faceArmor / cringe.headArmor) <= 0.6D) {
          if (minecraft.field_71474_y.field_74334_X > 80.0F) {
            minecraft.field_71474_y.field_74334_X = 80.0F;
            pupperino = 80.0F;
          } 
        } else if ((cringe.faceArmor / cringe.headArmor) > 0.6D && (cringe.faceArmor / cringe.headArmor) <= 0.8D) {
          minecraft.field_71474_y.field_74334_X = 65.0F;
          pupperino = 65.0F;
        } else if ((cringe.faceArmor / cringe.headArmor) > 0.8D && cringe.faceArmor / cringe.headArmor <= 100.0F) {
          minecraft.field_71474_y.field_74334_X = 55.0F;
          pupperino = 55.0F;
        } else {
          pupperino = 70.0F;
        } 
      } 
    } 
  }
  
  @SubscribeEvent
  public void chatMessage(ClientChatReceivedEvent event) {
    if (event.message.func_150260_c().equals("#flansmod"))
      event.setCanceled(true); 
  }
  
  private boolean checkFileExists(File file) {
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (Exception e) {
        FlansMod.log("Failed to create file");
        FlansMod.log(file.getAbsolutePath());
      } 
      return false;
    } 
    return true;
  }
  
  public static boolean flipControlMode() {
    if (controlModeSwitchTimer > 0)
      return false; 
    controlModeMouse = !controlModeMouse;
    FMLClientHandler.instance().getClient().func_147108_a(controlModeMouse ? (GuiScreen)new GuiDriveableController((IControllable)(FMLClientHandler.instance().getClient()).field_71439_g.field_70154_o) : null);
    controlModeSwitchTimer = 40;
    return true;
  }
  
  public static void reloadModels(boolean reloadSkins) {
    for (InfoType type : InfoType.infoTypes)
      type.reloadModel(); 
    if (reloadSkins)
      proxy.forceReload(); 
  }
  
  public static Team getTeam(int spawnerTeamID) {
    if (teamInfo == null)
      return null; 
    return teamInfo.getTeam(spawnerTeamID);
  }
  
  public static boolean isCurrentMap(String map) {
    if (FlansModClient.teamInfo != null) {
      PacketTeamInfo teamInfo = FlansModClient.teamInfo;
      if (PacketTeamInfo.mapShortName != null) {
        PacketTeamInfo teamInfo2 = FlansModClient.teamInfo;
        if (PacketTeamInfo.mapShortName.equals(map))
          return true; 
      } 
    } 
    return false;
  }
  
  @SideOnly(Side.CLIENT)
  public static EntityFX getParticle(String s, World w, double x, double y, double z) {
    EntityDiggingFX entityDiggingFX;
    Minecraft mc = Minecraft.func_71410_x();
    EntityFX fx = null;
    if (s.equals("hugeexplosion")) {
      EntityHugeExplodeFX entityHugeExplodeFX = new EntityHugeExplodeFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("largeexplode")) {
      EntityLargeExplodeFX entityLargeExplodeFX = new EntityLargeExplodeFX(mc.field_71446_o, w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("fireworksSpark")) {
      EntityFireworkSparkFX entityFireworkSparkFX = new EntityFireworkSparkFX(w, x, y, z, 0.0D, 0.0D, 0.0D, mc.field_71452_i);
    } else if (s.equals("bubble")) {
      EntityBubbleFX entityBubbleFX = new EntityBubbleFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("suspended")) {
      EntitySuspendFX entitySuspendFX = new EntitySuspendFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("faggot")) {
      fx = new EntityAfterburn(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("arabe")) {
      fx = new EntitySmokeBurst(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("protoFlame")) {
      fx = new EntityFMFlame(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("nuclear")) {
      fx = new EntityFMNuke(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("shippuDeath")) {
      fx = new EntityshipDeath(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("tankkuDeath")) {
      fx = new EntitytankDeath(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("waterSmoke")) {
      fx = new EntityWaterSmoke(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("waterSmokeMini")) {
      fx = new EntityWaterSmokeMini(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("smokeShell")) {
      fx = new EntitySmokeShell(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("smokeShellMustard")) {
      fx = new EntitySmokeShellMustard(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("smokeShellChlorine")) {
      fx = new EntitySmokeShellChlorine(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("smallSmoke")) {
      fx = new EntitySmallSmoke(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("shipSmoke")) {
      fx = new EntityShipSmoke(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("casing")) {
      fx = new EntityShellCasing(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("blood")) {
      fx = new Entityblood(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("overkill")) {
      fx = new EntityOverKill(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("depthsuspend")) {
      EntityAuraFX entityAuraFX = new EntityAuraFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("townaura")) {
      EntityAuraFX entityAuraFX = new EntityAuraFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("crit")) {
      EntityCritFX entityCritFX = new EntityCritFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("magicCrit")) {
      EntityCritFX entityCritFX = new EntityCritFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      entityCritFX.func_70538_b(entityCritFX.func_70534_d() * 0.3F, entityCritFX.func_70542_f() * 0.8F, entityCritFX.func_70535_g());
      entityCritFX.func_94053_h();
    } else if (s.equals("smoke")) {
      EntitySmokeFX entitySmokeFX = new EntitySmokeFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("mobSpell")) {
      EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      entitySpellParticleFX.func_70538_b(0.0F, 0.0F, 0.0F);
    } else if (s.equals("mobSpellAmbient")) {
      EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      entitySpellParticleFX.func_82338_g(0.15F);
      entitySpellParticleFX.func_70538_b(0.0F, 0.0F, 0.0F);
    } else if (s.equals("spell")) {
      EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("instantSpell")) {
      EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      entitySpellParticleFX.func_70589_b(144);
    } else if (s.equals("witchMagic")) {
      EntitySmokeFX entitySmokeFX = new EntitySmokeFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      ((EntitySpellParticleFX)entitySmokeFX).func_70589_b(144);
      float f = w.field_73012_v.nextFloat() * 0.5F + 0.35F;
      entitySmokeFX.func_70538_b(1.0F * f, 0.0F * f, 1.0F * f);
    } else if (s.equals("note")) {
      EntityNoteFX entityNoteFX = new EntityNoteFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("portal")) {
      EntityPortalFX entityPortalFX = new EntityPortalFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("enchantmenttable")) {
      EntityEnchantmentTableParticleFX entityEnchantmentTableParticleFX = new EntityEnchantmentTableParticleFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("explode")) {
      EntityExplodeFX entityExplodeFX = new EntityExplodeFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("flame")) {
      EntityFlameFX entityFlameFX = new EntityFlameFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("lava")) {
      EntityLavaFX entityLavaFX = new EntityLavaFX(w, x, y, z);
    } else if (s.equals("footstep")) {
      EntityFootStepFX entityFootStepFX = new EntityFootStepFX(mc.field_71446_o, w, x, y, z);
    } else if (s.equals("splash")) {
      EntitySplashFX entitySplashFX = new EntitySplashFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("wake")) {
      EntityFishWakeFX entityFishWakeFX = new EntityFishWakeFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("largesmoke")) {
      EntitySmokeFX entitySmokeFX = new EntitySmokeFX(w, x, y, z, 0.0D, 0.0D, 0.0D, 2.5F);
    } else if (s.equals("cloud")) {
      EntityCloudFX entityCloudFX = new EntityCloudFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("reddust")) {
      EntityReddustFX entityReddustFX = new EntityReddustFX(w, x, y, z, 0.0F, 0.0F, 0.0F);
    } else if (s.equals("snowballpoof")) {
      EntityBreakingFX entityBreakingFX = new EntityBreakingFX(w, x, y, z, Items.field_151126_ay);
    } else if (s.equals("dripWater")) {
      EntityDropParticleFX entityDropParticleFX = new EntityDropParticleFX(w, x, y, z, Material.field_151586_h);
    } else if (s.equals("dripLava")) {
      EntityDropParticleFX entityDropParticleFX = new EntityDropParticleFX(w, x, y, z, Material.field_151587_i);
    } else if (s.equals("snowshovel")) {
      EntitySnowShovelFX entitySnowShovelFX = new EntitySnowShovelFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("slime")) {
      EntityBreakingFX entityBreakingFX = new EntityBreakingFX(w, x, y, z, Items.field_151123_aH);
    } else if (s.equals("heart")) {
      EntityHeartFX entityHeartFX = new EntityHeartFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("angryVillager")) {
      EntityHeartFX entityHeartFX = new EntityHeartFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      entityHeartFX.func_70536_a(81);
      entityHeartFX.func_70538_b(1.0F, 1.0F, 1.0F);
    } else if (s.equals("happyVillager")) {
      EntityAuraFX entityAuraFX = new EntityAuraFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
      entityAuraFX.func_70536_a(82);
      entityAuraFX.func_70538_b(1.0F, 1.0F, 1.0F);
    } else if (s.equals("snowshovel")) {
      EntitySnowShovelFX entitySnowShovelFX = new EntitySnowShovelFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("snowshovel")) {
      EntitySnowShovelFX entitySnowShovelFX = new EntitySnowShovelFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.equals("snowshovel")) {
      EntitySnowShovelFX entitySnowShovelFX = new EntitySnowShovelFX(w, x, y, z, 0.0D, 0.0D, 0.0D);
    } else if (s.startsWith("iconcrack_")) {
      String[] astring = s.split("_", 3);
      int j = Integer.parseInt(astring[1]);
      if (astring.length > 2) {
        int k = Integer.parseInt(astring[2]);
        EntityBreakingFX entityBreakingFX = new EntityBreakingFX(w, x, y, z, 0.0D, 0.0D, 0.0D, Item.func_150899_d(j), k);
      } else {
        EntityBreakingFX entityBreakingFX = new EntityBreakingFX(w, x, y, z, 0.0D, 0.0D, 0.0D, Item.func_150899_d(j), 0);
      } 
    } else if (s.startsWith("blockcrack_")) {
      String[] astring = s.split("_", 3);
      Block block = Block.func_149729_e(Integer.parseInt(astring[1]));
      int k = Integer.parseInt(astring[2]);
      entityDiggingFX = (new EntityDiggingFX(w, x, y, z, 0.0D, 0.0D, 0.0D, block, k)).func_90019_g(k);
    } else if (s.startsWith("blockdust_")) {
      String[] astring = s.split("_", 3);
      Block block = Block.func_149729_e(Integer.parseInt(astring[1]));
      int k = Integer.parseInt(astring[2]);
      entityDiggingFX = (new EntityBlockDustFX(w, x, y, z, 0.0D, 0.0D, 0.0D, block, k)).func_90019_g(k);
    } 
    if (mc.field_71474_y.field_74347_j)
      ((EntityFX)entityDiggingFX).field_70155_l = 200.0D; 
    if (entityDiggingFX != null)
      mc.field_71452_i.func_78873_a((EntityFX)entityDiggingFX); 
    return (EntityFX)entityDiggingFX;
  }
  
  public static GunAnimations getGunAnimations(EntityLivingBase living, boolean offHand) {
    GunAnimations animations = null;
    if (offHand) {
      if (gunAnimationsLeft.containsKey(living)) {
        animations = (GunAnimations)gunAnimationsLeft.get(living);
      } else {
        animations = new GunAnimations();
        gunAnimationsLeft.put(living, animations);
      } 
    } else if (gunAnimationsRight.containsKey(living)) {
      animations = (GunAnimations)gunAnimationsRight.get(living);
    } else {
      animations = new GunAnimations();
      gunAnimationsRight.put(living, animations);
    } 
    return animations;
  }
  
  public static void setAimType(AimType aimInputType) {
    Property cw = FlansMod.configFile.get("Settings", "Aim Type", "toggle", "The type of aiming that you want to use 'toggle' or 'hold'");
    cw.set(aimInputType.toString());
    FlansMod.configFile.save();
    aimType = aimInputType;
  }
  
  public static void setAimButton(FlanMouseButton buttonInput) {
    Property cw = FlansMod.configFile.get("Settings", "Aim Button", "left", "The mouse button used to aim a gun 'left' or 'right'");
    cw.set(buttonInput.toString());
    FlansMod.configFile.save();
    aimButton = buttonInput;
  }
  
  public static void setFireButton(FlanMouseButton buttonInput) {
    Property cw = FlansMod.configFile.get("Settings", "Fire Button", "right", "The mouse button used to fire a gun 'left' or 'right'");
    cw.set(buttonInput.toString());
    FlansMod.configFile.save();
    fireButton = buttonInput;
  }
  
  static {
    doneTutorial = false;
    controlModeMouse = true;
    controlModeSwitchTimer = 20;
    shotState = -1;
    lastBulletReload = 0;
    vehicleEngineRevs = 14539;
    currentScope = null;
    zoomProgress = 0.0F;
    lastZoomProgress = 0.0F;
    stanceProgress = 0.0F;
    lastStanceProgress = 0.0F;
    lastZoomLevel = 1.0F;
    lastFOVZoomLevel = 1.0F;
    cringe = 1.0F;
    pupperino = 69.0F;
    originalMouseSensitivity = 0.5F;
    originalFOV = 70.0F;
    originalThirdPerson = 0;
    inPlane = false;
    teamsScoreGUILock = 0;
    minecraft = FMLClientHandler.instance().getClient();
  }
}
