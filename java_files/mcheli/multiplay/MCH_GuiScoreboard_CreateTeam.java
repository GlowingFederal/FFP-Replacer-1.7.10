/*     */ package mcheli.multiplay;
/*     */ 
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_ScaledResolution;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MCH_GuiScoreboard_CreateTeam
/*     */   extends MCH_GuiScoreboard_Base {
/*     */   private GuiButton buttonCreateTeamOK;
/*     */   private GuiButton buttonCreateTeamFF;
/*     */   private GuiTextField editCreateTeamName;
/*     */   private static boolean friendlyFire = true;
/*  17 */   private int lastTeamColor = 0;
/*  18 */   private static final String[] colorNames = new String[] { "RESET", "BLACK", "DARK_BLUE", "DARK_GREEN", "DARK_AQUA", "DARK_RED", "DARK_PURPLE", "GOLD", "GRAY", "DARK_GRAY", "BLUE", "GREEN", "AQUA", "RED", "LIGHT_PURPLE", "YELLOW" };
/*     */ 
/*     */   
/*     */   public MCH_GuiScoreboard_CreateTeam(MCH_IGuiScoreboard switcher, EntityPlayer player) {
/*  22 */     super(switcher, player);
/*     */   }
/*     */   
/*     */   public void func_73866_w_() {
/*  26 */     super.func_73866_w_();
/*  27 */     W_ScaledResolution sr = new W_ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/*  28 */     int factor = (sr.func_78325_e() > 0) ? sr.func_78325_e() : 1;
/*  29 */     this.field_147003_i = 0;
/*  30 */     this.field_147009_r = 0;
/*  31 */     int x = this.field_146297_k.field_71443_c / 2 / factor;
/*  32 */     int y = this.field_146297_k.field_71440_d / 2 / factor;
/*  33 */     GuiButton buttonCTNextC = new GuiButton(576, x + 40, y - 20, 40, 20, ">");
/*  34 */     GuiButton buttonCTPrevC = new GuiButton(577, x - 80, y - 20, 40, 20, "<");
/*  35 */     this.buttonCreateTeamFF = new GuiButton(560, x - 80, y + 20, 160, 20, "");
/*  36 */     this.buttonCreateTeamOK = new GuiButton(528, x - 80, y + 60, 80, 20, "OK");
/*  37 */     GuiButton buttonCTCancel = new GuiButton(544, x + 0, y + 60, 80, 20, "Cancel");
/*  38 */     this.editCreateTeamName = new GuiTextField(this.field_146289_q, x - 80, y - 55, 160, 20);
/*  39 */     this.editCreateTeamName.func_146180_a("");
/*  40 */     this.editCreateTeamName.func_146193_g(-1);
/*  41 */     this.editCreateTeamName.func_146203_f(16);
/*  42 */     this.editCreateTeamName.func_146195_b(true);
/*  43 */     this.listGui.add(buttonCTNextC);
/*  44 */     this.listGui.add(buttonCTPrevC);
/*  45 */     this.listGui.add(this.buttonCreateTeamFF);
/*  46 */     this.listGui.add(this.buttonCreateTeamOK);
/*  47 */     this.listGui.add(buttonCTCancel);
/*  48 */     this.listGui.add(this.editCreateTeamName);
/*     */   }
/*     */   
/*     */   public void func_73876_c() {
/*  52 */     String teamName = this.editCreateTeamName.func_146179_b();
/*  53 */     this.buttonCreateTeamOK.field_146124_l = (teamName.length() > 0 && teamName.length() <= 16);
/*  54 */     this.editCreateTeamName.func_146178_a();
/*  55 */     this.buttonCreateTeamFF.field_146126_j = "Friendly Fire : " + (friendlyFire ? "ON" : "OFF");
/*     */   }
/*     */   
/*     */   public void acviveScreen() {
/*  59 */     this.editCreateTeamName.func_146180_a("");
/*  60 */     this.editCreateTeamName.func_146195_b(true);
/*     */   }
/*     */   
/*     */   protected void func_73869_a(char c, int code) {
/*  64 */     if (code == 1) {
/*  65 */       switchScreen(MCH_GuiScoreboard_Base.SCREEN_ID.MAIN);
/*     */     } else {
/*  67 */       this.editCreateTeamName.func_146201_a(c, code);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/*  73 */     this.editCreateTeamName.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*  74 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */   }
/*     */   
/*     */   protected void func_146284_a(GuiButton btn) {
/*  78 */     if (btn != null && btn.field_146124_l) {
/*  79 */       String str; switch (btn.field_146127_k) {
/*     */         case 528:
/*  81 */           str = this.editCreateTeamName.func_146179_b();
/*     */         case 544:
/*  83 */           switchScreen(MCH_GuiScoreboard_Base.SCREEN_ID.MAIN);
/*     */           break;
/*     */         case 560:
/*  86 */           friendlyFire = !friendlyFire;
/*     */           break;
/*     */         case 576:
/*  89 */           this.lastTeamColor++;
/*  90 */           if (this.lastTeamColor >= colorNames.length) {
/*  91 */             this.lastTeamColor = 0;
/*     */           }
/*     */           break;
/*     */         case 577:
/*  95 */           this.lastTeamColor--;
/*  96 */           if (this.lastTeamColor < 0) {
/*  97 */             this.lastTeamColor = colorNames.length - 1;
/*     */           }
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_146976_a(float par1, int par2, int par3) {
/* 105 */     drawList(this.field_146297_k, this.field_146289_q, true);
/* 106 */     W_ScaledResolution sr = new W_ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 107 */     int factor = (sr.func_78325_e() > 0) ? sr.func_78325_e() : 1;
/* 108 */     W_McClient.MOD_bindTexture("textures/gui/mp_new_team.png");
/* 109 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 110 */     int x = (this.field_146297_k.field_71443_c / factor - 222) / 2;
/* 111 */     int y = (this.field_146297_k.field_71440_d / factor - 200) / 2;
/* 112 */     func_73729_b(x, y, 0, 0, 222, 200);
/* 113 */     x = this.field_146297_k.field_71443_c / 2 / factor;
/* 114 */     y = this.field_146297_k.field_71440_d / 2 / factor;
/* 115 */     drawCenteredString("Create team", x, y - 85, -1);
/* 116 */     drawCenteredString("Team name", x, y - 70, -1);
/* 117 */     EnumChatFormatting ecf = EnumChatFormatting.func_96300_b(colorNames[this.lastTeamColor]);
/* 118 */     drawCenteredString(ecf + "Team Color" + ecf, x, y - 13, -1);
/* 119 */     this.editCreateTeamName.func_146194_f();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_GuiScoreboard_CreateTeam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */