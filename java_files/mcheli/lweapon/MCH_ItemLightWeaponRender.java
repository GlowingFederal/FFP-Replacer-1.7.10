/*    */ package mcheli.lweapon;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.MCH_Config;
/*    */ import mcheli.MCH_MOD;
/*    */ import mcheli.MCH_ModelManager;
/*    */ import mcheli.wrapper.W_Lib;
/*    */ import mcheli.wrapper.W_McClient;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.IItemRenderer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class MCH_ItemLightWeaponRender
/*    */   implements IItemRenderer {
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/* 19 */     return (type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
/*    */   }
/*    */   
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/* 23 */     return false;
/*    */   }
/*    */   
/*    */   public boolean useCurrentWeapon() {
/* 27 */     return false;
/*    */   }
/*    */   
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/* 31 */     boolean isRender = false;
/* 32 */     if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON || type == IItemRenderer.ItemRenderType.EQUIPPED) {
/* 33 */       isRender = true;
/* 34 */       if (data[1] instanceof EntityPlayer) {
/* 35 */         EntityPlayer player = (EntityPlayer)data[1];
/* 36 */         if (MCH_ItemLightWeaponBase.isHeld(player) && W_Lib.isFirstPerson() && W_Lib.isClientPlayer((Entity)player)) {
/* 37 */           isRender = false;
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 42 */     if (isRender) {
/* 43 */       renderItem(item, (Entity)W_Lib.castEntityLivingBase(data[1]), (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public static void renderItem(ItemStack pitem, Entity entity, boolean isFirstPerson) {
/* 50 */     if (pitem != null && pitem.func_77973_b() != null) {
/* 51 */       String name = MCH_ItemLightWeaponBase.getName(pitem);
/* 52 */       GL11.glEnable(32826);
/* 53 */       GL11.glEnable(2903);
/* 54 */       GL11.glPushMatrix();
/* 55 */       MCH_Config var10000 = MCH_MOD.config;
/* 56 */       if (MCH_Config.SmoothShading.prmBool) {
/* 57 */         GL11.glShadeModel(7425);
/*    */       }
/*    */       
/* 60 */       GL11.glEnable(2884);
/* 61 */       W_McClient.MOD_bindTexture("textures/lweapon/" + name + ".png");
/* 62 */       if (isFirstPerson) {
/* 63 */         GL11.glTranslatef(0.0F, 0.005F, -0.165F);
/* 64 */         GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 65 */         GL11.glRotatef(-10.0F, 0.0F, 0.0F, 1.0F);
/* 66 */         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/* 67 */         GL11.glRotatef(-50.0F, 1.0F, 0.0F, 0.0F);
/*    */       } else {
/* 69 */         GL11.glTranslatef(0.3F, 0.3F, 0.0F);
/* 70 */         GL11.glScalef(2.0F, 2.0F, 2.0F);
/* 71 */         GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
/* 72 */         GL11.glRotatef(10.0F, 0.0F, 1.0F, 0.0F);
/* 73 */         GL11.glRotatef(15.0F, 1.0F, 0.0F, 0.0F);
/*    */       } 
/*    */       
/* 76 */       MCH_ModelManager.render("lweapons", name);
/* 77 */       GL11.glShadeModel(7424);
/* 78 */       GL11.glPopMatrix();
/* 79 */       GL11.glDisable(32826);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\lweapon\MCH_ItemLightWeaponRender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */