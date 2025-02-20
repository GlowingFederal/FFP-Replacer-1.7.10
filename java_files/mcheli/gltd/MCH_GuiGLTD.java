/*     */ package mcheli.gltd;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.MCH_Camera;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_KeyName;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.gui.MCH_Gui;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_GuiGLTD
/*     */   extends MCH_Gui {
/*     */   public MCH_GuiGLTD(Minecraft minecraft) {
/*  24 */     super(minecraft);
/*     */   }
/*     */   
/*     */   public void func_73866_w_() {
/*  28 */     super.func_73866_w_();
/*     */   }
/*     */   
/*     */   public boolean func_73868_f() {
/*  32 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isDrawGui(EntityPlayer player) {
/*  36 */     return (player.field_70154_o != null && player.field_70154_o instanceof MCH_EntityGLTD);
/*     */   }
/*     */   
/*     */   public void drawGui(EntityPlayer player, boolean isThirdPersonView) {
/*  40 */     if (isThirdPersonView) {
/*  41 */       MCH_Config var10000 = MCH_MOD.config;
/*  42 */       if (!MCH_Config.DisplayHUDThirdPerson.prmBool) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */     
/*  47 */     GL11.glLineWidth(MCH_Gui.scaleFactor);
/*  48 */     if (isDrawGui(player)) {
/*  49 */       MCH_EntityGLTD gltd = (MCH_EntityGLTD)player.field_70154_o;
/*  50 */       if (gltd.camera.getMode(0) == 1) {
/*  51 */         GL11.glEnable(3042);
/*  52 */         GL11.glColor4f(0.0F, 1.0F, 0.0F, 0.3F);
/*  53 */         int srcBlend = GL11.glGetInteger(3041);
/*  54 */         int dstBlend = GL11.glGetInteger(3040);
/*  55 */         GL11.glBlendFunc(1, 1);
/*  56 */         W_McClient.MOD_bindTexture("textures/gui/alpha.png");
/*  57 */         drawTexturedModalRectRotate(0.0D, 0.0D, this.field_146294_l, this.field_146295_m, this.rand.nextInt(256), this.rand.nextInt(256), 256.0D, 256.0D, 0.0F);
/*  58 */         GL11.glBlendFunc(srcBlend, dstBlend);
/*  59 */         GL11.glDisable(3042);
/*     */       } 
/*     */       
/*  62 */       drawString(String.format("x%.1f", new Object[] { Float.valueOf(gltd.camera.getCameraZoom()) }), this.centerX - 70, this.centerY + 10, -805306369);
/*  63 */       drawString(gltd.weaponCAS.getName(), this.centerX - 200, this.centerY + 65, (gltd.countWait == 0) ? -819986657 : -807468024);
/*  64 */       drawCommonPosition(gltd, -819986657);
/*  65 */       drawString(gltd.camera.getModeName(0), this.centerX + 30, this.centerY - 50, -819986657);
/*  66 */       drawSight(gltd.camera, -819986657);
/*  67 */       drawTargetPosition(gltd, -819986657, -807468024);
/*  68 */       drawKeyBind(gltd.camera, -805306369, -813727873);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawKeyBind(MCH_Camera camera, int color, int colorCannotUse) {
/*  73 */     int OffX = this.centerX + 55;
/*  74 */     int OffY = this.centerY + 40;
/*  75 */     drawString("DISMOUNT :", OffX, OffY + 0, color);
/*  76 */     drawString("CAM MODE :", OffX, OffY + 10, color);
/*  77 */     drawString("ZOOM IN   :", OffX, OffY + 20, (camera.getCameraZoom() < 10.0F) ? color : colorCannotUse);
/*  78 */     drawString("ZOOM OUT :", OffX, OffY + 30, (camera.getCameraZoom() > 1.0F) ? color : colorCannotUse);
/*  79 */     OffX += 60;
/*  80 */     StringBuilder var10001 = (new StringBuilder()).append(MCH_KeyName.getDescOrName(42)).append(" or ");
/*  81 */     MCH_Config var10002 = MCH_MOD.config;
/*  82 */     drawString(var10001.append(MCH_KeyName.getDescOrName(MCH_Config.KeyUnmount.prmInt)).toString(), OffX, OffY + 0, color);
/*  83 */     MCH_Config var6 = MCH_MOD.config;
/*  84 */     drawString(MCH_KeyName.getDescOrName(MCH_Config.KeyCameraMode.prmInt), OffX, OffY + 10, color);
/*  85 */     var6 = MCH_MOD.config;
/*  86 */     drawString(MCH_KeyName.getDescOrName(MCH_Config.KeyZoom.prmInt), OffX, OffY + 20, (camera.getCameraZoom() < 10.0F) ? color : colorCannotUse);
/*  87 */     var6 = MCH_MOD.config;
/*  88 */     drawString(MCH_KeyName.getDescOrName(MCH_Config.KeySwWeaponMode.prmInt), OffX, OffY + 30, (camera.getCameraZoom() > 1.0F) ? color : colorCannotUse);
/*     */   }
/*     */   
/*     */   public void drawCommonPosition(MCH_EntityGLTD gltd, int color) {
/*  92 */     boolean OFFSETX = true;
/*  93 */     drawString(String.format("X: %+.1f", new Object[] { Double.valueOf(gltd.field_70165_t) }), this.centerX - 145, this.centerY + 0, color);
/*  94 */     drawString(String.format("Y: %+.1f", new Object[] { Double.valueOf(gltd.field_70163_u) }), this.centerX - 145, this.centerY + 10, color);
/*  95 */     drawString(String.format("Z: %+.1f", new Object[] { Double.valueOf(gltd.field_70161_v) }), this.centerX - 145, this.centerY + 20, color);
/*  96 */     drawString(String.format("AX: %+.1f", new Object[] { Float.valueOf(gltd.field_70153_n.field_70177_z) }), this.centerX - 145, this.centerY + 40, color);
/*  97 */     drawString(String.format("AY: %+.1f", new Object[] { Float.valueOf(gltd.field_70153_n.field_70125_A) }), this.centerX - 145, this.centerY + 50, color);
/*     */   }
/*     */   
/*     */   public void drawTargetPosition(MCH_EntityGLTD gltd, int color, int colorDanger) {
/* 101 */     if (gltd.field_70153_n != null) {
/* 102 */       World w = gltd.field_70153_n.field_70170_p;
/* 103 */       float yaw = gltd.field_70153_n.field_70177_z;
/* 104 */       float pitch = gltd.field_70153_n.field_70125_A;
/* 105 */       double tX = (-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 106 */       double tZ = (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 107 */       double tY = -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F);
/* 108 */       double dist = MathHelper.func_76133_a(tX * tX + tY * tY + tZ * tZ);
/* 109 */       tX = tX * 80.0D / dist;
/* 110 */       tY = tY * 80.0D / dist;
/* 111 */       tZ = tZ * 80.0D / dist;
/* 112 */       MCH_Camera c = gltd.camera;
/* 113 */       Vec3 src = W_WorldFunc.getWorldVec3(w, c.posX, c.posY, c.posZ);
/* 114 */       Vec3 dst = W_WorldFunc.getWorldVec3(w, c.posX + tX, c.posY + tY, c.posZ + tZ);
/* 115 */       MovingObjectPosition m = W_WorldFunc.clip(w, src, dst);
/* 116 */       boolean OS_X = true;
/* 117 */       if (m != null) {
/* 118 */         drawString(String.format("X: %+.2fm", new Object[] { Double.valueOf(m.field_72307_f.field_72450_a) }), this.centerX + 50, this.centerY - 5 - 15, color);
/* 119 */         drawString(String.format("Y: %+.2fm", new Object[] { Double.valueOf(m.field_72307_f.field_72448_b) }), this.centerX + 50, this.centerY - 5, color);
/* 120 */         drawString(String.format("Z: %+.2fm", new Object[] { Double.valueOf(m.field_72307_f.field_72449_c) }), this.centerX + 50, this.centerY - 5 + 15, color);
/* 121 */         double x = m.field_72307_f.field_72450_a - c.posX;
/* 122 */         double y = m.field_72307_f.field_72448_b - c.posY;
/* 123 */         double z = m.field_72307_f.field_72449_c - c.posZ;
/* 124 */         double len = Math.sqrt(x * x + y * y + z * z);
/* 125 */         drawCenteredString(String.format("[%.2fm]", new Object[] { Double.valueOf(len) }), this.centerX, this.centerY + 30, (len > 20.0D) ? color : colorDanger);
/*     */       } else {
/* 127 */         drawString("X: --.--m", this.centerX + 50, this.centerY - 5 - 15, color);
/* 128 */         drawString("Y: --.--m", this.centerX + 50, this.centerY - 5, color);
/* 129 */         drawString("Z: --.--m", this.centerX + 50, this.centerY - 5 + 15, color);
/* 130 */         drawCenteredString("[--.--m]", this.centerX, this.centerY + 30, colorDanger);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawSight(MCH_Camera camera, int color) {
/* 137 */     double posX = this.centerX;
/* 138 */     double posY = this.centerY;
/* 139 */     boolean SW = true;
/* 140 */     boolean SH = true;
/* 141 */     boolean SINV = true;
/* 142 */     double[] line2 = { posX - 30.0D, posY - 10.0D, posX - 30.0D, posY - 20.0D, posX - 30.0D, posY - 20.0D, posX - 10.0D, posY - 20.0D, posX - 30.0D, posY + 10.0D, posX - 30.0D, posY + 20.0D, posX - 30.0D, posY + 20.0D, posX - 10.0D, posY + 20.0D, posX + 30.0D, posY - 10.0D, posX + 30.0D, posY - 20.0D, posX + 30.0D, posY - 20.0D, posX + 10.0D, posY - 20.0D, posX + 30.0D, posY + 10.0D, posX + 30.0D, posY + 20.0D, posX + 30.0D, posY + 20.0D, posX + 10.0D, posY + 20.0D };
/* 143 */     drawLine(line2, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gltd\MCH_GuiGLTD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */