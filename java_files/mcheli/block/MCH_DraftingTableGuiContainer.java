/*     */ package mcheli.block;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mcheli.MCH_IRecipeList;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.wrapper.W_Block;
/*     */ import mcheli.wrapper.W_EntityPlayer;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryCraftResult;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ 
/*     */ public class MCH_DraftingTableGuiContainer
/*     */   extends Container
/*     */ {
/*     */   public final EntityPlayer player;
/*     */   public final int posX;
/*     */   public final int posY;
/*     */   public final int posZ;
/*     */   public final int outputSlotIndex;
/*  29 */   private IInventory outputSlot = (IInventory)new InventoryCraftResult();
/*     */ 
/*     */   
/*     */   public MCH_DraftingTableGuiContainer(EntityPlayer player, int posX, int posY, int posZ) {
/*  33 */     this.player = player;
/*  34 */     this.posX = posX;
/*  35 */     this.posY = posY;
/*  36 */     this.posZ = posZ;
/*     */     
/*     */     int a;
/*  39 */     for (a = 0; a < 3; a++) {
/*  40 */       for (int x = 0; x < 9; x++) {
/*  41 */         func_75146_a(new Slot((IInventory)player.field_71071_by, 9 + x + a * 9, 30 + x * 18, 140 + a * 18));
/*     */       }
/*     */     } 
/*     */     
/*  45 */     for (a = 0; a < 9; a++) {
/*  46 */       func_75146_a(new Slot((IInventory)player.field_71071_by, a, 30 + a * 18, 198));
/*     */     }
/*     */     
/*  49 */     this.outputSlotIndex = this.field_75153_a.size();
/*  50 */     Slot var7 = new Slot(this.outputSlot, this.outputSlotIndex, 178, 90) {
/*     */         public boolean func_75214_a(ItemStack par1ItemStack) {
/*  52 */           return false;
/*     */         }
/*     */       };
/*  55 */     func_75146_a(var7);
/*  56 */     MCH_Lib.DbgLog(player.field_70170_p, "MCH_DraftingTableGuiContainer.MCH_DraftingTableGuiContainer", new Object[0]);
/*     */   }
/*     */   
/*     */   public void func_75142_b() {
/*  60 */     super.func_75142_b();
/*     */   }
/*     */   
/*     */   public boolean func_75145_c(EntityPlayer player) {
/*  64 */     Block block = W_WorldFunc.getBlock(player.field_70170_p, this.posX, this.posY, this.posZ);
/*  65 */     return (!W_Block.isEqual(block, (Block)MCH_MOD.blockDraftingTable) && !W_Block.isEqual(block, (Block)MCH_MOD.blockDraftingTableLit)) ? false : ((player.func_70092_e(this.posX, this.posY, this.posZ) <= 144.0D));
/*     */   }
/*     */   
/*     */   public ItemStack func_82846_b(EntityPlayer player, int slotIndex) {
/*  69 */     ItemStack itemstack = null;
/*  70 */     Slot slot = this.field_75151_b.get(slotIndex);
/*  71 */     if (slot != null && slot.func_75216_d()) {
/*  72 */       ItemStack itemstack1 = slot.func_75211_c();
/*  73 */       itemstack = itemstack1.func_77946_l();
/*  74 */       if (slotIndex != this.outputSlotIndex) {
/*  75 */         return null;
/*     */       }
/*     */       
/*  78 */       if (!func_75135_a(itemstack1, 0, 36, true)) {
/*  79 */         return null;
/*     */       }
/*     */       
/*  82 */       slot.func_75220_a(itemstack1, itemstack);
/*  83 */       if (itemstack1.field_77994_a == 0) {
/*  84 */         slot.func_75215_d((ItemStack)null);
/*     */       } else {
/*  86 */         slot.func_75218_e();
/*     */       } 
/*     */       
/*  89 */       if (itemstack1.field_77994_a == itemstack.field_77994_a) {
/*  90 */         return null;
/*     */       }
/*     */       
/*  93 */       slot.func_82870_a(player, itemstack1);
/*     */     } 
/*     */     
/*  96 */     return itemstack;
/*     */   }
/*     */   
/*     */   public void func_75134_a(EntityPlayer player) {
/* 100 */     super.func_75134_a(player);
/* 101 */     if (!player.field_70170_p.field_72995_K) {
/* 102 */       ItemStack itemstack = func_75139_a(this.outputSlotIndex).func_75211_c();
/* 103 */       if (itemstack != null) {
/* 104 */         W_EntityPlayer.dropPlayerItemWithRandomChoice(player, itemstack, false, false);
/*     */       }
/*     */     } 
/*     */     
/* 108 */     MCH_Lib.DbgLog(player.field_70170_p, "MCH_DraftingTableGuiContainer.onContainerClosed", new Object[0]);
/*     */   }
/*     */   
/*     */   public void createRecipeItem(Item outputItem, Map map) {
/* 112 */     boolean isCreativeMode = this.player.field_71075_bZ.field_75098_d;
/* 113 */     if (func_75139_a(this.outputSlotIndex).func_75216_d() && !isCreativeMode) {
/* 114 */       MCH_Lib.DbgLog(this.player.field_70170_p, "MCH_DraftingTableGuiContainer.createRecipeItem:OutputSlot is not empty", new Object[0]);
/* 115 */     } else if (outputItem == null) {
/* 116 */       MCH_Lib.DbgLog(this.player.field_70170_p, "Error:MCH_DraftingTableGuiContainer.createRecipeItem:outputItem = null", new Object[0]);
/* 117 */     } else if (map != null && map.size() > 0) {
/* 118 */       ItemStack itemStack = new ItemStack(outputItem);
/* 119 */       boolean result = false;
/* 120 */       IRecipe recipe = null;
/*     */ 
/*     */ 
/*     */       
/* 124 */       MCH_Lib.DbgLog(this.player.field_70170_p, "MCH_DraftingTableGuiContainer:Result=" + result + ":Recipe=" + recipe + " :" + outputItem.func_77658_a() + ": map=" + map, new Object[0]);
/*     */     } else {
/* 126 */       MCH_Lib.DbgLog(this.player.field_70170_p, "Error:MCH_DraftingTableGuiContainer.createRecipeItem:map is null : " + map, new Object[0]);
/*     */     } 
/*     */   }
/*     */   
/*     */   public IRecipe isValidRecipe(MCH_IRecipeList list, ItemStack itemStack, int startIndex, Map map) {
/* 131 */     for (int index = startIndex; index >= 0 && index < list.getRecipeListSize(); index++) {
/* 132 */       IRecipe recipe = list.getRecipe(index);
/* 133 */       if (!itemStack.func_77969_a(recipe.func_77571_b())) {
/* 134 */         return null;
/*     */       }
/*     */       
/* 137 */       Map mapRecipe = MCH_Lib.getItemMapFromRecipe(recipe);
/* 138 */       boolean isEqual = true;
/* 139 */       Iterator<Item> i$ = map.keySet().iterator();
/*     */       
/* 141 */       while (i$.hasNext()) {
/* 142 */         Item key = i$.next();
/* 143 */         if (!mapRecipe.containsKey(key) || mapRecipe.get(key) != map.get(key)) {
/* 144 */           isEqual = false;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 149 */       if (isEqual) {
/* 150 */         return recipe;
/*     */       }
/*     */     } 
/*     */     
/* 154 */     return null;
/*     */   }
/*     */   
/*     */   public int searchRecipeFromList(MCH_IRecipeList list, ItemStack item) {
/* 158 */     for (int i = 0; i < list.getRecipeListSize(); i++) {
/* 159 */       if (list.getRecipe(i).func_77571_b().func_77969_a(item)) {
/* 160 */         return i;
/*     */       }
/*     */     } 
/*     */     
/* 164 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\block\MCH_DraftingTableGuiContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */