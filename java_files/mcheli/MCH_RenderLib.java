/*    */ package mcheli;
/*    */ 
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.util.Vec3;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class MCH_RenderLib
/*    */ {
/*    */   public static void drawLine(Vec3[] points, int color) {
/* 10 */     drawLine(points, color, 1, 1);
/*    */   }
/*    */   
/*    */   public static void drawLine(Vec3[] points, int color, int mode, int width) {
/* 14 */     int prevWidth = GL11.glGetInteger(2849);
/* 15 */     GL11.glDisable(3553);
/* 16 */     GL11.glEnable(3042);
/* 17 */     GL11.glBlendFunc(770, 771);
/* 18 */     GL11.glColor4ub((byte)(color >> 16 & 0xFF), (byte)(color >> 8 & 0xFF), (byte)(color >> 0 & 0xFF), (byte)(color >> 24 & 0xFF));
/* 19 */     GL11.glLineWidth(width);
/* 20 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 21 */     tessellator.func_78371_b(mode);
/* 22 */     Vec3[] arr$ = points;
/* 23 */     int len$ = points.length;
/*    */     
/* 25 */     for (int i$ = 0; i$ < len$; i$++) {
/* 26 */       Vec3 v = arr$[i$];
/* 27 */       tessellator.func_78377_a(v.field_72450_a, v.field_72448_b, v.field_72449_c);
/*    */     } 
/*    */     
/* 30 */     tessellator.func_78381_a();
/* 31 */     GL11.glEnable(3553);
/* 32 */     GL11.glDisable(3042);
/* 33 */     GL11.glColor4b((byte)-1, (byte)-1, (byte)-1, (byte)-1);
/* 34 */     GL11.glLineWidth(prevWidth);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_RenderLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */