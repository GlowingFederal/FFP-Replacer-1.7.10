/*     */ package mcheli.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.wrapper.IconRegister;
/*     */ import mcheli.wrapper.W_BlockContainer;
/*     */ import mcheli.wrapper.W_Item;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.ITileEntityProvider;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_DraftingTableBlock
/*     */   extends W_BlockContainer
/*     */   implements ITileEntityProvider
/*     */ {
/*     */   private final boolean isLighting;
/*     */   
/*     */   public MCH_DraftingTableBlock(int blockId, boolean p_i45421_1_) {
/*  31 */     super(blockId, Material.field_151573_f);
/*  32 */     func_149672_a(Block.field_149777_j);
/*  33 */     func_149711_c(0.2F);
/*  34 */     this.isLighting = p_i45421_1_;
/*  35 */     if (p_i45421_1_) {
/*  36 */       func_149715_a(1.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
/*  42 */     if (!world.field_72995_K) {
/*  43 */       if (!player.func_70093_af()) {
/*  44 */         MCH_Lib.DbgLog(player.field_70170_p, "MCH_DraftingTableGui.MCH_DraftingTableGui OPEN GUI (%d, %d, %d)", new Object[] { Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(z) });
/*  45 */         player.openGui(MCH_MOD.instance, 4, world, x, y, z);
/*     */       } else {
/*  47 */         int yaw = world.func_72805_g(x, y, z);
/*  48 */         MCH_Lib.DbgLog(world, "MCH_DraftingTableBlock.onBlockActivated:yaw=%d Light %s", new Object[] { Integer.valueOf(yaw), this.isLighting ? "OFF->ON" : "ON->OFF" });
/*  49 */         if (this.isLighting) {
/*  50 */           W_WorldFunc.setBlock(world, x, y, z, (Block)MCH_MOD.blockDraftingTable, yaw + 180, 2);
/*     */         } else {
/*  52 */           W_WorldFunc.setBlock(world, x, y, z, (Block)MCH_MOD.blockDraftingTableLit, yaw + 180, 2);
/*     */         } 
/*     */         
/*  55 */         world.func_72921_c(x, y, z, yaw, 2);
/*  56 */         world.func_72908_a(x + 0.5D, y + 0.5D, z + 0.5D, "random.click", 0.3F, 0.5F);
/*     */       } 
/*     */     }
/*     */     
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int a) {
/*  64 */     return new MCH_DraftingTableTileEntity();
/*     */   }
/*     */   
/*     */   public TileEntity createNewTileEntity(World world) {
/*  68 */     return new MCH_DraftingTableTileEntity();
/*     */   }
/*     */   
/*     */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/*  72 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d() {
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c() {
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public boolean canHarvestBlock(EntityPlayer player, int meta) {
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   public boolean canRenderInPass(int pass) {
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int func_149656_h() {
/*  92 */     return 1;
/*     */   }
/*     */   
/*     */   public void func_149689_a(World world, int par2, int par3, int par4, EntityLivingBase entity, ItemStack itemStack) {
/*  96 */     float pyaw = (float)MCH_Lib.getRotate360(entity.field_70177_z);
/*  97 */     pyaw += 22.5F;
/*  98 */     int yaw = (int)(pyaw / 45.0F);
/*  99 */     if (yaw < 0) {
/* 100 */       yaw = yaw % 8 + 8;
/*     */     }
/*     */     
/* 103 */     world.func_72921_c(par2, par3, par4, yaw, 2);
/* 104 */     MCH_Lib.DbgLog(world, "MCH_DraftingTableBlock.onBlockPlacedBy:yaw=%d", new Object[] { Integer.valueOf(yaw) });
/*     */   }
/*     */   
/*     */   public boolean func_149710_n() {
/* 108 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister par1IconRegister) {
/* 113 */     this.field_149761_L = par1IconRegister.func_94245_a("mcheli:drafting_table");
/*     */   }
/*     */   
/*     */   public void registerIcons(IconRegister par1IconRegister) {
/* 117 */     this.field_149761_L = par1IconRegister.registerIcon("mcheli:drafting_table");
/*     */   }
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 121 */     return W_Item.getItemFromBlock((Block)MCH_MOD.blockDraftingTable);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_149694_d(World world, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
/* 126 */     return W_Item.getItemFromBlock((Block)MCH_MOD.blockDraftingTable);
/*     */   }
/*     */   
/*     */   protected ItemStack func_149644_j(int p_149644_1_) {
/* 130 */     return new ItemStack((Block)MCH_MOD.blockDraftingTable);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\block\MCH_DraftingTableBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */