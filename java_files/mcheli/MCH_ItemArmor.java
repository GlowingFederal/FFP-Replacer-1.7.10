/*    */ package mcheli;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.wrapper.W_ItemArmor;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class MCH_ItemArmor
/*    */   extends W_ItemArmor {
/*    */   public static final String HELMET_TEXTURE = "mcheli:textures/helicopters/ah-64.png";
/*    */   public static final String CHESTPLATE_TEXTURE = "mcheli:textures/armor/plate.png";
/*    */   public static final String LEGGINGS_TEXTURE = "mcheli:textures/armor/leg.png";
/*    */   public static final String BOOTS_TEXTURE = "mcheli:textures/armor/boots.png";
/* 17 */   public static MCH_TEST_ModelBiped model = null;
/*    */ 
/*    */   
/*    */   public MCH_ItemArmor(int par1, int par3, int par4) {
/* 21 */     super(par1, par3, par4);
/*    */   }
/*    */   
/*    */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
/* 25 */     return (slot == 0) ? "mcheli:textures/helicopters/ah-64.png" : ((slot == 1) ? "mcheli:textures/armor/plate.png" : ((slot == 2) ? "mcheli:textures/armor/leg.png" : ((slot == 3) ? "mcheli:textures/armor/boots.png" : "none")));
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
/* 30 */     if (model == null) {
/* 31 */       model = new MCH_TEST_ModelBiped();
/*    */     }
/*    */     
/* 34 */     return (armorSlot == 0) ? model : null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_ItemArmor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */