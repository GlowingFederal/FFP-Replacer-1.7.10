/*    */ package mcheli.hud;
/*    */ 
/*    */ public class MCH_HudItemColor
/*    */   extends MCH_HudItem
/*    */ {
/*    */   private final String updateColor;
/*    */   
/*    */   public MCH_HudItemColor(int fileLine, String newColor) {
/*  9 */     super(fileLine);
/* 10 */     this.updateColor = newColor;
/*    */   }
/*    */   
/*    */   public static MCH_HudItemColor createByParams(int fileLine, String[] prm) {
/* 14 */     return (prm.length == 1) ? new MCH_HudItemColor(fileLine, toFormula(prm[0])) : ((prm.length == 4) ? new MCH_HudItemColor(fileLine, "((" + toFormula(prm[0]) + ")<<24)|((" + toFormula(prm[1]) + ")<<16)|((" + toFormula(prm[2]) + ")<<8 )|((" + toFormula(prm[3]) + ")<<0 )") : null);
/*    */   }
/*    */   
/*    */   public void execute() {
/* 18 */     double d = calc(this.updateColor);
/* 19 */     long l = (long)d;
/* 20 */     MCH_HudItem.colorSetting = (int)l;
/* 21 */     updateVarMapItem("color", getColor());
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItemColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */