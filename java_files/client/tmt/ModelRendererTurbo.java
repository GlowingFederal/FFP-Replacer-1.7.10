package com.flansmod.client.tmt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ModelRendererTurbo extends ModelRenderer {
  public boolean glow = false;
  
  private static float lightmapLastX;
  
  private static float lightmapLastY;
  
  public ModelRendererTurbo(ModelBase modelbase, String s) {
    super(modelbase, s);
    this.flip = false;
    this.compiled = false;
    this.displayList = 0;
    this.field_78809_i = false;
    this.field_78806_j = true;
    this.field_1402_i = false;
    this.vertices = new PositionTextureVertex[0];
    this.faces = new TexturedPolygon[0];
    this.forcedRecompile = false;
    this.transformGroup = new HashMap<>();
    this.transformGroup.put("0", new TransformGroupBone(new Bone(0.0F, 0.0F, 0.0F, 0.0F), 1.0D));
    this.textureGroup = new HashMap<>();
    this.textureGroup.put("0", new TextureGroup());
    this.currentTextureGroup = this.textureGroup.get("0");
    this.field_78802_n = s;
    this.defaultTexture = "";
    this.useLegacyCompiler = false;
  }
  
  public ModelRendererTurbo(ModelBase modelbase) {
    this(modelbase, (String)null);
  }
  
  public ModelRendererTurbo(ModelBase modelbase, int textureX, int textureY) {
    this(modelbase, textureX, textureY, 64, 32);
  }
  
  public ModelRendererTurbo(ModelBase modelbase, int textureX, int textureY, int textureU, int textureV) {
    this(modelbase);
    this.textureOffsetX = textureX;
    this.textureOffsetY = textureY;
    this.field_78801_a = textureU;
    this.field_78799_b = textureV;
  }
  
  public void addPolygon(PositionTextureVertex[] verts) {
    copyTo(verts, new TexturedPolygon[] { new TexturedPolygon(verts) });
  }
  
  public void addPolygon(PositionTextureVertex[] verts, int[][] uv) {
    try {
      for (int i = 0; i < verts.length; i++)
        verts[i] = verts[i].setTexturePosition(uv[i][0] / this.field_78801_a, uv[i][1] / this.field_78799_b); 
    } finally {
      addPolygon(verts);
    } 
  }
  
  public void addPolygon(PositionTextureVertex[] verts, int u1, int v1, int u2, int v2) {
    copyTo(verts, new TexturedPolygon[] { addPolygonReturn(verts, u1, v1, u2, v2) });
  }
  
  private TexturedPolygon addPolygonReturn(PositionTextureVertex[] verts, int u1, int v1, int u2, int v2, float q1, float q2, float q3, float q4) {
    if (verts.length < 3)
      return null; 
    float uOffs = 1.0F / this.field_78801_a * 10.0F;
    float vOffs = 1.0F / this.field_78799_b * 10.0F;
    if (verts.length < 4) {
      float xMin = -1.0F;
      float yMin = -1.0F;
      float xMax = 0.0F;
      float yMax = 0.0F;
      for (PositionTextureVertex vert : verts) {
        float xPos = vert.field_78241_b;
        float yPos = vert.field_78242_c;
        xMax = Math.max(xMax, xPos);
        xMin = (xMin < -1.0F) ? xPos : Math.min(xMin, xPos);
        yMax = Math.max(yMax, yPos);
        yMin = (yMin < -1.0F) ? yPos : Math.min(yMin, yPos);
      } 
      float uMin = u1 / this.field_78801_a + uOffs;
      float vMin = v1 / this.field_78799_b + vOffs;
      float uSize = (u2 - u1) / this.field_78801_a - uOffs * 2.0F;
      float vSize = (v2 - v1) / this.field_78799_b - vOffs * 2.0F;
      float xSize = xMax - xMin;
      float ySize = yMax - yMin;
      for (int i = 0; i < verts.length; i++) {
        float xPos = (verts[i]).field_78241_b;
        float yPos = (verts[i]).field_78242_c;
        xPos = (xPos - xMin) / xSize;
        yPos = (yPos - yMin) / ySize;
        verts[i] = verts[i].setTexturePosition(uMin + xPos * uSize, vMin + yPos * vSize);
      } 
    } else {
      verts[0] = verts[0].setTexturePosition((u2 / this.field_78801_a - uOffs) * q1, (v1 / this.field_78799_b + vOffs) * q1, q1);
      verts[1] = verts[1].setTexturePosition((u1 / this.field_78801_a + uOffs) * q2, (v1 / this.field_78799_b + vOffs) * q2, q2);
      verts[2] = verts[2].setTexturePosition((u1 / this.field_78801_a + uOffs) * q3, (v2 / this.field_78799_b - vOffs) * q3, q3);
      verts[3] = verts[3].setTexturePosition((u2 / this.field_78801_a - uOffs) * q4, (v2 / this.field_78799_b - vOffs) * q4, q4);
    } 
    return new TexturedPolygon(verts);
  }
  
  private TexturedPolygon addPolygonReturn(PositionTextureVertex[] verts, int u1, int v1, int u2, int v2) {
    if (verts.length < 3)
      return null; 
    float uOffs = 1.0F / this.field_78801_a * 10.0F;
    float vOffs = 1.0F / this.field_78799_b * 10.0F;
    if (verts.length < 4) {
      float xMin = -1.0F;
      float yMin = -1.0F;
      float xMax = 0.0F;
      float yMax = 0.0F;
      for (PositionTextureVertex vert : verts) {
        float xPos = vert.field_78241_b;
        float yPos = vert.field_78242_c;
        xMax = Math.max(xMax, xPos);
        xMin = (xMin < -1.0F) ? xPos : Math.min(xMin, xPos);
        yMax = Math.max(yMax, yPos);
        yMin = (yMin < -1.0F) ? yPos : Math.min(yMin, yPos);
      } 
      float uMin = u1 / this.field_78801_a + uOffs;
      float vMin = v1 / this.field_78799_b + vOffs;
      float uSize = (u2 - u1) / this.field_78801_a - uOffs * 2.0F;
      float vSize = (v2 - v1) / this.field_78799_b - vOffs * 2.0F;
      float xSize = xMax - xMin;
      float ySize = yMax - yMin;
      for (int i = 0; i < verts.length; i++) {
        float xPos = (verts[i]).field_78241_b;
        float yPos = (verts[i]).field_78242_c;
        xPos = (xPos - xMin) / xSize;
        yPos = (yPos - yMin) / ySize;
        verts[i] = verts[i].setTexturePosition(uMin + xPos * uSize, vMin + yPos * vSize);
      } 
    } else {
      verts[0] = verts[0].setTexturePosition(u2 / this.field_78801_a - uOffs, v1 / this.field_78799_b + vOffs);
      verts[1] = verts[1].setTexturePosition(u1 / this.field_78801_a + uOffs, v1 / this.field_78799_b + vOffs);
      verts[2] = verts[2].setTexturePosition(u1 / this.field_78801_a + uOffs, v2 / this.field_78799_b - vOffs);
      verts[3] = verts[3].setTexturePosition(u2 / this.field_78801_a - uOffs, v2 / this.field_78799_b - vOffs);
    } 
    return new TexturedPolygon(verts);
  }
  
  public void addRectShape(float[] v, float[] v1, float[] v2, float[] v3, float[] v4, float[] v5, float[] v6, float[] v7, int w, int h, int d) {
    float[] var1 = { 
        1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 
        1.0F, 1.0F };
    addRectShape(v, v1, v2, v3, v4, v5, v6, v7, w, h, d, var1);
  }
  
  public void addRectShape(float[] v, float[] v1, float[] v2, float[] v3, float[] v4, float[] v5, float[] v6, float[] v7, int w, int h, int d, float[] qParam) {
    PositionTextureVertex[] verts = new PositionTextureVertex[8];
    TexturedPolygon[] poly = new TexturedPolygon[6];
    PositionTextureVertex positionTexturevertex = new PositionTextureVertex(v[0], v[1], v[2], 0.0F, 0.0F);
    PositionTextureVertex positionTexturevertex1 = new PositionTextureVertex(v1[0], v1[1], v1[2], 0.0F, 8.0F);
    PositionTextureVertex positionTexturevertex2 = new PositionTextureVertex(v2[0], v2[1], v2[2], 8.0F, 8.0F);
    PositionTextureVertex positionTexturevertex3 = new PositionTextureVertex(v3[0], v3[1], v3[2], 8.0F, 0.0F);
    PositionTextureVertex positionTexturevertex4 = new PositionTextureVertex(v4[0], v4[1], v4[2], 0.0F, 0.0F);
    PositionTextureVertex positionTexturevertex5 = new PositionTextureVertex(v5[0], v5[1], v5[2], 0.0F, 8.0F);
    PositionTextureVertex positionTexturevertex6 = new PositionTextureVertex(v6[0], v6[1], v6[2], 8.0F, 8.0F);
    PositionTextureVertex positionTexturevertex7 = new PositionTextureVertex(v7[0], v7[1], v7[2], 8.0F, 0.0F);
    verts[0] = positionTexturevertex;
    verts[1] = positionTexturevertex1;
    verts[2] = positionTexturevertex2;
    verts[3] = positionTexturevertex3;
    verts[4] = positionTexturevertex4;
    verts[5] = positionTexturevertex5;
    verts[6] = positionTexturevertex6;
    verts[7] = positionTexturevertex7;
    poly[0] = addPolygonReturn(new PositionTextureVertex[] { positionTexturevertex5, positionTexturevertex1, positionTexturevertex2, positionTexturevertex6 }, this.textureOffsetX + d + w, this.textureOffsetY + d, this.textureOffsetX + d + w + d, this.textureOffsetY + d + h, 1.0F, qParam[7], qParam[10] * qParam[7], qParam[10]);
    poly[1] = addPolygonReturn(new PositionTextureVertex[] { positionTexturevertex, positionTexturevertex4, positionTexturevertex7, positionTexturevertex3 }, this.textureOffsetX, this.textureOffsetY + d, this.textureOffsetX + d, this.textureOffsetY + d + h, qParam[9] * qParam[6], qParam[9], 1.0F, qParam[6]);
    poly[2] = addPolygonReturn(new PositionTextureVertex[] { positionTexturevertex5, positionTexturevertex4, positionTexturevertex, positionTexturevertex1 }, this.textureOffsetX + d, this.textureOffsetY, this.textureOffsetX + d + w, this.textureOffsetY + d, 1.0F, qParam[8], qParam[1] * qParam[8], qParam[1]);
    poly[3] = addPolygonReturn(new PositionTextureVertex[] { positionTexturevertex2, positionTexturevertex3, positionTexturevertex7, positionTexturevertex6 }, this.textureOffsetX + d + w, this.textureOffsetY, this.textureOffsetX + d + w + w, this.textureOffsetY + d, qParam[3], qParam[3] * qParam[11], qParam[11], 1.0F);
    poly[4] = addPolygonReturn(new PositionTextureVertex[] { positionTexturevertex1, positionTexturevertex, positionTexturevertex3, positionTexturevertex2 }, this.textureOffsetX + d, this.textureOffsetY + d, this.textureOffsetX + d + w, this.textureOffsetY + d + h, qParam[0], qParam[0] * qParam[4], qParam[4], 1.0F);
    poly[5] = addPolygonReturn(new PositionTextureVertex[] { positionTexturevertex4, positionTexturevertex5, positionTexturevertex6, positionTexturevertex7 }, this.textureOffsetX + d + w + d, this.textureOffsetY + d, this.textureOffsetX + d + w + d + w, this.textureOffsetY + d + h, qParam[2] * qParam[5], qParam[2], 1.0F, qParam[5]);
    if ((this.field_78809_i ^ this.flip) != 0)
      for (TexturedPolygon aPoly : poly)
        aPoly.flipFace();  
    copyTo(verts, poly);
  }
  
  public ModelRendererTurbo addBox(float x, float y, float z, int w, int h, int d) {
    func_78790_a(x, y, z, w, h, d, 0.0F);
    return this;
  }
  
  public void func_78790_a(float x, float y, float z, int w, int h, int d, float expansion) {
    addBox(x, y, z, w, h, d, expansion, 1.0F);
  }
  
  public void addBox(float x, float y, float z, int w, int h, int d, float expansion, float scale) {
    float scaleX = w * scale;
    float scaleY = h * scale;
    float scaleZ = d * scale;
    float x1 = x + scaleX;
    float y1 = y + scaleY;
    float z1 = z + scaleZ;
    float expX = expansion + scaleX - w;
    float expY = expansion + scaleY - h;
    float expZ = expansion + scaleZ - d;
    x -= expX;
    y -= expY;
    z -= expZ;
    x1 += expansion;
    y1 += expansion;
    z1 += expansion;
    if (this.field_78809_i) {
      float xTemp = x1;
      x1 = x;
      x = xTemp;
    } 
    float[] v = { x, y, z };
    float[] v1 = { x1, y, z };
    float[] v2 = { x1, y1, z };
    float[] v3 = { x, y1, z };
    float[] v4 = { x, y, z1 };
    float[] v5 = { x1, y, z1 };
    float[] v6 = { x1, y1, z1 };
    float[] v7 = { x, y1, z1 };
    addRectShape(v, v1, v2, v3, v4, v5, v6, v7, w, h, d);
  }
  
  public void addTrapezoid(float x, float y, float z, int w, int h, int d, float scale, float bottomScale, int dir) {
    float f4 = x + w;
    float f5 = y + h;
    float f6 = z + d;
    x -= scale;
    y -= scale;
    z -= scale;
    f4 += scale;
    f5 += scale;
    f6 += scale;
    int m = this.field_78809_i ? -1 : 1;
    if (this.field_78809_i) {
      float f7 = f4;
      f4 = x;
      x = f7;
    } 
    float[] v = { x, y, z };
    float[] v1 = { f4, y, z };
    float[] v2 = { f4, f5, z };
    float[] v3 = { x, f5, z };
    float[] v4 = { x, y, f6 };
    float[] v5 = { f4, y, f6 };
    float[] v6 = { f4, f5, f6 };
    float[] v7 = { x, f5, f6 };
    switch (dir) {
      case 3:
        v[1] = v[1] - bottomScale;
        v[2] = v[2] - bottomScale;
        v3[1] = v3[1] + bottomScale;
        v3[2] = v3[2] - bottomScale;
        v4[1] = v4[1] - bottomScale;
        v4[2] = v4[2] + bottomScale;
        v7[1] = v7[1] + bottomScale;
        v7[2] = v7[2] + bottomScale;
        break;
      case 2:
        v1[1] = v1[1] - bottomScale;
        v1[2] = v1[2] - bottomScale;
        v2[1] = v2[1] + bottomScale;
        v2[2] = v2[2] - bottomScale;
        v5[1] = v5[1] - bottomScale;
        v5[2] = v5[2] + bottomScale;
        v6[1] = v6[1] + bottomScale;
        v6[2] = v6[2] + bottomScale;
        break;
      case 0:
        v[0] = v[0] - m * bottomScale;
        v[1] = v[1] - bottomScale;
        v1[0] = v1[0] + m * bottomScale;
        v1[1] = v1[1] - bottomScale;
        v2[0] = v2[0] + m * bottomScale;
        v2[1] = v2[1] + bottomScale;
        v3[0] = v3[0] - m * bottomScale;
        v3[1] = v3[1] + bottomScale;
        break;
      case 1:
        v4[0] = v4[0] - m * bottomScale;
        v4[1] = v4[1] - bottomScale;
        v5[0] = v5[0] + m * bottomScale;
        v5[1] = v5[1] - bottomScale;
        v6[0] = v6[0] + m * bottomScale;
        v6[1] = v6[1] + bottomScale;
        v7[0] = v7[0] - m * bottomScale;
        v7[1] = v7[1] + bottomScale;
        break;
      case 4:
        v[0] = v[0] - m * bottomScale;
        v[2] = v[2] - bottomScale;
        v1[0] = v1[0] + m * bottomScale;
        v1[2] = v1[2] - bottomScale;
        v4[0] = v4[0] - m * bottomScale;
        v4[2] = v4[2] + bottomScale;
        v5[0] = v5[0] + m * bottomScale;
        v5[2] = v5[2] + bottomScale;
        break;
      case 5:
        v2[0] = v2[0] + m * bottomScale;
        v2[2] = v2[2] - bottomScale;
        v3[0] = v3[0] - m * bottomScale;
        v3[2] = v3[2] - bottomScale;
        v6[0] = v6[0] + m * bottomScale;
        v6[2] = v6[2] + bottomScale;
        v7[0] = v7[0] - m * bottomScale;
        v7[2] = v7[2] + bottomScale;
        break;
    } 
    float[] qValues = { 
        Math.abs((v[0] - v1[0]) / (v3[0] - v2[0])), Math.abs((v[0] - v1[0]) / (v4[0] - v5[0])), Math.abs((v4[0] - v5[0]) / (v7[0] - v6[0])), Math.abs((v3[0] - v2[0]) / (v7[0] - v6[0])), Math.abs((v[1] - v3[1]) / (v1[1] - v2[1])), Math.abs((v4[1] - v7[1]) / (v5[1] - v6[1])), Math.abs((v[1] - v3[1]) / (v4[1] - v7[1])), Math.abs((v1[1] - v2[1]) / (v5[1] - v6[1])), Math.abs((v[2] - v4[2]) / (v1[2] - v5[2])), Math.abs((v[2] - v4[2]) / (v3[2] - v7[2])), 
        Math.abs((v1[2] - v5[2]) / (v2[2] - v6[2])), Math.abs((v3[2] - v7[2]) / (v2[2] - v6[2])) };
    addRectShape(v, v1, v2, v3, v4, v5, v6, v7, w, h, d);
  }
  
  public void addFlexBox(float x, float y, float z, int w, int h, int d, float scale, float bScale1, float bScale2, float bScale3, float bScale4, int dir) {
    float f4 = x + w;
    float f5 = y + h;
    float f6 = z + d;
    x -= scale;
    y -= scale;
    z -= scale;
    f4 += scale;
    f5 += scale;
    f6 += scale;
    int m = this.field_78809_i ? -1 : 1;
    if (this.field_78809_i) {
      float f7 = f4;
      f4 = x;
      x = f7;
    } 
    float[] v = { x, y, z };
    float[] v1 = { f4, y, z };
    float[] v2 = { f4, f5, z };
    float[] v3 = { x, f5, z };
    float[] v4 = { x, y, f6 };
    float[] v5 = { f4, y, f6 };
    float[] v6 = { f4, f5, f6 };
    float[] v7 = { x, f5, f6 };
    switch (dir) {
      case 3:
        v[1] = v[1] - bScale1;
        v[2] = v[2] - bScale3;
        v3[1] = v3[1] + bScale2;
        v3[2] = v3[2] - bScale3;
        v4[1] = v4[1] - bScale1;
        v4[2] = v4[2] + bScale4;
        v7[1] = v7[1] + bScale2;
        v7[2] = v7[2] + bScale4;
        break;
      case 2:
        v1[1] = v1[1] - bScale1;
        v1[2] = v1[2] - bScale3;
        v2[1] = v2[1] + bScale2;
        v2[2] = v2[2] - bScale3;
        v5[1] = v5[1] - bScale1;
        v5[2] = v5[2] + bScale4;
        v6[1] = v6[1] + bScale2;
        v6[2] = v6[2] + bScale4;
        break;
      case 0:
        v[0] = v[0] - m * bScale4;
        v[1] = v[1] - bScale1;
        v1[0] = v1[0] + m * bScale3;
        v1[1] = v1[1] - bScale1;
        v2[0] = v2[0] + m * bScale3;
        v2[1] = v2[1] + bScale2;
        v3[0] = v3[0] - m * bScale4;
        v3[1] = v3[1] + bScale2;
        break;
      case 1:
        v4[0] = v4[0] - m * bScale4;
        v4[1] = v4[1] - bScale1;
        v5[0] = v5[0] + m * bScale3;
        v5[1] = v5[1] - bScale1;
        v6[0] = v6[0] + m * bScale3;
        v6[1] = v6[1] + bScale2;
        v7[0] = v7[0] - m * bScale4;
        v7[1] = v7[1] + bScale2;
        break;
      case 4:
        v[0] = v[0] - m * bScale1;
        v[2] = v[2] - bScale3;
        v1[0] = v1[0] + m * bScale2;
        v1[2] = v1[2] - bScale3;
        v4[0] = v4[0] - m * bScale1;
        v4[2] = v4[2] + bScale4;
        v5[0] = v5[0] + m * bScale2;
        v5[2] = v5[2] + bScale4;
        break;
      case 5:
        v2[0] = v2[0] + m * bScale2;
        v2[2] = v2[2] - bScale3;
        v3[0] = v3[0] - m * bScale1;
        v3[2] = v3[2] - bScale3;
        v6[0] = v6[0] + m * bScale2;
        v6[2] = v6[2] + bScale4;
        v7[0] = v7[0] - m * bScale1;
        v7[2] = v7[2] + bScale4;
        break;
    } 
    float[] qValues = { 
        Math.abs((v[0] - v1[0]) / (v3[0] - v2[0])), Math.abs((v[0] - v1[0]) / (v4[0] - v5[0])), Math.abs((v4[0] - v5[0]) / (v7[0] - v6[0])), Math.abs((v3[0] - v2[0]) / (v7[0] - v6[0])), Math.abs((v[1] - v3[1]) / (v1[1] - v2[1])), Math.abs((v4[1] - v7[1]) / (v5[1] - v6[1])), Math.abs((v[1] - v3[1]) / (v4[1] - v7[1])), Math.abs((v1[1] - v2[1]) / (v5[1] - v6[1])), Math.abs((v[2] - v4[2]) / (v1[2] - v5[2])), Math.abs((v[2] - v4[2]) / (v3[2] - v7[2])), 
        Math.abs((v1[2] - v5[2]) / (v2[2] - v6[2])), Math.abs((v3[2] - v7[2]) / (v2[2] - v6[2])) };
    addRectShape(v, v1, v2, v3, v4, v5, v6, v7, w, h, d);
  }
  
  public void addFlexTrapezoid(float x, float y, float z, int w, int h, int d, float scale, float bScale1, float bScale2, float bScale3, float bScale4, float fScale1, float fScale2, int dir) {
    float f4 = x + w;
    float f5 = y + h;
    float f6 = z + d;
    x -= scale;
    y -= scale;
    z -= scale;
    f4 += scale;
    f5 += scale;
    f6 += scale;
    int m = this.field_78809_i ? -1 : 1;
    if (this.field_78809_i) {
      float f7 = f4;
      f4 = x;
      x = f7;
    } 
    float[] v = { x, y, z };
    float[] v1 = { f4, y, z };
    float[] v2 = { f4, f5, z };
    float[] v3 = { x, f5, z };
    float[] v4 = { x, y, f6 };
    float[] v5 = { f4, y, f6 };
    float[] v6 = { f4, f5, f6 };
    float[] v7 = { x, f5, f6 };
    switch (dir) {
      case 3:
        v[2] = v[2] - fScale1;
        v1[2] = v1[2] - fScale1;
        v4[2] = v4[2] + fScale2;
        v5[2] = v5[2] + fScale2;
        v[1] = v[1] - bScale1;
        v[2] = v[2] - bScale3;
        v3[1] = v3[1] + bScale2;
        v3[2] = v3[2] - bScale3;
        v4[1] = v4[1] - bScale1;
        v4[2] = v4[2] + bScale4;
        v7[1] = v7[1] + bScale2;
        v7[2] = v7[2] + bScale4;
        break;
      case 2:
        v[2] = v[2] - fScale1;
        v1[2] = v1[2] - fScale1;
        v4[2] = v4[2] + fScale2;
        v5[2] = v5[2] + fScale2;
        v1[1] = v1[1] - bScale1;
        v1[2] = v1[2] - bScale3;
        v2[1] = v2[1] + bScale2;
        v2[2] = v2[2] - bScale3;
        v5[1] = v5[1] - bScale1;
        v5[2] = v5[2] + bScale4;
        v6[1] = v6[1] + bScale2;
        v6[2] = v6[2] + bScale4;
        break;
      case 0:
        v1[1] = v1[1] - fScale1;
        v5[1] = v5[1] - fScale1;
        v2[1] = v2[1] + fScale2;
        v6[1] = v6[1] + fScale2;
        v[0] = v[0] - m * bScale4;
        v[1] = v[1] - bScale1;
        v1[0] = v1[0] + m * bScale3;
        v1[1] = v1[1] - bScale1;
        v2[0] = v2[0] + m * bScale3;
        v2[1] = v2[1] + bScale2;
        v3[0] = v3[0] - m * bScale4;
        v3[1] = v3[1] + bScale2;
        break;
      case 1:
        v1[1] = v1[1] - fScale1;
        v5[1] = v5[1] - fScale1;
        v2[1] = v2[1] + fScale2;
        v6[1] = v6[1] + fScale2;
        v4[0] = v4[0] - m * bScale4;
        v4[1] = v4[1] - bScale1;
        v5[0] = v5[0] + m * bScale3;
        v5[1] = v5[1] - bScale1;
        v6[0] = v6[0] + m * bScale3;
        v6[1] = v6[1] + bScale2;
        v7[0] = v7[0] - m * bScale4;
        v7[1] = v7[1] + bScale2;
        break;
      case 4:
        v1[2] = v1[2] - fScale1;
        v2[2] = v2[2] - fScale1;
        v5[2] = v5[2] + fScale2;
        v6[2] = v6[2] + fScale2;
        v[0] = v[0] - m * bScale1;
        v[2] = v[2] - bScale3;
        v1[0] = v1[0] + m * bScale2;
        v1[2] = v1[2] - bScale3;
        v4[0] = v4[0] - m * bScale1;
        v4[2] = v4[2] + bScale4;
        v5[0] = v5[0] + m * bScale2;
        v5[2] = v5[2] + bScale4;
        break;
      case 5:
        v1[2] = v1[2] - fScale1;
        v2[2] = v2[2] - fScale1;
        v5[2] = v5[2] + fScale2;
        v6[2] = v6[2] + fScale2;
        v2[0] = v2[0] + m * bScale2;
        v2[2] = v2[2] - bScale3;
        v3[0] = v3[0] - m * bScale1;
        v3[2] = v3[2] - bScale3;
        v6[0] = v6[0] + m * bScale2;
        v6[2] = v6[2] + bScale4;
        v7[0] = v7[0] - m * bScale1;
        v7[2] = v7[2] + bScale4;
        break;
    } 
    float[] qValues = { 
        Math.abs((v[0] - v1[0]) / (v3[0] - v2[0])), Math.abs((v[0] - v1[0]) / (v4[0] - v5[0])), Math.abs((v4[0] - v5[0]) / (v7[0] - v6[0])), Math.abs((v3[0] - v2[0]) / (v7[0] - v6[0])), Math.abs((v[1] - v3[1]) / (v1[1] - v2[1])), Math.abs((v4[1] - v7[1]) / (v5[1] - v6[1])), Math.abs((v[1] - v3[1]) / (v4[1] - v7[1])), Math.abs((v1[1] - v2[1]) / (v5[1] - v6[1])), Math.abs((v[2] - v4[2]) / (v1[2] - v5[2])), Math.abs((v[2] - v4[2]) / (v3[2] - v7[2])), 
        Math.abs((v1[2] - v5[2]) / (v2[2] - v6[2])), Math.abs((v3[2] - v7[2]) / (v2[2] - v6[2])) };
    addRectShape(v, v1, v2, v3, v4, v5, v6, v7, w, h, d);
  }
  
  public void addBox(float x, float y, float z, float w, float h, float d) {
    int rw = MathHelper.func_76123_f(w);
    int rh = MathHelper.func_76123_f(h);
    int rd = MathHelper.func_76123_f(d);
    w -= rw;
    h -= rh;
    d -= rd;
    addShapeBox(x, y, z, rw, rh, rd, 0.0F, 0.0F, 0.0F, 0.0F, w, 0.0F, 0.0F, w, 0.0F, d, 0.0F, 0.0F, d, 0.0F, h, 0.0F, w, h, 0.0F, w, h, d, 0.0F, h, d);
  }
  
  public void addShapeBox(float x, float y, float z, int w, int h, int d, float scale, float x0, float y0, float z0, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4, float x5, float y5, float z5, float x6, float y6, float z6, float x7, float y7, float z7) {
    float f4 = x + w;
    float f5 = y + h;
    float f6 = z + d;
    x -= scale;
    y -= scale;
    z -= scale;
    f4 += scale;
    f5 += scale;
    f6 += scale;
    int m = this.field_78809_i ? -1 : 1;
    if (this.field_78809_i) {
      float f7 = f4;
      f4 = x;
      x = f7;
    } 
    float[] v = { x - x0, y - y0, z - z0 };
    float[] v1 = { f4 + x1, y - y1, z - z1 };
    float[] v2 = { f4 + x5, f5 + y5, z - z5 };
    float[] v3 = { x - x4, f5 + y4, z - z4 };
    float[] v4 = { x - x3, y - y3, f6 + z3 };
    float[] v5 = { f4 + x2, y - y2, f6 + z2 };
    float[] v6 = { f4 + x6, f5 + y6, f6 + z6 };
    float[] v7 = { x - x7, f5 + y7, f6 + z7 };
    float[] qValues = { 
        Math.abs((v[0] - v1[0]) / (v3[0] - v2[0])), Math.abs((v[0] - v1[0]) / (v4[0] - v5[0])), Math.abs((v4[0] - v5[0]) / (v7[0] - v6[0])), Math.abs((v3[0] - v2[0]) / (v7[0] - v6[0])), Math.abs((v[1] - v3[1]) / (v1[1] - v2[1])), Math.abs((v4[1] - v7[1]) / (v5[1] - v6[1])), Math.abs((v[1] - v3[1]) / (v4[1] - v7[1])), Math.abs((v1[1] - v2[1]) / (v5[1] - v6[1])), Math.abs((v[2] - v4[2]) / (v1[2] - v5[2])), Math.abs((v[2] - v4[2]) / (v3[2] - v7[2])), 
        Math.abs((v1[2] - v5[2]) / (v2[2] - v6[2])), Math.abs((v3[2] - v7[2]) / (v2[2] - v6[2])) };
    addRectShape(v, v1, v2, v3, v4, v5, v6, v7, w, h, d);
  }
  
  public void addShape3D(float x, float y, float z, Coord2D[] coordinates, float depth, int shapeTextureWidth, int shapeTextureHeight, int sideTextureWidth, int sideTextureHeight, int direction) {
    addShape3D(x, y, z, coordinates, depth, shapeTextureWidth, shapeTextureHeight, sideTextureWidth, sideTextureHeight, direction, (float[])null);
  }
  
  public void addShape3D(float x, float y, float z, Coord2D[] coordinates, float depth, int shapeTextureWidth, int shapeTextureHeight, int sideTextureWidth, int sideTextureHeight, int direction, float[] faceLengths) {
    addShape3D(x, y, z, new Shape2D(coordinates), depth, shapeTextureWidth, shapeTextureHeight, sideTextureWidth, sideTextureHeight, direction, faceLengths);
  }
  
  public void addShape3D(float x, float y, float z, ArrayList<Coord2D> coordinates, float depth, int shapeTextureWidth, int shapeTextureHeight, int sideTextureWidth, int sideTextureHeight, int direction) {
    addShape3D(x, y, z, coordinates, depth, shapeTextureWidth, shapeTextureHeight, sideTextureWidth, sideTextureHeight, direction, (float[])null);
  }
  
  public void addShape3D(float x, float y, float z, ArrayList<Coord2D> coordinates, float depth, int shapeTextureWidth, int shapeTextureHeight, int sideTextureWidth, int sideTextureHeight, int direction, float[] faceLengths) {
    addShape3D(x, y, z, new Shape2D(coordinates), depth, shapeTextureWidth, shapeTextureHeight, sideTextureWidth, sideTextureHeight, direction, faceLengths);
  }
  
  public void addShape3D(float x, float y, float z, Shape2D shape, float depth, int shapeTextureWidth, int shapeTextureHeight, int sideTextureWidth, int sideTextureHeight, int direction) {
    addShape3D(x, y, z, shape, depth, shapeTextureWidth, shapeTextureHeight, sideTextureWidth, sideTextureHeight, direction, (float[])null);
  }
  
  public void addShape3D(float x, float y, float z, Shape2D shape, float depth, int shapeTextureWidth, int shapeTextureHeight, int sideTextureWidth, int sideTextureHeight, int direction, float[] faceLengths) {
    float rotX = 0.0F;
    float rotY = 0.0F;
    float rotZ = 0.0F;
    switch (direction) {
      case 2:
        rotY = 1.5707964F;
        break;
      case 3:
        rotY = -1.5707964F;
        break;
      case 4:
        rotX = 1.5707964F;
        break;
      case 5:
        rotX = -1.5707964F;
        break;
      case 0:
        rotY = 3.1415927F;
        break;
    } 
    addShape3D(x, y, z, shape, depth, shapeTextureWidth, shapeTextureHeight, sideTextureWidth, sideTextureHeight, rotX, rotY, rotZ, faceLengths);
  }
  
  public void addShape3D(float x, float y, float z, Shape2D shape, float depth, int shapeTextureWidth, int shapeTextureHeight, int sideTextureWidth, int sideTextureHeight, float rotX, float rotY, float rotZ) {
    addShape3D(x, y, z, shape, depth, shapeTextureWidth, shapeTextureHeight, sideTextureWidth, sideTextureHeight, rotX, rotY, rotZ, (float[])null);
  }
  
  public void addShape3D(float x, float y, float z, Shape2D shape, float depth, int shapeTextureWidth, int shapeTextureHeight, int sideTextureWidth, int sideTextureHeight, float rotX, float rotY, float rotZ, float[] faceLengths) {
    Shape3D shape3D = shape.extrude(x, y, z, rotX, rotY, rotZ, depth, this.textureOffsetX, this.textureOffsetY, this.field_78801_a, this.field_78799_b, shapeTextureWidth, shapeTextureHeight, sideTextureWidth, sideTextureHeight, faceLengths);
    if (this.flip)
      for (int idx = 0; idx < shape3D.faces.length; idx++)
        shape3D.faces[idx].flipFace();  
    copyTo((PositionTextureVertex[])shape3D.vertices, shape3D.faces);
  }
  
  public void addPixel(float x, float y, float z, float width, float height, float length) {
    addPixel(x, y, z, new float[] { width, height, length }, this.textureOffsetX, this.textureOffsetY);
  }
  
  public void addPixel(float x, float y, float z, float[] scale, int w, int h) {
    PositionTextureVertex[] verts = new PositionTextureVertex[8];
    TexturedPolygon[] poly = new TexturedPolygon[6];
    float x1 = x + scale[0];
    float y1 = y + scale[1];
    float z1 = z + scale[2];
    float[] f = { x, y, z };
    float[] f1 = { x1, y, z };
    float[] f2 = { x1, y1, z };
    float[] f3 = { x, y1, z };
    float[] f4 = { x, y, z1 };
    float[] f5 = { x1, y, z1 };
    float[] f6 = { x1, y1, z1 };
    float[] f7 = { x, y1, z1 };
    PositionTextureVertex positionTexturevertex = new PositionTextureVertex(f[0], f[1], f[2], 0.0F, 0.0F);
    PositionTextureVertex positionTexturevertex1 = new PositionTextureVertex(f1[0], f1[1], f1[2], 0.0F, 8.0F);
    PositionTextureVertex positionTexturevertex2 = new PositionTextureVertex(f2[0], f2[1], f2[2], 8.0F, 8.0F);
    PositionTextureVertex positionTexturevertex3 = new PositionTextureVertex(f3[0], f3[1], f3[2], 8.0F, 0.0F);
    PositionTextureVertex positionTexturevertex4 = new PositionTextureVertex(f4[0], f4[1], f4[2], 0.0F, 0.0F);
    PositionTextureVertex positionTexturevertex5 = new PositionTextureVertex(f5[0], f5[1], f5[2], 0.0F, 8.0F);
    PositionTextureVertex positionTexturevertex6 = new PositionTextureVertex(f6[0], f6[1], f6[2], 8.0F, 8.0F);
    PositionTextureVertex positionTexturevertex7 = new PositionTextureVertex(f7[0], f7[1], f7[2], 8.0F, 0.0F);
    verts[0] = positionTexturevertex;
    verts[1] = positionTexturevertex1;
    verts[2] = positionTexturevertex2;
    verts[3] = positionTexturevertex3;
    verts[4] = positionTexturevertex4;
    verts[5] = positionTexturevertex5;
    verts[6] = positionTexturevertex6;
    verts[7] = positionTexturevertex7;
    poly[0] = addPolygonReturn(new PositionTextureVertex[] { positionTexturevertex5, positionTexturevertex1, positionTexturevertex2, positionTexturevertex6 }, w, h, w + 1, h + 1);
    poly[1] = addPolygonReturn(new PositionTextureVertex[] { positionTexturevertex, positionTexturevertex4, positionTexturevertex7, positionTexturevertex3 }, w, h, w + 1, h + 1);
    poly[2] = addPolygonReturn(new PositionTextureVertex[] { positionTexturevertex5, positionTexturevertex4, positionTexturevertex, positionTexturevertex1 }, w, h, w + 1, h + 1);
    poly[3] = addPolygonReturn(new PositionTextureVertex[] { positionTexturevertex2, positionTexturevertex3, positionTexturevertex7, positionTexturevertex6 }, w, h, w + 1, h + 1);
    poly[4] = addPolygonReturn(new PositionTextureVertex[] { positionTexturevertex1, positionTexturevertex, positionTexturevertex3, positionTexturevertex2 }, w, h, w + 1, h + 1);
    poly[5] = addPolygonReturn(new PositionTextureVertex[] { positionTexturevertex4, positionTexturevertex5, positionTexturevertex6, positionTexturevertex7 }, w, h, w + 1, h + 1);
    copyTo(verts, poly);
  }
  
  public void addSprite(float x, float y, float z, int w, int h, float expansion) {
    addSprite(x, y, z, w, h, 1, false, false, false, false, false, expansion);
  }
  
  public void addSprite(float x, float y, float z, int w, int h, boolean rotX, boolean rotY, boolean rotZ, boolean mirrorX, boolean mirrorY, float expansion) {
    addSprite(x, y, z, w, h, 1, rotX, rotY, rotZ, mirrorX, mirrorY, expansion);
  }
  
  public void addSprite(float x, float y, float z, int w, int h, int d, boolean rotX, boolean rotY, boolean rotZ, boolean mirrorX, boolean mirrorY, float expansion) {
    addSprite(x, y, z, w, h, d, 1.0F, rotX, rotY, rotZ, mirrorX, mirrorY, expansion);
  }
  
  public void addSprite(float x, float y, float z, int w, int h, int d, float pixelScale, boolean rotX, boolean rotY, boolean rotZ, boolean mirrorX, boolean mirrorY, float expansion) {
    String[] mask = new String[h];
    char[] str = new char[w];
    Arrays.fill(str, '1');
    Arrays.fill((Object[])mask, new String(str));
    addSprite(x, y, z, mask, d, pixelScale, rotX, rotY, rotZ, mirrorX, mirrorY, expansion);
  }
  
  public void addSprite(float x, float y, float z, String[] mask, int d, float pixelScale, boolean rotX, boolean rotY, boolean rotZ, boolean mirrorX, boolean mirrorY, float expansion) {
    int w = mask[0].length();
    int h = mask.length;
    float x1 = x - expansion;
    float y1 = y - expansion;
    float z1 = z - expansion;
    int wDir = 0;
    int hDir = 0;
    int dDir = 0;
    float wScale = 1.0F + expansion / w * pixelScale;
    float hScale = 1.0F + expansion / h * pixelScale;
    if (!rotX) {
      if (!rotY) {
        if (!rotZ) {
          wDir = 0;
          hDir = 1;
          dDir = 2;
        } else {
          wDir = 1;
          hDir = 0;
          dDir = 2;
        } 
      } else if (!rotZ) {
        wDir = 2;
        hDir = 1;
        dDir = 0;
      } else {
        wDir = 2;
        hDir = 0;
        dDir = 1;
      } 
    } else if (!rotY) {
      if (!rotZ) {
        wDir = 0;
        hDir = 2;
        dDir = 1;
      } else {
        wDir = 1;
        hDir = 2;
        dDir = 0;
      } 
    } else if (!rotZ) {
      wDir = 2;
      hDir = 0;
      dDir = 1;
    } else {
      wDir = 2;
      hDir = 1;
      dDir = 0;
    } 
    int texStartX = this.textureOffsetX + (mirrorX ? (w - 1) : 0);
    int texStartY = this.textureOffsetY + (mirrorY ? (h - 1) : 0);
    int texDirX = mirrorX ? -1 : 1;
    int texDirY = mirrorY ? -1 : 1;
    float wVoxSize = getPixelSize(wScale, hScale, d * pixelScale + expansion * 2.0F, 0, 1, wDir, 1, 1);
    float hVoxSize = getPixelSize(wScale, hScale, d * pixelScale + expansion * 2.0F, 0, 1, hDir, 1, 1);
    float dVoxSize = getPixelSize(wScale, hScale, d * pixelScale + expansion * 2.0F, 0, 1, dDir, 1, 1);
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < h; j++) {
        if (mask[j].charAt(i) == '1')
          addPixel(x1 + getPixelSize(wScale, hScale, 0.0F, wDir, hDir, 0, i, j), y1 + 
              getPixelSize(wScale, hScale, 0.0F, wDir, hDir, 1, i, j), z1 + 
              getPixelSize(wScale, hScale, 0.0F, wDir, hDir, 2, i, j), new float[] { wVoxSize, hVoxSize, dVoxSize }, texStartX + texDirX * i, texStartY + texDirY * j); 
      } 
    } 
  }
  
  private float getPixelSize(float wScale, float hScale, float dScale, int wDir, int hDir, int checkDir, int texPosX, int texPosY) {
    return (wDir == checkDir) ? (wScale * texPosX) : ((hDir == checkDir) ? (hScale * texPosY) : dScale);
  }
  
  public void addSphere(float x, float y, float z, float r, int segs, int rings, int textureW, int textureH) {
    if (segs < 3)
      segs = 3; 
    rings++;
    PositionTextureVertex[] tempVerts = new PositionTextureVertex[segs * (rings - 1) + 2];
    TexturedPolygon[] poly = new TexturedPolygon[segs * rings];
    tempVerts[0] = new PositionTextureVertex(x, y - r, z, 0.0F, 0.0F);
    tempVerts[tempVerts.length - 1] = new PositionTextureVertex(x, y + r, z, 0.0F, 0.0F);
    float uOffs = 1.0F / this.field_78801_a * 10.0F;
    float vOffs = 1.0F / this.field_78799_b * 10.0F;
    float texW = textureW / this.field_78801_a - 2.0F * uOffs;
    float texH = textureH / this.field_78799_b - 2.0F * vOffs;
    float segW = texW / segs;
    float segH = texH / rings;
    float startU = this.textureOffsetX / this.field_78801_a;
    float startV = this.textureOffsetY / this.field_78799_b;
    int currentFace = 0;
    for (int j = 1; j < rings; j++) {
      PositionTextureVertex[] verts;
      for (int k = 0; k < segs; k++) {
        float yWidth = MathHelper.func_76134_b(-1.5707964F + 3.1415927F / rings * j);
        float yHeight = MathHelper.func_76126_a(-1.5707964F + 3.1415927F / rings * j);
        float xSize = MathHelper.func_76126_a(3.1415927F / segs * k * 2.0F + 3.1415927F) * yWidth;
        float zSize = -MathHelper.func_76134_b(3.1415927F / segs * k * 2.0F + 3.1415927F) * yWidth;
        int curVert = 1 + k + segs * (j - 1);
        tempVerts[curVert] = new PositionTextureVertex(x + xSize * r, y + yHeight * r, z + zSize * r, 0.0F, 0.0F);
        if (k > 0) {
          PositionTextureVertex[] arrayOfPositionTextureVertex;
          if (j == 1) {
            arrayOfPositionTextureVertex = new PositionTextureVertex[4];
            arrayOfPositionTextureVertex[0] = tempVerts[curVert].setTexturePosition(startU + segW * k, startV + segH * j);
            arrayOfPositionTextureVertex[1] = tempVerts[curVert - 1].setTexturePosition(startU + segW * (k - 1), startV + segH * j);
            arrayOfPositionTextureVertex[2] = tempVerts[0].setTexturePosition(startU + segW * (k - 1), startV);
            arrayOfPositionTextureVertex[3] = tempVerts[0].setTexturePosition(startU + segW + segW * k, startV);
          } else {
            arrayOfPositionTextureVertex = new PositionTextureVertex[4];
            arrayOfPositionTextureVertex[0] = tempVerts[curVert].setTexturePosition(startU + segW * k, startV + segH * j);
            arrayOfPositionTextureVertex[1] = tempVerts[curVert - 1].setTexturePosition(startU + segW * (k - 1), startV + segH * j);
            arrayOfPositionTextureVertex[2] = tempVerts[curVert - 1 - segs].setTexturePosition(startU + segW * (k - 1), startV + segH * (j - 1));
            arrayOfPositionTextureVertex[3] = tempVerts[curVert - segs].setTexturePosition(startU + segW * k, startV + segH * (j - 1));
          } 
          poly[currentFace] = new TexturedPolygon(arrayOfPositionTextureVertex);
          currentFace++;
        } 
      } 
      if (j == 1) {
        verts = new PositionTextureVertex[4];
        verts[0] = tempVerts[1].setTexturePosition(startU + segW * segs, startV + segH * j);
        verts[1] = tempVerts[segs].setTexturePosition(startU + segW * (segs - 1), startV + segH * j);
        verts[2] = tempVerts[0].setTexturePosition(startU + segW * (segs - 1), startV);
        verts[3] = tempVerts[0].setTexturePosition(startU + segW * segs, startV);
      } else {
        verts = new PositionTextureVertex[4];
        verts[0] = tempVerts[1 + segs * (j - 1)].setTexturePosition(startU + texW, startV + segH * j);
        verts[1] = tempVerts[segs * (j - 1) + segs].setTexturePosition(startU + texW - segW, startV + segH * j);
        verts[2] = tempVerts[segs * (j - 1)].setTexturePosition(startU + texW - segW, startV + segH * (j - 1));
        verts[3] = tempVerts[1 + segs * (j - 1) - segs].setTexturePosition(startU + texW, startV + segH * (j - 1));
      } 
      poly[currentFace] = new TexturedPolygon(verts);
      currentFace++;
    } 
    for (int i = 0; i < segs; i++) {
      PositionTextureVertex[] verts = new PositionTextureVertex[3];
      int curVert = tempVerts.length - segs + 1;
      verts[0] = tempVerts[tempVerts.length - 1].setTexturePosition(startU + segW * (i + 0.5F), startV + texH);
      verts[1] = tempVerts[curVert + i].setTexturePosition(startU + segW * i, startV + texH - segH);
      verts[2] = tempVerts[curVert + (i + 1) % segs].setTexturePosition(startU + segW * (i + 1), startV + texH - segH);
      poly[currentFace] = new TexturedPolygon(verts);
      currentFace++;
    } 
    copyTo(tempVerts, poly);
  }
  
  public void addCone(float x, float y, float z, float radius, float length, int segments) {
    addCone(x, y, z, radius, length, segments, 1.0F);
  }
  
  public void addCone(float x, float y, float z, float radius, float length, int segments, float baseScale) {
    addCone(x, y, z, radius, length, segments, baseScale, 4);
  }
  
  public void addCone(float x, float y, float z, float radius, float length, int segments, float baseScale, int baseDirection) {
    addCone(x, y, z, radius, length, segments, baseScale, baseDirection, (int)Math.floor((radius * 2.0F)), (int)Math.floor((radius * 2.0F)));
  }
  
  public void addCone(float x, float y, float z, float radius, float length, int segments, float baseScale, int baseDirection, int textureCircleDiameterW, int textureCircleDiameterH) {
    addCylinder(x, y, z, radius, length, segments, baseScale, 0.0F, baseDirection, textureCircleDiameterW, textureCircleDiameterH, 1);
  }
  
  public void addCylinder(float x, float y, float z, float radius, float length, int segments) {
    addCylinder(x, y, z, radius, length, segments, 1.0F, 1.0F);
  }
  
  public void addCylinder(float x, float y, float z, float radius, float length, int segments, float baseScale, float topScale) {
    addCylinder(x, y, z, radius, length, segments, baseScale, topScale, 4);
  }
  
  public void addCylinder(float x, float y, float z, float radius, float length, int segments, float baseScale, float topScale, int baseDirection) {
    addCylinder(x, y, z, radius, length, segments, baseScale, topScale, baseDirection, (int)Math.floor((radius * 2.0F)), (int)Math.floor((radius * 2.0F)), (int)Math.floor(length));
  }
  
  public void addCylinder(float x, float y, float z, float radius, float length, int segments, float baseScale, float topScale, int baseDirection, int textureCircleDiameterW, int textureCircleDiameterH, int textureH) {
    boolean dirTop = (baseDirection == 4 || baseDirection == 5);
    boolean dirSide = (baseDirection == 3 || baseDirection == 2);
    boolean dirFront = (baseDirection == 0 || baseDirection == 1);
    boolean dirMirror = (baseDirection == 2 || baseDirection == 5 || baseDirection == 1);
    boolean coneBase = (baseScale == 0.0F);
    boolean coneTop = (topScale == 0.0F);
    if (coneBase && coneTop) {
      baseScale = 1.0F;
      coneBase = false;
    } 
    PositionTextureVertex[] tempVerts = new PositionTextureVertex[segments * ((coneBase || coneTop) ? 1 : 2) + 2];
    TexturedPolygon[] poly = new TexturedPolygon[segments * ((coneBase || coneTop) ? 2 : 3)];
    float xLength = dirSide ? length : 0.0F;
    float yLength = dirTop ? length : 0.0F;
    float zLength = dirFront ? length : 0.0F;
    float xStart = dirMirror ? (x + xLength) : x;
    float yStart = dirMirror ? (y + yLength) : y;
    float zStart = dirMirror ? (z + zLength) : z;
    float xEnd = !dirMirror ? (x + xLength) : x;
    float yEnd = !dirMirror ? (y + yLength) : y;
    float zEnd = !dirMirror ? (z + zLength) : z;
    tempVerts[0] = new PositionTextureVertex(xStart, yStart, zStart, 0.0F, 0.0F);
    tempVerts[tempVerts.length - 1] = new PositionTextureVertex(xEnd, yEnd, zEnd, 0.0F, 0.0F);
    float xCur = xStart;
    float yCur = yStart;
    float zCur = zStart;
    float sCur = coneBase ? topScale : baseScale;
    for (int repeat = 0; repeat < ((coneBase || coneTop) ? 1 : 2); repeat++) {
      for (int i = 0; i < segments; i++) {
        float xSize = ((this.field_78809_i ^ dirMirror) ? -1 : true) * MathHelper.func_76126_a(3.1415927F / segments * i * 2.0F + 3.1415927F) * radius * sCur;
        float zSize = -MathHelper.func_76134_b(3.1415927F / segments * i * 2.0F + 3.1415927F) * radius * sCur;
        float xPlace = xCur + (!dirSide ? xSize : 0.0F);
        float yPlace = yCur + (!dirTop ? zSize : 0.0F);
        float zPlace = zCur + (dirSide ? xSize : (dirTop ? zSize : 0.0F));
        tempVerts[1 + i + repeat * segments] = new PositionTextureVertex(xPlace, yPlace, zPlace, 0.0F, 0.0F);
      } 
      xCur = xEnd;
      yCur = yEnd;
      zCur = zEnd;
      sCur = topScale;
    } 
    float uScale = 1.0F / this.field_78801_a;
    float vScale = 1.0F / this.field_78799_b;
    float uOffset = uScale / 20.0F;
    float vOffset = vScale / 20.0F;
    float uCircle = textureCircleDiameterW * uScale;
    float vCircle = textureCircleDiameterH * vScale;
    float uWidth = (uCircle * 2.0F - uOffset * 2.0F) / segments;
    float vHeight = textureH * vScale - uOffset * 2.0F;
    float uStart = this.textureOffsetX * uScale;
    float vStart = this.textureOffsetY * vScale;
    for (int index = 0; index < segments; index++) {
      int index2 = (index + 1) % segments;
      float uSize = MathHelper.func_76126_a(3.1415927F / segments * index * 2.0F + (!dirTop ? 0.0F : 3.1415927F)) * (0.5F * uCircle - 2.0F * uOffset);
      float vSize = MathHelper.func_76134_b(3.1415927F / segments * index * 2.0F + (!dirTop ? 0.0F : 3.1415927F)) * (0.5F * vCircle - 2.0F * vOffset);
      float uSize1 = MathHelper.func_76126_a(3.1415927F / segments * index2 * 2.0F + (!dirTop ? 0.0F : 3.1415927F)) * (0.5F * uCircle - 2.0F * uOffset);
      float vSize1 = MathHelper.func_76134_b(3.1415927F / segments * index2 * 2.0F + (!dirTop ? 0.0F : 3.1415927F)) * (0.5F * vCircle - 2.0F * vOffset);
      PositionTextureVertex[] vert = new PositionTextureVertex[3];
      vert[0] = tempVerts[0].setTexturePosition(uStart + 0.5F * uCircle, vStart + 0.5F * vCircle);
      vert[1] = tempVerts[1 + index2].setTexturePosition(uStart + 0.5F * uCircle + uSize1, vStart + 0.5F * vCircle + vSize1);
      vert[2] = tempVerts[1 + index].setTexturePosition(uStart + 0.5F * uCircle + uSize, vStart + 0.5F * vCircle + vSize);
      poly[index] = new TexturedPolygon(vert);
      if ((this.field_78809_i ^ this.flip) != 0)
        poly[index].flipFace(); 
      if (!coneBase && !coneTop) {
        vert = new PositionTextureVertex[4];
        vert[0] = tempVerts[1 + index].setTexturePosition(uStart + uOffset + uWidth * index, vStart + vOffset + vCircle);
        vert[1] = tempVerts[1 + index2].setTexturePosition(uStart + uOffset + uWidth * (index + 1), vStart + vOffset + vCircle);
        vert[2] = tempVerts[1 + segments + index2].setTexturePosition(uStart + uOffset + uWidth * (index + 1), vStart + vOffset + vCircle + vHeight);
        vert[3] = tempVerts[1 + segments + index].setTexturePosition(uStart + uOffset + uWidth * index, vStart + vOffset + vCircle + vHeight);
        poly[index + segments] = new TexturedPolygon(vert);
        if ((this.field_78809_i ^ this.flip) != 0)
          poly[index + segments].flipFace(); 
      } 
      vert = new PositionTextureVertex[3];
      vert[0] = tempVerts[tempVerts.length - 1].setTexturePosition(uStart + 1.5F * uCircle, vStart + 0.5F * vCircle);
      vert[1] = tempVerts[tempVerts.length - 2 - index].setTexturePosition(uStart + 1.5F * uCircle + uSize1, vStart + 0.5F * vCircle + vSize1);
      vert[2] = tempVerts[tempVerts.length - 1 + segments + (segments - index) % segments].setTexturePosition(uStart + 1.5F * uCircle + uSize, vStart + 0.5F * vCircle + vSize);
      poly[poly.length - segments + index] = new TexturedPolygon(vert);
      if ((this.field_78809_i ^ this.flip) != 0)
        poly[poly.length - segments + index].flipFace(); 
    } 
    copyTo(tempVerts, poly);
  }
  
  public void addObj(String file) {
    addModel(file, ModelPool.OBJ);
  }
  
  public void addModel(String file, Class modelFormat) {
    ModelPoolEntry entry = ModelPool.addFile(file, modelFormat, this.transformGroup, this.textureGroup);
    if (entry == null)
      return; 
    PositionTextureVertex[] verts = Arrays.<PositionTextureVertex>copyOf((PositionTextureVertex[])entry.vertices, entry.vertices.length);
    TexturedPolygon[] poly = Arrays.<TexturedPolygon>copyOf(entry.faces, entry.faces.length);
    if (this.flip)
      for (TexturedPolygon face : this.faces)
        face.flipFace();  
    copyTo(verts, poly, false);
  }
  
  public ModelRendererTurbo setTextureOffset(int x, int y) {
    this.textureOffsetX = x;
    this.textureOffsetY = y;
    return this;
  }
  
  public void setPosition(float x, float y, float z) {
    this.field_78800_c = x;
    this.field_78797_d = y;
    this.field_78798_e = z;
  }
  
  public void doMirror(boolean x, boolean y, boolean z) {
    for (TexturedPolygon face : this.faces) {
      PositionTextureVertex[] verts = face.vertexPositions;
      for (int j = 0; j < verts.length; j++) {
        (verts[j]).field_78243_a.field_72450_a *= (x ? -1 : true);
        (verts[j]).field_78243_a.field_72448_b *= (y ? -1 : true);
        (verts[j]).field_78243_a.field_72449_c *= (z ? -1 : true);
      } 
      if (x ^ y ^ z)
        face.flipFace(); 
    } 
  }
  
  public void setMirrored(boolean isMirrored) {
    this.field_78809_i = isMirrored;
  }
  
  public void setFlipped(boolean isFlipped) {
    this.flip = isFlipped;
  }
  
  public void clear() {
    this.vertices = new PositionTextureVertex[0];
    this.faces = new TexturedPolygon[0];
    this.transformGroup.clear();
    this.transformGroup.put("0", new TransformGroupBone(new Bone(0.0F, 0.0F, 0.0F, 0.0F), 1.0D));
    this.currentGroup = this.transformGroup.get("0");
  }
  
  public void copyTo(PositionTextureVertex[] verts, TexturedPolygon[] poly) {
    copyTo(verts, poly, true);
  }
  
  public void copyTo(PositionTextureVertex[] verts, TexturedPolygon[] poly, boolean copyGroup) {
    this.vertices = Arrays.<PositionTextureVertex>copyOf(this.vertices, this.vertices.length + verts.length);
    this.faces = Arrays.<TexturedPolygon>copyOf(this.faces, this.faces.length + poly.length);
    int idx;
    for (idx = 0; idx < verts.length; idx++) {
      this.vertices[this.vertices.length - verts.length + idx] = verts[idx];
      if (copyGroup && verts[idx] instanceof PositionTransformVertex)
        ((PositionTransformVertex)verts[idx]).addGroup(this.currentGroup); 
    } 
    for (idx = 0; idx < poly.length; idx++) {
      this.faces[this.faces.length - poly.length + idx] = poly[idx];
      if (copyGroup)
        this.currentTextureGroup.addPoly(poly[idx]); 
    } 
  }
  
  public void copyTo(PositionTextureVertex[] verts, TexturedQuad[] quad) {
    TexturedPolygon[] poly = new TexturedPolygon[quad.length];
    for (int idx = 0; idx < quad.length; idx++)
      poly[idx] = new TexturedPolygon((PositionTextureVertex[])(quad[idx]).field_78239_a); 
    copyTo(verts, poly);
  }
  
  public void setGroup(String groupName) {
    setGroup(groupName, new Bone(0.0F, 0.0F, 0.0F, 0.0F), 1.0D);
  }
  
  public void setGroup(String groupName, Bone bone, double weight) {
    if (!this.transformGroup.containsKey(groupName))
      this.transformGroup.put(groupName, new TransformGroupBone(bone, weight)); 
    this.currentGroup = this.transformGroup.get(groupName);
  }
  
  public TransformGroup getGroup() {
    return this.currentGroup;
  }
  
  public TransformGroup getGroup(String groupName) {
    if (!this.transformGroup.containsKey(groupName))
      return null; 
    return this.transformGroup.get(groupName);
  }
  
  public void setTextureGroup(String groupName) {
    if (!this.textureGroup.containsKey(groupName))
      this.textureGroup.put(groupName, new TextureGroup()); 
    this.currentTextureGroup = this.textureGroup.get(groupName);
  }
  
  public TextureGroup getTextureGroup() {
    return this.currentTextureGroup;
  }
  
  public TextureGroup getTextureGroup(String groupName) {
    if (!this.textureGroup.containsKey(groupName))
      return null; 
    return this.textureGroup.get(groupName);
  }
  
  public void setGroupTexture(String s) {
    this.currentTextureGroup.texture = s;
  }
  
  public void setDefaultTexture(String s) {
    this.defaultTexture = s;
  }
  
  public void func_78785_a(float worldScale) {
    render(worldScale, false);
  }
  
  public void render(float worldScale, boolean oldRotateOrder) {
    GL11.glPushMatrix();
    if (this.glow)
      glowOn(); 
    GL11.glAlphaFunc(516, 0.001F);
    GL11.glEnable(3042);
    int srcBlend = GL11.glGetInteger(3041);
    int dstBlend = GL11.glGetInteger(3040);
    GL11.glBlendFunc(770, 771);
    if (this.field_1402_i)
      return; 
    if (!this.field_78806_j)
      return; 
    if (!this.compiled || this.forcedRecompile)
      compileDisplayList(worldScale); 
    if (this.field_78795_f != 0.0F || this.field_78796_g != 0.0F || this.field_78808_h != 0.0F) {
      GL11.glPushMatrix();
      GL11.glTranslatef(this.field_78800_c * worldScale, this.field_78797_d * worldScale, this.field_78798_e * worldScale);
      if (!oldRotateOrder && this.field_78796_g != 0.0F)
        GL11.glRotatef(this.field_78796_g * 57.29578F, 0.0F, 1.0F, 0.0F); 
      if (this.field_78808_h != 0.0F)
        GL11.glRotatef((oldRotateOrder ? -1 : true) * this.field_78808_h * 57.29578F, 0.0F, 0.0F, 1.0F); 
      if (oldRotateOrder && this.field_78796_g != 0.0F)
        GL11.glRotatef(-this.field_78796_g * 57.29578F, 0.0F, 1.0F, 0.0F); 
      if (this.field_78795_f != 0.0F)
        GL11.glRotatef(this.field_78795_f * 57.29578F, 1.0F, 0.0F, 0.0F); 
      callDisplayList();
      if (this.field_78805_m != null)
        for (Object childModel : this.field_78805_m)
          ((ModelRenderer)childModel).func_78785_a(worldScale);  
      GL11.glPopMatrix();
    } else if (this.field_78800_c != 0.0F || this.field_78797_d != 0.0F || this.field_78798_e != 0.0F) {
      GL11.glTranslatef(this.field_78800_c * worldScale, this.field_78797_d * worldScale, this.field_78798_e * worldScale);
      callDisplayList();
      if (this.field_78805_m != null)
        for (Object childModel : this.field_78805_m)
          ((ModelRenderer)childModel).func_78785_a(worldScale);  
      GL11.glTranslatef(-this.field_78800_c * worldScale, -this.field_78797_d * worldScale, -this.field_78798_e * worldScale);
    } else {
      callDisplayList();
      if (this.field_78805_m != null)
        for (Object childModel : this.field_78805_m)
          ((ModelRenderer)childModel).func_78785_a(worldScale);  
    } 
    if (this.glow)
      glowOff(); 
    GL11.glBlendFunc(srcBlend, dstBlend);
    GL11.glDisable(3042);
    GL11.glPopMatrix();
  }
  
  public void func_78791_b(float f) {
    if (this.field_1402_i)
      return; 
    if (!this.field_78806_j)
      return; 
    if (!this.compiled)
      compileDisplayList(f); 
    GL11.glPushMatrix();
    GL11.glTranslatef(this.field_78800_c * f, this.field_78797_d * f, this.field_78798_e * f);
    if (this.field_78796_g != 0.0F)
      GL11.glRotatef(this.field_78796_g * 57.29578F, 0.0F, 1.0F, 0.0F); 
    if (this.field_78795_f != 0.0F)
      GL11.glRotatef(this.field_78795_f * 57.29578F, 1.0F, 0.0F, 0.0F); 
    if (this.field_78808_h != 0.0F)
      GL11.glRotatef(this.field_78808_h * 57.29578F, 0.0F, 0.0F, 1.0F); 
    callDisplayList();
    GL11.glPopMatrix();
  }
  
  public void func_78794_c(float f) {
    if (this.field_1402_i)
      return; 
    if (!this.field_78806_j)
      return; 
    if (!this.compiled || this.forcedRecompile)
      compileDisplayList(f); 
    if (this.field_78795_f != 0.0F || this.field_78796_g != 0.0F || this.field_78808_h != 0.0F) {
      GL11.glTranslatef(this.field_78800_c * f, this.field_78797_d * f, this.field_78798_e * f);
      if (this.field_78808_h != 0.0F)
        GL11.glRotatef(this.field_78808_h * 57.29578F, 0.0F, 0.0F, 1.0F); 
      if (this.field_78796_g != 0.0F)
        GL11.glRotatef(this.field_78796_g * 57.29578F, 0.0F, 1.0F, 0.0F); 
      if (this.field_78795_f != 0.0F)
        GL11.glRotatef(this.field_78795_f * 57.29578F, 1.0F, 0.0F, 0.0F); 
    } else if (this.field_78800_c != 0.0F || this.field_78797_d != 0.0F || this.field_78798_e != 0.0F) {
      GL11.glTranslatef(this.field_78800_c * f, this.field_78797_d * f, this.field_78798_e * f);
    } 
  }
  
  private void callDisplayList() {
    if (this.useLegacyCompiler) {
      GL11.glCallList(this.displayList);
    } else {
      TextureManager renderEngine = RenderManager.field_78727_a.field_78724_e;
      Collection<TextureGroup> textures = this.textureGroup.values();
      Iterator<TextureGroup> itr = textures.iterator();
      for (int i = 0; itr.hasNext(); i++) {
        TextureGroup curTexGroup = itr.next();
        curTexGroup.loadTexture();
        GL11.glCallList(this.displayListArray[i]);
        if (!this.defaultTexture.equals(""))
          renderEngine.func_110577_a(new ResourceLocation("", this.defaultTexture)); 
      } 
    } 
  }
  
  private void compileDisplayList(float worldScale) {
    if (this.useLegacyCompiler) {
      compileLegacyDisplayList(worldScale);
    } else {
      Collection<TextureGroup> textures = this.textureGroup.values();
      Iterator<TextureGroup> itr = textures.iterator();
      this.displayListArray = new int[this.textureGroup.size()];
      for (int i = 0; itr.hasNext(); i++) {
        this.displayListArray[i] = GLAllocation.func_74526_a(1);
        GL11.glNewList(this.displayListArray[i], 4864);
        TmtTessellator tessellator = TmtTessellator.instance;
        TextureGroup usedGroup = itr.next();
        for (int j = 0; j < usedGroup.poly.size(); j++)
          ((TexturedPolygon)usedGroup.poly.get(j)).draw(tessellator, worldScale); 
        GL11.glEndList();
      } 
    } 
    this.compiled = true;
  }
  
  private void compileLegacyDisplayList(float worldScale) {
    this.displayList = GLAllocation.func_74526_a(1);
    GL11.glNewList(this.displayList, 4864);
    TmtTessellator tessellator = TmtTessellator.instance;
    for (TexturedPolygon face : this.faces)
      face.draw(tessellator, worldScale); 
    GL11.glEndList();
  }
  
  private static boolean optifineBreak = false;
  
  private PositionTextureVertex[] vertices;
  
  private TexturedPolygon[] faces;
  
  private int textureOffsetX;
  
  private int textureOffsetY;
  
  private boolean compiled;
  
  private int displayList;
  
  private int[] displayListArray;
  
  private Map<String, TransformGroup> transformGroup;
  
  private Map<String, TextureGroup> textureGroup;
  
  private TransformGroup currentGroup;
  
  private TextureGroup currentTextureGroup;
  
  public boolean field_78809_i;
  
  public boolean flip;
  
  public boolean field_78806_j;
  
  public boolean field_1402_i;
  
  public boolean forcedRecompile;
  
  public boolean useLegacyCompiler;
  
  public List field_78804_l;
  
  public List field_78805_m;
  
  public final String field_78802_n;
  
  private String defaultTexture;
  
  public static final int MR_FRONT = 0;
  
  public static final int MR_BACK = 1;
  
  public static final int MR_LEFT = 2;
  
  public static final int MR_RIGHT = 3;
  
  public static final int MR_TOP = 4;
  
  public static final int MR_BOTTOM = 5;
  
  private static final float pi = 3.1415927F;
  
  public static void glowOn() {
    glowOn(15);
  }
  
  public static void glowOn(int glow) {
    GL11.glPushAttrib(64);
    try {
      lightmapLastX = OpenGlHelper.lastBrightnessX;
      lightmapLastY = OpenGlHelper.lastBrightnessY;
    } catch (NoSuchFieldError e) {
      optifineBreak = true;
    } 
    float glowRatioX = Math.min(glow / 15.0F * 240.0F + lightmapLastX, 240.0F);
    float glowRatioY = Math.min(glow / 15.0F * 240.0F + lightmapLastY, 240.0F);
    if (!optifineBreak)
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, glowRatioX, glowRatioY); 
  }
  
  public static void glowOff() {
    if (!optifineBreak)
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, lightmapLastX, lightmapLastY); 
    GL11.glPopAttrib();
  }
}
