/*    */ package mcheli.tool;
/*    */ 
/*    */ import mcheli.MCH_ModelManager;
/*    */ import mcheli.wrapper.W_McClient;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.IItemRenderer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class MCH_ItemRenderWrench
/*    */   implements IItemRenderer {
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/* 13 */     return (type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
/*    */   }
/*    */   
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/* 17 */     return (type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
/*    */   }
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/*    */     int useFrame;
/* 21 */     GL11.glPushMatrix();
/* 22 */     W_McClient.MOD_bindTexture("textures/wrench.png");
/* 23 */     float size = 1.0F;
/* 24 */     switch (type) {
/*    */       case null:
/* 26 */         size = 2.2F;
/* 27 */         GL11.glScalef(size, size, size);
/* 28 */         GL11.glRotatef(-130.0F, 0.0F, 1.0F, 0.0F);
/* 29 */         GL11.glRotatef(-40.0F, 1.0F, 0.0F, 0.0F);
/* 30 */         GL11.glTranslatef(0.1F, 0.5F, -0.1F);
/*    */         break;
/*    */       case null:
/* 33 */         useFrame = MCH_ItemWrench.getUseAnimCount(item) - 8;
/* 34 */         if (useFrame < 0) {
/* 35 */           useFrame = -useFrame;
/*    */         }
/*    */         
/* 38 */         size = 2.2F;
/* 39 */         if (data.length >= 2 && data[1] instanceof EntityPlayer) {
/* 40 */           EntityPlayer player = (EntityPlayer)data[1];
/* 41 */           if (player.func_71052_bv() > 0) {
/* 42 */             float x = 0.8567F;
/* 43 */             float y = -0.0298F;
/* 44 */             float z = 0.0F;
/* 45 */             GL11.glTranslatef(-x, -y, -z);
/* 46 */             GL11.glRotatef((useFrame + 20), 1.0F, 0.0F, 0.0F);
/* 47 */             GL11.glTranslatef(x, y, z);
/*    */           } 
/*    */         } 
/*    */         
/* 51 */         GL11.glScalef(size, size, size);
/* 52 */         GL11.glRotatef(-200.0F, 0.0F, 1.0F, 0.0F);
/* 53 */         GL11.glRotatef(-60.0F, 1.0F, 0.0F, 0.0F);
/* 54 */         GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
/* 55 */         GL11.glTranslatef(-0.2F, 0.5F, -0.1F);
/*    */         break;
/*    */     } 
/* 58 */     MCH_ModelManager.render("wrench");
/* 59 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static class NamelessClass500917510
/*    */   {
/* 66 */     static final int[] $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType = new int[(IItemRenderer.ItemRenderType.values()).length];
/*    */ 
/*    */     
/*    */     static {
/*    */       try {
/* 71 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.EQUIPPED.ordinal()] = 1;
/* 72 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */ 
/*    */ 
/*    */       
/*    */       try {
/* 77 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON.ordinal()] = 2;
/* 78 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tool\MCH_ItemRenderWrench.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */