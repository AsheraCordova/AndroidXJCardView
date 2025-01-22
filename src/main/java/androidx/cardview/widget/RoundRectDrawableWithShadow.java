package androidx.cardview.widget;
import r.android.graphics.drawable.Drawable;
class RoundRectDrawableWithShadow extends Drawable {
  private static final double COS_45=Math.cos(Math.toRadians(45));
  private static final float SHADOW_MULTIPLIER=1.5f;
  static float calculateVerticalPadding(  float maxShadowSize,  float cornerRadius,  boolean addPaddingForCorners){
    if (addPaddingForCorners) {
      return (float)(maxShadowSize * SHADOW_MULTIPLIER + (1 - COS_45) * cornerRadius);
    }
 else {
      return maxShadowSize * SHADOW_MULTIPLIER;
    }
  }
  static float calculateHorizontalPadding(  float maxShadowSize,  float cornerRadius,  boolean addPaddingForCorners){
    if (addPaddingForCorners) {
      return (float)(maxShadowSize + (1 - COS_45) * cornerRadius);
    }
 else {
      return maxShadowSize;
    }
  }
}
