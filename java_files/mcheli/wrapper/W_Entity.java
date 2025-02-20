/*     */ package mcheli.wrapper;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.Explosion;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class W_Entity
/*     */   extends Entity
/*     */ {
/*     */   public W_Entity(World par1World) {
/*  42 */     super(par1World);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {}
/*     */   
/*     */   public static boolean isEntityFallingBlock(Entity entity) {
/*  49 */     return entity instanceof net.minecraft.entity.item.EntityFallingBlock;
/*     */   }
/*     */   
/*     */   public static int getEntityId(Entity entity) {
/*  53 */     return (entity != null) ? entity.func_145782_y() : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isEqual(Entity e1, Entity e2) {
/*  58 */     int i1 = getEntityId(e1); int i2; return 
/*  59 */       (i1 == (i2 = getEntityId(e2)));
/*     */   }
/*     */   
/*     */   public EntityItem dropItemWithOffset(Item item, int par2, float par3) {
/*  63 */     return func_70099_a(new ItemStack(item, par2, 0), par3);
/*     */   }
/*     */   
/*     */   public String getEntityName() {
/*  67 */     return func_70022_Q();
/*     */   }
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer par1EntityPlayer) {
/*  71 */     return interact(par1EntityPlayer);
/*     */   }
/*     */   
/*     */   public boolean interact(EntityPlayer par1EntityPlayer) {
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
/*  79 */     return func_70097_a(par1DamageSource, par2);
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean attackEntityFrom(Entity entity, DamageSource ds, float par2) {
/*  87 */     return entity.func_70097_a(ds, par2);
/*     */   }
/*     */   
/*     */   public void func_85029_a(CrashReportCategory par1CrashReportCategory) {
/*  91 */     super.func_85029_a(par1CrashReportCategory);
/*     */   }
/*     */   
/*     */   public static float getBlockExplosionResistance(Entity entity, Explosion par1Explosion, World par2World, int par3, int par4, int par5, Block par6Block) {
/*  95 */     if (par6Block != null) {
/*     */       try {
/*  97 */         return entity.func_145772_a(par1Explosion, par2World, par3, par4, par5, par6Block);
/*     */       }
/*  99 */       catch (Exception e) {
/* 100 */         e.printStackTrace();
/*     */       } 
/*     */     }
/* 103 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public static boolean shouldExplodeBlock(Entity entity, Explosion par1Explosion, World par2World, int par3, int par4, int par5, int par6, float par7) {
/* 107 */     return entity.func_145774_a(par1Explosion, par2World, par3, par4, par5, W_Block.getBlockById(par6), par7);
/*     */   }
/*     */   
/*     */   public static PotionEffect getActivePotionEffect(Entity entity, Potion par1Potion) {
/* 111 */     return (entity instanceof EntityLivingBase) ? ((EntityLivingBase)entity).func_70660_b(par1Potion) : null;
/*     */   }
/*     */   
/*     */   public static void removePotionEffectClient(Entity entity, int id) {
/* 115 */     if (entity instanceof EntityLivingBase) {
/* 116 */       ((EntityLivingBase)entity).func_70618_n(id);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void removePotionEffect(Entity entity, int id) {
/* 121 */     if (entity instanceof EntityLivingBase) {
/* 122 */       ((EntityLivingBase)entity).func_82170_o(id);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void addPotionEffect(Entity entity, PotionEffect pe) {
/* 127 */     if (entity instanceof EntityLivingBase) {
/* 128 */       ((EntityLivingBase)entity).func_70690_d(pe);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void doBlockCollisions() {
/* 133 */     func_145775_I();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vec3 getLook(float p_70676_1_) {
/* 143 */     if (p_70676_1_ == 1.0F) {
/*     */       
/* 145 */       float f7 = MathHelper.func_76134_b(-this.field_70177_z * 0.017453292F - 3.1415927F);
/* 146 */       float f8 = MathHelper.func_76126_a(-this.field_70177_z * 0.017453292F - 3.1415927F);
/* 147 */       float f9 = -MathHelper.func_76134_b(-this.field_70125_A * 0.017453292F);
/* 148 */       float f10 = MathHelper.func_76126_a(-this.field_70125_A * 0.017453292F);
/* 149 */       return Vec3.func_72443_a((f8 * f9), f10, (f7 * f9));
/*     */     } 
/*     */ 
/*     */     
/* 153 */     float f1 = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * p_70676_1_;
/* 154 */     float f2 = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * p_70676_1_;
/* 155 */     float f3 = MathHelper.func_76134_b(-f2 * 0.017453292F - 3.1415927F);
/* 156 */     float f4 = MathHelper.func_76126_a(-f2 * 0.017453292F - 3.1415927F);
/* 157 */     float f5 = -MathHelper.func_76134_b(-f1 * 0.017453292F);
/* 158 */     float f6 = MathHelper.func_76126_a(-f1 * 0.017453292F);
/* 159 */     return Vec3.func_72443_a((f4 * f5), f6, (f3 * f5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_Entity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */