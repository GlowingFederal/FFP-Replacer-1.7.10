/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import java.util.List;
/*     */ import mcheli.MCH_PacketNotifyLock;
/*     */ import mcheli.weapon.MCH_EntityBaseBullet;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_MissileDetector
/*     */ {
/*     */   private MCH_EntityAircraft ac;
/*     */   private World world;
/*     */   private int alertCount;
/*     */   public static final int SEARCH_RANGE = 60;
/*     */   
/*     */   public MCH_MissileDetector(MCH_EntityAircraft aircraft, World w) {
/*  23 */     this.world = w;
/*  24 */     this.ac = aircraft;
/*  25 */     this.alertCount = 0;
/*     */   }
/*     */   
/*     */   public void update() {
/*  29 */     if (this.ac.haveFlare()) {
/*  30 */       if (this.alertCount > 0) {
/*  31 */         this.alertCount--;
/*     */       }
/*     */       
/*  34 */       boolean isLocked = this.ac.getEntityData().func_74767_n("Tracking");
/*  35 */       if (isLocked) {
/*  36 */         this.ac.getEntityData().func_74757_a("Tracking", false);
/*     */       }
/*     */       
/*  39 */       if (this.ac.getEntityData().func_74767_n("LockOn")) {
/*  40 */         if (this.alertCount == 0) {
/*  41 */           this.alertCount = 10;
/*  42 */           if (this.ac != null && this.ac.haveFlare() && !this.ac.isDestroyed()) {
/*  43 */             for (int rider = 0; rider < 2; rider++) {
/*  44 */               Entity entity = this.ac.getEntityBySeatId(rider);
/*  45 */               if (entity instanceof net.minecraft.entity.player.EntityPlayerMP) {
/*  46 */                 MCH_PacketNotifyLock.sendToPlayer((EntityPlayer)entity);
/*     */               }
/*     */             } 
/*     */           }
/*     */         } 
/*     */         
/*  52 */         this.ac.getEntityData().func_74757_a("LockOn", false);
/*     */       } 
/*     */       
/*  55 */       if (!this.ac.isDestroyed()) {
/*  56 */         Entity var4 = this.ac.getRiddenByEntity();
/*  57 */         if (var4 == null) {
/*  58 */           var4 = this.ac.getEntityBySeatId(1);
/*     */         }
/*     */         
/*  61 */         if (var4 != null) {
/*  62 */           if (this.ac.isFlareUsing()) {
/*  63 */             destroyMissile();
/*  64 */           } else if (!this.ac.isUAV() && !this.world.field_72995_K) {
/*  65 */             if (this.alertCount == 0 && (isLocked || isLockedByMissile())) {
/*  66 */               this.alertCount = 20;
/*  67 */               W_WorldFunc.MOD_playSoundAtEntity((Entity)this.ac, "alert", 1.0F, 1.0F);
/*     */             } 
/*  69 */           } else if (this.ac.isUAV() && this.world.field_72995_K && this.alertCount == 0 && (isLocked || isLockedByMissile())) {
/*  70 */             this.alertCount = 20;
/*  71 */             if (W_Lib.isClientPlayer(var4)) {
/*  72 */               W_McClient.MOD_playSoundFX("alert", 1.0F, 1.0F);
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean destroyMissile() {
/*  82 */     List<MCH_EntityBaseBullet> list = this.world.func_72872_a(MCH_EntityBaseBullet.class, this.ac.field_70121_D.func_72314_b(60.0D, 60.0D, 60.0D));
/*  83 */     if (list != null) {
/*  84 */       for (int i = 0; i < list.size(); i++) {
/*  85 */         MCH_EntityBaseBullet msl = list.get(i);
/*  86 */         if (msl.targetEntity != null && (this.ac.isMountedEntity(msl.targetEntity) || msl.targetEntity.equals(this.ac))) {
/*  87 */           msl.targetEntity = null;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isLockedByMissile() {
/*  97 */     List<MCH_EntityBaseBullet> list = this.world.func_72872_a(MCH_EntityBaseBullet.class, this.ac.field_70121_D.func_72314_b(60.0D, 60.0D, 60.0D));
/*  98 */     if (list != null) {
/*  99 */       for (int i = 0; i < list.size(); i++) {
/* 100 */         MCH_EntityBaseBullet msl = list.get(i);
/* 101 */         if (msl.targetEntity != null && (this.ac.isMountedEntity(msl.targetEntity) || msl.targetEntity.equals(this.ac))) {
/* 102 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 107 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_MissileDetector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */