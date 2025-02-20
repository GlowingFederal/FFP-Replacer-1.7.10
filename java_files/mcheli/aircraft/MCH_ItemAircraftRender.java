/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import mcheli.MCH_ModelManager;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MCH_ItemAircraftRender
/*     */   implements IItemRenderer {
/*  11 */   float size = 0.1F;
/*  12 */   float x = 0.1F;
/*  13 */   float y = 0.1F;
/*  14 */   float z = 0.1F;
/*     */ 
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
/*  18 */     if (item != null && item.func_77973_b() instanceof MCH_ItemAircraft) {
/*  19 */       MCH_AircraftInfo info = ((MCH_ItemAircraft)item.func_77973_b()).getAircraftInfo();
/*  20 */       if (info == null) {
/*  21 */         return false;
/*     */       }
/*     */       
/*  24 */       if (info != null && info.name.equalsIgnoreCase("mh-60l_dap")) {
/*  25 */         return (type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON || type == IItemRenderer.ItemRenderType.ENTITY || type == IItemRenderer.ItemRenderType.INVENTORY);
/*     */       }
/*     */     } 
/*     */     
/*  29 */     return false;
/*     */   }
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
/*  33 */     return (type == IItemRenderer.ItemRenderType.ENTITY || type == IItemRenderer.ItemRenderType.INVENTORY);
/*     */   }
/*     */   
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
/*  37 */     boolean isRender = true;
/*  38 */     GL11.glPushMatrix();
/*  39 */     GL11.glEnable(2884);
/*  40 */     W_McClient.MOD_bindTexture("textures/helicopters/mh-60l_dap.png");
/*  41 */     switch (type) {
/*     */       case null:
/*  43 */         GL11.glEnable(32826);
/*  44 */         GL11.glEnable(2903);
/*  45 */         GL11.glScalef(0.1F, 0.1F, 0.1F);
/*  46 */         MCH_ModelManager.render("helicopters", "mh-60l_dap");
/*  47 */         GL11.glDisable(32826);
/*     */         break;
/*     */       case null:
/*  50 */         GL11.glEnable(32826);
/*  51 */         GL11.glEnable(2903);
/*  52 */         GL11.glTranslatef(0.0F, 0.005F, -0.165F);
/*  53 */         GL11.glScalef(0.1F, 0.1F, 0.1F);
/*  54 */         GL11.glRotatef(-10.0F, 0.0F, 0.0F, 1.0F);
/*  55 */         GL11.glRotatef(90.0F, 0.0F, -1.0F, 0.0F);
/*  56 */         GL11.glRotatef(-50.0F, 1.0F, 0.0F, 0.0F);
/*  57 */         MCH_ModelManager.render("helicopters", "mh-60l_dap");
/*  58 */         GL11.glDisable(32826);
/*     */         break;
/*     */       case null:
/*  61 */         GL11.glEnable(32826);
/*  62 */         GL11.glEnable(2903);
/*  63 */         GL11.glTranslatef(0.3F, 0.5F, -0.5F);
/*  64 */         GL11.glScalef(0.1F, 0.1F, 0.1F);
/*  65 */         GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/*  66 */         GL11.glRotatef(140.0F, 0.0F, 1.0F, 0.0F);
/*  67 */         GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
/*  68 */         MCH_ModelManager.render("helicopters", "mh-60l_dap");
/*  69 */         GL11.glDisable(32826);
/*     */         break;
/*     */       case null:
/*  72 */         GL11.glTranslatef(this.x, this.y, this.z);
/*  73 */         GL11.glScalef(this.size, this.size, this.size);
/*  74 */         MCH_ModelManager.render("helicopters", "mh-60l_dap");
/*     */         break;
/*     */       
/*     */       default:
/*  78 */         isRender = false;
/*     */         break;
/*     */     } 
/*  81 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class NamelessClass956700996
/*     */   {
/*  88 */     static final int[] $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType = new int[(IItemRenderer.ItemRenderType.values()).length];
/*     */ 
/*     */     
/*     */     static {
/*     */       try {
/*  93 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.ENTITY.ordinal()] = 1;
/*  94 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/*  99 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.EQUIPPED.ordinal()] = 2;
/* 100 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 105 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON.ordinal()] = 3;
/* 106 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 111 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.INVENTORY.ordinal()] = 4;
/* 112 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 117 */         $SwitchMap$net$minecraftforge$client$IItemRenderer$ItemRenderType[IItemRenderer.ItemRenderType.FIRST_PERSON_MAP.ordinal()] = 5;
/* 118 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_ItemAircraftRender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */