/*    */ package mcheli.throwable;
/*    */ 
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.wrapper.W_BlockDispenser;
/*    */ import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
/*    */ import net.minecraft.dispenser.IBlockSource;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ 
/*    */ public class MCH_ItemThrowableDispenseBehavior extends BehaviorDefaultDispenseItem {
/*    */   public ItemStack func_82487_b(IBlockSource bs, ItemStack itemStack) {
/* 13 */     EnumFacing enumfacing = W_BlockDispenser.getFacing(bs.func_82620_h());
/* 14 */     double x = bs.func_82615_a() + enumfacing.func_82601_c() * 2.0D;
/* 15 */     double y = bs.func_82617_b() + enumfacing.func_96559_d() * 2.0D;
/* 16 */     double z = bs.func_82616_c() + enumfacing.func_82599_e() * 2.0D;
/* 17 */     if (itemStack.func_77973_b() instanceof MCH_ItemThrowable) {
/* 18 */       MCH_ThrowableInfo info = MCH_ThrowableInfoManager.get(itemStack.func_77973_b());
/* 19 */       if (info != null) {
/* 20 */         bs.func_82618_k().func_72980_b(x, y, z, "random.bow", 0.5F, 0.4F / ((bs.func_82618_k()).field_73012_v.nextFloat() * 0.4F + 0.8F), false);
/* 21 */         if (!(bs.func_82618_k()).field_72995_K) {
/* 22 */           MCH_Lib.DbgLog(bs.func_82618_k(), "MCH_ItemThrowableDispenseBehavior.dispenseStack(%s)", new Object[] { info.name });
/* 23 */           MCH_EntityThrowable entity = new MCH_EntityThrowable(bs.func_82618_k(), x, y, z);
/* 24 */           entity.field_70159_w = enumfacing.func_82601_c() * info.dispenseAcceleration;
/* 25 */           entity.field_70181_x = enumfacing.func_96559_d() * info.dispenseAcceleration;
/* 26 */           entity.field_70179_y = enumfacing.func_82599_e() * info.dispenseAcceleration;
/* 27 */           entity.setInfo(info);
/* 28 */           bs.func_82618_k().func_72838_d((Entity)entity);
/* 29 */           itemStack.func_77979_a(1);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 34 */     return itemStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\throwable\MCH_ItemThrowableDispenseBehavior.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */