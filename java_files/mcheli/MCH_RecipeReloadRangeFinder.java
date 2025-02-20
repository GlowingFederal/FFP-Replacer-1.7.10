/*    */ package mcheli;
/*    */ 
/*    */ import net.minecraft.inventory.InventoryCrafting;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.crafting.IRecipe;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_RecipeReloadRangeFinder
/*    */   implements IRecipe
/*    */ {
/*    */   public boolean func_77569_a(InventoryCrafting inv, World var2) {
/* 13 */     int jcnt = 0;
/* 14 */     int ccnt = 0;
/*    */     
/* 16 */     for (int i = 0; i < inv.func_70302_i_(); i++) {
/* 17 */       ItemStack is = inv.func_70301_a(i);
/* 18 */       if (is != null) {
/* 19 */         if (is.func_77973_b() instanceof mcheli.tool.rangefinder.MCH_ItemRangeFinder) {
/* 20 */           if (is.func_77960_j() == 0) {
/* 21 */             return false;
/*    */           }
/*    */           
/* 24 */           jcnt++;
/* 25 */           if (jcnt > 1) {
/* 26 */             return false;
/*    */           }
/*    */         } else {
/* 29 */           if (!(is.func_77973_b() instanceof net.minecraft.item.ItemRedstone) || is.field_77994_a <= 0) {
/* 30 */             return false;
/*    */           }
/*    */           
/* 33 */           ccnt++;
/* 34 */           if (ccnt > 1) {
/* 35 */             return false;
/*    */           }
/*    */         } 
/*    */       }
/*    */     } 
/*    */     
/* 41 */     return (jcnt == 1 && ccnt > 0);
/*    */   }
/*    */   
/*    */   public ItemStack func_77572_b(InventoryCrafting inv) {
/* 45 */     ItemStack output = new ItemStack((Item)MCH_MOD.itemRangeFinder);
/* 46 */     return output;
/*    */   }
/*    */   
/*    */   public int func_77570_a() {
/* 50 */     return 9;
/*    */   }
/*    */   
/*    */   public ItemStack func_77571_b() {
/* 54 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_RecipeReloadRangeFinder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */