package com.flansmod.common.driveables;

import com.flansmod.common.FlansMod;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.collisions.CollisionTest;
import com.flansmod.common.driveables.collisions.RidingEntityPosition;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.raytracing.DriveableHit;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketFlak;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.nbt.NBTTagCompound;

public class DriveablePart {
  public EnumDriveablePart type;
  
  public CollisionBox box;
  
  public int maxHealth = 1;
  
  public int health = 1;
  
  public int fireTime;
  
  public boolean onFire;
  
  public int maxCrew = 1;
  
  public int crew = 1;
  
  public int armor;
  
  public int compArmor;
  
  public int animal;
  
  public int crewRegenTimer;
  
  public int autoRepairTimer;
  
  public int autoRepairLimit = 20;
  
  public int totalCrewFactor = 20;
  
  public boolean dead;
  
  public EntityDriveable owner;
  
  public DriveablePart(EnumDriveablePart e, CollisionBox b) {
    this.type = e;
    this.box = b;
    this.health = this.maxHealth = (b == null) ? 0 : b.health;
    this.crew = this.maxCrew = (b == null) ? 0 : b.crew;
    this.armor = (b == null) ? 0 : b.armor;
    this.compArmor = (b == null) ? 0 : b.compArmor;
    this.animal = (b == null) ? 0 : b.animal;
  }
  
  public void update(EntityDriveable driveable) {
    if (this.crew < 0)
      this.crew = 0; 
    if (this.fireTime > 0)
      this.fireTime--; 
    if (this.fireTime == 0)
      this.onFire = false; 
    if (this.onFire)
      this.health--; 
    if (this.health <= 0 && this.maxHealth > 0) {
      this.dead = true;
      this.crew = 0;
    } 
    this.owner = driveable;
    if (this.maxCrew > 1000 && this.owner.throttle > -0.1D && this.owner.throttle < 0.1D && !this.dead && this.crew < this.maxCrew && this.owner.shootDelaySecondary <= 0 && this.owner.shootDelayPrimary <= 0)
      this.totalCrewFactor = 3; 
    if (this.maxCrew < 1000 && this.maxCrew > 900)
      this.totalCrewFactor = 6; 
    if (this.maxCrew < 900 && this.maxCrew > 800)
      this.totalCrewFactor = 8; 
    if (this.maxCrew < 800 && this.maxCrew > 700)
      this.totalCrewFactor = 12; 
    if (this.maxCrew < 700 && this.maxCrew > 600)
      this.totalCrewFactor = 20; 
    if (this.maxCrew < 600 && this.maxCrew > 500)
      this.totalCrewFactor = 30; 
    if (this.maxCrew < 500 && this.maxCrew > 400)
      this.totalCrewFactor = 46; 
    if (this.maxCrew < 400 && this.maxCrew > 300)
      this.totalCrewFactor = 56; 
    if (this.maxCrew < 300 && this.maxCrew > 200)
      this.totalCrewFactor = 72; 
    if (this.maxCrew < 200 && this.maxCrew > 100)
      this.totalCrewFactor = 90; 
    if (this.maxCrew < 100 && this.maxCrew > 0)
      this.totalCrewFactor = 110; 
    if (this.crewRegenTimer >= this.totalCrewFactor)
      this.crewRegenTimer = 0; 
    if (this.crewRegenTimer < this.totalCrewFactor)
      this.crewRegenTimer++; 
    if (this.crewRegenTimer == this.totalCrewFactor - 1 && this.owner.throttle > -0.1D && this.owner.throttle < 0.1D && !this.dead && this.crew < this.maxCrew && this.owner.shootDelaySecondary <= 0 && this.owner.shootDelayPrimary <= 0)
      this.crew++; 
    if (this.type != EnumDriveablePart.buoyancy && driveable.ticksFlareUsing > 0 && driveable.throttle > -0.1D && driveable.throttle < 0.1D && this.health < this.maxHealth) {
      this.autoRepairTimer++;
      int globalMaximum = (driveable.getDriveableData()).maximumCrew;
      int globalCrew = (driveable.getDriveableData()).totalCrew;
      this.autoRepairLimit = (int)(566.0F - 137.0F * this.crew / this.maxCrew + 409.0F * globalCrew / globalMaximum);
      if (this.autoRepairTimer > this.autoRepairLimit)
        this.autoRepairTimer = 0; 
      if (this.autoRepairTimer == 15 && !this.dead)
        this.health = this.health + 1 + (int)(this.maxHealth * 0.025D); 
    } 
    if ((driveable.ticksRepairing > 0 || driveable.mounted) && driveable.throttle > -0.1D && driveable.throttle < 0.1D && this.health < this.maxHealth) {
      this.autoRepairTimer++;
      if (this.autoRepairTimer > 20)
        this.autoRepairTimer = 0; 
      if (this.autoRepairTimer == 15 && !this.dead && this.type != EnumDriveablePart.leftTrack && this.type != EnumDriveablePart.rightTrack && this.type != EnumDriveablePart.frontLeftWheel && this.type != EnumDriveablePart.frontRightWheel && this.type != EnumDriveablePart.backLeftWheel && this.type != EnumDriveablePart.backRightWheel && this.type != EnumDriveablePart.engine && this.type != EnumDriveablePart.engine2 && this.type != EnumDriveablePart.engine3 && this.type != EnumDriveablePart.engine4 && this.type != EnumDriveablePart.engine5 && this.type != EnumDriveablePart.engine6)
        this.health = this.health + 1 + (int)(this.maxHealth * 0.005D); 
      if (this.autoRepairTimer == 15 && !this.dead && (this.type == EnumDriveablePart.leftTrack || this.type == EnumDriveablePart.rightTrack || this.type == EnumDriveablePart.frontLeftWheel || this.type == EnumDriveablePart.frontRightWheel || this.type == EnumDriveablePart.backLeftWheel || this.type == EnumDriveablePart.backRightWheel || this.type == EnumDriveablePart.engine || this.type == EnumDriveablePart.engine5 || this.type == EnumDriveablePart.engine2 || this.type == EnumDriveablePart.engine3 || this.type == EnumDriveablePart.engine4 || this.type == EnumDriveablePart.engine6))
        this.health = this.health + 1 + (int)(this.maxHealth * 0.025D); 
    } 
    if (driveable.mounted && this.health < this.maxHealth)
      this.health++; 
    if (this.health > this.maxHealth)
      this.health = this.maxHealth; 
    if (this.crew > this.maxCrew)
      this.crew = this.maxCrew; 
  }
  
  public void writeToNBT(NBTTagCompound tags) {
    tags.func_74768_a(this.type.getShortName() + "_Health", this.health);
    tags.func_74768_a(this.type.getShortName() + "_Crew", this.crew);
    tags.func_74757_a(this.type.getShortName() + "_Fire", this.onFire);
  }
  
  public void readFromNBT(NBTTagCompound tags) {
    if (!tags.func_74764_b(this.type.getShortName() + "_Health")) {
      this.health = this.maxHealth;
      this.onFire = false;
      return;
    } 
    if (!tags.func_74764_b(this.type.getShortName() + "_Crew")) {
      this.crew = this.maxCrew;
      this.onFire = false;
      return;
    } 
    this.health = tags.func_74762_e(this.type.getShortName() + "_Health");
    this.crew = tags.func_74762_e(this.type.getShortName() + "_Crew");
    this.onFire = tags.func_74767_n(this.type.getShortName() + "_Fire");
  }
  
  public float smashIntoGround(EntityDriveable driveable, float damage) {
    if (this.box == null || this.dead)
      return 0.0F; 
    if (!driveable.canHitPart(this.type))
      return 0.0F; 
    if (this.maxHealth == 0)
      return damage; 
    this.health -= (int)(damage / 2.0F);
    return damage / 2.0F;
  }
  
  public DriveableHit rayTrace(EntityDriveable driveable, Vector3f origin, Vector3f motion) {
    if (this.box == null || this.health <= 0 || this.dead)
      return null; 
    if (!driveable.canHitPart(this.type))
      return null; 
    if (motion.x != 0.0F)
      if (origin.x < this.box.x) {
        float intersectTime = (this.box.x - origin.x) / motion.x;
        float intersectY = origin.y + motion.y * intersectTime;
        float intersectZ = origin.z + motion.z * intersectTime;
        if (intersectY >= this.box.y && intersectY <= this.box.y + this.box.h && intersectZ >= this.box.z && intersectZ <= this.box.z + this.box.d && intersectTime >= 0.0F)
          return new DriveableHit(driveable, this.type, intersectTime); 
      } else if (origin.x > this.box.x + this.box.w) {
        float intersectTime = (this.box.x + this.box.w - origin.x) / motion.x;
        float intersectY = origin.y + motion.y * intersectTime;
        float intersectZ = origin.z + motion.z * intersectTime;
        if (intersectY >= this.box.y && intersectY <= this.box.y + this.box.h && intersectZ >= this.box.z && intersectZ <= this.box.z + this.box.d && intersectTime >= 0.0F)
          return new DriveableHit(driveable, this.type, intersectTime); 
      }  
    if (motion.z != 0.0F)
      if (origin.z < this.box.z) {
        float intersectTime = (this.box.z - origin.z) / motion.z;
        float intersectX = origin.x + motion.x * intersectTime;
        float intersectY = origin.y + motion.y * intersectTime;
        if (intersectX >= this.box.x && intersectX <= this.box.x + this.box.w && intersectY >= this.box.y && intersectY <= this.box.y + this.box.h && intersectTime >= 0.0F)
          return new DriveableHit(driveable, this.type, intersectTime); 
      } else if (origin.z > this.box.z + this.box.d) {
        float intersectTime = (this.box.z + this.box.d - origin.z) / motion.z;
        float intersectX = origin.x + motion.x * intersectTime;
        float intersectY = origin.y + motion.y * intersectTime;
        if (intersectX >= this.box.x && intersectX <= this.box.x + this.box.w && intersectY >= this.box.y && intersectY <= this.box.y + this.box.h && intersectTime >= 0.0F)
          return new DriveableHit(driveable, this.type, intersectTime); 
      }  
    if (motion.y != 0.0F)
      if (origin.y < this.box.y) {
        float intersectTime = (this.box.y - origin.y) / motion.y;
        float intersectX = origin.x + motion.x * intersectTime;
        float intersectZ = origin.z + motion.z * intersectTime;
        if (intersectX >= this.box.x && intersectX <= this.box.x + this.box.w && intersectZ >= this.box.z && intersectZ <= this.box.z + this.box.d && intersectTime >= 0.0F)
          return new DriveableHit(driveable, this.type, intersectTime); 
      } else if (origin.y > this.box.y + this.box.h) {
        float intersectTime = (this.box.y + this.box.h - origin.y) / motion.y;
        float intersectX = origin.x + motion.x * intersectTime;
        float intersectZ = origin.z + motion.z * intersectTime;
        if (intersectX >= this.box.x && intersectX <= this.box.x + this.box.w && intersectZ >= this.box.z && intersectZ <= this.box.z + this.box.d && intersectTime >= 0.0F)
          return new DriveableHit(driveable, this.type, intersectTime); 
      }  
    return null;
  }
  
  public RidingEntityPosition rayTraceRider(EntityDriveable driveable, CollisionTest tester) {
    if (this.box == null || this.health <= 0 || this.dead)
      return null; 
    if (!driveable.canHitPart(this.type))
      return null; 
    double distance = 10.0D;
    Vector3f collisionPoint = new Vector3f(40.0F, 0.0F, 0.0F);
    int surface = 0;
    if (tester.didCollide)
      return new RidingEntityPosition(collisionPoint.x, collisionPoint.y, collisionPoint.z, 1, distance, this.type); 
    Vector3f pos = new Vector3f(driveable.field_70165_t, driveable.field_70163_u, driveable.field_70161_v);
    RotatedAxes shift = driveable.axes;
    Vector3f p1 = shift.findLocalVectorGlobally(new Vector3f(this.box.x + this.box.w, this.box.y + this.box.h, this.box.z));
    Vector3f p2 = shift.findLocalVectorGlobally(new Vector3f(this.box.x + this.box.w, this.box.y + this.box.h, this.box.z + this.box.d));
    Vector3f p3 = shift.findLocalVectorGlobally(new Vector3f(this.box.x, this.box.y + this.box.h, this.box.z + this.box.d));
    Vector3f p4 = shift.findLocalVectorGlobally(new Vector3f(this.box.x, this.box.y + this.box.h, this.box.z));
    Vector3f p5 = shift.findLocalVectorGlobally(new Vector3f(this.box.x + this.box.w, this.box.y, this.box.z));
    Vector3f p6 = shift.findLocalVectorGlobally(new Vector3f(this.box.x + this.box.w, this.box.y, this.box.z + this.box.d));
    Vector3f p7 = shift.findLocalVectorGlobally(new Vector3f(this.box.x, this.box.y, this.box.z + this.box.d));
    Vector3f p8 = shift.findLocalVectorGlobally(new Vector3f(this.box.x, this.box.y, this.box.z));
    if (this.type == EnumDriveablePart.turret && driveable.seats[0] != null) {
      p1 = driveable.getPositionOnTurret(new Vector3f(this.box.x + this.box.w, this.box.y + this.box.h, this.box.z), false);
      p2 = driveable.getPositionOnTurret(new Vector3f(this.box.x + this.box.w, this.box.y + this.box.h, this.box.z + this.box.d), false);
      p3 = driveable.getPositionOnTurret(new Vector3f(this.box.x, this.box.y + this.box.h, this.box.z + this.box.d), false);
      p4 = driveable.getPositionOnTurret(new Vector3f(this.box.x, this.box.y + this.box.h, this.box.z), false);
      p5 = driveable.getPositionOnTurret(new Vector3f(this.box.x + this.box.w, this.box.y, this.box.z), false);
      p6 = driveable.getPositionOnTurret(new Vector3f(this.box.x + this.box.w, this.box.y, this.box.z + this.box.d), false);
      p7 = driveable.getPositionOnTurret(new Vector3f(this.box.x, this.box.y, this.box.z + this.box.d), false);
      p8 = driveable.getPositionOnTurret(new Vector3f(this.box.x, this.box.y, this.box.z), false);
    } 
    double topFaceDist = 100.0D;
    tester.checkTriangle(tester, p3, p2, p1);
    if (tester.didCollide && tester.nearestDistance < distance) {
      collisionPoint = tester.intersectionPoint;
      surface = 1;
      tester.part = this.type;
    } 
    tester.checkTriangle(tester, p4, p3, p1);
    if (tester.didCollide && tester.nearestDistance < distance) {
      collisionPoint = tester.intersectionPoint;
      surface = 1;
      tester.part = this.type;
    } 
    if (tester.didCollide) {
      tester.isOnTop = true;
      topFaceDist = tester.nearestDistance;
    } 
    tester.checkTriangle(tester, p1, p2, p6);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 2;
      tester.part = this.type;
    } 
    tester.checkTriangle(tester, p1, p6, p5);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 2;
      tester.part = this.type;
    } 
    tester.checkTriangle(tester, p3, p4, p8);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 3;
      tester.part = this.type;
    } 
    tester.checkTriangle(tester, p4, p8, p7);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 3;
      tester.part = this.type;
    } 
    tester.checkTriangle(tester, p4, p1, p5);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 4;
      tester.part = this.type;
    } 
    tester.checkTriangle(tester, p1, p5, p8);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 4;
      tester.part = this.type;
    } 
    tester.checkTriangle(tester, p2, p3, p7);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 5;
      tester.part = this.type;
    } 
    tester.checkTriangle(tester, p3, p7, p6);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 5;
      tester.part = this.type;
    } 
    if (tester.nearestDistance < topFaceDist)
      tester.isOnTop = false; 
    if (surface == 1)
      tester.isOnTop = true; 
    if (tester.part == this.type)
      return null; 
    return null;
  }
  
  public void hitByBullet(EntityBullet bullet, DriveableHit hit) {
    EntitySeat parkingSeat = null;
    EntitySeat shooterSeat = null;
    if (bullet != null) {
      if (hit.driveable != null && hit.driveable.func_70115_ae() && hit.driveable.field_70154_o != null && hit.driveable.field_70154_o instanceof EntitySeat) {
        parkingSeat = (EntitySeat)hit.driveable.field_70154_o;
        if (bullet.owner != null && bullet.owner.func_70115_ae() && bullet.owner.field_70154_o != null && bullet.owner.field_70154_o instanceof EntitySeat)
          shooterSeat = (EntitySeat)bullet.owner.field_70154_o; 
      } 
      if (shooterSeat != null && parkingSeat != null && shooterSeat.driveable != null && parkingSeat.driveable != null && (shooterSeat.driveable == parkingSeat.driveable || shooterSeat.driveable == this.owner)) {
        System.out.println("Self-damage should have been prevented");
        this.health -= 0;
      } else if (hit.driveable.APSdelay <= 0 && bullet.truePen > 30.0F && hit.driveable.APSchecker < 3) {
        hit.driveable.APSdelay = hit.driveable.APSmax;
        PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 25.0D, 0, bullet.type.APSsound, true);
      } else if (hit.driveable instanceof EntityPlane) {
        if (this.type == EnumDriveablePart.shield)
          hit.driveable.shieldHitTimer = 20; 
        if (bullet.isSword && this.animal == 1) {
          this.health -= 0;
        } else if (this.animal == 2) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsLiving);
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 1, "blood"), bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 200.0F, 0);
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.blood", bullet.field_70165_t, bullet.field_70163_u + 1.0D, bullet.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 150.0F, 0);
        } else if (bullet.truePen < this.armor && 0.9D * this.armor < bullet.truePen && !bullet.isHEAT) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsVehicles * bullet.type.barelypenPenalty);
          this.crew = (int)(this.crew - hit.driveable.damageVsCrew * bullet.damage * bullet.type.damageVsVehicles * bullet.type.barelypenPenalty);
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 35.0D, 0, bullet.type.minorPenSound, true);
        } else if (bullet.truePen < this.compArmor && 0.9D * this.compArmor < bullet.truePen && bullet.isHEAT) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsVehicles * bullet.type.barelypenPenalty);
          this.crew = (int)(this.crew - hit.driveable.damageVsCrew * bullet.damage * bullet.type.damageVsVehicles * bullet.type.barelypenPenalty);
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 35.0D, 0, bullet.type.minorPenSound, true);
        } else if (0.9F * this.armor >= bullet.truePen && !bullet.isHEAT) {
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 25.0D, 0, bullet.type.ricochetSound, true);
        } else if (0.9F * this.compArmor >= bullet.truePen && bullet.isHEAT) {
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 25.0D, 0, bullet.type.ricochetSound, true);
        } else if (bullet.truePen > this.armor && (3 * this.armor) >= bullet.truePen && !bullet.isHEAT) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsPlanes);
          this.crew = (int)(this.crew - hit.driveable.damageVsCrew * bullet.damage * bullet.type.damageVsVehicles);
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 50.0D, 0, bullet.type.penetrateSound, true);
        } else if (bullet.truePen > this.compArmor && (3 * this.compArmor) >= bullet.truePen && bullet.isHEAT) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsPlanes);
          this.crew = (int)(this.crew - hit.driveable.damageVsCrew * bullet.damage * bullet.type.damageVsVehicles);
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 50.0D, 0, bullet.type.penetrateSound, true);
        } else if ((3 * this.armor) < bullet.truePen && !bullet.isHEAT) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsPlanes * bullet.type.overPenPenalty);
          this.crew = (int)(this.crew - hit.driveable.damageVsCrew * bullet.damage * bullet.type.damageVsVehicles * bullet.type.overPenPenalty);
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 50.0D, 0, bullet.type.overPenSound, true);
        } else if ((3 * this.compArmor) < bullet.truePen && bullet.isHEAT) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsPlanes * bullet.type.overPenPenalty);
          this.crew = (int)(this.crew - hit.driveable.damageVsCrew * bullet.damage * bullet.type.damageVsVehicles * bullet.type.overPenPenalty);
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 50.0D, 0, bullet.type.overPenSound, true);
        } 
      } else {
        if (this.type == EnumDriveablePart.shield) {
          hit.driveable.shieldHitTimer = 10;
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 15, "crit"), bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 200.0F, 0);
        } 
        if (bullet.isSword && this.animal == 1) {
          this.health -= 0;
        } else if (this.animal == 2) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsLiving);
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 1, "blood"), bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 200.0F, 0);
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.blood", bullet.field_70165_t, bullet.field_70163_u + 1.0D, bullet.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 150.0F, 0);
        } else if (bullet.truePen < this.armor && 0.9D * this.armor < bullet.truePen && !bullet.isHEAT) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsVehicles * bullet.type.barelypenPenalty);
          this.crew = (int)(this.crew - hit.driveable.damageVsCrew * bullet.damage * bullet.type.damageVsVehicles * bullet.type.barelypenPenalty);
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 35.0D, 0, bullet.type.minorPenSound, true);
        } else if (bullet.isHEAT && bullet.truePen < this.compArmor && 0.9D * this.compArmor < bullet.truePen) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsVehicles * bullet.type.barelypenPenalty);
          this.crew = (int)(this.crew - hit.driveable.damageVsCrew * bullet.damage * bullet.type.damageVsVehicles * bullet.type.barelypenPenalty);
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 35.0D, 0, bullet.type.minorPenSound, true);
        } else if (0.9F * this.armor >= bullet.truePen && !bullet.isHEAT) {
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 25.0D, 0, bullet.type.ricochetSound, true);
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 1, "crit"), bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 200.0F, 0);
        } else if (0.9F * this.compArmor >= bullet.truePen && bullet.isHEAT) {
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 25.0D, 0, bullet.type.ricochetSound, true);
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 1, "crit"), bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 200.0F, 0);
        } else if (bullet.truePen > this.armor && (3 * this.armor) >= bullet.truePen && !bullet.isHEAT) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsVehicles);
          this.crew = (int)(this.crew - hit.driveable.damageVsCrew * bullet.damage * bullet.type.damageVsVehicles);
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 50.0D, 0, bullet.type.penetrateSound, true);
        } else if (bullet.truePen > this.armor && (3 * this.compArmor) >= bullet.truePen && bullet.isHEAT) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsVehicles);
          this.crew = (int)(this.crew - hit.driveable.damageVsCrew * bullet.damage * bullet.type.damageVsVehicles);
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 50.0D, 0, bullet.type.penetrateSound, true);
        } else if ((3 * this.armor) < bullet.truePen && !bullet.isHEAT) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsVehicles * bullet.type.overPenPenalty);
          this.crew = (int)(this.crew - hit.driveable.damageVsCrew * bullet.damage * bullet.type.damageVsVehicles * bullet.type.overPenPenalty);
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 50.0D, 0, bullet.type.overPenSound, true);
        } else if ((3 * this.compArmor) < bullet.truePen && bullet.isHEAT) {
          this.health = (int)(this.health - bullet.damage * bullet.type.damageVsVehicles * bullet.type.overPenPenalty);
          this.crew = (int)(this.crew - hit.driveable.damageVsCrew * bullet.damage * bullet.type.damageVsVehicles * bullet.type.overPenPenalty);
          PacketPlaySound.sendSoundPacket(bullet.field_70165_t, bullet.field_70163_u, bullet.field_70161_v, 50.0D, 0, bullet.type.overPenSound, true);
        } 
      } 
      if (bullet.type.setEntitiesOnFire) {
        this.fireTime = 20;
        this.onFire = true;
      } 
    } 
  }
  
  private boolean coordIsEntering(float start, float end, float min, float max) {
    if (start < min && end >= min)
      return true; 
    if (start > max && end <= max)
      return true; 
    return false;
  }
  
  private boolean coordIsIn(float start, float end, float min, float max) {
    if (start >= min && start <= max)
      return true; 
    if (end >= min && end <= max)
      return true; 
    if (start < min && end > max)
      return true; 
    if (end < min && start > max)
      return true; 
    return false;
  }
  
  public boolean attack(float damage, boolean fireDamage) {
    this.health = (int)(this.health - damage);
    if (fireDamage) {
      this.fireTime = 0;
      this.onFire = false;
    } 
    if (this.health < 0)
      this.health = 0; 
    return (this.health <= 0);
  }
}
