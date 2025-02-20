/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public abstract class Col1AfterExpression
/*    */   extends Col1Expression {
/*    */   protected Col1AfterExpression() {}
/*    */   
/*    */   protected Col1AfterExpression(Col1Expression from, ShareExpValue s) {
/*  8 */     super(from, s);
/*    */   }
/*    */   
/*    */   protected AbstractExpression replace() {
/* 12 */     this.exp = this.exp.replaceVar();
/* 13 */     return this.share.repl.replaceVar1(this);
/*    */   }
/*    */   
/*    */   protected AbstractExpression replaceVar() {
/* 17 */     return replace();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 21 */     if (this.exp == null) {
/* 22 */       return getOperator();
/*    */     }
/* 24 */     StringBuffer sb = new StringBuffer();
/* 25 */     if (this.exp.getPriority() > this.prio) {
/* 26 */       sb.append(this.exp.toString());
/* 27 */       sb.append(getOperator());
/* 28 */     } else if (this.exp.getPriority() == this.prio) {
/* 29 */       sb.append(this.exp.toString());
/* 30 */       sb.append(' ');
/* 31 */       sb.append(getOperator());
/*    */     } else {
/* 33 */       sb.append(this.share.paren.getOperator());
/* 34 */       sb.append(this.exp.toString());
/* 35 */       sb.append(this.share.paren.getEndOperator());
/* 36 */       sb.append(getOperator());
/*    */     } 
/*    */     
/* 39 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\Col1AfterExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */