/*    */ package mcheli;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.wrapper.W_EntityRenderer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.ItemRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_ItemRendererDummy
/*    */   extends ItemRenderer
/*    */ {
/*    */   protected static Minecraft mc;
/*    */   protected static ItemRenderer backupItemRenderer;
/*    */   protected static MCH_ItemRendererDummy instance;
/*    */   
/*    */   public MCH_ItemRendererDummy(Minecraft par1Minecraft) {
/* 21 */     super(par1Minecraft);
/* 22 */     mc = par1Minecraft;
/*    */   }
/*    */   
/*    */   public void func_78440_a(float par1) {
/* 26 */     if (mc.field_71439_g == null) {
/* 27 */       super.func_78440_a(par1);
/* 28 */     } else if (!(mc.field_71439_g.field_70154_o instanceof mcheli.aircraft.MCH_EntityAircraft) && !(mc.field_71439_g.field_70154_o instanceof mcheli.uav.MCH_EntityUavStation) && !(mc.field_71439_g.field_70154_o instanceof mcheli.gltd.MCH_EntityGLTD)) {
/* 29 */       super.func_78440_a(par1);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void enableDummyItemRenderer() {
/* 35 */     if (instance == null) {
/* 36 */       instance = new MCH_ItemRendererDummy(Minecraft.func_71410_x());
/*    */     }
/*    */     
/* 39 */     if (!(mc.field_71460_t.field_78516_c instanceof MCH_ItemRendererDummy)) {
/* 40 */       backupItemRenderer = mc.field_71460_t.field_78516_c;
/*    */     }
/*    */     
/* 43 */     W_EntityRenderer.setItemRenderer(mc, instance);
/*    */   }
/*    */   
/*    */   public static void disableDummyItemRenderer() {
/* 47 */     if (backupItemRenderer != null)
/* 48 */       W_EntityRenderer.setItemRenderer(mc, backupItemRenderer); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_ItemRendererDummy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */