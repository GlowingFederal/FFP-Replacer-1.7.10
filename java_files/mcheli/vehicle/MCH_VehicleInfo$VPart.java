/*     */ package mcheli.vehicle;
/*     */ 
/*     */ import java.util.List;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
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
/*     */ public class VPart
/*     */   extends MCH_AircraftInfo.DrawnPart
/*     */ {
/*     */   public final boolean rotPitch;
/*     */   public final boolean rotYaw;
/*     */   public final int type;
/*     */   public List child;
/*     */   public final boolean drawFP;
/*     */   public final float recoilBuf;
/*     */   
/*     */   public VPart(float x, float y, float z, String model, boolean drawfp, boolean roty, boolean rotp, int type, float rb) {
/* 108 */     super(MCH_VehicleInfo.this, x, y, z, 0.0F, 0.0F, 0.0F, model);
/* 109 */     this.rotYaw = roty;
/* 110 */     this.rotPitch = rotp;
/* 111 */     this.type = type;
/* 112 */     this.child = null;
/* 113 */     this.drawFP = drawfp;
/* 114 */     this.recoilBuf = rb;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\vehicle\MCH_VehicleInfo$VPart.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */