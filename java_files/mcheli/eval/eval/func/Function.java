package mcheli.eval.eval.func;

public interface Function {
  long evalLong(Object paramObject, String paramString, Long[] paramArrayOfLong) throws Throwable;
  
  double evalDouble(Object paramObject, String paramString, Double[] paramArrayOfDouble) throws Throwable;
  
  Object evalObject(Object paramObject, String paramString, Object[] paramArrayOfObject) throws Throwable;
}


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\func\Function.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */