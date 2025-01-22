package com.flansmod.client.tmt;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class ModelPoolEntry {
  public String name;
  
  public PositionTransformVertex[] vertices;
  
  public TexturedPolygon[] faces;
  
  public Map<String, TransformGroupBone> groups;
  
  public Map<String, TextureGroup> textures;
  
  protected TransformGroupBone group;
  
  protected TextureGroup texture;
  
  protected String[] fileExtensions;
  
  public File checkValidPath(String path) {
    File file = null;
    for (int index = 0; index < this.fileExtensions.length && (file == null || !file.exists()); index++) {
      String absPath = path;
      if (!path.endsWith("." + this.fileExtensions[index]))
        absPath = absPath + "." + this.fileExtensions[index]; 
      file = new File(absPath);
    } 
    if (file == null || !file.exists())
      return null; 
    return file;
  }
  
  public abstract void getModel(File paramFile);
  
  protected void setGroup(String groupName) {
    setGroup(groupName, new Bone(0.0F, 0.0F, 0.0F, 0.0F), 1.0D);
  }
  
  protected void setGroup(String groupName, Bone bone, double weight) {
    if (this.groups.size() == 0 || !this.groups.containsKey(groupName))
      this.groups.put(groupName, new TransformGroupBone(bone, weight)); 
    this.group = this.groups.get(groupName);
  }
  
  protected void setTextureGroup(String groupName) {
    if (this.textures.size() == 0 || !this.textures.containsKey(groupName))
      this.textures.put(groupName, new TextureGroup()); 
    this.texture = this.textures.get(groupName);
  }
  
  protected void applyGroups(Map<String, TransformGroup> groupsMap, Map<String, TextureGroup> texturesMap) {
    Set<String> groupsCol = this.groups.keySet();
    Collection<String> texturesCol = this.textures.keySet();
    Iterator<String> groupsItr = groupsCol.iterator();
    Iterator<String> texturesItr = texturesCol.iterator();
    while (groupsItr.hasNext()) {
      int nameIdx = 0;
      String groupKey = groupsItr.next();
      String currentGroup = this.name + "_" + nameIdx + ":" + groupKey;
      while (groupsMap.size() > 0 && groupsMap.containsKey(currentGroup)) {
        nameIdx++;
        currentGroup = this.name + "_" + nameIdx + ":" + groupKey;
      } 
      groupsMap.put(currentGroup, this.groups.get(groupKey));
    } 
    while (texturesItr.hasNext()) {
      int nameIdx = 0;
      String groupKey = texturesItr.next();
      String currentGroup = this.name + "_" + nameIdx + ":" + groupKey;
      while (groupsMap.size() > 0 && texturesMap.containsKey(currentGroup)) {
        nameIdx++;
        currentGroup = this.name + "_" + nameIdx + ":" + groupKey;
      } 
      texturesMap.put(currentGroup, this.textures.get(groupKey));
    } 
  }
}
