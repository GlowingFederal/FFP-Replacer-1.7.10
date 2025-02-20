/*    */ package mcheli.gltd;
/*    */ 
/*    */ import java.util.List;
/*    */ import mcheli.wrapper.W_Item;
/*    */ import mcheli.wrapper.W_MovingObjectPosition;
/*    */ import mcheli.wrapper.W_WorldFunc;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_ItemGLTD
/*    */   extends W_Item
/*    */ {
/*    */   public MCH_ItemGLTD(int par1) {
/* 20 */     super(par1);
/* 21 */     this.field_77777_bU = 1;
/*    */   }
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
/* 25 */     float f = 1.0F;
/* 26 */     float f1 = par3EntityPlayer.field_70127_C + (par3EntityPlayer.field_70125_A - par3EntityPlayer.field_70127_C) * f;
/* 27 */     float f2 = par3EntityPlayer.field_70126_B + (par3EntityPlayer.field_70177_z - par3EntityPlayer.field_70126_B) * f;
/* 28 */     double d0 = par3EntityPlayer.field_70169_q + (par3EntityPlayer.field_70165_t - par3EntityPlayer.field_70169_q) * f;
/* 29 */     double d1 = par3EntityPlayer.field_70167_r + (par3EntityPlayer.field_70163_u - par3EntityPlayer.field_70167_r) * f + 1.62D - par3EntityPlayer.field_70129_M;
/* 30 */     double d2 = par3EntityPlayer.field_70166_s + (par3EntityPlayer.field_70161_v - par3EntityPlayer.field_70166_s) * f;
/* 31 */     Vec3 vec3 = W_WorldFunc.getWorldVec3(par2World, d0, d1, d2);
/* 32 */     float f3 = MathHelper.func_76134_b(-f2 * 0.017453292F - 3.1415927F);
/* 33 */     float f4 = MathHelper.func_76126_a(-f2 * 0.017453292F - 3.1415927F);
/* 34 */     float f5 = -MathHelper.func_76134_b(-f1 * 0.017453292F);
/* 35 */     float f6 = MathHelper.func_76126_a(-f1 * 0.017453292F);
/* 36 */     float f7 = f4 * f5;
/* 37 */     float f8 = f3 * f5;
/* 38 */     double d3 = 5.0D;
/* 39 */     Vec3 vec31 = vec3.func_72441_c(f7 * d3, f6 * d3, f8 * d3);
/* 40 */     MovingObjectPosition movingobjectposition = W_WorldFunc.clip(par2World, vec3, vec31, true);
/* 41 */     if (movingobjectposition == null) {
/* 42 */       return par1ItemStack;
/*    */     }
/* 44 */     Vec3 vec32 = par3EntityPlayer.func_70676_i(f);
/* 45 */     boolean flag = false;
/* 46 */     float f9 = 1.0F;
/* 47 */     List<Entity> list = par2World.func_72839_b((Entity)par3EntityPlayer, par3EntityPlayer.field_70121_D.func_72321_a(vec32.field_72450_a * d3, vec32.field_72448_b * d3, vec32.field_72449_c * d3).func_72314_b(f9, f9, f9));
/*    */     
/*    */     int i;
/* 50 */     for (i = 0; i < list.size(); i++) {
/* 51 */       Entity j = list.get(i);
/* 52 */       if (j.func_70067_L()) {
/* 53 */         float k = j.func_70111_Y();
/* 54 */         AxisAlignedBB entityboat = j.field_70121_D.func_72314_b(k, k, k);
/* 55 */         if (entityboat.func_72318_a(vec3)) {
/* 56 */           flag = true;
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 61 */     if (flag) {
/* 62 */       return par1ItemStack;
/*    */     }
/* 64 */     if (W_MovingObjectPosition.isHitTypeTile(movingobjectposition)) {
/* 65 */       i = movingobjectposition.field_72311_b;
/* 66 */       int var32 = movingobjectposition.field_72312_c;
/* 67 */       int var33 = movingobjectposition.field_72309_d;
/* 68 */       MCH_EntityGLTD var34 = new MCH_EntityGLTD(par2World, (i + 0.5F), (var32 + 1.0F), (var33 + 0.5F));
/* 69 */       var34.field_70177_z = par3EntityPlayer.field_70177_z;
/* 70 */       if (!par2World.func_72945_a((Entity)var34, var34.field_70121_D.func_72314_b(-0.1D, -0.1D, -0.1D)).isEmpty()) {
/* 71 */         return par1ItemStack;
/*    */       }
/*    */       
/* 74 */       if (!par2World.field_72995_K) {
/* 75 */         par2World.func_72838_d((Entity)var34);
/*    */       }
/*    */       
/* 78 */       if (!par3EntityPlayer.field_71075_bZ.field_75098_d) {
/* 79 */         par1ItemStack.field_77994_a--;
/*    */       }
/*    */     } 
/*    */     
/* 83 */     return par1ItemStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gltd\MCH_ItemGLTD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */