package com.flansmod.common.types;

import java.util.ArrayList;
import java.util.HashMap;

public class TypeFile {
  private int readerPosition = 0;
  
  public static HashMap<EnumType, ArrayList<TypeFile>> files = new HashMap<>();
  
  public ArrayList<String> lines;
  
  public final String pack;
  
  public String name;
  
  public EnumType type;
  
  static {
    for (EnumType type : EnumType.values())
      files.put(type, new ArrayList<>()); 
  }
  
  public TypeFile(EnumType t, String s, String packName) {
    this(t, s, packName, true);
  }
  
  public TypeFile(EnumType t, String s, String packName, boolean addToTypeFileList) {
    this.type = t;
    this.name = s;
    this.pack = packName;
    this.lines = new ArrayList<>();
    if (addToTypeFileList)
      ((ArrayList<TypeFile>)files.get(this.type)).add(this); 
  }
  
  public String readLine() {
    if (this.readerPosition == this.lines.size())
      return null; 
    return this.lines.get(this.readerPosition++);
  }
}
