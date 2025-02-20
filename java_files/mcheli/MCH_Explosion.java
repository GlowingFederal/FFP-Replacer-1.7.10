/*     */ package mcheli;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mcheli.flare.MCH_EntityFlare;
/*     */ import mcheli.particles.MCH_ParticleParam;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.wrapper.W_Block;
/*     */ import mcheli.wrapper.W_ChunkPosition;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_Explosion extends Explosion {
/*  28 */   public final int field_77289_h = 16;
/*     */   public World world;
/*  30 */   private static Random explosionRNG = new Random();
/*  31 */   public Map field_77288_k = new HashMap<>();
/*     */   public boolean isDestroyBlock;
/*     */   public int countSetFireEntity;
/*     */   public boolean isPlaySound;
/*     */   public boolean isInWater;
/*     */   ExplosionResult result;
/*     */   public EntityPlayer explodedPlayer;
/*     */   public float explosionSizeBlock;
/*  39 */   public MCH_DamageFactor damageFactor = null;
/*     */ 
/*     */   
/*     */   public MCH_Explosion(World par1World, Entity exploder, Entity player, double x, double y, double z, float size) {
/*  43 */     super(par1World, exploder, x, y, z, size);
/*  44 */     this.world = par1World;
/*  45 */     this.isDestroyBlock = false;
/*  46 */     this.explosionSizeBlock = size;
/*  47 */     this.countSetFireEntity = 0;
/*  48 */     this.isPlaySound = true;
/*  49 */     this.isInWater = false;
/*  50 */     this.result = null;
/*  51 */     this.explodedPlayer = (player instanceof EntityPlayer) ? (EntityPlayer)player : null;
/*     */   }
/*     */   
/*     */   public boolean isRemote() {
/*  55 */     return this.world.field_72995_K;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_77278_a() {
/*     */     // Byte code:
/*     */     //   0: new java/util/HashSet
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore_1
/*     */     //   8: iconst_0
/*     */     //   9: istore_2
/*     */     //   10: aload_0
/*     */     //   11: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   14: pop
/*     */     //   15: iload_2
/*     */     //   16: bipush #16
/*     */     //   18: if_icmplt -> 855
/*     */     //   21: aload_0
/*     */     //   22: getfield field_77280_f : F
/*     */     //   25: fstore #11
/*     */     //   27: aload_0
/*     */     //   28: getfield field_77281_g : Ljava/util/List;
/*     */     //   31: aload_1
/*     */     //   32: invokeinterface addAll : (Ljava/util/Collection;)Z
/*     */     //   37: pop
/*     */     //   38: aload_0
/*     */     //   39: dup
/*     */     //   40: getfield field_77280_f : F
/*     */     //   43: fconst_2
/*     */     //   44: fmul
/*     */     //   45: putfield field_77280_f : F
/*     */     //   48: aload_0
/*     */     //   49: getfield field_77284_b : D
/*     */     //   52: aload_0
/*     */     //   53: getfield field_77280_f : F
/*     */     //   56: f2d
/*     */     //   57: dsub
/*     */     //   58: dconst_1
/*     */     //   59: dsub
/*     */     //   60: invokestatic func_76128_c : (D)I
/*     */     //   63: istore_2
/*     */     //   64: aload_0
/*     */     //   65: getfield field_77284_b : D
/*     */     //   68: aload_0
/*     */     //   69: getfield field_77280_f : F
/*     */     //   72: f2d
/*     */     //   73: dadd
/*     */     //   74: dconst_1
/*     */     //   75: dadd
/*     */     //   76: invokestatic func_76128_c : (D)I
/*     */     //   79: istore_3
/*     */     //   80: aload_0
/*     */     //   81: getfield field_77285_c : D
/*     */     //   84: aload_0
/*     */     //   85: getfield field_77280_f : F
/*     */     //   88: f2d
/*     */     //   89: dsub
/*     */     //   90: dconst_1
/*     */     //   91: dsub
/*     */     //   92: invokestatic func_76128_c : (D)I
/*     */     //   95: istore #4
/*     */     //   97: aload_0
/*     */     //   98: getfield field_77285_c : D
/*     */     //   101: aload_0
/*     */     //   102: getfield field_77280_f : F
/*     */     //   105: f2d
/*     */     //   106: dadd
/*     */     //   107: dconst_1
/*     */     //   108: dadd
/*     */     //   109: invokestatic func_76128_c : (D)I
/*     */     //   112: istore #12
/*     */     //   114: aload_0
/*     */     //   115: getfield field_77282_d : D
/*     */     //   118: aload_0
/*     */     //   119: getfield field_77280_f : F
/*     */     //   122: f2d
/*     */     //   123: dsub
/*     */     //   124: dconst_1
/*     */     //   125: dsub
/*     */     //   126: invokestatic func_76128_c : (D)I
/*     */     //   129: istore #13
/*     */     //   131: aload_0
/*     */     //   132: getfield field_77282_d : D
/*     */     //   135: aload_0
/*     */     //   136: getfield field_77280_f : F
/*     */     //   139: f2d
/*     */     //   140: dadd
/*     */     //   141: dconst_1
/*     */     //   142: dadd
/*     */     //   143: invokestatic func_76128_c : (D)I
/*     */     //   146: istore #14
/*     */     //   148: aload_0
/*     */     //   149: getfield world : Lnet/minecraft/world/World;
/*     */     //   152: aload_0
/*     */     //   153: getfield field_77283_e : Lnet/minecraft/entity/Entity;
/*     */     //   156: iload_2
/*     */     //   157: i2d
/*     */     //   158: iload #4
/*     */     //   160: i2d
/*     */     //   161: iload #13
/*     */     //   163: i2d
/*     */     //   164: iload_3
/*     */     //   165: i2d
/*     */     //   166: iload #12
/*     */     //   168: i2d
/*     */     //   169: iload #14
/*     */     //   171: i2d
/*     */     //   172: invokestatic getAABB : (DDDDDD)Lnet/minecraft/util/AxisAlignedBB;
/*     */     //   175: invokevirtual func_72839_b : (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/AxisAlignedBB;)Ljava/util/List;
/*     */     //   178: astore #15
/*     */     //   180: aload_0
/*     */     //   181: getfield world : Lnet/minecraft/world/World;
/*     */     //   184: aload_0
/*     */     //   185: aload #15
/*     */     //   187: aload_0
/*     */     //   188: getfield field_77280_f : F
/*     */     //   191: f2d
/*     */     //   192: invokestatic onExplosionDetonate : (Lnet/minecraft/world/World;Lnet/minecraft/world/Explosion;Ljava/util/List;D)V
/*     */     //   195: aload_0
/*     */     //   196: getfield world : Lnet/minecraft/world/World;
/*     */     //   199: aload_0
/*     */     //   200: getfield field_77284_b : D
/*     */     //   203: aload_0
/*     */     //   204: getfield field_77285_c : D
/*     */     //   207: aload_0
/*     */     //   208: getfield field_77282_d : D
/*     */     //   211: invokestatic getWorldVec3 : (Lnet/minecraft/world/World;DDD)Lnet/minecraft/util/Vec3;
/*     */     //   214: astore #16
/*     */     //   216: aload_0
/*     */     //   217: aload_0
/*     */     //   218: getfield explodedPlayer : Lnet/minecraft/entity/player/EntityPlayer;
/*     */     //   221: putfield field_77283_e : Lnet/minecraft/entity/Entity;
/*     */     //   224: iconst_0
/*     */     //   225: istore #17
/*     */     //   227: iload #17
/*     */     //   229: aload #15
/*     */     //   231: invokeinterface size : ()I
/*     */     //   236: if_icmpge -> 848
/*     */     //   239: aload #15
/*     */     //   241: iload #17
/*     */     //   243: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   248: checkcast net/minecraft/entity/Entity
/*     */     //   251: astore #18
/*     */     //   253: aload #18
/*     */     //   255: aload_0
/*     */     //   256: getfield field_77284_b : D
/*     */     //   259: aload_0
/*     */     //   260: getfield field_77285_c : D
/*     */     //   263: aload_0
/*     */     //   264: getfield field_77282_d : D
/*     */     //   267: invokevirtual func_70011_f : (DDD)D
/*     */     //   270: aload_0
/*     */     //   271: getfield field_77280_f : F
/*     */     //   274: f2d
/*     */     //   275: ddiv
/*     */     //   276: dstore #19
/*     */     //   278: dload #19
/*     */     //   280: dconst_1
/*     */     //   281: dcmpg
/*     */     //   282: ifgt -> 842
/*     */     //   285: aload #18
/*     */     //   287: getfield field_70165_t : D
/*     */     //   290: aload_0
/*     */     //   291: getfield field_77284_b : D
/*     */     //   294: dsub
/*     */     //   295: dstore #5
/*     */     //   297: aload #18
/*     */     //   299: getfield field_70163_u : D
/*     */     //   302: aload #18
/*     */     //   304: invokevirtual func_70047_e : ()F
/*     */     //   307: f2d
/*     */     //   308: dadd
/*     */     //   309: aload_0
/*     */     //   310: getfield field_77285_c : D
/*     */     //   313: dsub
/*     */     //   314: dstore #7
/*     */     //   316: aload #18
/*     */     //   318: getfield field_70161_v : D
/*     */     //   321: aload_0
/*     */     //   322: getfield field_77282_d : D
/*     */     //   325: dsub
/*     */     //   326: dstore #9
/*     */     //   328: dload #5
/*     */     //   330: dload #5
/*     */     //   332: dmul
/*     */     //   333: dload #7
/*     */     //   335: dload #7
/*     */     //   337: dmul
/*     */     //   338: dadd
/*     */     //   339: dload #9
/*     */     //   341: dload #9
/*     */     //   343: dmul
/*     */     //   344: dadd
/*     */     //   345: invokestatic func_76133_a : (D)F
/*     */     //   348: f2d
/*     */     //   349: dstore #21
/*     */     //   351: dload #21
/*     */     //   353: dconst_0
/*     */     //   354: dcmpl
/*     */     //   355: ifeq -> 842
/*     */     //   358: dload #5
/*     */     //   360: dload #21
/*     */     //   362: ddiv
/*     */     //   363: dstore #5
/*     */     //   365: dload #7
/*     */     //   367: dload #21
/*     */     //   369: ddiv
/*     */     //   370: dstore #7
/*     */     //   372: dload #9
/*     */     //   374: dload #21
/*     */     //   376: ddiv
/*     */     //   377: dstore #9
/*     */     //   379: aload_0
/*     */     //   380: aload #16
/*     */     //   382: aload #18
/*     */     //   384: getfield field_70121_D : Lnet/minecraft/util/AxisAlignedBB;
/*     */     //   387: invokespecial getBlockDensity : (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/AxisAlignedBB;)D
/*     */     //   390: dstore #23
/*     */     //   392: dconst_1
/*     */     //   393: dload #19
/*     */     //   395: dsub
/*     */     //   396: dload #23
/*     */     //   398: dmul
/*     */     //   399: dstore #25
/*     */     //   401: dload #25
/*     */     //   403: dload #25
/*     */     //   405: dmul
/*     */     //   406: dload #25
/*     */     //   408: dadd
/*     */     //   409: ldc2_w 2.0
/*     */     //   412: ddiv
/*     */     //   413: ldc2_w 8.0
/*     */     //   416: dmul
/*     */     //   417: aload_0
/*     */     //   418: getfield field_77280_f : F
/*     */     //   421: f2d
/*     */     //   422: dmul
/*     */     //   423: dconst_1
/*     */     //   424: dadd
/*     */     //   425: d2i
/*     */     //   426: i2f
/*     */     //   427: fstore #27
/*     */     //   429: fload #27
/*     */     //   431: fconst_0
/*     */     //   432: fcmpl
/*     */     //   433: ifle -> 614
/*     */     //   436: aload_0
/*     */     //   437: getfield result : Lmcheli/MCH_Explosion$ExplosionResult;
/*     */     //   440: ifnull -> 614
/*     */     //   443: aload #18
/*     */     //   445: instanceof net/minecraft/entity/item/EntityItem
/*     */     //   448: ifne -> 614
/*     */     //   451: aload #18
/*     */     //   453: instanceof net/minecraft/entity/item/EntityExpBottle
/*     */     //   456: ifne -> 614
/*     */     //   459: aload #18
/*     */     //   461: instanceof net/minecraft/entity/item/EntityXPOrb
/*     */     //   464: ifne -> 614
/*     */     //   467: aload #18
/*     */     //   469: invokestatic isEntityFallingBlock : (Lnet/minecraft/entity/Entity;)Z
/*     */     //   472: ifne -> 614
/*     */     //   475: aload #18
/*     */     //   477: instanceof mcheli/weapon/MCH_EntityBaseBullet
/*     */     //   480: ifeq -> 564
/*     */     //   483: aload_0
/*     */     //   484: getfield field_77283_e : Lnet/minecraft/entity/Entity;
/*     */     //   487: instanceof net/minecraft/entity/player/EntityPlayer
/*     */     //   490: ifeq -> 564
/*     */     //   493: aload #18
/*     */     //   495: checkcast mcheli/weapon/MCH_EntityBaseBullet
/*     */     //   498: getfield shootingEntity : Lnet/minecraft/entity/Entity;
/*     */     //   501: aload_0
/*     */     //   502: getfield field_77283_e : Lnet/minecraft/entity/Entity;
/*     */     //   505: invokestatic isEqual : (Lnet/minecraft/entity/Entity;Lnet/minecraft/entity/Entity;)Z
/*     */     //   508: ifne -> 614
/*     */     //   511: aload_0
/*     */     //   512: getfield result : Lmcheli/MCH_Explosion$ExplosionResult;
/*     */     //   515: iconst_1
/*     */     //   516: putfield hitEntity : Z
/*     */     //   519: aload_0
/*     */     //   520: getfield world : Lnet/minecraft/world/World;
/*     */     //   523: new java/lang/StringBuilder
/*     */     //   526: dup
/*     */     //   527: invokespecial <init> : ()V
/*     */     //   530: ldc 'MCH_Explosion.doExplosionA:Damage=%.1f:HitEntityBullet='
/*     */     //   532: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   535: aload #18
/*     */     //   537: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   540: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   543: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   546: iconst_1
/*     */     //   547: anewarray java/lang/Object
/*     */     //   550: dup
/*     */     //   551: iconst_0
/*     */     //   552: fload #27
/*     */     //   554: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   557: aastore
/*     */     //   558: invokestatic DbgLog : (Lnet/minecraft/world/World;Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   561: goto -> 614
/*     */     //   564: aload_0
/*     */     //   565: getfield world : Lnet/minecraft/world/World;
/*     */     //   568: new java/lang/StringBuilder
/*     */     //   571: dup
/*     */     //   572: invokespecial <init> : ()V
/*     */     //   575: ldc 'MCH_Explosion.doExplosionA:Damage=%.1f:HitEntity='
/*     */     //   577: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   580: aload #18
/*     */     //   582: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   585: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   588: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   591: iconst_1
/*     */     //   592: anewarray java/lang/Object
/*     */     //   595: dup
/*     */     //   596: iconst_0
/*     */     //   597: fload #27
/*     */     //   599: invokestatic valueOf : (F)Ljava/lang/Float;
/*     */     //   602: aastore
/*     */     //   603: invokestatic DbgLog : (Lnet/minecraft/world/World;Ljava/lang/String;[Ljava/lang/Object;)V
/*     */     //   606: aload_0
/*     */     //   607: getfield result : Lmcheli/MCH_Explosion$ExplosionResult;
/*     */     //   610: iconst_1
/*     */     //   611: putfield hitEntity : Z
/*     */     //   614: aload #18
/*     */     //   616: invokestatic applyEntityHurtResistantTimeConfig : (Lnet/minecraft/entity/Entity;)V
/*     */     //   619: aload_0
/*     */     //   620: invokestatic func_94539_a : (Lnet/minecraft/world/Explosion;)Lnet/minecraft/util/DamageSource;
/*     */     //   623: astore #28
/*     */     //   625: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   628: astore #29
/*     */     //   630: aload #18
/*     */     //   632: aload #28
/*     */     //   634: fload #27
/*     */     //   636: invokestatic applyDamageVsEntity : (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/DamageSource;F)F
/*     */     //   639: fstore #27
/*     */     //   641: fload #27
/*     */     //   643: aload_0
/*     */     //   644: getfield damageFactor : Lmcheli/MCH_DamageFactor;
/*     */     //   647: ifnull -> 662
/*     */     //   650: aload_0
/*     */     //   651: getfield damageFactor : Lmcheli/MCH_DamageFactor;
/*     */     //   654: aload #18
/*     */     //   656: invokevirtual getDamageFactor : (Lnet/minecraft/entity/Entity;)F
/*     */     //   659: goto -> 663
/*     */     //   662: fconst_1
/*     */     //   663: fmul
/*     */     //   664: fstore #27
/*     */     //   666: aload #18
/*     */     //   668: aload #28
/*     */     //   670: fload #27
/*     */     //   672: invokestatic attackEntityFrom : (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/DamageSource;F)Z
/*     */     //   675: pop
/*     */     //   676: aload #18
/*     */     //   678: dload #25
/*     */     //   680: invokestatic func_92092_a : (Lnet/minecraft/entity/Entity;D)D
/*     */     //   683: dstore #30
/*     */     //   685: aload #18
/*     */     //   687: instanceof mcheli/weapon/MCH_EntityBaseBullet
/*     */     //   690: ifne -> 750
/*     */     //   693: aload #18
/*     */     //   695: dup
/*     */     //   696: getfield field_70159_w : D
/*     */     //   699: dload #5
/*     */     //   701: dload #30
/*     */     //   703: dmul
/*     */     //   704: ldc2_w 0.4
/*     */     //   707: dmul
/*     */     //   708: dadd
/*     */     //   709: putfield field_70159_w : D
/*     */     //   712: aload #18
/*     */     //   714: dup
/*     */     //   715: getfield field_70181_x : D
/*     */     //   718: dload #7
/*     */     //   720: dload #30
/*     */     //   722: dmul
/*     */     //   723: ldc2_w 0.1
/*     */     //   726: dmul
/*     */     //   727: dadd
/*     */     //   728: putfield field_70181_x : D
/*     */     //   731: aload #18
/*     */     //   733: dup
/*     */     //   734: getfield field_70179_y : D
/*     */     //   737: dload #9
/*     */     //   739: dload #30
/*     */     //   741: dmul
/*     */     //   742: ldc2_w 0.4
/*     */     //   745: dmul
/*     */     //   746: dadd
/*     */     //   747: putfield field_70179_y : D
/*     */     //   750: aload #18
/*     */     //   752: instanceof net/minecraft/entity/player/EntityPlayer
/*     */     //   755: ifeq -> 795
/*     */     //   758: aload_0
/*     */     //   759: getfield field_77288_k : Ljava/util/Map;
/*     */     //   762: aload #18
/*     */     //   764: checkcast net/minecraft/entity/player/EntityPlayer
/*     */     //   767: aload_0
/*     */     //   768: getfield world : Lnet/minecraft/world/World;
/*     */     //   771: dload #5
/*     */     //   773: dload #25
/*     */     //   775: dmul
/*     */     //   776: dload #7
/*     */     //   778: dload #25
/*     */     //   780: dmul
/*     */     //   781: dload #9
/*     */     //   783: dload #25
/*     */     //   785: dmul
/*     */     //   786: invokestatic getWorldVec3 : (Lnet/minecraft/world/World;DDD)Lnet/minecraft/util/Vec3;
/*     */     //   789: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   794: pop
/*     */     //   795: fload #27
/*     */     //   797: fconst_0
/*     */     //   798: fcmpl
/*     */     //   799: ifle -> 842
/*     */     //   802: aload_0
/*     */     //   803: getfield countSetFireEntity : I
/*     */     //   806: ifle -> 842
/*     */     //   809: dconst_1
/*     */     //   810: dload #21
/*     */     //   812: aload_0
/*     */     //   813: getfield field_77280_f : F
/*     */     //   816: f2d
/*     */     //   817: ddiv
/*     */     //   818: dsub
/*     */     //   819: dstore #32
/*     */     //   821: dload #32
/*     */     //   823: dconst_0
/*     */     //   824: dcmpl
/*     */     //   825: ifle -> 842
/*     */     //   828: aload #18
/*     */     //   830: dload #32
/*     */     //   832: aload_0
/*     */     //   833: getfield countSetFireEntity : I
/*     */     //   836: i2d
/*     */     //   837: dmul
/*     */     //   838: d2i
/*     */     //   839: invokevirtual func_70015_d : (I)V
/*     */     //   842: iinc #17, 1
/*     */     //   845: goto -> 227
/*     */     //   848: aload_0
/*     */     //   849: fload #11
/*     */     //   851: putfield field_77280_f : F
/*     */     //   854: return
/*     */     //   855: iconst_0
/*     */     //   856: istore_3
/*     */     //   857: aload_0
/*     */     //   858: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   861: pop
/*     */     //   862: iload_3
/*     */     //   863: bipush #16
/*     */     //   865: if_icmplt -> 874
/*     */     //   868: iinc #2, 1
/*     */     //   871: goto -> 1383
/*     */     //   874: iconst_0
/*     */     //   875: istore #4
/*     */     //   877: aload_0
/*     */     //   878: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   881: pop
/*     */     //   882: iload #4
/*     */     //   884: bipush #16
/*     */     //   886: if_icmplt -> 895
/*     */     //   889: iinc #3, 1
/*     */     //   892: goto -> 857
/*     */     //   895: iload_2
/*     */     //   896: ifeq -> 945
/*     */     //   899: aload_0
/*     */     //   900: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   903: pop
/*     */     //   904: iload_2
/*     */     //   905: bipush #15
/*     */     //   907: if_icmpeq -> 945
/*     */     //   910: iload_3
/*     */     //   911: ifeq -> 945
/*     */     //   914: aload_0
/*     */     //   915: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   918: pop
/*     */     //   919: iload_3
/*     */     //   920: bipush #15
/*     */     //   922: if_icmpeq -> 945
/*     */     //   925: iload #4
/*     */     //   927: ifeq -> 945
/*     */     //   930: aload_0
/*     */     //   931: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   934: pop
/*     */     //   935: iload #4
/*     */     //   937: bipush #15
/*     */     //   939: if_icmpeq -> 945
/*     */     //   942: goto -> 1377
/*     */     //   945: iload_2
/*     */     //   946: i2f
/*     */     //   947: fstore #11
/*     */     //   949: aload_0
/*     */     //   950: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   953: pop
/*     */     //   954: fload #11
/*     */     //   956: ldc_w 15.0
/*     */     //   959: fdiv
/*     */     //   960: fconst_2
/*     */     //   961: fmul
/*     */     //   962: fconst_1
/*     */     //   963: fsub
/*     */     //   964: f2d
/*     */     //   965: dstore #12
/*     */     //   967: iload_3
/*     */     //   968: i2f
/*     */     //   969: fstore #11
/*     */     //   971: aload_0
/*     */     //   972: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   975: pop
/*     */     //   976: fload #11
/*     */     //   978: ldc_w 15.0
/*     */     //   981: fdiv
/*     */     //   982: fconst_2
/*     */     //   983: fmul
/*     */     //   984: fconst_1
/*     */     //   985: fsub
/*     */     //   986: f2d
/*     */     //   987: dstore #14
/*     */     //   989: iload #4
/*     */     //   991: i2f
/*     */     //   992: fstore #11
/*     */     //   994: aload_0
/*     */     //   995: invokevirtual getClass : ()Ljava/lang/Class;
/*     */     //   998: pop
/*     */     //   999: fload #11
/*     */     //   1001: ldc_w 15.0
/*     */     //   1004: fdiv
/*     */     //   1005: fconst_2
/*     */     //   1006: fmul
/*     */     //   1007: fconst_1
/*     */     //   1008: fsub
/*     */     //   1009: f2d
/*     */     //   1010: dstore #16
/*     */     //   1012: dload #12
/*     */     //   1014: dload #12
/*     */     //   1016: dmul
/*     */     //   1017: dload #14
/*     */     //   1019: dload #14
/*     */     //   1021: dmul
/*     */     //   1022: dadd
/*     */     //   1023: dload #16
/*     */     //   1025: dload #16
/*     */     //   1027: dmul
/*     */     //   1028: dadd
/*     */     //   1029: invokestatic sqrt : (D)D
/*     */     //   1032: dstore #18
/*     */     //   1034: dload #12
/*     */     //   1036: dload #18
/*     */     //   1038: ddiv
/*     */     //   1039: dstore #12
/*     */     //   1041: dload #14
/*     */     //   1043: dload #18
/*     */     //   1045: ddiv
/*     */     //   1046: dstore #14
/*     */     //   1048: dload #16
/*     */     //   1050: dload #18
/*     */     //   1052: ddiv
/*     */     //   1053: dstore #16
/*     */     //   1055: aload_0
/*     */     //   1056: getfield explosionSizeBlock : F
/*     */     //   1059: ldc_w 0.7
/*     */     //   1062: aload_0
/*     */     //   1063: getfield world : Lnet/minecraft/world/World;
/*     */     //   1066: getfield field_73012_v : Ljava/util/Random;
/*     */     //   1069: invokevirtual nextFloat : ()F
/*     */     //   1072: ldc_w 0.6
/*     */     //   1075: fmul
/*     */     //   1076: fadd
/*     */     //   1077: fmul
/*     */     //   1078: fstore #20
/*     */     //   1080: aload_0
/*     */     //   1081: getfield field_77284_b : D
/*     */     //   1084: dstore #5
/*     */     //   1086: aload_0
/*     */     //   1087: getfield field_77285_c : D
/*     */     //   1090: dstore #7
/*     */     //   1092: aload_0
/*     */     //   1093: getfield field_77282_d : D
/*     */     //   1096: dstore #9
/*     */     //   1098: ldc_w 0.3
/*     */     //   1101: fstore #21
/*     */     //   1103: fload #20
/*     */     //   1105: fconst_0
/*     */     //   1106: fcmpl
/*     */     //   1107: ifle -> 1377
/*     */     //   1110: dload #5
/*     */     //   1112: invokestatic func_76128_c : (D)I
/*     */     //   1115: istore #22
/*     */     //   1117: dload #7
/*     */     //   1119: invokestatic func_76128_c : (D)I
/*     */     //   1122: istore #23
/*     */     //   1124: dload #9
/*     */     //   1126: invokestatic func_76128_c : (D)I
/*     */     //   1129: istore #24
/*     */     //   1131: aload_0
/*     */     //   1132: getfield world : Lnet/minecraft/world/World;
/*     */     //   1135: iload #22
/*     */     //   1137: iload #23
/*     */     //   1139: iload #24
/*     */     //   1141: invokestatic getBlockId : (Lnet/minecraft/world/World;III)I
/*     */     //   1144: istore #25
/*     */     //   1146: iload #25
/*     */     //   1148: ifle -> 1276
/*     */     //   1151: aload_0
/*     */     //   1152: getfield world : Lnet/minecraft/world/World;
/*     */     //   1155: iload #22
/*     */     //   1157: iload #23
/*     */     //   1159: iload #24
/*     */     //   1161: invokestatic getBlock : (Lnet/minecraft/world/World;III)Lnet/minecraft/block/Block;
/*     */     //   1164: astore #26
/*     */     //   1166: aload_0
/*     */     //   1167: getfield field_77283_e : Lnet/minecraft/entity/Entity;
/*     */     //   1170: ifnull -> 1198
/*     */     //   1173: aload_0
/*     */     //   1174: getfield field_77283_e : Lnet/minecraft/entity/Entity;
/*     */     //   1177: aload_0
/*     */     //   1178: aload_0
/*     */     //   1179: getfield world : Lnet/minecraft/world/World;
/*     */     //   1182: iload #22
/*     */     //   1184: iload #23
/*     */     //   1186: iload #24
/*     */     //   1188: aload #26
/*     */     //   1190: invokestatic getBlockExplosionResistance : (Lnet/minecraft/entity/Entity;Lnet/minecraft/world/Explosion;Lnet/minecraft/world/World;IIILnet/minecraft/block/Block;)F
/*     */     //   1193: fstore #27
/*     */     //   1195: goto -> 1231
/*     */     //   1198: aload #26
/*     */     //   1200: aload_0
/*     */     //   1201: getfield field_77283_e : Lnet/minecraft/entity/Entity;
/*     */     //   1204: aload_0
/*     */     //   1205: getfield world : Lnet/minecraft/world/World;
/*     */     //   1208: iload #22
/*     */     //   1210: iload #23
/*     */     //   1212: iload #24
/*     */     //   1214: aload_0
/*     */     //   1215: getfield field_77284_b : D
/*     */     //   1218: aload_0
/*     */     //   1219: getfield field_77285_c : D
/*     */     //   1222: aload_0
/*     */     //   1223: getfield field_77282_d : D
/*     */     //   1226: invokevirtual getExplosionResistance : (Lnet/minecraft/entity/Entity;Lnet/minecraft/world/World;IIIDDD)F
/*     */     //   1229: fstore #27
/*     */     //   1231: aload_0
/*     */     //   1232: getfield isInWater : Z
/*     */     //   1235: ifeq -> 1261
/*     */     //   1238: fload #27
/*     */     //   1240: aload_0
/*     */     //   1241: getfield world : Lnet/minecraft/world/World;
/*     */     //   1244: getfield field_73012_v : Ljava/util/Random;
/*     */     //   1247: invokevirtual nextFloat : ()F
/*     */     //   1250: ldc_w 0.2
/*     */     //   1253: fmul
/*     */     //   1254: ldc_w 0.2
/*     */     //   1257: fadd
/*     */     //   1258: fmul
/*     */     //   1259: fstore #27
/*     */     //   1261: fload #20
/*     */     //   1263: fload #27
/*     */     //   1265: ldc_w 0.3
/*     */     //   1268: fadd
/*     */     //   1269: ldc_w 0.3
/*     */     //   1272: fmul
/*     */     //   1273: fsub
/*     */     //   1274: fstore #20
/*     */     //   1276: fload #20
/*     */     //   1278: fconst_0
/*     */     //   1279: fcmpl
/*     */     //   1280: ifle -> 1333
/*     */     //   1283: aload_0
/*     */     //   1284: getfield field_77283_e : Lnet/minecraft/entity/Entity;
/*     */     //   1287: ifnull -> 1315
/*     */     //   1290: aload_0
/*     */     //   1291: getfield field_77283_e : Lnet/minecraft/entity/Entity;
/*     */     //   1294: aload_0
/*     */     //   1295: aload_0
/*     */     //   1296: getfield world : Lnet/minecraft/world/World;
/*     */     //   1299: iload #22
/*     */     //   1301: iload #23
/*     */     //   1303: iload #24
/*     */     //   1305: iload #25
/*     */     //   1307: fload #20
/*     */     //   1309: invokestatic shouldExplodeBlock : (Lnet/minecraft/entity/Entity;Lnet/minecraft/world/Explosion;Lnet/minecraft/world/World;IIIIF)Z
/*     */     //   1312: ifeq -> 1333
/*     */     //   1315: aload_1
/*     */     //   1316: new net/minecraft/world/ChunkPosition
/*     */     //   1319: dup
/*     */     //   1320: iload #22
/*     */     //   1322: iload #23
/*     */     //   1324: iload #24
/*     */     //   1326: invokespecial <init> : (III)V
/*     */     //   1329: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   1332: pop
/*     */     //   1333: dload #5
/*     */     //   1335: dload #12
/*     */     //   1337: ldc2_w 0.30000001192092896
/*     */     //   1340: dmul
/*     */     //   1341: dadd
/*     */     //   1342: dstore #5
/*     */     //   1344: dload #7
/*     */     //   1346: dload #14
/*     */     //   1348: ldc2_w 0.30000001192092896
/*     */     //   1351: dmul
/*     */     //   1352: dadd
/*     */     //   1353: dstore #7
/*     */     //   1355: dload #9
/*     */     //   1357: dload #16
/*     */     //   1359: ldc2_w 0.30000001192092896
/*     */     //   1362: dmul
/*     */     //   1363: dadd
/*     */     //   1364: dstore #9
/*     */     //   1366: fload #20
/*     */     //   1368: ldc_w 0.22500001
/*     */     //   1371: fsub
/*     */     //   1372: fstore #20
/*     */     //   1374: goto -> 1103
/*     */     //   1377: iinc #4, 1
/*     */     //   1380: goto -> 877
/*     */     //   1383: goto -> 10
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #59	-> 0
/*     */     //   #60	-> 8
/*     */     //   #63	-> 10
/*     */     //   #69	-> 15
/*     */     //   #70	-> 21
/*     */     //   #71	-> 27
/*     */     //   #72	-> 38
/*     */     //   #73	-> 48
/*     */     //   #74	-> 64
/*     */     //   #75	-> 80
/*     */     //   #76	-> 97
/*     */     //   #77	-> 114
/*     */     //   #78	-> 131
/*     */     //   #79	-> 148
/*     */     //   #80	-> 180
/*     */     //   #82	-> 195
/*     */     //   #83	-> 216
/*     */     //   #85	-> 224
/*     */     //   #86	-> 239
/*     */     //   #87	-> 253
/*     */     //   #88	-> 278
/*     */     //   #89	-> 285
/*     */     //   #90	-> 297
/*     */     //   #91	-> 316
/*     */     //   #92	-> 328
/*     */     //   #93	-> 351
/*     */     //   #94	-> 358
/*     */     //   #95	-> 365
/*     */     //   #96	-> 372
/*     */     //   #97	-> 379
/*     */     //   #98	-> 392
/*     */     //   #99	-> 401
/*     */     //   #100	-> 429
/*     */     //   #101	-> 475
/*     */     //   #102	-> 493
/*     */     //   #103	-> 511
/*     */     //   #104	-> 519
/*     */     //   #107	-> 564
/*     */     //   #108	-> 606
/*     */     //   #112	-> 614
/*     */     //   #113	-> 619
/*     */     //   #114	-> 625
/*     */     //   #115	-> 630
/*     */     //   #116	-> 641
/*     */     //   #117	-> 666
/*     */     //   #118	-> 676
/*     */     //   #119	-> 685
/*     */     //   #120	-> 693
/*     */     //   #121	-> 712
/*     */     //   #122	-> 731
/*     */     //   #125	-> 750
/*     */     //   #126	-> 758
/*     */     //   #129	-> 795
/*     */     //   #130	-> 809
/*     */     //   #131	-> 821
/*     */     //   #132	-> 828
/*     */     //   #85	-> 842
/*     */     //   #139	-> 848
/*     */     //   #140	-> 854
/*     */     //   #143	-> 855
/*     */     //   #146	-> 857
/*     */     //   #147	-> 862
/*     */     //   #148	-> 868
/*     */     //   #149	-> 871
/*     */     //   #152	-> 874
/*     */     //   #155	-> 877
/*     */     //   #156	-> 882
/*     */     //   #157	-> 889
/*     */     //   #158	-> 892
/*     */     //   #162	-> 895
/*     */     //   #163	-> 899
/*     */     //   #164	-> 904
/*     */     //   #165	-> 914
/*     */     //   #166	-> 919
/*     */     //   #167	-> 930
/*     */     //   #168	-> 935
/*     */     //   #169	-> 942
/*     */     //   #175	-> 945
/*     */     //   #176	-> 949
/*     */     //   #177	-> 954
/*     */     //   #178	-> 967
/*     */     //   #179	-> 971
/*     */     //   #180	-> 976
/*     */     //   #181	-> 989
/*     */     //   #182	-> 994
/*     */     //   #183	-> 999
/*     */     //   #184	-> 1012
/*     */     //   #185	-> 1034
/*     */     //   #186	-> 1041
/*     */     //   #187	-> 1048
/*     */     //   #188	-> 1055
/*     */     //   #189	-> 1080
/*     */     //   #190	-> 1086
/*     */     //   #191	-> 1092
/*     */     //   #193	-> 1098
/*     */     //   #194	-> 1110
/*     */     //   #195	-> 1117
/*     */     //   #196	-> 1124
/*     */     //   #197	-> 1131
/*     */     //   #198	-> 1146
/*     */     //   #199	-> 1151
/*     */     //   #201	-> 1166
/*     */     //   #202	-> 1173
/*     */     //   #204	-> 1198
/*     */     //   #207	-> 1231
/*     */     //   #208	-> 1238
/*     */     //   #211	-> 1261
/*     */     //   #214	-> 1276
/*     */     //   #215	-> 1315
/*     */     //   #218	-> 1333
/*     */     //   #219	-> 1344
/*     */     //   #220	-> 1355
/*     */     //   #193	-> 1366
/*     */     //   #224	-> 1377
/*     */     //   #227	-> 1383
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   821	21	32	fireFactor	D
/*     */     //   392	450	23	var40	D
/*     */     //   401	441	25	var41	D
/*     */     //   429	413	27	damage	F
/*     */     //   625	217	28	ds	Lnet/minecraft/util/DamageSource;
/*     */     //   630	212	29	var36	Lmcheli/MCH_Config;
/*     */     //   685	157	30	d11	D
/*     */     //   351	491	21	var39	D
/*     */     //   297	545	5	d0	D
/*     */     //   316	526	7	d1	D
/*     */     //   328	514	9	d2	D
/*     */     //   253	589	18	entity	Lnet/minecraft/entity/Entity;
/*     */     //   278	564	19	var38	D
/*     */     //   227	621	17	var37	I
/*     */     //   27	828	11	var33	F
/*     */     //   114	741	12	l1	I
/*     */     //   131	724	13	var34	I
/*     */     //   148	707	14	j2	I
/*     */     //   180	675	15	var35	Ljava/util/List;
/*     */     //   216	639	16	vec3	Lnet/minecraft/util/Vec3;
/*     */     //   80	775	3	j	I
/*     */     //   97	758	4	k	I
/*     */     //   1195	3	27	f3	F
/*     */     //   1166	110	26	d10	Lnet/minecraft/block/Block;
/*     */     //   1231	45	27	f3	F
/*     */     //   1117	249	22	d8	I
/*     */     //   1124	242	23	i1	I
/*     */     //   1131	235	24	d9	I
/*     */     //   1146	220	25	k1	I
/*     */     //   1103	274	21	f2	F
/*     */     //   949	428	11	var10000	F
/*     */     //   967	410	12	f	D
/*     */     //   989	388	14	i2	D
/*     */     //   1012	365	16	list	D
/*     */     //   1034	343	18	k2	D
/*     */     //   1080	297	20	d7	F
/*     */     //   1086	291	5	d0	D
/*     */     //   1092	285	7	d1	D
/*     */     //   1098	279	9	d2	D
/*     */     //   857	526	3	j	I
/*     */     //   877	506	4	k	I
/*     */     //   0	1386	0	this	Lmcheli/MCH_Explosion;
/*     */     //   8	1378	1	hashset	Ljava/util/HashSet;
/*     */     //   10	1376	2	i	I
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double getBlockDensity(Vec3 vec3, AxisAlignedBB p_72842_2_) {
/* 231 */     double d0 = 1.0D / ((p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * 2.0D + 1.0D);
/* 232 */     double d1 = 1.0D / ((p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * 2.0D + 1.0D);
/* 233 */     double d2 = 1.0D / ((p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * 2.0D + 1.0D);
/* 234 */     if (d0 >= 0.0D && d1 >= 0.0D && d2 >= 0.0D) {
/* 235 */       int i = 0;
/* 236 */       int j = 0;
/*     */       float f;
/* 238 */       for (f = 0.0F; f <= 1.0F; f = (float)(f + d0)) {
/* 239 */         float f1; for (f1 = 0.0F; f1 <= 1.0F; f1 = (float)(f1 + d1)) {
/* 240 */           float f2; for (f2 = 0.0F; f2 <= 1.0F; f2 = (float)(f2 + d2)) {
/* 241 */             double d3 = p_72842_2_.field_72340_a + (p_72842_2_.field_72336_d - p_72842_2_.field_72340_a) * f;
/* 242 */             double d4 = p_72842_2_.field_72338_b + (p_72842_2_.field_72337_e - p_72842_2_.field_72338_b) * f1;
/* 243 */             double d5 = p_72842_2_.field_72339_c + (p_72842_2_.field_72334_f - p_72842_2_.field_72339_c) * f2;
/* 244 */             if (this.world.func_147447_a(Vec3.func_72443_a(d3, d4, d5), vec3, false, true, false) == null) {
/* 245 */               i++;
/*     */             }
/*     */             
/* 248 */             j++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 253 */       return (i / j);
/*     */     } 
/* 255 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_77279_a(boolean par1) {
/* 260 */     if (this.isPlaySound) {
/* 261 */       W_WorldFunc.DEF_playSoundEffect(this.world, this.field_77284_b, this.field_77285_c, this.field_77282_d, "random.explode", 4.0F, (1.0F + (this.world.field_73012_v.nextFloat() - this.world.field_73012_v.nextFloat()) * 0.2F) * 0.7F);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 272 */     if (this.field_82755_b) {
/* 273 */       Iterator<ChunkPosition> iterator = this.field_77281_g.iterator();
/*     */       
/* 275 */       while (iterator.hasNext()) {
/* 276 */         ChunkPosition chunkposition = iterator.next();
/* 277 */         int i = W_ChunkPosition.getChunkPosX(chunkposition);
/* 278 */         int j = W_ChunkPosition.getChunkPosY(chunkposition);
/* 279 */         int k = W_ChunkPosition.getChunkPosZ(chunkposition);
/* 280 */         int l = W_WorldFunc.getBlockId(this.world, i, j, k);
/* 281 */         if (l > 0 && this.isDestroyBlock && this.explosionSizeBlock > 0.0F) {
/* 282 */           MCH_Config var10000 = MCH_MOD.config;
/* 283 */           if (MCH_Config.Explosion_DestroyBlock.prmBool) {
/* 284 */             Block b = W_Block.getBlockById(l);
/* 285 */             if (b.func_149659_a(this)) {
/* 286 */               b.func_149690_a(this.world, i, j, k, this.world.func_72805_g(i, j, k), 1.0F / this.explosionSizeBlock, 0);
/*     */             }
/*     */             
/* 289 */             b.onBlockExploded(this.world, i, j, k, this);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 295 */     if (this.field_77286_a) {
/* 296 */       MCH_Config var10000 = MCH_MOD.config;
/* 297 */       if (MCH_Config.Explosion_FlamingBlock.prmBool) {
/* 298 */         Iterator<ChunkPosition> iterator = this.field_77281_g.iterator();
/*     */         
/* 300 */         while (iterator.hasNext()) {
/* 301 */           ChunkPosition chunkposition = iterator.next();
/* 302 */           int i = W_ChunkPosition.getChunkPosX(chunkposition);
/* 303 */           int j = W_ChunkPosition.getChunkPosY(chunkposition);
/* 304 */           int k = W_ChunkPosition.getChunkPosZ(chunkposition);
/* 305 */           int l = W_WorldFunc.getBlockId(this.world, i, j, k);
/* 306 */           Block b = W_WorldFunc.getBlock(this.world, i, j - 1, k);
/* 307 */           if (l == 0 && b != null && b.func_149662_c() && explosionRNG.nextInt(3) == 0) {
/* 308 */             W_WorldFunc.setBlock(this.world, i, j, k, (Block)Blocks.field_150480_ab);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ExplosionResult newExplosionResult() {
/* 317 */     return new ExplosionResult();
/*     */   }
/*     */   
/*     */   public static ExplosionResult newExplosion(World w, Entity entityExploded, Entity player, double x, double y, double z, float size, float sizeBlock, boolean playSound, boolean isSmoking, boolean isFlaming, boolean isDestroyBlock, int countSetFireEntity) {
/* 321 */     return newExplosion(w, entityExploded, player, x, y, z, size, sizeBlock, playSound, isSmoking, isFlaming, isDestroyBlock, countSetFireEntity, (MCH_DamageFactor)null);
/*     */   }
/*     */   
/*     */   public static ExplosionResult newExplosion(World w, Entity entityExploded, Entity player, double x, double y, double z, float size, float sizeBlock, boolean playSound, boolean isSmoking, boolean isFlaming, boolean isDestroyBlock, int countSetFireEntity, MCH_DamageFactor df) {
/* 325 */     if (w.field_72995_K) {
/* 326 */       return null;
/*     */     }
/* 328 */     MCH_Explosion exp = new MCH_Explosion(w, entityExploded, player, x, y, z, size);
/* 329 */     exp.field_82755_b = w.func_82736_K().func_82766_b("mobGriefing");
/* 330 */     exp.field_77286_a = isFlaming;
/* 331 */     exp.isDestroyBlock = isDestroyBlock;
/* 332 */     exp.explosionSizeBlock = sizeBlock;
/* 333 */     exp.countSetFireEntity = countSetFireEntity;
/* 334 */     exp.isPlaySound = playSound;
/* 335 */     exp.isInWater = false;
/* 336 */     exp.result = exp.newExplosionResult();
/* 337 */     exp.damageFactor = df;
/* 338 */     exp.func_77278_a();
/* 339 */     exp.func_77279_a(true);
/* 340 */     MCH_PacketEffectExplosion.ExplosionParam param = MCH_PacketEffectExplosion.create();
/* 341 */     param.exploderID = W_Entity.getEntityId(entityExploded);
/* 342 */     param.posX = x;
/* 343 */     param.posY = y;
/* 344 */     param.posZ = z;
/* 345 */     param.size = size;
/* 346 */     param.inWater = false;
/* 347 */     MCH_PacketEffectExplosion.send(param);
/* 348 */     return exp.result;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ExplosionResult newExplosionInWater(World w, Entity entityExploded, Entity player, double x, double y, double z, float size, float sizeBlock, boolean playSound, boolean isSmoking, boolean isFlaming, boolean isDestroyBlock, int countSetFireEntity, MCH_DamageFactor df) {
/* 353 */     if (w.field_72995_K) {
/* 354 */       return null;
/*     */     }
/* 356 */     MCH_Explosion exp = new MCH_Explosion(w, entityExploded, player, x, y, z, size);
/* 357 */     exp.field_82755_b = w.func_82736_K().func_82766_b("mobGriefing");
/* 358 */     exp.field_77286_a = isFlaming;
/* 359 */     exp.isDestroyBlock = isDestroyBlock;
/* 360 */     exp.explosionSizeBlock = sizeBlock;
/* 361 */     exp.countSetFireEntity = countSetFireEntity;
/* 362 */     exp.isPlaySound = playSound;
/* 363 */     exp.isInWater = true;
/* 364 */     exp.result = exp.newExplosionResult();
/* 365 */     exp.damageFactor = df;
/* 366 */     exp.func_77278_a();
/* 367 */     exp.func_77279_a(true);
/* 368 */     MCH_PacketEffectExplosion.ExplosionParam param = MCH_PacketEffectExplosion.create();
/* 369 */     param.exploderID = W_Entity.getEntityId(entityExploded);
/* 370 */     param.posX = x;
/* 371 */     param.posY = y;
/* 372 */     param.posZ = z;
/* 373 */     param.size = size;
/* 374 */     param.inWater = true;
/* 375 */     MCH_PacketEffectExplosion.send(param);
/* 376 */     return exp.result;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void playExplosionSound(World w, double x, double y, double z) {
/* 381 */     Random rand = new Random();
/* 382 */     W_WorldFunc.DEF_playSoundEffect(w, x, y, z, "random.explode", 4.0F, (1.0F + (rand.nextFloat() - rand.nextFloat()) * 0.2F) * 0.7F);
/*     */   }
/*     */   
/*     */   public static void effectExplosion(World world, Entity exploder, double explosionX, double explosionY, double explosionZ, float explosionSize, boolean isSmoking) {
/* 386 */     ArrayList<ChunkPosition> affectedBlockPositions = new ArrayList();
/* 387 */     boolean field_77289_h = true;
/* 388 */     HashSet<ChunkPosition> hashset = new HashSet();
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */ 
/*     */     
/* 396 */     for (i = 0; i < 16; i++) {
/* 397 */       for (int j = 0; j < 16; j++) {
/* 398 */         for (int k = 0; k < 16; k++) {
/* 399 */           if (i == 0 || i == 15 || j == 0 || j == 15 || k == 0 || k == 15) {
/* 400 */             double iterator = (i / 15.0F * 2.0F - 1.0F);
/* 401 */             double l = (j / 15.0F * 2.0F - 1.0F);
/* 402 */             double flareCnt = (k / 15.0F * 2.0F - 1.0F);
/* 403 */             double d6 = Math.sqrt(iterator * iterator + l * l + flareCnt * flareCnt);
/* 404 */             iterator /= d6;
/* 405 */             l /= d6;
/* 406 */             flareCnt /= d6;
/* 407 */             float f1 = explosionSize * (0.7F + world.field_73012_v.nextFloat() * 0.6F);
/* 408 */             double d0 = explosionX;
/* 409 */             double d1 = explosionY;
/* 410 */             double d2 = explosionZ;
/*     */             
/* 412 */             for (float mz = 0.3F; f1 > 0.0F; f1 -= mz * 0.75F) {
/* 413 */               int l1 = MathHelper.func_76128_c(d0);
/* 414 */               int d61 = MathHelper.func_76128_c(d1);
/* 415 */               int j1 = MathHelper.func_76128_c(d2);
/* 416 */               int d7 = W_WorldFunc.getBlockId(world, l1, d61, j1);
/* 417 */               if (d7 > 0) {
/* 418 */                 Block block = W_Block.getBlockById(d7);
/* 419 */                 float px = block.getExplosionResistance(exploder, world, l1, d61, j1, explosionX, explosionY, explosionZ);
/* 420 */                 f1 -= (px + 0.3F) * mz;
/*     */               } 
/*     */               
/* 423 */               if (f1 > 0.0F) {
/* 424 */                 hashset.add(new ChunkPosition(l1, d61, j1));
/*     */               }
/*     */               
/* 427 */               d0 += iterator * mz;
/* 428 */               d1 += l * mz;
/* 429 */               d2 += flareCnt * mz;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 436 */     affectedBlockPositions.addAll(hashset);
/* 437 */     if (explosionSize >= 2.0F && isSmoking) {
/* 438 */       MCH_ParticlesUtil.DEF_spawnParticle("hugeexplosion", explosionX, explosionY, explosionZ, 1.0D, 0.0D, 0.0D, 10.0F);
/*     */     } else {
/* 440 */       MCH_ParticlesUtil.DEF_spawnParticle("largeexplode", explosionX, explosionY, explosionZ, 1.0D, 0.0D, 0.0D, 10.0F);
/*     */     } 
/*     */     
/* 443 */     if (isSmoking) {
/* 444 */       Iterator<ChunkPosition> var50 = affectedBlockPositions.iterator();
/* 445 */       int cnt = 0;
/* 446 */       int var51 = (int)explosionSize;
/*     */       
/* 448 */       while (var50.hasNext()) {
/* 449 */         ChunkPosition chunkposition = var50.next();
/* 450 */         i = W_ChunkPosition.getChunkPosX(chunkposition);
/* 451 */         int j = W_ChunkPosition.getChunkPosY(chunkposition);
/* 452 */         int k = W_ChunkPosition.getChunkPosZ(chunkposition);
/* 453 */         W_WorldFunc.getBlockId(world, i, j, k);
/* 454 */         cnt++;
/* 455 */         double d0 = (i + world.field_73012_v.nextFloat());
/* 456 */         double d1 = (j + world.field_73012_v.nextFloat());
/* 457 */         double d2 = (k + world.field_73012_v.nextFloat());
/* 458 */         double mx = d0 - explosionX;
/* 459 */         double my = d1 - explosionY;
/* 460 */         double var52 = d2 - explosionZ;
/* 461 */         double var53 = MathHelper.func_76133_a(mx * mx + my * my + var52 * var52);
/* 462 */         mx /= var53;
/* 463 */         my /= var53;
/* 464 */         var52 /= var53;
/* 465 */         double var54 = 0.5D / (var53 / explosionSize + 0.1D);
/* 466 */         var54 *= (world.field_73012_v.nextFloat() * world.field_73012_v.nextFloat() + 0.3F);
/* 467 */         mx *= var54 * 0.5D;
/* 468 */         my *= var54 * 0.5D;
/* 469 */         var52 *= var54 * 0.5D;
/* 470 */         double var55 = (d0 + explosionX * 1.0D) / 2.0D;
/* 471 */         double py = (d1 + explosionY * 1.0D) / 2.0D;
/* 472 */         double pz = (d2 + explosionZ * 1.0D) / 2.0D;
/* 473 */         double r = Math.PI * world.field_73012_v.nextInt(360) / 180.0D;
/* 474 */         if (explosionSize >= 4.0F && var51 > 0) {
/* 475 */           double es = Math.min((explosionSize / 12.0F), 0.6D) * (0.5F + world.field_73012_v.nextFloat() * 0.5F);
/* 476 */           world.func_72838_d((Entity)new MCH_EntityFlare(world, var55, py + 2.0D, pz, Math.sin(r) * es, (1.0D + my / 5.0D) * es, Math.cos(r) * es, 2.0F, 0));
/* 477 */           var51--;
/*     */         } 
/*     */         
/* 480 */         if (cnt % 4 == 0) {
/* 481 */           float var48 = Math.min(explosionSize / 3.0F, 2.0F) * (0.5F + world.field_73012_v.nextFloat() * 0.5F);
/* 482 */           MCH_ParticlesUtil.spawnParticleTileDust(world, (int)(var55 + 0.5D), (int)(py - 0.5D), (int)(pz + 0.5D), var55, py + 1.0D, pz, Math.sin(r) * var48, 0.5D + my / 5.0D * var48, Math.cos(r) * var48, Math.min(explosionSize / 2.0F, 3.0F) * (0.5F + world.field_73012_v.nextFloat() * 0.5F));
/*     */         } 
/*     */         
/* 485 */         int var49 = (int)((explosionSize >= 4.0F) ? explosionSize : 4.0F);
/* 486 */         if (explosionSize <= 1.0F || cnt % var49 == 0) {
/* 487 */           if (world.field_73012_v.nextBoolean()) {
/* 488 */             my *= 3.0D;
/* 489 */             mx *= 0.1D;
/* 490 */             var52 *= 0.1D;
/*     */           } else {
/* 492 */             my *= 0.2D;
/* 493 */             mx *= 3.0D;
/* 494 */             var52 *= 3.0D;
/*     */           } 
/*     */           
/* 497 */           MCH_ParticleParam prm = new MCH_ParticleParam(world, "explode", var55, py, pz, mx, my, var52, (explosionSize < 8.0F) ? ((explosionSize < 2.0F) ? 2.0F : (explosionSize * 2.0F)) : 16.0F);
/* 498 */           prm.r = prm.g = prm.b = 0.3F + world.field_73012_v.nextFloat() * 0.4F;
/* 499 */           prm.r += 0.1F;
/* 500 */           prm.g += 0.05F;
/* 501 */           prm.b += 0.0F;
/* 502 */           prm.age = 10 + world.field_73012_v.nextInt(30);
/* 503 */           prm.age = (int)(prm.age * ((explosionSize < 6.0F) ? explosionSize : 6.0F));
/* 504 */           prm.age = prm.age * 2 / 3;
/* 505 */           prm.diffusible = true;
/* 506 */           MCH_ParticlesUtil.spawnParticle(prm);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void DEF_effectExplosion(World world, Entity exploder, double explosionX, double explosionY, double explosionZ, float explosionSize, boolean isSmoking) {
/* 514 */     ArrayList<ChunkPosition> affectedBlockPositions = new ArrayList();
/* 515 */     boolean field_77289_h = true;
/* 516 */     HashSet<ChunkPosition> hashset = new HashSet();
/*     */ 
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */ 
/*     */     
/* 524 */     for (i = 0; i < 16; i++) {
/* 525 */       for (int j = 0; j < 16; j++) {
/* 526 */         for (int k = 0; k < 16; k++) {
/* 527 */           if (i == 0 || i == 15 || j == 0 || j == 15 || k == 0 || k == 15) {
/* 528 */             double iterator = (i / 15.0F * 2.0F - 1.0F);
/* 529 */             double l = (j / 15.0F * 2.0F - 1.0F);
/* 530 */             double d5 = (k / 15.0F * 2.0F - 1.0F);
/* 531 */             double d6 = Math.sqrt(iterator * iterator + l * l + d5 * d5);
/* 532 */             iterator /= d6;
/* 533 */             l /= d6;
/* 534 */             d5 /= d6;
/* 535 */             float f1 = explosionSize * (0.7F + world.field_73012_v.nextFloat() * 0.6F);
/* 536 */             double d0 = explosionX;
/* 537 */             double d1 = explosionY;
/* 538 */             double d2 = explosionZ;
/*     */             
/* 540 */             for (float d61 = 0.3F; f1 > 0.0F; f1 -= d61 * 0.75F) {
/* 541 */               int l1 = MathHelper.func_76128_c(d0);
/* 542 */               int d7 = MathHelper.func_76128_c(d1);
/* 543 */               int j1 = MathHelper.func_76128_c(d2);
/* 544 */               int k1 = W_WorldFunc.getBlockId(world, l1, d7, j1);
/* 545 */               if (k1 > 0) {
/* 546 */                 Block block = W_Block.getBlockById(k1);
/* 547 */                 float f3 = block.getExplosionResistance(exploder, world, l1, d7, j1, explosionX, explosionY, explosionZ);
/* 548 */                 f1 -= (f3 + 0.3F) * d61;
/*     */               } 
/*     */               
/* 551 */               if (f1 > 0.0F) {
/* 552 */                 hashset.add(new ChunkPosition(l1, d7, j1));
/*     */               }
/*     */               
/* 555 */               d0 += iterator * d61;
/* 556 */               d1 += l * d61;
/* 557 */               d2 += d5 * d61;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 564 */     affectedBlockPositions.addAll(hashset);
/* 565 */     if (explosionSize >= 2.0F && isSmoking) {
/* 566 */       MCH_ParticlesUtil.DEF_spawnParticle("hugeexplosion", explosionX, explosionY, explosionZ, 1.0D, 0.0D, 0.0D, 10.0F);
/*     */     } else {
/* 568 */       MCH_ParticlesUtil.DEF_spawnParticle("largeexplode", explosionX, explosionY, explosionZ, 1.0D, 0.0D, 0.0D, 10.0F);
/*     */     } 
/*     */     
/* 571 */     if (isSmoking) {
/* 572 */       Iterator<ChunkPosition> var39 = affectedBlockPositions.iterator();
/*     */       
/* 574 */       while (var39.hasNext()) {
/* 575 */         ChunkPosition chunkposition = var39.next();
/* 576 */         i = W_ChunkPosition.getChunkPosX(chunkposition);
/* 577 */         int j = W_ChunkPosition.getChunkPosY(chunkposition);
/* 578 */         int k = W_ChunkPosition.getChunkPosZ(chunkposition);
/* 579 */         W_WorldFunc.getBlockId(world, i, j, k);
/* 580 */         double d0 = (i + world.field_73012_v.nextFloat());
/* 581 */         double d1 = (j + world.field_73012_v.nextFloat());
/* 582 */         double d2 = (k + world.field_73012_v.nextFloat());
/* 583 */         double d3 = d0 - explosionX;
/* 584 */         double d4 = d1 - explosionY;
/* 585 */         double d51 = d2 - explosionZ;
/* 586 */         double var40 = MathHelper.func_76133_a(d3 * d3 + d4 * d4 + d51 * d51);
/* 587 */         d3 /= var40;
/* 588 */         d4 /= var40;
/* 589 */         d51 /= var40;
/* 590 */         double var41 = 0.5D / (var40 / explosionSize + 0.1D);
/* 591 */         var41 *= (world.field_73012_v.nextFloat() * world.field_73012_v.nextFloat() + 0.3F);
/* 592 */         d3 *= var41;
/* 593 */         d4 *= var41;
/* 594 */         d51 *= var41;
/* 595 */         MCH_ParticlesUtil.DEF_spawnParticle("explode", (d0 + explosionX * 1.0D) / 2.0D, (d1 + explosionY * 1.0D) / 2.0D, (d2 + explosionZ * 1.0D) / 2.0D, d3, d4, d51, 10.0F);
/* 596 */         MCH_ParticlesUtil.DEF_spawnParticle("smoke", d0, d1, d2, d3, d4, d51, 10.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void effectExplosionInWater(World world, Entity exploder, double explosionX, double explosionY, double explosionZ, float explosionSize, boolean isSmoking) {
/* 603 */     if (explosionSize > 0.0F) {
/* 604 */       int range = (int)(explosionSize + 0.5D) / 1;
/* 605 */       int ex = (int)(explosionX + 0.5D);
/* 606 */       int ey = (int)(explosionY + 0.5D);
/* 607 */       int ez = (int)(explosionZ + 0.5D);
/*     */       
/* 609 */       for (int y = -range; y <= range; y++) {
/* 610 */         if (ey + y >= 1)
/* 611 */           for (int x = -range; x <= range; x++) {
/* 612 */             for (int z = -range; z <= range; z++) {
/* 613 */               int d = x * x + y * y + z * z;
/* 614 */               if (d < range * range && W_Block.func_149680_a(W_WorldFunc.getBlock(world, ex + x, ey + y, ez + z), W_Block.getWater())) {
/* 615 */                 int n = explosionRNG.nextInt(2);
/*     */                 
/* 617 */                 for (int i = 0; i < n; i++) {
/* 618 */                   MCH_ParticleParam prm = new MCH_ParticleParam(world, "splash", (ex + x), (ey + y), (ez + z), x / range * (explosionRNG.nextFloat() - 0.2D), 1.0D - Math.sqrt((x * x + z * z)) / range + explosionRNG.nextFloat() * 0.4D * range * 0.4D, z / range * (explosionRNG.nextFloat() - 0.2D), (explosionRNG.nextInt(range) * 3 + range));
/* 619 */                   MCH_ParticlesUtil.spawnParticle(prm);
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }  
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public class ExplosionResult {
/*     */     public boolean hitEntity = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_Explosion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */