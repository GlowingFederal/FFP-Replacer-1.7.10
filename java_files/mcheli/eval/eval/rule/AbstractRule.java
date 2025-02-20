/*    */ package mcheli.eval.eval.rule;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mcheli.eval.eval.exp.AbstractExpression;
/*    */ import mcheli.eval.eval.exp.ShareExpValue;
/*    */ import mcheli.eval.eval.lex.Lex;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractRule
/*    */ {
/*    */   public AbstractRule nextRule;
/*    */   protected ShareRuleValue share;
/* 17 */   private final Map opes = new HashMap<>();
/*    */   
/*    */   public int prio;
/*    */   
/*    */   public AbstractRule(ShareRuleValue share) {
/* 22 */     this.share = share;
/*    */   }
/*    */   
/*    */   public final void addExpression(AbstractExpression exp) {
/* 26 */     if (exp != null) {
/* 27 */       String ope = exp.getOperator();
/* 28 */       addOperator(ope, exp);
/* 29 */       addLexOperator(exp.getEndOperator());
/* 30 */       if (exp instanceof mcheli.eval.eval.exp.ParenExpression) {
/* 31 */         this.share.paren = exp;
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public final void addOperator(String ope, AbstractExpression exp) {
/* 38 */     this.opes.put(ope, exp);
/* 39 */     addLexOperator(ope);
/*    */   }
/*    */   
/*    */   public final String[] getOperators() {
/* 43 */     ArrayList list = new ArrayList();
/* 44 */     Iterator i = this.opes.keySet().iterator();
/*    */     
/* 46 */     while (i.hasNext()) {
/* 47 */       list.add(i.next());
/*    */     }
/*    */     
/* 50 */     return (String[])list.toArray((Object[])new String[list.size()]);
/*    */   }
/*    */   
/*    */   public final void addLexOperator(String ope) {
/* 54 */     if (ope != null) {
/* 55 */       int n = ope.length() - 1;
/* 56 */       if (this.share.opeList[n] == null) {
/* 57 */         this.share.opeList[n] = new ArrayList();
/*    */       }
/*    */       
/* 60 */       this.share.opeList[n].add(ope);
/*    */     } 
/*    */   }
/*    */   
/*    */   protected final boolean isMyOperator(String ope) {
/* 65 */     return this.opes.containsKey(ope);
/*    */   }
/*    */   
/*    */   protected final AbstractExpression newExpression(String ope, ShareExpValue share) {
/*    */     try {
/* 70 */       AbstractExpression e = (AbstractExpression)this.opes.get(ope);
/* 71 */       AbstractExpression n = e.dup(share);
/* 72 */       n.setPriority(this.prio);
/* 73 */       n.share = share;
/* 74 */       return n;
/* 75 */     } catch (RuntimeException var5) {
/* 76 */       throw var5;
/* 77 */     } catch (Exception var6) {
/* 78 */       throw new RuntimeException(var6);
/*    */     } 
/*    */   }
/*    */   
/*    */   public final void initPriority(int prio) {
/* 83 */     this.prio = prio;
/* 84 */     if (this.nextRule != null)
/* 85 */       this.nextRule.initPriority(prio + 1); 
/*    */   }
/*    */   
/*    */   protected abstract AbstractExpression parse(Lex paramLex);
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\rule\AbstractRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */