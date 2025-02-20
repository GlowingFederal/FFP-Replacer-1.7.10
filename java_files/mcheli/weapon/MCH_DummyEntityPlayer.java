/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.wrapper.ChatMessageComponent;
/*    */ import mcheli.wrapper.W_EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.ChunkCoordinates;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_DummyEntityPlayer
/*    */   extends W_EntityPlayer {
/*    */   public MCH_DummyEntityPlayer(World p_i45324_1_, EntityPlayer player) {
/* 13 */     super(p_i45324_1_, player);
/*    */   }
/*    */   
/*    */   public void func_145747_a(IChatComponent var1) {}
/*    */   
/*    */   public boolean func_70003_b(int var1, String var2) {
/* 19 */     return false;
/*    */   }
/*    */   
/*    */   public ChunkCoordinates func_82114_b() {
/* 23 */     return null;
/*    */   }
/*    */   
/*    */   public void sendChatToPlayer(ChatMessageComponent chatmessagecomponent) {}
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_DummyEntityPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */