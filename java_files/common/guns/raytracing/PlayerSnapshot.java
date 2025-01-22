package com.flansmod.common.guns.raytracing;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class PlayerSnapshot {
  public EntityPlayer player;
  
  public Vector3f pos;
  
  public ArrayList<PlayerHitbox> hitboxes;
  
  public long time;
  
  public int shieldTimer = 0;
  
  public PlayerSnapshot(EntityPlayer p) {
    this.player = p;
    this.pos = new Vector3f(p.field_70165_t, p.field_70163_u, p.field_70161_v);
    if (FlansMod.proxy.isThePlayer(p))
      this.pos = new Vector3f(p.field_70165_t, p.field_70163_u - 1.600000023841858D, p.field_70161_v); 
    this.hitboxes = new ArrayList<>();
    RotatedAxes bodyAxes = new RotatedAxes(p.field_70761_aq, 0.0F, 0.0F);
    RotatedAxes headAxes = new RotatedAxes(p.field_70759_as - p.field_70761_aq, 0.0F, -p.field_70125_A);
    this.hitboxes.add(new PlayerHitbox(this.player, bodyAxes, new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-0.25F, 0.7F, -0.2F), new Vector3f(0.5F, 0.7F, 0.2F), EnumHitboxType.BACK));
    this.hitboxes.add(new PlayerHitbox(this.player, bodyAxes, new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-0.25F, 0.7F, 0.0F), new Vector3f(0.5F, 0.7F, 0.2F), EnumHitboxType.BODY));
    this.hitboxes.add(new PlayerHitbox(this.player, bodyAxes, new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-0.25F, 0.0F, -0.15F), new Vector3f(0.5F, 0.7F, 0.3F), EnumHitboxType.LEGS));
    this.hitboxes.add(new PlayerHitbox(this.player, bodyAxes.findLocalAxesGlobally(headAxes), new Vector3f(0.0F, 1.4F, 0.0F), new Vector3f(-0.25F, 0.0F, -0.3F), new Vector3f(0.5F, 0.25F, 0.45F), EnumHitboxType.NAPE));
    this.hitboxes.add(new PlayerHitbox(this.player, bodyAxes.findLocalAxesGlobally(headAxes), new Vector3f(0.0F, 1.4F, 0.0F), new Vector3f(-0.2F, 0.0F, 0.15F), new Vector3f(0.4F, 0.25F, 0.1F), EnumHitboxType.FACE));
    this.hitboxes.add(new PlayerHitbox(this.player, bodyAxes.findLocalAxesGlobally(headAxes), new Vector3f(0.0F, 1.4F, 0.0F), new Vector3f(-0.25F, 0.25F, -0.3F), new Vector3f(0.5F, 0.25F, 0.6F), EnumHitboxType.CRANIUM));
    this.hitboxes.add(new PlayerHitbox(this.player, bodyAxes, new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-2.25F, 0.0F, -2.15F), new Vector3f(4.5F, 6.0F, 4.3F), EnumHitboxType.NEARBY));
    float yHead = (p.field_70759_as - p.field_70761_aq) / 57.295776F;
    float xHead = p.field_70125_A / 57.295776F;
    float zRight = 0.0F;
    float zLeft = 0.0F;
    float yRight = -0.1F + yHead - 1.5707964F;
    float yLeft = 0.1F + yHead + 0.4F - 1.5707964F;
    float xRight = -1.5707964F + xHead;
    float xLeft = -1.5707964F + xHead;
    zRight += MathHelper.func_76134_b(p.field_70173_aa * 0.09F) * 0.05F + 0.05F;
    zLeft -= MathHelper.func_76134_b(p.field_70173_aa * 0.09F) * 0.05F + 0.05F;
    xRight += MathHelper.func_76126_a(p.field_70173_aa * 0.067F) * 0.05F;
    xLeft -= MathHelper.func_76126_a(p.field_70173_aa * 0.067F) * 0.05F;
    RotatedAxes leftArmAxes = (new RotatedAxes()).rotateGlobalPitchInRads(xLeft).rotateGlobalYawInRads(3.1415927F + yLeft).rotateGlobalRollInRads(-zLeft);
    RotatedAxes rightArmAxes = (new RotatedAxes()).rotateGlobalPitchInRads(xRight).rotateGlobalYawInRads(3.1415927F + yRight).rotateGlobalRollInRads(-zRight);
    float originZRight = MathHelper.func_76126_a(-p.field_70761_aq * 3.1415927F / 180.0F) * 5.0F / 16.0F;
    float originXRight = -MathHelper.func_76134_b(-p.field_70761_aq * 3.1415927F / 180.0F) * 5.0F / 16.0F;
    float originZLeft = -MathHelper.func_76126_a(-p.field_70761_aq * 3.1415927F / 180.0F) * 5.0F / 16.0F;
    float originXLeft = MathHelper.func_76134_b(-p.field_70761_aq * 3.1415927F / 180.0F) * 5.0F / 16.0F;
    this.hitboxes.add(new PlayerHitbox(this.player, bodyAxes.findLocalAxesGlobally(leftArmAxes), new Vector3f(originXLeft, 1.3F, originZLeft), new Vector3f(-0.125F, -0.6F, -0.125F), new Vector3f(0.25F, 0.7F, 0.25F), EnumHitboxType.LEFTARM));
    this.hitboxes.add(new PlayerHitbox(this.player, bodyAxes.findLocalAxesGlobally(rightArmAxes), new Vector3f(originXRight, 1.3F, originZRight), new Vector3f(-0.125F, -0.6F, -0.125F), new Vector3f(0.25F, 0.7F, 0.25F), EnumHitboxType.RIGHTARM));
    ItemStack playerRightHandStack = this.player.func_71045_bC();
    if (playerRightHandStack != null && playerRightHandStack.func_77973_b() instanceof ItemGun) {
      GunType gunType = ((ItemGun)playerRightHandStack.func_77973_b()).type;
      ItemGun allahu = (ItemGun)playerRightHandStack.func_77973_b();
      if ((gunType.shield && !gunType.canBlock) || (allahu.blocking == true && gunType.canBlock == true))
        this.hitboxes.add(new PlayerHitbox(this.player, bodyAxes.findLocalAxesGlobally(rightArmAxes), new Vector3f(originXRight, 1.3F, originZRight), new Vector3f(gunType.shieldOrigin.y, -1.05F + gunType.shieldOrigin.x, -0.0625F + gunType.shieldOrigin.z), new Vector3f(gunType.shieldDimensions.y, gunType.shieldDimensions.x, gunType.shieldDimensions.z), EnumHitboxType.RIGHTITEM)); 
      PlayerData data = PlayerHandler.getPlayerData(this.player);
      if (gunType.oneHanded && data.offHandGunSlot != 0) {
        ItemStack leftHandStack = null;
        if (this.player.field_70170_p.field_72995_K && !FlansMod.proxy.isThePlayer(this.player)) {
          leftHandStack = data.offHandGunStack;
        } else {
          leftHandStack = this.player.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
        } 
        if (leftHandStack != null && leftHandStack.func_77973_b() instanceof ItemGun) {
          GunType leftGunType = ((ItemGun)leftHandStack.func_77973_b()).type;
          if (leftGunType.shield)
            this.hitboxes.add(new PlayerHitbox(this.player, bodyAxes.findLocalAxesGlobally(leftArmAxes), new Vector3f(originXLeft, 1.3F, originZLeft), new Vector3f(leftGunType.shieldOrigin.y, -1.05F + leftGunType.shieldOrigin.x, -0.0625F + leftGunType.shieldOrigin.z), new Vector3f(leftGunType.shieldDimensions.y, leftGunType.shieldDimensions.x, leftGunType.shieldDimensions.z), EnumHitboxType.LEFTITEM)); 
        } 
      } 
    } 
  }
  
  public ArrayList<BulletHit> raytrace(Vector3f origin, Vector3f motion) {
    Vector3f localOrigin = Vector3f.sub(origin, this.pos, null);
    ArrayList<BulletHit> hits = new ArrayList<>();
    for (PlayerHitbox hitbox : this.hitboxes) {
      PlayerBulletHit hit = hitbox.raytrace(localOrigin, motion);
      if (hit != null && hit.intersectTime >= 0.0F && hit.intersectTime <= 1.0F) {
        hits.add(hit);
        this.shieldTimer = 10;
      } 
    } 
    return hits;
  }
  
  @SideOnly(Side.CLIENT)
  public void renderSnapshot() {
    for (PlayerHitbox hitbox : this.hitboxes)
      hitbox.renderHitbox(this.player.field_70170_p, this.pos); 
  }
}
