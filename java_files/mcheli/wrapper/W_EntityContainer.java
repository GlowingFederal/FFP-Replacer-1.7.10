/*     */ package mcheli.wrapper;
/*     */ 
/*     */ import mcheli.MCH_Lib;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class W_EntityContainer
/*     */   extends W_Entity
/*     */   implements IInventory
/*     */ {
/*     */   public static final int MAX_INVENTORY_SIZE = 54;
/*  33 */   private ItemStack[] containerItems = new ItemStack[54];
/*     */   public boolean dropContentsWhenDead = true;
/*     */   
/*     */   public W_EntityContainer(World par1World) {
/*  37 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */ 
/*     */   
/*     */   public ItemStack func_70301_a(int par1) {
/*  45 */     return this.containerItems[par1];
/*     */   }
/*     */   
/*     */   public int getUsingSlotNum() {
/*  49 */     int numUsingSlot = 0;
/*  50 */     if (this.containerItems == null) {
/*  51 */       numUsingSlot = 0;
/*     */     } else {
/*  53 */       int n = func_70302_i_();
/*  54 */       numUsingSlot = 0;
/*  55 */       for (int i = 0; i < n && i < this.containerItems.length; i++) {
/*  56 */         if (func_70301_a(i) != null)
/*  57 */           numUsingSlot++; 
/*     */       } 
/*     */     } 
/*  60 */     return numUsingSlot;
/*     */   }
/*     */   
/*     */   public ItemStack func_70298_a(int par1, int par2) {
/*  64 */     if (this.containerItems[par1] != null) {
/*  65 */       if ((this.containerItems[par1]).field_77994_a <= par2) {
/*  66 */         ItemStack itemStack = this.containerItems[par1];
/*  67 */         this.containerItems[par1] = null;
/*  68 */         return itemStack;
/*     */       } 
/*  70 */       ItemStack itemstack = this.containerItems[par1].func_77979_a(par2);
/*  71 */       if ((this.containerItems[par1]).field_77994_a == 0) {
/*  72 */         this.containerItems[par1] = null;
/*     */       }
/*  74 */       return itemstack;
/*     */     } 
/*  76 */     return null;
/*     */   }
/*     */   
/*     */   public ItemStack func_70304_b(int par1) {
/*  80 */     if (this.containerItems[par1] != null) {
/*  81 */       ItemStack itemstack = this.containerItems[par1];
/*  82 */       this.containerItems[par1] = null;
/*  83 */       return itemstack;
/*     */     } 
/*  85 */     return null;
/*     */   }
/*     */   
/*     */   public void func_70299_a(int par1, ItemStack par2ItemStack) {
/*  89 */     this.containerItems[par1] = par2ItemStack;
/*  90 */     if (par2ItemStack != null && par2ItemStack.field_77994_a > func_70297_j_()) {
/*  91 */       par2ItemStack.field_77994_a = func_70297_j_();
/*     */     }
/*  93 */     func_70296_d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onInventoryChanged() {}
/*     */   
/*     */   public boolean func_70300_a(EntityPlayer par1EntityPlayer) {
/* 100 */     return this.field_70128_L ? false : ((par1EntityPlayer.func_70068_e(this) <= 64.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public void openChest() {}
/*     */ 
/*     */   
/*     */   public void closeChest() {}
/*     */   
/*     */   public boolean func_94041_b(int par1, ItemStack par2ItemStack) {
/* 110 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isStackValidForSlot(int par1, ItemStack par2ItemStack) {
/* 114 */     return true;
/*     */   }
/*     */   
/*     */   public String getInvName() {
/* 118 */     return "Inventory";
/*     */   }
/*     */   
/*     */   public String func_145825_b() {
/* 122 */     return getInvName();
/*     */   }
/*     */   
/*     */   public boolean isInvNameLocalized() {
/* 126 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_145818_k_() {
/* 130 */     return isInvNameLocalized();
/*     */   }
/*     */   
/*     */   public int func_70297_j_() {
/* 134 */     return 64;
/*     */   }
/*     */   
/*     */   public void func_70106_y() {
/* 138 */     if (this.dropContentsWhenDead && !this.field_70170_p.field_72995_K)
/* 139 */       for (int i = 0; i < func_70302_i_(); i++) {
/* 140 */         ItemStack itemstack = func_70301_a(i);
/* 141 */         if (itemstack != null) {
/* 142 */           float x = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
/* 143 */           float y = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
/* 144 */           float z = this.field_70146_Z.nextFloat() * 0.8F + 0.1F;
/* 145 */           while (itemstack.field_77994_a > 0) {
/* 146 */             int j = this.field_70146_Z.nextInt(21) + 10;
/* 147 */             if (j > itemstack.field_77994_a) {
/* 148 */               j = itemstack.field_77994_a;
/*     */             }
/* 150 */             itemstack.field_77994_a -= j;
/* 151 */             EntityItem entityitem = new EntityItem(this.field_70170_p, this.field_70165_t + x, this.field_70163_u + y, this.field_70161_v + z, new ItemStack(itemstack.func_77973_b(), j, itemstack.func_77960_j()));
/* 152 */             if (itemstack.func_77942_o()) {
/* 153 */               entityitem.func_92059_d().func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
/*     */             }
/* 155 */             float f3 = 0.05F;
/* 156 */             entityitem.field_70159_w = ((float)this.field_70146_Z.nextGaussian() * f3);
/* 157 */             entityitem.field_70181_x = ((float)this.field_70146_Z.nextGaussian() * f3 + 0.2F);
/* 158 */             entityitem.field_70179_y = ((float)this.field_70146_Z.nextGaussian() * f3);
/* 159 */             this.field_70170_p.func_72838_d((Entity)entityitem);
/*     */           } 
/*     */         } 
/*     */       }  
/* 163 */     super.func_70106_y();
/*     */   }
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 167 */     NBTTagList nbttaglist = new NBTTagList();
/* 168 */     for (int i = 0; i < this.containerItems.length; i++) {
/* 169 */       if (this.containerItems[i] != null) {
/* 170 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 171 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 172 */         this.containerItems[i].func_77955_b(nbttagcompound1);
/* 173 */         nbttaglist.func_74742_a((NBTBase)nbttagcompound1);
/*     */       } 
/* 175 */     }  par1NBTTagCompound.func_74782_a("Items", (NBTBase)nbttaglist);
/*     */   }
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 179 */     NBTTagList nbttaglist = W_NBTTag.getTagList(par1NBTTagCompound, "Items", 10);
/* 180 */     this.containerItems = new ItemStack[func_70302_i_()];
/* 181 */     MCH_Lib.DbgLog(this.field_70170_p, "W_EntityContainer.readEntityFromNBT.InventorySize = %d", new Object[] { Integer.valueOf(func_70302_i_()) });
/* 182 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/* 183 */       NBTTagCompound nbttagcompound1 = W_NBTTag.tagAt(nbttaglist, i);
/* 184 */       int j = nbttagcompound1.func_74771_c("Slot") & 0xFF;
/* 185 */       if (j >= 0 && j < this.containerItems.length)
/* 186 */         this.containerItems[j] = ItemStack.func_77949_a(nbttagcompound1); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_71027_c(int par1) {
/* 191 */     this.dropContentsWhenDead = false;
/* 192 */     super.func_71027_c(par1);
/*     */   }
/*     */   
/*     */   public boolean openInventory(EntityPlayer player) {
/* 196 */     if (!this.field_70170_p.field_72995_K && func_70302_i_() > 0) {
/* 197 */       player.func_71007_a(this);
/* 198 */       return true;
/*     */     } 
/* 200 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70295_k_() {}
/*     */ 
/*     */   
/*     */   public void func_70305_f() {}
/*     */ 
/*     */   
/*     */   public void func_70296_d() {}
/*     */   
/*     */   public int func_70302_i_() {
/* 213 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_EntityContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */