/*    */ package mcheli.command;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import mcheli.MCH_MOD;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class MCH_CommandPacketHandler {
/*    */   public static void onPacketTitle(EntityPlayer player, ByteArrayDataInput data) {
/* 11 */     if (player != null && player.field_70170_p.field_72995_K) {
/* 12 */       MCH_PacketTitle req = new MCH_PacketTitle();
/* 13 */       req.readData(data);
/* 14 */       MCH_MOD.proxy.printChatMessage(req.chatComponent, req.showTime, req.position);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void onPacketSave(EntityPlayer player, ByteArrayDataInput data) {
/* 19 */     if (player != null && !player.field_70170_p.field_72995_K) {
/* 20 */       MCH_PacketCommandSave req = new MCH_PacketCommandSave();
/* 21 */       req.readData(data);
/* 22 */       MCH_EntityAircraft ac = MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)player);
/* 23 */       if (ac != null)
/* 24 */         ac.setCommand(req.str, player); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\command\MCH_CommandPacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */