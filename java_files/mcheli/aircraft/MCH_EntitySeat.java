/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_EntitySeat
/*     */   extends W_Entity
/*     */ {
/*     */   public String parentUniqueID;
/*     */   private MCH_EntityAircraft parent;
/*     */   public int seatID;
/*     */   public int parentSearchCount;
/*     */   protected Entity lastRiddenByEntity;
/*     */   public static final float BB_SIZE = 1.0F;
/*     */   
/*     */   public MCH_EntitySeat(World world) {
/*  28 */     super(world);
/*  29 */     func_70105_a(1.0F, 1.0F);
/*  30 */     this.field_70129_M = 0.0F;
/*  31 */     this.field_70159_w = 0.0D;
/*  32 */     this.field_70181_x = 0.0D;
/*  33 */     this.field_70179_y = 0.0D;
/*  34 */     this.seatID = -1;
/*  35 */     setParent((MCH_EntityAircraft)null);
/*  36 */     this.parentSearchCount = 0;
/*  37 */     this.lastRiddenByEntity = null;
/*  38 */     this.field_70158_ak = true;
/*  39 */     this.field_70178_ae = true;
/*     */   }
/*     */   
/*     */   public MCH_EntitySeat(World world, double x, double y, double z) {
/*  43 */     this(world);
/*  44 */     func_70107_b(x, y + 1.0D, z);
/*  45 */     this.field_70169_q = x;
/*  46 */     this.field_70167_r = y + 1.0D;
/*  47 */     this.field_70166_s = z;
/*     */   }
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  51 */     return false;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity par1Entity) {
/*  55 */     return par1Entity.field_70121_D;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/*  59 */     return this.field_70121_D;
/*     */   }
/*     */   
/*     */   public boolean func_70104_M() {
/*  63 */     return false;
/*     */   }
/*     */   
/*     */   public double func_70042_X() {
/*  67 */     return -0.3D;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/*  71 */     return (getParent() != null) ? getParent().func_70097_a(par1DamageSource, par2) : false;
/*     */   }
/*     */   
/*     */   public boolean func_70067_L() {
/*  75 */     return !this.field_70128_L;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {}
/*     */   
/*     */   public void func_70106_y() {
/*  82 */     super.func_70106_y();
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/*  86 */     super.func_70071_h_();
/*  87 */     this.field_70143_R = 0.0F;
/*  88 */     if (this.field_70153_n != null) {
/*  89 */       this.field_70153_n.field_70143_R = 0.0F;
/*     */     }
/*     */     
/*  92 */     if (this.lastRiddenByEntity == null && this.field_70153_n != null) {
/*  93 */       if (getParent() != null) {
/*  94 */         MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntitySeat.onUpdate:SeatID=%d", new Object[] { Integer.valueOf(this.seatID), this.field_70153_n.toString() });
/*  95 */         getParent().onMountPlayerSeat(this, this.field_70153_n);
/*     */       } 
/*  97 */     } else if (this.lastRiddenByEntity != null && this.field_70153_n == null && getParent() != null) {
/*  98 */       MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntitySeat.onUpdate:SeatID=%d", new Object[] { Integer.valueOf(this.seatID), this.lastRiddenByEntity.toString() });
/*  99 */       getParent().onUnmountPlayerSeat(this, this.lastRiddenByEntity);
/*     */     } 
/*     */     
/* 102 */     if (this.field_70170_p.field_72995_K) {
/* 103 */       onUpdate_Client();
/*     */     } else {
/* 105 */       onUpdate_Server();
/*     */     } 
/*     */     
/* 108 */     this.lastRiddenByEntity = this.field_70153_n;
/*     */   }
/*     */   
/*     */   private void onUpdate_Client() {
/* 112 */     checkDetachmentAndDelete();
/*     */   }
/*     */   
/*     */   private void onUpdate_Server() {
/* 116 */     checkDetachmentAndDelete();
/* 117 */     if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
/* 118 */       this.field_70153_n = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70043_V() {
/* 124 */     updatePosition();
/*     */   }
/*     */   
/*     */   public void updatePosition() {
/* 128 */     Entity ridEnt = this.field_70153_n;
/* 129 */     if (ridEnt != null) {
/* 130 */       ridEnt.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 131 */       ridEnt.field_70159_w = ridEnt.field_70181_x = ridEnt.field_70179_y = 0.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRotation(float yaw, float pitch) {
/* 137 */     Entity ridEnt = this.field_70153_n;
/* 138 */     if (ridEnt != null) {
/* 139 */       ridEnt.field_70177_z = yaw;
/* 140 */       ridEnt.field_70125_A = pitch;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void checkDetachmentAndDelete() {
/* 146 */     if (!this.field_70128_L && (this.seatID < 0 || getParent() == null || (getParent()).field_70128_L)) {
/* 147 */       if (getParent() != null && (getParent()).field_70128_L) {
/* 148 */         this.parentSearchCount = 100000000;
/*     */       }
/*     */       
/* 151 */       if (this.parentSearchCount >= 1200) {
/* 152 */         func_70106_y();
/* 153 */         if (!this.field_70170_p.field_72995_K && this.field_70153_n != null) {
/* 154 */           this.field_70153_n.func_70078_a((Entity)null);
/*     */         }
/*     */         
/* 157 */         setParent((MCH_EntityAircraft)null);
/* 158 */         MCH_Lib.DbgLog(this.field_70170_p, "[Error]座席エンティティは本体が見つからないため削除 seat=%d, parentUniqueID=%s", new Object[] { Integer.valueOf(this.seatID), this.parentUniqueID });
/*     */       } else {
/* 160 */         this.parentSearchCount++;
/*     */       } 
/*     */     } else {
/* 163 */       this.parentSearchCount = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 169 */     par1NBTTagCompound.func_74768_a("SeatID", this.seatID);
/* 170 */     par1NBTTagCompound.func_74778_a("ParentUniqueID", this.parentUniqueID);
/*     */   }
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 174 */     this.seatID = par1NBTTagCompound.func_74762_e("SeatID");
/* 175 */     this.parentUniqueID = par1NBTTagCompound.func_74779_i("ParentUniqueID");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 180 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public boolean canRideMob(Entity entity) {
/* 184 */     return (getParent() != null && this.seatID >= 0) ? (!(getParent().getSeatInfo(this.seatID + 1) instanceof MCH_SeatRackInfo)) : false;
/*     */   }
/*     */   
/*     */   public boolean isGunnerMode() {
/* 188 */     return (this.field_70153_n != null && getParent() != null) ? getParent().getIsGunnerMode(this.field_70153_n) : false;
/*     */   }
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer player) {
/* 192 */     if (getParent() != null && !getParent().isDestroyed()) {
/* 193 */       if (!getParent().checkTeam(player)) {
/* 194 */         return false;
/*     */       }
/* 196 */       ItemStack itemStack = player.func_71045_bC();
/* 197 */       if (itemStack != null && itemStack.func_77973_b() instanceof mcheli.tool.MCH_ItemWrench)
/* 198 */         return getParent().func_130002_c(player); 
/* 199 */       if (itemStack != null && itemStack.func_77973_b() instanceof mcheli.mob.MCH_ItemSpawnGunner)
/* 200 */         return getParent().func_130002_c(player); 
/* 201 */       if (this.field_70153_n != null)
/* 202 */         return false; 
/* 203 */       if (player.field_70154_o != null)
/* 204 */         return false; 
/* 205 */       if (!canRideMob((Entity)player)) {
/* 206 */         return false;
/*     */       }
/* 208 */       player.func_70078_a((Entity)this);
/* 209 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 213 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public MCH_EntityAircraft getParent() {
/* 218 */     return this.parent;
/*     */   }
/*     */   
/*     */   public void setParent(MCH_EntityAircraft parent) {
/* 222 */     this.parent = parent;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_EntitySeat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */