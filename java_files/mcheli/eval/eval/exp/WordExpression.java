/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public abstract class WordExpression
/*    */   extends AbstractExpression
/*    */ {
/*    */   protected String word;
/*    */   
/*    */   protected WordExpression(String str) {
/*  9 */     this.word = str;
/*    */   }
/*    */   
/*    */   protected WordExpression(WordExpression from, ShareExpValue s) {
/* 13 */     super(from, s);
/* 14 */     this.word = from.word;
/*    */   }
/*    */   
/*    */   protected String getWord() {
/* 18 */     return this.word;
/*    */   }
/*    */   
/*    */   protected void setWord(String word) {
/* 22 */     this.word = word;
/*    */   }
/*    */   
/*    */   protected int getCols() {
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */   protected int getFirstPos() {
/* 30 */     return this.pos;
/*    */   }
/*    */   
/*    */   protected void search() {
/* 34 */     this.share.srch.search(this);
/* 35 */     if (!this.share.srch.end()) {
/* 36 */       this.share.srch.search0(this);
/*    */     }
/*    */   }
/*    */   
/*    */   protected AbstractExpression replace() {
/* 41 */     return this.share.repl.replace0(this);
/*    */   }
/*    */   
/*    */   protected AbstractExpression replaceVar() {
/* 45 */     return this.share.repl.replaceVar0(this);
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj) {
/* 49 */     if (obj instanceof WordExpression) {
/* 50 */       WordExpression e = (WordExpression)obj;
/* 51 */       if (getClass() == e.getClass()) {
/* 52 */         return this.word.equals(e.word);
/*    */       }
/*    */     } 
/*    */     
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     return this.word.hashCode();
/*    */   }
/*    */   
/*    */   public void dump(int n) {
/* 64 */     StringBuffer sb = new StringBuffer();
/*    */     
/* 66 */     for (int i = 0; i < n; i++) {
/* 67 */       sb.append(' ');
/*    */     }
/*    */     
/* 70 */     sb.append(this.word);
/* 71 */     System.out.println(sb.toString());
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     return this.word;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\WordExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */