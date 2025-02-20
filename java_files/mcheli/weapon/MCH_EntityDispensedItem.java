/*     */ package mcheli.weapon;
/*     */ 
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.wrapper.W_Item;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_EntityDispensedItem extends MCH_EntityBaseBullet {
/*     */   public MCH_EntityDispensedItem(World par1World) {
/*  19 */     super(par1World);
/*     */   }
/*     */   
/*     */   public MCH_EntityDispensedItem(World par1World, double posX, double posY, double posZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration) {
/*  23 */     super(par1World, posX, posY, posZ, targetX, targetY, targetZ, yaw, pitch, acceleration);
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/*  27 */     super.func_70071_h_();
/*  28 */     if (getInfo() != null && !(getInfo()).disableSmoke) {
/*  29 */       spawnParticle((getInfo()).trajectoryParticleName, 3, 7.0F * (getInfo()).smokeSize);
/*     */     }
/*     */     
/*  32 */     if (!this.field_70170_p.field_72995_K && getInfo() != null) {
/*  33 */       if (this.acceleration < 1.0E-4D) {
/*  34 */         this.field_70159_w *= 0.999D;
/*  35 */         this.field_70179_y *= 0.999D;
/*     */       } 
/*     */       
/*  38 */       if (func_70090_H()) {
/*  39 */         this.field_70159_w *= (getInfo()).velocityInWater;
/*  40 */         this.field_70181_x *= (getInfo()).velocityInWater;
/*  41 */         this.field_70179_y *= (getInfo()).velocityInWater;
/*     */       } 
/*     */     } 
/*     */     
/*  45 */     onUpdateBomblet();
/*     */   }
/*     */   
/*     */   protected void onImpact(MovingObjectPosition m, float damageFactor) {
/*  49 */     if (!this.field_70170_p.field_72995_K) {
/*  50 */       this.field_70121_D.field_72337_e += 2000.0D;
/*  51 */       this.field_70121_D.field_72338_b += 2000.0D;
/*  52 */       EntityPlayer player = null;
/*  53 */       Item item = null;
/*  54 */       int itemDamage = 0;
/*  55 */       if (m != null && getInfo() != null) {
/*  56 */         if (this.shootingAircraft instanceof EntityPlayer) {
/*  57 */           player = (EntityPlayer)this.shootingAircraft;
/*     */         }
/*     */         
/*  60 */         if (this.shootingEntity instanceof EntityPlayer) {
/*  61 */           player = (EntityPlayer)this.shootingEntity;
/*     */         }
/*     */         
/*  64 */         item = (getInfo()).dispenseItem;
/*  65 */         itemDamage = (getInfo()).dispenseDamege;
/*     */       } 
/*     */       
/*  68 */       if (player != null && !player.field_70128_L && item != null) {
/*  69 */         MCH_DummyEntityPlayer dummyPlayer = new MCH_DummyEntityPlayer(this.field_70170_p, player);
/*  70 */         dummyPlayer.field_70125_A = 90.0F;
/*  71 */         int RNG = (getInfo()).dispenseRange - 1;
/*     */         
/*  73 */         for (int x = -RNG; x <= RNG; x++) {
/*  74 */           for (int y = -RNG; y <= RNG; y++) {
/*  75 */             if (y >= 0 && y < 256) {
/*  76 */               for (int z = -RNG; z <= RNG; z++) {
/*  77 */                 int dist = x * x + y * y + z * z;
/*  78 */                 if (dist <= RNG * RNG) {
/*  79 */                   if (dist <= 0.5D * RNG * RNG) {
/*  80 */                     useItemToBlock(m.field_72311_b + x, m.field_72312_c + y, m.field_72309_d + z, item, itemDamage, (EntityPlayer)dummyPlayer);
/*  81 */                   } else if (this.field_70146_Z.nextInt(2) == 0) {
/*  82 */                     useItemToBlock(m.field_72311_b + x, m.field_72312_c + y, m.field_72309_d + z, item, itemDamage, (EntityPlayer)dummyPlayer);
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  91 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void useItemToBlock(int x, int y, int z, Item item, int itemDamage, EntityPlayer dummyPlayer) {
/*  97 */     dummyPlayer.field_70165_t = x + 0.5D;
/*  98 */     dummyPlayer.field_70163_u = y + 2.5D;
/*  99 */     dummyPlayer.field_70161_v = z + 0.5D;
/* 100 */     dummyPlayer.field_70177_z = this.field_70146_Z.nextInt(360);
/* 101 */     Block block = W_WorldFunc.getBlock(this.field_70170_p, x, y, z);
/* 102 */     Material blockMat = W_WorldFunc.getBlockMaterial(this.field_70170_p, x, y, z);
/* 103 */     if (block != Blocks.field_150350_a && blockMat != Material.field_151579_a) {
/* 104 */       if (item == W_Item.getItemByName("water_bucket")) {
/* 105 */         MCH_Config var10000 = MCH_MOD.config;
/* 106 */         if (MCH_Config.Collision_DestroyBlock.prmBool) {
/* 107 */           if (blockMat == Material.field_151581_o) {
/* 108 */             this.field_70170_p.func_147468_f(x, y, z);
/* 109 */           } else if (blockMat == Material.field_151587_i) {
/* 110 */             int metadata = this.field_70170_p.func_72805_g(x, y, z);
/* 111 */             if (metadata == 0) {
/* 112 */               W_WorldFunc.setBlock(this.field_70170_p, x, y, z, Blocks.field_150343_Z);
/* 113 */             } else if (metadata <= 4) {
/* 114 */               W_WorldFunc.setBlock(this.field_70170_p, x, y, z, Blocks.field_150347_e);
/*     */             } 
/*     */           } 
/*     */         }
/* 118 */       } else if (!item.onItemUseFirst(new ItemStack(item, 1, itemDamage), dummyPlayer, this.field_70170_p, x, y, z, 1, x, y, z) && !item.func_77648_a(new ItemStack(item, 1, itemDamage), dummyPlayer, this.field_70170_p, x, y, z, 1, x, y, z)) {
/* 119 */         item.func_77659_a(new ItemStack(item, 1, itemDamage), this.field_70170_p, dummyPlayer);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void sprinkleBomblet() {
/* 126 */     if (!this.field_70170_p.field_72995_K) {
/* 127 */       MCH_EntityDispensedItem e = new MCH_EntityDispensedItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y, this.field_70146_Z.nextInt(360), 0.0F, this.acceleration);
/* 128 */       e.setParameterFromWeapon(this, this.shootingAircraft, this.shootingEntity);
/* 129 */       e.setName(getName());
/* 130 */       float MOTION = 1.0F;
/* 131 */       float RANDOM = (getInfo()).bombletDiff;
/* 132 */       e.field_70159_w = this.field_70159_w * 1.0D + ((this.field_70146_Z.nextFloat() - 0.5F) * RANDOM);
/* 133 */       e.field_70181_x = this.field_70181_x * 1.0D / 2.0D + ((this.field_70146_Z.nextFloat() - 0.5F) * RANDOM / 2.0F);
/* 134 */       e.field_70179_y = this.field_70179_y * 1.0D + ((this.field_70146_Z.nextFloat() - 0.5F) * RANDOM);
/* 135 */       e.setBomblet();
/* 136 */       this.field_70170_p.func_72838_d((Entity)e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public MCH_BulletModel getDefaultBulletModel() {
/* 142 */     return MCH_DefaultBulletModels.Bomb;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityDispensedItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */