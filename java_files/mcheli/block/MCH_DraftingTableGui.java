/*     */ package mcheli.block;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_IRecipeList;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_RenderAircraft;
/*     */ import mcheli.gui.MCH_GuiSliderVertical;
/*     */ import mcheli.helicopter.MCH_HeliInfoManager;
/*     */ import mcheli.plane.MCP_PlaneInfoManager;
/*     */ import mcheli.tank.MCH_TankInfoManager;
/*     */ import mcheli.vehicle.MCH_VehicleInfoManager;
/*     */ import mcheli.wrapper.W_GuiButton;
/*     */ import mcheli.wrapper.W_GuiContainer;
/*     */ import mcheli.wrapper.W_KeyBinding;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_ScaledResolution;
/*     */ import mcheli.wrapper.modelloader.W_ModelCustom;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.item.crafting.ShapedRecipes;
/*     */ import net.minecraft.item.crafting.ShapelessRecipes;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_DraftingTableGui
/*     */   extends W_GuiContainer
/*     */ {
/*     */   private final EntityPlayer thePlayer;
/*     */   private int scaleFactor;
/*     */   private MCH_GuiSliderVertical listSlider;
/*     */   private GuiButton buttonCreate;
/*     */   private GuiButton buttonNext;
/*     */   private GuiButton buttonPrev;
/*     */   private GuiButton buttonNextPage;
/*     */   private GuiButton buttonPrevPage;
/*     */   private int drawFace;
/*     */   private int buttonClickWait;
/*     */   public static final int RECIPE_HELI = 0;
/*     */   public static final int RECIPE_PLANE = 1;
/*     */   public static final int RECIPE_VEHICLE = 2;
/*     */   public static final int RECIPE_TANK = 3;
/*  64 */   public int screenId = 0; public static final int RECIPE_ITEM = 4; public MCH_IRecipeList currentList; public MCH_CurrentRecipe current; public static final int BUTTON_HELI = 10; public static final int BUTTON_PLANE = 11; public static final int BUTTON_VEHICLE = 12; public static final int BUTTON_TANK = 13; public static final int BUTTON_ITEM = 14; public static final int BUTTON_NEXT = 20; public static final int BUTTON_PREV = 21; public static final int BUTTON_CREATE = 30; public static final int BUTTON_SELECT = 40; public static final int BUTTON_NEXT_PAGE = 50; public static final int BUTTON_PREV_PAGE = 51; public List screenButtonList;
/*     */   public static final int SCREEN_MAIN = 0;
/*     */   public static final int SCREEN_LIST = 1;
/*  67 */   public static float modelZoom = 1.0F;
/*  68 */   public static float modelRotX = 0.0F;
/*  69 */   public static float modelRotY = 0.0F;
/*  70 */   public static float modelPosX = 0.0F;
/*  71 */   public static float modelPosY = 0.0F;
/*     */ 
/*     */   
/*     */   public MCH_DraftingTableGui(EntityPlayer player, int posX, int posY, int posZ) {
/*  75 */     super(new MCH_DraftingTableGuiContainer(player, posX, posY, posZ));
/*  76 */     this.thePlayer = player;
/*  77 */     this.field_146999_f = 400;
/*  78 */     this.field_147000_g = 240;
/*  79 */     this.screenButtonList = new ArrayList();
/*  80 */     this.drawFace = 0;
/*  81 */     this.buttonClickWait = 0;
/*  82 */     MCH_Lib.DbgLog(player.field_70170_p, "MCH_DraftingTableGui.MCH_DraftingTableGui", new Object[0]);
/*     */   }
/*     */   
/*     */   public void func_73866_w_() {
/*  86 */     super.func_73866_w_();
/*  87 */     this.field_146292_n.clear();
/*  88 */     this.screenButtonList.clear();
/*  89 */     this.screenButtonList.add(new ArrayList());
/*  90 */     this.screenButtonList.add(new ArrayList());
/*  91 */     List<GuiButton> list = null;
/*  92 */     list = this.screenButtonList.get(0);
/*  93 */     GuiButton btnHeli = new GuiButton(10, this.field_147003_i + 20, this.field_147009_r + 20, 90, 20, "Helicopter List");
/*  94 */     GuiButton btnPlane = new GuiButton(11, this.field_147003_i + 20, this.field_147009_r + 40, 90, 20, "Plane List");
/*  95 */     GuiButton btnVehicle = new GuiButton(12, this.field_147003_i + 20, this.field_147009_r + 60, 90, 20, "Vehicle List");
/*  96 */     GuiButton btnTank = new GuiButton(13, this.field_147003_i + 20, this.field_147009_r + 80, 90, 20, "Tank List");
/*  97 */     GuiButton btnItem = new GuiButton(14, this.field_147003_i + 20, this.field_147009_r + 100, 90, 20, "Item List");
/*  98 */     btnHeli.field_146124_l = (MCH_HeliInfoManager.getInstance().getRecipeListSize() > 0);
/*  99 */     btnPlane.field_146124_l = (MCP_PlaneInfoManager.getInstance().getRecipeListSize() > 0);
/* 100 */     btnVehicle.field_146124_l = (MCH_VehicleInfoManager.getInstance().getRecipeListSize() > 0);
/* 101 */     btnTank.field_146124_l = (MCH_TankInfoManager.getInstance().getRecipeListSize() > 0);
/* 102 */     list.add(btnHeli);
/* 103 */     list.add(btnPlane);
/* 104 */     list.add(btnVehicle);
/* 105 */     list.add(btnTank);
/* 106 */     list.add(btnItem);
/* 107 */     this.buttonCreate = new GuiButton(30, this.field_147003_i + 120, this.field_147009_r + 89, 50, 20, "Create");
/* 108 */     this.buttonPrev = new GuiButton(21, this.field_147003_i + 120, this.field_147009_r + 111, 36, 20, "<<");
/* 109 */     this.buttonNext = new GuiButton(20, this.field_147003_i + 155, this.field_147009_r + 111, 35, 20, ">>");
/* 110 */     list.add(this.buttonCreate);
/* 111 */     list.add(this.buttonPrev);
/* 112 */     list.add(this.buttonNext);
/* 113 */     this.buttonPrevPage = new GuiButton(51, this.field_147003_i + 210, this.field_147009_r + 210, 60, 20, "Prev Page");
/* 114 */     this.buttonNextPage = new GuiButton(50, this.field_147003_i + 270, this.field_147009_r + 210, 60, 20, "Next Page");
/* 115 */     list.add(this.buttonPrevPage);
/* 116 */     list.add(this.buttonNextPage);
/* 117 */     list = this.screenButtonList.get(1);
/* 118 */     int i = 0;
/*     */     
/*     */     int j;
/* 121 */     for (j = 0; i < 3; i++) {
/* 122 */       for (int x = 0; x < 2; j++) {
/* 123 */         int px = this.field_147003_i + 30 + x * 140;
/* 124 */         int py = this.field_147009_r + 40 + i * 70;
/* 125 */         list.add(new GuiButton(40 + j, px, py, 45, 20, "Select"));
/* 126 */         x++;
/*     */       } 
/*     */     } 
/*     */     
/* 130 */     this.listSlider = new MCH_GuiSliderVertical(0, this.field_147003_i + 360, this.field_147009_r + 20, 20, 200, "", 0.0F, 0.0F, 0.0F, 1.0F);
/* 131 */     list.add(this.listSlider);
/*     */     
/* 133 */     for (i = 0; i < this.screenButtonList.size(); i++) {
/* 134 */       list = this.screenButtonList.get(i);
/*     */       
/* 136 */       for (j = 0; j < list.size(); j++) {
/* 137 */         this.field_146292_n.add(list.get(j));
/*     */       }
/*     */     } 
/*     */     
/* 141 */     switchScreen(0);
/* 142 */     initModelTransform();
/* 143 */     modelRotX = 180.0F;
/* 144 */     modelRotY = 90.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void initModelTransform() {
/* 149 */     modelRotX = 0.0F;
/* 150 */     modelRotY = 0.0F;
/* 151 */     modelPosX = 0.0F;
/* 152 */     modelPosY = 0.0F;
/* 153 */     modelZoom = 1.0F;
/*     */   }
/*     */   
/*     */   public void updateListSliderSize(int listSize) {
/* 157 */     int s = listSize / 2;
/* 158 */     if (listSize % 2 != 0) {
/* 159 */       s++;
/*     */     }
/*     */     
/* 162 */     if (s > 3) {
/* 163 */       this.listSlider.valueMax = (s - 3);
/*     */     } else {
/* 165 */       this.listSlider.valueMax = 0.0F;
/*     */     } 
/*     */     
/* 168 */     this.listSlider.setSliderValue(0.0F);
/*     */   }
/*     */   
/*     */   public void switchScreen(int id) {
/* 172 */     this.screenId = id;
/*     */     
/* 174 */     for (int list = 0; list < this.field_146292_n.size(); list++) {
/* 175 */       W_GuiButton.setVisible(this.field_146292_n.get(list), false);
/*     */     }
/*     */     
/* 178 */     if (id < this.screenButtonList.size()) {
/* 179 */       List var5 = this.screenButtonList.get(id);
/* 180 */       Iterator<GuiButton> i$ = var5.iterator();
/*     */       
/* 182 */       while (i$.hasNext()) {
/* 183 */         GuiButton b = i$.next();
/* 184 */         W_GuiButton.setVisible(b, true);
/*     */       } 
/*     */     } 
/*     */     
/* 188 */     if (getScreenId() == 0 && this.current != null && this.current.getDescMaxPage() > 1) {
/* 189 */       W_GuiButton.setVisible(this.buttonNextPage, true);
/* 190 */       W_GuiButton.setVisible(this.buttonPrevPage, true);
/*     */     } else {
/* 192 */       W_GuiButton.setVisible(this.buttonNextPage, false);
/* 193 */       W_GuiButton.setVisible(this.buttonPrevPage, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCurrentRecipe(MCH_CurrentRecipe currentRecipe) {
/* 199 */     modelPosX = 0.0F;
/* 200 */     modelPosY = 0.0F;
/* 201 */     if (this.current == null || currentRecipe == null || !this.current.recipe.func_77571_b().func_77969_a(currentRecipe.recipe.func_77571_b())) {
/* 202 */       this.drawFace = 0;
/*     */     }
/*     */     
/* 205 */     this.current = currentRecipe;
/* 206 */     if (getScreenId() == 0 && this.current != null && this.current.getDescMaxPage() > 1) {
/* 207 */       W_GuiButton.setVisible(this.buttonNextPage, true);
/* 208 */       W_GuiButton.setVisible(this.buttonPrevPage, true);
/*     */     } else {
/* 210 */       W_GuiButton.setVisible(this.buttonNextPage, false);
/* 211 */       W_GuiButton.setVisible(this.buttonPrevPage, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public MCH_IRecipeList getCurrentList() {
/* 217 */     return this.currentList;
/*     */   }
/*     */   
/*     */   public void switchRecipeList(MCH_IRecipeList list) {
/* 221 */     if (getCurrentList() != list) {
/* 222 */       setCurrentRecipe(new MCH_CurrentRecipe(list, 0));
/* 223 */       this.currentList = list;
/* 224 */       updateListSliderSize(list.getRecipeListSize());
/*     */     } else {
/* 226 */       this.listSlider.setSliderValue((this.current.index / 2));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/* 232 */     super.func_73876_c();
/* 233 */     MCH_DraftingTableGuiContainer container = (MCH_DraftingTableGuiContainer)this.field_147002_h;
/* 234 */     this.buttonCreate.field_146124_l = false;
/* 235 */     if (!container.func_75139_a(container.outputSlotIndex).func_75216_d() && MCH_Lib.canPlayerCreateItem(this.current.recipe, this.thePlayer.field_71071_by)) {
/* 236 */       this.buttonCreate.field_146124_l = true;
/*     */     }
/*     */     
/* 239 */     if (this.thePlayer.field_71075_bZ.field_75098_d) {
/* 240 */       this.buttonCreate.field_146124_l = true;
/*     */     }
/*     */     
/* 243 */     if (this.buttonClickWait > 0) {
/* 244 */       this.buttonClickWait--;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/* 250 */     super.func_146281_b();
/* 251 */     MCH_Lib.DbgLog(this.thePlayer.field_70170_p, "MCH_DraftingTableGui.onGuiClosed", new Object[0]);
/*     */   }
/*     */   
/*     */   protected void func_146284_a(GuiButton button) {
/* 255 */     super.func_146284_a(button);
/* 256 */     if (this.buttonClickWait <= 0 && 
/* 257 */       button.field_146124_l) {
/* 258 */       int index1; this.buttonClickWait = 3;
/* 259 */       boolean index = false;
/* 260 */       int page = this.current.getDescCurrentPage();
/*     */       
/* 262 */       switch (button.field_146127_k) {
/*     */         case 10:
/* 264 */           initModelTransform();
/* 265 */           modelRotX = 180.0F;
/* 266 */           modelRotY = 90.0F;
/* 267 */           switchRecipeList((MCH_IRecipeList)MCH_HeliInfoManager.getInstance());
/* 268 */           switchScreen(1);
/*     */         
/*     */         case 11:
/* 271 */           initModelTransform();
/* 272 */           modelRotX = 90.0F;
/* 273 */           modelRotY = 180.0F;
/* 274 */           switchRecipeList((MCH_IRecipeList)MCP_PlaneInfoManager.getInstance());
/* 275 */           switchScreen(1);
/*     */         
/*     */         case 12:
/* 278 */           initModelTransform();
/* 279 */           modelRotX = 180.0F;
/* 280 */           modelRotY = 90.0F;
/* 281 */           switchRecipeList((MCH_IRecipeList)MCH_VehicleInfoManager.getInstance());
/* 282 */           switchScreen(1);
/*     */         
/*     */         case 13:
/* 285 */           initModelTransform();
/* 286 */           modelRotX = 180.0F;
/* 287 */           modelRotY = 90.0F;
/* 288 */           switchRecipeList((MCH_IRecipeList)MCH_TankInfoManager.getInstance());
/* 289 */           switchScreen(1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/*     */           return;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 20:
/* 320 */           if (this.current.isCurrentPageTexture()) {
/* 321 */             page = 0;
/*     */           }
/*     */           
/* 324 */           index1 = (this.current.index + 1) % getCurrentList().getRecipeListSize();
/* 325 */           setCurrentRecipe(new MCH_CurrentRecipe(getCurrentList(), index1));
/* 326 */           this.current.setDescCurrentPage(page);
/*     */         
/*     */         case 21:
/* 329 */           if (this.current.isCurrentPageTexture()) {
/* 330 */             page = 0;
/*     */           }
/*     */           
/* 333 */           index1 = this.current.index - 1;
/* 334 */           if (index1 < 0) {
/* 335 */             index1 = getCurrentList().getRecipeListSize() - 1;
/*     */           }
/*     */           
/* 338 */           setCurrentRecipe(new MCH_CurrentRecipe(getCurrentList(), index1));
/* 339 */           this.current.setDescCurrentPage(page);
/*     */         
/*     */         case 30:
/* 342 */           MCH_DraftingTableCreatePacket.send(this.current.recipe);
/*     */         
/*     */         case 40:
/*     */         case 41:
/*     */         case 42:
/*     */         case 43:
/*     */         case 44:
/*     */         case 45:
/* 350 */           index1 = (int)this.listSlider.getSliderValue() * 2 + button.field_146127_k - 40;
/* 351 */           if (index1 < getCurrentList().getRecipeListSize()) {
/* 352 */             setCurrentRecipe(new MCH_CurrentRecipe(getCurrentList(), index1));
/* 353 */             switchScreen(0);
/*     */           } 
/*     */         
/*     */         case 50:
/* 357 */           if (this.current != null)
/* 358 */             this.current.switchNextPage(); 
/*     */         case 51:
/*     */           break;
/*     */       } 
/* 362 */       if (this.current != null) {
/* 363 */         this.current.switchPrevPage();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char par1, int keycode) {
/* 372 */     if (keycode == 1 || keycode == W_KeyBinding.getKeyCode((Minecraft.func_71410_x()).field_71474_y.field_151445_Q)) {
/* 373 */       if (getScreenId() == 0) {
/* 374 */         this.field_146297_k.field_71439_g.func_71053_j();
/*     */       } else {
/* 376 */         switchScreen(0);
/*     */       } 
/*     */     }
/*     */     
/* 380 */     if (getScreenId() == 0) {
/* 381 */       if (keycode == 205) {
/* 382 */         func_146284_a(this.buttonNext);
/*     */       }
/*     */       
/* 385 */       if (keycode == 203) {
/* 386 */         func_146284_a(this.buttonPrev);
/*     */       }
/* 388 */     } else if (getScreenId() == 1) {
/* 389 */       if (keycode == 200) {
/* 390 */         this.listSlider.scrollDown(1.0F);
/*     */       }
/*     */       
/* 393 */       if (keycode == 208) {
/* 394 */         this.listSlider.scrollUp(1.0F);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146979_b(int mx, int my) {
/* 401 */     super.func_146979_b(mx, my);
/* 402 */     float z = this.field_73735_i;
/* 403 */     this.field_73735_i = 0.0F;
/* 404 */     GL11.glEnable(3042);
/*     */ 
/*     */     
/* 407 */     if (getScreenId() == 0) {
/* 408 */       ArrayList<String> index = new ArrayList();
/* 409 */       if (this.current != null) {
/* 410 */         if (this.current.isCurrentPageTexture()) {
/* 411 */           GL11.glColor4d(1.0D, 1.0D, 1.0D, 1.0D);
/* 412 */           this.field_146297_k.func_110434_K().func_110577_a(this.current.getCurrentPageTexture());
/* 413 */           drawTexturedModalRect(210, 20, 170, 190, 0, 0, 340, 380);
/* 414 */         } else if (this.current.isCurrentPageAcInfo()) {
/* 415 */           int i = -9491968;
/*     */           
/* 417 */           for (int r = 0; r < this.current.infoItem.size(); r++) {
/* 418 */             this.field_146289_q.func_78276_b(this.current.infoItem.get(r), 210, 40 + 10 * r, -9491968);
/* 419 */             String c = this.current.infoData.get(r);
/* 420 */             if (!c.isEmpty()) {
/* 421 */               this.field_146289_q.func_78276_b(c, 280, 40 + 10 * r, -9491968);
/*     */             }
/*     */           } 
/*     */         } else {
/* 425 */           W_McClient.MOD_bindTexture("textures/gui/drafting_table.png");
/* 426 */           drawTexturedModalRect(340, 215, 45, 15, 400, 60, 90, 30);
/* 427 */           if (mx >= 350 && mx <= 400 && my >= 214 && my <= 230) {
/* 428 */             boolean var12 = Mouse.isButtonDown(0);
/* 429 */             boolean var13 = Mouse.isButtonDown(1);
/* 430 */             boolean var14 = Mouse.isButtonDown(2);
/* 431 */             index.add((var12 ? (String)EnumChatFormatting.AQUA : "") + "Mouse left button drag : Rotation model");
/* 432 */             index.add((var13 ? (String)EnumChatFormatting.AQUA : "") + "Mouse right button drag : Zoom model");
/* 433 */             index.add((var14 ? (String)EnumChatFormatting.AQUA : "") + "Mouse middle button drag : Move model");
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 438 */       drawString(this.current.displayName, 120, 20, -1);
/* 439 */       drawItemRecipe(this.current.recipe, 121, 34);
/* 440 */       if (index.size() > 0) {
/* 441 */         drawHoveringText(index, mx - 30, my - 0, this.field_146289_q);
/*     */       }
/*     */     } 
/*     */     
/* 445 */     if (getScreenId() == 1) {
/* 446 */       int var11 = 2 * (int)this.listSlider.getSliderValue();
/* 447 */       int i = 0;
/*     */ 
/*     */       
/*     */       int r;
/*     */       
/* 452 */       for (r = 0; r < 3; r++) {
/* 453 */         for (int var15 = 0; var15 < 2; var15++) {
/* 454 */           if (var11 + i < getCurrentList().getRecipeListSize()) {
/* 455 */             int rx = 110 + 140 * var15;
/* 456 */             int ry = 20 + 70 * r;
/* 457 */             String s = getCurrentList().getRecipe(var11 + i).func_77571_b().func_82833_r();
/* 458 */             drawCenteredString(s, rx, ry, -1);
/*     */           } 
/*     */           
/* 461 */           i++;
/*     */         } 
/*     */       } 
/*     */       
/* 465 */       W_McClient.MOD_bindTexture("textures/gui/drafting_table.png");
/* 466 */       i = 0;
/*     */       
/* 468 */       for (r = 0; r < 3; r++) {
/* 469 */         for (int var15 = 0; var15 < 2; var15++) {
/* 470 */           if (var11 + i < getCurrentList().getRecipeListSize()) {
/* 471 */             int rx = 80 + 140 * var15 - 1;
/* 472 */             int ry = 30 + 70 * r - 1;
/* 473 */             func_73729_b(rx, ry, 400, 0, 75, 54);
/*     */           } 
/*     */           
/* 476 */           i++;
/*     */         } 
/*     */       } 
/*     */       
/* 480 */       i = 0;
/*     */       
/* 482 */       for (r = 0; r < 3; r++) {
/* 483 */         for (int var15 = 0; var15 < 2; var15++) {
/* 484 */           if (var11 + i < getCurrentList().getRecipeListSize()) {
/* 485 */             int rx = 80 + 140 * var15;
/* 486 */             int ry = 30 + 70 * r;
/* 487 */             drawItemRecipe(getCurrentList().getRecipe(var11 + i), rx, ry);
/*     */           } 
/*     */           
/* 490 */           i++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146984_a(Slot p_146984_1_, int p_146984_2_, int p_146984_3_, int p_146984_4_) {
/* 498 */     if (getScreenId() != 1) {
/* 499 */       super.func_146984_a(p_146984_1_, p_146984_2_, p_146984_3_, p_146984_4_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private int getScreenId() {
/* 505 */     return this.screenId;
/*     */   }
/*     */   
/*     */   public void drawItemRecipe(IRecipe recipe, int x, int y) {
/* 509 */     if (recipe != null && 
/* 510 */       recipe.func_77571_b() != null && 
/* 511 */       recipe.func_77571_b().func_77973_b() != null) {
/*     */       
/* 513 */       if (recipe instanceof ShapedRecipes) {
/* 514 */         ShapedRecipes rcp = (ShapedRecipes)recipe;
/* 515 */         int i = rcp.field_77577_c;
/*     */         
/* 517 */         for (int h = 0; h < i; h++) {
/* 518 */           for (int w = 0; w < rcp.field_77576_b; w++) {
/* 519 */             int IDX = h * i + w;
/* 520 */             if (IDX < rcp.field_77574_d.length) {
/* 521 */               drawItemStack(rcp.field_77574_d[IDX], x + w * 18, y + h * 18);
/*     */             }
/*     */           } 
/*     */         } 
/* 525 */       } else if (recipe instanceof ShapelessRecipes) {
/* 526 */         ShapelessRecipes var9 = (ShapelessRecipes)recipe;
/*     */         
/* 528 */         for (int i = 0; i < var9.field_77579_b.size(); i++) {
/* 529 */           drawItemStack(var9.field_77579_b.get(i), x + i % 3 * 18, y + i / 3 * 18);
/*     */         }
/*     */       } 
/*     */       
/* 533 */       drawItemStack(recipe.func_77571_b(), x + 54 + 3, y + 18);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_146274_d() {
/* 540 */     super.func_146274_d();
/* 541 */     int dx = Mouse.getEventDX();
/* 542 */     int dy = Mouse.getEventDY();
/* 543 */     if (getScreenId() == 0 && Mouse.getX() > this.field_146297_k.field_71443_c / 2) {
/* 544 */       if (Mouse.isButtonDown(0) && (dx != 0 || dy != 0)) {
/* 545 */         modelRotX = (float)(modelRotX - dy / 2.0D);
/* 546 */         modelRotY = (float)(modelRotY - dx / 2.0D);
/* 547 */         if (modelRotX > 360.0F) {
/* 548 */           modelRotX -= 360.0F;
/*     */         }
/*     */         
/* 551 */         if (modelRotX < -360.0F) {
/* 552 */           modelRotX += 360.0F;
/*     */         }
/*     */         
/* 555 */         if (modelRotY > 360.0F) {
/* 556 */           modelRotY -= 360.0F;
/*     */         }
/*     */         
/* 559 */         if (modelRotY < -360.0F) {
/* 560 */           modelRotY += 360.0F;
/*     */         }
/*     */       } 
/*     */       
/* 564 */       if (Mouse.isButtonDown(2) && (dx != 0 || dy != 0)) {
/* 565 */         modelPosX = (float)(modelPosX + dx / 2.0D);
/* 566 */         modelPosY = (float)(modelPosY - dy / 2.0D);
/* 567 */         if (modelRotX > 1000.0F) {
/* 568 */           modelRotX = 1000.0F;
/*     */         }
/*     */         
/* 571 */         if (modelRotX < -1000.0F) {
/* 572 */           modelRotX = -1000.0F;
/*     */         }
/*     */         
/* 575 */         if (modelRotY > 1000.0F) {
/* 576 */           modelRotY = 1000.0F;
/*     */         }
/*     */         
/* 579 */         if (modelRotY < -1000.0F) {
/* 580 */           modelRotY = -1000.0F;
/*     */         }
/*     */       } 
/*     */       
/* 584 */       if (Mouse.isButtonDown(1) && dy != 0) {
/* 585 */         modelZoom = (float)(modelZoom + dy / 100.0D);
/* 586 */         if (modelZoom < 0.1D) {
/* 587 */           modelZoom = 0.1F;
/*     */         }
/*     */         
/* 590 */         if (modelZoom > 10.0F) {
/* 591 */           modelZoom = 10.0F;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 596 */     int wheel = Mouse.getEventDWheel();
/* 597 */     if (wheel != 0) {
/* 598 */       if (getScreenId() == 1) {
/* 599 */         if (wheel > 0) {
/* 600 */           this.listSlider.scrollDown(1.0F);
/* 601 */         } else if (wheel < 0) {
/* 602 */           this.listSlider.scrollUp(1.0F);
/*     */         } 
/* 604 */       } else if (getScreenId() == 0) {
/* 605 */         if (wheel > 0) {
/* 606 */           func_146284_a(this.buttonPrev);
/* 607 */         } else if (wheel < 0) {
/* 608 */           func_146284_a(this.buttonNext);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
/* 616 */     GL11.glEnable(3042);
/* 617 */     GL11.glBlendFunc(770, 771);
/* 618 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 619 */     if (getScreenId() == 0) {
/* 620 */       super.func_73863_a(mouseX, mouseY, partialTicks);
/*     */     } else {
/* 622 */       List inventory = this.field_147002_h.field_75151_b;
/* 623 */       this.field_147002_h.field_75151_b = new ArrayList();
/* 624 */       super.func_73863_a(mouseX, mouseY, partialTicks);
/* 625 */       this.field_147002_h.field_75151_b = inventory;
/*     */     } 
/*     */     
/* 628 */     if (getScreenId() == 0 && this.current.isCurrentPageModel()) {
/* 629 */       RenderHelper.func_74520_c();
/* 630 */       drawModel(partialTicks);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawModel(float partialTicks) {
/* 636 */     W_ModelCustom model = this.current.getModel();
/* 637 */     double scl = 162.0D / ((MathHelper.func_76135_e(model.size) < 0.01D) ? 0.01D : model.size);
/* 638 */     this.field_146297_k.func_110434_K().func_110577_a(this.current.getModelTexture());
/* 639 */     GL11.glPushMatrix();
/* 640 */     double cx = (model.maxX - model.minX) * 0.5D + model.minX;
/* 641 */     double cy = (model.maxY - model.minY) * 0.5D + model.minY;
/* 642 */     double cz = (model.maxZ - model.minZ) * 0.5D + model.minZ;
/* 643 */     if (this.current.modelRot == 0) {
/* 644 */       GL11.glTranslated(cx * scl, cz * scl, 0.0D);
/*     */     } else {
/* 646 */       GL11.glTranslated(cz * scl, cy * scl, 0.0D);
/*     */     } 
/*     */     
/* 649 */     GL11.glTranslated(((this.field_147003_i + 300) + modelPosX), ((this.field_147009_r + 110) + modelPosY), 550.0D);
/* 650 */     GL11.glRotated(modelRotX, 1.0D, 0.0D, 0.0D);
/* 651 */     GL11.glRotated(modelRotY, 0.0D, 1.0D, 0.0D);
/* 652 */     GL11.glScaled(scl * modelZoom, scl * modelZoom, -scl * modelZoom);
/* 653 */     GL11.glDisable(32826);
/* 654 */     GL11.glDisable(2896);
/* 655 */     GL11.glEnable(3008);
/* 656 */     GL11.glEnable(3042);
/* 657 */     int faceNum = model.getFaceNum();
/* 658 */     if (this.drawFace < faceNum * 2) {
/* 659 */       GL11.glColor4d(0.10000000149011612D, 0.10000000149011612D, 0.10000000149011612D, 1.0D);
/* 660 */       GL11.glDisable(3553);
/* 661 */       GL11.glPolygonMode(1032, 6913);
/* 662 */       float lw = GL11.glGetFloat(2849);
/* 663 */       GL11.glLineWidth(1.0F);
/* 664 */       model.renderAll(this.drawFace - faceNum, this.drawFace);
/* 665 */       MCH_RenderAircraft.renderCrawlerTrack((MCH_EntityAircraft)null, this.current.getAcInfo(), partialTicks);
/* 666 */       GL11.glLineWidth(lw);
/* 667 */       GL11.glPolygonMode(1032, 6914);
/* 668 */       GL11.glEnable(3553);
/*     */     } 
/*     */     
/* 671 */     if (this.drawFace >= faceNum) {
/* 672 */       GL11.glColor4d(1.0D, 1.0D, 1.0D, 1.0D);
/* 673 */       model.renderAll(0, this.drawFace - faceNum);
/* 674 */       MCH_RenderAircraft.renderCrawlerTrack((MCH_EntityAircraft)null, this.current.getAcInfo(), partialTicks);
/*     */     } 
/*     */     
/* 677 */     GL11.glEnable(32826);
/* 678 */     GL11.glEnable(2896);
/* 679 */     GL11.glPopMatrix();
/* 680 */     if (this.drawFace < 10000000) {
/* 681 */       this.drawFace = (int)(this.drawFace + 20.0F);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float var1, int var2, int var3) {
/* 687 */     W_ScaledResolution scaledresolution = new W_ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 688 */     this.scaleFactor = scaledresolution.func_78325_e();
/* 689 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 690 */     float z = this.field_73735_i;
/* 691 */     this.field_73735_i = 0.0F;
/* 692 */     W_McClient.MOD_bindTexture("textures/gui/drafting_table.png");
/* 693 */     if (getScreenId() == 0) {
/* 694 */       func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
/*     */     }
/*     */     
/* 697 */     if (getScreenId() == 1) {
/* 698 */       func_73729_b(this.field_147003_i, this.field_147009_r, 0, this.field_147000_g, this.field_146999_f, this.field_147000_g);
/* 699 */       List<GuiButton> list = this.screenButtonList.get(1);
/* 700 */       int index = (int)this.listSlider.getSliderValue() * 2;
/*     */       
/* 702 */       for (int i = 0; i < 6; i++) {
/* 703 */         W_GuiButton.setVisible(list.get(i), (index + i < getCurrentList().getRecipeListSize()));
/*     */       }
/*     */     } 
/*     */     
/* 707 */     this.field_73735_i = z;
/*     */   }
/*     */   
/*     */   public void func_73729_b(int par1, int par2, int par3, int par4, int par5, int par6) {
/* 711 */     float w = 0.001953125F;
/* 712 */     float h = 0.001953125F;
/* 713 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 714 */     tessellator.func_78382_b();
/* 715 */     tessellator.func_78374_a((par1 + 0), (par2 + par6), this.field_73735_i, ((par3 + 0) * w), ((par4 + par6) * h));
/* 716 */     tessellator.func_78374_a((par1 + par5), (par2 + par6), this.field_73735_i, ((par3 + par5) * w), ((par4 + par6) * h));
/* 717 */     tessellator.func_78374_a((par1 + par5), (par2 + 0), this.field_73735_i, ((par3 + par5) * w), ((par4 + 0) * h));
/* 718 */     tessellator.func_78374_a((par1 + 0), (par2 + 0), this.field_73735_i, ((par3 + 0) * w), ((par4 + 0) * h));
/* 719 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public void drawTexturedModalRect(int dx, int dy, int dw, int dh, int u, int v, int tw, int th) {
/* 723 */     float w = 0.001953125F;
/* 724 */     float h = 0.001953125F;
/* 725 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 726 */     tessellator.func_78382_b();
/* 727 */     tessellator.func_78374_a((dx + 0), (dy + dh), this.field_73735_i, ((u + 0) * w), ((v + th) * h));
/* 728 */     tessellator.func_78374_a((dx + dw), (dy + dh), this.field_73735_i, ((u + tw) * w), ((v + th) * h));
/* 729 */     tessellator.func_78374_a((dx + dw), (dy + 0), this.field_73735_i, ((u + tw) * w), ((v + 0) * h));
/* 730 */     tessellator.func_78374_a((dx + 0), (dy + 0), this.field_73735_i, ((u + 0) * w), ((v + 0) * h));
/* 731 */     tessellator.func_78381_a();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\block\MCH_DraftingTableGui.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */