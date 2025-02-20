/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import net.minecraft.command.ICommandManager;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ import net.minecraft.util.ChunkCoordinates;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_DummyCommandSender
/*    */   implements ICommandSender {
/* 12 */   public static MCH_DummyCommandSender instance = new MCH_DummyCommandSender();
/*    */ 
/*    */   
/*    */   public static void execCommand(String s) {
/* 16 */     ICommandManager icommandmanager = MinecraftServer.func_71276_C().func_71187_D();
/* 17 */     icommandmanager.func_71556_a(instance, s);
/*    */   }
/*    */   
/*    */   public String func_70005_c_() {
/* 21 */     return "";
/*    */   }
/*    */   
/*    */   public IChatComponent func_145748_c_() {
/* 25 */     return null;
/*    */   }
/*    */   
/*    */   public void func_145747_a(IChatComponent p_145747_1_) {}
/*    */   
/*    */   public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public ChunkCoordinates func_82114_b() {
/* 35 */     return null;
/*    */   }
/*    */   
/*    */   public World func_130014_f_() {
/* 39 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_DummyCommandSender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */