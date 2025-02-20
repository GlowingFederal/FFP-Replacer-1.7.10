/*     */ package mcheli.particles;
/*     */ 
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.multiplay.MCH_GuiTargetMarker;
/*     */ import mcheli.wrapper.W_Reflection;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.particle.EntityFX;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.scoreboard.Team;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ public class MCH_EntityParticleMarkPoint
/*     */   extends MCH_EntityParticleBase
/*     */ {
/*     */   final Team taem;
/*     */   public boolean isFromBallisticCalculator = false;
/*     */   
/*     */   public MCH_EntityParticleMarkPoint(World par1World, double x, double y, double z, Team team) {
/*  26 */     super(par1World, x, y, z, 0.0D, 0.0D, 0.0D);
/*  27 */     setParticleMaxAge(30);
/*  28 */     this.taem = team;
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/*  32 */     this.field_70169_q = this.field_70165_t;
/*  33 */     this.field_70167_r = this.field_70163_u;
/*  34 */     this.field_70166_s = this.field_70161_v;
/*  35 */     EntityClientPlayerMP player = (Minecraft.func_71410_x()).field_71439_g;
/*  36 */     if (player == null) {
/*  37 */       func_70106_y();
/*  38 */     } else if (player.func_96124_cp() == null && this.taem != null) {
/*  39 */       func_70106_y();
/*  40 */     } else if (player.func_96124_cp() != null && !player.func_142012_a(this.taem)) {
/*  41 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70106_y() {
/*  47 */     super.func_70106_y();
/*  48 */     MCH_Lib.DbgLog(true, "MCH_EntityParticleMarkPoint.setDead : " + this, new Object[0]);
/*     */   }
/*     */   
/*     */   public int func_70537_b() {
/*  52 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70539_a(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
/*  57 */     if (this.field_70128_L)
/*  58 */       return;  GL11.glPushMatrix();
/*  59 */     Minecraft mc = Minecraft.func_71410_x();
/*  60 */     EntityClientPlayerMP player = mc.field_71439_g;
/*  61 */     if (player != null) {
/*  62 */       double ix = EntityFX.field_70556_an;
/*  63 */       double iy = EntityFX.field_70554_ao;
/*  64 */       double iz = EntityFX.field_70555_ap;
/*  65 */       if (mc.field_71474_y.field_74320_O > 0 && mc.field_71451_h != null) {
/*  66 */         EntityLivingBase px = mc.field_71451_h;
/*  67 */         double dist = W_Reflection.getThirdPersonDistance();
/*  68 */         float yaw = (mc.field_71474_y.field_74320_O != 2) ? -px.field_70177_z : -px.field_70177_z;
/*  69 */         float pz = (mc.field_71474_y.field_74320_O != 2) ? -px.field_70125_A : -px.field_70125_A;
/*  70 */         Vec3 v = MCH_Lib.RotVec3(0.0D, 0.0D, -dist, yaw, pz);
/*  71 */         if (mc.field_71474_y.field_74320_O == 2) {
/*  72 */           v.field_72450_a = -v.field_72450_a;
/*  73 */           v.field_72448_b = -v.field_72448_b;
/*  74 */           v.field_72449_c = -v.field_72449_c;
/*     */         } 
/*     */         
/*  77 */         Vec3 scale = Vec3.func_72443_a(px.field_70165_t, px.field_70163_u + px.func_70047_e(), px.field_70161_v);
/*  78 */         MovingObjectPosition mop = mc.field_71451_h.field_70170_p.func_72933_a(scale.func_72441_c(0.0D, 0.0D, 0.0D), scale.func_72441_c(v.field_72450_a, v.field_72448_b, v.field_72449_c));
/*  79 */         double block_dist = dist;
/*  80 */         if (mop != null && mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/*  81 */           block_dist = scale.func_72438_d(mop.field_72307_f) - 0.4D;
/*  82 */           if (block_dist < 0.0D) {
/*  83 */             block_dist = 0.0D;
/*     */           }
/*     */         } 
/*     */         
/*  87 */         GL11.glTranslated(v.field_72450_a * block_dist / dist, v.field_72448_b * block_dist / dist, v.field_72449_c * block_dist / dist);
/*  88 */         ix += v.field_72450_a * block_dist / dist;
/*  89 */         iy += v.field_72448_b * block_dist / dist;
/*  90 */         iz += v.field_72449_c * block_dist / dist;
/*     */       } 
/*     */       
/*  93 */       double px1 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * par2 - ix);
/*  94 */       double py = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * par2 - iy);
/*  95 */       double pz1 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * par2 - iz);
/*  96 */       double scale1 = Math.sqrt(px1 * px1 + py * py + pz1 * pz1) / 10.0D;
/*  97 */       if (scale1 < 1.0D) {
/*  98 */         scale1 = 1.0D;
/*     */       }
/* 100 */       MCH_GuiTargetMarker.clearMarkEntityPos();
/* 101 */       MCH_GuiTargetMarker.addMarkEntityPos(100, (Entity)this, px1 / scale1, py / scale1, pz1 / scale1, false);
/*     */     } 
/* 103 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\particles\MCH_EntityParticleMarkPoint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */