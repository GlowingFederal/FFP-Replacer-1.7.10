/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
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
/*    */ public class W_Item
/*    */   extends Item
/*    */ {
/*    */   public W_Item(int par1) {}
/*    */   
/*    */   public W_Item() {}
/*    */   
/*    */   public static int getIdFromItem(Item i) {
/* 23 */     return (i == null) ? 0 : Item.field_150901_e.func_148757_b(i);
/*    */   }
/*    */   
/*    */   public Item setTexture(String par1Str) {
/* 27 */     func_111206_d(W_MOD.DOMAIN + ":" + par1Str);
/* 28 */     return this;
/*    */   }
/*    */   
/*    */   public static Item getItemById(int i) {
/* 32 */     return Item.func_150899_d(i);
/*    */   }
/*    */   
/*    */   public static Item getItemByName(String nm) {
/* 36 */     if (nm.indexOf(':') < 0) {
/* 37 */       nm = "minecraft:" + nm;
/*    */     }
/* 39 */     return (Item)Item.field_150901_e.func_82594_a(nm);
/*    */   }
/*    */   
/*    */   public static String getNameForItem(Item item) {
/* 43 */     return Item.field_150901_e.func_148750_c(item);
/*    */   }
/*    */   
/*    */   public static Item getItemFromBlock(Block block) {
/* 47 */     return Item.func_150898_a(block);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_Item.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */