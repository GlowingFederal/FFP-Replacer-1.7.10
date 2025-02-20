/*    */ package mcheli;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderNull
/*    */   extends W_Render {
/*    */   public MCH_RenderNull() {
/* 13 */     this.field_76989_e = 0.0F;
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double posX, double posY, double posZ, float par8, float tickTime) {}
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 19 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_RenderNull.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */