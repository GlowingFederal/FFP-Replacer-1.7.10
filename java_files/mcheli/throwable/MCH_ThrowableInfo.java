/*     */ package mcheli.throwable;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_BaseInfo;
/*     */ import mcheli.MCH_Color;
/*     */ import mcheli.wrapper.W_Item;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraftforge.client.model.IModelCustom;
/*     */ 
/*     */ 
/*     */ public class MCH_ThrowableInfo
/*     */   extends MCH_BaseInfo
/*     */ {
/*     */   public final String name;
/*     */   public String displayName;
/*     */   public HashMap displayNameLang;
/*     */   public int itemID;
/*     */   public W_Item item;
/*     */   public List recipeString;
/*     */   public List recipe;
/*     */   public boolean isShapedRecipe;
/*     */   public int power;
/*     */   public float acceleration;
/*     */   public float accelerationInWater;
/*     */   public float dispenseAcceleration;
/*     */   public int explosion;
/*     */   public int delayFuse;
/*     */   public float bound;
/*     */   public int timeFuse;
/*     */   public boolean flaming;
/*     */   public int stackSize;
/*     */   public float soundVolume;
/*     */   public float soundPitch;
/*     */   public float proximityFuseDist;
/*     */   public float accuracy;
/*     */   public int aliveTime;
/*     */   public int bomblet;
/*     */   public float bombletDiff;
/*     */   public IModelCustom model;
/*     */   public float smokeSize;
/*     */   public int smokeNum;
/*     */   public float smokeVelocityVertical;
/*     */   public float smokeVelocityHorizontal;
/*     */   public float gravity;
/*     */   public float gravityInWater;
/*     */   public String particleName;
/*     */   public boolean disableSmoke;
/*     */   public MCH_Color smokeColor;
/*     */   
/*     */   public MCH_ThrowableInfo(String name) {
/*  53 */     this.name = name;
/*  54 */     this.displayName = name;
/*  55 */     this.displayNameLang = new HashMap<>();
/*  56 */     this.itemID = 0;
/*  57 */     this.item = null;
/*  58 */     this.recipeString = new ArrayList();
/*  59 */     this.recipe = new ArrayList();
/*  60 */     this.isShapedRecipe = true;
/*  61 */     this.power = 0;
/*  62 */     this.acceleration = 1.0F;
/*  63 */     this.accelerationInWater = 1.0F;
/*  64 */     this.dispenseAcceleration = 1.0F;
/*  65 */     this.explosion = 0;
/*  66 */     this.delayFuse = 0;
/*  67 */     this.bound = 0.2F;
/*  68 */     this.timeFuse = 0;
/*  69 */     this.flaming = false;
/*  70 */     this.stackSize = 1;
/*  71 */     this.soundVolume = 1.0F;
/*  72 */     this.soundPitch = 1.0F;
/*  73 */     this.proximityFuseDist = 0.0F;
/*  74 */     this.accuracy = 0.0F;
/*  75 */     this.aliveTime = 10;
/*  76 */     this.bomblet = 0;
/*  77 */     this.bombletDiff = 0.3F;
/*  78 */     this.model = null;
/*  79 */     this.smokeSize = 10.0F;
/*  80 */     this.smokeNum = 0;
/*  81 */     this.smokeVelocityVertical = 1.0F;
/*  82 */     this.smokeVelocityHorizontal = 1.0F;
/*  83 */     this.gravity = 0.0F;
/*  84 */     this.gravityInWater = -0.04F;
/*  85 */     this.particleName = "explode";
/*  86 */     this.disableSmoke = true;
/*  87 */     this.smokeColor = new MCH_Color();
/*     */   }
/*     */   
/*     */   public void checkData() {
/*  91 */     this.timeFuse *= 20;
/*  92 */     this.aliveTime *= 20;
/*  93 */     this.delayFuse *= 20;
/*     */   }
/*     */   
/*     */   public void loadItemData(String item, String data) {
/*  97 */     if (item.compareTo("displayname") == 0) {
/*  98 */       this.displayName = data;
/*     */     
/*     */     }
/* 101 */     else if (item.compareTo("adddisplayname") == 0) {
/* 102 */       String[] s = data.split("\\s*,\\s*");
/* 103 */       if (s != null && s.length == 2) {
/* 104 */         this.displayNameLang.put(s[0].trim(), s[1].trim());
/*     */       }
/* 106 */     } else if (item.compareTo("itemid") == 0) {
/* 107 */       this.itemID = toInt(data, 0, 65535);
/* 108 */     } else if (item.compareTo("addrecipe") != 0 && item.compareTo("addshapelessrecipe") != 0) {
/* 109 */       if (item.compareTo("power") == 0) {
/* 110 */         this.power = toInt(data);
/* 111 */       } else if (item.compareTo("acceleration") == 0) {
/* 112 */         this.acceleration = toFloat(data, 0.0F, 100.0F);
/* 113 */       } else if (item.compareTo("accelerationinwater") == 0) {
/* 114 */         this.accelerationInWater = toFloat(data, 0.0F, 100.0F);
/* 115 */       } else if (item.equalsIgnoreCase("DispenseAcceleration")) {
/* 116 */         this.dispenseAcceleration = toFloat(data, 0.0F, 1000.0F);
/* 117 */       } else if (item.compareTo("explosion") == 0) {
/* 118 */         this.explosion = toInt(data, 0, 50);
/* 119 */       } else if (item.equalsIgnoreCase("DelayFuse")) {
/* 120 */         this.delayFuse = toInt(data, 0, 100000);
/* 121 */       } else if (item.equalsIgnoreCase("Bound")) {
/* 122 */         this.bound = toFloat(data, 0.0F, 100000.0F);
/* 123 */       } else if (item.equalsIgnoreCase("TimeFuse")) {
/* 124 */         this.timeFuse = toInt(data, 0, 100000);
/* 125 */       } else if (item.compareTo("flaming") == 0) {
/* 126 */         this.flaming = toBool(data);
/* 127 */       } else if (item.equalsIgnoreCase("StackSize")) {
/* 128 */         this.stackSize = toInt(data, 1, 64);
/* 129 */       } else if (item.compareTo("soundvolume") == 0) {
/* 130 */         this.soundVolume = toFloat(data, 0.0F, 1000.0F);
/* 131 */       } else if (item.compareTo("soundpitch") == 0) {
/* 132 */         this.soundPitch = toFloat(data, 0.0F, 1.0F);
/* 133 */       } else if (item.compareTo("proximityfusedist") == 0) {
/* 134 */         this.proximityFuseDist = toFloat(data, 0.0F, 20.0F);
/* 135 */       } else if (item.compareTo("accuracy") == 0) {
/* 136 */         this.accuracy = toFloat(data, 0.0F, 1000.0F);
/* 137 */       } else if (item.equalsIgnoreCase("aliveTime")) {
/* 138 */         this.aliveTime = toInt(data, 0, 1000000);
/* 139 */       } else if (item.compareTo("bomblet") == 0) {
/* 140 */         this.bomblet = toInt(data, 0, 1000);
/* 141 */       } else if (item.equalsIgnoreCase("BombletDiff")) {
/* 142 */         this.bombletDiff = toFloat(data, 0.0F, 1000.0F);
/* 143 */       } else if (item.equalsIgnoreCase("SmokeSize")) {
/* 144 */         this.smokeSize = toFloat(data, 0.0F, 1000.0F);
/* 145 */       } else if (item.equalsIgnoreCase("SmokeNum")) {
/* 146 */         this.smokeNum = toInt(data, 0, 1000);
/* 147 */       } else if (item.equalsIgnoreCase("SmokeVelocityVertical")) {
/* 148 */         this.smokeVelocityVertical = toFloat(data, -100.0F, 100.0F);
/* 149 */       } else if (item.equalsIgnoreCase("SmokeVelocityHorizontal")) {
/* 150 */         this.smokeVelocityHorizontal = toFloat(data, 0.0F, 1000.0F);
/* 151 */       } else if (item.compareTo("gravity") == 0) {
/* 152 */         this.gravity = toFloat(data, -50.0F, 50.0F);
/* 153 */       } else if (item.equalsIgnoreCase("gravityInWater")) {
/* 154 */         this.gravityInWater = toFloat(data, -50.0F, 50.0F);
/* 155 */       } else if (item.compareTo("particle") == 0) {
/* 156 */         this.particleName = data.toLowerCase().trim();
/* 157 */         if (this.particleName.equalsIgnoreCase("none")) {
/* 158 */           this.particleName = "";
/*     */         }
/* 160 */       } else if (item.equalsIgnoreCase("DisableSmoke")) {
/* 161 */         this.disableSmoke = toBool(data);
/* 162 */       } else if (item.equalsIgnoreCase("SmokeColor")) {
/* 163 */         String[] s = data.split("\\s*,\\s*");
/* 164 */         if (s.length >= 3) {
/* 165 */           float f = 0.003921569F;
/* 166 */           this.smokeColor = new MCH_Color(1.0F, 0.003921569F * toInt(s[0], 0, 255), 0.003921569F * toInt(s[1], 0, 255), 0.003921569F * toInt(s[2], 0, 255));
/*     */         } 
/*     */       } 
/*     */     } else {
/* 170 */       this.isShapedRecipe = (item.compareTo("addrecipe") == 0);
/* 171 */       this.recipeString.add(data.toUpperCase());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public class RoundItem
/*     */   {
/*     */     public final int num;
/*     */     
/*     */     public final Item item;
/*     */ 
/*     */     
/*     */     public RoundItem(int n, Item i) {
/* 184 */       this.num = n;
/* 185 */       this.item = i;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\throwable\MCH_ThrowableInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */