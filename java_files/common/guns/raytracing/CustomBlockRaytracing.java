package com.flansmod.common.guns.raytracing;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class CustomBlockRaytracing {
  public static MovingObjectPosition func_147447_a(World w, Vec3 p_147447_1_, Vec3 p_147447_2_, boolean p_147447_3_, boolean p_147447_4_, boolean p_147447_5_) {
    if (!Double.isNaN(p_147447_1_.field_72450_a) && !Double.isNaN(p_147447_1_.field_72448_b) && !Double.isNaN(p_147447_1_.field_72449_c)) {
      if (!Double.isNaN(p_147447_2_.field_72450_a) && !Double.isNaN(p_147447_2_.field_72448_b) && !Double.isNaN(p_147447_2_.field_72449_c)) {
        int i = MathHelper.func_76128_c(p_147447_2_.field_72450_a);
        int j = MathHelper.func_76128_c(p_147447_2_.field_72448_b);
        int k = MathHelper.func_76128_c(p_147447_2_.field_72449_c);
        int l = MathHelper.func_76128_c(p_147447_1_.field_72450_a);
        int i1 = MathHelper.func_76128_c(p_147447_1_.field_72448_b);
        int j1 = MathHelper.func_76128_c(p_147447_1_.field_72449_c);
        Block block = w.func_147439_a(l, i1, j1);
        int k1 = w.func_72805_g(l, i1, j1);
        boolean doWeIgnoreThisBlock = false;
        if (block instanceof net.minecraft.block.BlockLeaves || block instanceof net.minecraft.block.BlockGlass || block instanceof net.minecraft.block.BlockStainedGlass || block instanceof net.minecraft.block.BlockStainedGlassPane || block instanceof net.minecraft.block.BlockPane)
          doWeIgnoreThisBlock = true; 
        if (!doWeIgnoreThisBlock && (!p_147447_4_ || block.func_149668_a(w, l, i1, j1) != null) && block.func_149678_a(k1, p_147447_3_)) {
          MovingObjectPosition movingobjectposition = block.func_149731_a(w, l, i1, j1, p_147447_1_, p_147447_2_);
          if (movingobjectposition != null)
            return movingobjectposition; 
        } 
        MovingObjectPosition movingobjectposition2 = null;
        k1 = 200;
        while (k1-- >= 0) {
          byte b0;
          if (Double.isNaN(p_147447_1_.field_72450_a) || Double.isNaN(p_147447_1_.field_72448_b) || Double.isNaN(p_147447_1_.field_72449_c))
            return null; 
          if (l == i && i1 == j && j1 == k)
            return p_147447_5_ ? movingobjectposition2 : null; 
          boolean flag6 = true;
          boolean flag3 = true;
          boolean flag4 = true;
          double d0 = 999.0D;
          double d1 = 999.0D;
          double d2 = 999.0D;
          if (i > l) {
            d0 = l + 1.0D;
          } else if (i < l) {
            d0 = l + 0.0D;
          } else {
            flag6 = false;
          } 
          if (j > i1) {
            d1 = i1 + 1.0D;
          } else if (j < i1) {
            d1 = i1 + 0.0D;
          } else {
            flag3 = false;
          } 
          if (k > j1) {
            d2 = j1 + 1.0D;
          } else if (k < j1) {
            d2 = j1 + 0.0D;
          } else {
            flag4 = false;
          } 
          double d3 = 999.0D;
          double d4 = 999.0D;
          double d5 = 999.0D;
          double d6 = p_147447_2_.field_72450_a - p_147447_1_.field_72450_a;
          double d7 = p_147447_2_.field_72448_b - p_147447_1_.field_72448_b;
          double d8 = p_147447_2_.field_72449_c - p_147447_1_.field_72449_c;
          if (flag6)
            d3 = (d0 - p_147447_1_.field_72450_a) / d6; 
          if (flag3)
            d4 = (d1 - p_147447_1_.field_72448_b) / d7; 
          if (flag4)
            d5 = (d2 - p_147447_1_.field_72449_c) / d8; 
          boolean flag5 = false;
          if (d3 < d4 && d3 < d5) {
            if (i > l) {
              b0 = 4;
            } else {
              b0 = 5;
            } 
            p_147447_1_.field_72450_a = d0;
            p_147447_1_.field_72448_b += d7 * d3;
            p_147447_1_.field_72449_c += d8 * d3;
          } else if (d4 < d5) {
            if (j > i1) {
              b0 = 0;
            } else {
              b0 = 1;
            } 
            p_147447_1_.field_72450_a += d6 * d4;
            p_147447_1_.field_72448_b = d1;
            p_147447_1_.field_72449_c += d8 * d4;
          } else {
            if (k > j1) {
              b0 = 2;
            } else {
              b0 = 3;
            } 
            p_147447_1_.field_72450_a += d6 * d5;
            p_147447_1_.field_72448_b += d7 * d5;
            p_147447_1_.field_72449_c = d2;
          } 
          Vec3 vec32 = Vec3.func_72443_a(p_147447_1_.field_72450_a, p_147447_1_.field_72448_b, p_147447_1_.field_72449_c);
          l = (int)(vec32.field_72450_a = MathHelper.func_76128_c(p_147447_1_.field_72450_a));
          if (b0 == 5) {
            l--;
            vec32.field_72450_a++;
          } 
          i1 = (int)(vec32.field_72448_b = MathHelper.func_76128_c(p_147447_1_.field_72448_b));
          if (b0 == 1) {
            i1--;
            vec32.field_72448_b++;
          } 
          j1 = (int)(vec32.field_72449_c = MathHelper.func_76128_c(p_147447_1_.field_72449_c));
          if (b0 == 3) {
            j1--;
            vec32.field_72449_c++;
          } 
          Block block1 = w.func_147439_a(l, i1, j1);
          int l1 = w.func_72805_g(l, i1, j1);
          doWeIgnoreThisBlock = false;
          if (block1 instanceof net.minecraft.block.BlockLeaves || block1 instanceof net.minecraft.block.BlockGlass || block1 instanceof net.minecraft.block.BlockStainedGlass || block1 instanceof net.minecraft.block.BlockStainedGlassPane || block1 instanceof net.minecraft.block.BlockPane)
            doWeIgnoreThisBlock = true; 
          if (!doWeIgnoreThisBlock && (!p_147447_4_ || block1.func_149668_a(w, l, i1, j1) != null)) {
            if (block1.func_149678_a(l1, p_147447_3_)) {
              MovingObjectPosition movingobjectposition1 = block1.func_149731_a(w, l, i1, j1, p_147447_1_, p_147447_2_);
              if (movingobjectposition1 != null)
                return movingobjectposition1; 
              continue;
            } 
            movingobjectposition2 = new MovingObjectPosition(l, i1, j1, b0, p_147447_1_, false);
          } 
        } 
        return p_147447_5_ ? movingobjectposition2 : null;
      } 
      return null;
    } 
    return null;
  }
}
