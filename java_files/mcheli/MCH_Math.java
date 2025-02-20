/*     */ package mcheli;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ public class MCH_Math
/*     */ {
/*  10 */   public static float PI = 3.1415927F;
/*  11 */   public static MCH_Math instance = new MCH_Math();
/*     */ 
/*     */   
/*     */   public FVector3D privateNewVec3D(float x, float y, float z) {
/*  15 */     FVector3D v = new FVector3D();
/*  16 */     v.x = x;
/*  17 */     v.y = y;
/*  18 */     v.z = z;
/*  19 */     return v;
/*     */   }
/*     */   
/*     */   public static FVector3D newVec3D() {
/*  23 */     return instance.privateNewVec3D(0.0F, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public static FVector3D newVec3D(float x, float y, float z) {
/*  27 */     return instance.privateNewVec3D(x, y, z);
/*     */   }
/*     */   
/*     */   private FQuat privateNewQuat() {
/*  31 */     FQuat q = new FQuat();
/*  32 */     QuatIdentity(q);
/*  33 */     return new FQuat();
/*     */   }
/*     */   
/*     */   public static FQuat newQuat() {
/*  37 */     return instance.privateNewQuat();
/*     */   }
/*     */   
/*     */   private FMatrix privateNewMatrix() {
/*  41 */     FMatrix m = new FMatrix();
/*  42 */     MatIdentity(m);
/*  43 */     return m;
/*     */   }
/*     */   
/*     */   public static FMatrix newMatrix() {
/*  47 */     return instance.privateNewMatrix();
/*     */   }
/*     */   
/*     */   public static FQuat EulerToQuatTestNG(float yaw, float pitch, float roll) {
/*  51 */     FVector3D axis = newVec3D();
/*  52 */     float rot = VecNormalize(axis);
/*  53 */     FQuat dqtn = newQuat();
/*  54 */     QuatRotation(dqtn, rot, axis.x, axis.y, axis.z);
/*  55 */     return dqtn;
/*     */   }
/*     */   
/*     */   public static FMatrix EulerToMatrix(float yaw, float pitch, float roll) {
/*  59 */     FMatrix m = newMatrix();
/*  60 */     MatTurnZ(m, roll / 180.0F * PI);
/*  61 */     MatTurnX(m, pitch / 180.0F * PI);
/*  62 */     MatTurnY(m, yaw / 180.0F * PI);
/*  63 */     return m;
/*     */   }
/*     */   
/*     */   public static FQuat EulerToQuat(float yaw, float pitch, float roll) {
/*  67 */     FQuat dqtn = newQuat();
/*  68 */     MatrixToQuat(dqtn, EulerToMatrix(yaw, pitch, roll));
/*  69 */     return dqtn;
/*     */   }
/*     */   
/*     */   public static FVector3D QuatToEuler(FQuat q) {
/*  73 */     FMatrix m = QuatToMatrix(q);
/*  74 */     return MatrixToEuler(m);
/*     */   }
/*     */   
/*     */   public static FVector3D MatrixToEuler(FMatrix m) {
/*  78 */     float xx = m.m00;
/*  79 */     float xy = m.m01;
/*  80 */     float xz = m.m02;
/*  81 */     float yy = m.m11;
/*  82 */     float zx = m.m20;
/*  83 */     float zy = m.m21;
/*  84 */     float zz = m.m22;
/*  85 */     float b = (float)-Math.asin(zy);
/*  86 */     float cosB = Cos(b);
/*     */ 
/*     */     
/*  89 */     if (Math.abs(cosB) >= 1.0E-4D) {
/*  90 */       c = Atan2(zx, zz);
/*  91 */       float xy_cos = xy / cosB;
/*  92 */       if (xy_cos > 1.0F) {
/*  93 */         xy_cos = 1.0F;
/*  94 */       } else if (xy_cos < -1.0F) {
/*  95 */         xy_cos = -1.0F;
/*     */       } 
/*     */       
/*  98 */       a = (float)Math.asin(xy_cos);
/*  99 */       if (Float.isNaN(a)) {
/* 100 */         a = 0.0F;
/*     */       }
/*     */     } else {
/* 103 */       c = Atan2(-xz, xx);
/* 104 */       a = 0.0F;
/*     */     } 
/*     */     
/* 107 */     float a = (float)(a * 180.0D / PI);
/* 108 */     b = (float)(b * 180.0D / PI);
/* 109 */     float c = (float)(c * 180.0D / PI);
/* 110 */     if (yy < 0.0F) {
/* 111 */       a = 180.0F - a;
/*     */     }
/*     */     
/* 114 */     return newVec3D(-b, -c, -a);
/*     */   }
/*     */   
/*     */   public float atan2(float y, float x) {
/* 118 */     return Atan2(y, x);
/*     */   }
/*     */   
/*     */   public static float SIGN(float x) {
/* 122 */     return (x >= 0.0F) ? 1.0F : -1.0F;
/*     */   }
/*     */   
/*     */   public static float NORM(float a, float b, float c, float d) {
/* 126 */     return (float)Math.sqrt((a * a + b * b + c * c + d * d));
/*     */   }
/*     */   
/*     */   public static void QuatNormalize(FQuat q) {
/* 130 */     float r = NORM(q.w, q.x, q.y, q.z);
/* 131 */     if (MathHelper.func_76135_e(r) > 1.0E-4D) {
/* 132 */       q.w /= r;
/* 133 */       q.x /= r;
/* 134 */       q.y /= r;
/* 135 */       q.z /= r;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean MatrixToQuat(FQuat q, FMatrix m) {
/* 141 */     q.w = (m.m00 + m.m11 + m.m22 + 1.0F) / 4.0F;
/* 142 */     q.x = (m.m00 - m.m11 - m.m22 + 1.0F) / 4.0F;
/* 143 */     q.y = (-m.m00 + m.m11 - m.m22 + 1.0F) / 4.0F;
/* 144 */     q.z = (-m.m00 - m.m11 + m.m22 + 1.0F) / 4.0F;
/* 145 */     if (q.w < 0.0F) {
/* 146 */       q.w = 0.0F;
/*     */     }
/*     */     
/* 149 */     if (q.x < 0.0F) {
/* 150 */       q.x = 0.0F;
/*     */     }
/*     */     
/* 153 */     if (q.y < 0.0F) {
/* 154 */       q.y = 0.0F;
/*     */     }
/*     */     
/* 157 */     if (q.z < 0.0F) {
/* 158 */       q.z = 0.0F;
/*     */     }
/*     */     
/* 161 */     q.w = (float)Math.sqrt(q.w);
/* 162 */     q.x = (float)Math.sqrt(q.x);
/* 163 */     q.y = (float)Math.sqrt(q.y);
/* 164 */     q.z = (float)Math.sqrt(q.z);
/* 165 */     if (q.w >= q.x && q.w >= q.y && q.w >= q.z) {
/* 166 */       q.w *= 1.0F;
/* 167 */       q.x *= SIGN(m.m21 - m.m12);
/* 168 */       q.y *= SIGN(m.m02 - m.m20);
/* 169 */       q.z *= SIGN(m.m10 - m.m01);
/* 170 */     } else if (q.x >= q.w && q.x >= q.y && q.x >= q.z) {
/* 171 */       q.w *= SIGN(m.m21 - m.m12);
/* 172 */       q.x *= 1.0F;
/* 173 */       q.y *= SIGN(m.m10 + m.m01);
/* 174 */       q.z *= SIGN(m.m02 + m.m20);
/* 175 */     } else if (q.y >= q.w && q.y >= q.x && q.y >= q.z) {
/* 176 */       q.w *= SIGN(m.m02 - m.m20);
/* 177 */       q.x *= SIGN(m.m10 + m.m01);
/* 178 */       q.y *= 1.0F;
/* 179 */       q.z *= SIGN(m.m21 + m.m12);
/*     */     } else {
/* 181 */       if (q.z < q.w || q.z < q.x || q.z < q.y) {
/* 182 */         QuatIdentity(q);
/* 183 */         return false;
/*     */       } 
/*     */       
/* 186 */       q.w *= SIGN(m.m10 - m.m01);
/* 187 */       q.x *= SIGN(m.m20 + m.m02);
/* 188 */       q.y *= SIGN(m.m21 + m.m12);
/* 189 */       q.z *= 1.0F;
/*     */     } 
/*     */     
/* 192 */     correctQuat(q);
/* 193 */     float r = NORM(q.w, q.x, q.y, q.z);
/* 194 */     q.w /= r;
/* 195 */     q.x /= r;
/* 196 */     q.y /= r;
/* 197 */     q.z /= r;
/* 198 */     correctQuat(q);
/* 199 */     return true;
/*     */   }
/*     */   
/*     */   public static void correctQuat(FQuat q) {
/* 203 */     if (Float.isNaN(q.w) || Float.isInfinite(q.w)) {
/* 204 */       q.w = 0.0F;
/*     */     }
/*     */     
/* 207 */     if (Float.isNaN(q.x) || Float.isInfinite(q.x)) {
/* 208 */       q.x = 0.0F;
/*     */     }
/*     */     
/* 211 */     if (Float.isNaN(q.y) || Float.isInfinite(q.y)) {
/* 212 */       q.y = 0.0F;
/*     */     }
/*     */     
/* 215 */     if (Float.isNaN(q.z) || Float.isInfinite(q.z)) {
/* 216 */       q.z = 0.0F;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static FQuat motionTest(int x, int y, FQuat prevQtn) {
/* 222 */     FVector3D axis = newVec3D();
/* 223 */     FQuat dqtn = newQuat();
/* 224 */     axis.x = 2.0F * PI * y / 200.0F;
/* 225 */     axis.y = 2.0F * PI * x / 200.0F;
/* 226 */     axis.z = 0.0F;
/* 227 */     float rot = VecNormalize(axis);
/* 228 */     QuatRotation(dqtn, rot, axis.x, axis.y, axis.z);
/* 229 */     return QuatMult(dqtn, prevQtn);
/*     */   }
/*     */   
/*     */   public static float Sin(float rad) {
/* 233 */     return (float)Math.sin(rad);
/*     */   }
/*     */   
/*     */   public static float Cos(float rad) {
/* 237 */     return (float)Math.cos(rad);
/*     */   }
/*     */   
/*     */   public static float Tan(float rad) {
/* 241 */     return (float)Math.tan(rad);
/*     */   }
/*     */   
/*     */   public static float Floor(float x) {
/* 245 */     return (float)Math.floor(x);
/*     */   }
/*     */   
/*     */   public static float Atan(float x) {
/* 249 */     return (float)Math.atan(x);
/*     */   }
/*     */   
/*     */   public static float Atan2(float y, float x) {
/* 253 */     return (float)Math.atan2(y, x);
/*     */   }
/*     */   
/*     */   public static float Fabs(float x) {
/* 257 */     return (x >= 0.0F) ? x : -x;
/*     */   }
/*     */   
/*     */   public static float Sqrt(float x) {
/* 261 */     return (float)Math.sqrt(x);
/*     */   }
/*     */   
/*     */   public static float InvSqrt(float x) {
/* 265 */     return 1.0F / (float)Math.sqrt(x);
/*     */   }
/*     */   
/*     */   public static float Pow(float a, float b) {
/* 269 */     return (float)Math.pow(a, b);
/*     */   }
/*     */   
/*     */   public static float VecNormalize(FVector3D lpV) {
/* 273 */     float len2 = lpV.x * lpV.x + lpV.y * lpV.y + lpV.z * lpV.z;
/* 274 */     float length = Sqrt(len2);
/* 275 */     if (length == 0.0F) {
/* 276 */       return 0.0F;
/*     */     }
/* 278 */     float invLength = 1.0F / length;
/* 279 */     lpV.x *= invLength;
/* 280 */     lpV.y *= invLength;
/* 281 */     lpV.z *= invLength;
/* 282 */     return length;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float Vec2DNormalize(FVector2D lpV) {
/* 287 */     float len2 = lpV.x * lpV.x + lpV.y * lpV.y;
/* 288 */     float length = Sqrt(len2);
/* 289 */     if (length == 0.0F) {
/* 290 */       return 0.0F;
/*     */     }
/* 292 */     float invLength = 1.0F / length;
/* 293 */     lpV.x *= invLength;
/* 294 */     lpV.y *= invLength;
/* 295 */     return length;
/*     */   }
/*     */ 
/*     */   
/*     */   public static FVector3D MatVector(FMatrix lpM, FVector3D lpV) {
/* 300 */     FVector3D lpS = newVec3D();
/* 301 */     float x = lpV.x;
/* 302 */     float y = lpV.y;
/* 303 */     float z = lpV.z;
/* 304 */     lpS.x = lpM.m00 * x + lpM.m01 * y + lpM.m02 * z + lpM.m03;
/* 305 */     lpS.y = lpM.m10 * x + lpM.m11 * y + lpM.m12 * z + lpM.m13;
/* 306 */     lpS.z = lpM.m20 * x + lpM.m21 * y + lpM.m22 * z + lpM.m23;
/* 307 */     return lpS;
/*     */   }
/*     */   
/*     */   public static FVector3D MatDirection(FMatrix lpM, FVector3D lpDir) {
/* 311 */     FVector3D lpSDir = newVec3D();
/* 312 */     float x = lpDir.x;
/* 313 */     float y = lpDir.y;
/* 314 */     float z = lpDir.z;
/* 315 */     lpSDir.x = lpM.m00 * x + lpM.m01 * y + lpM.m02 * z;
/* 316 */     lpSDir.y = lpM.m10 * x + lpM.m11 * y + lpM.m12 * z;
/* 317 */     lpSDir.z = lpM.m20 * x + lpM.m21 * y + lpM.m22 * z;
/* 318 */     return lpSDir;
/*     */   }
/*     */   
/*     */   public static void MatIdentity(FMatrix lpM) {
/* 322 */     lpM.m01 = lpM.m02 = lpM.m03 = lpM.m10 = lpM.m12 = lpM.m13 = lpM.m20 = lpM.m21 = lpM.m23 = lpM.m30 = lpM.m31 = lpM.m32 = 0.0F;
/* 323 */     lpM.m00 = lpM.m11 = lpM.m22 = lpM.m33 = 1.0F;
/*     */   }
/*     */   
/*     */   public static void MatCopy(FMatrix lpMa, FMatrix lpMb) {
/* 327 */     lpMa.m00 = lpMb.m00;
/* 328 */     lpMa.m10 = lpMb.m10;
/* 329 */     lpMa.m20 = lpMb.m20;
/* 330 */     lpMa.m30 = lpMb.m30;
/* 331 */     lpMa.m01 = lpMb.m01;
/* 332 */     lpMa.m11 = lpMb.m11;
/* 333 */     lpMa.m21 = lpMb.m21;
/* 334 */     lpMa.m31 = lpMb.m31;
/* 335 */     lpMa.m02 = lpMb.m02;
/* 336 */     lpMa.m12 = lpMb.m12;
/* 337 */     lpMa.m22 = lpMb.m22;
/* 338 */     lpMa.m32 = lpMb.m32;
/* 339 */     lpMa.m03 = lpMb.m03;
/* 340 */     lpMa.m13 = lpMb.m13;
/* 341 */     lpMa.m23 = lpMb.m23;
/* 342 */     lpMa.m33 = lpMb.m33;
/*     */   }
/*     */   
/*     */   public static void MatTranslate(FMatrix m, float x, float y, float z) {
/* 346 */     float m30 = m.m30;
/* 347 */     float m31 = m.m31;
/* 348 */     float m32 = m.m32;
/* 349 */     float m33 = m.m33;
/* 350 */     m.m00 += m30 * x;
/* 351 */     m.m01 += m31 * x;
/* 352 */     m.m02 += m32 * x;
/* 353 */     m.m03 += m33 * x;
/* 354 */     m.m10 += m30 * y;
/* 355 */     m.m11 += m31 * y;
/* 356 */     m.m12 += m32 * y;
/* 357 */     m.m13 += m33 * y;
/* 358 */     m.m20 += m30 * z;
/* 359 */     m.m21 += m31 * z;
/* 360 */     m.m22 += m32 * z;
/* 361 */     m.m23 += m33 * z;
/*     */   }
/*     */   
/*     */   public static void MatMove(FMatrix m, float x, float y, float z) {
/* 365 */     m.m03 += m.m00 * x + m.m01 * y + m.m02 * z;
/* 366 */     m.m13 += m.m10 * x + m.m11 * y + m.m12 * z;
/* 367 */     m.m23 += m.m20 * x + m.m21 * y + m.m22 * z;
/* 368 */     m.m33 += m.m30 * x + m.m31 * y + m.m32 * z;
/*     */   }
/*     */   
/*     */   public static void MatRotateX(FMatrix m, float rad) {
/* 372 */     if (rad > 2.0F * PI || rad < -2.0F * PI) {
/* 373 */       rad -= 2.0F * PI * (int)(rad / 2.0F * PI);
/*     */     }
/*     */     
/* 376 */     float cosA = Cos(rad);
/* 377 */     float sinA = Sin(rad);
/* 378 */     float tmp1 = m.m10;
/* 379 */     float tmp2 = m.m20;
/* 380 */     m.m10 = cosA * tmp1 - sinA * tmp2;
/* 381 */     m.m20 = sinA * tmp1 + cosA * tmp2;
/* 382 */     tmp1 = m.m11;
/* 383 */     tmp2 = m.m21;
/* 384 */     m.m11 = cosA * tmp1 - sinA * tmp2;
/* 385 */     m.m21 = sinA * tmp1 + cosA * tmp2;
/* 386 */     tmp1 = m.m12;
/* 387 */     tmp2 = m.m22;
/* 388 */     m.m12 = cosA * tmp1 - sinA * tmp2;
/* 389 */     m.m22 = sinA * tmp1 + cosA * tmp2;
/* 390 */     tmp1 = m.m13;
/* 391 */     tmp2 = m.m23;
/* 392 */     m.m13 = cosA * tmp1 - sinA * tmp2;
/* 393 */     m.m23 = sinA * tmp1 + cosA * tmp2;
/*     */   }
/*     */   
/*     */   public static void MatRotateY(FMatrix m, float rad) {
/* 397 */     if (rad > 2.0F * PI || rad < -2.0F * PI) {
/* 398 */       rad -= 2.0F * PI * (int)(rad / 2.0F * PI);
/*     */     }
/*     */     
/* 401 */     float cosA = Cos(rad);
/* 402 */     float sinA = Sin(rad);
/* 403 */     float tmp1 = m.m00;
/* 404 */     float tmp2 = m.m20;
/* 405 */     m.m00 = cosA * tmp1 + sinA * tmp2;
/* 406 */     m.m20 = -sinA * tmp1 + cosA * tmp2;
/* 407 */     tmp1 = m.m01;
/* 408 */     tmp2 = m.m21;
/* 409 */     m.m01 = cosA * tmp1 + sinA * tmp2;
/* 410 */     m.m21 = -sinA * tmp1 + cosA * tmp2;
/* 411 */     tmp1 = m.m02;
/* 412 */     tmp2 = m.m22;
/* 413 */     m.m02 = cosA * tmp1 + sinA * tmp2;
/* 414 */     m.m22 = -sinA * tmp1 + cosA * tmp2;
/* 415 */     tmp1 = m.m03;
/* 416 */     tmp2 = m.m23;
/* 417 */     m.m03 = cosA * tmp1 + sinA * tmp2;
/* 418 */     m.m23 = -sinA * tmp1 + cosA * tmp2;
/*     */   }
/*     */   
/*     */   public static void MatRotateZ(FMatrix m, float rad) {
/* 422 */     if (rad > 2.0F * PI || rad < -2.0F * PI) {
/* 423 */       rad -= 2.0F * PI * (int)(rad / 2.0F * PI);
/*     */     }
/*     */     
/* 426 */     float cosA = Cos(rad);
/* 427 */     float sinA = Sin(rad);
/* 428 */     float tmp1 = m.m00;
/* 429 */     float tmp2 = m.m10;
/* 430 */     m.m00 = cosA * tmp1 - sinA * tmp2;
/* 431 */     m.m10 = sinA * tmp1 + cosA * tmp2;
/* 432 */     tmp1 = m.m01;
/* 433 */     tmp2 = m.m11;
/* 434 */     m.m01 = cosA * tmp1 - sinA * tmp2;
/* 435 */     m.m11 = sinA * tmp1 + cosA * tmp2;
/* 436 */     tmp1 = m.m02;
/* 437 */     tmp2 = m.m12;
/* 438 */     m.m02 = cosA * tmp1 - sinA * tmp2;
/* 439 */     m.m12 = sinA * tmp1 + cosA * tmp2;
/* 440 */     tmp1 = m.m03;
/* 441 */     tmp2 = m.m13;
/* 442 */     m.m03 = cosA * tmp1 - sinA * tmp2;
/* 443 */     m.m13 = sinA * tmp1 + cosA * tmp2;
/*     */   }
/*     */   
/*     */   public static void MatTurnX(FMatrix m, float rad) {
/* 447 */     if (rad > 2.0F * PI || rad < -2.0F * PI) {
/* 448 */       rad -= 2.0F * PI * (int)(rad / 2.0F * PI);
/*     */     }
/*     */     
/* 451 */     float cosA = Cos(rad);
/* 452 */     float sinA = Sin(rad);
/* 453 */     float tmp1 = m.m01;
/* 454 */     float tmp2 = m.m02;
/* 455 */     m.m01 = cosA * tmp1 + sinA * tmp2;
/* 456 */     m.m02 = -sinA * tmp1 + cosA * tmp2;
/* 457 */     tmp1 = m.m11;
/* 458 */     tmp2 = m.m12;
/* 459 */     m.m11 = cosA * tmp1 + sinA * tmp2;
/* 460 */     m.m12 = -sinA * tmp1 + cosA * tmp2;
/* 461 */     tmp1 = m.m21;
/* 462 */     tmp2 = m.m22;
/* 463 */     m.m21 = cosA * tmp1 + sinA * tmp2;
/* 464 */     m.m22 = -sinA * tmp1 + cosA * tmp2;
/* 465 */     tmp1 = m.m31;
/* 466 */     tmp2 = m.m32;
/* 467 */     m.m31 = cosA * tmp1 + sinA * tmp2;
/* 468 */     m.m32 = -sinA * tmp1 + cosA * tmp2;
/*     */   }
/*     */   
/*     */   public static void MatTurnY(FMatrix m, float rad) {
/* 472 */     if (rad > 2.0F * PI || rad < -2.0F * PI) {
/* 473 */       rad -= 2.0F * PI * (int)(rad / 2.0F * PI);
/*     */     }
/*     */     
/* 476 */     float cosA = Cos(rad);
/* 477 */     float sinA = Sin(rad);
/* 478 */     float tmp1 = m.m00;
/* 479 */     float tmp2 = m.m02;
/* 480 */     m.m00 = cosA * tmp1 - sinA * tmp2;
/* 481 */     m.m02 = sinA * tmp1 + cosA * tmp2;
/* 482 */     tmp1 = m.m10;
/* 483 */     tmp2 = m.m12;
/* 484 */     m.m10 = cosA * tmp1 - sinA * tmp2;
/* 485 */     m.m12 = sinA * tmp1 + cosA * tmp2;
/* 486 */     tmp1 = m.m20;
/* 487 */     tmp2 = m.m22;
/* 488 */     m.m20 = cosA * tmp1 - sinA * tmp2;
/* 489 */     m.m22 = sinA * tmp1 + cosA * tmp2;
/* 490 */     tmp1 = m.m30;
/* 491 */     tmp2 = m.m32;
/* 492 */     m.m30 = cosA * tmp1 - sinA * tmp2;
/* 493 */     m.m32 = sinA * tmp1 + cosA * tmp2;
/*     */   }
/*     */   
/*     */   public static void MatTurnZ(FMatrix m, float rad) {
/* 497 */     if (rad > 2.0F * PI || rad < -2.0F * PI) {
/* 498 */       rad -= 2.0F * PI * (int)(rad / 2.0F * PI);
/*     */     }
/*     */     
/* 501 */     float cosA = Cos(rad);
/* 502 */     float sinA = Sin(rad);
/* 503 */     float tmp1 = m.m00;
/* 504 */     float tmp2 = m.m01;
/* 505 */     m.m00 = cosA * tmp1 + sinA * tmp2;
/* 506 */     m.m01 = -sinA * tmp1 + cosA * tmp2;
/* 507 */     tmp1 = m.m10;
/* 508 */     tmp2 = m.m11;
/* 509 */     m.m10 = cosA * tmp1 + sinA * tmp2;
/* 510 */     m.m11 = -sinA * tmp1 + cosA * tmp2;
/* 511 */     tmp1 = m.m20;
/* 512 */     tmp2 = m.m21;
/* 513 */     m.m20 = cosA * tmp1 + sinA * tmp2;
/* 514 */     m.m21 = -sinA * tmp1 + cosA * tmp2;
/* 515 */     tmp1 = m.m30;
/* 516 */     tmp2 = m.m31;
/* 517 */     m.m30 = cosA * tmp1 + sinA * tmp2;
/* 518 */     m.m31 = -sinA * tmp1 + cosA * tmp2;
/*     */   }
/*     */   
/*     */   public static void MatScale(FMatrix lpM, float scalex, float scaley, float scalez) {
/* 522 */     lpM.m00 = scalex * lpM.m00;
/* 523 */     lpM.m01 = scalex * lpM.m01;
/* 524 */     lpM.m02 = scalex * lpM.m02;
/* 525 */     lpM.m03 = scalex * lpM.m03;
/* 526 */     lpM.m10 = scaley * lpM.m10;
/* 527 */     lpM.m11 = scaley * lpM.m11;
/* 528 */     lpM.m12 = scaley * lpM.m12;
/* 529 */     lpM.m13 = scaley * lpM.m13;
/* 530 */     lpM.m20 = scalez * lpM.m20;
/* 531 */     lpM.m21 = scalez * lpM.m21;
/* 532 */     lpM.m22 = scalez * lpM.m22;
/* 533 */     lpM.m23 = scalez * lpM.m23;
/*     */   }
/*     */   
/*     */   public static void MatSize(FMatrix lpM, float scalex, float scaley, float scalez) {
/* 537 */     lpM.m00 = scalex * lpM.m00;
/* 538 */     lpM.m01 = scaley * lpM.m01;
/* 539 */     lpM.m02 = scalez * lpM.m02;
/* 540 */     lpM.m10 = scalex * lpM.m10;
/* 541 */     lpM.m11 = scaley * lpM.m11;
/* 542 */     lpM.m12 = scalez * lpM.m12;
/* 543 */     lpM.m20 = scalex * lpM.m20;
/* 544 */     lpM.m21 = scaley * lpM.m21;
/* 545 */     lpM.m22 = scalez * lpM.m22;
/* 546 */     lpM.m30 = scalex * lpM.m30;
/* 547 */     lpM.m31 = scaley * lpM.m31;
/* 548 */     lpM.m32 = scalez * lpM.m32;
/*     */   }
/*     */   
/*     */   public static FQuat QuatMult(FQuat lpP, FQuat lpQ) {
/* 552 */     FQuat lpR = newQuat();
/* 553 */     float pw = lpP.w;
/* 554 */     float px = lpP.x;
/* 555 */     float py = lpP.y;
/* 556 */     float pz = lpP.z;
/* 557 */     float qw = lpQ.w;
/* 558 */     float qx = lpQ.x;
/* 559 */     float qy = lpQ.y;
/* 560 */     float qz = lpQ.z;
/* 561 */     lpR.w = pw * qw - px * qx - py * qy - pz * qz;
/* 562 */     lpR.x = pw * qx + px * qw + py * qz - pz * qy;
/* 563 */     lpR.y = pw * qy - px * qz + py * qw + pz * qx;
/* 564 */     lpR.z = pw * qz + px * qy - py * qx + pz * qw;
/* 565 */     return lpR;
/*     */   }
/*     */   
/*     */   public static void QuatAdd(FQuat q_out, FQuat q) {
/* 569 */     q_out.w += q.w;
/* 570 */     q_out.x += q.x;
/* 571 */     q_out.y += q.y;
/* 572 */     q_out.z += q.z;
/*     */   }
/*     */   
/*     */   public static FMatrix QuatToMatrix(FQuat lpQ) {
/* 576 */     FMatrix lpM = newMatrix();
/* 577 */     float qw = lpQ.w;
/* 578 */     float qx = lpQ.x;
/* 579 */     float qy = lpQ.y;
/* 580 */     float qz = lpQ.z;
/* 581 */     float x2 = 2.0F * qx * qx;
/* 582 */     float y2 = 2.0F * qy * qy;
/* 583 */     float z2 = 2.0F * qz * qz;
/* 584 */     float xy = 2.0F * qx * qy;
/* 585 */     float yz = 2.0F * qy * qz;
/* 586 */     float zx = 2.0F * qz * qx;
/* 587 */     float wx = 2.0F * qw * qx;
/* 588 */     float wy = 2.0F * qw * qy;
/* 589 */     float wz = 2.0F * qw * qz;
/* 590 */     lpM.m00 = 1.0F - y2 - z2;
/* 591 */     lpM.m01 = xy - wz;
/* 592 */     lpM.m02 = zx + wy;
/* 593 */     lpM.m03 = 0.0F;
/* 594 */     lpM.m10 = xy + wz;
/* 595 */     lpM.m11 = 1.0F - z2 - x2;
/* 596 */     lpM.m12 = yz - wx;
/* 597 */     lpM.m13 = 0.0F;
/* 598 */     lpM.m20 = zx - wy;
/* 599 */     lpM.m21 = yz + wx;
/* 600 */     lpM.m22 = 1.0F - x2 - y2;
/* 601 */     lpM.m23 = 0.0F;
/* 602 */     lpM.m30 = lpM.m31 = lpM.m32 = 0.0F;
/* 603 */     lpM.m33 = 1.0F;
/* 604 */     return lpM;
/*     */   }
/*     */   
/*     */   public static void QuatRotation(FQuat lpQ, float rad, float ax, float ay, float az) {
/* 608 */     float hrad = 0.5F * rad;
/* 609 */     float s = Sin(hrad);
/* 610 */     lpQ.w = Cos(hrad);
/* 611 */     lpQ.x = s * ax;
/* 612 */     lpQ.y = s * ay;
/* 613 */     lpQ.z = s * az;
/*     */   }
/*     */   
/*     */   public static void QuatIdentity(FQuat lpQ) {
/* 617 */     lpQ.w = 1.0F;
/* 618 */     lpQ.x = 0.0F;
/* 619 */     lpQ.y = 0.0F;
/* 620 */     lpQ.z = 0.0F;
/*     */   }
/*     */   
/*     */   public static void QuatCopy(FQuat lpTo, FQuat lpFrom) {
/* 624 */     lpTo.w = lpFrom.w;
/* 625 */     lpTo.x = lpFrom.x;
/* 626 */     lpTo.y = lpFrom.y;
/* 627 */     lpTo.z = lpFrom.z;
/*     */   }
/*     */ 
/*     */   
/*     */   public class FVector2D
/*     */   {
/*     */     public float x;
/*     */     
/*     */     public float y;
/*     */   }
/*     */ 
/*     */   
/*     */   public class FVector3D
/*     */   {
/*     */     public float x;
/*     */     
/*     */     public float y;
/*     */     
/*     */     public float z;
/*     */   }
/*     */ 
/*     */   
/*     */   public class FQuat
/*     */   {
/*     */     public float w;
/*     */     
/*     */     public float x;
/*     */     
/*     */     public float y;
/*     */     public float z;
/*     */   }
/*     */   
/*     */   public class FMatrix
/*     */   {
/*     */     float m00;
/*     */     float m10;
/*     */     float m20;
/*     */     float m30;
/*     */     float m01;
/*     */     float m11;
/*     */     float m21;
/*     */     float m31;
/*     */     float m02;
/*     */     float m12;
/*     */     float m22;
/*     */     float m32;
/*     */     float m03;
/*     */     float m13;
/*     */     float m23;
/*     */     float m33;
/*     */     
/*     */     public FloatBuffer toFloatBuffer() {
/* 679 */       ByteBuffer bb = ByteBuffer.allocateDirect(64);
/* 680 */       FloatBuffer fb = bb.asFloatBuffer();
/* 681 */       fb.put(this.m00);
/* 682 */       fb.put(this.m10);
/* 683 */       fb.put(this.m20);
/* 684 */       fb.put(this.m30);
/* 685 */       fb.put(this.m01);
/* 686 */       fb.put(this.m11);
/* 687 */       fb.put(this.m21);
/* 688 */       fb.put(this.m31);
/* 689 */       fb.put(this.m02);
/* 690 */       fb.put(this.m12);
/* 691 */       fb.put(this.m22);
/* 692 */       fb.put(this.m32);
/* 693 */       fb.put(this.m03);
/* 694 */       fb.put(this.m13);
/* 695 */       fb.put(this.m23);
/* 696 */       fb.put(this.m33);
/* 697 */       float f = fb.get(0);
/* 698 */       f = fb.get(1);
/* 699 */       fb.position(0);
/* 700 */       return fb;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_Math.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */