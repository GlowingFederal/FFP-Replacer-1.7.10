/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import mcheli.MCH_MOD;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_Lib
/*    */ {
/*    */   public static boolean isEntityLivingBase(Entity entity) {
/* 19 */     return entity instanceof EntityLivingBase;
/*    */   }
/*    */   
/*    */   public static EntityLivingBase castEntityLivingBase(Object entity) {
/* 23 */     return (EntityLivingBase)entity;
/*    */   }
/*    */   
/*    */   public static Class getEntityLivingBaseClass() {
/* 27 */     return EntityLivingBase.class;
/*    */   }
/*    */   
/*    */   public static double getEntityMoveDist(Entity entity) {
/* 31 */     if (entity == null) {
/* 32 */       return 0.0D;
/*    */     }
/* 34 */     return (entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).field_70701_bs : 0.0D;
/*    */   }
/*    */   
/*    */   public static boolean isClientPlayer(Entity entity) {
/* 38 */     if (entity instanceof net.minecraft.entity.player.EntityPlayer && entity.field_70170_p.field_72995_K) {
/* 39 */       return W_Entity.isEqual(MCH_MOD.proxy.getClientPlayer(), entity);
/*    */     }
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public static boolean isFirstPerson() {
/* 45 */     return MCH_MOD.proxy.isFirstPerson();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_Lib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */