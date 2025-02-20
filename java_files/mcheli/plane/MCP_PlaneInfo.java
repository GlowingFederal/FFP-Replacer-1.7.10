/*     */ package mcheli.plane;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import net.minecraft.item.Item;
/*     */ 
/*     */ public class MCP_PlaneInfo
/*     */   extends MCH_AircraftInfo
/*     */ {
/*  13 */   public MCP_ItemPlane item = null;
/*  14 */   public List nozzles = new ArrayList();
/*  15 */   public List rotorList = new ArrayList();
/*  16 */   public List wingList = new ArrayList();
/*     */   public boolean isEnableVtol = false;
/*     */   public boolean isDefaultVtol;
/*  19 */   public float vtolYaw = 0.3F;
/*  20 */   public float vtolPitch = 0.2F;
/*     */   
/*     */   public boolean isEnableAutoPilot = false;
/*     */   public boolean isVariableSweepWing = false;
/*     */   public float sweepWingSpeed;
/*     */   
/*     */   public Item getItem() {
/*  27 */     return (Item)this.item;
/*     */   }
/*     */   
/*     */   public MCP_PlaneInfo(String name) {
/*  31 */     super(name);
/*  32 */     this.sweepWingSpeed = this.speed;
/*     */   }
/*     */   
/*     */   public float getDefaultRotorSpeed() {
/*  36 */     return 47.94F;
/*     */   }
/*     */   
/*     */   private float getDefaultStepHeight() {
/*  40 */     return 0.6F;
/*     */   }
/*     */   
/*     */   public boolean haveNozzle() {
/*  44 */     return (this.nozzles.size() > 0);
/*     */   }
/*     */   
/*     */   public boolean haveRotor() {
/*  48 */     return (this.rotorList.size() > 0);
/*     */   }
/*     */   
/*     */   public boolean haveWing() {
/*  52 */     return (this.wingList.size() > 0);
/*     */   }
/*     */   
/*     */   public float getMaxSpeed() {
/*  56 */     return 1.8F;
/*     */   }
/*     */   
/*     */   public int getDefaultMaxZoom() {
/*  60 */     return 8;
/*     */   }
/*     */   
/*     */   public String getDefaultHudName(int seatId) {
/*  64 */     return (seatId <= 0) ? "plane" : ((seatId == 1) ? "plane" : "gunner");
/*     */   }
/*     */   
/*     */   public boolean isValidData() throws Exception {
/*  68 */     if (haveHatch() && haveWing()) {
/*  69 */       this.wingList.clear();
/*  70 */       this.hatchList.clear();
/*     */     } 
/*     */     
/*  73 */     double var10001 = this.speed;
/*  74 */     MCH_Config var10002 = MCH_MOD.config;
/*  75 */     this.speed = (float)(var10001 * MCH_Config.AllPlaneSpeed.prmDouble);
/*  76 */     var10001 = this.sweepWingSpeed;
/*  77 */     var10002 = MCH_MOD.config;
/*  78 */     this.sweepWingSpeed = (float)(var10001 * MCH_Config.AllPlaneSpeed.prmDouble);
/*  79 */     return super.isValidData();
/*     */   }
/*     */   
/*     */   public void loadItemData(String item, String data) {
/*  83 */     super.loadItemData(item, data);
/*     */     
/*  85 */     if (item.compareTo("addpartrotor") == 0) {
/*  86 */       String[] s = data.split("\\s*,\\s*");
/*  87 */       if (s.length >= 6) {
/*  88 */         float n = (s.length >= 7) ? (toFloat(s[6], -180.0F, 180.0F) / 90.0F) : 1.0F;
/*  89 */         Rotor n1 = new Rotor(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), n, "rotor" + this.rotorList.size());
/*  90 */         this.rotorList.add(n1);
/*     */       } 
/*  92 */     } else if (item.compareTo("addblade") == 0) {
/*  93 */       int s1 = this.rotorList.size() - 1;
/*  94 */       Rotor n2 = (this.rotorList.size() > 0) ? this.rotorList.get(s1) : null;
/*  95 */       if (n2 != null) {
/*  96 */         String[] n4 = data.split("\\s*,\\s*");
/*  97 */         if (n4.length == 8) {
/*  98 */           Blade b = new Blade(toInt(n4[0]), toInt(n4[1]), toFloat(n4[2]), toFloat(n4[3]), toFloat(n4[4]), toFloat(n4[5]), toFloat(n4[6]), toFloat(n4[7]), "blade" + s1);
/*  99 */           n2.blades.add(b);
/*     */         }
/*     */       
/*     */       }
/*     */     
/* 104 */     } else if (item.compareTo("addpartwing") == 0) {
/* 105 */       String[] s = data.split("\\s*,\\s*");
/* 106 */       if (s.length == 7) {
/* 107 */         Wing n3 = new Wing(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), toFloat(s[6]), "wing" + this.wingList.size());
/* 108 */         this.wingList.add(n3);
/*     */       } 
/* 110 */     } else if (item.equalsIgnoreCase("AddPartPylon")) {
/* 111 */       String[] s = data.split("\\s*,\\s*");
/* 112 */       if (s.length >= 7 && this.wingList.size() > 0) {
/* 113 */         Wing n3 = this.wingList.get(this.wingList.size() - 1);
/* 114 */         if (n3.pylonList == null) {
/* 115 */           n3.pylonList = new ArrayList();
/*     */         }
/*     */         
/* 118 */         Pylon n6 = new Pylon(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), toFloat(s[6]), n3.modelName + "_pylon" + n3.pylonList.size());
/* 119 */         n3.pylonList.add(n6);
/*     */       } 
/* 121 */     } else if (item.compareTo("addpartnozzle") == 0) {
/* 122 */       String[] s = data.split("\\s*,\\s*");
/* 123 */       if (s.length == 6) {
/* 124 */         MCH_AircraftInfo.DrawnPart n5 = new MCH_AircraftInfo.DrawnPart(this, toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), "nozzle" + this.nozzles.size());
/* 125 */         this.nozzles.add(n5);
/*     */       } 
/* 127 */     } else if (item.compareTo("variablesweepwing") == 0) {
/* 128 */       this.isVariableSweepWing = toBool(data);
/* 129 */     } else if (item.compareTo("sweepwingspeed") == 0) {
/* 130 */       this.sweepWingSpeed = toFloat(data, 0.0F, 5.0F);
/* 131 */     } else if (item.compareTo("enablevtol") == 0) {
/* 132 */       this.isEnableVtol = toBool(data);
/* 133 */     } else if (item.compareTo("defaultvtol") == 0) {
/* 134 */       this.isDefaultVtol = toBool(data);
/* 135 */     } else if (item.compareTo("vtolyaw") == 0) {
/* 136 */       this.vtolYaw = toFloat(data, 0.0F, 1.0F);
/* 137 */     } else if (item.compareTo("vtolpitch") == 0) {
/* 138 */       this.vtolPitch = toFloat(data, 0.01F, 1.0F);
/* 139 */     } else if (item.compareTo("enableautopilot") == 0) {
/* 140 */       this.isEnableAutoPilot = toBool(data);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDirectoryName() {
/* 147 */     return "planes";
/*     */   }
/*     */   
/*     */   public String getKindName() {
/* 151 */     return "plane";
/*     */   }
/*     */   
/*     */   public void preReload() {
/* 155 */     super.preReload();
/* 156 */     this.nozzles.clear();
/* 157 */     this.rotorList.clear();
/* 158 */     this.wingList.clear();
/*     */   }
/*     */   
/*     */   public void postReload() {
/* 162 */     MCH_MOD.proxy.registerModelsPlane(this.name, true);
/*     */   }
/*     */   
/*     */   public class Rotor
/*     */     extends MCH_AircraftInfo.DrawnPart {
/* 167 */     public List blades = new ArrayList();
/*     */     
/*     */     public final float maxRotFactor;
/*     */     
/*     */     public Rotor(float x, float y, float z, float rx, float ry, float rz, float mrf, String model) {
/* 172 */       super(MCP_PlaneInfo.this, x, y, z, rx, ry, rz, model);
/* 173 */       this.maxRotFactor = mrf;
/*     */     }
/*     */   }
/*     */   
/*     */   public class Pylon
/*     */     extends MCH_AircraftInfo.DrawnPart
/*     */   {
/*     */     public final float maxRotFactor;
/*     */     public final float maxRot;
/*     */     
/*     */     public Pylon(float px, float py, float pz, float rx, float ry, float rz, float mr, String name) {
/* 184 */       super(MCP_PlaneInfo.this, px, py, pz, rx, ry, rz, name);
/* 185 */       this.maxRot = mr;
/* 186 */       this.maxRotFactor = this.maxRot / 90.0F;
/*     */     }
/*     */   }
/*     */   
/*     */   public class Blade
/*     */     extends MCH_AircraftInfo.DrawnPart
/*     */   {
/*     */     public final int numBlade;
/*     */     public final int rotBlade;
/*     */     
/*     */     public Blade(int num, int r, float px, float py, float pz, float rx, float ry, float rz, String name) {
/* 197 */       super(MCP_PlaneInfo.this, px, py, pz, rx, ry, rz, name);
/* 198 */       this.numBlade = num;
/* 199 */       this.rotBlade = r;
/*     */     }
/*     */   }
/*     */   
/*     */   public class Wing
/*     */     extends MCH_AircraftInfo.DrawnPart
/*     */   {
/*     */     public final float maxRotFactor;
/*     */     public final float maxRot;
/*     */     public List pylonList;
/*     */     
/*     */     public Wing(float px, float py, float pz, float rx, float ry, float rz, float mr, String name) {
/* 211 */       super(MCP_PlaneInfo.this, px, py, pz, rx, ry, rz, name);
/* 212 */       this.maxRot = mr;
/* 213 */       this.maxRotFactor = this.maxRot / 90.0F;
/* 214 */       this.pylonList = null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\plane\MCP_PlaneInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */