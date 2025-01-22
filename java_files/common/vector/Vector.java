package com.flansmod.common.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public abstract class Vector implements Serializable, ReadableVector {
  public final float length() {
    return (float)Math.sqrt(lengthSquared());
  }
  
  public abstract float lengthSquared();
  
  public abstract Vector load(FloatBuffer paramFloatBuffer);
  
  public abstract Vector negate();
  
  public final Vector normalise() {
    float len = length();
    if (len != 0.0F) {
      float l = 1.0F / len;
      return scale(l);
    } 
    return scale(0.0F);
  }
  
  public abstract Vector store(FloatBuffer paramFloatBuffer);
  
  public abstract Vector scale(float paramFloat);
}
