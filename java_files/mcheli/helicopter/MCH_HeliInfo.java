/*    */ package mcheli.helicopter;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mcheli.MCH_Config;
/*    */ import mcheli.MCH_MOD;
/*    */ import mcheli.aircraft.MCH_AircraftInfo;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class MCH_HeliInfo
/*    */   extends MCH_AircraftInfo
/*    */ {
/* 13 */   public MCH_ItemHeli item = null;
/*    */   
/*    */   public boolean isEnableFoldBlade;
/*    */   public List rotorList;
/*    */   
/*    */   public MCH_HeliInfo(String name) {
/* 19 */     super(name);
/* 20 */     this.isEnableGunnerMode = false;
/* 21 */     this.isEnableFoldBlade = false;
/* 22 */     this.rotorList = new ArrayList();
/* 23 */     this.minRotationPitch = -20.0F;
/* 24 */     this.maxRotationPitch = 20.0F;
/*    */   }
/*    */   
/*    */   public boolean isValidData() throws Exception {
/* 28 */     double var10001 = this.speed;
/* 29 */     MCH_Config var10002 = MCH_MOD.config;
/* 30 */     this.speed = (float)(var10001 * MCH_Config.AllHeliSpeed.prmDouble);
/* 31 */     return super.isValidData();
/*    */   }
/*    */   
/*    */   public float getDefaultSoundRange() {
/* 35 */     return 80.0F;
/*    */   }
/*    */   
/*    */   public float getDefaultRotorSpeed() {
/* 39 */     return 79.99F;
/*    */   }
/*    */   
/*    */   public int getDefaultMaxZoom() {
/* 43 */     return 8;
/*    */   }
/*    */   
/*    */   public Item getItem() {
/* 47 */     return (Item)this.item;
/*    */   }
/*    */   
/*    */   public String getDefaultHudName(int seatId) {
/* 51 */     return (seatId <= 0) ? "heli" : ((seatId == 1) ? "heli_gnr" : "gunner");
/*    */   }
/*    */   
/*    */   public void loadItemData(String item, String data) {
/* 55 */     super.loadItemData(item, data);
/* 56 */     if (item.compareTo("enablefoldblade") == 0) {
/* 57 */       this.isEnableFoldBlade = toBool(data);
/* 58 */     } else if (item.compareTo("addrotor") == 0 || item.compareTo("addrotorold") == 0) {
/* 59 */       String[] s = data.split("\\s*,\\s*");
/* 60 */       if (s.length == 8 || s.length == 9) {
/* 61 */         boolean cfb = (s.length == 9 && toBool(s[8]));
/* 62 */         Rotor e = new Rotor(toInt(s[0]), toInt(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), toFloat(s[6]), toFloat(s[7]), "blade" + this.rotorList.size(), cfb, (item.compareTo("addrotorold") == 0));
/* 63 */         this.rotorList.add(e);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDirectoryName() {
/* 70 */     return "helicopters";
/*    */   }
/*    */   
/*    */   public String getKindName() {
/* 74 */     return "helicopter";
/*    */   }
/*    */   
/*    */   public void preReload() {
/* 78 */     super.preReload();
/* 79 */     this.rotorList.clear();
/*    */   }
/*    */   
/*    */   public void postReload() {
/* 83 */     MCH_MOD.proxy.registerModelsHeli(this.name, true);
/*    */   }
/*    */   
/*    */   public class Rotor
/*    */     extends MCH_AircraftInfo.DrawnPart
/*    */   {
/*    */     public final int bladeNum;
/*    */     public final int bladeRot;
/*    */     public final boolean haveFoldFunc;
/*    */     public final boolean oldRenderMethod;
/*    */     
/*    */     public Rotor(int b, int br, float x, float y, float z, float rx, float ry, float rz, String model, boolean hf, boolean old) {
/* 95 */       super(MCH_HeliInfo.this, x, y, z, rx, ry, rz, model);
/* 96 */       this.bladeNum = b;
/* 97 */       this.bladeRot = br;
/* 98 */       this.haveFoldFunc = hf;
/* 99 */       this.oldRenderMethod = old;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\helicopter\MCH_HeliInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */