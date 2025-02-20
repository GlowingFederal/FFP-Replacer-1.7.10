/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.client.IItemRenderer;
/*    */ import net.minecraftforge.client.MinecraftForgeClient;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_MinecraftForgeClient
/*    */ {
/*    */   public static void registerItemRenderer(Item item, IItemRenderer renderer) {
/* 17 */     if (item != null)
/* 18 */       MinecraftForgeClient.registerItemRenderer(item, renderer); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_MinecraftForgeClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */