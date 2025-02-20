/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import java.util.List;
/*     */ import mcheli.MCH_CommonProxy;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.wrapper.W_EntityPlayer;
/*     */ import mcheli.wrapper.W_Item;
/*     */ import mcheli.wrapper.W_MovingObjectPosition;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockDispenser;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class MCH_ItemAircraft
/*     */   extends W_Item {
/*     */   public MCH_ItemAircraft(int i) {
/*  29 */     super(i);
/*     */   }
/*     */   private static boolean isRegistedDispenseBehavior = false;
/*     */   
/*     */   public void func_77624_a(ItemStack stack, EntityPlayer player, List<String> lines, boolean p_77624_4_) {
/*  34 */     MCH_EntityAircraft ac = createAircraft(player.field_70170_p, -1.0D, -1.0D, -1.0D, stack);
/*  35 */     if (ac != null && 
/*  36 */       ac.isNewUAV()) {
/*  37 */       lines.add(EnumChatFormatting.RED + "ОПАСНО!");
/*  38 */       lines.add(EnumChatFormatting.RED + "Этот дрон имеет новую механику БПЛА!");
/*  39 */       lines.add(EnumChatFormatting.RED + "Может содержать кучу багов!");
/*  40 */       lines.add(EnumChatFormatting.RED + "Очистите свой инвентарь перед использованием!");
/*     */     } 
/*     */     
/*  43 */     super.func_77624_a(stack, player, lines, p_77624_4_);
/*     */   }
/*     */   
/*     */   public static void registerDispenseBehavior(Item item) {
/*  47 */     if (!isRegistedDispenseBehavior) {
/*  48 */       BlockDispenser.field_149943_a.func_82595_a(item, new MCH_ItemAircraftDispenseBehavior());
/*     */     }
/*     */   }
/*     */   
/*     */   public abstract MCH_AircraftInfo getAircraftInfo();
/*     */   
/*     */   public abstract MCH_EntityAircraft createAircraft(World paramWorld, double paramDouble1, double paramDouble2, double paramDouble3, ItemStack paramItemStack);
/*     */   
/*     */   public MCH_EntityAircraft onTileClick(ItemStack itemStack, World world, float rotationYaw, int x, int y, int z) {
/*  57 */     MCH_EntityAircraft ac = createAircraft(world, (x + 0.5F), (y + 1.0F), (z + 0.5F), itemStack);
/*  58 */     if (ac == null) {
/*  59 */       return null;
/*     */     }
/*  61 */     ac.initRotationYaw((((MathHelper.func_76128_c((rotationYaw * 4.0F / 360.0F) + 0.5D) & 0x3) - 1) * 90));
/*  62 */     return !world.func_72945_a((Entity)ac, ac.field_70121_D.func_72314_b(-0.1D, -0.1D, -0.1D)).isEmpty() ? null : ac;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  67 */     MCH_AircraftInfo info = getAircraftInfo();
/*  68 */     return (info != null) ? (super.toString() + "(" + info.getDirectoryName() + ":" + info.name + ")") : (super.toString() + "(null)");
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack par1ItemStack, World world, EntityPlayer player) {
/*  73 */     float f = 1.0F;
/*  74 */     float f1 = player.field_70127_C + (player.field_70125_A - player.field_70127_C) * f;
/*  75 */     float f2 = player.field_70126_B + (player.field_70177_z - player.field_70126_B) * f;
/*  76 */     double d0 = player.field_70169_q + (player.field_70165_t - player.field_70169_q) * f;
/*  77 */     double d1 = player.field_70167_r + (player.field_70163_u - player.field_70167_r) * f + 1.62D - player.field_70129_M;
/*  78 */     double d2 = player.field_70166_s + (player.field_70161_v - player.field_70166_s) * f;
/*  79 */     Vec3 vec3 = W_WorldFunc.getWorldVec3(world, d0, d1, d2);
/*  80 */     float f3 = MathHelper.func_76134_b(-f2 * 0.017453292F - 3.1415927F);
/*  81 */     float f4 = MathHelper.func_76126_a(-f2 * 0.017453292F - 3.1415927F);
/*  82 */     float f5 = -MathHelper.func_76134_b(-f1 * 0.017453292F);
/*  83 */     float f6 = MathHelper.func_76126_a(-f1 * 0.017453292F);
/*  84 */     float f7 = f4 * f5;
/*  85 */     float f8 = f3 * f5;
/*  86 */     double d3 = 5.0D;
/*  87 */     Vec3 vec31 = vec3.func_72441_c(f7 * d3, f6 * d3, f8 * d3);
/*  88 */     MovingObjectPosition mop = W_WorldFunc.clip(world, vec3, vec31, true);
/*  89 */     if (mop == null) {
/*  90 */       return par1ItemStack;
/*     */     }
/*  92 */     Vec3 vec32 = player.func_70676_i(f);
/*  93 */     boolean flag = false;
/*  94 */     float f9 = 1.0F;
/*  95 */     List<Entity> list = world.func_72839_b((Entity)player, player.field_70121_D.func_72321_a(vec32.field_72450_a * d3, vec32.field_72448_b * d3, vec32.field_72449_c * d3).func_72314_b(f9, f9, f9));
/*     */     
/*  97 */     for (int i = 0; i < list.size(); i++) {
/*  98 */       Entity block = list.get(i);
/*  99 */       if (block.func_70067_L()) {
/* 100 */         float f10 = block.func_70111_Y();
/* 101 */         AxisAlignedBB axisalignedbb = block.field_70121_D.func_72314_b(f10, f10, f10);
/* 102 */         if (axisalignedbb.func_72318_a(vec3)) {
/* 103 */           flag = true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 108 */     if (flag) {
/* 109 */       return par1ItemStack;
/*     */     }
/* 111 */     if (W_MovingObjectPosition.isHitTypeTile(mop)) {
/* 112 */       MCH_Config var10000 = MCH_MOD.config;
/* 113 */       if (MCH_Config.PlaceableOnSpongeOnly.prmBool) {
/* 114 */         Block var32 = world.func_147439_a(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d);
/* 115 */         if (!(var32 instanceof net.minecraft.block.BlockSponge)) {
/* 116 */           return par1ItemStack;
/*     */         }
/*     */       } 
/* 119 */       if (!MCH_CommonProxy.checkSafeZone(player)) {
/* 120 */         spawnAircraft(par1ItemStack, world, player, mop.field_72311_b, mop.field_72312_c, mop.field_72309_d);
/*     */       } else {
/* 122 */         player.func_145747_a((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "Спавн техники на сейф-зоне запрещен"));
/*     */       } 
/*     */     } 
/*     */     
/* 126 */     return par1ItemStack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MCH_EntityAircraft spawnAircraft(ItemStack itemStack, World world, EntityPlayer player, int x, int y, int z) {
/* 132 */     MCH_EntityAircraft ac = onTileClick(itemStack, world, player.field_70177_z, x, y, z);
/* 133 */     if (ac != null) {
/* 134 */       if (ac.isUAV() || ac.isNewUAV()) {
/* 135 */         if (world.field_72995_K) {
/* 136 */           if (ac.isSmallUAV()) {
/* 137 */             W_EntityPlayer.addChatMessage(player, "Please use the UAV station OR Portable Controller");
/*     */           } else {
/* 139 */             W_EntityPlayer.addChatMessage(player, "Please use the UAV station");
/*     */           } 
/*     */         }
/*     */         
/* 143 */         ac = null;
/*     */       } else {
/* 145 */         if (!world.field_72995_K) {
/* 146 */           ac.getAcDataFromItem(itemStack);
/* 147 */           world.func_72838_d((Entity)ac);
/*     */         } 
/*     */         
/* 150 */         if (!player.field_71075_bZ.field_75098_d) {
/* 151 */           itemStack.field_77994_a--;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 156 */     return ac;
/*     */   }
/*     */   
/*     */   public void rideEntity(ItemStack item, Entity target, EntityPlayer player) {
/* 160 */     MCH_Config var10000 = MCH_MOD.config;
/* 161 */     if (!MCH_CommonProxy.checkSafeZone(player) && 
/* 162 */       !MCH_Config.PlaceableOnSpongeOnly.prmBool && target instanceof net.minecraft.entity.item.EntityMinecartEmpty && target.field_70153_n == null) {
/* 163 */       MCH_EntityAircraft ac = spawnAircraft(item, player.field_70170_p, player, (int)target.field_70165_t, (int)target.field_70163_u + 2, (int)target.field_70161_v);
/* 164 */       if (!player.field_70170_p.field_72995_K && ac != null)
/* 165 */         ac.func_70078_a(target); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_ItemAircraft.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */