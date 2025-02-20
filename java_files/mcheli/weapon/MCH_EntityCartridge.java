/*     */ package mcheli.weapon;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_MovingObjectPosition;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.model.IModelCustom;
/*     */ 
/*     */ public class MCH_EntityCartridge
/*     */   extends W_Entity {
/*     */   public final String texture_name;
/*     */   public final IModelCustom model;
/*     */   private final float bound;
/*     */   private final float gravity;
/*     */   private final float scale;
/*     */   private int countOnUpdate;
/*     */   public float targetYaw;
/*     */   public float targetPitch;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void spawnCartridge(World world, MCH_Cartridge cartridge, double x, double y, double z, double mx, double my, double mz, float yaw, float pitch) {
/*  31 */     if (cartridge != null) {
/*  32 */       MCH_EntityCartridge entityFX = new MCH_EntityCartridge(world, cartridge, x, y, z, mx + (world.field_73012_v.nextFloat() - 0.5D) * 0.07D, my, mz + (world.field_73012_v.nextFloat() - 0.5D) * 0.07D);
/*  33 */       entityFX.field_70126_B = yaw;
/*  34 */       entityFX.field_70177_z = yaw;
/*  35 */       entityFX.targetYaw = yaw;
/*  36 */       entityFX.field_70127_C = pitch;
/*  37 */       entityFX.field_70125_A = pitch;
/*  38 */       entityFX.targetPitch = pitch;
/*  39 */       float cy = yaw + cartridge.yaw;
/*  40 */       float cp = pitch + cartridge.pitch;
/*  41 */       double tX = (-MathHelper.func_76126_a(cy / 180.0F * 3.1415927F) * MathHelper.func_76134_b(cp / 180.0F * 3.1415927F));
/*  42 */       double tZ = (MathHelper.func_76134_b(cy / 180.0F * 3.1415927F) * MathHelper.func_76134_b(cp / 180.0F * 3.1415927F));
/*  43 */       double tY = -MathHelper.func_76126_a(cp / 180.0F * 3.1415927F);
/*  44 */       double d = MathHelper.func_76133_a(tX * tX + tY * tY + tZ * tZ);
/*  45 */       if (Math.abs(d) > 0.001D) {
/*  46 */         entityFX.field_70159_w += tX * cartridge.acceleration / d;
/*  47 */         entityFX.field_70181_x += tY * cartridge.acceleration / d;
/*  48 */         entityFX.field_70179_y += tZ * cartridge.acceleration / d;
/*     */       } 
/*     */       
/*  51 */       world.func_72838_d((Entity)entityFX);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public MCH_EntityCartridge(World par1World, MCH_Cartridge c, double x, double y, double z, double mx, double my, double mz) {
/*  57 */     super(par1World);
/*  58 */     func_70080_a(x, y, z, 0.0F, 0.0F);
/*  59 */     this.field_70159_w = mx;
/*  60 */     this.field_70181_x = my;
/*  61 */     this.field_70179_y = mz;
/*  62 */     this.texture_name = c.name;
/*  63 */     this.model = c.model;
/*  64 */     this.bound = c.bound;
/*  65 */     this.gravity = c.gravity;
/*  66 */     this.scale = c.scale;
/*  67 */     this.countOnUpdate = 0;
/*     */   }
/*     */   
/*     */   public float getScale() {
/*  71 */     return this.scale;
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/*  75 */     this.field_70169_q = this.field_70165_t;
/*  76 */     this.field_70167_r = this.field_70163_u;
/*  77 */     this.field_70166_s = this.field_70161_v;
/*  78 */     this.field_70126_B = this.field_70177_z;
/*  79 */     this.field_70127_C = this.field_70125_A;
/*  80 */     MCH_Config var10001 = MCH_MOD.config;
/*  81 */     if (this.countOnUpdate < MCH_Config.AliveTimeOfCartridge.prmInt) {
/*  82 */       this.countOnUpdate++;
/*     */     } else {
/*  84 */       func_70106_y();
/*     */     } 
/*     */     
/*  87 */     this.field_70159_w *= 0.98D;
/*  88 */     this.field_70179_y *= 0.98D;
/*  89 */     this.field_70181_x += this.gravity;
/*  90 */     move();
/*     */   }
/*     */   
/*     */   public void rotation() {
/*  94 */     if (this.field_70177_z < this.targetYaw - 3.0F) {
/*  95 */       this.field_70177_z += 10.0F;
/*  96 */       if (this.field_70177_z > this.targetYaw) {
/*  97 */         this.field_70177_z = this.targetYaw;
/*     */       }
/*  99 */     } else if (this.field_70177_z > this.targetYaw + 3.0F) {
/* 100 */       this.field_70177_z -= 10.0F;
/* 101 */       if (this.field_70177_z < this.targetYaw) {
/* 102 */         this.field_70177_z = this.targetYaw;
/*     */       }
/*     */     } 
/*     */     
/* 106 */     if (this.field_70125_A < this.targetPitch) {
/* 107 */       this.field_70125_A += 10.0F;
/* 108 */       if (this.field_70125_A > this.targetPitch) {
/* 109 */         this.field_70125_A = this.targetPitch;
/*     */       }
/* 111 */     } else if (this.field_70125_A > this.targetPitch) {
/* 112 */       this.field_70125_A -= 10.0F;
/* 113 */       if (this.field_70125_A < this.targetPitch) {
/* 114 */         this.field_70125_A = this.targetPitch;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void move() {
/* 121 */     Vec3 vec1 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 122 */     Vec3 vec2 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 123 */     MovingObjectPosition m = W_WorldFunc.clip(this.field_70170_p, vec1, vec2);
/* 124 */     double d = Math.max(Math.abs(this.field_70159_w), Math.abs(this.field_70181_x));
/* 125 */     d = Math.max(d, Math.abs(this.field_70179_y));
/* 126 */     if (W_MovingObjectPosition.isHitTypeTile(m)) {
/* 127 */       func_70107_b(m.field_72307_f.field_72450_a, m.field_72307_f.field_72448_b, m.field_72307_f.field_72449_c);
/* 128 */       this.field_70159_w += d * (this.field_70146_Z.nextFloat() - 0.5F) * 0.10000000149011612D;
/* 129 */       this.field_70181_x += d * (this.field_70146_Z.nextFloat() - 0.5F) * 0.10000000149011612D;
/* 130 */       this.field_70179_y += d * (this.field_70146_Z.nextFloat() - 0.5F) * 0.10000000149011612D;
/* 131 */       if (d > 0.10000000149011612D) {
/* 132 */         this.targetYaw += (float)(d * (this.field_70146_Z.nextFloat() - 0.5F) * 720.0D);
/* 133 */         this.targetPitch = (float)(d * (this.field_70146_Z.nextFloat() - 0.5F) * 720.0D);
/*     */       } else {
/* 135 */         this.targetPitch = 0.0F;
/*     */       } 
/*     */       
/* 138 */       switch (m.field_72310_e) {
/*     */         case 0:
/* 140 */           if (this.field_70181_x > 0.0D) {
/* 141 */             this.field_70181_x = -this.field_70181_x * this.bound;
/*     */           }
/*     */           break;
/*     */         case 1:
/* 145 */           if (this.field_70181_x < 0.0D) {
/* 146 */             this.field_70181_x = -this.field_70181_x * this.bound;
/*     */           }
/*     */           
/* 149 */           this.targetPitch *= 0.3F;
/*     */           break;
/*     */         case 2:
/* 152 */           if (this.field_70179_y > 0.0D) {
/* 153 */             this.field_70179_y = -this.field_70179_y * this.bound; break;
/*     */           } 
/* 155 */           this.field_70161_v += this.field_70179_y;
/*     */           break;
/*     */         
/*     */         case 3:
/* 159 */           if (this.field_70179_y < 0.0D) {
/* 160 */             this.field_70179_y = -this.field_70179_y * this.bound; break;
/*     */           } 
/* 162 */           this.field_70161_v += this.field_70179_y;
/*     */           break;
/*     */         
/*     */         case 4:
/* 166 */           if (this.field_70159_w > 0.0D) {
/* 167 */             this.field_70159_w = -this.field_70159_w * this.bound; break;
/*     */           } 
/* 169 */           this.field_70165_t += this.field_70159_w;
/*     */           break;
/*     */         
/*     */         case 5:
/* 173 */           if (this.field_70159_w < 0.0D) {
/* 174 */             this.field_70159_w = -this.field_70159_w * this.bound; break;
/*     */           } 
/* 176 */           this.field_70165_t += this.field_70159_w;
/*     */           break;
/*     */       } 
/*     */     } else {
/* 180 */       this.field_70165_t += this.field_70159_w;
/* 181 */       this.field_70163_u += this.field_70181_x;
/* 182 */       this.field_70161_v += this.field_70179_y;
/* 183 */       if (d > 0.05000000074505806D)
/* 184 */         rotation(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound var1) {}
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound var1) {}
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityCartridge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */