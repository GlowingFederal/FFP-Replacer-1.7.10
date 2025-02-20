/*    */ package mcheli;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import org.lwjgl.BufferUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MCH_MarkEntityPos
/*    */ {
/*    */   public FloatBuffer pos;
/*    */   public int type;
/*    */   public Entity entity;
/*    */   
/*    */   public MCH_MarkEntityPos(int type, Entity entity) {
/* 16 */     this.type = type;
/* 17 */     this.pos = BufferUtils.createFloatBuffer(3);
/* 18 */     this.entity = entity;
/*    */   }
/*    */   
/*    */   public MCH_MarkEntityPos(int type) {
/* 22 */     this(type, (Entity)null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_MarkEntityPos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */