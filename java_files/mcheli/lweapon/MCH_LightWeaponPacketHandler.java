/*    */ package mcheli.lweapon;
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.weapon.MCH_IEntityLockChecker;
/*    */ import mcheli.weapon.MCH_WeaponBase;
/*    */ import mcheli.weapon.MCH_WeaponCreator;
/*    */ import mcheli.weapon.MCH_WeaponParam;
/*    */ import mcheli.wrapper.W_EntityPlayer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class MCH_LightWeaponPacketHandler {
/*    */   public static void onPacket_PlayerControl(EntityPlayer player, ByteArrayDataInput data) {
/* 19 */     if (!player.field_70170_p.field_72995_K) {
/* 20 */       MCH_PacketLightWeaponPlayerControl pc = new MCH_PacketLightWeaponPlayerControl();
/* 21 */       pc.readData(data);
/* 22 */       if (pc.camMode == 1) {
/* 23 */         player.func_82170_o(Potion.field_76439_r.func_76396_c());
/*    */       }
/*    */       
/* 26 */       ItemStack is = player.func_70694_bm();
/* 27 */       if (is != null && 
/* 28 */         is.func_77973_b() instanceof MCH_ItemLightWeaponBase) {
/* 29 */         MCH_ItemLightWeaponBase lweapon = (MCH_ItemLightWeaponBase)is.func_77973_b();
/* 30 */         if (pc.camMode == 2 && MCH_ItemLightWeaponBase.isHeld(player)) {
/* 31 */           player.func_70690_d(new PotionEffect(Potion.field_76439_r.func_76396_c(), 255, 0, false));
/*    */         }
/*    */         
/* 34 */         if (pc.camMode > 0) {
/* 35 */           MCH_Lib.DbgLog(false, "MCH_LightWeaponPacketHandler NV=%s", new Object[] { (pc.camMode == 2) ? "ON" : "OFF" });
/*    */         }
/*    */         
/* 38 */         if (pc.useWeapon && is.func_77960_j() < is.func_77958_k()) {
/* 39 */           String name = MCH_ItemLightWeaponBase.getName(player.func_70694_bm());
/* 40 */           MCH_WeaponBase w = MCH_WeaponCreator.createWeapon(player.field_70170_p, name, Vec3.func_72443_a(0.0D, 0.0D, 0.0D), 0.0F, 0.0F, (MCH_IEntityLockChecker)null, false);
/* 41 */           MCH_WeaponParam prm = new MCH_WeaponParam();
/* 42 */           prm.entity = (Entity)player;
/* 43 */           prm.user = (Entity)player;
/* 44 */           prm.setPosAndRot(pc.useWeaponPosX, pc.useWeaponPosY, pc.useWeaponPosZ, player.field_70177_z, player.field_70125_A);
/* 45 */           prm.option1 = pc.useWeaponOption1;
/* 46 */           prm.option2 = pc.useWeaponOption2;
/* 47 */           w.shot(prm);
/* 48 */           if (!player.field_71075_bZ.field_75098_d && is.func_77958_k() == 1) {
/* 49 */             is.field_77994_a--;
/*    */           }
/*    */           
/* 52 */           if (is.func_77958_k() > 1) {
/* 53 */             is.func_77964_b(is.func_77958_k());
/*    */           }
/* 55 */         } else if (pc.cmpReload > 0 && is.func_77960_j() > 1 && W_EntityPlayer.hasItem(player, (Item)lweapon.bullet)) {
/* 56 */           if (!player.field_71075_bZ.field_75098_d) {
/* 57 */             W_EntityPlayer.consumeInventoryItem(player, (Item)lweapon.bullet);
/*    */           }
/*    */           
/* 60 */           is.func_77964_b(0);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\lweapon\MCH_LightWeaponPacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */