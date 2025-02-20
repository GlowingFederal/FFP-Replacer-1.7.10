/*    */ package mcheli;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class MCH_TEST_ModelRenderer
/*    */   extends ModelRenderer {
/*    */   public MCH_TEST_ModelRenderer(ModelBase par1ModelBase) {
/* 10 */     super(par1ModelBase);
/*    */   }
/*    */   
/*    */   public void func_78785_a(float par1) {
/* 14 */     GL11.glPushMatrix();
/* 15 */     GL11.glScaled(0.2D, -0.2D, 0.2D);
/* 16 */     MCH_ModelManager.render("helicopters", "ah-64");
/* 17 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_TEST_ModelRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */