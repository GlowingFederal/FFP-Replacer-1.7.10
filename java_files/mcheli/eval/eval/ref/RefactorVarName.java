/*    */ package mcheli.eval.eval.ref;
/*    */ 
/*    */ public class RefactorVarName
/*    */   extends RefactorAdapter
/*    */ {
/*    */   protected Class targetClass;
/*    */   protected String oldName;
/*    */   protected String newName;
/*    */   
/*    */   public RefactorVarName(Class targetClass, String oldName, String newName) {
/* 11 */     this.targetClass = targetClass;
/* 12 */     this.oldName = oldName;
/* 13 */     this.newName = newName;
/* 14 */     if (oldName == null || newName == null) {
/* 15 */       throw new NullPointerException();
/*    */     }
/*    */   }
/*    */   
/*    */   public String getNewName(Object target, String name) {
/* 20 */     if (!name.equals(this.oldName)) {
/* 21 */       return null;
/*    */     }
/* 23 */     if (this.targetClass == null) {
/* 24 */       if (target == null) {
/* 25 */         return this.newName;
/*    */       }
/* 27 */     } else if (target != null && this.targetClass.isAssignableFrom(target.getClass())) {
/* 28 */       return this.newName;
/*    */     } 
/*    */     
/* 31 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\ref\RefactorVarName.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */