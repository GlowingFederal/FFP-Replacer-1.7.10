/*    */ package mcheli.helicopter;
/*    */ 
/*    */ import mcheli.aircraft.MCH_AircraftInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Rotor
/*    */   extends MCH_AircraftInfo.DrawnPart
/*    */ {
/*    */   public final int bladeNum;
/*    */   public final int bladeRot;
/*    */   public final boolean haveFoldFunc;
/*    */   public final boolean oldRenderMethod;
/*    */   
/*    */   public Rotor(int b, int br, float x, float y, float z, float rx, float ry, float rz, String model, boolean hf, boolean old) {
/* 95 */     super(MCH_HeliInfo.this, x, y, z, rx, ry, rz, model);
/* 96 */     this.bladeNum = b;
/* 97 */     this.bladeRot = br;
/* 98 */     this.haveFoldFunc = hf;
/* 99 */     this.oldRenderMethod = old;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\helicopter\MCH_HeliInfo$Rotor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */