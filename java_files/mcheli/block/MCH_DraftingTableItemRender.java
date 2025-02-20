/*    */ package mcheli.block;
/*    */ 
/*    */ import mcheli.MCH_ModelManager;
/*    */ import mcheli.wrapper.W_McClient;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.IItemRenderer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class MCH_DraftingTableItemRender
/*    */   implements IItemRenderer {
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/* 12 */     switch (type) {
/*    */       case null:
/*    */       case null:
/*    */       case null:
/*    */       case null:
/* 17 */         return true;
/*    */     } 
/* 19 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/* 24 */     return true;
/*    */   }
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/*    */     float INV_SIZE;
/* 28 */     GL11.glPushMatrix();
/* 29 */     W_McClient.MOD_bindTexture("textures/blocks/drafting_table.png");
/* 30 */     GL11.glEnable(32826);
/* 31 */     switch (type) {
/*    */       case null:
/* 33 */         GL11.glTranslatef(0.0F, 0.5F, 0.0F);
/* 34 */         GL11.glScalef(1.5F, 1.5F, 1.5F);
/*    */         break;
/*    */       case null:
/* 37 */         GL11.glTranslatef(0.0F, 0.0F, 0.5F);
/* 38 */         GL11.glScalef(1.0F, 1.0F, 1.0F);
/*    */         break;
/*    */       case null:
/* 41 */         GL11.glTranslatef(0.75F, 0.0F, 0.0F);
/* 42 */         GL11.glScalef(1.0F, 1.0F, 1.0F);
/* 43 */         GL11.glRotatef(90.0F, 0.0F, -1.0F, 0.0F);
/*    */         break;
/*    */       case null:
/* 46 */         INV_SIZE = 0.75F;
/* 47 */         GL11.glTranslatef(0.0F, -0.5F, 0.0F);
/* 48 */         GL11.glScalef(0.75F, 0.75F, 0.75F);
/*    */         break;
/*    */     } 
/* 51 */     MCH_ModelManager.render("blocks", "drafting_table");
/* 52 */     GL11.glPopMatrix();
/* 53 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 54 */     GL11.glEnable(3042);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static class NamelessClass1811513524
/*    */   {
/* 61 */     static final int[] $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType = new int[(IItemRenderer.ItemRenderType.values()).length];
/*    */ 
/*    */     
/*    */     static {
/*    */       try {
/* 66 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.ENTITY.ordinal()] = 1;
/* 67 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */ 
/*    */ 
/*    */       
/*    */       try {
/* 72 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.EQUIPPED.ordinal()] = 2;
/* 73 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */ 
/*    */ 
/*    */       
/*    */       try {
/* 78 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON.ordinal()] = 3;
/* 79 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */ 
/*    */ 
/*    */       
/*    */       try {
/* 84 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.INVENTORY.ordinal()] = 4;
/* 85 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\block\MCH_DraftingTableItemRender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */