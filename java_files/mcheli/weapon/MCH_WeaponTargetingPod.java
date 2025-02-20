/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.multiplay.MCH_Multiplay;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_WeaponTargetingPod
/*    */   extends MCH_WeaponBase {
/*    */   public MCH_WeaponTargetingPod(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/* 12 */     super(w, v, yaw, pitch, nm, wi);
/* 13 */     this.interval = -90;
/* 14 */     if (w.field_72995_K) {
/* 15 */       this.interval -= 10;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shot(MCH_WeaponParam prm) {
/* 21 */     if (!this.worldObj.field_72995_K) {
/* 22 */       MCH_WeaponInfo info = getInfo();
/* 23 */       if ((info.target & 0x40) != 0) {
/* 24 */         if (MCH_Multiplay.markPoint((EntityPlayer)prm.user, prm.posX, prm.posY, prm.posZ)) {
/* 25 */           playSound(prm.user);
/*    */         } else {
/* 27 */           playSound(prm.user, "ng");
/*    */         } 
/* 29 */       } else if (MCH_Multiplay.spotEntity((EntityPlayer)prm.user, (MCH_EntityAircraft)prm.entity, prm.posX, prm.posY, prm.posZ, info.target, info.length, info.markTime, info.angle)) {
/* 30 */         playSound(prm.entity);
/*    */       } else {
/* 32 */         playSound(prm.entity, "ng");
/*    */       } 
/*    */     } 
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponTargetingPod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */