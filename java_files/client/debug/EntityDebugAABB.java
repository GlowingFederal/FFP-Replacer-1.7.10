package com.flansmod.client.debug;

import com.flansmod.common.vector.Vector3f;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityDebugAABB extends Entity {
  public Vector3f vector;
  
  public int life;
  
  public float red = 1.0F, green = 1.0F, blue = 1.0F;
  
  public float rotationRoll;
  
  public float opacity = 0.0F;
  
  public Vector3f offset;
  
  public EntityDebugAABB(World w, Vector3f u, Vector3f v, int i, float r, float g, float b, float yaw, float pitch, float roll, Vector3f offset, int timer) {
    super(w);
    func_70107_b(u.x, u.y, u.z);
    this.field_70177_z = yaw;
    this.field_70125_A = pitch;
    this.rotationRoll = roll;
    this.vector = v;
    this.life = i;
    this.red = r;
    this.green = g;
    this.blue = b;
    this.offset = offset;
    this.opacity = timer;
  }
  
  public EntityDebugAABB(World w, Vector3f u, Vector3f v, int i, float r, float g, float b, float yaw, float pitch, float roll) {
    this(w, u, v, i, r, g, b, yaw, pitch, roll, new Vector3f(), 0);
  }
  
  public EntityDebugAABB(World w, Vector3f u, Vector3f v, int i, float r, float g, float b) {
    this(w, u, v, i, r, g, b, 0.0F, 0.0F, 0.0F);
  }
  
  public EntityDebugAABB(World w, Vector3f u, Vector3f v, int i) {
    this(w, u, v, i, 1.0F, 1.0F, 1.0F);
  }
  
  public void func_70071_h_() {
    this.life--;
    if (this.life <= 0)
      func_70106_y(); 
  }
  
  public AxisAlignedBB func_70046_E() {
    return null;
  }
  
  protected void func_70088_a() {}
  
  protected void func_70037_a(NBTTagCompound nbttagcompound) {}
  
  protected void func_70014_b(NBTTagCompound nbttagcompound) {}
}
