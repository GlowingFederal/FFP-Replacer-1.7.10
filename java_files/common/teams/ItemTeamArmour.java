package com.flansmod.common.teams;

import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketFlak;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.types.IFlanItem;
import com.flansmod.common.types.InfoType;
import com.google.common.collect.Multimap;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class ItemTeamArmour extends ItemArmor implements ISpecialArmor, IFlanItem {
  public ArmourType type;
  
  protected static final UUID[] uuid = new UUID[] { UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID() };
  
  public int timer = 0;
  
  public int SoundTimer = 0;
  
  public int rechargeTimer = 0;
  
  public float secretBody = 0.0F;
  
  public float secretArm = 0.0F;
  
  public float secretNape = 0.0F;
  
  public float secretHead = 0.0F;
  
  public float secretFace = 0.0F;
  
  public float secretLeg = 0.0F;
  
  public double secretBack = 0.0D;
  
  public float pouchMultiplier = 1.0F;
  
  public boolean hasPouch = false;
  
  public boolean hasFrontMount = false;
  
  public float frontMountY1 = 1.0F;
  
  public float frontMountZ1 = 1.0F;
  
  public float frontMountY2 = 1.0F;
  
  public float frontMountZ2 = 1.0F;
  
  public float frontMountRotation = 1.0F;
  
  boolean hasTopMount = false;
  
  float topMountY = 1.0F;
  
  float topMountZ = 1.0F;
  
  float topMountRotation = 1.0F;
  
  public ItemTeamArmour(ArmourType t) {
    super(ItemArmor.ArmorMaterial.CLOTH, 0, t.type);
    this.type = t;
    this.type.item = (Item)this;
    func_77637_a((CreativeTabs)FlansMod.tabFlanTeams);
    if (t.durability > 0)
      func_77656_e(t.durability); 
    GameRegistry.registerItem((Item)this, this.type.shortName, "flansmod");
  }
  
  public ItemTeamArmour(ItemArmor.ArmorMaterial armorMaterial, int renderIndex, int armourType) {
    super(armorMaterial, renderIndex, armourType);
  }
  
  public ISpecialArmor.ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
    this.secretBody = this.type.bodyArmor;
    this.secretHead = this.type.headArmor;
    this.secretNape = this.type.napeArmor;
    this.secretFace = this.type.faceArmor;
    this.secretArm = this.type.armArmor;
    this.secretLeg = this.type.legArmor;
    this.secretBack = this.type.backArmor;
    this.pouchMultiplier = this.type.pouchMultiplier;
    this.hasPouch = this.type.hasPouch;
    this.hasFrontMount = this.type.hasFrontMount;
    this.frontMountY1 = this.type.frontMountY1;
    this.frontMountZ1 = this.type.frontMountZ1;
    this.frontMountY2 = this.type.frontMountY2;
    this.frontMountZ2 = this.type.frontMountZ2;
    this.frontMountRotation = this.type.frontMountRotation;
    this.hasTopMount = this.type.hasTopMount;
    this.topMountY = this.type.topMountY;
    this.topMountZ = this.type.topMountZ;
    this.topMountRotation = this.type.topMountRotation;
    if (armor.func_77960_j() >= this.type.durability && this.type.energyShield == true)
      return new ISpecialArmor.ArmorProperties(1, this.type.backupDefence, 900); 
    if (armor.func_77960_j() < this.type.durability && this.type.energyShield == true)
      return new ISpecialArmor.ArmorProperties(1, this.type.defence, 900); 
    return new ISpecialArmor.ArmorProperties(1, this.type.defence, 900);
  }
  
  public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
    return (int)(this.type.defence * 20.0D);
  }
  
  public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
    setDamage(stack, (int)((stack.func_77960_j() + 1) + (int)damage / 2.0F));
    if (this.type.energyShield && entity instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer)entity;
      (PlayerHandler.getPlayerData(player)).shieldTimer = this.type.rechargeTimer;
    } 
    if (this.type.energyShield && stack.func_77960_j() < this.type.durability) {
      PacketPlaySound.sendSoundPacket(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 5.0D, entity.field_71093_bK, this.type.ShieldHit, true);
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 25, "crit"), entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 100.0F, entity.field_71093_bK);
      if (entity instanceof EntityPlayer) {
        EntityPlayer player = (EntityPlayer)entity;
        (PlayerHandler.getPlayerData(player)).shieldHit = 10;
      } 
    } 
    if (this.type.energyShield && stack.func_77960_j() == this.type.durability) {
      PacketPlaySound.sendSoundPacket(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 5.0D, entity.field_71093_bK, this.type.ShieldKill, true);
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 75, "fireworksSpark"), entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 150.0F, entity.field_71093_bK);
    } 
    if (stack.func_77960_j() >= this.type.durability && !this.type.energyShield)
      stack.field_77994_a--; 
  }
  
  public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String s) {
    return "flansmod:armor/" + this.type.armourTextureName + "_" + ((this.type.type == 2) ? "2" : "1") + ".png";
  }
  
  public void func_77624_a(ItemStack stack, EntityPlayer player, List<String> lines, boolean b) {
    if (!this.type.packName.isEmpty())
      lines.add(this.type.packName); 
    if (this.type.description != null)
      Collections.addAll(lines, this.type.description.split("_")); 
    lines.add("Defense: " + (float)(10.0D * this.type.defence) + " bars");
    if (this.type.headArmor > 1.0F && !this.type.energyShield)
      lines.add("§2Head protection: " + this.type.headArmor); 
    if (this.type.faceArmor > 1.0F && !this.type.energyShield)
      lines.add("§2Face protection: " + this.type.faceArmor); 
    if (this.type.bodyArmor > 1.0F && !this.type.energyShield)
      lines.add("§2Front Chest protection: " + this.type.bodyArmor); 
    if (this.type.backArmor > 1.0F && !this.type.energyShield)
      lines.add("§2Back Chest protection: " + this.type.backArmor); 
    if (this.type.armArmor > 1.0F && !this.type.energyShield)
      lines.add("§2Arm protection: " + this.type.armArmor); 
    if (this.type.legArmor > 1.0F && !this.type.energyShield)
      lines.add("§2Leg protection: " + this.type.legArmor); 
    if (this.type.napeArmor > 1.0F && !this.type.energyShield)
      lines.add("§2Nape protection: " + this.type.napeArmor); 
    if (this.type.headArmor > 1.0F && this.type.energyShield)
      lines.add("§2Head protection: " + this.secretHead); 
    if (this.type.faceArmor > 1.0F && this.type.energyShield)
      lines.add("§2Face protection: " + this.secretFace); 
    if (this.type.bodyArmor > 1.0F && this.type.energyShield)
      lines.add("§2Front Chest protection: " + this.secretBody); 
    if (this.type.backArmor > 1.0F && this.type.energyShield)
      lines.add("§2Back Chest protection: " + (float)this.secretBack); 
    if (this.type.armArmor > 1.0F && this.type.energyShield)
      lines.add("§2Arm protection: " + this.secretArm); 
    if (this.type.legArmor > 1.0F && this.type.energyShield)
      lines.add("§2Leg protection: " + this.secretLeg); 
    if (this.type.napeArmor > 1.0F && this.type.energyShield)
      lines.add("§2Leg protection: " + this.secretNape); 
    if (this.type.durability > 101.0F)
      lines.add("§2Max Durability: " + this.type.durability); 
    if (Math.abs(this.type.jumpModifier - 1.0F) > 0.01F)
      lines.add("§3+" + (int)((this.type.jumpModifier - 1.0F) * 100.0F) + "% Jump Height"); 
    if (this.type.smokeProtection)
      lines.add("§2+Smoke Protection"); 
    if (this.type.nightVision)
      lines.add("§2+Night Vision"); 
    if (this.type.invisible)
      lines.add("§2+Invisiblity"); 
    if (this.type.negateFallDamage)
      lines.add("§2+Negates Fall Damage"); 
    if (this.type.submarine)
      lines.add("§2+Allows Underwater Breathing"); 
    if (this.type.playermodel)
      lines.add("§2+Custom Player Model"); 
    if (this.type.regenerate)
      lines.add("§2+Has Personal Energy Shield"); 
    if (this.type.hunger)
      lines.add("§c-Reduces Stamina"); 
    if (this.type.hasPouch && this.type.pouchMultiplier > 1.0F)
      lines.add("§c-Reload is " + this.type.pouchMultiplier + "§c times slower"); 
    if (this.type.hasPouch && this.type.pouchMultiplier <= 1.0F)
      lines.add("§2+Reload is " + (1.0F / this.type.pouchMultiplier) + "§2 times faster"); 
    if (this.type.hasOldGunPouch && this.type.pouchMultiplier > 1.0F)
      lines.add("§c-Reload for old firearms is " + this.type.pouchMultiplier + "§c times slower"); 
    if (this.type.hasOldGunPouch && this.type.pouchMultiplier <= 1.0F)
      lines.add("§2+Reload for old firearms is " + (1.0F / this.type.pouchMultiplier) + "§2 times faster"); 
    if (this.type.hasBowPouch && this.type.pouchMultiplier > 1.0F)
      lines.add("§c-Reload for bows is " + this.type.pouchMultiplier + "§c times slower"); 
    if (this.type.hasBowPouch && this.type.pouchMultiplier <= 1.0F)
      lines.add("§2+Reload for bows is " + (1.0F / this.type.pouchMultiplier) + "§2 times faster"); 
    if (this.type.hasHeavyPouch && this.type.pouchMultiplier > 1.0F)
      lines.add("§c-Reload for heavy weapons is " + this.type.pouchMultiplier + "§c times slower"); 
    if (this.type.hasHeavyPouch && this.type.pouchMultiplier <= 1.0F)
      lines.add("§2+Reload for heavy weapons is " + (1.0F / this.type.pouchMultiplier) + "§2 times faster"); 
    if (this.type.hasGunPouch && this.type.pouchMultiplier > 1.0F)
      lines.add("§c-Reload for repeating firearms is " + this.type.pouchMultiplier + "§c times slower"); 
    if (this.type.hasGunPouch && this.type.pouchMultiplier <= 1.0F)
      lines.add("§2+Reload for repeating firearms is " + (1.0F / this.type.pouchMultiplier) + "§2 times faster"); 
  }
  
  @SideOnly(Side.CLIENT)
  public int func_82790_a(ItemStack par1ItemStack, int par2) {
    return this.type.colour;
  }
  
  @SideOnly(Side.CLIENT)
  public boolean func_77623_v() {
    return false;
  }
  
  @SideOnly(Side.CLIENT)
  public void func_94581_a(IIconRegister icon) {
    this.field_77791_bV = icon.func_94245_a("FlansMod:" + this.type.iconPath);
  }
  
  public Multimap getAttributeModifiers(ItemStack stack) {
    Multimap map = super.getAttributeModifiers(stack);
    map.put(SharedMonsterAttributes.field_111266_c.func_111108_a(), new AttributeModifier(uuid[this.type.type], "KnockbackResist", this.type.knockbackModifier, 0));
    map.put(SharedMonsterAttributes.field_111263_d.func_111108_a(), new AttributeModifier(uuid[this.type.type], "MovementSpeed", (this.type.moveSpeedModifier - 1.0F), 2));
    map.put(SharedMonsterAttributes.field_111263_d.func_111108_a(), new AttributeModifier(uuid[this.type.type], "hunger", (this.type.moveSpeedModifier - 1.0F), 2));
    return map;
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
    return (ModelBiped)this.type.model;
  }
  
  public InfoType getInfoType() {
    return this.type;
  }
  
  public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
    if (this.type.energyShield && itemStack.func_77960_j() > this.type.durability + 2)
      setDamage(itemStack, itemStack.func_77960_j() - 1); 
    if (itemStack.func_77960_j() == 0)
      (PlayerHandler.getPlayerData(player)).shieldTimer = this.type.rechargeTimer; 
    if (itemStack.func_77960_j() >= 0 && (PlayerHandler.getPlayerData(player)).shieldTimer > 0)
      (PlayerHandler.getPlayerData(player)).shieldTimer--; 
    if (itemStack.func_77960_j() >= 0 && (PlayerHandler.getPlayerData(player)).shieldTimer == 0 && this.type.energyShield) {
      (PlayerHandler.getPlayerData(player)).rechargeTimer++;
      if ((PlayerHandler.getPlayerData(player)).rechargeTimer == this.type.rechargeDelay)
        (PlayerHandler.getPlayerData(player)).rechargeTimer = 0; 
      if ((PlayerHandler.getPlayerData(player)).rechargeTimer == 1)
        setDamage(itemStack, itemStack.func_77960_j() - 1); 
    } 
    if (itemStack.func_77960_j() >= 0 && (PlayerHandler.getPlayerData(player)).shieldTimer == 1 && this.type.energyShield) {
      PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, 5.0D, player.field_71093_bK, this.type.rechargeSound, true);
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(player.field_70165_t, player.field_70163_u, player.field_70161_v, 100, "instantSpell"), player.field_70165_t, player.field_70163_u, player.field_70161_v, 100.0F, player.field_71093_bK);
    } 
    if (itemStack.func_77960_j() < this.type.durability && this.type.energyShield)
      (PlayerHandler.getPlayerData(player)).SoundTimer = 0; 
    if (itemStack.func_77960_j() >= this.type.durability) {
      this.secretBody = this.type.ReserveBodyArmor;
      (PlayerHandler.getPlayerData(player)).SoundTimer++;
      if ((PlayerHandler.getPlayerData(player)).SoundTimer == this.type.warningSoundTimer)
        (PlayerHandler.getPlayerData(player)).SoundTimer = 0; 
      if ((PlayerHandler.getPlayerData(player)).SoundTimer == 1 && (PlayerHandler.getPlayerData(player)).shieldTimer > 1)
        PacketPlaySound.sendSoundPacket(player.field_70165_t, player.field_70163_u, player.field_70161_v, 5.0D, player.field_71093_bK, this.type.warningSound, false); 
    } else if (itemStack.func_77960_j() < this.type.durability) {
      this.secretBody = this.type.bodyArmor;
    } 
    if (itemStack.func_77960_j() >= this.type.durability) {
      this.secretBack = this.type.ReserveBackArmor;
    } else if (itemStack.func_77960_j() < this.type.durability) {
      this.secretBack = this.type.backArmor;
    } 
    if (itemStack.func_77960_j() >= this.type.durability) {
      this.secretHead = this.type.ReserveHeadArmor;
    } else if (itemStack.func_77960_j() < this.type.durability) {
      this.secretHead = this.type.headArmor;
    } 
    if (itemStack.func_77960_j() >= this.type.durability) {
      this.secretNape = this.type.ReserveNapeArmor;
    } else if (itemStack.func_77960_j() < this.type.durability) {
      this.secretNape = this.type.napeArmor;
    } 
    if (itemStack.func_77960_j() >= this.type.durability) {
      this.secretFace = this.type.ReserveFaceArmor;
    } else if (itemStack.func_77960_j() < this.type.durability) {
      this.secretFace = this.type.faceArmor;
    } 
    if (itemStack.func_77960_j() >= this.type.durability) {
      this.secretArm = this.type.ReserveArmArmor;
    } else if (itemStack.func_77960_j() < this.type.durability) {
      this.secretArm = this.type.armArmor;
    } 
    if (itemStack.func_77960_j() >= this.type.durability) {
      this.secretLeg = this.type.ReserveLegArmor;
    } else if (itemStack.func_77960_j() < this.type.durability) {
      this.secretLeg = this.type.legArmor;
    } 
    if (this.type.nightVision && FlansMod.ticker % 25 == 0)
      player.func_70690_d(new PotionEffect(Potion.field_76439_r.field_76415_H, 250)); 
    if (this.type.invisible && FlansMod.ticker % 25 == 0) {
      player.func_70690_d(new PotionEffect(Potion.field_76441_p.field_76415_H, 250));
      (PlayerHandler.getPlayerData(player)).invisArmor = true;
    } 
    if (!this.type.invisible)
      (PlayerHandler.getPlayerData(player)).invisArmor = false; 
    if (this.type.jumpModifier > 1.01F && FlansMod.ticker % 25 == 0)
      player.func_70690_d(new PotionEffect(Potion.field_76430_j.field_76415_H, 250, (int)((this.type.jumpModifier - 1.0F) * 2.0F), true)); 
    if (this.type.submarine && FlansMod.ticker % 25 == 0)
      player.func_70690_d(new PotionEffect(Potion.field_76427_o.field_76415_H, 250)); 
    if (this.type.playermodel && FlansMod.ticker % 25 == 0)
      player.func_70690_d(new PotionEffect(Potion.field_76441_p.field_76415_H, 100)); 
    if (this.type.hunger && FlansMod.ticker % 25 == 0)
      player.func_70690_d(new PotionEffect(Potion.field_76438_s.field_76415_H, 250)); 
    if (this.type.regenerate && FlansMod.ticker % 25 == 0)
      player.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 250)); 
    if (this.type.negateFallDamage)
      player.field_70143_R = 0.0F; 
    if (this.type.onWaterWalking)
      if (player.func_70090_H()) {
        player.field_71075_bZ.field_75101_c = true;
      } else {
        player.field_71075_bZ.field_75100_b = false;
      }  
  }
}
