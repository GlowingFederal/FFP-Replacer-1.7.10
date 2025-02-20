/*    */ package mcheli.multiplay;
/*    */ 
/*    */ 
/*    */ public enum MCH_TargetType
/*    */ {
/*  6 */   NONE("NONE", 0),
/*  7 */   OTHER_MOB("OTHER_MOB", 1),
/*  8 */   MONSTER("MONSTER", 2),
/*  9 */   NO_TEAM_PLAYER("NO_TEAM_PLAYER", 3),
/* 10 */   SAME_TEAM_PLAYER("SAME_TEAM_PLAYER", 4),
/* 11 */   OTHER_TEAM_PLAYER("OTHER_TEAM_PLAYER", 5),
/* 12 */   POINT("POINT", 6);
/*    */   static {
/* 14 */     $VALUES = new MCH_TargetType[] { NONE, OTHER_MOB, MONSTER, NO_TEAM_PLAYER, SAME_TEAM_PLAYER, OTHER_TEAM_PLAYER, POINT };
/*    */   }
/*    */   
/*    */   private static final MCH_TargetType[] $VALUES;
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_TargetType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */