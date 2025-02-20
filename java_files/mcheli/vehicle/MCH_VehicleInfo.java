/*     */ package mcheli.vehicle;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import net.minecraft.item.Item;
/*     */ 
/*     */ public class MCH_VehicleInfo
/*     */   extends MCH_AircraftInfo
/*     */ {
/*  12 */   public MCH_ItemVehicle item = null;
/*     */   public boolean isEnableMove = false;
/*     */   public boolean isEnableRot = false;
/*  15 */   public List partList = new ArrayList();
/*     */ 
/*     */   
/*     */   public float getMinRotationPitch() {
/*  19 */     return -90.0F;
/*     */   }
/*     */   
/*     */   public float getMaxRotationPitch() {
/*  23 */     return 90.0F;
/*     */   }
/*     */   
/*     */   public Item getItem() {
/*  27 */     return (Item)this.item;
/*     */   }
/*     */   
/*     */   public MCH_VehicleInfo(String name) {
/*  31 */     super(name);
/*     */   }
/*     */   
/*     */   public boolean isValidData() throws Exception {
/*  35 */     return super.isValidData();
/*     */   }
/*     */   
/*     */   public String getDefaultHudName(int seatId) {
/*  39 */     return "vehicle";
/*     */   }
/*     */   
/*     */   public void loadItemData(String item, String data) {
/*  43 */     super.loadItemData(item, data);
/*  44 */     if (item.compareTo("canmove") == 0) {
/*  45 */       this.isEnableMove = toBool(data);
/*  46 */     } else if (item.compareTo("canrotation") == 0) {
/*  47 */       this.isEnableRot = toBool(data);
/*  48 */     } else if (item.compareTo("rotationpitchmin") == 0) {
/*  49 */       super.loadItemData("minrotationpitch", data);
/*  50 */     } else if (item.compareTo("rotationpitchmax") == 0) {
/*  51 */       super.loadItemData("maxrotationpitch", data);
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  56 */     else if (item.compareTo("addpart") == 0) {
/*  57 */       String[] s = data.split("\\s*,\\s*");
/*  58 */       if (s.length >= 7) {
/*  59 */         float rb = (s.length >= 8) ? toFloat(s[7]) : 0.0F;
/*  60 */         VPart p = new VPart(toFloat(s[4]), toFloat(s[5]), toFloat(s[6]), "part" + this.partList.size(), toBool(s[0]), toBool(s[1]), toBool(s[2]), toInt(s[3]), rb);
/*  61 */         this.partList.add(p);
/*     */       } 
/*  63 */     } else if (item.compareTo("addchildpart") == 0 && this.partList.size() > 0) {
/*  64 */       String[] s = data.split("\\s*,\\s*");
/*  65 */       if (s.length >= 7) {
/*  66 */         float rb = (s.length >= 8) ? toFloat(s[7]) : 0.0F;
/*  67 */         VPart p = this.partList.get(this.partList.size() - 1);
/*  68 */         if (p.child == null) {
/*  69 */           p.child = new ArrayList();
/*     */         }
/*     */         
/*  72 */         VPart n = new VPart(toFloat(s[4]), toFloat(s[5]), toFloat(s[6]), p.modelName + "_" + p.child.size(), toBool(s[0]), toBool(s[1]), toBool(s[2]), toInt(s[3]), rb);
/*  73 */         p.child.add(n);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDirectoryName() {
/*  81 */     return "vehicles";
/*     */   }
/*     */   
/*     */   public String getKindName() {
/*  85 */     return "vehicle";
/*     */   }
/*     */   
/*     */   public void preReload() {
/*  89 */     super.preReload();
/*  90 */     this.partList.clear();
/*     */   }
/*     */   
/*     */   public void postReload() {
/*  94 */     MCH_MOD.proxy.registerModelsVehicle(this.name, true);
/*     */   }
/*     */   
/*     */   public class VPart
/*     */     extends MCH_AircraftInfo.DrawnPart
/*     */   {
/*     */     public final boolean rotPitch;
/*     */     public final boolean rotYaw;
/*     */     public final int type;
/*     */     public List child;
/*     */     public final boolean drawFP;
/*     */     public final float recoilBuf;
/*     */     
/*     */     public VPart(float x, float y, float z, String model, boolean drawfp, boolean roty, boolean rotp, int type, float rb) {
/* 108 */       super(MCH_VehicleInfo.this, x, y, z, 0.0F, 0.0F, 0.0F, model);
/* 109 */       this.rotYaw = roty;
/* 110 */       this.rotPitch = rotp;
/* 111 */       this.type = type;
/* 112 */       this.child = null;
/* 113 */       this.drawFP = drawfp;
/* 114 */       this.recoilBuf = rb;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\vehicle\MCH_VehicleInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */