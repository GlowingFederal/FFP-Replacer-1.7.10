/*     */ package mcheli.multiplay;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.server.CommandSummon;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class MCH_MultiplayPacketHandler {
/*  24 */   private static final Logger logger = LogManager.getLogger();
/*  25 */   private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
/*  26 */   private static byte[] imageData = null;
/*  27 */   private static String lastPlayerName = "";
/*  28 */   private static double lastDataPercent = 0.0D;
/*  29 */   public static EntityPlayer modListRequestPlayer = null;
/*  30 */   private static int playerInfoId = 0;
/*     */ 
/*     */   
/*     */   public static void onPacket_Command(EntityPlayer player, ByteArrayDataInput data) {}
/*     */ 
/*     */   
/*     */   private static void destoryAllAircraft(EntityPlayer player) {
/*  37 */     CommandSummon cmd = new CommandSummon();
/*  38 */     if (cmd.func_71519_b((ICommandSender)player)) {
/*  39 */       Iterator i$ = player.field_70170_p.field_72996_f.iterator();
/*     */       
/*  41 */       while (i$.hasNext()) {
/*  42 */         Object e = i$.next();
/*  43 */         if (e instanceof MCH_EntityAircraft) {
/*  44 */           ((MCH_EntityAircraft)e).func_70106_y();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacket_NotifySpotedEntity(EntityPlayer player, ByteArrayDataInput data) {
/*  52 */     if (player.field_70170_p.field_72995_K) {
/*  53 */       MCH_PacketNotifySpotedEntity pc = new MCH_PacketNotifySpotedEntity();
/*  54 */       pc.readData(data);
/*  55 */       if (pc.count > 0) {
/*  56 */         for (int i = 0; i < pc.num; i++) {
/*  57 */           MCH_GuiTargetMarker.addSpotedEntity(pc.entityId[i], pc.count);
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacket_NotifyMarkPoint(EntityPlayer player, ByteArrayDataInput data) {
/*  65 */     if (player.field_70170_p.field_72995_K) {
/*  66 */       MCH_PacketNotifyMarkPoint pc = new MCH_PacketNotifyMarkPoint();
/*  67 */       pc.readData(data);
/*  68 */       MCH_GuiTargetMarker.markPoint(pc.px, pc.py, pc.pz);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void onPacket_LargeData(EntityPlayer player, ByteArrayDataInput data) {
/*  73 */     if (!player.field_70170_p.field_72995_K) {
/*     */       try {
/*  75 */         System.out.println("try");
/*  76 */         MinecraftServer e = MinecraftServer.func_71276_C();
/*  77 */         if (e == null) {
/*     */           return;
/*     */         }
/*     */         
/*  81 */         MCH_PacketLargeData pc = new MCH_PacketLargeData();
/*  82 */         pc.readData(data);
/*  83 */         if (pc.imageDataIndex < 0 || pc.imageDataTotalSize <= 0) {
/*     */           return;
/*     */         }
/*     */         
/*  87 */         if (pc.imageDataIndex == 0) {
/*  88 */           if (imageData != null && !lastPlayerName.isEmpty()) {
/*  89 */             LogError("[mcheli]Err1:Saving the %s screen shot to server FAILED!!!", new Object[] { lastPlayerName });
/*     */           }
/*     */           
/*  92 */           imageData = new byte[pc.imageDataTotalSize];
/*  93 */           lastPlayerName = player.getDisplayName();
/*  94 */           lastDataPercent = 0.0D;
/*     */         } 
/*     */         
/*  97 */         double dataPercent = (pc.imageDataIndex + pc.imageDataSize) / pc.imageDataTotalSize * 100.0D;
/*  98 */         if (dataPercent - lastDataPercent >= 10.0D || lastDataPercent == 0.0D) {
/*  99 */           LogInfo("[mcheli]Saving the %s screen shot to server. %.0f%% : %dbyte / %dbyte", new Object[] { player.getDisplayName(), Double.valueOf(dataPercent), Integer.valueOf(pc.imageDataIndex), Integer.valueOf(pc.imageDataTotalSize) });
/* 100 */           lastDataPercent = dataPercent;
/*     */         } 
/*     */         
/* 103 */         if (imageData == null) {
/* 104 */           if (imageData != null && !lastPlayerName.isEmpty()) {
/* 105 */             LogError("[mcheli]Err2:Saving the %s screen shot to server FAILED!!!", new Object[] { player.getDisplayName() });
/*     */           }
/*     */           
/* 108 */           imageData = null;
/* 109 */           lastPlayerName = "";
/* 110 */           lastDataPercent = 0.0D;
/*     */           
/*     */           return;
/*     */         } 
/* 114 */         for (int fos = 0; fos < pc.imageDataSize; fos++) {
/* 115 */           imageData[pc.imageDataIndex + fos] = pc.buf[fos];
/*     */         }
/*     */         
/* 118 */         if (pc.imageDataIndex + pc.imageDataSize >= pc.imageDataTotalSize) {
/* 119 */           DataOutputStream dos = null;
/* 120 */           String dt = dateFormat.format(new Date()).toString();
/* 121 */           File file = new File("screenshots_op");
/* 122 */           file.mkdir();
/* 123 */           file = new File(file, player.getDisplayName() + "_" + dt + ".png");
/* 124 */           String s = file.getAbsolutePath();
/* 125 */           LogInfo("[mcheli]Save Screenshot has been completed: %s", new Object[] { s });
/* 126 */           FileOutputStream var12 = new FileOutputStream(s);
/* 127 */           dos = new DataOutputStream(var12);
/* 128 */           dos.write(imageData);
/* 129 */           dos.flush();
/* 130 */           dos.close();
/* 131 */           imageData = null;
/* 132 */           lastPlayerName = "";
/* 133 */           lastDataPercent = 0.0D;
/*     */         } 
/* 135 */       } catch (Exception var11) {
/* 136 */         var11.printStackTrace();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void LogInfo(String format, Object... args) {
/* 143 */     logger.info(String.format(format, args));
/*     */   }
/*     */   
/*     */   public static void LogError(String format, Object... args) {
/* 147 */     logger.error(String.format(format, args));
/*     */   }
/*     */   
/*     */   public static void onPacket_IndClient(EntityPlayer player, ByteArrayDataInput data) {
/* 151 */     if (player.field_70170_p.field_72995_K) {
/* 152 */       MCH_PacketIndClient pc = new MCH_PacketIndClient();
/* 153 */       pc.readData(data);
/* 154 */       if (pc.CmdID == 1) {
/* 155 */         MCH_MultiplayClient.startSendImageData();
/* 156 */       } else if (pc.CmdID == 2) {
/* 157 */         MCH_MultiplayClient.sendModsInfo(player.getDisplayName(), Integer.parseInt(pc.CmdStr));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getPlayerInfoId(EntityPlayer player) {
/* 164 */     modListRequestPlayer = player;
/* 165 */     playerInfoId++;
/* 166 */     if (playerInfoId > 1000000) {
/* 167 */       playerInfoId = 1;
/*     */     }
/*     */     
/* 170 */     return playerInfoId;
/*     */   }
/*     */   
/*     */   public static void onPacket_ModList(EntityPlayer player, ByteArrayDataInput data) {
/* 174 */     MCH_PacketModList pc = new MCH_PacketModList();
/* 175 */     pc.readData(data);
/* 176 */     MCH_Lib.DbgLog(player.field_70170_p, "MCH_MultiplayPacketHandler.onPacket_ModList : ID=%d, Num=%d", new Object[] { Integer.valueOf(pc.id), Integer.valueOf(pc.num) });
/*     */ 
/*     */     
/* 179 */     if (player.field_70170_p.field_72995_K) {
/* 180 */       if (pc.firstData) {
/* 181 */         MCH_Lib.Log(EnumChatFormatting.RED + "###### " + player.getDisplayName() + " ######", new Object[0]);
/* 182 */         player.func_145747_a((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "###### " + player.getDisplayName() + " ######"));
/*     */       } 
/*     */       
/* 185 */       Iterator<String> i$ = pc.list.iterator();
/*     */       
/* 187 */       while (i$.hasNext()) {
/* 188 */         String s = i$.next();
/* 189 */         MCH_Lib.Log(s, new Object[0]);
/* 190 */         player.func_145747_a((IChatComponent)new ChatComponentText(s));
/*     */       } 
/* 192 */     } else if (pc.id == playerInfoId) {
/* 193 */       if (modListRequestPlayer != null) {
/* 194 */         MCH_PacketModList.send(modListRequestPlayer, pc);
/*     */       } else {
/* 196 */         if (pc.firstData) {
/* 197 */           LogInfo("###### " + player.getDisplayName() + " ######", new Object[0]);
/*     */         }
/*     */         
/* 200 */         Iterator<String> i$ = pc.list.iterator();
/*     */         
/* 202 */         while (i$.hasNext()) {
/* 203 */           String s = i$.next();
/* 204 */           LogInfo(s, new Object[0]);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_MultiplayPacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */