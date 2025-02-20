/*     */ package mcheli.mob;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.renderer.entity.RendererLivingEntity;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_RenderGunner
/*     */   extends RendererLivingEntity
/*     */ {
/*  23 */   private static final ResourceLocation steveTextures = new ResourceLocation("mcheli", "textures/mob/heligunner.png");
/*     */   public ModelBiped modelBipedMain;
/*     */   public ModelBiped modelArmorChestplate;
/*     */   public ModelBiped modelArmor;
/*     */   
/*     */   public MCH_RenderGunner() {
/*  29 */     super((ModelBase)new ModelBiped(0.0F), 0.5F);
/*  30 */     this.modelBipedMain = (ModelBiped)this.field_77045_g;
/*  31 */     this.modelArmorChestplate = new ModelBiped(1.0F);
/*  32 */     this.modelArmor = new ModelBiped(0.5F);
/*     */   }
/*     */   
/*     */   protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
/*  36 */     ItemStack itemstack = null;
/*  37 */     return -1;
/*     */   }
/*     */   
/*     */   protected boolean func_110813_b(EntityLivingBase p_110813_1_) {
/*  41 */     return (p_110813_1_.func_96124_cp() != null);
/*     */   }
/*     */   
/*     */   public void func_76986_a(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/*  45 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*  46 */     this.modelBipedMain.field_78117_n = p_76986_1_.func_70093_af();
/*  47 */     double d3 = p_76986_4_ - p_76986_1_.field_70129_M;
/*  48 */     if (p_76986_1_.func_70093_af() && !(p_76986_1_ instanceof net.minecraft.client.entity.EntityPlayerSP)) {
/*  49 */       d3 -= 0.125D;
/*     */     }
/*     */     
/*  52 */     MCH_EntityAircraft ac = ((MCH_EntityGunner)p_76986_1_).getAc();
/*  53 */     if (ac != null && ac.getAcInfo() != null && (!(ac.getAcInfo()).hideEntity || !ac.isPilot((Entity)p_76986_1_))) {
/*  54 */       super.func_76986_a(p_76986_1_, p_76986_2_, d3, p_76986_6_, p_76986_8_, p_76986_9_);
/*     */     }
/*     */     
/*  57 */     this.modelBipedMain.field_78118_o = false;
/*  58 */     this.modelBipedMain.field_78117_n = false;
/*  59 */     this.modelBipedMain.field_78120_m = 0;
/*     */   }
/*     */   
/*     */   protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_) {
/*  63 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*  64 */     super.func_77029_c(p_77029_1_, p_77029_2_);
/*  65 */     func_85093_e(p_77029_1_, p_77029_2_);
/*  66 */     ItemStack itemstack = null;
/*  67 */     boolean flag = false;
/*  68 */     ItemStack itemstack1 = null;
/*     */   }
/*     */   
/*     */   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
/*  72 */     float f1 = 0.9375F;
/*  73 */     GL11.glScalef(f1, f1, f1);
/*     */   }
/*     */   
/*     */   public void renderFirstPersonArm(EntityPlayer p_82441_1_) {
/*  77 */     float f = 1.0F;
/*  78 */     GL11.glColor3f(f, f, f);
/*  79 */     this.modelBipedMain.field_78095_p = 0.0F;
/*  80 */     this.modelBipedMain.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, (Entity)p_82441_1_);
/*  81 */     this.modelBipedMain.field_78112_f.func_78785_a(0.0625F);
/*     */   }
/*     */   
/*     */   protected void _func_96449_a(EntityLivingBase p_96449_1_, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_) {
/*  85 */     func_96449_a(p_96449_1_, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);
/*     */   }
/*     */   
/*     */   protected void _preRenderCallback(EntityLivingBase p_77041_1_, float p_77041_2_) {
/*  89 */     func_77041_b(p_77041_1_, p_77041_2_);
/*     */   }
/*     */   
/*     */   protected void _func_82408_c(EntityLivingBase p_82408_1_, int p_82408_2_, float p_82408_3_) {
/*  93 */     func_82408_c(p_82408_1_, p_82408_2_, p_82408_3_);
/*     */   }
/*     */   
/*     */   protected int _shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
/*  97 */     return func_77032_a(p_77032_1_, p_77032_2_, p_77032_3_);
/*     */   }
/*     */   
/*     */   protected void _renderEquippedItems(EntityLivingBase p_77029_1_, float p_77029_2_) {
/* 101 */     func_77029_c(p_77029_1_, p_77029_2_);
/*     */   }
/*     */   
/*     */   protected void _rotateCorpse(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
/* 105 */     func_77043_a(p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
/*     */   }
/*     */   
/*     */   protected void _renderLivingAt(EntityLivingBase p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_) {
/* 109 */     func_77039_a(p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
/*     */   }
/*     */   
/*     */   public void _doRender(EntityLivingBase p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 113 */     func_76986_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*     */   }
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity p_110775_1_) {
/* 117 */     return steveTextures;
/*     */   }
/*     */   
/*     */   public void _doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
/* 121 */     func_76986_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\mob\MCH_RenderGunner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */