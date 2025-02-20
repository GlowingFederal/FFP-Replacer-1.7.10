/*     */ package mcheli.uav;
/*     */ 
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import mcheli.helicopter.MCH_HeliInfoManager;
/*     */ import mcheli.plane.MCP_PlaneInfoManager;
/*     */ import mcheli.tank.MCH_TankInfoManager;
/*     */ import mcheli.wrapper.W_GuiContainer;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_Network;
/*     */ import mcheli.wrapper.W_PacketBase;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_GuiUavStation
/*     */   extends W_GuiContainer
/*     */ {
/*     */   final MCH_EntityUavStation uavStation;
/*     */   static final int BX = 20;
/*     */   static final int BY = 22;
/*  27 */   private final int BUTTON_ID_CONTINUE = 256;
/*     */   
/*     */   private GuiButton buttonContinue;
/*     */   
/*     */   public MCH_GuiUavStation(InventoryPlayer inventoryPlayer, MCH_EntityUavStation uavStation) {
/*  32 */     super(new MCH_ContainerUavStation(inventoryPlayer, uavStation));
/*  33 */     this.uavStation = uavStation;
/*     */   }
/*     */   
/*     */   protected void func_146979_b(int param1, int param2) {
/*  37 */     if (this.uavStation != null) {
/*  38 */       ItemStack item = this.uavStation.func_70301_a(0);
/*  39 */       Object info = null;
/*  40 */       if (item != null && item.func_77973_b() instanceof mcheli.plane.MCP_ItemPlane) {
/*  41 */         info = MCP_PlaneInfoManager.getFromItem(item.func_77973_b());
/*     */       }
/*     */       
/*  44 */       if (item != null && item.func_77973_b() instanceof mcheli.helicopter.MCH_ItemHeli) {
/*  45 */         info = MCH_HeliInfoManager.getFromItem(item.func_77973_b());
/*     */       }
/*     */       
/*  48 */       if (item != null && item.func_77973_b() instanceof mcheli.tank.MCH_ItemTank) {
/*  49 */         info = MCH_TankInfoManager.getFromItem(item.func_77973_b());
/*     */       }
/*     */       
/*  52 */       if (item != null && (item == null || info == null || !((MCH_AircraftInfo)info).isUAV || !((MCH_AircraftInfo)info).isNewUAV)) {
/*  53 */         if (item != null) {
/*  54 */           drawString("Not UAV", 8, 6, 16711680);
/*     */         }
/*  56 */       } else if (this.uavStation.getKind() <= 1) {
/*  57 */         drawString("UAV Station", 8, 6, 16777215);
/*  58 */       } else if (item != null && !((MCH_AircraftInfo)info).isSmallUAV) {
/*  59 */         drawString("Small UAV only", 8, 6, 16711680);
/*     */       } else {
/*  61 */         drawString("UAV Controller", 8, 6, 16777215);
/*     */       } 
/*     */       
/*  64 */       drawString(StatCollector.func_74838_a("container.inventory"), 8, this.field_147000_g - 96 + 2, 16777215);
/*  65 */       drawString(String.format("X.%+2d", new Object[] { Integer.valueOf(this.uavStation.posUavX) }), 58, 15, 16777215);
/*  66 */       drawString(String.format("Y.%+2d", new Object[] { Integer.valueOf(this.uavStation.posUavY) }), 58, 37, 16777215);
/*  67 */       drawString(String.format("Z.%+2d", new Object[] { Integer.valueOf(this.uavStation.posUavZ) }), 58, 59, 16777215);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_146976_a(float par1, int par2, int par3) {
/*  72 */     W_McClient.MOD_bindTexture("textures/gui/uav_station.png");
/*  73 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  74 */     int x = (this.field_146294_l - this.field_146999_f) / 2;
/*  75 */     int y = (this.field_146295_m - this.field_147000_g) / 2;
/*  76 */     func_73729_b(x, y, 0, 0, this.field_146999_f, this.field_147000_g);
/*     */   }
/*     */   
/*     */   protected void func_146284_a(GuiButton btn) {
/*  80 */     if (btn != null && btn.field_146124_l) {
/*  81 */       if (btn.field_146127_k == 256) {
/*  82 */         if (this.uavStation != null && !this.uavStation.field_70128_L && this.uavStation.getLastControlAircraft() != null && !(this.uavStation.getLastControlAircraft()).field_70128_L) {
/*  83 */           MCH_UavPacketStatus pos = new MCH_UavPacketStatus();
/*  84 */           pos.posUavX = (byte)this.uavStation.posUavX;
/*  85 */           pos.posUavY = (byte)this.uavStation.posUavY;
/*  86 */           pos.posUavZ = (byte)this.uavStation.posUavZ;
/*  87 */           pos.continueControl = true;
/*  88 */           W_Network.sendToServer((W_PacketBase)pos);
/*     */         } 
/*     */         
/*  91 */         this.buttonContinue.field_146124_l = false;
/*     */       } else {
/*  93 */         int[] pos1 = { this.uavStation.posUavX, this.uavStation.posUavY, this.uavStation.posUavZ };
/*  94 */         int i = btn.field_146127_k >> 4 & 0xF;
/*  95 */         int j = (btn.field_146127_k & 0xF) - 1;
/*  96 */         int[] BTN = { -10, -1, 1, 10 };
/*  97 */         pos1[i] = pos1[i] + BTN[j];
/*  98 */         if (pos1[i] < -50) {
/*  99 */           pos1[i] = -50;
/*     */         }
/*     */         
/* 102 */         if (pos1[i] > 50) {
/* 103 */           pos1[i] = 50;
/*     */         }
/*     */         
/* 106 */         if (this.uavStation.posUavX != pos1[0] || this.uavStation.posUavY != pos1[1] || this.uavStation.posUavZ != pos1[2]) {
/* 107 */           MCH_UavPacketStatus data = new MCH_UavPacketStatus();
/* 108 */           data.posUavX = (byte)pos1[0];
/* 109 */           data.posUavY = (byte)pos1[1];
/* 110 */           data.posUavZ = (byte)pos1[2];
/* 111 */           W_Network.sendToServer((W_PacketBase)data);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/* 119 */     super.func_73866_w_();
/* 120 */     this.field_146292_n.clear();
/* 121 */     int x = this.field_146294_l / 2 - 5;
/* 122 */     int y = this.field_146295_m / 2 - 76;
/* 123 */     String[] BTN = { "-10", "-1", "+1", "+10" };
/*     */     
/* 125 */     for (int row = 0; row < 3; row++) {
/* 126 */       for (int col = 0; col < 4; col++) {
/* 127 */         int id = row << 4 | col + 1;
/* 128 */         this.field_146292_n.add(new GuiButton(id, x + col * 20, y + row * 22, 20, 20, BTN[col]));
/*     */       } 
/*     */     } 
/*     */     
/* 132 */     this.buttonContinue = new GuiButton(256, x - 80 + 3, y + 44, 50, 20, "Continue");
/* 133 */     this.buttonContinue.field_146124_l = false;
/* 134 */     if (this.uavStation != null && !this.uavStation.field_70128_L && this.uavStation.getAndSearchLastControlAircraft() != null) {
/* 135 */       this.buttonContinue.field_146124_l = true;
/*     */     }
/*     */     
/* 138 */     this.field_146292_n.add(this.buttonContinue);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mchel\\uav\MCH_GuiUavStation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */