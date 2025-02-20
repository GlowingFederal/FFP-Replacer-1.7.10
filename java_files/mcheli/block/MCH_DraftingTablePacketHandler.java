/*    */ package mcheli.block;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import mcheli.MCH_Lib;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class MCH_DraftingTablePacketHandler
/*    */ {
/*    */   public static void onPacketCreate(EntityPlayer player, ByteArrayDataInput data) {
/* 10 */     if (!player.field_70170_p.field_72995_K) {
/* 11 */       MCH_DraftingTableCreatePacket packet = new MCH_DraftingTableCreatePacket();
/* 12 */       packet.readData(data);
/* 13 */       boolean openScreen = player.field_71070_bA instanceof MCH_DraftingTableGuiContainer;
/* 14 */       MCH_Lib.DbgLog(false, "MCH_DraftingTablePacketHandler.onPacketCreate : " + openScreen, new Object[0]);
/* 15 */       if (openScreen)
/* 16 */         ((MCH_DraftingTableGuiContainer)player.field_71070_bA).createRecipeItem(packet.outputItem, packet.map); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\block\MCH_DraftingTablePacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */