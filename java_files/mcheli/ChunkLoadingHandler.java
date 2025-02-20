/*    */ package mcheli;
/*    */ 
/*    */ import java.util.List;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.weapon.MCH_EntityBaseBullet;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.ForgeChunkManager;
/*    */ 
/*    */ 
/*    */ public class ChunkLoadingHandler
/*    */   implements ForgeChunkManager.LoadingCallback
/*    */ {
/*    */   public void ticketsLoaded(List<ForgeChunkManager.Ticket> tickets, World world) {
/* 15 */     for (ForgeChunkManager.Ticket ticket : tickets) {
/* 16 */       int id = ticket.getModData().func_74762_e("ID");
/* 17 */       Entity entity = world.func_73045_a(id);
/* 18 */       if (entity instanceof MCH_EntityBaseBullet) {
/* 19 */         ((MCH_EntityBaseBullet)entity).forceChunkLoading(ticket);
/*    */         continue;
/*    */       } 
/* 22 */       if (entity instanceof MCH_EntityAircraft)
/* 23 */         ((MCH_EntityAircraft)entity).forceChunkLoading(ticket); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\ChunkLoadingHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */