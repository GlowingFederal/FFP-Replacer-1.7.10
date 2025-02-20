/*     */ package mcheli;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.File;
/*     */ import java.util.HashMap;
/*     */ import java.util.Random;
/*     */ import mcheli.wrapper.W_ModelBase;
/*     */ import mcheli.wrapper.W_ResourcePath;
/*     */ import mcheli.wrapper.modelloader.W_ModelCustom;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraftforge.client.model.IModelCustom;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_ModelManager
/*     */   extends W_ModelBase
/*     */ {
/*  19 */   private static MCH_ModelManager instance = new MCH_ModelManager();
/*     */   private static HashMap map;
/*     */   private static ModelRenderer defaultModel;
/*     */   private static boolean forceReloadMode = false;
/*  23 */   private static Random rand = new Random();
/*     */ 
/*     */   
/*     */   private MCH_ModelManager() {
/*  27 */     map = new HashMap<>();
/*  28 */     defaultModel = null;
/*  29 */     defaultModel = new ModelRenderer((ModelBase)this, 0, 0);
/*  30 */     defaultModel.func_78790_a(-5.0F, -5.0F, -5.0F, 10, 10, 10, 0.0F);
/*     */   }
/*     */   
/*     */   public static void setForceReloadMode(boolean b) {
/*  34 */     forceReloadMode = b;
/*     */   }
/*     */   
/*     */   public static IModelCustom load(String path, String name) {
/*  38 */     return (name != null && !name.isEmpty()) ? load(path + "/" + name) : null;
/*     */   }
/*     */   
/*     */   public static IModelCustom load(String name) {
/*  42 */     if (name != null && !name.isEmpty()) {
/*  43 */       IModelCustom obj = (IModelCustom)map.get(name);
/*  44 */       if (obj != null) {
/*  45 */         if (!forceReloadMode) {
/*  46 */           return obj;
/*     */         }
/*     */         
/*  49 */         map.remove(name);
/*     */       } 
/*     */       
/*  52 */       IModelCustom model = null;
/*     */       
/*     */       try {
/*  55 */         String e = "/assets/mcheli/models/" + name + ".mqo";
/*  56 */         String filePathObj = "/assets/mcheli/models/" + name + ".obj";
/*  57 */         String filePathTcn = "/assets/mcheli/models/" + name + ".tcn";
/*  58 */         if ((new File(MCH_MOD.sourcePath + e)).exists()) {
/*  59 */           e = W_ResourcePath.getModelPath() + "models/" + name + ".mqo";
/*  60 */           model = W_ModelBase.loadModel(e);
/*  61 */         } else if ((new File(MCH_MOD.sourcePath + filePathObj)).exists()) {
/*  62 */           filePathObj = W_ResourcePath.getModelPath() + "models/" + name + ".obj";
/*  63 */           model = W_ModelBase.loadModel(filePathObj);
/*  64 */         } else if ((new File(MCH_MOD.sourcePath + filePathTcn)).exists()) {
/*  65 */           filePathTcn = W_ResourcePath.getModelPath() + "models/" + name + ".tcn";
/*  66 */           model = W_ModelBase.loadModel(filePathTcn);
/*     */         } 
/*  68 */       } catch (Exception var6) {
/*  69 */         var6.printStackTrace();
/*  70 */         model = null;
/*     */       } 
/*     */       
/*  73 */       if (model != null) {
/*  74 */         map.put(name, model);
/*  75 */         return model;
/*     */       } 
/*  77 */       return null;
/*     */     } 
/*     */     
/*  80 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void render(String path, String name) {
/*  85 */     render(path + "/" + name);
/*     */   }
/*     */   
/*     */   public static void render(String name) {
/*  89 */     IModelCustom model = (IModelCustom)map.get(name);
/*     */     
/*  91 */     if (model != null) {
/*  92 */       model.renderAll();
/*     */     }
/*  94 */     else if (defaultModel != null) {
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderPart(String name, String partName) {
/* 101 */     IModelCustom model = (IModelCustom)map.get(name);
/* 102 */     if (model != null) {
/* 103 */       model.renderPart(partName);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderLine(String path, String name, int startLine, int maxLine) {
/* 109 */     IModelCustom model = (IModelCustom)map.get(path + "/" + name);
/* 110 */     if (model instanceof W_ModelCustom) {
/* 111 */       ((W_ModelCustom)model).renderAllLine(startLine, maxLine);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void render(String path, String name, int startFace, int maxFace) {
/* 117 */     IModelCustom model = (IModelCustom)map.get(path + "/" + name);
/* 118 */     if (model instanceof W_ModelCustom) {
/* 119 */       ((W_ModelCustom)model).renderAll(startFace, maxFace);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getVertexNum(String path, String name) {
/* 125 */     IModelCustom model = (IModelCustom)map.get(path + "/" + name);
/* 126 */     return (model instanceof W_ModelCustom) ? ((W_ModelCustom)model).getVertexNum() : 0;
/*     */   }
/*     */   
/*     */   public static W_ModelCustom get(String path, String name) {
/* 130 */     IModelCustom model = (IModelCustom)map.get(path + "/" + name);
/* 131 */     return (model instanceof W_ModelCustom) ? (W_ModelCustom)model : null;
/*     */   }
/*     */   
/*     */   public static W_ModelCustom getRandome() {
/* 135 */     int size = map.size();
/*     */     
/* 137 */     for (int i = 0; i < 10; i++) {
/* 138 */       int idx = 0;
/* 139 */       int index = rand.nextInt(size);
/*     */       
/* 141 */       for (IModelCustom model : map.values()) {
/*     */         
/* 143 */         if (idx >= index && model instanceof W_ModelCustom) {
/* 144 */           return (W_ModelCustom)model;
/*     */         }
/*     */         idx++;
/*     */       } 
/*     */     } 
/* 149 */     return null;
/*     */   }
/*     */   
/*     */   public static boolean containsModel(String path, String name) {
/* 153 */     return containsModel(path + "/" + name);
/*     */   }
/*     */   
/*     */   public static boolean containsModel(String name) {
/* 157 */     return map.containsKey(name);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_ModelManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */