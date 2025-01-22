package com.flansmod.common.driveables.mechas;

import com.flansmod.client.model.GunAnimations;
import com.flansmod.common.FlansMod;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.DriveableData;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.EnumFireMode;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.InventoryHelper;
import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketDriveableDamage;
import com.flansmod.common.network.PacketDriveableGUI;
import com.flansmod.common.network.PacketDriveableKey;
import com.flansmod.common.network.PacketMechaControl;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.tools.ItemTool;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import com.flansmod.common.vector.Vector3i;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.world.BlockEvent;

public class EntityMecha extends EntityDriveable {
  private int ticksSinceUsed;
  
  public int toggleTimer = 0;
  
  private float moveX = 0.0F;
  
  private float moveZ = 0.0F;
  
  public RotatedAxes legAxes;
  
  public float prevLegsYaw = 0.0F;
  
  private int jumpDelay = 0;
  
  public MechaInventory inventory;
  
  public float legSwing = 0.0F;
  
  public int shootDelayLeft = 0, shootDelayRight = 0;
  
  public int soundDelayLeft = 0;
  
  public int soundDelayRight = 0;
  
  public Vector3i breakingBlock = null;
  
  public float breakingProgress = 0.0F;
  
  private float rocketTimer = 0.0F;
  
  private int diamondTimer = 0;
  
  public int legAnimTimer = 1;
  
  public int legAnimMax = 1;
  
  public int animState;
  
  public float second = 0.0F;
  
  public int lastHealth = 0;
  
  public int lastFlare = 0;
  
  public float fivesec = 0.0F;
  
  public float poopooThrottle = 0.0F;
  
  public int targetLeftUpper = 0;
  
  public int targetLeftLower = 0;
  
  public int targetLeftFoot = 0;
  
  public int targetLeftUpperSpeed = 1;
  
  public int targetLeftLowerSpeed = 1;
  
  public int targetLeftFootSpeed = 1;
  
  int targetRightUpper = 0;
  
  int targetRightLower = 0;
  
  int targetRightFoot = 0;
  
  int targetRightUpperSpeed = 1;
  
  int targetRightLowerSpeed = 1;
  
  int targetRightFootSpeed = 1;
  
  public float leftLegUpperAngle = 0.0F;
  
  public float leftLegLowerAngle = 0.0F;
  
  public float leftFootAngle = 0.0F;
  
  public float rightLegUpperAngle = 0.0F;
  
  public float rightLegLowerAngle = 0.0F;
  
  public float rightFootAngle = 0.0F;
  
  public float prevLeftLegUpperAngle = 0.0F;
  
  public float prevLeftLegLowerAngle = 0.0F;
  
  public float prevLeftFootAngle = 0.0F;
  
  public float prevRightLegUpperAngle = 0.0F;
  
  public float prevRightLegLowerAngle = 0.0F;
  
  public float prevRightFootAngle = 0.0F;
  
  public float legPosition = 0.0F;
  
  public int stompDelay;
  
  public GunAnimations leftAnimations = new GunAnimations();
  
  public GunAnimations rightAnimations = new GunAnimations();
  
  boolean couldNotFindFuel;
  
  private int exitTimer = 40;
  
  public EntityMecha(World world) {
    super(world);
    func_70105_a(2.0F, 3.0F);
    this.field_70138_W = 3.0F;
    this.legAxes = new RotatedAxes();
    this.inventory = new MechaInventory(this);
    this.isMecha = true;
  }
  
  public EntityMecha(World world, double x, double y, double z, MechaType type, DriveableData data, NBTTagCompound tags) {
    super(world, type, data);
    this.legAxes = new RotatedAxes();
    func_70105_a(2.0F, 3.0F);
    this.field_70138_W = 3.0F;
    func_70107_b(x, y, z);
    initType(type, false);
    this.inventory = new MechaInventory(this, tags);
    this.isMecha = true;
  }
  
  public EntityMecha(World world, double x, double y, double z, EntityPlayer placer, MechaType type, DriveableData data, NBTTagCompound tags) {
    this(world, x, y, z, type, data, tags);
    rotateYaw(placer.field_70177_z + 90.0F);
    this.legAxes.rotateGlobalYaw(placer.field_70177_z + 90.0F);
    this.prevLegsYaw = this.legAxes.getYaw();
    this.isMecha = true;
  }
  
  protected void initType(DriveableType type, boolean clientSide) {
    super.initType(type, clientSide);
    func_70105_a(((MechaType)type).width, ((MechaType)type).height);
    this.field_70138_W = ((MechaType)type).stepHeight;
    this.isMecha = true;
    this.driveableData.morale = (int)(getMechaType()).morale;
  }
  
  protected void func_70014_b(NBTTagCompound tag) {
    super.func_70014_b(tag);
    tag.func_74776_a("LegsYaw", this.legAxes.getYaw());
    tag.func_74782_a("Inventory", (NBTBase)this.inventory.writeToNBT(new NBTTagCompound()));
    this.isMecha = true;
  }
  
  protected void func_70037_a(NBTTagCompound tag) {
    super.func_70037_a(tag);
    this.legAxes.setAngles(tag.func_74760_g("LegsYaw"), 0.0F, 0.0F);
    this.inventory.readFromNBT(tag.func_74775_l("Inventory"));
    this.isMecha = true;
  }
  
  public void writeSpawnData(ByteBuf data) {
    super.writeSpawnData(data);
    ByteBufUtils.writeTag(data, this.inventory.writeToNBT(new NBTTagCompound()));
    this.isMecha = true;
  }
  
  public void readSpawnData(ByteBuf data) {
    super.readSpawnData(data);
    this.legAxes.rotateGlobalYaw(this.axes.getYaw());
    this.prevLegsYaw = this.legAxes.getYaw();
    this.inventory.readFromNBT(ByteBufUtils.readTag(data));
    this.isMecha = true;
  }
  
  public void onMouseMoved(int deltaX, int deltaY) {}
  
  public boolean func_130002_c(EntityPlayer entityplayer) {
    if (this.field_70128_L)
      return false; 
    if (this.field_70170_p.field_72995_K)
      return false; 
    ItemStack currentItem = entityplayer.func_71045_bC();
    if (currentItem != null && currentItem.func_77973_b() instanceof ItemTool && ((ItemTool)currentItem.func_77973_b()).type.healDriveables)
      return true; 
    MechaType type = getMechaType();
    for (int i = 0; i <= type.numPassengers; i++) {
      if (this.seats[i].func_130002_c(entityplayer))
        return true; 
    } 
    return false;
  }
  
  public MechaType getMechaType() {
    return MechaType.getMecha(this.driveableType);
  }
  
  public boolean pressKey(int key, EntityPlayer player) {
    boolean canThrustCreatively;
    MechaType type = getMechaType();
    DriveableData data = getDriveableData();
    if (this.field_70170_p.field_72995_K && (key == 6 || key == 8 || key == 9)) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableKey(key));
      return true;
    } 
    switch (key) {
      case 0:
        return true;
      case 1:
        return true;
      case 2:
        return true;
      case 3:
        return true;
      case 4:
        canThrustCreatively = (this.seats != null && this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d);
        if (this.field_70122_E && this.jumpDelay == 0 && (canThrustCreatively || data.fuelInTank > data.engine.fuelConsumption) && isPartIntact(EnumDriveablePart.hips)) {
          this.jumpDelay = 20;
          this.field_70181_x += type.jumpVelocity;
          if (!canThrustCreatively)
            data.fuelInTank -= data.engine.fuelConsumption * 0.0F; 
        } 
        return true;
      case 5:
        return true;
      case 6:
        this.exitTimer--;
        this.exitTimer--;
        if (this.exitTimer > 20)
          (this.seats[0]).field_70153_n.func_82142_c(false); 
        return true;
      case 7:
        FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableGUI(4));
        ((EntityPlayer)(this.seats[0]).field_70153_n).openGui(FlansMod.INSTANCE, 10, this.field_70170_p, this.field_70176_ah, this.field_70162_ai, this.field_70164_aj);
        return true;
      case 8:
        return true;
      case 9:
        return true;
      case 10:
        return true;
      case 11:
        return true;
      case 12:
        return true;
      case 13:
        return true;
      case 14:
        return true;
      case 15:
        return true;
      case 16:
        return true;
      case 17:
        return true;
      case 18:
        if (type.hasFlare && this.ticksFlareUsing <= 0 && this.flareDelay <= 0) {
          this.ticksFlareUsing = type.timeFlareUsing * 20;
          this.flareDelay = type.flareDelay;
          if (this.field_70170_p.field_72995_K) {
            FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableKey(key));
          } else if (!type.flareSound.isEmpty()) {
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.flareSound, false);
          } 
          return true;
        } 
        break;
    } 
    return false;
  }
  
  private boolean useItem(boolean left) {
    // Byte code:
    //   0: iload_1
    //   1: ifeq -> 17
    //   4: aload_0
    //   5: getstatic com/flansmod/common/driveables/EnumDriveablePart.leftArm : Lcom/flansmod/common/driveables/EnumDriveablePart;
    //   8: invokevirtual isPartIntact : (Lcom/flansmod/common/driveables/EnumDriveablePart;)Z
    //   11: ifeq -> 878
    //   14: goto -> 27
    //   17: aload_0
    //   18: getstatic com/flansmod/common/driveables/EnumDriveablePart.rightArm : Lcom/flansmod/common/driveables/EnumDriveablePart;
    //   21: invokevirtual isPartIntact : (Lcom/flansmod/common/driveables/EnumDriveablePart;)Z
    //   24: ifeq -> 878
    //   27: aload_0
    //   28: getfield seats : [Lcom/flansmod/common/driveables/EntitySeat;
    //   31: iconst_0
    //   32: aaload
    //   33: getfield field_70153_n : Lnet/minecraft/entity/Entity;
    //   36: instanceof net/minecraft/entity/player/EntityPlayer
    //   39: ifeq -> 63
    //   42: aload_0
    //   43: getfield seats : [Lcom/flansmod/common/driveables/EntitySeat;
    //   46: iconst_0
    //   47: aaload
    //   48: getfield field_70153_n : Lnet/minecraft/entity/Entity;
    //   51: checkcast net/minecraft/entity/player/EntityPlayer
    //   54: getfield field_71075_bZ : Lnet/minecraft/entity/player/PlayerCapabilities;
    //   57: getfield field_75098_d : Z
    //   60: ifeq -> 67
    //   63: iconst_1
    //   64: goto -> 68
    //   67: iconst_0
    //   68: istore_2
    //   69: iload_1
    //   70: ifeq -> 86
    //   73: aload_0
    //   74: getfield inventory : Lcom/flansmod/common/driveables/mechas/MechaInventory;
    //   77: getstatic com/flansmod/common/driveables/mechas/EnumMechaSlotType.leftTool : Lcom/flansmod/common/driveables/mechas/EnumMechaSlotType;
    //   80: invokevirtual getStackInSlot : (Lcom/flansmod/common/driveables/mechas/EnumMechaSlotType;)Lnet/minecraft/item/ItemStack;
    //   83: goto -> 96
    //   86: aload_0
    //   87: getfield inventory : Lcom/flansmod/common/driveables/mechas/MechaInventory;
    //   90: getstatic com/flansmod/common/driveables/mechas/EnumMechaSlotType.rightTool : Lcom/flansmod/common/driveables/mechas/EnumMechaSlotType;
    //   93: invokevirtual getStackInSlot : (Lcom/flansmod/common/driveables/mechas/EnumMechaSlotType;)Lnet/minecraft/item/ItemStack;
    //   96: astore_3
    //   97: aload_3
    //   98: ifnonnull -> 103
    //   101: iconst_0
    //   102: ireturn
    //   103: aload_3
    //   104: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   107: astore #4
    //   109: aload_0
    //   110: invokevirtual getMechaType : ()Lcom/flansmod/common/driveables/mechas/MechaType;
    //   113: astore #5
    //   115: aload #4
    //   117: instanceof com/flansmod/common/driveables/mechas/ItemMechaAddon
    //   120: ifeq -> 442
    //   123: aload #4
    //   125: checkcast com/flansmod/common/driveables/mechas/ItemMechaAddon
    //   128: getfield type : Lcom/flansmod/common/driveables/mechas/MechaItemType;
    //   131: astore #6
    //   133: aload #6
    //   135: getfield reach : F
    //   138: aload #5
    //   140: getfield reach : F
    //   143: fmul
    //   144: fstore #7
    //   146: new com/flansmod/common/vector/Vector3f
    //   149: dup
    //   150: aload #5
    //   152: getfield seats : [Lcom/flansmod/common/driveables/Seat;
    //   155: iconst_0
    //   156: aaload
    //   157: getfield x : I
    //   160: i2f
    //   161: ldc_w 16.0
    //   164: fdiv
    //   165: f2d
    //   166: aload #5
    //   168: getfield seats : [Lcom/flansmod/common/driveables/Seat;
    //   171: iconst_0
    //   172: aaload
    //   173: getfield y : I
    //   176: i2f
    //   177: ldc_w 16.0
    //   180: fdiv
    //   181: f2d
    //   182: aload_0
    //   183: getfield seats : [Lcom/flansmod/common/driveables/EntitySeat;
    //   186: iconst_0
    //   187: aaload
    //   188: getfield field_70153_n : Lnet/minecraft/entity/Entity;
    //   191: invokevirtual func_70042_X : ()D
    //   194: dadd
    //   195: aload #5
    //   197: getfield seats : [Lcom/flansmod/common/driveables/Seat;
    //   200: iconst_0
    //   201: aaload
    //   202: getfield z : I
    //   205: i2f
    //   206: ldc_w 16.0
    //   209: fdiv
    //   210: f2d
    //   211: invokespecial <init> : (DDD)V
    //   214: astore #8
    //   216: aload_0
    //   217: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   220: aload #8
    //   222: invokevirtual findLocalVectorGlobally : (Lcom/flansmod/common/vector/Vector3f;)Lcom/flansmod/common/vector/Vector3f;
    //   225: astore #8
    //   227: aload #8
    //   229: new com/flansmod/common/vector/Vector3f
    //   232: dup
    //   233: aload_0
    //   234: getfield field_70165_t : D
    //   237: aload_0
    //   238: getfield field_70163_u : D
    //   241: aload_0
    //   242: getfield field_70161_v : D
    //   245: invokespecial <init> : (DDD)V
    //   248: aload #8
    //   250: invokestatic add : (Lcom/flansmod/common/vector/Vector3f;Lcom/flansmod/common/vector/Vector3f;Lcom/flansmod/common/vector/Vector3f;)Lcom/flansmod/common/vector/Vector3f;
    //   253: pop
    //   254: aload_0
    //   255: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   258: aload_0
    //   259: getfield seats : [Lcom/flansmod/common/driveables/EntitySeat;
    //   262: iconst_0
    //   263: aaload
    //   264: getfield looking : Lcom/flansmod/common/RotatedAxes;
    //   267: new com/flansmod/common/vector/Vector3f
    //   270: dup
    //   271: fload #7
    //   273: fconst_0
    //   274: fconst_0
    //   275: invokespecial <init> : (FFF)V
    //   278: invokevirtual findLocalVectorGlobally : (Lcom/flansmod/common/vector/Vector3f;)Lcom/flansmod/common/vector/Vector3f;
    //   281: invokevirtual findLocalVectorGlobally : (Lcom/flansmod/common/vector/Vector3f;)Lcom/flansmod/common/vector/Vector3f;
    //   284: astore #9
    //   286: aload_0
    //   287: getfield field_70170_p : Lnet/minecraft/world/World;
    //   290: new com/flansmod/client/debug/EntityDebugVector
    //   293: dup
    //   294: aload_0
    //   295: getfield field_70170_p : Lnet/minecraft/world/World;
    //   298: aload #8
    //   300: aload #9
    //   302: bipush #20
    //   304: invokespecial <init> : (Lnet/minecraft/world/World;Lcom/flansmod/common/vector/Vector3f;Lcom/flansmod/common/vector/Vector3f;I)V
    //   307: invokevirtual func_72838_d : (Lnet/minecraft/entity/Entity;)Z
    //   310: pop
    //   311: aload #9
    //   313: aload #8
    //   315: aconst_null
    //   316: invokestatic add : (Lcom/flansmod/common/vector/Vector3f;Lcom/flansmod/common/vector/Vector3f;Lcom/flansmod/common/vector/Vector3f;)Lcom/flansmod/common/vector/Vector3f;
    //   319: astore #10
    //   321: aload_0
    //   322: getfield field_70170_p : Lnet/minecraft/world/World;
    //   325: aload #8
    //   327: invokevirtual toVec3 : ()Lnet/minecraft/util/Vec3;
    //   330: aload #10
    //   332: invokevirtual toVec3 : ()Lnet/minecraft/util/Vec3;
    //   335: invokevirtual func_72933_a : (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
    //   338: astore #11
    //   340: aload #11
    //   342: ifnull -> 439
    //   345: aload #11
    //   347: getfield field_72313_a : Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
    //   350: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK : Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
    //   353: if_acmpne -> 439
    //   356: aload_0
    //   357: getfield breakingBlock : Lcom/flansmod/common/vector/Vector3i;
    //   360: ifnull -> 408
    //   363: aload_0
    //   364: getfield breakingBlock : Lcom/flansmod/common/vector/Vector3i;
    //   367: getfield x : I
    //   370: aload #11
    //   372: getfield field_72311_b : I
    //   375: if_icmpne -> 408
    //   378: aload_0
    //   379: getfield breakingBlock : Lcom/flansmod/common/vector/Vector3i;
    //   382: getfield y : I
    //   385: aload #11
    //   387: getfield field_72312_c : I
    //   390: if_icmpne -> 408
    //   393: aload_0
    //   394: getfield breakingBlock : Lcom/flansmod/common/vector/Vector3i;
    //   397: getfield z : I
    //   400: aload #11
    //   402: getfield field_72309_d : I
    //   405: if_icmpeq -> 413
    //   408: aload_0
    //   409: fconst_0
    //   410: putfield breakingProgress : F
    //   413: aload_0
    //   414: new com/flansmod/common/vector/Vector3i
    //   417: dup
    //   418: aload #11
    //   420: getfield field_72311_b : I
    //   423: aload #11
    //   425: getfield field_72312_c : I
    //   428: aload #11
    //   430: getfield field_72309_d : I
    //   433: invokespecial <init> : (III)V
    //   436: putfield breakingBlock : Lcom/flansmod/common/vector/Vector3i;
    //   439: goto -> 878
    //   442: aload #4
    //   444: instanceof com/flansmod/common/guns/ItemGun
    //   447: ifeq -> 878
    //   450: aload #4
    //   452: checkcast com/flansmod/common/guns/ItemGun
    //   455: astore #6
    //   457: aload #6
    //   459: getfield type : Lcom/flansmod/common/guns/GunType;
    //   462: astore #7
    //   464: aload_3
    //   465: getfield field_77990_d : Lnet/minecraft/nbt/NBTTagCompound;
    //   468: ldc_w 'secondaryAmmo'
    //   471: invokevirtual func_74764_b : (Ljava/lang/String;)Z
    //   474: ifeq -> 493
    //   477: aload #7
    //   479: aload_3
    //   480: invokevirtual getSecondaryFire : (Lnet/minecraft/item/ItemStack;)Z
    //   483: ifeq -> 493
    //   486: aload #7
    //   488: aload_3
    //   489: iconst_0
    //   490: invokevirtual setSecondaryFire : (Lnet/minecraft/item/ItemStack;Z)V
    //   493: iload_1
    //   494: ifeq -> 504
    //   497: aload_0
    //   498: getfield shootDelayLeft : I
    //   501: goto -> 508
    //   504: aload_0
    //   505: getfield shootDelayRight : I
    //   508: istore #8
    //   510: iload #8
    //   512: ifgt -> 878
    //   515: aload #5
    //   517: aload #7
    //   519: invokevirtual isValidGun : (Lcom/flansmod/common/guns/GunType;)Z
    //   522: ifeq -> 878
    //   525: iconst_0
    //   526: istore #9
    //   528: aconst_null
    //   529: astore #10
    //   531: iload #9
    //   533: aload #7
    //   535: aload_3
    //   536: invokevirtual getNumAmmoItemsInGun : (Lnet/minecraft/item/ItemStack;)I
    //   539: if_icmpge -> 591
    //   542: aload #6
    //   544: aload_3
    //   545: iload #9
    //   547: invokevirtual getBulletItemStack : (Lnet/minecraft/item/ItemStack;I)Lnet/minecraft/item/ItemStack;
    //   550: astore #11
    //   552: aload #11
    //   554: ifnull -> 585
    //   557: aload #11
    //   559: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   562: ifnull -> 585
    //   565: aload #11
    //   567: invokevirtual func_77960_j : ()I
    //   570: aload #11
    //   572: invokevirtual func_77958_k : ()I
    //   575: if_icmpge -> 585
    //   578: aload #11
    //   580: astore #10
    //   582: goto -> 591
    //   585: iinc #9, 1
    //   588: goto -> 531
    //   591: aload #10
    //   593: ifnonnull -> 642
    //   596: aload #7
    //   598: getfield shootMelee : Z
    //   601: ifne -> 878
    //   604: aload #6
    //   606: aload_3
    //   607: aload #7
    //   609: aload_0
    //   610: getfield field_70170_p : Lnet/minecraft/world/World;
    //   613: aload_0
    //   614: aload_0
    //   615: getfield driveableData : Lcom/flansmod/common/driveables/DriveableData;
    //   618: aload_0
    //   619: invokevirtual infiniteAmmo : ()Z
    //   622: ifne -> 629
    //   625: iload_2
    //   626: ifeq -> 633
    //   629: iconst_1
    //   630: goto -> 634
    //   633: iconst_0
    //   634: iconst_0
    //   635: invokevirtual reload : (Lnet/minecraft/item/ItemStack;Lcom/flansmod/common/guns/GunType;Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;Lnet/minecraft/inventory/IInventory;ZZ)Z
    //   638: pop
    //   639: goto -> 878
    //   642: aload #10
    //   644: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   647: instanceof com/flansmod/common/guns/ItemBullet
    //   650: ifeq -> 878
    //   653: aload #10
    //   655: ifnull -> 878
    //   658: aload_0
    //   659: aload_3
    //   660: aload #7
    //   662: aload #10
    //   664: iload_2
    //   665: iload_1
    //   666: invokespecial shoot : (Lnet/minecraft/item/ItemStack;Lcom/flansmod/common/guns/GunType;Lnet/minecraft/item/ItemStack;ZZ)V
    //   669: aload_0
    //   670: getfield field_70170_p : Lnet/minecraft/world/World;
    //   673: getfield field_72995_K : Z
    //   676: ifeq -> 856
    //   679: aload #7
    //   681: getfield model : Lcom/flansmod/client/model/ModelGun;
    //   684: ifnonnull -> 691
    //   687: iconst_0
    //   688: goto -> 699
    //   691: aload #7
    //   693: getfield model : Lcom/flansmod/client/model/ModelGun;
    //   696: getfield pumpDelay : I
    //   699: istore #11
    //   701: aload #7
    //   703: getfield model : Lcom/flansmod/client/model/ModelGun;
    //   706: ifnonnull -> 713
    //   709: iconst_1
    //   710: goto -> 721
    //   713: aload #7
    //   715: getfield model : Lcom/flansmod/client/model/ModelGun;
    //   718: getfield pumpTime : I
    //   721: istore #12
    //   723: aload #7
    //   725: getfield model : Lcom/flansmod/client/model/ModelGun;
    //   728: ifnonnull -> 735
    //   731: iconst_0
    //   732: goto -> 743
    //   735: aload #7
    //   737: getfield model : Lcom/flansmod/client/model/ModelGun;
    //   740: getfield hammerDelay : I
    //   743: istore #13
    //   745: aload #7
    //   747: getfield model : Lcom/flansmod/client/model/ModelGun;
    //   750: ifnonnull -> 757
    //   753: iconst_0
    //   754: goto -> 765
    //   757: aload #7
    //   759: getfield model : Lcom/flansmod/client/model/ModelGun;
    //   762: getfield casingDelay : I
    //   765: istore #14
    //   767: aload #7
    //   769: getfield model : Lcom/flansmod/client/model/ModelGun;
    //   772: ifnonnull -> 779
    //   775: fconst_0
    //   776: goto -> 787
    //   779: aload #7
    //   781: getfield model : Lcom/flansmod/client/model/ModelGun;
    //   784: getfield hammerAngle : F
    //   787: fstore #15
    //   789: aload #7
    //   791: getfield model : Lcom/flansmod/client/model/ModelGun;
    //   794: ifnonnull -> 801
    //   797: fconst_0
    //   798: goto -> 809
    //   801: aload #7
    //   803: getfield model : Lcom/flansmod/client/model/ModelGun;
    //   806: getfield althammerAngle : F
    //   809: fstore #16
    //   811: iload_1
    //   812: ifeq -> 837
    //   815: aload_0
    //   816: getfield leftAnimations : Lcom/flansmod/client/model/GunAnimations;
    //   819: iload #11
    //   821: iload #12
    //   823: iload #13
    //   825: fload #15
    //   827: fload #16
    //   829: iload #14
    //   831: invokevirtual doShoot : (IIIFFI)V
    //   834: goto -> 856
    //   837: aload_0
    //   838: getfield rightAnimations : Lcom/flansmod/client/model/GunAnimations;
    //   841: iload #11
    //   843: iload #12
    //   845: iload #13
    //   847: fload #15
    //   849: fload #16
    //   851: iload #14
    //   853: invokevirtual doShoot : (IIIFFI)V
    //   856: aload #10
    //   858: aload #10
    //   860: invokevirtual func_77960_j : ()I
    //   863: iconst_1
    //   864: iadd
    //   865: invokevirtual func_77964_b : (I)V
    //   868: aload #6
    //   870: aload_3
    //   871: aload #10
    //   873: iload #9
    //   875: invokevirtual setBulletItemStack : (Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;I)V
    //   878: iconst_1
    //   879: ireturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #403	-> 0
    //   #405	-> 27
    //   #406	-> 69
    //   #407	-> 97
    //   #408	-> 101
    //   #410	-> 103
    //   #412	-> 109
    //   #414	-> 115
    //   #416	-> 123
    //   #418	-> 133
    //   #420	-> 146
    //   #421	-> 216
    //   #422	-> 227
    //   #424	-> 254
    //   #426	-> 286
    //   #428	-> 311
    //   #430	-> 321
    //   #433	-> 340
    //   #435	-> 356
    //   #436	-> 408
    //   #437	-> 413
    //   #439	-> 439
    //   #441	-> 442
    //   #443	-> 450
    //   #444	-> 457
    //   #447	-> 464
    //   #448	-> 477
    //   #449	-> 486
    //   #452	-> 493
    //   #455	-> 510
    //   #458	-> 525
    //   #459	-> 528
    //   #460	-> 531
    //   #462	-> 542
    //   #463	-> 552
    //   #465	-> 578
    //   #466	-> 582
    //   #460	-> 585
    //   #471	-> 591
    //   #473	-> 596
    //   #474	-> 604
    //   #477	-> 642
    //   #480	-> 658
    //   #484	-> 669
    //   #486	-> 679
    //   #487	-> 701
    //   #488	-> 723
    //   #489	-> 745
    //   #490	-> 767
    //   #491	-> 789
    //   #493	-> 811
    //   #495	-> 815
    //   #499	-> 837
    //   #503	-> 856
    //   #506	-> 868
    //   #511	-> 878
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   133	306	6	toolType	Lcom/flansmod/common/driveables/mechas/MechaItemType;
    //   146	293	7	reach	F
    //   216	223	8	lookOrigin	Lcom/flansmod/common/vector/Vector3f;
    //   286	153	9	lookVector	Lcom/flansmod/common/vector/Vector3f;
    //   321	118	10	lookTarget	Lcom/flansmod/common/vector/Vector3f;
    //   340	99	11	hit	Lnet/minecraft/util/MovingObjectPosition;
    //   552	33	11	checkingStack	Lnet/minecraft/item/ItemStack;
    //   701	155	11	pumpDelay	I
    //   723	133	12	pumpTime	I
    //   745	111	13	hammerDelay	I
    //   767	89	14	casingDelay	I
    //   789	67	15	hammerAngle	F
    //   811	45	16	althammerAngle	F
    //   528	350	9	bulletID	I
    //   531	347	10	bulletStack	Lnet/minecraft/item/ItemStack;
    //   457	421	6	gunItem	Lcom/flansmod/common/guns/ItemGun;
    //   464	414	7	gunType	Lcom/flansmod/common/guns/GunType;
    //   510	368	8	delay	I
    //   69	809	2	creative	Z
    //   97	781	3	heldStack	Lnet/minecraft/item/ItemStack;
    //   109	769	4	heldItem	Lnet/minecraft/item/Item;
    //   115	763	5	mechaType	Lcom/flansmod/common/driveables/mechas/MechaType;
    //   0	880	0	this	Lcom/flansmod/common/driveables/mechas/EntityMecha;
    //   0	880	1	left	Z
  }
  
  private void shoot(ItemStack stack, GunType gunType, ItemStack bulletStack, boolean creative, boolean left) {
    MechaType mechaType = getMechaType();
    BulletType bulletType = ((ItemBullet)bulletStack.func_77973_b()).type;
    RotatedAxes a = new RotatedAxes();
    Vector3f armVector = new Vector3f(mechaType.armLength, 0.0F, 0.0F);
    Vector3f gunVector = new Vector3f(mechaType.armLength + 1.2F * mechaType.heldItemScale, 0.5F * mechaType.heldItemScale, 0.0F);
    Vector3f armOrigin = left ? mechaType.leftArmOrigin : mechaType.rightArmOrigin;
    a.rotateGlobalYaw(this.axes.getYaw());
    armOrigin = a.findLocalVectorGlobally(armOrigin);
    a.rotateLocalPitch(-(this.seats[0]).looking.getPitch());
    gunVector = a.findLocalVectorGlobally(gunVector);
    armVector = a.findLocalVectorGlobally(armVector);
    Vector3f bulletOrigin = Vector3f.add(armOrigin, gunVector, null);
    bulletOrigin = Vector3f.add(new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v), bulletOrigin, null);
    if (!this.field_70170_p.field_72995_K)
      for (int k = 0; k < gunType.numBullets; k++)
        this.field_70170_p.func_72838_d((Entity)((ItemBullet)bulletStack.func_77973_b()).getEntity(this.field_70170_p, bulletOrigin, armVector, (EntityLivingBase)(this.seats[0]).field_70153_n, gunType.getSpread(stack, false, false) / 2.0F, gunType.getDamage(stack), gunType.getBulletSpeed(stack), bulletStack.func_77960_j(), (InfoType)mechaType));  
    if (left) {
      this.shootDelayLeft = (gunType.mode == EnumFireMode.SEMIAUTO) ? (int)Math.max(gunType.shootDelay, 5.0F) : (int)gunType.shootDelay;
    } else {
      this.shootDelayRight = (gunType.mode == EnumFireMode.SEMIAUTO) ? (int)Math.max(gunType.shootDelay, 5.0F) : (int)gunType.shootDelay;
    } 
    if (bulletType.dropItemOnShoot != null && !creative)
      ItemGun.dropItem(this.field_70170_p, (Entity)this, bulletType.dropItemOnShoot); 
    if ((left ? this.soundDelayLeft : this.soundDelayRight) <= 0 && gunType.shootSound != null) {
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, gunType.shootSound, gunType.distortSound);
      if (left) {
        this.soundDelayLeft = gunType.shootSoundLength;
      } else {
        this.soundDelayRight = gunType.shootSoundLength;
      } 
    } 
  }
  
  private boolean driverIsCreative() {
    return (this.seats != null && this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d);
  }
  
  protected void func_70069_a(float f) {
    func_70097_a(DamageSource.field_76379_h, f);
  }
  
  public void setLegAngles(float LLU, float pLLU, float RLU, float pRLU, float LLL, float pLLL, float RLL, float pRLL, float LLF, float pLLF, float RLF, float pRLF) {
    this.leftLegUpperAngle = LLU;
    this.leftLegLowerAngle = LLL;
    this.leftFootAngle = LLF;
    this.rightLegUpperAngle = RLU;
    this.rightLegLowerAngle = RLL;
    this.rightFootAngle = RLF;
    this.prevLeftLegUpperAngle = pLLU;
    this.prevLeftLegLowerAngle = pLLL;
    this.prevLeftFootAngle = pLLF;
    this.prevRightLegUpperAngle = pRLU;
    this.prevRightLegLowerAngle = pRLL;
    this.prevRightFootAngle = pRLF;
  }
  
  public boolean func_70097_a(DamageSource damagesource, float i) {
    MechaType type = getMechaType();
    if (this.field_70170_p.field_72995_K || this.field_70128_L || damagesource.field_76373_n.equals("arrow") || (!type.vanillaDamage && damagesource.field_76373_n.equals("player") && this.seats[0] != null && (this.seats[0]).field_70153_n != null))
      return true; 
    if (damagesource.func_76355_l().equals("fall")) {
      byte wouldBeNegativeDamage;
      boolean takeFallDamage = (type.takeFallDamage && !stopFallDamage());
      boolean damageBlocksFromFalling = (type.damageBlocksFromFalling || breakBlocksUponFalling());
      if (i * type.fallDamageMultiplier * vulnerability() - 2.0F < 0.0F) {
        wouldBeNegativeDamage = 0;
      } else {
        wouldBeNegativeDamage = 1;
      } 
      float damageToInflict = takeFallDamage ? (i * type.fallDamageMultiplier * vulnerability() * wouldBeNegativeDamage) : 0.0F;
      float blockDamageFromFalling = damageBlocksFromFalling ? (i * type.blockDamageFromFalling / 10.0F) : 0.0F;
      ((DriveablePart)this.driveableData.parts.get(EnumDriveablePart.hips)).attack(damageToInflict, false);
      checkParts();
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketDriveableDamage(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, FlansMod.driveableUpdateRange, this.field_71093_bK);
      if (blockDamageFromFalling > 1.0F)
        this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, blockDamageFromFalling, TeamsManager.explosions); 
    } else if (damagesource.field_76373_n.equals("player") && (damagesource.func_76346_g()).field_70122_E && (this.seats[0] == null || (this.seats[0]).field_70153_n == null) && !this.locked && !type.unpunchable) {
      ItemStack mechaStack = new ItemStack(type.item, 1, this.driveableData.paintjobID);
      mechaStack.field_77990_d = new NBTTagCompound();
      this.driveableData.writeToNBT(mechaStack.field_77990_d);
      this.inventory.writeToNBT(mechaStack.field_77990_d);
      func_70099_a(mechaStack, 0.5F);
      func_70106_y();
    } else {
      ((DriveablePart)this.driveableData.parts.get(EnumDriveablePart.core)).attack(i * vulnerability(), damagesource.func_76347_k());
    } 
    return true;
  }
  
  public void func_70071_h_() {
    super.func_70071_h_();
    if (this.driveableData.panicTimer > 0) {
      Random rand = new Random();
      this.moveZ = 2.0F * (rand.nextInt(3) - 1.0F);
      this.moveX = (5 + 2 * rand.nextInt(2));
      this.throttle = 2.0F;
    } 
    if (this.poopooThrottle > 0.0F)
      this.poopooThrottle -= 0.05F; 
    if (this.poopooThrottle > 0.3D)
      this.poopooThrottle *= 0.98F; 
    if (this.poopooThrottle > 1.5D)
      this.poopooThrottle = 1.5F; 
    if (this.poopooThrottle < 0.0F)
      this.poopooThrottle = 0.0F; 
    if (this.driveableData.panicTimer <= 0) {
      this.moveX = 0.0F;
      this.moveZ = 0.0F;
    } 
    if (this.second < 20.0F)
      this.second++; 
    if (this.second >= 20.0F)
      this.second = 0.0F; 
    if (this.fivesec >= 5.0F)
      this.fivesec = 0.0F; 
    if (this.second == 2.0F) {
      if (this.driveableData.panicTimer > 0) {
        this.driveableData.panicTimer -= 2;
        this.driveableData.morale = 1;
      } 
      if (this.driveableData.morale < (getMechaType()).morale)
        this.driveableData.morale++; 
      this.lastHealth = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).health;
    } 
    if (this.second == 19.0F) {
      if (this.fivesec < 5.0F)
        this.fivesec++; 
      if (this.driveableData.morale <= 0 && this.driveableData.panicTimer <= 0) {
        this.driveableData.panicTimer = (getMechaType()).panicTime;
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, (getMechaType()).panicSound, false);
      } 
      if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).health < this.lastHealth && (getDriveableType()).panic) {
        int cringeDamage = this.lastHealth - ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).health;
        if (this.driveableData.morale > 0)
          this.driveableData.morale -= cringeDamage; 
        if (this.driveableData.panicTimer > 0)
          this.driveableData.panicTimer = (int)(this.driveableData.panicTimer + cringeDamage * 0.25D); 
      } 
    } 
    if (this.fivesec == 3.0F && this.second == 17.0F)
      if (this.driveableData.panicTimer > 0)
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, "elephantAttack", false);  
    if (this.exitTimer < (getDriveableType()).exitTimer)
      this.exitTimer++; 
    if (this.exitTimer < 0) {
      (this.seats[0]).field_70153_n.func_70078_a(null);
      this.exitTimer = (getDriveableType()).exitTimer;
    } 
    boolean legDir = true;
    if (this.legPosition > 1.0F)
      this.legPosition = 0.0F; 
    this.prevLeftLegUpperAngle = this.leftLegUpperAngle;
    this.prevLeftLegLowerAngle = this.leftLegLowerAngle;
    this.prevLeftFootAngle = this.leftFootAngle;
    this.prevRightLegUpperAngle = this.rightLegUpperAngle;
    this.prevRightLegLowerAngle = this.rightLegLowerAngle;
    this.prevRightFootAngle = this.rightFootAngle;
    if (this.field_70170_p.field_72995_K && (this.varFlare || this.ticksFlareUsing > 0))
      this.throttle = 2.0F; 
    if (this.field_70170_p.field_72995_K && (this.varFlare || this.ticksFlareUsing <= 0))
      this.throttle = 0.0F; 
    if (this.ticksFlareUsing > 0) {
      this.ticksFlareUsing--;
      if ((getDriveableType()).needsThrottle == true)
        this.throttle = (this.ticksFlareUsing * this.ticksFlareUsing * this.ticksFlareUsing) * 1.25E-4F - 0.1F; 
    } 
    if (this.flareDelay > 0)
      this.flareDelay--; 
    for (MechaType.LegNode node : (getMechaType()).legNodes) {
      if (this.legPosition >= node.lowerBound && this.legPosition <= node.upperBound) {
        if (node.legPart == 1) {
          this.targetLeftUpper = node.rotation;
          this.targetLeftUpperSpeed = node.speed;
          continue;
        } 
        if (node.legPart == 2) {
          this.targetLeftLower = node.rotation;
          this.targetLeftLowerSpeed = node.speed;
          continue;
        } 
        if (node.legPart == 3) {
          this.targetLeftFoot = node.rotation;
          this.targetLeftFootSpeed = node.speed;
          continue;
        } 
        if (node.legPart == 4) {
          this.targetRightUpper = node.rotation;
          this.targetRightUpperSpeed = node.speed;
          continue;
        } 
        if (node.legPart == 5) {
          this.targetRightLower = node.rotation;
          this.targetRightLowerSpeed = node.speed;
          continue;
        } 
        if (node.legPart == 6) {
          this.targetRightFoot = node.rotation;
          this.targetRightFootSpeed = node.speed;
        } 
      } 
    } 
    if (this.leftLegUpperAngle < this.targetLeftUpper) {
      this.leftLegUpperAngle += this.targetLeftUpperSpeed;
    } else if (this.leftLegUpperAngle > this.targetLeftUpper) {
      this.leftLegUpperAngle -= this.targetLeftUpperSpeed;
    } 
    if ((float)Math.sqrt(((this.leftLegUpperAngle - this.targetLeftUpper) * (this.leftLegUpperAngle - this.targetLeftUpper))) <= (this.targetLeftUpperSpeed / 2))
      this.leftLegUpperAngle = this.targetLeftUpper; 
    if (this.rightLegUpperAngle < this.targetRightUpper) {
      this.rightLegUpperAngle += this.targetRightUpperSpeed;
    } else if (this.rightLegUpperAngle > this.targetRightUpper) {
      this.rightLegUpperAngle -= this.targetRightUpperSpeed;
    } 
    if ((float)Math.sqrt(((this.rightLegUpperAngle - this.targetRightUpper) * (this.rightLegUpperAngle - this.targetRightUpper))) <= (this.targetRightUpperSpeed / 2))
      this.rightLegUpperAngle = this.targetRightUpper; 
    if (this.leftLegLowerAngle < this.targetLeftLower) {
      this.leftLegLowerAngle += this.targetLeftLowerSpeed;
    } else if (this.leftLegLowerAngle > this.targetLeftLower) {
      this.leftLegLowerAngle -= this.targetRightLowerSpeed;
    } 
    if (this.rightLegLowerAngle < this.targetRightLower) {
      this.rightLegLowerAngle += this.targetRightLowerSpeed;
    } else if (this.rightLegLowerAngle > this.targetRightLower) {
      this.rightLegLowerAngle -= this.targetRightLowerSpeed;
    } 
    if ((float)Math.sqrt(((this.leftLegLowerAngle - this.targetLeftLower) * (this.leftLegLowerAngle - this.targetLeftLower))) <= (this.targetLeftLowerSpeed / 2))
      this.leftLegLowerAngle = this.targetLeftLower; 
    if ((float)Math.sqrt(((this.rightLegLowerAngle - this.targetRightLower) * (this.rightLegLowerAngle - this.targetRightLower))) <= (this.targetRightLowerSpeed / 2))
      this.rightLegLowerAngle = this.targetRightLower; 
    if (this.leftFootAngle < this.targetLeftFoot) {
      this.leftFootAngle += this.targetLeftFootSpeed;
    } else if (this.leftFootAngle > this.targetLeftFoot) {
      this.leftFootAngle -= this.targetLeftFootSpeed;
    } 
    if (this.rightFootAngle < this.targetRightFoot) {
      this.rightFootAngle += this.targetRightFootSpeed;
    } else if (this.rightFootAngle > this.targetRightFoot) {
      this.rightFootAngle -= this.targetRightFootSpeed;
    } 
    if ((float)Math.sqrt(((this.rightFootAngle - this.targetRightFoot) * (this.rightFootAngle - this.targetRightFoot))) <= (this.targetRightFootSpeed / 2))
      this.rightFootAngle = this.targetRightFoot; 
    if ((float)Math.sqrt(((this.leftFootAngle - this.targetLeftFoot) * (this.leftFootAngle - this.targetLeftFoot))) <= (this.targetLeftFootSpeed / 2))
      this.leftFootAngle = this.targetLeftFoot; 
    if (this.jumpDelay > 0)
      this.jumpDelay--; 
    if (this.shootDelayLeft > 0)
      this.shootDelayLeft--; 
    if (this.shootDelayRight > 0)
      this.shootDelayRight--; 
    if (this.soundDelayLeft > 0)
      this.soundDelayLeft--; 
    if (this.soundDelayRight > 0)
      this.soundDelayRight--; 
    if (!this.field_70170_p.field_72995_K && (this.seats[0] == null || (this.seats[0]).field_70153_n == null))
      this.rightMouseHeld = this.leftMouseHeld = false; 
    this.leftAnimations.update();
    this.rightAnimations.update();
    MechaType type = getMechaType();
    DriveableData data = getDriveableData();
    if (type == null) {
      FlansMod.log("Mecha type null. Not ticking mecha");
      return;
    } 
    if (this.stompDelay > 0)
      this.stompDelay--; 
    this.prevLegsYaw = this.legAxes.getYaw();
    if (this.toggleTimer == 0 && autoRepair()) {
      for (EnumDriveablePart part : EnumDriveablePart.values()) {
        DriveablePart thisPart = (DriveablePart)data.parts.get(part);
        boolean hasCreativePlayer = (this.seats != null && this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d);
        if (thisPart != null && thisPart.health != 0 && thisPart.health < thisPart.maxHealth && (hasCreativePlayer || data.fuelInTank >= 10.0F)) {
          thisPart.health++;
          if (!hasCreativePlayer)
            data.fuelInTank -= 10.0F; 
        } 
      } 
      this.toggleTimer = 20;
    } 
    if (diamondDetect() != null && this.diamondTimer == 0 && this.field_70170_p.field_72995_K && this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)(this.seats[0]).field_70153_n)) {
      float sqDistance = 901.0F;
      float i;
      for (i = -30.0F; i <= 30.0F; i++) {
        float j;
        for (j = -30.0F; j <= 30.0F; j++) {
          float k;
          for (k = -30.0F; k <= 30.0F; k++) {
            int x = MathHelper.func_76128_c(i + this.field_70165_t);
            int y = MathHelper.func_76128_c(j + this.field_70163_u);
            int z = MathHelper.func_76128_c(k + this.field_70161_v);
            if (i * i + j * j + k * k < sqDistance && this.field_70170_p.func_147439_a(x, y, z) == Blocks.field_150482_ag)
              sqDistance = i * i + j * j + k * k; 
          } 
        } 
      } 
      if (sqDistance < 901.0F) {
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, (diamondDetect()).detectSound, false);
        this.diamondTimer = 1 + 2 * MathHelper.func_76141_d(MathHelper.func_76129_c(sqDistance));
      } 
    } 
    if (this.diamondTimer > 0)
      this.diamondTimer--; 
    if (isPartIntact(EnumDriveablePart.hips)) {
      func_70105_a(type.width, type.height);
      this.field_70129_M = type.yOffset;
    } else {
      func_70105_a(type.width, type.height - type.chassisHeight);
      this.field_70129_M = type.yOffset - type.chassisHeight;
    } 
    boolean thePlayerIsDrivingThis = (this.field_70170_p.field_72995_K && this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)(this.seats[0]).field_70153_n));
    boolean driverIsLiving = (this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityLivingBase);
    this.ticksSinceUsed++;
    if (!this.field_70170_p.field_72995_K && (this.seats[0]).field_70153_n != null)
      this.ticksSinceUsed = 0; 
    if (!this.field_70170_p.field_72995_K && TeamsManager.mechaLove > 0 && this.ticksSinceUsed > TeamsManager.mechaLove * 20)
      func_70106_y(); 
    if (this.toggleTimer > 0)
      this.toggleTimer--; 
    if (this.field_70170_p.field_72995_K && !thePlayerIsDrivingThis)
      if (this.serverPositionTransitionTicker > 0) {
        double x = this.field_70165_t + (this.field_70118_ct - this.field_70165_t) / this.serverPositionTransitionTicker;
        double y = this.field_70163_u + (this.field_70117_cu - this.field_70163_u) / this.serverPositionTransitionTicker;
        double z = this.field_70161_v + (this.field_70116_cv - this.field_70161_v) / this.serverPositionTransitionTicker;
        double dYaw = MathHelper.func_76138_g(this.serverYaw - this.axes.getYaw());
        double dPitch = MathHelper.func_76138_g(this.serverPitch - this.axes.getPitch());
        double dRoll = MathHelper.func_76138_g(this.serverRoll - this.axes.getRoll());
        this.field_70177_z = (float)(this.axes.getYaw() + dYaw / this.serverPositionTransitionTicker);
        this.field_70125_A = (float)(this.axes.getPitch() + dPitch / this.serverPositionTransitionTicker);
        float rotationRoll = (float)(this.axes.getRoll() + dRoll / this.serverPositionTransitionTicker);
        this.serverPositionTransitionTicker--;
        func_70107_b(x, y, z);
        setRotation(this.field_70177_z, this.field_70125_A, rotationRoll);
      }  
    if (this.seats[0] != null && this.driveableData.panicTimer <= 0)
      if ((this.seats[0]).field_70153_n instanceof EntityLivingBase && !((this.seats[0]).field_70153_n instanceof EntityPlayer) && this.driveableData.panicTimer <= 0) {
        this.axes.setAngles(((EntityLivingBase)(this.seats[0]).field_70153_n).field_70761_aq + 90.0F, 0.0F, 0.0F);
      } else {
        if (type.limitHeadTurn) {
          float axesLegs = this.legAxes.getYaw();
          float axesBody = this.axes.getYaw();
          double dYaw = (axesBody - axesLegs);
          if (dYaw > 180.0D)
            axesBody -= 360.0F; 
          if (dYaw < -180.0D)
            axesBody += 360.0F; 
          if (axesLegs + type.limitHeadTurnValue < axesBody)
            this.axes.setAngles(axesLegs + type.limitHeadTurnValue, 0.0F, 0.0F); 
          if (axesLegs - type.limitHeadTurnValue > axesBody)
            this.axes.setAngles(axesLegs - type.limitHeadTurnValue, 0.0F, 0.0F); 
        } 
        float yaw = (this.seats[0]).looking.getYaw() - (this.seats[0]).prevLooking.getYaw();
        (this.seats[0]).looking.rotateGlobalYaw(-yaw);
        if (this.driveableData.panicTimer <= 0)
          (this.seats[0]).playerLooking.rotateGlobalYaw(-yaw); 
        this.axes.rotateGlobalYaw(yaw);
      }  
    float jetPack = jetPackPower();
    if (!this.field_70122_E && thePlayerIsDrivingThis && (Minecraft.func_71410_x()).field_71462_r instanceof com.flansmod.client.gui.GuiDriveableController && FlansMod.proxy.isKeyDown(4) && shouldFly() && (((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d || data.fuelInTank >= 10.0F * jetPack)) {
      this.field_70181_x *= 0.95D;
      this.field_70181_x += 0.07D * jetPack;
      this.field_70143_R = 0.0F;
      if (!((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d)
        data.fuelInTank -= 10.0F * jetPack; 
      if (this.rocketTimer <= 0.0F && (rocketPack()).soundEffect != null) {
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, (rocketPack()).soundEffect, false);
        this.rocketTimer = (rocketPack()).soundTime;
      } 
    } else if (func_70090_H() && shouldFloat()) {
      this.field_70181_x *= 0.89D;
      this.field_70181_x += 0.1D;
    } 
    if (this.rocketTimer != 0.0F)
      this.rocketTimer--; 
    Vector3f actualMotion = new Vector3f(0.0D, this.field_70181_x - 0.03999999910593033D, 0.0D);
    if (driverIsLiving) {
      EntityLivingBase entity = (EntityLivingBase)(this.seats[0]).field_70153_n;
      boolean driverIsCreative = (entity instanceof EntityPlayer && ((EntityPlayer)entity).field_71075_bZ.field_75098_d);
      if (thePlayerIsDrivingThis && (Minecraft.func_71410_x()).field_71462_r instanceof com.flansmod.client.gui.GuiDriveableController && this.driveableData.panicTimer <= 0) {
        if (FlansMod.proxy.isKeyDown(0)) {
          this.moveX = 1.0F * this.poopooThrottle;
          this.poopooThrottle += 0.1F;
        } 
        if (this.poopooThrottle > 0.1D)
          this.moveX = 1.0F * this.poopooThrottle; 
        if (FlansMod.proxy.isKeyDown(1)) {
          this.moveX = -1.0F * this.poopooThrottle;
          if (this.poopooThrottle < 0.5F)
            this.poopooThrottle += 0.1F; 
        } 
        if (FlansMod.proxy.isKeyDown(2)) {
          this.moveZ = -1.0F * this.poopooThrottle;
          if (this.poopooThrottle < 0.9F)
            this.poopooThrottle += 0.1F; 
        } 
        if (FlansMod.proxy.isKeyDown(3)) {
          this.moveZ = 1.0F * this.poopooThrottle;
          if (this.poopooThrottle < 0.9F)
            this.poopooThrottle += 0.1F; 
        } 
      } else if ((this.seats[0]).field_70153_n instanceof EntityLiving && !((this.seats[0]).field_70153_n instanceof EntityPlayer)) {
        this.moveZ = 1.0F;
      } 
      Vector3f intent = new Vector3f(this.moveX, 0.0F, this.moveZ);
      if (Math.abs(intent.lengthSquared()) > 0.1D) {
        this.legSwing++;
        this.legPosition += (getMechaType()).legAnimSpeed;
        if (this.stompDelay == 0 && this.legPosition >= (getMechaType()).stompRangeLower && this.legPosition <= (getMechaType()).stompRangeUpper) {
          PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, (getMechaType()).stompSound, false);
          this.stompDelay = (getMechaType()).stompSoundLength;
        } 
        intent = this.axes.findLocalVectorGlobally(intent);
        Vector3f intentOnLegAxes = this.legAxes.findGlobalVectorLocally(intent);
        float intentAngle = (float)Math.atan2(intent.z, intent.x) * 180.0F / 3.1415927F;
        float angleBetween = intentAngle - this.legAxes.getYaw();
        if (angleBetween > 180.0F)
          angleBetween -= 360.0F; 
        if (angleBetween < -180.0F)
          angleBetween += 360.0F; 
        float signBetween = Math.signum(angleBetween);
        angleBetween = Math.abs(angleBetween);
        if (angleBetween > 0.1D)
          this.legAxes.rotateGlobalYaw(Math.min(angleBetween, type.rotateSpeed) * signBetween); 
        intent.scale(type.moveSpeed * data.engine.engineSpeed * speedMultiplier() * 0.215F);
        boolean canThrustCreatively = (this.seats != null && this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d);
        if ((canThrustCreatively || data.fuelInTank > data.engine.fuelConsumption) && isPartIntact(EnumDriveablePart.hips)) {
          if (!this.field_70122_E && shouldFly() && (canThrustCreatively || data.fuelInTank > 10.0F * jetPack + data.engine.fuelConsumption)) {
            intent.scale(jetPack);
            if (!canThrustCreatively)
              data.fuelInTank -= 10.0F * jetPack; 
          } 
          Vector3f.add(actualMotion, intent, actualMotion);
          if (!canThrustCreatively)
            data.fuelInTank -= data.engine.fuelConsumption; 
        } 
      } else {
        this.legPosition = 0.0F;
      } 
      if (!this.field_70170_p.field_72995_K) {
        if (this.leftMouseHeld)
          useItem(true); 
        if (this.rightMouseHeld)
          useItem(false); 
        if (this.breakingBlock != null) {
          Block blockHit = this.field_70170_p.func_147439_a(this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z);
          int metadata = this.field_70170_p.func_72805_g(this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z);
          Material material = blockHit.func_149688_o();
          ItemStack leftStack = this.inventory.getStackInSlot(EnumMechaSlotType.leftTool);
          ItemStack rightStack = this.inventory.getStackInSlot(EnumMechaSlotType.rightTool);
          boolean leftStackIsTool = (leftStack != null && leftStack.func_77973_b() instanceof ItemMechaAddon);
          boolean rightStackIsTool = (rightStack != null && rightStack.func_77973_b() instanceof ItemMechaAddon);
          boolean breakingBlocks = ((this.leftMouseHeld && leftStackIsTool) || (this.rightMouseHeld && rightStackIsTool));
          if (blockHit == null || !breakingBlocks) {
            this.breakingBlock = null;
          } else {
            float blockHardness = blockHit.func_149712_f(this.field_70170_p, this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z);
            float mineSpeed = 1.0F;
            boolean atLeastOneEffectiveTool = false;
            if (leftStackIsTool) {
              MechaItemType leftType = ((ItemMechaAddon)leftStack.func_77973_b()).type;
              if (leftType.function.effectiveAgainst(material) && leftType.toolHardness > blockHardness) {
                mineSpeed *= leftType.speed;
                atLeastOneEffectiveTool = true;
              } 
            } 
            if (rightStackIsTool) {
              MechaItemType rightType = ((ItemMechaAddon)rightStack.func_77973_b()).type;
              if (rightType.function.effectiveAgainst(material) && rightType.toolHardness > blockHardness) {
                mineSpeed *= rightType.speed;
                atLeastOneEffectiveTool = true;
              } 
            } 
            if (blockHardness < -0.01F) {
              mineSpeed = 0.0F;
            } else if (Math.abs(blockHardness) < 0.01F) {
              mineSpeed = 9001.0F;
            } else {
              mineSpeed /= blockHit.func_149712_f(this.field_70170_p, this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z);
            } 
            this.breakingProgress += 0.1F * mineSpeed;
            if (this.breakingProgress >= 1.0F) {
              boolean cancelled = false;
              if (entity instanceof EntityPlayerMP) {
                BlockEvent.BreakEvent event = ForgeHooks.onBlockBreakEvent(this.field_70170_p, ((EntityPlayerMP)entity).field_71075_bZ.field_75098_d ? WorldSettings.GameType.CREATIVE : (((EntityPlayerMP)entity).field_71075_bZ.field_75099_e ? WorldSettings.GameType.SURVIVAL : WorldSettings.GameType.ADVENTURE), (EntityPlayerMP)(this.seats[0]).field_70153_n, this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z);
                cancelled = event.isCanceled();
              } 
              if (!cancelled) {
                boolean vacuumItems = vacuumItems();
                if (vacuumItems)
                  for (ItemStack stack : blockHit.getDrops(this.field_70170_p, this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z, metadata, 0)) {
                    boolean fuelCheck = (data.fuelInTank >= 5.0F || ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d);
                    if (fuelCheck && refineIron() && stack.func_77973_b() instanceof ItemBlock && ((ItemBlock)stack.func_77973_b()).field_150939_a == Blocks.field_150366_p) {
                      stack = new ItemStack(Items.field_151042_j, 1, 0);
                      if (!((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d)
                        data.fuelInTank -= 5.0F; 
                    } 
                    fuelCheck = (data.fuelInTank >= 0.1F || ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d);
                    if (fuelCheck && wasteCompact().booleanValue() && stack.func_77973_b() instanceof ItemBlock && (((ItemBlock)stack.func_77973_b()).field_150939_a == Blocks.field_150347_e || ((ItemBlock)stack.func_77973_b()).field_150939_a == Blocks.field_150346_d || ((ItemBlock)stack.func_77973_b()).field_150939_a == Blocks.field_150354_m)) {
                      stack.field_77994_a = 0;
                      if (!((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d)
                        data.fuelInTank -= 0.1F; 
                    } 
                    fuelCheck = (data.fuelInTank >= 3.0F * diamondMultiplier() || ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d);
                    if (fuelCheck && stack.func_77973_b() == Items.field_151045_i) {
                      float multiplier = diamondMultiplier();
                      stack.field_77994_a *= MathHelper.func_76141_d(multiplier) + ((this.field_70146_Z.nextFloat() < tailFloat(multiplier)) ? 1 : 0);
                      if (!((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d)
                        data.fuelInTank -= 3.0F * diamondMultiplier(); 
                    } 
                    fuelCheck = (data.fuelInTank >= 2.0F * redstoneMultiplier() || ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d);
                    if (fuelCheck && stack.func_77973_b() == Items.field_151137_ax) {
                      float multiplier = redstoneMultiplier();
                      stack.field_77994_a *= MathHelper.func_76141_d(multiplier) + ((this.field_70146_Z.nextFloat() < tailFloat(multiplier)) ? 1 : 0);
                      if (!((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d)
                        data.fuelInTank -= 2.0F * redstoneMultiplier(); 
                    } 
                    fuelCheck = (data.fuelInTank >= 2.0F * coalMultiplier() || ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d);
                    if (fuelCheck && stack.func_77973_b() == Items.field_151044_h) {
                      float multiplier = coalMultiplier();
                      stack.field_77994_a *= MathHelper.func_76141_d(multiplier) + ((this.field_70146_Z.nextFloat() < tailFloat(multiplier)) ? 1 : 0);
                      if (!((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d)
                        data.fuelInTank -= 2.0F * coalMultiplier(); 
                    } 
                    fuelCheck = (data.fuelInTank >= 2.0F * emeraldMultiplier() || ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d);
                    if (fuelCheck && stack.func_77973_b() == Items.field_151166_bC) {
                      float multiplier = emeraldMultiplier();
                      stack.field_77994_a *= MathHelper.func_76141_d(multiplier) + ((this.field_70146_Z.nextFloat() < tailFloat(multiplier)) ? 1 : 0);
                      if (!((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d)
                        data.fuelInTank -= 2.0F * emeraldMultiplier(); 
                    } 
                    fuelCheck = (data.fuelInTank >= 2.0F * ironMultiplier() || ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d);
                    if (fuelCheck && stack.func_77973_b() == Items.field_151042_j && refineIron()) {
                      float multiplier = ironMultiplier();
                      stack.field_77994_a *= MathHelper.func_76141_d(multiplier) + ((this.field_70146_Z.nextFloat() < tailFloat(multiplier)) ? 1 : 0);
                      if (!((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d)
                        data.fuelInTank -= 2.0F * ironMultiplier(); 
                    } 
                    if (autoCoal() && stack.func_77973_b() == Items.field_151044_h && data.fuelInTank + 250.0F < type.fuelTankSize) {
                      data.fuelInTank = Math.min(data.fuelInTank + 1000.0F, type.fuelTankSize);
                      this.couldNotFindFuel = false;
                      stack.field_77994_a = 0;
                    } 
                    if (!InventoryHelper.addItemStackToInventory((IInventory)this.driveableData, stack, driverIsCreative) && !this.field_70170_p.field_72995_K && this.field_70170_p.func_82736_K().func_82766_b("doTileDrops"))
                      this.field_70170_p.func_72838_d((Entity)new EntityItem(this.field_70170_p, (this.breakingBlock.x + 0.5F), (this.breakingBlock.y + 0.5F), (this.breakingBlock.z + 0.5F), stack)); 
                  }  
                this.field_70170_p.func_147480_a(this.breakingBlock.x, this.breakingBlock.y, this.breakingBlock.z, (atLeastOneEffectiveTool && !vacuumItems));
              } 
            } 
          } 
        } 
      } 
    } 
    this.field_70181_x = actualMotion.y;
    func_70091_d(actualMotion.x, actualMotion.y, actualMotion.z);
    func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    if (thePlayerIsDrivingThis) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketMechaControl(this));
      this.field_70118_ct = this.field_70165_t;
      this.field_70117_cu = this.field_70163_u;
      this.field_70116_cv = this.field_70161_v;
      this.serverYaw = this.axes.getYaw();
    } 
    if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 5 == 0)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketMechaControl(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, FlansMod.driveableUpdateRange, this.field_71093_bK); 
    for (EntitySeat seat : this.seats) {
      if (seat != null)
        seat.updatePosition(); 
    } 
    if (!driverIsLiving || thePlayerIsDrivingThis)
      this.legSwing /= type.legSwingLimit; 
  }
  
  private float tailFloat(float f) {
    return f - MathHelper.func_76141_d(f);
  }
  
  public boolean stopFallDamage() {
    for (MechaItemType type : getUpgradeTypes()) {
      if (type.stopMechaFallDamage)
        return true; 
    } 
    return false;
  }
  
  public boolean breakBlocksUponFalling() {
    for (MechaItemType type : getUpgradeTypes()) {
      if (type.forceBlockFallDamage)
        return true; 
    } 
    return false;
  }
  
  public boolean vacuumItems() {
    for (MechaItemType type : getUpgradeTypes()) {
      if (type.vacuumItems)
        return true; 
    } 
    return false;
  }
  
  public boolean refineIron() {
    for (MechaItemType type : getUpgradeTypes()) {
      if (type.refineIron)
        return true; 
    } 
    return false;
  }
  
  public MechaItemType diamondDetect() {
    for (MechaItemType type : getUpgradeTypes()) {
      if (type.diamondDetect)
        return type; 
    } 
    return null;
  }
  
  public Boolean wasteCompact() {
    for (MechaItemType type : getUpgradeTypes()) {
      if (type.wasteCompact)
        return Boolean.valueOf(true); 
    } 
    return Boolean.valueOf(false);
  }
  
  public float diamondMultiplier() {
    float multiplier = 1.0F;
    for (MechaItemType type : getUpgradeTypes())
      multiplier *= type.fortuneDiamond; 
    return multiplier;
  }
  
  public float speedMultiplier() {
    float multiplier = 1.0F;
    for (MechaItemType type : getUpgradeTypes())
      multiplier *= type.speedMultiplier; 
    return multiplier;
  }
  
  public float coalMultiplier() {
    float multiplier = 1.0F;
    for (MechaItemType type : getUpgradeTypes())
      multiplier *= type.fortuneCoal; 
    return multiplier;
  }
  
  public float redstoneMultiplier() {
    float multiplier = 1.0F;
    for (MechaItemType type : getUpgradeTypes())
      multiplier *= type.fortuneRedstone; 
    return multiplier;
  }
  
  public float vulnerability() {
    float multiplier = 1.0F;
    for (MechaItemType type : getUpgradeTypes())
      multiplier *= 1.0F - type.damageResistance; 
    return multiplier;
  }
  
  public float emeraldMultiplier() {
    float multiplier = 1.0F;
    for (MechaItemType type : getUpgradeTypes())
      multiplier *= type.fortuneEmerald; 
    return multiplier;
  }
  
  public float ironMultiplier() {
    float multiplier = 1.0F;
    for (MechaItemType type : getUpgradeTypes())
      multiplier *= type.fortuneIron; 
    return multiplier;
  }
  
  public int lightLevel() {
    int level = 0;
    for (MechaItemType type : getUpgradeTypes())
      level = Math.max(level, type.lightLevel); 
    return level;
  }
  
  public boolean forceDark() {
    for (MechaItemType type : getUpgradeTypes()) {
      if (type.forceDark)
        return true; 
    } 
    return false;
  }
  
  public boolean autoCoal() {
    for (MechaItemType type : getUpgradeTypes()) {
      if (type.autoCoal)
        return true; 
    } 
    return false;
  }
  
  public boolean autoRepair() {
    for (MechaItemType type : getUpgradeTypes()) {
      if (type.autoRepair)
        return true; 
    } 
    return false;
  }
  
  public boolean shouldFloat() {
    for (MechaItemType type : getUpgradeTypes()) {
      if (type.floater)
        return true; 
    } 
    return false;
  }
  
  public boolean infiniteAmmo() {
    for (MechaItemType type : getUpgradeTypes()) {
      if (type.infiniteAmmo)
        return true; 
    } 
    return false;
  }
  
  public MechaItemType rocketPack() {
    for (MechaItemType type : getUpgradeTypes()) {
      if (type.rocketPack)
        return type; 
    } 
    return null;
  }
  
  public boolean shouldFly() {
    return (rocketPack() != null);
  }
  
  public float jetPackPower() {
    float multiplier = 1.0F;
    for (MechaItemType type : getUpgradeTypes())
      multiplier *= type.rocketPower; 
    return multiplier;
  }
  
  public ArrayList<MechaItemType> getUpgradeTypes() {
    ArrayList<MechaItemType> types = new ArrayList<>();
    for (ItemStack stack : this.inventory.stacks.values()) {
      if (stack != null && stack.func_77973_b() instanceof ItemMechaAddon)
        types.add(((ItemMechaAddon)stack.func_77973_b()).type); 
    } 
    return types;
  }
  
  @SideOnly(Side.CLIENT)
  public boolean showInventory(int seat) {
    return (seat != 0);
  }
  
  protected void dropItemsOnPartDeath(Vector3f midpoint, DriveablePart part) {}
  
  public boolean hasMouseControlMode() {
    return false;
  }
  
  public String getBombInventoryName() {
    return "";
  }
  
  public String getMissileInventoryName() {
    return "";
  }
  
  @SideOnly(Side.CLIENT)
  public EntityLivingBase getCamera() {
    return null;
  }
  
  public AxisAlignedBB func_70114_g(Entity entity) {
    if ((getDriveableType()).collisionDamageEnable)
      if (this.throttle > (getDriveableType()).collisionDamageThrottle)
        if (entity instanceof EntityLiving && !entity.func_70115_ae() && !entity.field_70128_L) {
          entity.func_70097_a(DamageSource.field_76367_g, (getDriveableType()).collisionDamageTimes);
          if ((getDriveableType()).collisionDamageTimes > 40.0F && ((EntityLiving)entity).func_110143_aJ() > 0.0F) {
            FlansMod.proxy.spawnParticle("flansmod.overkill", entity.field_70165_t, entity.field_70163_u - 4.0D, entity.field_70161_v, 0.0D, 0.10000000149011612D, 0.0D);
            PacketPlaySound.sendSoundPacket(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 15.0D, entity.field_71093_bK, "goreDeath", true);
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.overkill", entity.field_70165_t, entity.field_70163_u - 4.0D, entity.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 150.0F, entity.field_71093_bK);
          } 
        } else if (entity instanceof EntityPlayer && !entity.func_70115_ae() && !entity.field_70128_L) {
          entity.func_70097_a(DamageSource.field_76367_g, (getDriveableType()).collisionDamageTimes);
          if ((getDriveableType()).collisionDamageTimes > 40.0F && ((EntityPlayer)entity).func_110143_aJ() > 0.0F) {
            FlansMod.proxy.spawnParticle("flansmod.overkill", entity.field_70165_t, entity.field_70163_u - 4.0D, entity.field_70161_v, 0.0D, 0.10000000149011612D, 0.0D);
            PacketPlaySound.sendSoundPacket(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 15.0D, entity.field_71093_bK, "goreDeath", true);
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.overkill", entity.field_70165_t, entity.field_70163_u - 4.0D, entity.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 150.0F, entity.field_71093_bK);
          } 
        }   
    return this.field_70121_D;
  }
}
