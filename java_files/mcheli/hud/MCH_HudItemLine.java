/*    */ package mcheli.hud;
/*    */ 
/*    */ public class MCH_HudItemLine
/*    */   extends MCH_HudItem
/*    */ {
/*    */   private final String[] pos;
/*    */   
/*    */   public MCH_HudItemLine(int fileLine, String[] position) {
/*  9 */     super(fileLine);
/* 10 */     this.pos = new String[position.length];
/*    */     
/* 12 */     for (int i = 0; i < position.length; i++) {
/* 13 */       this.pos[i] = position[i].toLowerCase();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void execute() {
/* 19 */     double[] lines = new double[this.pos.length];
/*    */     
/* 21 */     for (int i = 0; i < lines.length; i += 2) {
/* 22 */       lines[i + 0] = MCH_HudItem.centerX + calc(this.pos[i + 0]);
/* 23 */       lines[i + 1] = MCH_HudItem.centerY + calc(this.pos[i + 1]);
/*    */     } 
/*    */     
/* 26 */     drawLine(lines, MCH_HudItem.colorSetting, 3);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItemLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */