package com.flansmod.common.driveables;

import com.flansmod.common.vector.Vector3f;

public class CollisionBox {
  public float x;
  
  public float y;
  
  public float z;
  
  public float w;
  
  public float h;
  
  public float d;
  
  public int health;
  
  public int armor;
  
  public int compArmor;
  
  public int animal;
  
  public int crew;
  
  public EnumDriveablePart part;
  
  public CollisionBox(int health, int x, int y, int z, int w, int h, int d, int armor, int compArmor, int animal, int crew) {
    this.health = health;
    this.x = x / 16.0F;
    this.y = y / 16.0F;
    this.z = z / 16.0F;
    this.w = w / 16.0F;
    this.h = h / 16.0F;
    this.d = d / 16.0F;
    this.armor = armor;
    this.compArmor = compArmor;
    this.animal = animal;
    this.crew = crew;
  }
  
  public Vector3f getCentre() {
    return new Vector3f(this.x + this.w / 2.0F, this.y + this.h / 2.0F, this.z + this.d / 2.0F);
  }
}
