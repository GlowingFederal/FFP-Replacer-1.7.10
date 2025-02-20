/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.nbt.NBTTagIntArray;
/*    */ import net.minecraft.nbt.NBTTagList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_NBTTag
/*    */ {
/*    */   public static final int TAG_COMPOUND = 10;
/*    */   
/*    */   public static NBTTagCompound tagAt(NBTTagList list, int i) {
/* 19 */     return (list != null) ? list.func_150305_b(i) : null;
/*    */   }
/*    */   
/*    */   public static NBTTagList getTagList(NBTTagCompound nbt, String s, int i) {
/* 23 */     return nbt.func_150295_c(s, i);
/*    */   }
/*    */   
/*    */   public static NBTTagIntArray newTagIntArray(String s, int[] n) {
/* 27 */     return new NBTTagIntArray(n);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_NBTTag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */