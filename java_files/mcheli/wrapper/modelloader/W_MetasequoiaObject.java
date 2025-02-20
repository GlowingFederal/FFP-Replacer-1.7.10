/*     */ package mcheli.wrapper.modelloader;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.resources.IResource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.model.ModelFormatException;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class W_MetasequoiaObject
/*     */   extends W_ModelCustom
/*     */ {
/*  22 */   public ArrayList vertices = new ArrayList();
/*  23 */   public ArrayList groupObjects = new ArrayList();
/*  24 */   private W_GroupObject currentGroupObject = null;
/*     */   private String fileName;
/*  26 */   private int vertexNum = 0;
/*  27 */   private int faceNum = 0;
/*     */ 
/*     */   
/*     */   public W_MetasequoiaObject(ResourceLocation resource) throws ModelFormatException {
/*  31 */     this.fileName = resource.toString();
/*     */     
/*     */     try {
/*  34 */       IResource e = Minecraft.func_71410_x().func_110442_L().func_110536_a(resource);
/*  35 */       loadObjModel(e.func_110527_b());
/*  36 */     } catch (IOException var3) {
/*  37 */       throw new ModelFormatException("IO Exception reading model format:" + this.fileName, var3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public W_MetasequoiaObject(String fileName, URL resource) throws ModelFormatException {
/*  42 */     this.fileName = fileName;
/*     */     
/*     */     try {
/*  45 */       loadObjModel(resource.openStream());
/*  46 */     } catch (IOException var4) {
/*  47 */       throw new ModelFormatException("IO Exception reading model format:" + this.fileName, var4);
/*     */     } 
/*     */   }
/*     */   
/*     */   public W_MetasequoiaObject(String filename, InputStream inputStream) throws ModelFormatException {
/*  52 */     this.fileName = filename;
/*  53 */     loadObjModel(inputStream);
/*     */   }
/*     */   public boolean containsPart(String partName) {
/*     */     W_GroupObject groupObject;
/*  57 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */ 
/*     */     
/*     */     do {
/*  61 */       if (!i$.hasNext()) {
/*  62 */         return false;
/*     */       }
/*     */       
/*  65 */       groupObject = i$.next();
/*  66 */     } while (!partName.equalsIgnoreCase(groupObject.name));
/*     */     
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   private void loadObjModel(InputStream inputStream) throws ModelFormatException {
/*  72 */     BufferedReader reader = null;
/*  73 */     String currentLine = null;
/*  74 */     int lineCount = 0;
/*     */     
/*     */     try {
/*  77 */       reader = new BufferedReader(new InputStreamReader(inputStream));
/*     */       
/*  79 */       while ((currentLine = reader.readLine()) != null) {
/*  80 */         lineCount++;
/*  81 */         currentLine = currentLine.replaceAll("\\s+", " ").trim();
/*  82 */         if (isValidGroupObjectLine(currentLine)) {
/*  83 */           W_GroupObject e = parseGroupObject(currentLine, lineCount);
/*  84 */           if (e != null) {
/*  85 */             e.glDrawingMode = 4;
/*  86 */             this.vertices.clear();
/*  87 */             int vertexNum = 0;
/*  88 */             boolean mirror = false;
/*  89 */             double facet = Math.cos(0.785398163375D);
/*  90 */             boolean shading = false;
/*     */ 
/*     */             
/*  93 */             while ((currentLine = reader.readLine()) != null) {
/*  94 */               lineCount++;
/*  95 */               currentLine = currentLine.replaceAll("\\s+", " ").trim();
/*  96 */               if (currentLine.equalsIgnoreCase("mirror 1")) {
/*  97 */                 mirror = true;
/*     */               }
/*     */               
/* 100 */               if (currentLine.equalsIgnoreCase("shading 1")) {
/* 101 */                 shading = true;
/*     */               }
/*     */               
/* 104 */               String[] faceNum = currentLine.split(" ");
/* 105 */               if (faceNum.length == 2 && faceNum[0].equalsIgnoreCase("facet")) {
/* 106 */                 facet = Math.cos(Double.parseDouble(faceNum[1]) * 3.1415926535D / 180.0D);
/*     */               }
/*     */               
/* 109 */               if (isValidVertexLine(currentLine)) {
/* 110 */                 vertexNum = Integer.valueOf(currentLine.split(" ")[1]).intValue();
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/* 115 */             if (vertexNum > 0) {
/* 116 */               while ((currentLine = reader.readLine()) != null) {
/* 117 */                 lineCount++;
/* 118 */                 currentLine = currentLine.replaceAll("\\s+", " ").trim();
/* 119 */                 String[] faceNum = currentLine.split(" ");
/* 120 */                 if (faceNum.length == 3) {
/* 121 */                   W_Vertex s = new W_Vertex(Float.valueOf(faceNum[0]).floatValue() / 100.0F, Float.valueOf(faceNum[1]).floatValue() / 100.0F, Float.valueOf(faceNum[2]).floatValue() / 100.0F);
/* 122 */                   checkMinMax(s);
/* 123 */                   this.vertices.add(s);
/* 124 */                   vertexNum--;
/* 125 */                   if (vertexNum <= 0)
/*     */                     break;  continue;
/*     */                 } 
/* 128 */                 if (faceNum.length > 0) {
/* 129 */                   throw new ModelFormatException("format error : " + this.fileName + " : line=" + lineCount);
/*     */                 }
/*     */               } 
/*     */               
/* 133 */               int var30 = 0;
/*     */               
/* 135 */               while ((currentLine = reader.readLine()) != null) {
/* 136 */                 lineCount++;
/* 137 */                 currentLine = currentLine.replaceAll("\\s+", " ").trim();
/* 138 */                 if (isValidFaceLine(currentLine)) {
/* 139 */                   var30 = Integer.valueOf(currentLine.split(" ")[1]).intValue();
/*     */                   
/*     */                   break;
/*     */                 } 
/*     */               } 
/* 144 */               if (var30 > 0) {
/* 145 */                 while ((currentLine = reader.readLine()) != null) {
/* 146 */                   lineCount++;
/* 147 */                   currentLine = currentLine.replaceAll("\\s+", " ").trim();
/* 148 */                   String[] var31 = currentLine.split(" ");
/* 149 */                   if (var31.length <= 2) {
/* 150 */                     if (var31.length > 2 && Integer.valueOf(var31[0]).intValue() != 3)
/* 151 */                       throw new ModelFormatException("found face is not triangle : " + this.fileName + " : line=" + lineCount); 
/*     */                     continue;
/*     */                   } 
/* 154 */                   if (Integer.valueOf(var31[0]).intValue() >= 3) {
/* 155 */                     W_Face[] faces = parseFace(currentLine, lineCount, mirror);
/* 156 */                     W_Face[] arr$ = faces;
/* 157 */                     int len$ = faces.length;
/*     */                     
/* 159 */                     for (int i$ = 0; i$ < len$; i$++) {
/* 160 */                       W_Face face = arr$[i$];
/* 161 */                       e.faces.add(face);
/*     */                     } 
/*     */                   } 
/*     */                   
/* 165 */                   var30--;
/* 166 */                   if (var30 <= 0) {
/*     */                     break;
/*     */                   }
/*     */                 } 
/*     */ 
/*     */                 
/* 172 */                 calcVerticesNormal(e, shading, facet);
/*     */               } 
/*     */             } 
/*     */             
/* 176 */             this.vertexNum += this.vertices.size();
/* 177 */             this.faceNum += e.faces.size();
/* 178 */             this.vertices.clear();
/* 179 */             this.groupObjects.add(e);
/*     */           } 
/*     */         } 
/*     */       } 
/* 183 */     } catch (IOException var28) {
/* 184 */       throw new ModelFormatException("IO Exception reading model format : " + this.fileName, var28);
/*     */     } finally {
/* 186 */       checkMinMaxFinal();
/* 187 */       this.vertices = null;
/*     */       
/*     */       try {
/* 190 */         reader.close();
/* 191 */       } catch (IOException iOException) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 196 */         inputStream.close();
/* 197 */       } catch (IOException iOException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void calcVerticesNormal(W_GroupObject group, boolean shading, double facet) {
/* 206 */     Iterator<W_Face> i$ = group.faces.iterator();
/*     */     
/* 208 */     while (i$.hasNext()) {
/* 209 */       W_Face f = i$.next();
/* 210 */       f.vertexNormals = new W_Vertex[f.verticesID.length];
/*     */       
/* 212 */       for (int i = 0; i < f.verticesID.length; i++) {
/* 213 */         W_Vertex vn = getVerticesNormalFromFace(f.faceNormal, f.verticesID[i], group, (float)facet);
/* 214 */         vn.normalize();
/* 215 */         if (shading) {
/* 216 */           if ((f.faceNormal.x * vn.x + f.faceNormal.y * vn.y + f.faceNormal.z * vn.z) >= facet) {
/* 217 */             f.vertexNormals[i] = vn;
/*     */           } else {
/* 219 */             f.vertexNormals[i] = f.faceNormal;
/*     */           } 
/*     */         } else {
/* 222 */           f.vertexNormals[i] = f.faceNormal;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public W_Vertex getVerticesNormalFromFace(W_Vertex faceNormal, int verticesID, W_GroupObject group, float facet) {
/* 230 */     W_Vertex v = new W_Vertex(0.0F, 0.0F, 0.0F);
/* 231 */     Iterator<W_Face> i$ = group.faces.iterator();
/*     */     
/* 233 */     while (i$.hasNext()) {
/* 234 */       W_Face f = i$.next();
/* 235 */       int[] arr$ = f.verticesID;
/* 236 */       int len$ = arr$.length;
/*     */       
/* 238 */       for (int i$1 = 0; i$1 < len$; i$1++) {
/* 239 */         int id = arr$[i$1];
/* 240 */         if (id == verticesID) {
/* 241 */           if (f.faceNormal.x * faceNormal.x + f.faceNormal.y * faceNormal.y + f.faceNormal.z * faceNormal.z >= facet) {
/* 242 */             v.add(f.faceNormal);
/*     */           }
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 249 */     v.normalize();
/* 250 */     return v;
/*     */   }
/*     */   
/*     */   public void renderAll() {
/* 254 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 255 */     if (this.currentGroupObject != null) {
/* 256 */       tessellator.func_78371_b(this.currentGroupObject.glDrawingMode);
/*     */     } else {
/* 258 */       tessellator.func_78371_b(4);
/*     */     } 
/*     */     
/* 261 */     tessellateAll(tessellator);
/* 262 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public void tessellateAll(Tessellator tessellator) {
/* 266 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 268 */     while (i$.hasNext()) {
/* 269 */       W_GroupObject groupObject = i$.next();
/* 270 */       groupObject.render(tessellator);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderOnly(String... groupNames) {
/* 276 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 278 */     while (i$.hasNext()) {
/* 279 */       W_GroupObject groupObject = i$.next();
/* 280 */       String[] arr$ = groupNames;
/* 281 */       int len$ = groupNames.length;
/*     */       
/* 283 */       for (int i$1 = 0; i$1 < len$; i$1++) {
/* 284 */         String groupName = arr$[i$1];
/* 285 */         if (groupName.equalsIgnoreCase(groupObject.name)) {
/* 286 */           groupObject.render();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void tessellateOnly(Tessellator tessellator, String... groupNames) {
/* 294 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 296 */     while (i$.hasNext()) {
/* 297 */       W_GroupObject groupObject = i$.next();
/* 298 */       String[] arr$ = groupNames;
/* 299 */       int len$ = groupNames.length;
/*     */       
/* 301 */       for (int i$1 = 0; i$1 < len$; i$1++) {
/* 302 */         String groupName = arr$[i$1];
/* 303 */         if (groupName.equalsIgnoreCase(groupObject.name)) {
/* 304 */           groupObject.render(tessellator);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPart(String partName) {
/* 313 */     if (partName.charAt(0) == '$') {
/* 314 */       for (int i$ = 0; i$ < this.groupObjects.size(); i$++) {
/* 315 */         W_GroupObject groupObject = this.groupObjects.get(i$);
/* 316 */         if (partName.equalsIgnoreCase(groupObject.name)) {
/* 317 */           groupObject.render();
/* 318 */           i$++;
/*     */           
/* 320 */           while (i$ < this.groupObjects.size()) {
/* 321 */             groupObject = this.groupObjects.get(i$);
/* 322 */             if (groupObject.name.charAt(0) == '$') {
/*     */               break;
/*     */             }
/*     */             
/* 326 */             groupObject.render();
/* 327 */             i$++;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/* 332 */       Iterator<W_GroupObject> var4 = this.groupObjects.iterator();
/*     */       
/* 334 */       while (var4.hasNext()) {
/* 335 */         W_GroupObject groupObject = var4.next();
/* 336 */         if (partName.equalsIgnoreCase(groupObject.name)) {
/* 337 */           groupObject.render();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void tessellatePart(Tessellator tessellator, String partName) {
/* 345 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 347 */     while (i$.hasNext()) {
/* 348 */       W_GroupObject groupObject = i$.next();
/* 349 */       if (partName.equalsIgnoreCase(groupObject.name)) {
/* 350 */         groupObject.render(tessellator);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAllExcept(String... excludedGroupNames) {
/* 357 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 359 */     while (i$.hasNext()) {
/* 360 */       W_GroupObject groupObject = i$.next();
/* 361 */       boolean skipPart = false;
/* 362 */       String[] arr$ = excludedGroupNames;
/* 363 */       int len$ = excludedGroupNames.length;
/*     */       
/* 365 */       for (int i$1 = 0; i$1 < len$; i$1++) {
/* 366 */         String excludedGroupName = arr$[i$1];
/* 367 */         if (excludedGroupName.equalsIgnoreCase(groupObject.name)) {
/* 368 */           skipPart = true;
/*     */         }
/*     */       } 
/*     */       
/* 372 */       if (!skipPart) {
/* 373 */         groupObject.render();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void tessellateAllExcept(Tessellator tessellator, String... excludedGroupNames) {
/* 380 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 382 */     while (i$.hasNext()) {
/* 383 */       W_GroupObject groupObject = i$.next();
/* 384 */       boolean exclude = false;
/* 385 */       String[] arr$ = excludedGroupNames;
/* 386 */       int len$ = excludedGroupNames.length;
/*     */       
/* 388 */       for (int i$1 = 0; i$1 < len$; i$1++) {
/* 389 */         String excludedGroupName = arr$[i$1];
/* 390 */         if (excludedGroupName.equalsIgnoreCase(groupObject.name)) {
/* 391 */           exclude = true;
/*     */         }
/*     */       } 
/*     */       
/* 395 */       if (!exclude) {
/* 396 */         groupObject.render(tessellator);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private W_Face[] parseFace(String line, int lineCount, boolean mirror) {
/* 403 */     String[] s = line.split("[ VU)(M]+");
/* 404 */     int vnum = Integer.valueOf(s[0]).intValue();
/* 405 */     if (vnum != 3 && vnum != 4) {
/* 406 */       return new W_Face[0];
/*     */     }
/*     */     
/* 409 */     if (vnum == 3) {
/* 410 */       W_Face w_Face = new W_Face();
/* 411 */       w_Face.verticesID = new int[] { Integer.valueOf(s[3]).intValue(), Integer.valueOf(s[2]).intValue(), Integer.valueOf(s[1]).intValue() };
/* 412 */       w_Face.vertices = new W_Vertex[] { this.vertices.get(w_Face.verticesID[0]), this.vertices.get(w_Face.verticesID[1]), this.vertices.get(w_Face.verticesID[2]) };
/* 413 */       if (s.length >= 11) {
/* 414 */         w_Face.textureCoordinates = new W_TextureCoordinate[] { new W_TextureCoordinate(Float.valueOf(s[9]).floatValue(), Float.valueOf(s[10]).floatValue()), new W_TextureCoordinate(Float.valueOf(s[7]).floatValue(), Float.valueOf(s[8]).floatValue()), new W_TextureCoordinate(Float.valueOf(s[5]).floatValue(), Float.valueOf(s[6]).floatValue()) };
/*     */       } else {
/* 416 */         w_Face.textureCoordinates = new W_TextureCoordinate[] { new W_TextureCoordinate(0.0F, 0.0F), new W_TextureCoordinate(0.0F, 0.0F), new W_TextureCoordinate(0.0F, 0.0F) };
/*     */       } 
/*     */       
/* 419 */       w_Face.faceNormal = w_Face.calculateFaceNormal();
/* 420 */       return new W_Face[] { w_Face };
/*     */     } 
/* 422 */     W_Face face1 = new W_Face();
/* 423 */     face1.verticesID = new int[] { Integer.valueOf(s[3]).intValue(), Integer.valueOf(s[2]).intValue(), Integer.valueOf(s[1]).intValue() };
/* 424 */     face1.vertices = new W_Vertex[] { this.vertices.get(face1.verticesID[0]), this.vertices.get(face1.verticesID[1]), this.vertices.get(face1.verticesID[2]) };
/* 425 */     if (s.length >= 12) {
/* 426 */       face1.textureCoordinates = new W_TextureCoordinate[] { new W_TextureCoordinate(Float.valueOf(s[10]).floatValue(), Float.valueOf(s[11]).floatValue()), new W_TextureCoordinate(Float.valueOf(s[8]).floatValue(), Float.valueOf(s[9]).floatValue()), new W_TextureCoordinate(Float.valueOf(s[6]).floatValue(), Float.valueOf(s[7]).floatValue()) };
/*     */     } else {
/* 428 */       face1.textureCoordinates = new W_TextureCoordinate[] { new W_TextureCoordinate(0.0F, 0.0F), new W_TextureCoordinate(0.0F, 0.0F), new W_TextureCoordinate(0.0F, 0.0F) };
/*     */     } 
/*     */     
/* 431 */     face1.faceNormal = face1.calculateFaceNormal();
/* 432 */     W_Face face2 = new W_Face();
/* 433 */     face2.verticesID = new int[] { Integer.valueOf(s[4]).intValue(), Integer.valueOf(s[3]).intValue(), Integer.valueOf(s[1]).intValue() };
/* 434 */     face2.vertices = new W_Vertex[] { this.vertices.get(face2.verticesID[0]), this.vertices.get(face2.verticesID[1]), this.vertices.get(face2.verticesID[2]) };
/* 435 */     if (s.length >= 14) {
/* 436 */       face2.textureCoordinates = new W_TextureCoordinate[] { new W_TextureCoordinate(Float.valueOf(s[12]).floatValue(), Float.valueOf(s[13]).floatValue()), new W_TextureCoordinate(Float.valueOf(s[10]).floatValue(), Float.valueOf(s[11]).floatValue()), new W_TextureCoordinate(Float.valueOf(s[6]).floatValue(), Float.valueOf(s[7]).floatValue()) };
/*     */     } else {
/* 438 */       face2.textureCoordinates = new W_TextureCoordinate[] { new W_TextureCoordinate(0.0F, 0.0F), new W_TextureCoordinate(0.0F, 0.0F), new W_TextureCoordinate(0.0F, 0.0F) };
/*     */     } 
/*     */     
/* 441 */     face2.faceNormal = face2.calculateFaceNormal();
/* 442 */     return new W_Face[] { face1, face2 };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isValidGroupObjectLine(String line) {
/* 448 */     String[] s = line.split(" ");
/* 449 */     return (s.length >= 2 && s[0].equals("Object")) ? ((s[1].length() >= 4 && s[1].charAt(0) == '"')) : false;
/*     */   }
/*     */   
/*     */   private W_GroupObject parseGroupObject(String line, int lineCount) throws ModelFormatException {
/* 453 */     W_GroupObject group = null;
/* 454 */     if (isValidGroupObjectLine(line)) {
/* 455 */       String[] s = line.split(" ");
/* 456 */       String trimmedLine = s[1].substring(1, s[1].length() - 1);
/* 457 */       if (trimmedLine.length() > 0) {
/* 458 */         group = new W_GroupObject(trimmedLine);
/*     */       }
/*     */       
/* 461 */       return group;
/*     */     } 
/* 463 */     throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isValidVertexLine(String line) {
/* 468 */     String[] s = line.split(" ");
/* 469 */     return s[0].equals("vertex");
/*     */   }
/*     */   
/*     */   private static boolean isValidFaceLine(String line) {
/* 473 */     String[] s = line.split(" ");
/* 474 */     return s[0].equals("face");
/*     */   }
/*     */   
/*     */   public String getType() {
/* 478 */     return "mqo";
/*     */   }
/*     */   
/*     */   public void renderAllLine(int startLine, int maxLine) {
/* 482 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 483 */     tessellator.func_78371_b(1);
/* 484 */     renderAllLine(tessellator, startLine, maxLine);
/* 485 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public void renderAllLine(Tessellator tessellator, int startLine, int maxLine) {
/* 489 */     int lineCnt = 0;
/* 490 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 492 */     while (i$.hasNext()) {
/* 493 */       W_GroupObject groupObject = i$.next();
/* 494 */       if (groupObject.faces.size() > 0) {
/* 495 */         Iterator<W_Face> i$1 = groupObject.faces.iterator();
/*     */         
/* 497 */         while (i$1.hasNext()) {
/* 498 */           W_Face face = i$1.next();
/*     */           
/* 500 */           for (int i = 0; i < face.vertices.length / 3; i++) {
/* 501 */             W_Vertex v1 = face.vertices[i * 3 + 0];
/* 502 */             W_Vertex v2 = face.vertices[i * 3 + 1];
/* 503 */             W_Vertex v3 = face.vertices[i * 3 + 2];
/* 504 */             lineCnt++;
/* 505 */             if (lineCnt > maxLine) {
/*     */               return;
/*     */             }
/*     */             
/* 509 */             tessellator.func_78377_a(v1.x, v1.y, v1.z);
/* 510 */             tessellator.func_78377_a(v2.x, v2.y, v2.z);
/* 511 */             lineCnt++;
/* 512 */             if (lineCnt > maxLine) {
/*     */               return;
/*     */             }
/*     */             
/* 516 */             tessellator.func_78377_a(v2.x, v2.y, v2.z);
/* 517 */             tessellator.func_78377_a(v3.x, v3.y, v3.z);
/* 518 */             lineCnt++;
/* 519 */             if (lineCnt > maxLine) {
/*     */               return;
/*     */             }
/*     */             
/* 523 */             tessellator.func_78377_a(v3.x, v3.y, v3.z);
/* 524 */             tessellator.func_78377_a(v1.x, v1.y, v1.z);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVertexNum() {
/* 533 */     return this.vertexNum;
/*     */   }
/*     */   
/*     */   public int getFaceNum() {
/* 537 */     return this.faceNum;
/*     */   }
/*     */   
/*     */   public void renderAll(int startFace, int maxFace) {
/* 541 */     if (startFace < 0) {
/* 542 */       startFace = 0;
/*     */     }
/*     */     
/* 545 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 546 */     tessellator.func_78371_b(4);
/* 547 */     renderAll(tessellator, startFace, maxFace);
/* 548 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public void renderAll(Tessellator tessellator, int startFace, int maxLine) {
/* 552 */     int faceCnt = 0;
/* 553 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 555 */     while (i$.hasNext()) {
/* 556 */       W_GroupObject groupObject = i$.next();
/* 557 */       if (groupObject.faces.size() > 0) {
/* 558 */         Iterator<W_Face> i$1 = groupObject.faces.iterator();
/*     */         
/* 560 */         while (i$1.hasNext()) {
/* 561 */           W_Face face = i$1.next();
/* 562 */           faceCnt++;
/* 563 */           if (faceCnt >= startFace) {
/* 564 */             if (faceCnt > maxLine) {
/*     */               return;
/*     */             }
/*     */             
/* 568 */             face.addFaceForRender(tessellator);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\modelloader\W_MetasequoiaObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */