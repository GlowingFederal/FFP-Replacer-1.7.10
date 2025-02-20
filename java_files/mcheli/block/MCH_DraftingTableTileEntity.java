/*    */ package mcheli.block;
/*    */ 
/*    */ import mcheli.MCH_Lib;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ public class MCH_DraftingTableTileEntity
/*    */   extends TileEntity {
/*    */   public int func_145832_p() {
/*  9 */     if (this.field_145847_g == -1) {
/* 10 */       this.field_145847_g = this.field_145850_b.func_72805_g(this.field_145851_c, this.field_145848_d, this.field_145849_e);
/* 11 */       MCH_Lib.DbgLog(this.field_145850_b, "MCH_DraftingTableTileEntity.getBlockMetadata : %d(0x%08X)", new Object[] { Integer.valueOf(this.field_145847_g), Integer.valueOf(this.field_145847_g) });
/*    */     } 
/*    */     
/* 14 */     return this.field_145847_g;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\block\MCH_DraftingTableTileEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */