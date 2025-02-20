/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.TickEvent;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class W_TickHandler
/*    */   implements ITickHandler
/*    */ {
/*    */   protected Minecraft mc;
/*    */   
/*    */   public W_TickHandler(Minecraft m) {
/* 26 */     this.mc = m;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onPlayerTickPre(EntityPlayer player) {}
/*    */ 
/*    */   
/*    */   public void onPlayerTickPost(EntityPlayer player) {}
/*    */ 
/*    */   
/*    */   public void onRenderTickPre(float partialTicks) {}
/*    */ 
/*    */   
/*    */   public void onRenderTickPost(float partialTicks) {}
/*    */ 
/*    */   
/*    */   public void onTickPre() {}
/*    */ 
/*    */   
/*    */   public void onTickPost() {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onPlayerTickEvent(TickEvent.PlayerTickEvent event) {
/* 49 */     if (event.phase == TickEvent.Phase.START) {
/* 50 */       onPlayerTickPre(event.player);
/*    */     }
/* 52 */     if (event.phase == TickEvent.Phase.END) {
/* 53 */       onPlayerTickPost(event.player);
/*    */     }
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onClientTickEvent(TickEvent.ClientTickEvent event) {
/* 59 */     if (event.phase == TickEvent.Phase.START) {
/* 60 */       onTickPre();
/*    */     }
/* 62 */     if (event.phase == TickEvent.Phase.END) {
/* 63 */       onTickPost();
/*    */     }
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onRenderTickEvent(TickEvent.RenderTickEvent event) {
/* 69 */     if (event.phase == TickEvent.Phase.START) {
/* 70 */       onRenderTickPre(event.renderTickTime);
/*    */     }
/* 72 */     if (event.phase == TickEvent.Phase.END)
/* 73 */       onRenderTickPost(event.renderTickTime); 
/*    */   }
/*    */   
/*    */   enum TickType
/*    */   {
/* 78 */     RENDER,
/* 79 */     CLIENT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_TickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */