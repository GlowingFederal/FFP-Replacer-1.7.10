/*    */ package mcheli.uav;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class MCH_ContainerUavStation
/*    */   extends Container
/*    */ {
/*    */   protected MCH_EntityUavStation uavStation;
/*    */   
/*    */   public MCH_ContainerUavStation(InventoryPlayer inventoryPlayer, MCH_EntityUavStation te) {
/* 17 */     this.uavStation = te;
/* 18 */     func_75146_a(new Slot((IInventory)this.uavStation, 0, 20, 20));
/* 19 */     bindPlayerInventory(inventoryPlayer);
/*    */   }
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer player) {
/* 23 */     return this.uavStation.func_70300_a(player);
/*    */   }
/*    */   
/*    */   public void func_75130_a(IInventory par1IInventory) {
/* 27 */     super.func_75130_a(par1IInventory);
/*    */   }
/*    */   
/*    */   protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
/*    */     int i;
/* 32 */     for (i = 0; i < 3; i++) {
/* 33 */       for (int j = 0; j < 9; j++) {
/* 34 */         func_75146_a(new Slot((IInventory)inventoryPlayer, 9 + j + i * 9, 8 + j * 18, 84 + i * 18));
/*    */       }
/*    */     } 
/*    */     
/* 38 */     for (i = 0; i < 9; i++) {
/* 39 */       func_75146_a(new Slot((IInventory)inventoryPlayer, i, 8 + i * 18, 142));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_82846_b(EntityPlayer player, int slot) {
/* 45 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mchel\\uav\MCH_ContainerUavStation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */