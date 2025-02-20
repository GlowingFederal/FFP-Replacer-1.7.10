/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_Vec3
/*    */ {
/*    */   public static void rotateAroundZ(float par1, Vec3 vOut) {
/* 15 */     float f1 = MathHelper.func_76134_b(par1);
/* 16 */     float f2 = MathHelper.func_76126_a(par1);
/* 17 */     double d0 = vOut.field_72450_a * f1 + vOut.field_72448_b * f2;
/* 18 */     double d1 = vOut.field_72448_b * f1 - vOut.field_72450_a * f2;
/* 19 */     double d2 = vOut.field_72449_c;
/* 20 */     vOut.field_72450_a = d0;
/* 21 */     vOut.field_72448_b = d1;
/* 22 */     vOut.field_72449_c = d2;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_Vec3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */