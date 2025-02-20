/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.client.event.MouseEvent;
/*    */ import net.minecraftforge.client.event.RenderLivingEvent;
/*    */ import net.minecraftforge.client.event.RenderPlayerEvent;
/*    */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*    */ import net.minecraftforge.event.world.WorldEvent;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_ClientEventHook
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onEvent_MouseEvent(MouseEvent event) {
/* 32 */     mouseEvent(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void mouseEvent(MouseEvent event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_renderLivingEventSpecialsPre(RenderLivingEvent.Specials.Pre event) {
/* 40 */     renderLivingEventSpecialsPre(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderLivingEventSpecialsPre(RenderLivingEvent.Specials.Pre event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_renderLivingEventSpecialsPost(RenderLivingEvent.Specials.Post event) {
/* 48 */     renderLivingEventSpecialsPost(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderLivingEventSpecialsPost(RenderLivingEvent.Specials.Post event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_renderLivingEventPre(RenderLivingEvent.Pre event) {
/* 56 */     renderLivingEventPre(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderLivingEventPre(RenderLivingEvent.Pre event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_renderLivingEventPost(RenderLivingEvent.Post event) {
/* 64 */     renderLivingEventPost(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderLivingEventPost(RenderLivingEvent.Post event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_renderPlayerPre(RenderPlayerEvent.Pre event) {
/* 72 */     renderPlayerPre(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderPlayerPre(RenderPlayerEvent.Pre event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void Event_renderPlayerPost(RenderPlayerEvent.Post event) {
/* 80 */     renderPlayerPost(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderPlayerPost(RenderPlayerEvent.Post event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_WorldEventUnload(WorldEvent.Unload event) {
/* 88 */     worldEventUnload(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void worldEventUnload(WorldEvent.Unload event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_EntityJoinWorldEvent(EntityJoinWorldEvent event) {
/* 96 */     entityJoinWorldEvent(event);
/*    */   }
/*    */   
/*    */   public void entityJoinWorldEvent(EntityJoinWorldEvent event) {}
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_ClientEventHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */