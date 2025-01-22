package com.flansmod.common.guns;

import com.flansmod.api.IEntityBullet;
import com.flansmod.client.debug.EntityDebugDot;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.guns.raytracing.BlockHit;
import com.flansmod.common.guns.raytracing.BulletHit;
import com.flansmod.common.guns.raytracing.CustomBlockRaytracing;
import com.flansmod.common.guns.raytracing.DriveableHit;
import com.flansmod.common.guns.raytracing.EntityHit;
import com.flansmod.common.guns.raytracing.EnumHitboxType;
import com.flansmod.common.guns.raytracing.PlayerBulletHit;
import com.flansmod.common.guns.raytracing.PlayerHitbox;
import com.flansmod.common.guns.raytracing.PlayerSnapshot;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketFlak;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.teams.Team;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBullet extends EntityShootable implements IEntityAdditionalSpawnData, IEntityBullet {
  private static int bulletLife = 600;
  
  public Entity owner;
  
  private int ticksInAir;
  
  public BulletType type;
  
  public InfoType firedFrom;
  
  public float damage;
  
  public ShootableType getType() {
    return this.type;
  }
  
  public boolean shotgun = false;
  
  public int pingOfShooter = 0;
  
  public boolean detonated = false;
  
  public Entity lockedOnTo;
  
  public double prevDistanceToEntity = 0.0D;
  
  public int cnt;
  
  public boolean toggleLock = false;
  
  public double lockedOnToSpeed = 0.0D;
  
  public double thisSpeed = 0.0D;
  
  public int closeCount = 0;
  
  public int soundTime = 0;
  
  public float speedA;
  
  public float truePen;
  
  public boolean isHEAT;
  
  public boolean isSword = false;
  
  public String missNoise = "bulletFlyby";
  
  public boolean radarVisible = false;
  
  public boolean entityMissileRadarVisible = false;
  
  public int impactX;
  
  public int impactY;
  
  public int impactZ;
  
  public boolean isFirstPositionSetting = false;
  
  public boolean isPositionUpper = true;
  
  public boolean lockAttempted = false;
  
  public static boolean hitCrossHair;
  
  public static float penAmount;
  
  public static boolean headshot;
  
  public float penetratingPower;
  
  public int submunitionDelay = 20;
  
  public boolean hasSetSubDelay = false;
  
  public boolean hasSetVLSDelay = false;
  
  public int VLSDelay = 0;
  
  public Vector3f lookVector;
  
  public Vector3f initialPos;
  
  public boolean hasSetLook = false;
  
  public float maxspeed;
  
  public float initialX;
  
  public float initialY;
  
  public float initialZ;
  
  public EntityBullet(World world) {
    super(world);
    this.ticksInAir = 0;
    func_70105_a(0.5F, 0.5F);
  }
  
  private EntityBullet(World world, EntityLivingBase shooter, float gunDamage, BulletType bulletType, InfoType shotFrom) {
    this(world);
    this.owner = (Entity)shooter;
    if (shooter instanceof EntityPlayerMP)
      this.pingOfShooter = ((EntityPlayerMP)shooter).field_71138_i; 
    this.type = bulletType;
    this.firedFrom = shotFrom;
    this.damage = gunDamage;
    this.penetratingPower = this.type.penetratingPower;
    func_70105_a(bulletType.hitBoxSize, bulletType.hitBoxSize);
  }
  
  public EntityBullet(World world, EntityLivingBase shooter, float spread, float gunDamage, BulletType type1, float speed, boolean shot, InfoType shotFrom, float Xoffset, float Yoffset, float Zoffset) {
    this(world, Vec3.func_72443_a(shooter.field_70165_t - (MathHelper.func_76134_b(shooter.field_70177_z / 180.0F * 3.1415927F) * Zoffset) - (MathHelper.func_76134_b(shooter.field_70125_A / 180.0F * 3.1415927F) * MathHelper.func_76126_a(shooter.field_70177_z / 180.0F * 3.1415927F) * Xoffset), shooter.field_70163_u + Yoffset + shooter.func_70047_e() - (MathHelper.func_76126_a(shooter.field_70125_A / 180.0F * 3.1415927F) * Xoffset), shooter.field_70161_v + (MathHelper.func_76134_b(shooter.field_70125_A / 180.0F * 3.1415927F) * MathHelper.func_76134_b(shooter.field_70177_z / 180.0F * 3.1415927F) * Xoffset) - (MathHelper.func_76126_a(shooter.field_70177_z / 180.0F * 3.1415927F) * Zoffset)), shooter.field_70177_z, shooter.field_70125_A, shooter, spread, gunDamage, type1, speed, shotFrom);
    this.shotgun = shot;
  }
  
  public EntityBullet(World world, Vec3 origin, float yaw, float pitch, EntityLivingBase shooter, float spread, float gunDamage, BulletType type1, InfoType shotFrom) {
    this(world, origin, yaw, pitch, shooter, spread, gunDamage, type1, 3.0F, shotFrom);
  }
  
  public EntityBullet(World world, Vec3 origin, float yaw, float pitch, EntityLivingBase shooter, float spread, float gunDamage, BulletType type1, float speed, InfoType shotFrom) {
    this(world, shooter, gunDamage, type1, shotFrom);
    func_70012_b(origin.field_72450_a, origin.field_72448_b, origin.field_72449_c, yaw, pitch);
    func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    this.field_70129_M = 0.0F;
    this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
    this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
    this.field_70181_x = -MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.141593F);
    setArrowHeading(this.field_70159_w, this.field_70181_x, this.field_70179_y, spread / 2.0F, speed);
  }
  
  public EntityBullet(World world, Vector3f origin, Vector3f direction, EntityLivingBase shooter, float spread, float gunDamage, BulletType type1, float speed, InfoType shotFrom) {
    this(world, shooter, gunDamage, type1, shotFrom);
    this.damage = gunDamage;
    func_70107_b(origin.x, origin.y, origin.z);
    this.field_70159_w = direction.x;
    this.field_70181_x = direction.y;
    this.field_70179_y = direction.z;
    setArrowHeading(this.field_70159_w, this.field_70181_x, this.field_70179_y, spread, speed);
  }
  
  public EntityBullet(World world, Vec3 origin, float yaw, float pitch, double motX, double motY, double motZ, EntityLivingBase shooter, float gunDamage, BulletType type1, InfoType shotFrom) {
    this(world, shooter, gunDamage, type1, shotFrom);
    func_70012_b(origin.field_72450_a, origin.field_72448_b, origin.field_72449_c, yaw, pitch);
    func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    this.field_70129_M = 0.0F;
    this.field_70159_w = motX;
    this.field_70181_x = motY;
    this.field_70179_y = motZ;
  }
  
  protected void func_70088_a() {}
  
  public void setArrowHeading(double d, double d1, double d2, float spread, float speed) {
    float f2 = MathHelper.func_76133_a(d * d + d1 * d1 + d2 * d2);
    d /= f2;
    d1 /= f2;
    d2 /= f2;
    d *= speed;
    d1 *= speed;
    d2 *= speed;
    d += this.field_70146_Z.nextGaussian() * 0.005D * spread * speed;
    d1 += this.field_70146_Z.nextGaussian() * 0.005D * spread * speed;
    d2 += this.field_70146_Z.nextGaussian() * 0.005D * spread * speed;
    this.field_70159_w = d;
    this.field_70181_x = d1;
    this.field_70179_y = d2;
    float f3 = MathHelper.func_76133_a(d * d + d2 * d2);
    this.field_70126_B = this.field_70177_z = (float)(Math.atan2(d, d2) * 180.0D / 3.1415927410125732D);
    this.field_70127_C = this.field_70125_A = (float)(Math.atan2(d1, f3) * 180.0D / 3.1415927410125732D);
  }
  
  private void getLockOnTarget() {
    if (this.type.lockOnToPlanes || this.type.lockOnToVehicles || this.type.lockOnToMechas || this.type.lockOnToLivings || this.type.lockOnToPlayers) {
      Vector3f motionVec = new Vector3f(this.field_70159_w, this.field_70181_x, this.field_70179_y);
      Entity closestEntity = null;
      float closestAngle = this.type.maxLockOnAngle * 3.1415927F / 180.0F;
      for (Object obj : this.field_70170_p.field_72996_f) {
        Entity entity = (Entity)obj;
        String etype = entity.getEntityData().func_74779_i("EntityType");
        if ((this.type.lockOnToMechas && entity instanceof com.flansmod.common.driveables.mechas.EntityMecha) || (this.type.lockOnToVehicles && entity instanceof com.flansmod.common.driveables.EntityVehicle) || (this.type.lockOnToVehicles && etype
          
          .equals("Vehicle")) || (this.type.lockOnToPlanes && entity instanceof com.flansmod.common.driveables.EntityPlane) || (this.type.lockOnToPlanes && etype
          
          .equals("Plane")) || (this.type.lockOnToPlayers && entity instanceof EntityPlayer) || (this.type.lockOnToLivings && entity instanceof EntityLivingBase)) {
          Vector3f relPosVec = new Vector3f(entity.field_70165_t - this.field_70165_t, entity.field_70163_u - this.field_70163_u, entity.field_70161_v - this.field_70161_v);
          float angle = Math.abs(Vector3f.angle(motionVec, relPosVec));
          Vector3f missileDirection = (Vector3f)motionVec.normalise();
          Vector3f targetDirection = (Vector3f)(new Vector3f(entity.field_70159_w, entity.field_70181_x, entity.field_70179_y)).normalise();
          boolean rearLock = false;
          if (Math.abs(missileDirection.x - targetDirection.x) < 0.5F && Math.abs(missileDirection.y - targetDirection.y) < 0.5F && Math.abs(missileDirection.z - targetDirection.z) < 0.5F)
            rearLock = true; 
          if ((angle < closestAngle && !this.type.earlyInfrared) || this.type.infiniteAngle || (angle < closestAngle && this.type.earlyInfrared && rearLock)) {
            closestEntity = entity;
            closestAngle = angle;
          } 
          if (entity != null && entity instanceof EntityDriveable) {
            EntityDriveable victim = (EntityDriveable)entity;
            float noisiness = 0.0F;
            if (victim != null && victim.throttle > 0.0F)
              noisiness = victim.throttle; 
            if (victim != null && victim.throttle < 0.0F)
              noisiness = Math.abs(victim.throttle) / 2.0F; 
            if (victim != null && (victim.getDriveableType()).hasRadar && victim.activeRadar && 
              this.type.antiRadiation) {
              closestEntity = entity;
              closestAngle = angle;
            } 
            if ((this.owner.field_70154_o != null && victim != this.owner.field_70154_o) || !this.owner.func_70115_ae())
              if (this.type.modernTorpedo && func_70090_H() && this.type.ASWminRange + this.type.seekerRange * noisiness > relPosVec.length()) {
                closestEntity = entity;
                closestAngle = angle;
              }  
          } 
        } 
      } 
      if (closestEntity != null) {
        this.lockedOnTo = closestEntity;
        if (this.owner != null && this.owner instanceof EntityPlayer && this.lockedOnTo instanceof EntityDriveable && !this.field_70170_p.field_72995_K) {
          EntityDriveable target = (EntityDriveable)this.lockedOnTo;
          EntityPlayer human = (EntityPlayer)this.owner;
          human.func_145747_a((IChatComponent)new ChatComponentText(this.type.name + " has successfully locked onto " + (target.getDriveableType()).name));
        } 
      } 
    } 
  }
  
  public void func_70016_h(double d, double d1, double d2) {
    this.field_70159_w = d;
    this.field_70181_x = d1;
    this.field_70179_y = d2;
    if (this.field_70127_C == 0.0F && this.field_70126_B == 0.0F) {
      float f = MathHelper.func_76133_a(d * d + d2 * d2);
      this.field_70126_B = this.field_70177_z = (float)(Math.atan2(d, d2) * 180.0D / 3.1415927410125732D);
      this.field_70127_C = this.field_70125_A = (float)(Math.atan2(d1, f) * 180.0D / 3.1415927410125732D);
      func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
    } 
  }
  
  public void func_70071_h_() {
    super.func_70071_h_();
    this.field_70169_q = this.field_70165_t;
    this.field_70167_r = this.field_70163_u;
    this.field_70166_s = this.field_70161_v;
    if (this.type == null) {
      FlansMod.log("EntityBullet.onUpdate() Error: BulletType is null (" + this + ")");
      func_70106_y();
      return;
    } 
    if (this.field_70173_aa == this.type.lockonDelay && !this.type.modernTorpedo)
      getLockOnTarget(); 
    if (this.type.modernTorpedo && func_70090_H() && !this.lockAttempted) {
      getLockOnTarget();
      this.lockAttempted = true;
    } 
    if (this.type.despawnTime > 0 && this.field_70173_aa > this.type.despawnTime) {
      this.detonated = true;
      func_70106_y();
      return;
    } 
    if (this.field_70173_aa < 10) {
      this.truePen = this.type.armorPen;
      this.isHEAT = this.type.HEAT;
      this.isSword = this.type.swordEnergy;
      this.missNoise = this.type.missNoise;
    } 
    if (this.truePen > 2.0F && this.truePen > 0.5D * this.type.armorPen)
      this.truePen -= this.field_70173_aa * this.type.penDecay; 
    if (this.type.armorPen > 2 && this.truePen < 2.0F)
      this.truePen = 2.0F; 
    if (!this.hasSetSubDelay && this.type.hasSubmunitions) {
      setSubmunitionDelay();
    } else if (this.type.hasSubmunitions) {
      this.submunitionDelay--;
    } 
    if (!this.hasSetVLSDelay && this.type.VLS) {
      this.VLSDelay = this.type.VLSTime;
      this.hasSetVLSDelay = true;
    } 
    if (this.VLSDelay > 0)
      this.VLSDelay--; 
    if (!this.hasSetLook && this.owner != null) {
      this.lookVector = new Vector3f((float)(this.owner.func_70040_Z()).field_72450_a, (float)(this.owner.func_70040_Z()).field_72448_b, (float)(this.owner.func_70040_Z()).field_72449_c);
      this.initialPos = new Vector3f(this.owner.field_70165_t, this.owner.field_70163_u, this.owner.field_70161_v);
      this.hasSetLook = true;
    } 
    if (this.soundTime > 0)
      this.soundTime--; 
    if (this.owner != null) {
      double rangeX = this.owner.field_70165_t - this.field_70165_t;
      double rangeY = this.owner.field_70163_u - this.field_70163_u;
      double rangeZ = this.owner.field_70161_v - this.field_70161_v;
      double range = Math.sqrt(rangeX * rangeX + rangeY * rangeY + rangeZ * rangeZ);
      if (this.type.maxRange != -1 && this.type.maxRange < range) {
        if (this.field_70173_aa > this.type.fuse && this.type.fuse > 0)
          detonate(); 
        func_70106_y();
      } 
    } else {
      func_70106_y();
    } 
    this.ticksInAir++;
    if (this.ticksInAir > this.type.fuse && this.type.fuse > 0 && !this.field_70128_L)
      func_70106_y(); 
    if (this.field_70173_aa > bulletLife)
      func_70106_y(); 
    if (this.field_70128_L)
      return; 
    if (!this.field_70170_p.field_72995_K) {
      if (this.field_70173_aa > this.type.fuse && this.type.fuse > 0)
        detonate(); 
      if (this.type.livingProximityTrigger > 0.0F || this.type.driveableProximityTrigger > 0.0F) {
        float checkRadius = Math.max(this.type.livingProximityTrigger, this.type.driveableProximityTrigger);
        List list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(checkRadius, checkRadius, checkRadius));
        for (Object obj : list) {
          if (obj == this.owner && this.field_70173_aa < 10)
            continue; 
          if (obj instanceof EntityLivingBase && func_70032_d((Entity)obj) < this.type.livingProximityTrigger) {
            if (TeamsManager.getInstance() != null && (TeamsManager.getInstance()).currentRound != null && obj instanceof EntityPlayerMP && this.owner instanceof EntityPlayer && 
              !(TeamsManager.getInstance()).currentRound.gametype.playerAttacked((EntityPlayerMP)obj, (DamageSource)new EntityDamageSourceFlans(this.type.shortName, this, (EntityPlayer)this.owner, this.type, false, false)))
              continue; 
            if (this.type.damageToTriggerer > 0.0F)
              ((EntityLivingBase)obj).func_70097_a(getBulletDamage(false), this.type.damageToTriggerer); 
            FlansMod.proxy.spawnParticle("redstone", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
            detonate();
            break;
          } 
          if (obj instanceof EntityDriveable && func_70032_d((Entity)obj) < this.type.driveableProximityTrigger) {
            if (this.type.damageToTriggerer > 0.0F)
              ((EntityDriveable)obj).func_70097_a(getBulletDamage(false), this.type.damageToTriggerer); 
            detonate();
            break;
          } 
        } 
      } 
    } 
    ArrayList<BulletHit> hits = new ArrayList<>();
    Vector3f origin = new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    Vector3f motion = new Vector3f(this.field_70159_w, this.field_70181_x, this.field_70179_y);
    float hitBoxSize = (this.type.hitBoxSize >= 0.0F) ? this.type.hitBoxSize : 0.0F;
    float speed = motion.length();
    this.speedA = speed;
    if (this.type.hasSubmunitions && 
      this.submunitionDelay < 0) {
      DeploySubmunitions();
      this.submunitionDelay = 9001;
    } 
    for (int i = 0; i < this.field_70170_p.field_72996_f.size(); i++) {
      Object obj = this.field_70170_p.field_72996_f.get(i);
      if (obj instanceof EntityDriveable) {
        EntityDriveable driveable = (EntityDriveable)obj;
        if (!driveable.isDead() && !driveable.isPartOfThis(this.owner) && !driveable.hitboxPartOfThis(this.owner))
          if (func_70032_d((Entity)driveable) <= (driveable.getDriveableType()).bulletDetectionRadius + speed)
            if ((driveable.getDriveableType()).autisticHitDetection) {
              ArrayList<BulletHit> driveableHits = driveable.attackFromBullet(origin, motion);
              hits.addAll(driveableHits);
            } else {
              ArrayList<BulletHit> driveableHiterinos = driveable.attackFromBulletClassic(origin, motion);
              hits.addAll(driveableHiterinos);
            }   
        continue;
      } 
      if (obj instanceof EntityPlayer) {
        EntityPlayer player = (EntityPlayer)obj;
        PlayerData data = PlayerHandler.getPlayerData(player);
        boolean shouldDoNormalHitDetect = false;
        if (data != null) {
          PlayerSnapshot snapshot;
          if (player.field_70128_L || data.team == Team.spectators)
            continue; 
          if (player == this.owner && this.ticksInAir < 20)
            continue; 
          int snapshotToTry = TeamsManager.bulletSnapshotMin;
          if (TeamsManager.bulletSnapshotDivisor > 0)
            snapshotToTry += this.pingOfShooter / TeamsManager.bulletSnapshotDivisor; 
          if (snapshotToTry >= data.snapshots.length)
            snapshotToTry = data.snapshots.length - 1; 
          if (data.snapshots[snapshotToTry] != null) {
            snapshot = data.snapshots[snapshotToTry];
          } else {
            snapshot = data.snapshots[0];
          } 
          if (snapshot == null) {
            shouldDoNormalHitDetect = true;
          } else {
            ArrayList<BulletHit> playerHits = snapshot.raytrace(origin, motion);
            hits.addAll(playerHits);
          } 
        } 
        if (data == null || shouldDoNormalHitDetect) {
          MovingObjectPosition mop = player.field_70121_D.func_72314_b(hitBoxSize, hitBoxSize, hitBoxSize).func_72327_a(origin.toVec3(), Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y));
          if (mop != null) {
            Vector3f hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - this.field_70165_t, mop.field_72307_f.field_72448_b - this.field_70163_u, mop.field_72307_f.field_72449_c - this.field_70161_v);
            float hitLambda = 1.0F;
            if (motion.x != 0.0F) {
              hitLambda = hitPoint.x / motion.x;
            } else if (motion.y != 0.0F) {
              hitLambda = hitPoint.y / motion.y;
            } else if (motion.z != 0.0F) {
              hitLambda = hitPoint.z / motion.z;
            } 
            if (hitLambda < 0.0F)
              hitLambda = -hitLambda; 
            hits.add(new PlayerBulletHit(new PlayerHitbox(player, new RotatedAxes(), new Vector3f(), new Vector3f(), new Vector3f(), EnumHitboxType.BODY), hitLambda));
          } 
        } 
        continue;
      } 
      Entity entity = (Entity)obj;
      if (entity != this && entity != this.owner && !entity.field_70128_L && !(entity instanceof net.minecraft.entity.item.EntityItem) && !(entity instanceof net.minecraft.entity.item.EntityXPOrb) && !(entity instanceof net.minecraft.entity.projectile.EntityArrow) && (entity
        .getClass().toString().indexOf("flansmod.") < 0 || entity instanceof EntityAAGun || entity instanceof EntityGrenade) && entity
        .getClass().toString().indexOf("holographicdisplays") < 0) {
        AxisAlignedBB bb = entity.field_70121_D.func_72321_a(-(entity.field_70165_t - entity.field_70169_q) * 2.0D, -(entity.field_70163_u - entity.field_70167_r) * 2.0D, -(entity.field_70161_v - entity.field_70166_s) * 2.0D);
        MovingObjectPosition mop = bb.func_72314_b(hitBoxSize, hitBoxSize, hitBoxSize).func_72327_a(origin.toVec3(), Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y));
        if (mop != null) {
          Vector3f hitPoint = new Vector3f(mop.field_72307_f.field_72450_a - this.field_70165_t, mop.field_72307_f.field_72448_b - this.field_70163_u, mop.field_72307_f.field_72449_c - this.field_70161_v);
          float hitLambda = 1.0F;
          if (motion.x != 0.0F) {
            hitLambda = hitPoint.x / motion.x;
          } else if (motion.y != 0.0F) {
            hitLambda = hitPoint.y / motion.y;
          } else if (motion.z != 0.0F) {
            hitLambda = hitPoint.z / motion.z;
          } 
          if (hitLambda < 0.0F)
            hitLambda = -hitLambda; 
          hits.add(new EntityHit(entity, hitLambda));
        } 
      } 
      continue;
    } 
    Vec3 posVec = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    Vec3 nextPosVec = Vec3.func_72443_a(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
    MovingObjectPosition hit = CustomBlockRaytracing.func_147447_a(this.field_70170_p, posVec, nextPosVec, false, true, true);
    posVec = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    if (hit != null) {
      Vec3 hitVec = posVec.func_72444_a(hit.field_72307_f);
      float lambda = 1.0F;
      if (this.field_70159_w != 0.0D) {
        lambda = (float)(hitVec.field_72450_a / this.field_70159_w);
      } else if (this.field_70181_x != 0.0D) {
        lambda = (float)(hitVec.field_72448_b / this.field_70181_x);
      } else if (this.field_70179_y != 0.0D) {
        lambda = (float)(hitVec.field_72449_c / this.field_70179_y);
      } 
      if (lambda < 0.0F)
        lambda = -lambda; 
      hits.add(new BlockHit(hit, lambda));
    } 
    if (!hits.isEmpty()) {
      Collections.sort(hits);
      for (BulletHit bulletHit : hits) {
        if (bulletHit instanceof DriveableHit) {
          if (this.type.entityHitSoundEnable)
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.hitSoundRange, this.field_71093_bK, this.type.hitSound, true); 
          if (this.field_70170_p.field_72995_K && 
            this.owner instanceof EntityPlayer && 
            FlansMod.proxy.isThePlayer((EntityPlayer)this.owner))
            hitCrossHair = true; 
          DriveableHit driveableHit = (DriveableHit)bulletHit;
          driveableHit.driveable.lastAtkEntity = this.owner;
          if ((this.type != null && this.type.swordEnergy && this.driveable != null && this.driveable.getDriveableType() != null && (this.driveable.getDriveableType()).canStab) || !this.type.swordEnergy)
            this.penetratingPower = driveableHit.driveable.bulletHit(this, driveableHit, this.penetratingPower); 
          if (this.type.canSpotEntityDriveable)
            driveableHit.driveable.setEntityMarker(200); 
          if (FlansMod.DEBUG)
            this.field_70170_p.func_72838_d((Entity)new EntityDebugDot(this.field_70170_p, new Vector3f(this.field_70165_t + this.field_70159_w * driveableHit.intersectTime, this.field_70163_u + this.field_70181_x * driveableHit.intersectTime, this.field_70161_v + this.field_70179_y * driveableHit.intersectTime), 1000, 0.0F, 0.0F, 1.0F)); 
        } else if (bulletHit instanceof PlayerBulletHit) {
          if (this.type.entityHitSoundEnable)
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.hitSoundRange, this.field_71093_bK, this.type.hitSound, true); 
          if (this.field_70170_p.field_72995_K && 
            this.owner instanceof EntityPlayer && 
            FlansMod.proxy.isThePlayer((EntityPlayer)this.owner))
            hitCrossHair = true; 
          PlayerBulletHit playerHit = (PlayerBulletHit)bulletHit;
          this.penetratingPower = playerHit.hitbox.hitByBullet(this, this.penetratingPower);
          if (FlansMod.DEBUG)
            this.field_70170_p.func_72838_d((Entity)new EntityDebugDot(this.field_70170_p, new Vector3f(this.field_70165_t + this.field_70159_w * playerHit.intersectTime, this.field_70163_u + this.field_70181_x * playerHit.intersectTime, this.field_70161_v + this.field_70179_y * playerHit.intersectTime), 1000, 1.0F, 0.0F, 0.0F)); 
        } else if (bulletHit instanceof EntityHit) {
          if (this.type.entityHitSoundEnable)
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.hitSoundRange, this.field_71093_bK, this.type.hitSound, true); 
          if (this.field_70170_p.field_72995_K && 
            this.owner instanceof EntityPlayer && 
            FlansMod.proxy.isThePlayer((EntityPlayer)this.owner)) {
            hitCrossHair = true;
            penAmount = 1.0F;
            headshot = false;
          } 
          EntityHit entityHit = (EntityHit)bulletHit;
          float d = this.damage;
          if (entityHit.entity instanceof EntityLivingBase) {
            if (this.field_70173_aa > this.type.dynamicBulletDelay) {
              d *= this.type.dynamicDamage;
            } else {
              d *= this.type.damageVsLiving;
            } 
            if (entityHit.entity != this.owner)
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.blood", entityHit.entity.field_70165_t, entityHit.entity.field_70163_u + 1.0D, entityHit.entity.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), entityHit.entity.field_70165_t, entityHit.entity.field_70163_u, entityHit.entity.field_70161_v, 150.0F, this.field_71093_bK); 
            if (d > 40.0F) {
              PacketPlaySound.sendSoundPacket(entityHit.entity.field_70165_t, entityHit.entity.field_70163_u, entityHit.entity.field_70161_v, 15.0D, this.field_71093_bK, "goreDeath", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.overkill", entityHit.entity.field_70165_t, entityHit.entity.field_70163_u - 4.0D, entityHit.entity.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), entityHit.entity.field_70165_t, entityHit.entity.field_70163_u, entityHit.entity.field_70161_v, 150.0F, this.field_71093_bK);
            } 
          } else {
            if (this.field_70173_aa > this.type.dynamicBulletDelay) {
              d *= this.type.dynamicDamage;
            } else {
              d *= this.type.damageVsEntity;
            } 
            if (d > 40.0F) {
              PacketPlaySound.sendSoundPacket(entityHit.entity.field_70165_t, entityHit.entity.field_70163_u, entityHit.entity.field_70161_v, 15.0D, this.field_71093_bK, "goreDeath", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.overkill", entityHit.entity.field_70165_t, entityHit.entity.field_70163_u - 4.0D, entityHit.entity.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), entityHit.entity.field_70165_t, entityHit.entity.field_70163_u, entityHit.entity.field_70161_v, 150.0F, this.field_71093_bK);
            } 
          } 
          if (entityHit.entity.func_70097_a(getBulletDamage(false), d) && entityHit.entity instanceof EntityLivingBase) {
            EntityLivingBase living = (EntityLivingBase)entityHit.entity;
            for (PotionEffect effect : this.type.hitEffects)
              living.func_70690_d(new PotionEffect(effect)); 
            living.field_70720_be++;
            living.field_70172_ad = living.field_70771_an / 2;
          } 
          if (this.type.setEntitiesOnFire)
            entityHit.entity.func_70015_d(20); 
          this.penetratingPower--;
          if (FlansMod.DEBUG) {
            this.field_70170_p.func_72838_d((Entity)new EntityDebugDot(this.field_70170_p, new Vector3f(this.field_70165_t + this.field_70159_w * entityHit.intersectTime, this.field_70163_u + this.field_70181_x * entityHit.intersectTime, this.field_70161_v + this.field_70179_y * entityHit.intersectTime), 1000, 1.0F, 1.0F, 0.0F));
            FlansMod.log(entityHit.entity.toString() + ": d=" + d + ": damage=" + this.damage + ": type.damageVsEntity=" + this.type.damageVsEntity);
          } 
        } else if (bulletHit instanceof BlockHit) {
          BlockHit blockHit = (BlockHit)bulletHit;
          MovingObjectPosition raytraceResult = blockHit.raytraceResult;
          int xTile = raytraceResult.field_72311_b;
          int yTile = raytraceResult.field_72312_c;
          int zTile = raytraceResult.field_72309_d;
          if (FlansMod.DEBUG)
            this.field_70170_p.func_72838_d((Entity)new EntityDebugDot(this.field_70170_p, new Vector3f(raytraceResult.field_72307_f.field_72450_a, raytraceResult.field_72307_f.field_72448_b, raytraceResult.field_72307_f.field_72449_c), 1000, 0.0F, 1.0F, 0.0F)); 
          Block block = this.field_70170_p.func_147439_a(xTile, yTile, zTile);
          Material mat = block.func_149688_o();
          if (this.type.breaksGlass && mat == Material.field_151592_s && 
            TeamsManager.canBreakGlass) {
            this.field_70170_p.func_147468_f(xTile, yTile, zTile);
            FlansMod.proxy.playBlockBreakSound(xTile, yTile, zTile, block, this.field_71093_bK);
          } 
          if (this.field_70170_p.field_72995_K && 
            block.func_149688_o() != Material.field_151579_a && this.type.explosionRadius <= 0.0F) {
            int num = 2 + this.field_70146_Z.nextInt(3);
            for (int j = 0; j < num; j++) {
              FlansMod.proxy.spawnParticle("blockcrack_" + 
                  Block.func_149682_b(block) + "_" + this.field_70170_p.func_72805_g(xTile, yTile, zTile), raytraceResult.field_72307_f.field_72450_a + (this.field_70146_Z
                  .nextFloat() - 0.5D) * this.field_70130_N, raytraceResult.field_72307_f.field_72448_b + 0.1D, raytraceResult.field_72307_f.field_72449_c + (this.field_70146_Z
                  
                  .nextFloat() - 0.5D) * this.field_70130_N, -this.field_70159_w * 4.0D, 1.5D, -this.field_70179_y * 4.0D);
              FlansMod.proxy.spawnParticle("explode", raytraceResult.field_72307_f.field_72450_a, raytraceResult.field_72307_f.field_72448_b, raytraceResult.field_72307_f.field_72449_c, 0.0D, 0.0D, 0.0D);
            } 
          } 
          func_70107_b(hit.field_72307_f.field_72450_a, hit.field_72307_f.field_72448_b, hit.field_72307_f.field_72449_c);
          if (this.type.hitSoundEnable)
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.hitSoundRange, this.field_71093_bK, this.type.hitSound, true); 
          func_70106_y();
          break;
        } 
        if (this.penetratingPower <= 0.0F || (this.type.explodeOnImpact && this.ticksInAir > 1 && !(bulletHit instanceof PlayerBulletHit))) {
          func_70107_b(this.field_70165_t + this.field_70159_w * bulletHit.intersectTime, this.field_70163_u + this.field_70181_x * bulletHit.intersectTime, this.field_70161_v + this.field_70179_y * bulletHit.intersectTime);
          func_70106_y();
          break;
        } 
      } 
    } 
    float drag = this.type.dragInAir;
    float gravity = 0.02F;
    if (func_70090_H()) {
      for (int j = 0; j < 4; j++) {
        float bubbleMotion = 0.25F;
        this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * bubbleMotion, this.field_70163_u - this.field_70181_x * bubbleMotion, this.field_70161_v - this.field_70179_y * bubbleMotion, this.field_70159_w, this.field_70181_x + 0.10000000149011612D, this.field_70179_y);
      } 
      drag = this.type.dragInWater;
    } 
    if (!this.type.torpedo && !this.type.modernTorpedo) {
      this.field_70159_w *= drag;
      this.field_70181_x *= drag;
      this.field_70179_y *= drag;
      this.field_70181_x -= (gravity * this.type.fallSpeed);
      if (this.type.jamiogravity)
        this.field_70181_x *= 0.9800000190734863D; 
    } 
    if (this.lockedOnTo != null) {
      if (this.lockedOnTo instanceof EntityDriveable) {
        EntityDriveable entDriveable = (EntityDriveable)this.lockedOnTo;
        if ((entDriveable.getDriveableType()).lockedOnSound != null && this.soundTime <= 0 && !this.field_70170_p.field_72995_K) {
          PacketPlaySound.sendSoundPacket(this.lockedOnTo.field_70165_t, this.lockedOnTo.field_70163_u, this.lockedOnTo.field_70161_v, 
              (entDriveable.getDriveableType()).lockedOnSoundRange, this.field_71093_bK, (entDriveable.getDriveableType()).lockedOnSound, false);
          this.soundTime = (entDriveable.getDriveableType()).soundTime;
        } 
      } else {
        this.lockedOnTo.getEntityData().func_74757_a("Tracking", true);
      } 
      if (this.field_70173_aa > this.type.tickStartHoming) {
        double dY, dXYZ, dX = this.lockedOnTo.field_70165_t - this.field_70165_t;
        if (this.type.isDoTopAttack && Math.abs(this.lockedOnTo.field_70165_t - this.field_70165_t) > 2.0D && Math.abs(this.lockedOnTo.field_70161_v - this.field_70161_v) > 2.0D) {
          dY = this.lockedOnTo.field_70163_u + 30.0D - this.field_70163_u;
        } else {
          dY = this.lockedOnTo.field_70163_u - this.field_70163_u;
        } 
        double dZ = this.lockedOnTo.field_70161_v - this.field_70161_v;
        if (!this.type.isDoTopAttack) {
          dXYZ = func_70032_d(this.lockedOnTo);
        } else {
          dXYZ = Math.sqrt(dX * dX + dY * dY + dZ * dZ);
        } 
        if (this.owner != null && this.type.enableSACLOS) {
          double dXp = this.lockedOnTo.field_70165_t - this.owner.field_70165_t;
          double dYp = this.lockedOnTo.field_70163_u - this.owner.field_70163_u;
          double dZp = this.lockedOnTo.field_70161_v - this.owner.field_70161_v;
          Vec3 playerVec = this.owner.func_70040_Z();
          Vector3f playerVec3f = new Vector3f(playerVec.field_72450_a, playerVec.field_72448_b, playerVec.field_72449_c);
          double angles = Math.abs(Vector3f.angle(playerVec3f, new Vector3f(dXp, dYp, dZp)));
          if (angles > Math.toRadians(this.type.maxDegreeOfSACLOS))
            this.lockedOnTo = null; 
        } 
        if (this.toggleLock) {
          if (dXYZ > this.type.maxRangeOfMissile)
            this.lockedOnTo = null; 
          this.toggleLock = false;
        } 
        double dmotion = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
        Vector3f motionVector = new Vector3f(dX * dmotion / dXYZ, dY * dmotion / dXYZ, dZ * dmotion / dXYZ);
        double angle = Math.abs(Vector3f.angle(motion, motionVector));
        if (angle > Math.toRadians(this.type.maxDegreeOfMissile) && !this.type.infiniteAngle && !this.type.antiRadiation && !this.type.modernTorpedo) {
          this.lockedOnTo = null;
        } else {
          this.field_70159_w = motionVector.x;
          this.field_70181_x = motionVector.y;
          this.field_70179_y = motionVector.z;
        } 
        if (this.field_70173_aa > 4 && dXYZ > this.prevDistanceToEntity) {
          this.closeCount++;
          if (this.closeCount > 15)
            this.lockedOnTo = null; 
        } else if (this.closeCount > 0) {
          this.closeCount--;
        } 
        this.prevDistanceToEntity = dXYZ;
      } 
      if (this.lockedOnTo instanceof EntityDriveable) {
        EntityDriveable plane = (EntityDriveable)this.lockedOnTo;
        if (plane.varFlare || plane.ticksFlareUsing > 0) {
          this.lockedOnTo = null;
          if (this.owner != null && this.owner instanceof EntityPlayer && !this.field_70170_p.field_72995_K) {
            EntityDriveable target = (EntityDriveable)this.lockedOnTo;
            EntityPlayer human = (EntityPlayer)this.owner;
            human.func_145747_a((IChatComponent)new ChatComponentText("Enemy flares have broken " + this.type.name + "'s lock!"));
          } 
        } 
      } else if (this.lockedOnTo != null && this.lockedOnTo.getEntityData().func_74767_n("FlareUsing")) {
        this.lockedOnTo = null;
      } 
    } 
    if (this.owner != null && this.type.shootForSettingPos && !this.isFirstPositionSetting) {
      if (this.owner instanceof EntityPlayer) {
        EntityPlayer entP = (EntityPlayer)this.owner;
        if (entP.func_71045_bC() != null && 
          entP.func_71045_bC().func_77973_b() instanceof ItemGun) {
          ItemGun itemGun = (ItemGun)entP.func_71045_bC().func_77973_b();
          this.impactX = itemGun.impactX;
          this.impactY = itemGun.impactY;
          this.impactZ = itemGun.impactZ;
        } 
      } 
      this.isFirstPositionSetting = true;
    } 
    if (this.type.shootForSettingPos && this.isFirstPositionSetting && this.isPositionUpper) {
      double motionXa = this.field_70159_w;
      double motionYa = this.field_70181_x;
      double motionZa = this.field_70179_y;
      double motiona = Math.sqrt(motionXa * motionXa + motionYa * motionYa + motionZa * motionZa);
      this.field_70159_w = 0.0D;
      this.field_70181_x = motiona;
      this.field_70179_y = 0.0D;
      if (this.field_70163_u - this.type.shootForSettingPosHeight > this.owner.field_70163_u)
        this.isPositionUpper = false; 
    } 
    if (this.type.shootForSettingPos && this.isFirstPositionSetting && !this.isPositionUpper) {
      double rootx = this.impactX - this.field_70165_t;
      double rootz = this.impactZ - this.field_70161_v;
      double roota = Math.sqrt(rootx * rootx + rootz * rootz);
      double motionXa = this.field_70159_w;
      double motionYa = this.field_70181_x;
      double motionZa = this.field_70179_y;
      double motiona = Math.sqrt(motionXa * motionXa + motionYa * motionYa + motionZa * motionZa);
      this.field_70159_w = rootx * motiona / roota;
      this.field_70179_y = rootz * motiona / roota;
      if (Math.abs(this.impactX - this.field_70165_t) < 1.0D && Math.abs(this.impactZ - this.field_70161_v) < 1.0D) {
        double motionXab = this.field_70159_w;
        double motionYab = this.field_70181_x;
        double motionZab = this.field_70179_y;
        double motionab = Math.sqrt(motionXa * motionXa + motionYa * motionYa + motionZa * motionZa);
        this.field_70159_w = 0.0D;
        this.field_70181_x = -motionab;
        this.field_70179_y = 0.0D;
      } 
    } 
    this.field_70155_l = 256.0D;
    if (this.owner != null && this.type.manualGuidance && this.VLSDelay <= 0 && this.lockedOnTo == null) {
      this.field_70155_l = 256.0D;
      Vector3f lookVec = new Vector3f((float)(this.owner.func_70040_Z()).field_72450_a, (float)(this.owner.func_70040_Z()).field_72448_b, (float)(this.owner.func_70040_Z()).field_72449_c);
      Vector3f origin2 = new Vector3f(this.owner.field_70165_t, this.owner.field_70163_u, this.owner.field_70161_v);
      if (this.type.fixedDirection) {
        lookVec = this.lookVector;
        origin2 = this.initialPos;
      } 
      float x = (float)(this.field_70165_t - origin2.x);
      float y = (float)(this.field_70163_u - origin2.y);
      float z = (float)(this.field_70161_v - origin2.z);
      float d = (float)Math.sqrt((x * x + y * y + z * z));
      d += this.type.turnRadius;
      lookVec.normalise();
      Vector3f targetPoint = new Vector3f(origin2.x + lookVec.x * d, origin2.y + lookVec.y * d, origin2.z + lookVec.z * d);
      Vector3f diff = Vector3f.sub(targetPoint, new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v), null);
      float speed2 = this.type.trackPhaseSpeed;
      float turnSpeed = this.type.trackPhaseTurn;
      diff.normalise();
      turnSpeed = 0.1F;
      Vector3f targetSpeed = new Vector3f(diff.x * speed2, diff.y * speed2, diff.z * speed2);
      this.field_70159_w += (targetSpeed.x - this.field_70159_w) * turnSpeed;
      this.field_70181_x += (targetSpeed.y - this.field_70181_x) * turnSpeed;
      this.field_70179_y += (targetSpeed.z - this.field_70179_y) * turnSpeed;
    } 
    if (this.type.torpedo || (this.type.modernTorpedo && this.lockedOnTo == null))
      if (func_70090_H()) {
        Vector3f motion2 = new Vector3f(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        float length = motion.length();
        motion.normalise();
        this.field_70159_w = (motion.x * 1.0F);
        this.field_70179_y = (motion.z * 1.0F);
        if (!this.type.modernTorpedo)
          this.field_70181_x *= 0.30000001192092896D; 
      } else {
        this.field_70181_x -= (gravity * this.type.fallSpeed * 2.5F);
      }  
    if (this.type.depthCharge) {
      if (!func_70090_H()) {
        this.field_70181_x -= (gravity * this.type.fallSpeed);
        if (this.field_70181_x > 0.10000000149011612D)
          this.field_70181_x *= 0.8999999761581421D; 
      } 
      if (TeamsManager.seaLevel - this.field_70163_u <= this.type.activationDepth && func_70090_H()) {
        this.field_70181_x -= (gravity * this.type.fallSpeed);
        this.field_70159_w = 0.0D;
        this.field_70179_y = 0.0D;
      } 
      if (TeamsManager.seaLevel - this.field_70163_u > this.type.activationDepth && func_70090_H())
        detonate(); 
    } 
    func_70107_b(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
    float motionXZ = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
    this.field_70177_z = (float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.1415927410125732D);
    this.field_70125_A = (float)(Math.atan2(this.field_70181_x, motionXZ) * 180.0D / 3.1415927410125732D);
    for (; this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F);
    for (; this.field_70125_A - this.field_70127_C >= 180.0F; this.field_70127_C += 360.0F);
    for (; this.field_70177_z - this.field_70126_B < -180.0F; this.field_70126_B -= 360.0F);
    for (; this.field_70177_z - this.field_70126_B >= 180.0F; this.field_70126_B += 360.0F);
    this.field_70125_A = this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F;
    this.field_70177_z = this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F;
    if (this.type.trailParticles && this.field_70170_p.field_72995_K && this.ticksInAir > 1)
      spawnParticles(); 
    if (this.field_70173_aa == 3) {
      this.maxspeed = (float)Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
      this.initialX = (float)this.field_70159_w;
      this.initialY = (float)this.field_70181_x;
      this.initialZ = (float)this.field_70179_y;
    } 
    if (this.type.trueManual && this.owner != null && this.owner.func_70115_ae() && (this.owner.field_70154_o instanceof EntitySeat || this.owner.field_70154_o instanceof EntityDriveable)) {
      EntityDriveable driverino = null;
      if (this.owner.field_70154_o instanceof EntitySeat) {
        EntitySeat seaterino = (EntitySeat)this.owner.field_70154_o;
        driverino = seaterino.driveable;
      } else if (this.owner.field_70154_o instanceof EntityDriveable) {
        driverino = (EntityDriveable)this.owner.field_70154_o;
      } 
      if (driverino != null) {
        float cancerZ = -MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * this.type.joystickSensitivity * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F);
        float cancerX = MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * this.type.joystickSensitivity * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F);
        float fakeY = this.initialY - gravity * this.type.fallSpeed * this.field_70173_aa;
        Vector3f direction = new Vector3f(this.field_70159_w, this.field_70181_x, this.field_70179_y);
        direction.normalise();
        if ((this.initialX > 0.5F && this.initialX > 0.0F) || (this.initialX < 0.0F && this.initialX > -0.5F && this.initialZ < 0.5F) || (this.initialX > 0.0F && this.initialZ < 0.5F)) {
          this.field_70179_y -= (driverino.yawSignal / 100.0F * this.type.joystickSensitivity * (1.0F - Math.abs(direction.z)));
          this.field_70159_w -= (driverino.yawSignal / 100.0F * this.type.joystickSensitivity * (1.0F - Math.abs(direction.x)));
        } else {
          this.field_70179_y += (driverino.yawSignal / 100.0F * this.type.joystickSensitivity * (1.0F - Math.abs(direction.z)));
          this.field_70159_w += (driverino.yawSignal / 100.0F * this.type.joystickSensitivity * (1.0F - Math.abs(direction.x)));
        } 
        this.field_70181_x += (driverino.pitchSignal / 120.0F * this.type.joystickSensitivity * (1.0F - Math.abs(direction.y)));
      } 
    } 
    if (this.field_70170_p.field_72995_K)
      func_70066_B(); 
  }
  
  @SideOnly(Side.CLIENT)
  private void spawnParticles() {
    double dX = (this.field_70165_t - this.field_70169_q) / 10.0D;
    double dY = (this.field_70163_u - this.field_70167_r) / 10.0D;
    double dZ = (this.field_70161_v - this.field_70166_s) / 10.0D;
    float spread = 0.1F;
    if (this.VLSDelay > 0 && this.type.boostPhaseParticle != null) {
      for (int i = 0; i < 10; i++)
        FlansMod.proxy.spawnParticle(this.type.boostPhaseParticle, this.field_70169_q + dX * i + this.field_70146_Z
            .nextGaussian() * spread, this.field_70167_r + dY * i + this.field_70146_Z.nextGaussian() * spread, this.field_70166_s + dZ * i + this.field_70146_Z.nextGaussian() * spread, 0.0D, 0.0D, 0.0D); 
    } else if (!this.type.VLS || this.VLSDelay <= 0) {
      for (int i = 0; i < 10; i++)
        FlansMod.proxy.spawnParticle(this.type.trailParticleType, this.field_70169_q + dX * i + this.field_70146_Z
            .nextGaussian() * spread, this.field_70167_r + dY * i + this.field_70146_Z.nextGaussian() * spread, this.field_70166_s + dZ * i + this.field_70146_Z.nextGaussian() * spread, 0.0D, 0.0D, 0.0D); 
    } 
  }
  
  @SideOnly(Side.CLIENT)
  private void spawnHitParticles(double x, double y, double z) {
    FlansMod.proxy.spawnParticle("explode", x, y, z, 0.0D, 0.0D, 0.0D);
  }
  
  public DamageSource getBulletDamage(boolean headshot) {
    if (this.owner instanceof EntityPlayer)
      return (new EntityDamageSourceFlans(this.type.shortName, this, (EntityPlayer)this.owner, this.firedFrom, headshot, false)).func_76349_b(); 
    return (new EntityDamageSourceIndirect(this.type.shortName, this, this.owner)).func_76349_b();
  }
  
  private boolean isPartOfOwner(Entity entity) {
    if (this.owner == null)
      return false; 
    if (entity == this.owner || entity == this.owner.field_70153_n || entity == this.owner.field_70154_o)
      return true; 
    if (this.owner instanceof EntityPlayer) {
      if (PlayerHandler.getPlayerData((EntityPlayer)this.owner, this.field_70170_p.field_72995_K ? Side.CLIENT : Side.SERVER) == null)
        return false; 
      EntityMG mg = (PlayerHandler.getPlayerData((EntityPlayer)this.owner, this.field_70170_p.field_72995_K ? Side.CLIENT : Side.SERVER)).mountingGun;
      if (mg != null && mg == entity)
        return true; 
    } 
    return (this.owner.field_70154_o instanceof EntitySeat && (((EntitySeat)this.owner.field_70154_o).driveable == null || ((EntitySeat)this.owner.field_70154_o).driveable.isPartOfThis(entity)));
  }
  
  public void func_70106_y() {
    try {
      if (this.field_70128_L)
        return; 
      super.func_70106_y();
      if (this.field_70170_p.field_72995_K)
        return; 
      if (this.type.explosionRadius > 0.0F)
        if (this.owner instanceof EntityPlayer) {
          new FlansModExplosion(this.field_70170_p, this, (EntityPlayer)this.owner, this.type, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.explosionRadius, (TeamsManager.explosions && this.type.explosionBreaksBlocks), this.type.explosionDamageVsLiving, this.type.explosionDamageVsPlayer, this.type.explosionDamageVsPlane, this.type.explosionDamageVsVehicle, this.type.smokeParticleCount, this.type.debrisParticleCount);
        } else {
          this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.explosionRadius, TeamsManager.explosions);
        }  
      if (this.type.fireRadius > 0.0F)
        for (float i = -this.type.fireRadius; i < this.type.fireRadius; i++) {
          for (float k = -this.type.fireRadius; k < this.type.fireRadius; k++) {
            for (int j = -1; j < 1; j++) {
              if (this.field_70170_p.func_147439_a((int)(this.field_70165_t + i), (int)(this.field_70163_u + j), (int)(this.field_70161_v + k)).func_149688_o() == Material.field_151579_a)
                this.field_70170_p.func_147449_b((int)(this.field_70165_t + i), (int)(this.field_70163_u + j), (int)(this.field_70161_v + k), (Block)Blocks.field_150480_ab); 
            } 
          } 
        }  
      if (this.type.flak > 0)
        FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.flak, this.type.flakParticles), this.field_70165_t, this.field_70163_u, this.field_70161_v, 200.0F, this.field_71093_bK); 
      if (this.type.dropItemOnHit != null) {
        String itemName = this.type.dropItemOnHit;
        int damage = 0;
        if (itemName.contains(".")) {
          damage = Integer.parseInt(itemName.split("\\.")[1]);
          itemName = itemName.split("\\.")[0];
        } 
        ItemStack dropStack = InfoType.getRecipeElement(itemName, damage);
        func_70099_a(dropStack, 1.0F);
      } 
    } catch (Exception e) {
      if (FlansMod.printStackTrace)
        e.printStackTrace(); 
    } 
  }
  
  public float moveToTarget(float current, float target, float speed) {
    float pitchToMove = (float)(Math.sqrt((target * target)) - Math.sqrt((current * current)));
    for (; pitchToMove > 180.0F; pitchToMove -= 360.0F);
    for (; pitchToMove <= -180.0F; pitchToMove += 360.0F);
    float signDeltaY = 0.0F;
    if (pitchToMove > speed) {
      signDeltaY = 1.0F;
    } else if (pitchToMove < -speed) {
      signDeltaY = -1.0F;
    } else {
      signDeltaY = 0.0F;
      return target;
    } 
    if (current > target) {
      current -= speed;
    } else if (current < target) {
      current += speed;
    } 
    return current;
  }
  
  public void detonate() {
    if (this.field_70173_aa < this.type.primeDelay)
      return; 
    if (this.detonated)
      return; 
    this.detonated = true;
    PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.type.detonateSound, true);
    if (!this.field_70170_p.field_72995_K && this.type.explosionRadius > 0.1F)
      if (this.owner instanceof EntityPlayer) {
        new FlansModExplosion(this.field_70170_p, this, (EntityPlayer)this.owner, this.type, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.explosionRadius, (TeamsManager.explosions && this.type.explosionBreaksBlocks), this.type.explosionDamageVsLiving, this.type.explosionDamageVsPlayer, this.type.explosionDamageVsPlane, this.type.explosionDamageVsVehicle, this.type.smokeParticleCount, this.type.debrisParticleCount);
        this.field_70128_L = true;
      } else {
        this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.type.explosionRadius, (TeamsManager.explosions && this.type.explosionBreaksBlocks));
        this.field_70128_L = true;
      }  
    if (!this.field_70170_p.field_72995_K && this.type.fireRadius > 0.1F)
      for (float f = -this.type.fireRadius; f < this.type.fireRadius; f++) {
        for (float j = -this.type.fireRadius; j < this.type.fireRadius; j++) {
          for (float k = -this.type.fireRadius; k < this.type.fireRadius; k++) {
            int x = MathHelper.func_76128_c(f + this.field_70165_t);
            int y = MathHelper.func_76128_c(j + this.field_70163_u);
            int z = MathHelper.func_76128_c(k + this.field_70161_v);
            if (f * f + j * j + k * k <= this.type.fireRadius * this.type.fireRadius && this.field_70170_p.func_147439_a(x, y, z) == Blocks.field_150350_a && this.field_70146_Z.nextBoolean())
              this.field_70170_p.func_147465_d(x, y, z, (Block)Blocks.field_150480_ab, 0, 3); 
          } 
        } 
      }  
    for (int i = 0; i < this.type.explodeParticles; i++)
      this.field_70170_p.func_72869_a(this.type.explodeParticleType, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70146_Z.nextGaussian(), this.field_70146_Z.nextGaussian(), this.field_70146_Z.nextGaussian()); 
    if (!this.field_70170_p.field_72995_K && this.type.dropItemOnDetonate != null) {
      String itemName = this.type.dropItemOnDetonate;
      int damage = 0;
      if (itemName.contains(".")) {
        damage = Integer.parseInt(itemName.split("\\.")[1]);
        itemName = itemName.split("\\.")[0];
      } 
      ItemStack dropStack = InfoType.getRecipeElement(itemName, damage);
      func_70099_a(dropStack, 1.0F);
    } 
  }
  
  public void func_70014_b(NBTTagCompound tag) {
    if (this.type == null) {
      FlansMod.log("EntityBullet.writeEntityToNBT() Error: BulletType is null (" + this + ")");
      func_70106_y();
      return;
    } 
    tag.func_74778_a("type", this.type.shortName);
    if (this.owner == null) {
      tag.func_74778_a("owner", "null");
    } else {
      tag.func_74778_a("owner", this.owner.func_70005_c_());
    } 
  }
  
  public void func_70037_a(NBTTagCompound tag) {
    String typeString = tag.func_74779_i("type");
    String ownerName = tag.func_74779_i("owner");
    if (typeString != null)
      this.type = BulletType.getBullet(typeString); 
    if (this.type == null) {
      this.field_70128_L = true;
      return;
    } 
    if (this.type.despawnTime <= 0)
      this.field_70128_L = true; 
    if (ownerName != null && !ownerName.equals("null"))
      this.owner = (Entity)FMLCommonHandler.instance().getMinecraftServerInstance().func_71203_ab().func_152612_a(ownerName); 
  }
  
  public float func_70053_R() {
    return this.type.hitBoxSize;
  }
  
  public void setSubmunitionDelay() {
    this.submunitionDelay = this.type.subMunitionTimer;
    this.hasSetSubDelay = true;
  }
  
  public void DeploySubmunitions() {
    ItemShootable itemShootable = (ItemShootable)GameRegistry.findItem("flansmod", this.type.submunition);
    ShootableType shootType = itemShootable.type;
    World world = this.field_70170_p;
    EntityLivingBase entityplayer = (EntityLivingBase)this.owner;
    for (int sm = 0; sm < this.type.numSubmunitions; sm++)
      world.func_72838_d(itemShootable.getEntity(world, new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v), new Vector3f(this.field_70159_w, this.field_70181_x, this.field_70179_y), entityplayer, this.type.submunitionSpread, this.damage, this.speedA, 0, this.firedFrom)); 
    if (this.type.destroyOnDeploySubmunition)
      detonate(); 
  }
  
  public int func_70070_b(float par1) {
    if (this.type.hasLight)
      return 15728880; 
    int i = MathHelper.func_76128_c(this.field_70165_t);
    int j = MathHelper.func_76128_c(this.field_70161_v);
    if (this.field_70170_p.func_72899_e(i, 0, j)) {
      double d0 = (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * 0.66D;
      int k = MathHelper.func_76128_c(this.field_70163_u - this.field_70129_M + d0);
      return this.field_70170_p.func_72802_i(i, k, j, 0);
    } 
    return 0;
  }
  
  public void writeSpawnData(ByteBuf data) {
    data.writeDouble(this.field_70159_w);
    data.writeDouble(this.field_70181_x);
    data.writeDouble(this.field_70179_y);
    data.writeInt(this.impactX);
    data.writeInt(this.impactY);
    data.writeInt(this.impactZ);
    data.writeInt((this.lockedOnTo == null) ? -1 : this.lockedOnTo.func_145782_y());
    ByteBufUtils.writeUTF8String(data, this.type.shortName);
    if (this.owner == null) {
      ByteBufUtils.writeUTF8String(data, "null");
    } else {
      ByteBufUtils.writeUTF8String(data, this.owner.func_70005_c_());
    } 
  }
  
  public void readSpawnData(ByteBuf data) {
    try {
      this.field_70159_w = data.readDouble();
      this.field_70181_x = data.readDouble();
      this.field_70179_y = data.readDouble();
      this.impactX = data.readInt();
      this.impactY = data.readInt();
      this.impactZ = data.readInt();
      int lockedOnToID = data.readInt();
      if (lockedOnToID != -1)
        this.lockedOnTo = this.field_70170_p.func_73045_a(lockedOnToID); 
      this.type = BulletType.getBullet(ByteBufUtils.readUTF8String(data));
      this.penetratingPower = this.type.penetratingPower;
      String name = ByteBufUtils.readUTF8String(data);
      for (Object obj : this.field_70170_p.field_72996_f) {
        if (((Entity)obj).func_70005_c_().equals(name))
          this.owner = (Entity)obj; 
      } 
    } catch (Exception e) {
      FlansMod.log("Failed to read bullet owner from server.");
      super.func_70106_y();
      e.printStackTrace();
    } 
  }
  
  public boolean func_70027_ad() {
    return false;
  }
}
