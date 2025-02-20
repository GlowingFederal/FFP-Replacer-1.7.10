/*     */ package mcheli.weapon;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_WeaponGPSMissile extends MCH_WeaponBase {
/*     */   public MCH_WeaponGPSMissile(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/*  13 */     super(w, v, yaw, pitch, nm, wi);
/*  14 */     this.interval = -350;
/*  15 */     if (w.field_72995_K) {
/*  16 */       this.interval -= 10;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCooldownCountReloadTime() {
/*  22 */     return true;
/*     */   }
/*     */   
/*     */   public void update(int countWait) {
/*  26 */     super.update(countWait);
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
/*     */   public boolean shot(MCH_WeaponParam prm) {
/*  66 */     boolean canShot = false;
/*  67 */     float yaw = prm.user.field_70177_z;
/*  68 */     float pitch = prm.user.field_70125_A;
/*  69 */     double tX = (-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/*  70 */     double tZ = (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/*  71 */     double tY = -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F);
/*  72 */     double dist = MathHelper.func_76133_a(tX * tX + tY * tY + tZ * tZ);
/*  73 */     if (this.worldObj.field_72995_K) {
/*  74 */       tX = tX * 200.0D / dist;
/*  75 */       tY = tY * 200.0D / dist;
/*  76 */       tZ = tZ * 200.0D / dist;
/*     */     } else {
/*  78 */       tX = tX * 250.0D / dist;
/*  79 */       tY = tY * 250.0D / dist;
/*  80 */       tZ = tZ * 250.0D / dist;
/*     */     } 
/*     */ 
/*     */     
/*  84 */     Vec3 target = (this.aircraft.getCurrentWeapon(prm.user)).targetPoint;
/*  85 */     if (target.func_72438_d(Vec3.func_72443_a(this.aircraft.field_70165_t, this.aircraft.field_70163_u, this.aircraft.field_70161_v)) >= (getInfo()).minShotDist) {
/*  86 */       int alt = 0;
/*  87 */       int heliY = (int)this.aircraft.field_70163_u;
/*  88 */       if (heliY > 256) {
/*  89 */         heliY = 256;
/*     */       }
/*     */       
/*  92 */       for (int i = 0; i < 256 && heliY - i > 0; i++) {
/*  93 */         int id = W_WorldFunc.getBlockId(this.aircraft.field_70170_p, (int)this.aircraft.field_70165_t, heliY - i, (int)this.aircraft.field_70161_v);
/*  94 */         if (id != 0) {
/*  95 */           alt = i;
/*  96 */           if (this.aircraft.field_70163_u > 256.0D) {
/*  97 */             alt = (int)(alt + this.aircraft.field_70163_u - 256.0D);
/*     */           }
/*     */           break;
/*     */         } 
/*     */       } 
/* 102 */       if (alt >= (getInfo()).minShotAlt) {
/* 103 */         if (!this.worldObj.field_72995_K) {
/* 104 */           MCH_EntityGPSMissile e = new MCH_EntityGPSMissile(this.worldObj, prm.posX, prm.posY, prm.posZ, tX, tY, tZ, yaw, pitch, this.acceleration, getInfo());
/* 105 */           e.setName(this.name);
/* 106 */           e.setParameterFromWeapon(this, prm.entity, prm.user);
/* 107 */           double tpx = rand.nextBoolean() ? (target.field_72450_a + rand.nextInt((int)this.weaponInfo.accuracy + 1)) : (target.field_72450_a - rand.nextInt((int)this.weaponInfo.accuracy + 1));
/* 108 */           double tpy = target.field_72448_b;
/* 109 */           double tpz = rand.nextBoolean() ? (target.field_72449_c + rand.nextInt((int)this.weaponInfo.accuracy + 1)) : (target.field_72449_c - rand.nextInt((int)this.weaponInfo.accuracy + 1));
/* 110 */           e.targetPos = Vec3.func_72443_a(tpx, tpy, tpz);
/* 111 */           this.worldObj.func_72838_d((Entity)e);
/* 112 */           playSound(prm.entity);
/*     */         } 
/* 114 */         canShot = true;
/*     */       }
/* 116 */       else if (prm.user instanceof EntityPlayer && 
/* 117 */         this.worldObj.field_72995_K) {
/* 118 */         ((EntityPlayer)prm.user).func_146105_b((IChatComponent)new ChatComponentText("You cant shot! Minimal shot altitude = " + (getInfo()).minShotAlt));
/*     */       } 
/* 120 */     } else if (prm.user instanceof EntityPlayer && 
/* 121 */       this.worldObj.field_72995_K) {
/* 122 */       ((EntityPlayer)prm.user).func_146105_b((IChatComponent)new ChatComponentText("You cant shot! Minimal shot distance = " + (getInfo()).minShotDist));
/*     */     } 
/* 124 */     return canShot;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponGPSMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */