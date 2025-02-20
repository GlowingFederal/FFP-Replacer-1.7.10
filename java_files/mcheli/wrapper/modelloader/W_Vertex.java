/*    */ package mcheli.wrapper.modelloader;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class W_Vertex
/*    */ {
/*    */   public float x;
/*    */   public float y;
/*    */   public float z;
/*    */   
/*    */   public W_Vertex(float x, float y) {
/* 15 */     this(x, y, 0.0F);
/*    */   }
/*    */   
/*    */   public W_Vertex(float x, float y, float z) {
/* 19 */     this.x = x;
/* 20 */     this.y = y;
/* 21 */     this.z = z;
/*    */   }
/*    */   
/*    */   public void normalize() {
/* 25 */     double d = Math.sqrt((this.x * this.x + this.y * this.y + this.z * this.z));
/* 26 */     this.x = (float)(this.x / d);
/* 27 */     this.y = (float)(this.y / d);
/* 28 */     this.z = (float)(this.z / d);
/*    */   }
/*    */   
/*    */   public void add(W_Vertex v) {
/* 32 */     this.x += v.x;
/* 33 */     this.y += v.y;
/* 34 */     this.z += v.z;
/*    */   }
/*    */   
/*    */   public boolean equal(W_Vertex v) {
/* 38 */     return (this.x == v.x && this.y == v.y && this.z == v.z);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\modelloader\W_Vertex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */