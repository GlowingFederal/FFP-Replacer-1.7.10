/*    */ package mcheli.plane;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.aircraft.MCH_AircraftInfo;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.aircraft.MCH_ItemAircraft;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCP_ItemPlane extends MCH_ItemAircraft {
/*    */   public MCP_ItemPlane(int par1) {
/* 12 */     super(par1);
/* 13 */     this.field_77777_bU = 1;
/*    */   }
/*    */   
/*    */   public MCH_AircraftInfo getAircraftInfo() {
/* 17 */     return MCP_PlaneInfoManager.getFromItem((Item)this);
/*    */   }
/*    */   
/*    */   public MCP_EntityPlane createAircraft(World world, double x, double y, double z, ItemStack itemStack) {
/* 21 */     MCP_PlaneInfo info = MCP_PlaneInfoManager.getFromItem((Item)this);
/* 22 */     if (info == null) {
/* 23 */       MCH_Lib.Log(world, "##### MCP_EntityPlane Plane info null %s", new Object[] { func_77658_a() });
/* 24 */       return null;
/*    */     } 
/* 26 */     MCP_EntityPlane plane = new MCP_EntityPlane(world);
/* 27 */     plane.func_70107_b(x, y + plane.field_70129_M, z);
/* 28 */     plane.field_70169_q = x;
/* 29 */     plane.field_70167_r = y;
/* 30 */     plane.field_70166_s = z;
/* 31 */     plane.camera.setPosition(x, y, z);
/* 32 */     plane.setTypeName(info.name);
/* 33 */     if (!world.field_72995_K) {
/* 34 */       plane.setTextureName(info.getTextureName());
/*    */     }
/*    */     
/* 37 */     return plane;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\plane\MCP_ItemPlane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */