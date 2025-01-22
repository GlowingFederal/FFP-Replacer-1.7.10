package com.flansmod.client.tmt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class ModelPoolObjEntry extends ModelPoolEntry {
  public void getModel(File file) {
    try {
      BufferedReader in = new BufferedReader(new FileReader(file));
      ArrayList<PositionTransformVertex> verts = new ArrayList<>();
      ArrayList<float[]> uvs = (ArrayList)new ArrayList<>();
      ArrayList<float[]> normals = (ArrayList)new ArrayList<>();
      ArrayList<TexturedPolygon> face = new ArrayList<>();
      String s;
      while ((s = in.readLine()) != null) {
        if (s.contains("#"))
          s = s.substring(0, s.indexOf("#")); 
        s = s.trim();
        if (s.equals(""))
          continue; 
        if (s.startsWith("g ")) {
          setTextureGroup(s.substring(s.indexOf(" ") + 1).trim());
          continue;
        } 
        if (s.startsWith("v ")) {
          s = s.substring(s.indexOf(" ") + 1).trim();
          float[] v = new float[3];
          for (int j = 0; j < 3; j++) {
            int ind = s.indexOf(" ");
            if (ind > -1) {
              v[j] = Float.parseFloat(s.substring(0, ind));
            } else {
              v[j] = Float.parseFloat(s.substring(0));
            } 
            s = s.substring(s.indexOf(" ") + 1).trim();
          } 
          float flt = v[2];
          v[2] = -v[1];
          v[1] = flt;
          verts.add(new PositionTransformVertex(v[0], v[1], v[2], 0.0F, 0.0F));
          continue;
        } 
        if (s.startsWith("vt ")) {
          s = s.substring(s.indexOf(" ") + 1).trim();
          float[] v = new float[2];
          for (int j = 0; j < 2; j++) {
            int ind = s.indexOf(" ");
            if (ind > -1) {
              v[j] = Float.parseFloat(s.substring(0, ind));
            } else {
              v[j] = Float.parseFloat(s.substring(0));
            } 
            s = s.substring(s.indexOf(" ") + 1).trim();
          } 
          uvs.add(new float[] { v[0], 1.0F - v[1] });
          continue;
        } 
        if (s.startsWith("vn ")) {
          s = s.substring(s.indexOf(" ") + 1).trim();
          float[] v = new float[3];
          for (int j = 0; j < 3; j++) {
            int ind = s.indexOf(" ");
            if (ind > -1) {
              v[j] = Float.parseFloat(s.substring(0, ind));
            } else {
              v[j] = Float.parseFloat(s.substring(0));
            } 
            s = s.substring(s.indexOf(" ") + 1).trim();
          } 
          float flt = v[2];
          v[2] = v[1];
          v[1] = flt;
          normals.add(new float[] { v[0], v[1], v[2] });
          continue;
        } 
        if (s.startsWith("f ")) {
          s = s.substring(s.indexOf(" ") + 1).trim();
          ArrayList<PositionTextureVertex> v = new ArrayList<>();
          int finalPhase = 0;
          float[] normal = { 0.0F, 0.0F, 0.0F };
          ArrayList<Vec3> iNormal = new ArrayList<>();
          do {
            int vInt;
            float[] curUV, curNormals;
            int ind = s.indexOf(" ");
            String s1 = s;
            if (ind > -1)
              s1 = s.substring(0, ind); 
            if (s1.contains("/")) {
              String[] f = s1.split("/");
              vInt = Integer.parseInt(f[0]) - 1;
              if (f[1].equals(""))
                f[1] = f[0]; 
              int vtInt = Integer.parseInt(f[1]) - 1;
              if (uvs.size() > vtInt) {
                curUV = uvs.get(vtInt);
              } else {
                curUV = new float[] { 0.0F, 0.0F };
              } 
              int vnInt = 0;
              if (f.length == 3) {
                if (f[2].equals(""))
                  f[2] = f[0]; 
                vnInt = Integer.parseInt(f[2]) - 1;
              } else {
                vnInt = Integer.parseInt(f[0]) - 1;
              } 
              if (normals.size() > vnInt) {
                curNormals = normals.get(vnInt);
              } else {
                curNormals = new float[] { 0.0F, 0.0F, 0.0F };
              } 
            } else {
              vInt = Integer.parseInt(s1) - 1;
              if (uvs.size() > vInt) {
                curUV = uvs.get(vInt);
              } else {
                curUV = new float[] { 0.0F, 0.0F };
              } 
              if (normals.size() > vInt) {
                curNormals = normals.get(vInt);
              } else {
                curNormals = new float[] { 0.0F, 0.0F, 0.0F };
              } 
            } 
            iNormal.add(Vec3.func_72443_a(curNormals[0], curNormals[1], curNormals[2]));
            normal[0] = normal[0] + curNormals[0];
            normal[1] = normal[1] + curNormals[1];
            normal[2] = normal[2] + curNormals[2];
            if (vInt < verts.size()) {
              v.add(((PositionTransformVertex)verts.get(vInt)).setTexturePosition(curUV[0], curUV[1]));
              if (verts.get(vInt) instanceof PositionTransformVertex)
                ((PositionTransformVertex)verts.get(vInt)).addGroup(this.group); 
            } 
            if (ind > -1) {
              s = s.substring(s.indexOf(" ") + 1).trim();
            } else {
              finalPhase++;
            } 
          } while (finalPhase < 1);
          float d = MathHelper.func_76133_a((normal[0] * normal[0] + normal[1] * normal[1] + normal[2] * normal[2]));
          normal[0] = normal[0] / d;
          normal[1] = normal[1] / d;
          normal[2] = normal[2] / d;
          PositionTextureVertex[] vToArr = new PositionTextureVertex[v.size()];
          for (int j = 0; j < v.size(); j++)
            vToArr[j] = v.get(j); 
          TexturedPolygon poly = new TexturedPolygon(vToArr);
          poly.setNormals(normal[0], normal[1], normal[2]);
          poly.setNormals(iNormal);
          face.add(poly);
          this.texture.addPoly(poly);
        } 
      } 
      this.vertices = new PositionTransformVertex[verts.size()];
      int i;
      for (i = 0; i < verts.size(); i++)
        this.vertices[i] = verts.get(i); 
      this.faces = new TexturedPolygon[face.size()];
      for (i = 0; i < face.size(); i++)
        this.faces[i] = face.get(i); 
      in.close();
    } catch (Throwable throwable) {}
  }
}
