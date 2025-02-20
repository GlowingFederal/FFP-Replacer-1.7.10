/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ public class MCH_Parts
/*     */ {
/*     */   public final Entity parent;
/*     */   public final DataWatcher dataWatcher;
/*     */   public final int shift;
/*     */   public final int dataIndex;
/*     */   public final String partName;
/*  15 */   public float prevRotation = 0.0F;
/*  16 */   public float rotation = 0.0F;
/*  17 */   public float rotationMax = 90.0F;
/*  18 */   public float rotationInv = 1.0F;
/*  19 */   public Sound soundStartSwichOn = new Sound();
/*  20 */   public Sound soundEndSwichOn = new Sound();
/*  21 */   public Sound soundSwitching = new Sound();
/*  22 */   public Sound soundStartSwichOff = new Sound();
/*  23 */   public Sound soundEndSwichOff = new Sound();
/*     */   
/*     */   private boolean status = false;
/*     */   
/*     */   public MCH_Parts(Entity parent, int shiftBit, int dataWatcherIndex, String name) {
/*  28 */     this.parent = parent;
/*  29 */     this.dataWatcher = parent.func_70096_w();
/*  30 */     this.shift = shiftBit;
/*  31 */     this.dataIndex = dataWatcherIndex;
/*  32 */     this.status = ((getDataWatcherValue() & 1 << this.shift) != 0);
/*  33 */     this.partName = name;
/*     */   }
/*     */   
/*     */   public int getDataWatcherValue() {
/*  37 */     return this.dataWatcher.func_75679_c(this.dataIndex);
/*     */   }
/*     */   
/*     */   public void setStatusServer(boolean stat) {
/*  41 */     setStatusServer(stat, true);
/*     */   }
/*     */   
/*     */   public void setStatusServer(boolean stat, boolean playSound) {
/*  45 */     if (!this.parent.field_70170_p.field_72995_K && getStatus() != stat) {
/*  46 */       MCH_Lib.DbgLog(false, "setStatusServer(ID=%d %s :%s -> %s)", new Object[] { Integer.valueOf(this.shift), this.partName, getStatus() ? "ON" : "OFF", stat ? "ON" : "OFF" });
/*  47 */       updateDataWatcher(stat);
/*  48 */       playSound(this.soundSwitching);
/*  49 */       if (!stat) {
/*  50 */         playSound(this.soundStartSwichOff);
/*     */       } else {
/*  52 */         playSound(this.soundStartSwichOn);
/*     */       } 
/*     */       
/*  55 */       update();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateDataWatcher(boolean stat) {
/*  61 */     int currentStatus = this.dataWatcher.func_75679_c(this.dataIndex);
/*  62 */     int mask = 1 << this.shift;
/*  63 */     if (!stat) {
/*  64 */       this.dataWatcher.func_75692_b(this.dataIndex, Integer.valueOf(currentStatus & (mask ^ 0xFFFFFFFF)));
/*     */     } else {
/*  66 */       this.dataWatcher.func_75692_b(this.dataIndex, Integer.valueOf(currentStatus | mask));
/*     */     } 
/*     */     
/*  69 */     this.status = stat;
/*     */   }
/*     */   
/*     */   public boolean getStatus() {
/*  73 */     return this.status;
/*     */   }
/*     */   
/*     */   public boolean isOFF() {
/*  77 */     return (!this.status && this.rotation <= 0.02F);
/*     */   }
/*     */   
/*     */   public boolean isON() {
/*  81 */     return (this.status && this.rotation >= this.rotationMax - 0.02F);
/*     */   }
/*     */   
/*     */   public void updateStatusClient(int statFromDataWatcher) {
/*  85 */     if (this.parent.field_70170_p.field_72995_K) {
/*  86 */       this.status = ((statFromDataWatcher & 1 << this.shift) != 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/*  92 */     this.prevRotation = this.rotation;
/*  93 */     if (getStatus()) {
/*  94 */       if (this.rotation < this.rotationMax) {
/*  95 */         this.rotation += this.rotationInv;
/*  96 */         if (this.rotation >= this.rotationMax) {
/*  97 */           playSound(this.soundEndSwichOn);
/*     */         }
/*     */       } 
/* 100 */     } else if (this.rotation > 0.0F) {
/* 101 */       this.rotation -= this.rotationInv;
/* 102 */       if (this.rotation <= 0.0F) {
/* 103 */         playSound(this.soundEndSwichOff);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void forceSwitch(boolean onoff) {
/* 110 */     updateDataWatcher(onoff);
/* 111 */     this.rotation = this.prevRotation = this.rotationMax;
/*     */   }
/*     */   
/*     */   public float getFactor() {
/* 115 */     return (this.rotationMax > 0.0F) ? (this.rotation / this.rotationMax) : 0.0F;
/*     */   }
/*     */   
/*     */   public void playSound(Sound snd) {
/* 119 */     if (!snd.name.isEmpty() && !this.parent.field_70170_p.field_72995_K) {
/* 120 */       W_WorldFunc.MOD_playSoundAtEntity(this.parent, snd.name, snd.volume, snd.pitch);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class Sound
/*     */   {
/* 127 */     public String name = "";
/* 128 */     public float volume = 1.0F;
/* 129 */     public float pitch = 1.0F;
/*     */ 
/*     */     
/*     */     public void setPrm(String n, float v, float p) {
/* 133 */       this.name = n;
/* 134 */       this.volume = v;
/* 135 */       this.pitch = p;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_Parts.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */