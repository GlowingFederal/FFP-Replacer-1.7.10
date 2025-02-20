/*     */ package mcheli.multiplay;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.relauncher.CoreModManager;
/*     */ import java.awt.Robot;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ import java.util.zip.ZipEntry;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_FileSearch;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.MCH_OStream;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MCH_MultiplayClient {
/*  32 */   private static List modList = new ArrayList(); private static IntBuffer pixelBuffer; private static int[] pixelValues;
/*     */   private static MCH_OStream dataOutputStream;
/*     */   
/*     */   public static void startSendImageData() {
/*  36 */     Minecraft mc = Minecraft.func_71410_x();
/*  37 */     sendScreenShot(mc.field_71443_c, mc.field_71440_d, mc.func_147110_a());
/*     */   }
/*     */   
/*     */   public static void sendScreenShot(int displayWidth, int displayHeight, Framebuffer framebufferMc) {
/*     */     try {
/*  42 */       if (OpenGlHelper.func_148822_b()) {
/*  43 */         displayWidth = framebufferMc.field_147622_a;
/*  44 */         displayHeight = framebufferMc.field_147620_b;
/*     */       } 
/*     */       
/*  47 */       int exception = displayWidth * displayHeight;
/*  48 */       if (pixelBuffer == null || pixelBuffer.capacity() < exception) {
/*  49 */         pixelBuffer = BufferUtils.createIntBuffer(exception);
/*  50 */         pixelValues = new int[exception];
/*     */       } 
/*     */       
/*  53 */       GL11.glPixelStorei(3333, 1);
/*  54 */       GL11.glPixelStorei(3317, 1);
/*  55 */       pixelBuffer.clear();
/*  56 */       if (OpenGlHelper.func_148822_b()) {
/*  57 */         GL11.glBindTexture(3553, framebufferMc.field_147617_g);
/*  58 */         GL11.glGetTexImage(3553, 0, 32993, 33639, pixelBuffer);
/*     */       } else {
/*  60 */         GL11.glReadPixels(0, 0, displayWidth, displayHeight, 32993, 33639, pixelBuffer);
/*     */       } 
/*     */       
/*  63 */       pixelBuffer.get(pixelValues);
/*  64 */       TextureUtil.func_147953_a(pixelValues, displayWidth, displayHeight);
/*  65 */       BufferedImage bufferedimage = null;
/*  66 */       if (OpenGlHelper.func_148822_b()) {
/*  67 */         bufferedimage = new BufferedImage(framebufferMc.field_147621_c, framebufferMc.field_147618_d, 1);
/*  68 */         int l = framebufferMc.field_147620_b - framebufferMc.field_147618_d;
/*     */         
/*  70 */         for (int i1 = l; i1 < framebufferMc.field_147620_b; i1++) {
/*  71 */           for (int j1 = 0; j1 < framebufferMc.field_147621_c; j1++) {
/*  72 */             bufferedimage.setRGB(j1, i1 - l, pixelValues[i1 * framebufferMc.field_147622_a + j1]);
/*     */           }
/*     */         } 
/*     */       } else {
/*  76 */         bufferedimage = new BufferedImage(displayWidth, displayHeight, 1);
/*  77 */         bufferedimage.setRGB(0, 0, displayWidth, displayHeight, pixelValues, 0, displayWidth);
/*     */       } 
/*     */       
/*  80 */       Robot rb = new Robot();
/*  81 */       bufferedimage = rb.createScreenCapture(new Rectangle(0, 0, 1920, 1080));
/*  82 */       dataOutputStream = new MCH_OStream();
/*  83 */       ImageIO.write(bufferedimage, "png", (OutputStream)dataOutputStream);
/*  84 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void readImageData(DataOutputStream dos) throws IOException {
/*  91 */     dataOutputStream.write(dos);
/*     */   }
/*     */   
/*     */   public static void sendImageData() {
/*  95 */     if (dataOutputStream != null) {
/*  96 */       MCH_PacketLargeData.send();
/*  97 */       if (dataOutputStream.isDataEnd()) {
/*  98 */         dataOutputStream = null;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static double getPerData() {
/* 105 */     return (dataOutputStream == null) ? -1.0D : (dataOutputStream.index / dataOutputStream.size());
/*     */   }
/*     */   
/*     */   public static void readModList(String playerName) {
/* 109 */     modList = new ArrayList();
/* 110 */     modList.add(EnumChatFormatting.RED + "###### " + playerName + " ######");
/* 111 */     String[] classFileNameList = System.getProperty("java.class.path").split(File.pathSeparator);
/* 112 */     String[] mc = classFileNameList;
/* 113 */     int search = classFileNameList.length;
/*     */     
/* 115 */     for (int files = 0; files < search; files++) {
/* 116 */       String arr$ = mc[files];
/* 117 */       MCH_Lib.DbgLog(true, "java.class.path=" + arr$, new Object[0]);
/* 118 */       if (arr$.length() > 1) {
/* 119 */         File len$ = new File(arr$);
/* 120 */         if (len$.getAbsolutePath().toLowerCase().indexOf("versions") >= 0) {
/* 121 */           modList.add(EnumChatFormatting.AQUA + "# Client class=" + len$.getName() + " : file size= " + len$.length());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 126 */     modList.add(EnumChatFormatting.YELLOW + "=== ActiveModList ===");
/* 127 */     Iterator<ModContainer> var20 = Loader.instance().getActiveModList().iterator();
/*     */     
/* 129 */     while (var20.hasNext()) {
/* 130 */       ModContainer var21 = var20.next();
/* 131 */       modList.add("" + var21 + "  [" + var21.getModId() + "]  " + var21.getName() + "[" + var21.getDisplayVersion() + "]  " + var21.getSource().getName());
/*     */     } 
/*     */ 
/*     */     
/* 135 */     if (CoreModManager.getAccessTransformers().size() > 0) {
/* 136 */       modList.add(EnumChatFormatting.YELLOW + "=== AccessTransformers ===");
/* 137 */       var20 = CoreModManager.getAccessTransformers().iterator();
/*     */       
/* 139 */       while (var20.hasNext()) {
/* 140 */         String var22 = (String)var20.next();
/* 141 */         modList.add(var22);
/*     */       } 
/*     */     } 
/*     */     
/* 145 */     if (CoreModManager.getLoadedCoremods().size() > 0) {
/* 146 */       modList.add(EnumChatFormatting.YELLOW + "=== LoadedCoremods ===");
/* 147 */       var20 = CoreModManager.getLoadedCoremods().iterator();
/*     */       
/* 149 */       while (var20.hasNext()) {
/* 150 */         String var22 = (String)var20.next();
/* 151 */         modList.add(var22);
/*     */       } 
/*     */     } 
/*     */     
/* 155 */     if (CoreModManager.getReparseableCoremods().size() > 0) {
/* 156 */       modList.add(EnumChatFormatting.YELLOW + "=== ReparseableCoremods ===");
/* 157 */       var20 = CoreModManager.getReparseableCoremods().iterator();
/*     */       
/* 159 */       while (var20.hasNext()) {
/* 160 */         String var22 = (String)var20.next();
/* 161 */         modList.add(var22);
/*     */       } 
/*     */     } 
/*     */     
/* 165 */     Minecraft var23 = Minecraft.func_71410_x();
/* 166 */     MCH_FileSearch var24 = new MCH_FileSearch();
/* 167 */     File[] var25 = var24.listFiles((new File(var23.field_71412_D, "mods")).getAbsolutePath(), "*.jar");
/* 168 */     modList.add(EnumChatFormatting.YELLOW + "=== Manifest ===");
/* 169 */     File[] var26 = var25;
/* 170 */     int var27 = var25.length;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int i$;
/*     */ 
/*     */ 
/*     */     
/* 179 */     for (i$ = 0; i$ < var27; i$++) {
/* 180 */       File file = var26[i$];
/*     */       
/*     */       try {
/* 183 */         String e = file.getCanonicalPath();
/* 184 */         JarFile jarFile = new JarFile(e);
/* 185 */         Enumeration<JarEntry> jarEntries = jarFile.entries();
/* 186 */         String litemod_json = "";
/*     */         
/* 188 */         while (jarEntries.hasMoreElements()) {
/* 189 */           ZipEntry zipEntry = jarEntries.nextElement();
/* 190 */           if (zipEntry.getName().equalsIgnoreCase("META-INF/MANIFEST.MF") && !zipEntry.isDirectory()) {
/* 191 */             InputStream fname = jarFile.getInputStream(zipEntry);
/* 192 */             BufferedReader index = new BufferedReader(new InputStreamReader(fname));
/*     */             
/* 194 */             for (String br = index.readLine(); br != null; br = index.readLine()) {
/* 195 */               br = br.replace(" ", "").trim();
/* 196 */               if (!br.isEmpty()) {
/* 197 */                 litemod_json = litemod_json + " [" + br + "]";
/*     */               }
/*     */             } 
/*     */             
/* 201 */             fname.close();
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 206 */         jarFile.close();
/* 207 */         if (!litemod_json.isEmpty()) {
/* 208 */           modList.add(file.getName() + litemod_json);
/*     */         }
/* 210 */       } catch (Exception var19) {
/* 211 */         modList.add(file.getName() + " : Read Manifest failed.");
/*     */       } 
/*     */     } 
/*     */     
/* 215 */     var24 = new MCH_FileSearch();
/* 216 */     var25 = var24.listFiles((new File(var23.field_71412_D, "mods")).getAbsolutePath(), "*.litemod");
/* 217 */     modList.add(EnumChatFormatting.LIGHT_PURPLE + "=== LiteLoader ===");
/* 218 */     var26 = var25;
/* 219 */     var27 = var25.length;
/*     */     
/* 221 */     for (i$ = 0; i$ < var27; i$++) {
/* 222 */       File file = var26[i$];
/*     */       
/*     */       try {
/* 225 */         String e = file.getCanonicalPath();
/* 226 */         JarFile jarFile = new JarFile(e);
/* 227 */         Enumeration<JarEntry> jarEntries = jarFile.entries();
/* 228 */         String litemod_json = "";
/*     */         
/* 230 */         while (jarEntries.hasMoreElements()) {
/* 231 */           ZipEntry zipEntry = jarEntries.nextElement();
/* 232 */           String var28 = zipEntry.getName().toLowerCase();
/* 233 */           if (!zipEntry.isDirectory()) {
/* 234 */             if (!var28.equals("litemod.json")) {
/* 235 */               int var30 = var28.lastIndexOf("/");
/* 236 */               if (var30 >= 0) {
/* 237 */                 var28 = var28.substring(var30 + 1);
/*     */               }
/*     */               
/* 240 */               if (var28.indexOf("litemod") >= 0 && var28.endsWith("class")) {
/* 241 */                 var28 = zipEntry.getName();
/* 242 */                 if (var30 >= 0) {
/* 243 */                   var28 = var28.substring(var30 + 1);
/*     */                 }
/*     */                 
/* 246 */                 litemod_json = litemod_json + " [" + var28 + "]";
/*     */               }  continue;
/*     */             } 
/* 249 */             InputStream var29 = jarFile.getInputStream(zipEntry);
/* 250 */             BufferedReader var31 = new BufferedReader(new InputStreamReader(var29));
/*     */             
/* 252 */             for (String line = var31.readLine(); line != null; line = var31.readLine()) {
/* 253 */               line = line.replace(" ", "").trim();
/* 254 */               if (line.toLowerCase().indexOf("name") >= 0) {
/* 255 */                 litemod_json = litemod_json + " [" + line + "]";
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/* 260 */             var29.close();
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 265 */         jarFile.close();
/* 266 */         if (!litemod_json.isEmpty()) {
/* 267 */           modList.add(file.getName() + litemod_json);
/*     */         }
/* 269 */       } catch (Exception var18) {
/* 270 */         modList.add(file.getName() + " : Read LiteLoader failed.");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendModsInfo(String playerName, int id) {
/* 277 */     MCH_Config var10000 = MCH_MOD.config;
/* 278 */     if (MCH_Config.DebugLog) {
/* 279 */       modList.clear();
/* 280 */       readModList(playerName);
/*     */     } 
/*     */     
/* 283 */     MCH_PacketModList.send(modList, id);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_MultiplayClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */