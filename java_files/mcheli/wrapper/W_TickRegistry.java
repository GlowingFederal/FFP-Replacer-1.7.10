/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_TickRegistry
/*    */ {
/*    */   public static void registerTickHandler(W_TickHandler handler, Side side) {
/* 16 */     FMLCommonHandler.instance().bus().register(handler);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_TickRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */