package com.flansmod.client;

import com.flansmod.client.model.RenderFlag;
import com.flansmod.client.model.RenderGun;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketChecker;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3i;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MouseHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumSkyBlock;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class TickHandlerClient {
  public static Entity lastMount;
  
  public static final ResourceLocation offHand = new ResourceLocation("flansmod", "gui/offHand.png");
  
  public static ArrayList<Vector3i> blockLightOverrides = new ArrayList<>();
  
  public static ArrayList<Vector3i> vehicleLightOverrides = new ArrayList<>();
  
  public static int lightOverrideRefreshRate = 5;
  
  public static int vehicleLightOverrideRefreshRate = 1;
  
  int tickcount = 0;
  
  int tickcountflash = 0;
  
  int tickcountWounded = 0;
  
  boolean isInFlash;
  
  int flashTime;
  
  EntityPlayer entityPlayerFlash;
  
  private static GuiScreen guiDriveableController = null;
  
  public static float cringeBlood = 100.0F;
  
  public static float cringeHemorrhaging = 0.0F;
  
  public TickHandlerClient() {
    FMLCommonHandler.instance().bus().register(this);
    MinecraftForge.EVENT_BUS.register(this);
  }
  
  @SubscribeEvent
  public void eventHandler(MouseEvent event) {
    EntityClientPlayerMP entityClientPlayerMP = (Minecraft.func_71410_x()).field_71439_g;
    if (entityClientPlayerMP.func_71045_bC() != null && entityClientPlayerMP.func_71045_bC().func_77973_b() instanceof ItemGun)
      if (((ItemGun)entityClientPlayerMP.func_71045_bC().func_77973_b()).type.oneHanded && Keyboard.isKeyDown((Minecraft.func_71410_x()).field_71474_y.field_74311_E.func_151463_i()) && Math.abs(event.dwheel) > 0)
        event.setCanceled(true);  
  }
  
  @SubscribeEvent
  public void eventHandler(RenderGameOverlayEvent event) {
    // Byte code:
    //   0: invokestatic func_71410_x : ()Lnet/minecraft/client/Minecraft;
    //   3: astore_2
    //   4: getstatic com/flansmod/client/FlansModClient.minecraft : Lnet/minecraft/client/Minecraft;
    //   7: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   10: invokevirtual func_70005_c_ : ()Ljava/lang/String;
    //   13: astore_3
    //   14: invokestatic func_71410_x : ()Lnet/minecraft/client/Minecraft;
    //   17: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
    //   20: getfield field_74314_A : Lnet/minecraft/client/settings/KeyBinding;
    //   23: invokevirtual func_151463_i : ()I
    //   26: invokestatic isKeyDown : (I)Z
    //   29: ifeq -> 79
    //   32: aload_2
    //   33: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   36: invokevirtual func_70115_ae : ()Z
    //   39: ifne -> 79
    //   42: ldc net/minecraft/client/renderer/EntityRenderer
    //   44: invokestatic instance : ()Lcpw/mods/fml/client/FMLClientHandler;
    //   47: invokevirtual getClient : ()Lnet/minecraft/client/Minecraft;
    //   50: getfield field_71460_t : Lnet/minecraft/client/renderer/EntityRenderer;
    //   53: iconst_1
    //   54: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   57: iconst_3
    //   58: anewarray java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: ldc 'cameraZoom'
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: ldc 'af'
    //   70: aastore
    //   71: dup
    //   72: iconst_2
    //   73: ldc 'field_78503_V'
    //   75: aastore
    //   76: invokestatic setPrivateValue : (Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/String;)V
    //   79: aload_2
    //   80: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   83: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   86: instanceof com/flansmod/common/driveables/EntitySeat
    //   89: ifeq -> 169
    //   92: aload_2
    //   93: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   96: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   99: checkcast com/flansmod/common/driveables/EntitySeat
    //   102: getfield driveable : Lcom/flansmod/common/driveables/EntityDriveable;
    //   105: astore #4
    //   107: aload #4
    //   109: instanceof com/flansmod/common/driveables/EntityVehicle
    //   112: ifeq -> 169
    //   115: aload #4
    //   117: checkcast com/flansmod/common/driveables/EntityVehicle
    //   120: astore #5
    //   122: aload_1
    //   123: getfield type : Lnet/minecraftforge/client/event/RenderGameOverlayEvent$ElementType;
    //   126: getstatic net/minecraftforge/client/event/RenderGameOverlayEvent$ElementType.CROSSHAIRS : Lnet/minecraftforge/client/event/RenderGameOverlayEvent$ElementType;
    //   129: if_acmpne -> 169
    //   132: aload_2
    //   133: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   136: ifnull -> 169
    //   139: aload #4
    //   141: ifnull -> 169
    //   144: aload #4
    //   146: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   149: getfield hasScope : Z
    //   152: ifeq -> 169
    //   155: aload #5
    //   157: getfield hasRadar : Z
    //   160: ifne -> 169
    //   163: aload_1
    //   164: iconst_1
    //   165: invokevirtual setCanceled : (Z)V
    //   168: return
    //   169: aload_1
    //   170: getfield type : Lnet/minecraftforge/client/event/RenderGameOverlayEvent$ElementType;
    //   173: getstatic net/minecraftforge/client/event/RenderGameOverlayEvent$ElementType.CROSSHAIRS : Lnet/minecraftforge/client/event/RenderGameOverlayEvent$ElementType;
    //   176: if_acmpne -> 267
    //   179: aload_2
    //   180: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   183: ifnull -> 267
    //   186: aload_2
    //   187: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   190: invokevirtual func_70694_bm : ()Lnet/minecraft/item/ItemStack;
    //   193: ifnull -> 267
    //   196: aload_2
    //   197: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   200: invokevirtual func_70694_bm : ()Lnet/minecraft/item/ItemStack;
    //   203: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   206: instanceof com/flansmod/common/guns/ItemGun
    //   209: ifeq -> 267
    //   212: aload_2
    //   213: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   216: invokevirtual func_70115_ae : ()Z
    //   219: ifne -> 267
    //   222: aload_2
    //   223: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   226: invokevirtual func_70694_bm : ()Lnet/minecraft/item/ItemStack;
    //   229: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   232: checkcast com/flansmod/common/guns/ItemGun
    //   235: getfield type : Lcom/flansmod/common/guns/GunType;
    //   238: getfield showCrosshair : Z
    //   241: ifeq -> 261
    //   244: getstatic com/flansmod/client/FlansModClient.currentScope : Lcom/flansmod/common/guns/IScope;
    //   247: ifnonnull -> 261
    //   250: getstatic com/flansmod/client/FlansModClient.lastZoomProgress : F
    //   253: f2d
    //   254: ldc2_w -0.8
    //   257: dcmpg
    //   258: ifge -> 267
    //   261: aload_1
    //   262: iconst_1
    //   263: invokevirtual setCanceled : (Z)V
    //   266: return
    //   267: new net/minecraft/client/gui/ScaledResolution
    //   270: dup
    //   271: getstatic com/flansmod/client/FlansModClient.minecraft : Lnet/minecraft/client/Minecraft;
    //   274: getstatic com/flansmod/client/FlansModClient.minecraft : Lnet/minecraft/client/Minecraft;
    //   277: getfield field_71443_c : I
    //   280: getstatic com/flansmod/client/FlansModClient.minecraft : Lnet/minecraft/client/Minecraft;
    //   283: getfield field_71440_d : I
    //   286: invokespecial <init> : (Lnet/minecraft/client/Minecraft;II)V
    //   289: astore #4
    //   291: aload #4
    //   293: invokevirtual func_78326_a : ()I
    //   296: istore #5
    //   298: aload #4
    //   300: invokevirtual func_78328_b : ()I
    //   303: istore #6
    //   305: getstatic net/minecraft/client/renderer/Tessellator.field_78398_a : Lnet/minecraft/client/renderer/Tessellator;
    //   308: astore #7
    //   310: aload_1
    //   311: invokevirtual isCancelable : ()Z
    //   314: ifne -> 1051
    //   317: aload_1
    //   318: getfield type : Lnet/minecraftforge/client/event/RenderGameOverlayEvent$ElementType;
    //   321: getstatic net/minecraftforge/client/event/RenderGameOverlayEvent$ElementType.HELMET : Lnet/minecraftforge/client/event/RenderGameOverlayEvent$ElementType;
    //   324: if_acmpne -> 1051
    //   327: aconst_null
    //   328: astore #8
    //   330: getstatic com/flansmod/client/FlansModClient.currentScope : Lcom/flansmod/common/guns/IScope;
    //   333: ifnull -> 382
    //   336: getstatic com/flansmod/client/FlansModClient.currentScope : Lcom/flansmod/common/guns/IScope;
    //   339: invokeinterface hasZoomOverlay : ()Z
    //   344: ifeq -> 382
    //   347: invokestatic instance : ()Lcpw/mods/fml/client/FMLClientHandler;
    //   350: invokevirtual getClient : ()Lnet/minecraft/client/Minecraft;
    //   353: getfield field_71462_r : Lnet/minecraft/client/gui/GuiScreen;
    //   356: ifnonnull -> 382
    //   359: getstatic com/flansmod/client/FlansModClient.zoomProgress : F
    //   362: ldc_w 0.8
    //   365: fcmpl
    //   366: ifle -> 382
    //   369: getstatic com/flansmod/client/FlansModClient.currentScope : Lcom/flansmod/common/guns/IScope;
    //   372: invokeinterface getZoomOverlay : ()Ljava/lang/String;
    //   377: astore #8
    //   379: goto -> 865
    //   382: aload_2
    //   383: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   386: ifnull -> 865
    //   389: aload_2
    //   390: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   393: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
    //   396: getfield field_70460_b : [Lnet/minecraft/item/ItemStack;
    //   399: iconst_3
    //   400: aaload
    //   401: astore #9
    //   403: aload #9
    //   405: ifnull -> 603
    //   408: aload #9
    //   410: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   413: instanceof com/flansmod/common/teams/ItemTeamArmour
    //   416: ifeq -> 603
    //   419: aload #9
    //   421: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   424: checkcast com/flansmod/common/teams/ItemTeamArmour
    //   427: getfield type : Lcom/flansmod/common/teams/ArmourType;
    //   430: getfield faceArmor : F
    //   433: aload #9
    //   435: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   438: checkcast com/flansmod/common/teams/ItemTeamArmour
    //   441: getfield type : Lcom/flansmod/common/teams/ArmourType;
    //   444: getfield headArmor : F
    //   447: fconst_1
    //   448: fadd
    //   449: fdiv
    //   450: ldc_w 0.7
    //   453: fcmpl
    //   454: ifle -> 484
    //   457: aload #9
    //   459: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   462: checkcast com/flansmod/common/teams/ItemTeamArmour
    //   465: getfield type : Lcom/flansmod/common/teams/ArmourType;
    //   468: getfield faceArmor : F
    //   471: fconst_1
    //   472: fcmpl
    //   473: ifeq -> 484
    //   476: ldc_w 'faceHelmet'
    //   479: astore #8
    //   481: goto -> 603
    //   484: aload #9
    //   486: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   489: checkcast com/flansmod/common/teams/ItemTeamArmour
    //   492: getfield type : Lcom/flansmod/common/teams/ArmourType;
    //   495: getfield faceArmor : F
    //   498: aload #9
    //   500: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   503: checkcast com/flansmod/common/teams/ItemTeamArmour
    //   506: getfield type : Lcom/flansmod/common/teams/ArmourType;
    //   509: getfield headArmor : F
    //   512: fconst_1
    //   513: fadd
    //   514: fdiv
    //   515: ldc_w 0.2
    //   518: fcmpl
    //   519: ifle -> 587
    //   522: aload #9
    //   524: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   527: checkcast com/flansmod/common/teams/ItemTeamArmour
    //   530: getfield type : Lcom/flansmod/common/teams/ArmourType;
    //   533: getfield faceArmor : F
    //   536: aload #9
    //   538: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   541: checkcast com/flansmod/common/teams/ItemTeamArmour
    //   544: getfield type : Lcom/flansmod/common/teams/ArmourType;
    //   547: getfield headArmor : F
    //   550: fconst_1
    //   551: fadd
    //   552: fdiv
    //   553: ldc_w 0.7
    //   556: fcmpg
    //   557: ifgt -> 587
    //   560: aload #9
    //   562: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   565: checkcast com/flansmod/common/teams/ItemTeamArmour
    //   568: getfield type : Lcom/flansmod/common/teams/ArmourType;
    //   571: getfield faceArmor : F
    //   574: fconst_1
    //   575: fcmpl
    //   576: ifeq -> 587
    //   579: ldc_w 'cheekHelmet'
    //   582: astore #8
    //   584: goto -> 603
    //   587: aload #9
    //   589: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   592: checkcast com/flansmod/common/teams/ItemTeamArmour
    //   595: getfield type : Lcom/flansmod/common/teams/ArmourType;
    //   598: getfield overlay : Ljava/lang/String;
    //   601: astore #8
    //   603: getstatic com/flansmod/client/FlansModClient.teamInfo : Lcom/flansmod/common/network/PacketTeamInfo;
    //   606: astore #10
    //   608: getstatic com/flansmod/client/TickHandlerClient.cringeHemorrhaging : F
    //   611: fconst_1
    //   612: fcmpl
    //   613: ifle -> 650
    //   616: aload_2
    //   617: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   620: ldc_w 'ORGAN FAILURE IMMINENT'
    //   623: iconst_2
    //   624: bipush #72
    //   626: ldc_w 14329120
    //   629: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   632: pop
    //   633: aload_2
    //   634: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   637: ldc_w 'SURGERY NEEDED'
    //   640: iconst_2
    //   641: bipush #82
    //   643: ldc_w 16711680
    //   646: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   649: pop
    //   650: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   653: ldc_w 95.0
    //   656: fcmpg
    //   657: ifgt -> 675
    //   660: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   663: ldc_w 80.0
    //   666: fcmpl
    //   667: ifle -> 675
    //   670: ldc_w 'blood1'
    //   673: astore #8
    //   675: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   678: ldc_w 80.0
    //   681: fcmpg
    //   682: ifgt -> 700
    //   685: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   688: ldc_w 70.0
    //   691: fcmpl
    //   692: ifle -> 700
    //   695: ldc_w 'blood2'
    //   698: astore #8
    //   700: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   703: ldc_w 70.0
    //   706: fcmpg
    //   707: ifgt -> 725
    //   710: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   713: ldc_w 60.0
    //   716: fcmpl
    //   717: ifle -> 725
    //   720: ldc_w 'blood3'
    //   723: astore #8
    //   725: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   728: ldc_w 60.0
    //   731: fcmpg
    //   732: ifgt -> 750
    //   735: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   738: ldc_w 50.0
    //   741: fcmpl
    //   742: ifle -> 750
    //   745: ldc_w 'blood4'
    //   748: astore #8
    //   750: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   753: ldc_w 50.0
    //   756: fcmpg
    //   757: ifgt -> 775
    //   760: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   763: ldc_w 40.0
    //   766: fcmpl
    //   767: ifle -> 775
    //   770: ldc_w 'blood5'
    //   773: astore #8
    //   775: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   778: ldc_w 40.0
    //   781: fcmpg
    //   782: ifgt -> 800
    //   785: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   788: ldc_w 30.0
    //   791: fcmpl
    //   792: ifle -> 800
    //   795: ldc_w 'blood6'
    //   798: astore #8
    //   800: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   803: ldc_w 30.0
    //   806: fcmpg
    //   807: ifgt -> 825
    //   810: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   813: ldc_w 20.0
    //   816: fcmpl
    //   817: ifle -> 825
    //   820: ldc_w 'blood7'
    //   823: astore #8
    //   825: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   828: ldc_w 20.0
    //   831: fcmpg
    //   832: ifgt -> 850
    //   835: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   838: ldc_w 10.0
    //   841: fcmpl
    //   842: ifle -> 850
    //   845: ldc_w 'blood8'
    //   848: astore #8
    //   850: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   853: ldc_w 10.0
    //   856: fcmpg
    //   857: ifgt -> 865
    //   860: ldc_w 'blood9'
    //   863: astore #8
    //   865: aload #8
    //   867: ifnull -> 1051
    //   870: getstatic com/flansmod/client/FlansModClient.minecraft : Lnet/minecraft/client/Minecraft;
    //   873: getfield field_71460_t : Lnet/minecraft/client/renderer/EntityRenderer;
    //   876: invokevirtual func_78478_c : ()V
    //   879: sipush #3042
    //   882: invokestatic glEnable : (I)V
    //   885: sipush #2929
    //   888: invokestatic glDisable : (I)V
    //   891: iconst_0
    //   892: invokestatic glDepthMask : (Z)V
    //   895: sipush #770
    //   898: sipush #771
    //   901: invokestatic glBlendFunc : (II)V
    //   904: fconst_1
    //   905: fconst_1
    //   906: fconst_1
    //   907: fconst_1
    //   908: invokestatic glColor4f : (FFFF)V
    //   911: sipush #3008
    //   914: invokestatic glDisable : (I)V
    //   917: aload_2
    //   918: getfield field_71446_o : Lnet/minecraft/client/renderer/texture/TextureManager;
    //   921: aload #8
    //   923: invokestatic getScope : (Ljava/lang/String;)Lnet/minecraft/util/ResourceLocation;
    //   926: invokevirtual func_110577_a : (Lnet/minecraft/util/ResourceLocation;)V
    //   929: aload #7
    //   931: invokevirtual func_78382_b : ()V
    //   934: aload #7
    //   936: iload #5
    //   938: iconst_2
    //   939: idiv
    //   940: iconst_2
    //   941: iload #6
    //   943: imul
    //   944: isub
    //   945: i2d
    //   946: iload #6
    //   948: i2d
    //   949: ldc2_w -90.0
    //   952: dconst_0
    //   953: dconst_1
    //   954: invokevirtual func_78374_a : (DDDDD)V
    //   957: aload #7
    //   959: iload #5
    //   961: iconst_2
    //   962: idiv
    //   963: iconst_2
    //   964: iload #6
    //   966: imul
    //   967: iadd
    //   968: i2d
    //   969: iload #6
    //   971: i2d
    //   972: ldc2_w -90.0
    //   975: dconst_1
    //   976: dconst_1
    //   977: invokevirtual func_78374_a : (DDDDD)V
    //   980: aload #7
    //   982: iload #5
    //   984: iconst_2
    //   985: idiv
    //   986: iconst_2
    //   987: iload #6
    //   989: imul
    //   990: iadd
    //   991: i2d
    //   992: dconst_0
    //   993: ldc2_w -90.0
    //   996: dconst_1
    //   997: dconst_0
    //   998: invokevirtual func_78374_a : (DDDDD)V
    //   1001: aload #7
    //   1003: iload #5
    //   1005: iconst_2
    //   1006: idiv
    //   1007: iconst_2
    //   1008: iload #6
    //   1010: imul
    //   1011: isub
    //   1012: i2d
    //   1013: dconst_0
    //   1014: ldc2_w -90.0
    //   1017: dconst_0
    //   1018: dconst_0
    //   1019: invokevirtual func_78374_a : (DDDDD)V
    //   1022: aload #7
    //   1024: invokevirtual func_78381_a : ()I
    //   1027: pop
    //   1028: iconst_1
    //   1029: invokestatic glDepthMask : (Z)V
    //   1032: sipush #2929
    //   1035: invokestatic glEnable : (I)V
    //   1038: sipush #3008
    //   1041: invokestatic glEnable : (I)V
    //   1044: fconst_1
    //   1045: fconst_1
    //   1046: fconst_1
    //   1047: fconst_1
    //   1048: invokestatic glColor4f : (FFFF)V
    //   1051: aload_1
    //   1052: invokevirtual isCancelable : ()Z
    //   1055: ifne -> 11056
    //   1058: aload_1
    //   1059: getfield type : Lnet/minecraftforge/client/event/RenderGameOverlayEvent$ElementType;
    //   1062: getstatic net/minecraftforge/client/event/RenderGameOverlayEvent$ElementType.HOTBAR : Lnet/minecraftforge/client/event/RenderGameOverlayEvent$ElementType;
    //   1065: if_acmpne -> 11056
    //   1068: getstatic com/flansmod/common/FlansMod.bulletGuiEnable : Z
    //   1071: ifeq -> 11056
    //   1074: aload_2
    //   1075: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   1078: ifnull -> 1876
    //   1081: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   1084: ldc_w 100.0
    //   1087: fcmpg
    //   1088: ifge -> 1129
    //   1091: aload_2
    //   1092: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   1095: new java/lang/StringBuilder
    //   1098: dup
    //   1099: invokespecial <init> : ()V
    //   1102: ldc_w 'Blood: '
    //   1105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: getstatic com/flansmod/client/TickHandlerClient.cringeBlood : F
    //   1111: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   1114: invokevirtual toString : ()Ljava/lang/String;
    //   1117: sipush #172
    //   1120: bipush #30
    //   1122: ldc_w 14329120
    //   1125: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   1128: pop
    //   1129: getstatic com/flansmod/client/TickHandlerClient.cringeHemorrhaging : F
    //   1132: fconst_0
    //   1133: fcmpl
    //   1134: ifle -> 1156
    //   1137: aload_2
    //   1138: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   1141: ldc_w 'FATAL BEEDING'
    //   1144: sipush #172
    //   1147: bipush #42
    //   1149: ldc_w 16711680
    //   1152: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   1155: pop
    //   1156: aload_2
    //   1157: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   1160: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
    //   1163: invokevirtual func_70448_g : ()Lnet/minecraft/item/ItemStack;
    //   1166: astore #8
    //   1168: aload #8
    //   1170: ifnull -> 1876
    //   1173: aload #8
    //   1175: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   1178: instanceof com/flansmod/common/guns/ItemGun
    //   1181: ifeq -> 1876
    //   1184: aload #8
    //   1186: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   1189: checkcast com/flansmod/common/guns/ItemGun
    //   1192: astore #9
    //   1194: aload #9
    //   1196: getfield type : Lcom/flansmod/common/guns/GunType;
    //   1199: astore #10
    //   1201: iconst_0
    //   1202: istore #11
    //   1204: iconst_0
    //   1205: istore #12
    //   1207: iload #12
    //   1209: aload #10
    //   1211: aload #8
    //   1213: invokevirtual getNumAmmoItemsInGun : (Lnet/minecraft/item/ItemStack;)I
    //   1216: if_icmpge -> 1497
    //   1219: aload #8
    //   1221: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   1224: checkcast com/flansmod/common/guns/ItemGun
    //   1227: aload #8
    //   1229: iload #12
    //   1231: invokevirtual getBulletItemStack : (Lnet/minecraft/item/ItemStack;I)Lnet/minecraft/item/ItemStack;
    //   1234: astore #13
    //   1236: aload #13
    //   1238: ifnull -> 1491
    //   1241: aload #13
    //   1243: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   1246: ifnull -> 1491
    //   1249: aload #13
    //   1251: invokevirtual func_77960_j : ()I
    //   1254: aload #13
    //   1256: invokevirtual func_77958_k : ()I
    //   1259: if_icmpge -> 1491
    //   1262: invokestatic func_74520_c : ()V
    //   1265: ldc_w 32826
    //   1268: invokestatic glEnable : (I)V
    //   1271: getstatic net/minecraft/client/renderer/OpenGlHelper.field_77476_b : I
    //   1274: ldc_w 240.0
    //   1277: ldc_w 240.0
    //   1280: invokestatic func_77475_a : (IFF)V
    //   1283: aload_0
    //   1284: aload_2
    //   1285: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   1288: aload #13
    //   1290: iload #5
    //   1292: iconst_2
    //   1293: idiv
    //   1294: bipush #16
    //   1296: iadd
    //   1297: iload #11
    //   1299: iadd
    //   1300: iload #6
    //   1302: bipush #65
    //   1304: isub
    //   1305: invokespecial drawSlotInventory : (Lnet/minecraft/client/gui/FontRenderer;Lnet/minecraft/item/ItemStack;II)V
    //   1308: ldc_w 32826
    //   1311: invokestatic glDisable : (I)V
    //   1314: invokestatic func_74518_a : ()V
    //   1317: new java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial <init> : ()V
    //   1324: aload #13
    //   1326: invokevirtual func_77958_k : ()I
    //   1329: aload #13
    //   1331: invokevirtual func_77960_j : ()I
    //   1334: isub
    //   1335: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1338: ldc_w '/'
    //   1341: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: aload #13
    //   1346: invokevirtual func_77958_k : ()I
    //   1349: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1352: invokevirtual toString : ()Ljava/lang/String;
    //   1355: astore #14
    //   1357: aload #10
    //   1359: getfield submode : [Lcom/flansmod/common/guns/EnumFireMode;
    //   1362: arraylength
    //   1363: iconst_2
    //   1364: if_icmplt -> 1406
    //   1367: new java/lang/StringBuilder
    //   1370: dup
    //   1371: invokespecial <init> : ()V
    //   1374: aload #14
    //   1376: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: ldc_w '['
    //   1382: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: aload #10
    //   1387: aload #8
    //   1389: invokevirtual getFireMode : (Lnet/minecraft/item/ItemStack;)Lcom/flansmod/common/guns/EnumFireMode;
    //   1392: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1395: ldc_w ']'
    //   1398: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: invokevirtual toString : ()Ljava/lang/String;
    //   1404: astore #14
    //   1406: aload #13
    //   1408: invokevirtual func_77958_k : ()I
    //   1411: iconst_1
    //   1412: if_icmpne -> 1420
    //   1415: ldc_w ''
    //   1418: astore #14
    //   1420: aload_2
    //   1421: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   1424: aload #14
    //   1426: iload #5
    //   1428: iconst_2
    //   1429: idiv
    //   1430: bipush #32
    //   1432: iadd
    //   1433: iload #11
    //   1435: iadd
    //   1436: iload #6
    //   1438: bipush #59
    //   1440: isub
    //   1441: iconst_0
    //   1442: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   1445: pop
    //   1446: aload_2
    //   1447: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   1450: aload #14
    //   1452: iload #5
    //   1454: iconst_2
    //   1455: idiv
    //   1456: bipush #33
    //   1458: iadd
    //   1459: iload #11
    //   1461: iadd
    //   1462: iload #6
    //   1464: bipush #60
    //   1466: isub
    //   1467: ldc_w 16777215
    //   1470: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   1473: pop
    //   1474: iload #11
    //   1476: bipush #16
    //   1478: aload_2
    //   1479: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   1482: aload #14
    //   1484: invokevirtual func_78256_a : (Ljava/lang/String;)I
    //   1487: iadd
    //   1488: iadd
    //   1489: istore #11
    //   1491: iinc #12, 1
    //   1494: goto -> 1207
    //   1497: aload_2
    //   1498: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   1501: getstatic cpw/mods/fml/relauncher/Side.CLIENT : Lcpw/mods/fml/relauncher/Side;
    //   1504: invokestatic getPlayerData : (Lnet/minecraft/entity/player/EntityPlayer;Lcpw/mods/fml/relauncher/Side;)Lcom/flansmod/common/PlayerData;
    //   1507: astore #12
    //   1509: aload #10
    //   1511: getfield oneHanded : Z
    //   1514: ifeq -> 1876
    //   1517: aload #12
    //   1519: getfield offHandGunSlot : I
    //   1522: ifeq -> 1876
    //   1525: aload_2
    //   1526: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   1529: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
    //   1532: aload #12
    //   1534: getfield offHandGunSlot : I
    //   1537: iconst_1
    //   1538: isub
    //   1539: invokevirtual func_70301_a : (I)Lnet/minecraft/item/ItemStack;
    //   1542: astore #13
    //   1544: aload #13
    //   1546: ifnull -> 1876
    //   1549: aload #13
    //   1551: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   1554: instanceof com/flansmod/common/guns/ItemGun
    //   1557: ifeq -> 1876
    //   1560: aload #13
    //   1562: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   1565: checkcast com/flansmod/common/guns/ItemGun
    //   1568: getfield type : Lcom/flansmod/common/guns/GunType;
    //   1571: astore #14
    //   1573: iconst_0
    //   1574: istore #11
    //   1576: iconst_0
    //   1577: istore #15
    //   1579: iload #15
    //   1581: aload #14
    //   1583: aload #13
    //   1585: invokevirtual getNumAmmoItemsInGun : (Lnet/minecraft/item/ItemStack;)I
    //   1588: if_icmpge -> 1876
    //   1591: aload #13
    //   1593: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   1596: checkcast com/flansmod/common/guns/ItemGun
    //   1599: aload #13
    //   1601: iload #15
    //   1603: invokevirtual getBulletItemStack : (Lnet/minecraft/item/ItemStack;I)Lnet/minecraft/item/ItemStack;
    //   1606: astore #16
    //   1608: aload #16
    //   1610: ifnull -> 1870
    //   1613: aload #16
    //   1615: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   1618: ifnull -> 1870
    //   1621: aload #16
    //   1623: invokevirtual func_77960_j : ()I
    //   1626: aload #16
    //   1628: invokevirtual func_77958_k : ()I
    //   1631: if_icmpge -> 1870
    //   1634: new java/lang/StringBuilder
    //   1637: dup
    //   1638: invokespecial <init> : ()V
    //   1641: aload #16
    //   1643: invokevirtual func_77958_k : ()I
    //   1646: aload #16
    //   1648: invokevirtual func_77960_j : ()I
    //   1651: isub
    //   1652: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1655: ldc_w '/'
    //   1658: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: aload #16
    //   1663: invokevirtual func_77958_k : ()I
    //   1666: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1669: invokevirtual toString : ()Ljava/lang/String;
    //   1672: astore #17
    //   1674: aload #10
    //   1676: getfield submode : [Lcom/flansmod/common/guns/EnumFireMode;
    //   1679: arraylength
    //   1680: iconst_2
    //   1681: if_icmplt -> 1723
    //   1684: new java/lang/StringBuilder
    //   1687: dup
    //   1688: invokespecial <init> : ()V
    //   1691: aload #17
    //   1693: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1696: ldc_w '['
    //   1699: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1702: aload #10
    //   1704: aload #13
    //   1706: invokevirtual getFireMode : (Lnet/minecraft/item/ItemStack;)Lcom/flansmod/common/guns/EnumFireMode;
    //   1709: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1712: ldc_w ']'
    //   1715: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1718: invokevirtual toString : ()Ljava/lang/String;
    //   1721: astore #17
    //   1723: aload #16
    //   1725: invokevirtual func_77958_k : ()I
    //   1728: iconst_1
    //   1729: if_icmpne -> 1737
    //   1732: ldc_w ''
    //   1735: astore #17
    //   1737: invokestatic func_74520_c : ()V
    //   1740: fconst_1
    //   1741: fconst_1
    //   1742: fconst_1
    //   1743: fconst_1
    //   1744: invokestatic glColor4f : (FFFF)V
    //   1747: ldc_w 32826
    //   1750: invokestatic glEnable : (I)V
    //   1753: getstatic net/minecraft/client/renderer/OpenGlHelper.field_77476_b : I
    //   1756: ldc_w 240.0
    //   1759: ldc_w 240.0
    //   1762: invokestatic func_77475_a : (IFF)V
    //   1765: aload_0
    //   1766: aload_2
    //   1767: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   1770: aload #16
    //   1772: iload #5
    //   1774: iconst_2
    //   1775: idiv
    //   1776: bipush #32
    //   1778: isub
    //   1779: iload #11
    //   1781: isub
    //   1782: iload #6
    //   1784: bipush #65
    //   1786: isub
    //   1787: invokespecial drawSlotInventory : (Lnet/minecraft/client/gui/FontRenderer;Lnet/minecraft/item/ItemStack;II)V
    //   1790: iload #11
    //   1792: bipush #16
    //   1794: aload_2
    //   1795: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   1798: aload #17
    //   1800: invokevirtual func_78256_a : (Ljava/lang/String;)I
    //   1803: iadd
    //   1804: iadd
    //   1805: istore #11
    //   1807: ldc_w 32826
    //   1810: invokestatic glDisable : (I)V
    //   1813: invokestatic func_74518_a : ()V
    //   1816: aload_2
    //   1817: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   1820: aload #17
    //   1822: iload #5
    //   1824: iconst_2
    //   1825: idiv
    //   1826: bipush #16
    //   1828: isub
    //   1829: iload #11
    //   1831: isub
    //   1832: iload #6
    //   1834: bipush #59
    //   1836: isub
    //   1837: iconst_0
    //   1838: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   1841: pop
    //   1842: aload_2
    //   1843: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   1846: aload #17
    //   1848: iload #5
    //   1850: iconst_2
    //   1851: idiv
    //   1852: bipush #17
    //   1854: isub
    //   1855: iload #11
    //   1857: isub
    //   1858: iload #6
    //   1860: bipush #60
    //   1862: isub
    //   1863: ldc_w 16777215
    //   1866: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   1869: pop
    //   1870: iinc #15, 1
    //   1873: goto -> 1579
    //   1876: getstatic com/flansmod/client/FlansModClient.teamInfo : Lcom/flansmod/common/network/PacketTeamInfo;
    //   1879: astore #8
    //   1881: aload #8
    //   1883: ifnull -> 3325
    //   1886: getstatic com/flansmod/client/FlansModClient.minecraft : Lnet/minecraft/client/Minecraft;
    //   1889: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   1892: ifnull -> 3325
    //   1895: aload #8
    //   1897: pop
    //   1898: getstatic com/flansmod/common/network/PacketTeamInfo.numTeams : I
    //   1901: ifgt -> 1913
    //   1904: aload #8
    //   1906: pop
    //   1907: getstatic com/flansmod/common/network/PacketTeamInfo.sortedByTeam : Z
    //   1910: ifne -> 3325
    //   1913: aload #8
    //   1915: pop
    //   1916: getstatic com/flansmod/client/FlansModClient.minecraft : Lnet/minecraft/client/Minecraft;
    //   1919: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   1922: invokevirtual func_70005_c_ : ()Ljava/lang/String;
    //   1925: invokestatic getPlayerScoreData : (Ljava/lang/String;)Lcom/flansmod/common/network/PacketTeamInfo$PlayerScoreData;
    //   1928: ifnull -> 3325
    //   1931: sipush #3042
    //   1934: invokestatic glEnable : (I)V
    //   1937: sipush #2929
    //   1940: invokestatic glDisable : (I)V
    //   1943: iconst_0
    //   1944: invokestatic glDepthMask : (Z)V
    //   1947: sipush #770
    //   1950: sipush #771
    //   1953: invokestatic glBlendFunc : (II)V
    //   1956: fconst_1
    //   1957: fconst_1
    //   1958: fconst_1
    //   1959: fconst_1
    //   1960: invokestatic glColor4f : (FFFF)V
    //   1963: sipush #3008
    //   1966: invokestatic glDisable : (I)V
    //   1969: aload_2
    //   1970: getfield field_71446_o : Lnet/minecraft/client/renderer/texture/TextureManager;
    //   1973: getstatic com/flansmod/client/gui/GuiTeamScores.texture : Lnet/minecraft/util/ResourceLocation;
    //   1976: invokevirtual func_110577_a : (Lnet/minecraft/util/ResourceLocation;)V
    //   1979: aload #7
    //   1981: invokevirtual func_78382_b : ()V
    //   1984: aload #7
    //   1986: iload #5
    //   1988: iconst_2
    //   1989: idiv
    //   1990: bipush #43
    //   1992: isub
    //   1993: i2d
    //   1994: ldc2_w 35.0
    //   1997: ldc2_w -90.0
    //   2000: ldc2_w 0.33203125
    //   2003: ldc2_w 0.13671875
    //   2006: invokevirtual func_78374_a : (DDDDD)V
    //   2009: aload #7
    //   2011: iload #5
    //   2013: iconst_2
    //   2014: idiv
    //   2015: bipush #43
    //   2017: iadd
    //   2018: i2d
    //   2019: ldc2_w 35.0
    //   2022: ldc2_w -90.0
    //   2025: ldc2_w 0.66796875
    //   2028: ldc2_w 0.13671875
    //   2031: invokevirtual func_78374_a : (DDDDD)V
    //   2034: aload #7
    //   2036: iload #5
    //   2038: iconst_2
    //   2039: idiv
    //   2040: bipush #43
    //   2042: iadd
    //   2043: i2d
    //   2044: dconst_0
    //   2045: ldc2_w -90.0
    //   2048: ldc2_w 0.66796875
    //   2051: dconst_0
    //   2052: invokevirtual func_78374_a : (DDDDD)V
    //   2055: aload #7
    //   2057: iload #5
    //   2059: iconst_2
    //   2060: idiv
    //   2061: bipush #43
    //   2063: isub
    //   2064: i2d
    //   2065: dconst_0
    //   2066: ldc2_w -90.0
    //   2069: ldc2_w 0.33203125
    //   2072: dconst_0
    //   2073: invokevirtual func_78374_a : (DDDDD)V
    //   2076: aload #7
    //   2078: invokevirtual func_78381_a : ()I
    //   2081: pop
    //   2082: aload #8
    //   2084: pop
    //   2085: getstatic com/flansmod/common/network/PacketTeamInfo.numTeams : I
    //   2088: iconst_2
    //   2089: if_icmpne -> 2724
    //   2092: aload #8
    //   2094: pop
    //   2095: getstatic com/flansmod/common/network/PacketTeamInfo.sortedByTeam : Z
    //   2098: ifeq -> 2724
    //   2101: aload #8
    //   2103: pop
    //   2104: getstatic com/flansmod/common/network/PacketTeamInfo.teamData : [Lcom/flansmod/common/network/PacketTeamInfo$TeamData;
    //   2107: iconst_0
    //   2108: aaload
    //   2109: getfield team : Lcom/flansmod/common/teams/Team;
    //   2112: getfield teamColour : I
    //   2115: istore #9
    //   2117: iload #9
    //   2119: bipush #16
    //   2121: ishr
    //   2122: sipush #255
    //   2125: iand
    //   2126: i2f
    //   2127: ldc_w 256.0
    //   2130: fdiv
    //   2131: iload #9
    //   2133: bipush #8
    //   2135: ishr
    //   2136: sipush #255
    //   2139: iand
    //   2140: i2f
    //   2141: ldc_w 256.0
    //   2144: fdiv
    //   2145: iload #9
    //   2147: sipush #255
    //   2150: iand
    //   2151: i2f
    //   2152: ldc_w 256.0
    //   2155: fdiv
    //   2156: fconst_1
    //   2157: invokestatic glColor4f : (FFFF)V
    //   2160: aload #7
    //   2162: invokevirtual func_78382_b : ()V
    //   2165: aload #7
    //   2167: iload #5
    //   2169: iconst_2
    //   2170: idiv
    //   2171: bipush #43
    //   2173: isub
    //   2174: i2d
    //   2175: ldc2_w 27.0
    //   2178: ldc2_w -90.0
    //   2181: dconst_0
    //   2182: ldc2_w 0.48828125
    //   2185: invokevirtual func_78374_a : (DDDDD)V
    //   2188: aload #7
    //   2190: iload #5
    //   2192: iconst_2
    //   2193: idiv
    //   2194: bipush #19
    //   2196: isub
    //   2197: i2d
    //   2198: ldc2_w 27.0
    //   2201: ldc2_w -90.0
    //   2204: ldc2_w 0.09375
    //   2207: ldc2_w 0.48828125
    //   2210: invokevirtual func_78374_a : (DDDDD)V
    //   2213: aload #7
    //   2215: iload #5
    //   2217: iconst_2
    //   2218: idiv
    //   2219: bipush #19
    //   2221: isub
    //   2222: i2d
    //   2223: dconst_0
    //   2224: ldc2_w -90.0
    //   2227: ldc2_w 0.09375
    //   2230: ldc2_w 0.3828125
    //   2233: invokevirtual func_78374_a : (DDDDD)V
    //   2236: aload #7
    //   2238: iload #5
    //   2240: iconst_2
    //   2241: idiv
    //   2242: bipush #43
    //   2244: isub
    //   2245: i2d
    //   2246: dconst_0
    //   2247: ldc2_w -90.0
    //   2250: dconst_0
    //   2251: ldc2_w 0.3828125
    //   2254: invokevirtual func_78374_a : (DDDDD)V
    //   2257: aload #7
    //   2259: invokevirtual func_78381_a : ()I
    //   2262: pop
    //   2263: aload #8
    //   2265: pop
    //   2266: getstatic com/flansmod/common/network/PacketTeamInfo.teamData : [Lcom/flansmod/common/network/PacketTeamInfo$TeamData;
    //   2269: iconst_1
    //   2270: aaload
    //   2271: getfield team : Lcom/flansmod/common/teams/Team;
    //   2274: getfield teamColour : I
    //   2277: istore #9
    //   2279: iload #9
    //   2281: bipush #16
    //   2283: ishr
    //   2284: sipush #255
    //   2287: iand
    //   2288: i2f
    //   2289: ldc_w 256.0
    //   2292: fdiv
    //   2293: iload #9
    //   2295: bipush #8
    //   2297: ishr
    //   2298: sipush #255
    //   2301: iand
    //   2302: i2f
    //   2303: ldc_w 256.0
    //   2306: fdiv
    //   2307: iload #9
    //   2309: sipush #255
    //   2312: iand
    //   2313: i2f
    //   2314: ldc_w 256.0
    //   2317: fdiv
    //   2318: fconst_1
    //   2319: invokestatic glColor4f : (FFFF)V
    //   2322: aload #7
    //   2324: invokevirtual func_78382_b : ()V
    //   2327: aload #7
    //   2329: iload #5
    //   2331: iconst_2
    //   2332: idiv
    //   2333: bipush #19
    //   2335: iadd
    //   2336: i2d
    //   2337: ldc2_w 27.0
    //   2340: ldc2_w -90.0
    //   2343: ldc2_w 0.2421875
    //   2346: ldc2_w 0.48828125
    //   2349: invokevirtual func_78374_a : (DDDDD)V
    //   2352: aload #7
    //   2354: iload #5
    //   2356: iconst_2
    //   2357: idiv
    //   2358: bipush #43
    //   2360: iadd
    //   2361: i2d
    //   2362: ldc2_w 27.0
    //   2365: ldc2_w -90.0
    //   2368: ldc2_w 0.3359375
    //   2371: ldc2_w 0.48828125
    //   2374: invokevirtual func_78374_a : (DDDDD)V
    //   2377: aload #7
    //   2379: iload #5
    //   2381: iconst_2
    //   2382: idiv
    //   2383: bipush #43
    //   2385: iadd
    //   2386: i2d
    //   2387: dconst_0
    //   2388: ldc2_w -90.0
    //   2391: ldc2_w 0.3359375
    //   2394: ldc2_w 0.3828125
    //   2397: invokevirtual func_78374_a : (DDDDD)V
    //   2400: aload #7
    //   2402: iload #5
    //   2404: iconst_2
    //   2405: idiv
    //   2406: bipush #19
    //   2408: iadd
    //   2409: i2d
    //   2410: dconst_0
    //   2411: ldc2_w -90.0
    //   2414: ldc2_w 0.2421875
    //   2417: ldc2_w 0.3828125
    //   2420: invokevirtual func_78374_a : (DDDDD)V
    //   2423: aload #7
    //   2425: invokevirtual func_78381_a : ()I
    //   2428: pop
    //   2429: iconst_1
    //   2430: invokestatic glDepthMask : (Z)V
    //   2433: sipush #2929
    //   2436: invokestatic glEnable : (I)V
    //   2439: sipush #3008
    //   2442: invokestatic glEnable : (I)V
    //   2445: fconst_1
    //   2446: fconst_1
    //   2447: fconst_1
    //   2448: fconst_1
    //   2449: invokestatic glColor4f : (FFFF)V
    //   2452: aload_2
    //   2453: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   2456: new java/lang/StringBuilder
    //   2459: dup
    //   2460: invokespecial <init> : ()V
    //   2463: aload #8
    //   2465: pop
    //   2466: getstatic com/flansmod/common/network/PacketTeamInfo.teamData : [Lcom/flansmod/common/network/PacketTeamInfo$TeamData;
    //   2469: iconst_0
    //   2470: aaload
    //   2471: getfield score : I
    //   2474: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2477: ldc_w ''
    //   2480: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2483: invokevirtual toString : ()Ljava/lang/String;
    //   2486: iload #5
    //   2488: iconst_2
    //   2489: idiv
    //   2490: bipush #35
    //   2492: isub
    //   2493: bipush #9
    //   2495: iconst_0
    //   2496: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   2499: pop
    //   2500: aload_2
    //   2501: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   2504: new java/lang/StringBuilder
    //   2507: dup
    //   2508: invokespecial <init> : ()V
    //   2511: aload #8
    //   2513: pop
    //   2514: getstatic com/flansmod/common/network/PacketTeamInfo.teamData : [Lcom/flansmod/common/network/PacketTeamInfo$TeamData;
    //   2517: iconst_0
    //   2518: aaload
    //   2519: getfield score : I
    //   2522: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2525: ldc_w ''
    //   2528: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2531: invokevirtual toString : ()Ljava/lang/String;
    //   2534: iload #5
    //   2536: iconst_2
    //   2537: idiv
    //   2538: bipush #36
    //   2540: isub
    //   2541: bipush #8
    //   2543: ldc_w 16777215
    //   2546: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   2549: pop
    //   2550: aload_2
    //   2551: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   2554: new java/lang/StringBuilder
    //   2557: dup
    //   2558: invokespecial <init> : ()V
    //   2561: aload #8
    //   2563: pop
    //   2564: getstatic com/flansmod/common/network/PacketTeamInfo.teamData : [Lcom/flansmod/common/network/PacketTeamInfo$TeamData;
    //   2567: iconst_1
    //   2568: aaload
    //   2569: getfield score : I
    //   2572: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2575: ldc_w ''
    //   2578: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2581: invokevirtual toString : ()Ljava/lang/String;
    //   2584: iload #5
    //   2586: iconst_2
    //   2587: idiv
    //   2588: bipush #35
    //   2590: iadd
    //   2591: aload_2
    //   2592: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   2595: new java/lang/StringBuilder
    //   2598: dup
    //   2599: invokespecial <init> : ()V
    //   2602: aload #8
    //   2604: pop
    //   2605: getstatic com/flansmod/common/network/PacketTeamInfo.teamData : [Lcom/flansmod/common/network/PacketTeamInfo$TeamData;
    //   2608: iconst_1
    //   2609: aaload
    //   2610: getfield score : I
    //   2613: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2616: ldc_w ''
    //   2619: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2622: invokevirtual toString : ()Ljava/lang/String;
    //   2625: invokevirtual func_78256_a : (Ljava/lang/String;)I
    //   2628: isub
    //   2629: bipush #9
    //   2631: iconst_0
    //   2632: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   2635: pop
    //   2636: aload_2
    //   2637: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   2640: new java/lang/StringBuilder
    //   2643: dup
    //   2644: invokespecial <init> : ()V
    //   2647: aload #8
    //   2649: pop
    //   2650: getstatic com/flansmod/common/network/PacketTeamInfo.teamData : [Lcom/flansmod/common/network/PacketTeamInfo$TeamData;
    //   2653: iconst_1
    //   2654: aaload
    //   2655: getfield score : I
    //   2658: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2661: ldc_w ''
    //   2664: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2667: invokevirtual toString : ()Ljava/lang/String;
    //   2670: iload #5
    //   2672: iconst_2
    //   2673: idiv
    //   2674: bipush #34
    //   2676: iadd
    //   2677: aload_2
    //   2678: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   2681: new java/lang/StringBuilder
    //   2684: dup
    //   2685: invokespecial <init> : ()V
    //   2688: aload #8
    //   2690: pop
    //   2691: getstatic com/flansmod/common/network/PacketTeamInfo.teamData : [Lcom/flansmod/common/network/PacketTeamInfo$TeamData;
    //   2694: iconst_1
    //   2695: aaload
    //   2696: getfield score : I
    //   2699: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   2702: ldc_w ''
    //   2705: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2708: invokevirtual toString : ()Ljava/lang/String;
    //   2711: invokevirtual func_78256_a : (Ljava/lang/String;)I
    //   2714: isub
    //   2715: bipush #8
    //   2717: ldc_w 16777215
    //   2720: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   2723: pop
    //   2724: aload_2
    //   2725: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   2728: new java/lang/StringBuilder
    //   2731: dup
    //   2732: invokespecial <init> : ()V
    //   2735: aload #8
    //   2737: pop
    //   2738: getstatic com/flansmod/common/network/PacketTeamInfo.gametype : Ljava/lang/String;
    //   2741: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2744: ldc_w ''
    //   2747: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2750: invokevirtual toString : ()Ljava/lang/String;
    //   2753: iload #5
    //   2755: iconst_2
    //   2756: idiv
    //   2757: bipush #48
    //   2759: iadd
    //   2760: bipush #9
    //   2762: iconst_0
    //   2763: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   2766: pop
    //   2767: aload_2
    //   2768: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   2771: new java/lang/StringBuilder
    //   2774: dup
    //   2775: invokespecial <init> : ()V
    //   2778: aload #8
    //   2780: pop
    //   2781: getstatic com/flansmod/common/network/PacketTeamInfo.gametype : Ljava/lang/String;
    //   2784: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2787: ldc_w ''
    //   2790: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2793: invokevirtual toString : ()Ljava/lang/String;
    //   2796: iload #5
    //   2798: iconst_2
    //   2799: idiv
    //   2800: bipush #47
    //   2802: iadd
    //   2803: bipush #8
    //   2805: ldc_w 16777215
    //   2808: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   2811: pop
    //   2812: aload_2
    //   2813: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   2816: new java/lang/StringBuilder
    //   2819: dup
    //   2820: invokespecial <init> : ()V
    //   2823: aload #8
    //   2825: pop
    //   2826: getstatic com/flansmod/common/network/PacketTeamInfo.map : Ljava/lang/String;
    //   2829: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2832: ldc_w ''
    //   2835: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2838: invokevirtual toString : ()Ljava/lang/String;
    //   2841: iload #5
    //   2843: iconst_2
    //   2844: idiv
    //   2845: bipush #47
    //   2847: isub
    //   2848: aload_2
    //   2849: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   2852: new java/lang/StringBuilder
    //   2855: dup
    //   2856: invokespecial <init> : ()V
    //   2859: aload #8
    //   2861: pop
    //   2862: getstatic com/flansmod/common/network/PacketTeamInfo.map : Ljava/lang/String;
    //   2865: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2868: ldc_w ''
    //   2871: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2874: invokevirtual toString : ()Ljava/lang/String;
    //   2877: invokevirtual func_78256_a : (Ljava/lang/String;)I
    //   2880: isub
    //   2881: bipush #9
    //   2883: iconst_0
    //   2884: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   2887: pop
    //   2888: aload_2
    //   2889: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   2892: new java/lang/StringBuilder
    //   2895: dup
    //   2896: invokespecial <init> : ()V
    //   2899: aload #8
    //   2901: pop
    //   2902: getstatic com/flansmod/common/network/PacketTeamInfo.map : Ljava/lang/String;
    //   2905: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2908: ldc_w ''
    //   2911: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2914: invokevirtual toString : ()Ljava/lang/String;
    //   2917: iload #5
    //   2919: iconst_2
    //   2920: idiv
    //   2921: bipush #48
    //   2923: isub
    //   2924: aload_2
    //   2925: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   2928: new java/lang/StringBuilder
    //   2931: dup
    //   2932: invokespecial <init> : ()V
    //   2935: aload #8
    //   2937: pop
    //   2938: getstatic com/flansmod/common/network/PacketTeamInfo.map : Ljava/lang/String;
    //   2941: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2944: ldc_w ''
    //   2947: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2950: invokevirtual toString : ()Ljava/lang/String;
    //   2953: invokevirtual func_78256_a : (Ljava/lang/String;)I
    //   2956: isub
    //   2957: bipush #8
    //   2959: ldc_w 16777215
    //   2962: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   2965: pop
    //   2966: aload #8
    //   2968: pop
    //   2969: getstatic com/flansmod/common/network/PacketTeamInfo.timeLeft : I
    //   2972: bipush #20
    //   2974: idiv
    //   2975: istore #9
    //   2977: iload #9
    //   2979: bipush #60
    //   2981: idiv
    //   2982: istore #10
    //   2984: iload #9
    //   2986: bipush #60
    //   2988: irem
    //   2989: istore #9
    //   2991: new java/lang/StringBuilder
    //   2994: dup
    //   2995: invokespecial <init> : ()V
    //   2998: iload #10
    //   3000: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   3003: ldc_w ':'
    //   3006: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3009: iload #9
    //   3011: bipush #10
    //   3013: if_icmpge -> 3040
    //   3016: new java/lang/StringBuilder
    //   3019: dup
    //   3020: invokespecial <init> : ()V
    //   3023: ldc_w '0'
    //   3026: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3029: iload #9
    //   3031: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   3034: invokevirtual toString : ()Ljava/lang/String;
    //   3037: goto -> 3045
    //   3040: iload #9
    //   3042: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   3045: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3048: invokevirtual toString : ()Ljava/lang/String;
    //   3051: astore #11
    //   3053: aload_2
    //   3054: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3057: aload #11
    //   3059: iload #5
    //   3061: iconst_2
    //   3062: idiv
    //   3063: aload_2
    //   3064: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3067: aload #11
    //   3069: invokevirtual func_78256_a : (Ljava/lang/String;)I
    //   3072: iconst_2
    //   3073: idiv
    //   3074: isub
    //   3075: iconst_1
    //   3076: isub
    //   3077: bipush #37
    //   3079: iconst_0
    //   3080: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   3083: pop
    //   3084: aload_2
    //   3085: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3088: aload #11
    //   3090: iload #5
    //   3092: iconst_2
    //   3093: idiv
    //   3094: aload_2
    //   3095: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3098: aload #11
    //   3100: invokevirtual func_78256_a : (Ljava/lang/String;)I
    //   3103: iconst_2
    //   3104: idiv
    //   3105: isub
    //   3106: bipush #38
    //   3108: ldc_w 16777215
    //   3111: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   3114: pop
    //   3115: iconst_1
    //   3116: invokestatic glDepthMask : (Z)V
    //   3119: sipush #2929
    //   3122: invokestatic glEnable : (I)V
    //   3125: sipush #3008
    //   3128: invokestatic glEnable : (I)V
    //   3131: fconst_1
    //   3132: fconst_1
    //   3133: fconst_1
    //   3134: fconst_1
    //   3135: invokestatic glColor4f : (FFFF)V
    //   3138: aload_2
    //   3139: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3142: new java/lang/StringBuilder
    //   3145: dup
    //   3146: invokespecial <init> : ()V
    //   3149: aload #8
    //   3151: pop
    //   3152: aload_3
    //   3153: invokestatic getPlayerScoreData : (Ljava/lang/String;)Lcom/flansmod/common/network/PacketTeamInfo$PlayerScoreData;
    //   3156: getfield score : I
    //   3159: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   3162: ldc_w ''
    //   3165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3168: invokevirtual toString : ()Ljava/lang/String;
    //   3171: iload #5
    //   3173: iconst_2
    //   3174: idiv
    //   3175: bipush #7
    //   3177: isub
    //   3178: iconst_1
    //   3179: iconst_0
    //   3180: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   3183: pop
    //   3184: aload_2
    //   3185: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3188: new java/lang/StringBuilder
    //   3191: dup
    //   3192: invokespecial <init> : ()V
    //   3195: aload #8
    //   3197: pop
    //   3198: aload_3
    //   3199: invokestatic getPlayerScoreData : (Ljava/lang/String;)Lcom/flansmod/common/network/PacketTeamInfo$PlayerScoreData;
    //   3202: getfield kills : I
    //   3205: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   3208: ldc_w ''
    //   3211: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3214: invokevirtual toString : ()Ljava/lang/String;
    //   3217: iload #5
    //   3219: iconst_2
    //   3220: idiv
    //   3221: bipush #7
    //   3223: isub
    //   3224: bipush #9
    //   3226: iconst_0
    //   3227: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   3230: pop
    //   3231: aload_2
    //   3232: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3235: new java/lang/StringBuilder
    //   3238: dup
    //   3239: invokespecial <init> : ()V
    //   3242: aload #8
    //   3244: pop
    //   3245: aload_3
    //   3246: invokestatic getPlayerScoreData : (Ljava/lang/String;)Lcom/flansmod/common/network/PacketTeamInfo$PlayerScoreData;
    //   3249: getfield deaths : I
    //   3252: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   3255: ldc_w ''
    //   3258: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3261: invokevirtual toString : ()Ljava/lang/String;
    //   3264: iload #5
    //   3266: iconst_2
    //   3267: idiv
    //   3268: bipush #7
    //   3270: isub
    //   3271: bipush #17
    //   3273: iconst_0
    //   3274: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   3277: pop
    //   3278: aload_2
    //   3279: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3282: new java/lang/StringBuilder
    //   3285: dup
    //   3286: invokespecial <init> : ()V
    //   3289: aload #8
    //   3291: pop
    //   3292: aload_3
    //   3293: invokestatic getPlayerScoreData : (Ljava/lang/String;)Lcom/flansmod/common/network/PacketTeamInfo$PlayerScoreData;
    //   3296: getfield shekels : I
    //   3299: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   3302: ldc_w ''
    //   3305: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3308: invokevirtual toString : ()Ljava/lang/String;
    //   3311: iload #5
    //   3313: iconst_2
    //   3314: idiv
    //   3315: bipush #7
    //   3317: isub
    //   3318: bipush #25
    //   3320: iconst_0
    //   3321: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   3324: pop
    //   3325: getstatic com/flansmod/client/TickHandlerClient.killMessages : Ljava/util/List;
    //   3328: invokeinterface iterator : ()Ljava/util/Iterator;
    //   3333: astore #9
    //   3335: aload #9
    //   3337: invokeinterface hasNext : ()Z
    //   3342: ifeq -> 3468
    //   3345: aload #9
    //   3347: invokeinterface next : ()Ljava/lang/Object;
    //   3352: checkcast com/flansmod/client/TickHandlerClient$KillMessage
    //   3355: astore #10
    //   3357: aload_2
    //   3358: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3361: new java/lang/StringBuilder
    //   3364: dup
    //   3365: invokespecial <init> : ()V
    //   3368: ldc_w '§'
    //   3371: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3374: aload #10
    //   3376: getfield killerName : Ljava/lang/String;
    //   3379: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3382: ldc_w '     §'
    //   3385: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3388: aload #10
    //   3390: getfield killedName : Ljava/lang/String;
    //   3393: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3396: invokevirtual toString : ()Ljava/lang/String;
    //   3399: iload #5
    //   3401: aload_2
    //   3402: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3405: new java/lang/StringBuilder
    //   3408: dup
    //   3409: invokespecial <init> : ()V
    //   3412: aload #10
    //   3414: getfield killerName : Ljava/lang/String;
    //   3417: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3420: ldc_w '     '
    //   3423: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3426: aload #10
    //   3428: getfield killedName : Ljava/lang/String;
    //   3431: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3434: invokevirtual toString : ()Ljava/lang/String;
    //   3437: invokevirtual func_78256_a : (Ljava/lang/String;)I
    //   3440: isub
    //   3441: bipush #6
    //   3443: isub
    //   3444: iload #6
    //   3446: bipush #32
    //   3448: isub
    //   3449: aload #10
    //   3451: getfield line : I
    //   3454: bipush #16
    //   3456: imul
    //   3457: isub
    //   3458: ldc_w 16777215
    //   3461: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   3464: pop
    //   3465: goto -> 3335
    //   3468: getstatic com/flansmod/client/TickHandlerClient.killMessagesDumb : Ljava/util/List;
    //   3471: invokeinterface iterator : ()Ljava/util/Iterator;
    //   3476: astore #9
    //   3478: aload #9
    //   3480: invokeinterface hasNext : ()Z
    //   3485: ifeq -> 3611
    //   3488: aload #9
    //   3490: invokeinterface next : ()Ljava/lang/Object;
    //   3495: checkcast com/flansmod/client/TickHandlerClient$KillMessageDumb
    //   3498: astore #10
    //   3500: aload_2
    //   3501: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3504: new java/lang/StringBuilder
    //   3507: dup
    //   3508: invokespecial <init> : ()V
    //   3511: ldc_w '§'
    //   3514: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3517: aload #10
    //   3519: getfield killerName : Ljava/lang/String;
    //   3522: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3525: ldc_w '  somehow  killed  §'
    //   3528: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3531: aload #10
    //   3533: getfield killedName : Ljava/lang/String;
    //   3536: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3539: invokevirtual toString : ()Ljava/lang/String;
    //   3542: iload #5
    //   3544: aload_2
    //   3545: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3548: new java/lang/StringBuilder
    //   3551: dup
    //   3552: invokespecial <init> : ()V
    //   3555: aload #10
    //   3557: getfield killerName : Ljava/lang/String;
    //   3560: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3563: ldc_w '  somehow  killed  '
    //   3566: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3569: aload #10
    //   3571: getfield killedName : Ljava/lang/String;
    //   3574: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3577: invokevirtual toString : ()Ljava/lang/String;
    //   3580: invokevirtual func_78256_a : (Ljava/lang/String;)I
    //   3583: isub
    //   3584: bipush #6
    //   3586: isub
    //   3587: iload #6
    //   3589: bipush #32
    //   3591: isub
    //   3592: aload #10
    //   3594: getfield line : I
    //   3597: bipush #16
    //   3599: imul
    //   3600: isub
    //   3601: ldc_w 16777215
    //   3604: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   3607: pop
    //   3608: goto -> 3478
    //   3611: invokestatic func_74520_c : ()V
    //   3614: fconst_1
    //   3615: fconst_1
    //   3616: fconst_1
    //   3617: fconst_1
    //   3618: invokestatic glColor4f : (FFFF)V
    //   3621: ldc_w 32826
    //   3624: invokestatic glEnable : (I)V
    //   3627: getstatic net/minecraft/client/renderer/OpenGlHelper.field_77476_b : I
    //   3630: ldc_w 240.0
    //   3633: ldc_w 240.0
    //   3636: invokestatic func_77475_a : (IFF)V
    //   3639: getstatic com/flansmod/client/TickHandlerClient.killMessages : Ljava/util/List;
    //   3642: invokeinterface iterator : ()Ljava/util/Iterator;
    //   3647: astore #9
    //   3649: aload #9
    //   3651: invokeinterface hasNext : ()Z
    //   3656: ifeq -> 3748
    //   3659: aload #9
    //   3661: invokeinterface next : ()Ljava/lang/Object;
    //   3666: checkcast com/flansmod/client/TickHandlerClient$KillMessage
    //   3669: astore #10
    //   3671: aload_0
    //   3672: aload_2
    //   3673: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3676: new net/minecraft/item/ItemStack
    //   3679: dup
    //   3680: aload #10
    //   3682: getfield weapon : Lcom/flansmod/common/types/InfoType;
    //   3685: getfield item : Lnet/minecraft/item/Item;
    //   3688: invokespecial <init> : (Lnet/minecraft/item/Item;)V
    //   3691: iload #5
    //   3693: aload_2
    //   3694: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   3697: new java/lang/StringBuilder
    //   3700: dup
    //   3701: invokespecial <init> : ()V
    //   3704: ldc_w '     '
    //   3707: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3710: aload #10
    //   3712: getfield killedName : Ljava/lang/String;
    //   3715: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3718: invokevirtual toString : ()Ljava/lang/String;
    //   3721: invokevirtual func_78256_a : (Ljava/lang/String;)I
    //   3724: isub
    //   3725: bipush #12
    //   3727: isub
    //   3728: iload #6
    //   3730: bipush #36
    //   3732: isub
    //   3733: aload #10
    //   3735: getfield line : I
    //   3738: bipush #16
    //   3740: imul
    //   3741: isub
    //   3742: invokespecial drawSlotInventory : (Lnet/minecraft/client/gui/FontRenderer;Lnet/minecraft/item/ItemStack;II)V
    //   3745: goto -> 3649
    //   3748: sipush #3042
    //   3751: invokestatic glDisable : (I)V
    //   3754: invokestatic func_74518_a : ()V
    //   3757: aload_2
    //   3758: getfield field_71446_o : Lnet/minecraft/client/renderer/texture/TextureManager;
    //   3761: getstatic com/flansmod/client/TickHandlerClient.offHand : Lnet/minecraft/util/ResourceLocation;
    //   3764: invokevirtual func_110577_a : (Lnet/minecraft/util/ResourceLocation;)V
    //   3767: aload_2
    //   3768: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   3771: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
    //   3774: invokevirtual func_70448_g : ()Lnet/minecraft/item/ItemStack;
    //   3777: astore #9
    //   3779: aload_2
    //   3780: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   3783: getstatic cpw/mods/fml/relauncher/Side.CLIENT : Lcpw/mods/fml/relauncher/Side;
    //   3786: invokestatic getPlayerData : (Lnet/minecraft/entity/player/EntityPlayer;Lcpw/mods/fml/relauncher/Side;)Lcom/flansmod/common/PlayerData;
    //   3789: astore #10
    //   3791: aload #9
    //   3793: ifnull -> 4149
    //   3796: aload #9
    //   3798: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   3801: instanceof com/flansmod/common/guns/ItemGun
    //   3804: ifeq -> 4149
    //   3807: aload #9
    //   3809: invokevirtual func_77973_b : ()Lnet/minecraft/item/Item;
    //   3812: checkcast com/flansmod/common/guns/ItemGun
    //   3815: getfield type : Lcom/flansmod/common/guns/GunType;
    //   3818: getfield oneHanded : Z
    //   3821: ifeq -> 4149
    //   3824: iconst_0
    //   3825: istore #11
    //   3827: iload #11
    //   3829: bipush #9
    //   3831: if_icmpge -> 4149
    //   3834: aload #10
    //   3836: getfield offHandGunSlot : I
    //   3839: iload #11
    //   3841: iconst_1
    //   3842: iadd
    //   3843: if_icmpne -> 3990
    //   3846: aload #7
    //   3848: invokevirtual func_78382_b : ()V
    //   3851: aload #7
    //   3853: iload #5
    //   3855: iconst_2
    //   3856: idiv
    //   3857: bipush #88
    //   3859: isub
    //   3860: bipush #20
    //   3862: iload #11
    //   3864: imul
    //   3865: iadd
    //   3866: i2d
    //   3867: iload #6
    //   3869: iconst_3
    //   3870: isub
    //   3871: i2d
    //   3872: ldc2_w -90.0
    //   3875: ldc2_w 0.25
    //   3878: ldc2_w 0.5
    //   3881: invokevirtual func_78374_a : (DDDDD)V
    //   3884: aload #7
    //   3886: iload #5
    //   3888: iconst_2
    //   3889: idiv
    //   3890: bipush #72
    //   3892: isub
    //   3893: bipush #20
    //   3895: iload #11
    //   3897: imul
    //   3898: iadd
    //   3899: i2d
    //   3900: iload #6
    //   3902: iconst_3
    //   3903: isub
    //   3904: i2d
    //   3905: ldc2_w -90.0
    //   3908: ldc2_w 0.5
    //   3911: ldc2_w 0.5
    //   3914: invokevirtual func_78374_a : (DDDDD)V
    //   3917: aload #7
    //   3919: iload #5
    //   3921: iconst_2
    //   3922: idiv
    //   3923: bipush #72
    //   3925: isub
    //   3926: bipush #20
    //   3928: iload #11
    //   3930: imul
    //   3931: iadd
    //   3932: i2d
    //   3933: iload #6
    //   3935: bipush #19
    //   3937: isub
    //   3938: i2d
    //   3939: ldc2_w -90.0
    //   3942: ldc2_w 0.5
    //   3945: dconst_0
    //   3946: invokevirtual func_78374_a : (DDDDD)V
    //   3949: aload #7
    //   3951: iload #5
    //   3953: iconst_2
    //   3954: idiv
    //   3955: bipush #88
    //   3957: isub
    //   3958: bipush #20
    //   3960: iload #11
    //   3962: imul
    //   3963: iadd
    //   3964: i2d
    //   3965: iload #6
    //   3967: bipush #19
    //   3969: isub
    //   3970: i2d
    //   3971: ldc2_w -90.0
    //   3974: ldc2_w 0.25
    //   3977: dconst_0
    //   3978: invokevirtual func_78374_a : (DDDDD)V
    //   3981: aload #7
    //   3983: invokevirtual func_78381_a : ()I
    //   3986: pop
    //   3987: goto -> 4143
    //   3990: aload #10
    //   3992: aload_2
    //   3993: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   3996: iload #11
    //   3998: iconst_1
    //   3999: iadd
    //   4000: invokevirtual isValidOffHandWeapon : (Lnet/minecraft/entity/player/EntityPlayer;I)Z
    //   4003: ifeq -> 4143
    //   4006: aload #7
    //   4008: invokevirtual func_78382_b : ()V
    //   4011: aload #7
    //   4013: iload #5
    //   4015: iconst_2
    //   4016: idiv
    //   4017: bipush #88
    //   4019: isub
    //   4020: bipush #20
    //   4022: iload #11
    //   4024: imul
    //   4025: iadd
    //   4026: i2d
    //   4027: iload #6
    //   4029: iconst_3
    //   4030: isub
    //   4031: i2d
    //   4032: ldc2_w -90.0
    //   4035: dconst_0
    //   4036: ldc2_w 0.5
    //   4039: invokevirtual func_78374_a : (DDDDD)V
    //   4042: aload #7
    //   4044: iload #5
    //   4046: iconst_2
    //   4047: idiv
    //   4048: bipush #72
    //   4050: isub
    //   4051: bipush #20
    //   4053: iload #11
    //   4055: imul
    //   4056: iadd
    //   4057: i2d
    //   4058: iload #6
    //   4060: iconst_3
    //   4061: isub
    //   4062: i2d
    //   4063: ldc2_w -90.0
    //   4066: ldc2_w 0.25
    //   4069: ldc2_w 0.5
    //   4072: invokevirtual func_78374_a : (DDDDD)V
    //   4075: aload #7
    //   4077: iload #5
    //   4079: iconst_2
    //   4080: idiv
    //   4081: bipush #72
    //   4083: isub
    //   4084: bipush #20
    //   4086: iload #11
    //   4088: imul
    //   4089: iadd
    //   4090: i2d
    //   4091: iload #6
    //   4093: bipush #19
    //   4095: isub
    //   4096: i2d
    //   4097: ldc2_w -90.0
    //   4100: ldc2_w 0.25
    //   4103: dconst_0
    //   4104: invokevirtual func_78374_a : (DDDDD)V
    //   4107: aload #7
    //   4109: iload #5
    //   4111: iconst_2
    //   4112: idiv
    //   4113: bipush #88
    //   4115: isub
    //   4116: bipush #20
    //   4118: iload #11
    //   4120: imul
    //   4121: iadd
    //   4122: i2d
    //   4123: iload #6
    //   4125: bipush #19
    //   4127: isub
    //   4128: i2d
    //   4129: ldc2_w -90.0
    //   4132: dconst_0
    //   4133: dconst_0
    //   4134: invokevirtual func_78374_a : (DDDDD)V
    //   4137: aload #7
    //   4139: invokevirtual func_78381_a : ()I
    //   4142: pop
    //   4143: iinc #11, 1
    //   4146: goto -> 3827
    //   4149: invokestatic func_71410_x : ()Lnet/minecraft/client/Minecraft;
    //   4152: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   4155: astore #11
    //   4157: aload #11
    //   4159: invokevirtual func_71045_bC : ()Lnet/minecraft/item/ItemStack;
    //   4162: astore #12
    //   4164: aload_2
    //   4165: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   4168: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   4171: instanceof com/flansmod/common/driveables/EntitySeat
    //   4174: ifeq -> 4458
    //   4177: aload_2
    //   4178: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   4181: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   4184: checkcast com/flansmod/common/driveables/EntitySeat
    //   4187: getfield seatInfo : Lcom/flansmod/common/driveables/Seat;
    //   4190: getfield heliGuiSeat : Z
    //   4193: ifeq -> 4458
    //   4196: aload_2
    //   4197: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   4200: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   4203: checkcast com/flansmod/common/driveables/EntitySeat
    //   4206: getfield driveable : Lcom/flansmod/common/driveables/EntityDriveable;
    //   4209: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   4212: getfield heliGUI : Ljava/lang/String;
    //   4215: astore #13
    //   4217: aload #13
    //   4219: ifnull -> 4455
    //   4222: getstatic com/flansmod/client/FlansModClient.minecraft : Lnet/minecraft/client/Minecraft;
    //   4225: getfield field_71460_t : Lnet/minecraft/client/renderer/EntityRenderer;
    //   4228: invokevirtual func_78478_c : ()V
    //   4231: sipush #3042
    //   4234: invokestatic glEnable : (I)V
    //   4237: sipush #2929
    //   4240: invokestatic glDisable : (I)V
    //   4243: iconst_0
    //   4244: invokestatic glDepthMask : (Z)V
    //   4247: sipush #770
    //   4250: sipush #771
    //   4253: invokestatic glBlendFunc : (II)V
    //   4256: fconst_1
    //   4257: fconst_1
    //   4258: fconst_1
    //   4259: fconst_1
    //   4260: invokestatic glColor4f : (FFFF)V
    //   4263: sipush #3008
    //   4266: invokestatic glDisable : (I)V
    //   4269: aload_2
    //   4270: getfield field_71446_o : Lnet/minecraft/client/renderer/texture/TextureManager;
    //   4273: aload #13
    //   4275: invokestatic getScope : (Ljava/lang/String;)Lnet/minecraft/util/ResourceLocation;
    //   4278: invokevirtual func_110577_a : (Lnet/minecraft/util/ResourceLocation;)V
    //   4281: aload #7
    //   4283: invokevirtual func_78382_b : ()V
    //   4286: aload #7
    //   4288: iload #5
    //   4290: iconst_2
    //   4291: idiv
    //   4292: iconst_2
    //   4293: iload #6
    //   4295: imul
    //   4296: isub
    //   4297: i2d
    //   4298: iload #6
    //   4300: i2d
    //   4301: ldc2_w -90.0
    //   4304: dconst_0
    //   4305: dconst_1
    //   4306: invokevirtual func_78374_a : (DDDDD)V
    //   4309: aload #7
    //   4311: iload #5
    //   4313: iconst_2
    //   4314: idiv
    //   4315: iconst_2
    //   4316: iload #6
    //   4318: imul
    //   4319: iadd
    //   4320: i2d
    //   4321: iload #6
    //   4323: i2d
    //   4324: ldc2_w -90.0
    //   4327: dconst_1
    //   4328: dconst_1
    //   4329: invokevirtual func_78374_a : (DDDDD)V
    //   4332: aload #7
    //   4334: iload #5
    //   4336: iconst_2
    //   4337: idiv
    //   4338: iconst_2
    //   4339: iload #6
    //   4341: imul
    //   4342: iadd
    //   4343: i2d
    //   4344: dconst_0
    //   4345: ldc2_w -90.0
    //   4348: dconst_1
    //   4349: dconst_0
    //   4350: invokevirtual func_78374_a : (DDDDD)V
    //   4353: aload #7
    //   4355: iload #5
    //   4357: iconst_2
    //   4358: idiv
    //   4359: iconst_2
    //   4360: iload #6
    //   4362: imul
    //   4363: isub
    //   4364: i2d
    //   4365: dconst_0
    //   4366: ldc2_w -90.0
    //   4369: dconst_0
    //   4370: dconst_0
    //   4371: invokevirtual func_78374_a : (DDDDD)V
    //   4374: aload #7
    //   4376: invokevirtual func_78381_a : ()I
    //   4379: pop
    //   4380: iconst_1
    //   4381: invokestatic glDepthMask : (Z)V
    //   4384: sipush #2929
    //   4387: invokestatic glEnable : (I)V
    //   4390: sipush #3008
    //   4393: invokestatic glEnable : (I)V
    //   4396: fconst_1
    //   4397: fconst_1
    //   4398: fconst_1
    //   4399: fconst_1
    //   4400: invokestatic glColor4f : (FFFF)V
    //   4403: ldc net/minecraft/client/renderer/EntityRenderer
    //   4405: invokestatic instance : ()Lcpw/mods/fml/client/FMLClientHandler;
    //   4408: invokevirtual getClient : ()Lnet/minecraft/client/Minecraft;
    //   4411: getfield field_71460_t : Lnet/minecraft/client/renderer/EntityRenderer;
    //   4414: aload_2
    //   4415: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   4418: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   4421: checkcast com/flansmod/common/driveables/EntitySeat
    //   4424: getfield seatInfo : Lcom/flansmod/common/driveables/Seat;
    //   4427: getfield passengerZoom : F
    //   4430: invokestatic valueOf : (F)Ljava/lang/Float;
    //   4433: iconst_3
    //   4434: anewarray java/lang/String
    //   4437: dup
    //   4438: iconst_0
    //   4439: ldc 'cameraZoom'
    //   4441: aastore
    //   4442: dup
    //   4443: iconst_1
    //   4444: ldc 'af'
    //   4446: aastore
    //   4447: dup
    //   4448: iconst_2
    //   4449: ldc 'field_78503_V'
    //   4451: aastore
    //   4452: invokestatic setPrivateValue : (Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/String;)V
    //   4455: goto -> 4527
    //   4458: aload_2
    //   4459: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   4462: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   4465: instanceof com/flansmod/common/driveables/EntitySeat
    //   4468: ifeq -> 4527
    //   4471: aload_2
    //   4472: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   4475: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   4478: checkcast com/flansmod/common/driveables/EntitySeat
    //   4481: getfield seatInfo : Lcom/flansmod/common/driveables/Seat;
    //   4484: getfield heliGuiSeat : Z
    //   4487: ifne -> 4527
    //   4490: ldc net/minecraft/client/renderer/EntityRenderer
    //   4492: invokestatic instance : ()Lcpw/mods/fml/client/FMLClientHandler;
    //   4495: invokevirtual getClient : ()Lnet/minecraft/client/Minecraft;
    //   4498: getfield field_71460_t : Lnet/minecraft/client/renderer/EntityRenderer;
    //   4501: iconst_1
    //   4502: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   4505: iconst_3
    //   4506: anewarray java/lang/String
    //   4509: dup
    //   4510: iconst_0
    //   4511: ldc 'cameraZoom'
    //   4513: aastore
    //   4514: dup
    //   4515: iconst_1
    //   4516: ldc 'af'
    //   4518: aastore
    //   4519: dup
    //   4520: iconst_2
    //   4521: ldc 'field_78503_V'
    //   4523: aastore
    //   4524: invokestatic setPrivateValue : (Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/String;)V
    //   4527: aload_2
    //   4528: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   4531: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   4534: instanceof com/flansmod/common/driveables/EntitySeat
    //   4537: ifeq -> 11056
    //   4540: aload_2
    //   4541: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   4544: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   4547: checkcast com/flansmod/common/driveables/EntitySeat
    //   4550: getfield driveable : Lcom/flansmod/common/driveables/EntityDriveable;
    //   4553: astore #13
    //   4555: aload #13
    //   4557: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   4560: invokevirtual getXAxis : ()Lcom/flansmod/common/vector/Vector3f;
    //   4563: invokevirtual normalise : ()Lcom/flansmod/common/vector/Vector;
    //   4566: checkcast com/flansmod/common/vector/Vector3f
    //   4569: astore #14
    //   4571: aload #14
    //   4573: getfield x : F
    //   4576: aload #13
    //   4578: getfield field_70159_w : D
    //   4581: d2f
    //   4582: fmul
    //   4583: aload #14
    //   4585: getfield x : F
    //   4588: aload #13
    //   4590: getfield field_70159_w : D
    //   4593: d2f
    //   4594: fmul
    //   4595: fmul
    //   4596: aload #14
    //   4598: getfield y : F
    //   4601: aload #13
    //   4603: getfield field_70181_x : D
    //   4606: d2f
    //   4607: fmul
    //   4608: aload #14
    //   4610: getfield y : F
    //   4613: aload #13
    //   4615: getfield field_70181_x : D
    //   4618: d2f
    //   4619: fmul
    //   4620: fmul
    //   4621: fadd
    //   4622: aload #14
    //   4624: getfield z : F
    //   4627: aload #13
    //   4629: getfield field_70179_y : D
    //   4632: d2f
    //   4633: fmul
    //   4634: aload #14
    //   4636: getfield z : F
    //   4639: aload #13
    //   4641: getfield field_70179_y : D
    //   4644: d2f
    //   4645: fmul
    //   4646: fmul
    //   4647: fadd
    //   4648: fstore #15
    //   4650: fload #15
    //   4652: f2d
    //   4653: invokestatic sqrt : (D)D
    //   4656: d2f
    //   4657: fstore #16
    //   4659: fconst_1
    //   4660: fstore #17
    //   4662: fconst_0
    //   4663: fstore #18
    //   4665: fload #16
    //   4667: fload #17
    //   4669: fmul
    //   4670: f2d
    //   4671: ldc2_w 1.05
    //   4674: dcmpl
    //   4675: iflt -> 4727
    //   4678: aload #13
    //   4680: getfield field_70159_w : D
    //   4683: invokestatic abs : (D)D
    //   4686: ldc2_w 0.2
    //   4689: dcmpl
    //   4690: ifgt -> 4708
    //   4693: aload #13
    //   4695: getfield field_70179_y : D
    //   4698: invokestatic abs : (D)D
    //   4701: ldc2_w 0.2
    //   4704: dcmpl
    //   4705: ifle -> 4727
    //   4708: ldc_w 1572.6646
    //   4711: fload #16
    //   4713: fload #17
    //   4715: fmul
    //   4716: f2d
    //   4717: invokestatic log : (D)D
    //   4720: d2f
    //   4721: fmul
    //   4722: fstore #18
    //   4724: goto -> 4782
    //   4727: aload #13
    //   4729: getfield field_70159_w : D
    //   4732: invokestatic abs : (D)D
    //   4735: ldc2_w 0.2
    //   4738: dcmpl
    //   4739: ifgt -> 4757
    //   4742: aload #13
    //   4744: getfield field_70179_y : D
    //   4747: invokestatic abs : (D)D
    //   4750: ldc2_w 0.2
    //   4753: dcmpl
    //   4754: ifle -> 4779
    //   4757: dconst_0
    //   4758: fload #15
    //   4760: f2d
    //   4761: invokestatic sqrt : (D)D
    //   4764: fload #17
    //   4766: f2d
    //   4767: dmul
    //   4768: ldc2_w 74.0
    //   4771: dmul
    //   4772: dadd
    //   4773: d2f
    //   4774: fstore #18
    //   4776: goto -> 4782
    //   4779: fconst_0
    //   4780: fstore #18
    //   4782: aload #13
    //   4784: instanceof com/flansmod/common/driveables/EntityPlane
    //   4787: ifeq -> 4821
    //   4790: aload #13
    //   4792: checkcast com/flansmod/common/driveables/EntityPlane
    //   4795: astore #19
    //   4797: aload #19
    //   4799: getfield control : Lcom/flansmod/common/driveables/FlightController;
    //   4802: ifnull -> 4821
    //   4805: aload #19
    //   4807: getfield control : Lcom/flansmod/common/driveables/FlightController;
    //   4810: getfield V : F
    //   4813: f2d
    //   4814: ldc2_w 2.23694
    //   4817: dmul
    //   4818: d2f
    //   4819: fstore #18
    //   4821: aload #13
    //   4823: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   4826: getfield parts : Ljava/util/HashMap;
    //   4829: getstatic com/flansmod/common/driveables/EnumDriveablePart.core : Lcom/flansmod/common/driveables/EnumDriveablePart;
    //   4832: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4835: checkcast com/flansmod/common/driveables/DriveablePart
    //   4838: getfield health : I
    //   4841: i2f
    //   4842: aload #13
    //   4844: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   4847: getfield parts : Ljava/util/HashMap;
    //   4850: getstatic com/flansmod/common/driveables/EnumDriveablePart.core : Lcom/flansmod/common/driveables/EnumDriveablePart;
    //   4853: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4856: checkcast com/flansmod/common/driveables/DriveablePart
    //   4859: getfield maxHealth : I
    //   4862: i2f
    //   4863: fdiv
    //   4864: ldc_w 100.0
    //   4867: fmul
    //   4868: f2i
    //   4869: istore #19
    //   4871: iconst_0
    //   4872: istore #20
    //   4874: iload #19
    //   4876: bipush #75
    //   4878: if_icmple -> 4889
    //   4881: ldc_w 16777215
    //   4884: istore #20
    //   4886: goto -> 4938
    //   4889: iload #19
    //   4891: bipush #75
    //   4893: if_icmpge -> 4911
    //   4896: iload #19
    //   4898: bipush #50
    //   4900: if_icmple -> 4911
    //   4903: ldc_w 65280
    //   4906: istore #20
    //   4908: goto -> 4938
    //   4911: iload #19
    //   4913: bipush #50
    //   4915: if_icmpge -> 4933
    //   4918: iload #19
    //   4920: bipush #25
    //   4922: if_icmple -> 4933
    //   4925: ldc_w 14329120
    //   4928: istore #20
    //   4930: goto -> 4938
    //   4933: ldc_w 16711680
    //   4936: istore #20
    //   4938: aload #13
    //   4940: getfield throttle : F
    //   4943: fstore #21
    //   4945: iconst_0
    //   4946: istore #22
    //   4948: aload #13
    //   4950: getfield throttle : F
    //   4953: f2d
    //   4954: ldc2_w 0.5
    //   4957: dcmpg
    //   4958: ifge -> 4977
    //   4961: aload #13
    //   4963: getfield afterBurning : Z
    //   4966: ifeq -> 4977
    //   4969: ldc_w 16777215
    //   4972: istore #22
    //   4974: goto -> 5095
    //   4977: aload #13
    //   4979: getfield throttle : F
    //   4982: f2d
    //   4983: ldc2_w 0.7
    //   4986: dcmpg
    //   4987: ifge -> 5019
    //   4990: aload #13
    //   4992: getfield throttle : F
    //   4995: f2d
    //   4996: ldc2_w 0.5
    //   4999: dcmpl
    //   5000: ifle -> 5019
    //   5003: aload #13
    //   5005: getfield afterBurning : Z
    //   5008: ifeq -> 5019
    //   5011: ldc_w 65280
    //   5014: istore #22
    //   5016: goto -> 5095
    //   5019: aload #13
    //   5021: getfield throttle : F
    //   5024: f2d
    //   5025: ldc2_w 0.9
    //   5028: dcmpg
    //   5029: ifge -> 5061
    //   5032: aload #13
    //   5034: getfield throttle : F
    //   5037: f2d
    //   5038: ldc2_w 0.7
    //   5041: dcmpl
    //   5042: ifle -> 5061
    //   5045: aload #13
    //   5047: getfield afterBurning : Z
    //   5050: ifeq -> 5061
    //   5053: ldc_w 14329120
    //   5056: istore #22
    //   5058: goto -> 5095
    //   5061: aload #13
    //   5063: getfield throttle : F
    //   5066: f2d
    //   5067: ldc2_w 0.9
    //   5070: dcmpl
    //   5071: ifle -> 5090
    //   5074: aload #13
    //   5076: getfield afterBurning : Z
    //   5079: ifeq -> 5090
    //   5082: ldc_w 16711680
    //   5085: istore #22
    //   5087: goto -> 5095
    //   5090: ldc_w 16777215
    //   5093: istore #22
    //   5095: aload #13
    //   5097: getfield throttle : F
    //   5100: invokestatic abs : (F)F
    //   5103: f2d
    //   5104: ldc2_w 0.5
    //   5107: dcmpl
    //   5108: ifle -> 5122
    //   5111: aload #13
    //   5113: getfield throttle : F
    //   5116: ldc_w 1.075
    //   5119: fmul
    //   5120: fstore #21
    //   5122: fload #21
    //   5124: fconst_1
    //   5125: fcmpl
    //   5126: ifle -> 5132
    //   5129: fconst_1
    //   5130: fstore #21
    //   5132: fload #21
    //   5134: ldc_w -1.0
    //   5137: fcmpg
    //   5138: ifge -> 5146
    //   5141: ldc_w -1.0
    //   5144: fstore #21
    //   5146: aload #13
    //   5148: instanceof com/flansmod/common/driveables/mechas/EntityMecha
    //   5151: ifne -> 5564
    //   5154: aload #13
    //   5156: getfield aiming : Z
    //   5159: ifne -> 5564
    //   5162: aload #13
    //   5164: instanceof com/flansmod/common/driveables/EntityPlane
    //   5167: ifne -> 5207
    //   5170: aload_2
    //   5171: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   5174: ldc_w 'Throttle : %.0f%%'
    //   5177: iconst_1
    //   5178: anewarray java/lang/Object
    //   5181: dup
    //   5182: iconst_0
    //   5183: fload #21
    //   5185: ldc_w 100.0
    //   5188: fmul
    //   5189: invokestatic valueOf : (F)Ljava/lang/Float;
    //   5192: aastore
    //   5193: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5196: iconst_2
    //   5197: iconst_2
    //   5198: iload #22
    //   5200: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   5203: pop
    //   5204: goto -> 5564
    //   5207: aload #13
    //   5209: instanceof com/flansmod/common/driveables/EntityPlane
    //   5212: ifeq -> 5564
    //   5215: aload #13
    //   5217: checkcast com/flansmod/common/driveables/EntityPlane
    //   5220: astore #23
    //   5222: aload #23
    //   5224: getfield driveableData : Lcom/flansmod/common/driveables/DriveableData;
    //   5227: getfield landBrake : I
    //   5230: iconst_5
    //   5231: if_icmple -> 5257
    //   5234: aload #23
    //   5236: getfield varFlap : Z
    //   5239: ifne -> 5257
    //   5242: aload_2
    //   5243: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   5246: ldc_w 'Throttle : BRK'
    //   5249: iconst_2
    //   5250: iconst_2
    //   5251: iload #22
    //   5253: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   5256: pop
    //   5257: fload #18
    //   5259: f2d
    //   5260: ldc2_w 0.1
    //   5263: dcmpl
    //   5264: ifgt -> 5277
    //   5267: fload #18
    //   5269: f2d
    //   5270: ldc2_w -0.1
    //   5273: dcmpg
    //   5274: ifge -> 5328
    //   5277: aload_2
    //   5278: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   5281: new java/lang/StringBuilder
    //   5284: dup
    //   5285: invokespecial <init> : ()V
    //   5288: ldc_w 'Speed : %.0f'
    //   5291: iconst_1
    //   5292: anewarray java/lang/Object
    //   5295: dup
    //   5296: iconst_0
    //   5297: fload #18
    //   5299: invokestatic valueOf : (F)Ljava/lang/Float;
    //   5302: aastore
    //   5303: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5306: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5309: ldc_w 'mph'
    //   5312: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5315: invokevirtual toString : ()Ljava/lang/String;
    //   5318: iconst_2
    //   5319: bipush #22
    //   5321: ldc_w 16777215
    //   5324: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   5327: pop
    //   5328: fload #18
    //   5330: ldc_w 767.0
    //   5333: fdiv
    //   5334: fconst_1
    //   5335: fcmpl
    //   5336: ifle -> 5378
    //   5339: aload_2
    //   5340: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   5343: ldc_w 'Mach %.1f'
    //   5346: iconst_1
    //   5347: anewarray java/lang/Object
    //   5350: dup
    //   5351: iconst_0
    //   5352: fload #18
    //   5354: ldc_w 767.0
    //   5357: fdiv
    //   5358: invokestatic valueOf : (F)Ljava/lang/Float;
    //   5361: aastore
    //   5362: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5365: iconst_2
    //   5366: bipush #32
    //   5368: ldc_w 16777215
    //   5371: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   5374: pop
    //   5375: goto -> 5495
    //   5378: aload #23
    //   5380: getfield driveableData : Lcom/flansmod/common/driveables/DriveableData;
    //   5383: getfield landBrake : I
    //   5386: iconst_5
    //   5387: if_icmple -> 5416
    //   5390: aload #23
    //   5392: getfield varFlap : Z
    //   5395: ifeq -> 5416
    //   5398: aload_2
    //   5399: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   5402: ldc_w 'Throttle : BRK - flaps'
    //   5405: iconst_2
    //   5406: iconst_2
    //   5407: iload #22
    //   5409: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   5412: pop
    //   5413: goto -> 5495
    //   5416: aload #23
    //   5418: getfield varFlap : Z
    //   5421: ifeq -> 5461
    //   5424: aload_2
    //   5425: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   5428: ldc_w 'Throttle : %.0f%% - flaps'
    //   5431: iconst_1
    //   5432: anewarray java/lang/Object
    //   5435: dup
    //   5436: iconst_0
    //   5437: fload #21
    //   5439: ldc_w 100.0
    //   5442: fmul
    //   5443: invokestatic valueOf : (F)Ljava/lang/Float;
    //   5446: aastore
    //   5447: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5450: iconst_2
    //   5451: iconst_2
    //   5452: iload #22
    //   5454: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   5457: pop
    //   5458: goto -> 5495
    //   5461: aload_2
    //   5462: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   5465: ldc_w 'Throttle : %.0f%%'
    //   5468: iconst_1
    //   5469: anewarray java/lang/Object
    //   5472: dup
    //   5473: iconst_0
    //   5474: fload #21
    //   5476: ldc_w 100.0
    //   5479: fmul
    //   5480: invokestatic valueOf : (F)Ljava/lang/Float;
    //   5483: aastore
    //   5484: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5487: iconst_2
    //   5488: iconst_2
    //   5489: iload #22
    //   5491: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   5494: pop
    //   5495: aload #23
    //   5497: getfield driveableData : Lcom/flansmod/common/driveables/DriveableData;
    //   5500: getfield carrierTip : I
    //   5503: ifle -> 5564
    //   5506: aload #13
    //   5508: getfield mounted : Z
    //   5511: ifne -> 5564
    //   5514: aload_2
    //   5515: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   5518: new java/lang/StringBuilder
    //   5521: dup
    //   5522: invokespecial <init> : ()V
    //   5525: ldc_w 'Press '
    //   5528: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5531: getstatic com/flansmod/client/KeyInputHandler.bombKey : Lnet/minecraft/client/settings/KeyBinding;
    //   5534: invokevirtual func_151463_i : ()I
    //   5537: invokestatic getKeyName : (I)Ljava/lang/String;
    //   5540: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5543: ldc_w ' to dock'
    //   5546: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5549: invokevirtual toString : ()Ljava/lang/String;
    //   5552: sipush #172
    //   5555: bipush #62
    //   5557: ldc_w 65280
    //   5560: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   5563: pop
    //   5564: aload #13
    //   5566: instanceof com/flansmod/common/driveables/mechas/EntityMecha
    //   5569: ifeq -> 5635
    //   5572: aload #13
    //   5574: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   5577: getfield panicTimer : I
    //   5580: ifgt -> 5635
    //   5583: aload #13
    //   5585: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   5588: getfield morale : I
    //   5591: iconst_1
    //   5592: if_icmple -> 5635
    //   5595: aload_2
    //   5596: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   5599: new java/lang/StringBuilder
    //   5602: dup
    //   5603: invokespecial <init> : ()V
    //   5606: ldc_w 'Morale : '
    //   5609: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5612: aload #13
    //   5614: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   5617: getfield morale : I
    //   5620: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   5623: invokevirtual toString : ()Ljava/lang/String;
    //   5626: iconst_2
    //   5627: iconst_2
    //   5628: ldc_w 16777215
    //   5631: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   5634: pop
    //   5635: aload #13
    //   5637: instanceof com/flansmod/common/driveables/mechas/EntityMecha
    //   5640: ifeq -> 5677
    //   5643: aload #13
    //   5645: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   5648: getfield panicTimer : I
    //   5651: ifle -> 5677
    //   5654: aload_2
    //   5655: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   5658: ldc_w 'CONTROL LOST'
    //   5661: iconst_0
    //   5662: anewarray java/lang/Object
    //   5665: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5668: iconst_2
    //   5669: iconst_2
    //   5670: ldc_w 16711680
    //   5673: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   5676: pop
    //   5677: aload #13
    //   5679: getfield epicShip : Z
    //   5682: ifne -> 5733
    //   5685: aload #13
    //   5687: getfield aiming : Z
    //   5690: ifne -> 5733
    //   5693: aload_2
    //   5694: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   5697: new java/lang/StringBuilder
    //   5700: dup
    //   5701: invokespecial <init> : ()V
    //   5704: ldc_w 'Health : '
    //   5707: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5710: iload #19
    //   5712: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   5715: ldc_w '%'
    //   5718: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5721: invokevirtual toString : ()Ljava/lang/String;
    //   5724: iconst_2
    //   5725: bipush #12
    //   5727: iload #20
    //   5729: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   5732: pop
    //   5733: invokestatic func_71410_x : ()Lnet/minecraft/client/Minecraft;
    //   5736: getfield field_71474_y : Lnet/minecraft/client/settings/GameSettings;
    //   5739: getfield field_74311_E : Lnet/minecraft/client/settings/KeyBinding;
    //   5742: invokevirtual func_151463_i : ()I
    //   5745: invokestatic isKeyDown : (I)Z
    //   5748: ifeq -> 5775
    //   5751: aload_2
    //   5752: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   5755: ldc_w 'EXITING VEHICLE'
    //   5758: iconst_0
    //   5759: anewarray java/lang/Object
    //   5762: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5765: iconst_2
    //   5766: bipush #56
    //   5768: ldc_w 16777215
    //   5771: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   5774: pop
    //   5775: aload #13
    //   5777: getfield epicShip : Z
    //   5780: ifeq -> 6328
    //   5783: aload #13
    //   5785: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   5788: getfield parts : Ljava/util/HashMap;
    //   5791: getstatic com/flansmod/common/driveables/EnumDriveablePart.buoyancy : Lcom/flansmod/common/driveables/EnumDriveablePart;
    //   5794: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   5797: checkcast com/flansmod/common/driveables/DriveablePart
    //   5800: getfield health : I
    //   5803: i2f
    //   5804: aload #13
    //   5806: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   5809: getfield parts : Ljava/util/HashMap;
    //   5812: getstatic com/flansmod/common/driveables/EnumDriveablePart.buoyancy : Lcom/flansmod/common/driveables/EnumDriveablePart;
    //   5815: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   5818: checkcast com/flansmod/common/driveables/DriveablePart
    //   5821: getfield maxHealth : I
    //   5824: i2f
    //   5825: fdiv
    //   5826: ldc_w 100.0
    //   5829: fmul
    //   5830: f2i
    //   5831: istore #23
    //   5833: bipush #100
    //   5835: aload #13
    //   5837: checkcast com/flansmod/common/driveables/EntityVehicle
    //   5840: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   5843: getfield notFlooding : I
    //   5846: imul
    //   5847: i2f
    //   5848: aload #13
    //   5850: checkcast com/flansmod/common/driveables/EntityVehicle
    //   5853: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   5856: getfield notFloodingMax : I
    //   5859: i2f
    //   5860: ldc_w 0.1
    //   5863: fadd
    //   5864: fdiv
    //   5865: fstore #24
    //   5867: iconst_0
    //   5868: istore #25
    //   5870: fload #24
    //   5872: ldc_w 75.0
    //   5875: fcmpl
    //   5876: ifle -> 5887
    //   5879: ldc_w 16777215
    //   5882: istore #25
    //   5884: goto -> 5944
    //   5887: fload #24
    //   5889: ldc_w 75.0
    //   5892: fcmpg
    //   5893: ifge -> 5913
    //   5896: fload #24
    //   5898: ldc_w 50.0
    //   5901: fcmpl
    //   5902: ifle -> 5913
    //   5905: ldc_w 65280
    //   5908: istore #25
    //   5910: goto -> 5944
    //   5913: fload #24
    //   5915: ldc_w 50.0
    //   5918: fcmpg
    //   5919: ifge -> 5939
    //   5922: fload #24
    //   5924: ldc_w 25.0
    //   5927: fcmpl
    //   5928: ifle -> 5939
    //   5931: ldc_w 14329120
    //   5934: istore #25
    //   5936: goto -> 5944
    //   5939: ldc_w 16711680
    //   5942: istore #25
    //   5944: iconst_0
    //   5945: istore #26
    //   5947: fload #24
    //   5949: ldc_w 75.0
    //   5952: fcmpl
    //   5953: ifle -> 5964
    //   5956: ldc_w 16777215
    //   5959: istore #26
    //   5961: goto -> 6013
    //   5964: iload #23
    //   5966: bipush #75
    //   5968: if_icmpge -> 5986
    //   5971: iload #23
    //   5973: bipush #50
    //   5975: if_icmple -> 5986
    //   5978: ldc_w 65280
    //   5981: istore #26
    //   5983: goto -> 6013
    //   5986: iload #23
    //   5988: bipush #50
    //   5990: if_icmpge -> 6008
    //   5993: iload #23
    //   5995: bipush #25
    //   5997: if_icmple -> 6008
    //   6000: ldc_w 14329120
    //   6003: istore #26
    //   6005: goto -> 6013
    //   6008: ldc_w 16711680
    //   6011: istore #26
    //   6013: aload_2
    //   6014: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   6017: new java/lang/StringBuilder
    //   6020: dup
    //   6021: invokespecial <init> : ()V
    //   6024: ldc_w 'Crew : '
    //   6027: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6030: aload #13
    //   6032: checkcast com/flansmod/common/driveables/EntityVehicle
    //   6035: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   6038: getfield totalCrew : I
    //   6041: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   6044: ldc_w '/'
    //   6047: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6050: aload #13
    //   6052: checkcast com/flansmod/common/driveables/EntityVehicle
    //   6055: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   6058: getfield maximumCrew : I
    //   6061: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   6064: invokevirtual toString : ()Ljava/lang/String;
    //   6067: iconst_2
    //   6068: bipush #12
    //   6070: ldc_w 16777215
    //   6073: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   6076: pop
    //   6077: fload #24
    //   6079: ldc_w 100.0
    //   6082: fcmpl
    //   6083: ifne -> 6110
    //   6086: aload_2
    //   6087: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   6090: ldc_w 'Flooding : None'
    //   6093: iconst_0
    //   6094: anewarray java/lang/Object
    //   6097: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6100: iconst_2
    //   6101: bipush #22
    //   6103: ldc_w 16777215
    //   6106: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   6109: pop
    //   6110: fload #24
    //   6112: ldc_w 99.0
    //   6115: fcmpg
    //   6116: ifgt -> 6152
    //   6119: fload #24
    //   6121: ldc_w 75.0
    //   6124: fcmpl
    //   6125: ifle -> 6152
    //   6128: aload_2
    //   6129: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   6132: ldc_w 'Flooding : Minor'
    //   6135: iconst_0
    //   6136: anewarray java/lang/Object
    //   6139: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6142: iconst_2
    //   6143: bipush #22
    //   6145: ldc_w 65280
    //   6148: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   6151: pop
    //   6152: fload #24
    //   6154: ldc_w 75.0
    //   6157: fcmpg
    //   6158: ifgt -> 6194
    //   6161: fload #24
    //   6163: ldc_w 40.0
    //   6166: fcmpl
    //   6167: ifle -> 6194
    //   6170: aload_2
    //   6171: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   6174: ldc_w 'Flooding : Heavy'
    //   6177: iconst_0
    //   6178: anewarray java/lang/Object
    //   6181: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6184: iconst_2
    //   6185: bipush #22
    //   6187: ldc_w 65280
    //   6190: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   6193: pop
    //   6194: fload #24
    //   6196: ldc_w 40.0
    //   6199: fcmpg
    //   6200: ifgt -> 6236
    //   6203: fload #24
    //   6205: ldc_w 10.0
    //   6208: fcmpl
    //   6209: ifle -> 6236
    //   6212: aload_2
    //   6213: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   6216: ldc_w 'Flooding : Severe'
    //   6219: iconst_0
    //   6220: anewarray java/lang/Object
    //   6223: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6226: iconst_2
    //   6227: bipush #22
    //   6229: ldc_w 16711680
    //   6232: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   6235: pop
    //   6236: fload #24
    //   6238: ldc_w 10.0
    //   6241: fcmpg
    //   6242: ifgt -> 6269
    //   6245: aload_2
    //   6246: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   6249: ldc_w 'Abandon Ship'
    //   6252: iconst_0
    //   6253: anewarray java/lang/Object
    //   6256: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6259: iconst_2
    //   6260: bipush #22
    //   6262: ldc_w 16711680
    //   6265: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   6268: pop
    //   6269: aload_2
    //   6270: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   6273: new java/lang/StringBuilder
    //   6276: dup
    //   6277: invokespecial <init> : ()V
    //   6280: ldc_w 'Buoyancy : '
    //   6283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6286: aload #13
    //   6288: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   6291: getfield parts : Ljava/util/HashMap;
    //   6294: getstatic com/flansmod/common/driveables/EnumDriveablePart.buoyancy : Lcom/flansmod/common/driveables/EnumDriveablePart;
    //   6297: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   6300: checkcast com/flansmod/common/driveables/DriveablePart
    //   6303: getfield health : I
    //   6306: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   6309: invokevirtual toString : ()Ljava/lang/String;
    //   6312: iconst_0
    //   6313: anewarray java/lang/Object
    //   6316: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6319: iconst_2
    //   6320: bipush #32
    //   6322: iload #26
    //   6324: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   6327: pop
    //   6328: aload #13
    //   6330: instanceof com/flansmod/common/driveables/EntityPlane
    //   6333: ifne -> 7478
    //   6336: aload #13
    //   6338: getfield aiming : Z
    //   6341: ifne -> 6443
    //   6344: aload_2
    //   6345: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   6348: ldc_w 'Gun Pitch : %.0f%%'
    //   6351: iconst_1
    //   6352: anewarray java/lang/Object
    //   6355: dup
    //   6356: iconst_0
    //   6357: aload_2
    //   6358: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   6361: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   6364: checkcast com/flansmod/common/driveables/EntitySeat
    //   6367: getfield looking : Lcom/flansmod/common/RotatedAxes;
    //   6370: invokevirtual getPitch : ()F
    //   6373: ldc_w -1.0
    //   6376: fmul
    //   6377: invokestatic valueOf : (F)Ljava/lang/Float;
    //   6380: aastore
    //   6381: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6384: sipush #172
    //   6387: bipush #12
    //   6389: ldc_w 16777215
    //   6392: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   6395: pop
    //   6396: aload_2
    //   6397: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   6400: ldc_w 'Yaw : %.0f%%'
    //   6403: iconst_1
    //   6404: anewarray java/lang/Object
    //   6407: dup
    //   6408: iconst_0
    //   6409: aload_2
    //   6410: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   6413: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   6416: checkcast com/flansmod/common/driveables/EntitySeat
    //   6419: getfield looking : Lcom/flansmod/common/RotatedAxes;
    //   6422: invokevirtual getYaw : ()F
    //   6425: invokestatic valueOf : (F)Ljava/lang/Float;
    //   6428: aastore
    //   6429: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   6432: sipush #172
    //   6435: iconst_2
    //   6436: ldc_w 16777215
    //   6439: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   6442: pop
    //   6443: aload_2
    //   6444: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   6447: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   6450: checkcast com/flansmod/common/driveables/EntitySeat
    //   6453: getfield looking : Lcom/flansmod/common/RotatedAxes;
    //   6456: invokevirtual getYaw : ()F
    //   6459: fstore #23
    //   6461: ldc_w 'gui/tankerino.png'
    //   6464: astore #24
    //   6466: fload #23
    //   6468: ldc_w 23.0
    //   6471: fcmpg
    //   6472: ifge -> 6492
    //   6475: fload #23
    //   6477: ldc_w -22.0
    //   6480: fcmpl
    //   6481: iflt -> 6492
    //   6484: ldc_w 'gui/0.png'
    //   6487: astore #24
    //   6489: goto -> 6697
    //   6492: fload #23
    //   6494: ldc_w 68.0
    //   6497: fcmpg
    //   6498: ifge -> 6518
    //   6501: fload #23
    //   6503: ldc_w 23.0
    //   6506: fcmpl
    //   6507: iflt -> 6518
    //   6510: ldc_w 'gui/45.png'
    //   6513: astore #24
    //   6515: goto -> 6697
    //   6518: fload #23
    //   6520: ldc_w 113.0
    //   6523: fcmpg
    //   6524: ifge -> 6544
    //   6527: fload #23
    //   6529: ldc_w 68.0
    //   6532: fcmpl
    //   6533: iflt -> 6544
    //   6536: ldc_w 'gui/90.png'
    //   6539: astore #24
    //   6541: goto -> 6697
    //   6544: fload #23
    //   6546: ldc_w 158.0
    //   6549: fcmpg
    //   6550: ifge -> 6570
    //   6553: fload #23
    //   6555: ldc_w 113.0
    //   6558: fcmpl
    //   6559: iflt -> 6570
    //   6562: ldc_w 'gui/135.png'
    //   6565: astore #24
    //   6567: goto -> 6697
    //   6570: fload #23
    //   6572: ldc_w 203.0
    //   6575: fcmpg
    //   6576: ifge -> 6588
    //   6579: fload #23
    //   6581: ldc_w 158.0
    //   6584: fcmpl
    //   6585: ifge -> 6606
    //   6588: fload #23
    //   6590: ldc_w -180.0
    //   6593: fcmpl
    //   6594: ifle -> 6614
    //   6597: fload #23
    //   6599: ldc_w -158.0
    //   6602: fcmpg
    //   6603: ifge -> 6614
    //   6606: ldc_w 'gui/180.png'
    //   6609: astore #24
    //   6611: goto -> 6697
    //   6614: fload #23
    //   6616: ldc_w -113.0
    //   6619: fcmpg
    //   6620: ifge -> 6640
    //   6623: fload #23
    //   6625: ldc_w -158.0
    //   6628: fcmpl
    //   6629: iflt -> 6640
    //   6632: ldc_w 'gui/225.png'
    //   6635: astore #24
    //   6637: goto -> 6697
    //   6640: fload #23
    //   6642: ldc_w -68.0
    //   6645: fcmpg
    //   6646: ifge -> 6666
    //   6649: fload #23
    //   6651: ldc_w -113.0
    //   6654: fcmpl
    //   6655: iflt -> 6666
    //   6658: ldc_w 'gui/270.png'
    //   6661: astore #24
    //   6663: goto -> 6697
    //   6666: fload #23
    //   6668: ldc_w -23.0
    //   6671: fcmpg
    //   6672: ifge -> 6692
    //   6675: fload #23
    //   6677: ldc_w -68.0
    //   6680: fcmpl
    //   6681: iflt -> 6692
    //   6684: ldc_w 'gui/315.png'
    //   6687: astore #24
    //   6689: goto -> 6697
    //   6692: ldc_w 'gui/0.png'
    //   6695: astore #24
    //   6697: aload #13
    //   6699: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   6702: getfield showTurretIndicator : Z
    //   6705: ifeq -> 6932
    //   6708: getstatic com/flansmod/client/FlansModClient.minecraft : Lnet/minecraft/client/Minecraft;
    //   6711: getfield field_71460_t : Lnet/minecraft/client/renderer/EntityRenderer;
    //   6714: invokevirtual func_78478_c : ()V
    //   6717: sipush #3042
    //   6720: invokestatic glEnable : (I)V
    //   6723: sipush #2929
    //   6726: invokestatic glDisable : (I)V
    //   6729: iconst_0
    //   6730: invokestatic glDepthMask : (Z)V
    //   6733: sipush #770
    //   6736: sipush #771
    //   6739: invokestatic glBlendFunc : (II)V
    //   6742: fconst_1
    //   6743: fconst_1
    //   6744: fconst_1
    //   6745: fconst_1
    //   6746: invokestatic glColor4f : (FFFF)V
    //   6749: sipush #3008
    //   6752: invokestatic glDisable : (I)V
    //   6755: aload_2
    //   6756: getfield field_71446_o : Lnet/minecraft/client/renderer/texture/TextureManager;
    //   6759: new net/minecraft/util/ResourceLocation
    //   6762: dup
    //   6763: ldc_w 'flansmod'
    //   6766: aload #24
    //   6768: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   6771: invokevirtual func_110577_a : (Lnet/minecraft/util/ResourceLocation;)V
    //   6774: aload #7
    //   6776: invokevirtual func_78382_b : ()V
    //   6779: aload #7
    //   6781: iload #5
    //   6783: i2d
    //   6784: ldc2_w 1.35
    //   6787: ddiv
    //   6788: ldc2_w 0.05
    //   6791: iload #6
    //   6793: i2d
    //   6794: dmul
    //   6795: dsub
    //   6796: ldc2_w 1.07
    //   6799: iload #6
    //   6801: i2d
    //   6802: dmul
    //   6803: ldc2_w -90.0
    //   6806: dconst_0
    //   6807: dconst_1
    //   6808: invokevirtual func_78374_a : (DDDDD)V
    //   6811: aload #7
    //   6813: iload #5
    //   6815: i2d
    //   6816: ldc2_w 2.3
    //   6819: ddiv
    //   6820: dconst_1
    //   6821: iload #6
    //   6823: i2d
    //   6824: dmul
    //   6825: dadd
    //   6826: ldc2_w 1.07
    //   6829: iload #6
    //   6831: i2d
    //   6832: dmul
    //   6833: ldc2_w -90.0
    //   6836: dconst_1
    //   6837: dconst_1
    //   6838: invokevirtual func_78374_a : (DDDDD)V
    //   6841: aload #7
    //   6843: iload #5
    //   6845: i2d
    //   6846: ldc2_w 2.3
    //   6849: ddiv
    //   6850: dconst_1
    //   6851: iload #6
    //   6853: i2d
    //   6854: dmul
    //   6855: dadd
    //   6856: ldc2_w 0.7
    //   6859: iload #6
    //   6861: i2d
    //   6862: dmul
    //   6863: ldc2_w -90.0
    //   6866: dconst_1
    //   6867: dconst_0
    //   6868: invokevirtual func_78374_a : (DDDDD)V
    //   6871: aload #7
    //   6873: iload #5
    //   6875: i2d
    //   6876: ldc2_w 1.35
    //   6879: ddiv
    //   6880: ldc2_w 0.05
    //   6883: iload #6
    //   6885: i2d
    //   6886: dmul
    //   6887: dsub
    //   6888: ldc2_w 0.7
    //   6891: iload #6
    //   6893: i2d
    //   6894: dmul
    //   6895: ldc2_w -90.0
    //   6898: dconst_0
    //   6899: dconst_0
    //   6900: invokevirtual func_78374_a : (DDDDD)V
    //   6903: aload #7
    //   6905: invokevirtual func_78381_a : ()I
    //   6908: pop
    //   6909: iconst_1
    //   6910: invokestatic glDepthMask : (Z)V
    //   6913: sipush #2929
    //   6916: invokestatic glEnable : (I)V
    //   6919: sipush #3008
    //   6922: invokestatic glEnable : (I)V
    //   6925: fconst_1
    //   6926: fconst_1
    //   6927: fconst_1
    //   6928: fconst_1
    //   6929: invokestatic glColor4f : (FFFF)V
    //   6932: aload #13
    //   6934: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   6937: getfield gunRange : Z
    //   6940: ifne -> 6959
    //   6943: aload_2
    //   6944: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   6947: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   6950: checkcast com/flansmod/common/driveables/EntitySeat
    //   6953: getfield calculator : Z
    //   6956: ifeq -> 7478
    //   6959: ldc_w -1.0
    //   6962: aload_2
    //   6963: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   6966: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   6969: checkcast com/flansmod/common/driveables/EntitySeat
    //   6972: getfield looking : Lcom/flansmod/common/RotatedAxes;
    //   6975: invokevirtual getPitch : ()F
    //   6978: fmul
    //   6979: fstore #23
    //   6981: aload #13
    //   6983: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   6986: getfield bulletSpeed : F
    //   6989: fstore #24
    //   6991: aload_2
    //   6992: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   6995: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   6998: instanceof com/flansmod/common/driveables/EntitySeat
    //   7001: ifeq -> 7044
    //   7004: aload_2
    //   7005: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   7008: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   7011: checkcast com/flansmod/common/driveables/EntitySeat
    //   7014: getfield seatInfo : Lcom/flansmod/common/driveables/Seat;
    //   7017: getfield gunType : Lcom/flansmod/common/guns/GunType;
    //   7020: ifnull -> 7044
    //   7023: aload_2
    //   7024: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   7027: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   7030: checkcast com/flansmod/common/driveables/EntitySeat
    //   7033: getfield seatInfo : Lcom/flansmod/common/driveables/Seat;
    //   7036: getfield gunType : Lcom/flansmod/common/guns/GunType;
    //   7039: getfield bulletSpeed : F
    //   7042: fstore #24
    //   7044: ldc_w -0.0200431
    //   7047: fload #24
    //   7049: fload #24
    //   7051: fmul
    //   7052: fmul
    //   7053: ldc_w -0.0190021
    //   7056: fload #24
    //   7058: fmul
    //   7059: fadd
    //   7060: ldc_w 0.0121473
    //   7063: fadd
    //   7064: fstore #25
    //   7066: ldc_w 1.80951
    //   7069: fload #24
    //   7071: fload #24
    //   7073: fmul
    //   7074: fmul
    //   7075: ldc_w 1.28548
    //   7078: fload #24
    //   7080: fmul
    //   7081: fadd
    //   7082: ldc_w 0.717027
    //   7085: fsub
    //   7086: fstore #26
    //   7088: ldc_w -1.71186
    //   7091: fload #24
    //   7093: fload #24
    //   7095: fmul
    //   7096: fmul
    //   7097: ldc_w 28.3149
    //   7100: fload #24
    //   7102: fmul
    //   7103: fadd
    //   7104: ldc_w 17.7582
    //   7107: fsub
    //   7108: fstore #27
    //   7110: ldc_w -0.0154103
    //   7113: fload #24
    //   7115: fload #24
    //   7117: fmul
    //   7118: fmul
    //   7119: ldc_w -0.0536423
    //   7122: fload #24
    //   7124: fmul
    //   7125: fadd
    //   7126: ldc_w 0.0672506
    //   7129: fadd
    //   7130: fstore #28
    //   7132: ldc_w 1.62975
    //   7135: fload #24
    //   7137: fload #24
    //   7139: fmul
    //   7140: fmul
    //   7141: ldc_w 2.87832
    //   7144: fload #24
    //   7146: fmul
    //   7147: fadd
    //   7148: ldc_w 3.14029
    //   7151: fsub
    //   7152: fstore #29
    //   7154: ldc_w 0.155543
    //   7157: fload #24
    //   7159: fload #24
    //   7161: fmul
    //   7162: fmul
    //   7163: ldc_w 10.6558
    //   7166: fload #24
    //   7168: fmul
    //   7169: fadd
    //   7170: ldc_w 3.87799
    //   7173: fsub
    //   7174: fstore #30
    //   7176: ldc_w -0.025129
    //   7179: fload #24
    //   7181: fload #24
    //   7183: fmul
    //   7184: fmul
    //   7185: ldc_w 0.0681265
    //   7188: fload #24
    //   7190: fmul
    //   7191: fadd
    //   7192: ldc_w 0.105299
    //   7195: fsub
    //   7196: fstore #31
    //   7198: ldc_w 2.58971
    //   7201: fload #24
    //   7203: fload #24
    //   7205: fmul
    //   7206: fmul
    //   7207: ldc_w -11.2084
    //   7210: fload #24
    //   7212: fmul
    //   7213: fadd
    //   7214: ldc_w 16.2033
    //   7217: fadd
    //   7218: fstore #32
    //   7220: ldc_w -609.734
    //   7223: fload #24
    //   7225: fload #24
    //   7227: fmul
    //   7228: fmul
    //   7229: ldc_w 460.235
    //   7232: fload #24
    //   7234: fmul
    //   7235: fadd
    //   7236: ldc_w 609.734
    //   7239: fsub
    //   7240: fstore #33
    //   7242: fload #25
    //   7244: fload #23
    //   7246: fload #23
    //   7248: fmul
    //   7249: fmul
    //   7250: fload #26
    //   7252: fload #23
    //   7254: fmul
    //   7255: fadd
    //   7256: fload #27
    //   7258: fadd
    //   7259: fstore #34
    //   7261: fload #31
    //   7263: fload #23
    //   7265: fload #23
    //   7267: fmul
    //   7268: fmul
    //   7269: fload #32
    //   7271: fload #23
    //   7273: fmul
    //   7274: fadd
    //   7275: fload #33
    //   7277: fadd
    //   7278: fstore #35
    //   7280: fload #28
    //   7282: fload #23
    //   7284: fload #23
    //   7286: fmul
    //   7287: fmul
    //   7288: fload #29
    //   7290: fload #23
    //   7292: fmul
    //   7293: fadd
    //   7294: fload #30
    //   7296: fadd
    //   7297: fstore #36
    //   7299: ldc_w 69.0
    //   7302: fstore #37
    //   7304: fload #23
    //   7306: fconst_0
    //   7307: fcmpl
    //   7308: iflt -> 7345
    //   7311: fload #23
    //   7313: ldc_w 20.0
    //   7316: fcmpg
    //   7317: ifge -> 7345
    //   7320: fload #36
    //   7322: ldc_w 20.0
    //   7325: fload #23
    //   7327: fsub
    //   7328: ldc_w 20.0
    //   7331: fdiv
    //   7332: fmul
    //   7333: fload #34
    //   7335: fload #23
    //   7337: ldc_w 20.0
    //   7340: fdiv
    //   7341: fmul
    //   7342: fadd
    //   7343: fstore #37
    //   7345: fload #23
    //   7347: ldc_w 20.0
    //   7350: fcmpl
    //   7351: iflt -> 7367
    //   7354: fload #23
    //   7356: ldc_w 90.0
    //   7359: fcmpg
    //   7360: ifge -> 7367
    //   7363: fload #34
    //   7365: fstore #37
    //   7367: fload #23
    //   7369: fconst_0
    //   7370: fcmpl
    //   7371: ifle -> 7408
    //   7374: aload_2
    //   7375: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7378: ldc_w 'Estimated Gun Range : %.0f'
    //   7381: iconst_1
    //   7382: anewarray java/lang/Object
    //   7385: dup
    //   7386: iconst_0
    //   7387: fload #37
    //   7389: invokestatic valueOf : (F)Ljava/lang/Float;
    //   7392: aastore
    //   7393: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   7396: sipush #172
    //   7399: bipush #32
    //   7401: ldc_w 16777215
    //   7404: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7407: pop
    //   7408: fload #37
    //   7410: ldc_w 350.0
    //   7413: fcmpl
    //   7414: ifle -> 7443
    //   7417: aload_2
    //   7418: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7421: ldc_w 'Warning: Bullet May Freeze Outside of Render Range'
    //   7424: iconst_0
    //   7425: anewarray java/lang/Object
    //   7428: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   7431: sipush #172
    //   7434: bipush #52
    //   7436: ldc_w 16711680
    //   7439: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7442: pop
    //   7443: fload #23
    //   7445: ldc_w 55.0
    //   7448: fcmpl
    //   7449: ifle -> 7478
    //   7452: aload_2
    //   7453: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7456: ldc_w 'Warning: Predicion Less Accurate at These Angles'
    //   7459: iconst_0
    //   7460: anewarray java/lang/Object
    //   7463: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   7466: sipush #172
    //   7469: bipush #62
    //   7471: ldc_w 14329120
    //   7474: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7477: pop
    //   7478: aload #13
    //   7480: instanceof com/flansmod/common/driveables/EntityPlane
    //   7483: ifeq -> 8816
    //   7486: aload #13
    //   7488: astore #23
    //   7490: aload #23
    //   7492: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   7495: getfield hasFlare : Z
    //   7498: ifeq -> 7584
    //   7501: aload #23
    //   7503: getfield ticksFlareUsing : I
    //   7506: ifgt -> 7534
    //   7509: aload #23
    //   7511: getfield flareDelay : I
    //   7514: ifgt -> 7534
    //   7517: aload_2
    //   7518: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7521: ldc_w 'Flare : READY'
    //   7524: iconst_2
    //   7525: bipush #42
    //   7527: ldc_w 65280
    //   7530: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7533: pop
    //   7534: aload #23
    //   7536: getfield ticksFlareUsing : I
    //   7539: ifle -> 7559
    //   7542: aload_2
    //   7543: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7546: ldc_w 'Flare : Deploying'
    //   7549: iconst_2
    //   7550: bipush #52
    //   7552: ldc_w 16711680
    //   7555: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7558: pop
    //   7559: aload #23
    //   7561: getfield flareDelay : I
    //   7564: ifle -> 7584
    //   7567: aload_2
    //   7568: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7571: ldc_w 'Flare : Reloading'
    //   7574: iconst_2
    //   7575: bipush #62
    //   7577: ldc_w 14329120
    //   7580: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7583: pop
    //   7584: aload #23
    //   7586: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7589: invokevirtual getYAxis : ()Lcom/flansmod/common/vector/Vector3f;
    //   7592: invokevirtual normalise : ()Lcom/flansmod/common/vector/Vector;
    //   7595: checkcast com/flansmod/common/vector/Vector3f
    //   7598: astore #24
    //   7600: aload_2
    //   7601: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7604: new java/lang/StringBuilder
    //   7607: dup
    //   7608: invokespecial <init> : ()V
    //   7611: ldc_w 'Plane Pitch : %.1f'
    //   7614: iconst_1
    //   7615: anewarray java/lang/Object
    //   7618: dup
    //   7619: iconst_0
    //   7620: ldc_w -1.0
    //   7623: aload #23
    //   7625: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7628: invokevirtual getPitch : ()F
    //   7631: fmul
    //   7632: invokestatic valueOf : (F)Ljava/lang/Float;
    //   7635: aastore
    //   7636: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   7639: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7642: ldc_w '°'
    //   7645: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7648: invokevirtual toString : ()Ljava/lang/String;
    //   7651: sipush #172
    //   7654: bipush #22
    //   7656: ldc_w 16777215
    //   7659: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7662: pop
    //   7663: aload_2
    //   7664: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7667: new java/lang/StringBuilder
    //   7670: dup
    //   7671: invokespecial <init> : ()V
    //   7674: ldc_w 'Plane Roll : %.1f'
    //   7677: iconst_1
    //   7678: anewarray java/lang/Object
    //   7681: dup
    //   7682: iconst_0
    //   7683: ldc_w -1.0
    //   7686: aload #23
    //   7688: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7691: invokevirtual getRoll : ()F
    //   7694: fmul
    //   7695: invokestatic valueOf : (F)Ljava/lang/Float;
    //   7698: aastore
    //   7699: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   7702: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7705: ldc_w '°'
    //   7708: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7711: invokevirtual toString : ()Ljava/lang/String;
    //   7714: sipush #172
    //   7717: bipush #12
    //   7719: ldc_w 16777215
    //   7722: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7725: pop
    //   7726: aload #23
    //   7728: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7731: invokevirtual getYaw : ()F
    //   7734: f2d
    //   7735: ldc2_w 22.5
    //   7738: dcmpg
    //   7739: ifge -> 7776
    //   7742: aload #23
    //   7744: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7747: invokevirtual getYaw : ()F
    //   7750: f2d
    //   7751: ldc2_w -22.5
    //   7754: dcmpl
    //   7755: iflt -> 7776
    //   7758: aload_2
    //   7759: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7762: ldc_w 'Compass : East'
    //   7765: sipush #172
    //   7768: iconst_2
    //   7769: ldc_w 16777215
    //   7772: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7775: pop
    //   7776: aload #23
    //   7778: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7781: invokevirtual getYaw : ()F
    //   7784: f2d
    //   7785: ldc2_w 67.5
    //   7788: dcmpg
    //   7789: ifge -> 7826
    //   7792: aload #23
    //   7794: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7797: invokevirtual getYaw : ()F
    //   7800: f2d
    //   7801: ldc2_w 22.5
    //   7804: dcmpl
    //   7805: iflt -> 7826
    //   7808: aload_2
    //   7809: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7812: ldc_w 'Compass: South-East'
    //   7815: sipush #172
    //   7818: iconst_2
    //   7819: ldc_w 16777215
    //   7822: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7825: pop
    //   7826: aload #23
    //   7828: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7831: invokevirtual getYaw : ()F
    //   7834: f2d
    //   7835: ldc2_w 67.5
    //   7838: dcmpl
    //   7839: iflt -> 7876
    //   7842: aload #23
    //   7844: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7847: invokevirtual getYaw : ()F
    //   7850: f2d
    //   7851: ldc2_w 112.5
    //   7854: dcmpg
    //   7855: ifge -> 7876
    //   7858: aload_2
    //   7859: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7862: ldc_w 'Compass : South'
    //   7865: sipush #172
    //   7868: iconst_2
    //   7869: ldc_w 16777215
    //   7872: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7875: pop
    //   7876: aload #23
    //   7878: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7881: invokevirtual getYaw : ()F
    //   7884: f2d
    //   7885: ldc2_w 112.5
    //   7888: dcmpl
    //   7889: iflt -> 7926
    //   7892: aload #23
    //   7894: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7897: invokevirtual getYaw : ()F
    //   7900: f2d
    //   7901: ldc2_w 157.5
    //   7904: dcmpg
    //   7905: ifge -> 7926
    //   7908: aload_2
    //   7909: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7912: ldc_w 'Compass : South-West'
    //   7915: sipush #172
    //   7918: iconst_2
    //   7919: ldc_w 16777215
    //   7922: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7925: pop
    //   7926: aload #23
    //   7928: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7931: invokevirtual getYaw : ()F
    //   7934: f2d
    //   7935: ldc2_w -157.5
    //   7938: dcmpg
    //   7939: iflt -> 7958
    //   7942: aload #23
    //   7944: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7947: invokevirtual getYaw : ()F
    //   7950: f2d
    //   7951: ldc2_w 157.5
    //   7954: dcmpl
    //   7955: iflt -> 7976
    //   7958: aload_2
    //   7959: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   7962: ldc_w 'Compass : West'
    //   7965: sipush #172
    //   7968: iconst_2
    //   7969: ldc_w 16777215
    //   7972: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   7975: pop
    //   7976: aload #23
    //   7978: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7981: invokevirtual getYaw : ()F
    //   7984: f2d
    //   7985: ldc2_w -112.5
    //   7988: dcmpg
    //   7989: ifge -> 8026
    //   7992: aload #23
    //   7994: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   7997: invokevirtual getYaw : ()F
    //   8000: f2d
    //   8001: ldc2_w -157.5
    //   8004: dcmpl
    //   8005: iflt -> 8026
    //   8008: aload_2
    //   8009: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8012: ldc_w 'Compass: North-West'
    //   8015: sipush #172
    //   8018: iconst_2
    //   8019: ldc_w 16777215
    //   8022: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8025: pop
    //   8026: aload #23
    //   8028: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   8031: invokevirtual getYaw : ()F
    //   8034: f2d
    //   8035: ldc2_w -112.5
    //   8038: dcmpl
    //   8039: ifle -> 8076
    //   8042: aload #23
    //   8044: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   8047: invokevirtual getYaw : ()F
    //   8050: f2d
    //   8051: ldc2_w -67.5
    //   8054: dcmpg
    //   8055: ifgt -> 8076
    //   8058: aload_2
    //   8059: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8062: ldc_w 'Compass : North'
    //   8065: sipush #172
    //   8068: iconst_2
    //   8069: ldc_w 16777215
    //   8072: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8075: pop
    //   8076: aload #23
    //   8078: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   8081: invokevirtual getYaw : ()F
    //   8084: f2d
    //   8085: ldc2_w -67.5
    //   8088: dcmpl
    //   8089: ifle -> 8126
    //   8092: aload #23
    //   8094: getfield axes : Lcom/flansmod/common/RotatedAxes;
    //   8097: invokevirtual getYaw : ()F
    //   8100: f2d
    //   8101: ldc2_w -22.5
    //   8104: dcmpg
    //   8105: ifgt -> 8126
    //   8108: aload_2
    //   8109: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8112: ldc_w 'Compass : North-East'
    //   8115: sipush #172
    //   8118: iconst_2
    //   8119: ldc_w 16777215
    //   8122: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8125: pop
    //   8126: aload_2
    //   8127: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8130: new java/lang/StringBuilder
    //   8133: dup
    //   8134: invokespecial <init> : ()V
    //   8137: ldc_w 'Altitude : %.0f'
    //   8140: iconst_1
    //   8141: anewarray java/lang/Object
    //   8144: dup
    //   8145: iconst_0
    //   8146: aload_2
    //   8147: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   8150: getfield field_70154_o : Lnet/minecraft/entity/Entity;
    //   8153: checkcast com/flansmod/common/driveables/EntitySeat
    //   8156: getfield field_70163_u : D
    //   8159: invokestatic valueOf : (D)Ljava/lang/Double;
    //   8162: aastore
    //   8163: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   8166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8169: ldc_w ' Meters'
    //   8172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8175: invokevirtual toString : ()Ljava/lang/String;
    //   8178: sipush #172
    //   8181: bipush #32
    //   8183: ldc_w 16777215
    //   8186: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8189: pop
    //   8190: aload #23
    //   8192: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   8195: getfield rocketThrottle : Z
    //   8198: ifeq -> 8241
    //   8201: aload_2
    //   8202: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8205: new java/lang/StringBuilder
    //   8208: dup
    //   8209: invokespecial <init> : ()V
    //   8212: ldc_w 'Fuel : '
    //   8215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8218: aload #23
    //   8220: getfield fuelTimer : I
    //   8223: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   8226: invokevirtual toString : ()Ljava/lang/String;
    //   8229: sipush #172
    //   8232: bipush #42
    //   8234: ldc_w 16777215
    //   8237: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8240: pop
    //   8241: aload #23
    //   8243: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   8246: getfield labjacFuel : F
    //   8249: ldc_w 10.0
    //   8252: fcmpl
    //   8253: ifle -> 8315
    //   8256: aload_2
    //   8257: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8260: new java/lang/StringBuilder
    //   8263: dup
    //   8264: invokespecial <init> : ()V
    //   8267: ldc_w 'Fuel : %.2f'
    //   8270: iconst_1
    //   8271: anewarray java/lang/Object
    //   8274: dup
    //   8275: iconst_0
    //   8276: aload #23
    //   8278: getfield labjacFuel : F
    //   8281: ldc_w 12000.0
    //   8284: fdiv
    //   8285: invokestatic valueOf : (F)Ljava/lang/Float;
    //   8288: aastore
    //   8289: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   8292: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8295: ldc_w ' Minutes'
    //   8298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8301: invokevirtual toString : ()Ljava/lang/String;
    //   8304: sipush #288
    //   8307: iconst_2
    //   8308: ldc_w 16777215
    //   8311: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8314: pop
    //   8315: aload #23
    //   8317: getfield mounted : Z
    //   8320: ifeq -> 8373
    //   8323: aload_2
    //   8324: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8327: new java/lang/StringBuilder
    //   8330: dup
    //   8331: invokespecial <init> : ()V
    //   8334: ldc_w 'Press '
    //   8337: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8340: getstatic com/flansmod/client/KeyInputHandler.gunKey : Lnet/minecraft/client/settings/KeyBinding;
    //   8343: invokevirtual func_151463_i : ()I
    //   8346: invokestatic getKeyName : (I)Ljava/lang/String;
    //   8349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8352: ldc_w ' to undock'
    //   8355: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8358: invokevirtual toString : ()Ljava/lang/String;
    //   8361: sipush #172
    //   8364: bipush #62
    //   8366: ldc_w 16711680
    //   8369: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8372: pop
    //   8373: aload #23
    //   8375: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   8378: getfield epicShip : Z
    //   8381: ifne -> 8572
    //   8384: aload #23
    //   8386: getfield ticksRepairing : I
    //   8389: ifgt -> 8503
    //   8392: aload #23
    //   8394: getfield flareDelay : I
    //   8397: ifgt -> 8503
    //   8400: aload #13
    //   8402: getfield throttle : F
    //   8405: f2d
    //   8406: ldc2_w 0.01
    //   8409: dcmpg
    //   8410: ifge -> 8503
    //   8413: aload #13
    //   8415: getfield throttle : F
    //   8418: f2d
    //   8419: ldc2_w -0.01
    //   8422: dcmpl
    //   8423: ifle -> 8503
    //   8426: aload #23
    //   8428: getfield field_70170_p : Lnet/minecraft/world/World;
    //   8431: aload #23
    //   8433: getfield field_70165_t : D
    //   8436: d2i
    //   8437: aload #23
    //   8439: getfield field_70163_u : D
    //   8442: ldc2_w 5.0
    //   8445: dsub
    //   8446: d2i
    //   8447: aload #23
    //   8449: getfield field_70161_v : D
    //   8452: d2i
    //   8453: invokevirtual func_147437_c : (III)Z
    //   8456: ifne -> 8503
    //   8459: aload_2
    //   8460: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8463: new java/lang/StringBuilder
    //   8466: dup
    //   8467: invokespecial <init> : ()V
    //   8470: ldc_w 'Repair Ready - Press '
    //   8473: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8476: getstatic com/flansmod/client/KeyInputHandler.repairKey : Lnet/minecraft/client/settings/KeyBinding;
    //   8479: invokevirtual func_151463_i : ()I
    //   8482: invokestatic getKeyName : (I)Ljava/lang/String;
    //   8485: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8488: invokevirtual toString : ()Ljava/lang/String;
    //   8491: sipush #288
    //   8494: bipush #12
    //   8496: ldc_w 65280
    //   8499: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8502: pop
    //   8503: aload #23
    //   8505: getfield ticksRepairing : I
    //   8508: ifgt -> 8532
    //   8511: aload #23
    //   8513: getfield flareDelay : I
    //   8516: ifgt -> 8532
    //   8519: aload #13
    //   8521: getfield throttle : F
    //   8524: f2d
    //   8525: ldc2_w 0.01
    //   8528: dcmpl
    //   8529: ifgt -> 8553
    //   8532: aload #23
    //   8534: getfield ticksRepairing : I
    //   8537: ifgt -> 8572
    //   8540: aload #13
    //   8542: getfield throttle : F
    //   8545: f2d
    //   8546: ldc2_w -0.01
    //   8549: dcmpg
    //   8550: ifge -> 8572
    //   8553: aload_2
    //   8554: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8557: ldc_w 'You must land to repair'
    //   8560: sipush #288
    //   8563: bipush #12
    //   8565: ldc_w 14329120
    //   8568: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8571: pop
    //   8572: aload #23
    //   8574: getfield ticksRepairing : I
    //   8577: ifle -> 8620
    //   8580: aload_2
    //   8581: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8584: new java/lang/StringBuilder
    //   8587: dup
    //   8588: invokespecial <init> : ()V
    //   8591: ldc_w 'Repairing ticks: '
    //   8594: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8597: aload #23
    //   8599: getfield ticksRepairing : I
    //   8602: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   8605: invokevirtual toString : ()Ljava/lang/String;
    //   8608: sipush #288
    //   8611: bipush #12
    //   8613: ldc_w 65280
    //   8616: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8619: pop
    //   8620: aload #23
    //   8622: getfield currentAmmo : Ljava/lang/String;
    //   8625: ifnull -> 8679
    //   8628: aload #23
    //   8630: ldc_w ''
    //   8633: invokevirtual equals : (Ljava/lang/Object;)Z
    //   8636: ifne -> 8679
    //   8639: aload_2
    //   8640: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8643: ldc_w 'Current Ammo '
    //   8646: sipush #172
    //   8649: bipush #42
    //   8651: ldc_w 16777215
    //   8654: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8657: pop
    //   8658: aload_2
    //   8659: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8662: aload #23
    //   8664: getfield currentAmmo : Ljava/lang/String;
    //   8667: sipush #172
    //   8670: bipush #52
    //   8672: ldc_w 2424674
    //   8675: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8678: pop
    //   8679: aload #23
    //   8681: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   8684: getfield hasPlaneRadar : Z
    //   8687: ifeq -> 8717
    //   8690: aload #23
    //   8692: getfield activeRadar : Z
    //   8695: ifeq -> 8717
    //   8698: aload_2
    //   8699: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8702: ldc_w 'Radar Mode: ACTIVE'
    //   8705: sipush #288
    //   8708: bipush #22
    //   8710: ldc_w 2424674
    //   8713: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8716: pop
    //   8717: aload #23
    //   8719: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   8722: getfield hasPlaneRadar : Z
    //   8725: ifeq -> 8755
    //   8728: aload #23
    //   8730: getfield activeRadar : Z
    //   8733: ifne -> 8755
    //   8736: aload_2
    //   8737: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8740: ldc_w 'Radar Mode: PASSIVE'
    //   8743: sipush #288
    //   8746: bipush #22
    //   8748: ldc_w 14363648
    //   8751: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8754: pop
    //   8755: aload #23
    //   8757: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   8760: getfield hasPlaneRadar : Z
    //   8763: ifeq -> 8816
    //   8766: aload_2
    //   8767: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8770: new java/lang/StringBuilder
    //   8773: dup
    //   8774: invokespecial <init> : ()V
    //   8777: ldc_w 'Press '
    //   8780: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8783: getstatic com/flansmod/client/KeyInputHandler.activeRadar : Lnet/minecraft/client/settings/KeyBinding;
    //   8786: invokevirtual func_151463_i : ()I
    //   8789: invokestatic getKeyName : (I)Ljava/lang/String;
    //   8792: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8795: ldc_w ' to toggle'
    //   8798: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8801: invokevirtual toString : ()Ljava/lang/String;
    //   8804: sipush #288
    //   8807: bipush #32
    //   8809: ldc_w 16748580
    //   8812: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8815: pop
    //   8816: aload #13
    //   8818: instanceof com/flansmod/common/driveables/mechas/EntityMecha
    //   8821: ifeq -> 8980
    //   8824: aload #13
    //   8826: checkcast com/flansmod/common/driveables/mechas/EntityMecha
    //   8829: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   8832: astore #23
    //   8834: aload #13
    //   8836: astore #24
    //   8838: aload #24
    //   8840: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   8843: getfield hasFlare : Z
    //   8846: ifeq -> 8973
    //   8849: aload #24
    //   8851: getfield ticksFlareUsing : I
    //   8854: ifgt -> 8893
    //   8857: aload #24
    //   8859: getfield flareDelay : I
    //   8862: ifgt -> 8893
    //   8865: aload #13
    //   8867: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   8870: getfield panicTimer : I
    //   8873: ifgt -> 8893
    //   8876: aload_2
    //   8877: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8880: ldc_w 'Trample : READY'
    //   8883: iconst_2
    //   8884: bipush #32
    //   8886: ldc_w 65280
    //   8889: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8892: pop
    //   8893: aload #24
    //   8895: getfield ticksFlareUsing : I
    //   8898: ifle -> 8929
    //   8901: aload #13
    //   8903: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   8906: getfield panicTimer : I
    //   8909: ifgt -> 8929
    //   8912: aload_2
    //   8913: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8916: ldc_w 'Trampling'
    //   8919: iconst_2
    //   8920: bipush #32
    //   8922: ldc_w 16711680
    //   8925: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8928: pop
    //   8929: aload #24
    //   8931: getfield flareDelay : I
    //   8934: ifle -> 8973
    //   8937: aload #24
    //   8939: getfield ticksFlareUsing : I
    //   8942: ifgt -> 8973
    //   8945: aload #13
    //   8947: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   8950: getfield panicTimer : I
    //   8953: ifgt -> 8973
    //   8956: aload_2
    //   8957: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   8960: ldc_w 'Trample : Exhausted'
    //   8963: iconst_2
    //   8964: bipush #32
    //   8966: ldc_w 14329120
    //   8969: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   8972: pop
    //   8973: aload #13
    //   8975: checkcast com/flansmod/common/driveables/mechas/EntityMecha
    //   8978: astore #25
    //   8980: aload #13
    //   8982: instanceof com/flansmod/common/driveables/EntityVehicle
    //   8985: ifeq -> 10892
    //   8988: aload #13
    //   8990: checkcast com/flansmod/common/driveables/EntityVehicle
    //   8993: invokevirtual getDriveableData : ()Lcom/flansmod/common/driveables/DriveableData;
    //   8996: astore #23
    //   8998: aload #13
    //   9000: astore #24
    //   9002: aload #24
    //   9004: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   9007: getfield hasFlare : Z
    //   9010: ifeq -> 9107
    //   9013: aload #24
    //   9015: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   9018: getfield epicShip : Z
    //   9021: ifne -> 9107
    //   9024: aload #24
    //   9026: getfield ticksFlareUsing : I
    //   9029: ifgt -> 9057
    //   9032: aload #24
    //   9034: getfield flareDelay : I
    //   9037: ifgt -> 9057
    //   9040: aload_2
    //   9041: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9044: ldc_w 'Smoke : READY'
    //   9047: iconst_2
    //   9048: bipush #62
    //   9050: ldc_w 65280
    //   9053: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9056: pop
    //   9057: aload #24
    //   9059: getfield ticksFlareUsing : I
    //   9062: ifle -> 9082
    //   9065: aload_2
    //   9066: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9069: ldc_w 'Smoke : Deploying'
    //   9072: iconst_2
    //   9073: bipush #62
    //   9075: ldc_w 16711680
    //   9078: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9081: pop
    //   9082: aload #24
    //   9084: getfield flareDelay : I
    //   9087: ifle -> 9107
    //   9090: aload_2
    //   9091: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9094: ldc_w 'Smoke : Reloading'
    //   9097: iconst_2
    //   9098: bipush #72
    //   9100: ldc_w 14329120
    //   9103: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9106: pop
    //   9107: aload #24
    //   9109: checkcast com/flansmod/common/driveables/EntityVehicle
    //   9112: invokevirtual getVehicleType : ()Lcom/flansmod/common/driveables/VehicleType;
    //   9115: getfield canRepair : Z
    //   9118: ifeq -> 9300
    //   9121: aload #24
    //   9123: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   9126: getfield epicShip : Z
    //   9129: ifne -> 9300
    //   9132: aload #24
    //   9134: getfield ticksRepairing : I
    //   9137: ifgt -> 9216
    //   9140: aload #24
    //   9142: getfield flareDelay : I
    //   9145: ifgt -> 9216
    //   9148: aload #13
    //   9150: getfield throttle : F
    //   9153: f2d
    //   9154: ldc2_w 0.01
    //   9157: dcmpg
    //   9158: ifge -> 9216
    //   9161: aload #13
    //   9163: getfield throttle : F
    //   9166: f2d
    //   9167: ldc2_w -0.01
    //   9170: dcmpl
    //   9171: ifle -> 9216
    //   9174: aload_2
    //   9175: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9178: new java/lang/StringBuilder
    //   9181: dup
    //   9182: invokespecial <init> : ()V
    //   9185: ldc_w 'Repair Ready - Press '
    //   9188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9191: getstatic com/flansmod/client/KeyInputHandler.repairKey : Lnet/minecraft/client/settings/KeyBinding;
    //   9194: invokevirtual func_151463_i : ()I
    //   9197: invokestatic getKeyName : (I)Ljava/lang/String;
    //   9200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9203: invokevirtual toString : ()Ljava/lang/String;
    //   9206: iconst_2
    //   9207: bipush #42
    //   9209: ldc_w 65280
    //   9212: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9215: pop
    //   9216: aload #24
    //   9218: getfield ticksRepairing : I
    //   9221: ifgt -> 9245
    //   9224: aload #24
    //   9226: getfield flareDelay : I
    //   9229: ifgt -> 9245
    //   9232: aload #13
    //   9234: getfield throttle : F
    //   9237: f2d
    //   9238: ldc2_w 0.01
    //   9241: dcmpl
    //   9242: ifgt -> 9266
    //   9245: aload #24
    //   9247: getfield ticksRepairing : I
    //   9250: ifgt -> 9300
    //   9253: aload #13
    //   9255: getfield throttle : F
    //   9258: f2d
    //   9259: ldc2_w -0.01
    //   9262: dcmpg
    //   9263: ifge -> 9300
    //   9266: aload_2
    //   9267: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9270: ldc_w 'You must be at'
    //   9273: iconst_2
    //   9274: bipush #36
    //   9276: ldc_w 14329120
    //   9279: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9282: pop
    //   9283: aload_2
    //   9284: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9287: ldc_w '0 throttle to repair!'
    //   9290: iconst_2
    //   9291: bipush #46
    //   9293: ldc_w 14329120
    //   9296: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9299: pop
    //   9300: aload #24
    //   9302: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   9305: getfield hasRadar : Z
    //   9308: ifeq -> 9337
    //   9311: aload #24
    //   9313: getfield activeRadar : Z
    //   9316: ifeq -> 9337
    //   9319: aload_2
    //   9320: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9323: ldc_w 'Radar Mode: ACTIVE'
    //   9326: sipush #292
    //   9329: iconst_2
    //   9330: ldc_w 2424674
    //   9333: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9336: pop
    //   9337: aload #24
    //   9339: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   9342: getfield hasRadar : Z
    //   9345: ifeq -> 9374
    //   9348: aload #24
    //   9350: getfield activeRadar : Z
    //   9353: ifne -> 9374
    //   9356: aload_2
    //   9357: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9360: ldc_w 'Radar Mode: PASSIVE'
    //   9363: sipush #292
    //   9366: iconst_2
    //   9367: ldc_w 14363648
    //   9370: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9373: pop
    //   9374: aload #24
    //   9376: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   9379: getfield hasRadar : Z
    //   9382: ifeq -> 9435
    //   9385: aload_2
    //   9386: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9389: new java/lang/StringBuilder
    //   9392: dup
    //   9393: invokespecial <init> : ()V
    //   9396: ldc_w 'Press '
    //   9399: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9402: getstatic com/flansmod/client/KeyInputHandler.activeRadar : Lnet/minecraft/client/settings/KeyBinding;
    //   9405: invokevirtual func_151463_i : ()I
    //   9408: invokestatic getKeyName : (I)Ljava/lang/String;
    //   9411: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9414: ldc_w ' to toggle'
    //   9417: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9420: invokevirtual toString : ()Ljava/lang/String;
    //   9423: sipush #292
    //   9426: bipush #12
    //   9428: ldc_w 16748580
    //   9431: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9434: pop
    //   9435: aload #24
    //   9437: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   9440: getfield shootDelayPrimary : I
    //   9443: bipush #30
    //   9445: if_icmple -> 9594
    //   9448: aload #24
    //   9450: getfield ticksRepairing : I
    //   9453: ifle -> 9494
    //   9456: aload_2
    //   9457: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9460: new java/lang/StringBuilder
    //   9463: dup
    //   9464: invokespecial <init> : ()V
    //   9467: ldc_w 'Repairing ticks: '
    //   9470: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9473: aload #24
    //   9475: getfield ticksRepairing : I
    //   9478: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   9481: invokevirtual toString : ()Ljava/lang/String;
    //   9484: iconst_2
    //   9485: bipush #42
    //   9487: ldc_w 65280
    //   9490: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9493: pop
    //   9494: aload #24
    //   9496: getfield recoilTimer : I
    //   9499: iconst_1
    //   9500: if_icmple -> 9567
    //   9503: aload_2
    //   9504: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9507: new java/lang/StringBuilder
    //   9510: dup
    //   9511: invokespecial <init> : ()V
    //   9514: ldc_w 'Reload Time: %.1f'
    //   9517: iconst_1
    //   9518: anewarray java/lang/Object
    //   9521: dup
    //   9522: iconst_0
    //   9523: aload #24
    //   9525: getfield recoilTimer : I
    //   9528: i2f
    //   9529: ldc_w 20.0
    //   9532: fdiv
    //   9533: invokestatic valueOf : (F)Ljava/lang/Float;
    //   9536: aastore
    //   9537: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9540: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9543: ldc_w ' seconds'
    //   9546: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9549: invokevirtual toString : ()Ljava/lang/String;
    //   9552: sipush #172
    //   9555: bipush #22
    //   9557: ldc_w 16711680
    //   9560: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9563: pop
    //   9564: goto -> 9594
    //   9567: aload #24
    //   9569: getfield recoilTimer : I
    //   9572: ifgt -> 9594
    //   9575: aload_2
    //   9576: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9579: ldc_w 'Shell : Ready'
    //   9582: sipush #172
    //   9585: bipush #22
    //   9587: ldc_w 65280
    //   9590: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9593: pop
    //   9594: aload #24
    //   9596: getfield currentAmmo : Ljava/lang/String;
    //   9599: ifnull -> 9653
    //   9602: aload #24
    //   9604: ldc_w ''
    //   9607: invokevirtual equals : (Ljava/lang/Object;)Z
    //   9610: ifne -> 9653
    //   9613: aload_2
    //   9614: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9617: ldc_w 'Current Ammo '
    //   9620: sipush #172
    //   9623: bipush #32
    //   9625: ldc_w 16777215
    //   9628: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9631: pop
    //   9632: aload_2
    //   9633: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9636: aload #24
    //   9638: getfield currentAmmo : Ljava/lang/String;
    //   9641: sipush #172
    //   9644: bipush #42
    //   9646: ldc_w 2424674
    //   9649: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9652: pop
    //   9653: aload #24
    //   9655: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   9658: getfield hasFlare : Z
    //   9661: ifeq -> 9867
    //   9664: aload #24
    //   9666: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   9669: getfield epicShip : Z
    //   9672: ifeq -> 9867
    //   9675: aload #24
    //   9677: getfield ticksFlareUsing : I
    //   9680: ifgt -> 9734
    //   9683: aload #24
    //   9685: getfield flareDelay : I
    //   9688: ifgt -> 9734
    //   9691: aload #13
    //   9693: getfield throttle : F
    //   9696: f2d
    //   9697: ldc2_w 0.01
    //   9700: dcmpg
    //   9701: ifge -> 9734
    //   9704: aload #13
    //   9706: getfield throttle : F
    //   9709: f2d
    //   9710: ldc2_w -0.01
    //   9713: dcmpl
    //   9714: ifle -> 9734
    //   9717: aload_2
    //   9718: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9721: ldc_w 'Damage Control : READY'
    //   9724: iconst_2
    //   9725: bipush #42
    //   9727: ldc_w 65280
    //   9730: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9733: pop
    //   9734: aload #24
    //   9736: getfield ticksFlareUsing : I
    //   9739: ifgt -> 9763
    //   9742: aload #24
    //   9744: getfield flareDelay : I
    //   9747: ifgt -> 9763
    //   9750: aload #13
    //   9752: getfield throttle : F
    //   9755: f2d
    //   9756: ldc2_w 0.01
    //   9759: dcmpl
    //   9760: ifgt -> 9792
    //   9763: aload #24
    //   9765: getfield ticksFlareUsing : I
    //   9768: ifgt -> 9809
    //   9771: aload #24
    //   9773: getfield flareDelay : I
    //   9776: ifgt -> 9809
    //   9779: aload #13
    //   9781: getfield throttle : F
    //   9784: f2d
    //   9785: ldc2_w -0.01
    //   9788: dcmpg
    //   9789: ifge -> 9809
    //   9792: aload_2
    //   9793: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9796: ldc_w 'You must be at 0 throttle to Repair!'
    //   9799: iconst_2
    //   9800: bipush #42
    //   9802: ldc_w 14329120
    //   9805: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9808: pop
    //   9809: aload #24
    //   9811: getfield ticksFlareUsing : I
    //   9814: ifle -> 9834
    //   9817: aload_2
    //   9818: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9821: ldc_w 'Damage Control : Repairing'
    //   9824: iconst_2
    //   9825: bipush #42
    //   9827: ldc_w 16711680
    //   9830: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9833: pop
    //   9834: aload #24
    //   9836: getfield flareDelay : I
    //   9839: ifle -> 9867
    //   9842: aload #24
    //   9844: getfield ticksFlareUsing : I
    //   9847: ifgt -> 9867
    //   9850: aload_2
    //   9851: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9854: ldc_w 'Damage Control : Resting'
    //   9857: iconst_2
    //   9858: bipush #42
    //   9860: ldc_w 14329120
    //   9863: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9866: pop
    //   9867: aload #24
    //   9869: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   9872: getfield hasAPS : Z
    //   9875: ifeq -> 9930
    //   9878: aload #24
    //   9880: getfield APSdelay : I
    //   9883: iconst_5
    //   9884: if_icmpgt -> 9904
    //   9887: aload_2
    //   9888: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9891: ldc_w 'APS : READY'
    //   9894: iconst_2
    //   9895: bipush #52
    //   9897: ldc_w 65280
    //   9900: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9903: pop
    //   9904: aload #24
    //   9906: getfield APSdelay : I
    //   9909: iconst_5
    //   9910: if_icmple -> 9930
    //   9913: aload_2
    //   9914: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   9917: ldc_w 'APS : Reloading'
    //   9920: iconst_2
    //   9921: bipush #52
    //   9923: ldc_w 14329120
    //   9926: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   9929: pop
    //   9930: aload #13
    //   9932: checkcast com/flansmod/common/driveables/EntityVehicle
    //   9935: invokevirtual getVehicleType : ()Lcom/flansmod/common/driveables/VehicleType;
    //   9938: astore #25
    //   9940: aload_2
    //   9941: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   9944: ifnull -> 10270
    //   9947: aload_2
    //   9948: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
    //   9951: getfield field_71071_by : Lnet/minecraft/entity/player/InventoryPlayer;
    //   9954: getfield field_70460_b : [Lnet/minecraft/item/ItemStack;
    //   9957: iconst_3
    //   9958: aaload
    //   9959: astore #26
    //   9961: aconst_null
    //   9962: astore #27
    //   9964: aload #25
    //   9966: getfield hasScope : Z
    //   9969: ifeq -> 10028
    //   9972: aload #13
    //   9974: getfield aiming : Z
    //   9977: ifeq -> 10028
    //   9980: aload #25
    //   9982: getfield overlay : Ljava/lang/String;
    //   9985: astore #27
    //   9987: ldc net/minecraft/client/renderer/EntityRenderer
    //   9989: invokestatic instance : ()Lcpw/mods/fml/client/FMLClientHandler;
    //   9992: invokevirtual getClient : ()Lnet/minecraft/client/Minecraft;
    //   9995: getfield field_71460_t : Lnet/minecraft/client/renderer/EntityRenderer;
    //   9998: aload #25
    //   10000: getfield gunsightZoom : F
    //   10003: invokestatic valueOf : (F)Ljava/lang/Float;
    //   10006: iconst_3
    //   10007: anewarray java/lang/String
    //   10010: dup
    //   10011: iconst_0
    //   10012: ldc 'cameraZoom'
    //   10014: aastore
    //   10015: dup
    //   10016: iconst_1
    //   10017: ldc 'af'
    //   10019: aastore
    //   10020: dup
    //   10021: iconst_2
    //   10022: ldc 'field_78503_V'
    //   10024: aastore
    //   10025: invokestatic setPrivateValue : (Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/String;)V
    //   10028: aload #25
    //   10030: getfield hasScope : Z
    //   10033: ifeq -> 10084
    //   10036: aload #13
    //   10038: getfield aiming : Z
    //   10041: ifne -> 10084
    //   10044: aconst_null
    //   10045: astore #27
    //   10047: ldc net/minecraft/client/renderer/EntityRenderer
    //   10049: invokestatic instance : ()Lcpw/mods/fml/client/FMLClientHandler;
    //   10052: invokevirtual getClient : ()Lnet/minecraft/client/Minecraft;
    //   10055: getfield field_71460_t : Lnet/minecraft/client/renderer/EntityRenderer;
    //   10058: iconst_1
    //   10059: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10062: iconst_3
    //   10063: anewarray java/lang/String
    //   10066: dup
    //   10067: iconst_0
    //   10068: ldc 'cameraZoom'
    //   10070: aastore
    //   10071: dup
    //   10072: iconst_1
    //   10073: ldc 'af'
    //   10075: aastore
    //   10076: dup
    //   10077: iconst_2
    //   10078: ldc 'field_78503_V'
    //   10080: aastore
    //   10081: invokestatic setPrivateValue : (Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/String;)V
    //   10084: aload #27
    //   10086: ifnull -> 10270
    //   10089: getstatic com/flansmod/client/FlansModClient.minecraft : Lnet/minecraft/client/Minecraft;
    //   10092: getfield field_71460_t : Lnet/minecraft/client/renderer/EntityRenderer;
    //   10095: invokevirtual func_78478_c : ()V
    //   10098: sipush #3042
    //   10101: invokestatic glEnable : (I)V
    //   10104: sipush #2929
    //   10107: invokestatic glDisable : (I)V
    //   10110: iconst_0
    //   10111: invokestatic glDepthMask : (Z)V
    //   10114: sipush #770
    //   10117: sipush #771
    //   10120: invokestatic glBlendFunc : (II)V
    //   10123: fconst_1
    //   10124: fconst_1
    //   10125: fconst_1
    //   10126: fconst_1
    //   10127: invokestatic glColor4f : (FFFF)V
    //   10130: sipush #3008
    //   10133: invokestatic glDisable : (I)V
    //   10136: aload_2
    //   10137: getfield field_71446_o : Lnet/minecraft/client/renderer/texture/TextureManager;
    //   10140: aload #27
    //   10142: invokestatic getScope : (Ljava/lang/String;)Lnet/minecraft/util/ResourceLocation;
    //   10145: invokevirtual func_110577_a : (Lnet/minecraft/util/ResourceLocation;)V
    //   10148: aload #7
    //   10150: invokevirtual func_78382_b : ()V
    //   10153: aload #7
    //   10155: iload #5
    //   10157: iconst_2
    //   10158: idiv
    //   10159: iconst_2
    //   10160: iload #6
    //   10162: imul
    //   10163: isub
    //   10164: i2d
    //   10165: iload #6
    //   10167: i2d
    //   10168: ldc2_w -90.0
    //   10171: dconst_0
    //   10172: dconst_1
    //   10173: invokevirtual func_78374_a : (DDDDD)V
    //   10176: aload #7
    //   10178: iload #5
    //   10180: iconst_2
    //   10181: idiv
    //   10182: iconst_2
    //   10183: iload #6
    //   10185: imul
    //   10186: iadd
    //   10187: i2d
    //   10188: iload #6
    //   10190: i2d
    //   10191: ldc2_w -90.0
    //   10194: dconst_1
    //   10195: dconst_1
    //   10196: invokevirtual func_78374_a : (DDDDD)V
    //   10199: aload #7
    //   10201: iload #5
    //   10203: iconst_2
    //   10204: idiv
    //   10205: iconst_2
    //   10206: iload #6
    //   10208: imul
    //   10209: iadd
    //   10210: i2d
    //   10211: dconst_0
    //   10212: ldc2_w -90.0
    //   10215: dconst_1
    //   10216: dconst_0
    //   10217: invokevirtual func_78374_a : (DDDDD)V
    //   10220: aload #7
    //   10222: iload #5
    //   10224: iconst_2
    //   10225: idiv
    //   10226: iconst_2
    //   10227: iload #6
    //   10229: imul
    //   10230: isub
    //   10231: i2d
    //   10232: dconst_0
    //   10233: ldc2_w -90.0
    //   10236: dconst_0
    //   10237: dconst_0
    //   10238: invokevirtual func_78374_a : (DDDDD)V
    //   10241: aload #7
    //   10243: invokevirtual func_78381_a : ()I
    //   10246: pop
    //   10247: iconst_1
    //   10248: invokestatic glDepthMask : (Z)V
    //   10251: sipush #2929
    //   10254: invokestatic glEnable : (I)V
    //   10257: sipush #3008
    //   10260: invokestatic glEnable : (I)V
    //   10263: fconst_1
    //   10264: fconst_1
    //   10265: fconst_1
    //   10266: fconst_1
    //   10267: invokestatic glColor4f : (FFFF)V
    //   10270: aload #13
    //   10272: checkcast com/flansmod/common/driveables/EntityVehicle
    //   10275: invokevirtual getVehicleType : ()Lcom/flansmod/common/driveables/VehicleType;
    //   10278: getfield airship : Z
    //   10281: ifeq -> 10325
    //   10284: aload_2
    //   10285: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10288: ldc_w 'Diving Throttle : %.0f%%'
    //   10291: iconst_1
    //   10292: anewarray java/lang/Object
    //   10295: dup
    //   10296: iconst_0
    //   10297: aload #13
    //   10299: getfield divingFactor : F
    //   10302: ldc_w 100.0
    //   10305: fmul
    //   10306: invokestatic valueOf : (F)Ljava/lang/Float;
    //   10309: aastore
    //   10310: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10313: sipush #172
    //   10316: bipush #32
    //   10318: ldc_w 16777215
    //   10321: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10324: pop
    //   10325: aload #13
    //   10327: checkcast com/flansmod/common/driveables/EntityVehicle
    //   10330: invokevirtual getVehicleType : ()Lcom/flansmod/common/driveables/VehicleType;
    //   10333: getfield canDive : Z
    //   10336: ifeq -> 10594
    //   10339: aload_2
    //   10340: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10343: ldc_w 'Diving Throttle : %.0f%%'
    //   10346: iconst_1
    //   10347: anewarray java/lang/Object
    //   10350: dup
    //   10351: iconst_0
    //   10352: aload #13
    //   10354: getfield divingFactor : F
    //   10357: ldc_w 100.0
    //   10360: fmul
    //   10361: invokestatic valueOf : (F)Ljava/lang/Float;
    //   10364: aastore
    //   10365: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   10368: sipush #172
    //   10371: bipush #52
    //   10373: ldc_w 16777215
    //   10376: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10379: pop
    //   10380: aload #24
    //   10382: checkcast com/flansmod/common/driveables/EntityVehicle
    //   10385: invokevirtual getVehicleType : ()Lcom/flansmod/common/driveables/VehicleType;
    //   10388: getfield unlimitedOxygen : Z
    //   10391: ifne -> 10437
    //   10394: aload_2
    //   10395: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10398: new java/lang/StringBuilder
    //   10401: dup
    //   10402: invokespecial <init> : ()V
    //   10405: ldc_w 'Oxygen (Seconds) : '
    //   10408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10411: aload #13
    //   10413: getfield oxygenMeter : F
    //   10416: ldc_w 160.0
    //   10419: fdiv
    //   10420: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   10423: invokevirtual toString : ()Ljava/lang/String;
    //   10426: sipush #172
    //   10429: bipush #62
    //   10431: iload #20
    //   10433: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10436: pop
    //   10437: aload #24
    //   10439: checkcast com/flansmod/common/driveables/EntityVehicle
    //   10442: invokevirtual getVehicleType : ()Lcom/flansmod/common/driveables/VehicleType;
    //   10445: getfield unlimitedOxygen : Z
    //   10448: iconst_1
    //   10449: if_icmpne -> 10470
    //   10452: aload_2
    //   10453: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10456: ldc_w 'Unlimited Oxygen'
    //   10459: sipush #172
    //   10462: bipush #62
    //   10464: iload #20
    //   10466: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10469: pop
    //   10470: getstatic com/flansmod/common/teams/TeamsManager.seaLevel : I
    //   10473: i2d
    //   10474: aload #24
    //   10476: getfield field_70163_u : D
    //   10479: dsub
    //   10480: d2i
    //   10481: istore #26
    //   10483: iload #26
    //   10485: ifle -> 10594
    //   10488: aload_2
    //   10489: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10492: new java/lang/StringBuilder
    //   10495: dup
    //   10496: invokespecial <init> : ()V
    //   10499: ldc_w 'Depth : '
    //   10502: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10505: iload #26
    //   10507: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   10510: invokevirtual toString : ()Ljava/lang/String;
    //   10513: iconst_2
    //   10514: bipush #72
    //   10516: iload #20
    //   10518: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10521: pop
    //   10522: iload #26
    //   10524: i2f
    //   10525: aload #25
    //   10527: getfield maxDepth : F
    //   10530: fdiv
    //   10531: f2d
    //   10532: ldc2_w 0.7
    //   10535: dcmpl
    //   10536: ifle -> 10558
    //   10539: aload_2
    //   10540: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10543: ldc_w 'WARNING : Aproaching Max Depth'
    //   10546: sipush #172
    //   10549: bipush #82
    //   10551: ldc_w 14329120
    //   10554: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10557: pop
    //   10558: iload #26
    //   10560: i2f
    //   10561: aload #25
    //   10563: getfield maxDepth : F
    //   10566: fdiv
    //   10567: f2d
    //   10568: ldc2_w 0.9
    //   10571: dcmpl
    //   10572: ifle -> 10594
    //   10575: aload_2
    //   10576: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10579: ldc_w 'DANGER : COLLAPSE IMMINENT'
    //   10582: sipush #172
    //   10585: bipush #92
    //   10587: ldc_w 16711680
    //   10590: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10593: pop
    //   10594: aload #13
    //   10596: checkcast com/flansmod/common/driveables/EntityVehicle
    //   10599: invokevirtual getDriveableType : ()Lcom/flansmod/common/driveables/DriveableType;
    //   10602: getfield showReload : Z
    //   10605: ifeq -> 10724
    //   10608: aload #23
    //   10610: getfield fakeReloadShell : F
    //   10613: ldc_w 40.0
    //   10616: fcmpl
    //   10617: ifle -> 10666
    //   10620: aload_2
    //   10621: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10624: new java/lang/StringBuilder
    //   10627: dup
    //   10628: invokespecial <init> : ()V
    //   10631: ldc_w 'First Shot Delay (Seconds) : '
    //   10634: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10637: aload #23
    //   10639: getfield fakeReloadShell : F
    //   10642: ldc_w 20.0
    //   10645: fsub
    //   10646: ldc_w 20.0
    //   10649: fdiv
    //   10650: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   10653: invokevirtual toString : ()Ljava/lang/String;
    //   10656: iconst_2
    //   10657: bipush #62
    //   10659: ldc_w 14329120
    //   10662: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10665: pop
    //   10666: aload #23
    //   10668: getfield fakeReloadMissile : F
    //   10671: ldc_w 40.0
    //   10674: fcmpl
    //   10675: ifle -> 10724
    //   10678: aload_2
    //   10679: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10682: new java/lang/StringBuilder
    //   10685: dup
    //   10686: invokespecial <init> : ()V
    //   10689: ldc_w 'First Shot Delay (Seconds) : '
    //   10692: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10695: aload #23
    //   10697: getfield fakeReloadMissile : F
    //   10700: ldc_w 20.0
    //   10703: fsub
    //   10704: ldc_w 20.0
    //   10707: fdiv
    //   10708: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   10711: invokevirtual toString : ()Ljava/lang/String;
    //   10714: iconst_2
    //   10715: bipush #72
    //   10717: ldc_w 14329120
    //   10720: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10723: pop
    //   10724: aload #13
    //   10726: checkcast com/flansmod/common/driveables/EntityVehicle
    //   10729: invokevirtual getVehicleType : ()Lcom/flansmod/common/driveables/VehicleType;
    //   10732: getfield shootWithOpenDoor : Z
    //   10735: ifeq -> 10892
    //   10738: aload #13
    //   10740: checkcast com/flansmod/common/driveables/EntityVehicle
    //   10743: getfield varDoor : Z
    //   10746: ifeq -> 10815
    //   10749: aload_2
    //   10750: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10753: ldc_w 'Weapon : READY'
    //   10756: iconst_2
    //   10757: bipush #62
    //   10759: ldc_w 65280
    //   10762: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10765: pop
    //   10766: aload_2
    //   10767: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10770: new java/lang/StringBuilder
    //   10773: dup
    //   10774: invokespecial <init> : ()V
    //   10777: ldc_w '['
    //   10780: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10783: getstatic com/flansmod/client/KeyInputHandler.doorKey : Lnet/minecraft/client/settings/KeyBinding;
    //   10786: invokevirtual func_151463_i : ()I
    //   10789: invokestatic getKeyName : (I)Ljava/lang/String;
    //   10792: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10795: ldc_w ' to disable]'
    //   10798: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10801: invokevirtual toString : ()Ljava/lang/String;
    //   10804: bipush #100
    //   10806: bipush #62
    //   10808: ldc_w 65280
    //   10811: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10814: pop
    //   10815: aload #13
    //   10817: checkcast com/flansmod/common/driveables/EntityVehicle
    //   10820: getfield varDoor : Z
    //   10823: ifne -> 10892
    //   10826: aload_2
    //   10827: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10830: ldc_w 'Weapon : DISABLED'
    //   10833: iconst_2
    //   10834: bipush #62
    //   10836: ldc_w 16711680
    //   10839: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10842: pop
    //   10843: aload_2
    //   10844: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10847: new java/lang/StringBuilder
    //   10850: dup
    //   10851: invokespecial <init> : ()V
    //   10854: ldc_w '['
    //   10857: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10860: getstatic com/flansmod/client/KeyInputHandler.doorKey : Lnet/minecraft/client/settings/KeyBinding;
    //   10863: invokevirtual func_151463_i : ()I
    //   10866: invokestatic getKeyName : (I)Ljava/lang/String;
    //   10869: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10872: ldc_w ' to activate]'
    //   10875: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10878: invokevirtual toString : ()Ljava/lang/String;
    //   10881: bipush #100
    //   10883: bipush #62
    //   10885: ldc_w 16711680
    //   10888: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10891: pop
    //   10892: getstatic com/flansmod/common/FlansMod.DEBUG : Z
    //   10895: ifeq -> 11056
    //   10898: aload #13
    //   10900: getfield epicShip : Z
    //   10903: ifne -> 11056
    //   10906: aload_2
    //   10907: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10910: new java/lang/StringBuilder
    //   10913: dup
    //   10914: invokespecial <init> : ()V
    //   10917: ldc_w 'MotionX : '
    //   10920: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10923: aload #13
    //   10925: getfield field_70159_w : D
    //   10928: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   10931: invokevirtual toString : ()Ljava/lang/String;
    //   10934: iconst_2
    //   10935: bipush #32
    //   10937: ldc_w 16777215
    //   10940: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10943: pop
    //   10944: aload_2
    //   10945: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10948: new java/lang/StringBuilder
    //   10951: dup
    //   10952: invokespecial <init> : ()V
    //   10955: ldc_w 'MotionY : '
    //   10958: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10961: aload #13
    //   10963: getfield field_70181_x : D
    //   10966: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   10969: invokevirtual toString : ()Ljava/lang/String;
    //   10972: iconst_2
    //   10973: bipush #42
    //   10975: ldc_w 16777215
    //   10978: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   10981: pop
    //   10982: aload_2
    //   10983: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   10986: new java/lang/StringBuilder
    //   10989: dup
    //   10990: invokespecial <init> : ()V
    //   10993: ldc_w 'MotionZ : '
    //   10996: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10999: aload #13
    //   11001: getfield field_70179_y : D
    //   11004: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   11007: invokevirtual toString : ()Ljava/lang/String;
    //   11010: iconst_2
    //   11011: bipush #52
    //   11013: ldc_w 16777215
    //   11016: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   11019: pop
    //   11020: aload_2
    //   11021: getfield field_71466_p : Lnet/minecraft/client/gui/FontRenderer;
    //   11024: new java/lang/StringBuilder
    //   11027: dup
    //   11028: invokespecial <init> : ()V
    //   11031: ldc_w 'Break Blocks : '
    //   11034: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11037: getstatic com/flansmod/common/teams/TeamsManager.driveablesBreakBlocks : Z
    //   11040: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   11043: invokevirtual toString : ()Ljava/lang/String;
    //   11046: iconst_2
    //   11047: bipush #62
    //   11049: ldc_w 16777215
    //   11052: invokevirtual func_78276_b : (Ljava/lang/String;III)I
    //   11055: pop
    //   11056: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #119	-> 0
    //   #120	-> 4
    //   #127	-> 14
    //   #129	-> 42
    //   #138	-> 79
    //   #141	-> 92
    //   #143	-> 107
    //   #146	-> 115
    //   #164	-> 122
    //   #165	-> 144
    //   #167	-> 163
    //   #168	-> 168
    //   #182	-> 169
    //   #184	-> 222
    //   #186	-> 261
    //   #187	-> 266
    //   #194	-> 267
    //   #195	-> 291
    //   #196	-> 298
    //   #198	-> 305
    //   #203	-> 310
    //   #210	-> 327
    //   #211	-> 330
    //   #213	-> 369
    //   #215	-> 382
    //   #217	-> 389
    //   #218	-> 403
    //   #221	-> 419
    //   #222	-> 476
    //   #223	-> 484
    //   #224	-> 579
    //   #226	-> 587
    //   #228	-> 603
    //   #230	-> 608
    //   #232	-> 616
    //   #233	-> 633
    //   #236	-> 650
    //   #238	-> 670
    //   #242	-> 675
    //   #244	-> 695
    //   #248	-> 700
    //   #250	-> 720
    //   #254	-> 725
    //   #256	-> 745
    //   #260	-> 750
    //   #262	-> 770
    //   #266	-> 775
    //   #268	-> 795
    //   #271	-> 800
    //   #273	-> 820
    //   #276	-> 825
    //   #278	-> 845
    //   #281	-> 850
    //   #283	-> 860
    //   #289	-> 865
    //   #291	-> 870
    //   #292	-> 879
    //   #293	-> 885
    //   #294	-> 891
    //   #295	-> 895
    //   #296	-> 904
    //   #297	-> 911
    //   #299	-> 917
    //   #301	-> 929
    //   #302	-> 934
    //   #303	-> 957
    //   #304	-> 980
    //   #305	-> 1001
    //   #306	-> 1022
    //   #307	-> 1028
    //   #308	-> 1032
    //   #309	-> 1038
    //   #310	-> 1044
    //   #314	-> 1051
    //   #317	-> 1074
    //   #324	-> 1081
    //   #325	-> 1091
    //   #326	-> 1129
    //   #327	-> 1137
    //   #336	-> 1156
    //   #337	-> 1168
    //   #339	-> 1184
    //   #340	-> 1194
    //   #341	-> 1201
    //   #342	-> 1204
    //   #344	-> 1219
    //   #345	-> 1236
    //   #347	-> 1262
    //   #348	-> 1265
    //   #349	-> 1271
    //   #350	-> 1283
    //   #351	-> 1308
    //   #352	-> 1314
    //   #353	-> 1317
    //   #354	-> 1357
    //   #356	-> 1367
    //   #358	-> 1406
    //   #359	-> 1415
    //   #360	-> 1420
    //   #361	-> 1446
    //   #362	-> 1474
    //   #342	-> 1491
    //   #367	-> 1497
    //   #375	-> 1509
    //   #377	-> 1525
    //   #378	-> 1544
    //   #380	-> 1560
    //   #381	-> 1573
    //   #382	-> 1576
    //   #384	-> 1591
    //   #385	-> 1608
    //   #388	-> 1634
    //   #389	-> 1674
    //   #391	-> 1684
    //   #393	-> 1723
    //   #394	-> 1732
    //   #397	-> 1737
    //   #398	-> 1740
    //   #399	-> 1747
    //   #400	-> 1753
    //   #401	-> 1765
    //   #402	-> 1790
    //   #405	-> 1807
    //   #406	-> 1813
    //   #407	-> 1816
    //   #408	-> 1842
    //   #382	-> 1870
    //   #416	-> 1876
    //   #418	-> 1881
    //   #420	-> 1931
    //   #421	-> 1937
    //   #422	-> 1943
    //   #423	-> 1947
    //   #424	-> 1956
    //   #425	-> 1963
    //   #427	-> 1969
    //   #429	-> 1979
    //   #430	-> 1984
    //   #431	-> 2009
    //   #432	-> 2034
    //   #433	-> 2055
    //   #434	-> 2076
    //   #437	-> 2082
    //   #440	-> 2101
    //   #441	-> 2117
    //   #442	-> 2160
    //   #443	-> 2165
    //   #444	-> 2188
    //   #445	-> 2213
    //   #446	-> 2236
    //   #447	-> 2257
    //   #449	-> 2263
    //   #450	-> 2279
    //   #451	-> 2322
    //   #452	-> 2327
    //   #453	-> 2352
    //   #454	-> 2377
    //   #455	-> 2400
    //   #456	-> 2423
    //   #458	-> 2429
    //   #459	-> 2433
    //   #460	-> 2439
    //   #461	-> 2445
    //   #464	-> 2452
    //   #465	-> 2500
    //   #466	-> 2550
    //   #467	-> 2636
    //   #470	-> 2724
    //   #471	-> 2767
    //   #472	-> 2812
    //   #473	-> 2888
    //   #475	-> 2966
    //   #476	-> 2977
    //   #477	-> 2984
    //   #478	-> 2991
    //   #479	-> 3053
    //   #480	-> 3084
    //   #483	-> 3115
    //   #484	-> 3119
    //   #485	-> 3125
    //   #486	-> 3131
    //   #489	-> 3138
    //   #490	-> 3184
    //   #491	-> 3231
    //   #492	-> 3278
    //   #494	-> 3325
    //   #495	-> 3357
    //   #496	-> 3465
    //   #498	-> 3468
    //   #499	-> 3500
    //   #500	-> 3608
    //   #503	-> 3611
    //   #504	-> 3614
    //   #505	-> 3621
    //   #506	-> 3627
    //   #507	-> 3639
    //   #508	-> 3671
    //   #509	-> 3745
    //   #510	-> 3748
    //   #511	-> 3754
    //   #514	-> 3757
    //   #516	-> 3767
    //   #517	-> 3779
    //   #519	-> 3791
    //   #521	-> 3824
    //   #523	-> 3834
    //   #525	-> 3846
    //   #526	-> 3851
    //   #527	-> 3884
    //   #528	-> 3917
    //   #529	-> 3949
    //   #530	-> 3981
    //   #532	-> 3990
    //   #534	-> 4006
    //   #535	-> 4011
    //   #536	-> 4042
    //   #537	-> 4075
    //   #538	-> 4107
    //   #539	-> 4137
    //   #521	-> 4143
    //   #551	-> 4149
    //   #552	-> 4157
    //   #635	-> 4164
    //   #638	-> 4196
    //   #639	-> 4217
    //   #641	-> 4222
    //   #642	-> 4231
    //   #643	-> 4237
    //   #644	-> 4243
    //   #645	-> 4247
    //   #646	-> 4256
    //   #647	-> 4263
    //   #649	-> 4269
    //   #651	-> 4281
    //   #652	-> 4286
    //   #653	-> 4309
    //   #654	-> 4332
    //   #655	-> 4353
    //   #656	-> 4374
    //   #657	-> 4380
    //   #658	-> 4384
    //   #659	-> 4390
    //   #660	-> 4396
    //   #662	-> 4403
    //   #664	-> 4455
    //   #665	-> 4458
    //   #666	-> 4490
    //   #673	-> 4527
    //   #676	-> 4540
    //   #677	-> 4555
    //   #679	-> 4571
    //   #681	-> 4650
    //   #682	-> 4659
    //   #683	-> 4662
    //   #690	-> 4665
    //   #691	-> 4708
    //   #693	-> 4727
    //   #694	-> 4757
    //   #696	-> 4779
    //   #700	-> 4782
    //   #702	-> 4790
    //   #704	-> 4797
    //   #705	-> 4805
    //   #768	-> 4821
    //   #769	-> 4871
    //   #770	-> 4874
    //   #771	-> 4881
    //   #772	-> 4889
    //   #773	-> 4903
    //   #774	-> 4911
    //   #775	-> 4925
    //   #777	-> 4933
    //   #780	-> 4938
    //   #784	-> 4945
    //   #785	-> 4948
    //   #786	-> 4969
    //   #787	-> 4977
    //   #788	-> 5011
    //   #789	-> 5019
    //   #790	-> 5053
    //   #791	-> 5061
    //   #792	-> 5082
    //   #794	-> 5090
    //   #797	-> 5095
    //   #798	-> 5111
    //   #800	-> 5122
    //   #801	-> 5129
    //   #802	-> 5132
    //   #803	-> 5141
    //   #807	-> 5146
    //   #809	-> 5162
    //   #810	-> 5170
    //   #811	-> 5207
    //   #813	-> 5215
    //   #814	-> 5222
    //   #815	-> 5242
    //   #816	-> 5257
    //   #817	-> 5277
    //   #818	-> 5328
    //   #819	-> 5339
    //   #820	-> 5378
    //   #821	-> 5398
    //   #822	-> 5416
    //   #823	-> 5424
    //   #825	-> 5461
    //   #829	-> 5495
    //   #830	-> 5514
    //   #833	-> 5564
    //   #835	-> 5595
    //   #838	-> 5635
    //   #839	-> 5654
    //   #842	-> 5677
    //   #844	-> 5693
    //   #852	-> 5733
    //   #854	-> 5751
    //   #857	-> 5775
    //   #859	-> 5783
    //   #860	-> 5833
    //   #861	-> 5867
    //   #862	-> 5870
    //   #863	-> 5879
    //   #864	-> 5887
    //   #865	-> 5905
    //   #866	-> 5913
    //   #867	-> 5931
    //   #869	-> 5939
    //   #872	-> 5944
    //   #873	-> 5947
    //   #874	-> 5956
    //   #875	-> 5964
    //   #876	-> 5978
    //   #877	-> 5986
    //   #878	-> 6000
    //   #880	-> 6008
    //   #882	-> 6013
    //   #883	-> 6077
    //   #884	-> 6086
    //   #885	-> 6110
    //   #886	-> 6128
    //   #887	-> 6152
    //   #888	-> 6170
    //   #889	-> 6194
    //   #890	-> 6212
    //   #891	-> 6236
    //   #892	-> 6245
    //   #897	-> 6269
    //   #902	-> 6328
    //   #906	-> 6336
    //   #908	-> 6344
    //   #909	-> 6396
    //   #913	-> 6443
    //   #914	-> 6461
    //   #916	-> 6466
    //   #918	-> 6484
    //   #920	-> 6492
    //   #922	-> 6510
    //   #924	-> 6518
    //   #926	-> 6536
    //   #928	-> 6544
    //   #930	-> 6562
    //   #932	-> 6570
    //   #934	-> 6606
    //   #936	-> 6614
    //   #938	-> 6632
    //   #940	-> 6640
    //   #942	-> 6658
    //   #944	-> 6666
    //   #946	-> 6684
    //   #949	-> 6692
    //   #954	-> 6697
    //   #956	-> 6708
    //   #957	-> 6717
    //   #958	-> 6723
    //   #959	-> 6729
    //   #960	-> 6733
    //   #961	-> 6742
    //   #962	-> 6749
    //   #964	-> 6755
    //   #966	-> 6774
    //   #967	-> 6779
    //   #970	-> 6811
    //   #973	-> 6841
    //   #977	-> 6871
    //   #980	-> 6903
    //   #981	-> 6909
    //   #982	-> 6913
    //   #983	-> 6919
    //   #984	-> 6925
    //   #994	-> 6932
    //   #996	-> 6959
    //   #999	-> 6981
    //   #1003	-> 6991
    //   #1004	-> 7023
    //   #1008	-> 7044
    //   #1009	-> 7066
    //   #1010	-> 7088
    //   #1013	-> 7110
    //   #1014	-> 7132
    //   #1015	-> 7154
    //   #1018	-> 7176
    //   #1019	-> 7198
    //   #1020	-> 7220
    //   #1023	-> 7242
    //   #1026	-> 7261
    //   #1029	-> 7280
    //   #1031	-> 7299
    //   #1036	-> 7304
    //   #1037	-> 7320
    //   #1040	-> 7345
    //   #1041	-> 7363
    //   #1053	-> 7367
    //   #1054	-> 7374
    //   #1055	-> 7408
    //   #1056	-> 7417
    //   #1063	-> 7443
    //   #1064	-> 7452
    //   #1073	-> 7478
    //   #1075	-> 7486
    //   #1076	-> 7490
    //   #1078	-> 7501
    //   #1079	-> 7517
    //   #1081	-> 7534
    //   #1082	-> 7542
    //   #1084	-> 7559
    //   #1085	-> 7567
    //   #1087	-> 7584
    //   #1089	-> 7600
    //   #1090	-> 7663
    //   #1091	-> 7726
    //   #1092	-> 7758
    //   #1094	-> 7776
    //   #1095	-> 7808
    //   #1097	-> 7826
    //   #1098	-> 7858
    //   #1100	-> 7876
    //   #1101	-> 7908
    //   #1103	-> 7926
    //   #1104	-> 7958
    //   #1106	-> 7976
    //   #1107	-> 8008
    //   #1109	-> 8026
    //   #1110	-> 8058
    //   #1112	-> 8076
    //   #1113	-> 8108
    //   #1116	-> 8126
    //   #1118	-> 8190
    //   #1119	-> 8201
    //   #1121	-> 8241
    //   #1122	-> 8256
    //   #1125	-> 8315
    //   #1126	-> 8323
    //   #1132	-> 8373
    //   #1134	-> 8384
    //   #1135	-> 8459
    //   #1137	-> 8503
    //   #1139	-> 8553
    //   #1143	-> 8572
    //   #1145	-> 8580
    //   #1149	-> 8620
    //   #1151	-> 8639
    //   #1152	-> 8658
    //   #1154	-> 8679
    //   #1155	-> 8698
    //   #1156	-> 8717
    //   #1157	-> 8736
    //   #1158	-> 8755
    //   #1159	-> 8766
    //   #1166	-> 8816
    //   #1168	-> 8824
    //   #1169	-> 8834
    //   #1170	-> 8838
    //   #1172	-> 8849
    //   #1173	-> 8876
    //   #1175	-> 8893
    //   #1176	-> 8912
    //   #1178	-> 8929
    //   #1179	-> 8956
    //   #1182	-> 8973
    //   #1186	-> 8980
    //   #1188	-> 8988
    //   #1189	-> 8998
    //   #1190	-> 9002
    //   #1192	-> 9024
    //   #1193	-> 9040
    //   #1195	-> 9057
    //   #1196	-> 9065
    //   #1198	-> 9082
    //   #1199	-> 9090
    //   #1202	-> 9107
    //   #1204	-> 9132
    //   #1205	-> 9174
    //   #1207	-> 9216
    //   #1209	-> 9266
    //   #1210	-> 9283
    //   #1215	-> 9300
    //   #1216	-> 9319
    //   #1217	-> 9337
    //   #1218	-> 9356
    //   #1219	-> 9374
    //   #1220	-> 9385
    //   #1223	-> 9435
    //   #1225	-> 9448
    //   #1227	-> 9456
    //   #1230	-> 9494
    //   #1232	-> 9503
    //   #1234	-> 9567
    //   #1236	-> 9575
    //   #1244	-> 9594
    //   #1246	-> 9613
    //   #1247	-> 9632
    //   #1253	-> 9653
    //   #1255	-> 9675
    //   #1256	-> 9717
    //   #1258	-> 9734
    //   #1260	-> 9792
    //   #1264	-> 9809
    //   #1265	-> 9817
    //   #1267	-> 9834
    //   #1268	-> 9850
    //   #1271	-> 9867
    //   #1273	-> 9878
    //   #1274	-> 9887
    //   #1277	-> 9904
    //   #1278	-> 9913
    //   #1282	-> 9930
    //   #1286	-> 9940
    //   #1288	-> 9947
    //   #1289	-> 9961
    //   #1290	-> 9964
    //   #1292	-> 9980
    //   #1293	-> 9987
    //   #1296	-> 10028
    //   #1298	-> 10044
    //   #1299	-> 10047
    //   #1304	-> 10084
    //   #1306	-> 10089
    //   #1307	-> 10098
    //   #1308	-> 10104
    //   #1309	-> 10110
    //   #1310	-> 10114
    //   #1311	-> 10123
    //   #1312	-> 10130
    //   #1314	-> 10136
    //   #1316	-> 10148
    //   #1317	-> 10153
    //   #1318	-> 10176
    //   #1319	-> 10199
    //   #1320	-> 10220
    //   #1321	-> 10241
    //   #1322	-> 10247
    //   #1323	-> 10251
    //   #1324	-> 10257
    //   #1325	-> 10263
    //   #1332	-> 10270
    //   #1333	-> 10284
    //   #1337	-> 10325
    //   #1340	-> 10339
    //   #1342	-> 10380
    //   #1343	-> 10394
    //   #1344	-> 10437
    //   #1345	-> 10452
    //   #1348	-> 10470
    //   #1350	-> 10483
    //   #1352	-> 10488
    //   #1354	-> 10522
    //   #1355	-> 10539
    //   #1357	-> 10558
    //   #1358	-> 10575
    //   #1372	-> 10594
    //   #1376	-> 10608
    //   #1377	-> 10620
    //   #1378	-> 10666
    //   #1379	-> 10678
    //   #1385	-> 10724
    //   #1387	-> 10738
    //   #1388	-> 10749
    //   #1389	-> 10766
    //   #1392	-> 10815
    //   #1393	-> 10826
    //   #1394	-> 10843
    //   #1399	-> 10892
    //   #1401	-> 10906
    //   #1402	-> 10944
    //   #1403	-> 10982
    //   #1404	-> 11020
    //   #1408	-> 11056
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   122	47	5	enterinoTank	Lcom/flansmod/common/driveables/EntityVehicle;
    //   107	62	4	enterino	Lcom/flansmod/common/driveables/EntityDriveable;
    //   403	462	9	stack	Lnet/minecraft/item/ItemStack;
    //   608	257	10	teamInfo	Lcom/flansmod/common/network/PacketTeamInfo;
    //   330	721	8	overlayTexture	Ljava/lang/String;
    //   1357	134	14	s	Ljava/lang/String;
    //   1236	255	13	bulletStack	Lnet/minecraft/item/ItemStack;
    //   1207	290	12	n	I
    //   1674	196	17	s	Ljava/lang/String;
    //   1608	262	16	bulletStack	Lnet/minecraft/item/ItemStack;
    //   1579	297	15	n	I
    //   1573	303	14	offHandGunType	Lcom/flansmod/common/guns/GunType;
    //   1544	332	13	offHandStack	Lnet/minecraft/item/ItemStack;
    //   1194	682	9	gunItem	Lcom/flansmod/common/guns/ItemGun;
    //   1201	675	10	gunType	Lcom/flansmod/common/guns/GunType;
    //   1204	672	11	x	I
    //   1509	367	12	data	Lcom/flansmod/common/PlayerData;
    //   1168	708	8	stack	Lnet/minecraft/item/ItemStack;
    //   2117	607	9	colour	I
    //   2977	348	9	secondsLeft	I
    //   2984	341	10	minutesLeft	I
    //   3053	272	11	timeLeft	Ljava/lang/String;
    //   3357	108	10	killMessage	Lcom/flansmod/client/TickHandlerClient$KillMessage;
    //   3500	108	10	killMessage	Lcom/flansmod/client/TickHandlerClient$KillMessageDumb;
    //   3671	74	10	killMessage	Lcom/flansmod/client/TickHandlerClient$KillMessage;
    //   3827	322	11	n	I
    //   4217	238	13	gunnerOverlay	Ljava/lang/String;
    //   4797	24	19	Planerino	Lcom/flansmod/common/driveables/EntityPlane;
    //   5222	342	23	Plane	Lcom/flansmod/common/driveables/EntityPlane;
    //   5833	495	23	healthB	I
    //   5867	461	24	notFlooding	F
    //   5870	458	25	color	I
    //   5947	381	26	kostaColor	I
    //   6461	471	23	tankYaw	F
    //   6466	466	24	tankBarrelerino	Ljava/lang/String;
    //   6981	497	23	pitch	F
    //   6991	487	24	bulletSpeed	F
    //   7066	412	25	A	F
    //   7088	390	26	B	F
    //   7110	368	27	C	F
    //   7132	346	28	Af	F
    //   7154	324	29	Bf	F
    //   7176	302	30	Cf	F
    //   7198	280	31	Am	F
    //   7220	258	32	Bm	F
    //   7242	236	33	Cm	F
    //   7261	217	34	estimatedRange	F
    //   7280	198	35	mortarRange	F
    //   7299	179	36	fieldgunRange	F
    //   7304	174	37	displayRange	F
    //   7490	1326	23	entP	Lcom/flansmod/common/driveables/EntityDriveable;
    //   7600	1216	24	up2	Lcom/flansmod/common/vector/Vector3f;
    //   8834	146	23	datavehicle	Lcom/flansmod/common/driveables/DriveableData;
    //   8838	142	24	entP	Lcom/flansmod/common/driveables/EntityDriveable;
    //   9961	309	26	stack	Lnet/minecraft/item/ItemStack;
    //   9964	306	27	overlayTexture	Ljava/lang/String;
    //   10483	111	26	poopooDepth	I
    //   8998	1894	23	datavehicle	Lcom/flansmod/common/driveables/DriveableData;
    //   9002	1890	24	entP	Lcom/flansmod/common/driveables/EntityDriveable;
    //   9940	952	25	allah	Lcom/flansmod/common/driveables/DriveableType;
    //   4555	6501	13	ent	Lcom/flansmod/common/driveables/EntityDriveable;
    //   4571	6485	14	forwards	Lcom/flansmod/common/vector/Vector3f;
    //   4650	6406	15	speed	F
    //   4659	6397	16	advancedSpeed	F
    //   4662	6394	17	cringedUniversalBuff	F
    //   4665	6391	18	Mach	F
    //   4871	6185	19	healthP	I
    //   4874	6182	20	colour	I
    //   4945	6111	21	fakeThrottle	F
    //   4948	6108	22	colourThrottle	I
    //   1881	9175	8	teamInfo	Lcom/flansmod/common/network/PacketTeamInfo;
    //   3779	7277	9	currentStack	Lnet/minecraft/item/ItemStack;
    //   3791	7265	10	data	Lcom/flansmod/common/PlayerData;
    //   4157	6899	11	player	Lnet/minecraft/entity/player/EntityPlayer;
    //   4164	6892	12	currentHeldItem	Lnet/minecraft/item/ItemStack;
    //   0	11057	0	this	Lcom/flansmod/client/TickHandlerClient;
    //   0	11057	1	event	Lnet/minecraftforge/client/event/RenderGameOverlayEvent;
    //   4	11053	2	mc	Lnet/minecraft/client/Minecraft;
    //   14	11043	3	playerUsername	Ljava/lang/String;
    //   291	10766	4	scaledresolution	Lnet/minecraft/client/gui/ScaledResolution;
    //   298	10759	5	i	I
    //   305	10752	6	j	I
    //   310	10747	7	tessellator	Lnet/minecraft/client/renderer/Tessellator;
  }
  
  @SubscribeEvent
  public void renderTick(TickEvent.RenderTickEvent event) {
    switch (event.phase) {
      case START:
        RenderGun.smoothing = event.renderTickTime;
        renderTickStart(Minecraft.func_71410_x(), event.renderTickTime);
        break;
      case END:
        renderTickEnd(Minecraft.func_71410_x());
        break;
    } 
  }
  
  @SubscribeEvent
  public void clientTick(TickEvent.ClientTickEvent event) {
    switch (event.phase) {
      case START:
        clientTickStart(Minecraft.func_71410_x());
        break;
      case END:
        clientTickEnd(Minecraft.func_71410_x());
        break;
    } 
  }
  
  public void clientTickStart(Minecraft mc) {
    if (Minecraft.func_71410_x() != null && (Minecraft.func_71410_x()).field_71439_g != null) {
      Entity ridden = (Minecraft.func_71410_x()).field_71439_g.field_70154_o;
      if (lastMount != null && ridden == null)
        FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketChecker()); 
      lastMount = ridden;
      if (ridden != null)
        FlansMod.lastRidden = ridden; 
    } 
    if (this.tickcount > 0)
      this.tickcount--; 
    if (this.tickcountWounded > 0)
      this.tickcountWounded--; 
    if (FlansMod.ticker % lightOverrideRefreshRate == 0 && mc.field_71441_e != null) {
      lightOverrideRefreshRate = mc.field_71474_y.field_74347_j ? 10 : 20;
      for (Vector3i v : blockLightOverrides)
        mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, v.x, v.y, v.z); 
      blockLightOverrides.clear();
      for (Object obj : mc.field_71441_e.field_73010_i) {
        EntityPlayer player = (EntityPlayer)obj;
        ItemStack currentHeldItem = player.func_71045_bC();
        if (currentHeldItem != null && currentHeldItem.func_77973_b() instanceof ItemGun) {
          GunType type = ((ItemGun)currentHeldItem.func_77973_b()).type;
          AttachmentType grip = type.getGrip(currentHeldItem);
          if (grip != null && grip.flashlight)
            for (int i = 0; i < 2; i++) {
              MovingObjectPosition ray = player.func_70614_a((grip.flashlightRange / 2.0F * (i + 1)), 1.0F);
              if (ray != null) {
                int x = ray.field_72311_b;
                int y = ray.field_72312_c;
                int z = ray.field_72309_d;
                int side = ray.field_72310_e;
                switch (side) {
                  case 0:
                    y--;
                    break;
                  case 1:
                    y++;
                    break;
                  case 2:
                    z--;
                    break;
                  case 3:
                    z++;
                    break;
                  case 4:
                    x--;
                    break;
                  case 5:
                    x++;
                    break;
                } 
                blockLightOverrides.add(new Vector3i(x, y, z));
                mc.field_71441_e.func_72915_b(EnumSkyBlock.Block, x, y, z, 12);
                mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y + 1, z);
                mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y - 1, z);
                mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x + 1, y, z);
                mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x - 1, y, z);
                mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y, z + 1);
                mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y, z - 1);
              } 
            }  
          if (type.matchlock)
            for (int i = 0; i < 2; i++) {
              MovingObjectPosition ray = player.func_70614_a((2.0F * (i + 1)), 1.0F);
              if (ray != null) {
                int x = ray.field_72311_b;
                int y = ray.field_72312_c;
                int z = ray.field_72309_d;
                int side = ray.field_72310_e;
                switch (side) {
                  case 0:
                    y--;
                    break;
                  case 1:
                    y++;
                    break;
                  case 2:
                    z--;
                    break;
                  case 3:
                    z++;
                    break;
                  case 4:
                    x--;
                    break;
                  case 5:
                    x++;
                    break;
                } 
                blockLightOverrides.add(new Vector3i(x, y, z));
                mc.field_71441_e.func_72915_b(EnumSkyBlock.Block, x, y, z, 15);
                mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y + 1, z);
                mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y - 1, z);
                mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x + 1, y, z);
                mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x - 1, y, z);
                mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y, z + 1);
                mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y, z - 1);
              } 
            }  
        } 
      } 
      for (Object obj : mc.field_71441_e.field_72996_f) {
        if (obj instanceof EntityLiving && (Minecraft.func_71410_x()).field_71460_t.func_147702_a()) {
          EntityLiving bullet = (EntityLiving)obj;
          bullet.func_70070_b(1.572888E7F);
          if (obj instanceof EntityPlayer) {
            EntityPlayer human = (EntityPlayer)obj;
            human.func_70070_b(1.572888E7F);
            int x = MathHelper.func_76128_c(human.field_70165_t);
            int y = MathHelper.func_76128_c(human.field_70163_u);
            int z = MathHelper.func_76128_c(human.field_70161_v);
            blockLightOverrides.add(new Vector3i(x, y, z));
            mc.field_71441_e.func_72915_b(EnumSkyBlock.Block, x, y, z, 10);
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y + 1, z);
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y - 1, z);
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x + 1, y, z);
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x - 1, y, z);
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y, z + 1);
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y, z - 1);
          } 
        } 
        if (obj instanceof EntityBullet) {
          EntityBullet bullet = (EntityBullet)obj;
          if (!bullet.field_70128_L && bullet.type.hasLight)
            continue; 
          if (!bullet.field_70128_L || bullet.type.hasLight);
          continue;
        } 
        if (obj instanceof EntityMecha) {
          EntityMecha mecha = (EntityMecha)obj;
          int x = MathHelper.func_76128_c(mecha.field_70165_t);
          int y = MathHelper.func_76128_c(mecha.field_70163_u);
          int z = MathHelper.func_76128_c(mecha.field_70161_v);
          if (mecha.lightLevel() > 0) {
            blockLightOverrides.add(new Vector3i(x, y, z));
            mc.field_71441_e.func_72915_b(EnumSkyBlock.Block, x, y, z, Math.max(mc.field_71441_e.func_72957_l(x, y, z), mecha.lightLevel()));
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x + 1, y, z);
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x - 1, y + 1, z);
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y + 1, z);
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y - 1, z);
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y, z + 1);
            mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, x, y, z - 1);
          } 
          if (mecha.forceDark())
            for (int i = -3; i <= 3; i++) {
              for (int j = -3; j <= 3; j++) {
                for (int k = -3; k <= 3; k++) {
                  int xd = i + x;
                  int yd = j + y;
                  int zd = k + z;
                  blockLightOverrides.add(new Vector3i(xd, yd, zd));
                  mc.field_71441_e.func_72915_b(EnumSkyBlock.Sky, xd, yd, zd, Math.abs(i) + Math.abs(j) + Math.abs(k));
                } 
              } 
            }  
        } 
      } 
    } 
    if (FlansMod.ticker % vehicleLightOverrideRefreshRate == 0 && mc.field_71441_e != null) {
      vehicleLightOverrideRefreshRate = mc.field_71474_y.field_74347_j ? 1 : 2;
      for (Vector3i v : vehicleLightOverrides)
        mc.field_71441_e.func_147463_c(EnumSkyBlock.Block, v.x, v.y, v.z); 
      vehicleLightOverrides.clear();
    } 
  }
  
  public void clientTickEnd(Minecraft minecraft) {
    for (int i = 0; i < killMessages.size(); i++) {
      ((KillMessage)killMessages.get(i)).timer--;
      if (((KillMessage)killMessages.get(i)).timer == 0)
        killMessages.remove(i); 
    } 
    RenderFlag.angle += 2.0F;
    FlansModClient.tick();
  }
  
  public void renderTickStart(Minecraft mc, float smoothing) {
    if (mc.field_71462_r == null && FlansModClient.controlModeMouse) {
      MouseHelper mouse = mc.field_71417_B;
      Entity ridden = mc.field_71439_g.field_70154_o;
      if (ridden instanceof EntityDriveable) {
        EntityDriveable entity = (EntityDriveable)ridden;
        entity.onMouseMoved(mouse.field_74377_a, mouse.field_74375_b);
      } 
    } 
    FlansModClient.renderTick(smoothing);
    if (mc.field_71462_r instanceof com.flansmod.client.gui.GuiDriveableController) {
      guiDriveableController = mc.field_71462_r;
      mc.field_71462_r = null;
    } else {
      guiDriveableController = null;
    } 
  }
  
  public void renderTickEnd(Minecraft mc) {
    if (mc.field_71462_r == null && guiDriveableController != null) {
      mc.field_71462_r = guiDriveableController;
      guiDriveableController = null;
    } 
    Tessellator tessellator = Tessellator.field_78398_a;
    ScaledResolution scaledresolution = new ScaledResolution(FlansModClient.minecraft, FlansModClient.minecraft.field_71443_c, FlansModClient.minecraft.field_71440_d);
    int i = scaledresolution.func_78326_a();
    int j = scaledresolution.func_78328_b();
    if (FlansModClient.isInFlash) {
      this.isInFlash = true;
      this.flashTime = FlansModClient.flashTime;
      this.tickcountflash = 0;
      FlansModClient.isInFlash = false;
      FlansModClient.flashTime = 0;
    } 
    if (this.isInFlash && this.tickcountflash < this.flashTime) {
      FlansModClient.minecraft.field_71460_t.func_78478_c();
      GL11.glEnable(3042);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3008);
      mc.field_71446_o.func_110577_a(new ResourceLocation("flansmod", "gui/flash.png"));
      tessellator.func_78382_b();
      tessellator.func_78374_a((i / 2 - 2 * j), j, -90.0D, 0.0D, 1.0D);
      tessellator.func_78374_a((i / 2 + 2 * j), j, -90.0D, 1.0D, 1.0D);
      tessellator.func_78374_a((i / 2 + 2 * j), 0.0D, -90.0D, 1.0D, 0.0D);
      tessellator.func_78374_a((i / 2 - 2 * j), 0.0D, -90.0D, 0.0D, 0.0D);
      tessellator.func_78381_a();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(3008);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.tickcountflash++;
    } else {
      this.isInFlash = false;
      this.flashTime = 0;
      this.tickcountflash = 0;
    } 
  }
  
  private void drawSlotInventory(FontRenderer fontRenderer, ItemStack itemstack, int i, int j) {
    if (itemstack == null || itemstack.func_77973_b() == null)
      return; 
    itemRenderer.func_77015_a(fontRenderer, FlansModClient.minecraft.field_71446_o, itemstack, i, j);
    itemRenderer.func_77021_b(fontRenderer, FlansModClient.minecraft.field_71446_o, itemstack, i, j);
  }
  
  public static void addKillMessage(boolean headshot, InfoType infoType, int itmDmg, String killer, String killed) {
    for (KillMessage killMessage : killMessages) {
      killMessage.line++;
      if (killMessage.line > 10)
        killMessage.timer = 0; 
    } 
    killMessages.add(new KillMessage(headshot, infoType, itmDmg, killer, killed));
  }
  
  public static void addKillMessageDumb(String killer, String killed) {
    for (KillMessage killMessage : killMessages) {
      killMessage.line++;
      if (killMessage.line > 10)
        killMessage.timer = 0; 
    } 
    killMessagesDumb.add(new KillMessageDumb(killer, killed));
  }
  
  private static RenderItem itemRenderer = new RenderItem();
  
  private static List<KillMessage> killMessages = new ArrayList<>();
  
  private static List<KillMessageDumb> killMessagesDumb = new ArrayList<>();
  
  private static class KillMessageDumb {
    public String killerName;
    
    public String killedName;
    
    public int timer;
    
    public int line;
    
    public KillMessageDumb(String killer, String killed) {
      this.killerName = killer;
      this.killedName = killed;
      this.line = 0;
      this.timer = 200;
    }
  }
  
  private static class KillMessage {
    public String killerName;
    
    public String killedName;
    
    public InfoType weapon;
    
    public int itemDamage;
    
    public int timer;
    
    public int line;
    
    public boolean headshot;
    
    public KillMessage(boolean head, InfoType infoType, int itmDmg, String killer, String killed) {
      this.headshot = head;
      this.killerName = killer;
      this.killedName = killed;
      this.weapon = infoType;
      this.itemDamage = itmDmg;
      this.line = 0;
      this.timer = 200;
    }
  }
}
