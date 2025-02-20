/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import mcheli.wrapper.W_SoundUpdater;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ public class MCH_SoundUpdater
/*     */   extends W_SoundUpdater {
/*     */   private final MCH_EntityAircraft theAircraft;
/*     */   private final EntityPlayerSP thePlayer;
/*     */   private boolean isMoving;
/*     */   private boolean silent;
/*     */   private float aircraftPitch;
/*     */   private float aircraftVolume;
/*     */   private float addPitch;
/*     */   private boolean isFirstUpdate;
/*     */   private double prevDist;
/*  19 */   private int soundDelay = 0;
/*     */ 
/*     */   
/*     */   public MCH_SoundUpdater(Minecraft mc, MCH_EntityAircraft aircraft, EntityPlayerSP entityPlayerSP) {
/*  23 */     super(mc, (Entity)aircraft);
/*  24 */     this.theAircraft = aircraft;
/*  25 */     this.thePlayer = entityPlayerSP;
/*  26 */     this.isFirstUpdate = true;
/*     */   }
/*     */   
/*     */   public void update() {
/*  30 */     if (!this.theAircraft.getSoundName().isEmpty() && this.theAircraft.getAcInfo() != null) {
/*  31 */       if (this.isFirstUpdate) {
/*  32 */         this.isFirstUpdate = false;
/*  33 */         initEntitySound(this.theAircraft.getSoundName());
/*     */       } 
/*     */       
/*  36 */       MCH_AircraftInfo info = this.theAircraft.getAcInfo();
/*  37 */       boolean isBeforeMoving = this.isMoving;
/*  38 */       boolean isDead = this.theAircraft.field_70128_L;
/*  39 */       if (isDead || (!this.silent && this.aircraftVolume == 0.0F)) {
/*  40 */         if (isDead) {
/*  41 */           stopEntitySound((Entity)this.theAircraft);
/*     */         }
/*     */         
/*  44 */         this.silent = true;
/*  45 */         if (isDead) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */       
/*  50 */       boolean isRide = (this.theAircraft.getSeatIdByEntity((Entity)this.thePlayer) >= 0);
/*  51 */       boolean isPlaying = isEntitySoundPlaying((Entity)this.theAircraft);
/*  52 */       boolean onPlaySound = false;
/*  53 */       if (!isPlaying && this.aircraftVolume > 0.0F) {
/*  54 */         if (this.soundDelay > 0) {
/*  55 */           this.soundDelay--;
/*     */         } else {
/*  57 */           this.soundDelay = 20;
/*  58 */           playEntitySound(this.theAircraft.getSoundName(), (Entity)this.theAircraft, this.aircraftVolume, this.aircraftPitch, true);
/*     */         } 
/*     */         
/*  61 */         this.silent = false;
/*  62 */         onPlaySound = true;
/*     */       } 
/*     */       
/*  65 */       float prevVolume = this.aircraftVolume;
/*  66 */       float prevPitch = this.aircraftPitch;
/*  67 */       this.isMoving = ((info.soundVolume * this.theAircraft.getSoundVolume()) >= 0.01D);
/*  68 */       if (this.isMoving) {
/*  69 */         this.aircraftVolume = info.soundVolume * this.theAircraft.getSoundVolume();
/*  70 */         this.aircraftPitch = info.soundPitch * this.theAircraft.getSoundPitch();
/*  71 */         if (!isRide) {
/*  72 */           double updateLocation = this.thePlayer.func_70011_f(this.theAircraft.field_70165_t, this.thePlayer.field_70163_u, this.theAircraft.field_70161_v);
/*  73 */           double pitch = this.prevDist - updateLocation;
/*  74 */           if (Math.abs(pitch) > 0.3D) {
/*  75 */             this.addPitch = (float)(this.addPitch + pitch / 40.0D);
/*  76 */             float maxAddPitch = 0.2F;
/*  77 */             if (this.addPitch < -maxAddPitch) {
/*  78 */               this.addPitch = -maxAddPitch;
/*     */             }
/*     */             
/*  81 */             if (this.addPitch > maxAddPitch) {
/*  82 */               this.addPitch = maxAddPitch;
/*     */             }
/*     */           } 
/*     */           
/*  86 */           this.addPitch = (float)(this.addPitch * 0.9D);
/*  87 */           this.aircraftPitch += this.addPitch;
/*  88 */           this.prevDist = updateLocation;
/*     */         } 
/*     */         
/*  91 */         if (this.aircraftPitch < 0.0F) {
/*  92 */           this.aircraftPitch = 0.0F;
/*     */         }
/*  94 */       } else if (isBeforeMoving) {
/*  95 */         this.aircraftVolume = 0.0F;
/*  96 */         this.aircraftPitch = 0.0F;
/*     */       } 
/*     */       
/*  99 */       if (!this.silent) {
/* 100 */         if (this.aircraftPitch != prevPitch) {
/* 101 */           setEntitySoundPitch((Entity)this.theAircraft, this.aircraftPitch);
/*     */         }
/*     */         
/* 104 */         if (this.aircraftVolume != prevVolume) {
/* 105 */           setEntitySoundVolume((Entity)this.theAircraft, this.aircraftVolume);
/*     */         }
/*     */       } 
/*     */       
/* 109 */       boolean var24 = false;
/* 110 */       var24 = true;
/* 111 */       if (var24 && this.aircraftVolume > 0.0F) {
/* 112 */         if (isRide) {
/* 113 */           updateSoundLocation((Entity)this.theAircraft);
/*     */         } else {
/* 115 */           double px = this.thePlayer.field_70165_t;
/* 116 */           double py = this.thePlayer.field_70163_u;
/* 117 */           double pz = this.thePlayer.field_70161_v;
/* 118 */           double dx = this.theAircraft.field_70165_t - px;
/* 119 */           double dy = this.theAircraft.field_70163_u - py;
/* 120 */           double dz = this.theAircraft.field_70161_v - pz;
/* 121 */           double dist = info.soundRange / 16.0D;
/* 122 */           dx /= dist;
/* 123 */           dy /= dist;
/* 124 */           dz /= dist;
/* 125 */           updateSoundLocation(px + dx, py + dy, pz + dz);
/*     */         } 
/* 127 */       } else if (isEntitySoundPlaying((Entity)this.theAircraft)) {
/* 128 */         stopEntitySound((Entity)this.theAircraft);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_SoundUpdater.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */