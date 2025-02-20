/*    */ package mcheli.wrapper.modelloader;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class W_Face
/*    */ {
/*    */   public int[] verticesID;
/*    */   public W_Vertex[] vertices;
/*    */   public W_Vertex[] vertexNormals;
/*    */   public W_Vertex faceNormal;
/*    */   public W_TextureCoordinate[] textureCoordinates;
/*    */   
/*    */   public W_Face copy() {
/* 19 */     W_Face f = new W_Face();
/* 20 */     return f;
/*    */   }
/*    */   
/*    */   public void addFaceForRender(Tessellator tessellator) {
/* 24 */     addFaceForRender(tessellator, 0.0F);
/*    */   }
/*    */   
/*    */   public void addFaceForRender(Tessellator tessellator, float textureOffset) {
/* 28 */     if (this.faceNormal == null) {
/* 29 */       this.faceNormal = calculateFaceNormal();
/*    */     }
/*    */     
/* 32 */     tessellator.func_78375_b(this.faceNormal.x, this.faceNormal.y, this.faceNormal.z);
/* 33 */     float averageU = 0.0F;
/* 34 */     float averageV = 0.0F;
/* 35 */     if (this.textureCoordinates != null && this.textureCoordinates.length > 0) {
/* 36 */       for (int offsetU = 0; offsetU < this.textureCoordinates.length; offsetU++) {
/* 37 */         averageU += (this.textureCoordinates[offsetU]).u;
/* 38 */         averageV += (this.textureCoordinates[offsetU]).v;
/*    */       } 
/*    */       
/* 41 */       averageU /= this.textureCoordinates.length;
/* 42 */       averageV /= this.textureCoordinates.length;
/*    */     } 
/*    */     
/* 45 */     for (int i = 0; i < this.vertices.length; i++) {
/* 46 */       if (this.textureCoordinates != null && this.textureCoordinates.length > 0) {
/* 47 */         float var8 = textureOffset;
/* 48 */         float offsetV = textureOffset;
/* 49 */         if ((this.textureCoordinates[i]).u > averageU) {
/* 50 */           var8 = -textureOffset;
/*    */         }
/*    */         
/* 53 */         if ((this.textureCoordinates[i]).v > averageV) {
/* 54 */           offsetV = -textureOffset;
/*    */         }
/*    */         
/* 57 */         if (this.vertexNormals != null && i < this.vertexNormals.length) {
/* 58 */           tessellator.func_78375_b((this.vertexNormals[i]).x, (this.vertexNormals[i]).y, (this.vertexNormals[i]).z);
/*    */         }
/*    */         
/* 61 */         tessellator.func_78374_a((this.vertices[i]).x, (this.vertices[i]).y, (this.vertices[i]).z, ((this.textureCoordinates[i]).u + var8), ((this.textureCoordinates[i]).v + offsetV));
/*    */       } else {
/* 63 */         tessellator.func_78377_a((this.vertices[i]).x, (this.vertices[i]).y, (this.vertices[i]).z);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public W_Vertex calculateFaceNormal() {
/* 70 */     Vec3 v1 = Vec3.func_72443_a(((this.vertices[1]).x - (this.vertices[0]).x), ((this.vertices[1]).y - (this.vertices[0]).y), ((this.vertices[1]).z - (this.vertices[0]).z));
/* 71 */     Vec3 v2 = Vec3.func_72443_a(((this.vertices[2]).x - (this.vertices[0]).x), ((this.vertices[2]).y - (this.vertices[0]).y), ((this.vertices[2]).z - (this.vertices[0]).z));
/* 72 */     Vec3 normalVector = null;
/* 73 */     normalVector = v1.func_72431_c(v2).func_72432_b();
/* 74 */     return new W_Vertex((float)normalVector.field_72450_a, (float)normalVector.field_72448_b, (float)normalVector.field_72449_c);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\modelloader\W_Face.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */