/*    */ package mcheli.parachute;
/*    */ 
/*    */ import mcheli.wrapper.W_Item;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_ItemParachute extends W_Item {
/*    */   public MCH_ItemParachute(int par1) {
/* 11 */     super(par1);
/* 12 */     this.field_77777_bU = 1;
/*    */   }
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player) {
/* 16 */     if (!world.field_72995_K && player.field_70154_o == null && !player.field_70122_E) {
/* 17 */       double x = player.field_70165_t + 0.5D;
/* 18 */       double y = player.field_70163_u + 3.5D;
/* 19 */       double z = player.field_70161_v + 0.5D;
/* 20 */       MCH_EntityParachute entity = new MCH_EntityParachute(world, x, y, z);
/* 21 */       entity.field_70177_z = player.field_70177_z;
/* 22 */       entity.field_70159_w = player.field_70159_w;
/* 23 */       entity.field_70181_x = player.field_70181_x;
/* 24 */       entity.field_70179_y = player.field_70179_y;
/* 25 */       entity.field_70143_R = player.field_70143_R;
/* 26 */       player.field_70143_R = 0.0F;
/* 27 */       entity.user = (Entity)player;
/* 28 */       entity.setType(1);
/* 29 */       world.func_72838_d((Entity)entity);
/*    */     } 
/*    */     
/* 32 */     if (!player.field_71075_bZ.field_75098_d) {
/* 33 */       item.field_77994_a--;
/*    */     }
/*    */     
/* 36 */     return item;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\parachute\MCH_ItemParachute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */