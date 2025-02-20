/*     */ package mcheli;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import mcheli.aircraft.MCH_ItemAircraft;
/*     */ import mcheli.wrapper.W_Item;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class MCH_CreativeTabs
/*     */   extends CreativeTabs
/*     */ {
/*  19 */   private List iconItems = new ArrayList();
/*     */   private Item lastItem;
/*  21 */   private int currentIconIndex = 0;
/*  22 */   private int switchItemWait = 0;
/*  23 */   private Item fixedItem = null;
/*     */ 
/*     */   
/*     */   public MCH_CreativeTabs(String label) {
/*  27 */     super(label);
/*     */   }
/*     */   
/*     */   public void setFixedIconItem(String itemName) {
/*  31 */     if (itemName.indexOf(':') >= 0) {
/*  32 */       this.fixedItem = W_Item.getItemByName(itemName);
/*  33 */       if (this.fixedItem != null) {
/*  34 */         this.fixedItem.func_111206_d(itemName);
/*     */       }
/*     */     } else {
/*  37 */       this.fixedItem = W_Item.getItemByName("mcheli:" + itemName);
/*  38 */       if (this.fixedItem != null) {
/*  39 */         this.fixedItem.func_111206_d("mcheli:" + itemName);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Item func_78016_d() {
/*  46 */     if (this.iconItems.size() <= 0) {
/*  47 */       return null;
/*     */     }
/*  49 */     this.currentIconIndex = (this.currentIconIndex + 1) % this.iconItems.size();
/*  50 */     return this.iconItems.get(this.currentIconIndex);
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_151244_d() {
/*  55 */     if (this.fixedItem != null) {
/*  56 */       return new ItemStack(this.fixedItem, 1, 0);
/*     */     }
/*  58 */     if (this.switchItemWait > 0) {
/*  59 */       this.switchItemWait--;
/*     */     } else {
/*  61 */       this.lastItem = func_78016_d();
/*  62 */       this.switchItemWait = 60;
/*     */     } 
/*     */     
/*  65 */     if (this.lastItem == null) {
/*  66 */       this.lastItem = W_Item.getItemByName("iron_block");
/*     */     }
/*     */     
/*  69 */     return new ItemStack(this.lastItem, 1, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_78018_a(List<ItemStack> list) {
/*  75 */     super.func_78018_a(list);
/*  76 */     Comparator<ItemStack> cmp = new Comparator<ItemStack>() {
/*     */         public int compare(ItemStack i1, ItemStack i2) {
/*  78 */           if (i1.func_77973_b() instanceof MCH_ItemAircraft && i2.func_77973_b() instanceof MCH_ItemAircraft) {
/*  79 */             MCH_AircraftInfo info1 = ((MCH_ItemAircraft)i1.func_77973_b()).getAircraftInfo();
/*  80 */             MCH_AircraftInfo info2 = ((MCH_ItemAircraft)i2.func_77973_b()).getAircraftInfo();
/*  81 */             if (info1 != null && info2 != null) {
/*  82 */               String s1 = info1.category + "." + info1.name;
/*  83 */               String s2 = info2.category + "." + info2.name;
/*  84 */               return s1.compareTo(s2);
/*     */             } 
/*     */           } 
/*     */           
/*  88 */           return i1.func_77973_b().func_77658_a().compareTo(i2.func_77973_b().func_77658_a());
/*     */         }
/*     */       };
/*  91 */     Collections.sort(list, cmp);
/*     */   }
/*     */   
/*     */   public void addIconItem(Item i) {
/*  95 */     if (i != null) {
/*  96 */       this.iconItems.add(i);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_78024_c() {
/* 102 */     return "MC Heli";
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_CreativeTabs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */