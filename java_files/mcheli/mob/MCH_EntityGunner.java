/*     */ package mcheli.mob;
/*     */ 
/*     */ import java.util.List;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.aircraft.MCH_SeatInfo;
/*     */ import mcheli.weapon.MCH_WeaponBase;
/*     */ import mcheli.weapon.MCH_WeaponParam;
/*     */ import mcheli.weapon.MCH_WeaponSet;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.monster.IMob;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.scoreboard.ScorePlayerTeam;
/*     */ import net.minecraft.scoreboard.Team;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_EntityGunner
/*     */   extends EntityLivingBase
/*     */ {
/*     */   public boolean isCreative;
/*     */   public String ownerUUID;
/*     */   public int targetType;
/*     */   public int despawnCount;
/*     */   public int switchTargetCount;
/*     */   public Entity targetEntity;
/*     */   public double targetPrevPosX;
/*     */   public double targetPrevPosY;
/*     */   public double targetPrevPosZ;
/*     */   public boolean waitCooldown;
/*     */   public int idleCount;
/*     */   public int idleRotation;
/*     */   
/*     */   public MCH_EntityGunner(World world) {
/*  51 */     super(world);
/*  52 */     this.isCreative = false;
/*  53 */     this.ownerUUID = "";
/*  54 */     this.targetType = 0;
/*  55 */     this.despawnCount = 0;
/*  56 */     this.switchTargetCount = 0;
/*  57 */     this.targetEntity = null;
/*  58 */     this.targetPrevPosX = 0.0D;
/*  59 */     this.targetPrevPosY = 0.0D;
/*  60 */     this.targetPrevPosZ = 0.0D;
/*  61 */     this.waitCooldown = false;
/*  62 */     this.idleCount = 0;
/*  63 */     this.idleRotation = 0;
/*     */   }
/*     */   
/*     */   public MCH_EntityGunner(World world, double x, double y, double z) {
/*  67 */     this(world);
/*  68 */     func_70107_b(x, y, z);
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  72 */     super.func_70088_a();
/*  73 */     func_70096_w().func_75682_a(17, "");
/*     */   }
/*     */   
/*     */   public String getTeamName() {
/*  77 */     return func_70096_w().func_75681_e(17);
/*     */   }
/*     */   
/*     */   public void setTeamName(String name) {
/*  81 */     func_70096_w().func_75692_b(17, name);
/*     */   }
/*     */   
/*     */   public Team func_96124_cp() {
/*  85 */     return (Team)this.field_70170_p.func_96441_U().func_96508_e(getTeamName());
/*     */   }
/*     */   
/*     */   public boolean func_142014_c(EntityLivingBase p_142014_1_) {
/*  89 */     return super.func_142014_c(p_142014_1_);
/*     */   }
/*     */   
/*     */   public IChatComponent func_145748_c_() {
/*  93 */     Team team = func_96124_cp();
/*  94 */     return (team != null) ? (IChatComponent)new ChatComponentText(ScorePlayerTeam.func_96667_a(team, team.func_96661_b() + " Gunner")) : (IChatComponent)new ChatComponentText("");
/*     */   }
/*     */   
/*     */   public boolean func_85032_ar() {
/*  98 */     return this.isCreative;
/*     */   }
/*     */   
/*     */   public void func_70645_a(DamageSource source) {
/* 102 */     super.func_70645_a(source);
/*     */   }
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer player) {
/* 106 */     if (this.field_70170_p.field_72995_K)
/* 107 */       return false; 
/* 108 */     if (this.field_70154_o == null)
/* 109 */       return false; 
/* 110 */     if (player.field_71075_bZ.field_75098_d) {
/* 111 */       removeFromAircraft(player);
/* 112 */       return true;
/* 113 */     }  if (this.isCreative) {
/* 114 */       player.func_145747_a((IChatComponent)new ChatComponentText("Creative mode only."));
/* 115 */       return false;
/* 116 */     }  if (func_96124_cp() != null && !func_142014_c((EntityLivingBase)player)) {
/* 117 */       player.func_145747_a((IChatComponent)new ChatComponentText("You are other team."));
/* 118 */       return false;
/*     */     } 
/* 120 */     removeFromAircraft(player);
/* 121 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeFromAircraft(EntityPlayer player) {
/* 126 */     if (!this.field_70170_p.field_72995_K) {
/* 127 */       W_WorldFunc.MOD_playSoundAtEntity((Entity)player, "wrench", 1.0F, 1.0F);
/* 128 */       func_70106_y();
/* 129 */       MCH_EntityAircraft ac = null;
/* 130 */       if (this.field_70154_o instanceof MCH_EntityAircraft) {
/* 131 */         ac = (MCH_EntityAircraft)this.field_70154_o;
/* 132 */       } else if (this.field_70154_o instanceof MCH_EntitySeat) {
/* 133 */         ac = ((MCH_EntitySeat)this.field_70154_o).getParent();
/*     */       } 
/*     */       
/* 136 */       String name = "";
/* 137 */       if (ac != null && ac.getAcInfo() != null) {
/* 138 */         name = " on " + (ac.getAcInfo()).displayName + " seat " + (ac.getSeatIdByEntity((Entity)this) + 1);
/*     */       }
/*     */       
/* 141 */       player.func_145747_a((IChatComponent)new ChatComponentText("Remove gunner" + name + " by " + ScorePlayerTeam.func_96667_a(player.func_96124_cp(), player.getDisplayName()) + "."));
/* 142 */       func_70078_a((Entity)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 148 */     super.func_70071_h_();
/* 149 */     if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
/* 150 */       if (this.field_70154_o != null && this.field_70154_o.field_70128_L) {
/* 151 */         this.field_70154_o = null;
/*     */       }
/*     */       
/* 154 */       if (this.field_70154_o instanceof MCH_EntityAircraft) {
/* 155 */         shotTarget((MCH_EntityAircraft)this.field_70154_o);
/* 156 */       } else if (this.field_70154_o instanceof MCH_EntitySeat && ((MCH_EntitySeat)this.field_70154_o).getParent() != null) {
/* 157 */         shotTarget(((MCH_EntitySeat)this.field_70154_o).getParent());
/* 158 */       } else if (this.despawnCount < 20) {
/* 159 */         this.despawnCount++;
/* 160 */       } else if (this.field_70154_o == null || this.field_70173_aa > 100) {
/* 161 */         func_70106_y();
/*     */       } 
/*     */       
/* 164 */       if (this.targetEntity == null) {
/* 165 */         if (this.idleCount == 0) {
/* 166 */           this.idleCount = (3 + this.field_70146_Z.nextInt(5)) * 20;
/* 167 */           this.idleRotation = this.field_70146_Z.nextInt(5) - 2;
/*     */         } 
/*     */         
/* 170 */         this.field_70177_z += this.idleRotation / 2.0F;
/*     */       } else {
/* 172 */         this.idleCount = 60;
/*     */       } 
/*     */     } 
/*     */     
/* 176 */     if (this.switchTargetCount > 0) {
/* 177 */       this.switchTargetCount--;
/*     */     }
/*     */     
/* 180 */     if (this.idleCount > 0) {
/* 181 */       this.idleCount--;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canAttackEntity(EntityLivingBase entity, MCH_EntityAircraft ac, MCH_WeaponSet ws) {
/* 187 */     boolean ret = false;
/* 188 */     if (this.targetType == 0) {
/* 189 */       ret = (entity != this && !(entity instanceof net.minecraft.entity.monster.EntityEnderman) && !entity.field_70128_L && !func_142014_c(entity) && entity.func_110143_aJ() > 0.0F && !ac.isMountedEntity((Entity)entity));
/*     */     } else {
/* 191 */       ret = (entity != this && !((EntityPlayer)entity).field_71075_bZ.field_75098_d && !entity.field_70128_L && !getTeamName().isEmpty() && !func_142014_c(entity) && entity.func_110143_aJ() > 0.0F && !ac.isMountedEntity((Entity)entity));
/*     */     } 
/*     */     
/* 194 */     if (ret && ws.getCurrentWeapon().getGuidanceSystem() != null) {
/* 195 */       ret = ws.getCurrentWeapon().getGuidanceSystem().canLockEntity((Entity)entity);
/*     */     }
/*     */     
/* 198 */     return ret;
/*     */   }
/*     */   
/*     */   public void shotTarget(MCH_EntityAircraft ac) {
/* 202 */     if (!ac.isDestroyed() && 
/* 203 */       ac.getGunnerStatus()) {
/* 204 */       MCH_WeaponSet ws = ac.getCurrentWeapon((Entity)this);
/* 205 */       if (ws != null && ws.getInfo() != null && ws.getCurrentWeapon() != null) {
/* 206 */         MCH_WeaponBase cw = ws.getCurrentWeapon();
/* 207 */         if (this.targetEntity != null && (this.targetEntity.field_70128_L || ((EntityLivingBase)this.targetEntity).func_110143_aJ() <= 0.0F) && this.switchTargetCount > 20) {
/* 208 */           this.switchTargetCount = 20;
/*     */         }
/*     */         
/* 211 */         Vec3 pos = getGunnerWeaponPos(ac, ws);
/* 212 */         if ((this.targetEntity == null && this.switchTargetCount <= 0) || this.switchTargetCount <= 0) {
/* 213 */           List<EntityLivingBase> list; this.switchTargetCount = 20;
/* 214 */           EntityLivingBase nextTarget = null;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 219 */           if (this.targetType == 0) {
/* 220 */             MCH_Config var10000 = MCH_MOD.config;
/* 221 */             int i = MCH_Config.RangeOfGunner_VsMonster_Horizontal.prmInt;
/* 222 */             var10000 = MCH_MOD.config;
/* 223 */             int rv = MCH_Config.RangeOfGunner_VsMonster_Vertical.prmInt;
/* 224 */             list = this.field_70170_p.func_72872_a(IMob.class, this.field_70121_D.func_72314_b(i, rv, i));
/*     */           } else {
/* 226 */             MCH_Config var10000 = MCH_MOD.config;
/* 227 */             int i = MCH_Config.RangeOfGunner_VsPlayer_Horizontal.prmInt;
/* 228 */             var10000 = MCH_MOD.config;
/* 229 */             int rv = MCH_Config.RangeOfGunner_VsPlayer_Vertical.prmInt;
/* 230 */             list = this.field_70170_p.func_72872_a(EntityPlayer.class, this.field_70121_D.func_72314_b(i, rv, i));
/*     */           } 
/*     */           
/* 233 */           for (byte b = 0; b < list.size(); b++) {
/* 234 */             EntityLivingBase entity = list.get(b);
/* 235 */             if (canAttackEntity(entity, ac, ws) && checkPitch(entity, ac, pos) && (nextTarget == null || func_70032_d((Entity)entity) < func_70032_d((Entity)nextTarget)) && func_70685_l((Entity)entity) && isInAttackable(entity, ac, ws, pos)) {
/* 236 */               nextTarget = entity;
/* 237 */               this.switchTargetCount = 60;
/*     */             } 
/*     */           } 
/*     */           
/* 241 */           if (nextTarget != null && this.targetEntity != nextTarget) {
/* 242 */             this.targetPrevPosX = nextTarget.field_70165_t;
/* 243 */             this.targetPrevPosY = nextTarget.field_70163_u;
/* 244 */             this.targetPrevPosZ = nextTarget.field_70161_v;
/*     */           } 
/*     */           
/* 247 */           this.targetEntity = (Entity)nextTarget;
/*     */         } 
/*     */         
/* 250 */         if (this.targetEntity != null) {
/* 251 */           float rotSpeed = 10.0F;
/* 252 */           if (ac.isPilot((Entity)this)) {
/* 253 */             rotSpeed = (ac.getAcInfo()).cameraRotationSpeed / 10.0F;
/*     */           }
/*     */           
/* 256 */           this.field_70125_A = MathHelper.func_76142_g(this.field_70125_A);
/* 257 */           this.field_70177_z = MathHelper.func_76142_g(this.field_70177_z);
/* 258 */           double dist = func_70032_d(this.targetEntity);
/* 259 */           double tick = 1.0D;
/* 260 */           if (dist >= 10.0D && (ws.getInfo()).acceleration > 1.0F) {
/* 261 */             tick = dist / (ws.getInfo()).acceleration;
/*     */           }
/*     */           
/* 264 */           if (this.targetEntity.field_70154_o instanceof MCH_EntitySeat || this.targetEntity.field_70154_o instanceof MCH_EntityAircraft) {
/* 265 */             MCH_Config var10001 = MCH_MOD.config;
/* 266 */             tick -= MCH_Config.HitBoxDelayTick.prmInt;
/*     */           } 
/*     */           
/* 269 */           double dx = (this.targetEntity.field_70165_t - this.targetPrevPosX) * tick;
/* 270 */           double dy = (this.targetEntity.field_70163_u - this.targetPrevPosY) * tick + this.targetEntity.field_70131_O * this.field_70146_Z.nextDouble();
/* 271 */           double dz = (this.targetEntity.field_70161_v - this.targetPrevPosZ) * tick;
/* 272 */           double d0 = this.targetEntity.field_70165_t + dx - pos.field_72450_a;
/* 273 */           double d1 = this.targetEntity.field_70163_u + dy - pos.field_72448_b;
/* 274 */           double d2 = this.targetEntity.field_70161_v + dz - pos.field_72449_c;
/* 275 */           double d3 = MathHelper.func_76133_a(d0 * d0 + d2 * d2);
/* 276 */           float yaw = MathHelper.func_76142_g((float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F);
/* 277 */           float pitch = (float)-(Math.atan2(d1, d3) * 180.0D / Math.PI);
/* 278 */           if (Math.abs(this.field_70125_A - pitch) < rotSpeed && Math.abs(this.field_70177_z - yaw) < rotSpeed) {
/* 279 */             float r = ac.isPilot((Entity)this) ? 0.1F : 0.5F;
/* 280 */             this.field_70125_A = pitch + (this.field_70146_Z.nextFloat() - 0.5F) * r - cw.fixRotationPitch;
/* 281 */             this.field_70177_z = yaw + (this.field_70146_Z.nextFloat() - 0.5F) * r;
/* 282 */             if (!this.waitCooldown || ws.currentHeat <= 0 || (ws.getInfo()).maxHeatCount <= 0) {
/* 283 */               this.waitCooldown = false;
/* 284 */               MCH_WeaponParam prm = new MCH_WeaponParam();
/* 285 */               prm.setPosition(ac.field_70165_t, ac.field_70163_u, ac.field_70161_v);
/* 286 */               prm.user = (Entity)this;
/* 287 */               prm.entity = (Entity)ac;
/* 288 */               prm.option1 = (cw instanceof mcheli.weapon.MCH_WeaponEntitySeeker) ? this.targetEntity.func_145782_y() : 0;
/* 289 */               if (ac.useCurrentWeapon(prm) && (ws.getInfo()).maxHeatCount > 0 && ws.currentHeat > (ws.getInfo()).maxHeatCount * 4 / 5) {
/* 290 */                 this.waitCooldown = true;
/*     */               }
/*     */             } 
/*     */           } 
/*     */           
/* 295 */           if (Math.abs(pitch - this.field_70125_A) >= rotSpeed) {
/* 296 */             this.field_70125_A += (pitch > this.field_70125_A) ? rotSpeed : -rotSpeed;
/*     */           }
/*     */           
/* 299 */           if (Math.abs(yaw - this.field_70177_z) >= rotSpeed) {
/* 300 */             if (Math.abs(yaw - this.field_70177_z) <= 180.0F) {
/* 301 */               this.field_70177_z += (yaw > this.field_70177_z) ? rotSpeed : -rotSpeed;
/*     */             } else {
/* 303 */               this.field_70177_z += (yaw > this.field_70177_z) ? -rotSpeed : rotSpeed;
/*     */             } 
/*     */           }
/*     */           
/* 307 */           this.field_70759_as = this.field_70177_z;
/* 308 */           this.targetPrevPosX = this.targetEntity.field_70165_t;
/* 309 */           this.targetPrevPosY = this.targetEntity.field_70163_u;
/* 310 */           this.targetPrevPosZ = this.targetEntity.field_70161_v;
/*     */         } else {
/* 312 */           this.field_70125_A *= 0.95F;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean checkPitch(EntityLivingBase entity, MCH_EntityAircraft ac, Vec3 pos) {
/*     */     try {
/* 322 */       double d0 = entity.field_70165_t - pos.field_72450_a;
/* 323 */       double d1 = entity.field_70163_u - pos.field_72448_b;
/* 324 */       double d2 = entity.field_70161_v - pos.field_72449_c;
/* 325 */       double d3 = MathHelper.func_76133_a(d0 * d0 + d2 * d2);
/* 326 */       float pitch = (float)-(Math.atan2(d1, d3) * 180.0D / Math.PI);
/* 327 */       MCH_AircraftInfo ai = ac.getAcInfo();
/* 328 */       if (ac instanceof mcheli.vehicle.MCH_EntityVehicle && ac.isPilot((Entity)this) && Math.abs(ai.minRotationPitch) + Math.abs(ai.maxRotationPitch) > 0.0F) {
/* 329 */         if (pitch < ai.minRotationPitch) {
/* 330 */           return false;
/*     */         }
/*     */         
/* 333 */         if (pitch > ai.maxRotationPitch) {
/* 334 */           return false;
/*     */         }
/*     */       } 
/*     */       
/* 338 */       MCH_WeaponBase cw = ac.getCurrentWeapon((Entity)this).getCurrentWeapon();
/* 339 */       if (!(cw instanceof mcheli.weapon.MCH_WeaponEntitySeeker)) {
/* 340 */         MCH_AircraftInfo.Weapon wi = ai.getWeaponById(ac.getCurrentWeaponID((Entity)this));
/* 341 */         if (Math.abs(wi.minPitch) + Math.abs(wi.maxPitch) > 0.0F) {
/* 342 */           if (pitch < wi.minPitch) {
/* 343 */             return false;
/*     */           }
/*     */           
/* 346 */           if (pitch > wi.maxPitch) {
/* 347 */             return false;
/*     */           }
/*     */         } 
/*     */       } 
/* 351 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 354 */     return true;
/*     */   }
/*     */   
/*     */   public Vec3 getGunnerWeaponPos(MCH_EntityAircraft ac, MCH_WeaponSet ws) {
/* 358 */     MCH_SeatInfo seatInfo = ac.getSeatInfo((Entity)this);
/* 359 */     return ((seatInfo == null || !seatInfo.rotSeat) && !(ac instanceof mcheli.vehicle.MCH_EntityVehicle)) ? ac.getTransformedPosition((ws.getCurrentWeapon()).position) : ac.calcOnTurretPos((ws.getCurrentWeapon()).position).func_72441_c(ac.field_70165_t, ac.field_70163_u, ac.field_70161_v);
/*     */   }
/*     */   
/*     */   private boolean isInAttackable(EntityLivingBase entity, MCH_EntityAircraft ac, MCH_WeaponSet ws, Vec3 pos) {
/* 363 */     if (ac instanceof mcheli.vehicle.MCH_EntityVehicle) {
/* 364 */       return true;
/*     */     }
/*     */     try {
/* 367 */       if (ac.getCurrentWeapon((Entity)this).getCurrentWeapon() instanceof mcheli.weapon.MCH_WeaponEntitySeeker) {
/* 368 */         return true;
/*     */       }
/* 370 */       MCH_AircraftInfo.Weapon wi = ac.getAcInfo().getWeaponById(ac.getCurrentWeaponID((Entity)this));
/* 371 */       Vec3 v1 = Vec3.func_72443_a(0.0D, 0.0D, 1.0D);
/* 372 */       float yaw = -ac.getRotYaw() + (wi.maxYaw + wi.minYaw) / 2.0F - wi.defaultYaw;
/* 373 */       v1.func_72442_b(yaw * 3.1415927F / 180.0F);
/* 374 */       Vec3 v2 = Vec3.func_72443_a(entity.field_70165_t - pos.field_72450_a, 0.0D, entity.field_70161_v - pos.field_72449_c).func_72432_b();
/* 375 */       double dot = v1.func_72430_b(v2);
/* 376 */       double rad = Math.acos(dot);
/* 377 */       double deg = rad * 180.0D / Math.PI;
/* 378 */       return (deg < (Math.abs(wi.maxYaw - wi.minYaw) / 2.0F));
/*     */     }
/* 380 */     catch (Exception var15) {
/* 381 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public MCH_EntityAircraft getAc() {
/* 387 */     if (this.field_70154_o == null) {
/* 388 */       return null;
/*     */     }
/* 390 */     return (this.field_70154_o instanceof MCH_EntitySeat) ? ((MCH_EntitySeat)this.field_70154_o).getParent() : ((this.field_70154_o instanceof MCH_EntityAircraft) ? (MCH_EntityAircraft)this.field_70154_o : null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound nbt) {
/* 395 */     super.func_70014_b(nbt);
/* 396 */     nbt.func_74757_a("Creative", this.isCreative);
/* 397 */     nbt.func_74778_a("OwnerUUID", this.ownerUUID);
/* 398 */     nbt.func_74778_a("TeamName", getTeamName());
/* 399 */     nbt.func_74768_a("TargetType", this.targetType);
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound nbt) {
/* 403 */     super.func_70037_a(nbt);
/* 404 */     this.isCreative = nbt.func_74767_n("Creative");
/* 405 */     this.ownerUUID = nbt.func_74779_i("OwnerUUID");
/* 406 */     setTeamName(nbt.func_74779_i("TeamName"));
/* 407 */     this.targetType = nbt.func_74762_e("TargetType");
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71027_c(int dim) {}
/*     */   
/*     */   public void func_70106_y() {
/* 414 */     if (!this.field_70170_p.field_72995_K && !this.field_70128_L && !this.isCreative) {
/* 415 */       if (this.targetType == 0) {
/* 416 */         func_145779_a((Item)MCH_MOD.itemSpawnGunnerVsMonster, 1);
/*     */       } else {
/* 418 */         func_145779_a((Item)MCH_MOD.itemSpawnGunnerVsPlayer, 1);
/*     */       } 
/*     */     }
/*     */     
/* 422 */     super.func_70106_y();
/* 423 */     MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityGunner.setDead type=%d :" + toString(), new Object[] { Integer.valueOf(this.targetType) });
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource ds, float p_70097_2_) {
/* 427 */     if (ds == DamageSource.field_76380_i) {
/* 428 */       func_70106_y();
/*     */     }
/*     */     
/* 431 */     return super.func_70097_a(ds, p_70097_2_);
/*     */   }
/*     */   
/*     */   public ItemStack func_70694_bm() {
/* 435 */     return null;
/*     */   }
/*     */   
/*     */   public ItemStack func_71124_b(int p_71124_1_) {
/* 439 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {}
/*     */ 
/*     */   
/*     */   public ItemStack[] func_70035_c() {
/* 447 */     return new ItemStack[0];
/*     */   }
/*     */   
/*     */   public ItemStack[] getInventory() {
/* 451 */     return new ItemStack[0];
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\mob\MCH_EntityGunner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */