/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.uav.MCH_EntityUavStation;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class MCH_AircraftGuiContainer
/*     */   extends Container
/*     */ {
/*     */   public final EntityPlayer player;
/*     */   public final MCH_EntityAircraft aircraft;
/*     */   
/*     */   public MCH_AircraftGuiContainer(EntityPlayer player, MCH_EntityAircraft ac) {
/*  18 */     this.player = player;
/*  19 */     this.aircraft = ac;
/*  20 */     MCH_AircraftInventory iv = this.aircraft.getGuiInventory();
/*  21 */     iv.getClass();
/*  22 */     func_75146_a(new Slot(iv, 0, 10, 30));
/*  23 */     iv.getClass();
/*  24 */     func_75146_a(new Slot(iv, 1, 10, 48));
/*  25 */     iv.getClass();
/*  26 */     func_75146_a(new Slot(iv, 2, 10, 66));
/*  27 */     int num = this.aircraft.getNumEjectionSeat();
/*  28 */     for (int i = 0; i < num; i++) {
/*  29 */       iv.getClass();
/*  30 */       func_75146_a(new Slot(iv, 3 + i, 10 + 18 * i, 105));
/*     */     } 
/*  32 */     for (int y = 0; y < 3; y++) {
/*  33 */       for (int j = 0; j < 9; j++) {
/*  34 */         func_75146_a(new Slot((IInventory)player.field_71071_by, 9 + j + y * 9, 25 + j * 18, 135 + y * 18));
/*     */       }
/*     */     } 
/*  37 */     for (int x = 0; x < 9; x++) {
/*  38 */       func_75146_a(new Slot((IInventory)player.field_71071_by, x, 25 + x * 18, 195));
/*     */     }
/*     */   }
/*     */   
/*     */   public int getInventoryStartIndex() {
/*  43 */     if (this.aircraft == null) {
/*  44 */       return 3;
/*     */     }
/*  46 */     return 3 + this.aircraft.getNumEjectionSeat();
/*     */   }
/*     */   
/*     */   public void func_75142_b() {
/*  50 */     super.func_75142_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer player) {
/*  55 */     if (this.aircraft.getGuiInventory().func_70300_a(player))
/*  56 */       return true; 
/*     */     MCH_EntityUavStation us;
/*  58 */     if (this.aircraft.isUAV() && (us = this.aircraft.getUavStation()) != null) {
/*  59 */       double x = us.field_70165_t + us.posUavX;
/*  60 */       double z = us.field_70161_v + us.posUavZ;
/*  61 */       if (this.aircraft.field_70165_t < x + 10.0D && this.aircraft.field_70165_t > x - 10.0D && this.aircraft.field_70161_v < z + 10.0D && this.aircraft.field_70161_v > z - 10.0D) {
/*  62 */         return true;
/*     */       }
/*     */     } 
/*  65 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int slotIndex) {
/*  75 */     MCH_AircraftInventory iv = this.aircraft.getGuiInventory();
/*  76 */     Slot slot = this.field_75151_b.get(slotIndex);
/*  77 */     if (slot == null) {
/*  78 */       return null;
/*     */     }
/*  80 */     ItemStack itemStack = slot.func_75211_c();
/*  81 */     MCH_Lib.DbgLog(player.field_70170_p, "transferStackInSlot : %d :" + itemStack, new Object[] { Integer.valueOf(slotIndex) });
/*  82 */     if (itemStack == null) {
/*  83 */       return null;
/*     */     }
/*  85 */     if (slotIndex >= getInventoryStartIndex())
/*     */     
/*     */     { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  95 */       if (!(itemStack.func_77973_b() instanceof MCH_ItemFuel))
/*     */       
/*     */       { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 105 */         if (itemStack.func_77973_b() instanceof mcheli.parachute.MCH_ItemParachute) {
/* 106 */           int num = this.aircraft.getNumEjectionSeat();
/* 107 */           for (int k = 0; k < num; ) {
/* 108 */             if (iv.getParachuteSlotItemStack(k) != null) { k++; continue; }
/* 109 */              iv.getClass();
/* 110 */             iv.func_70299_a(3 + k, itemStack);
/* 111 */             slot.func_75215_d(null);
/* 112 */             return itemStack;
/*     */           } 
/*     */         } 
/* 115 */         return null; }  for (int j = 0; j < 3; ) { if (iv.getFuelSlotItemStack(j) != null) { j++; continue; }  iv.getClass(); iv.func_70299_a(0 + j, itemStack); slot.func_75215_d(null); return itemStack; }  return null; }  for (int i = getInventoryStartIndex(); i < this.field_75151_b.size(); ) { Slot playerSlot = this.field_75151_b.get(i); if (playerSlot.func_75211_c() != null) { i++; continue; }  playerSlot.func_75215_d(itemStack); slot.func_75215_d(null); return itemStack; }  return null;
/*     */   }
/*     */   
/*     */   public void func_75134_a(EntityPlayer player) {
/* 119 */     super.func_75134_a(player);
/* 120 */     if (!player.field_70170_p.field_72995_K) {
/*     */ 
/*     */       
/* 123 */       MCH_AircraftInventory iv = this.aircraft.getGuiInventory(); int i;
/* 124 */       for (i = 0; i < 3; i++) {
/* 125 */         ItemStack is = iv.getFuelSlotItemStack(i);
/* 126 */         if (is != null && !(is.func_77973_b() instanceof MCH_ItemFuel)) {
/* 127 */           iv.getClass();
/* 128 */           dropPlayerItem(player, 0 + i);
/*     */         } 
/* 130 */       }  for (i = 0; i < 2; i++) {
/* 131 */         ItemStack is = iv.getParachuteSlotItemStack(i);
/* 132 */         if (is != null && !(is.func_77973_b() instanceof mcheli.parachute.MCH_ItemParachute)) {
/* 133 */           iv.getClass();
/* 134 */           dropPlayerItem(player, 3 + i);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void dropPlayerItem(EntityPlayer player, int slotID) {
/*     */     ItemStack itemstack;
/* 141 */     if (!player.field_70170_p.field_72995_K && (itemstack = this.aircraft.getGuiInventory().func_70304_b(slotID)) != null)
/* 142 */       player.func_71019_a(itemstack, false); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_AircraftGuiContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */