/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.wrapper.W_BlockDispenser;
/*    */ import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
/*    */ import net.minecraft.dispenser.IBlockSource;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ 
/*    */ public class MCH_ItemAircraftDispenseBehavior extends BehaviorDefaultDispenseItem {
/*    */   public ItemStack func_82487_b(IBlockSource bs, ItemStack itemStack) {
/* 13 */     EnumFacing enumfacing = W_BlockDispenser.getFacing(bs.func_82620_h());
/* 14 */     double x = bs.func_82615_a() + enumfacing.func_82601_c() * 2.0D;
/* 15 */     double y = bs.func_82617_b() + enumfacing.func_96559_d() * 2.0D;
/* 16 */     double z = bs.func_82616_c() + enumfacing.func_82599_e() * 2.0D;
/* 17 */     if (itemStack.func_77973_b() instanceof MCH_ItemAircraft) {
/* 18 */       MCH_EntityAircraft ac = ((MCH_ItemAircraft)itemStack.func_77973_b()).onTileClick(itemStack, bs.func_82618_k(), 0.0F, (int)x, (int)y, (int)z);
/* 19 */       if (ac != null && !ac.isUAV()) {
/* 20 */         if (!(bs.func_82618_k()).field_72995_K) {
/* 21 */           ac.getAcDataFromItem(itemStack);
/* 22 */           bs.func_82618_k().func_72838_d((Entity)ac);
/*    */         } 
/*    */         
/* 25 */         itemStack.func_77979_a(1);
/* 26 */         MCH_Lib.DbgLog(bs.func_82618_k(), "dispenseStack:x=%.1f,y=%.1f,z=%.1f;dir=%s:item=" + itemStack.func_82833_r(), new Object[] { Double.valueOf(x), Double.valueOf(y), Double.valueOf(z), enumfacing.toString() });
/*    */       } 
/*    */     } 
/*    */     
/* 30 */     return itemStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_ItemAircraftDispenseBehavior.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */