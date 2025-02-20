/*    */ package mcheli;
/*    */ 
/*    */ import mcheli.wrapper.W_KeyBinding;
/*    */ import net.minecraft.client.settings.KeyBinding;
/*    */ import org.lwjgl.input.Keyboard;
/*    */ import org.lwjgl.input.Mouse;
/*    */ 
/*    */ 
/*    */ public class MCH_Key
/*    */ {
/*    */   public int key;
/*    */   private boolean isPress;
/*    */   private boolean isBeforePress;
/*    */   
/*    */   public MCH_Key(int k) {
/* 16 */     this.key = k;
/* 17 */     this.isPress = false;
/* 18 */     this.isBeforePress = false;
/*    */   }
/*    */   
/*    */   public boolean isKeyDown() {
/* 22 */     return (!this.isBeforePress && this.isPress);
/*    */   }
/*    */   
/*    */   public boolean isKeyPress() {
/* 26 */     return this.isPress;
/*    */   }
/*    */   
/*    */   public boolean isKeyUp() {
/* 30 */     return (this.isBeforePress && !this.isPress);
/*    */   }
/*    */   
/*    */   public void update() {
/* 34 */     if (this.key != 0) {
/* 35 */       this.isBeforePress = this.isPress;
/* 36 */       if (this.key >= 0) {
/* 37 */         this.isPress = Keyboard.isKeyDown(this.key);
/*    */       } else {
/* 39 */         this.isPress = Mouse.isButtonDown(this.key + 100);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isKeyDown(int key) {
/* 46 */     return (key > 0) ? Keyboard.isKeyDown(key) : ((key < 0) ? Mouse.isButtonDown(key + 100) : false);
/*    */   }
/*    */   
/*    */   public static boolean isKeyDown(KeyBinding keyBind) {
/* 50 */     return isKeyDown(W_KeyBinding.getKeyCode(keyBind));
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_Key.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */