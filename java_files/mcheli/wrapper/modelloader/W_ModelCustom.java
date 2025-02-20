/*    */ package mcheli.wrapper.modelloader;
/*    */ 
/*    */ import net.minecraftforge.client.model.IModelCustom;
/*    */ 
/*    */ public abstract class W_ModelCustom
/*    */   implements IModelCustom {
/*  7 */   public float min = 100000.0F;
/*  8 */   public float minX = 100000.0F;
/*  9 */   public float minY = 100000.0F;
/* 10 */   public float minZ = 100000.0F;
/* 11 */   public float max = -100000.0F;
/* 12 */   public float maxX = -100000.0F;
/* 13 */   public float maxY = -100000.0F;
/* 14 */   public float maxZ = -100000.0F;
/* 15 */   public float size = 0.0F;
/* 16 */   public float sizeX = 0.0F;
/* 17 */   public float sizeY = 0.0F;
/* 18 */   public float sizeZ = 0.0F;
/*    */ 
/*    */   
/*    */   public void checkMinMax(W_Vertex v) {
/* 22 */     if (v.x < this.minX) {
/* 23 */       this.minX = v.x;
/*    */     }
/*    */     
/* 26 */     if (v.y < this.minY) {
/* 27 */       this.minY = v.y;
/*    */     }
/*    */     
/* 30 */     if (v.z < this.minZ) {
/* 31 */       this.minZ = v.z;
/*    */     }
/*    */     
/* 34 */     if (v.x > this.maxX) {
/* 35 */       this.maxX = v.x;
/*    */     }
/*    */     
/* 38 */     if (v.y > this.maxY) {
/* 39 */       this.maxY = v.y;
/*    */     }
/*    */     
/* 42 */     if (v.z > this.maxZ) {
/* 43 */       this.maxZ = v.z;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void checkMinMaxFinal() {
/* 49 */     if (this.minX < this.min) {
/* 50 */       this.min = this.minX;
/*    */     }
/*    */     
/* 53 */     if (this.minY < this.min) {
/* 54 */       this.min = this.minY;
/*    */     }
/*    */     
/* 57 */     if (this.minZ < this.min) {
/* 58 */       this.min = this.minZ;
/*    */     }
/*    */     
/* 61 */     if (this.maxX > this.max) {
/* 62 */       this.max = this.maxX;
/*    */     }
/*    */     
/* 65 */     if (this.maxY > this.max) {
/* 66 */       this.max = this.maxY;
/*    */     }
/*    */     
/* 69 */     if (this.maxZ > this.max) {
/* 70 */       this.max = this.maxZ;
/*    */     }
/*    */     
/* 73 */     this.sizeX = this.maxX - this.minX;
/* 74 */     this.sizeY = this.maxY - this.minY;
/* 75 */     this.sizeZ = this.maxZ - this.minZ;
/* 76 */     this.size = this.max - this.min;
/*    */   }
/*    */   
/*    */   public abstract boolean containsPart(String paramString);
/*    */   
/*    */   public abstract void renderAll(int paramInt1, int paramInt2);
/*    */   
/*    */   public abstract void renderAllLine(int paramInt1, int paramInt2);
/*    */   
/*    */   public abstract int getVertexNum();
/*    */   
/*    */   public abstract int getFaceNum();
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\modelloader\W_ModelCustom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */