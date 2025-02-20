/*     */ package mcheli;
/*     */ 
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_EntityRenderer;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class MCH_Camera
/*     */ {
/*     */   private final World worldObj;
/*     */   private float zoom;
/*     */   private int[] mode;
/*     */   private boolean[] canUseShader;
/*     */   private int[] lastMode;
/*     */   public double posX;
/*     */   public double posY;
/*     */   public double posZ;
/*     */   public float rotationYaw;
/*     */   public float rotationPitch;
/*     */   public float prevRotationYaw;
/*     */   public float prevRotationPitch;
/*     */   private int lastZoomDir;
/*     */   public float partRotationYaw;
/*     */   public float partRotationPitch;
/*     */   public float prevPartRotationYaw;
/*     */   public float prevPartRotationPitch;
/*     */   public static final int MODE_NORMAL = 0;
/*     */   public static final int MODE_NIGHTVISION = 1;
/*     */   public static final int MODE_THERMALVISION = 2;
/*     */   
/*     */   public MCH_Camera(World w, Entity p) {
/*  36 */     this.worldObj = w;
/*  37 */     this.mode = new int[] { 0, 0 };
/*  38 */     this.zoom = 1.0F;
/*  39 */     this.lastMode = new int[getUserMax()];
/*  40 */     this.lastZoomDir = 0;
/*  41 */     this.canUseShader = new boolean[getUserMax()];
/*     */   }
/*     */   
/*     */   public MCH_Camera(World w, Entity p, double x, double y, double z) {
/*  45 */     this(w, p);
/*  46 */     setPosition(x, y, z);
/*  47 */     setCameraZoom(1.0F);
/*     */   }
/*     */   
/*     */   public int getUserMax() {
/*  51 */     return this.mode.length;
/*     */   }
/*     */   
/*     */   public void initCamera(int uid, Entity viewer) {
/*  55 */     setCameraZoom(1.0F);
/*  56 */     setMode(uid, 0);
/*  57 */     updateViewer(uid, viewer);
/*     */   }
/*     */   
/*     */   public void setMode(int uid, int m) {
/*  61 */     if (isValidUid(uid)) {
/*  62 */       this.mode[uid] = (m < 0) ? 0 : (m % getModeNum(uid));
/*  63 */       switch (this.mode[uid]) {
/*     */         case 0:
/*     */         case 1:
/*  66 */           if (this.worldObj.field_72995_K) {
/*  67 */             W_EntityRenderer.deactivateShader();
/*     */           }
/*     */           break;
/*     */         case 2:
/*  71 */           if (this.worldObj.field_72995_K) {
/*  72 */             W_EntityRenderer.activateShader("pencil");
/*     */           }
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setShaderSupport(int uid, Boolean b) {
/*  80 */     if (isValidUid(uid)) {
/*  81 */       setMode(uid, 0);
/*  82 */       this.canUseShader[uid] = b.booleanValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValidUid(int uid) {
/*  88 */     return (uid >= 0 && uid < getUserMax());
/*     */   }
/*     */   
/*     */   public int getModeNum(int uid) {
/*  92 */     return !isValidUid(uid) ? 2 : (this.canUseShader[uid] ? 3 : 2);
/*     */   }
/*     */   
/*     */   public int getMode(int uid) {
/*  96 */     return isValidUid(uid) ? this.mode[uid] : 0;
/*     */   }
/*     */   
/*     */   public String getModeName(int uid) {
/* 100 */     return (getMode(uid) == 1) ? "NIGHT VISION" : ((getMode(uid) == 2) ? "THERMAL VISION" : "");
/*     */   }
/*     */   
/*     */   public void updateViewer(int uid, Entity viewer) {
/* 104 */     if (isValidUid(uid) && viewer != null) {
/* 105 */       if (W_Lib.isEntityLivingBase(viewer) && !viewer.field_70128_L) {
/*     */         
/* 107 */         if (getMode(uid) == 0 && this.lastMode[uid] != 0) {
/* 108 */           PotionEffect pe = W_Entity.getActivePotionEffect(viewer, Potion.field_76439_r);
/* 109 */           if (pe != null && pe.func_76459_b() > 0 && pe.func_76459_b() < 500) {
/* 110 */             if (viewer.field_70170_p.field_72995_K) {
/* 111 */               W_Entity.removePotionEffectClient(viewer, Potion.field_76439_r.field_76415_H);
/*     */             } else {
/* 113 */               W_Entity.removePotionEffect(viewer, Potion.field_76439_r.field_76415_H);
/*     */             } 
/*     */           }
/*     */         } 
/*     */         
/* 118 */         if (getMode(uid) == 1 || getMode(uid) == 2) {
/* 119 */           PotionEffect pe = W_Entity.getActivePotionEffect(viewer, Potion.field_76439_r);
/* 120 */           if ((pe == null || (pe != null && pe.func_76459_b() < 500)) && !viewer.field_70170_p.field_72995_K) {
/* 121 */             W_Entity.addPotionEffect(viewer, new PotionEffect(Potion.field_76439_r.field_76415_H, 250, 0, true));
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 126 */       this.lastMode[uid] = getMode(uid);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setPosition(double x, double y, double z) {
/* 131 */     this.posX = x;
/* 132 */     this.posY = y;
/* 133 */     this.posZ = z;
/*     */   }
/*     */   
/*     */   public void setCameraZoom(float z) {
/* 137 */     float prevZoom = this.zoom;
/* 138 */     this.zoom = (z < 1.0F) ? 1.0F : z;
/* 139 */     if (this.zoom > prevZoom) {
/* 140 */       this.lastZoomDir = 1;
/* 141 */     } else if (this.zoom < prevZoom) {
/* 142 */       this.lastZoomDir = -1;
/*     */     } else {
/* 144 */       this.lastZoomDir = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float getCameraZoom() {
/* 150 */     return this.zoom;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_Camera.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */