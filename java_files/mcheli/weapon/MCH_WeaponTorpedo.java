/*     */ package mcheli.weapon;
/*     */ 
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.wrapper.W_MovingObjectPosition;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_WeaponTorpedo extends MCH_WeaponBase {
/*     */   public MCH_WeaponTorpedo(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/*  14 */     super(w, v, yaw, pitch, nm, wi);
/*  15 */     this.acceleration = 0.5F;
/*  16 */     this.explosionPower = 8;
/*  17 */     this.power = 35;
/*  18 */     this.interval = -100;
/*  19 */     if (w.field_72995_K) {
/*  20 */       this.interval -= 10;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shot(MCH_WeaponParam prm) {
/*  26 */     return (getInfo() != null) ? ((getInfo()).isGuidedTorpedo ? shotGuided(prm) : shotNoGuided(prm)) : false;
/*     */   }
/*     */   
/*     */   protected boolean shotNoGuided(MCH_WeaponParam prm) {
/*  30 */     if (this.worldObj.field_72995_K) {
/*  31 */       return true;
/*     */     }
/*  33 */     float yaw = prm.rotYaw;
/*  34 */     float pitch = prm.rotPitch;
/*  35 */     double mx = (-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/*  36 */     double mz = (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/*  37 */     double my = -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F);
/*  38 */     mx = mx * (getInfo()).acceleration + prm.entity.field_70159_w;
/*  39 */     my = my * (getInfo()).acceleration + prm.entity.field_70181_x;
/*  40 */     mz = mz * (getInfo()).acceleration + prm.entity.field_70179_y;
/*  41 */     this.acceleration = MathHelper.func_76133_a(mx * mx + my * my + mz * mz);
/*  42 */     MCH_EntityTorpedo e = new MCH_EntityTorpedo(this.worldObj, prm.posX, prm.posY, prm.posZ, mx, my, mz, yaw, 0.0F, this.acceleration);
/*  43 */     e.setName(this.name);
/*  44 */     e.setParameterFromWeapon(this, prm.entity, prm.user);
/*  45 */     e.field_70159_w = mx;
/*  46 */     e.field_70181_x = my;
/*  47 */     e.field_70179_y = mz;
/*  48 */     e.accelerationInWater = (getInfo() != null) ? (getInfo()).accelerationInWater : 1.0D;
/*  49 */     this.worldObj.func_72838_d((Entity)e);
/*  50 */     playSound(prm.entity);
/*  51 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean shotGuided(MCH_WeaponParam prm) {
/*  56 */     float yaw = prm.user.field_70177_z;
/*  57 */     float pitch = prm.user.field_70125_A;
/*  58 */     Vec3 v = MCH_Lib.RotVec3(0.0D, 0.0D, 1.0D, -yaw, -pitch, -prm.rotRoll);
/*  59 */     double tX = v.field_72450_a;
/*  60 */     double tZ = v.field_72449_c;
/*  61 */     double tY = v.field_72448_b;
/*  62 */     double dist = MathHelper.func_76133_a(tX * tX + tY * tY + tZ * tZ);
/*  63 */     if (this.worldObj.field_72995_K) {
/*  64 */       tX = tX * 100.0D / dist;
/*  65 */       tY = tY * 100.0D / dist;
/*  66 */       tZ = tZ * 100.0D / dist;
/*     */     } else {
/*  68 */       tX = tX * 150.0D / dist;
/*  69 */       tY = tY * 150.0D / dist;
/*  70 */       tZ = tZ * 150.0D / dist;
/*     */     } 
/*     */     
/*  73 */     Vec3 src = W_WorldFunc.getWorldVec3(this.worldObj, prm.user.field_70165_t, prm.user.field_70163_u, prm.user.field_70161_v);
/*  74 */     Vec3 dst = W_WorldFunc.getWorldVec3(this.worldObj, prm.user.field_70165_t + tX, prm.user.field_70163_u + tY, prm.user.field_70161_v + tZ);
/*  75 */     MovingObjectPosition m = W_WorldFunc.clip(this.worldObj, src, dst);
/*  76 */     if (m != null && W_MovingObjectPosition.isHitTypeTile(m) && MCH_Lib.isBlockInWater(this.worldObj, m.field_72311_b, m.field_72312_c, m.field_72309_d)) {
/*  77 */       if (!this.worldObj.field_72995_K) {
/*  78 */         double mx = (-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/*  79 */         double mz = (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/*  80 */         double my = -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F);
/*  81 */         mx = mx * (getInfo()).acceleration + prm.entity.field_70159_w;
/*  82 */         my = my * (getInfo()).acceleration + prm.entity.field_70181_x;
/*  83 */         mz = mz * (getInfo()).acceleration + prm.entity.field_70179_y;
/*  84 */         this.acceleration = MathHelper.func_76133_a(mx * mx + my * my + mz * mz);
/*  85 */         MCH_EntityTorpedo e = new MCH_EntityTorpedo(this.worldObj, prm.posX, prm.posY, prm.posZ, prm.entity.field_70159_w, prm.entity.field_70181_x, prm.entity.field_70179_y, yaw, 0.0F, this.acceleration);
/*  86 */         e.setName(this.name);
/*  87 */         e.setParameterFromWeapon(this, prm.entity, prm.user);
/*  88 */         e.targetPosX = m.field_72307_f.field_72450_a;
/*  89 */         e.targetPosY = m.field_72307_f.field_72448_b;
/*  90 */         e.targetPosZ = m.field_72307_f.field_72449_c;
/*  91 */         e.field_70159_w = mx;
/*  92 */         e.field_70181_x = my;
/*  93 */         e.field_70179_y = mz;
/*  94 */         e.accelerationInWater = (getInfo() != null) ? (getInfo()).accelerationInWater : 1.0D;
/*  95 */         this.worldObj.func_72838_d((Entity)e);
/*  96 */         playSound(prm.entity);
/*     */       } 
/*     */       
/*  99 */       return true;
/*     */     } 
/* 101 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponTorpedo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */