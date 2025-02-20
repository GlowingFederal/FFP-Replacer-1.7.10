/*    */ package mcheli.vehicle;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.aircraft.MCH_AircraftInfo;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.aircraft.MCH_ItemAircraft;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_ItemVehicle extends MCH_ItemAircraft {
/*    */   public MCH_ItemVehicle(int par1) {
/* 12 */     super(par1);
/* 13 */     this.field_77777_bU = 1;
/*    */   }
/*    */   
/*    */   public MCH_AircraftInfo getAircraftInfo() {
/* 17 */     return MCH_VehicleInfoManager.getFromItem((Item)this);
/*    */   }
/*    */   
/*    */   public MCH_EntityVehicle createAircraft(World world, double x, double y, double z, ItemStack item) {
/* 21 */     MCH_VehicleInfo info = MCH_VehicleInfoManager.getFromItem((Item)this);
/* 22 */     if (info == null) {
/* 23 */       MCH_Lib.Log(world, "##### MCH_ItemVehicle Vehicle info null %s", new Object[] { func_77658_a() });
/* 24 */       return null;
/*    */     } 
/* 26 */     MCH_EntityVehicle vehicle = new MCH_EntityVehicle(world);
/* 27 */     vehicle.func_70107_b(x, y + vehicle.field_70129_M, z);
/* 28 */     vehicle.field_70169_q = x;
/* 29 */     vehicle.field_70167_r = y;
/* 30 */     vehicle.field_70166_s = z;
/* 31 */     vehicle.camera.setPosition(x, y, z);
/* 32 */     vehicle.setTypeName(info.name);
/* 33 */     if (!world.field_72995_K) {
/* 34 */       vehicle.setTextureName(info.getTextureName());
/*    */     }
/*    */     
/* 37 */     return vehicle;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\vehicle\MCH_ItemVehicle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */