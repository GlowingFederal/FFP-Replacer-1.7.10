/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.client.particle.EntityFX;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class W_EntityFX
/*    */   extends EntityFX
/*    */ {
/*    */   public W_EntityFX(World par1World, double par2, double par4, double par6) {
/* 21 */     super(par1World, par2, par4, par6);
/*    */   }
/*    */   
/*    */   public W_EntityFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
/* 25 */     super(par1World, par2, par4, par6, par8, par10, par12);
/*    */   }
/*    */   
/*    */   public AxisAlignedBB func_70046_E() {
/* 29 */     return this.field_70121_D;
/*    */   }
/*    */   
/*    */   public void setIcon(IIcon icon) {
/* 33 */     func_110125_a(icon);
/*    */   }
/*    */   
/*    */   protected void doBlockCollisions() {
/* 37 */     func_145775_I();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_EntityFX.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */