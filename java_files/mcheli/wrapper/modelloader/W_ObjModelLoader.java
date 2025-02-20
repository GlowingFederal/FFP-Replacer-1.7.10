/*    */ package mcheli.wrapper.modelloader;
/*    */ 
/*    */ import java.net.URL;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.model.IModelCustom;
/*    */ import net.minecraftforge.client.model.IModelCustomLoader;
/*    */ import net.minecraftforge.client.model.ModelFormatException;
/*    */ 
/*    */ public class W_ObjModelLoader
/*    */   implements IModelCustomLoader
/*    */ {
/* 12 */   private static final String[] types = new String[] { "obj" };
/*    */ 
/*    */   
/*    */   public String getType() {
/* 16 */     return "OBJ model";
/*    */   }
/*    */   
/*    */   public String[] getSuffixes() {
/* 20 */     return types;
/*    */   }
/*    */   
/*    */   public IModelCustom loadInstance(ResourceLocation resource) throws ModelFormatException {
/* 24 */     return new W_WavefrontObject(resource);
/*    */   }
/*    */   
/*    */   public IModelCustom loadInstance(String resourceName, URL resource) throws ModelFormatException {
/* 28 */     return new W_WavefrontObject(resourceName, resource);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\modelloader\W_ObjModelLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */