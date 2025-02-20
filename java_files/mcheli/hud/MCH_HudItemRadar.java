/*    */ package mcheli.hud;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.MCH_Vector2;
/*    */ 
/*    */ 
/*    */ public class MCH_HudItemRadar
/*    */   extends MCH_HudItem
/*    */ {
/*    */   private final String rot;
/*    */   private final String left;
/*    */   private final String top;
/*    */   private final String width;
/*    */   private final String height;
/*    */   private final boolean isEntityRadar;
/*    */   
/*    */   public MCH_HudItemRadar(int fileLine, boolean isEntityRadar, String rot, String left, String top, String width, String height) {
/* 20 */     super(fileLine);
/* 21 */     this.isEntityRadar = isEntityRadar;
/* 22 */     this.rot = toFormula(rot);
/* 23 */     this.left = toFormula(left);
/* 24 */     this.top = toFormula(top);
/* 25 */     this.width = toFormula(width);
/* 26 */     this.height = toFormula(height);
/*    */   }
/*    */   
/*    */   public void execute() {
/* 30 */     if (this.isEntityRadar) {
/* 31 */       if (MCH_HudItem.EntityList != null && MCH_HudItem.EntityList.size() > 0) {
/* 32 */         drawEntityList(MCH_HudItem.EntityList, (float)calc(this.rot), MCH_HudItem.centerX + calc(this.left), MCH_HudItem.centerY + calc(this.top), calc(this.width), calc(this.height));
/*    */       }
/* 34 */     } else if (MCH_HudItem.EnemyList != null && MCH_HudItem.EnemyList.size() > 0) {
/* 35 */       drawEntityList(MCH_HudItem.EnemyList, (float)calc(this.rot), MCH_HudItem.centerX + calc(this.left), MCH_HudItem.centerY + calc(this.top), calc(this.width), calc(this.height));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void drawEntityList(ArrayList src, float r, double left, double top, double w, double h) {
/* 41 */     double w1 = -w / 2.0D;
/* 42 */     double w2 = w / 2.0D;
/* 43 */     double h1 = -h / 2.0D;
/* 44 */     double h2 = h / 2.0D;
/* 45 */     double w_factor = w / 196.0D;
/* 46 */     double h_factor = h / 196.0D;
/* 47 */     double[] list = new double[src.size() * 2];
/* 48 */     int idx = 0;
/*    */     
/* 50 */     for (Iterator<MCH_Vector2> drawList = src.iterator(); drawList.hasNext(); idx += 2) {
/* 51 */       MCH_Vector2 i = drawList.next();
/* 52 */       list[idx + 0] = i.x / 2.0D * w_factor;
/* 53 */       list[idx + 1] = i.y / 2.0D * h_factor;
/*    */     } 
/*    */     
/* 56 */     MCH_Lib.rotatePoints(list, r);
/* 57 */     ArrayList<Double> drawList1 = new ArrayList();
/*    */     
/* 59 */     for (int i1 = 0; i1 + 1 < list.length; i1 += 2) {
/* 60 */       if (list[i1 + 0] > w1 && list[i1 + 0] < w2 && list[i1 + 1] > h1 && list[i1 + 1] < h2) {
/* 61 */         drawList1.add(Double.valueOf(list[i1 + 0] + left + w / 2.0D));
/* 62 */         drawList1.add(Double.valueOf(list[i1 + 1] + top + h / 2.0D));
/*    */       } 
/*    */     } 
/*    */     
/* 66 */     drawPoints(drawList1, MCH_HudItem.colorSetting, MCH_HudItem.scaleFactor * 2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItemRadar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */