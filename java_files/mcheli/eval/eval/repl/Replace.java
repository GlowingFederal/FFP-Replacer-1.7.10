package mcheli.eval.eval.repl;

import mcheli.eval.eval.exp.AbstractExpression;
import mcheli.eval.eval.exp.Col1Expression;
import mcheli.eval.eval.exp.Col2Expression;
import mcheli.eval.eval.exp.Col2OpeExpression;
import mcheli.eval.eval.exp.Col3Expression;
import mcheli.eval.eval.exp.FunctionExpression;
import mcheli.eval.eval.exp.WordExpression;

public interface Replace {
  AbstractExpression replace0(WordExpression paramWordExpression);
  
  AbstractExpression replace1(Col1Expression paramCol1Expression);
  
  AbstractExpression replace2(Col2Expression paramCol2Expression);
  
  AbstractExpression replace2(Col2OpeExpression paramCol2OpeExpression);
  
  AbstractExpression replace3(Col3Expression paramCol3Expression);
  
  AbstractExpression replaceVar0(WordExpression paramWordExpression);
  
  AbstractExpression replaceVar1(Col1Expression paramCol1Expression);
  
  AbstractExpression replaceVar2(Col2Expression paramCol2Expression);
  
  AbstractExpression replaceVar2(Col2OpeExpression paramCol2OpeExpression);
  
  AbstractExpression replaceVar3(Col3Expression paramCol3Expression);
  
  AbstractExpression replaceFunc(FunctionExpression paramFunctionExpression);
  
  AbstractExpression replaceLet(Col2Expression paramCol2Expression);
}


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\repl\Replace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */