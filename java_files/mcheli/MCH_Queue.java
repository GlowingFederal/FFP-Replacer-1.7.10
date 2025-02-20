/*    */ package mcheli;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class MCH_Queue
/*    */ {
/*    */   private int current;
/*    */   private List list;
/*    */   
/*    */   public MCH_Queue(int filterLength, Object initVal) {
/* 13 */     if (filterLength <= 0) {
/* 14 */       filterLength = 1;
/*    */     }
/*    */     
/* 17 */     this.list = new ArrayList();
/*    */     
/* 19 */     for (int i = 0; i < filterLength; i++) {
/* 20 */       this.list.add(initVal);
/*    */     }
/*    */     
/* 23 */     this.current = 0;
/*    */   }
/*    */   
/*    */   public void clear(Object clearVal) {
/* 27 */     for (int i = 0; i < size(); i++) {
/* 28 */       this.list.set(i, clearVal);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void put(Object t) {
/* 34 */     this.list.set(this.current, t);
/* 35 */     this.current++;
/* 36 */     this.current %= size();
/*    */   }
/*    */   
/*    */   private int getIndex(int offset) {
/* 40 */     offset %= size();
/* 41 */     int index = this.current + offset;
/* 42 */     return (index < 0) ? (index + size()) : (index % size());
/*    */   }
/*    */   
/*    */   public Object oldest() {
/* 46 */     return this.list.get(getIndex(1));
/*    */   }
/*    */   
/*    */   public Object get(int i) {
/* 50 */     return this.list.get(i);
/*    */   }
/*    */   
/*    */   public int size() {
/* 54 */     return this.list.size();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_Queue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */