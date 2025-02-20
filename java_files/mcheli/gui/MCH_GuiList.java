/*     */ package mcheli.gui;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mcheli.wrapper.W_GuiButton;
/*     */ import net.minecraft.client.Minecraft;
/*     */ 
/*     */ 
/*     */ public class MCH_GuiList
/*     */   extends W_GuiButton
/*     */ {
/*     */   public List listItems;
/*     */   public MCH_GuiSliderVertical scrollBar;
/*     */   public final int maxRowNum;
/*     */   public MCH_GuiListItem lastPushItem;
/*     */   
/*     */   public MCH_GuiList(int id, int maxRow, int posX, int posY, int w, int h, String name) {
/*  19 */     super(id, posX, posY, w, h, "");
/*  20 */     this.maxRowNum = (maxRow > 0) ? maxRow : 1;
/*  21 */     this.listItems = new ArrayList();
/*  22 */     this.scrollBar = new MCH_GuiSliderVertical(0, posX + w - 20, posY, 20, h, name, 0.0F, 0.0F, 0.0F, 1.0F);
/*  23 */     this.lastPushItem = null;
/*     */   }
/*     */   
/*     */   public void func_146112_a(Minecraft mc, int x, int y) {
/*  27 */     if (isVisible()) {
/*  28 */       func_73734_a(this.field_146128_h, this.field_146129_i, this.field_146128_h + this.field_146120_f, this.field_146129_i + this.field_146121_g, -2143272896);
/*  29 */       this.scrollBar.func_146112_a(mc, x, y);
/*     */       
/*  31 */       for (int i = 0; i < this.maxRowNum && i + getStartRow() < this.listItems.size(); i++) {
/*  32 */         MCH_GuiListItem item = this.listItems.get(i + getStartRow());
/*  33 */         item.draw(mc, x, y, this.field_146128_h, this.field_146129_i + 5 + 20 * i);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void addItem(MCH_GuiListItem item) {
/*  40 */     this.listItems.add(item);
/*  41 */     int listNum = this.listItems.size();
/*  42 */     this.scrollBar.valueMax = (listNum > this.maxRowNum) ? (listNum - this.maxRowNum) : 0.0F;
/*     */   }
/*     */   
/*     */   public MCH_GuiListItem getItem(int i) {
/*  46 */     return (i < getItemNum()) ? this.listItems.get(i) : null;
/*     */   }
/*     */   
/*     */   public int getItemNum() {
/*  50 */     return this.listItems.size();
/*     */   }
/*     */   
/*     */   public void scrollUp(float a) {
/*  54 */     if (isVisible()) {
/*  55 */       this.scrollBar.scrollUp(a);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void scrollDown(float a) {
/*  61 */     if (isVisible()) {
/*  62 */       this.scrollBar.scrollDown(a);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getStartRow() {
/*  68 */     int startRow = (int)this.scrollBar.getSliderValue();
/*  69 */     return (startRow >= 0) ? startRow : 0;
/*     */   }
/*     */   
/*     */   protected void func_146119_b(Minecraft mc, int x, int y) {
/*  73 */     if (isVisible()) {
/*  74 */       this.scrollBar.func_146119_b(mc, x, y);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_146116_c(Minecraft mc, int x, int y) {
/*  80 */     boolean b = false;
/*  81 */     if (isVisible()) {
/*  82 */       b |= this.scrollBar.func_146116_c(mc, x, y);
/*     */       
/*  84 */       for (int i = 0; i < this.maxRowNum && i + getStartRow() < this.listItems.size(); i++) {
/*  85 */         MCH_GuiListItem item = this.listItems.get(i + getStartRow());
/*  86 */         if (item.mousePressed(mc, x, y)) {
/*  87 */           this.lastPushItem = item;
/*  88 */           b = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     return b;
/*     */   }
/*     */   
/*     */   public void func_146118_a(int x, int y) {
/*  97 */     if (isVisible()) {
/*  98 */       this.scrollBar.func_146118_a(x, y);
/*  99 */       Iterator<MCH_GuiListItem> i$ = this.listItems.iterator();
/*     */       
/* 101 */       while (i$.hasNext()) {
/* 102 */         MCH_GuiListItem item = i$.next();
/* 103 */         item.mouseReleased(x, y);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gui\MCH_GuiList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */