/*    */ package mcheli.tool.rangefinder;
/*    */ 
/*    */ import mcheli.MCH_ModelManager;
/*    */ import mcheli.wrapper.W_McClient;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.IItemRenderer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class MCH_ItemRenderRangeFinder implements IItemRenderer {
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/* 13 */     return (type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON || type == IItemRenderer.ItemRenderType.ENTITY);
/*    */   }
/*    */   
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/* 17 */     return (type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON || type == IItemRenderer.ItemRenderType.ENTITY);
/*    */   }
/*    */   
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/* 21 */     GL11.glPushMatrix();
/* 22 */     W_McClient.MOD_bindTexture("textures/rangefinder.png");
/* 23 */     float size = 1.0F;
/* 24 */     switch (type) {
/*    */       case null:
/* 26 */         size = 2.2F;
/* 27 */         GL11.glScalef(size, size, size);
/* 28 */         GL11.glRotatef(-130.0F, 0.0F, 1.0F, 0.0F);
/* 29 */         GL11.glRotatef(70.0F, 1.0F, 0.0F, 0.0F);
/* 30 */         GL11.glRotatef(5.0F, 0.0F, 0.0F, 1.0F);
/* 31 */         GL11.glTranslatef(0.0F, 0.0F, -0.0F);
/* 32 */         MCH_ModelManager.render("rangefinder");
/*    */         break;
/*    */       case null:
/* 35 */         size = 2.2F;
/* 36 */         GL11.glScalef(size, size, size);
/* 37 */         GL11.glRotatef(-130.0F, 0.0F, 1.0F, 0.0F);
/* 38 */         GL11.glRotatef(70.0F, 1.0F, 0.0F, 0.0F);
/* 39 */         GL11.glRotatef(5.0F, 0.0F, 0.0F, 1.0F);
/* 40 */         if ((Minecraft.func_71410_x()).field_71439_g.func_71057_bx() > 0) {
/* 41 */           GL11.glTranslatef(0.4F, -0.35F, -0.3F);
/*    */         } else {
/* 43 */           GL11.glTranslatef(0.2F, -0.35F, -0.3F);
/*    */         } 
/*    */         
/* 46 */         MCH_ModelManager.render("rangefinder");
/*    */         break;
/*    */       case null:
/* 49 */         if (!MCH_ItemRangeFinder.isUsingScope((EntityPlayer)(Minecraft.func_71410_x()).field_71439_g)) {
/* 50 */           size = 2.2F;
/* 51 */           GL11.glScalef(size, size, size);
/* 52 */           GL11.glRotatef(-210.0F, 0.0F, 1.0F, 0.0F);
/* 53 */           GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
/* 54 */           GL11.glRotatef(-10.0F, 0.0F, 0.0F, 1.0F);
/* 55 */           GL11.glTranslatef(0.06F, 0.53F, -0.1F);
/* 56 */           MCH_ModelManager.render("rangefinder");
/*    */         } 
/*    */         break;
/*    */     } 
/* 60 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static class NamelessClass956777817
/*    */   {
/* 67 */     static final int[] $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType = new int[(IItemRenderer.ItemRenderType.values()).length];
/*    */ 
/*    */     
/*    */     static {
/*    */       try {
/* 72 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.ENTITY.ordinal()] = 1;
/* 73 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */ 
/*    */ 
/*    */       
/*    */       try {
/* 78 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.EQUIPPED.ordinal()] = 2;
/* 79 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */ 
/*    */ 
/*    */       
/*    */       try {
/* 84 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON.ordinal()] = 3;
/* 85 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tool\rangefinder\MCH_ItemRenderRangeFinder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */