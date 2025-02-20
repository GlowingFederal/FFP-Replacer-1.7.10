/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class W_Block
/*    */   extends Block
/*    */ {
/*    */   protected W_Block(Material p_i45394_1_) {
/* 18 */     super(p_i45394_1_);
/*    */   }
/*    */   
/*    */   public static Block getBlockFromName(String name) {
/* 22 */     return Block.func_149684_b(name);
/*    */   }
/*    */   
/*    */   public static Block getSnowLayer() {
/* 26 */     return Blocks.field_150431_aC;
/*    */   }
/*    */   
/*    */   public static boolean isNull(Block block) {
/* 30 */     return (block == null || block == Blocks.field_150350_a);
/*    */   }
/*    */   
/*    */   public static boolean isEqual(int blockId, Block block) {
/* 34 */     return Block.func_149680_a(Block.func_149729_e(blockId), block);
/*    */   }
/*    */   
/*    */   public static boolean isEqual(Block block1, Block block2) {
/* 38 */     return Block.func_149680_a(block1, block2);
/*    */   }
/*    */   
/*    */   public static Block getWater() {
/* 42 */     return Blocks.field_150355_j;
/*    */   }
/*    */   
/*    */   public static Block getBlockById(int i) {
/* 46 */     return Block.func_149729_e(i);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_Block.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */