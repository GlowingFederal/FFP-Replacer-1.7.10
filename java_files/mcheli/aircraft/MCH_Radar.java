/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mcheli.MCH_Vector2;
/*    */ import mcheli.wrapper.W_WorldFunc;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MCH_Radar
/*    */ {
/*    */   private World worldObj;
/* 16 */   private ArrayList entityList = new ArrayList();
/* 17 */   private ArrayList enemyList = new ArrayList();
/*    */ 
/*    */   
/*    */   public ArrayList getEntityList() {
/* 21 */     return this.entityList;
/*    */   }
/*    */   
/*    */   public ArrayList getEnemyList() {
/* 25 */     return this.enemyList;
/*    */   }
/*    */   
/*    */   public MCH_Radar(World world) {
/* 29 */     this.worldObj = world;
/*    */   }
/*    */   
/*    */   public void clear() {
/* 33 */     this.entityList.clear();
/* 34 */     this.enemyList.clear();
/*    */   }
/*    */   
/*    */   public void updateXZ(Entity centerEntity, int range) {
/* 38 */     if (this.worldObj.field_72995_K) {
/* 39 */       clear();
/* 40 */       List<Entity> list = centerEntity.field_70170_p.func_72839_b(centerEntity, centerEntity.field_70121_D.func_72314_b(range, range, range));
/*    */       
/* 42 */       for (int i = 0; i < list.size(); i++) {
/* 43 */         Entity entity = list.get(i);
/* 44 */         if (entity instanceof mcheli.wrapper.W_Entity) {
/* 45 */           double x = entity.field_70165_t - centerEntity.field_70165_t;
/* 46 */           double z = entity.field_70161_v - centerEntity.field_70161_v;
/* 47 */           if (x * x + z * z < (range * range)) {
/* 48 */             int y = 1 + (int)entity.field_70163_u;
/* 49 */             if (y < 0) {
/* 50 */               y = 1;
/*    */             }
/*    */ 
/*    */             
/* 54 */             int blockCnt = 0;
/*    */             
/* 56 */             blockCnt++;
/* 57 */             for (; y < 200 && (W_WorldFunc.getBlockId(this.worldObj, (int)entity.field_70165_t, y, (int)entity.field_70161_v) == 0 || blockCnt < 5); y++);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 63 */             if (blockCnt < 5 && (
/* 64 */               entity instanceof MCH_EntityAircraft || entity instanceof mcheli.flare.MCH_EntityFlare))
/* 65 */               this.entityList.add(new MCH_Vector2(x, z)); 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_Radar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */