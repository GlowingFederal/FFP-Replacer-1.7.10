/*    */ package mcheli.gui;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class MCH_ConfigGuiContainer
/*    */   extends Container
/*    */ {
/*    */   public final EntityPlayer player;
/*    */   
/*    */   public MCH_ConfigGuiContainer(EntityPlayer player) {
/* 13 */     this.player = player;
/*    */   }
/*    */   
/*    */   public void func_75142_b() {
/* 17 */     super.func_75142_b();
/*    */   }
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer player) {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public ItemStack func_82846_b(EntityPlayer par1EntityPlayer, int par2) {
/* 25 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gui\MCH_ConfigGuiContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */