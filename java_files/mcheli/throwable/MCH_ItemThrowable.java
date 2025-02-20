/*    */ package mcheli.throwable;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.wrapper.W_Item;
/*    */ import net.minecraft.block.BlockDispenser;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.EnumAction;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_ItemThrowable extends W_Item {
/*    */   public MCH_ItemThrowable(int par1) {
/* 15 */     super(par1);
/* 16 */     func_77625_d(1);
/*    */   }
/*    */   
/*    */   public static void registerDispenseBehavior(Item item) {
/* 20 */     BlockDispenser.field_149943_a.func_82595_a(item, new MCH_ItemThrowableDispenseBehavior());
/*    */   }
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack itemStack, World world, EntityPlayer player) {
/* 24 */     player.func_71008_a(itemStack, func_77626_a(itemStack));
/* 25 */     return itemStack;
/*    */   }
/*    */   
/*    */   public void func_77615_a(ItemStack itemStack, World world, EntityPlayer player, int par4) {
/* 29 */     if (itemStack != null && itemStack.field_77994_a > 0) {
/* 30 */       MCH_ThrowableInfo info = MCH_ThrowableInfoManager.get(itemStack.func_77973_b());
/* 31 */       if (info != null) {
/* 32 */         if (!player.field_71075_bZ.field_75098_d) {
/* 33 */           itemStack.field_77994_a--;
/* 34 */           if (itemStack.field_77994_a <= 0) {
/* 35 */             player.field_71071_by.field_70462_a[player.field_71071_by.field_70461_c] = null;
/*    */           }
/*    */         } 
/*    */         
/* 39 */         world.func_72956_a((Entity)player, "random.bow", 0.5F, 0.4F / (Item.field_77697_d.nextFloat() * 0.4F + 0.8F));
/* 40 */         if (!world.field_72995_K) {
/* 41 */           float acceleration = 1.0F;
/* 42 */           par4 = itemStack.func_77988_m() - par4;
/* 43 */           if (par4 <= 35) {
/* 44 */             if (par4 < 5) {
/* 45 */               par4 = 5;
/*    */             }
/*    */             
/* 48 */             acceleration = par4 / 25.0F;
/*    */           } 
/*    */           
/* 51 */           MCH_Lib.DbgLog(world, "MCH_ItemThrowable.onPlayerStoppedUsing(%d)", new Object[] { Integer.valueOf(par4) });
/* 52 */           MCH_EntityThrowable entity = new MCH_EntityThrowable(world, (EntityLivingBase)player, acceleration);
/* 53 */           entity.setInfo(info);
/* 54 */           world.func_72838_d((Entity)entity);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77626_a(ItemStack par1ItemStack) {
/* 62 */     return 72000;
/*    */   }
/*    */   
/*    */   public EnumAction func_77661_b(ItemStack par1ItemStack) {
/* 66 */     return EnumAction.bow;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\throwable\MCH_ItemThrowable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */