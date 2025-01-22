package com.flansmod.common.guns.raytracing;

public class BulletHit implements Comparable<BulletHit> {
  public float intersectTime;
  
  public BulletHit(float f) {
    this.intersectTime = f;
  }
  
  public int compareTo(BulletHit other) {
    if (this.intersectTime < other.intersectTime)
      return -1; 
    if (this.intersectTime > other.intersectTime)
      return 1; 
    return 0;
  }
}
