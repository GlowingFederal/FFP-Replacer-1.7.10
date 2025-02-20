/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.aircraft.MCH_PacketNotifyTVMissileEntity;
/*    */ import mcheli.wrapper.W_Entity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_WeaponTvMissile
/*    */   extends MCH_WeaponBase {
/* 13 */   protected MCH_EntityTvMissile lastShotTvMissile = null;
/* 14 */   protected Entity lastShotEntity = null;
/*    */   
/*    */   protected boolean isTVGuided = false;
/*    */   
/*    */   public MCH_WeaponTvMissile(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/* 19 */     super(w, v, yaw, pitch, nm, wi);
/* 20 */     this.power = 32;
/* 21 */     this.acceleration = 2.0F;
/* 22 */     this.explosionPower = 4;
/* 23 */     this.interval = -100;
/* 24 */     if (w.field_72995_K) {
/* 25 */       this.interval -= 10;
/*    */     }
/*    */     
/* 28 */     this.numMode = 2;
/* 29 */     this.lastShotEntity = null;
/* 30 */     this.lastShotTvMissile = null;
/* 31 */     this.isTVGuided = false;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 35 */     String opt = "";
/* 36 */     if (getCurrentMode() == 0) {
/* 37 */       opt = " [TV]";
/*    */     }
/*    */     
/* 40 */     if (getCurrentMode() == 2) {
/* 41 */       opt = " [TA]";
/*    */     }
/*    */     
/* 44 */     return super.getName() + opt;
/*    */   }
/*    */   
/*    */   public void update(int countWait) {
/* 48 */     super.update(countWait);
/* 49 */     if (!this.worldObj.field_72995_K) {
/* 50 */       if (this.isTVGuided && this.tick <= 9) {
/* 51 */         if (this.tick % 3 == 0 && this.lastShotTvMissile != null && !this.lastShotTvMissile.field_70128_L && this.lastShotEntity != null && !this.lastShotEntity.field_70128_L) {
/* 52 */           MCH_PacketNotifyTVMissileEntity.send(W_Entity.getEntityId(this.lastShotEntity), W_Entity.getEntityId((Entity)this.lastShotTvMissile));
/*    */         }
/*    */         
/* 55 */         if (this.tick == 9) {
/* 56 */           this.lastShotEntity = null;
/* 57 */           this.lastShotTvMissile = null;
/*    */         } 
/*    */       } 
/*    */       
/* 61 */       if (this.tick <= 2 && this.lastShotEntity instanceof MCH_EntityAircraft) {
/* 62 */         ((MCH_EntityAircraft)this.lastShotEntity).setTVMissile(this.lastShotTvMissile);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shot(MCH_WeaponParam prm) {
/* 69 */     return this.worldObj.field_72995_K ? shotClient(prm.entity, prm.user) : shotServer(prm);
/*    */   }
/*    */   
/*    */   protected boolean shotClient(Entity entity, Entity user) {
/* 73 */     this.optionParameter2 = 0;
/* 74 */     this.optionParameter1 = getCurrentMode();
/* 75 */     return true;
/*    */   }
/*    */   
/*    */   protected boolean shotServer(MCH_WeaponParam prm) {
/* 79 */     float yaw = prm.user.field_70177_z + this.fixRotationYaw;
/* 80 */     float pitch = prm.user.field_70125_A + this.fixRotationPitch;
/* 81 */     double tX = (-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 82 */     double tZ = (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 83 */     double tY = -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F);
/* 84 */     this.isTVGuided = (prm.option1 == 0);
/* 85 */     float acr = this.acceleration;
/* 86 */     if (!this.isTVGuided) {
/* 87 */       acr = (float)(acr * 1.5D);
/*    */     }
/*    */     
/* 90 */     MCH_EntityTvMissile e = new MCH_EntityTvMissile(this.worldObj, prm.posX, prm.posY, prm.posZ, tX, tY, tZ, yaw, pitch, acr);
/* 91 */     e.setName(this.name);
/* 92 */     e.setParameterFromWeapon(this, prm.entity, prm.user);
/* 93 */     this.lastShotEntity = prm.entity;
/* 94 */     this.lastShotTvMissile = e;
/* 95 */     this.worldObj.func_72838_d((Entity)e);
/* 96 */     playSound(prm.entity);
/* 97 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponTvMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */