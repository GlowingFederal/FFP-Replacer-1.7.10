/*    */ package mcheli;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import net.minecraftforge.client.model.IModelCustom;
/*    */ import net.minecraftforge.client.model.obj.GroupObject;
/*    */ import net.minecraftforge.client.model.obj.WavefrontObject;
/*    */ import org.lwjgl.BufferUtils;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class W_Model
/*    */   implements IModelCustom
/*    */ {
/* 18 */   private final Map<String, Integer> lists = new HashMap<>();
/*    */   
/*    */   private final IntBuffer bufAll;
/*    */   
/*    */   private final String type;
/*    */   
/*    */   public W_Model(WavefrontObject model) {
/* 25 */     this.type = model.getType();
/* 26 */     int list = GL11.glGenLists(model.groupObjects.size());
/* 27 */     for (GroupObject obj : model.groupObjects) {
/* 28 */       GL11.glNewList(list, 4864);
/* 29 */       model.renderPart(obj.name);
/* 30 */       GL11.glEndList();
/* 31 */       this.lists.put(obj.name, Integer.valueOf(list++));
/*    */     } 
/* 33 */     this.bufAll = initBuffer();
/*    */   }
/*    */ 
/*    */   
/*    */   private IntBuffer initBuffer() {
/* 38 */     IntBuffer buf = BufferUtils.createIntBuffer(this.lists.size());
/* 39 */     for (Iterator<Integer> iterator = this.lists.values().iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/* 40 */       buf.put(i); }
/*    */     
/* 42 */     buf.flip();
/* 43 */     return buf;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getType() {
/* 49 */     return this.type;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAll() {
/* 55 */     GL11.glCallLists(this.bufAll);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderOnly(String... groupNames) {
/* 61 */     if (groupNames == null || groupNames.length == 0) {
/*    */       return;
/*    */     }
/*    */     
/* 65 */     for (String group : groupNames) {
/* 66 */       renderPart(group);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderPart(String partName) {
/* 73 */     Integer list = this.lists.get(partName);
/* 74 */     if (list != null) {
/* 75 */       GL11.glCallList(list.intValue());
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAllExcept(String... groupNames) {
/* 82 */     if (groupNames == null || groupNames.length == 0) {
/* 83 */       renderAll();
/*    */       
/*    */       return;
/*    */     } 
/* 87 */     for (Map.Entry<String, Integer> it : this.lists.entrySet()) {
/* 88 */       if (Arrays.binarySearch(groupNames, it.getKey(), String::compareTo) < 0)
/* 89 */         GL11.glCallList(((Integer)it.getValue()).intValue()); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\W_Model.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */