/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mcheli.MCH_IRecipeList;
/*    */ import mcheli.MCH_InfoManagerBase;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.crafting.IRecipe;
/*    */ 
/*    */ public abstract class MCH_AircraftInfoManager
/*    */   extends MCH_InfoManagerBase
/*    */   implements MCH_IRecipeList {
/* 14 */   private List listItemRecipe = new ArrayList();
/*    */ 
/*    */   
/*    */   public int getRecipeListSize() {
/* 18 */     return this.listItemRecipe.size();
/*    */   }
/*    */   
/*    */   public IRecipe getRecipe(int index) {
/* 22 */     return this.listItemRecipe.get(index);
/*    */   }
/*    */   
/*    */   public void addRecipe(IRecipe recipe, int count, String name, String recipeString) {
/* 26 */     if (recipe != null && recipe.func_77571_b() != null && recipe.func_77571_b().func_77973_b() != null) {
/* 27 */       this.listItemRecipe.add(recipe);
/*    */     } else {
/* 29 */       throw new RuntimeException("[mcheli]Recipe Parameter Error! recipe" + count + " : " + name + ".txt : " + recipe + " : " + recipeString);
/*    */     } 
/*    */   }
/*    */   
/*    */   public abstract MCH_AircraftInfo getAcInfoFromItem(Item paramItem);
/*    */   
/*    */   public MCH_AircraftInfo getAcInfoFromItem(IRecipe recipe) {
/* 36 */     Map map = getMap();
/* 37 */     return (recipe != null) ? getAcInfoFromItem(recipe.func_77571_b().func_77973_b()) : null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_AircraftInfoManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */