/*     */ package mcheli.command;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mcheli.gui.MCH_Gui;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ChatLine;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_GuiTitle
/*     */   extends MCH_Gui
/*     */ {
/*  23 */   private final List chatLines = new ArrayList();
/*  24 */   private int prevPlayerTick = 0;
/*  25 */   private int restShowTick = 0;
/*  26 */   private int showTick = 0;
/*  27 */   private float colorAlpha = 0.0F;
/*  28 */   private int position = 0;
/*     */   
/*     */   private static Minecraft s_minecraft;
/*     */   
/*     */   public MCH_GuiTitle(Minecraft minecraft) {
/*  33 */     super(minecraft);
/*  34 */     s_minecraft = minecraft;
/*     */   }
/*     */   
/*     */   public void func_73866_w_() {
/*  38 */     super.func_73866_w_();
/*     */   }
/*     */   
/*     */   public boolean func_73868_f() {
/*  42 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isDrawGui(EntityPlayer player) {
/*  46 */     if (this.restShowTick > 0 && this.chatLines.size() > 0 && player != null && player.field_70170_p != null) {
/*  47 */       if (this.prevPlayerTick != player.field_70173_aa) {
/*  48 */         this.showTick++;
/*  49 */         this.restShowTick--;
/*     */       } 
/*     */       
/*  52 */       this.prevPlayerTick = player.field_70173_aa;
/*     */     } 
/*     */     
/*  55 */     return (this.restShowTick > 0);
/*     */   }
/*     */   
/*     */   public void drawGui(EntityPlayer player, boolean isThirdPersonView) {
/*  59 */     GL11.glLineWidth((MCH_Gui.scaleFactor * 2));
/*  60 */     GL11.glDisable(3042);
/*  61 */     if (MCH_Gui.scaleFactor <= 0) {
/*  62 */       MCH_Gui.scaleFactor = 1;
/*     */     }
/*     */     
/*  65 */     this.colorAlpha = 1.0F;
/*  66 */     if (this.restShowTick > 20 && this.showTick < 5) {
/*  67 */       this.colorAlpha = 0.2F * this.showTick;
/*     */     }
/*     */     
/*  70 */     if (this.showTick > 0 && this.restShowTick < 5) {
/*  71 */       this.colorAlpha = 0.2F * this.restShowTick;
/*     */     }
/*     */     
/*  74 */     drawChat();
/*     */   }
/*     */   
/*     */   private String func_146235_b(String s) {
/*  78 */     return (Minecraft.func_71410_x()).field_71474_y.field_74344_o ? s : EnumChatFormatting.func_110646_a(s);
/*     */   }
/*     */   
/*     */   private int func_146233_a() {
/*  82 */     short short1 = 320;
/*  83 */     byte b0 = 40;
/*  84 */     return MathHelper.func_76141_d(this.field_146297_k.field_71474_y.field_96692_F * (short1 - b0) + b0);
/*     */   }
/*     */   
/*     */   public void setupTitle(IChatComponent chatComponent, int showTime, int pos) {
/*  88 */     byte displayTime = 20;
/*  89 */     byte line = 0;
/*  90 */     this.chatLines.clear();
/*  91 */     this.position = pos;
/*  92 */     this.showTick = 0;
/*  93 */     this.restShowTick = showTime;
/*  94 */     int k = MathHelper.func_76141_d(func_146233_a() / this.field_146297_k.field_71474_y.field_96691_E);
/*  95 */     int l = 0;
/*  96 */     ChatComponentText chatcomponenttext = new ChatComponentText("");
/*  97 */     ArrayList<ChatComponentText> arraylist = Lists.newArrayList();
/*  98 */     ArrayList<IChatComponent> arraylist1 = Lists.newArrayList((Iterable)chatComponent);
/*     */     
/* 100 */     for (int ichatcomponent2 = 0; ichatcomponent2 < arraylist1.size(); ichatcomponent2++) {
/* 101 */       IChatComponent iterator = arraylist1.get(ichatcomponent2);
/* 102 */       String[] splitLine = (iterator.func_150261_e() + "").split("\n");
/* 103 */       int lineCnt = 0;
/* 104 */       String[] arr$ = splitLine;
/* 105 */       int len$ = splitLine.length;
/*     */       
/* 107 */       for (int i$ = 0; i$ < len$; i$++) {
/* 108 */         String sLine = arr$[i$];
/* 109 */         String s = func_146235_b(iterator.func_150256_b().func_150218_j() + sLine);
/* 110 */         int j1 = this.field_146297_k.field_71466_p.func_78256_a(s);
/* 111 */         ChatComponentText chatcomponenttext1 = new ChatComponentText(s);
/* 112 */         chatcomponenttext1.func_150255_a(iterator.func_150256_b().func_150232_l());
/* 113 */         boolean flag1 = false;
/* 114 */         if (l + j1 > k) {
/* 115 */           String s1 = this.field_146297_k.field_71466_p.func_78262_a(s, k - l, false);
/* 116 */           String s2 = (s1.length() < s.length()) ? s.substring(s1.length()) : null;
/* 117 */           if (s2 != null && s2.length() > 0) {
/* 118 */             int k1 = s1.lastIndexOf(" ");
/* 119 */             if (k1 >= 0 && this.field_146297_k.field_71466_p.func_78256_a(s.substring(0, k1)) > 0) {
/* 120 */               s1 = s.substring(0, k1);
/* 121 */               s2 = s.substring(k1);
/*     */             } 
/*     */             
/* 124 */             ChatComponentText chatcomponenttext2 = new ChatComponentText(s2);
/* 125 */             chatcomponenttext2.func_150255_a(iterator.func_150256_b().func_150232_l());
/* 126 */             arraylist1.add(ichatcomponent2 + 1, chatcomponenttext2);
/*     */           } 
/*     */           
/* 129 */           j1 = this.field_146297_k.field_71466_p.func_78256_a(s1);
/* 130 */           chatcomponenttext1 = new ChatComponentText(s1);
/* 131 */           chatcomponenttext1.func_150255_a(iterator.func_150256_b().func_150232_l());
/* 132 */           flag1 = true;
/*     */         } 
/*     */         
/* 135 */         if (l + j1 <= k) {
/* 136 */           l += j1;
/* 137 */           chatcomponenttext.func_150257_a((IChatComponent)chatcomponenttext1);
/*     */         } else {
/* 139 */           flag1 = true;
/*     */         } 
/*     */         
/* 142 */         if (flag1) {
/* 143 */           arraylist.add(chatcomponenttext);
/* 144 */           l = 0;
/* 145 */           chatcomponenttext = new ChatComponentText("");
/*     */         } 
/*     */         
/* 148 */         lineCnt++;
/* 149 */         if (lineCnt < splitLine.length) {
/* 150 */           arraylist.add(chatcomponenttext);
/* 151 */           l = 0;
/* 152 */           chatcomponenttext = new ChatComponentText("");
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 157 */     arraylist.add(chatcomponenttext);
/* 158 */     Iterator<ChatComponentText> var28 = arraylist.iterator();
/*     */     
/* 160 */     while (var28.hasNext()) {
/* 161 */       IChatComponent var27 = (IChatComponent)var28.next();
/* 162 */       this.chatLines.add(new ChatLine(displayTime, var27, line));
/*     */     } 
/*     */     
/* 165 */     while (this.chatLines.size() > 100) {
/* 166 */       this.chatLines.remove(this.chatLines.size() - 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private int func_146243_b() {
/* 172 */     short short1 = 180;
/* 173 */     byte b0 = 20;
/* 174 */     return MathHelper.func_76141_d(this.field_146297_k.field_71474_y.field_96694_H * (short1 - b0) + b0);
/*     */   }
/*     */   
/*     */   private void drawChat() {
/* 178 */     float charAlpha = this.field_146297_k.field_71474_y.field_74357_r * 0.9F + 0.1F;
/* 179 */     float scale = this.field_146297_k.field_71474_y.field_96691_E * 2.0F;
/* 180 */     GL11.glPushMatrix();
/* 181 */     float posY = 0.0F;
/* 182 */     switch (this.position) {
/*     */       
/*     */       default:
/* 185 */         posY = (this.field_146297_k.field_71440_d / 2 / MCH_Gui.scaleFactor) - this.chatLines.size() / 2.0F * 9.0F * scale;
/*     */         break;
/*     */       case 1:
/* 188 */         posY = 0.0F;
/*     */         break;
/*     */       case 2:
/* 191 */         posY = (this.field_146297_k.field_71440_d / MCH_Gui.scaleFactor) - this.chatLines.size() * 9.0F * scale;
/*     */         break;
/*     */       case 3:
/* 194 */         posY = (this.field_146297_k.field_71440_d / 3 / MCH_Gui.scaleFactor) - this.chatLines.size() / 2.0F * 9.0F * scale;
/*     */         break;
/*     */       case 4:
/* 197 */         posY = (this.field_146297_k.field_71440_d * 2 / 3 / MCH_Gui.scaleFactor) - this.chatLines.size() / 2.0F * 9.0F * scale;
/*     */         break;
/*     */     } 
/* 200 */     GL11.glTranslatef(0.0F, posY, 0.0F);
/* 201 */     GL11.glScalef(scale, scale, 1.0F);
/*     */     
/* 203 */     for (int i = 0; i < this.chatLines.size(); i++) {
/* 204 */       ChatLine chatline = this.chatLines.get(i);
/* 205 */       if (chatline != null) {
/* 206 */         int alpha = (int)(255.0F * charAlpha * this.colorAlpha);
/* 207 */         int y = i * 9;
/* 208 */         func_73734_a(0, y + 9, this.field_146297_k.field_71443_c, y, alpha / 2 << 24);
/* 209 */         GL11.glEnable(3042);
/* 210 */         String s = chatline.func_151461_a().func_150254_d();
/* 211 */         int sw = this.field_146297_k.field_71443_c / 2 / MCH_Gui.scaleFactor - this.field_146297_k.field_71466_p.func_78256_a(s);
/* 212 */         sw = (int)(sw / scale);
/* 213 */         this.field_146297_k.field_71466_p.func_78261_a(s, sw, y + 1, 16777215 + (alpha << 24));
/* 214 */         GL11.glDisable(3008);
/*     */       } 
/*     */     } 
/*     */     
/* 218 */     GL11.glTranslatef(-3.0F, 0.0F, 0.0F);
/* 219 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\command\MCH_GuiTitle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */