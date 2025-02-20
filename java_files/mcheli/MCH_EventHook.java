/*     */ package mcheli;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.aircraft.MCH_ItemAircraft;
/*     */ import mcheli.command.MCH_Command;
/*     */ import mcheli.weapon.MCH_EntityBaseBullet;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_EntityPlayer;
/*     */ import mcheli.wrapper.W_EventHook;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.event.CommandEvent;
/*     */ import net.minecraftforge.event.entity.EntityEvent;
/*     */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingAttackEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.event.entity.player.EntityInteractEvent;
/*     */ 
/*     */ public class MCH_EventHook
/*     */   extends W_EventHook
/*     */ {
/*     */   public void commandEvent(CommandEvent event) {
/*  28 */     MCH_Command.onCommandEvent(event);
/*     */   }
/*     */   
/*     */   public void entitySpawn(EntityJoinWorldEvent event) {
/*  32 */     if (W_Lib.isEntityLivingBase(event.entity) && !W_EntityPlayer.isPlayer(event.entity)) {
/*  33 */       MCH_Config var10002 = MCH_MOD.config;
/*  34 */       event.entity.field_70155_l *= MCH_Config.MobRenderDistanceWeight.prmDouble;
/*  35 */     } else if (event.entity instanceof MCH_EntityAircraft) {
/*  36 */       MCH_EntityAircraft b = (MCH_EntityAircraft)event.entity;
/*  37 */       if (!b.field_70170_p.field_72995_K && !b.isCreatedSeats()) {
/*  38 */         b.createSeats(UUID.randomUUID().toString());
/*     */       }
/*  40 */     } else if (W_EntityPlayer.isPlayer(event.entity)) {
/*  41 */       Entity e = event.entity;
/*  42 */       boolean b1 = Float.isNaN(e.field_70125_A);
/*  43 */       b1 |= Float.isNaN(e.field_70127_C);
/*  44 */       b1 |= Float.isInfinite(e.field_70125_A);
/*  45 */       b1 |= Float.isInfinite(e.field_70127_C);
/*  46 */       if (b1) {
/*  47 */         MCH_Lib.Log(event.entity, "### EntityJoinWorldEvent Error:Player invalid rotation pitch(" + e.field_70125_A + ")", new Object[0]);
/*  48 */         e.field_70125_A = 0.0F;
/*  49 */         e.field_70127_C = 0.0F;
/*     */       } 
/*     */       
/*  52 */       b1 = Float.isInfinite(e.field_70177_z);
/*  53 */       b1 |= Float.isInfinite(e.field_70126_B);
/*  54 */       b1 |= Float.isNaN(e.field_70177_z);
/*  55 */       b1 |= Float.isNaN(e.field_70126_B);
/*  56 */       if (b1) {
/*  57 */         MCH_Lib.Log(event.entity, "### EntityJoinWorldEvent Error:Player invalid rotation yaw(" + e.field_70177_z + ")", new Object[0]);
/*  58 */         e.field_70177_z = 0.0F;
/*  59 */         e.field_70126_B = 0.0F;
/*     */       } 
/*     */       
/*  62 */       if (!e.field_70170_p.field_72995_K && event.entity instanceof EntityPlayerMP) {
/*  63 */         MCH_Lib.DbgLog(false, "EntityJoinWorldEvent:" + event.entity, new Object[0]);
/*  64 */         MCH_PacketNotifyServerSettings.send((EntityPlayerMP)event.entity);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void livingAttackEvent(LivingAttackEvent event) {
/*  71 */     MCH_EntityAircraft ac = getRiddenAircraft(event.entity);
/*  72 */     if (ac != null && 
/*  73 */       ac.getAcInfo() != null && 
/*  74 */       !ac.isDestroyed() && 
/*  75 */       (ac.getAcInfo()).damageFactor <= 0.0F) {
/*  76 */       Entity attackEntity = event.source.func_76346_g();
/*  77 */       if (attackEntity == null) {
/*  78 */         event.setCanceled(true);
/*  79 */       } else if (W_Entity.isEqual(attackEntity, event.entity)) {
/*  80 */         event.setCanceled(true);
/*  81 */       } else if (ac.isMountedEntity(attackEntity)) {
/*  82 */         event.setCanceled(true);
/*     */       } else {
/*  84 */         MCH_EntityAircraft atkac = getRiddenAircraft(attackEntity);
/*  85 */         if (W_Entity.isEqual((Entity)atkac, (Entity)ac)) {
/*  86 */           event.setCanceled(true);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void livingHurtEvent(LivingHurtEvent event) {
/*  97 */     MCH_EntityAircraft ac = getRiddenAircraft(event.entity);
/*  98 */     if (ac != null && 
/*  99 */       ac.getAcInfo() != null) {
/* 100 */       if (ac.isNewUAV()) {
/* 101 */         event.setCanceled(true);
/*     */         return;
/*     */       } 
/* 104 */       if (!ac.isDestroyed()) {
/* 105 */         Entity attackEntity = event.source.func_76346_g();
/* 106 */         if (attackEntity == null) {
/* 107 */           ac.func_70097_a(event.source, event.ammount * 2.0F);
/* 108 */           event.ammount *= (ac.getAcInfo()).damageFactor;
/* 109 */         } else if (W_Entity.isEqual(attackEntity, event.entity)) {
/* 110 */           ac.func_70097_a(event.source, event.ammount * 2.0F);
/* 111 */           event.ammount *= (ac.getAcInfo()).damageFactor;
/* 112 */         } else if (ac.isMountedEntity(attackEntity)) {
/* 113 */           event.ammount = 0.0F;
/* 114 */           event.setCanceled(true);
/*     */         } else {
/* 116 */           MCH_EntityAircraft atkac = getRiddenAircraft(attackEntity);
/* 117 */           if (W_Entity.isEqual((Entity)atkac, (Entity)ac)) {
/* 118 */             event.ammount = 0.0F;
/* 119 */             event.setCanceled(true);
/*     */           } else {
/* 121 */             ac.func_70097_a(event.source, event.ammount * 2.0F);
/* 122 */             event.ammount *= (ac.getAcInfo()).damageFactor;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MCH_EntityAircraft getRiddenAircraft(Entity entity) {
/* 132 */     MCH_EntityAircraft ac = null;
/* 133 */     Entity ridden = entity.field_70154_o;
/* 134 */     if (ridden instanceof MCH_EntityAircraft) {
/* 135 */       ac = (MCH_EntityAircraft)ridden;
/* 136 */     } else if (ridden instanceof MCH_EntitySeat) {
/* 137 */       ac = ((MCH_EntitySeat)ridden).getParent();
/*     */     } 
/*     */     
/* 140 */     if (ac == null) {
/* 141 */       List<MCH_EntityAircraft> list = entity.field_70170_p.func_72872_a(MCH_EntityAircraft.class, entity.field_70121_D.func_72314_b(50.0D, 50.0D, 50.0D));
/* 142 */       if (list != null) {
/* 143 */         for (int i = 0; i < list.size(); i++) {
/* 144 */           MCH_EntityAircraft tmp = list.get(i);
/* 145 */           if (tmp.isMountedEntity(entity)) {
/* 146 */             return tmp;
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 152 */     return ac;
/*     */   }
/*     */   
/*     */   public void entityInteractEvent(EntityInteractEvent event) {
/* 156 */     ItemStack item = event.entityPlayer.func_70694_bm();
/* 157 */     if (item != null && 
/* 158 */       item.func_77973_b() instanceof MCH_ItemAircraft && 
/* 159 */       !MCH_CommonProxy.checkSafeZone(event.entityPlayer)) {
/* 160 */       ((MCH_ItemAircraft)item.func_77973_b()).rideEntity(item, event.target, event.entityPlayer);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void entityCanUpdate(EntityEvent.CanUpdate event) {
/* 168 */     if (event.entity instanceof MCH_EntityBaseBullet) {
/* 169 */       MCH_EntityBaseBullet bullet = (MCH_EntityBaseBullet)event.entity;
/* 170 */       bullet.func_70106_y();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_EventHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */