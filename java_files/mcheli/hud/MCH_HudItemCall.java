/*    */ package mcheli.hud;
/*    */ 
/*    */ public class MCH_HudItemCall
/*    */   extends MCH_HudItem
/*    */ {
/*    */   private final String hudName;
/*    */   
/*    */   public MCH_HudItemCall(int fileLine, String name) {
/*  9 */     super(fileLine);
/* 10 */     this.hudName = name;
/*    */   }
/*    */   
/*    */   public void execute() {
/* 14 */     MCH_Hud hud = MCH_HudManager.get(this.hudName);
/* 15 */     if (hud != null)
/* 16 */       hud.drawItems(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItemCall.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */