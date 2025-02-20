/*    */ package mcheli.wrapper.modelloader;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class W_GroupObject
/*    */ {
/*    */   public String name;
/*    */   public ArrayList faces;
/*    */   public int glDrawingMode;
/*    */   
/*    */   public W_GroupObject() {
/* 19 */     this("");
/*    */   }
/*    */   
/*    */   public W_GroupObject(String name) {
/* 23 */     this(name, -1);
/*    */   }
/*    */   
/*    */   public W_GroupObject(String name, int glDrawingMode) {
/* 27 */     this.faces = new ArrayList();
/* 28 */     this.name = name;
/* 29 */     this.glDrawingMode = glDrawingMode;
/*    */   }
/*    */   
/*    */   public void render() {
/* 33 */     if (this.faces.size() > 0) {
/* 34 */       Tessellator tessellator = Tessellator.field_78398_a;
/* 35 */       tessellator.func_78371_b(this.glDrawingMode);
/* 36 */       render(tessellator);
/* 37 */       tessellator.func_78381_a();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(Tessellator tessellator) {
/* 43 */     if (this.faces.size() > 0) {
/* 44 */       Iterator<W_Face> i$ = this.faces.iterator();
/*    */       
/* 46 */       while (i$.hasNext()) {
/* 47 */         W_Face face = i$.next();
/* 48 */         face.addFaceForRender(tessellator);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\modelloader\W_GroupObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */