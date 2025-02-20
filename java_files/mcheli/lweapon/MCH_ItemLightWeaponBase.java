/*    */ package mcheli.lweapon;
/*    */ 
/*    */ import mcheli.wrapper.W_Item;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.EnumAction;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_ItemLightWeaponBase
/*    */   extends W_Item
/*    */ {
/*    */   public final MCH_ItemLightWeaponBullet bullet;
/*    */   
/*    */   public MCH_ItemLightWeaponBase(int par1, MCH_ItemLightWeaponBullet bullet) {
/* 18 */     super(par1);
/* 19 */     func_77656_e(10);
/* 20 */     func_77625_d(1);
/* 21 */     this.bullet = bullet;
/*    */   }
/*    */   
/*    */   public static String getName(ItemStack itemStack) {
/* 25 */     if (itemStack != null && itemStack.func_77973_b() instanceof MCH_ItemLightWeaponBase) {
/* 26 */       String name = itemStack.func_77977_a();
/* 27 */       int li = name.lastIndexOf(":");
/* 28 */       if (li >= 0) {
/* 29 */         name = name.substring(li + 1);
/*    */       }
/*    */       
/* 32 */       return name;
/*    */     } 
/* 34 */     return "";
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isHeld(EntityPlayer player) {
/* 39 */     ItemStack is = (player != null) ? player.func_70694_bm() : null;
/* 40 */     return (is != null && is.func_77973_b() instanceof MCH_ItemLightWeaponBase) ? ((player.func_71057_bx() > 10)) : false;
/*    */   }
/*    */   
/*    */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
/* 44 */     PotionEffect pe = player.func_70660_b(Potion.field_76439_r);
/* 45 */     if (pe != null && pe.func_76459_b() < 220) {
/* 46 */       player.func_70690_d(new PotionEffect(Potion.field_76439_r.func_76396_c(), 250, 0, false));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public EnumAction func_77661_b(ItemStack par1ItemStack) {
/* 56 */     return EnumAction.bow;
/*    */   }
/*    */   
/*    */   public int func_77626_a(ItemStack par1ItemStack) {
/* 60 */     return 72000;
/*    */   }
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 64 */     if (par1ItemStack != null) {
/* 65 */       par3EntityPlayer.func_71008_a(par1ItemStack, func_77626_a(par1ItemStack));
/*    */     }
/*    */     
/* 68 */     return par1ItemStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\lweapon\MCH_ItemLightWeaponBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */