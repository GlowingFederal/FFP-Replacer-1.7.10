/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_Particle
/*    */ {
/*    */   public static String getParticleTileCrackName(World w, int blockX, int blockY, int blockZ) {
/* 17 */     Block block = w.func_147439_a(blockX, blockY, blockZ);
/* 18 */     if (block.func_149688_o() != Material.field_151579_a) {
/* 19 */       return "blockcrack_" + Block.func_149682_b(block) + "_" + w.func_72805_g(blockX, blockY, blockZ);
/*    */     }
/* 21 */     return "";
/*    */   }
/*    */   
/*    */   public static String getParticleTileDustName(World w, int blockX, int blockY, int blockZ) {
/* 25 */     Block block = w.func_147439_a(blockX, blockY, blockZ);
/* 26 */     if (block.func_149688_o() != Material.field_151579_a) {
/* 27 */       return "blockdust_" + Block.func_149682_b(block) + "_" + w.func_72805_g(blockX, blockY, blockZ);
/*    */     }
/* 29 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_Particle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */