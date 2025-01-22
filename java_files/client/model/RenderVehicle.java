package com.flansmod.client.model;

import com.flansmod.client.FlansModResourceHandler;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.ItemVehicle;
import com.flansmod.common.driveables.ShootPoint;
import com.flansmod.common.driveables.VehicleType;
import com.flansmod.common.paintjob.Paintjob;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderVehicle extends Render implements IItemRenderer {
  public void render(EntityVehicle vehicle, double d, double d1, double d2, float f, float f1) {
    if (vehicle.field_70154_o != null)
      if (vehicle.field_70154_o.getClass().toString().indexOf("mcheli.aircraft.MCH_EntitySeat") > 0)
        return;  
    func_110777_b((Entity)vehicle);
    VehicleType type = vehicle.getVehicleType();
    GL11.glPushMatrix();
    GL11.glTranslatef((float)d, (float)d1, (float)d2);
    float dYaw = vehicle.axes.getYaw() - vehicle.field_70126_B;
    for (; dYaw > 180.0F; dYaw -= 360.0F);
    for (; dYaw <= -180.0F; dYaw += 360.0F);
    float dPitch = vehicle.axes.getPitch() - vehicle.field_70127_C;
    for (; dPitch > 180.0F; dPitch -= 360.0F);
    for (; dPitch <= -180.0F; dPitch += 360.0F);
    float dRoll = vehicle.axes.getRoll() - vehicle.prevRotationRoll;
    for (; dRoll > 180.0F; dRoll -= 360.0F);
    for (; dRoll <= -180.0F; dRoll += 360.0F);
    GL11.glRotatef(180.0F - vehicle.field_70126_B - dYaw * f1, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(vehicle.field_70127_C + dPitch * f1, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(vehicle.prevRotationRoll + dRoll * f1, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
    GL11.glPushMatrix();
    ModelVehicle modVehicle = (ModelVehicle)type.model;
    GL11.glPushMatrix();
    float recoilDPos = (float)Math.sin(Math.toRadians(vehicle.recoilPos)) - (float)Math.sin(Math.toRadians(vehicle.lastRecoilPos));
    float recoilPos = (float)Math.sin(Math.toRadians(vehicle.lastRecoilPos)) + recoilDPos * f1;
    float tankerinoYaw = 0.0F;
    if ((vehicle.getVehicleType()).marioKart && (vehicle.throttlePeepee > 0.01D || vehicle.throttlePeepee < -0.01F))
      GL11.glRotatef(2.0F * vehicle.throttlePeepee * (vehicle.getVehicleType()).animationMultiplier, 0.0F, 0.0F, 1.0F); 
    if ((vehicle.getVehicleType()).marioKart && vehicle.throttlePeepee > -0.01D && vehicle.throttlePeepee <= 0.01D && (vehicle.throttle > 0.005D || vehicle.throttle < -0.005F))
      GL11.glRotatef(-1.5F * vehicle.throttle * (vehicle.getVehicleType()).animationMultiplier, 0.0F, 0.0F, 1.0F); 
    if (vehicle.throttle > 0.0F)
      GL11.glRotatef(0.5F * vehicle.throttle * vehicle.throttle * vehicle.wheelsYaw * (vehicle.getVehicleType()).driftMultiplier, 1.0F, 0.0F, 0.0F); 
    if (type.turretOrigin != null && vehicle.isPartIntact(EnumDriveablePart.turret) && vehicle.seats != null && vehicle.seats[0] != null) {
      tankerinoYaw = (vehicle.seats[0]).looking.getYaw();
      if (vehicle.backwardsTimer > 0.05D && !vehicle.epicShip && !(vehicle.getVehicleType()).canDive) {
        GL11.glTranslatef(0.0F, -0.03F * vehicle.recoilEnergy, 0.0F);
        if (tankerinoYaw < 23.0F && tankerinoYaw >= -22.0F) {
          GL11.glRotatef(vehicle.recoilEnergy, 0.0F, 0.0F, 1.0F);
        } else if (tankerinoYaw < 68.0F && tankerinoYaw >= 23.0F) {
          GL11.glRotatef(vehicle.recoilEnergy * 0.7F, -1.0F, 0.0F, 1.0F);
        } else if (tankerinoYaw < 113.0F && tankerinoYaw >= 68.0F) {
          GL11.glRotatef(vehicle.recoilEnergy, -1.0F, 0.0F, 0.0F);
        } else if (tankerinoYaw < 158.0F && tankerinoYaw >= 113.0F) {
          GL11.glRotatef(vehicle.recoilEnergy * 0.7F, -1.0F, 0.0F, -1.0F);
        } else if ((tankerinoYaw < 203.0F && tankerinoYaw >= 158.0F) || (tankerinoYaw > -180.0F && tankerinoYaw < -158.0F)) {
          GL11.glRotatef(vehicle.recoilEnergy, 0.0F, 0.0F, -1.0F);
        } else if (tankerinoYaw < -113.0F && tankerinoYaw >= -158.0F) {
          GL11.glRotatef(vehicle.recoilEnergy * 0.7F, 1.0F, 0.0F, -1.0F);
        } else if (tankerinoYaw < -68.0F && tankerinoYaw >= -113.0F) {
          GL11.glRotatef(vehicle.recoilEnergy, 1.0F, 0.0F, 0.0F);
        } else if (tankerinoYaw < -23.0F && tankerinoYaw >= -68.0F) {
          GL11.glRotatef(vehicle.recoilEnergy * 0.7F, 1.0F, 0.0F, 1.0F);
        } else {
          GL11.glRotatef(vehicle.recoilEnergy, 0.0F, 0.0F, 1.0F);
        } 
      } 
    } 
    if (!vehicle.isPartIntact(EnumDriveablePart.frontRightWheel) && !vehicle.isPartIntact(EnumDriveablePart.frontLeftWheel) && !vehicle.isPartIntact(EnumDriveablePart.backRightWheel) && !vehicle.isPartIntact(EnumDriveablePart.backLeftWheel))
      GL11.glTranslatef(0.0F, -0.5F, 0.0F); 
    if (!vehicle.isPartIntact(EnumDriveablePart.rightTrack) && !vehicle.isPartIntact(EnumDriveablePart.leftTrack))
      GL11.glTranslatef(0.0F, -0.5F, 0.0F); 
    if (!vehicle.isPartIntact(EnumDriveablePart.frontRightWheel) && !vehicle.isPartIntact(EnumDriveablePart.frontLeftWheel))
      GL11.glRotatef(8.0F, 0.0F, 0.0F, -1.0F); 
    if (!vehicle.isPartIntact(EnumDriveablePart.backRightWheel) && !vehicle.isPartIntact(EnumDriveablePart.backLeftWheel))
      GL11.glRotatef(8.0F, 0.0F, 0.0F, 1.0F); 
    float number = 1.0F;
    if (type.shiftSides)
      number = -1.0F; 
    if (!vehicle.isPartIntact(EnumDriveablePart.rightTrack) || (!vehicle.isPartIntact(EnumDriveablePart.frontRightWheel) && !vehicle.isPartIntact(EnumDriveablePart.backRightWheel)))
      GL11.glRotatef(8.0F, 1.0F * number, 0.0F, 0.0F); 
    if (!vehicle.isPartIntact(EnumDriveablePart.leftTrack) || (!vehicle.isPartIntact(EnumDriveablePart.frontLeftWheel) && !vehicle.isPartIntact(EnumDriveablePart.backLeftWheel)))
      GL11.glRotatef(8.0F, -1.0F * number, 0.0F, 0.0F); 
    GL11.glScalef(type.modelScale, type.modelScale, type.modelScale);
    if (modVehicle != null)
      modVehicle.render((EntityDriveable)vehicle, f1); 
    int i;
    for (i = 0; i < vehicle.trackLinksLeft.length; i++) {
      AnimTrackLink link = vehicle.trackLinksLeft[i];
      float rotZ = link.zRot;
      GL11.glPushMatrix();
      GL11.glTranslatef(link.position.x / 16.0F, link.position.y / 16.0F, link.position.z / 16.0F);
      for (; rotZ > 180.0F; rotZ -= 360.0F);
      for (; rotZ <= -180.0F; rotZ += 360.0F);
      GL11.glRotatef(rotZ * 57.29578F, 0.0F, 0.0F, 1.0F);
      if (modVehicle != null)
        modVehicle.renderFancyTracks(vehicle, f1); 
      GL11.glPopMatrix();
    } 
    for (i = 0; i < vehicle.trackLinksRight.length; i++) {
      AnimTrackLink link = vehicle.trackLinksRight[i];
      float rotZ = link.zRot;
      for (; rotZ > 180.0F; rotZ -= 360.0F);
      for (; rotZ <= -180.0F; rotZ += 360.0F);
      GL11.glPushMatrix();
      GL11.glTranslatef(link.position.x / 16.0F, link.position.y / 16.0F, link.position.z / 16.0F);
      GL11.glRotatef(rotZ * 57.29578F, 0.0F, 0.0F, 1.0F);
      if (modVehicle != null)
        modVehicle.renderFancyTracks(vehicle, f1); 
      GL11.glPopMatrix();
    } 
    if (type.turretOrigin != null && vehicle.isPartIntact(EnumDriveablePart.turret) && vehicle.seats != null && vehicle.seats[0] != null) {
      dYaw = (vehicle.seats[0]).looking.getYaw() - (vehicle.seats[0]).prevLooking.getYaw();
      float pitch = (vehicle.seats[0]).looking.getPitch();
      for (; dYaw > 180.0F; dYaw -= 360.0F);
      for (; dYaw <= -180.0F; dYaw += 360.0F);
      float yaw = (vehicle.seats[0]).prevLooking.getYaw() + dYaw * f1;
      GL11.glTranslatef(type.turretOrigin.x, type.turretOrigin.y, type.turretOrigin.z);
      GL11.glRotatef(-yaw, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(-type.turretOrigin.x, -type.turretOrigin.y, -type.turretOrigin.z);
      if (modVehicle != null)
        modVehicle.renderTurret(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, vehicle, f1); 
      if (modVehicle != null) {
        GL11.glTranslatef(modVehicle.barrelAttach.x, modVehicle.barrelAttach.y, -modVehicle.barrelAttach.z);
        float bPitch = (vehicle.seats[0]).looking.getPitch() - (vehicle.seats[0]).prevLooking.getPitch();
        float aPitch = (vehicle.seats[0]).prevLooking.getPitch() + bPitch * f1;
        GL11.glRotatef(-aPitch, 0.0F, 0.0F, 1.0F);
        if (vehicle.ticksRepairing > 1)
          GL11.glTranslatef(recoilPos * -0.3125F, 0.0F, 0.0F); 
        GL11.glTranslatef(vehicle.recoilEnergy * -0.5625F, 0.0F, 0.0F);
        modVehicle.renderAnimBarrel(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, vehicle, f1);
      } 
    } 
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    if (FlansMod.DEBUG)
      if (type.turretOrigin != null && vehicle.isPartIntact(EnumDriveablePart.turret) && vehicle.seats != null && vehicle.seats[0] != null) {
        dYaw = (vehicle.seats[0]).looking.getYaw() - (vehicle.seats[0]).prevLooking.getYaw();
        for (; dYaw > 180.0F; dYaw -= 360.0F);
        for (; dYaw <= -180.0F; dYaw += 360.0F);
        float yaw = (vehicle.seats[0]).prevLooking.getYaw() + dYaw * f1;
        GL11.glTranslatef(type.turretOrigin.x, type.turretOrigin.y, type.turretOrigin.z);
        GL11.glRotatef(-yaw, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-(vehicle.seats[0]).looking.getPitch(), 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(-type.turretOrigin.x, -type.turretOrigin.y, -type.turretOrigin.z);
        GL11.glColor4f(0.0F, 0.0F, 1.0F, 0.3F);
        for (ShootPoint point : type.shootPointsPrimary) {
          if (point.rootPos.part == EnumDriveablePart.turret)
            func_76980_a(AxisAlignedBB.func_72330_a((point.rootPos.position.x - 0.25F), (point.rootPos.position.y - 0.25F), (point.rootPos.position.z - 0.25F), (point.rootPos.position.x + 0.25F), (point.rootPos.position.y + 0.25F), (point.rootPos.position.z + 0.25F))); 
        } 
        GL11.glColor4f(0.0F, 1.0F, 0.0F, 0.3F);
        for (ShootPoint point : type.shootPointsSecondary) {
          if (point.rootPos.part == EnumDriveablePart.turret)
            func_76980_a(AxisAlignedBB.func_72330_a((point.rootPos.position.x - 0.25F), (point.rootPos.position.y - 0.25F), (point.rootPos.position.z - 0.25F), (point.rootPos.position.x + 0.25F), (point.rootPos.position.y + 0.25F), (point.rootPos.position.z + 0.25F))); 
        } 
      }  
    GL11.glPopMatrix();
    if (modVehicle != null) {
      GL11.glPushMatrix();
      GL11.glTranslatef(modVehicle.drillHeadOrigin.x, modVehicle.drillHeadOrigin.y, modVehicle.drillHeadOrigin.z);
      GL11.glRotatef(vehicle.harvesterAngle * 50.0F, 1.0F, 0.0F, 0.0F);
      GL11.glTranslatef(-modVehicle.drillHeadOrigin.x, -modVehicle.drillHeadOrigin.y, -modVehicle.drillHeadOrigin.z);
      modVehicle.renderDrillBit(vehicle, f1);
      GL11.glPopMatrix();
    } 
    if (modVehicle != null) {
      Vector3f newRot = Interpolate(vehicle.doorRot, vehicle.prevDoorRot, f1);
      Vector3f newPos = Interpolate(vehicle.doorPos, vehicle.prevDoorPos, f1);
      GL11.glPushMatrix();
      GL11.glTranslatef(modVehicle.doorAttach.x + newPos.x / 16.0F, modVehicle.doorAttach.y + newPos.y / 16.0F, -modVehicle.doorAttach.z + newPos.z / 16.0F);
      GL11.glRotatef(newRot.x, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(-newRot.y, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(newRot.z, 0.0F, 0.0F, 1.0F);
      modVehicle.renderDoor(vehicle, 0.0625F);
      GL11.glPopMatrix();
      Vector3f newRot2 = Interpolate(vehicle.door2Rot, vehicle.prevDoor2Rot, f1);
      Vector3f newPos2 = Interpolate(vehicle.door2Pos, vehicle.prevDoor2Pos, f1);
      GL11.glPushMatrix();
      GL11.glTranslatef(modVehicle.door2Attach.x + newPos2.x / 16.0F, modVehicle.door2Attach.y + newPos2.y / 16.0F, -modVehicle.door2Attach.z + newPos2.z / 16.0F);
      GL11.glRotatef(newRot2.x, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(-newRot2.y, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(newRot2.z, 0.0F, 0.0F, 1.0F);
      modVehicle.renderDoor2(vehicle, 0.0625F);
      GL11.glPopMatrix();
    } 
    GL11.glPopMatrix();
    GL11.glDisable(3553);
    GL11.glEnable(3042);
    GL11.glDisable(2929);
    GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.3F);
    GL11.glScalef(1.0F, 1.0F, 1.0F);
    for (DriveablePart part : (vehicle.getDriveableData()).parts.values()) {
      if (part.box == null)
        continue; 
      float flux = 0.1F;
      if (flux > 0.1F || flux < -0.1F) {
        flux = 0.1F;
      } else {
        flux = (float)Math.sin((vehicle.field_70173_aa / 10.0F));
      } 
      float red = 0.5F;
      if (vehicle.shieldHitTimer > 0 || (part.health <= 0 && part.maxHealth > 0 && part.type == EnumDriveablePart.shield)) {
        red = vehicle.shieldHitTimer / 2.0F;
        flux = vehicle.shieldHitTimer / 2.0F;
      } else {
        red = 0.5F;
      } 
      if (part.type == EnumDriveablePart.shield && !FlansMod.DEBUG)
        GL11.glColor4f(red, red / 5.0F + 0.4F, 5.0F * red, Math.abs(flux * 0.5F)); 
      if (FlansMod.DEBUG) {
        if (part.type == EnumDriveablePart.weakSpot || part.type == EnumDriveablePart.weakSpot2 || part.type == EnumDriveablePart.weakSpot3 || part.type == EnumDriveablePart.turretWeak || part.type == EnumDriveablePart.turretWeak2) {
          GL11.glColor4f(3.0F, 0.0F, 0.0F, 0.5F);
        } else if (part.type == EnumDriveablePart.engine || part.type == EnumDriveablePart.leftTrack || part.type == EnumDriveablePart.rightTrack || part.type == EnumDriveablePart.frontLeftWheel || part.type == EnumDriveablePart.frontRightWheel || part.type == EnumDriveablePart.backLeftWheel || part.type == EnumDriveablePart.backRightWheel) {
          GL11.glColor4f(0.0F, 0.0F, 2.0F, 0.3F);
        } else if (part.type == EnumDriveablePart.core || part.type == EnumDriveablePart.citadel || part.type == EnumDriveablePart.midsection || part.type == EnumDriveablePart.bow || part.type == EnumDriveablePart.stern || part.type == EnumDriveablePart.left || part.type == EnumDriveablePart.right || part.type == EnumDriveablePart.superstructure || part.type == EnumDriveablePart.turret) {
          GL11.glColor4f(0.0F, 2.0F, 2.0F, 0.3F);
        } else if (part.type == EnumDriveablePart.shield) {
          GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
        } else {
          GL11.glColor4f(1.5F, 1.5F, 0.0F, 0.2F);
        } 
      } else if (part.type != EnumDriveablePart.shield) {
        GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.0F);
      } 
      func_76980_a(AxisAlignedBB.func_72330_a(part.box.x, part.box.y, part.box.z, (part.box.x + part.box.w), (part.box.y + part.box.h), (part.box.z + part.box.d)));
    } 
    if (FlansMod.DEBUG) {
      GL11.glColor4f(0.0F, 0.0F, 1.0F, 0.3F);
      for (ShootPoint point : type.shootPointsPrimary) {
        if (point.rootPos.part != EnumDriveablePart.turret)
          func_76980_a(AxisAlignedBB.func_72330_a((point.rootPos.position.x - 0.25F), (point.rootPos.position.y - 0.25F), (point.rootPos.position.z - 0.25F), (point.rootPos.position.x + 0.25F), (point.rootPos.position.y + 0.25F), (point.rootPos.position.z + 0.25F))); 
      } 
      GL11.glColor4f(0.0F, 1.0F, 0.0F, 0.3F);
      for (ShootPoint point : type.shootPointsSecondary) {
        if (point.rootPos.part != EnumDriveablePart.turret)
          func_76980_a(AxisAlignedBB.func_72330_a((point.rootPos.position.x - 0.25F), (point.rootPos.position.y - 0.25F), (point.rootPos.position.z - 0.25F), (point.rootPos.position.x + 0.25F), (point.rootPos.position.y + 0.25F), (point.rootPos.position.z + 0.25F))); 
      } 
    } 
    GL11.glEnable(3553);
    GL11.glEnable(2929);
    GL11.glDisable(3042);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    GL11.glPopMatrix();
  }
  
  public void func_76986_a(Entity entity, double d, double d1, double d2, float f, float f1) {
    render((EntityVehicle)entity, d, d1, d2, f, f1);
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
        return ((Minecraft.func_71410_x()).field_71474_y.field_74347_j && item != null && item.func_77973_b() instanceof ItemVehicle && ((ItemVehicle)item.func_77973_b()).type.model != null);
    } 
    return false;
  }
  
  public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
    return false;
  }
  
  public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
    GL11.glPushMatrix();
    if (item != null && item.func_77973_b() instanceof ItemVehicle) {
      VehicleType vehicleType = ((ItemVehicle)item.func_77973_b()).type;
      if (vehicleType.model != null) {
        float scale = 0.5F;
        switch (type) {
          case ENTITY:
            scale = 1.5F;
            GL11.glRotatef(((EntityItem)data[1]).field_70173_aa, 0.0F, 1.0F, 0.0F);
            break;
          case EQUIPPED:
            GL11.glRotatef(15.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(15.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, 0.15F, -0.4F);
            scale = 1.0F;
            break;
          case EQUIPPED_FIRST_PERSON:
            GL11.glRotatef(25.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-5.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.15F, 0.45F, -0.6F);
            break;
        } 
        GL11.glScalef(scale / vehicleType.cameraDistance, scale / vehicleType.cameraDistance, scale / vehicleType.cameraDistance);
        (Minecraft.func_71410_x()).field_71446_o.func_110577_a(FlansModResourceHandler.getTexture((InfoType)vehicleType));
        ModelDriveable model = vehicleType.model;
        model.render((DriveableType)vehicleType);
      } 
    } 
    GL11.glPopMatrix();
  }
  
  public Vector3f Interpolate(Vector3f current, Vector3f prev, float f1) {
    Vector3f result = new Vector3f(prev.x + (current.x - prev.x) * f1, prev.y + (current.y - prev.y) * f1, prev.z + (current.z - prev.z) * f1);
    return result;
  }
}
