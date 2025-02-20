/*    */ package mcheli;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class MCH_OStream
/*    */   extends ByteArrayOutputStream {
/*  9 */   public int index = 0;
/*    */   
/*    */   public static final int SIZE = 30720;
/*    */   
/*    */   public void write(DataOutputStream dos) {
/*    */     try {
/*    */       int e;
/* 16 */       if (this.index + 30720 <= size()) {
/* 17 */         e = 30720;
/*    */       } else {
/* 19 */         e = size() - this.index;
/*    */       } 
/*    */       
/* 22 */       dos.writeInt(this.index);
/* 23 */       dos.writeInt(e);
/* 24 */       dos.writeInt(size());
/* 25 */       dos.write(this.buf, this.index, e);
/* 26 */       this.index += e;
/* 27 */     } catch (IOException var3) {
/* 28 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isDataEnd() {
/* 34 */     return (this.index >= size());
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_OStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */