/*     */ package mcheli.tool.rangefinder;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.multiplay.MCH_PacketIndSpotEntity;
/*     */ import mcheli.wrapper.W_Item;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_Reflection;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_ItemRangeFinder extends W_Item {
/*  18 */   public static int rangeFinderUseCooldown = 0;
/*     */   public static boolean continueUsingItem = false;
/*  20 */   public static float zoom = 2.0F;
/*  21 */   public static int mode = 0;
/*     */ 
/*     */   
/*     */   public MCH_ItemRangeFinder(int itemId) {
/*  25 */     super(itemId);
/*  26 */     this.field_77777_bU = 1;
/*  27 */     func_77656_e(10);
/*     */   }
/*     */   
/*     */   public static boolean canUse(EntityPlayer player) {
/*  31 */     if (player == null)
/*  32 */       return false; 
/*  33 */     if (player.field_70170_p == null)
/*  34 */       return false; 
/*  35 */     if (player.func_71045_bC() == null)
/*  36 */       return false; 
/*  37 */     if (!(player.func_71045_bC().func_77973_b() instanceof MCH_ItemRangeFinder))
/*  38 */       return false; 
/*  39 */     if (player.field_70154_o instanceof MCH_EntityAircraft) {
/*  40 */       return false;
/*     */     }
/*  42 */     if (player.field_70154_o instanceof MCH_EntitySeat) {
/*  43 */       MCH_EntityAircraft ac = ((MCH_EntitySeat)player.field_70154_o).getParent();
/*  44 */       if (ac != null && (ac.getIsGunnerMode((Entity)player) || ac.getWeaponIDBySeatID(ac.getSeatIdByEntity((Entity)player)) >= 0)) {
/*  45 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  49 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isUsingScope(EntityPlayer player) {
/*  54 */     return (player.func_71057_bx() > 8 || continueUsingItem);
/*     */   }
/*     */   
/*     */   public static void onStartUseItem() {
/*  58 */     zoom = 2.0F;
/*  59 */     W_Reflection.setCameraZoom(2.0F);
/*  60 */     continueUsingItem = true;
/*     */   }
/*     */   
/*     */   public static void onStopUseItem() {
/*  64 */     W_Reflection.restoreCameraZoom();
/*  65 */     continueUsingItem = false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void spotEntity(EntityPlayer player, ItemStack itemStack) {
/*  70 */     if (player != null && player.field_70170_p.field_72995_K && rangeFinderUseCooldown == 0 && player.func_71057_bx() > 8) {
/*  71 */       if (mode == 2) {
/*  72 */         rangeFinderUseCooldown = 60;
/*  73 */         MCH_PacketIndSpotEntity.send((EntityLivingBase)player, 0);
/*  74 */       } else if (itemStack.func_77960_j() < itemStack.func_77958_k()) {
/*  75 */         rangeFinderUseCooldown = 60;
/*  76 */         MCH_PacketIndSpotEntity.send((EntityLivingBase)player, (mode == 0) ? 60 : 3);
/*     */       } else {
/*  78 */         W_McClient.MOD_playSoundFX("ng", 1.0F, 1.0F);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_77615_a(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_) {
/*  85 */     if (p_77615_2_.field_72995_K) {
/*  86 */       onStopUseItem();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
/*  92 */     return p_77654_1_;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77662_d() {
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack itemStack) {
/* 101 */     return EnumAction.bow;
/*     */   }
/*     */   
/*     */   public int func_77626_a(ItemStack itemStack) {
/* 105 */     return 72000;
/*     */   }
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack itemStack, World world, EntityPlayer player) {
/* 109 */     if (canUse(player)) {
/* 110 */       player.func_71008_a(itemStack, func_77626_a(itemStack));
/*     */     }
/*     */     
/* 113 */     return itemStack;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tool\rangefinder\MCH_ItemRangeFinder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */