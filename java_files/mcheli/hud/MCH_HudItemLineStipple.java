/*    */ package mcheli.hud;
/*    */ 
/*    */ public class MCH_HudItemLineStipple
/*    */   extends MCH_HudItem
/*    */ {
/*    */   private final String pat;
/*    */   private final String fac;
/*    */   private final String[] pos;
/*    */   
/*    */   public MCH_HudItemLineStipple(int fileLine, String[] position) {
/* 11 */     super(fileLine);
/* 12 */     this.pat = position[0];
/* 13 */     this.fac = position[1];
/* 14 */     this.pos = new String[position.length - 2];
/*    */     
/* 16 */     for (int i = 0; i < position.length - 2; i++) {
/* 17 */       this.pos[i] = toFormula(position[2 + i]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute() {
/* 23 */     double[] lines = new double[this.pos.length];
/*    */     
/* 25 */     for (int i = 0; i < lines.length; i += 2) {
/* 26 */       lines[i + 0] = MCH_HudItem.centerX + calc(this.pos[i + 0]);
/* 27 */       lines[i + 1] = MCH_HudItem.centerY + calc(this.pos[i + 1]);
/*    */     } 
/*    */     
/* 30 */     drawLineStipple(lines, MCH_HudItem.colorSetting, (int)calc(this.fac), (int)calc(this.pat));
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItemLineStipple.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */