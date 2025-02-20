/*    */ package mcheli.eval.eval.lex;
/*    */ 
/*    */ import java.util.List;
/*    */ import mcheli.eval.eval.exp.ShareExpValue;
/*    */ import mcheli.eval.eval.rule.ShareRuleValue;
/*    */ 
/*    */ 
/*    */ public class LexFactory
/*    */ {
/*    */   public Lex create(String str, List[] opeList, ShareRuleValue share, ShareExpValue exp) {
/* 11 */     return new Lex(str, opeList, share.paren, exp);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\lex\LexFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */