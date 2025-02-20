/*     */ package mcheli.wrapper;
/*     */ 
/*     */ import cpw.mods.fml.common.ObfuscationReflectionHelper;
/*     */ import java.util.List;
/*     */ import java.util.Queue;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.multiplayer.PlayerControllerMP;
/*     */ import net.minecraft.client.renderer.EntityRenderer;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.NetworkSystem;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class W_Reflection
/*     */ {
/*     */   public static RenderManager getRenderManager(Render render) {
/*     */     try {
/*  44 */       return (RenderManager)ObfuscationReflectionHelper.getPrivateValue(Render.class, render, new String[] { "field_76990_c", "renderManager" });
/*  45 */     } catch (Exception var2) {
/*  46 */       var2.printStackTrace();
/*  47 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void restoreDefaultThirdPersonDistance() {
/*  52 */     setThirdPersonDistance(4.0F);
/*     */   }
/*     */   
/*     */   public static void setThirdPersonDistance(float dist) {
/*  56 */     if (dist >= 0.1D) {
/*     */       try {
/*  58 */         Minecraft e = Minecraft.func_71410_x();
/*  59 */         ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, e.field_71460_t, Float.valueOf(dist), new String[] { "field_78490_B", "thirdPersonDistance" });
/*  60 */       } catch (Exception var2) {
/*  61 */         var2.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getThirdPersonDistance() {
/*     */     try {
/*  69 */       Minecraft e = Minecraft.func_71410_x();
/*  70 */       return ((Float)ObfuscationReflectionHelper.getPrivateValue(EntityRenderer.class, e.field_71460_t, new String[] { "field_78490_B", "thirdPersonDistance" })).floatValue();
/*  71 */     } catch (Exception var1) {
/*  72 */       var1.printStackTrace();
/*  73 */       return 4.0F;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setCameraRoll(float roll) {
/*     */     try {
/*  79 */       roll = MathHelper.func_76142_g(roll);
/*  80 */       Minecraft e = Minecraft.func_71410_x();
/*  81 */       ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, (Minecraft.func_71410_x()).field_71460_t, Float.valueOf(roll), new String[] { "field_78495_O", "camRoll" });
/*  82 */       ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, (Minecraft.func_71410_x()).field_71460_t, Float.valueOf(roll), new String[] { "field_78505_P", "prevCamRoll" });
/*  83 */     } catch (Exception var2) {
/*  84 */       var2.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getPrevCameraRoll() {
/*     */     try {
/*  91 */       Minecraft e = Minecraft.func_71410_x();
/*  92 */       return ((Float)ObfuscationReflectionHelper.getPrivateValue(EntityRenderer.class, (Minecraft.func_71410_x()).field_71460_t, new String[] { "field_78505_P", "prevCamRoll" })).floatValue();
/*  93 */     } catch (Exception var1) {
/*  94 */       var1.printStackTrace();
/*  95 */       return 0.0F;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void restoreCameraZoom() {
/* 100 */     setCameraZoom(1.0F);
/*     */   }
/*     */   
/*     */   public static void setCameraZoom(float zoom) {
/*     */     try {
/* 105 */       Minecraft e = Minecraft.func_71410_x();
/* 106 */       ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, e.field_71460_t, Float.valueOf(zoom), new String[] { "field_78503_V", "cameraZoom" });
/* 107 */     } catch (Exception var2) {
/* 108 */       var2.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setItemRenderer(ItemRenderer r) {
/*     */     try {
/* 115 */       Minecraft minecraft = Minecraft.func_71410_x();
/* 116 */     } catch (Exception var2) {
/* 117 */       var2.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setCreativeDigSpeed(int n) {
/*     */     try {
/* 124 */       Minecraft e = Minecraft.func_71410_x();
/* 125 */       ObfuscationReflectionHelper.setPrivateValue(PlayerControllerMP.class, e.field_71442_b, Integer.valueOf(n), new String[] { "field_78781_i", "blockHitDelay" });
/* 126 */     } catch (Exception var2) {
/* 127 */       var2.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemRenderer getItemRenderer() {
/* 133 */     return (Minecraft.func_71410_x()).field_71460_t.field_78516_c;
/*     */   }
/*     */   
/*     */   public static void setItemRenderer_ItemToRender(ItemStack itemToRender) {
/*     */     try {
/* 138 */       ObfuscationReflectionHelper.setPrivateValue(ItemRenderer.class, getItemRenderer(), itemToRender, new String[] { "field_78453_b", "itemToRender" });
/* 139 */     } catch (Exception var2) {
/* 140 */       var2.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack getItemRenderer_ItemToRender() {
/*     */     try {
/* 147 */       ItemStack e = (ItemStack)ObfuscationReflectionHelper.getPrivateValue(ItemRenderer.class, getItemRenderer(), new String[] { "field_78453_b", "itemToRender" });
/* 148 */       return e;
/* 149 */     } catch (Exception var1) {
/* 150 */       var1.printStackTrace();
/* 151 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void setItemRendererProgress(float equippedProgress) {
/*     */     try {
/* 157 */       ObfuscationReflectionHelper.setPrivateValue(ItemRenderer.class, getItemRenderer(), Float.valueOf(equippedProgress), new String[] { "field_78454_c", "equippedProgress" });
/* 158 */     } catch (Exception var2) {
/* 159 */       var2.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setBoundingBox(Entity entity, AxisAlignedBB bb) {
/*     */     try {
/* 166 */       ObfuscationReflectionHelper.setPrivateValue(Entity.class, entity, bb, new String[] { "field_70121_D", "boundingBox" });
/* 167 */     } catch (Exception var3) {
/* 168 */       var3.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static List getNetworkManagers() {
/*     */     try {
/* 175 */       List e = (List)ObfuscationReflectionHelper.getPrivateValue(NetworkSystem.class, MinecraftServer.func_71276_C().func_147137_ag(), new String[] { "field_151272_f", "networkManagers" });
/* 176 */       return e;
/* 177 */     } catch (Exception var1) {
/* 178 */       var1.printStackTrace();
/* 179 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Queue getReceivedPacketsQueue(NetworkManager nm) {
/*     */     try {
/* 185 */       Queue e = (Queue)ObfuscationReflectionHelper.getPrivateValue(NetworkManager.class, nm, new String[] { "field_150748_i", "receivedPacketsQueue" });
/* 186 */       return e;
/* 187 */     } catch (Exception var2) {
/* 188 */       var2.printStackTrace();
/* 189 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Queue getSendPacketsQueue(NetworkManager nm) {
/*     */     try {
/* 195 */       Queue e = (Queue)ObfuscationReflectionHelper.getPrivateValue(NetworkManager.class, nm, new String[] { "field_150745_j", "outboundPacketsQueue" });
/* 196 */       return e;
/* 197 */     } catch (Exception var2) {
/* 198 */       var2.printStackTrace();
/* 199 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_Reflection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */