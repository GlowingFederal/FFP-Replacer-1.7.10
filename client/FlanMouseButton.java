package com.flansmod.client;

import net.minecraft.util.StatCollector;

public enum FlanMouseButton {
  LEFT(0),
  RIGHT(1);
  
  private int buttonNumber;
  
  FlanMouseButton(int button) {
    this.buttonNumber = button;
  }
  
  public String getName() {
    return StatCollector.func_74838_a(String.format("firebutton.%s.name", new Object[] { name().toLowerCase() }));
  }
  
  public int getButton() {
    return this.buttonNumber;
  }
  
  public static FlanMouseButton fromString(String input) {
    for (FlanMouseButton buttonType : values()) {
      if (buttonType.name().equalsIgnoreCase(input))
        return buttonType; 
    } 
    return null;
  }
  
  public String toString() {
    return name().toLowerCase();
  }
}
