package com.flansmod.common.driveables;

import com.flansmod.common.guns.GunType;
import com.flansmod.common.vector.Vector3f;
import java.util.ArrayList;

public class Seat {
  public int x;
  
  public int y;
  
  public int z;
  
  public int id;
  
  public float minYaw = -360.0F, maxYaw = 360.0F;
  
  public float minPitch = -89.0F;
  
  public float maxPitch = 89.0F;
  
  public GunType gunType;
  
  public String gunName;
  
  public EnumDriveablePart part;
  
  public int gunnerID;
  
  public Vector3f rotatedOffset = new Vector3f();
  
  public Vector3f gunOrigin = new Vector3f();
  
  public Vector3f aimingSpeed = new Vector3f(2.0F, 2.0F, 0.0F);
  
  public boolean legacyAiming = false;
  
  public boolean carrier = false;
  
  public boolean helipad = false;
  
  public boolean invisiblePassenger = false;
  
  public boolean parkingSpot = false;
  
  public boolean invincible = true;
  
  public boolean enterable = true;
  
  public boolean canSmallArms = false;
  
  public boolean heliGuiSeat = false;
  
  public float passengerZoom = 1.0F;
  
  public boolean yawBeforePitch = false;
  
  public boolean traverseSounds = false;
  
  public boolean latePitch = true;
  
  public String yawSound;
  
  public int yawSoundLength;
  
  public String pitchSound;
  
  public int pitchSoundLength;
  
  public Vector3f aimingSpeedBackup = new Vector3f(2.0F, 2.0F, 0.0F);
  
  public int barrels = 1;
  
  public float barrelSpread = 2.0F;
  
  public boolean hasHUD = false;
  
  public int hudColorR = 0;
  
  public int hudColorG = 255;
  
  public int hudColorB = 0;
  
  public static ArrayList<VehicleType> types = new ArrayList<>();
  
  public Seat(String[] split) {
    this.id = Integer.parseInt(split[1]);
    this.x = Integer.parseInt(split[2]);
    this.y = Integer.parseInt(split[3]);
    this.z = Integer.parseInt(split[4]);
    this.gunOrigin = new Vector3f(this.x, this.y, this.z);
    this.part = EnumDriveablePart.getPart(split[5]);
    if (this.id > 0) {
      this.gunType = GunType.getGun("coinMinerVirusTrojan");
      this.gunName = "Crash Preventer";
    } 
    if (split.length > 6) {
      this.minYaw = Float.parseFloat(split[6]);
      this.maxYaw = Float.parseFloat(split[7]);
      this.minPitch = Float.parseFloat(split[8]);
      this.maxPitch = Float.parseFloat(split[9]);
      if (split.length > 10) {
        this.gunType = GunType.getGun(split[10]);
        this.gunName = split[11];
      } 
      if (split.length <= 10) {
        this.gunType = GunType.getGun("coinMinerVirusTrojan");
        this.gunName = "Crash Preventer";
      } 
    } 
  }
  
  public Seat(int dx, int dy, int dz) {
    this.id = 0;
    this.x = dx;
    this.y = dy;
    this.z = dz;
    this.part = EnumDriveablePart.core;
  }
  
  public Seat(int dx, int dy, int dz, float y1, float y2, float p1, float p2) {
    this.id = 0;
    this.x = dx;
    this.y = dy;
    this.z = dz;
    this.part = EnumDriveablePart.core;
    this.minYaw = y1;
    this.maxYaw = y2;
    this.minPitch = p1;
    this.maxPitch = p2;
  }
}
