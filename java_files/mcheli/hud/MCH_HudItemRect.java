/*    */ package mcheli.hud;
/*    */ 
/*    */ public class MCH_HudItemRect
/*    */   extends MCH_HudItem
/*    */ {
/*    */   private final String left;
/*    */   private final String top;
/*    */   private final String width;
/*    */   private final String height;
/*    */   
/*    */   public MCH_HudItemRect(int fileLine, String left, String top, String width, String height) {
/* 12 */     super(fileLine);
/* 13 */     this.left = toFormula(left);
/* 14 */     this.top = toFormula(top);
/* 15 */     this.width = toFormula(width);
/* 16 */     this.height = toFormula(height);
/*    */   }
/*    */   
/*    */   public void execute() {
/* 20 */     double x2 = MCH_HudItem.centerX + calc(this.left);
/* 21 */     double y2 = MCH_HudItem.centerY + calc(this.top);
/* 22 */     double x1 = x2 + (int)calc(this.width);
/* 23 */     double y1 = y2 + (int)calc(this.height);
/* 24 */     drawRect(x1, y1, x2, y2, MCH_HudItem.colorSetting);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItemRect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */