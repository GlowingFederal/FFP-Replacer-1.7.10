/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import java.util.Random;
/*     */ import mcheli.wrapper.W_NBTTag;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ public class MCH_AircraftInventory
/*     */   implements IInventory {
/*  16 */   public final int SLOT_FUEL0 = 0;
/*  17 */   public final int SLOT_FUEL1 = 1;
/*  18 */   public final int SLOT_FUEL2 = 2;
/*  19 */   public final int SLOT_PARACHUTE0 = 3;
/*  20 */   public final int SLOT_PARACHUTE1 = 4;
/*  21 */   private ItemStack[] containerItems = new ItemStack[func_70302_i_()];
/*     */   
/*     */   final MCH_EntityAircraft aircraft;
/*     */   
/*     */   public MCH_AircraftInventory(MCH_EntityAircraft ac) {
/*  26 */     this.aircraft = ac;
/*     */   }
/*     */   
/*     */   public ItemStack getFuelSlotItemStack(int i) {
/*  30 */     return func_70301_a(0 + i);
/*     */   }
/*     */   
/*     */   public ItemStack getParachuteSlotItemStack(int i) {
/*  34 */     return func_70301_a(3 + i);
/*     */   }
/*     */   
/*     */   public boolean haveParachute() {
/*  38 */     for (int i = 0; i < 2; i++) {
/*  39 */       ItemStack item = getParachuteSlotItemStack(i);
/*  40 */       if (item != null && item.func_77973_b() instanceof mcheli.parachute.MCH_ItemParachute) {
/*  41 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  45 */     return false;
/*     */   }
/*     */   
/*     */   public void consumeParachute() {
/*  49 */     for (int i = 0; i < 2; i++) {
/*  50 */       ItemStack item = getParachuteSlotItemStack(i);
/*  51 */       if (item != null && item.func_77973_b() instanceof mcheli.parachute.MCH_ItemParachute) {
/*  52 */         func_70299_a(3 + i, (ItemStack)null);
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/*  60 */     return 10;
/*     */   }
/*     */   
/*     */   public ItemStack func_70301_a(int var1) {
/*  64 */     return this.containerItems[var1];
/*     */   }
/*     */   
/*     */   public void setDead() {
/*  68 */     Random rand = new Random();
/*  69 */     if (this.aircraft.dropContentsWhenDead && !this.aircraft.field_70170_p.field_72995_K) {
/*  70 */       for (int i = 0; i < func_70302_i_(); i++) {
/*  71 */         ItemStack itemstack = func_70301_a(i);
/*  72 */         if (itemstack != null) {
/*  73 */           float x = rand.nextFloat() * 0.8F + 0.1F;
/*  74 */           float y = rand.nextFloat() * 0.8F + 0.1F;
/*  75 */           float z = rand.nextFloat() * 0.8F + 0.1F;
/*     */           
/*  77 */           while (itemstack.field_77994_a > 0) {
/*  78 */             int j = rand.nextInt(21) + 10;
/*  79 */             if (j > itemstack.field_77994_a) {
/*  80 */               j = itemstack.field_77994_a;
/*     */             }
/*     */             
/*  83 */             itemstack.field_77994_a -= j;
/*  84 */             EntityItem entityitem = new EntityItem(this.aircraft.field_70170_p, this.aircraft.field_70165_t + x, this.aircraft.field_70163_u + y, this.aircraft.field_70161_v + z, new ItemStack(itemstack.func_77973_b(), j, itemstack.func_77960_j()));
/*  85 */             if (itemstack.func_77942_o()) {
/*  86 */               entityitem.func_92059_d().func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
/*     */             }
/*     */             
/*  89 */             float f3 = 0.05F;
/*  90 */             entityitem.field_70159_w = ((float)rand.nextGaussian() * f3);
/*  91 */             entityitem.field_70181_x = ((float)rand.nextGaussian() * f3 + 0.2F);
/*  92 */             entityitem.field_70179_y = ((float)rand.nextGaussian() * f3);
/*  93 */             this.aircraft.field_70170_p.func_72838_d((Entity)entityitem);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70298_a(int par1, int par2) {
/* 102 */     if (this.containerItems[par1] != null) {
/*     */       
/* 104 */       if ((this.containerItems[par1]).field_77994_a <= par2) {
/* 105 */         ItemStack itemStack = this.containerItems[par1];
/* 106 */         this.containerItems[par1] = null;
/* 107 */         return itemStack;
/*     */       } 
/* 109 */       ItemStack itemstack = this.containerItems[par1].func_77979_a(par2);
/* 110 */       if ((this.containerItems[par1]).field_77994_a == 0) {
/* 111 */         this.containerItems[par1] = null;
/*     */       }
/*     */       
/* 114 */       return itemstack;
/*     */     } 
/*     */     
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_70304_b(int par1) {
/* 122 */     if (this.containerItems[par1] != null) {
/* 123 */       ItemStack itemstack = this.containerItems[par1];
/* 124 */       this.containerItems[par1] = null;
/* 125 */       return itemstack;
/*     */     } 
/* 127 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70299_a(int par1, ItemStack par2ItemStack) {
/* 132 */     this.containerItems[par1] = par2ItemStack;
/* 133 */     if (par2ItemStack != null && par2ItemStack.field_77994_a > func_70297_j_()) {
/* 134 */       par2ItemStack.field_77994_a = func_70297_j_();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_145825_b() {
/* 140 */     return getInvName();
/*     */   }
/*     */   
/*     */   public String getInvName() {
/* 144 */     if (this.aircraft.getAcInfo() == null) {
/* 145 */       return "";
/*     */     }
/* 147 */     String s = (this.aircraft.getAcInfo()).displayName;
/* 148 */     return (s.length() <= 32) ? s : s.substring(0, 31);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInvNameLocalized() {
/* 153 */     return (this.aircraft.getAcInfo() != null);
/*     */   }
/*     */   
/*     */   public boolean func_145818_k_() {
/* 157 */     return isInvNameLocalized();
/*     */   }
/*     */   
/*     */   public int func_70297_j_() {
/* 161 */     return 64;
/*     */   }
/*     */   
/*     */   public void func_70296_d() {}
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer player) {
/* 167 */     return (player.func_70068_e((Entity)this.aircraft) <= 144.0D);
/*     */   }
/*     */   
/*     */   public boolean func_94041_b(int par1, ItemStack par2ItemStack) {
/* 171 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isStackValidForSlot(int par1, ItemStack par2ItemStack) {
/* 175 */     return true;
/*     */   }
/*     */   
/*     */   public void func_70295_k_() {}
/*     */   
/*     */   public void func_70305_f() {}
/*     */   
/*     */   protected void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/* 183 */     NBTTagList nbttaglist = new NBTTagList();
/*     */     
/* 185 */     for (int i = 0; i < this.containerItems.length; i++) {
/* 186 */       if (this.containerItems[i] != null) {
/* 187 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 188 */         nbttagcompound1.func_74774_a("SlotAC", (byte)i);
/* 189 */         this.containerItems[i].func_77955_b(nbttagcompound1);
/* 190 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/*     */     } 
/*     */     
/* 194 */     par1NBTTagCompound.func_74782_a("ItemsAC", (NBTBase)nbttaglist);
/*     */   }
/*     */   
/*     */   protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/* 198 */     NBTTagList nbttaglist = W_NBTTag.getTagList(par1NBTTagCompound, "ItemsAC", 10);
/* 199 */     this.containerItems = new ItemStack[func_70302_i_()];
/*     */     
/* 201 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/* 202 */       NBTTagCompound nbttagcompound1 = W_NBTTag.tagAt(nbttaglist, i);
/* 203 */       int j = nbttagcompound1.func_74771_c("SlotAC") & 0xFF;
/* 204 */       if (j >= 0 && j < this.containerItems.length)
/* 205 */         this.containerItems[j] = ItemStack.func_77949_a(nbttagcompound1); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void onInventoryChanged() {}
/*     */   
/*     */   public void openChest() {}
/*     */   
/*     */   public void closeChest() {}
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_AircraftInventory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */