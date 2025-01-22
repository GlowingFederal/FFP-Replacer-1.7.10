package com.flansmod.common.paintjob;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.guns.InventoryHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPaintjobTable extends BlockContainer {
  private IIcon side;
  
  private IIcon top;
  
  public BlockPaintjobTable() {
    super(Material.field_151576_e);
    func_149711_c(2.0F);
    func_149752_b(4.0F);
    func_149663_c("paintjobTable");
    func_149647_a((CreativeTabs)FlansMod.tabFlanGuns);
  }
  
  public boolean func_149742_c(World world, int x, int y, int z) {
    return World.func_147466_a((IBlockAccess)world, x, y - 1, z);
  }
  
  public TileEntity func_149915_a(World world, int i) {
    return new TileEntityPaintjobTable();
  }
  
  public IIcon func_149691_a(int i, int j) {
    if (i == 1)
      return this.top; 
    return this.side;
  }
  
  public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int facing, float par7, float par8, float par9) {
    if (world.field_72995_K) {
      (PlayerHandler.getPlayerData(player, Side.CLIENT)).shootTimeLeft = (PlayerHandler.getPlayerData(player, Side.CLIENT)).shootTimeRight = 10.0F;
      return true;
    } 
    TileEntityPaintjobTable table = (TileEntityPaintjobTable)world.func_147438_o(x, y, z);
    if (!world.field_72995_K)
      player.openGui(FlansMod.INSTANCE, 13, world, x, y, z); 
    return true;
  }
  
  public void func_149749_a(World worldIn, int x, int y, int z, Block block, int meta) {
    TileEntity tileentity = worldIn.func_147438_o(x, y, z);
    if (tileentity instanceof IInventory)
      InventoryHelper.dropInventoryItems(worldIn, x, y, z, (IInventory)tileentity); 
    super.func_149749_a(worldIn, x, y, z, block, meta);
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149651_a(IIconRegister register) {
    this.top = register.func_94245_a("FlansMod:paintjobTableTop");
    this.side = register.func_94245_a("FlansMod:planeCraftingTableSide");
  }
}
