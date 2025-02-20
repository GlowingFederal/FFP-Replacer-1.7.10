/*    */ package mcheli;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import mcheli.aircraft.MCH_AircraftInfo;
/*    */ import mcheli.aircraft.MCH_ItemAircraft;
/*    */ import net.minecraft.item.ItemStack;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements Comparator<ItemStack>
/*    */ {
/*    */   public int compare(ItemStack i1, ItemStack i2) {
/* 78 */     if (i1.func_77973_b() instanceof MCH_ItemAircraft && i2.func_77973_b() instanceof MCH_ItemAircraft) {
/* 79 */       MCH_AircraftInfo info1 = ((MCH_ItemAircraft)i1.func_77973_b()).getAircraftInfo();
/* 80 */       MCH_AircraftInfo info2 = ((MCH_ItemAircraft)i2.func_77973_b()).getAircraftInfo();
/* 81 */       if (info1 != null && info2 != null) {
/* 82 */         String s1 = info1.category + "." + info1.name;
/* 83 */         String s2 = info2.category + "." + info2.name;
/* 84 */         return s1.compareTo(s2);
/*    */       } 
/*    */     } 
/*    */     
/* 88 */     return i1.func_77973_b().func_77658_a().compareTo(i2.func_77973_b().func_77658_a());
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_CreativeTabs$1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */