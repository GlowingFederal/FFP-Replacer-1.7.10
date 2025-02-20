/*     */ package mcheli.block;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_IRecipeList;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.MCH_ModelManager;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import mcheli.aircraft.MCH_AircraftInfoManager;
/*     */ import mcheli.plane.MCP_PlaneInfo;
/*     */ import mcheli.weapon.MCH_WeaponInfo;
/*     */ import mcheli.weapon.MCH_WeaponInfoManager;
/*     */ import mcheli.wrapper.modelloader.W_ModelCustom;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_CurrentRecipe
/*     */ {
/*     */   public final IRecipe recipe;
/*     */   public final int index;
/*     */   public final String displayName;
/*     */   public final List descTexture;
/*     */   private final MCH_AircraftInfo acInfo;
/*     */   public List infoItem;
/*     */   public List infoData;
/*     */   private int descMaxPage;
/*     */   private int descPage;
/*     */   private W_ModelCustom model;
/*     */   public int modelRot;
/*     */   private ResourceLocation modelTexture;
/*     */   
/*     */   public MCH_CurrentRecipe(MCH_IRecipeList list, int idx) {
/*  37 */     if (list.getRecipeListSize() > 0) {
/*  38 */       this.recipe = list.getRecipe(idx);
/*     */     } else {
/*  40 */       this.recipe = null;
/*     */     } 
/*     */     
/*  43 */     this.index = idx;
/*  44 */     this.displayName = (this.recipe != null) ? this.recipe.func_77571_b().func_82833_r() : "None";
/*  45 */     this.descTexture = getDescTexture(this.recipe);
/*  46 */     this.descPage = 0;
/*  47 */     this.descMaxPage = this.descTexture.size();
/*  48 */     MCH_AircraftInfo info = null;
/*  49 */     if (list instanceof MCH_AircraftInfoManager) {
/*  50 */       info = ((MCH_AircraftInfoManager)list).getAcInfoFromItem(this.recipe);
/*  51 */       if (info != null) {
/*  52 */         this.descMaxPage++;
/*  53 */         String dir = info.getDirectoryName();
/*  54 */         String name = info.name;
/*  55 */         this.model = MCH_ModelManager.get(dir, name);
/*  56 */         if (this.model != null) {
/*  57 */           this.modelTexture = new ResourceLocation("mcheli", "textures/" + dir + "/" + name + ".png");
/*  58 */           this.descMaxPage++;
/*  59 */           if (list instanceof mcheli.plane.MCP_PlaneInfoManager) {
/*  60 */             this.modelRot = 0;
/*     */           } else {
/*  62 */             this.modelRot = 1;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  68 */     getAcInfoText(info);
/*  69 */     this.acInfo = info;
/*     */   }
/*     */   
/*     */   private void getAcInfoText(MCH_AircraftInfo info) {
/*  73 */     this.infoItem = new ArrayList();
/*  74 */     this.infoData = new ArrayList();
/*  75 */     if (info != null) {
/*  76 */       getAcInfoTextSub("Name", info.getItemStack().func_82833_r());
/*  77 */       getAcInfoTextSub("HP", "" + info.maxHp);
/*  78 */       int seatNum = !info.isUAV ? info.getNumSeat() : (info.getNumSeat() - 1);
/*  79 */       getAcInfoTextSub("Num of Seat", "" + seatNum);
/*  80 */       getAcInfoTextSub("GunnerMode", info.isEnableGunnerMode ? "YES" : "NO");
/*  81 */       getAcInfoTextSub("NightVision", info.isEnableNightVision ? "YES" : "NO");
/*  82 */       getAcInfoTextSub("Radar", info.isEnableEntityRadar ? "YES" : "NO");
/*  83 */       if (info instanceof MCP_PlaneInfo) {
/*  84 */         MCP_PlaneInfo i = (MCP_PlaneInfo)info;
/*  85 */         getAcInfoTextSub("VTOL", i.isEnableVtol ? "YES" : "NO");
/*     */       } 
/*     */       
/*  88 */       if (info.getWeaponNum() > 0) {
/*  89 */         getAcInfoTextSub("Armed----------------");
/*     */         
/*  91 */         for (int var6 = 0; var6 < info.getWeaponNum(); var6++) {
/*  92 */           String type = (info.getWeaponSetById(var6)).type;
/*  93 */           MCH_WeaponInfo winfo = MCH_WeaponInfoManager.get(type);
/*  94 */           if (winfo != null) {
/*  95 */             getAcInfoTextSub(winfo.getWeaponTypeName(), winfo.displayName);
/*     */           } else {
/*  97 */             getAcInfoTextSub("ERROR", "Not found weapon " + (var6 + 1));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void getAcInfoTextSub(String item, String data) {
/* 106 */     this.infoItem.add(item + " :");
/* 107 */     this.infoData.add(data);
/*     */   }
/*     */   
/*     */   private void getAcInfoTextSub(String item) {
/* 111 */     this.infoItem.add(item);
/* 112 */     this.infoData.add("");
/*     */   }
/*     */   
/*     */   public void switchNextPage() {
/* 116 */     if (this.descMaxPage >= 2) {
/* 117 */       this.descPage = (this.descPage + 1) % this.descMaxPage;
/*     */     } else {
/* 119 */       this.descPage = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void switchPrevPage() {
/* 125 */     this.descPage--;
/* 126 */     if (this.descPage < 0 && this.descMaxPage >= 2) {
/* 127 */       this.descPage = this.descMaxPage - 1;
/*     */     } else {
/* 129 */       this.descPage = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDescCurrentPage() {
/* 135 */     return this.descPage;
/*     */   }
/*     */   
/*     */   public void setDescCurrentPage(int page) {
/* 139 */     if (this.descMaxPage > 0) {
/* 140 */       this.descPage = (page < this.descMaxPage) ? page : (this.descMaxPage - 1);
/*     */     } else {
/* 142 */       this.descPage = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDescMaxPage() {
/* 148 */     return this.descMaxPage;
/*     */   }
/*     */   
/*     */   public ResourceLocation getCurrentPageTexture() {
/* 152 */     return (this.descPage < this.descTexture.size()) ? this.descTexture.get(this.descPage) : null;
/*     */   }
/*     */   
/*     */   public W_ModelCustom getModel() {
/* 156 */     return this.model;
/*     */   }
/*     */   
/*     */   public ResourceLocation getModelTexture() {
/* 160 */     return this.modelTexture;
/*     */   }
/*     */   
/*     */   public MCH_AircraftInfo getAcInfo() {
/* 164 */     return this.acInfo;
/*     */   }
/*     */   
/*     */   public boolean isCurrentPageTexture() {
/* 168 */     return (this.descPage >= 0 && this.descPage < this.descTexture.size());
/*     */   }
/*     */   
/*     */   public boolean isCurrentPageModel() {
/* 172 */     return (getAcInfo() != null && getModel() != null && this.descPage == this.descTexture.size());
/*     */   }
/*     */   
/*     */   public boolean isCurrentPageAcInfo() {
/* 176 */     return (getAcInfo() != null && this.descPage == this.descMaxPage - 1);
/*     */   }
/*     */   
/*     */   private List getDescTexture(IRecipe r) {
/* 180 */     ArrayList<ResourceLocation> list = new ArrayList();
/* 181 */     if (r != null) {
/* 182 */       for (int i = 0; i < 20; i++) {
/* 183 */         String itemName = r.func_77571_b().func_77977_a();
/* 184 */         if (itemName.startsWith("tile.")) {
/* 185 */           itemName = itemName.substring(5);
/*     */         }
/*     */         
/* 188 */         if (itemName.indexOf(":") >= 0) {
/* 189 */           itemName = itemName.substring(itemName.indexOf(":") + 1);
/*     */         }
/*     */         
/* 192 */         itemName = "/textures/drafting_table_desc/" + itemName + "#" + i + ".png";
/* 193 */         File filePng = new File(MCH_MOD.sourcePath, "/assets/mcheli/" + itemName);
/* 194 */         if (filePng.exists()) {
/* 195 */           list.add(new ResourceLocation("mcheli", itemName));
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 200 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\block\MCH_CurrentRecipe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */