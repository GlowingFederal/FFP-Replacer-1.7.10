/*    */ package mcheli.weapon;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderCartridge
/*    */   extends W_Render {
/*    */   public MCH_RenderCartridge() {
/* 14 */     this.field_76989_e = 0.0F;
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double posX, double posY, double posZ, float par8, float tickTime) {
/* 18 */     MCH_EntityCartridge cartridge = null;
/* 19 */     cartridge = (MCH_EntityCartridge)entity;
/* 20 */     if (cartridge.model != null && !cartridge.texture_name.isEmpty()) {
/* 21 */       GL11.glPushMatrix();
/* 22 */       GL11.glTranslated(posX, posY, posZ);
/* 23 */       GL11.glScalef(cartridge.getScale(), cartridge.getScale(), cartridge.getScale());
/* 24 */       float prevYaw = cartridge.field_70126_B;
/* 25 */       if (cartridge.field_70177_z - prevYaw < -180.0F) {
/* 26 */         prevYaw -= 360.0F;
/* 27 */       } else if (prevYaw - cartridge.field_70177_z < -180.0F) {
/* 28 */         prevYaw += 360.0F;
/*    */       } 
/*    */       
/* 31 */       float yaw = -(prevYaw + (cartridge.field_70177_z - prevYaw) * tickTime);
/* 32 */       float pitch = cartridge.field_70127_C + (cartridge.field_70125_A - cartridge.field_70127_C) * tickTime;
/* 33 */       GL11.glRotatef(yaw, 0.0F, 1.0F, 0.0F);
/* 34 */       GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
/* 35 */       bindTexture("textures/bullets/" + cartridge.texture_name + ".png");
/* 36 */       cartridge.model.renderAll();
/* 37 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 43 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_RenderCartridge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */