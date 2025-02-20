/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import mcheli.MCH_ClientTickHandlerBase;
/*    */ import mcheli.MCH_Config;
/*    */ import mcheli.MCH_Key;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ public class MCH_ClientSeatTickHandler
/*    */   extends MCH_ClientTickHandlerBase
/*    */ {
/*    */   protected boolean isRiding = false;
/*    */   protected boolean isBeforeRiding = false;
/*    */   public MCH_Key KeySwitchNextSeat;
/*    */   public MCH_Key KeySwitchPrevSeat;
/*    */   
/*    */   public MCH_ClientSeatTickHandler(Minecraft minecraft, MCH_Config config) {
/* 25 */     super(minecraft);
/* 26 */     updateKeybind(config);
/*    */   }
/*    */   public MCH_Key KeyParachuting; public MCH_Key KeyFreeLook; public MCH_Key KeyUnmountForce; public MCH_Key[] Keys;
/*    */   public void updateKeybind(MCH_Config config) {
/* 30 */     this.KeySwitchNextSeat = new MCH_Key(MCH_Config.KeyExtra.prmInt);
/* 31 */     this.KeySwitchPrevSeat = new MCH_Key(MCH_Config.KeyGUI.prmInt);
/* 32 */     this.KeyParachuting = new MCH_Key(MCH_Config.KeySwitchHovering.prmInt);
/* 33 */     this.KeyUnmountForce = new MCH_Key(42);
/* 34 */     this.KeyFreeLook = new MCH_Key(MCH_Config.KeyFreeLook.prmInt);
/* 35 */     this.Keys = new MCH_Key[] { this.KeySwitchNextSeat, this.KeySwitchPrevSeat, this.KeyParachuting, this.KeyUnmountForce, this.KeyFreeLook };
/*    */   }
/*    */   
/*    */   protected void onTick(boolean inGUI) {
/* 39 */     MCH_Key[] player = this.Keys;
/* 40 */     int seat = player.length;
/*    */     
/* 42 */     for (int ac = 0; ac < seat; ac++) {
/* 43 */       MCH_Key k = player[ac];
/* 44 */       k.update();
/*    */     } 
/*    */     
/* 47 */     this.isBeforeRiding = this.isRiding;
/* 48 */     EntityClientPlayerMP var6 = this.mc.field_71439_g;
/* 49 */     if (var6 != null && var6.field_70154_o instanceof MCH_EntitySeat) {
/* 50 */       MCH_EntitySeat var7 = (MCH_EntitySeat)var6.field_70154_o;
/* 51 */       if (var7.getParent() == null || var7.getParent().getAcInfo() == null) {
/*    */         return;
/*    */       }
/*    */       
/* 55 */       MCH_EntityAircraft var8 = var7.getParent();
/* 56 */       if (!inGUI && !var8.isDestroyed()) {
/* 57 */         playerControl((EntityPlayer)var6, var7, var8);
/*    */       }
/*    */       
/* 60 */       this.isRiding = true;
/*    */     } else {
/* 62 */       this.isRiding = false;
/*    */     } 
/*    */     
/* 65 */     if (this.isBeforeRiding != this.isRiding && !this.isRiding) {
/* 66 */       MCH_Lib.setRenderViewEntity((EntityLivingBase)var6);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private void playerControlInGUI(EntityPlayer player, MCH_EntitySeat seat, MCH_EntityAircraft ac) {}
/*    */   
/*    */   private void playerControl(EntityPlayer player, MCH_EntitySeat seat, MCH_EntityAircraft ac) {
/* 74 */     MCH_PacketSeatPlayerControl pc = new MCH_PacketSeatPlayerControl();
/* 75 */     boolean send = false;
/* 76 */     if (this.KeyFreeLook.isKeyDown() && ac.canSwitchGunnerFreeLook(player)) {
/* 77 */       ac.switchGunnerFreeLookMode();
/*    */     }
/*    */     
/* 80 */     if (this.KeyParachuting.isKeyDown()) {
/* 81 */       if (ac.canParachuting((Entity)player)) {
/* 82 */         pc.parachuting = true;
/* 83 */         send = true;
/* 84 */       } else if (ac.canRepelling((Entity)player)) {
/* 85 */         pc.parachuting = true;
/* 86 */         send = true;
/*    */       } else {
/* 88 */         playSoundNG();
/*    */       } 
/*    */     }
/*    */     
/* 92 */     if (send)
/* 93 */       W_Network.sendToServer((W_PacketBase)pc); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_ClientSeatTickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */