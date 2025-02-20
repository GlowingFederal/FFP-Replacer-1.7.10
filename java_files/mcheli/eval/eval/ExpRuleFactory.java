/*     */ package mcheli.eval.eval;
/*     */ import mcheli.eval.eval.exp.AbstractExpression;
/*     */ import mcheli.eval.eval.rule.AbstractRule;
/*     */ import mcheli.eval.eval.rule.Col1AfterRule;
/*     */ import mcheli.eval.eval.rule.Col2RightJoinRule;
/*     */ import mcheli.eval.eval.rule.Col2Rule;
/*     */ import mcheli.eval.eval.rule.IfRule;
/*     */ import mcheli.eval.eval.rule.ShareRuleValue;
/*     */ import mcheli.eval.eval.rule.SignRule;
/*     */ 
/*     */ public class ExpRuleFactory {
/*     */   private static ExpRuleFactory me;
/*     */   protected Rule rule;
/*     */   
/*     */   public static ExpRuleFactory getInstance() {
/*  16 */     if (me == null) {
/*  17 */       me = new ExpRuleFactory();
/*     */     }
/*     */     
/*  20 */     return me;
/*     */   }
/*     */   protected AbstractRule topRule; protected LexFactory defaultLexFactory;
/*     */   public static Rule getDefaultRule() {
/*  24 */     return getInstance().getRule();
/*     */   }
/*     */   
/*     */   public static Rule getJavaRule() {
/*  28 */     return JavaRuleFactory.getInstance().getRule();
/*     */   }
/*     */   
/*     */   public ExpRuleFactory() {
/*  32 */     ShareRuleValue share = new ShareRuleValue();
/*  33 */     share.lexFactory = getLexFactory();
/*  34 */     init(share);
/*  35 */     this.rule = (Rule)share;
/*     */   }
/*     */   
/*     */   public Rule getRule() {
/*  39 */     return this.rule;
/*     */   }
/*     */   
/*     */   protected void init(ShareRuleValue share) {
/*  43 */     AbstractRule rule = null;
/*  44 */     rule = add(rule, createCommaRule(share));
/*  45 */     rule = add(rule, createLetRule(share));
/*  46 */     rule = add(rule, createIfRule(share));
/*  47 */     rule = add(rule, createOrRule(share));
/*  48 */     rule = add(rule, createAndRule(share));
/*  49 */     rule = add(rule, createBitOrRule(share));
/*  50 */     rule = add(rule, createBitXorRule(share));
/*  51 */     rule = add(rule, createBitAndRule(share));
/*  52 */     rule = add(rule, createEqualRule(share));
/*  53 */     rule = add(rule, createGreaterRule(share));
/*  54 */     rule = add(rule, createShiftRule(share));
/*  55 */     rule = add(rule, createPlusRule(share));
/*  56 */     rule = add(rule, createMultRule(share));
/*  57 */     rule = add(rule, createSignRule(share));
/*  58 */     rule = add(rule, createPowerRule(share));
/*  59 */     rule = add(rule, createCol1AfterRule(share));
/*  60 */     add(rule, createPrimaryRule(share));
/*  61 */     this.topRule.initPriority(1);
/*  62 */     share.topRule = this.topRule;
/*  63 */     initFuncArgRule(share);
/*     */   }
/*     */   
/*     */   protected void initFuncArgRule(ShareRuleValue share) {
/*  67 */     AbstractRule argRule = share.funcArgRule = createFuncArgRule(share);
/*  68 */     String[] a_opes = argRule.getOperators();
/*  69 */     String[] t_opes = this.topRule.getOperators();
/*  70 */     boolean match = false;
/*     */     
/*     */     int i;
/*  73 */     label20: for (i = 0; i < a_opes.length; i++) {
/*  74 */       for (int j = 0; j < t_opes.length; j++) {
/*  75 */         if (a_opes[i].equals(t_opes[j])) {
/*  76 */           match = true;
/*     */           
/*     */           break label20;
/*     */         } 
/*     */       } 
/*     */     } 
/*  82 */     if (match) {
/*  83 */       argRule.nextRule = this.topRule.nextRule;
/*     */     } else {
/*  85 */       argRule.nextRule = this.topRule;
/*     */     } 
/*     */     
/*  88 */     argRule.prio = this.topRule.prio;
/*     */   }
/*     */   
/*     */   protected final AbstractRule add(AbstractRule rule, AbstractRule r) {
/*  92 */     if (r == null) {
/*  93 */       return rule;
/*     */     }
/*  95 */     if (this.topRule == null) {
/*  96 */       this.topRule = r;
/*     */     }
/*     */     
/*  99 */     if (rule != null) {
/* 100 */       rule.nextRule = r;
/*     */     }
/*     */     
/* 103 */     return r;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AbstractRule createCommaRule(ShareRuleValue share) {
/* 108 */     Col2Rule me = new Col2Rule(share);
/* 109 */     me.addExpression(createCommaExpression());
/* 110 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createCommaExpression() {
/* 114 */     return (AbstractExpression)new CommaExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createLetRule(ShareRuleValue share) {
/* 118 */     Col2RightJoinRule me = new Col2RightJoinRule(share);
/* 119 */     me.addExpression(createLetExpression());
/* 120 */     me.addExpression(createLetMultExpression());
/* 121 */     me.addExpression(createLetDivExpression());
/* 122 */     me.addExpression(createLetModExpression());
/* 123 */     me.addExpression(createLetPlusExpression());
/* 124 */     me.addExpression(createLetMinusExpression());
/* 125 */     me.addExpression(createLetShiftLeftExpression());
/* 126 */     me.addExpression(createLetShiftRightExpression());
/* 127 */     me.addExpression(createLetShiftRightLogicalExpression());
/* 128 */     me.addExpression(createLetAndExpression());
/* 129 */     me.addExpression(createLetOrExpression());
/* 130 */     me.addExpression(createLetXorExpression());
/* 131 */     me.addExpression(createLetPowerExpression());
/* 132 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetExpression() {
/* 136 */     return (AbstractExpression)new LetExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetMultExpression() {
/* 140 */     return (AbstractExpression)new LetMultExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetDivExpression() {
/* 144 */     return (AbstractExpression)new LetDivExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetModExpression() {
/* 148 */     return (AbstractExpression)new LetModExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetPlusExpression() {
/* 152 */     return (AbstractExpression)new LetPlusExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetMinusExpression() {
/* 156 */     return (AbstractExpression)new LetMinusExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetShiftLeftExpression() {
/* 160 */     return (AbstractExpression)new LetShiftLeftExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetShiftRightExpression() {
/* 164 */     return (AbstractExpression)new LetShiftRightExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetShiftRightLogicalExpression() {
/* 168 */     return (AbstractExpression)new LetShiftRightLogicalExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetAndExpression() {
/* 172 */     return (AbstractExpression)new LetAndExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetOrExpression() {
/* 176 */     return (AbstractExpression)new LetOrExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetXorExpression() {
/* 180 */     return (AbstractExpression)new LetXorExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLetPowerExpression() {
/* 184 */     return (AbstractExpression)new LetPowerExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createIfRule(ShareRuleValue share) {
/* 188 */     IfRule me = new IfRule(share);
/* 189 */     me.addExpression(me.cond = createIfExpression());
/* 190 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createIfExpression() {
/* 194 */     return (AbstractExpression)new IfExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createOrRule(ShareRuleValue share) {
/* 198 */     Col2Rule me = new Col2Rule(share);
/* 199 */     me.addExpression(createOrExpression());
/* 200 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createOrExpression() {
/* 204 */     return (AbstractExpression)new OrExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createAndRule(ShareRuleValue share) {
/* 208 */     Col2Rule me = new Col2Rule(share);
/* 209 */     me.addExpression(createAndExpression());
/* 210 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createAndExpression() {
/* 214 */     return (AbstractExpression)new AndExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createBitOrRule(ShareRuleValue share) {
/* 218 */     Col2Rule me = new Col2Rule(share);
/* 219 */     me.addExpression(createBitOrExpression());
/* 220 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createBitOrExpression() {
/* 224 */     return (AbstractExpression)new BitOrExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createBitXorRule(ShareRuleValue share) {
/* 228 */     Col2Rule me = new Col2Rule(share);
/* 229 */     me.addExpression(createBitXorExpression());
/* 230 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createBitXorExpression() {
/* 234 */     return (AbstractExpression)new BitXorExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createBitAndRule(ShareRuleValue share) {
/* 238 */     Col2Rule me = new Col2Rule(share);
/* 239 */     me.addExpression(createBitAndExpression());
/* 240 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createBitAndExpression() {
/* 244 */     return (AbstractExpression)new BitAndExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createEqualRule(ShareRuleValue share) {
/* 248 */     Col2Rule me = new Col2Rule(share);
/* 249 */     me.addExpression(createEqualExpression());
/* 250 */     me.addExpression(createNotEqualExpression());
/* 251 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createEqualExpression() {
/* 255 */     return (AbstractExpression)new EqualExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createNotEqualExpression() {
/* 259 */     return (AbstractExpression)new NotEqualExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createGreaterRule(ShareRuleValue share) {
/* 263 */     Col2Rule me = new Col2Rule(share);
/* 264 */     me.addExpression(createLessThanExpression());
/* 265 */     me.addExpression(createLessEqualExpression());
/* 266 */     me.addExpression(createGreaterThanExpression());
/* 267 */     me.addExpression(createGreaterEqualExpression());
/* 268 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLessThanExpression() {
/* 272 */     return (AbstractExpression)new LessThanExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createLessEqualExpression() {
/* 276 */     return (AbstractExpression)new LessEqualExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createGreaterThanExpression() {
/* 280 */     return (AbstractExpression)new GreaterThanExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createGreaterEqualExpression() {
/* 284 */     return (AbstractExpression)new GreaterEqualExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createShiftRule(ShareRuleValue share) {
/* 288 */     Col2Rule me = new Col2Rule(share);
/* 289 */     me.addExpression(createShiftLeftExpression());
/* 290 */     me.addExpression(createShiftRightExpression());
/* 291 */     me.addExpression(createShiftRightLogicalExpression());
/* 292 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createShiftLeftExpression() {
/* 296 */     return (AbstractExpression)new ShiftLeftExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createShiftRightExpression() {
/* 300 */     return (AbstractExpression)new ShiftRightExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createShiftRightLogicalExpression() {
/* 304 */     return (AbstractExpression)new ShiftRightLogicalExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createPlusRule(ShareRuleValue share) {
/* 308 */     Col2Rule me = new Col2Rule(share);
/* 309 */     me.addExpression(createPlusExpression());
/* 310 */     me.addExpression(createMinusExpression());
/* 311 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createPlusExpression() {
/* 315 */     return (AbstractExpression)new PlusExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createMinusExpression() {
/* 319 */     return (AbstractExpression)new MinusExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createMultRule(ShareRuleValue share) {
/* 323 */     Col2Rule me = new Col2Rule(share);
/* 324 */     me.addExpression(createMultExpression());
/* 325 */     me.addExpression(createDivExpression());
/* 326 */     me.addExpression(createModExpression());
/* 327 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createMultExpression() {
/* 331 */     return (AbstractExpression)new MultExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createDivExpression() {
/* 335 */     return (AbstractExpression)new DivExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createModExpression() {
/* 339 */     return (AbstractExpression)new ModExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createSignRule(ShareRuleValue share) {
/* 343 */     SignRule me = new SignRule(share);
/* 344 */     me.addExpression(createSignPlusExpression());
/* 345 */     me.addExpression(createSignMinusExpression());
/* 346 */     me.addExpression(createBitNotExpression());
/* 347 */     me.addExpression(createNotExpression());
/* 348 */     me.addExpression(createIncBeforeExpression());
/* 349 */     me.addExpression(createDecBeforeExpression());
/* 350 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createSignPlusExpression() {
/* 354 */     return (AbstractExpression)new SignPlusExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createSignMinusExpression() {
/* 358 */     return (AbstractExpression)new SignMinusExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createBitNotExpression() {
/* 362 */     return (AbstractExpression)new BitNotExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createNotExpression() {
/* 366 */     return (AbstractExpression)new NotExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createIncBeforeExpression() {
/* 370 */     return (AbstractExpression)new IncBeforeExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createDecBeforeExpression() {
/* 374 */     return (AbstractExpression)new DecBeforeExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createPowerRule(ShareRuleValue share) {
/* 378 */     Col2Rule me = new Col2Rule(share);
/* 379 */     me.addExpression(createPowerExpression());
/* 380 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createPowerExpression() {
/* 384 */     return (AbstractExpression)new PowerExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createCol1AfterRule(ShareRuleValue share) {
/* 388 */     Col1AfterRule me = new Col1AfterRule(share);
/* 389 */     me.addExpression(me.func = createFunctionExpression());
/* 390 */     me.addExpression(me.array = createArrayExpression());
/* 391 */     me.addExpression(createIncAfterExpression());
/* 392 */     me.addExpression(createDecAfterExpression());
/* 393 */     me.addExpression(me.field = createFieldExpression());
/* 394 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createFunctionExpression() {
/* 398 */     return (AbstractExpression)new FunctionExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createArrayExpression() {
/* 402 */     return (AbstractExpression)new ArrayExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createIncAfterExpression() {
/* 406 */     return (AbstractExpression)new IncAfterExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createDecAfterExpression() {
/* 410 */     return (AbstractExpression)new DecAfterExpression();
/*     */   }
/*     */   
/*     */   protected AbstractExpression createFieldExpression() {
/* 414 */     return (AbstractExpression)new FieldExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createPrimaryRule(ShareRuleValue share) {
/* 418 */     PrimaryRule me = new PrimaryRule(share);
/* 419 */     me.addExpression(createParenExpression());
/* 420 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createParenExpression() {
/* 424 */     return (AbstractExpression)new ParenExpression();
/*     */   }
/*     */   
/*     */   protected AbstractRule createFuncArgRule(ShareRuleValue share) {
/* 428 */     Col2Rule me = new Col2Rule(share);
/* 429 */     me.addExpression(createFuncArgExpression());
/* 430 */     return (AbstractRule)me;
/*     */   }
/*     */   
/*     */   protected AbstractExpression createFuncArgExpression() {
/* 434 */     return (AbstractExpression)new FuncArgExpression();
/*     */   }
/*     */   
/*     */   protected LexFactory getLexFactory() {
/* 438 */     if (this.defaultLexFactory == null) {
/* 439 */       this.defaultLexFactory = new LexFactory();
/*     */     }
/*     */     
/* 442 */     return this.defaultLexFactory;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\ExpRuleFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */