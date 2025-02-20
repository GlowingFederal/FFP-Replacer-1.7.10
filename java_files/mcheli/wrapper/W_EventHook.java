/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraftforge.event.CommandEvent;
/*    */ import net.minecraftforge.event.entity.EntityEvent;
/*    */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*    */ import net.minecraftforge.event.entity.living.LivingAttackEvent;
/*    */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*    */ import net.minecraftforge.event.entity.player.EntityInteractEvent;
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
/*    */ 
/*    */ 
/*    */ public class W_EventHook
/*    */ {
/*    */   @SubscribeEvent
/*    */   public void onEntityEnterInChunk(EntityEvent.EnteringChunk event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_entitySpawn(EntityJoinWorldEvent event) {
/* 38 */     entitySpawn(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void entitySpawn(EntityJoinWorldEvent event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_livingHurtEvent(LivingHurtEvent event) {
/* 46 */     livingHurtEvent(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void livingHurtEvent(LivingHurtEvent event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_livingAttackEvent(LivingAttackEvent event) {
/* 54 */     livingAttackEvent(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void livingAttackEvent(LivingAttackEvent event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_entityInteractEvent(EntityInteractEvent event) {
/* 62 */     entityInteractEvent(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void entityInteractEvent(EntityInteractEvent event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_entityCanUpdate(EntityEvent.CanUpdate event) {
/* 70 */     entityCanUpdate(event);
/*    */   }
/*    */ 
/*    */   
/*    */   public void entityCanUpdate(EntityEvent.CanUpdate event) {}
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEvent_commandEvent(CommandEvent event) {
/* 78 */     commandEvent(event);
/*    */   }
/*    */   
/*    */   public void commandEvent(CommandEvent event) {}
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_EventHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */