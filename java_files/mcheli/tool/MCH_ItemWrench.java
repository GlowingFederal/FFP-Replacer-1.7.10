/*     */ package mcheli.tool;
/*     */ 
/*     */ import com.google.common.collect.Multimap;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.wrapper.W_Item;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class MCH_ItemWrench
/*     */   extends W_Item
/*     */ {
/*     */   private float damageVsEntity;
/*     */   private final Item.ToolMaterial toolMaterial;
/*  35 */   private static Random rand = new Random();
/*     */ 
/*     */   
/*     */   public MCH_ItemWrench(int itemId, Item.ToolMaterial material) {
/*  39 */     super(itemId);
/*  40 */     this.toolMaterial = material;
/*  41 */     this.field_77777_bU = 1;
/*  42 */     func_77656_e(material.func_77997_a());
/*  43 */     this.damageVsEntity = 4.0F + material.func_78000_c();
/*     */   }
/*     */   
/*     */   public boolean func_150897_b(Block b) {
/*  47 */     Material material = b.func_149688_o();
/*  48 */     return (material == Material.field_151573_f) ? true : (material instanceof net.minecraft.block.material.MaterialLogic);
/*     */   }
/*     */   
/*     */   public float func_150893_a(ItemStack itemStack, Block block) {
/*  52 */     Material material = block.func_149688_o();
/*  53 */     return (material == Material.field_151573_f) ? 20.5F : ((material instanceof net.minecraft.block.material.MaterialLogic) ? 5.5F : 2.0F);
/*     */   }
/*     */   
/*     */   public static int getUseAnimCount(ItemStack stack) {
/*  57 */     return getAnimCount(stack, "MCH_WrenchAnim");
/*     */   }
/*     */   
/*     */   public static void setUseAnimCount(ItemStack stack, int n) {
/*  61 */     setAnimCount(stack, "MCH_WrenchAnim", n);
/*     */   }
/*     */   
/*     */   public static int getAnimCount(ItemStack stack, String name) {
/*  65 */     if (!stack.func_77942_o()) {
/*  66 */       stack.field_77990_d = new NBTTagCompound();
/*     */     }
/*     */     
/*  69 */     if (stack.field_77990_d.func_74764_b(name)) {
/*  70 */       return stack.field_77990_d.func_74762_e(name);
/*     */     }
/*  72 */     stack.field_77990_d.func_74768_a(name, 0);
/*  73 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setAnimCount(ItemStack stack, String name, int n) {
/*  78 */     if (!stack.func_77942_o()) {
/*  79 */       stack.field_77990_d = new NBTTagCompound();
/*     */     }
/*     */     
/*  82 */     stack.field_77990_d.func_74768_a(name, n);
/*     */   }
/*     */   
/*     */   public boolean func_77644_a(ItemStack itemStack, EntityLivingBase entity, EntityLivingBase player) {
/*  86 */     if (!player.field_70170_p.field_72995_K) {
/*  87 */       if (rand.nextInt(40) == 0) {
/*  88 */         entity.func_70099_a(new ItemStack(W_Item.getItemByName("iron_ingot"), 1, 0), 0.0F);
/*  89 */       } else if (rand.nextInt(20) == 0) {
/*  90 */         entity.func_70099_a(new ItemStack(W_Item.getItemByName("gunpowder"), 1, 0), 0.0F);
/*     */       } 
/*     */     }
/*     */     
/*  94 */     itemStack.func_77972_a(2, player);
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   public void func_77615_a(ItemStack stack, World world, EntityPlayer player, int count) {
/*  99 */     setUseAnimCount(stack, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
/* 104 */     if (player.field_70170_p.field_72995_K) {
/* 105 */       MCH_EntityAircraft ac = getMouseOverAircraft(player);
/* 106 */       if (ac != null) {
/* 107 */         int cnt = getUseAnimCount(stack);
/* 108 */         if (cnt <= 0) {
/* 109 */           cnt = 16;
/*     */         } else {
/* 111 */           cnt--;
/*     */         } 
/*     */         
/* 114 */         setUseAnimCount(stack, cnt);
/*     */       } 
/*     */     } 
/*     */     
/* 118 */     if (!player.field_70170_p.field_72995_K && count < func_77626_a(stack) && count % 20 == 0) {
/* 119 */       MCH_EntityAircraft ac = getMouseOverAircraft(player);
/* 120 */       if (ac != null && ac.getHP() > 0 && ac.repair(10)) {
/* 121 */         stack.func_77972_a(1, (EntityLivingBase)player);
/* 122 */         W_WorldFunc.MOD_playSoundEffect(player.field_70170_p, (int)ac.field_70165_t, (int)ac.field_70163_u, (int)ac.field_70161_v, "wrench", 1.0F, 0.9F + rand.nextFloat() * 0.2F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_77663_a(ItemStack item, World world, Entity entity, int n, boolean b) {
/* 129 */     if (entity instanceof EntityPlayer) {
/* 130 */       EntityPlayer player = (EntityPlayer)entity;
/* 131 */       ItemStack itemStack = player.func_71045_bC();
/* 132 */       if (itemStack == item) {
/* 133 */         MCH_MOD.proxy.setCreativeDigDelay(0);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public MCH_EntityAircraft getMouseOverAircraft(EntityPlayer player) {
/* 140 */     MovingObjectPosition m = getMouseOver((EntityLivingBase)player, 1.0F);
/* 141 */     MCH_EntityAircraft ac = null;
/* 142 */     if (m != null) {
/* 143 */       if (m.field_72308_g instanceof MCH_EntityAircraft) {
/* 144 */         ac = (MCH_EntityAircraft)m.field_72308_g;
/* 145 */       } else if (m.field_72308_g instanceof MCH_EntitySeat) {
/* 146 */         MCH_EntitySeat seat = (MCH_EntitySeat)m.field_72308_g;
/* 147 */         if (seat.getParent() != null) {
/* 148 */           ac = seat.getParent();
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 153 */     return ac;
/*     */   }
/*     */   
/*     */   private static MovingObjectPosition rayTrace(EntityLivingBase entity, double dist, float tick) {
/* 157 */     Vec3 vec3 = Vec3.func_72443_a(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v);
/* 158 */     Vec3 vec31 = entity.func_70676_i(tick);
/* 159 */     Vec3 vec32 = vec3.func_72441_c(vec31.field_72450_a * dist, vec31.field_72448_b * dist, vec31.field_72449_c * dist);
/* 160 */     return entity.field_70170_p.func_147447_a(vec3, vec32, false, false, true);
/*     */   }
/*     */   
/*     */   private MovingObjectPosition getMouseOver(EntityLivingBase user, float tick) {
/* 164 */     Entity pointedEntity = null;
/* 165 */     double d0 = 4.0D;
/* 166 */     MovingObjectPosition objectMouseOver = rayTrace(user, d0, tick);
/* 167 */     double d1 = d0;
/* 168 */     Vec3 vec3 = Vec3.func_72443_a(user.field_70165_t, user.field_70163_u + user.func_70047_e(), user.field_70161_v);
/* 169 */     if (objectMouseOver != null) {
/* 170 */       d1 = objectMouseOver.field_72307_f.func_72438_d(vec3);
/*     */     }
/*     */     
/* 173 */     Vec3 vec31 = user.func_70676_i(tick);
/* 174 */     Vec3 vec32 = vec3.func_72441_c(vec31.field_72450_a * d0, vec31.field_72448_b * d0, vec31.field_72449_c * d0);
/* 175 */     pointedEntity = null;
/* 176 */     Vec3 vec33 = null;
/* 177 */     float f1 = 1.0F;
/* 178 */     List<Entity> list = user.field_70170_p.func_72839_b((Entity)user, user.field_70121_D.func_72321_a(vec31.field_72450_a * d0, vec31.field_72448_b * d0, vec31.field_72449_c * d0).func_72314_b(f1, f1, f1));
/* 179 */     double d2 = d1;
/*     */     
/* 181 */     for (int i = 0; i < list.size(); i++) {
/* 182 */       Entity entity = list.get(i);
/* 183 */       if (entity.func_70067_L()) {
/* 184 */         float f2 = entity.func_70111_Y();
/* 185 */         AxisAlignedBB axisalignedbb = entity.field_70121_D.func_72314_b(f2, f2, f2);
/* 186 */         MovingObjectPosition movingobjectposition = axisalignedbb.func_72327_a(vec3, vec32);
/* 187 */         if (axisalignedbb.func_72318_a(vec3)) {
/* 188 */           if (0.0D < d2 || d2 == 0.0D) {
/* 189 */             pointedEntity = entity;
/* 190 */             vec33 = (movingobjectposition == null) ? vec3 : movingobjectposition.field_72307_f;
/* 191 */             d2 = 0.0D;
/*     */           } 
/* 193 */         } else if (movingobjectposition != null) {
/* 194 */           double d3 = vec3.func_72438_d(movingobjectposition.field_72307_f);
/* 195 */           if (d3 < d2 || d2 == 0.0D) {
/* 196 */             if (entity == user.field_70154_o && !entity.canRiderInteract()) {
/* 197 */               if (d2 == 0.0D) {
/* 198 */                 pointedEntity = entity;
/* 199 */                 vec33 = movingobjectposition.field_72307_f;
/*     */               } 
/*     */             } else {
/* 202 */               pointedEntity = entity;
/* 203 */               vec33 = movingobjectposition.field_72307_f;
/* 204 */               d2 = d3;
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 211 */     if (pointedEntity != null && (d2 < d1 || objectMouseOver == null)) {
/* 212 */       objectMouseOver = new MovingObjectPosition(pointedEntity, vec33);
/*     */     }
/*     */     
/* 215 */     return objectMouseOver;
/*     */   }
/*     */   
/*     */   public boolean func_150894_a(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
/* 219 */     if (block.func_149712_f(world, x, y, z) != 0.0D) {
/* 220 */       itemStack.func_77972_a(2, entity);
/*     */     }
/*     */     
/* 223 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77662_d() {
/* 228 */     return true;
/*     */   }
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack itemStack) {
/* 232 */     return EnumAction.block;
/*     */   }
/*     */   
/*     */   public int func_77626_a(ItemStack itemStack) {
/* 236 */     return 72000;
/*     */   }
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack itemStack, World world, EntityPlayer player) {
/* 240 */     player.func_71008_a(itemStack, func_77626_a(itemStack));
/* 241 */     return itemStack;
/*     */   }
/*     */   
/*     */   public int func_77619_b() {
/* 245 */     return this.toolMaterial.func_77995_e();
/*     */   }
/*     */   
/*     */   public String getToolMaterialName() {
/* 249 */     return this.toolMaterial.toString();
/*     */   }
/*     */   
/*     */   public boolean func_82789_a(ItemStack item1, ItemStack item2) {
/* 253 */     return (this.toolMaterial.func_150995_f() == item2.func_77973_b()) ? true : super.func_82789_a(item1, item2);
/*     */   }
/*     */   
/*     */   public Multimap func_111205_h() {
/* 257 */     Multimap multimap = super.func_111205_h();
/* 258 */     multimap.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(Item.field_111210_e, "Weapon modifier", this.damageVsEntity, 0));
/* 259 */     return multimap;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tool\MCH_ItemWrench.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */