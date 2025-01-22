package com.flansmod.common.guns.raytracing;

import com.flansmod.client.debug.EntityDebugAABB;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerData;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketFlak;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.teams.ItemTeamArmour;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class PlayerHitbox {
  public EntityPlayer player;
  
  public RotatedAxes axes;
  
  public Vector3f rP;
  
  public Vector3f o;
  
  public Vector3f d;
  
  public EnumHitboxType type;
  
  public static int lefty = 0;
  
  public static int righty = 0;
  
  public static int topy = 0;
  
  public static int bottomy = 0;
  
  public static int shieldHit = 0;
  
  public PlayerHitbox(EntityPlayer player, RotatedAxes axes, Vector3f rotationPoint, Vector3f origin, Vector3f dimensions, EnumHitboxType type) {
    this.player = player;
    this.axes = axes;
    this.o = origin;
    this.d = dimensions;
    this.type = type;
    this.rP = rotationPoint;
  }
  
  @SideOnly(Side.CLIENT)
  public void renderHitbox(World world, Vector3f pos) {
    Vector3f boxOrigin = new Vector3f(pos.x + this.rP.x, pos.y + this.rP.y, pos.z + this.rP.z);
    if (this.type != EnumHitboxType.NEARBY && ((PlayerHandler.getPlayerData(this.player)).shieldHit > 0 || FlansMod.DEBUG))
      world.func_72838_d((Entity)new EntityDebugAABB(world, boxOrigin, this.d, 2, 1.0F, 1.0F, 0.0F, this.axes.getYaw(), this.axes.getPitch(), this.axes.getRoll(), this.o, (PlayerHandler.getPlayerData(this.player)).shieldHit)); 
  }
  
  public PlayerBulletHit raytrace(Vector3f origin, Vector3f motion) {
    origin = Vector3f.sub(origin, this.rP, null);
    origin = this.axes.findGlobalVectorLocally(origin);
    motion = this.axes.findGlobalVectorLocally(motion);
    if (motion.x != 0.0F)
      if (origin.x < this.o.x) {
        float intersectTime = (this.o.x - origin.x) / motion.x;
        float intersectY = origin.y + motion.y * intersectTime;
        float intersectZ = origin.z + motion.z * intersectTime;
        if (intersectY >= this.o.y && intersectY <= this.o.y + this.d.y && intersectZ >= this.o.z && intersectZ <= this.o.z + this.d.z)
          return new PlayerBulletHit(this, intersectTime); 
      } else if (origin.x > this.o.x + this.d.x) {
        float intersectTime = (this.o.x + this.d.x - origin.x) / motion.x;
        float intersectY = origin.y + motion.y * intersectTime;
        float intersectZ = origin.z + motion.z * intersectTime;
        if (intersectY >= this.o.y && intersectY <= this.o.y + this.d.y && intersectZ >= this.o.z && intersectZ <= this.o.z + this.d.z)
          return new PlayerBulletHit(this, intersectTime); 
      }  
    if (motion.z != 0.0F)
      if (origin.z < this.o.z) {
        float intersectTime = (this.o.z - origin.z) / motion.z;
        float intersectX = origin.x + motion.x * intersectTime;
        float intersectY = origin.y + motion.y * intersectTime;
        if (intersectX >= this.o.x && intersectX <= this.o.x + this.d.x && intersectY >= this.o.y && intersectY <= this.o.y + this.d.y)
          return new PlayerBulletHit(this, intersectTime); 
      } else if (origin.z > this.o.z + this.d.z) {
        float intersectTime = (this.o.z + this.d.z - origin.z) / motion.z;
        float intersectX = origin.x + motion.x * intersectTime;
        float intersectY = origin.y + motion.y * intersectTime;
        if (intersectX >= this.o.x && intersectX <= this.o.x + this.d.x && intersectY >= this.o.y && intersectY <= this.o.y + this.d.y)
          return new PlayerBulletHit(this, intersectTime); 
      }  
    if (motion.y != 0.0F)
      if (origin.y < this.o.y) {
        float intersectTime = (this.o.y - origin.y) / motion.y;
        float intersectX = origin.x + motion.x * intersectTime;
        float intersectZ = origin.z + motion.z * intersectTime;
        if (intersectX >= this.o.x && intersectX <= this.o.x + this.d.x && intersectZ >= this.o.z && intersectZ <= this.o.z + this.d.z)
          return new PlayerBulletHit(this, intersectTime); 
      } else if (origin.y > this.o.y + this.d.y) {
        float intersectTime = (this.o.y + this.d.y - origin.y) / motion.y;
        float intersectX = origin.x + motion.x * intersectTime;
        float intersectZ = origin.z + motion.z * intersectTime;
        if (intersectX >= this.o.x && intersectX <= this.o.x + this.d.x && intersectZ >= this.o.z && intersectZ <= this.o.z + this.d.z)
          return new PlayerBulletHit(this, intersectTime); 
      }  
    return null;
  }
  
  public float hitByBullet(EntityBullet bullet, float penetratingPower) {
    int i;
    PlayerData data;
    float hitDamage;
    ItemStack currentStack;
    PlayerData playerData1;
    DamageSource damagesource;
    if (bullet.type.setEntitiesOnFire)
      this.player.func_70015_d(20); 
    float damageModifier = (bullet.type.penetratingPower < 0.1F) ? (penetratingPower / bullet.type.penetratingPower) : 1.0F;
    float trueBodyArmorPen = bullet.type.bodyarmorPen;
    if (bullet.field_70173_aa > bullet.type.dynamicBulletDelay)
      trueBodyArmorPen = bullet.type.dynamicBodyarmorPen; 
    switch (this.type) {
      case BODY:
        for (i = 0; i < 5; i++) {
          ItemStack stack = this.player.func_71124_b(i);
          if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour) {
            (PlayerHandler.getPlayerData(this.player)).pouchMultiplier = ((ItemTeamArmour)stack.func_77973_b()).type.pouchMultiplier;
            if ((!((ItemTeamArmour)stack.func_77973_b()).type.smokeProtection && bullet.type.smokeProtectable) || !bullet.type.smokeProtectable)
              for (PotionEffect effect : bullet.type.hitEffects)
                this.player.func_70690_d(new PotionEffect(effect));  
            if (trueBodyArmorPen >= ((ItemTeamArmour)stack.func_77973_b()).secretBody * 0.85F && trueBodyArmorPen <= ((ItemTeamArmour)stack.func_77973_b()).secretBody) {
              damageModifier *= bullet.type.barelypenPenalty;
              if (damageModifier <= 0.1F)
                stack.func_77964_b(stack.func_77960_j() + 1); 
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } else if (trueBodyArmorPen < ((ItemTeamArmour)stack.func_77973_b()).secretBody * 0.85F) {
              stack.func_77964_b(stack.func_77960_j() + 1);
              damageModifier *= bullet.type.nonpenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } 
          } else {
            (PlayerHandler.getPlayerData(this.player)).pouchMultiplier = 1.0F;
          } 
        } 
        break;
      case BACK:
        damageModifier *= 1.0F;
        for (i = 0; i < 5; i++) {
          ItemStack stack = this.player.func_71124_b(i);
          if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour) {
            if ((!((ItemTeamArmour)stack.func_77973_b()).type.smokeProtection && bullet.type.smokeProtectable) || !bullet.type.smokeProtectable)
              for (PotionEffect effect : bullet.type.hitEffects)
                this.player.func_70690_d(new PotionEffect(effect));  
            if (((ItemTeamArmour)stack.func_77973_b()).secretBack * 0.8500000238418579D > trueBodyArmorPen) {
              damageModifier *= bullet.type.nonpenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } else if (((ItemTeamArmour)stack.func_77973_b()).secretBack > trueBodyArmorPen) {
              damageModifier *= bullet.type.barelypenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } 
          } 
        } 
        break;
      case NAPE:
        damageModifier *= 3.5F;
        for (i = 0; i < 5; i++) {
          ItemStack stack = this.player.func_71124_b(i);
          if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour) {
            if ((!((ItemTeamArmour)stack.func_77973_b()).type.smokeProtection && bullet.type.smokeProtectable) || !bullet.type.smokeProtectable)
              for (PotionEffect effect : bullet.type.hitEffects)
                this.player.func_70690_d(new PotionEffect(effect));  
            if (((ItemTeamArmour)stack.func_77973_b()).secretNape * 0.85D > trueBodyArmorPen) {
              damageModifier *= bullet.type.nonpenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } else if (((ItemTeamArmour)stack.func_77973_b()).secretNape > trueBodyArmorPen) {
              damageModifier *= bullet.type.barelypenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } 
          } 
        } 
        break;
      case CRANIUM:
        damageModifier *= 2.0F;
        for (i = 0; i < 5; i++) {
          ItemStack stack = this.player.func_71124_b(i);
          if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour) {
            if ((!((ItemTeamArmour)stack.func_77973_b()).type.smokeProtection && bullet.type.smokeProtectable) || !bullet.type.smokeProtectable)
              for (PotionEffect effect : bullet.type.hitEffects)
                this.player.func_70690_d(new PotionEffect(effect));  
            if (((ItemTeamArmour)stack.func_77973_b()).secretHead * 0.85D > trueBodyArmorPen) {
              damageModifier *= bullet.type.nonpenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } else if (((ItemTeamArmour)stack.func_77973_b()).secretHead > trueBodyArmorPen) {
              damageModifier *= bullet.type.barelypenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } 
          } 
        } 
        break;
      case FACE:
        damageModifier *= 1.5F;
        for (i = 0; i < 5; i++) {
          ItemStack stack = this.player.func_71124_b(i);
          if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour) {
            if ((!((ItemTeamArmour)stack.func_77973_b()).type.smokeProtection && bullet.type.smokeProtectable) || !bullet.type.smokeProtectable)
              for (PotionEffect effect : bullet.type.hitEffects)
                this.player.func_70690_d(new PotionEffect(effect));  
            if (((ItemTeamArmour)stack.func_77973_b()).secretFace * 0.85D > trueBodyArmorPen) {
              damageModifier *= bullet.type.nonpenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } else if (((ItemTeamArmour)stack.func_77973_b()).secretFace > trueBodyArmorPen) {
              damageModifier *= bullet.type.barelypenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } 
          } 
        } 
        break;
      case LEFTARM:
        damageModifier *= 0.6F;
        for (i = 0; i < 5; i++) {
          ItemStack stack = this.player.func_71124_b(i);
          if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour) {
            if ((!((ItemTeamArmour)stack.func_77973_b()).type.smokeProtection && bullet.type.smokeProtectable) || !bullet.type.smokeProtectable)
              for (PotionEffect effect : bullet.type.hitEffects)
                this.player.func_70690_d(new PotionEffect(effect));  
            if (((ItemTeamArmour)stack.func_77973_b()).secretArm * 0.85D > trueBodyArmorPen) {
              damageModifier *= bullet.type.nonpenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } else if (((ItemTeamArmour)stack.func_77973_b()).secretArm > trueBodyArmorPen) {
              damageModifier *= bullet.type.barelypenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } 
          } 
        } 
        break;
      case RIGHTARM:
        damageModifier *= 0.6F;
        for (i = 0; i < 5; i++) {
          ItemStack stack = this.player.func_71124_b(i);
          if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour) {
            if ((!((ItemTeamArmour)stack.func_77973_b()).type.smokeProtection && bullet.type.smokeProtectable) || !bullet.type.smokeProtectable)
              for (PotionEffect effect : bullet.type.hitEffects)
                this.player.func_70690_d(new PotionEffect(effect));  
            if (((ItemTeamArmour)stack.func_77973_b()).secretArm * 0.85D > trueBodyArmorPen) {
              damageModifier *= bullet.type.nonpenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } else if (((ItemTeamArmour)stack.func_77973_b()).secretArm > trueBodyArmorPen) {
              damageModifier *= bullet.type.barelypenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } 
          } 
        } 
        break;
      case LEGS:
        damageModifier *= 0.6F;
        for (i = 0; i < 5; i++) {
          ItemStack stack = this.player.func_71124_b(i);
          if (stack != null && stack.func_77973_b() instanceof ItemTeamArmour) {
            if ((!((ItemTeamArmour)stack.func_77973_b()).type.smokeProtection && bullet.type.smokeProtectable) || !bullet.type.smokeProtectable)
              for (PotionEffect effect : bullet.type.hitEffects)
                this.player.func_70690_d(new PotionEffect(effect));  
            if (((ItemTeamArmour)stack.func_77973_b()).secretLeg * 0.85D > trueBodyArmorPen) {
              damageModifier *= bullet.type.nonpenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } else if (((ItemTeamArmour)stack.func_77973_b()).secretLeg > trueBodyArmorPen) {
              damageModifier *= bullet.type.barelypenPenalty;
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "armorDeflect", true);
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 25, "crit"), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0F, this.player.field_71093_bK);
            } 
          } 
        } 
        break;
      case NEARBY:
        damageModifier *= 0.0F;
        if (!bullet.type.swordEnergy)
          PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 8.0D, this.player.field_71093_bK, bullet.missNoise, true); 
        if (!this.player.func_70115_ae() && !this.player.field_70170_p.field_72995_K)
          this.player.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, bullet.type.suppression)); 
        break;
      case LEFTITEM:
        data = PlayerHandler.getPlayerData(this.player);
        if (data.offHandGunSlot != 0) {
          ItemStack leftHandStack = null;
          if (this.player.field_70170_p.field_72995_K && !FlansMod.proxy.isThePlayer(this.player)) {
            leftHandStack = data.offHandGunStack;
          } else {
            leftHandStack = this.player.field_71071_by.func_70301_a(data.offHandGunSlot - 1);
          } 
          if (leftHandStack != null && leftHandStack.func_77973_b() instanceof ItemGun) {
            GunType leftGunType = ((ItemGun)leftHandStack.func_77973_b()).type;
            if (trueBodyArmorPen < leftGunType.shieldDamageAbsorption) {
              damageModifier *= 0.001F;
              bullet.func_70106_y();
              PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "shield_metal", true);
            } 
          } 
        } 
        break;
      case RIGHTITEM:
        currentStack = this.player.func_71045_bC();
        if (currentStack != null && currentStack.func_77973_b() instanceof ItemGun) {
          GunType gunType = ((ItemGun)currentStack.func_77973_b()).type;
          if (trueBodyArmorPen < gunType.shieldDamageAbsorption) {
            damageModifier *= 0.001F;
            bullet.func_70106_y();
            PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 5.0D, this.player.field_71093_bK, "shield_metal", true);
          } 
        } 
        break;
    } 
    switch (this.type) {
      case BODY:
      case BACK:
      case NAPE:
      case CRANIUM:
      case FACE:
      case LEFTARM:
      case RIGHTARM:
      case LEGS:
      case LEFTITEM:
      case RIGHTITEM:
        hitDamage = bullet.damage * bullet.type.dynamicDamage * damageModifier;
        if (bullet.field_70173_aa < bullet.type.dynamicBulletDelay)
          hitDamage = bullet.damage * bullet.type.damageVsPlayer * damageModifier; 
        playerData1 = PlayerHandler.getPlayerData(this.player);
        if (hitDamage < this.player.func_110143_aJ() && !this.player.getEntityData().func_74779_i("lastClowder").equals("SAFEZONE") && TeamsManager.bleeding)
          playerData1.minorBleed = (int)(playerData1.minorBleed + hitDamage * bullet.type.bleedMultiplier); 
        if (bullet.type.entityHitSoundEnable)
          PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, bullet.type.hitSoundRange, this.player.field_71093_bK, bullet.type.hitSound, true); 
        if (hitDamage > 40.0F && !this.player.getEntityData().func_74779_i("lastClowder").equals("SAFEZONE")) {
          FlansMod.proxy.spawnParticle("flansmod.overkill", this.player.field_70165_t, this.player.field_70163_u - 4.0D, this.player.field_70161_v, 0.0D, 0.10000000149011612D, 0.0D);
          PacketPlaySound.sendSoundPacket(this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 15.0D, this.player.field_71093_bK, "goreDeath", true);
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.overkill", this.player.field_70165_t, this.player.field_70163_u - 4.0D, this.player.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 150.0F, this.player.field_71093_bK);
        } 
        if (hitDamage > 10.0F && !this.player.getEntityData().func_74779_i("lastClowder").equals("SAFEZONE")) {
          FlansMod.proxy.spawnParticle("flansmod.blood", this.player.field_70165_t, this.player.field_70163_u - 4.0D, this.player.field_70161_v, 0.0D, 0.10000000149011612D, 0.0D);
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.blood", this.player.field_70165_t, this.player.field_70163_u - 4.0D, this.player.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), this.player.field_70165_t, this.player.field_70163_u, this.player.field_70161_v, 150.0F, this.player.field_71093_bK);
        } 
        damagesource = (bullet.owner == null) ? DamageSource.field_76377_j : bullet.getBulletDamage((this.type == EnumHitboxType.NAPE || this.type == EnumHitboxType.CRANIUM));
        if (!this.player.field_70170_p.field_72995_K && hitDamage == 0.0F && (TeamsManager.getInstance()).currentRound != null)
          (TeamsManager.getInstance()).currentRound.gametype.playerAttacked((EntityPlayerMP)this.player, damagesource); 
        if (this.player.func_70097_a(damagesource, hitDamage)) {
          this.player.field_70720_be++;
          this.player.field_70172_ad = this.player.field_70771_an / 2;
        } 
        return penetratingPower - 1.0F;
    } 
    return penetratingPower;
  }
}
