/*    */ package mcheli;
/*    */ 
/*    */ 
/*    */ public class MCH_CheckTime
/*    */ {
/*  6 */   private long startTime = 0L;
/*  7 */   public int x = 0;
/*  8 */   private int y = 0;
/*  9 */   public long[][] pointTimeList = new long[1][1];
/* 10 */   public int MAX_Y = 0;
/* 11 */   private int MAX_X = 0;
/*    */ 
/*    */   
/*    */   public MCH_CheckTime() {
/* 15 */     this.MAX_Y = 100;
/* 16 */     this.MAX_X = 40;
/* 17 */     this.pointTimeList = new long[this.MAX_Y + 1][this.MAX_X];
/* 18 */     this.y = this.MAX_Y - 1;
/*    */   }
/*    */   
/*    */   public void start() {
/* 22 */     this.startTime = System.nanoTime();
/* 23 */     this.x = 0;
/* 24 */     this.y = (this.y + 1) % this.MAX_Y;
/* 25 */     if (this.y == 0) {
/* 26 */       for (int j = 0; j < this.MAX_X; j++) {
/* 27 */         this.pointTimeList[this.MAX_Y][j] = 0L;
/*    */         
/* 29 */         for (int i = 0; i < this.MAX_Y; i++) {
/* 30 */           this.pointTimeList[this.MAX_Y][j] = this.pointTimeList[this.MAX_Y][j] + this.pointTimeList[i][j];
/*    */         }
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void timeStamp() {
/* 38 */     if (this.x < this.MAX_X) {
/* 39 */       this.pointTimeList[this.y][this.x] = System.nanoTime() - this.startTime;
/* 40 */       this.x++;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_CheckTime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */