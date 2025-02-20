/*     */ package mcheli.aircraft;
/*     */ 
/*     */ 
/*     */ public class MCH_Rotor
/*     */ {
/*     */   public MCH_Blade[] blades;
/*     */   private int numBlade;
/*     */   private int invRot;
/*     */   private boolean isFoldBlade;
/*     */   private boolean isFoldBladeTarget;
/*     */   private boolean haveFoldBladeFunc;
/*     */   
/*     */   public MCH_Rotor(int numBlade, int invRot, int foldSpeed, float posx, float posy, float posz, float rotx, float roty, float rotz, boolean canFoldBlade) {
/*  14 */     setupBlade(numBlade, invRot, foldSpeed);
/*  15 */     this.isFoldBlade = false;
/*  16 */     this.isFoldBladeTarget = false;
/*  17 */     this.haveFoldBladeFunc = canFoldBlade;
/*  18 */     setPostion(posx, posy, posz);
/*  19 */     setRotation(rotx, roty, rotz);
/*     */   }
/*     */   
/*     */   public MCH_Rotor setPostion(float x, float y, float z) {
/*  23 */     return this;
/*     */   }
/*     */   
/*     */   public MCH_Rotor setRotation(float x, float y, float z) {
/*  27 */     return this;
/*     */   }
/*     */   
/*     */   public int getBladeNum() {
/*  31 */     return this.numBlade;
/*     */   }
/*     */   
/*     */   public void setupBlade(int num, int invRot, int foldSpeed) {
/*  35 */     this.invRot = (invRot > 0) ? invRot : 1;
/*  36 */     this.numBlade = (num > 0) ? num : 1;
/*  37 */     this.blades = new MCH_Blade[this.numBlade];
/*     */     
/*  39 */     for (int i = 0; i < this.numBlade; i++) {
/*  40 */       this.blades[i] = new MCH_Blade((i * this.invRot));
/*  41 */       this.blades[i].setFoldRotation((5 + i * 3)).setFoldSpeed(foldSpeed);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFoldingOrUnfolding() {
/*  47 */     return (this.isFoldBlade != this.isFoldBladeTarget);
/*     */   }
/*     */   
/*     */   public float getBladeRotaion(int bladeIndex) {
/*  51 */     return (bladeIndex >= this.numBlade) ? 0.0F : this.blades[bladeIndex].getRotation();
/*     */   }
/*     */   
/*     */   public void startUnfold() {
/*  55 */     this.isFoldBladeTarget = false;
/*     */   }
/*     */   
/*     */   public void startFold() {
/*  59 */     if (this.haveFoldBladeFunc) {
/*  60 */       this.isFoldBladeTarget = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void forceFold() {
/*  66 */     if (this.haveFoldBladeFunc) {
/*  67 */       this.isFoldBladeTarget = true;
/*  68 */       this.isFoldBlade = true;
/*  69 */       MCH_Blade[] arr$ = this.blades;
/*  70 */       int len$ = arr$.length;
/*     */       
/*  72 */       for (int i$ = 0; i$ < len$; i$++) {
/*  73 */         MCH_Blade b = arr$[i$];
/*  74 */         b.forceFold();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(float rot) {
/*  81 */     boolean isCmpFoldUnfold = true;
/*  82 */     MCH_Blade[] arr$ = this.blades;
/*  83 */     int len$ = arr$.length;
/*     */     
/*  85 */     for (int i$ = 0; i$ < len$; i$++) {
/*  86 */       MCH_Blade b = arr$[i$];
/*  87 */       b.setPrevRotation(b.getRotation());
/*  88 */       if (!this.isFoldBlade) {
/*  89 */         if (!this.isFoldBladeTarget) {
/*  90 */           b.setRotation(rot + b.getBaseRotation());
/*  91 */           isCmpFoldUnfold = false;
/*  92 */         } else if (!b.folding()) {
/*  93 */           isCmpFoldUnfold = false;
/*     */         } 
/*  95 */       } else if (this.isFoldBladeTarget) {
/*  96 */         isCmpFoldUnfold = false;
/*  97 */       } else if (!b.unfolding(rot)) {
/*  98 */         isCmpFoldUnfold = false;
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     if (isCmpFoldUnfold)
/* 103 */       this.isFoldBlade = this.isFoldBladeTarget; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_Rotor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */