/*    */ package mcheli.uav;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ public class MCH_UavPacketHandler
/*    */ {
/*    */   public static void onPacketUavStatus(EntityPlayer player, ByteArrayDataInput data) {
/* 11 */     if (!player.field_70170_p.field_72995_K) {
/* 12 */       MCH_UavPacketStatus status = new MCH_UavPacketStatus();
/* 13 */       status.readData(data);
/* 14 */       if (player.field_70154_o instanceof MCH_EntityUavStation) {
/* 15 */         ((MCH_EntityUavStation)player.field_70154_o).setUavPosition(status.posUavX, status.posUavY, status.posUavZ);
/* 16 */         if (status.continueControl)
/* 17 */           ((MCH_EntityUavStation)player.field_70154_o).controlLastAircraft((Entity)player); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mchel\\uav\MCH_UavPacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */