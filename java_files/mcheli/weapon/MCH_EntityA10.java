/*     */ package mcheli.weapon;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_EntityA10
/*     */   extends W_Entity {
/*     */   public static final int DATAWT_NAME = 29;
/*     */   public final int DESPAWN_COUNT;
/*     */   public int despawnCount;
/*     */   public Entity shootingAircraft;
/*     */   public Entity shootingEntity;
/*     */   public int shotCount;
/*     */   public int direction;
/*     */   public int power;
/*     */   public float acceleration;
/*     */   public int explosionPower;
/*     */   public boolean isFlaming;
/*     */   public String name;
/*     */   public MCH_WeaponInfo weaponInfo;
/*  29 */   static int snd_num = 0;
/*     */ 
/*     */   
/*     */   public MCH_EntityA10(World world) {
/*  33 */     super(world);
/*  34 */     this.DESPAWN_COUNT = 70;
/*  35 */     this.despawnCount = 0;
/*  36 */     this.shotCount = 0;
/*  37 */     this.direction = 0;
/*  38 */     this.field_70158_ak = true;
/*  39 */     this.field_70156_m = false;
/*  40 */     func_70105_a(5.0F, 3.0F);
/*  41 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  42 */     this.field_70159_w = 0.0D;
/*  43 */     this.field_70181_x = 0.0D;
/*  44 */     this.field_70179_y = 0.0D;
/*  45 */     this.power = 32;
/*  46 */     this.acceleration = 4.0F;
/*  47 */     this.explosionPower = 1;
/*  48 */     this.isFlaming = false;
/*  49 */     this.shootingEntity = null;
/*  50 */     this.shootingAircraft = null;
/*  51 */     this.field_70178_ae = true;
/*  52 */     this.field_70155_l *= 10.0D;
/*     */   }
/*     */   
/*     */   public MCH_EntityA10(World world, double x, double y, double z) {
/*  56 */     this(world);
/*  57 */     this.field_70142_S = this.field_70169_q = this.field_70165_t = x;
/*  58 */     this.field_70137_T = this.field_70167_r = this.field_70163_u = y;
/*  59 */     this.field_70136_U = this.field_70166_s = this.field_70161_v = z;
/*     */   }
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  63 */     return false;
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  67 */     func_70096_w().func_75682_a(29, String.valueOf(""));
/*     */   }
/*     */   
/*     */   public void setWeaponName(String s) {
/*  71 */     if (s != null && !s.isEmpty()) {
/*  72 */       this.weaponInfo = MCH_WeaponInfoManager.get(s);
/*  73 */       if (this.weaponInfo != null && !this.field_70170_p.field_72995_K) {
/*  74 */         func_70096_w().func_75692_b(29, String.valueOf(s));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getWeaponName() {
/*  81 */     return func_70096_w().func_75681_e(29);
/*     */   }
/*     */   
/*     */   public MCH_WeaponInfo getInfo() {
/*  85 */     return this.weaponInfo;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity par1Entity) {
/*  89 */     return par1Entity.field_70121_D;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/*  93 */     return this.field_70121_D;
/*     */   }
/*     */   
/*     */   public boolean func_70104_M() {
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_70067_L() {
/* 105 */     return false;
/*     */   }
/*     */   
/*     */   public void func_70106_y() {
/* 109 */     super.func_70106_y();
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/* 113 */     super.func_70071_h_();
/* 114 */     if (!this.field_70128_L) {
/* 115 */       this.despawnCount++;
/*     */     }
/*     */     
/* 118 */     if (this.weaponInfo == null) {
/* 119 */       setWeaponName(getWeaponName());
/* 120 */       if (this.weaponInfo == null) {
/* 121 */         func_70106_y();
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 126 */     if (this.field_70170_p.field_72995_K) {
/* 127 */       onUpdate_Client();
/*     */     } else {
/* 129 */       onUpdate_Server();
/*     */     } 
/*     */     
/* 132 */     if (!this.field_70128_L) {
/* 133 */       if (this.despawnCount <= 20) {
/* 134 */         this.field_70181_x = -0.3D;
/*     */       } else {
/* 136 */         func_70107_b(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 137 */         this.field_70181_x += 0.02D;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRender() {
/* 144 */     return (this.despawnCount > 20);
/*     */   }
/*     */   
/*     */   private void onUpdate_Client() {
/* 148 */     this.shotCount += 4;
/*     */   }
/*     */   
/*     */   private void onUpdate_Server() {
/* 152 */     if (!this.field_70128_L) {
/* 153 */       if (this.despawnCount > 70) {
/* 154 */         func_70106_y();
/* 155 */       } else if (this.despawnCount > 0 && this.shotCount < 40) {
/* 156 */         for (int i = 0; i < 2; i++) {
/* 157 */           shotGAU8(true, this.shotCount);
/* 158 */           this.shotCount++;
/*     */         } 
/*     */         
/* 161 */         if (this.shotCount == 38) {
/* 162 */           W_WorldFunc.MOD_playSoundEffect(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, "gau-8_snd", 150.0F, 1.0F);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void shotGAU8(boolean playSound, int cnt) {
/* 170 */     float yaw = (90 * this.direction);
/* 171 */     float pitch = 30.0F;
/* 172 */     double x = this.field_70165_t;
/* 173 */     double y = this.field_70163_u;
/* 174 */     double z = this.field_70161_v;
/* 175 */     double tX = this.field_70146_Z.nextDouble() - 0.5D;
/* 176 */     double tY = -2.6D;
/* 177 */     double tZ = this.field_70146_Z.nextDouble() - 0.5D;
/* 178 */     if (this.direction == 0) {
/* 179 */       tZ += 10.0D;
/* 180 */       z += cnt * 0.6D;
/*     */     } 
/*     */     
/* 183 */     if (this.direction == 1) {
/* 184 */       tX -= 10.0D;
/* 185 */       x -= cnt * 0.6D;
/*     */     } 
/*     */     
/* 188 */     if (this.direction == 2) {
/* 189 */       tZ -= 10.0D;
/* 190 */       z -= cnt * 0.6D;
/*     */     } 
/*     */     
/* 193 */     if (this.direction == 3) {
/* 194 */       tX += 10.0D;
/* 195 */       x += cnt * 0.6D;
/*     */     } 
/*     */     
/* 198 */     double dist = MathHelper.func_76133_a(tX * tX + tY * tY + tZ * tZ);
/* 199 */     tX = tX * 4.0D / dist;
/* 200 */     tY = tY * 4.0D / dist;
/* 201 */     tZ = tZ * 4.0D / dist;
/* 202 */     MCH_EntityBullet e = new MCH_EntityBullet(this.field_70170_p, x, y, z, tX, tY, tZ, yaw, pitch, this.acceleration);
/* 203 */     e.setName(getWeaponName());
/* 204 */     e.explosionPower = (this.shotCount % 4 == 0) ? this.explosionPower : 0;
/* 205 */     e.setPower(this.power);
/* 206 */     e.shootingEntity = this.shootingEntity;
/* 207 */     e.shootingAircraft = this.shootingAircraft;
/* 208 */     this.field_70170_p.func_72838_d((Entity)e);
/*     */   }
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 212 */     par1NBTTagCompound.func_74778_a("WeaponName", getWeaponName());
/*     */   }
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 216 */     this.despawnCount = 200;
/* 217 */     if (par1NBTTagCompound.func_74764_b("WeaponName")) {
/* 218 */       setWeaponName(par1NBTTagCompound.func_74779_i("WeaponName"));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 225 */     return 10.0F;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityA10.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */