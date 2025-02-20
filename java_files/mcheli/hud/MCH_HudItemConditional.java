/*    */ package mcheli.hud;
/*    */ 
/*    */ public class MCH_HudItemConditional
/*    */   extends MCH_HudItem
/*    */ {
/*    */   private final boolean isEndif;
/*    */   private final String conditional;
/*    */   
/*    */   public MCH_HudItemConditional(int fileLine, boolean isEndif, String conditional) {
/* 10 */     super(fileLine);
/* 11 */     this.isEndif = isEndif;
/* 12 */     this.conditional = conditional;
/*    */   }
/*    */   
/*    */   public boolean canExecute() {
/* 16 */     return true;
/*    */   }
/*    */   
/*    */   public void execute() {
/* 20 */     if (!this.isEndif) {
/* 21 */       this.parent.isIfFalse = (calc(this.conditional) == 0.0D);
/*    */     } else {
/* 23 */       this.parent.isIfFalse = false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItemConditional.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */