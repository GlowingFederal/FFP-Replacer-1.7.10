/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import mcheli.MCH_Lib;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ 
/*    */ public class MCH_BoundingBox
/*    */ {
/*    */   public final AxisAlignedBB boundingBox;
/*    */   public final AxisAlignedBB backupBoundingBox;
/*    */   public final double offsetX;
/*    */   public final double offsetY;
/*    */   public final double offsetZ;
/*    */   public final float width;
/*    */   public final float height;
/*    */   public Vec3 rotatedOffset;
/*    */   public Vec3 nowPos;
/*    */   public Vec3 prevPos;
/*    */   public final float damegeFactor;
/*    */   
/*    */   public MCH_BoundingBox(double x, double y, double z, float w, float h, float df) {
/* 23 */     this.offsetX = x;
/* 24 */     this.offsetY = y;
/* 25 */     this.offsetZ = z;
/* 26 */     this.width = w;
/* 27 */     this.height = h;
/* 28 */     this.damegeFactor = df;
/* 29 */     this.boundingBox = AxisAlignedBB.func_72330_a(x - (w / 2.0F), y - (h / 2.0F), z - (w / 2.0F), x + (w / 2.0F), y + (h / 2.0F), z + (w / 2.0F));
/* 30 */     this.backupBoundingBox = AxisAlignedBB.func_72330_a(x - (w / 2.0F), y - (h / 2.0F), z - (w / 2.0F), x + (w / 2.0F), y + (h / 2.0F), z + (w / 2.0F));
/* 31 */     this.nowPos = Vec3.func_72443_a(x, y, z);
/* 32 */     this.prevPos = Vec3.func_72443_a(x, y, z);
/* 33 */     updatePosition(0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
/*    */   }
/*    */   
/*    */   public MCH_BoundingBox copy() {
/* 37 */     return new MCH_BoundingBox(this.offsetX, this.offsetY, this.offsetZ, this.width, this.height, this.damegeFactor);
/*    */   }
/*    */   
/*    */   public void updatePosition(double posX, double posY, double posZ, float yaw, float pitch, float roll) {
/* 41 */     Vec3 v = Vec3.func_72443_a(this.offsetX, this.offsetY, this.offsetZ);
/* 42 */     this.rotatedOffset = MCH_Lib.RotVec3(v, -yaw, -pitch, -roll);
/* 43 */     float w = this.width;
/* 44 */     float h = this.height;
/* 45 */     double x = posX + this.rotatedOffset.field_72450_a;
/* 46 */     double y = posY + this.rotatedOffset.field_72448_b;
/* 47 */     double z = posZ + this.rotatedOffset.field_72449_c;
/* 48 */     this.prevPos.field_72450_a = this.nowPos.field_72450_a;
/* 49 */     this.prevPos.field_72448_b = this.nowPos.field_72448_b;
/* 50 */     this.prevPos.field_72449_c = this.nowPos.field_72449_c;
/* 51 */     this.nowPos.field_72450_a = x;
/* 52 */     this.nowPos.field_72448_b = y;
/* 53 */     this.nowPos.field_72449_c = z;
/* 54 */     this.backupBoundingBox.func_72328_c(this.boundingBox);
/* 55 */     this.boundingBox.func_72324_b(x - (w / 2.0F), y - (h / 2.0F), z - (w / 2.0F), x + (w / 2.0F), y + (h / 2.0F), z + (w / 2.0F));
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_BoundingBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */