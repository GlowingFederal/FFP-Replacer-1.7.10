package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;

public class ModelGun extends ModelBase {
  public ModelRendererTurbo[] gunModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] backpackModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] defaultBarrelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] defaultScopeModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] defaultStockModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] defaultGripModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] defaultGadgetModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] ammoModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] fullammoModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] revolverBarrelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] revolver2BarrelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] breakActionModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] altbreakActionModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] slideModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] altslideModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] pumpModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] chargeModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] altpumpModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] minigunBarrelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leverActionModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] hammerModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] althammerModel = new ModelRendererTurbo[0];
  
  public Vector3f minigunBarrelOrigin = new Vector3f();
  
  public Vector3f barrelAttachPoint = new Vector3f();
  
  public Vector3f scopeAttachPoint = new Vector3f();
  
  public Vector3f stockAttachPoint = new Vector3f();
  
  public Vector3f gripAttachPoint = new Vector3f();
  
  public Vector3f gadgetAttachPoint = new Vector3f();
  
  public Vector3f slideAttachPoint = new Vector3f();
  
  public Vector3f pumpAttachPoint = new Vector3f();
  
  public Vector3f accessoryAttachPoint = new Vector3f();
  
  public Vector3f defaultBarrelFlashPoint = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f muzzleFlashPoint = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public boolean hasFlash = false;
  
  public boolean hasArms = false;
  
  public Vector3f leftArmPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f leftArmRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f leftArmScale = new Vector3f(1.0F, 1.0F, 1.0F);
  
  public Vector3f rightArmPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f rightArmRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f rightArmScale = new Vector3f(1.0F, 1.0F, 1.0F);
  
  public Vector3f rightArmReloadPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f rightArmReloadRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f leftArmReloadPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f leftArmReloadRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f rightArmChargePos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f rightArmChargeRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f leftArmChargePos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f leftArmChargeRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f stagedrightArmReloadPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f stagedrightArmReloadRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f stagedleftArmReloadPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f stagedleftArmReloadRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public boolean rightHandAmmo = false;
  
  public boolean leftHandAmmo = false;
  
  public float gunSlideDistance = 0.25F;
  
  public float altgunSlideDistance = 0.25F;
  
  public float RecoilSlideDistance = 0.125F;
  
  public float RotateSlideDistance = -3.0F;
  
  public float ShakeDistance = 0.0F;
  
  public float recoilAmount = 0.33F;
  
  public Vector3f casingAnimDistance = new Vector3f(0.0F, 0.0F, 16.0F);
  
  public Vector3f casingAnimSpread = new Vector3f(2.0F, 4.0F, 4.0F);
  
  public int casingAnimTime = 20;
  
  public Vector3f casingRotateVector = new Vector3f(0.1F, 1.0F, 0.1F);
  
  public Vector3f casingAttachPoint = new Vector3f();
  
  public int casingDelay = 0;
  
  public float caseScale = 1.0F;
  
  public float flashScale = 1.0F;
  
  public float chargeHandleDistance = 0.0F;
  
  public int chargeDelay = 0;
  
  public int chargeDelayAfterReload = 0;
  
  public int chargeTime = 1;
  
  public ModelRendererTurbo[] bulletCounterModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[][] advBulletCounterModel = new ModelRendererTurbo[0][0];
  
  public boolean countOnRightHandSide = false;
  
  public boolean isBulletCounterActive;
  
  public boolean isAdvBulletCounterActive = false;
  
  public EnumAnimationType animationType = EnumAnimationType.NONE;
  
  public EnumMeleeAnimation meleeAnimation = EnumMeleeAnimation.DEFAULT;
  
  public float tiltGunTime = 0.15F;
  
  public float unloadClipTime = 0.35F;
  
  public float loadClipTime = 0.35F;
  
  public float untiltGunTime = 0.15F;
  
  public boolean scopeIsOnSlide = false;
  
  public boolean scopeIsOnBreakAction = false;
  
  public float numBulletsInReloadAnimation = 1.0F;
  
  public int pumpDelay = 0;
  
  public int pumpDelayAfterReload = 0;
  
  public int pumpTime = 1;
  
  public int hammerDelay = 0;
  
  public float pumpHandleDistance = 0.25F;
  
  public float endLoadedAmmoDistance = 1.0F;
  
  public float breakActionAmmoDistance = 1.0F;
  
  public boolean gripIsOnPump = false;
  
  public boolean gadgetIsOnPump = false;
  
  public Vector3f barrelBreakPoint = new Vector3f();
  
  public Vector3f altbarrelBreakPoint = new Vector3f();
  
  public float revolverFlipAngle = 15.0F;
  
  public float revolver2FlipAngle = 15.0F;
  
  public Vector3f revolverFlipPoint = new Vector3f();
  
  public Vector3f revolver2FlipPoint = new Vector3f();
  
  public float breakAngle = 45.0F;
  
  public float altbreakAngle = 45.0F;
  
  public boolean spinningCocking = false;
  
  public Vector3f spinPoint = new Vector3f();
  
  public Vector3f hammerSpinPoint = new Vector3f();
  
  public Vector3f althammerSpinPoint = new Vector3f();
  
  public float hammerAngle = 75.0F;
  
  public float althammerAngle = 75.0F;
  
  public boolean isSingleAction = false;
  
  public boolean slideLockOnEmpty = false;
  
  public boolean lefthandPump = false;
  
  public boolean righthandPump = false;
  
  public boolean rightHandCharge = false;
  
  public boolean leftHandCharge = false;
  
  public boolean rightHandBolt = false;
  
  public boolean leftHandBolt = false;
  
  public float pumpModifier = 4.0F;
  
  public Vector3f chargeModifier = new Vector3f(8.0F, 4.0F, 4.0F);
  
  public float gunOffset = 0.0F;
  
  public float crouchZoom = 0.0F;
  
  public boolean fancyStance = false;
  
  public Vector3f stanceTranslate = new Vector3f();
  
  public Vector3f stanceRotate = new Vector3f();
  
  public float rotateGunVertical = 0.0F;
  
  public float rotateGunHorizontal = 0.0F;
  
  public float tiltGun = 0.0F;
  
  public Vector3f translateGun = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public float rotateClipVertical = 0.0F;
  
  public float stagedrotateClipVertical = 0.0F;
  
  public float rotateClipHorizontal = 0.0F;
  
  public float stagedrotateClipHorizontal = 0.0F;
  
  public float tiltClip = 0.0F;
  
  public float stagedtiltClip = 0.0F;
  
  public Vector3f translateClip = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f stagedtranslateClip = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public boolean stagedReload = false;
  
  public Vector3f thirdPersonOffset = new Vector3f();
  
  public Vector3f itemFrameOffset = new Vector3f();
  
  private static float lightmapLastX;
  
  private static float lightmapLastY;
  
  private static boolean optifineBreak = false;
  
  public static void glowOn() {
    glowOn(15);
  }
  
  public static void glowOn(int glow) {
    GL11.glPushAttrib(64);
    GL11.glEnable(3042);
    GL11.glBlendFunc(1, 1);
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
    GL11.glEnable(2896);
    if (!optifineBreak)
      OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, lightmapLastX, lightmapLastY); 
    GL11.glPopAttrib();
  }
  
  public void renderGun(float f) {
    render(this.gunModel, f);
  }
  
  public void renderSlide(float f) {
    render(this.slideModel, f);
  }
  
  public void renderaltSlide(float f) {
    render(this.altslideModel, f);
  }
  
  public void renderPump(float f) {
    render(this.pumpModel, f);
  }
  
  public void renderaltPump(float f) {
    render(this.altpumpModel, f);
  }
  
  public void renderCharge(float f) {
    render(this.chargeModel, f);
  }
  
  public void renderDefaultScope(float f) {
    render(this.defaultScopeModel, f);
  }
  
  public void renderDefaultBarrel(float f) {
    render(this.defaultBarrelModel, f);
  }
  
  public void renderDefaultStock(float f) {
    render(this.defaultStockModel, f);
  }
  
  public void renderDefaultGrip(float f) {
    render(this.defaultGripModel, f);
  }
  
  public void renderDefaultGadget(float f) {
    render(this.defaultGadgetModel, f);
  }
  
  public void renderAmmo(float f) {
    render(this.ammoModel, f);
  }
  
  public void renderfullAmmo(float f) {
    render(this.fullammoModel, f);
  }
  
  public void renderMinigunBarrel(float f) {
    render(this.minigunBarrelModel, f);
  }
  
  public void renderRevolverBarrel(float f) {
    render(this.revolverBarrelModel, f);
  }
  
  public void renderRevolver2Barrel(float f) {
    render(this.revolver2BarrelModel, f);
  }
  
  public void renderBreakAction(float f) {
    render(this.breakActionModel, f);
  }
  
  public void renderaltBreakAction(float f) {
    render(this.altbreakActionModel, f);
  }
  
  public void renderHammer(float f) {
    render(this.hammerModel, f);
  }
  
  public void renderaltHammer(float f) {
    render(this.althammerModel, f);
  }
  
  public void renderBulletCounter(float f, int k) {
    for (int i = 0; i < this.bulletCounterModel.length; i++) {
      if (i == k) {
        glowOn();
        this.bulletCounterModel[i].func_78785_a(f);
        glowOff();
      } 
    } 
  }
  
  public void renderAdvBulletCounter(float f, int k, boolean rhs) {
    char[] count = String.valueOf(k).toCharArray();
    int[] digits = new int[count.length];
    int i;
    for (i = 0; i < count.length; i++) {
      if (!rhs) {
        digits[i] = count[i] - 48;
      } else {
        digits[digits.length - 1 - i] = count[i] - 48;
      } 
    } 
    for (i = 0; i < digits.length; i++) {
      for (int j = 0; j < (this.advBulletCounterModel[i]).length; j++) {
        if (digits[i] == j) {
          glowOn();
          this.advBulletCounterModel[i][j].func_78785_a(f);
          glowOff();
        } 
      } 
    } 
  }
  
  protected void render(ModelRendererTurbo[] models, float f) {
    for (ModelRendererTurbo model : models) {
      if (model != null)
        model.func_78785_a(f); 
    } 
  }
  
  public void flipAll() {
    flip(this.gunModel);
    flip(this.defaultBarrelModel);
    flip(this.defaultScopeModel);
    flip(this.defaultStockModel);
    flip(this.defaultGripModel);
    flip(this.defaultGadgetModel);
    flip(this.ammoModel);
    flip(this.fullammoModel);
    flip(this.slideModel);
    flip(this.altslideModel);
    flip(this.pumpModel);
    flip(this.altpumpModel);
    flip(this.chargeModel);
    flip(this.minigunBarrelModel);
    flip(this.revolverBarrelModel);
    flip(this.revolver2BarrelModel);
    flip(this.breakActionModel);
    flip(this.altbreakActionModel);
    flip(this.hammerModel);
    flip(this.althammerModel);
    flip(this.bulletCounterModel);
    for (ModelRendererTurbo[] mod : this.advBulletCounterModel)
      flip(mod); 
  }
  
  protected void flip(ModelRendererTurbo[] model) {
    for (ModelRendererTurbo part : model) {
      part.doMirror(false, true, true);
      part.func_78793_a(part.field_78800_c, -part.field_78797_d, -part.field_78798_e);
    } 
  }
  
  public void translateAll(float x, float y, float z) {
    translate(this.gunModel, x, y, z);
    translate(this.defaultBarrelModel, x, y, z);
    translate(this.defaultScopeModel, x, y, z);
    translate(this.defaultStockModel, x, y, z);
    translate(this.defaultGripModel, x, y, z);
    translate(this.defaultGadgetModel, x, y, z);
    translate(this.ammoModel, x, y, z);
    translate(this.fullammoModel, x, y, z);
    translate(this.slideModel, x, y, z);
    translate(this.altslideModel, x, y, z);
    translate(this.pumpModel, x, y, z);
    translate(this.altpumpModel, x, y, z);
    translate(this.chargeModel, x, y, z);
    translate(this.minigunBarrelModel, x, y, z);
    translate(this.revolverBarrelModel, x, y, z);
    translate(this.revolver2BarrelModel, x, y, z);
    translate(this.breakActionModel, x, y, z);
    translate(this.altbreakActionModel, x, y, z);
    translate(this.hammerModel, x, y, z);
    translate(this.althammerModel, x, y, z);
    translate(this.bulletCounterModel, x, y, z);
    for (ModelRendererTurbo[] mod : this.advBulletCounterModel)
      translate(mod, x, y, z); 
  }
  
  protected void translate(ModelRendererTurbo[] model, float x, float y, float z) {
    for (ModelRendererTurbo mod : model) {
      mod.field_78800_c += x;
      mod.field_78797_d += y;
      mod.field_78798_e += z;
    } 
  }
}
