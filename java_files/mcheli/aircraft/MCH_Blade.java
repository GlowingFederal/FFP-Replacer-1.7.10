/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import mcheli.MCH_Lib;
/*     */ 
/*     */ public class MCH_Blade
/*     */ {
/*     */   private float baseRotation;
/*   8 */   private float rotation = 0.0F;
/*   9 */   private float prevRotation = 0.0F;
/*     */   
/*     */   private float foldSpeed;
/*     */   private float foldRotation;
/*     */   
/*     */   public MCH_Blade(float baseRotation) {
/*  15 */     this.baseRotation = baseRotation;
/*  16 */     this.foldSpeed = 3.0F;
/*  17 */     this.foldRotation = 5.0F;
/*     */   }
/*     */   
/*     */   public float getRotation() {
/*  21 */     return this.rotation;
/*     */   }
/*     */   
/*     */   public void setRotation(float rotation) {
/*  25 */     this.rotation = (float)MCH_Lib.getRotate360(rotation);
/*     */   }
/*     */   
/*     */   public float getPrevRotation() {
/*  29 */     return this.prevRotation;
/*     */   }
/*     */   
/*     */   public void setPrevRotation(float rotation) {
/*  33 */     this.prevRotation = (float)MCH_Lib.getRotate360(rotation);
/*     */   }
/*     */   
/*     */   public MCH_Blade setBaseRotation(float rotation) {
/*  37 */     if (rotation >= 0.0D) {
/*  38 */       this.baseRotation = rotation;
/*     */     }
/*     */     
/*  41 */     return this;
/*     */   }
/*     */   
/*     */   public float getBaseRotation() {
/*  45 */     return this.baseRotation;
/*     */   }
/*     */   
/*     */   public MCH_Blade setFoldSpeed(float speed) {
/*  49 */     if (speed > 0.1D) {
/*  50 */       this.foldSpeed = speed;
/*     */     }
/*     */     
/*  53 */     return this;
/*     */   }
/*     */   
/*     */   public MCH_Blade setFoldRotation(float rotation) {
/*  57 */     if (rotation > this.foldSpeed * 2.0F) {
/*  58 */       this.foldRotation = rotation;
/*     */     }
/*     */     
/*  61 */     return this;
/*     */   }
/*     */   
/*     */   public void forceFold() {
/*  65 */     if (this.rotation > this.foldRotation && this.rotation < 360.0F - this.foldRotation) {
/*  66 */       if (this.rotation < 180.0F) {
/*  67 */         this.rotation = this.foldRotation;
/*     */       } else {
/*  69 */         this.rotation = 360.0F - this.foldRotation;
/*     */       } 
/*     */       
/*  72 */       this.rotation %= 360.0F;
/*  73 */       this.prevRotation = this.rotation;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean folding() {
/*  79 */     boolean isCmpFolding = false;
/*  80 */     if (this.rotation > this.foldRotation && this.rotation < 360.0F - this.foldRotation) {
/*  81 */       if (this.rotation < 180.0F) {
/*  82 */         this.rotation -= this.foldSpeed;
/*     */       } else {
/*  84 */         this.rotation += this.foldSpeed;
/*     */       } 
/*     */       
/*  87 */       this.rotation %= 360.0F;
/*     */     } else {
/*  89 */       isCmpFolding = true;
/*     */     } 
/*     */     
/*  92 */     return isCmpFolding;
/*     */   }
/*     */   
/*     */   public boolean unfolding(float rot) {
/*  96 */     boolean isCmpUnfolding = false;
/*  97 */     float targetRot = (float)MCH_Lib.getRotate360((rot + this.baseRotation));
/*  98 */     float prevRot = this.rotation;
/*  99 */     if (targetRot <= 180.0F) {
/* 100 */       this.rotation = (float)MCH_Lib.getRotate360((this.rotation + this.foldSpeed));
/* 101 */       if (this.rotation >= targetRot && prevRot <= targetRot) {
/* 102 */         this.rotation = targetRot;
/* 103 */         isCmpUnfolding = true;
/*     */       } 
/*     */     } else {
/* 106 */       this.rotation = (float)MCH_Lib.getRotate360((this.rotation - this.foldSpeed));
/* 107 */       if (this.rotation <= targetRot && prevRot >= targetRot) {
/* 108 */         this.rotation = targetRot;
/* 109 */         isCmpUnfolding = true;
/*     */       } 
/*     */     } 
/*     */     
/* 113 */     return isCmpUnfolding;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_Blade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */