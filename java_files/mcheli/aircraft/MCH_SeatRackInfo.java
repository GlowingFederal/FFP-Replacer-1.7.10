/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class MCH_SeatRackInfo
/*    */   extends MCH_SeatInfo
/*    */ {
/*    */   public final float range;
/*    */   public final float openParaAlt;
/*    */   public final String[] names;
/*    */   
/*    */   public MCH_SeatRackInfo(String[] entityNames, double x, double y, double z, MCH_AircraftInfo.CameraPosition ep, float rng, float paraAlt, float yaw, float pitch, boolean rotSeat) {
/* 13 */     super(Vec3.func_72443_a(x, y, z), ep, yaw, pitch, rotSeat);
/* 14 */     this.range = rng;
/* 15 */     this.openParaAlt = paraAlt;
/* 16 */     this.names = entityNames;
/*    */   }
/*    */   
/*    */   public Vec3 getEntryPos() {
/* 20 */     return (getCamPos()).pos;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_SeatRackInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */