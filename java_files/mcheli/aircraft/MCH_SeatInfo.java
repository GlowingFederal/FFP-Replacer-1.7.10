/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ 
/*    */ public class MCH_SeatInfo
/*    */ {
/*    */   public final Vec3 pos;
/*    */   public final boolean gunner;
/*    */   private final MCH_AircraftInfo.CameraPosition camPos;
/*    */   public boolean invCamPos;
/*    */   public final boolean switchgunner;
/*    */   public final boolean fixRot;
/*    */   public final float fixYaw;
/*    */   public final float fixPitch;
/*    */   public final float minPitch;
/*    */   public final float maxPitch;
/*    */   public final boolean rotSeat;
/*    */   
/*    */   public MCH_SeatInfo(Vec3 p, boolean g, MCH_AircraftInfo.CameraPosition cp, boolean icp, boolean sg, boolean fr, float yaw, float pitch, float pmin, float pmax, boolean rotSeat) {
/* 21 */     this.camPos = cp;
/* 22 */     this.pos = p;
/* 23 */     this.gunner = g;
/* 24 */     this.invCamPos = icp;
/* 25 */     this.switchgunner = sg;
/* 26 */     this.fixRot = fr;
/* 27 */     this.fixYaw = yaw;
/* 28 */     this.fixPitch = pitch;
/* 29 */     this.minPitch = pmin;
/* 30 */     this.maxPitch = pmax;
/* 31 */     this.rotSeat = rotSeat;
/*    */   }
/*    */   
/*    */   public MCH_SeatInfo(Vec3 p, boolean g, MCH_AircraftInfo.CameraPosition cp, boolean icp, boolean sg, boolean fr, float yaw, float pitch, boolean rotSeat) {
/* 35 */     this(p, g, cp, icp, sg, fr, yaw, pitch, -30.0F, 70.0F, rotSeat);
/*    */   }
/*    */   
/*    */   public MCH_SeatInfo(Vec3 p, MCH_AircraftInfo.CameraPosition cp, float yaw, float pitch, boolean rotSeat) {
/* 39 */     this(p, false, cp, false, false, false, yaw, pitch, -30.0F, 70.0F, rotSeat);
/*    */   }
/*    */   
/*    */   public MCH_SeatInfo(Vec3 p, boolean rotSeat) {
/* 43 */     this(p, false, (MCH_AircraftInfo.CameraPosition)null, false, false, false, 0.0F, 0.0F, -30.0F, 70.0F, rotSeat);
/*    */   }
/*    */   
/*    */   public MCH_AircraftInfo.CameraPosition getCamPos() {
/* 47 */     return this.camPos;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_SeatInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */