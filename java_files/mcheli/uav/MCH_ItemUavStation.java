/*     */ package mcheli.uav;
/*     */ 
/*     */ import java.util.List;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.wrapper.W_Item;
/*     */ import mcheli.wrapper.W_MovingObjectPosition;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_ItemUavStation
/*     */   extends W_Item
/*     */ {
/*  20 */   public static int UAV_STATION_KIND_NUM = 2;
/*     */   
/*     */   public final int UavStationKind;
/*     */   
/*     */   public MCH_ItemUavStation(int par1, int kind) {
/*  25 */     super(par1);
/*  26 */     this.field_77777_bU = 1;
/*  27 */     this.UavStationKind = kind;
/*     */   }
/*     */   
/*     */   public MCH_EntityUavStation createUavStation(World world, double x, double y, double z, int kind) {
/*  31 */     MCH_EntityUavStation uavst = new MCH_EntityUavStation(world);
/*  32 */     uavst.func_70107_b(x, y + uavst.field_70129_M, z);
/*  33 */     uavst.field_70169_q = x;
/*  34 */     uavst.field_70167_r = y;
/*  35 */     uavst.field_70166_s = z;
/*  36 */     uavst.setKind(kind);
/*  37 */     return uavst;
/*     */   }
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/*  41 */     float f = 1.0F;
/*  42 */     float f1 = par3EntityPlayer.field_70127_C + (par3EntityPlayer.field_70125_A - par3EntityPlayer.field_70127_C) * f;
/*  43 */     float f2 = par3EntityPlayer.field_70126_B + (par3EntityPlayer.field_70177_z - par3EntityPlayer.field_70126_B) * f;
/*  44 */     double d0 = par3EntityPlayer.field_70169_q + (par3EntityPlayer.field_70165_t - par3EntityPlayer.field_70169_q) * f;
/*  45 */     double d1 = par3EntityPlayer.field_70167_r + (par3EntityPlayer.field_70163_u - par3EntityPlayer.field_70167_r) * f + 1.62D - par3EntityPlayer.field_70129_M;
/*  46 */     double d2 = par3EntityPlayer.field_70166_s + (par3EntityPlayer.field_70161_v - par3EntityPlayer.field_70166_s) * f;
/*  47 */     Vec3 vec3 = W_WorldFunc.getWorldVec3(par2World, d0, d1, d2);
/*  48 */     float f3 = MathHelper.func_76134_b(-f2 * 0.017453292F - 3.1415927F);
/*  49 */     float f4 = MathHelper.func_76126_a(-f2 * 0.017453292F - 3.1415927F);
/*  50 */     float f5 = -MathHelper.func_76134_b(-f1 * 0.017453292F);
/*  51 */     float f6 = MathHelper.func_76126_a(-f1 * 0.017453292F);
/*  52 */     float f7 = f4 * f5;
/*  53 */     float f8 = f3 * f5;
/*  54 */     double d3 = 5.0D;
/*  55 */     Vec3 vec31 = vec3.func_72441_c(f7 * d3, f6 * d3, f8 * d3);
/*  56 */     MovingObjectPosition movingobjectposition = W_WorldFunc.clip(par2World, vec3, vec31, true);
/*  57 */     if (movingobjectposition == null) {
/*  58 */       return par1ItemStack;
/*     */     }
/*  60 */     Vec3 vec32 = par3EntityPlayer.func_70676_i(f);
/*  61 */     boolean flag = false;
/*  62 */     float f9 = 1.0F;
/*  63 */     List<Entity> list = par2World.func_72839_b((Entity)par3EntityPlayer, par3EntityPlayer.field_70121_D.func_72321_a(vec32.field_72450_a * d3, vec32.field_72448_b * d3, vec32.field_72449_c * d3).func_72314_b(f9, f9, f9));
/*     */     
/*     */     int i;
/*  66 */     for (i = 0; i < list.size(); i++) {
/*  67 */       Entity j = list.get(i);
/*  68 */       if (j.func_70067_L()) {
/*  69 */         float k = j.func_70111_Y();
/*  70 */         AxisAlignedBB entityUavSt = j.field_70121_D.func_72314_b(k, k, k);
/*  71 */         if (entityUavSt.func_72318_a(vec3)) {
/*  72 */           flag = true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  77 */     if (flag) {
/*  78 */       return par1ItemStack;
/*     */     }
/*  80 */     if (W_MovingObjectPosition.isHitTypeTile(movingobjectposition)) {
/*  81 */       i = movingobjectposition.field_72311_b;
/*  82 */       int var33 = movingobjectposition.field_72312_c;
/*  83 */       int var34 = movingobjectposition.field_72309_d;
/*  84 */       MCH_EntityUavStation var35 = createUavStation(par2World, (i + 0.5F), (var33 + 1.0F), (var34 + 0.5F), this.UavStationKind);
/*  85 */       int rot = (int)(MCH_Lib.getRotate360(par3EntityPlayer.field_70177_z) + 45.0D);
/*  86 */       var35.field_70177_z = (rot / 90 * 90 - 180);
/*  87 */       var35.initUavPostion();
/*  88 */       if (!par2World.func_72945_a((Entity)var35, var35.field_70121_D.func_72314_b(-0.1D, -0.1D, -0.1D)).isEmpty()) {
/*  89 */         return par1ItemStack;
/*     */       }
/*     */       
/*  92 */       if (!par2World.field_72995_K) {
/*  93 */         par2World.func_72838_d((Entity)var35);
/*     */       }
/*     */       
/*  96 */       if (!par3EntityPlayer.field_71075_bZ.field_75098_d) {
/*  97 */         par1ItemStack.field_77994_a--;
/*     */       }
/*     */     } 
/*     */     
/* 101 */     return par1ItemStack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mchel\\uav\MCH_ItemUavStation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */