/*     */ package mcheli.mob;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.wrapper.W_Item;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.scoreboard.ScorePlayerTeam;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_ItemSpawnGunner
/*     */   extends W_Item {
/*  26 */   public int primaryColor = 16777215;
/*  27 */   public int secondaryColor = 16777215;
/*  28 */   public int targetType = 0;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon theIcon;
/*     */   
/*     */   public MCH_ItemSpawnGunner() {
/*  33 */     this.field_77777_bU = 1;
/*  34 */     func_77637_a(CreativeTabs.field_78029_e); } public ItemStack func_77659_a(ItemStack itemStack, World world, EntityPlayer player) {
/*     */     MCH_EntityGunner mCH_EntityGunner;
/*     */     MCH_EntitySeat mCH_EntitySeat;
/*     */     MCH_EntityAircraft mCH_EntityAircraft;
/*  38 */     float f = 1.0F;
/*  39 */     float pitch = player.field_70127_C + (player.field_70125_A - player.field_70127_C) * f;
/*  40 */     float yaw = player.field_70126_B + (player.field_70177_z - player.field_70126_B) * f;
/*  41 */     double dx = player.field_70169_q + (player.field_70165_t - player.field_70169_q) * f;
/*  42 */     double dy = player.field_70167_r + (player.field_70163_u - player.field_70167_r) * f + 1.62D - player.field_70129_M;
/*  43 */     double dz = player.field_70166_s + (player.field_70161_v - player.field_70166_s) * f;
/*  44 */     Vec3 vec3 = Vec3.func_72443_a(dx, dy, dz);
/*  45 */     float f3 = MathHelper.func_76134_b(-yaw * 0.017453292F - 3.1415927F);
/*  46 */     float f4 = MathHelper.func_76126_a(-yaw * 0.017453292F - 3.1415927F);
/*  47 */     float f5 = -MathHelper.func_76134_b(-pitch * 0.017453292F);
/*  48 */     float f6 = MathHelper.func_76126_a(-pitch * 0.017453292F);
/*  49 */     float f7 = f4 * f5;
/*  50 */     float f8 = f3 * f5;
/*  51 */     double d3 = 5.0D;
/*  52 */     Vec3 vec31 = vec3.func_72441_c(f7 * d3, f6 * d3, f8 * d3);
/*  53 */     List<MCH_EntityGunner> list = world.func_72872_a(MCH_EntityGunner.class, player.field_70121_D.func_72314_b(5.0D, 5.0D, 5.0D));
/*  54 */     Entity target = null;
/*     */     
/*     */     int i;
/*  57 */     for (i = 0; i < list.size(); i++) {
/*  58 */       MCH_EntityGunner gunner = list.get(i);
/*  59 */       if (gunner.field_70121_D.func_72327_a(vec3, vec31) != null && (target == null || player.func_70068_e((Entity)gunner) < player.func_70068_e(target))) {
/*  60 */         mCH_EntityGunner = gunner;
/*     */       }
/*     */     } 
/*     */     
/*  64 */     if (mCH_EntityGunner == null) {
/*  65 */       list = world.func_72872_a(MCH_EntitySeat.class, player.field_70121_D.func_72314_b(5.0D, 5.0D, 5.0D));
/*     */       
/*  67 */       for (i = 0; i < list.size(); i++) {
/*  68 */         MCH_EntitySeat seat = (MCH_EntitySeat)list.get(i);
/*  69 */         if (seat.getParent() != null && seat.getParent().getAcInfo() != null && seat.field_70121_D.func_72327_a(vec3, vec31) != null && (mCH_EntityGunner == null || player.func_70068_e((Entity)seat) < player.func_70068_e((Entity)mCH_EntityGunner))) {
/*  70 */           if (seat.field_70153_n instanceof MCH_EntityGunner) {
/*  71 */             Entity entity = seat.field_70153_n;
/*     */           } else {
/*  73 */             mCH_EntitySeat = seat;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  79 */     if (mCH_EntitySeat == null) {
/*  80 */       list = world.func_72872_a(MCH_EntityAircraft.class, player.field_70121_D.func_72314_b(5.0D, 5.0D, 5.0D));
/*     */       
/*  82 */       for (i = 0; i < list.size(); i++) {
/*  83 */         MCH_EntityAircraft ac = (MCH_EntityAircraft)list.get(i);
/*  84 */         if (!ac.isUAV() && ac.getAcInfo() != null && ac.field_70121_D.func_72327_a(vec3, vec31) != null && (mCH_EntitySeat == null || player.func_70068_e((Entity)ac) < player.func_70068_e((Entity)mCH_EntitySeat))) {
/*  85 */           if (ac.getRiddenByEntity() instanceof MCH_EntityGunner) {
/*  86 */             Entity entity = ac.getRiddenByEntity();
/*     */           } else {
/*  88 */             mCH_EntityAircraft = ac;
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     if (mCH_EntityAircraft instanceof MCH_EntityGunner) {
/*  95 */       mCH_EntityAircraft.func_130002_c(player);
/*  96 */       return itemStack;
/*  97 */     }  if (this.targetType == 1 && !world.field_72995_K && player.func_96124_cp() == null) {
/*  98 */       player.func_145747_a((IChatComponent)new ChatComponentText("You are not on team."));
/*  99 */       return itemStack;
/* 100 */     }  if (mCH_EntityAircraft == null) {
/* 101 */       if (!world.field_72995_K) {
/* 102 */         player.func_145747_a((IChatComponent)new ChatComponentText("Right click to seat."));
/*     */       }
/*     */       
/* 105 */       return itemStack;
/*     */     } 
/* 107 */     if (!world.field_72995_K) {
/* 108 */       MCH_EntityGunner gunner = new MCH_EntityGunner(world, ((Entity)mCH_EntityAircraft).field_70165_t, ((Entity)mCH_EntityAircraft).field_70163_u, ((Entity)mCH_EntityAircraft).field_70161_v);
/* 109 */       gunner.field_70177_z = (((MathHelper.func_76128_c((player.field_70177_z * 4.0F / 360.0F) + 0.5D) & 0x3) - 1) * 90);
/* 110 */       gunner.isCreative = player.field_71075_bZ.field_75098_d;
/* 111 */       gunner.targetType = this.targetType;
/* 112 */       gunner.ownerUUID = player.func_110124_au().toString();
/* 113 */       ScorePlayerTeam team = world.func_96441_U().func_96509_i(player.getDisplayName());
/* 114 */       if (team != null) {
/* 115 */         gunner.setTeamName(team.func_96661_b());
/*     */       }
/*     */       
/* 118 */       world.func_72838_d((Entity)gunner);
/* 119 */       gunner.func_70078_a((Entity)mCH_EntityAircraft);
/* 120 */       W_WorldFunc.MOD_playSoundAtEntity((Entity)gunner, "wrench", 1.0F, 3.0F);
/* 121 */       MCH_EntityAircraft ac = (mCH_EntityAircraft instanceof MCH_EntityAircraft) ? mCH_EntityAircraft : ((MCH_EntitySeat)mCH_EntityAircraft).getParent();
/* 122 */       player.func_145747_a((IChatComponent)new ChatComponentText("The gunner was put on " + EnumChatFormatting.GOLD + (ac.getAcInfo()).displayName + EnumChatFormatting.RESET + " seat " + (ac.getSeatIdByEntity((Entity)gunner) + 1) + " by " + ScorePlayerTeam.func_96667_a(player.func_96124_cp(), player.getDisplayName())));
/*     */     } 
/*     */     
/* 125 */     if (!player.field_71075_bZ.field_75098_d) {
/* 126 */       itemStack.field_77994_a--;
/*     */     }
/*     */     
/* 129 */     return itemStack;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack itemStack, int layer) {
/* 135 */     return (layer == 0) ? this.primaryColor : this.secondaryColor;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77623_v() {
/* 140 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_77618_c(int p_77618_1_, int p_77618_2_) {
/* 145 */     return (p_77618_2_ > 0) ? this.theIcon : super.func_77618_c(p_77618_1_, p_77618_2_);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IIconRegister icon) {
/* 150 */     super.func_94581_a(icon);
/* 151 */     this.theIcon = icon.func_94245_a(func_111208_A() + "_overlay");
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\mob\MCH_ItemSpawnGunner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */