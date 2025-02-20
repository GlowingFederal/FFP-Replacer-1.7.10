/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_EntityPlayerSP
/*    */ {
/*    */   public static void closeScreen(Entity p) {
/* 15 */     if (p instanceof EntityPlayerSP)
/* 16 */       ((EntityPlayerSP)p).func_71053_j(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_EntityPlayerSP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */