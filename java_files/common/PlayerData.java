package com.flansmod.common;

import com.flansmod.client.FlansModClient;
import com.flansmod.common.guns.EntityGrenade;
import com.flansmod.common.guns.EntityMG;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.guns.raytracing.PlayerSnapshot;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketBlockerino;
import com.flansmod.common.network.PacketSelectOffHandGun;
import com.flansmod.common.teams.PlayerClass;
import com.flansmod.common.teams.Team;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class PlayerData {
  public String username;
  
  public float prevRotationRoll;
  
  public float rotationRoll;
  
  public PlayerSnapshot[] snapshots;
  
  public int offHandGunSlot = 0;
  
  @SideOnly(Side.CLIENT)
  public ItemStack offHandGunStack;
  
  public EntityMG mountingGun;
  
  public int isBlockingLeft;
  
  public int isBlockingRight;
  
  public int isBlockingTop;
  
  public int isBlockingBottom;
  
  public int minigunSpeed;
  
  public int nintendoSwitch;
  
  public int drawTime;
  
  public int s0;
  
  public int s1;
  
  public int s2;
  
  public int s3;
  
  public int s4;
  
  public int s5;
  
  public int s6;
  
  public int s7;
  
  public int s8;
  
  public int s9;
  
  public float shootTimeRight;
  
  public float shootTimeLeft;
  
  public float stabTimeLeft;
  
  public float stabTimeRight;
  
  public int shootClickDelay;
  
  public boolean isShootingRight;
  
  public boolean isShootingLeft;
  
  public int labigunTimer = 0;
  
  public boolean reloadingRight;
  
  public boolean reloadingLeft;
  
  public ArrayList<EntityGrenade> remoteExplosives = new ArrayList<>();
  
  public int loopedSoundDelay;
  
  public boolean shouldPlayCooldownSound;
  
  public boolean shouldPlayWarmupSound;
  
  public int meleeProgress;
  
  public int meleeLength;
  
  public float pouchMultiplier = 1.0F;
  
  public int burstRoundsRemainingLeft = 0;
  
  public int burstRoundsRemainingRight = 0;
  
  public boolean isAmmoEmpty;
  
  public boolean invisArmor = false;
  
  public Vector3f[] lastMeleePositions;
  
  public Vector3f[] lastMeleeLeftPositions;
  
  public Vector3f[] lastMeleeRightPositions;
  
  public Vector3f[] lastMeleeDownPositions;
  
  public int meleeProgressLeft;
  
  public int meleeLengthLeft;
  
  public int meleeLeftLength;
  
  public int meleeProgressRight;
  
  public int meleeLengthRight;
  
  public int meleeRightLength;
  
  public int meleeProgressDown;
  
  public int meleeLengthDown;
  
  public int meleeDownLength;
  
  public int score;
  
  public int kills;
  
  public int deaths;
  
  public int shekels;
  
  public float blood = 100.0F;
  
  public int timer = 0;
  
  public int timerSlow = 0;
  
  public int minorBleed = 0;
  
  public int Bleed = 0;
  
  public int hemorrhaging = 0;
  
  public int totalScore;
  
  public int zombieScore;
  
  public boolean out;
  
  public int vote;
  
  public Team team;
  
  public Team newTeam;
  
  public PlayerClass playerClass;
  
  public PlayerClass newPlayerClass;
  
  public boolean builder;
  
  @SideOnly(Side.CLIENT)
  public ResourceLocation skin;
  
  public int shieldTimer = 0;
  
  public int rechargeTimer = 0;
  
  public int SoundTimer = 0;
  
  public int shieldHit = 0;
  
  public PlayerData(String name) {
    this.username = name;
    this.snapshots = new PlayerSnapshot[20];
  }
  
  public void tick(EntityPlayer player) {
    if (this.shieldHit > 0)
      this.shieldHit--; 
    if (player.field_70170_p.field_72995_K)
      clientTick(player); 
    if (this.shootTimeRight > 0.0F)
      this.shootTimeRight--; 
    if (this.shootTimeRight <= 0.0F)
      this.reloadingRight = false; 
    if (this.stabTimeRight > 0.0F)
      this.stabTimeRight--; 
    if (this.stabTimeRight <= 0.0F)
      this.reloadingRight = false; 
    if (this.isBlockingLeft > 0)
      this.isBlockingLeft--; 
    if (this.isBlockingRight > 0)
      this.isBlockingRight--; 
    if (this.isBlockingTop > 0)
      this.isBlockingTop--; 
    if (this.isBlockingBottom > 0)
      this.isBlockingBottom--; 
    if (this.loopedSoundDelay > 0) {
      this.loopedSoundDelay--;
      if (this.loopedSoundDelay == 0 && !this.isShootingRight)
        this.shouldPlayCooldownSound = true; 
    } 
    if (this.minigunSpeed > -3)
      this.minigunSpeed--; 
    FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketBlockerino(this.isBlockingLeft, this.isBlockingRight, this.isBlockingTop, this.isBlockingBottom, this.minigunSpeed));
    if (this.shootTimeLeft > 0.0F)
      this.shootTimeLeft--; 
    if (this.shootTimeLeft <= 0.0F)
      this.reloadingLeft = false; 
    if (this.stabTimeLeft > 0.0F)
      this.stabTimeLeft--; 
    if (this.stabTimeLeft <= 0.0F)
      this.reloadingLeft = false; 
    if (this.nintendoSwitch > 0)
      this.nintendoSwitch--; 
    if (this.drawTime > 0)
      this.drawTime--; 
    if (this.s0 > 0)
      this.s0--; 
    if (this.s1 > 0)
      this.s1--; 
    if (this.s2 > 0)
      this.s2--; 
    if (this.s3 > 0)
      this.s3--; 
    if (this.s4 > 0)
      this.s4--; 
    if (this.s5 > 0)
      this.s5--; 
    if (this.s6 > 0)
      this.s6--; 
    if (this.s7 > 0)
      this.s7--; 
    if (this.s8 > 0)
      this.s8--; 
    if (this.s9 > 0)
      this.s9--; 
    if (this.shootClickDelay > 0)
      this.shootClickDelay--; 
    for (int i = 0; i < 5; i++) {
      ItemStack stack = player.func_71124_b(i);
      if (stack != null) {
        if (!(player.field_70154_o instanceof com.flansmod.common.driveables.EntitySeat) && !player.func_82165_m(Potion.field_76441_p.field_76415_H) && !(stack.func_77973_b() instanceof com.flansmod.common.teams.ItemTeamArmour))
          player.func_82142_c(false); 
      } else if (!(player.field_70154_o instanceof com.flansmod.common.driveables.EntitySeat) && !player.func_82165_m(Potion.field_76441_p.field_76415_H)) {
        player.func_82142_c(false);
      } 
    } 
    if (this.timer < 60 && !(player.field_70154_o instanceof com.flansmod.common.driveables.EntitySeat))
      this.timer++; 
    if (this.timer >= 60)
      this.timer = 0; 
    if (this.timerSlow < 120 && !(player.field_70154_o instanceof com.flansmod.common.driveables.EntitySeat))
      this.timerSlow++; 
    if (this.timerSlow >= 120)
      this.timerSlow = 0; 
    if (this.blood > 50.0F && this.blood < 100.0F && this.timer == 59)
      this.blood++; 
    if (this.blood > 30.0F && this.blood <= 50.0F && this.timerSlow == 119)
      this.blood++; 
    if (this.timerSlow == 119 && this.minorBleed > 0) {
      this.blood--;
      this.blood--;
      this.blood--;
      this.minorBleed--;
    } 
    if (this.timerSlow == 119 && this.Bleed > 0) {
      this.blood--;
      this.blood--;
      this.Bleed--;
    } 
    if (this.timer == 59 && this.hemorrhaging > 0) {
      this.blood--;
      this.blood--;
      this.Bleed--;
    } 
    if (this.blood > 100.0F)
      this.blood = 100.0F; 
    if (this.minorBleed < 0)
      this.minorBleed = 0; 
    if (this.Bleed < 0)
      this.Bleed = 0; 
    if (this.hemorrhaging < 0)
      this.hemorrhaging = 0; 
    if (this.minorBleed > 5)
      this.Bleed = this.minorBleed - 5; 
    if (this.Bleed > 25)
      this.hemorrhaging = (this.Bleed - 25) * 2; 
    if (this.blood <= 80.0F)
      player.func_70690_d(new PotionEffect(Potion.field_76438_s.field_76415_H, 200)); 
    if (this.blood <= 60.0F)
      player.func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 200)); 
    if (this.blood <= 45.0F)
      player.func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 400)); 
    if (this.blood <= 40.0F)
      player.func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 240)); 
    if (this.blood <= 30.0F)
      player.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 240)); 
    if (this.blood <= 0.0F) {
      player.func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5));
      this.minorBleed = 0;
      this.Bleed = 0;
      this.hemorrhaging = 0;
      this.blood = 100.0F;
    } 
    if (this.pouchMultiplier != 1.0F)
      if (this.isShootingRight && !this.reloadingRight) {
        this.minigunSpeed += 2;
        System.out.println(this.minigunSpeed + "from growth");
      }  
    if (this.labigunTimer > 0)
      this.labigunTimer--; 
    System.arraycopy(this.snapshots, 0, this.snapshots, 1, this.snapshots.length - 2 + 1);
    this.snapshots[0] = new PlayerSnapshot(player);
  }
  
  public void clientTick(EntityPlayer player) {
    if (player.func_71045_bC() == null || !(player.func_71045_bC().func_77973_b() instanceof ItemGun) || ((ItemGun)player.func_71045_bC().func_77973_b()).type.oneHanded || player.func_71045_bC() == this.offHandGunStack)
      this.offHandGunStack = null; 
  }
  
  public PlayerClass getPlayerClass() {
    if (this.playerClass != this.newPlayerClass)
      this.playerClass = this.newPlayerClass; 
    return this.playerClass;
  }
  
  public void resetScore() {
    this.score = this.zombieScore = this.kills = this.deaths = 0;
    this.team = this.newTeam = null;
    this.playerClass = this.newPlayerClass = null;
  }
  
  public void playerKilled() {
    this.mountingGun = null;
    this.isShootingRight = this.isShootingLeft = false;
    this.snapshots = new PlayerSnapshot[20];
  }
  
  public void selectOffHandWeapon(EntityPlayer player, int slot) {
    if (isValidOffHandWeapon(player, slot))
      this.offHandGunSlot = slot; 
  }
  
  public boolean isValidOffHandWeapon(EntityPlayer player, int slot) {
    if (slot == 0)
      return true; 
    if (slot - 1 == player.field_71071_by.field_70461_c)
      return false; 
    ItemStack stackInSlot = player.field_71071_by.func_70301_a(slot - 1);
    if (stackInSlot == null)
      return false; 
    if (stackInSlot.func_77973_b() instanceof ItemGun) {
      ItemGun item = (ItemGun)stackInSlot.func_77973_b();
      if (item.type.oneHanded)
        return true; 
    } 
    return false;
  }
  
  public void cycleOffHandItem(EntityPlayer player, int dWheel) {
    if (dWheel < 0) {
      for (this.offHandGunSlot = (this.offHandGunSlot + 1) % 10; !isValidOffHandWeapon(player, this.offHandGunSlot); this.offHandGunSlot = (this.offHandGunSlot + 1) % 10);
    } else if (dWheel > 0) {
      for (this.offHandGunSlot = (this.offHandGunSlot + 9) % 10; !isValidOffHandWeapon(player, this.offHandGunSlot); this.offHandGunSlot = (this.offHandGunSlot + 9) % 10);
    } 
    FlansModClient.currentScope = null;
    FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketSelectOffHandGun(this.offHandGunSlot));
  }
  
  public void doMelee(EntityPlayer player, int meleeTime, GunType type) {
    this.meleeLength = meleeTime;
    this.lastMeleePositions = new Vector3f[type.meleePath.size()];
    for (int k = 0; k < type.meleeDamagePoints.size(); k++) {
      Vector3f meleeDamagePoint = type.meleeDamagePoints.get(k);
      Vector3f nextPos = type.meleePath.get(0);
      Vector3f nextAngles = type.meleePathAngles.get(0);
      RotatedAxes nextAxes = new RotatedAxes(-nextAngles.y, -nextAngles.z, nextAngles.x);
      Vector3f nextPosInPlayerCoords = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextAxes.findLocalVectorGlobally(meleeDamagePoint));
      Vector3f.add(nextPos, nextPosInPlayerCoords, nextPosInPlayerCoords);
      if (!FlansMod.proxy.isThePlayer(player))
        nextPosInPlayerCoords.y += 1.6F; 
      this.lastMeleePositions[k] = new Vector3f(player.field_70165_t + nextPosInPlayerCoords.x, player.field_70163_u + nextPosInPlayerCoords.y, player.field_70161_v + nextPosInPlayerCoords.z);
    } 
  }
  
  public void doMeleeLeft(EntityPlayer player, int meleeLeftTime, GunType type) {
    this.meleeLeftLength = meleeLeftTime;
    this.lastMeleeLeftPositions = new Vector3f[type.meleeLeftPath.size()];
    for (int k = 0; k < type.meleeLeftDamagePoints.size(); k++) {
      Vector3f meleeDamagePoint = type.meleeLeftDamagePoints.get(k);
      Vector3f nextPos = type.meleeLeftPath.get(0);
      Vector3f nextAngles = type.meleeLeftPathAngles.get(0);
      RotatedAxes nextAxes = new RotatedAxes(-nextAngles.y, -nextAngles.z, nextAngles.x);
      Vector3f nextPosInPlayerCoordsLeft = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextAxes.findLocalVectorGlobally(meleeDamagePoint));
      Vector3f.add(nextPos, nextPosInPlayerCoordsLeft, nextPosInPlayerCoordsLeft);
      if (!FlansMod.proxy.isThePlayer(player))
        nextPosInPlayerCoordsLeft.y += 1.6F; 
      this.lastMeleeLeftPositions[k] = new Vector3f(player.field_70165_t + nextPosInPlayerCoordsLeft.x, player.field_70163_u + nextPosInPlayerCoordsLeft.y, player.field_70161_v + nextPosInPlayerCoordsLeft.z);
    } 
  }
  
  public void doMeleeRight(EntityPlayer player, int meleeRightTime, GunType type) {
    this.meleeRightLength = meleeRightTime;
    this.lastMeleeRightPositions = new Vector3f[type.meleeRightPath.size()];
    for (int k = 0; k < type.meleeRightDamagePoints.size(); k++) {
      Vector3f meleeDamagePoint = type.meleeRightDamagePoints.get(k);
      Vector3f nextPos = type.meleeRightPath.get(0);
      Vector3f nextAngles = type.meleeRightPathAngles.get(0);
      RotatedAxes nextAxes = new RotatedAxes(-nextAngles.y, -nextAngles.z, nextAngles.x);
      Vector3f nextPosInPlayerCoords = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextAxes.findLocalVectorGlobally(meleeDamagePoint));
      Vector3f.add(nextPos, nextPosInPlayerCoords, nextPosInPlayerCoords);
      if (!FlansMod.proxy.isThePlayer(player))
        nextPosInPlayerCoords.y += 1.6F; 
      this.lastMeleeRightPositions[k] = new Vector3f(player.field_70165_t + nextPosInPlayerCoords.x, player.field_70163_u + nextPosInPlayerCoords.y, player.field_70161_v + nextPosInPlayerCoords.z);
    } 
  }
  
  public void doMeleeDown(EntityPlayer player, int meleeDownTime, GunType type) {
    this.meleeDownLength = meleeDownTime;
    this.lastMeleeDownPositions = new Vector3f[type.meleeDownPath.size()];
    for (int k = 0; k < type.meleeDownDamagePoints.size(); k++) {
      Vector3f meleeDamagePointDown = type.meleeDownDamagePoints.get(k);
      Vector3f nextPosDown = type.meleeDownPath.get(0);
      Vector3f nextAnglesDown = type.meleeDownPathAngles.get(0);
      RotatedAxes nextAxesDown = new RotatedAxes(-nextAnglesDown.y, -nextAnglesDown.z, nextAnglesDown.x);
      Vector3f nextPosInPlayerCoordsDown = (new RotatedAxes(player.field_70177_z + 90.0F, player.field_70125_A, 0.0F)).findLocalVectorGlobally(nextAxesDown.findLocalVectorGlobally(meleeDamagePointDown));
      Vector3f.add(nextPosDown, nextPosInPlayerCoordsDown, nextPosInPlayerCoordsDown);
      if (!FlansMod.proxy.isThePlayer(player))
        nextPosInPlayerCoordsDown.y += 1.6F; 
      this.lastMeleeDownPositions[k] = new Vector3f(player.field_70165_t + nextPosInPlayerCoordsDown.x, player.field_70163_u + nextPosInPlayerCoordsDown.y, player.field_70161_v + nextPosInPlayerCoordsDown.z);
    } 
  }
}
