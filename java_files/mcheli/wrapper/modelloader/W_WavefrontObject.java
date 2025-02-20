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
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.resources.IResource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.model.ModelFormatException;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class W_WavefrontObject
/*     */   extends W_ModelCustom
/*     */ {
/*  24 */   private static Pattern vertexPattern = Pattern.compile("(v( (\\-){0,1}\\d+\\.\\d+){3,4} *\\n)|(v( (\\-){0,1}\\d+\\.\\d+){3,4} *$)");
/*  25 */   private static Pattern vertexNormalPattern = Pattern.compile("(vn( (\\-){0,1}\\d+\\.\\d+){3,4} *\\n)|(vn( (\\-){0,1}\\d+\\.\\d+){3,4} *$)");
/*  26 */   private static Pattern textureCoordinatePattern = Pattern.compile("(vt( (\\-){0,1}\\d+\\.\\d+){2,3} *\\n)|(vt( (\\-){0,1}\\d+\\.\\d+){2,3} *$)");
/*  27 */   private static Pattern face_V_VT_VN_Pattern = Pattern.compile("(f( \\d+/\\d+/\\d+){3,4} *\\n)|(f( \\d+/\\d+/\\d+){3,4} *$)");
/*  28 */   private static Pattern face_V_VT_Pattern = Pattern.compile("(f( \\d+/\\d+){3,4} *\\n)|(f( \\d+/\\d+){3,4} *$)");
/*  29 */   private static Pattern face_V_VN_Pattern = Pattern.compile("(f( \\d+//\\d+){3,4} *\\n)|(f( \\d+//\\d+){3,4} *$)");
/*  30 */   private static Pattern face_V_Pattern = Pattern.compile("(f( \\d+){3,4} *\\n)|(f( \\d+){3,4} *$)");
/*  31 */   private static Pattern groupObjectPattern = Pattern.compile("([go]( [-\\$\\w\\d]+) *\\n)|([go]( [-\\$\\w\\d]+) *$)");
/*     */   private static Matcher vertexMatcher;
/*     */   private static Matcher vertexNormalMatcher;
/*     */   private static Matcher textureCoordinateMatcher;
/*     */   private static Matcher face_V_VT_VN_Matcher;
/*     */   private static Matcher face_V_VT_Matcher;
/*     */   private static Matcher face_V_VN_Matcher;
/*     */   private static Matcher face_V_Matcher;
/*     */   private static Matcher groupObjectMatcher;
/*  40 */   public ArrayList vertices = new ArrayList();
/*  41 */   public ArrayList vertexNormals = new ArrayList();
/*  42 */   public ArrayList textureCoordinates = new ArrayList();
/*  43 */   public ArrayList groupObjects = new ArrayList();
/*     */   
/*     */   private W_GroupObject currentGroupObject;
/*     */   private String fileName;
/*     */   
/*     */   public W_WavefrontObject(ResourceLocation resource) throws ModelFormatException {
/*  49 */     this.fileName = resource.toString();
/*     */     
/*     */     try {
/*  52 */       IResource e = Minecraft.func_71410_x().func_110442_L().func_110536_a(resource);
/*  53 */       loadObjModel(e.func_110527_b());
/*  54 */     } catch (IOException var3) {
/*  55 */       throw new ModelFormatException("IO Exception reading model format", var3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public W_WavefrontObject(String fileName, URL resource) throws ModelFormatException {
/*  60 */     this.fileName = fileName;
/*     */     
/*     */     try {
/*  63 */       loadObjModel(resource.openStream());
/*  64 */     } catch (IOException var4) {
/*  65 */       throw new ModelFormatException("IO Exception reading model format", var4);
/*     */     } 
/*     */   }
/*     */   
/*     */   public W_WavefrontObject(String filename, InputStream inputStream) throws ModelFormatException {
/*  70 */     this.fileName = filename;
/*  71 */     loadObjModel(inputStream);
/*     */   }
/*     */   public boolean containsPart(String partName) {
/*     */     W_GroupObject groupObject;
/*  75 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */ 
/*     */     
/*     */     do {
/*  79 */       if (!i$.hasNext()) {
/*  80 */         return false;
/*     */       }
/*     */       
/*  83 */       groupObject = i$.next();
/*  84 */     } while (!partName.equalsIgnoreCase(groupObject.name));
/*     */     
/*  86 */     return true;
/*     */   }
/*     */   
/*     */   private void loadObjModel(InputStream inputStream) throws ModelFormatException {
/*  90 */     BufferedReader reader = null;
/*  91 */     String currentLine = null;
/*  92 */     int lineCount = 0;
/*     */     
/*     */     try {
/*  95 */       reader = new BufferedReader(new InputStreamReader(inputStream));
/*     */       
/*  97 */       while ((currentLine = reader.readLine()) != null) {
/*  98 */         lineCount++;
/*  99 */         currentLine = currentLine.replaceAll("\\s+", " ").trim();
/* 100 */         if (!currentLine.startsWith("#") && currentLine.length() != 0) {
/*     */           
/* 102 */           if (currentLine.startsWith("v ")) {
/* 103 */             W_Vertex e = parseVertex(currentLine, lineCount);
/* 104 */             if (e != null) {
/* 105 */               checkMinMax(e);
/* 106 */               this.vertices.add(e);
/*     */             }  continue;
/* 108 */           }  if (currentLine.startsWith("vn ")) {
/* 109 */             W_Vertex e = parseVertexNormal(currentLine, lineCount);
/* 110 */             if (e != null)
/* 111 */               this.vertexNormals.add(e);  continue;
/*     */           } 
/* 113 */           if (currentLine.startsWith("vt ")) {
/* 114 */             W_TextureCoordinate var18 = parseTextureCoordinate(currentLine, lineCount);
/* 115 */             if (var18 != null)
/* 116 */               this.textureCoordinates.add(var18);  continue;
/*     */           } 
/* 118 */           if (currentLine.startsWith("f ")) {
/* 119 */             if (this.currentGroupObject == null) {
/* 120 */               this.currentGroupObject = new W_GroupObject("Default");
/*     */             }
/*     */             
/* 123 */             W_Face var19 = parseFace(currentLine, lineCount);
/* 124 */             if (var19 != null)
/* 125 */               this.currentGroupObject.faces.add(var19);  continue;
/*     */           } 
/* 127 */           if ((currentLine.startsWith("g ") | currentLine.startsWith("o ")) != 0 && currentLine.charAt(2) == '$') {
/* 128 */             W_GroupObject var20 = parseGroupObject(currentLine, lineCount);
/* 129 */             if (var20 != null && this.currentGroupObject != null) {
/* 130 */               this.groupObjects.add(this.currentGroupObject);
/*     */             }
/*     */             
/* 133 */             this.currentGroupObject = var20;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 138 */       this.groupObjects.add(this.currentGroupObject);
/* 139 */     } catch (IOException var16) {
/* 140 */       throw new ModelFormatException("IO Exception reading model format", var16);
/*     */     } finally {
/* 142 */       checkMinMaxFinal();
/*     */       
/*     */       try {
/* 145 */         reader.close();
/* 146 */       } catch (IOException iOException) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 151 */         inputStream.close();
/* 152 */       } catch (IOException iOException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAll() {
/* 161 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 162 */     if (this.currentGroupObject != null) {
/* 163 */       tessellator.func_78371_b(this.currentGroupObject.glDrawingMode);
/*     */     } else {
/* 165 */       tessellator.func_78371_b(4);
/*     */     } 
/*     */     
/* 168 */     tessellateAll(tessellator);
/* 169 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public void tessellateAll(Tessellator tessellator) {
/* 173 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 175 */     while (i$.hasNext()) {
/* 176 */       W_GroupObject groupObject = i$.next();
/* 177 */       groupObject.render(tessellator);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderOnly(String... groupNames) {
/* 183 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 185 */     while (i$.hasNext()) {
/* 186 */       W_GroupObject groupObject = i$.next();
/* 187 */       String[] arr$ = groupNames;
/* 188 */       int len$ = groupNames.length;
/*     */       
/* 190 */       for (int i$1 = 0; i$1 < len$; i$1++) {
/* 191 */         String groupName = arr$[i$1];
/* 192 */         if (groupName.equalsIgnoreCase(groupObject.name)) {
/* 193 */           groupObject.render();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void tessellateOnly(Tessellator tessellator, String... groupNames) {
/* 201 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 203 */     while (i$.hasNext()) {
/* 204 */       W_GroupObject groupObject = i$.next();
/* 205 */       String[] arr$ = groupNames;
/* 206 */       int len$ = groupNames.length;
/*     */       
/* 208 */       for (int i$1 = 0; i$1 < len$; i$1++) {
/* 209 */         String groupName = arr$[i$1];
/* 210 */         if (groupName.equalsIgnoreCase(groupObject.name)) {
/* 211 */           groupObject.render(tessellator);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderPart(String partName) {
/* 219 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 221 */     while (i$.hasNext()) {
/* 222 */       W_GroupObject groupObject = i$.next();
/* 223 */       if (partName.equalsIgnoreCase(groupObject.name)) {
/* 224 */         groupObject.render();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void tessellatePart(Tessellator tessellator, String partName) {
/* 231 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 233 */     while (i$.hasNext()) {
/* 234 */       W_GroupObject groupObject = i$.next();
/* 235 */       if (partName.equalsIgnoreCase(groupObject.name)) {
/* 236 */         groupObject.render(tessellator);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAllExcept(String... excludedGroupNames) {
/* 243 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 245 */     while (i$.hasNext()) {
/* 246 */       W_GroupObject groupObject = i$.next();
/* 247 */       boolean skipPart = false;
/* 248 */       String[] arr$ = excludedGroupNames;
/* 249 */       int len$ = excludedGroupNames.length;
/*     */       
/* 251 */       for (int i$1 = 0; i$1 < len$; i$1++) {
/* 252 */         String excludedGroupName = arr$[i$1];
/* 253 */         if (excludedGroupName.equalsIgnoreCase(groupObject.name)) {
/* 254 */           skipPart = true;
/*     */         }
/*     */       } 
/*     */       
/* 258 */       if (!skipPart) {
/* 259 */         groupObject.render();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void tessellateAllExcept(Tessellator tessellator, String... excludedGroupNames) {
/* 266 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 268 */     while (i$.hasNext()) {
/* 269 */       W_GroupObject groupObject = i$.next();
/* 270 */       boolean exclude = false;
/* 271 */       String[] arr$ = excludedGroupNames;
/* 272 */       int len$ = excludedGroupNames.length;
/*     */       
/* 274 */       for (int i$1 = 0; i$1 < len$; i$1++) {
/* 275 */         String excludedGroupName = arr$[i$1];
/* 276 */         if (excludedGroupName.equalsIgnoreCase(groupObject.name)) {
/* 277 */           exclude = true;
/*     */         }
/*     */       } 
/*     */       
/* 281 */       if (!exclude) {
/* 282 */         groupObject.render(tessellator);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private W_Vertex parseVertex(String line, int lineCount) throws ModelFormatException {
/* 289 */     Object vertex = null;
/* 290 */     if (isValidVertexLine(line)) {
/* 291 */       line = line.substring(line.indexOf(" ") + 1);
/* 292 */       String[] tokens = line.split(" ");
/*     */       
/*     */       try {
/* 295 */         return (tokens.length == 2) ? new W_Vertex(Float.parseFloat(tokens[0]), Float.parseFloat(tokens[1])) : ((tokens.length == 3) ? new W_Vertex(Float.parseFloat(tokens[0]), Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])) : (W_Vertex)vertex);
/* 296 */       } catch (NumberFormatException var6) {
/* 297 */         throw new ModelFormatException(String.format("Number formatting error at line %d", new Object[] { Integer.valueOf(lineCount) }), var6);
/*     */       } 
/*     */     } 
/* 300 */     throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
/*     */   }
/*     */ 
/*     */   
/*     */   private W_Vertex parseVertexNormal(String line, int lineCount) throws ModelFormatException {
/* 305 */     Object vertexNormal = null;
/* 306 */     if (isValidVertexNormalLine(line)) {
/* 307 */       line = line.substring(line.indexOf(" ") + 1);
/* 308 */       String[] tokens = line.split(" ");
/*     */       
/*     */       try {
/* 311 */         return (tokens.length == 3) ? new W_Vertex(Float.parseFloat(tokens[0]), Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])) : (W_Vertex)vertexNormal;
/* 312 */       } catch (NumberFormatException var6) {
/* 313 */         throw new ModelFormatException(String.format("Number formatting error at line %d", new Object[] { Integer.valueOf(lineCount) }), var6);
/*     */       } 
/*     */     } 
/* 316 */     throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
/*     */   }
/*     */ 
/*     */   
/*     */   private W_TextureCoordinate parseTextureCoordinate(String line, int lineCount) throws ModelFormatException {
/* 321 */     Object textureCoordinate = null;
/* 322 */     if (isValidTextureCoordinateLine(line)) {
/* 323 */       line = line.substring(line.indexOf(" ") + 1);
/* 324 */       String[] tokens = line.split(" ");
/*     */       
/*     */       try {
/* 327 */         return (tokens.length == 2) ? new W_TextureCoordinate(Float.parseFloat(tokens[0]), 1.0F - Float.parseFloat(tokens[1])) : ((tokens.length == 3) ? new W_TextureCoordinate(Float.parseFloat(tokens[0]), 1.0F - Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])) : (W_TextureCoordinate)textureCoordinate);
/* 328 */       } catch (NumberFormatException var6) {
/* 329 */         throw new ModelFormatException(String.format("Number formatting error at line %d", new Object[] { Integer.valueOf(lineCount) }), var6);
/*     */       } 
/*     */     } 
/* 332 */     throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
/*     */   }
/*     */ 
/*     */   
/*     */   private W_Face parseFace(String line, int lineCount) throws ModelFormatException {
/* 337 */     W_Face face = null;
/* 338 */     if (isValidFaceLine(line)) {
/* 339 */       face = new W_Face();
/* 340 */       String trimmedLine = line.substring(line.indexOf(" ") + 1);
/* 341 */       String[] tokens = trimmedLine.split(" ");
/* 342 */       String[] subTokens = null;
/* 343 */       if (tokens.length == 3) {
/* 344 */         if (this.currentGroupObject.glDrawingMode == -1) {
/* 345 */           this.currentGroupObject.glDrawingMode = 4;
/* 346 */         } else if (this.currentGroupObject.glDrawingMode != 4) {
/* 347 */           throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Invalid number of points for face (expected 4, found " + tokens.length + ")");
/*     */         } 
/* 349 */       } else if (tokens.length == 4) {
/* 350 */         if (this.currentGroupObject.glDrawingMode == -1) {
/* 351 */           this.currentGroupObject.glDrawingMode = 7;
/* 352 */         } else if (this.currentGroupObject.glDrawingMode != 7) {
/* 353 */           throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Invalid number of points for face (expected 3, found " + tokens.length + ")");
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 358 */       if (isValidFace_V_VT_VN_Line(line)) {
/* 359 */         face.vertices = new W_Vertex[tokens.length];
/* 360 */         face.textureCoordinates = new W_TextureCoordinate[tokens.length];
/* 361 */         face.vertexNormals = new W_Vertex[tokens.length];
/*     */         
/* 363 */         for (int i = 0; i < tokens.length; i++) {
/* 364 */           subTokens = tokens[i].split("/");
/* 365 */           face.vertices[i] = this.vertices.get(Integer.parseInt(subTokens[0]) - 1);
/* 366 */           face.textureCoordinates[i] = this.textureCoordinates.get(Integer.parseInt(subTokens[1]) - 1);
/* 367 */           face.vertexNormals[i] = this.vertexNormals.get(Integer.parseInt(subTokens[2]) - 1);
/*     */         } 
/*     */         
/* 370 */         face.faceNormal = face.calculateFaceNormal();
/* 371 */       } else if (isValidFace_V_VT_Line(line)) {
/* 372 */         face.vertices = new W_Vertex[tokens.length];
/* 373 */         face.textureCoordinates = new W_TextureCoordinate[tokens.length];
/*     */         
/* 375 */         for (int i = 0; i < tokens.length; i++) {
/* 376 */           subTokens = tokens[i].split("/");
/* 377 */           face.vertices[i] = this.vertices.get(Integer.parseInt(subTokens[0]) - 1);
/* 378 */           face.textureCoordinates[i] = this.textureCoordinates.get(Integer.parseInt(subTokens[1]) - 1);
/*     */         } 
/*     */         
/* 381 */         face.faceNormal = face.calculateFaceNormal();
/* 382 */       } else if (isValidFace_V_VN_Line(line)) {
/* 383 */         face.vertices = new W_Vertex[tokens.length];
/* 384 */         face.vertexNormals = new W_Vertex[tokens.length];
/*     */         
/* 386 */         for (int i = 0; i < tokens.length; i++) {
/* 387 */           subTokens = tokens[i].split("//");
/* 388 */           face.vertices[i] = this.vertices.get(Integer.parseInt(subTokens[0]) - 1);
/* 389 */           face.vertexNormals[i] = this.vertexNormals.get(Integer.parseInt(subTokens[1]) - 1);
/*     */         } 
/*     */         
/* 392 */         face.faceNormal = face.calculateFaceNormal();
/*     */       } else {
/* 394 */         if (!isValidFace_V_Line(line)) {
/* 395 */           throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
/*     */         }
/*     */         
/* 398 */         face.vertices = new W_Vertex[tokens.length];
/*     */         
/* 400 */         for (int i = 0; i < tokens.length; i++) {
/* 401 */           face.vertices[i] = this.vertices.get(Integer.parseInt(tokens[i]) - 1);
/*     */         }
/*     */         
/* 404 */         face.faceNormal = face.calculateFaceNormal();
/*     */       } 
/*     */       
/* 407 */       return face;
/*     */     } 
/* 409 */     throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
/*     */   }
/*     */ 
/*     */   
/*     */   private W_GroupObject parseGroupObject(String line, int lineCount) throws ModelFormatException {
/* 414 */     W_GroupObject group = null;
/* 415 */     if (isValidGroupObjectLine(line)) {
/* 416 */       String trimmedLine = line.substring(line.indexOf(" ") + 1);
/* 417 */       if (trimmedLine.length() > 0) {
/* 418 */         group = new W_GroupObject(trimmedLine);
/*     */       }
/*     */       
/* 421 */       return group;
/*     */     } 
/* 423 */     throw new ModelFormatException("Error parsing entry ('" + line + "', line " + lineCount + ") in file '" + this.fileName + "' - Incorrect format");
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isValidVertexLine(String line) {
/* 428 */     if (vertexMatcher != null) {
/* 429 */       vertexMatcher.reset();
/*     */     }
/*     */     
/* 432 */     vertexMatcher = vertexPattern.matcher(line);
/* 433 */     return vertexMatcher.matches();
/*     */   }
/*     */   
/*     */   private static boolean isValidVertexNormalLine(String line) {
/* 437 */     if (vertexNormalMatcher != null) {
/* 438 */       vertexNormalMatcher.reset();
/*     */     }
/*     */     
/* 441 */     vertexNormalMatcher = vertexNormalPattern.matcher(line);
/* 442 */     return vertexNormalMatcher.matches();
/*     */   }
/*     */   
/*     */   private static boolean isValidTextureCoordinateLine(String line) {
/* 446 */     if (textureCoordinateMatcher != null) {
/* 447 */       textureCoordinateMatcher.reset();
/*     */     }
/*     */     
/* 450 */     textureCoordinateMatcher = textureCoordinatePattern.matcher(line);
/* 451 */     return textureCoordinateMatcher.matches();
/*     */   }
/*     */   
/*     */   private static boolean isValidFace_V_VT_VN_Line(String line) {
/* 455 */     if (face_V_VT_VN_Matcher != null) {
/* 456 */       face_V_VT_VN_Matcher.reset();
/*     */     }
/*     */     
/* 459 */     face_V_VT_VN_Matcher = face_V_VT_VN_Pattern.matcher(line);
/* 460 */     return face_V_VT_VN_Matcher.matches();
/*     */   }
/*     */   
/*     */   private static boolean isValidFace_V_VT_Line(String line) {
/* 464 */     if (face_V_VT_Matcher != null) {
/* 465 */       face_V_VT_Matcher.reset();
/*     */     }
/*     */     
/* 468 */     face_V_VT_Matcher = face_V_VT_Pattern.matcher(line);
/* 469 */     return face_V_VT_Matcher.matches();
/*     */   }
/*     */   
/*     */   private static boolean isValidFace_V_VN_Line(String line) {
/* 473 */     if (face_V_VN_Matcher != null) {
/* 474 */       face_V_VN_Matcher.reset();
/*     */     }
/*     */     
/* 477 */     face_V_VN_Matcher = face_V_VN_Pattern.matcher(line);
/* 478 */     return face_V_VN_Matcher.matches();
/*     */   }
/*     */   
/*     */   private static boolean isValidFace_V_Line(String line) {
/* 482 */     if (face_V_Matcher != null) {
/* 483 */       face_V_Matcher.reset();
/*     */     }
/*     */     
/* 486 */     face_V_Matcher = face_V_Pattern.matcher(line);
/* 487 */     return face_V_Matcher.matches();
/*     */   }
/*     */   
/*     */   private static boolean isValidFaceLine(String line) {
/* 491 */     return (isValidFace_V_VT_VN_Line(line) || isValidFace_V_VT_Line(line) || isValidFace_V_VN_Line(line) || isValidFace_V_Line(line));
/*     */   }
/*     */   
/*     */   private static boolean isValidGroupObjectLine(String line) {
/* 495 */     if (groupObjectMatcher != null) {
/* 496 */       groupObjectMatcher.reset();
/*     */     }
/*     */     
/* 499 */     groupObjectMatcher = groupObjectPattern.matcher(line);
/* 500 */     return groupObjectMatcher.matches();
/*     */   }
/*     */   
/*     */   public String getType() {
/* 504 */     return "obj";
/*     */   }
/*     */   
/*     */   public void renderAllLine(int startLine, int maxLine) {
/* 508 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 509 */     tessellator.func_78371_b(1);
/* 510 */     renderAllLine(tessellator, startLine, maxLine);
/* 511 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public void renderAllLine(Tessellator tessellator, int startLine, int maxLine) {
/* 515 */     int lineCnt = 0;
/* 516 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 518 */     while (i$.hasNext()) {
/* 519 */       W_GroupObject groupObject = i$.next();
/* 520 */       if (groupObject.faces.size() > 0) {
/* 521 */         Iterator<W_Face> i$1 = groupObject.faces.iterator();
/*     */         
/* 523 */         while (i$1.hasNext()) {
/* 524 */           W_Face face = i$1.next();
/*     */           
/* 526 */           for (int i = 0; i < face.vertices.length / 3; i++) {
/* 527 */             W_Vertex v1 = face.vertices[i * 3 + 0];
/* 528 */             W_Vertex v2 = face.vertices[i * 3 + 1];
/* 529 */             W_Vertex v3 = face.vertices[i * 3 + 2];
/* 530 */             lineCnt++;
/* 531 */             if (lineCnt > maxLine) {
/*     */               return;
/*     */             }
/*     */             
/* 535 */             tessellator.func_78377_a(v1.x, v1.y, v1.z);
/* 536 */             tessellator.func_78377_a(v2.x, v2.y, v2.z);
/* 537 */             lineCnt++;
/* 538 */             if (lineCnt > maxLine) {
/*     */               return;
/*     */             }
/*     */             
/* 542 */             tessellator.func_78377_a(v2.x, v2.y, v2.z);
/* 543 */             tessellator.func_78377_a(v3.x, v3.y, v3.z);
/* 544 */             lineCnt++;
/* 545 */             if (lineCnt > maxLine) {
/*     */               return;
/*     */             }
/*     */             
/* 549 */             tessellator.func_78377_a(v3.x, v3.y, v3.z);
/* 550 */             tessellator.func_78377_a(v1.x, v1.y, v1.z);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getVertexNum() {
/* 559 */     return this.vertices.size();
/*     */   }
/*     */   
/*     */   public int getFaceNum() {
/* 563 */     return getVertexNum() / 3;
/*     */   }
/*     */   
/*     */   public void renderAll(int startFace, int maxFace) {
/* 567 */     if (startFace < 0) {
/* 568 */       startFace = 0;
/*     */     }
/*     */     
/* 571 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 572 */     tessellator.func_78371_b(4);
/* 573 */     renderAll(tessellator, startFace, maxFace);
/* 574 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public void renderAll(Tessellator tessellator, int startFace, int maxLine) {
/* 578 */     int faceCnt = 0;
/* 579 */     Iterator<W_GroupObject> i$ = this.groupObjects.iterator();
/*     */     
/* 581 */     while (i$.hasNext()) {
/* 582 */       W_GroupObject groupObject = i$.next();
/* 583 */       if (groupObject.faces.size() > 0) {
/* 584 */         Iterator<W_Face> i$1 = groupObject.faces.iterator();
/*     */         
/* 586 */         while (i$1.hasNext()) {
/* 587 */           W_Face face = i$1.next();
/* 588 */           faceCnt++;
/* 589 */           if (faceCnt >= startFace) {
/* 590 */             if (faceCnt > maxLine) {
/*     */               return;
/*     */             }
/*     */             
/* 594 */             face.addFaceForRender(tessellator);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\modelloader\W_WavefrontObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */