/*    */ package mcheli.tool;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import mcheli.MCH_Config;
/*    */ import mcheli.MCH_MOD;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.multiplay.MCH_Multiplay;
/*    */ import mcheli.multiplay.MCH_PacketIndSpotEntity;
/*    */ import mcheli.wrapper.W_WorldFunc;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class MCH_ToolPacketHandler {
/*    */   public static void onPacket_IndSpotEntity(EntityPlayer player, ByteArrayDataInput data) {
/* 17 */     if (!player.field_70170_p.field_72995_K) {
/* 18 */       MCH_PacketIndSpotEntity pc = new MCH_PacketIndSpotEntity();
/* 19 */       pc.readData(data);
/* 20 */       ItemStack itemStack = player.func_70694_bm();
/* 21 */       if (itemStack != null && itemStack.func_77973_b() instanceof mcheli.tool.rangefinder.MCH_ItemRangeFinder)
/* 22 */         if (pc.targetFilter == 0) {
/* 23 */           if (MCH_Multiplay.markPoint(player, player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v)) {
/* 24 */             W_WorldFunc.MOD_playSoundAtEntity((Entity)player, "pi", 1.0F, 1.0F);
/*    */           } else {
/* 26 */             W_WorldFunc.MOD_playSoundAtEntity((Entity)player, "ng", 1.0F, 1.0F);
/*    */           } 
/* 28 */         } else if (itemStack.func_77960_j() < itemStack.func_77958_k()) {
/* 29 */           int var5; MCH_Config var10000 = MCH_MOD.config;
/* 30 */           if (MCH_Config.RangeFinderConsume.prmBool) {
/* 31 */             itemStack.func_77972_a(1, (EntityLivingBase)player);
/*    */           }
/*    */ 
/*    */           
/* 35 */           if ((pc.targetFilter & 0xFC) == 0) {
/* 36 */             var5 = 60;
/*    */           } else {
/* 38 */             var10000 = MCH_MOD.config;
/* 39 */             var5 = MCH_Config.RangeFinderSpotTime.prmInt;
/*    */           } 
/*    */           
/* 42 */           int time = var5;
/* 43 */           double var10002 = player.field_70165_t;
/* 44 */           double var10003 = player.field_70163_u + player.func_70047_e();
/* 45 */           MCH_Config var10006 = MCH_MOD.config;
/* 46 */           if (MCH_Multiplay.spotEntity(player, (MCH_EntityAircraft)null, var10002, var10003, player.field_70161_v, pc.targetFilter, MCH_Config.RangeFinderSpotDist.prmInt, time, 20.0F)) {
/* 47 */             W_WorldFunc.MOD_playSoundAtEntity((Entity)player, "pi", 1.0F, 1.0F);
/*    */           } else {
/* 49 */             W_WorldFunc.MOD_playSoundAtEntity((Entity)player, "ng", 1.0F, 1.0F);
/*    */           } 
/*    */         }  
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tool\MCH_ToolPacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */