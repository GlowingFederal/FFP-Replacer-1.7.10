/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import mcheli.wrapper.modelloader.W_MqoModelLoader;
/*    */ import mcheli.wrapper.modelloader.W_ObjModelLoader;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.model.AdvancedModelLoader;
/*    */ import net.minecraftforge.client.model.IModelCustom;
/*    */ import net.minecraftforge.client.model.IModelCustomLoader;
/*    */ import net.minecraftforge.client.model.ModelFormatException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class W_ModelBase
/*    */   extends ModelBase
/*    */ {
/* 27 */   private static IModelCustomLoader objLoader = (IModelCustomLoader)new W_ObjModelLoader();
/* 28 */   private static IModelCustomLoader mqoLoader = (IModelCustomLoader)new W_MqoModelLoader();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static IModelCustom loadModel(String name) throws IllegalArgumentException, ModelFormatException {
/* 35 */     ResourceLocation resource = new ResourceLocation("mcheli", name);
/* 36 */     String path = resource.func_110623_a();
/* 37 */     int i = path.lastIndexOf('.');
/* 38 */     if (i == -1) {
/* 39 */       FMLLog.severe("The resource name %s is not valid", new Object[] { resource });
/* 40 */       throw new IllegalArgumentException("The resource name is not valid");
/*    */     } 
/* 42 */     String test = path.substring(i);
/* 43 */     if (path.substring(i).equalsIgnoreCase(".mqo")) {
/* 44 */       return mqoLoader.loadInstance(resource);
/*    */     }
/* 46 */     if (path.substring(i).equalsIgnoreCase(".obj"))
/*    */     {
/*    */ 
/*    */       
/* 50 */       return objLoader.loadInstance(resource);
/*    */     }
/* 52 */     return AdvancedModelLoader.loadModel(resource);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_ModelBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */