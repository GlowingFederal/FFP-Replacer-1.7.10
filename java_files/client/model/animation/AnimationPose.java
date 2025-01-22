package com.flansmod.client.model.animation;

import java.util.ArrayList;

public class AnimationPose {
  ArrayList<PoseComponent> parts = new ArrayList<>();
  
  public PoseComponent getComponentWithName(String name) {
    PoseComponent part = new PoseComponent("nope", null, null, 0, 0, false);
    for (PoseComponent p : this.parts) {
      if (p.name.equals(name))
        part = p; 
    } 
    return part;
  }
}
