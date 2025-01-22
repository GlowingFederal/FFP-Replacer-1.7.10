package com.flansmod.common.guns;

public enum EnumSecondaryFunction {
  ZOOM, ADS_ZOOM, MELEE, CUSTOM_MELEE;
  
  public static EnumSecondaryFunction get(String s) {
    s = s.toLowerCase();
    if (s.equals("zoom"))
      return ZOOM; 
    if (s.equals("melee"))
      return MELEE; 
    if (s.equals("custommelee"))
      return CUSTOM_MELEE; 
    return ADS_ZOOM;
  }
}
