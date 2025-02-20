/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import mcheli.wrapper.W_Item;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_ItemFuel
/*    */   extends W_Item
/*    */ {
/*    */   public MCH_ItemFuel(int itemID) {
/* 12 */     super(itemID);
/* 13 */     func_77656_e(600);
/* 14 */     func_77625_d(1);
/* 15 */     setNoRepair();
/* 16 */     func_77664_n();
/*    */   }
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack stack, World world, EntityPlayer player) {
/* 20 */     int damage = stack.func_77960_j();
/* 21 */     if (!world.field_72995_K && stack.func_77951_h() && !player.field_71075_bZ.field_75098_d) {
/* 22 */       refuel(stack, player, 1);
/* 23 */       refuel(stack, player, 0);
/*    */     } 
/*    */     
/* 26 */     return stack;
/*    */   }
/*    */   
/*    */   private void refuel(ItemStack stack, EntityPlayer player, int coalType) {
/* 30 */     ItemStack[] list = player.field_71071_by.field_70462_a;
/*    */     
/* 32 */     for (int i = 0; i < list.length; i++) {
/* 33 */       ItemStack is = list[i];
/* 34 */       if (is != null && is.func_77973_b() instanceof net.minecraft.item.ItemCoal && is.func_77960_j() == coalType) {
/* 35 */         for (int j = 0; is.field_77994_a > 0 && stack.func_77951_h() && j < 64; j++) {
/* 36 */           int damage = stack.func_77960_j() - ((coalType == 1) ? 75 : 100);
/* 37 */           if (damage < 0) {
/* 38 */             damage = 0;
/*    */           }
/*    */           
/* 41 */           stack.func_77964_b(damage);
/* 42 */           is.field_77994_a--;
/*    */         } 
/*    */         
/* 45 */         if (is.field_77994_a <= 0)
/* 46 */           list[i] = null; 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_ItemFuel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */