/*     */ package mcheli.multiplay;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.server.CommandScoreboard;
/*     */ import net.minecraft.command.server.CommandTeleport;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.scoreboard.ScorePlayerTeam;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_Multiplay {
/*  28 */   public static final MCH_TargetType[][] ENTITY_SPOT_TABLE = new MCH_TargetType[][] { { MCH_TargetType.NONE, MCH_TargetType.NONE }, { MCH_TargetType.OTHER_MOB, MCH_TargetType.OTHER_MOB }, { MCH_TargetType.MONSTER, MCH_TargetType.MONSTER }, { MCH_TargetType.NONE, MCH_TargetType.NO_TEAM_PLAYER }, { MCH_TargetType.NONE, MCH_TargetType.SAME_TEAM_PLAYER }, { MCH_TargetType.NONE, MCH_TargetType.OTHER_TEAM_PLAYER }, { MCH_TargetType.NONE, MCH_TargetType.NONE }, { MCH_TargetType.NONE, MCH_TargetType.NO_TEAM_PLAYER }, { MCH_TargetType.NONE, MCH_TargetType.SAME_TEAM_PLAYER }, { MCH_TargetType.NONE, MCH_TargetType.OTHER_TEAM_PLAYER } };
/*     */ 
/*     */   
/*     */   public static boolean canSpotEntityWithFilter(int filter, Entity entity) {
/*  32 */     return (entity instanceof mcheli.plane.MCP_EntityPlane) ? (((filter & 0x20) != 0)) : ((entity instanceof mcheli.helicopter.MCH_EntityHeli) ? (((filter & 0x10) != 0)) : ((!(entity instanceof mcheli.vehicle.MCH_EntityVehicle) && !(entity instanceof mcheli.tank.MCH_EntityTank)) ? ((entity instanceof EntityPlayer) ? (((filter & 0x4) != 0)) : ((entity instanceof EntityLivingBase) ? (isMonster(entity) ? (((filter & 0x2) != 0)) : (((filter & 0x1) != 0))) : false)) : (((filter & 0x8) != 0))));
/*     */   }
/*     */   
/*     */   public static boolean isMonster(Entity entity) {
/*  36 */     return (entity.getClass().toString().toLowerCase().indexOf("monster") >= 0);
/*     */   }
/*     */   
/*     */   public static MCH_TargetType canSpotEntity(Entity user, double posX, double posY, double posZ, Entity target, boolean checkSee) {
/*  40 */     if (!(user instanceof EntityLivingBase)) {
/*  41 */       return MCH_TargetType.NONE;
/*     */     }
/*  43 */     EntityLivingBase spotter = (EntityLivingBase)user;
/*  44 */     int col = (spotter.func_96124_cp() == null) ? 0 : 1;
/*  45 */     byte row = 0;
/*  46 */     if (target instanceof EntityLivingBase) {
/*  47 */       if (!isMonster(target)) {
/*  48 */         row = 1;
/*     */       } else {
/*  50 */         row = 2;
/*     */       } 
/*     */     }
/*     */     
/*  54 */     if (spotter.func_96124_cp() != null) {
/*  55 */       if (target instanceof EntityPlayer) {
/*  56 */         EntityPlayer ret = (EntityPlayer)target;
/*  57 */         if (ret.func_96124_cp() == null) {
/*  58 */           row = 3;
/*  59 */         } else if (spotter.func_142014_c((EntityLivingBase)ret)) {
/*  60 */           row = 4;
/*     */         } else {
/*  62 */           row = 5;
/*     */         } 
/*  64 */       } else if (target instanceof MCH_EntityAircraft) {
/*  65 */         MCH_EntityAircraft ret1 = (MCH_EntityAircraft)target;
/*  66 */         EntityPlayer vs = ret1.getFirstMountPlayer();
/*  67 */         if (vs == null) {
/*  68 */           row = 6;
/*  69 */         } else if (vs.func_96124_cp() == null) {
/*  70 */           row = 7;
/*  71 */         } else if (spotter.func_142014_c((EntityLivingBase)vs)) {
/*  72 */           row = 8;
/*     */         } else {
/*  74 */           row = 9;
/*     */         } 
/*     */       } 
/*  77 */     } else if (target instanceof EntityPlayer || target instanceof MCH_EntityAircraft) {
/*  78 */       row = 0;
/*     */     } 
/*     */     
/*  81 */     MCH_TargetType ret2 = ENTITY_SPOT_TABLE[row][col];
/*  82 */     if (checkSee && ret2 != MCH_TargetType.NONE) {
/*  83 */       Vec3 vs1 = Vec3.func_72443_a(posX, posY, posZ);
/*  84 */       Vec3 ve = Vec3.func_72443_a(target.field_70165_t, target.field_70163_u + target.func_70047_e(), target.field_70161_v);
/*  85 */       MovingObjectPosition mop = target.field_70170_p.func_72933_a(vs1, ve);
/*  86 */       if (mop != null && mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/*  87 */         ret2 = MCH_TargetType.NONE;
/*     */       }
/*     */     } 
/*     */     
/*  91 */     return ret2;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean canAttackEntity(DamageSource ds, Entity target) {
/*  96 */     return canAttackEntity(ds.func_76346_g(), target);
/*     */   }
/*     */   
/*     */   public static boolean canAttackEntity(Entity attacker, Entity target) {
/* 100 */     if (attacker != null && target != null) {
/* 101 */       EntityPlayer attackPlayer = null;
/* 102 */       EntityPlayer targetPlayer = null;
/* 103 */       if (attacker instanceof EntityPlayer) {
/* 104 */         attackPlayer = (EntityPlayer)attacker;
/*     */       }
/*     */       
/* 107 */       if (target instanceof EntityPlayer) {
/* 108 */         targetPlayer = (EntityPlayer)target;
/* 109 */       } else if (target.field_70153_n instanceof EntityPlayer) {
/* 110 */         targetPlayer = (EntityPlayer)target.field_70153_n;
/*     */       } 
/*     */       
/* 113 */       if (target instanceof MCH_EntityAircraft) {
/* 114 */         MCH_EntityAircraft ac = (MCH_EntityAircraft)target;
/* 115 */         if (ac.getRiddenByEntity() instanceof EntityPlayer) {
/* 116 */           targetPlayer = (EntityPlayer)ac.getRiddenByEntity();
/*     */         }
/*     */       } 
/*     */       
/* 120 */       if (attackPlayer != null && targetPlayer != null && !attackPlayer.func_96122_a(targetPlayer)) {
/* 121 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 125 */     return true;
/*     */   }
/*     */   
/*     */   public static void jumpSpawnPoint(EntityPlayer player) {
/* 129 */     MCH_Lib.DbgLog(false, "JumpSpawnPoint", new Object[0]);
/* 130 */     CommandTeleport cmd = new CommandTeleport();
/* 131 */     if (cmd.func_71519_b((ICommandSender)player)) {
/* 132 */       MinecraftServer minecraftServer = MinecraftServer.func_71276_C();
/* 133 */       String[] arr$ = minecraftServer.func_71203_ab().func_72369_d();
/* 134 */       int len$ = arr$.length;
/*     */       
/* 136 */       for (int i$ = 0; i$ < len$; i$++) {
/* 137 */         String playerName = arr$[i$];
/* 138 */         EntityPlayerMP jumpPlayer = CommandTeleport.func_82359_c((ICommandSender)player, playerName);
/* 139 */         ChunkCoordinates cc = null;
/* 140 */         if (jumpPlayer != null && jumpPlayer.field_71093_bK == player.field_71093_bK) {
/* 141 */           cc = jumpPlayer.getBedLocation(jumpPlayer.field_71093_bK);
/* 142 */           if (cc != null) {
/* 143 */             cc = EntityPlayer.func_71056_a((World)minecraftServer.func_71218_a(jumpPlayer.field_71093_bK), cc, true);
/*     */           }
/*     */           
/* 146 */           if (cc == null) {
/* 147 */             cc = jumpPlayer.field_70170_p.field_73011_w.getRandomizedSpawnPoint();
/*     */           }
/*     */         } 
/*     */         
/* 151 */         if (cc != null) {
/* 152 */           String[] cmdStr = { playerName, String.format("%.1f", new Object[] { Double.valueOf(cc.field_71574_a + 0.5D) }), String.format("%.1f", new Object[] { Double.valueOf(cc.field_71572_b + 0.1D) }), String.format("%.1f", new Object[] { Double.valueOf(cc.field_71573_c + 0.5D) }) };
/* 153 */           cmd.func_71515_b((ICommandSender)player, cmdStr);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void shuffleTeam(EntityPlayer player) {
/* 161 */     Collection teams = player.field_70170_p.func_96441_U().func_96525_g();
/* 162 */     int teamNum = teams.size();
/* 163 */     MCH_Lib.DbgLog(false, "ShuffleTeam:%d teams ----------", new Object[] { Integer.valueOf(teamNum) });
/* 164 */     if (teamNum > 0) {
/* 165 */       CommandScoreboard cmd = new CommandScoreboard();
/* 166 */       if (cmd.func_71519_b((ICommandSender)player)) {
/* 167 */         List<String> list = Arrays.asList(MinecraftServer.func_71276_C().func_71203_ab().func_72369_d());
/* 168 */         Collections.shuffle(list);
/* 169 */         ArrayList<String> listTeam = new ArrayList();
/* 170 */         Iterator j = teams.iterator();
/*     */         
/* 172 */         while (j.hasNext()) {
/* 173 */           Object exe_cmd = j.next();
/* 174 */           ScorePlayerTeam process_cmd = (ScorePlayerTeam)exe_cmd;
/* 175 */           listTeam.add(process_cmd.func_96661_b());
/*     */         } 
/*     */         
/* 178 */         Collections.shuffle(listTeam);
/* 179 */         int var9 = 0;
/*     */         
/* 181 */         for (int var10 = 0; var9 < list.size(); var9++) {
/* 182 */           listTeam.set(var10, (String)listTeam.get(var10) + " " + (String)list.get(var9));
/* 183 */           var10++;
/* 184 */           if (var10 >= teamNum) {
/* 185 */             var10 = 0;
/*     */           }
/*     */         } 
/*     */         
/* 189 */         for (var9 = 0; var9 < listTeam.size(); var9++) {
/* 190 */           String var11 = "teams join " + (String)listTeam.get(var9);
/* 191 */           String[] var12 = var11.split(" ");
/* 192 */           if (var12.length > 3) {
/* 193 */             MCH_Lib.DbgLog(false, "ShuffleTeam:" + var11, new Object[0]);
/* 194 */             cmd.func_71515_b((ICommandSender)player, var12);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean spotEntity(EntityPlayer player, MCH_EntityAircraft ac, double posX, double posY, double posZ, int targetFilter, float spotLength, int markTime, float angle) {
/* 203 */     boolean ret = false;
/* 204 */     if (!player.field_70170_p.field_72995_K) {
/* 205 */       float acYaw = 0.0F;
/* 206 */       float acPitch = 0.0F;
/* 207 */       float acRoll = 0.0F;
/* 208 */       if (ac != null) {
/* 209 */         acYaw = ac.getRotYaw();
/* 210 */         acPitch = ac.getRotPitch();
/* 211 */         acRoll = ac.getRotRoll();
/*     */       } 
/*     */       
/* 214 */       Vec3 vv = MCH_Lib.RotVec3(0.0D, 0.0D, 1.0D, -player.field_70177_z, -player.field_70125_A, -acRoll);
/* 215 */       double tx = vv.field_72450_a;
/* 216 */       double tz = vv.field_72449_c;
/* 217 */       List<Entity> list = player.field_70170_p.func_72839_b((Entity)player, player.field_70121_D.func_72314_b(spotLength, spotLength, spotLength));
/* 218 */       ArrayList<Integer> entityList = new ArrayList();
/* 219 */       Vec3 pos = Vec3.func_72443_a(posX, posY, posZ);
/*     */       
/* 221 */       for (int entityId = 0; entityId < list.size(); entityId++) {
/* 222 */         Entity i = list.get(entityId);
/* 223 */         if (canSpotEntityWithFilter(targetFilter, i)) {
/* 224 */           MCH_TargetType stopType = canSpotEntity((Entity)player, posX, posY, posZ, i, true);
/* 225 */           if (stopType != MCH_TargetType.NONE && stopType != MCH_TargetType.SAME_TEAM_PLAYER) {
/* 226 */             double dist = i.func_70092_e(pos.field_72450_a, pos.field_72448_b, pos.field_72449_c);
/* 227 */             if (dist > 1.0D && dist < (spotLength * spotLength)) {
/* 228 */               double cx = i.field_70165_t - pos.field_72450_a;
/* 229 */               double cy = i.field_70163_u - pos.field_72448_b;
/* 230 */               double cz = i.field_70161_v - pos.field_72449_c;
/* 231 */               double h = MCH_Lib.getPosAngle(tx, tz, cx, cz);
/* 232 */               double v = Math.atan2(cy, Math.sqrt(cx * cx + cz * cz)) * 180.0D / Math.PI;
/* 233 */               v = Math.abs(v + player.field_70125_A);
/* 234 */               if (h < (angle * 2.0F) && v < (angle * 2.0F)) {
/* 235 */                 entityList.add(Integer.valueOf(i.func_145782_y()));
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 242 */       if (entityList.size() > 0) {
/* 243 */         int[] var39 = new int[entityList.size()];
/*     */         
/* 245 */         for (int var40 = 0; var40 < var39.length; var40++) {
/* 246 */           var39[var40] = ((Integer)entityList.get(var40)).intValue();
/*     */         }
/*     */         
/* 249 */         sendSpotedEntityListToSameTeam(player, markTime, var39);
/* 250 */         ret = true;
/*     */       } else {
/* 252 */         ret = false;
/*     */       } 
/*     */     } 
/*     */     
/* 256 */     return ret;
/*     */   }
/*     */   
/*     */   public static void sendSpotedEntityListToSameTeam(EntityPlayer player, int count, int[] entityId) {
/* 260 */     ServerConfigurationManager svCnf = MinecraftServer.func_71276_C().func_71203_ab();
/* 261 */     Iterator<EntityPlayerMP> i$ = svCnf.field_72404_b.iterator();
/*     */     
/* 263 */     while (i$.hasNext()) {
/* 264 */       EntityPlayerMP notifyPlayer = i$.next();
/* 265 */       if (player == notifyPlayer || player.func_142014_c((EntityLivingBase)notifyPlayer)) {
/* 266 */         MCH_PacketNotifySpotedEntity.send((EntityPlayer)notifyPlayer, count, entityId);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean markPoint(EntityPlayer player, double posX, double posY, double posZ) {
/* 273 */     Vec3 vs = Vec3.func_72443_a(posX, posY, posZ);
/* 274 */     Vec3 ve = MCH_Lib.Rot2Vec3(player.field_70177_z, player.field_70125_A);
/* 275 */     ve = vs.func_72441_c(ve.field_72450_a * 300.0D, ve.field_72448_b * 300.0D, ve.field_72449_c * 300.0D);
/* 276 */     MovingObjectPosition mop = player.field_70170_p.func_72901_a(vs, ve, true);
/* 277 */     if (mop != null && mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/* 278 */       sendMarkPointToSameTeam(player, mop.field_72311_b, mop.field_72312_c + 2, mop.field_72309_d);
/* 279 */       return true;
/*     */     } 
/* 281 */     sendMarkPointToSameTeam(player, 0, 1000, 0);
/* 282 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendMarkPointToSameTeam(EntityPlayer player, int x, int y, int z) {
/* 287 */     ServerConfigurationManager svCnf = MinecraftServer.func_71276_C().func_71203_ab();
/* 288 */     Iterator<EntityPlayerMP> i$ = svCnf.field_72404_b.iterator();
/*     */     
/* 290 */     while (i$.hasNext()) {
/* 291 */       EntityPlayerMP notifyPlayer = i$.next();
/* 292 */       if (player == notifyPlayer || player.func_142014_c((EntityLivingBase)notifyPlayer))
/* 293 */         MCH_PacketNotifyMarkPoint.send((EntityPlayer)notifyPlayer, x, y, z); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_Multiplay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */