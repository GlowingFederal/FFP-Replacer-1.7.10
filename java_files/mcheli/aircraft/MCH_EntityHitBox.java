/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.wrapper.W_Entity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_EntityHitBox
/*    */   extends W_Entity
/*    */ {
/*    */   public MCH_EntityAircraft parent;
/*    */   public int debugId;
/*    */   
/*    */   public MCH_EntityHitBox(World world) {
/* 20 */     super(world);
/* 21 */     func_70105_a(1.0F, 1.0F);
/* 22 */     this.field_70129_M = 0.0F;
/* 23 */     this.field_70159_w = 0.0D;
/* 24 */     this.field_70181_x = 0.0D;
/* 25 */     this.field_70179_y = 0.0D;
/* 26 */     this.parent = null;
/* 27 */     this.field_70158_ak = true;
/* 28 */     this.field_70178_ae = true;
/*    */   }
/*    */   
/*    */   public MCH_EntityHitBox(World world, MCH_EntityAircraft ac, float w, float h) {
/* 32 */     this(world);
/* 33 */     func_70107_b(ac.field_70165_t, ac.field_70163_u + 1.0D, ac.field_70161_v);
/* 34 */     this.field_70169_q = ac.field_70165_t;
/* 35 */     this.field_70167_r = ac.field_70163_u + 1.0D;
/* 36 */     this.field_70166_s = ac.field_70161_v;
/* 37 */     this.parent = ac;
/* 38 */     func_70105_a(w, h);
/*    */   }
/*    */   
/*    */   protected boolean func_70041_e_() {
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public AxisAlignedBB func_70114_g(Entity par1Entity) {
/* 46 */     return par1Entity.field_70121_D;
/*    */   }
/*    */   
/*    */   public AxisAlignedBB func_70046_E() {
/* 50 */     return this.field_70121_D;
/*    */   }
/*    */   
/*    */   public boolean func_70104_M() {
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public double func_70042_X() {
/* 58 */     return -0.3D;
/*    */   }
/*    */   
/*    */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 62 */     return (this.parent != null) ? this.parent.func_70097_a(par1DamageSource, par2) : false;
/*    */   }
/*    */   
/*    */   public boolean func_70067_L() {
/* 66 */     return !this.field_70128_L;
/*    */   }
/*    */   
/*    */   public void func_70106_y() {
/* 70 */     super.func_70106_y();
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 74 */     super.func_70071_h_();
/*    */   }
/*    */   
/*    */   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) {}
/*    */   
/*    */   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) {}
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public float func_70053_R() {
/* 83 */     return 0.0F;
/*    */   }
/*    */   
/*    */   public boolean func_130002_c(EntityPlayer player) {
/* 87 */     return (this.parent != null) ? this.parent.func_130002_c(player) : false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_EntityHitBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */