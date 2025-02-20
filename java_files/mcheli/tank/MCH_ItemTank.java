/*    */ package mcheli.tank;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.aircraft.MCH_AircraftInfo;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.aircraft.MCH_ItemAircraft;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_ItemTank extends MCH_ItemAircraft {
/*    */   public MCH_ItemTank(int par1) {
/* 12 */     super(par1);
/* 13 */     this.field_77777_bU = 1;
/*    */   }
/*    */   
/*    */   public MCH_AircraftInfo getAircraftInfo() {
/* 17 */     return MCH_TankInfoManager.getFromItem((Item)this);
/*    */   }
/*    */   
/*    */   public MCH_EntityTank createAircraft(World world, double x, double y, double z, ItemStack itemStack) {
/* 21 */     MCH_TankInfo info = MCH_TankInfoManager.getFromItem((Item)this);
/* 22 */     if (info == null) {
/* 23 */       MCH_Lib.Log(world, "##### MCH_EntityTank Tank info null %s", new Object[] { func_77658_a() });
/* 24 */       return null;
/*    */     } 
/* 26 */     MCH_EntityTank tank = new MCH_EntityTank(world);
/* 27 */     tank.func_70107_b(x, y + tank.field_70129_M, z);
/* 28 */     tank.field_70169_q = x;
/* 29 */     tank.field_70167_r = y;
/* 30 */     tank.field_70166_s = z;
/* 31 */     tank.camera.setPosition(x, y, z);
/* 32 */     tank.setTypeName(info.name);
/* 33 */     if (!world.field_72995_K) {
/* 34 */       tank.setTextureName(info.getTextureName());
/*    */     }
/*    */     
/* 37 */     return tank;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tank\MCH_ItemTank.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */