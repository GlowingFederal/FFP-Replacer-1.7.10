/*    */ package mcheli.block;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.MCH_Packet;
/*    */ import mcheli.wrapper.W_Item;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.crafting.IRecipe;
/*    */ 
/*    */ public class MCH_DraftingTableCreatePacket
/*    */   extends MCH_Packet {
/*    */   public Item outputItem;
/* 20 */   public Map map = new HashMap<>();
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 24 */     return 537395216;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 29 */       this.outputItem = W_Item.getItemByName(data.readUTF());
/* 30 */       byte e = data.readByte();
/*    */       
/* 32 */       for (int i = 0; i < e; i++) {
/* 33 */         String s = data.readUTF();
/* 34 */         byte num = data.readByte();
/* 35 */         Item item = W_Item.getItemByName(s);
/* 36 */         if (item != null) {
/* 37 */           this.map.put(item, Integer.valueOf(0 + num));
/*    */         }
/*    */       } 
/* 40 */     } catch (Exception exception) {}
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 48 */       dos.writeUTF(getItemName(this.outputItem));
/* 49 */       dos.writeByte(this.map.size());
/* 50 */       Iterator<Item> e = this.map.keySet().iterator();
/*    */       
/* 52 */       while (e.hasNext()) {
/* 53 */         Item key = e.next();
/* 54 */         dos.writeUTF(getItemName(key));
/* 55 */         dos.writeByte(((Integer)this.map.get(key)).byteValue());
/*    */       } 
/* 57 */     } catch (IOException var4) {
/* 58 */       var4.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private String getItemName(Item item) {
/* 64 */     return W_Item.getNameForItem(item);
/*    */   }
/*    */   
/*    */   public static void send(IRecipe recipe) {
/* 68 */     if (recipe != null) {
/* 69 */       MCH_DraftingTableCreatePacket s = new MCH_DraftingTableCreatePacket();
/* 70 */       s.outputItem = (recipe.func_77571_b() != null) ? recipe.func_77571_b().func_77973_b() : null;
/* 71 */       if (s.outputItem != null) {
/* 72 */         s.map = MCH_Lib.getItemMapFromRecipe(recipe);
/* 73 */         W_Network.sendToServer((W_PacketBase)s);
/*    */       } 
/*    */       
/* 76 */       MCH_Lib.DbgLog(true, "MCH_DraftingTableCreatePacket.send outputItem = " + s.outputItem, new Object[0]);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\block\MCH_DraftingTableCreatePacket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */