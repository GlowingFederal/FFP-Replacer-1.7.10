package com.flansmod.common.guns;

import com.flansmod.client.AimType;
import com.flansmod.client.FlansModClient;
import com.flansmod.client.debug.EntityDebugDot;
import com.flansmod.client.debug.EntityDebugVector;
import com.flansmod.client.model.GunAnimations;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.guns.raytracing.BulletHit;
import com.flansmod.common.guns.raytracing.EntityHit;
import com.flansmod.common.guns.raytracing.EnumHitboxType;
import com.flansmod.common.guns.raytracing.PlayerBulletHit;
import com.flansmod.common.guns.raytracing.PlayerHitbox;
import com.flansmod.common.guns.raytracing.PlayerSnapshot;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketFlak;
import com.flansmod.common.network.PacketGunFire;
import com.flansmod.common.network.PacketGunRecoil;
import com.flansmod.common.network.PacketGunSpread;
import com.flansmod.common.network.PacketGunState;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.network.PacketReload;
import com.flansmod.common.network.PacketSelectOffHandGun;
import com.flansmod.common.paintjob.IPaintableItem;
import com.flansmod.common.paintjob.PaintableType;
import com.flansmod.common.paintjob.Paintjob;
import com.flansmod.common.teams.ItemTeamArmour;
import com.flansmod.common.teams.Team;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import com.google.common.collect.Multimap;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class ItemGun extends Item implements IPaintableItem {
  public static Random rand = new Random();
  
  public GunType type;
  
  public static boolean rightMouseHeld;
  
  private static boolean lastRightMouseHeld;
  
  private static boolean leftMouseHeld;
  
  private static boolean lastLeftMouseHeld;
  
  public static boolean DHeld;
  
  private static boolean lastDHeld;
  
  public static boolean AHeld;
  
  private static boolean lastAHeld;
  
  public static boolean WHeld;
  
  private static boolean lastWHeld;
  
  public boolean blocking = false;
  
  public boolean leftBlock = true;
  
  public boolean rightBlock = false;
  
  public boolean topBlock = false;
  
  public boolean bottomBlock = false;
  
  public static boolean crouching = false;
  
  public static boolean sprinting = false;
  
  public static boolean cringedBlockingCheckerClient = false;
  
  public static boolean mounted = false;
  
  public static boolean shooting = false;
  
  public int soundDelay;
  
  public int lockOnSoundDelay;
  
  public static boolean sliceCrossHair;
  
  public int impactX = 0;
  
  public int impactY = 0;
  
  public int impactZ = 0;
  
  public int fullHands = 0;
  
  public float bulletDamageInfo = 0.0F;
  
  public float pouchMultiplier = 1.0F;
  
  public boolean madeAmmo = false;
  
  public IIcon[] icons;
  
  public IIcon defaultIcon;
  
  public InfoType getInfoType() {
    return (InfoType)this.type;
  }
  
  public PaintableType GetPaintableType() {
    return this.type;
  }
  
  private int poopenfarden = 1;
  
  boolean canClick;
  
  public boolean func_77651_p() {
    return true;
  }
  
  public ItemStack getBulletItemStack(ItemStack gun, int id) {
    String s;
    if (!gun.func_77942_o()) {
      gun.field_77990_d = new NBTTagCompound();
      return null;
    } 
    if (this.type.getSecondaryFire(gun)) {
      s = "secondaryAmmo";
    } else {
      s = "ammo";
    } 
    if (!gun.field_77990_d.func_74764_b(s)) {
      NBTTagList nBTTagList = new NBTTagList();
      for (int i = 0; i < this.type.getNumAmmoItemsInGun(gun); i++)
        nBTTagList.func_74742_a((NBTBase)new NBTTagCompound()); 
      gun.field_77990_d.func_74782_a(s, (NBTBase)nBTTagList);
      return null;
    } 
    NBTTagList ammoTagsList = gun.field_77990_d.func_150295_c(s, 10);
    NBTTagCompound ammoTags = ammoTagsList.func_150305_b(id);
    return ItemStack.func_77949_a(ammoTags);
  }
  
  public void setBulletItemStack(ItemStack gun, ItemStack bullet, int id) {
    String s;
    if (!gun.func_77942_o())
      gun.field_77990_d = new NBTTagCompound(); 
    if (this.type.getSecondaryFire(gun)) {
      s = "secondaryAmmo";
    } else {
      s = "ammo";
    } 
    if (!gun.field_77990_d.func_74764_b(s)) {
      NBTTagList nBTTagList = new NBTTagList();
      for (int i = 0; i < this.type.getNumAmmoItemsInGun(gun); i++)
        nBTTagList.func_74742_a((NBTBase)new NBTTagCompound()); 
      gun.field_77990_d.func_74782_a(s, (NBTBase)nBTTagList);
    } 
    NBTTagList ammoTagsList = gun.field_77990_d.func_150295_c(s, 10);
    NBTTagCompound ammoTags = ammoTagsList.func_150305_b(id);
    if (bullet == null)
      ammoTags = new NBTTagCompound(); 
    bullet.func_77955_b(ammoTags);
  }
  
  public void func_77624_a(ItemStack stack, EntityPlayer player, List<String> lines, boolean advancedTooltips) {
    KeyBinding shift = (Minecraft.func_71410_x()).field_71474_y.field_74311_E;
    if (!(this.type.getPaintjob(stack.func_77960_j())).displayName.equals("default"))
      lines.add("§b§o" + (this.type.getPaintjob(stack.func_77960_j())).displayName); 
    if (this.type.swordArmorPen > 10.0F)
      lines.add("§2+Body Armor Penetration: " + this.type.swordArmorPen); 
    if (this.type.shieldDamageAbsorption > 0.1F)
      lines.add("§2+Shield Protection: " + this.type.shieldDamageAbsorption); 
    if (!this.type.packName.isEmpty())
      lines.add("§o" + this.type.packName); 
    if (this.type.description != null)
      Collections.addAll(lines, this.type.description.split("_")); 
    if (!GameSettings.func_100015_a(shift)) {
      for (int i = 0; i < this.type.getNumAmmoItemsInGun(stack); i++) {
        ItemStack bulletStack = getBulletItemStack(stack, i);
        if (bulletStack != null && bulletStack.func_77973_b() instanceof ItemBullet) {
          BulletType bulletType = ((ItemBullet)bulletStack.func_77973_b()).type;
          String line = bulletType.name + " " + (bulletStack.func_77958_k() - bulletStack.func_77960_j()) + "/" + bulletStack.func_77958_k();
          lines.add(line);
        } 
      } 
      lines.add("Hold §b§o" + GameSettings.func_74298_c(shift.func_151463_i()) + "§r§7 for details");
    } else {
      lines.add("");
      AttachmentType barrel = this.type.getBarrel(stack);
      if (barrel != null && barrel.silencer)
        lines.add("§e[Suppressed]"); 
      if (this.type.getSecondaryFire(stack))
        lines.add("§e[Underbarrel]"); 
      if (this.bulletDamageInfo != 0.0F)
        lines.add("§9Damage§7: " + this.bulletDamageInfo); 
      lines.add("§9Recoil§7: " + roundFloat(this.type.getRecoilPitch(stack), 2));
      lines.add("§9Accuracy§7: " + roundFloat(this.type.getSpread(stack, false, false), 2));
      lines.add("§9Reload Time§7: " + roundFloat(this.type.getReloadTime(stack) / 20.0F, 2) + "s");
      lines.add("§9Rounds per Minute§7: " + roundFloat(1200.0F / this.type.shootDelay, 2));
      lines.add("§9Mode§7: §f" + this.type.getFireMode(stack).toString().toLowerCase());
      lines.add("");
      lines.add("§eAttachments");
      boolean empty = true;
      for (AttachmentType attachment : this.type.getCurrentAttachments(stack)) {
        String line = attachment.name;
        lines.add(line);
        if (line != null)
          empty = false; 
      } 
      if (empty)
        lines.add("None"); 
    } 
  }
  
  @SideOnly(Side.CLIENT)
  public void onUpdateClient(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
    if (entity instanceof EntityPlayer && ((EntityPlayer)entity).field_71071_by.func_70448_g() == itemstack) {
      Minecraft mc = Minecraft.func_71410_x();
      EntityPlayer player = (EntityPlayer)entity;
      PlayerData data = PlayerHandler.getPlayerData(player, Side.CLIENT);
      if (this.soundDelay <= 0 && this.type.idleSound != null) {
        PacketPlaySound.sendSoundPacket(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, this.type.idleSoundRange, entity.field_71093_bK, this.type.idleSound, false);
        this.soundDelay = this.type.idleSoundLength;
      } 
      crouching = player.func_70093_af();
      mounted = player.func_70115_ae();
      if (this.type.deployable)
        return; 
      GameSettings gameSettings = (FMLClientHandler.instance().getClient()).field_71474_y;
      if ((FMLClientHandler.instance().getClient()).field_71462_r != null) {
        if (FlansModClient.currentScope != null) {
          FlansModClient.currentScope = null;
          gameSettings.field_74341_c = FlansModClient.originalMouseSensitivity;
          gameSettings.field_74320_O = FlansModClient.originalThirdPerson;
          gameSettings.field_74334_X = FlansModClient.originalFOV;
          FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunSpread(itemstack, this.type.getDefaultSpread(itemstack)));
        } 
      } else if (TeamsManager.violence != true && (mc.field_71476_x == null || (!(mc.field_71476_x.field_72308_g instanceof com.flansmod.common.teams.EntityFlagpole) && !(mc.field_71476_x.field_72308_g instanceof com.flansmod.common.teams.EntityFlag) && !(mc.field_71476_x.field_72308_g instanceof com.flansmod.common.teams.EntityGunItem) && (!(mc.field_71476_x.field_72308_g instanceof EntityGrenade) || !((EntityGrenade)mc.field_71476_x.field_72308_g).type.isDeployableBag)))) {
        lastRightMouseHeld = rightMouseHeld;
        lastLeftMouseHeld = leftMouseHeld;
        rightMouseHeld = Mouse.isButtonDown(FlansModClient.fireButton.getButton());
        leftMouseHeld = Mouse.isButtonDown(FlansModClient.aimButton.getButton());
        lastAHeld = AHeld;
        lastWHeld = WHeld;
        lastDHeld = DHeld;
        AHeld = GameSettings.func_100015_a((Minecraft.func_71410_x()).field_71474_y.field_74370_x);
        WHeld = GameSettings.func_100015_a((Minecraft.func_71410_x()).field_71474_y.field_74351_w);
        DHeld = GameSettings.func_100015_a((Minecraft.func_71410_x()).field_71474_y.field_74366_z);
        boolean offHandFull = false;
        if (this.type.oneHanded && FlansModClient.vehicleEngineRevs == PlayerHandler.enginePower) {
          if (data.offHandGunSlot == player.field_71071_by.field_70461_c + 1)
            data.offHandGunSlot = 0; 
          int dWheel = Mouse.getDWheel();
          if (Keyboard.isKeyDown(mc.field_71474_y.field_74311_E.func_151463_i()) && dWheel != 0)
            data.cycleOffHandItem(player, dWheel); 
          if (data.offHandGunSlot == 0)
            this.fullHands = 0; 
          if (data.offHandGunSlot != 0) {
            offHandFull = true;
            this.fullHands = 1;
            ItemStack offHandGunStack = player.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
            if (offHandGunStack != null && offHandGunStack.func_77973_b() instanceof ItemGun) {
              GunType offHandGunType = ((ItemGun)offHandGunStack.func_77973_b()).type;
              if (offHandGunType.usableByPlayers)
                if (offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.BURST && data.burstRoundsRemainingLeft > 0) {
                  if (clientSideShoot(player, offHandGunStack, offHandGunType, true))
                    player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, null); 
                } else {
                  if (leftMouseHeld && !lastLeftMouseHeld && !this.type.shootMelee) {
                    FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunFire(true, true, player.field_70177_z, player.field_70125_A));
                    if (clientSideShoot(player, offHandGunStack, offHandGunType, true)) {
                      player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, null);
                      if ((rightMouseHeld && !lastRightMouseHeld && !this.type.shootMelee) || !leftMouseHeld || lastLeftMouseHeld || !this.type.shootMelee || data.isBlockingLeft <= 0);
                    } 
                  } 
                  if ((offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.FULLAUTO || offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.MINIGUN) && !leftMouseHeld && lastLeftMouseHeld)
                    FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunFire(true, false, player.field_70177_z, player.field_70125_A)); 
                  if ((offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.FULLAUTO || offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.MINIGUN) && leftMouseHeld)
                    if (clientSideShoot(player, offHandGunStack, offHandGunType, true))
                      player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, null);  
                }  
            } else {
              data.offHandGunSlot = 0;
            } 
          } 
        } 
        if (this.type.usableByPlayers && FlansModClient.vehicleEngineRevs == PlayerHandler.enginePower && this.poopenfarden == 1)
          if (this.type.getFireMode(itemstack) == EnumFireMode.BURST && data.burstRoundsRemainingRight > 0) {
            if (clientSideShoot(player, itemstack, this.type, false))
              player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, null); 
          } else {
            if ((rightMouseHeld && !lastRightMouseHeld && !this.type.shootMelee) || (leftMouseHeld && !lastLeftMouseHeld && this.type.shootMelee && data.isBlockingLeft <= 0)) {
              if (this.type.shootMelee && this.type.meleeLeft == true && AHeld && data.stabTimeLeft <= 0.0F && data.isBlockingLeft <= 0) {
                if (player.field_70170_p.field_72995_K) {
                  GunAnimations animations = FlansModClient.getGunAnimations((EntityLivingBase)player, false);
                  animations.doMeleeLeft(this.type.meleeLeftTime);
                } 
              } else if (this.type.shootMelee && this.type.meleeRight == true && DHeld && data.stabTimeLeft <= 0.0F && data.isBlockingLeft <= 0) {
                if (player.field_70170_p.field_72995_K) {
                  GunAnimations animations = FlansModClient.getGunAnimations((EntityLivingBase)player, false);
                  animations.doMeleeRight(this.type.meleeRightTime);
                } 
              } else if (this.type.shootMelee && this.type.meleeDown == true && WHeld && data.stabTimeLeft <= 0.0F && data.isBlockingLeft <= 0) {
                if (player.field_70170_p.field_72995_K) {
                  GunAnimations animations = FlansModClient.getGunAnimations((EntityLivingBase)player, false);
                  animations.doMeleeDown(this.type.meleeDownTime);
                } 
              } else if (this.type.shootMelee && data.stabTimeLeft <= 0.0F && data.isBlockingLeft <= 0) {
                if (player.field_70170_p.field_72995_K) {
                  GunAnimations animations = FlansModClient.getGunAnimations((EntityLivingBase)player, false);
                  animations.doMelee(this.type.meleeTime);
                } 
              } 
              FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunFire(false, true, player.field_70177_z, player.field_70125_A));
              if (clientSideShoot(player, itemstack, this.type, false))
                player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, null); 
            } 
            if ((this.type.getFireMode(itemstack) == EnumFireMode.FULLAUTO || this.type.getFireMode(itemstack) == EnumFireMode.MINIGUN) && !rightMouseHeld && lastRightMouseHeld)
              FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunFire(false, false, player.field_70177_z, player.field_70125_A)); 
            if ((this.type.getFireMode(itemstack) == EnumFireMode.FULLAUTO || this.type.getFireMode(itemstack) == EnumFireMode.MINIGUN) && rightMouseHeld)
              if (clientSideShoot(player, itemstack, this.type, false))
                player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, null);  
          }  
        IScope currentScope = this.type.getCurrentScope(itemstack);
        if (FlansModClient.aimType == AimType.TOGGLE) {
          if (!offHandFull && (this.type.secondaryFunction == EnumSecondaryFunction.ADS_ZOOM || this.type.secondaryFunction == EnumSecondaryFunction.ZOOM) && Mouse.isButtonDown(FlansModClient.aimButton.getButton()) && !this.type.shootMelee && FlansModClient.scopeTime <= 0 && (FMLClientHandler.instance().getClient()).field_71462_r == null) {
            if (FlansModClient.currentScope == null) {
              FlansModClient.currentScope = currentScope;
              FlansModClient.lastZoomLevel = currentScope.getZoomFactor();
              FlansModClient.lastFOVZoomLevel = currentScope.getFOVFactor();
              float f = FlansModClient.originalMouseSensitivity = gameSettings.field_74341_c;
              gameSettings.field_74341_c = f / (float)Math.sqrt(currentScope.getZoomFactor());
              FlansModClient.originalThirdPerson = gameSettings.field_74320_O;
              gameSettings.field_74320_O = 0;
              if (Math.abs(FlansModClient.zoomProgress - FlansModClient.lastZoomProgress) < 1.0E-4F)
                FlansModClient.originalFOV = gameSettings.field_74334_X; 
              sendSpreadToServer(itemstack, player.func_70093_af(), player.func_70051_ag());
              FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunState((FlansModClient.currentScope != null)));
            } else {
              FlansModClient.currentScope = null;
              gameSettings.field_74341_c = FlansModClient.originalMouseSensitivity;
              gameSettings.field_74320_O = FlansModClient.originalThirdPerson;
              if (Math.abs(FlansModClient.zoomProgress - FlansModClient.lastZoomProgress) < 1.0E-4F)
                gameSettings.field_74334_X = FlansModClient.originalFOV; 
              FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunSpread(itemstack, this.type.getDefaultSpread(itemstack)));
              FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunState((FlansModClient.currentScope != null)));
            } 
            FlansModClient.scopeTime = 10;
          } 
        } else if (!offHandFull && (this.type.secondaryFunction == EnumSecondaryFunction.ADS_ZOOM || this.type.secondaryFunction == EnumSecondaryFunction.ZOOM) && Mouse.isButtonDown(FlansModClient.aimButton.getButton()) && (FMLClientHandler.instance().getClient()).field_71462_r == null) {
          if (FlansModClient.currentScope == null) {
            FlansModClient.currentScope = currentScope;
            FlansModClient.lastZoomLevel = currentScope.getZoomFactor();
            FlansModClient.lastFOVZoomLevel = currentScope.getFOVFactor();
            float f = FlansModClient.originalMouseSensitivity = gameSettings.field_74341_c;
            gameSettings.field_74341_c = f / (float)Math.sqrt(currentScope.getZoomFactor());
            FlansModClient.originalThirdPerson = gameSettings.field_74320_O;
            gameSettings.field_74320_O = 0;
            if (Math.abs(FlansModClient.zoomProgress - FlansModClient.lastZoomProgress) < 1.0E-4F)
              FlansModClient.originalFOV = gameSettings.field_74334_X; 
            sendSpreadToServer(itemstack, player.func_70093_af(), player.func_70051_ag());
            FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunState((FlansModClient.currentScope != null)));
          } 
          FlansModClient.scopeTime = 10;
        } else if (!Mouse.isButtonDown(FlansModClient.aimButton.getButton())) {
          if (FlansModClient.currentScope != null) {
            FlansModClient.currentScope = null;
            gameSettings.field_74341_c = FlansModClient.originalMouseSensitivity;
            gameSettings.field_74320_O = FlansModClient.originalThirdPerson;
            gameSettings.field_74334_X = FlansModClient.originalFOV;
            FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunSpread(itemstack, this.type.getDefaultSpread(itemstack)));
            FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunState((FlansModClient.currentScope != null)));
          } 
        } 
      } 
    } 
    if (this.soundDelay > 0)
      this.soundDelay--; 
  }
  
  public void sendSpreadToServer(ItemStack stack, boolean sneaking, boolean sprinting) {
    float f = (this.type.numBullets == 1) ? 0.2F : 0.8F;
    FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunSpread(stack, this.type.getSpread(stack, sneaking, sprinting) * f));
  }
  
  public boolean clientSideShoot(EntityPlayer player, ItemStack stack, GunType gunType, boolean left) {
    PlayerData data = PlayerHandler.getPlayerData(player);
    if (this.type.meleeSound != null)
      PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeSound, true); 
    if (this.type.secondaryFunctionWhenShoot != null)
      if (this.type.secondaryFunctionWhenShoot == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.meleeLeft == true && AHeld && !this.type.shootMelee) {
        if (player.field_70170_p.field_72995_K && data.isBlockingLeft <= 0) {
          GunAnimations animations = FlansModClient.getGunAnimations((EntityLivingBase)player, false);
          animations.doMeleeLeft(this.type.meleeLeftTime);
        } 
        if (player instanceof EntityPlayer && !this.type.shootMelee) {
          PlayerData whenshootdata = PlayerHandler.getPlayerData(player);
          data.doMeleeLeft(player, this.type.meleeLeftTime, this.type);
        } 
      } else if (this.type.secondaryFunctionWhenShoot == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.meleeRight == true && DHeld && !this.type.shootMelee) {
        if (player.field_70170_p.field_72995_K && data.isBlockingLeft <= 0) {
          GunAnimations animations = FlansModClient.getGunAnimations((EntityLivingBase)player, false);
          animations.doMeleeRight(this.type.meleeRightTime);
        } 
        if (player instanceof EntityPlayer && !this.type.shootMelee) {
          PlayerData whenshootdata = PlayerHandler.getPlayerData(player);
          data.doMeleeRight(player, this.type.meleeRightTime, this.type);
        } 
      } else if (this.type.secondaryFunctionWhenShoot == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.meleeDown == true && WHeld && !this.type.shootMelee) {
        if (player.field_70170_p.field_72995_K && data.isBlockingLeft <= 0) {
          GunAnimations animations = FlansModClient.getGunAnimations((EntityLivingBase)player, false);
          animations.doMeleeDown(this.type.meleeDownTime);
        } 
        if (player instanceof EntityPlayer && !this.type.shootMelee) {
          PlayerData whenshootdata = PlayerHandler.getPlayerData(player);
          data.doMeleeDown(player, this.type.meleeDownTime, this.type);
        } 
      } else if (this.type.secondaryFunctionWhenShoot == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && !this.type.shootMelee) {
        if (player.field_70170_p.field_72995_K && data.isBlockingLeft <= 0) {
          GunAnimations animations = FlansModClient.getGunAnimations((EntityLivingBase)player, false);
          animations.doMelee(this.type.meleeTime);
        } 
        if (player instanceof EntityPlayer && !this.type.shootMelee) {
          PlayerData whenshootdata = PlayerHandler.getPlayerData(player);
          data.doMelee(player, this.type.meleeTime, this.type);
        } 
      }  
    if ((FlansModClient.shootTime(left) <= 0.0F && sprinting && FlansModClient.zoomProgress > 0.5F) || (
      FlansModClient.shootTime(left) <= 0.0F && !sprinting)) {
      boolean onLastBullet = false;
      boolean hasAmmo = false;
      for (int i = 0; i < gunType.getNumAmmoItemsInGun(stack); i++) {
        ItemStack bulletStack = getBulletItemStack(stack, i);
        if (bulletStack != null && bulletStack.func_77973_b() != null && bulletStack.func_77960_j() < bulletStack.func_77958_k()) {
          if (bulletStack.func_77958_k() - bulletStack.func_77960_j() == 1 && gunType.model.slideLockOnEmpty)
            onLastBullet = true; 
          hasAmmo = true;
          break;
        } 
      } 
      if (hasAmmo) {
        AttachmentType barrel = gunType.getBarrel(stack);
        AttachmentType grip = gunType.getGrip(stack);
        boolean silenced = (barrel != null && barrel.silencer && !gunType.getSecondaryFire(stack));
        GunAnimations animations = null;
        if (left) {
          if (FlansModClient.gunAnimationsLeft.containsKey(player)) {
            animations = (GunAnimations)FlansModClient.gunAnimationsLeft.get(player);
          } else {
            animations = new GunAnimations();
            FlansModClient.gunAnimationsLeft.put(player, animations);
          } 
        } else if (FlansModClient.gunAnimationsRight.containsKey(player)) {
          animations = (GunAnimations)FlansModClient.gunAnimationsRight.get(player);
        } else {
          animations = new GunAnimations();
          FlansModClient.gunAnimationsRight.put(player, animations);
        } 
        int pumpDelay = (gunType.model == null) ? 0 : gunType.model.pumpDelay;
        int pumpTime = (gunType.model == null) ? 1 : gunType.model.pumpTime;
        int hammerDelay = (gunType.model == null) ? 0 : gunType.model.hammerDelay;
        int casingDelay = (gunType.model == null) ? 0 : gunType.model.casingDelay;
        float hammerAngle = (gunType.model == null) ? 0.0F : gunType.model.hammerAngle;
        float althammerAngle = (gunType.model == null) ? 0.0F : gunType.model.althammerAngle;
        animations.onGunEmpty(onLastBullet);
        animations.doShoot(pumpDelay, pumpTime, hammerDelay, hammerAngle, althammerAngle, casingDelay);
        if (FlansModClient.screenShake > -100)
          FlansModClient.screenShake -= 5; 
        if (left) {
          if (!this.type.shootMelee)
            FlansModClient.shootTimeLeft = gunType.getShootDelay(stack); 
          if (this.type.shootMelee)
            FlansModClient.shootTimeLeft = gunType.getShootDelay(stack); 
        } else {
          if (!this.type.shootMelee)
            FlansModClient.shootTimeRight = gunType.getShootDelay(stack); 
          if (this.type.shootMelee)
            FlansModClient.shootTimeRight = gunType.getShootDelay(stack); 
        } 
      } 
      if (gunType.getFireMode(stack) == EnumFireMode.BURST)
        if (left) {
          if (data.burstRoundsRemainingLeft > 0) {
            data.burstRoundsRemainingLeft--;
          } else {
            data.burstRoundsRemainingLeft = gunType.numBurstRounds;
          } 
        } else if (data.burstRoundsRemainingRight > 0) {
          data.burstRoundsRemainingRight--;
        } else {
          data.burstRoundsRemainingRight = gunType.numBurstRounds;
        }  
    } 
    return false;
  }
  
  public void onUpdateServer(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
    if (itemstack.func_77978_p() == null) {
      GunType gunType = this.type;
      NBTTagCompound tags = new NBTTagCompound();
      tags.func_74778_a("Paint", gunType.defaultPaintjob.iconName);
      NBTTagList ammoTagsList = new NBTTagList();
      for (int j = 0; j < gunType.getNumAmmoItemsInGun(itemstack); j++)
        ammoTagsList.func_74742_a((NBTBase)new NBTTagCompound()); 
      tags.func_74782_a("ammo", (NBTBase)ammoTagsList);
      itemstack.field_77990_d = tags;
    } 
    if (entity instanceof EntityPlayerMP) {
      EntityPlayerMP player = (EntityPlayerMP)entity;
      PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)player);
      if (data == null)
        return; 
      if (player.field_71071_by.func_70448_g() != itemstack) {
        if (player.field_71071_by.func_70448_g() == null || player.field_71071_by.func_70448_g().func_77973_b() == null || !(player.field_71071_by.func_70448_g().func_77973_b() instanceof ItemGun)) {
          data.isShootingRight = data.isShootingLeft = false;
          data.offHandGunSlot = 0;
          (new PacketSelectOffHandGun(0)).handleServerSide(player);
        } 
        return;
      } 
      if (this.type.getFireMode(itemstack) == EnumFireMode.BURST && data.burstRoundsRemainingRight > 0)
        player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, tryToShoot(itemstack, this.type, world, player, false)); 
      if (data.isShootingRight) {
        if (this.type.getFireMode(itemstack) == EnumFireMode.FULLAUTO && !this.type.labigunDelay)
          player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, tryToShoot(itemstack, this.type, world, player, false)); 
        if (this.type.useLoopingSounds && data.loopedSoundDelay <= 0 && data.minigunSpeed > 0.1F && !data.reloadingRight) {
          data.loopedSoundDelay = data.shouldPlayWarmupSound ? this.type.warmupSoundLength : this.type.loopedSoundLength;
          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, 50.0D, player.field_71093_bK, data.shouldPlayWarmupSound ? this.type.warmupSound : this.type.loopedSound, false);
          data.shouldPlayWarmupSound = false;
        } 
        if ((this.type.getFireMode(itemstack) == EnumFireMode.MINIGUN || this.type.labigunDelay) && (data.minigunSpeed == 0 || data.minigunSpeed == -1 || data.minigunSpeed == -2))
          player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, tryToShoot(itemstack, this.type, world, player, false)); 
      } else if (this.type.useLoopingSounds && data.shouldPlayCooldownSound) {
        PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, 50.0D, player.field_71093_bK, this.type.cooldownSound, false);
        data.shouldPlayCooldownSound = false;
      } 
      if (this.type.oneHanded && data.offHandGunSlot != 0) {
        ItemStack offHandGunStack = player.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
        if (offHandGunStack != null && offHandGunStack.func_77973_b() instanceof ItemGun) {
          GunType offHandGunType = ((ItemGun)offHandGunStack.func_77973_b()).type;
          if (offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.BURST && data.burstRoundsRemainingLeft > 0)
            player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, tryToShoot(offHandGunStack, offHandGunType, world, player, true)); 
          if (data.isShootingLeft) {
            if (offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.FULLAUTO && !this.type.labigunDelay)
              player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, tryToShoot(offHandGunStack, offHandGunType, world, player, true)); 
            if (offHandGunType.useLoopingSounds && data.loopedSoundDelay <= 0 && data.minigunSpeed > 0.1F && !data.reloadingLeft) {
              data.loopedSoundDelay = data.shouldPlayWarmupSound ? offHandGunType.warmupSoundLength : offHandGunType.loopedSoundLength;
              PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, 50.0D, player.field_71093_bK, data.shouldPlayWarmupSound ? offHandGunType.warmupSound : offHandGunType.loopedSound, false);
              data.shouldPlayWarmupSound = false;
            } 
            if ((offHandGunType.getFireMode(offHandGunStack) == EnumFireMode.MINIGUN || this.type.labigunDelay) && data.minigunSpeed > offHandGunType.minigunStartSpeed)
              player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, tryToShoot(offHandGunStack, offHandGunType, world, player, true)); 
          } else if (offHandGunType.useLoopingSounds && data.shouldPlayCooldownSound) {
            PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, 50.0D, player.field_71093_bK, offHandGunType.cooldownSound, false);
            data.shouldPlayCooldownSound = false;
          } 
        } 
      } 
    } 
  }
  
  public void func_77663_a(ItemStack itemstack, World world, Entity pEnt, int i, boolean flag) {
    if (world.field_72995_K) {
      onUpdateClient(itemstack, world, pEnt, i, flag);
    } else {
      onUpdateServer(itemstack, world, pEnt, i, flag);
    } 
    if (pEnt instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer)pEnt;
      PlayerData data = PlayerHandler.getPlayerData(player);
      if (data == null)
        return; 
      for (int n = 0; n < 5; n++) {
        ItemStack stacko = player.func_71124_b(n);
        if (stacko != null && stacko.func_77973_b() instanceof ItemTeamArmour)
          if (((ItemTeamArmour)stacko.func_77973_b()).type.hasPouch && ((ItemTeamArmour)stacko.func_77973_b()).type.pouchMultiplier != 1.0F) {
            this.pouchMultiplier = ((ItemTeamArmour)stacko.func_77973_b()).type.pouchMultiplier;
          } else if (((ItemTeamArmour)stacko.func_77973_b()).type.hasGunPouch && this.type.RepeatingGun && ((ItemTeamArmour)stacko.func_77973_b()).type.pouchMultiplier != 1.0F) {
            this.pouchMultiplier = ((ItemTeamArmour)stacko.func_77973_b()).type.pouchMultiplier;
          } else if (((ItemTeamArmour)stacko.func_77973_b()).type.hasOldGunPouch && this.type.OldGun && ((ItemTeamArmour)stacko.func_77973_b()).type.pouchMultiplier != 1.0F) {
            this.pouchMultiplier = ((ItemTeamArmour)stacko.func_77973_b()).type.pouchMultiplier;
          } else if (((ItemTeamArmour)stacko.func_77973_b()).type.hasHeavyPouch && this.type.Heavy && ((ItemTeamArmour)stacko.func_77973_b()).type.pouchMultiplier != 1.0F) {
            this.pouchMultiplier = ((ItemTeamArmour)stacko.func_77973_b()).type.pouchMultiplier;
          } else if (((ItemTeamArmour)stacko.func_77973_b()).type.hasBowPouch && this.type.Bow && ((ItemTeamArmour)stacko.func_77973_b()).type.pouchMultiplier != 1.0F) {
            this.pouchMultiplier = ((ItemTeamArmour)stacko.func_77973_b()).type.pouchMultiplier;
          }  
        if (stacko == null)
          this.pouchMultiplier = 1.0F; 
      } 
      if (this.pouchMultiplier != 1.0F)
        if (!this.type.canSetPosition)
          this.impactX = this.impactY = this.impactZ = 0;  
      if (this.lockOnSoundDelay > 0)
        this.lockOnSoundDelay--; 
      Entity closestEntity = null;
      if (this.type.lockOnToLivings || this.type.lockOnToMechas || this.type.lockOnToPlanes || this.type.lockOnToPlayers || this.type.lockOnToVehicles) {
        for (Object obj : player.field_70170_p.field_72996_f) {
          Entity entity = (Entity)obj;
          Vec3 playerVec = player.func_70040_Z();
          double dXYZ = Math.sqrt((entity.field_70165_t - player.field_70165_t) * (entity.field_70165_t - player.field_70165_t) + (entity.field_70163_u - player.field_70163_u) * (entity.field_70163_u - player.field_70163_u) + (entity.field_70161_v - player.field_70161_v) * (entity.field_70161_v - player.field_70161_v));
          Vector3f relPosVec = new Vector3f(entity.field_70165_t - player.field_70165_t, entity.field_70163_u - player.field_70163_u, entity.field_70161_v - player.field_70161_v);
          Vector3f playerVec3f = new Vector3f(playerVec.field_72450_a, playerVec.field_72448_b, playerVec.field_72449_c);
          float angle = Math.abs(Vector3f.angle(playerVec3f, relPosVec));
          if (angle < Math.toRadians(this.type.canLockOnAngle) && dXYZ < this.type.maxRangeLockOn) {
            String etype = entity.getEntityData().func_74779_i("EntityType");
            if ((this.type.lockOnToMechas && entity instanceof com.flansmod.common.driveables.mechas.EntityMecha) || (this.type.lockOnToVehicles && entity instanceof com.flansmod.common.driveables.EntityVehicle) || (this.type.lockOnToVehicles && etype
              
              .equals("Vehicle")) || (this.type.lockOnToPlanes && entity instanceof com.flansmod.common.driveables.EntityPlane) || (this.type.lockOnToPlanes && etype
              
              .equals("Plane")) || (this.type.lockOnToPlayers && entity instanceof EntityPlayer) || (this.type.lockOnToLivings && entity instanceof EntityLivingBase))
              if (!data.reloadingRight)
                closestEntity = entity;  
          } 
        } 
        if (closestEntity != null)
          closestEntity.getEntityData().func_74757_a("LockOn", true); 
        if (closestEntity != null && this.lockOnSoundDelay <= 0 && !player.field_70170_p.field_72995_K && player.func_71045_bC() != null)
          if (player.func_71045_bC().func_77973_b() instanceof ItemGun) {
            ItemGun itemGun = (ItemGun)player.func_71045_bC().func_77973_b();
            PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, 10.0D, player.field_71093_bK, itemGun.type.lockOnSound, false);
            this.lockOnSoundDelay = this.type.lockOnSoundTime;
            if (closestEntity instanceof EntityDriveable && (((EntityDriveable)closestEntity).getDriveableType()).hasFlare) {
              EntityDriveable entityDriveable = (EntityDriveable)closestEntity;
              PacketPlaySound.sendSoundPacket(closestEntity.field_70165_t, closestEntity.field_70163_u, closestEntity.field_70161_v, 
                  (entityDriveable.getDriveableType()).lockedOnSoundRange, closestEntity.field_71093_bK, 
                  (entityDriveable.getDriveableType()).lockingOnSound, false);
            } 
          }  
      } 
      if (data.meleeDownLength > 0 && this.type.meleeDownPath.size() > 0 && player.field_71071_by.func_70448_g() == itemstack && this.type.meleeDown == true && data.meleeProgressDown != data.meleeDownLength) {
        for (int k = 0; k < this.type.meleeDamagePoints.size(); k++) {
          Vector3f meleeDamagePoint = this.type.meleeDownDamagePoints.get(k);
          Vector3f nextPos = this.type.meleeDownPath.get((data.meleeProgressDown + 1) % this.type.meleeDownPath.size());
          Vector3f nextAngles = this.type.meleeDownPathAngles.get((data.meleeProgressDown + 1) % this.type.meleeDownPathAngles.size());
          RotatedAxes nextAxes = (new RotatedAxes()).rotateGlobalRoll(-nextAngles.x).rotateGlobalPitch(-nextAngles.z).rotateGlobalYaw(-nextAngles.y);
          Vector3f nextPosInGunCoords = nextAxes.findLocalVectorGlobally(meleeDamagePoint);
          Vector3f.add(nextPos, nextPosInGunCoords, nextPosInGunCoords);
          Vector3f.add(new Vector3f(0.0F, 0.0F, 0.0F), nextPosInGunCoords, nextPosInGunCoords);
          Vector3f nextPosInPlayerCoords = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextPosInGunCoords);
          if (!FlansMod.proxy.isThePlayer(player))
            nextPosInPlayerCoords.y += 1.6F; 
          Vector3f nextPosInWorldCoords = new Vector3f(player.field_70165_t + nextPosInPlayerCoords.x, player.field_70163_u + nextPosInPlayerCoords.y, player.field_70161_v + nextPosInPlayerCoords.z);
          Vector3f dPos = (data.lastMeleeDownPositions[k] == null) ? new Vector3f() : Vector3f.sub(nextPosInWorldCoords, data.lastMeleeDownPositions[k], null);
          if (player.field_70170_p.field_72995_K && FlansMod.DEBUG)
            player.field_70170_p.func_72838_d((Entity)new EntityDebugVector(player.field_70170_p, data.lastMeleeDownPositions[k], dPos, 200, 1.0F, 0.0F, 0.0F)); 
          ArrayList<BulletHit> hits = new ArrayList<>();
          for (int j = 0; j < world.field_72996_f.size(); j++) {
            Object obj = world.field_72996_f.get(j);
            if (obj instanceof EntityPlayer) {
              EntityPlayer otherPlayer = (EntityPlayer)obj;
              PlayerData otherData = PlayerHandler.getPlayerData(otherPlayer);
              boolean shouldDoNormalHitDetect = false;
              if (otherPlayer == player)
                continue; 
              if (otherData != null) {
                if (otherPlayer.field_70128_L || otherData.team == Team.spectators)
                  continue; 
                int snapshotToTry = (player instanceof EntityPlayerMP) ? (((EntityPlayerMP)player).field_71138_i / 50) : 0;
                if (snapshotToTry >= otherData.snapshots.length)
                  snapshotToTry = otherData.snapshots.length - 1; 
                PlayerSnapshot snapshot = otherData.snapshots[snapshotToTry];
                if (snapshot == null)
                  snapshot = otherData.snapshots[0]; 
                if (snapshot == null) {
                  shouldDoNormalHitDetect = true;
                } else {
                  ArrayList<BulletHit> playerHits = snapshot.raytrace((data.lastMeleeDownPositions[k] == null) ? nextPosInWorldCoords : data.lastMeleeDownPositions[k], dPos);
                  hits.addAll(playerHits);
                } 
              } 
              if (otherData == null || shouldDoNormalHitDetect) {
                MovingObjectPosition mop = (data.lastMeleeDownPositions[k] == null) ? player.field_70121_D.func_72327_a(nextPosInWorldCoords.toVec3(), Vec3.func_72443_a(0.0D, 0.0D, 0.0D)) : player.field_70121_D.func_72327_a(data.lastMeleeDownPositions[k].toVec3(), nextPosInWorldCoords.toVec3());
                if (mop != null) {
                  Vector3f hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (data.lastMeleeDownPositions[k]).x, mop.field_72307_f.field_72448_b - (data.lastMeleeDownPositions[k]).y, mop.field_72307_f.field_72449_c - (data.lastMeleeDownPositions[k]).z);
                  float hitLambda = 1.0F;
                  if (dPos.x != 0.0F) {
                    hitLambda = hitPoint.x / dPos.x;
                  } else if (dPos.y != 0.0F) {
                    hitLambda = hitPoint.y / dPos.y;
                  } else if (dPos.z != 0.0F) {
                    hitLambda = hitPoint.z / dPos.z;
                  } 
                  if (hitLambda < 0.0F)
                    hitLambda = -hitLambda; 
                  hits.add(new PlayerBulletHit(new PlayerHitbox(otherPlayer, new RotatedAxes(), new Vector3f(), new Vector3f(), new Vector3f(), EnumHitboxType.BODY), hitLambda));
                } 
              } 
              continue;
            } 
            Entity entity = (Entity)obj;
            if (entity != player && !entity.field_70128_L && (entity instanceof EntityLivingBase || entity instanceof EntityAAGun)) {
              MovingObjectPosition mop = entity.field_70121_D.func_72327_a(data.lastMeleeDownPositions[k].toVec3(), nextPosInWorldCoords.toVec3());
              if (mop != null) {
                Vector3f hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (data.lastMeleeDownPositions[k]).x, mop.field_72307_f.field_72448_b - (data.lastMeleeDownPositions[k]).y, mop.field_72307_f.field_72449_c - (data.lastMeleeDownPositions[k]).z);
                float hitLambda = 1.0F;
                if (dPos.x != 0.0F) {
                  hitLambda = hitPoint.x / dPos.x;
                } else if (dPos.y != 0.0F) {
                  hitLambda = hitPoint.y / dPos.y;
                } else if (dPos.z != 0.0F) {
                  hitLambda = hitPoint.z / dPos.z;
                } 
                if (hitLambda < 0.0F)
                  hitLambda = -hitLambda; 
                hits.add(new EntityHit(entity, hitLambda));
              } 
            } 
            continue;
          } 
          if (!hits.isEmpty()) {
            Collections.sort(hits);
            float swingDistance = dPos.length();
            for (BulletHit bulletHit : hits) {
              if (bulletHit instanceof PlayerBulletHit) {
                int m;
                PlayerBulletHit playerHit = (PlayerBulletHit)bulletHit;
                float damageMultiplier = 1.0F;
                switch (playerHit.hitbox.type) {
                  case LEFTITEM:
                  case RIGHTITEM:
                    PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                    data.meleeProgressDown = data.meleeDownLength = 0;
                    return;
                  case NAPE:
                    damageMultiplier = 2.0F;
                    for (m = 0; m < 5; m++) {
                      ItemStack stack = playerHit.hitbox.player.func_71124_b(m);
                      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour)
                        if (((ItemTeamArmour)stack.func_77973_b()).type.bodyArmor > this.type.swordArmorPen) {
                          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                          data.meleeProgressLeft = data.meleeLeftLength = 0;
                          return;
                        }  
                    } 
                    break;
                  case RIGHTARM:
                  case LEFTARM:
                    damageMultiplier = 0.6F;
                    for (m = 0; m < 5; m++) {
                      ItemStack stack = playerHit.hitbox.player.func_71124_b(m);
                      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour)
                        if (((ItemTeamArmour)stack.func_77973_b()).type.armArmor > this.type.swordArmorPen) {
                          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                          data.meleeProgressLeft = data.meleeLeftLength = 0;
                          return;
                        }  
                    } 
                    break;
                  case BODY:
                    for (m = 0; m < 5; m++) {
                      ItemStack stack = playerHit.hitbox.player.func_71124_b(m);
                      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour)
                        if (((ItemTeamArmour)stack.func_77973_b()).type.bodyArmor > this.type.swordArmorPen) {
                          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                          data.meleeProgressLeft = data.meleeLeftLength = 0;
                          return;
                        }  
                    } 
                    break;
                } 
                if (playerHit.hitbox.player.func_70097_a(getMeleeDamage(player), swingDistance * this.type.meleeDamage)) {
                  playerHit.hitbox.player.field_70720_be++;
                  playerHit.hitbox.player.field_70172_ad = playerHit.hitbox.player.field_70771_an / 2;
                  PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                  sliceCrossHair = true;
                } 
                if (FlansMod.DEBUG)
                  world.func_72838_d((Entity)new EntityDebugDot(world, new Vector3f((data.lastMeleeDownPositions[k]).x + dPos.x * playerHit.intersectTime, (data.lastMeleeDownPositions[k]).y + dPos.y * playerHit.intersectTime, (data.lastMeleeDownPositions[k]).z + dPos.z * playerHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F)); 
                continue;
              } 
              if (bulletHit instanceof EntityHit) {
                EntityHit entityHit = (EntityHit)bulletHit;
                if (entityHit.entity.func_70097_a(DamageSource.func_76365_a(player), swingDistance * this.type.meleeDamage) && entityHit.entity instanceof EntityLivingBase) {
                  EntityLivingBase living = (EntityLivingBase)entityHit.entity;
                  living.field_70720_be++;
                  living.field_70172_ad = living.field_70771_an / 2;
                  PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                } 
                if (FlansMod.DEBUG)
                  world.func_72838_d((Entity)new EntityDebugDot(world, new Vector3f((data.lastMeleeDownPositions[k]).x + dPos.x * entityHit.intersectTime, (data.lastMeleeDownPositions[k]).y + dPos.y * entityHit.intersectTime, (data.lastMeleeDownPositions[k]).z + dPos.z * entityHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F)); 
              } 
            } 
          } 
          data.lastMeleeDownPositions[k] = nextPosInWorldCoords;
        } 
        data.meleeProgressDown++;
        if (data.meleeProgressDown == data.meleeDownLength)
          data.meleeProgressDown = data.meleeDownLength = 0; 
      } else if (data.meleeLeftLength > 0 && this.type.meleeLeftPath.size() > 0 && player.field_71071_by.func_70448_g() == itemstack && this.type.meleeLeft == true && data.meleeProgressLeft != data.meleeLeftLength) {
        for (int k = 0; k < this.type.meleeDamagePoints.size(); k++) {
          Vector3f meleeDamagePoint = this.type.meleeLeftDamagePoints.get(k);
          Vector3f nextPos = this.type.meleeLeftPath.get((data.meleeProgressLeft + 1) % this.type.meleeLeftPath.size());
          Vector3f nextAngles = this.type.meleeLeftPathAngles.get((data.meleeProgressLeft + 1) % this.type.meleeLeftPathAngles.size());
          RotatedAxes nextAxes = (new RotatedAxes()).rotateGlobalRoll(-nextAngles.x).rotateGlobalPitch(-nextAngles.z).rotateGlobalYaw(-nextAngles.y);
          Vector3f nextPosInGunCoords = nextAxes.findLocalVectorGlobally(meleeDamagePoint);
          Vector3f.add(nextPos, nextPosInGunCoords, nextPosInGunCoords);
          Vector3f.add(new Vector3f(0.0F, 0.0F, 0.0F), nextPosInGunCoords, nextPosInGunCoords);
          Vector3f nextPosInPlayerCoords = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextPosInGunCoords);
          if (!FlansMod.proxy.isThePlayer(player))
            nextPosInPlayerCoords.y += 1.6F; 
          Vector3f nextPosInWorldCoords = new Vector3f(player.field_70165_t + nextPosInPlayerCoords.x, player.field_70163_u + nextPosInPlayerCoords.y, player.field_70161_v + nextPosInPlayerCoords.z);
          Vector3f dPos = (data.lastMeleeLeftPositions[k] == null) ? new Vector3f() : Vector3f.sub(nextPosInWorldCoords, data.lastMeleeLeftPositions[k], null);
          if (player.field_70170_p.field_72995_K && FlansMod.DEBUG)
            player.field_70170_p.func_72838_d((Entity)new EntityDebugVector(player.field_70170_p, data.lastMeleeLeftPositions[k], dPos, 200, 1.0F, 0.0F, 0.0F)); 
          ArrayList<BulletHit> hits = new ArrayList<>();
          for (int j = 0; j < world.field_72996_f.size(); j++) {
            Object obj = world.field_72996_f.get(j);
            if (obj instanceof EntityPlayer) {
              EntityPlayer otherPlayer = (EntityPlayer)obj;
              PlayerData otherData = PlayerHandler.getPlayerData(otherPlayer);
              boolean shouldDoNormalHitDetect = false;
              if (otherPlayer == player)
                continue; 
              if (otherData != null) {
                if (otherPlayer.field_70128_L || otherData.team == Team.spectators)
                  continue; 
                int snapshotToTry = (player instanceof EntityPlayerMP) ? (((EntityPlayerMP)player).field_71138_i / 50) : 0;
                if (snapshotToTry >= otherData.snapshots.length)
                  snapshotToTry = otherData.snapshots.length - 1; 
                PlayerSnapshot snapshot = otherData.snapshots[snapshotToTry];
                if (snapshot == null)
                  snapshot = otherData.snapshots[0]; 
                if (snapshot == null) {
                  shouldDoNormalHitDetect = true;
                } else {
                  ArrayList<BulletHit> playerHits = snapshot.raytrace((data.lastMeleeLeftPositions[k] == null) ? nextPosInWorldCoords : data.lastMeleeLeftPositions[k], dPos);
                  hits.addAll(playerHits);
                } 
              } 
              if (otherData == null || shouldDoNormalHitDetect) {
                MovingObjectPosition mop = (data.lastMeleeLeftPositions[k] == null) ? player.field_70121_D.func_72327_a(nextPosInWorldCoords.toVec3(), Vec3.func_72443_a(0.0D, 0.0D, 0.0D)) : player.field_70121_D.func_72327_a(data.lastMeleeLeftPositions[k].toVec3(), nextPosInWorldCoords.toVec3());
                if (mop != null) {
                  Vector3f hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (data.lastMeleeLeftPositions[k]).x, mop.field_72307_f.field_72448_b - (data.lastMeleeLeftPositions[k]).y, mop.field_72307_f.field_72449_c - (data.lastMeleeLeftPositions[k]).z);
                  float hitLambda = 1.0F;
                  if (dPos.x != 0.0F) {
                    hitLambda = hitPoint.x / dPos.x;
                  } else if (dPos.y != 0.0F) {
                    hitLambda = hitPoint.y / dPos.y;
                  } else if (dPos.z != 0.0F) {
                    hitLambda = hitPoint.z / dPos.z;
                  } 
                  if (hitLambda < 0.0F)
                    hitLambda = -hitLambda; 
                  hits.add(new PlayerBulletHit(new PlayerHitbox(otherPlayer, new RotatedAxes(), new Vector3f(), new Vector3f(), new Vector3f(), EnumHitboxType.BODY), hitLambda));
                } 
              } 
              continue;
            } 
            Entity entity = (Entity)obj;
            if (entity != player && !entity.field_70128_L && (entity instanceof EntityLivingBase || entity instanceof EntityAAGun)) {
              MovingObjectPosition mop = entity.field_70121_D.func_72327_a(data.lastMeleeLeftPositions[k].toVec3(), nextPosInWorldCoords.toVec3());
              if (mop != null) {
                Vector3f hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (data.lastMeleeLeftPositions[k]).x, mop.field_72307_f.field_72448_b - (data.lastMeleeLeftPositions[k]).y, mop.field_72307_f.field_72449_c - (data.lastMeleeLeftPositions[k]).z);
                float hitLambda = 1.0F;
                if (dPos.x != 0.0F) {
                  hitLambda = hitPoint.x / dPos.x;
                } else if (dPos.y != 0.0F) {
                  hitLambda = hitPoint.y / dPos.y;
                } else if (dPos.z != 0.0F) {
                  hitLambda = hitPoint.z / dPos.z;
                } 
                if (hitLambda < 0.0F)
                  hitLambda = -hitLambda; 
                hits.add(new EntityHit(entity, hitLambda));
              } 
            } 
            continue;
          } 
          if (!hits.isEmpty()) {
            Collections.sort(hits);
            float swingDistance = dPos.length();
            for (BulletHit bulletHit : hits) {
              if (bulletHit instanceof PlayerBulletHit) {
                int m;
                PlayerBulletHit playerHit = (PlayerBulletHit)bulletHit;
                float damageMultiplier = 1.0F;
                switch (playerHit.hitbox.type) {
                  case LEFTITEM:
                  case RIGHTITEM:
                    PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                    data.meleeProgressLeft = data.meleeLeftLength = 0;
                    return;
                  case NAPE:
                    damageMultiplier = 2.0F;
                    for (m = 0; m < 5; m++) {
                      ItemStack stack = playerHit.hitbox.player.func_71124_b(m);
                      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour)
                        if (((ItemTeamArmour)stack.func_77973_b()).type.bodyArmor > this.type.swordArmorPen) {
                          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                          data.meleeProgressLeft = data.meleeLeftLength = 0;
                          return;
                        }  
                    } 
                    break;
                  case RIGHTARM:
                  case LEFTARM:
                    damageMultiplier = 0.6F;
                    for (m = 0; m < 5; m++) {
                      ItemStack stack = playerHit.hitbox.player.func_71124_b(m);
                      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour)
                        if (((ItemTeamArmour)stack.func_77973_b()).type.armArmor > this.type.swordArmorPen) {
                          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                          data.meleeProgressLeft = data.meleeLeftLength = 0;
                          return;
                        }  
                    } 
                    break;
                  case BODY:
                    for (m = 0; m < 5; m++) {
                      ItemStack stack = playerHit.hitbox.player.func_71124_b(m);
                      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour)
                        if (((ItemTeamArmour)stack.func_77973_b()).type.bodyArmor > this.type.swordArmorPen) {
                          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                          data.meleeProgressLeft = data.meleeLeftLength = 0;
                          return;
                        }  
                    } 
                    break;
                } 
                if (playerHit.hitbox.player.func_70097_a(getMeleeDamage(player), swingDistance * this.type.meleeDamage)) {
                  PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                  playerHit.hitbox.player.field_70720_be++;
                  playerHit.hitbox.player.field_70172_ad = playerHit.hitbox.player.field_70771_an / 2;
                  sliceCrossHair = true;
                } 
                if (FlansMod.DEBUG)
                  world.func_72838_d((Entity)new EntityDebugDot(world, new Vector3f((data.lastMeleeLeftPositions[k]).x + dPos.x * playerHit.intersectTime, (data.lastMeleeLeftPositions[k]).y + dPos.y * playerHit.intersectTime, (data.lastMeleeLeftPositions[k]).z + dPos.z * playerHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F)); 
                continue;
              } 
              if (bulletHit instanceof EntityHit) {
                EntityHit entityHit = (EntityHit)bulletHit;
                if (entityHit.entity.func_70097_a(DamageSource.func_76365_a(player), swingDistance * this.type.meleeDamage) && entityHit.entity instanceof EntityLivingBase) {
                  EntityLivingBase living = (EntityLivingBase)entityHit.entity;
                  PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                  living.field_70720_be++;
                  living.field_70172_ad = living.field_70771_an / 2;
                } 
                if (FlansMod.DEBUG)
                  world.func_72838_d((Entity)new EntityDebugDot(world, new Vector3f((data.lastMeleeLeftPositions[k]).x + dPos.x * entityHit.intersectTime, (data.lastMeleeLeftPositions[k]).y + dPos.y * entityHit.intersectTime, (data.lastMeleeLeftPositions[k]).z + dPos.z * entityHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F)); 
              } 
            } 
          } 
          data.lastMeleeLeftPositions[k] = nextPosInWorldCoords;
        } 
        data.meleeProgressLeft++;
        if (data.meleeProgressLeft == data.meleeLeftLength)
          data.meleeProgressLeft = data.meleeLeftLength = 0; 
      } else if (data.meleeRightLength > 0 && this.type.meleeRightPath.size() > 0 && player.field_71071_by.func_70448_g() == itemstack && this.type.meleeRight == true && data.meleeProgressRight != data.meleeRightLength) {
        for (int k = 0; k < this.type.meleeRightDamagePoints.size(); k++) {
          Vector3f meleeDamagePoint = this.type.meleeRightDamagePoints.get(k);
          Vector3f nextPos = this.type.meleeRightPath.get((data.meleeProgressRight + 1) % this.type.meleeRightPath.size());
          Vector3f nextAngles = this.type.meleeRightPathAngles.get((data.meleeProgressRight + 1) % this.type.meleeRightPathAngles.size());
          RotatedAxes nextAxes = (new RotatedAxes()).rotateGlobalRoll(-nextAngles.x).rotateGlobalPitch(-nextAngles.z).rotateGlobalYaw(-nextAngles.y);
          Vector3f nextPosInGunCoords = nextAxes.findLocalVectorGlobally(meleeDamagePoint);
          Vector3f.add(nextPos, nextPosInGunCoords, nextPosInGunCoords);
          Vector3f.add(new Vector3f(0.0F, 0.0F, 0.0F), nextPosInGunCoords, nextPosInGunCoords);
          Vector3f nextPosInPlayerCoords = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextPosInGunCoords);
          if (!FlansMod.proxy.isThePlayer(player))
            nextPosInPlayerCoords.y += 1.6F; 
          Vector3f nextPosInWorldCoords = new Vector3f(player.field_70165_t + nextPosInPlayerCoords.x, player.field_70163_u + nextPosInPlayerCoords.y, player.field_70161_v + nextPosInPlayerCoords.z);
          Vector3f dPos = (data.lastMeleeRightPositions[k] == null) ? new Vector3f() : Vector3f.sub(nextPosInWorldCoords, data.lastMeleeRightPositions[k], null);
          if (player.field_70170_p.field_72995_K && FlansMod.DEBUG)
            player.field_70170_p.func_72838_d((Entity)new EntityDebugVector(player.field_70170_p, data.lastMeleeRightPositions[k], dPos, 200, 1.0F, 0.0F, 0.0F)); 
          ArrayList<BulletHit> hits = new ArrayList<>();
          for (int j = 0; j < world.field_72996_f.size(); j++) {
            Object obj = world.field_72996_f.get(j);
            if (obj instanceof EntityPlayer) {
              EntityPlayer otherPlayer = (EntityPlayer)obj;
              PlayerData otherData = PlayerHandler.getPlayerData(otherPlayer);
              boolean shouldDoNormalHitDetect = false;
              if (otherPlayer == player)
                continue; 
              if (otherData != null) {
                if (otherPlayer.field_70128_L || otherData.team == Team.spectators)
                  continue; 
                int snapshotToTry = (player instanceof EntityPlayerMP) ? (((EntityPlayerMP)player).field_71138_i / 50) : 0;
                if (snapshotToTry >= otherData.snapshots.length)
                  snapshotToTry = otherData.snapshots.length - 1; 
                PlayerSnapshot snapshot = otherData.snapshots[snapshotToTry];
                if (snapshot == null)
                  snapshot = otherData.snapshots[0]; 
                if (snapshot == null) {
                  shouldDoNormalHitDetect = true;
                } else {
                  ArrayList<BulletHit> playerHits = snapshot.raytrace((data.lastMeleeRightPositions[k] == null) ? nextPosInWorldCoords : data.lastMeleeRightPositions[k], dPos);
                  hits.addAll(playerHits);
                } 
              } 
              if (otherData == null || shouldDoNormalHitDetect) {
                MovingObjectPosition mop = (data.lastMeleeRightPositions[k] == null) ? player.field_70121_D.func_72327_a(nextPosInWorldCoords.toVec3(), Vec3.func_72443_a(0.0D, 0.0D, 0.0D)) : player.field_70121_D.func_72327_a(data.lastMeleeRightPositions[k].toVec3(), nextPosInWorldCoords.toVec3());
                if (mop != null) {
                  Vector3f hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (data.lastMeleeRightPositions[k]).x, mop.field_72307_f.field_72448_b - (data.lastMeleeRightPositions[k]).y, mop.field_72307_f.field_72449_c - (data.lastMeleeRightPositions[k]).z);
                  float hitLambda = 1.0F;
                  if (dPos.x != 0.0F) {
                    hitLambda = hitPoint.x / dPos.x;
                  } else if (dPos.y != 0.0F) {
                    hitLambda = hitPoint.y / dPos.y;
                  } else if (dPos.z != 0.0F) {
                    hitLambda = hitPoint.z / dPos.z;
                  } 
                  if (hitLambda < 0.0F)
                    hitLambda = -hitLambda; 
                  hits.add(new PlayerBulletHit(new PlayerHitbox(otherPlayer, new RotatedAxes(), new Vector3f(), new Vector3f(), new Vector3f(), EnumHitboxType.BODY), hitLambda));
                } 
              } 
              continue;
            } 
            Entity entity = (Entity)obj;
            if (entity != player && !entity.field_70128_L && (entity instanceof EntityLivingBase || entity instanceof EntityAAGun)) {
              MovingObjectPosition mop = entity.field_70121_D.func_72327_a(data.lastMeleeRightPositions[k].toVec3(), nextPosInWorldCoords.toVec3());
              if (mop != null) {
                Vector3f hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (data.lastMeleeRightPositions[k]).x, mop.field_72307_f.field_72448_b - (data.lastMeleeRightPositions[k]).y, mop.field_72307_f.field_72449_c - (data.lastMeleeRightPositions[k]).z);
                float hitLambda = 1.0F;
                if (dPos.x != 0.0F) {
                  hitLambda = hitPoint.x / dPos.x;
                } else if (dPos.y != 0.0F) {
                  hitLambda = hitPoint.y / dPos.y;
                } else if (dPos.z != 0.0F) {
                  hitLambda = hitPoint.z / dPos.z;
                } 
                if (hitLambda < 0.0F)
                  hitLambda = -hitLambda; 
                hits.add(new EntityHit(entity, hitLambda));
              } 
            } 
            continue;
          } 
          if (!hits.isEmpty()) {
            Collections.sort(hits);
            float swingDistance = dPos.length();
            for (BulletHit bulletHit : hits) {
              if (bulletHit instanceof PlayerBulletHit) {
                int m;
                PlayerBulletHit playerHit = (PlayerBulletHit)bulletHit;
                float damageMultiplier = 1.0F;
                switch (playerHit.hitbox.type) {
                  case LEFTITEM:
                  case RIGHTITEM:
                    PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                    data.meleeProgressRight = data.meleeRightLength = 0;
                    return;
                  case NAPE:
                    damageMultiplier = 2.0F;
                    for (m = 0; m < 5; m++) {
                      ItemStack stack = playerHit.hitbox.player.func_71124_b(m);
                      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour)
                        if (((ItemTeamArmour)stack.func_77973_b()).type.bodyArmor > this.type.swordArmorPen) {
                          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                          data.meleeProgressLeft = data.meleeLeftLength = 0;
                          return;
                        }  
                    } 
                    break;
                  case RIGHTARM:
                  case LEFTARM:
                    damageMultiplier = 0.6F;
                    for (m = 0; m < 5; m++) {
                      ItemStack stack = playerHit.hitbox.player.func_71124_b(m);
                      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour)
                        if (((ItemTeamArmour)stack.func_77973_b()).type.armArmor > this.type.swordArmorPen) {
                          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                          data.meleeProgressLeft = data.meleeLeftLength = 0;
                          return;
                        }  
                    } 
                    break;
                  case BODY:
                    for (m = 0; m < 5; m++) {
                      ItemStack stack = playerHit.hitbox.player.func_71124_b(m);
                      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour)
                        if (((ItemTeamArmour)stack.func_77973_b()).type.bodyArmor > this.type.swordArmorPen) {
                          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                          data.meleeProgressLeft = data.meleeLeftLength = 0;
                          return;
                        }  
                    } 
                    break;
                } 
                if (playerHit.hitbox.player.func_70097_a(getMeleeDamage(player), swingDistance * this.type.meleeDamage)) {
                  PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                  playerHit.hitbox.player.field_70720_be++;
                  playerHit.hitbox.player.field_70172_ad = playerHit.hitbox.player.field_70771_an / 2;
                  sliceCrossHair = true;
                } 
                if (FlansMod.DEBUG)
                  world.func_72838_d((Entity)new EntityDebugDot(world, new Vector3f((data.lastMeleeRightPositions[k]).x + dPos.x * playerHit.intersectTime, (data.lastMeleeRightPositions[k]).y + dPos.y * playerHit.intersectTime, (data.lastMeleeRightPositions[k]).z + dPos.z * playerHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F)); 
                continue;
              } 
              if (bulletHit instanceof EntityHit) {
                EntityHit entityHit = (EntityHit)bulletHit;
                if (entityHit.entity.func_70097_a(DamageSource.func_76365_a(player), swingDistance * this.type.meleeDamage) && entityHit.entity instanceof EntityLivingBase) {
                  EntityLivingBase living = (EntityLivingBase)entityHit.entity;
                  PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                  living.field_70720_be++;
                  living.field_70172_ad = living.field_70771_an / 2;
                } 
                if (FlansMod.DEBUG)
                  world.func_72838_d((Entity)new EntityDebugDot(world, new Vector3f((data.lastMeleeRightPositions[k]).x + dPos.x * entityHit.intersectTime, (data.lastMeleeRightPositions[k]).y + dPos.y * entityHit.intersectTime, (data.lastMeleeRightPositions[k]).z + dPos.z * entityHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F)); 
              } 
            } 
          } 
          data.lastMeleeRightPositions[k] = nextPosInWorldCoords;
        } 
        data.meleeProgressRight++;
        if (data.meleeProgressRight == data.meleeRightLength)
          data.meleeProgressRight = data.meleeRightLength = 0; 
      } else if (data.meleeLength > 0 && this.type.meleePath.size() > 0 && player.field_71071_by.func_70448_g() == itemstack) {
        for (int k = 0; k < this.type.meleeDamagePoints.size(); k++) {
          Vector3f meleeDamagePoint = this.type.meleeDamagePoints.get(k);
          Vector3f nextPos = this.type.meleePath.get((data.meleeProgress + 1) % this.type.meleePath.size());
          Vector3f nextAngles = this.type.meleePathAngles.get((data.meleeProgress + 1) % this.type.meleePathAngles.size());
          RotatedAxes nextAxes = (new RotatedAxes()).rotateGlobalRoll(-nextAngles.x).rotateGlobalPitch(-nextAngles.z).rotateGlobalYaw(-nextAngles.y);
          Vector3f nextPosInGunCoords = nextAxes.findLocalVectorGlobally(meleeDamagePoint);
          Vector3f.add(nextPos, nextPosInGunCoords, nextPosInGunCoords);
          Vector3f.add(new Vector3f(0.0F, 0.0F, 0.0F), nextPosInGunCoords, nextPosInGunCoords);
          Vector3f nextPosInPlayerCoords = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextPosInGunCoords);
          if (!FlansMod.proxy.isThePlayer(player))
            nextPosInPlayerCoords.y += 1.6F; 
          Vector3f nextPosInWorldCoords = new Vector3f(player.field_70165_t + nextPosInPlayerCoords.x, player.field_70163_u + nextPosInPlayerCoords.y, player.field_70161_v + nextPosInPlayerCoords.z);
          Vector3f dPos = (data.lastMeleePositions[k] == null) ? new Vector3f() : Vector3f.sub(nextPosInWorldCoords, data.lastMeleePositions[k], null);
          if (player.field_70170_p.field_72995_K && FlansMod.DEBUG)
            player.field_70170_p.func_72838_d((Entity)new EntityDebugVector(player.field_70170_p, data.lastMeleePositions[k], dPos, 200, 1.0F, 0.0F, 0.0F)); 
          ArrayList<BulletHit> hits = new ArrayList<>();
          for (int j = 0; j < world.field_72996_f.size(); j++) {
            Object obj = world.field_72996_f.get(j);
            if (obj instanceof EntityPlayer) {
              EntityPlayer otherPlayer = (EntityPlayer)obj;
              PlayerData otherData = PlayerHandler.getPlayerData(otherPlayer);
              boolean shouldDoNormalHitDetect = false;
              if (otherPlayer == player)
                continue; 
              if (otherData != null) {
                if (otherPlayer.field_70128_L || otherData.team == Team.spectators)
                  continue; 
                int snapshotToTry = (player instanceof EntityPlayerMP) ? (((EntityPlayerMP)player).field_71138_i / 50) : 0;
                if (snapshotToTry >= otherData.snapshots.length)
                  snapshotToTry = otherData.snapshots.length - 1; 
                PlayerSnapshot snapshot = otherData.snapshots[snapshotToTry];
                if (snapshot == null)
                  snapshot = otherData.snapshots[0]; 
                if (snapshot == null) {
                  shouldDoNormalHitDetect = true;
                } else {
                  ArrayList<BulletHit> playerHits = snapshot.raytrace((data.lastMeleePositions[k] == null) ? nextPosInWorldCoords : data.lastMeleePositions[k], dPos);
                  hits.addAll(playerHits);
                } 
              } 
              if (otherData == null || shouldDoNormalHitDetect) {
                MovingObjectPosition mop = (data.lastMeleePositions[k] == null) ? player.field_70121_D.func_72327_a(nextPosInWorldCoords.toVec3(), Vec3.func_72443_a(0.0D, 0.0D, 0.0D)) : player.field_70121_D.func_72327_a(data.lastMeleePositions[k].toVec3(), nextPosInWorldCoords.toVec3());
                if (mop != null) {
                  Vector3f hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (data.lastMeleePositions[k]).x, mop.field_72307_f.field_72448_b - (data.lastMeleePositions[k]).y, mop.field_72307_f.field_72449_c - (data.lastMeleePositions[k]).z);
                  float hitLambda = 1.0F;
                  if (dPos.x != 0.0F) {
                    hitLambda = hitPoint.x / dPos.x;
                  } else if (dPos.y != 0.0F) {
                    hitLambda = hitPoint.y / dPos.y;
                  } else if (dPos.z != 0.0F) {
                    hitLambda = hitPoint.z / dPos.z;
                  } 
                  if (hitLambda < 0.0F)
                    hitLambda = -hitLambda; 
                  hits.add(new PlayerBulletHit(new PlayerHitbox(otherPlayer, new RotatedAxes(), new Vector3f(), new Vector3f(), new Vector3f(), EnumHitboxType.BODY), hitLambda));
                } 
              } 
              continue;
            } 
            Entity entity = (Entity)obj;
            if (entity != player && !entity.field_70128_L && (entity instanceof EntityLivingBase || entity instanceof EntityAAGun)) {
              MovingObjectPosition mop = entity.field_70121_D.func_72327_a(data.lastMeleePositions[k].toVec3(), nextPosInWorldCoords.toVec3());
              if (mop != null) {
                Vector3f hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - (data.lastMeleePositions[k]).x, mop.field_72307_f.field_72448_b - (data.lastMeleePositions[k]).y, mop.field_72307_f.field_72449_c - (data.lastMeleePositions[k]).z);
                float hitLambda = 1.0F;
                if (dPos.x != 0.0F) {
                  hitLambda = hitPoint.x / dPos.x;
                } else if (dPos.y != 0.0F) {
                  hitLambda = hitPoint.y / dPos.y;
                } else if (dPos.z != 0.0F) {
                  hitLambda = hitPoint.z / dPos.z;
                } 
                if (hitLambda < 0.0F)
                  hitLambda = -hitLambda; 
                hits.add(new EntityHit(entity, hitLambda));
              } 
            } 
            continue;
          } 
          if (!hits.isEmpty()) {
            Collections.sort(hits);
            float swingDistance = dPos.length();
            for (BulletHit bulletHit : hits) {
              if (bulletHit instanceof PlayerBulletHit) {
                int m;
                PlayerBulletHit playerHit = (PlayerBulletHit)bulletHit;
                float damageMultiplier = 1.0F;
                switch (playerHit.hitbox.type) {
                  case LEFTITEM:
                  case RIGHTITEM:
                    PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                    data.meleeProgress = data.meleeLength = 0;
                    return;
                  case NAPE:
                    damageMultiplier = 2.0F;
                    for (m = 0; m < 5; m++) {
                      ItemStack stack = playerHit.hitbox.player.func_71124_b(m);
                      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour)
                        if (((ItemTeamArmour)stack.func_77973_b()).type.bodyArmor > this.type.swordArmorPen) {
                          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                          data.meleeProgressLeft = data.meleeLeftLength = 0;
                          return;
                        }  
                    } 
                    break;
                  case RIGHTARM:
                  case LEFTARM:
                    damageMultiplier = 0.6F;
                    for (m = 0; m < 5; m++) {
                      ItemStack stack = playerHit.hitbox.player.func_71124_b(m);
                      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour)
                        if (((ItemTeamArmour)stack.func_77973_b()).type.armArmor > this.type.swordArmorPen) {
                          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                          data.meleeProgressLeft = data.meleeLeftLength = 0;
                          return;
                        }  
                    } 
                    break;
                  case BODY:
                    for (m = 0; m < 5; m++) {
                      ItemStack stack = playerHit.hitbox.player.func_71124_b(m);
                      if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour)
                        if (((ItemTeamArmour)stack.func_77973_b()).type.bodyArmor > this.type.swordArmorPen) {
                          PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.ShieldHitSound, true);
                          data.meleeProgressLeft = data.meleeLeftLength = 0;
                          return;
                        }  
                    } 
                    break;
                } 
                if (playerHit.hitbox.player.func_70097_a(getMeleeDamage(player), swingDistance * this.type.meleeDamage)) {
                  PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                  playerHit.hitbox.player.field_70720_be++;
                  playerHit.hitbox.player.field_70172_ad = playerHit.hitbox.player.field_70771_an / 2;
                  sliceCrossHair = true;
                } 
                if (FlansMod.DEBUG)
                  world.func_72838_d((Entity)new EntityDebugDot(world, new Vector3f((data.lastMeleePositions[k]).x + dPos.x * playerHit.intersectTime, (data.lastMeleePositions[k]).y + dPos.y * playerHit.intersectTime, (data.lastMeleePositions[k]).z + dPos.z * playerHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F)); 
                continue;
              } 
              if (bulletHit instanceof EntityHit) {
                EntityHit entityHit = (EntityHit)bulletHit;
                if (entityHit.entity.func_70097_a(DamageSource.func_76365_a(player), swingDistance * this.type.meleeDamage) && entityHit.entity instanceof EntityLivingBase) {
                  EntityLivingBase living = (EntityLivingBase)entityHit.entity;
                  PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, this.type.meleeSoundRange, player.field_71093_bK, this.type.meleeHitSound, true);
                  living.field_70720_be++;
                  living.field_70172_ad = living.field_70771_an / 2;
                } 
                if (FlansMod.DEBUG)
                  world.func_72838_d((Entity)new EntityDebugDot(world, new Vector3f((data.lastMeleePositions[k]).x + dPos.x * entityHit.intersectTime, (data.lastMeleePositions[k]).y + dPos.y * entityHit.intersectTime, (data.lastMeleePositions[k]).z + dPos.z * entityHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F)); 
              } 
            } 
          } 
          data.lastMeleePositions[k] = nextPosInWorldCoords;
        } 
        data.meleeProgress++;
        if (data.meleeProgress == data.meleeLength)
          data.meleeProgress = data.meleeLength = 0; 
      } 
    } 
  }
  
  public DamageSource getMeleeDamage(EntityPlayer attacker) {
    return (DamageSource)new EntityDamageSourceFlans(this.type.shortName, (Entity)attacker, attacker, (InfoType)this.type, false, true);
  }
  
  public void onMouseHeld(ItemStack stack, World world, EntityPlayerMP player, boolean left, boolean isShooting) {
    PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)player);
    if (data != null && data.shootClickDelay == 0) {
      if (player.field_70154_o instanceof EntitySeat && !((EntitySeat)player.field_70154_o).seatInfo.canSmallArms)
        return; 
      if (left && data.offHandGunSlot != 0) {
        ItemStack offHandGunStack = player.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
        GunType gunType = ((ItemGun)offHandGunStack.func_77973_b()).type;
        data.isShootingLeft = isShooting;
        if (gunType.getFireMode(offHandGunStack) == EnumFireMode.SEMIAUTO && isShooting) {
          data.isShootingLeft = false;
          player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, tryToShoot(offHandGunStack, gunType, world, player, true));
        } 
        if (gunType.getFireMode(offHandGunStack) == EnumFireMode.BURST && isShooting && data.burstRoundsRemainingLeft == 0) {
          data.isShootingLeft = false;
          data.burstRoundsRemainingLeft = gunType.numBurstRounds;
          player.field_71071_by.func_70299_a(data.offHandGunSlot - 1, tryToShoot(offHandGunStack, gunType, world, player, true));
        } 
      } else {
        data.isShootingRight = isShooting;
        if (this.type.getFireMode(stack) == EnumFireMode.SEMIAUTO && isShooting) {
          data.isShootingRight = false;
          player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, tryToShoot(stack, this.type, world, player, false));
        } 
        if (this.type.getFireMode(stack) == EnumFireMode.BURST && isShooting && data.burstRoundsRemainingRight == 0) {
          data.isShootingRight = false;
          data.burstRoundsRemainingRight = this.type.numBurstRounds;
          player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, tryToShoot(stack, this.type, world, player, false));
        } 
      } 
      if (this.type.useLoopingSounds && isShooting)
        data.shouldPlayWarmupSound = true; 
      if (this.type.labigunDelay) {
        data.isShootingRight = true;
        System.out.println("it should be fuckign working");
      } 
    } 
  }
  
  public ItemGun(GunType gun) {
    this.canClick = true;
    this.field_77777_bU = 1;
    this.type = gun;
    this.type.item = this;
    func_77627_a(true);
    func_77637_a((CreativeTabs)FlansMod.tabFlanGuns);
    GameRegistry.registerItem(this, this.type.shortName, "flansmod");
  }
  
  public ItemStack tryToShoot(ItemStack gunStack, GunType gunType, World world, EntityPlayerMP entityplayer, boolean left) {
    if (this.type.deployable)
      return gunStack; 
    PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)entityplayer);
    if ((left && !this.type.shootMelee && data.shootTimeLeft <= 0.0F) || (!left && !this.type.shootMelee && data.shootTimeRight <= 0.0F) || (this.type.getSecondaryFire(gunStack) && data.stabTimeLeft <= 0.0F) || (left && this.type.shootMelee && data.stabTimeLeft <= 0.0F) || (!left && this.type.shootMelee && data.stabTimeRight <= 0.0F) || (!left && this.type.sidearm && data.stabTimeRight <= 0.0F) || (!left && this.type.sidearm && data.stabTimeRight <= 0.0F)) {
      int bulletID = 0;
      ItemStack bulletStack = null;
      for (; bulletID < gunType.getNumAmmoItemsInGun(gunStack); bulletID++) {
        ItemStack checkingStack = getBulletItemStack(gunStack, bulletID);
        if (checkingStack != null && checkingStack.func_77973_b() != null && checkingStack.func_77960_j() < checkingStack.func_77958_k()) {
          bulletStack = checkingStack;
          break;
        } 
      } 
      if (bulletStack == null) {
        if (reload(gunStack, gunType, world, (EntityPlayer)entityplayer, false, left)) {
          if (!this.type.shootMelee) {
            data.shootTimeRight = data.shootTimeLeft = ((int)(gunType.getReloadTime(gunStack) * this.pouchMultiplier) + 1);
            if (this.type.sidearm || this.type.getSecondaryFire(gunStack))
              data.stabTimeRight = data.stabTimeLeft = ((int)(gunType.getReloadTime(gunStack) * this.pouchMultiplier) + 1); 
          } 
          if (left) {
            data.reloadingLeft = true;
            data.burstRoundsRemainingLeft = 0;
          } else {
            data.reloadingRight = true;
            data.burstRoundsRemainingRight = 0;
          } 
          FlansMod.getPacketHandler().sendTo((PacketBase)new PacketReload(left), entityplayer);
          String soundToPlay = null;
          AttachmentType grip = gunType.getGrip(gunStack);
          if (gunType.getSecondaryFire(gunStack) && grip != null && grip.secondaryReloadSound != null) {
            soundToPlay = grip.secondaryReloadSound;
          } else if (gunType.reloadSoundOnEmpty != null) {
            soundToPlay = gunType.reloadSoundOnEmpty;
          } else if (gunType.reloadSound != null) {
            soundToPlay = gunType.reloadSound;
          } 
          if (entityplayer.field_70170_p.field_72995_K && grip != null && grip.bayonet) {
            GunAnimations animations = FlansModClient.getGunAnimations((EntityLivingBase)entityplayer, false);
            animations.doBayonet(17);
          } 
          if (soundToPlay != null)
            PacketPlaySound.sendSoundPacket(entityplayer.field_70165_t, entityplayer.field_70163_u, entityplayer.field_70161_v, this.type.reloadSoundRange, entityplayer.field_71093_bK, soundToPlay, false); 
        } else if (gunType.clickSoundOnEmpty != null && this.canClick) {
          PacketPlaySound.sendSoundPacket(entityplayer.field_70165_t, entityplayer.field_70163_u, entityplayer.field_70161_v, this.type.reloadSoundRange, entityplayer.field_71093_bK, gunType.clickSoundOnEmpty, false);
        } 
      } else if (bulletStack.func_77973_b() instanceof ItemShootable) {
        shoot(gunStack, gunType, world, bulletStack, (EntityPlayer)entityplayer, left);
        this.canClick = true;
        bulletStack.func_77964_b(bulletStack.func_77960_j() + 1);
        setBulletItemStack(gunStack, bulletStack, bulletID);
        if (gunType.getFireMode(gunStack) == EnumFireMode.BURST) {
          if (left && data.burstRoundsRemainingLeft > 0)
            data.burstRoundsRemainingLeft--; 
          if (!left && data.burstRoundsRemainingRight > 0)
            data.burstRoundsRemainingRight--; 
        } 
        if (gunType.consumeGunUponUse && bulletStack.func_77960_j() == bulletStack.func_77958_k())
          return null; 
      } 
    } 
    return gunStack;
  }
  
  public boolean reload(ItemStack gunStack, GunType gunType, World world, EntityPlayer player, boolean forceReload, boolean left) {
    return reload(gunStack, gunType, world, (Entity)player, (IInventory)player.field_71071_by, player.field_71075_bZ.field_75098_d, forceReload);
  }
  
  public boolean reload(ItemStack gunStack, GunType gunType, World world, Entity entity, IInventory inventory, boolean creative, boolean forceReload) {
    if (gunType.deployable)
      return false; 
    if (forceReload && !gunType.canForceReload)
      return false; 
    boolean reloadedSomething = false;
    for (int i = 0; i < gunType.getNumAmmoItemsInGun(gunStack); i++) {
      ItemStack bulletStack = getBulletItemStack(gunStack, i);
      if (bulletStack == null || bulletStack.func_77960_j() == bulletStack.func_77958_k() || forceReload) {
        if (this.type.shootMelee) {
          ShootableType bulletToGive = this.type.ammo.get(0);
          int numToGive = Math.min(bulletToGive.maxStackSize, 1);
          if (((InventoryPlayer)inventory).func_70441_a(new ItemStack(bulletToGive.item, numToGive)))
            boolean bool = true; 
        } 
        int bestSlot = -1;
        int bulletsInBestSlot = 0;
        for (int j = 0; j < inventory.func_70302_i_(); j++) {
          ItemStack item = inventory.func_70301_a(j);
          if (item != null && item.func_77973_b() instanceof ItemShootable && gunType.isAmmo(((ItemShootable)item.func_77973_b()).type, gunStack)) {
            int bulletsInThisSlot = item.func_77958_k() - item.func_77960_j();
            if (bulletsInThisSlot > bulletsInBestSlot) {
              bestSlot = j;
              bulletsInBestSlot = bulletsInThisSlot;
            } 
          } 
        } 
        if (bestSlot != -1) {
          ItemStack newBulletStack = inventory.func_70301_a(bestSlot);
          ShootableType newBulletType = ((ItemShootable)newBulletStack.func_77973_b()).type;
          if (bulletStack != null && bulletStack.func_77973_b() instanceof ItemShootable && ((ItemShootable)bulletStack.func_77973_b()).type.dropItemOnReload != null && !creative && bulletStack.func_77960_j() == bulletStack.func_77958_k())
            dropItem(world, entity, ((ItemShootable)bulletStack.func_77973_b()).type.dropItemOnReload); 
          if (bulletStack != null && bulletStack.func_77960_j() < bulletStack.func_77958_k() && 
            !InventoryHelper.addItemStackToInventory(inventory, bulletStack, creative))
            entity.func_70099_a(bulletStack, 0.5F); 
          this.bulletDamageInfo = newBulletType.damageVsLiving;
          ItemStack stackToLoad = newBulletStack.func_77946_l();
          stackToLoad.field_77994_a = 1;
          setBulletItemStack(gunStack, stackToLoad, i);
          if (!creative)
            newBulletStack.field_77994_a--; 
          if (newBulletStack.field_77994_a <= 0)
            newBulletStack = null; 
          inventory.func_70299_a(bestSlot, newBulletStack);
          reloadedSomething = true;
        } 
      } 
    } 
    return reloadedSomething;
  }
  
  public static void dropItem(World world, Entity entity, String itemName) {
    if (itemName != null) {
      int damage = 0;
      if (itemName.contains(".")) {
        damage = Integer.parseInt(itemName.split("\\.")[1]);
        itemName = itemName.split("\\.")[0];
      } 
      ItemStack dropStack = InfoType.getRecipeElement(itemName, damage);
      entity.func_70099_a(dropStack, 0.5F);
    } 
  }
  
  private void shoot(ItemStack stack, GunType gunType, World world, ItemStack bulletStack, EntityPlayer entityPlayer, boolean left) {
    ShootableType bullet = ((ItemShootable)bulletStack.func_77973_b()).type;
    boolean lastBullet = false;
    this.bulletDamageInfo = bullet.damageVsLiving;
    ItemStack[] bulletStacks = new ItemStack[this.type.getNumAmmoItemsInGun(stack)];
    for (int i = 0; i < this.type.getNumAmmoItemsInGun(stack); i++) {
      bulletStacks[i] = ((ItemGun)stack.func_77973_b()).getBulletItemStack(stack, i);
      if (bulletStacks[i] != null && bulletStacks[i].func_77973_b() instanceof ItemBullet && bulletStacks[i].func_77958_k() - bulletStacks[i].func_77960_j() == 1)
        lastBullet = true; 
    } 
    if (this.soundDelay <= 0 && gunType.shootSound != null) {
      AttachmentType barrel = gunType.getBarrel(stack);
      AttachmentType grip = gunType.getGrip(stack);
      boolean silenced = (barrel != null && barrel.silencer && !gunType.getSecondaryFire(stack));
      String soundToPlay = null;
      if (gunType.getSecondaryFire(stack) && grip != null && grip.secondaryShootSound != null) {
        soundToPlay = grip.secondaryShootSound;
      } else if (lastBullet && gunType.lastShootSound != null) {
        soundToPlay = gunType.lastShootSound;
      } else if (silenced && gunType.suppressedShootSound != null) {
        soundToPlay = gunType.suppressedShootSound;
      } else if (gunType.shootSound != null) {
        soundToPlay = gunType.shootSound;
      } 
      if (soundToPlay != null) {
        PacketPlaySound.sendSoundPacket(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, this.type.gunSoundRange, entityPlayer.field_71093_bK, soundToPlay, gunType.distortSound, silenced);
        FlansMod.packetHandler.sendToDonut((PacketBase)new PacketPlaySound(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, soundToPlay), entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, 0.5F, this.type.gunSoundRange, entityPlayer.field_71093_bK);
        this.soundDelay = gunType.shootSoundLength;
      } 
      if (this.type.distantShootSound != null)
        FlansMod.packetHandler.sendToDonut((PacketBase)new PacketPlaySound(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, this.type.distantShootSound), entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, this.type.gunSoundRange, this.type.distantSoundRange, entityPlayer.field_71093_bK); 
    } 
    if (!world.field_72995_K && bulletStack.func_77973_b() instanceof ItemShootable) {
      ItemShootable itemShootable = (ItemShootable)bulletStack.func_77973_b();
      ShootableType shootableType = itemShootable.type;
      int numBullets = -1;
      float spread = -1.0F;
      if (shootableType instanceof BulletType) {
        if (gunType.allowNumBulletsByBulletType)
          numBullets = ((BulletType)shootableType).numBullets; 
        if (gunType.allowSpreadByBullet)
          spread = ((BulletType)shootableType).bulletSpread; 
      } 
      if (numBullets <= 0)
        numBullets = gunType.getNumBullets(stack); 
      if (spread <= 0.0F) {
        float result = gunType.getSpread(stack, entityPlayer.func_70093_af(), entityPlayer.func_70051_ag());
        spread = result;
      } 
      for (int k = 0; k < numBullets; k++) {
        world.func_72838_d(itemShootable.getEntity(world, (EntityLivingBase)entityPlayer, spread, gunType
              
              .getDamage(stack), gunType
              .getBulletSpeed(stack), (numBullets > 1), bulletStack
              
              .func_77960_j(), (InfoType)gunType, gunType.Xoffset, gunType.Yoffset, gunType.Zoffset));
        AttachmentType grip = gunType.getGrip(bulletStack);
        System.out.println(this.type.getSecondaryFire(stack));
        if (this.type.muzzleParticleHave && !this.type.getSecondaryFire(stack))
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(entityPlayer.field_70165_t + (entityPlayer.func_70040_Z()).field_72450_a * this.type.muzzleOffset, entityPlayer.field_70163_u + (entityPlayer.func_70040_Z()).field_72448_b * this.type.muzzleOffset, entityPlayer.field_70161_v + (entityPlayer.func_70040_Z()).field_72449_c * this.type.muzzleOffset, this.type.muzzleParticleCount, this.type.muzzleParticle), entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v, 200.0F, entityPlayer.field_71093_bK); 
      } 
      FlansMod.packetHandler.sendTo((PacketBase)new PacketGunRecoil(gunType.getRecoilPitch(stack), gunType.getRecoilYaw(stack), gunType.decreaseRecoilPitch, gunType.decreaseRecoilYaw, gunType.getSustainedRecoilPitch(stack), gunType.getSustainedRecoilYaw(stack)), (EntityPlayerMP)entityPlayer);
      if (bullet.dropItemOnShoot != null && !entityPlayer.field_71075_bZ.field_75098_d)
        dropItem(world, (Entity)entityPlayer, bullet.dropItemOnShoot); 
      if (gunType.dropItemOnShoot != null)
        dropItem(world, (Entity)entityPlayer, gunType.dropItemOnShoot); 
    } 
    if (left) {
      if (!this.type.shootMelee || !this.type.sidearm || !this.type.getSecondaryFire(stack))
        (PlayerHandler.getPlayerData(entityPlayer)).shootTimeLeft += gunType.getShootDelay(stack); 
      if (this.type.shootMelee || this.type.sidearm || this.type.getSecondaryFire(stack))
        (PlayerHandler.getPlayerData(entityPlayer)).stabTimeLeft += gunType.getShootDelay(stack); 
    } else {
      if (!this.type.shootMelee || !this.type.sidearm || !this.type.getSecondaryFire(stack))
        (PlayerHandler.getPlayerData(entityPlayer)).shootTimeRight += gunType.getShootDelay(stack); 
      if (this.type.shootMelee || this.type.sidearm || this.type.getSecondaryFire(stack))
        (PlayerHandler.getPlayerData(entityPlayer)).stabTimeRight += gunType.getShootDelay(stack); 
    } 
    if (gunType.knockback > 0.0F);
  }
  
  public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic getPlayerData : (Lnet/minecraft/entity/player/EntityPlayer;)Lcom/flansmod/common/PlayerData;
    //   4: astore #4
    //   6: aload #4
    //   8: getfield isBlockingLeft : I
    //   11: bipush #10
    //   13: if_icmpge -> 118
    //   16: aload_0
    //   17: getfield type : Lcom/flansmod/common/guns/GunType;
    //   20: getfield canBlock : Z
    //   23: ifeq -> 118
    //   26: aload #4
    //   28: aload_0
    //   29: getfield type : Lcom/flansmod/common/guns/GunType;
    //   32: getfield blockTime : I
    //   35: putfield isBlockingLeft : I
    //   38: aload_3
    //   39: getfield field_70165_t : D
    //   42: aload_3
    //   43: getfield field_70163_u : D
    //   46: aload_3
    //   47: getfield field_70161_v : D
    //   50: ldc2_w 12.0
    //   53: aload_3
    //   54: getfield field_71093_bK : I
    //   57: ldc_w 'swordDraw'
    //   60: iconst_1
    //   61: invokestatic sendSoundPacket : (DDDDILjava/lang/String;Z)V
    //   64: aload_3
    //   65: new net/minecraft/potion/PotionEffect
    //   68: dup
    //   69: getstatic net/minecraft/potion/Potion.field_76421_d : Lnet/minecraft/potion/Potion;
    //   72: getfield field_76415_H : I
    //   75: aload_0
    //   76: getfield type : Lcom/flansmod/common/guns/GunType;
    //   79: getfield blockTime : I
    //   82: iconst_4
    //   83: invokespecial <init> : (III)V
    //   86: invokevirtual func_70690_d : (Lnet/minecraft/potion/PotionEffect;)V
    //   89: aload_3
    //   90: getfield field_70170_p : Lnet/minecraft/world/World;
    //   93: getfield field_72995_K : Z
    //   96: ifeq -> 118
    //   99: aload_3
    //   100: iconst_0
    //   101: invokestatic getGunAnimations : (Lnet/minecraft/entity/EntityLivingBase;Z)Lcom/flansmod/client/model/GunAnimations;
    //   104: astore #5
    //   106: aload #5
    //   108: aload_0
    //   109: getfield type : Lcom/flansmod/common/guns/GunType;
    //   112: getfield meleeTime : I
    //   115: invokevirtual doMeleeLeft : (I)V
    //   118: aload #4
    //   120: getfield minigunSpeed : I
    //   123: ifge -> 148
    //   126: aload_0
    //   127: getfield type : Lcom/flansmod/common/guns/GunType;
    //   130: getfield labigunDelay : Z
    //   133: ifeq -> 148
    //   136: aload #4
    //   138: aload_0
    //   139: getfield type : Lcom/flansmod/common/guns/GunType;
    //   142: getfield minigunStartSpeed : I
    //   145: putfield minigunSpeed : I
    //   148: aload_3
    //   149: getfield field_70170_p : Lnet/minecraft/world/World;
    //   152: getfield field_72995_K : Z
    //   155: ifeq -> 193
    //   158: aload_0
    //   159: getfield type : Lcom/flansmod/common/guns/GunType;
    //   162: aload_1
    //   163: invokevirtual getSecondaryFire : (Lnet/minecraft/item/ItemStack;)Z
    //   166: ifeq -> 193
    //   169: aload_3
    //   170: iconst_0
    //   171: invokestatic getGunAnimations : (Lnet/minecraft/entity/EntityLivingBase;Z)Lcom/flansmod/client/model/GunAnimations;
    //   174: astore #5
    //   176: aload #5
    //   178: aload_0
    //   179: getfield type : Lcom/flansmod/common/guns/GunType;
    //   182: aload_1
    //   183: invokevirtual getGrip : (Lnet/minecraft/item/ItemStack;)Lcom/flansmod/common/guns/AttachmentType;
    //   186: getfield secondaryShootDelay : F
    //   189: f2i
    //   190: invokevirtual doMelee : (I)V
    //   193: aload_0
    //   194: getfield type : Lcom/flansmod/common/guns/GunType;
    //   197: getfield deployable : Z
    //   200: ifeq -> 805
    //   203: aload_3
    //   204: getfield field_70177_z : F
    //   207: fneg
    //   208: ldc_w 0.01745329
    //   211: fmul
    //   212: ldc_w 3.141593
    //   215: fsub
    //   216: invokestatic func_76134_b : (F)F
    //   219: fstore #5
    //   221: aload_3
    //   222: getfield field_70177_z : F
    //   225: fneg
    //   226: ldc_w 0.01745329
    //   229: fmul
    //   230: ldc_w 3.141593
    //   233: fsub
    //   234: invokestatic func_76126_a : (F)F
    //   237: fstore #6
    //   239: aload_3
    //   240: getfield field_70125_A : F
    //   243: fneg
    //   244: ldc_w 0.01745329
    //   247: fmul
    //   248: invokestatic func_76134_b : (F)F
    //   251: fneg
    //   252: fstore #7
    //   254: aload_3
    //   255: getfield field_70125_A : F
    //   258: fneg
    //   259: ldc_w 0.01745329
    //   262: fmul
    //   263: invokestatic func_76126_a : (F)F
    //   266: fstore #8
    //   268: ldc2_w 5.0
    //   271: dstore #9
    //   273: aload_3
    //   274: getfield field_70165_t : D
    //   277: aload_3
    //   278: getfield field_70163_u : D
    //   281: ldc2_w 1.62
    //   284: dadd
    //   285: aload_3
    //   286: getfield field_70129_M : F
    //   289: f2d
    //   290: dsub
    //   291: aload_3
    //   292: getfield field_70161_v : D
    //   295: invokestatic func_72443_a : (DDD)Lnet/minecraft/util/Vec3;
    //   298: astore #11
    //   300: aload #11
    //   302: fload #6
    //   304: fload #7
    //   306: fmul
    //   307: f2d
    //   308: dload #9
    //   310: dmul
    //   311: fload #8
    //   313: f2d
    //   314: dload #9
    //   316: dmul
    //   317: fload #5
    //   319: fload #7
    //   321: fmul
    //   322: f2d
    //   323: dload #9
    //   325: dmul
    //   326: invokevirtual func_72441_c : (DDD)Lnet/minecraft/util/Vec3;
    //   329: astore #12
    //   331: aload_2
    //   332: aload #11
    //   334: aload #12
    //   336: iconst_1
    //   337: invokevirtual func_72901_a : (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;Z)Lnet/minecraft/util/MovingObjectPosition;
    //   340: astore #13
    //   342: aload #13
    //   344: ifnull -> 805
    //   347: aload #13
    //   349: getfield field_72313_a : Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
    //   352: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK : Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
    //   355: if_acmpne -> 805
    //   358: aload #13
    //   360: getfield field_72310_e : I
    //   363: iconst_1
    //   364: if_icmpne -> 805
    //   367: aload_3
    //   368: getfield field_70177_z : F
    //   371: ldc_w 4.0
    //   374: fmul
    //   375: ldc_w 360.0
    //   378: fdiv
    //   379: f2d
    //   380: ldc2_w 0.5
    //   383: dadd
    //   384: invokestatic func_76128_c : (D)I
    //   387: iconst_3
    //   388: iand
    //   389: istore #14
    //   391: aload #13
    //   393: getfield field_72311_b : I
    //   396: istore #15
    //   398: aload #13
    //   400: getfield field_72312_c : I
    //   403: istore #16
    //   405: aload #13
    //   407: getfield field_72309_d : I
    //   410: istore #17
    //   412: aload_2
    //   413: getfield field_72995_K : Z
    //   416: ifne -> 805
    //   419: aload_2
    //   420: iload #15
    //   422: iload #16
    //   424: iload #17
    //   426: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
    //   429: getstatic net/minecraft/init/Blocks.field_150433_aE : Lnet/minecraft/block/Block;
    //   432: if_acmpne -> 438
    //   435: iinc #16, -1
    //   438: aload_0
    //   439: aload_2
    //   440: iload #15
    //   442: iload #16
    //   444: iload #17
    //   446: invokespecial isSolid : (Lnet/minecraft/world/World;III)Z
    //   449: ifeq -> 805
    //   452: aload_2
    //   453: iload #15
    //   455: iload #16
    //   457: iconst_1
    //   458: iadd
    //   459: iload #17
    //   461: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
    //   464: getstatic net/minecraft/init/Blocks.field_150350_a : Lnet/minecraft/block/Block;
    //   467: if_acmpeq -> 488
    //   470: aload_2
    //   471: iload #15
    //   473: iload #16
    //   475: iconst_1
    //   476: iadd
    //   477: iload #17
    //   479: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
    //   482: getstatic net/minecraft/init/Blocks.field_150433_aE : Lnet/minecraft/block/Block;
    //   485: if_acmpne -> 805
    //   488: aload_2
    //   489: iload #15
    //   491: iload #14
    //   493: iconst_1
    //   494: if_icmpne -> 501
    //   497: iconst_1
    //   498: goto -> 502
    //   501: iconst_0
    //   502: iadd
    //   503: iload #14
    //   505: iconst_3
    //   506: if_icmpne -> 513
    //   509: iconst_1
    //   510: goto -> 514
    //   513: iconst_0
    //   514: isub
    //   515: iload #16
    //   517: iconst_1
    //   518: iadd
    //   519: iload #17
    //   521: iload #14
    //   523: ifne -> 530
    //   526: iconst_1
    //   527: goto -> 531
    //   530: iconst_0
    //   531: isub
    //   532: iload #14
    //   534: iconst_2
    //   535: if_icmpne -> 542
    //   538: iconst_1
    //   539: goto -> 543
    //   542: iconst_0
    //   543: iadd
    //   544: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
    //   547: getstatic net/minecraft/init/Blocks.field_150350_a : Lnet/minecraft/block/Block;
    //   550: if_acmpne -> 805
    //   553: aload_2
    //   554: iload #15
    //   556: iload #14
    //   558: iconst_1
    //   559: if_icmpne -> 566
    //   562: iconst_1
    //   563: goto -> 567
    //   566: iconst_0
    //   567: iadd
    //   568: iload #14
    //   570: iconst_3
    //   571: if_icmpne -> 578
    //   574: iconst_1
    //   575: goto -> 579
    //   578: iconst_0
    //   579: isub
    //   580: iload #16
    //   582: iload #17
    //   584: iload #14
    //   586: ifne -> 593
    //   589: iconst_1
    //   590: goto -> 594
    //   593: iconst_0
    //   594: isub
    //   595: iload #14
    //   597: iconst_2
    //   598: if_icmpne -> 605
    //   601: iconst_1
    //   602: goto -> 606
    //   605: iconst_0
    //   606: iadd
    //   607: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
    //   610: getstatic net/minecraft/init/Blocks.field_150350_a : Lnet/minecraft/block/Block;
    //   613: if_acmpeq -> 679
    //   616: aload_2
    //   617: iload #15
    //   619: iload #14
    //   621: iconst_1
    //   622: if_icmpne -> 629
    //   625: iconst_1
    //   626: goto -> 630
    //   629: iconst_0
    //   630: iadd
    //   631: iload #14
    //   633: iconst_3
    //   634: if_icmpne -> 641
    //   637: iconst_1
    //   638: goto -> 642
    //   641: iconst_0
    //   642: isub
    //   643: iload #16
    //   645: iload #17
    //   647: iload #14
    //   649: ifne -> 656
    //   652: iconst_1
    //   653: goto -> 657
    //   656: iconst_0
    //   657: isub
    //   658: iload #14
    //   660: iconst_2
    //   661: if_icmpne -> 668
    //   664: iconst_1
    //   665: goto -> 669
    //   668: iconst_0
    //   669: iadd
    //   670: invokevirtual func_147439_a : (III)Lnet/minecraft/block/Block;
    //   673: getstatic net/minecraft/init/Blocks.field_150433_aE : Lnet/minecraft/block/Block;
    //   676: if_acmpne -> 805
    //   679: getstatic com/flansmod/common/guns/EntityMG.mgs : Ljava/util/List;
    //   682: invokeinterface iterator : ()Ljava/util/Iterator;
    //   687: astore #18
    //   689: aload #18
    //   691: invokeinterface hasNext : ()Z
    //   696: ifeq -> 756
    //   699: aload #18
    //   701: invokeinterface next : ()Ljava/lang/Object;
    //   706: checkcast com/flansmod/common/guns/EntityMG
    //   709: astore #19
    //   711: aload #19
    //   713: getfield blockX : I
    //   716: iload #15
    //   718: if_icmpne -> 753
    //   721: aload #19
    //   723: getfield blockY : I
    //   726: iload #16
    //   728: iconst_1
    //   729: iadd
    //   730: if_icmpne -> 753
    //   733: aload #19
    //   735: getfield blockZ : I
    //   738: iload #17
    //   740: if_icmpne -> 753
    //   743: aload #19
    //   745: getfield field_70128_L : Z
    //   748: ifne -> 753
    //   751: aload_1
    //   752: areturn
    //   753: goto -> 689
    //   756: aload_2
    //   757: getfield field_72995_K : Z
    //   760: ifne -> 790
    //   763: aload_2
    //   764: new com/flansmod/common/guns/EntityMG
    //   767: dup
    //   768: aload_2
    //   769: iload #15
    //   771: iload #16
    //   773: iconst_1
    //   774: iadd
    //   775: iload #17
    //   777: iload #14
    //   779: aload_0
    //   780: getfield type : Lcom/flansmod/common/guns/GunType;
    //   783: invokespecial <init> : (Lnet/minecraft/world/World;IIIILcom/flansmod/common/guns/GunType;)V
    //   786: invokevirtual func_72838_d : (Lnet/minecraft/entity/Entity;)Z
    //   789: pop
    //   790: aload_3
    //   791: getfield field_71075_bZ : Lnet/minecraft/entity/player/PlayerCapabilities;
    //   794: getfield field_75098_d : Z
    //   797: ifne -> 805
    //   800: aload_1
    //   801: iconst_0
    //   802: putfield field_77994_a : I
    //   805: aload_2
    //   806: getfield field_72995_K : Z
    //   809: ifeq -> 839
    //   812: iconst_0
    //   813: istore #5
    //   815: iload #5
    //   817: iconst_3
    //   818: if_icmpge -> 839
    //   821: invokestatic func_71410_x : ()Lnet/minecraft/client/Minecraft;
    //   824: getfield field_71460_t : Lnet/minecraft/client/renderer/EntityRenderer;
    //   827: getfield field_78516_c : Lnet/minecraft/client/renderer/ItemRenderer;
    //   830: invokevirtual func_78441_a : ()V
    //   833: iinc #5, 1
    //   836: goto -> 815
    //   839: aload_1
    //   840: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #2748	-> 0
    //   #2750	-> 6
    //   #2752	-> 26
    //   #2753	-> 38
    //   #2754	-> 64
    //   #2757	-> 89
    //   #2759	-> 99
    //   #2760	-> 106
    //   #2766	-> 118
    //   #2767	-> 136
    //   #2776	-> 148
    //   #2778	-> 169
    //   #2779	-> 176
    //   #2784	-> 193
    //   #2787	-> 203
    //   #2788	-> 221
    //   #2789	-> 239
    //   #2790	-> 254
    //   #2791	-> 268
    //   #2792	-> 273
    //   #2793	-> 300
    //   #2794	-> 331
    //   #2797	-> 342
    //   #2799	-> 358
    //   #2801	-> 367
    //   #2802	-> 391
    //   #2803	-> 398
    //   #2804	-> 405
    //   #2805	-> 412
    //   #2807	-> 419
    //   #2809	-> 435
    //   #2811	-> 438
    //   #2813	-> 679
    //   #2815	-> 711
    //   #2816	-> 751
    //   #2817	-> 753
    //   #2818	-> 756
    //   #2820	-> 763
    //   #2822	-> 790
    //   #2823	-> 800
    //   #2830	-> 805
    //   #2832	-> 812
    //   #2833	-> 821
    //   #2832	-> 833
    //   #2835	-> 839
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   106	12	5	animations	Lcom/flansmod/client/model/GunAnimations;
    //   176	17	5	animations	Lcom/flansmod/client/model/GunAnimations;
    //   711	42	19	mg	Lcom/flansmod/common/guns/EntityMG;
    //   391	414	14	playerDir	I
    //   398	407	15	i	I
    //   405	400	16	j	I
    //   412	393	17	k	I
    //   221	584	5	cosYaw	F
    //   239	566	6	sinYaw	F
    //   254	551	7	cosPitch	F
    //   268	537	8	sinPitch	F
    //   273	532	9	length	D
    //   300	505	11	posVec	Lnet/minecraft/util/Vec3;
    //   331	474	12	lookVec	Lnet/minecraft/util/Vec3;
    //   342	463	13	look	Lnet/minecraft/util/MovingObjectPosition;
    //   815	24	5	i	I
    //   0	841	0	this	Lcom/flansmod/common/guns/ItemGun;
    //   0	841	1	itemstack	Lnet/minecraft/item/ItemStack;
    //   0	841	2	world	Lnet/minecraft/world/World;
    //   0	841	3	entityplayer	Lnet/minecraft/entity/player/EntityPlayer;
    //   6	835	4	data	Lcom/flansmod/common/PlayerData;
  }
  
  private boolean isSolid(World world, int i, int j, int k) {
    Block block = world.func_147439_a(i, j, k);
    return (block != null && block.func_149688_o().func_76220_a() && block.func_149662_c());
  }
  
  public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
    return ((this.type.secondaryFunction != EnumSecondaryFunction.MELEE && !this.type.shootMelee) || (this.type.secondaryFunction != EnumSecondaryFunction.MELEE && this.type.meleeDamage == 1.0F) || (this.type.shootMelee && this.type.meleeDamage == 0.1D));
  }
  
  public boolean func_77662_d() {
    return true;
  }
  
  public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
    if (this.type.meleeSound != null)
      PacketPlaySound.sendSoundPacket(entityLiving.field_70165_t, entityLiving.field_70163_u, entityLiving.field_70161_v, this.type.meleeSoundRange, entityLiving.field_71093_bK, this.type.meleeSound, true); 
    if (this.type.secondaryFunction == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.meleeLeft == true && AHeld) {
      if (entityLiving.field_70170_p.field_72995_K && (PlayerHandler.getPlayerData((EntityPlayer)entityLiving)).isBlockingLeft <= 0) {
        GunAnimations animations = FlansModClient.getGunAnimations(entityLiving, false);
        animations.doMeleeLeft(this.type.meleeTime);
      } 
      if (entityLiving instanceof EntityPlayer && !this.type.shootMelee) {
        PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)entityLiving);
        data.doMeleeLeft((EntityPlayer)entityLiving, this.type.meleeTime, this.type);
      } 
    } else if (this.type.secondaryFunction == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.meleeRight == true && DHeld) {
      if (entityLiving.field_70170_p.field_72995_K && (PlayerHandler.getPlayerData((EntityPlayer)entityLiving)).isBlockingLeft <= 0) {
        GunAnimations animations = FlansModClient.getGunAnimations(entityLiving, false);
        animations.doMeleeRight(this.type.meleeTime);
      } 
      if (entityLiving instanceof EntityPlayer && !this.type.shootMelee) {
        PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)entityLiving);
        data.doMeleeRight((EntityPlayer)entityLiving, this.type.meleeTime, this.type);
      } 
    } else if (this.type.secondaryFunction == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.meleeDown == true && WHeld) {
      if (entityLiving.field_70170_p.field_72995_K && (PlayerHandler.getPlayerData((EntityPlayer)entityLiving)).isBlockingLeft <= 0) {
        GunAnimations animations = FlansModClient.getGunAnimations(entityLiving, false);
        animations.doMeleeDown(this.type.meleeTime);
      } 
      if (entityLiving instanceof EntityPlayer && !this.type.shootMelee) {
        PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)entityLiving);
        data.doMeleeDown((EntityPlayer)entityLiving, this.type.meleeTime, this.type);
      } 
    } else if ((this.type.secondaryFunction == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && !this.type.lance) || (this.type.secondaryFunction == EnumSecondaryFunction.CUSTOM_MELEE && !this.blocking && this.type.lance == true && WHeld)) {
      if (entityLiving.field_70170_p.field_72995_K && (PlayerHandler.getPlayerData((EntityPlayer)entityLiving)).isBlockingLeft <= 0) {
        GunAnimations animations = FlansModClient.getGunAnimations(entityLiving, false);
        animations.doMelee(this.type.meleeTime);
      } 
      if (entityLiving instanceof EntityPlayer && !this.type.shootMelee) {
        PlayerData data = PlayerHandler.getPlayerData((EntityPlayer)entityLiving);
        data.doMelee((EntityPlayer)entityLiving, this.type.meleeTime, this.type);
      } 
    } 
    return (this.type.secondaryFunction != EnumSecondaryFunction.MELEE);
  }
  
  public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) {
    return true;
  }
  
  public boolean func_150897_b(Block p_150897_1_) {
    return false;
  }
  
  @SubscribeEvent
  public void onEventBlockBreak(BlockEvent.BreakEvent event) {
    EntityPlayer player = event.getPlayer();
    if (player != null && player.func_70694_bm() != null)
      if (player.func_70694_bm().func_77973_b() instanceof ItemGun)
        event.setCanceled(true);  
  }
  
  @SideOnly(Side.CLIENT)
  public int func_82790_a(ItemStack par1ItemStack, int par2) {
    return this.type.colour;
  }
  
  public boolean isItemStackDamageable() {
    return true;
  }
  
  public void func_150895_a(Item item, CreativeTabs tabs, List list) {
    PaintableType type = ((IPaintableItem)item).GetPaintableType();
    if (FlansMod.addAllPaintjobsToCreative) {
      for (Paintjob paintjob : type.paintjobs)
        addPaintjobToList(item, type, paintjob, list); 
    } else {
      addPaintjobToList(item, type, type.defaultPaintjob, list);
    } 
  }
  
  private void addPaintjobToList(Item item, PaintableType type, Paintjob paintjob, List<ItemStack> list) {
    ItemStack paintableStack = new ItemStack(item, 1, paintjob.ID);
    NBTTagCompound tags = new NBTTagCompound();
    paintableStack.func_77982_d(tags);
    list.add(paintableStack);
  }
  
  @SideOnly(Side.CLIENT)
  public void func_94581_a(IIconRegister icon) {
    this.icons = new IIcon[this.type.paintjobs.size()];
    this.defaultIcon = icon.func_94245_a("flansmod:null");
    this.field_77791_bV = icon.func_94245_a("FlansMod:" + this.type.iconPath);
    for (int i = 0; i < this.type.paintjobs.size(); i++)
      this.icons[i] = icon.func_94245_a("FlansMod:" + ((Paintjob)this.type.paintjobs.get(i)).iconName); 
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon func_77650_f(ItemStack stack) {
    if (this.icons != null)
      return this.icons[stack.func_77960_j()]; 
    return this.defaultIcon;
  }
  
  public int func_77626_a(ItemStack par1ItemStack) {
    return 100;
  }
  
  public EnumAction func_77661_b(ItemStack par1ItemStack) {
    if (this.type.shootMelee && !this.type.spear && this.fullHands == 0)
      return null; 
    return (this.type != null) ? this.type.itemUseAction : EnumAction.bow;
  }
  
  public Multimap getAttributeModifiers(ItemStack stack) {
    Multimap map = super.getAttributeModifiers(stack);
    map.put(SharedMonsterAttributes.field_111266_c.func_111108_a(), new AttributeModifier(field_111210_e, "KnockbackResist", this.type.knockbackModifier, 0));
    map.put(SharedMonsterAttributes.field_111263_d.func_111108_a(), new AttributeModifier(field_111210_e, "MovementSpeed", (this.type.getMovementSpeed(stack) - 1.0F), 2));
    if (this.type.secondaryFunction == EnumSecondaryFunction.MELEE)
      map.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Weapon modifier", this.type.meleeDamage, 0)); 
    return map;
  }
  
  public static float roundFloat(float value, int points) {
    int pow = 10;
    for (int i = 1; i < points; i++)
      pow *= 10; 
    float result = value * pow;
    return (int)((result - (int)result >= 0.5F) ? (result + 1.0F) : result) / pow;
  }
}
