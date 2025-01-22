package com.flansmod.client;

import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.paintjob.PaintableType;
import com.flansmod.common.paintjob.Paintjob;
import com.flansmod.common.types.InfoType;
import java.util.HashMap;
import net.minecraft.util.ResourceLocation;

public class FlansModResourceHandler {
  private static HashMap<InfoType, ResourceLocation> iconMap = new HashMap<>();
  
  private static HashMap<InfoType, ResourceLocation> textureMap = new HashMap<>();
  
  private static HashMap<Paintjob, ResourceLocation> paintjobMap = new HashMap<>();
  
  private static HashMap<Paintjob, ResourceLocation> paintjobIconMap = new HashMap<>();
  
  private static HashMap<String, ResourceLocation> scopeMap = new HashMap<>();
  
  private static HashMap<String, ResourceLocation> soundMap = new HashMap<>();
  
  private static HashMap<String, ResourceLocation> auxiliaryMap = new HashMap<>();
  
  public static ResourceLocation getIcon(PaintableType paintableType, Paintjob paintjob) {
    if (paintjobIconMap.containsKey(paintjob))
      return paintjobIconMap.get(paintjob); 
    ResourceLocation resLoc = new ResourceLocation("flansmod", "textures/items/" + paintjob.iconName + ".png");
    paintjobIconMap.put(paintjob, resLoc);
    return resLoc;
  }
  
  public static ResourceLocation getIcon(InfoType infoType) {
    if (iconMap.containsKey(infoType))
      return iconMap.get(infoType); 
    ResourceLocation resLoc = new ResourceLocation("flansmod", "textures/items/" + infoType.iconPath + ".png");
    iconMap.put(infoType, resLoc);
    return resLoc;
  }
  
  public static ResourceLocation getTexture(InfoType infoType) {
    if (textureMap.containsKey(infoType))
      return textureMap.get(infoType); 
    ResourceLocation resLoc = new ResourceLocation("flansmod", "skins/" + infoType.texture + ".png");
    if (infoType.texture != null) {
      textureMap.put(infoType, resLoc);
      return resLoc;
    } 
    return null;
  }
  
  public static ResourceLocation getAlternateTexture(BulletType gunType) {
    if (textureMap.containsKey(gunType))
      return textureMap.get(gunType); 
    ResourceLocation resLoc = new ResourceLocation("flansmod", "skins/" + gunType.LauncherSkin + ".png");
    if (gunType.LauncherSkin != null) {
      textureMap.put(gunType, resLoc);
      return resLoc;
    } 
    return null;
  }
  
  public static ResourceLocation getDeployableTexture(GunType gunType) {
    if (textureMap.containsKey(gunType))
      return textureMap.get(gunType); 
    ResourceLocation resLoc = new ResourceLocation("flansmod", "skins/" + gunType.deployableTexture + ".png");
    textureMap.put(gunType, resLoc);
    return resLoc;
  }
  
  public static ResourceLocation getScope(String scopeTexture) {
    if (scopeMap.containsKey(scopeTexture))
      return scopeMap.get(scopeTexture); 
    ResourceLocation resLoc = new ResourceLocation("flansmod", "gui/" + scopeTexture + ".png");
    scopeMap.put(scopeTexture, resLoc);
    return resLoc;
  }
  
  public static ResourceLocation getSound(String sound) {
    if (soundMap.containsKey(sound));
    ResourceLocation resLoc = new ResourceLocation("flansmod", sound);
    soundMap.put(sound, resLoc);
    return resLoc;
  }
  
  public static ResourceLocation getPaintjobTexture(Paintjob paintjob) {
    if (paintjobMap.containsKey(paintjob))
      return paintjobMap.get(paintjob); 
    ResourceLocation resLoc = new ResourceLocation("flansmod", "skins/" + paintjob.textureName + ".png");
    paintjobMap.put(paintjob, resLoc);
    return resLoc;
  }
  
  public static ResourceLocation getAuxiliaryTexture(String texture) {
    if (auxiliaryMap.containsKey(texture))
      return auxiliaryMap.get(texture); 
    ResourceLocation resLoc = new ResourceLocation("flansmod", "skins/" + texture + ".png");
    auxiliaryMap.put(texture, resLoc);
    return resLoc;
  }
}
