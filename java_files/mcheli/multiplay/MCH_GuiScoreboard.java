/*     */ package mcheli.multiplay;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mcheli.wrapper.W_GuiButton;
/*     */ import mcheli.wrapper.W_GuiContainer;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MCH_GuiScoreboard
/*     */   extends W_GuiContainer implements MCH_IGuiScoreboard {
/*     */   public final EntityPlayer thePlayer;
/*     */   private MCH_GuiScoreboard_Base.SCREEN_ID screenID;
/*     */   private Map listScreen;
/*  22 */   private int lastTeamNum = 0;
/*     */ 
/*     */   
/*     */   public MCH_GuiScoreboard(EntityPlayer player) {
/*  26 */     super(new MCH_ContainerScoreboard(player));
/*  27 */     this.thePlayer = player;
/*     */   }
/*     */   
/*     */   public void func_73866_w_() {
/*  31 */     Keyboard.enableRepeatEvents(true);
/*  32 */     super.func_73866_w_();
/*  33 */     this.field_146292_n.clear();
/*  34 */     this.field_146293_o.clear();
/*  35 */     this.field_147003_i = 0;
/*  36 */     this.field_147009_r = 0;
/*  37 */     this.listScreen = new HashMap<>();
/*  38 */     this.listScreen.put(MCH_GuiScoreboard_Base.SCREEN_ID.MAIN, new MCH_GuiScoreboard_Main(this, this.thePlayer));
/*  39 */     this.listScreen.put(MCH_GuiScoreboard_Base.SCREEN_ID.CREATE_TEAM, new MCH_GuiScoreboard_CreateTeam(this, this.thePlayer));
/*  40 */     Iterator<MCH_GuiScoreboard_Base> i$ = this.listScreen.values().iterator();
/*     */     
/*  42 */     while (i$.hasNext()) {
/*  43 */       MCH_GuiScoreboard_Base s = i$.next();
/*  44 */       s.initGui(this.field_146292_n, (GuiScreen)this);
/*     */     } 
/*     */     
/*  47 */     this.lastTeamNum = this.field_146297_k.field_71441_e.func_96441_U().func_96525_g().size();
/*  48 */     switchScreen(MCH_GuiScoreboard_Base.SCREEN_ID.MAIN);
/*     */   }
/*     */   
/*     */   public void func_73876_c() {
/*  52 */     super.func_73876_c();
/*  53 */     int nowTeamNum = this.field_146297_k.field_71441_e.func_96441_U().func_96525_g().size();
/*  54 */     if (this.lastTeamNum != nowTeamNum) {
/*  55 */       this.lastTeamNum = nowTeamNum;
/*  56 */       func_73866_w_();
/*     */     } 
/*     */     
/*  59 */     Iterator<MCH_GuiScoreboard_Base> i$ = this.listScreen.values().iterator();
/*     */     
/*  61 */     while (i$.hasNext()) {
/*  62 */       MCH_GuiScoreboard_Base s = i$.next();
/*     */       
/*     */       try {
/*  65 */         s.updateScreenButtons(this.field_146292_n);
/*  66 */         s.func_73876_c();
/*  67 */       } catch (Exception exception) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void switchScreen(MCH_GuiScoreboard_Base.SCREEN_ID id) {
/*  75 */     Iterator<MCH_GuiScoreboard_Base> i$ = this.listScreen.values().iterator();
/*     */     
/*  77 */     while (i$.hasNext()) {
/*  78 */       MCH_GuiScoreboard_Base b = i$.next();
/*  79 */       b.leaveScreen();
/*     */     } 
/*     */     
/*  82 */     this.screenID = id;
/*  83 */     getCurrentScreen().onSwitchScreen();
/*     */   }
/*     */   
/*     */   private MCH_GuiScoreboard_Base getCurrentScreen() {
/*  87 */     return (MCH_GuiScoreboard_Base)this.listScreen.get(this.screenID);
/*     */   }
/*     */   
/*     */   public static void setVisible(Object g, boolean v) {
/*  91 */     if (g instanceof GuiButton) {
/*  92 */       ((GuiButton)g).field_146125_m = v;
/*     */     }
/*     */     
/*  95 */     if (g instanceof GuiTextField) {
/*  96 */       ((GuiTextField)g).func_146189_e(v);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char c, int code) {
/* 102 */     getCurrentScreen().keyTypedScreen(c, code);
/*     */   }
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/*     */     try {
/* 107 */       Iterator<MCH_GuiScoreboard_Base> e = this.listScreen.values().iterator();
/*     */       
/* 109 */       while (e.hasNext()) {
/* 110 */         MCH_GuiScoreboard_Base s = e.next();
/* 111 */         s.mouseClickedScreen(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */       } 
/*     */       
/* 114 */       super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 115 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton btn) {
/* 122 */     if (btn != null && btn.field_146124_l) {
/* 123 */       getCurrentScreen().actionPerformedScreen(btn);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146276_q_() {}
/*     */   
/*     */   public void func_146278_c(int p_146278_1_) {
/* 131 */     GL11.glDisable(2896);
/* 132 */     GL11.glDisable(2912);
/* 133 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   protected void func_146979_b(int x, int y) {
/* 137 */     getCurrentScreen().drawGuiContainerForegroundLayerScreen(x, y);
/* 138 */     Iterator i$ = this.field_146292_n.iterator();
/*     */     
/* 140 */     while (i$.hasNext()) {
/* 141 */       Object o = i$.next();
/* 142 */       if (o instanceof W_GuiButton) {
/* 143 */         W_GuiButton btn = (W_GuiButton)o;
/* 144 */         if (btn.isOnMouseOver() && btn.hoverStringList != null) {
/* 145 */           drawHoveringText(btn.hoverStringList, x, y, this.field_146289_q);
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawList(Minecraft mc, FontRenderer fontRendererObj, boolean mng) {
/* 154 */     MCH_GuiScoreboard_Base.drawList(mc, fontRendererObj, mng);
/*     */   }
/*     */   
/*     */   protected void func_146976_a(float par1, int par2, int par3) {
/* 158 */     getCurrentScreen().func_146976_a(par1, par2, par3);
/*     */   }
/*     */   
/*     */   public void func_146280_a(Minecraft p_146280_1_, int p_146280_2_, int p_146280_3_) {
/* 162 */     super.func_146280_a(p_146280_1_, p_146280_2_, p_146280_3_);
/* 163 */     Iterator<MCH_GuiScoreboard_Base> i$ = this.listScreen.values().iterator();
/*     */     
/* 165 */     while (i$.hasNext()) {
/* 166 */       MCH_GuiScoreboard_Base s = i$.next();
/* 167 */       s.func_146280_a(p_146280_1_, p_146280_2_, p_146280_3_);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_GuiScoreboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */