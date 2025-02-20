/*    */ package mcheli.gltd;
/*    */ 
/*    */ import mcheli.wrapper.W_McClient;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.IItemRenderer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class MCH_ItemGLTDRender
/*    */   implements IItemRenderer {
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/* 11 */     return (type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON || type == IItemRenderer.ItemRenderType.ENTITY);
/*    */   }
/*    */   
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/* 15 */     return (type == IItemRenderer.ItemRenderType.ENTITY);
/*    */   }
/*    */   
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/* 19 */     GL11.glPushMatrix();
/* 20 */     GL11.glEnable(2884);
/* 21 */     W_McClient.MOD_bindTexture("textures/gltd.png");
/* 22 */     switch (type) {
/*    */       case null:
/* 24 */         GL11.glEnable(32826);
/* 25 */         GL11.glEnable(2903);
/* 26 */         GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 27 */         MCH_RenderGLTD.model.renderAll();
/* 28 */         GL11.glDisable(32826);
/*    */         break;
/*    */       case null:
/* 31 */         GL11.glEnable(32826);
/* 32 */         GL11.glEnable(2903);
/* 33 */         GL11.glTranslatef(0.0F, 0.005F, -0.165F);
/* 34 */         GL11.glRotatef(-10.0F, 0.0F, 0.0F, 1.0F);
/* 35 */         GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
/* 36 */         MCH_RenderGLTD.model.renderAll();
/* 37 */         GL11.glDisable(32826);
/*    */         break;
/*    */       case null:
/* 40 */         GL11.glEnable(32826);
/* 41 */         GL11.glEnable(2903);
/* 42 */         GL11.glTranslatef(0.3F, 0.5F, -0.5F);
/* 43 */         GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 44 */         GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 45 */         GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
/* 46 */         GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
/* 47 */         MCH_RenderGLTD.model.renderAll();
/* 48 */         GL11.glDisable(32826);
/*    */         break;
/*    */     } 
/*    */ 
/*    */     
/* 53 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static class NamelessClass334173775
/*    */   {
/* 60 */     static final int[] $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType = new int[(IItemRenderer.ItemRenderType.values()).length];
/*    */ 
/*    */     
/*    */     static {
/*    */       try {
/* 65 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.ENTITY.ordinal()] = 1;
/* 66 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */ 
/*    */ 
/*    */       
/*    */       try {
/* 71 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.EQUIPPED.ordinal()] = 2;
/* 72 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */ 
/*    */ 
/*    */       
/*    */       try {
/* 77 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON.ordinal()] = 3;
/* 78 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */ 
/*    */ 
/*    */       
/*    */       try {
/* 83 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.INVENTORY.ordinal()] = 4;
/* 84 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */ 
/*    */ 
/*    */       
/*    */       try {
/* 89 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.FIRST_PERSON_MAP.ordinal()] = 5;
/* 90 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gltd\MCH_ItemGLTDRender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */