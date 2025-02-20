/*    */ package mcheli.tank;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mcheli.MCH_Config;
/*    */ import mcheli.MCH_MOD;
/*    */ import mcheli.aircraft.MCH_AircraftInfo;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ public class MCH_TankInfo
/*    */   extends MCH_AircraftInfo
/*    */ {
/* 14 */   public MCH_ItemTank item = null;
/* 15 */   public int weightType = 0;
/* 16 */   public float weightedCenterZ = 0.0F;
/*    */ 
/*    */   
/*    */   public Item getItem() {
/* 20 */     return (Item)this.item;
/*    */   }
/*    */   
/*    */   public MCH_TankInfo(String name) {
/* 24 */     super(name);
/*    */   }
/*    */   
/*    */   public List getDefaultWheelList() {
/* 28 */     ArrayList<MCH_AircraftInfo.Wheel> list = new ArrayList();
/* 29 */     list.add(new MCH_AircraftInfo.Wheel(this, Vec3.func_72443_a(1.5D, -0.24D, 2.0D)));
/* 30 */     list.add(new MCH_AircraftInfo.Wheel(this, Vec3.func_72443_a(1.5D, -0.24D, -2.0D)));
/* 31 */     return list;
/*    */   }
/*    */   
/*    */   public float getDefaultSoundRange() {
/* 35 */     return 50.0F;
/*    */   }
/*    */   
/*    */   public float getDefaultRotorSpeed() {
/* 39 */     return 47.94F;
/*    */   }
/*    */   
/*    */   private float getDefaultStepHeight() {
/* 43 */     return 0.6F;
/*    */   }
/*    */   
/*    */   public float getMaxSpeed() {
/* 47 */     return 1.8F;
/*    */   }
/*    */   
/*    */   public int getDefaultMaxZoom() {
/* 51 */     return 8;
/*    */   }
/*    */   
/*    */   public String getDefaultHudName(int seatId) {
/* 55 */     return (seatId <= 0) ? "tank" : ((seatId == 1) ? "tank" : "gunner");
/*    */   }
/*    */   
/*    */   public boolean isValidData() throws Exception {
/* 59 */     double var10001 = this.speed;
/* 60 */     MCH_Config var10002 = MCH_MOD.config;
/* 61 */     this.speed = (float)(var10001 * MCH_Config.AllTankSpeed.prmDouble);
/* 62 */     return super.isValidData();
/*    */   }
/*    */   
/*    */   public void loadItemData(String item, String data) {
/* 66 */     super.loadItemData(item, data);
/* 67 */     if (item.equalsIgnoreCase("WeightType")) {
/* 68 */       data = data.toLowerCase();
/* 69 */       this.weightType = data.equals("tank") ? 2 : (data.equals("car") ? 1 : 0);
/* 70 */     } else if (item.equalsIgnoreCase("WeightedCenterZ")) {
/* 71 */       this.weightedCenterZ = toFloat(data, -1000.0F, 1000.0F);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDirectoryName() {
/* 77 */     return "tanks";
/*    */   }
/*    */   
/*    */   public String getKindName() {
/* 81 */     return "tank";
/*    */   }
/*    */   
/*    */   public void preReload() {
/* 85 */     super.preReload();
/*    */   }
/*    */   
/*    */   public void postReload() {
/* 89 */     MCH_MOD.proxy.registerModelsTank(this.name, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tank\MCH_TankInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */