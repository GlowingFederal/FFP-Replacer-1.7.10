/*    */ package mcheli.wrapper.modelloader;
/*    */ 
/*    */ import java.net.URL;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.model.IModelCustom;
/*    */ import net.minecraftforge.client.model.IModelCustomLoader;
/*    */ import net.minecraftforge.client.model.ModelFormatException;
/*    */ 
/*    */ public class W_MqoModelLoader
/*    */   implements IModelCustomLoader
/*    */ {
/* 12 */   private static final String[] types = new String[] { "mqo" };
/*    */ 
/*    */   
/*    */   public String getType() {
/* 16 */     return "Metasequoia model";
/*    */   }
/*    */   
/*    */   public String[] getSuffixes() {
/* 20 */     return types;
/*    */   }
/*    */   
/*    */   public IModelCustom loadInstance(ResourceLocation resource) throws ModelFormatException {
/* 24 */     return new W_MetasequoiaObject(resource);
/*    */   }
/*    */   
/*    */   public IModelCustom loadInstance(String resourceName, URL resource) throws ModelFormatException {
/* 28 */     return new W_MetasequoiaObject(resourceName, resource);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\modelloader\W_MqoModelLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */