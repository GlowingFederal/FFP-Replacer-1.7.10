package com.flansmod.client;

import net.minecraft.util.StatCollector;

public enum AimType {
  HOLD, TOGGLE;
  
  public String getName() {
    return StatCollector.func_74838_a(String.format("aimtype.%s.name", new Object[] { name().toLowerCase() }));
  }
  
  public static AimType fromString(String input) {
    for (AimType aimType : values()) {
      if (aimType.name().equalsIgnoreCase(input))
        return aimType; 
    } 
    return null;
  }
  
  public String toString() {
    return name().toLowerCase();
  }
}
