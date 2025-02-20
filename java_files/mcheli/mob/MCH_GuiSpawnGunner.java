/*     */ package mcheli.mob;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.gui.MCH_Gui;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_GuiSpawnGunner
/*     */   extends MCH_Gui
/*     */ {
/*     */   public MCH_GuiSpawnGunner(Minecraft minecraft) {
/*  25 */     super(minecraft);
/*     */   }
/*     */   
/*     */   public void func_73866_w_() {
/*  29 */     super.func_73866_w_();
/*     */   }
/*     */   
/*     */   public boolean func_73868_f() {
/*  33 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isDrawGui(EntityPlayer player) {
/*  37 */     return (player != null && player.field_70170_p != null && player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() instanceof MCH_ItemSpawnGunner);
/*     */   }
/*     */   
/*     */   public void drawGui(EntityPlayer player, boolean isThirdPersonView) {
/*  41 */     if (!isThirdPersonView && 
/*  42 */       isDrawGui(player)) {
/*  43 */       GL11.glLineWidth(MCH_Gui.scaleFactor);
/*  44 */       GL11.glDisable(3042);
/*  45 */       draw(player, searchTarget(player));
/*     */     } 
/*     */   } private Entity searchTarget(EntityPlayer player) {
/*     */     MCH_EntityGunner mCH_EntityGunner;
/*     */     MCH_EntitySeat mCH_EntitySeat;
/*     */     MCH_EntityAircraft mCH_EntityAircraft;
/*  51 */     float f = 1.0F;
/*  52 */     float pitch = player.field_70127_C + (player.field_70125_A - player.field_70127_C) * f;
/*  53 */     float yaw = player.field_70126_B + (player.field_70177_z - player.field_70126_B) * f;
/*  54 */     double dx = player.field_70169_q + (player.field_70165_t - player.field_70169_q) * f;
/*  55 */     double dy = player.field_70167_r + (player.field_70163_u - player.field_70167_r) * f + 1.62D - player.field_70129_M;
/*  56 */     double dz = player.field_70166_s + (player.field_70161_v - player.field_70166_s) * f;
/*  57 */     Vec3 vec3 = Vec3.func_72443_a(dx, dy, dz);
/*  58 */     float f3 = MathHelper.func_76134_b(-yaw * 0.017453292F - 3.1415927F);
/*  59 */     float f4 = MathHelper.func_76126_a(-yaw * 0.017453292F - 3.1415927F);
/*  60 */     float f5 = -MathHelper.func_76134_b(-pitch * 0.017453292F);
/*  61 */     float f6 = MathHelper.func_76126_a(-pitch * 0.017453292F);
/*  62 */     float f7 = f4 * f5;
/*  63 */     float f8 = f3 * f5;
/*  64 */     double d3 = 5.0D;
/*  65 */     Vec3 vec31 = vec3.func_72441_c(f7 * d3, f6 * d3, f8 * d3);
/*  66 */     Entity target = null;
/*  67 */     List<MCH_EntityGunner> list = player.field_70170_p.func_72872_a(MCH_EntityGunner.class, player.field_70121_D.func_72314_b(5.0D, 5.0D, 5.0D));
/*     */     
/*  69 */     for (int i = 0; i < list.size(); i++) {
/*  70 */       MCH_EntityGunner gunner = list.get(i);
/*  71 */       if (gunner.field_70121_D.func_72327_a(vec3, vec31) != null && (target == null || player.func_70068_e((Entity)gunner) < player.func_70068_e(target))) {
/*  72 */         mCH_EntityGunner = gunner;
/*     */       }
/*     */     } 
/*     */     
/*  76 */     if (mCH_EntityGunner != null) {
/*  77 */       return (Entity)mCH_EntityGunner;
/*     */     }
/*  79 */     MCH_ItemSpawnGunner item = (MCH_ItemSpawnGunner)player.func_71045_bC().func_77973_b();
/*  80 */     if (item.targetType == 1 && !player.field_70170_p.field_72995_K && player.func_96124_cp() == null) {
/*  81 */       return null;
/*     */     }
/*  83 */     list = player.field_70170_p.func_72872_a(MCH_EntitySeat.class, player.field_70121_D.func_72314_b(5.0D, 5.0D, 5.0D));
/*     */     
/*     */     int j;
/*  86 */     for (j = 0; j < list.size(); j++) {
/*  87 */       MCH_EntitySeat seat = (MCH_EntitySeat)list.get(j);
/*  88 */       if (seat.getParent() != null && seat.getParent().getAcInfo() != null && seat.field_70121_D.func_72327_a(vec3, vec31) != null && (mCH_EntityGunner == null || player.func_70068_e((Entity)seat) < player.func_70068_e((Entity)mCH_EntityGunner))) {
/*  89 */         if (seat.field_70153_n instanceof MCH_EntityGunner) {
/*  90 */           Entity entity = seat.field_70153_n;
/*     */         } else {
/*  92 */           mCH_EntitySeat = seat;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*  97 */     if (mCH_EntitySeat == null) {
/*  98 */       list = player.field_70170_p.func_72872_a(MCH_EntityAircraft.class, player.field_70121_D.func_72314_b(5.0D, 5.0D, 5.0D));
/*     */       
/* 100 */       for (j = 0; j < list.size(); j++) {
/* 101 */         MCH_EntityAircraft ac = (MCH_EntityAircraft)list.get(j);
/* 102 */         if (!ac.isUAV() && ac.getAcInfo() != null && ac.field_70121_D.func_72327_a(vec3, vec31) != null && (mCH_EntitySeat == null || player.func_70068_e((Entity)ac) < player.func_70068_e((Entity)mCH_EntitySeat))) {
/* 103 */           if (ac.getRiddenByEntity() instanceof MCH_EntityGunner) {
/* 104 */             Entity entity = ac.getRiddenByEntity();
/*     */           } else {
/* 106 */             mCH_EntityAircraft = ac;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 112 */     return (Entity)mCH_EntityAircraft;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void draw(EntityPlayer player, Entity entity) {
/* 118 */     if (entity != null) {
/* 119 */       GL11.glEnable(3042);
/* 120 */       GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
/* 121 */       int srcBlend = GL11.glGetInteger(3041);
/* 122 */       int dstBlend = GL11.glGetInteger(3040);
/* 123 */       GL11.glBlendFunc(770, 771);
/*     */       
/*     */       double size;
/* 126 */       for (size = 512.0D; size < this.field_146294_l || size < this.field_146295_m; size *= 2.0D);
/*     */ 
/*     */       
/* 129 */       GL11.glBlendFunc(srcBlend, dstBlend);
/* 130 */       GL11.glDisable(3042);
/* 131 */       double factor = size / 512.0D;
/* 132 */       double SCALE_FACTOR = MCH_Gui.scaleFactor * factor;
/* 133 */       double CX = (this.field_146297_k.field_71443_c / 2);
/* 134 */       double CY = (this.field_146297_k.field_71440_d / 2);
/* 135 */       double px = (CX - 0.0D) / SCALE_FACTOR;
/* 136 */       double py = (CY + 0.0D) / SCALE_FACTOR;
/* 137 */       GL11.glPushMatrix();
/* 138 */       if (entity instanceof MCH_EntityGunner) {
/* 139 */         MCH_EntityGunner gunner = (MCH_EntityGunner)entity;
/* 140 */         String seatName = "";
/* 141 */         if (gunner.field_70154_o instanceof MCH_EntitySeat) {
/* 142 */           seatName = "(seat " + (((MCH_EntitySeat)gunner.field_70154_o).seatID + 2) + ")";
/* 143 */         } else if (gunner.field_70154_o instanceof MCH_EntityAircraft) {
/* 144 */           seatName = "(seat 1)";
/*     */         } 
/*     */         
/* 147 */         drawCenteredString(gunner.getTeamName() + " Gunner " + seatName, (int)px, (int)py + 20, -8355840);
/* 148 */         int S = 10;
/* 149 */         drawLine(new double[] { px - S, py - S, px + S, py - S, px + S, py + S, px - S, py + S }, -8355840, 2);
/*     */       
/*     */       }
/* 152 */       else if (entity instanceof MCH_EntitySeat) {
/* 153 */         MCH_EntitySeat seat = (MCH_EntitySeat)entity;
/* 154 */         if (seat.field_70153_n == null) {
/* 155 */           drawCenteredString("seat " + (seat.seatID + 2), (int)px, (int)py + 20, -16711681);
/* 156 */           byte S = 10;
/* 157 */           drawLine(new double[] { px - S, py - S, px + S, py - S, px + S, py + S, px - S, py + S }, -16711681, 2);
/*     */         } else {
/* 159 */           drawCenteredString("seat " + (seat.seatID + 2), (int)px, (int)py + 20, -65536);
/* 160 */           byte S = 10;
/* 161 */           drawLine(new double[] { px - S, py - S, px + S, py - S, px + S, py + S, px - S, py + S }, -65536, 2);
/* 162 */           drawLine(new double[] { px - S, py - S, px + S, py + S }, -65536);
/* 163 */           drawLine(new double[] { px + S, py - S, px - S, py + S }, -65536);
/*     */         } 
/* 165 */       } else if (entity instanceof MCH_EntityAircraft) {
/* 166 */         MCH_EntityAircraft ac = (MCH_EntityAircraft)entity;
/* 167 */         if (ac.getRiddenByEntity() == null) {
/* 168 */           drawCenteredString("seat 1", (int)px, (int)py + 20, -16711681);
/* 169 */           byte S = 10;
/* 170 */           drawLine(new double[] { px - S, py - S, px + S, py - S, px + S, py + S, px - S, py + S }, -16711681, 2);
/*     */         } else {
/* 172 */           drawCenteredString("seat 1", (int)px, (int)py + 20, -65536);
/* 173 */           byte S = 10;
/* 174 */           drawLine(new double[] { px - S, py - S, px + S, py - S, px + S, py + S, px - S, py + S }, -65536, 2);
/* 175 */           drawLine(new double[] { px - S, py - S, px + S, py + S }, -65536);
/* 176 */           drawLine(new double[] { px + S, py - S, px - S, py + S }, -65536);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 181 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\mob\MCH_GuiSpawnGunner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */