/*    */ package mcheli.helicopter;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.aircraft.MCH_AircraftInfo;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.aircraft.MCH_ItemAircraft;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_ItemHeli extends MCH_ItemAircraft {
/*    */   public MCH_ItemHeli(int par1) {
/* 12 */     super(par1);
/* 13 */     this.field_77777_bU = 1;
/*    */   }
/*    */   
/*    */   public MCH_AircraftInfo getAircraftInfo() {
/* 17 */     return MCH_HeliInfoManager.getFromItem((Item)this);
/*    */   }
/*    */   
/*    */   public MCH_EntityHeli createAircraft(World world, double x, double y, double z, ItemStack itemStack) {
/* 21 */     MCH_HeliInfo info = MCH_HeliInfoManager.getFromItem((Item)this);
/* 22 */     if (info == null) {
/* 23 */       MCH_Lib.Log(world, "##### MCH_ItemHeli Heli info null %s", new Object[] { func_77658_a() });
/* 24 */       return null;
/*    */     } 
/* 26 */     MCH_EntityHeli heli = new MCH_EntityHeli(world);
/* 27 */     heli.func_70107_b(x, y + heli.field_70129_M, z);
/* 28 */     heli.field_70169_q = x;
/* 29 */     heli.field_70167_r = y;
/* 30 */     heli.field_70166_s = z;
/* 31 */     heli.camera.setPosition(x, y, z);
/* 32 */     heli.setTypeName(info.name);
/* 33 */     if (!world.field_72995_K) {
/* 34 */       heli.setTextureName(info.getTextureName());
/*    */     }
/*    */     
/* 37 */     return heli;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\helicopter\MCH_ItemHeli.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */