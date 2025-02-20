/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.MCH_Explosion;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_WeaponBomb
/*    */   extends MCH_WeaponBase
/*    */ {
/*    */   public MCH_WeaponBomb(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/* 13 */     super(w, v, yaw, pitch, nm, wi);
/* 14 */     this.acceleration = 0.5F;
/* 15 */     this.explosionPower = 9;
/* 16 */     this.power = 35;
/* 17 */     this.interval = -90;
/* 18 */     if (w.field_72995_K) {
/* 19 */       this.interval -= 10;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shot(MCH_WeaponParam prm) {
/* 25 */     if (getInfo() != null && (getInfo()).destruct) {
/* 26 */       if (prm.entity instanceof mcheli.helicopter.MCH_EntityHeli) {
/* 27 */         MCH_EntityAircraft e1 = (MCH_EntityAircraft)prm.entity;
/* 28 */         if (e1.isUAV() && e1.getSeatNum() == 0) {
/* 29 */           if (!this.worldObj.field_72995_K) {
/* 30 */             MCH_Explosion.newExplosion(this.worldObj, (Entity)null, prm.user, e1.field_70165_t, e1.field_70163_u, e1.field_70161_v, (getInfo()).explosion, (getInfo()).explosionBlock, true, true, (getInfo()).flaming, true, 0);
/* 31 */             playSound(prm.entity);
/*    */           } 
/*    */           
/* 34 */           e1.destruct();
/*    */         } 
/*    */       } 
/* 37 */     } else if (!this.worldObj.field_72995_K) {
/* 38 */       playSound(prm.entity);
/* 39 */       MCH_EntityBomb e = new MCH_EntityBomb(this.worldObj, prm.posX, prm.posY, prm.posZ, prm.entity.field_70159_w, prm.entity.field_70181_x, prm.entity.field_70179_y, prm.entity.field_70177_z, 0.0F, this.acceleration);
/* 40 */       e.setName(this.name);
/* 41 */       e.setParameterFromWeapon(this, prm.entity, prm.user);
/* 42 */       e.field_70159_w = prm.entity.field_70159_w;
/* 43 */       e.field_70181_x = prm.entity.field_70181_x;
/* 44 */       e.field_70179_y = prm.entity.field_70179_y;
/* 45 */       this.worldObj.func_72838_d((Entity)e);
/*    */     } 
/*    */     
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponBomb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */