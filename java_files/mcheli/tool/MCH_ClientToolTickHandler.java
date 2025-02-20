/*     */ package mcheli.tool;
/*     */ 
/*     */ import mcheli.MCH_ClientTickHandlerBase;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Key;
/*     */ import mcheli.tool.rangefinder.MCH_ItemRangeFinder;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_Reflection;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class MCH_ClientToolTickHandler
/*     */   extends MCH_ClientTickHandlerBase
/*     */ {
/*     */   public MCH_Key KeyUseItem;
/*     */   public MCH_Key KeyZoomIn;
/*     */   public MCH_Key KeyZoomOut;
/*     */   public MCH_Key KeySwitchMode;
/*     */   public MCH_Key[] Keys;
/*     */   
/*     */   public MCH_ClientToolTickHandler(Minecraft minecraft, MCH_Config config) {
/*  23 */     super(minecraft);
/*  24 */     updateKeybind(config);
/*     */   }
/*     */   
/*     */   public void updateKeybind(MCH_Config config) {
/*  28 */     this.KeyUseItem = new MCH_Key(MCH_Config.KeyAttack.prmInt);
/*  29 */     this.KeyZoomIn = new MCH_Key(MCH_Config.KeyZoom.prmInt);
/*  30 */     this.KeyZoomOut = new MCH_Key(MCH_Config.KeySwWeaponMode.prmInt);
/*  31 */     this.KeySwitchMode = new MCH_Key(MCH_Config.KeyFlare.prmInt);
/*  32 */     this.Keys = new MCH_Key[] { this.KeyUseItem, this.KeyZoomIn, this.KeyZoomOut, this.KeySwitchMode };
/*     */   }
/*     */   
/*     */   protected void onTick(boolean inGUI) {
/*  36 */     MCH_Key[] arr$ = this.Keys;
/*  37 */     int len$ = arr$.length;
/*     */     
/*  39 */     for (int i$ = 0; i$ < len$; i$++) {
/*  40 */       MCH_Key k = arr$[i$];
/*  41 */       k.update();
/*     */     } 
/*     */     
/*  44 */     onTick_ItemWrench(inGUI, (EntityPlayer)this.mc.field_71439_g);
/*  45 */     onTick_ItemRangeFinder(inGUI, (EntityPlayer)this.mc.field_71439_g);
/*     */   }
/*     */   
/*     */   private void onTick_ItemRangeFinder(boolean inGUI, EntityPlayer player) {
/*  49 */     if (MCH_ItemRangeFinder.rangeFinderUseCooldown > 0) {
/*  50 */       MCH_ItemRangeFinder.rangeFinderUseCooldown--;
/*     */     }
/*     */     
/*  53 */     ItemStack itemStack = null;
/*  54 */     if (player != null) {
/*  55 */       itemStack = this.mc.field_71439_g.func_71045_bC();
/*  56 */       if (itemStack != null && itemStack.func_77973_b() instanceof MCH_ItemRangeFinder) {
/*  57 */         boolean usingItem = (player.func_71057_bx() > 8 && MCH_ItemRangeFinder.canUse(player));
/*  58 */         if (!MCH_ItemRangeFinder.continueUsingItem && usingItem) {
/*  59 */           MCH_ItemRangeFinder.onStartUseItem();
/*     */         }
/*     */         
/*  62 */         if (usingItem) {
/*  63 */           if (this.KeyUseItem.isKeyDown()) {
/*  64 */             ((MCH_ItemRangeFinder)itemStack.func_77973_b()).spotEntity(player, itemStack);
/*     */           }
/*     */           
/*  67 */           if (this.KeyZoomIn.isKeyPress() && MCH_ItemRangeFinder.zoom < 10.0F) {
/*  68 */             MCH_ItemRangeFinder.zoom += MCH_ItemRangeFinder.zoom / 10.0F;
/*  69 */             if (MCH_ItemRangeFinder.zoom > 10.0F) {
/*  70 */               MCH_ItemRangeFinder.zoom = 10.0F;
/*     */             }
/*     */             
/*  73 */             W_McClient.MOD_playSoundFX("zoom", 0.05F, 1.0F);
/*  74 */             W_Reflection.setCameraZoom(MCH_ItemRangeFinder.zoom);
/*     */           } 
/*     */           
/*  77 */           if (this.KeyZoomOut.isKeyPress() && MCH_ItemRangeFinder.zoom > 1.2F) {
/*  78 */             MCH_ItemRangeFinder.zoom -= MCH_ItemRangeFinder.zoom / 10.0F;
/*  79 */             if (MCH_ItemRangeFinder.zoom < 1.2F) {
/*  80 */               MCH_ItemRangeFinder.zoom = 1.2F;
/*     */             }
/*     */             
/*  83 */             W_McClient.MOD_playSoundFX("zoom", 0.05F, 0.9F);
/*  84 */             W_Reflection.setCameraZoom(MCH_ItemRangeFinder.zoom);
/*     */           } 
/*     */           
/*  87 */           if (this.KeySwitchMode.isKeyDown()) {
/*  88 */             W_McClient.MOD_playSoundFX("lockon", 1.0F, 0.9F);
/*  89 */             MCH_ItemRangeFinder.mode = (MCH_ItemRangeFinder.mode + 1) % 3;
/*  90 */             if (this.mc.func_71356_B() && MCH_ItemRangeFinder.mode == 0) {
/*  91 */               MCH_ItemRangeFinder.mode = 1;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  98 */     if (MCH_ItemRangeFinder.continueUsingItem && (itemStack == null || !(itemStack.func_77973_b() instanceof MCH_ItemRangeFinder))) {
/*  99 */       MCH_ItemRangeFinder.onStopUseItem();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void onTick_ItemWrench(boolean inGUI, EntityPlayer player) {
/* 105 */     if (player != null) {
/* 106 */       ItemStack itemStack = player.func_71045_bC();
/* 107 */       if (itemStack != null && itemStack.func_77973_b() instanceof MCH_ItemWrench) {
/* 108 */         int maxdm = itemStack.func_77958_k();
/* 109 */         int dm = itemStack.func_77960_j();
/* 110 */         if (dm <= maxdm) {
/* 111 */           ItemStack renderItemstack = W_Reflection.getItemRenderer_ItemToRender();
/* 112 */           if (renderItemstack == null || itemStack.func_77973_b() == renderItemstack.func_77973_b())
/* 113 */             W_Reflection.setItemRenderer_ItemToRender(player.field_71071_by.func_70448_g()); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tool\MCH_ClientToolTickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */