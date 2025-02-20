/*    */ package mcheli.weapon;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class MCH_WeaponParam
/*    */ {
/*  7 */   public Entity entity = null;
/*  8 */   public Entity user = null;
/*  9 */   public double posX = 0.0D;
/* 10 */   public double posY = 0.0D;
/* 11 */   public double posZ = 0.0D;
/* 12 */   public float rotYaw = 0.0F;
/* 13 */   public float rotPitch = 0.0F;
/* 14 */   public float rotRoll = 0.0F;
/* 15 */   public int option1 = 0;
/* 16 */   public int option2 = 0;
/*    */   
/*    */   public boolean isInfinity = false;
/*    */   public boolean isTurret = false;
/*    */   public boolean result;
/*    */   public boolean reload;
/*    */   
/*    */   public void setPosAndRot(double x, double y, double z, float yaw, float pitch) {
/* 24 */     setPosition(x, y, z);
/* 25 */     setRotation(yaw, pitch);
/*    */   }
/*    */   
/*    */   public void setPosition(double x, double y, double z) {
/* 29 */     this.posX = x;
/* 30 */     this.posY = y;
/* 31 */     this.posZ = z;
/*    */   }
/*    */   
/*    */   public void setRotation(float y, float p) {
/* 35 */     this.rotYaw = y;
/* 36 */     this.rotPitch = p;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */