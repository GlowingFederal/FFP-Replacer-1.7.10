/*     */ package mcheli.multiplay;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_MarkEntityPos;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.gui.MCH_Gui;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.glu.GLU;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_GuiTargetMarker
/*     */   extends MCH_Gui
/*     */ {
/*  29 */   private static FloatBuffer matModel = BufferUtils.createFloatBuffer(16);
/*     */   
/*  31 */   private static FloatBuffer matProjection = BufferUtils.createFloatBuffer(16);
/*     */   
/*  33 */   private static IntBuffer matViewport = BufferUtils.createIntBuffer(16);
/*     */   
/*  35 */   private static ArrayList<MCH_MarkEntityPos> entityPos = new ArrayList<>();
/*     */   
/*  37 */   private static HashMap<Integer, Integer> spotedEntity = new HashMap<>();
/*     */   
/*     */   private static Minecraft s_minecraft;
/*     */   
/*     */   public MCH_GuiTargetMarker(Minecraft minecraft) {
/*  42 */     super(minecraft);
/*  43 */     s_minecraft = minecraft;
/*     */   }
/*     */   
/*     */   public void func_73866_w_() {
/*  47 */     super.func_73866_w_();
/*     */   }
/*     */   
/*     */   public boolean func_73868_f() {
/*  51 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isDrawGui(EntityPlayer player) {
/*  55 */     return (player != null && player.field_70170_p != null);
/*     */   }
/*     */   
/*  58 */   private static int spotedEntityCountdown = 0;
/*     */   
/*     */   public static void onClientTick() {
/*  61 */     if (!Minecraft.func_71410_x().func_147113_T())
/*  62 */       spotedEntityCountdown++; 
/*  63 */     if (spotedEntityCountdown >= 20) {
/*  64 */       spotedEntityCountdown = 0;
/*  65 */       for (Integer key : spotedEntity.keySet()) {
/*  66 */         int count = ((Integer)spotedEntity.get(key)).intValue();
/*  67 */         if (count > 0)
/*  68 */           spotedEntity.put(key, Integer.valueOf(count - 1)); 
/*     */       } 
/*  70 */       for (Iterator<Integer> i = spotedEntity.values().iterator(); i.hasNext();) {
/*  71 */         if (((Integer)i.next()).intValue() <= 0)
/*  72 */           i.remove(); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean isSpotedEntity(Entity entity) {
/*  78 */     int entityId = entity.func_145782_y();
/*  79 */     for (Iterator<Integer> i$ = spotedEntity.keySet().iterator(); i$.hasNext(); ) {
/*  80 */       int key = ((Integer)i$.next()).intValue();
/*  81 */       if (key == entityId)
/*  82 */         return true; 
/*     */     } 
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public static void addSpotedEntity(int entityId, int count) {
/*  88 */     if (spotedEntity.containsKey(Integer.valueOf(entityId))) {
/*  89 */       int now = ((Integer)spotedEntity.get(Integer.valueOf(entityId))).intValue();
/*  90 */       if (count > now)
/*  91 */         spotedEntity.put(Integer.valueOf(entityId), Integer.valueOf(count)); 
/*     */     } else {
/*  93 */       spotedEntity.put(Integer.valueOf(entityId), Integer.valueOf(count));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void addMarkEntityPos(int reserve, Entity entity, double x, double y, double z) {
/*  98 */     addMarkEntityPos(reserve, entity, x, y, z, false);
/*     */   }
/*     */   
/*     */   public static void addMarkEntityPos(int reserve, Entity entity, double x, double y, double z, boolean nazo) {
/* 102 */     if (!isEnableEntityMarker())
/*     */       return; 
/* 104 */     MCH_TargetType spotType = MCH_TargetType.NONE;
/* 105 */     EntityClientPlayerMP entityClientPlayerMP = s_minecraft.field_71439_g;
/* 106 */     if (entity instanceof MCH_EntityAircraft) {
/* 107 */       MCH_EntityAircraft ac = (MCH_EntityAircraft)entity;
/* 108 */       if (ac.isMountedEntity((Entity)entityClientPlayerMP))
/*     */         return; 
/* 110 */       if (ac.isMountedSameTeamEntity((EntityLivingBase)entityClientPlayerMP))
/* 111 */         spotType = MCH_TargetType.SAME_TEAM_PLAYER; 
/* 112 */     } else if (entity instanceof EntityPlayer) {
/* 113 */       if (entity == entityClientPlayerMP || entity.field_70154_o instanceof mcheli.aircraft.MCH_EntitySeat || entity.field_70154_o instanceof MCH_EntityAircraft)
/*     */         return; 
/* 115 */       if (entityClientPlayerMP.func_96124_cp() != null && entityClientPlayerMP.func_142014_c((EntityLivingBase)entity))
/* 116 */         spotType = MCH_TargetType.SAME_TEAM_PLAYER; 
/*     */     } 
/* 118 */     if (spotType == MCH_TargetType.NONE && isSpotedEntity(entity))
/* 119 */       spotType = MCH_Multiplay.canSpotEntity((Entity)entityClientPlayerMP, ((EntityPlayer)entityClientPlayerMP).field_70165_t, ((EntityPlayer)entityClientPlayerMP).field_70163_u + entityClientPlayerMP.func_70047_e(), ((EntityPlayer)entityClientPlayerMP).field_70161_v, entity, false); 
/* 120 */     if (reserve == 100)
/* 121 */       spotType = MCH_TargetType.POINT; 
/* 122 */     if (spotType != MCH_TargetType.NONE) {
/* 123 */       MCH_MarkEntityPos e = new MCH_MarkEntityPos(spotType.ordinal(), entity);
/* 124 */       GL11.glGetFloat(2982, matModel);
/* 125 */       GL11.glGetFloat(2983, matProjection);
/* 126 */       GL11.glGetInteger(2978, matViewport);
/* 127 */       if (nazo) {
/* 128 */         GLU.gluProject((float)z, (float)y, (float)x, matModel, matProjection, matViewport, e.pos);
/* 129 */         float yy = e.pos.get(1);
/* 130 */         GLU.gluProject((float)x, (float)y, (float)z, matModel, matProjection, matViewport, e.pos);
/* 131 */         e.pos.put(1, yy);
/*     */       } else {
/* 133 */         GLU.gluProject((float)x, (float)y, (float)z, matModel, matProjection, matViewport, e.pos);
/*     */       } 
/* 135 */       entityPos.add(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void clearMarkEntityPos() {
/* 140 */     entityPos.clear();
/*     */   }
/*     */   
/*     */   public static boolean isEnableEntityMarker() {
/* 144 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawGui(EntityPlayer player, boolean isThirdPersonView) {
/* 151 */     GL11.glLineWidth((scaleFactor * 2));
/* 152 */     if (!isDrawGui(player))
/*     */       return; 
/* 154 */     GL11.glDisable(3042);
/* 155 */     if (isEnableEntityMarker()) {
/* 156 */       drawMark();
/*     */     }
/*     */   }
/*     */   
/*     */   void drawMark() {
/* 161 */     int[] COLOR_TABLE = { 0, -808464433, -805371904, -805306624, -822018049, -805351649, -65536, 0 };
/* 162 */     int scale = (scaleFactor > 0) ? scaleFactor : 2;
/* 163 */     GL11.glEnable(3042);
/* 164 */     GL11.glDisable(3553);
/* 165 */     GL11.glBlendFunc(770, 771);
/* 166 */     GL11.glColor4b((byte)-1, (byte)-1, (byte)-1, (byte)-1);
/* 167 */     GL11.glDepthMask(false);
/* 168 */     int DW = this.field_146297_k.field_71443_c;
/* 169 */     int DH = this.field_146297_k.field_71440_d;
/* 170 */     int DSW = this.field_146297_k.field_71443_c / scale;
/* 171 */     int DSH = this.field_146297_k.field_71440_d / scale;
/* 172 */     double x = 9999.0D;
/* 173 */     double z = 9999.0D;
/* 174 */     double y = 9999.0D;
/* 175 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 176 */     for (int i = 0; i < 2; i++) {
/* 177 */       if (i == 0)
/* 178 */         tessellator.func_78371_b((i == 0) ? 4 : 1); 
/* 179 */       for (MCH_MarkEntityPos e : entityPos) {
/* 180 */         if (!e.entity.field_70128_L) {
/* 181 */           int color = COLOR_TABLE[e.type];
/* 182 */           x = (e.pos.get(0) / scale);
/* 183 */           z = e.pos.get(2);
/* 184 */           y = (e.pos.get(1) / scale);
/* 185 */           if (z < 1.0D) {
/* 186 */             y = DSH - y;
/* 187 */           } else if (x < (DW / 2)) {
/* 188 */             x = 10000.0D;
/* 189 */           } else if (x >= (DW / 2)) {
/* 190 */             x = -10000.0D;
/*     */           } 
/* 192 */           if (i == 0) {
/* 193 */             double size = MCH_Config.EntityMarkerSize.prmDouble;
/* 194 */             if (e.type < MCH_TargetType.POINT.ordinal() && z < 1.0D && x >= 0.0D && x <= DSW && y >= 0.0D && y <= DSH)
/* 195 */               drawTriangle1(tessellator, x, y, size, color); 
/*     */             continue;
/*     */           } 
/* 198 */           if (e.type == MCH_TargetType.POINT.ordinal() && e.entity != null) {
/* 199 */             double MARK_SIZE = MCH_Config.BlockMarkerSize.prmDouble;
/* 200 */             if (z < 1.0D && x >= 0.0D && x <= (DSW - 20) && y >= 0.0D && y <= (DSH - 40)) {
/* 201 */               double dist = this.field_146297_k.field_71439_g.func_70032_d(e.entity);
/* 202 */               GL11.glEnable(3553);
/* 203 */               drawCenteredString(String.format("%.0fm", new Object[] { Double.valueOf(dist) }), (int)x, (int)(y + MARK_SIZE * 1.1D + 16.0D), color);
/* 204 */               if (x >= (DSW / 2 - 20) && x <= (DSW / 2 + 20) && y >= (DSH / 2 - 20) && y <= (DSH / 2 + 20)) {
/* 205 */                 drawString(String.format("x : %.0f", new Object[] { Double.valueOf(e.entity.field_70165_t) }), (int)(x + MARK_SIZE + 18.0D), (int)y - 12, color);
/* 206 */                 drawString(String.format("y : %.0f", new Object[] { Double.valueOf(e.entity.field_70163_u) }), (int)(x + MARK_SIZE + 18.0D), (int)y - 4, color);
/* 207 */                 drawString(String.format("z : %.0f", new Object[] { Double.valueOf(e.entity.field_70161_v) }), (int)(x + MARK_SIZE + 18.0D), (int)y + 4, color);
/*     */               } 
/* 209 */               GL11.glDisable(3553);
/* 210 */               tessellator.func_78371_b(1);
/* 211 */               drawRhombus(tessellator, 15, x, y, this.field_73735_i, MARK_SIZE, color);
/*     */             } else {
/* 213 */               tessellator.func_78371_b(1);
/* 214 */               double S = 30.0D;
/* 215 */               if (x < S) {
/* 216 */                 drawRhombus(tessellator, 1, S, (DSH / 2), this.field_73735_i, MARK_SIZE, color);
/* 217 */               } else if (x > DSW - S) {
/* 218 */                 drawRhombus(tessellator, 4, DSW - S, (DSH / 2), this.field_73735_i, MARK_SIZE, color);
/*     */               } 
/* 220 */               if (y < S) {
/* 221 */                 drawRhombus(tessellator, 8, (DSW / 2), S, this.field_73735_i, MARK_SIZE, color);
/* 222 */               } else if (y > DSH - S * 2.0D) {
/* 223 */                 drawRhombus(tessellator, 2, (DSW / 2), DSH - S * 2.0D, this.field_73735_i, MARK_SIZE, color);
/*     */               } 
/*     */             } 
/* 226 */             tessellator.func_78381_a();
/*     */           } 
/*     */         } 
/*     */       } 
/* 230 */       if (i == 0)
/* 231 */         tessellator.func_78381_a(); 
/*     */     } 
/* 233 */     GL11.glDepthMask(true);
/* 234 */     GL11.glEnable(3553);
/* 235 */     GL11.glDisable(3042);
/*     */   }
/*     */   
/*     */   public static void drawRhombus(Tessellator tessellator, int dir, double x, double y, double z, double size, int color) {
/* 239 */     size *= 2.0D;
/* 240 */     tessellator.func_78384_a(0xFFFFFF & color, color >> 24 & 0xFF);
/* 241 */     double M = size / 3.0D;
/* 242 */     if ((dir & 0x1) != 0) {
/* 243 */       tessellator.func_78377_a(x - size, y, z);
/* 244 */       tessellator.func_78377_a(x - size + M, y - M, z);
/* 245 */       tessellator.func_78377_a(x - size, y, z);
/* 246 */       tessellator.func_78377_a(x - size + M, y + M, z);
/*     */     } 
/* 248 */     if ((dir & 0x4) != 0) {
/* 249 */       tessellator.func_78377_a(x + size, y, z);
/* 250 */       tessellator.func_78377_a(x + size - M, y - M, z);
/* 251 */       tessellator.func_78377_a(x + size, y, z);
/* 252 */       tessellator.func_78377_a(x + size - M, y + M, z);
/*     */     } 
/* 254 */     if ((dir & 0x8) != 0) {
/* 255 */       tessellator.func_78377_a(x, y - size, z);
/* 256 */       tessellator.func_78377_a(x + M, y - size + M, z);
/* 257 */       tessellator.func_78377_a(x, y - size, z);
/* 258 */       tessellator.func_78377_a(x - M, y - size + M, z);
/*     */     } 
/* 260 */     if ((dir & 0x2) != 0) {
/* 261 */       tessellator.func_78377_a(x, y + size, z);
/* 262 */       tessellator.func_78377_a(x + M, y + size - M, z);
/* 263 */       tessellator.func_78377_a(x, y + size, z);
/* 264 */       tessellator.func_78377_a(x - M, y + size - M, z);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawTriangle1(Tessellator tessellator, double x, double y, double size, int color) {
/* 269 */     tessellator.func_78384_a(0xFFFFFF & color, color >> 24 & 0xFF);
/* 270 */     tessellator.func_78377_a(x + size / 2.0D, y - 10.0D - size, this.field_73735_i);
/* 271 */     tessellator.func_78377_a(x - size / 2.0D, y - 10.0D - size, this.field_73735_i);
/* 272 */     tessellator.func_78377_a(x + 0.0D, y - 10.0D, this.field_73735_i);
/*     */   }
/*     */   
/*     */   public void drawTriangle2(Tessellator tessellator, double x, double y, double size, int color) {
/* 276 */     tessellator.func_78384_a(0x7F7F7F & color, color >> 24 & 0xFF);
/* 277 */     tessellator.func_78377_a(x + size / 2.0D, y - 10.0D - size, this.field_73735_i);
/* 278 */     tessellator.func_78377_a(x - size / 2.0D, y - 10.0D - size, this.field_73735_i);
/* 279 */     tessellator.func_78377_a(x - size / 2.0D, y - 10.0D - size, this.field_73735_i);
/* 280 */     tessellator.func_78377_a(x + 0.0D, y - 10.0D, this.field_73735_i);
/* 281 */     tessellator.func_78377_a(x + 0.0D, y - 10.0D, this.field_73735_i);
/* 282 */     tessellator.func_78377_a(x + size / 2.0D, y - 10.0D - size, this.field_73735_i);
/*     */   }
/*     */   
/*     */   public static void markPoint(int px, int py, int pz) {
/* 286 */     EntityClientPlayerMP entityClientPlayerMP = (Minecraft.func_71410_x()).field_71439_g;
/* 287 */     if (entityClientPlayerMP != null && ((EntityPlayer)entityClientPlayerMP).field_70170_p != null)
/* 288 */       if (py < 1000) {
/* 289 */         MCH_ParticlesUtil.spawnMarkPoint((EntityPlayer)entityClientPlayerMP, 0.5D + px, 1.0D + py, 0.5D + pz);
/*     */       } else {
/* 291 */         MCH_ParticlesUtil.clearMarkPoint();
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_GuiTargetMarker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */