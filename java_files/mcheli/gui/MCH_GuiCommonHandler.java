/*     */ package mcheli.gui;
/*     */ 
/*     */ import cpw.mods.fml.common.network.IGuiHandler;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_AircraftGui;
/*     */ import mcheli.aircraft.MCH_AircraftGuiContainer;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.block.MCH_DraftingTableGui;
/*     */ import mcheli.block.MCH_DraftingTableGuiContainer;
/*     */ import mcheli.multiplay.MCH_ContainerScoreboard;
/*     */ import mcheli.multiplay.MCH_GuiScoreboard;
/*     */ import mcheli.uav.MCH_ContainerUavStation;
/*     */ import mcheli.uav.MCH_EntityUavStation;
/*     */ import mcheli.uav.MCH_GuiUavStation;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_GuiCommonHandler
/*     */   implements IGuiHandler {
/*     */   public static final int GUIID_UAV_STATION = 0;
/*     */   public static final int GUIID_AIRCRAFT = 1;
/*     */   public static final int GUIID_CONFG = 2;
/*     */   public static final int GUIID_INVENTORY = 3;
/*     */   public static final int GUIID_DRAFTING = 4;
/*     */   public static final int GUIID_MULTI_MNG = 5;
/*     */   
/*     */   public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
/*     */     MCH_EntityAircraft ac;
/*  32 */     MCH_Lib.DbgLog(world, "MCH_GuiCommonHandler.getServerGuiElement ID=%d (%d, %d, %d)", new Object[] { Integer.valueOf(id), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z) });
/*  33 */     switch (id)
/*     */     { case 0:
/*  35 */         if (player.field_70154_o instanceof MCH_EntityUavStation) {
/*  36 */           return new MCH_ContainerUavStation(player.field_71071_by, (MCH_EntityUavStation)player.field_70154_o);
/*     */         }
/*     */       
/*     */       case 1:
/*  40 */         ac = null;
/*  41 */         if (player.field_70154_o instanceof MCH_EntityAircraft) {
/*  42 */           ac = (MCH_EntityAircraft)player.field_70154_o;
/*  43 */         } else if (player.field_70154_o instanceof MCH_EntityUavStation) {
/*  44 */           ac = ((MCH_EntityUavStation)player.field_70154_o).getControlAircract();
/*     */         } 
/*     */         
/*  47 */         if (ac != null) {
/*  48 */           return new MCH_AircraftGuiContainer(player, ac);
/*     */         }
/*     */       
/*     */       case 2:
/*  52 */         return new MCH_ConfigGuiContainer(player);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/*  69 */         return null;
/*     */       case 4: return new MCH_DraftingTableGuiContainer(player, x, y, z);
/*     */       case 5:
/*     */         break; }  if (MinecraftServer.func_71276_C().func_71264_H()) { MCH_Config var10000 = MCH_MOD.config; if (!MCH_Config.DebugLog)
/*  73 */         return null;  }  return new MCH_ContainerScoreboard(player); } public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) { MCH_EntityAircraft ac; MCH_Lib.DbgLog(world, "MCH_GuiCommonHandler.getClientGuiElement ID=%d (%d, %d, %d)", new Object[] { Integer.valueOf(id), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z) });
/*  74 */     switch (id) {
/*     */       case 0:
/*  76 */         if (player.field_70154_o instanceof MCH_EntityUavStation) {
/*  77 */           return new MCH_GuiUavStation(player.field_71071_by, (MCH_EntityUavStation)player.field_70154_o);
/*     */         }
/*     */       
/*     */       case 1:
/*  81 */         ac = null;
/*  82 */         if (player.field_70154_o instanceof MCH_EntityAircraft) {
/*  83 */           ac = (MCH_EntityAircraft)player.field_70154_o;
/*  84 */         } else if (player.field_70154_o instanceof MCH_EntityUavStation) {
/*  85 */           ac = ((MCH_EntityUavStation)player.field_70154_o).getControlAircract();
/*     */         } 
/*     */         
/*  88 */         if (ac != null) {
/*  89 */           return new MCH_AircraftGui(player, ac);
/*     */         }
/*     */       
/*     */       case 2:
/*  93 */         return new MCH_ConfigGui(player);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 103 */         return null;
/*     */       case 4:
/*     */         return new MCH_DraftingTableGui(player, x, y, z);
/*     */       case 5:
/*     */         break;
/*     */     } 
/*     */     return new MCH_GuiScoreboard(player); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gui\MCH_GuiCommonHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */