/*    */ package mcheli.weapon;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.aircraft.MCH_EntitySeat;
/*    */ import mcheli.uav.MCH_EntityUavStation;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderTvMissile
/*    */   extends MCH_RenderBulletBase {
/*    */   public MCH_RenderTvMissile() {
/* 18 */     this.field_76989_e = 0.5F;
/*    */   }
/*    */   
/*    */   public void renderBullet(Entity entity, double posX, double posY, double posZ, float par8, float par9) {
/* 22 */     MCH_EntityAircraft ac = null;
/* 23 */     Entity ridingEntity = (Minecraft.func_71410_x()).field_71439_g.field_70154_o;
/* 24 */     if (ridingEntity instanceof MCH_EntityAircraft) {
/* 25 */       ac = (MCH_EntityAircraft)ridingEntity;
/* 26 */     } else if (ridingEntity instanceof MCH_EntitySeat) {
/* 27 */       ac = ((MCH_EntitySeat)ridingEntity).getParent();
/* 28 */     } else if (ridingEntity instanceof MCH_EntityUavStation) {
/* 29 */       ac = ((MCH_EntityUavStation)ridingEntity).getControlAircract();
/*    */     } 
/*    */     
/* 32 */     if ((ac == null || ac.isRenderBullet(entity, (Entity)(Minecraft.func_71410_x()).field_71439_g)) && 
/* 33 */       entity instanceof MCH_EntityBaseBullet) {
/* 34 */       MCH_EntityBaseBullet bullet = (MCH_EntityBaseBullet)entity;
/* 35 */       GL11.glPushMatrix();
/* 36 */       GL11.glTranslated(posX, posY, posZ);
/* 37 */       GL11.glRotatef(-entity.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 38 */       GL11.glRotatef(-entity.field_70125_A, -1.0F, 0.0F, 0.0F);
/* 39 */       renderModel(bullet);
/* 40 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 47 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_RenderTvMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */