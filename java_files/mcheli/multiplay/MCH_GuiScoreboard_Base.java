/*     */ package mcheli.multiplay;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mcheli.wrapper.W_GuiContainer;
/*     */ import mcheli.wrapper.W_ScaledResolution;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiPlayerInfo;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.scoreboard.Score;
/*     */ import net.minecraft.scoreboard.ScoreObjective;
/*     */ import net.minecraft.scoreboard.ScorePlayerTeam;
/*     */ import net.minecraft.scoreboard.Team;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public abstract class MCH_GuiScoreboard_Base extends W_GuiContainer {
/*     */   public List listGui;
/*     */   public static final int BUTTON_ID_SHUFFLE = 256;
/*     */   public static final int BUTTON_ID_CREATE_TEAM = 512;
/*     */   public static final int BUTTON_ID_CREATE_TEAM_OK = 528;
/*     */   public static final int BUTTON_ID_CREATE_TEAM_CANCEL = 544;
/*     */   public static final int BUTTON_ID_CREATE_TEAM_FF = 560;
/*     */   
/*     */   public MCH_GuiScoreboard_Base(MCH_IGuiScoreboard switcher, EntityPlayer player) {
/*  35 */     super(new MCH_ContainerScoreboard(player));
/*  36 */     this.screen_switcher = switcher;
/*  37 */     this.field_146297_k = Minecraft.func_71410_x();
/*     */   }
/*     */   public static final int BUTTON_ID_CREATE_TEAM_NEXT_C = 576; public static final int BUTTON_ID_CREATE_TEAM_PREV_C = 577; public static final int BUTTON_ID_JUMP_SPAWN_POINT = 768; public static final int BUTTON_ID_SWITCH_PVP = 1024; public static final int BUTTON_ID_DESTORY_ALL = 1280; private MCH_IGuiScoreboard screen_switcher;
/*     */   public void func_73866_w_() {}
/*     */   
/*     */   public void initGui(List<Gui> buttonList, GuiScreen parents) {
/*  43 */     this.listGui = new ArrayList();
/*  44 */     this.field_146297_k = Minecraft.func_71410_x();
/*  45 */     this.field_146289_q = this.field_146297_k.field_71466_p;
/*  46 */     this.field_146294_l = parents.field_146294_l;
/*  47 */     this.field_146295_m = parents.field_146295_m;
/*  48 */     func_73866_w_();
/*  49 */     Iterator<Gui> i$ = this.listGui.iterator();
/*     */     
/*  51 */     while (i$.hasNext()) {
/*  52 */       Gui b = i$.next();
/*  53 */       if (b instanceof GuiButton) {
/*  54 */         buttonList.add(b);
/*     */       }
/*     */     } 
/*     */     
/*  58 */     this.field_146292_n.clear();
/*     */   }
/*     */   
/*     */   public static void setVisible(Object g, boolean v) {
/*  62 */     if (g instanceof GuiButton) {
/*  63 */       ((GuiButton)g).field_146125_m = v;
/*     */     }
/*     */     
/*  66 */     if (g instanceof GuiTextField) {
/*  67 */       ((GuiTextField)g).func_146189_e(v);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateScreenButtons(List list) {}
/*     */   
/*     */   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {}
/*     */   
/*     */   public int getTeamNum() {
/*  77 */     return this.field_146297_k.field_71441_e.func_96441_U().func_96525_g().size();
/*     */   }
/*     */   
/*     */   protected void acviveScreen() {}
/*     */   
/*     */   public void onSwitchScreen() {
/*  83 */     Iterator<Gui> i$ = this.listGui.iterator();
/*     */     
/*  85 */     while (i$.hasNext()) {
/*  86 */       Gui b = i$.next();
/*  87 */       setVisible(b, true);
/*     */     } 
/*     */     
/*  90 */     acviveScreen();
/*     */   }
/*     */   
/*     */   public void leaveScreen() {
/*  94 */     Iterator<Gui> i$ = this.listGui.iterator();
/*     */     
/*  96 */     while (i$.hasNext()) {
/*  97 */       Gui b = i$.next();
/*  98 */       setVisible(b, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyTypedScreen(char c, int code) {
/* 104 */     func_73869_a(c, code);
/*     */   }
/*     */   
/*     */   public void mouseClickedScreen(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/*     */     try {
/* 109 */       func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 110 */     } catch (Exception var7) {
/* 111 */       if (p_73864_3_ == 0) {
/* 112 */         for (int l = 0; l < this.field_146292_n.size(); l++) {
/* 113 */           GuiButton guibutton = this.field_146292_n.get(l);
/* 114 */           if (guibutton.func_146116_c(this.field_146297_k, p_73864_1_, p_73864_2_)) {
/* 115 */             guibutton.func_146113_a(this.field_146297_k.func_147118_V());
/* 116 */             func_146284_a(guibutton);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawGuiContainerForegroundLayerScreen(int param1, int param2) {
/* 125 */     func_146979_b(param1, param2);
/*     */   }
/*     */   
/*     */   protected void actionPerformedScreen(GuiButton btn) {
/* 129 */     func_146284_a(btn);
/*     */   }
/*     */   
/*     */   public void switchScreen(SCREEN_ID id) {
/* 133 */     this.screen_switcher.switchScreen(id);
/*     */   }
/*     */   
/*     */   public static int getScoreboradWidth(Minecraft mc) {
/* 137 */     W_ScaledResolution scaledresolution = new W_ScaledResolution(mc, mc.field_71443_c, mc.field_71440_d);
/* 138 */     int ScaledWidth = scaledresolution.func_78326_a() - 40;
/* 139 */     int width = ScaledWidth * 3 / 4 / (mc.field_71441_e.func_96441_U().func_96525_g().size() + 1);
/* 140 */     if (width > 150) {
/* 141 */       width = 150;
/*     */     }
/*     */     
/* 144 */     return width;
/*     */   }
/*     */   
/*     */   public static int getScoreBoardLeft(Minecraft mc, int teamNum, int teamIndex) {
/* 148 */     W_ScaledResolution scaledresolution = new W_ScaledResolution(mc, mc.field_71443_c, mc.field_71440_d);
/* 149 */     int ScaledWidth = scaledresolution.func_78326_a();
/* 150 */     return (int)((ScaledWidth / 2) + (getScoreboradWidth(mc) + 10) * (-(teamNum) / 2.0D + teamIndex));
/*     */   }
/*     */   
/*     */   public static void drawList(Minecraft mc, FontRenderer fontRendererObj, boolean mng) {
/* 154 */     ArrayList<ScorePlayerTeam> teamList = new ArrayList();
/* 155 */     teamList.add(null);
/* 156 */     Iterator i = mc.field_71441_e.func_96441_U().func_96525_g().iterator();
/*     */     
/* 158 */     while (i.hasNext()) {
/* 159 */       Object team = i.next();
/* 160 */       teamList.add((ScorePlayerTeam)team);
/*     */     } 
/*     */ 
/*     */     
/* 164 */     Collections.sort(teamList, new Comparator<ScorePlayerTeam>() {
/*     */           public int compare(ScorePlayerTeam o1, ScorePlayerTeam o2) {
/* 166 */             return (o1 == null && o2 == null) ? 0 : ((o1 == null) ? -1 : ((o2 == null) ? 1 : o1.func_96661_b().compareTo(o2.func_96661_b())));
/*     */           }
/*     */         });
/*     */     
/* 170 */     for (int var6 = 0; var6 < teamList.size(); var6++) {
/* 171 */       if (mng) {
/* 172 */         drawPlayersList(mc, fontRendererObj, teamList.get(var6), 1 + var6, 1 + teamList.size());
/*     */       } else {
/* 174 */         drawPlayersList(mc, fontRendererObj, teamList.get(var6), var6, teamList.size());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawPlayersList(Minecraft mc, FontRenderer fontRendererObj, ScorePlayerTeam team, int teamIndex, int teamNum) {
/* 181 */     W_ScaledResolution scaledresolution = new W_ScaledResolution(mc, mc.field_71443_c, mc.field_71440_d);
/* 182 */     int ScaledWidth = scaledresolution.func_78326_a();
/* 183 */     int ScaledHeight = scaledresolution.func_78328_b();
/* 184 */     ScoreObjective scoreobjective = mc.field_71441_e.func_96441_U().func_96539_a(0);
/* 185 */     NetHandlerPlayClient nethandlerplayclient = mc.field_71439_g.field_71174_a;
/* 186 */     List<GuiPlayerInfo> list = nethandlerplayclient.field_147303_b;
/* 187 */     int MaxPlayers = (list.size() / 5 + 1) * 5;
/* 188 */     MaxPlayers = (MaxPlayers < 10) ? 10 : MaxPlayers;
/* 189 */     if (MaxPlayers > nethandlerplayclient.field_147304_c) {
/* 190 */       MaxPlayers = nethandlerplayclient.field_147304_c;
/*     */     }
/*     */     
/* 193 */     int width = getScoreboradWidth(mc);
/* 194 */     int listLeft = getScoreBoardLeft(mc, teamNum, teamIndex);
/* 195 */     int listTop = ScaledHeight / 2 - (MaxPlayers * 9 + 10) / 2;
/* 196 */     func_73734_a(listLeft - 1, listTop - 1 - 18, listLeft + width, listTop + 9 * MaxPlayers, -2147483648);
/* 197 */     String teamName = ScorePlayerTeam.func_96667_a((Team)team, (team == null) ? "No team" : team.func_96661_b());
/* 198 */     int teamNameX = listLeft + width / 2 - fontRendererObj.func_78256_a(teamName) / 2;
/* 199 */     fontRendererObj.func_78261_a(teamName, teamNameX, listTop - 18, -1);
/* 200 */     String ff_onoff = "FriendlyFire : " + ((team == null) ? "ON" : (team.func_96665_g() ? "ON" : "OFF"));
/* 201 */     int ff_onoffX = listLeft + width / 2 - fontRendererObj.func_78256_a(ff_onoff) / 2;
/* 202 */     fontRendererObj.func_78261_a(ff_onoff, ff_onoffX, listTop - 9, -1);
/* 203 */     int drawY = 0;
/*     */     
/* 205 */     for (int i = 0; i < MaxPlayers; i++) {
/* 206 */       int y = listTop + drawY * 9;
/* 207 */       int rectY = listTop + i * 9;
/* 208 */       func_73734_a(listLeft, rectY, listLeft + width - 1, rectY + 8, 553648127);
/* 209 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 210 */       GL11.glEnable(3008);
/* 211 */       if (i < list.size()) {
/* 212 */         GuiPlayerInfo guiplayerinfo = list.get(i);
/* 213 */         String playerName = guiplayerinfo.field_78831_a;
/* 214 */         ScorePlayerTeam steam = mc.field_71441_e.func_96441_U().func_96509_i(playerName);
/* 215 */         if ((steam == null && team == null) || (steam != null && team != null && steam.func_142054_a((Team)team))) {
/* 216 */           drawY++;
/* 217 */           fontRendererObj.func_78261_a(playerName, listLeft, y, -1);
/* 218 */           if (scoreobjective != null) {
/* 219 */             int j4 = listLeft + fontRendererObj.func_78256_a(playerName) + 5;
/* 220 */             int k4 = listLeft + width - 12 - 5;
/* 221 */             if (k4 - j4 > 5) {
/* 222 */               Score score = scoreobjective.func_96682_a().func_96529_a(guiplayerinfo.field_78831_a, scoreobjective);
/* 223 */               String s1 = EnumChatFormatting.YELLOW + "" + score.func_96652_c();
/* 224 */               fontRendererObj.func_78261_a(s1, k4 - fontRendererObj.func_78256_a(s1), y, 16777215);
/*     */             } 
/*     */           } 
/*     */           
/* 228 */           drawResponseTime(listLeft + width - 12, y, guiplayerinfo.field_78829_b);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void drawResponseTime(int x, int y, int responseTime) {
/*     */     byte b2;
/* 236 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 237 */     Minecraft.func_71410_x().func_110434_K().func_110577_a(Gui.field_110324_m);
/*     */     
/* 239 */     if (responseTime < 0) {
/* 240 */       b2 = 5;
/* 241 */     } else if (responseTime < 150) {
/* 242 */       b2 = 0;
/* 243 */     } else if (responseTime < 300) {
/* 244 */       b2 = 1;
/* 245 */     } else if (responseTime < 600) {
/* 246 */       b2 = 2;
/* 247 */     } else if (responseTime < 1000) {
/* 248 */       b2 = 3;
/*     */     } else {
/* 250 */       b2 = 4;
/*     */     } 
/*     */     
/* 253 */     static_drawTexturedModalRect(x, y, 0, 176 + b2 * 8, 10, 8, 0.0D);
/*     */   }
/*     */   
/*     */   public static void static_drawTexturedModalRect(int x, int y, int x2, int y2, int x3, int y3, double zLevel) {
/* 257 */     float f = 0.00390625F;
/* 258 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 259 */     tessellator.func_78382_b();
/* 260 */     tessellator.func_78374_a((x + 0), (y + y3), zLevel, ((x2 + 0) * 0.00390625F), ((y2 + y3) * 0.00390625F));
/* 261 */     tessellator.func_78374_a((x + x3), (y + y3), zLevel, ((x2 + x3) * 0.00390625F), ((y2 + y3) * 0.00390625F));
/* 262 */     tessellator.func_78374_a((x + x3), (y + 0), zLevel, ((x2 + x3) * 0.00390625F), ((y2 + 0) * 0.00390625F));
/* 263 */     tessellator.func_78374_a((x + 0), (y + 0), zLevel, ((x2 + 0) * 0.00390625F), ((y2 + 0) * 0.00390625F));
/* 264 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   protected enum SCREEN_ID
/*     */   {
/* 269 */     MAIN("MAIN", 0),
/* 270 */     CREATE_TEAM("CREATE_TEAM", 1);
/*     */     
/* 272 */     private static final SCREEN_ID[] $VALUES = new SCREEN_ID[] { MAIN, CREATE_TEAM };
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_GuiScoreboard_Base.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */