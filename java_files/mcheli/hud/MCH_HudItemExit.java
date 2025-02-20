/*    */ package mcheli.hud;
/*    */ 
/*    */ public class MCH_HudItemExit
/*    */   extends MCH_HudItem {
/*    */   public MCH_HudItemExit(int fileLine) {
/*  6 */     super(fileLine);
/*    */   }
/*    */   
/*    */   public void execute() {
/* 10 */     this.parent.exit = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItemExit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */