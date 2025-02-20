/*    */ package mcheli.multiplay;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ 
/*    */ public class MCH_ContainerScoreboard
/*    */   extends Container
/*    */ {
/*    */   public final EntityPlayer thePlayer;
/*    */   
/*    */   public MCH_ContainerScoreboard(EntityPlayer player) {
/* 12 */     this.thePlayer = player;
/*    */   }
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer player) {
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_ContainerScoreboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */