package com.flansmod.client.model;

import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.client.model.animation.AnimationController;
import com.flansmod.client.model.animation.AnimationPart;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.ItemPlane;
import com.flansmod.common.driveables.PlaneType;
import com.flansmod.common.driveables.Propeller;
import com.flansmod.common.driveables.ShootPoint;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.paintjob.Paintjob;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderPlane extends Render implements IItemRenderer {
  public void render(EntityPlane entityPlane, double d, double d1, double d2, float f, float f1) {
    if (entityPlane.field_70154_o != null)
      if (entityPlane.field_70154_o.getClass().toString().indexOf("mcheli.aircraft.MCH_EntitySeat") > 0)
        return;  
    func_110777_b((Entity)entityPlane);
    PlaneType type = entityPlane.getPlaneType();
    GL11.glPushMatrix();
    GL11.glTranslatef((float)d, (float)d1, (float)d2);
    float dYaw = entityPlane.axes.getYaw() - entityPlane.field_70126_B;
    for (; dYaw > 180.0F; dYaw -= 360.0F);
    for (; dYaw <= -180.0F; dYaw += 360.0F);
    float dPitch = entityPlane.axes.getPitch() - entityPlane.field_70127_C;
    for (; dPitch > 180.0F; dPitch -= 360.0F);
    for (; dPitch <= -180.0F; dPitch += 360.0F);
    float dRoll = entityPlane.axes.getRoll() - entityPlane.prevRotationRoll;
    for (; dRoll > 180.0F; dRoll -= 360.0F);
    for (; dRoll <= -180.0F; dRoll += 360.0F);
    GL11.glRotatef(180.0F - entityPlane.field_70126_B - dYaw * f1, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(entityPlane.field_70127_C + dPitch * f1, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(entityPlane.prevRotationRoll + dRoll * f1, 1.0F, 0.0F, 0.0F);
    ModelPlane model = (ModelPlane)type.model;
    if (model != null) {
      GL11.glPushMatrix();
      GL11.glScalef(type.modelScale, type.modelScale, type.modelScale);
      model.render((EntityDriveable)entityPlane, f1);
      float dRotorAngle = entityPlane.rotorAngle - entityPlane.prevRotorAngle;
      float rotorAngle = entityPlane.prevRotorAngle + dRotorAngle * f1;
      int i;
      for (i = 0; i < model.heliMainRotorModels.length; i++) {
        GL11.glPushMatrix();
        GL11.glTranslatef((model.heliMainRotorOrigins[i]).x, (model.heliMainRotorOrigins[i]).y, (model.heliMainRotorOrigins[i]).z);
        GL11.glRotatef((entityPlane.rotorAngle + f1 * entityPlane.throttle / 7.0F) * model.heliRotorSpeeds[i] * 1440.0F / 3.1415927F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-(model.heliMainRotorOrigins[i]).x, -(model.heliMainRotorOrigins[i]).y, -(model.heliMainRotorOrigins[i]).z);
        model.renderRotor(entityPlane, 0.0625F, i);
        GL11.glPopMatrix();
      } 
      for (i = 0; i < model.heliTailRotorModels.length; i++) {
        GL11.glPushMatrix();
        GL11.glTranslatef((model.heliTailRotorOrigins[i]).x, (model.heliTailRotorOrigins[i]).y, (model.heliTailRotorOrigins[i]).z);
        GL11.glRotatef((entityPlane.rotorAngle + f1 * entityPlane.throttle / 7.0F) * 1440.0F / 3.1415927F, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(-(model.heliTailRotorOrigins[i]).x, -(model.heliTailRotorOrigins[i]).y, -(model.heliTailRotorOrigins[i]).z);
        model.renderTailRotor(entityPlane, 0.0625F, i);
        GL11.glPopMatrix();
      } 
      Vector3f wingPos = getRenderPosition(entityPlane.wingPos, entityPlane.prevWingPos, f1);
      Vector3f wingRot = getRenderPosition(entityPlane.wingRot, entityPlane.prevWingRot, f1);
      if (entityPlane.initiatedAnim) {
        AnimationController cont = entityPlane.anim;
        AnimationPart p = cont.getCorePart();
        renderAnimPart(p, new Vector3f(0.0F, 0.0F, 0.0F), model, entityPlane, 0.0625F, f1);
      } 
      GL11.glPushMatrix();
      GL11.glTranslatef(model.leftWingAttach.x + wingPos.x / 16.0F, model.leftWingAttach.y + wingPos.y / 16.0F, -model.leftWingAttach.z + wingPos.z / 16.0F);
      GL11.glRotatef(wingRot.x, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(wingRot.y, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(wingRot.z, 0.0F, 0.0F, 1.0F);
      model.renderLeftWing(entityPlane, 0.0625F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(model.rightWingAttach.x + wingPos.x / 16.0F, model.rightWingAttach.y + wingPos.y / 16.0F, -model.rightWingAttach.z + wingPos.z / 16.0F);
      GL11.glRotatef(-wingRot.x, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(-wingRot.y, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(wingRot.z, 0.0F, 0.0F, 1.0F);
      model.renderRightWing(entityPlane, 0.0625F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(model.leftWingWheelAttach.x + entityPlane.wingWheelPos.x / 16.0F, model.leftWingWheelAttach.y + entityPlane.wingWheelPos.y / 16.0F, -model.leftWingWheelAttach.z + entityPlane.wingWheelPos.z / 16.0F);
      GL11.glRotatef(entityPlane.wingWheelRot.x, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(entityPlane.wingWheelRot.y, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(entityPlane.wingWheelRot.z, 0.0F, 0.0F, 1.0F);
      model.renderLeftWingWheel(entityPlane, 0.0625F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(model.rightWingWheelAttach.x + entityPlane.wingWheelPos.x / 16.0F, model.rightWingWheelAttach.y + entityPlane.wingWheelPos.y / 16.0F, -model.rightWingWheelAttach.z + entityPlane.wingWheelPos.z / 16.0F);
      GL11.glRotatef(-entityPlane.wingWheelRot.x, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(-entityPlane.wingWheelRot.y, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(entityPlane.wingWheelRot.z, 0.0F, 0.0F, 1.0F);
      model.renderRightWingWheel(entityPlane, 0.0625F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(model.bodyWheelAttach.x + entityPlane.coreWheelPos.x / 16.0F, model.bodyWheelAttach.y + entityPlane.coreWheelPos.y / 16.0F, model.bodyWheelAttach.z + entityPlane.coreWheelPos.z / 16.0F);
      GL11.glRotatef(entityPlane.coreWheelRot.x, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(entityPlane.coreWheelRot.y, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(entityPlane.coreWheelRot.z, 0.0F, 0.0F, 1.0F);
      model.renderCoreWheel(entityPlane, 0.0625F);
      GL11.glPopMatrix();
      GL11.glPushMatrix();
      GL11.glTranslatef(model.tailWheelAttach.x + entityPlane.tailWheelPos.x / 16.0F, model.tailWheelAttach.y + entityPlane.tailWheelPos.y / 16.0F, model.tailWheelAttach.z + entityPlane.tailWheelPos.z / 16.0F);
      GL11.glRotatef(entityPlane.tailWheelRot.x, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(entityPlane.tailWheelRot.y, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(entityPlane.tailWheelRot.z, 0.0F, 0.0F, 1.0F);
      model.renderTailWheel(entityPlane, 0.0625F);
      GL11.glPopMatrix();
      Vector3f doorPos = getRenderPosition(entityPlane.doorPos, entityPlane.prevDoorPos, f1);
      Vector3f doorRot = getRenderPosition(entityPlane.doorRot, entityPlane.prevDoorRot, f1);
      GL11.glPushMatrix();
      GL11.glTranslatef(model.doorAttach.x + doorPos.x / 16.0F, model.doorAttach.y + doorPos.y / 16.0F, model.doorAttach.z + doorPos.z / 16.0F);
      GL11.glRotatef(doorRot.x, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(doorRot.y, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(doorRot.z, 0.0F, 0.0F, 1.0F);
      model.renderDoor(entityPlane, 0.0625F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
    } 
    if (FlansMod.DEBUG) {
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glDisable(2929);
      GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.03F);
      GL11.glScalef(-1.0F, 1.0F, -1.0F);
      for (DriveablePart part : (entityPlane.getDriveableData()).parts.values()) {
        if (part.box == null)
          continue; 
        if (part.type == EnumDriveablePart.core || part.type == EnumDriveablePart.engine || part.type == EnumDriveablePart.engine2 || part.type == EnumDriveablePart.engine3 || part.type == EnumDriveablePart.engine4 || part.type == EnumDriveablePart.engine5 || part.type == EnumDriveablePart.engine6) {
          GL11.glColor4f(3.0F, 0.0F, 0.0F, 0.5F);
        } else if (part.type == EnumDriveablePart.airframe) {
          GL11.glColor4f(0.0F, 2.0F, 2.0F, 0.3F);
        } else if (part.type == EnumDriveablePart.leftWing || part.type == EnumDriveablePart.rightWing || part.type == EnumDriveablePart.tail || part.type == EnumDriveablePart.nose || part.type == EnumDriveablePart.blades) {
          GL11.glColor4f(0.0F, 0.0F, 2.0F, 0.3F);
        } else {
          GL11.glColor4f(1.5F, 1.5F, 0.0F, 0.2F);
        } 
        func_76980_a(AxisAlignedBB.func_72330_a(part.box.x, part.box.y, part.box.z, (part.box.x + part.box.w), (part.box.y + part.box.h), (part.box.z + part.box.d)));
      } 
      GL11.glColor4f(1.0F, 1.0F, 0.0F, 0.3F);
      for (Propeller prop : type.propellers)
        func_76980_a(AxisAlignedBB.func_72330_a((prop.x / 16.0F - 0.25F), (prop.y / 16.0F - 0.25F), (prop.z / 16.0F - 0.25F), (prop.x / 16.0F + 0.25F), (prop.y / 16.0F + 0.25F), (prop.z / 16.0F + 0.25F))); 
      GL11.glColor4f(1.0F, 0.0F, 1.0F, 0.3F);
      for (ShootPoint point : type.shootPointsPrimary)
        func_76980_a(AxisAlignedBB.func_72330_a((point.rootPos.position.x - 0.25F), (point.rootPos.position.y - 0.25F), (point.rootPos.position.z - 0.25F), (point.rootPos.position.x + 0.25F), (point.rootPos.position.y + 0.25F), (point.rootPos.position.z + 0.25F))); 
      GL11.glColor4f(0.0F, 1.0F, 0.0F, 0.3F);
      for (ShootPoint point : type.shootPointsSecondary)
        func_76980_a(AxisAlignedBB.func_72330_a((point.rootPos.position.x - 0.25F), (point.rootPos.position.y - 0.25F), (point.rootPos.position.z - 0.25F), (point.rootPos.position.x + 0.25F), (point.rootPos.position.y + 0.25F), (point.rootPos.position.z + 0.25F))); 
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDisable(3042);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    } 
    if (TeamsManager.shellsEnabled) {
      int slot = -1;
      for (int i = entityPlane.getDriveableData().getMissileInventoryStart(); i < entityPlane.getDriveableData().getMissileInventoryStart() + type.numMissileSlots; i++) {
        ItemStack shell = entityPlane.getDriveableData().func_70301_a(i);
        if (shell != null && shell.func_77973_b() instanceof ItemBullet)
          slot = i; 
      } 
      if (slot != -1) {
        ItemStack bulletStack = entityPlane.driveableData.func_70301_a(slot);
        ItemBullet item = (ItemBullet)bulletStack.func_77973_b();
        if (item instanceof ItemBullet && item.type.model != null && item.type.wingVisible && type.missileVisible) {
          BulletType gunType = item.type;
          ModelBase modelo = item.type.model;
          TextureManager texturemanager = Minecraft.func_71410_x().func_110434_K();
          ModelBase modelLauncher = item.type.launcherMesh;
          if (item.type.hasLauncherModel) {
            texturemanager.func_110577_a(FlansModResourceHandler.getAlternateTexture(gunType));
            GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            if (entityPlane.isPartIntact(EnumDriveablePart.leftWing)) {
              IItemRenderer.ItemRenderType typerino = IItemRenderer.ItemRenderType.ENTITY;
              GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
              GL11.glTranslatef(type.missileWingSpan, type.missileForward, -1.0F * type.missileElevation);
              modelLauncher.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            } 
            if (entityPlane.isPartIntact(EnumDriveablePart.rightWing)) {
              GL11.glTranslatef(type.missileWingSpan * -2.0F, 0.0F, 0.0F);
              modelLauncher.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            } 
          } 
          if (!item.type.hasLauncherModel) {
            texturemanager.func_110577_a(FlansModResourceHandler.getTexture((InfoType)gunType));
            GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            IItemRenderer.ItemRenderType typerino = IItemRenderer.ItemRenderType.ENTITY;
            if (entityPlane.isPartIntact(EnumDriveablePart.leftWing)) {
              GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
              GL11.glTranslatef(type.missileWingSpan, type.missileForward, -1.0F * type.missileElevation);
              modelo.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            } 
            if (entityPlane.isPartIntact(EnumDriveablePart.rightWing)) {
              GL11.glTranslatef(type.missileWingSpan * -2.0F, 0.0F, 0.0F);
              modelo.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            } 
          } 
        } 
      } 
    } 
    GL11.glPopMatrix();
  }
  
  public Vector3f getRenderPosition(Vector3f current, Vector3f previous, float f) {
    Vector3f diff = new Vector3f(current.x - previous.x, current.y - previous.y, current.z - previous.z);
    Vector3f corrected = new Vector3f(previous.x + diff.x * f, previous.y + diff.y * f, previous.z + diff.z * f);
    return corrected;
  }
  
  public void func_76986_a(Entity entity, double d, double d1, double d2, float f, float f1) {
    render((EntityPlane)entity, d, d1, d2, f, f1);
  }
  
  protected ResourceLocation func_110775_a(Entity entity) {
    DriveableType type = ((EntityDriveable)entity).getDriveableType();
    Paintjob paintjob = type.getPaintjob((((EntityDriveable)entity).getDriveableData()).paintjobID);
    return FlansModResourceHandler.getPaintjobTexture(paintjob);
  }
  
  public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
    switch (type) {
      case EQUIPPED:
      case EQUIPPED_FIRST_PERSON:
      case ENTITY:
        return ((Minecraft.func_71410_x()).field_71474_y.field_74347_j && item != null && item.func_77973_b() instanceof ItemPlane && ((ItemPlane)item.func_77973_b()).type.model != null);
    } 
    return false;
  }
  
  public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
    return false;
  }
  
  public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
    GL11.glPushMatrix();
    if (item != null && item.func_77973_b() instanceof ItemPlane) {
      PlaneType planeType = ((ItemPlane)item.func_77973_b()).type;
      if (planeType.model != null) {
        float scale = 0.5F;
        switch (type) {
          case ENTITY:
            scale = 1.5F;
            GL11.glRotatef(((EntityItem)data[1]).field_70173_aa, 0.0F, 1.0F, 0.0F);
            break;
          case EQUIPPED:
            GL11.glRotatef(15.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(15.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, 0.2F, 0.4F);
            scale = 1.0F;
            break;
          case EQUIPPED_FIRST_PERSON:
            GL11.glRotatef(25.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.15F, 0.45F, -0.6F);
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            break;
        } 
        GL11.glScalef(scale / planeType.cameraDistance, scale / planeType.cameraDistance, scale / planeType.cameraDistance);
        (Minecraft.func_71410_x()).field_71446_o.func_110577_a(FlansModResourceHandler.getTexture((InfoType)planeType));
        ModelDriveable model = planeType.model;
        model.render((DriveableType)planeType);
      } 
    } 
    GL11.glPopMatrix();
  }
  
  public int getPartId(int i) {
    int id = i;
    return id;
  }
  
  public void renderAnimPart(AnimationPart p, Vector3f parent, ModelPlane mod, EntityPlane plane, float f5, float f1) {
    Vector3f pos = Vector3f.sub(p.position, parent, null);
    Vector3f offset = Interpolate(p.offset, p.prevOff, f1);
    Vector3f rotation = Interpolate(p.rotation, p.prevRot, f1);
    GL11.glPushMatrix();
    GL11.glTranslatef(pos.x / 16.0F, -pos.y / 16.0F, -pos.z / 16.0F);
    GL11.glRotatef(rotation.x, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(rotation.y, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(rotation.z, 0.0F, 0.0F, 1.0F);
    GL11.glTranslatef(offset.x / 16.0F, offset.y / 16.0F, offset.z / 16.0F);
    int i = getPartId(p.type);
    mod.renderValk(plane, f5, i);
    if (p.hasChildren)
      for (AnimationPart p2 : p.children)
        renderAnimPart(p2, p.position, mod, plane, f5, f1);  
    GL11.glPopMatrix();
  }
  
  public Vector3f Interpolate(Vector3f current, Vector3f prev, float f1) {
    Vector3f result = new Vector3f(prev.x + (current.x - prev.x) * f1, prev.y + (current.y - prev.y) * f1, prev.z + (current.z - prev.z) * f1);
    return result;
  }
}
