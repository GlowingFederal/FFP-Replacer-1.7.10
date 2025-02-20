/*    */ package mcheli.gltd;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class MCH_GLTDPacketHandler
/*    */ {
/*    */   public static void onPacket_GLTDPlayerControl(EntityPlayer player, ByteArrayDataInput data) {
/* 10 */     if (player.field_70154_o instanceof MCH_EntityGLTD && 
/* 11 */       !player.field_70170_p.field_72995_K) {
/* 12 */       MCH_PacketGLTDPlayerControl pc = new MCH_PacketGLTDPlayerControl();
/* 13 */       pc.readData(data);
/* 14 */       MCH_EntityGLTD gltd = (MCH_EntityGLTD)player.field_70154_o;
/* 15 */       if (pc.unmount) {
/* 16 */         if (gltd.field_70153_n != null) {
/* 17 */           gltd.field_70153_n.func_70078_a((Entity)null);
/*    */         }
/*    */       } else {
/* 20 */         if (pc.switchCameraMode >= 0) {
/* 21 */           gltd.camera.setMode(0, pc.switchCameraMode);
/*    */         }
/*    */         
/* 24 */         if (pc.switchWeapon >= 0) {
/* 25 */           gltd.switchWeapon(pc.switchWeapon);
/*    */         }
/*    */         
/* 28 */         if (pc.useWeapon)
/* 29 */           gltd.useCurrentWeapon(pc.useWeaponOption1, pc.useWeaponOption2); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gltd\MCH_GLTDPacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */