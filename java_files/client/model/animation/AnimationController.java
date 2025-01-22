package com.flansmod.client.model.animation;

import com.flansmod.common.RotatedAxes;
import com.flansmod.common.vector.Vector3f;
import java.util.ArrayList;

public class AnimationController {
  public ArrayList<AnimationPart> parts = new ArrayList<>();
  
  public int state = 0;
  
  int animStage = 1;
  
  ArrayList<AnimationPose> poses = new ArrayList<>();
  
  AnimationPose pose;
  
  public int timeSinceSwitch = 0;
  
  public void initAnim() {
    addPartToSkeleton(new AnimationPart(0, new Vector3f(11.0D, -34.5D, 0.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), -1);
    addPartToSkeleton(new AnimationPart(1, new Vector3f(6.0D, -34.5D, 0.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 0);
    addPartToSkeleton(new AnimationPart(2, new Vector3f(-25.0D, -34.5D, 0.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 1);
    addPartToSkeleton(new AnimationPart(3, new Vector3f(-9.0D, -25.0D, -13.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 0);
    addPartToSkeleton(new AnimationPart(4, new Vector3f(6.0D, -23.0D, -21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 3);
    addPartToSkeleton(new AnimationPart(5, new Vector3f(34.0D, -21.5D, -21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 4);
    addPartToSkeleton(new AnimationPart(6, new Vector3f(-9.0D, -25.0D, 13.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 0);
    addPartToSkeleton(new AnimationPart(7, new Vector3f(6.0D, -23.0D, 21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 6);
    addPartToSkeleton(new AnimationPart(8, new Vector3f(34.0D, -21.5D, 21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 7);
    addPartToSkeleton(new AnimationPart(9, new Vector3f(6.0F, -33.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 0);
    addPartToSkeleton(new AnimationPart(10, new Vector3f(43.0D, -38.5D, 0.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 9);
    addPartToSkeleton(new AnimationPart(11, new Vector3f(60.0D, -40.0D, -14.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 10);
    addPartToSkeleton(new AnimationPart(12, new Vector3f(60.0D, -40.0D, 14.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 10);
    addPartToSkeleton(new AnimationPart(13, new Vector3f(10.0D, -36.5D, -17.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 9);
    addPartToSkeleton(new AnimationPart(14, new Vector3f(10.0D, -36.5D, 17.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 9);
    addPartToSkeleton(new AnimationPart(15, new Vector3f(39.0D, -13.0D, -21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 5);
    addPartToSkeleton(new AnimationPart(16, new Vector3f(119.0D, -23.0D, -21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 5);
    addPartToSkeleton(new AnimationPart(17, new Vector3f(119.0D, -23.0D, -21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 5);
    addPartToSkeleton(new AnimationPart(18, new Vector3f(39.0D, -13.0D, 21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 8);
    addPartToSkeleton(new AnimationPart(19, new Vector3f(119.0D, -23.0D, 21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 8);
    addPartToSkeleton(new AnimationPart(20, new Vector3f(119.0D, -23.0D, 21.5D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 8);
    addPartToSkeleton(new AnimationPart(21, new Vector3f(-17.0F, -33.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 2);
    addPartToSkeleton(new AnimationPart(22, new Vector3f(-15.0F, -23.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 21);
    addPartToSkeleton(new AnimationPart(23, new Vector3f(17.0F, -31.0F, -7.0F), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 0);
    addPartToSkeleton(new AnimationPart(24, new Vector3f(22.0D, -20.5D, -7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 23);
    addPartToSkeleton(new AnimationPart(25, new Vector3f(33.0D, -20.5D, -7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 24);
    addPartToSkeleton(new AnimationPart(26, new Vector3f(68.0D, -19.5D, -7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 25);
    addPartToSkeleton(new AnimationPart(27, new Vector3f(69.0D, -21.5D, -7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 26);
    addPartToSkeleton(new AnimationPart(28, new Vector3f(17.0F, -31.0F, 7.0F), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 0);
    addPartToSkeleton(new AnimationPart(29, new Vector3f(22.0D, -20.5D, 7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 28);
    addPartToSkeleton(new AnimationPart(30, new Vector3f(33.0D, -20.5D, 7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 29);
    addPartToSkeleton(new AnimationPart(31, new Vector3f(68.0D, -19.5D, 7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 30);
    addPartToSkeleton(new AnimationPart(32, new Vector3f(69.0D, -21.5D, 7.0D), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F)), 31);
  }
  
  public void initPoses() {
    addDefaultPose();
    addGERWALKPose();
  }
  
  public void addDefaultPose() {
    AnimationPose pose = new AnimationPose();
    pose.parts.add(new PoseComponent("core", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("midfront", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("nose", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlegmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlegshin", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 4, false));
    pose.parts.add(new PoseComponent("rightlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightlegmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightlegshin", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 4, false));
    pose.parts.add(new PoseComponent("rearbody", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("tailmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 12, false));
    pose.parts.add(new PoseComponent("finleft", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 4, false));
    pose.parts.add(new PoseComponent("finright", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 4, false));
    pose.parts.add(new PoseComponent("leftwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 30.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, -30.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("head", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("headguns", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftshoulder", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
    pose.parts.add(new PoseComponent("leftshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
    pose.parts.add(new PoseComponent("leftupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
    pose.parts.add(new PoseComponent("leftlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
    pose.parts.add(new PoseComponent("lefthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
    pose.parts.add(new PoseComponent("rightshoulder", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
    pose.parts.add(new PoseComponent("rightshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
    pose.parts.add(new PoseComponent("rightupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
    pose.parts.add(new PoseComponent("rightlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
    pose.parts.add(new PoseComponent("righthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 5, 5, false));
    this.poses.add(pose);
  }
  
  public void addGERWALKPose() {
    AnimationPose pose = new AnimationPose();
    pose.parts.add(new PoseComponent("core", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("midfront", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("nose", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlegmid", new Vector3f(5.0F, 0.0F, 0.0F), new Vector3f(-20.0F, 0.0F, -50.0F), 2, 8, false));
    pose.parts.add(new PoseComponent("leftlegshin", new Vector3f(5.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -100.0F), 2, 16, false));
    pose.parts.add(new PoseComponent("rightlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightlegmid", new Vector3f(5.0F, 0.0F, 0.0F), new Vector3f(20.0F, 0.0F, -50.0F), 2, 8, false));
    pose.parts.add(new PoseComponent("rightlegshin", new Vector3f(5.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -100.0F), 2, 16, false));
    pose.parts.add(new PoseComponent("rearbody", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("tailmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 160.0F), 2, 12, false));
    pose.parts.add(new PoseComponent("finleft", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-100.0F, 0.0F, 0.0F), 2, 14, false));
    pose.parts.add(new PoseComponent("finright", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(100.0F, 0.0F, 0.0F), 2, 14, false));
    pose.parts.add(new PoseComponent("leftwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 90.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("leftfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 45.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("leftfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -45.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("rightknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 90.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("rightfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 45.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("rightfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -45.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("head", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("headguns", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftshoulder", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("lefthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightshoulder", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("righthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    this.poses.add(pose);
    addGERWALK2();
  }
  
  public void addGERWALK2() {
    AnimationPose pose = new AnimationPose();
    pose.parts.add(new PoseComponent("core", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("midfront", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("nose", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlegmid", new Vector3f(10.0F, 0.0F, 0.0F), new Vector3f(-20.0F, 0.0F, -35.0F), 2, 3, false));
    pose.parts.add(new PoseComponent("leftlegshin", new Vector3f(5.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -75.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("rightlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightlegmid", new Vector3f(10.0F, 0.0F, 0.0F), new Vector3f(20.0F, 0.0F, -35.0F), 2, 3, false));
    pose.parts.add(new PoseComponent("rightlegshin", new Vector3f(5.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -75.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("rearbody", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("tailmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 160.0F), 2, 12, false));
    pose.parts.add(new PoseComponent("finleft", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-100.0F, 0.0F, 0.0F), 2, 14, false));
    pose.parts.add(new PoseComponent("finright", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(100.0F, 0.0F, 0.0F), 2, 14, false));
    pose.parts.add(new PoseComponent("leftwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 110.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("leftfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 110.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("rightfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("head", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("headguns", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 20.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftshoulder", new Vector3f(15.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("lefthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightshoulder", new Vector3f(15.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("righthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    this.poses.add(pose);
    addGERWALK3();
  }
  
  public void addGERWALK3() {
    AnimationPose pose = new AnimationPose();
    pose.parts.add(new PoseComponent("core", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("midfront", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("nose", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlegmid", new Vector3f(10.0F, 0.0F, 0.0F), new Vector3f(-20.0F, 0.0F, -35.0F), 2, 3, false));
    pose.parts.add(new PoseComponent("leftlegshin", new Vector3f(5.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -75.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("rightlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightlegmid", new Vector3f(10.0F, 0.0F, 0.0F), new Vector3f(20.0F, 0.0F, -35.0F), 2, 3, false));
    pose.parts.add(new PoseComponent("rightlegshin", new Vector3f(5.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -75.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("rearbody", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("tailmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 160.0F), 2, 12, false));
    pose.parts.add(new PoseComponent("finleft", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-100.0F, 0.0F, 0.0F), 2, 14, false));
    pose.parts.add(new PoseComponent("finright", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(100.0F, 0.0F, 0.0F), 2, 14, false));
    pose.parts.add(new PoseComponent("leftwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 110.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("leftfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 110.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("rightfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("head", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("headguns", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 20.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftshoulder", new Vector3f(15.0F, -25.0F, 0.0F), new Vector3f(-90.0F, 0.0F, 0.0F), 6, 12, false));
    pose.parts.add(new PoseComponent("leftshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("lefthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightshoulder", new Vector3f(15.0F, -25.0F, 0.0F), new Vector3f(90.0F, 0.0F, 0.0F), 6, 12, false));
    pose.parts.add(new PoseComponent("rightshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("righthand", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    this.poses.add(pose);
    addGERWALK4();
  }
  
  public void addGERWALK4() {
    AnimationPose pose = new AnimationPose();
    pose.parts.add(new PoseComponent("core", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("midfront", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("nose", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlegmid", new Vector3f(10.0F, 0.0F, 0.0F), new Vector3f(-20.0F, 0.0F, -35.0F), 2, 3, false));
    pose.parts.add(new PoseComponent("leftlegshin", new Vector3f(5.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -75.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("rightlegtop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightlegmid", new Vector3f(10.0F, 0.0F, 0.0F), new Vector3f(20.0F, 0.0F, -35.0F), 2, 3, false));
    pose.parts.add(new PoseComponent("rightlegshin", new Vector3f(5.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -75.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("rearbody", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("tailmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 160.0F), 2, 12, false));
    pose.parts.add(new PoseComponent("finleft", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-100.0F, 0.0F, 0.0F), 2, 14, false));
    pose.parts.add(new PoseComponent("finright", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(100.0F, 0.0F, 0.0F), 2, 14, false));
    pose.parts.add(new PoseComponent("leftwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 110.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("leftfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 110.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("rightfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("head", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("headguns", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 20.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftshoulder", new Vector3f(10.0F, -25.0F, -10.0F), new Vector3f(-90.0F, 90.0F, 0.0F), 4, 6, false));
    pose.parts.add(new PoseComponent("leftshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -80.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("leftupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-90.0F, 0.0F, 0.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("leftlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 50.0F), 2, 12, false));
    pose.parts.add(new PoseComponent("lefthand", new Vector3f(23.0F, 0.0F, 0.0F), new Vector3f(180.0F, 0.0F, 0.0F), 2, 20, false));
    pose.parts.add(new PoseComponent("rightshoulder", new Vector3f(10.0F, -25.0F, 10.0F), new Vector3f(90.0F, -90.0F, 0.0F), 4, 6, false));
    pose.parts.add(new PoseComponent("rightshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -80.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("rightupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(90.0F, 0.0F, 0.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("rightlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 50.0F), 2, 12, false));
    pose.parts.add(new PoseComponent("righthand", new Vector3f(23.0F, 0.0F, 0.0F), new Vector3f(180.0F, 0.0F, 0.0F), 2, 20, false));
    this.poses.add(pose);
    addGERWALK5();
  }
  
  public void addGERWALK5() {
    AnimationPose pose = new AnimationPose();
    pose.parts.add(new PoseComponent("core", new Vector3f(120.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 90.0F), 2, 4, false));
    pose.parts.add(new PoseComponent("midfront", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 4, false));
    pose.parts.add(new PoseComponent("nose", new Vector3f(20.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftlegtop", new Vector3f(60.0F, 0.0F, -5.0F), new Vector3f(0.0F, 0.0F, -180.0F), 2, 8, false));
    pose.parts.add(new PoseComponent("leftlegmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 3, false));
    pose.parts.add(new PoseComponent("leftlegshin", new Vector3f(5.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("rightlegtop", new Vector3f(60.0F, 0.0F, 5.0F), new Vector3f(0.0F, 0.0F, -180.0F), 2, 8, false));
    pose.parts.add(new PoseComponent("rightlegmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 3, false));
    pose.parts.add(new PoseComponent("rightlegshin", new Vector3f(5.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("rearbody", new Vector3f(20.0F, 5.0F, 0.0F), new Vector3f(0.0F, 0.0F, -170.0F), 2, 8, false));
    pose.parts.add(new PoseComponent("tailmid", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 160.0F), 2, 12, false));
    pose.parts.add(new PoseComponent("finleft", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-100.0F, 0.0F, 0.0F), 2, 14, false));
    pose.parts.add(new PoseComponent("finright", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(100.0F, 0.0F, 0.0F), 2, 14, false));
    pose.parts.add(new PoseComponent("leftwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 20.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightwing", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, -20.0F, 0.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("leftfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 45.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -45.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightknee", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 25, false));
    pose.parts.add(new PoseComponent("rightfoottop", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 45.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("rightfootbottom", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -45.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("head", new Vector3f(0.0F, 6.0F, 0.0F), new Vector3f(180.0F, 0.0F, 90.0F), 2, 8, false));
    pose.parts.add(new PoseComponent("headguns", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 130.0F), 2, 2, false));
    pose.parts.add(new PoseComponent("leftshoulder", new Vector3f(25.0F, -30.0F, 0.0F), new Vector3f(-90.0F, 180.0F, 0.0F), 4, 6, false));
    pose.parts.add(new PoseComponent("leftshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, -30.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("leftupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(-60.0F, 0.0F, 0.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("leftlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 60.0F), 2, 12, false));
    pose.parts.add(new PoseComponent("lefthand", new Vector3f(23.0F, 0.0F, 0.0F), new Vector3f(180.0F, 0.0F, 0.0F), 2, 20, false));
    pose.parts.add(new PoseComponent("rightshoulder", new Vector3f(25.0F, -30.0F, 0.0F), new Vector3f(90.0F, -180.0F, 0.0F), 4, 6, false));
    pose.parts.add(new PoseComponent("rightshoulderjoint", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("rightupperarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(90.0F, 0.0F, 0.0F), 2, 6, false));
    pose.parts.add(new PoseComponent("rightlowerarm", new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 10.0F), 2, 12, false));
    pose.parts.add(new PoseComponent("righthand", new Vector3f(23.0F, 0.0F, 0.0F), new Vector3f(180.0F, 0.0F, 0.0F), 2, 20, false));
    this.poses.add(pose);
  }
  
  public void addPartToSkeleton(AnimationPart p, int parent) {
    this.parts.add(p);
    if (parent >= 0) {
      AnimationPart part = this.parts.get(parent);
      part.hasChildren = true;
      part.children.add(p);
      p.parent = parent;
    } 
  }
  
  public AnimationPart getCorePart() {
    AnimationPart part = this.parts.get(0);
    return part;
  }
  
  public void UpdateAnim(int stat) {
    switch (this.state) {
      case 0:
        this.pose = this.poses.get(0);
        this.animStage = 1;
        this.timeSinceSwitch = 0;
        break;
      case 1:
        if (this.animStage == 1) {
          this.pose = this.poses.get(1);
          break;
        } 
        if (this.animStage == 2) {
          this.pose = this.poses.get(2);
          break;
        } 
        if (this.animStage == 3) {
          this.pose = this.poses.get(3);
          break;
        } 
        if (this.animStage == 4)
          this.pose = this.poses.get(4); 
        break;
    } 
    boolean animHasFinished = true;
    for (AnimationPart p : this.parts) {
      p.prevOff = new Vector3f(p.offset.x, p.offset.y, p.offset.z);
      p.prevRot = new Vector3f(p.rotation.x, p.rotation.y, p.rotation.z);
      if (this.pose != null) {
        PoseComponent q = this.pose.parts.get(p.type);
        if (!checkIfFinished(p.offset, q.position))
          p.offset = transformPart(p.offset, q.position, new Vector3f(q.speed1, q.speed1, q.speed1)); 
        if (animHasFinished)
          animHasFinished = checkIfFinished(p.offset, q.position); 
        if (!checkIfFinished(p.rotation, q.rotation))
          p.rotation = transformPart(p.rotation, q.rotation, new Vector3f(q.speed2, q.speed2, q.speed2)); 
        if (animHasFinished)
          animHasFinished = checkIfFinished(p.rotation, q.rotation); 
      } 
    } 
    if (animHasFinished && this.timeSinceSwitch > 2)
      this.animStage++; 
    this.timeSinceSwitch++;
  }
  
  public void changeState(int i) {
    this.state = i;
    this.animStage = 1;
    this.timeSinceSwitch = 0;
  }
  
  public boolean checkIfFinished(Vector3f a, Vector3f b) {
    boolean c = true;
    float d = a.lengthSquared();
    float e = b.lengthSquared();
    float f = d - e;
    f = (float)Math.sqrt((f * f));
    if (f > 0.0F)
      c = false; 
    return c;
  }
  
  public int getNumberOfStages() {
    int i = 0;
    switch (this.state) {
      case 0:
        i = 1;
        break;
      case 1:
        i = 4;
        break;
    } 
    return i;
  }
  
  public Vector3f getPositionOnPart(Vector3f in, AnimationPart p, RotatedAxes rot) {
    Vector3f p1 = p.position;
    Vector3f p2 = in;
    p.rotateToPartAxis(rot);
    Vector3f trans = new Vector3f(p2.x - p1.x, p2.y - p1.y, p2.z - p1.z);
    trans = rot.findLocalVectorGlobally(trans);
    return trans;
  }
  
  public Vector3f getFullPosition(Vector3f in, AnimationPart p) {
    AnimationPart core = getCorePart();
    Vector3f pos = new Vector3f(0.0F, 0.0F, 0.0F);
    Vector3f.add(pos, new Vector3f(core.position.x, core.position.y, core.position.z), pos);
    RotatedAxes rot = new RotatedAxes(0.0F, 0.0F, 0.0F);
    ArrayList<Integer> chain = new ArrayList<>();
    chain = generateChain(p, chain);
    for (int i = chain.size() - 1; i > 0; i--) {
      AnimationPart child = this.parts.get(((Integer)chain.get(i - 1)).intValue());
      AnimationPart part = this.parts.get(((Integer)chain.get(i)).intValue());
      Vector3f vector3f = getPositionOnPart(Vector3f.add(child.position, new Vector3f(child.offset.x, -child.offset.y, child.offset.z), null), part, rot);
      Vector3f.add(vector3f, pos, pos);
    } 
    Vector3f tPos = getPositionOnPart(in, p, rot);
    Vector3f.add(tPos, pos, pos);
    return pos;
  }
  
  public ArrayList<Integer> generateChain(AnimationPart p, ArrayList<Integer> i) {
    i.add(Integer.valueOf(p.type));
    if (p.parent >= 0)
      generateChain(this.parts.get(p.parent), i); 
    return i;
  }
  
  public Vector3f transformPart(Vector3f current, Vector3f target, Vector3f rate) {
    Vector3f newPos = current;
    if (Math.sqrt(((current.x - target.x) * (current.x - target.x))) > (rate.x / 2.0F)) {
      if (current.x > target.x) {
        current.x -= rate.x;
      } else if (current.x < target.x) {
        current.x += rate.x;
      } 
    } else {
      current.x = target.x;
    } 
    if (Math.sqrt(((current.y - target.y) * (current.y - target.y))) > (rate.y / 2.0F)) {
      if (current.y > target.y) {
        current.y -= rate.y;
      } else if (current.y < target.y) {
        current.y += rate.y;
      } 
    } else {
      current.y = target.y;
    } 
    if (Math.sqrt(((current.z - target.z) * (current.z - target.z))) > (rate.z / 2.0F)) {
      if (current.z > target.z) {
        current.z -= rate.z;
      } else if (current.z < target.z) {
        current.z += rate.z;
      } 
    } else {
      current.z = target.z;
    } 
    return newPos;
  }
}
