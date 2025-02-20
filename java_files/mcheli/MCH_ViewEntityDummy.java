/*    */ package mcheli;
/*    */ 
/*    */ import mcheli.wrapper.W_Session;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_ViewEntityDummy extends EntityPlayerSP {
/* 10 */   private static MCH_ViewEntityDummy instance = null;
/*    */   
/*    */   private float zoom;
/*    */   
/*    */   private MCH_ViewEntityDummy(World world) {
/* 15 */     super(Minecraft.func_71410_x(), world, W_Session.newSession(), 0);
/* 16 */     this.field_70737_aN = 0;
/* 17 */     this.field_70738_aO = 1;
/* 18 */     func_70105_a(1.0F, 1.0F);
/*    */   }
/*    */   
/*    */   public static MCH_ViewEntityDummy getInstance(World w) {
/* 22 */     if ((instance == null || instance.field_70128_L) && w.field_72995_K) {
/* 23 */       instance = new MCH_ViewEntityDummy(w);
/* 24 */       if ((Minecraft.func_71410_x()).field_71439_g != null) {
/* 25 */         instance.field_71158_b = (Minecraft.func_71410_x()).field_71439_g.field_71158_b;
/*    */       }
/*    */       
/* 28 */       instance.func_70107_b(0.0D, -4.0D, 0.0D);
/* 29 */       w.func_72838_d((Entity)instance);
/*    */     } 
/*    */     
/* 32 */     return instance;
/*    */   }
/*    */   
/*    */   public static void onUnloadWorld() {
/* 36 */     if (instance != null) {
/* 37 */       instance.func_70106_y();
/* 38 */       instance = null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {}
/*    */   
/*    */   public void update(MCH_Camera camera) {
/* 46 */     if (camera != null) {
/* 47 */       this.zoom = camera.getCameraZoom();
/* 48 */       this.field_70126_B = this.field_70177_z;
/* 49 */       this.field_70127_C = this.field_70125_A;
/* 50 */       this.field_70177_z = camera.rotationYaw;
/* 51 */       this.field_70125_A = camera.rotationPitch;
/* 52 */       this.field_70169_q = camera.posX;
/* 53 */       this.field_70167_r = camera.posY;
/* 54 */       this.field_70166_s = camera.posZ;
/* 55 */       this.field_70165_t = camera.posX;
/* 56 */       this.field_70163_u = camera.posY;
/* 57 */       this.field_70161_v = camera.posZ;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void setCameraPosition(double x, double y, double z) {
/* 62 */     if (instance != null) {
/* 63 */       instance.field_70169_q = x;
/* 64 */       instance.field_70167_r = y;
/* 65 */       instance.field_70166_s = z;
/* 66 */       instance.field_70142_S = x;
/* 67 */       instance.field_70137_T = y;
/* 68 */       instance.field_70136_U = z;
/* 69 */       instance.field_70165_t = x;
/* 70 */       instance.field_70163_u = y;
/* 71 */       instance.field_70161_v = z;
/*    */     } 
/*    */   }
/*    */   
/*    */   public float func_71151_f() {
/* 76 */     return super.func_71151_f() * 1.0F / this.zoom;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_ViewEntityDummy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */