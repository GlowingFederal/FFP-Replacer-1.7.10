/*     */ package mcheli.hud;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_BaseInfo;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.wrapper.W_ScaledResolution;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ public class MCH_Hud
/*     */   extends MCH_BaseInfo
/*     */ {
/*  15 */   public static final MCH_Hud NoDisp = new MCH_Hud("none", "none");
/*     */   
/*     */   public final String name;
/*     */   public final String fileName;
/*     */   private List list;
/*     */   public boolean isWaitEndif;
/*     */   private boolean isDrawing;
/*     */   public boolean isIfFalse;
/*     */   public boolean exit;
/*     */   
/*     */   public MCH_Hud(String name, String fname) {
/*  26 */     this.name = name;
/*  27 */     this.fileName = fname;
/*  28 */     this.list = new ArrayList();
/*  29 */     this.isDrawing = false;
/*  30 */     this.isIfFalse = false;
/*  31 */     this.exit = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkData() {
/*  36 */     for (MCH_HudItem hud : this.list) hud.parent = this;
/*     */ 
/*     */ 
/*     */     
/*  40 */     if (this.isWaitEndif) {
/*  41 */       throw new RuntimeException("Endif not found!");
/*     */     }
/*     */   }
/*     */   
/*     */   public void loadItemData(int fileLine, String item, String data) {
/*  46 */     String[] prm = data.split("\\s*,\\s*");
/*  47 */     if (prm != null && prm.length != 0) {
/*  48 */       if (item.equalsIgnoreCase("If")) {
/*  49 */         if (this.isWaitEndif) {
/*  50 */           throw new RuntimeException("Endif not found!");
/*     */         }
/*     */         
/*  53 */         this.list.add(new MCH_HudItemConditional(fileLine, false, prm[0]));
/*  54 */         this.isWaitEndif = true;
/*  55 */       } else if (item.equalsIgnoreCase("Endif")) {
/*  56 */         if (!this.isWaitEndif) {
/*  57 */           throw new RuntimeException("IF in a pair can not be found!");
/*     */         }
/*     */         
/*  60 */         this.list.add(new MCH_HudItemConditional(fileLine, true, ""));
/*  61 */         this.isWaitEndif = false;
/*     */       
/*     */       }
/*  64 */       else if (!item.equalsIgnoreCase("DrawString") && !item.equalsIgnoreCase("DrawCenteredString")) {
/*  65 */         if (item.equalsIgnoreCase("Exit")) {
/*  66 */           this.list.add(new MCH_HudItemExit(fileLine));
/*  67 */         } else if (item.equalsIgnoreCase("Color")) {
/*     */           
/*  69 */           if (prm.length == 1) {
/*  70 */             MCH_HudItemColor type1 = MCH_HudItemColor.createByParams(fileLine, new String[] { prm[0] });
/*  71 */             if (type1 != null) {
/*  72 */               this.list.add(type1);
/*     */             }
/*  74 */           } else if (prm.length == 4) {
/*  75 */             String[] s = { prm[0], prm[1], prm[2], prm[3] };
/*  76 */             MCH_HudItemColor type1 = MCH_HudItemColor.createByParams(fileLine, s);
/*  77 */             if (type1 != null) {
/*  78 */               this.list.add(type1);
/*     */             }
/*     */           } 
/*  81 */         } else if (item.equalsIgnoreCase("DrawTexture")) {
/*  82 */           if (prm.length >= 9 && prm.length <= 10) {
/*  83 */             String type = (prm.length == 10) ? prm[9] : "0";
/*  84 */             this.list.add(new MCH_HudItemTexture(fileLine, prm[0], prm[1], prm[2], prm[3], prm[4], prm[5], prm[6], prm[7], prm[8], type));
/*     */           } 
/*  86 */         } else if (item.equalsIgnoreCase("DrawRect")) {
/*  87 */           if (prm.length == 4) {
/*  88 */             this.list.add(new MCH_HudItemRect(fileLine, prm[0], prm[1], prm[2], prm[3]));
/*     */           
/*     */           }
/*     */         }
/*  92 */         else if (item.equalsIgnoreCase("DrawLine")) {
/*  93 */           int type2 = prm.length;
/*  94 */           if (type2 >= 4 && type2 % 2 == 0) {
/*  95 */             this.list.add(new MCH_HudItemLine(fileLine, prm));
/*     */           }
/*  97 */         } else if (item.equalsIgnoreCase("DrawLineStipple")) {
/*  98 */           int type2 = prm.length;
/*  99 */           if (type2 >= 6 && type2 % 2 == 0) {
/* 100 */             this.list.add(new MCH_HudItemLineStipple(fileLine, prm));
/*     */           }
/* 102 */         } else if (item.equalsIgnoreCase("Call")) {
/* 103 */           int type2 = prm.length;
/* 104 */           if (type2 == 1) {
/* 105 */             this.list.add(new MCH_HudItemCall(fileLine, prm[0]));
/*     */           }
/* 107 */         } else if (!item.equalsIgnoreCase("DrawEntityRadar") && !item.equalsIgnoreCase("DrawEnemyRadar")) {
/* 108 */           if (!item.equalsIgnoreCase("DrawGraduationYaw") && !item.equalsIgnoreCase("DrawGraduationPitch1") && !item.equalsIgnoreCase("DrawGraduationPitch2") && !item.equalsIgnoreCase("DrawGraduationPitch3")) {
/* 109 */             if (item.equalsIgnoreCase("DrawCameraRot") && prm.length == 2) {
/* 110 */               this.list.add(new MCH_HudItemCameraRot(fileLine, prm[0], prm[1]));
/*     */             }
/* 112 */           } else if (prm.length == 4) {
/* 113 */             byte type3 = -1;
/* 114 */             if (item.equalsIgnoreCase("DrawGraduationYaw")) {
/* 115 */               type3 = 0;
/*     */             }
/*     */             
/* 118 */             if (item.equalsIgnoreCase("DrawGraduationPitch1")) {
/* 119 */               type3 = 1;
/*     */             }
/*     */             
/* 122 */             if (item.equalsIgnoreCase("DrawGraduationPitch2")) {
/* 123 */               type3 = 2;
/*     */             }
/*     */             
/* 126 */             if (item.equalsIgnoreCase("DrawGraduationPitch3")) {
/* 127 */               type3 = 3;
/*     */             }
/*     */             
/* 130 */             this.list.add(new MCH_HudItemGraduation(fileLine, type3, prm[0], prm[1], prm[2], prm[3]));
/*     */           } 
/* 132 */         } else if (prm.length == 5) {
/* 133 */           this.list.add(new MCH_HudItemRadar(fileLine, item.equalsIgnoreCase("DrawEntityRadar"), prm[0], prm[1], prm[2], prm[3], prm[4]));
/*     */         }
/*     */       
/* 136 */       } else if (prm.length >= 3) {
/* 137 */         String type = prm[2];
/* 138 */         if (type.charAt(0) == '"' && type.charAt(type.length() - 1) == '"') {
/* 139 */           type = type.substring(1, type.length() - 1);
/* 140 */           this.list.add(new MCH_HudItemString(fileLine, prm[0], prm[1], type, prm, item.equalsIgnoreCase("DrawCenteredString")));
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(MCH_EntityAircraft ac, EntityPlayer player, float partialTicks) {
/* 149 */     MCH_HudItem.ac = ac;
/* 150 */     MCH_HudItem.player = player;
/* 151 */     MCH_HudItem.partialTicks = partialTicks;
/* 152 */     W_ScaledResolution scaledresolution = new W_ScaledResolution(MCH_HudItem.mc, MCH_HudItem.mc.field_71443_c, MCH_HudItem.mc.field_71440_d);
/* 153 */     MCH_HudItem.scaleFactor = scaledresolution.func_78325_e();
/* 154 */     if (MCH_HudItem.scaleFactor <= 0) {
/* 155 */       MCH_HudItem.scaleFactor = 1;
/*     */     }
/*     */     
/* 158 */     MCH_HudItem.width = MCH_HudItem.mc.field_71443_c / MCH_HudItem.scaleFactor;
/* 159 */     MCH_HudItem.height = MCH_HudItem.mc.field_71440_d / MCH_HudItem.scaleFactor;
/* 160 */     MCH_HudItem.centerX = MCH_HudItem.width / 2.0D;
/* 161 */     MCH_HudItem.centerY = MCH_HudItem.height / 2.0D;
/* 162 */     this.isIfFalse = false;
/* 163 */     this.isDrawing = false;
/* 164 */     this.exit = false;
/* 165 */     if (ac != null && ac.getAcInfo() != null && player != null) {
/* 166 */       MCH_HudItem.update();
/* 167 */       drawItems();
/* 168 */       MCH_HudItem.drawVarMap();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void drawItems() {
/* 174 */     if (!this.isDrawing) {
/* 175 */       this.isDrawing = true;
/* 176 */       Iterator<MCH_HudItem> i$ = this.list.iterator();
/*     */       
/* 178 */       while (i$.hasNext()) {
/* 179 */         MCH_HudItem hud = i$.next();
/* 180 */         byte line = -1;
/*     */         
/*     */         try {
/* 183 */           int line1 = hud.fileLine;
/* 184 */           if (hud.canExecute()) {
/* 185 */             hud.execute();
/* 186 */             if (this.exit) {
/*     */               break;
/*     */             }
/*     */           } 
/* 190 */         } catch (Exception var5) {
/* 191 */           MCH_Lib.Log("#### Draw HUD Error!!!: line=%d, file=%s", new Object[] { Integer.valueOf(line), this.fileName });
/* 192 */           var5.printStackTrace();
/* 193 */           throw new RuntimeException(var5);
/*     */         } 
/*     */       } 
/*     */       
/* 197 */       this.exit = false;
/* 198 */       this.isIfFalse = false;
/* 199 */       this.isDrawing = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_Hud.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */