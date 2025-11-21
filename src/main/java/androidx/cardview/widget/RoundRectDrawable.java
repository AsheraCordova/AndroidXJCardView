//start - license
/*
 * Copyright (c) 2025 Ashera Cordova
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
//end - license
/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package androidx.cardview.widget;
import r.android.content.res.ColorStateList;
import r.android.graphics.Color;
import r.android.graphics.Rect;
import r.android.graphics.RectF;
import r.android.graphics.drawable.Drawable;
class RoundRectDrawable extends Drawable {
  private float mRadius;
  private final RectF mBoundsF;
  private final Rect mBoundsI;
  private float mPadding;
  private boolean mInsetForPadding=false;
  private boolean mInsetForRadius=true;
  private ColorStateList mBackground;
  RoundRectDrawable(  ColorStateList backgroundColor,  float radius){
    mRadius=radius;
    //mPaint=new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
    setBackground(backgroundColor);
    mBoundsF=new RectF();
    mBoundsI=new Rect();
  }
  private void setBackground(  ColorStateList color){
    mBackground=(color == null) ? ColorStateList.valueOf(Color.TRANSPARENT) : color;
    setDrawable(mBackground);//mPaint.setColor(mBackground.getColorForState(getState(),mBackground.getDefaultColor()));
  }
  void setPadding(  float padding,  boolean insetForPadding,  boolean insetForRadius){
    if (padding == mPadding && mInsetForPadding == insetForPadding && mInsetForRadius == insetForRadius) {
      return;
    }
    mPadding=padding;
    mInsetForPadding=insetForPadding;
    mInsetForRadius=insetForRadius;
    updateBounds(null);
    invalidateSelf();
  }
  float getPadding(){
    return mPadding;
  }
  private void updateBounds(  Rect bounds){
    if (bounds == null) {
      bounds=getBounds();
    }
    mBoundsF.set(bounds.left,bounds.top,bounds.right,bounds.bottom);
    mBoundsI.set(bounds);
    if (mInsetForPadding) {
      float vInset=RoundRectDrawableWithShadow.calculateVerticalPadding(mPadding,mRadius,mInsetForRadius);
      float hInset=RoundRectDrawableWithShadow.calculateHorizontalPadding(mPadding,mRadius,mInsetForRadius);
      mBoundsI.inset((int)Math.ceil(hInset),(int)Math.ceil(vInset));
      mBoundsF.set(mBoundsI);
    }
  }
  void setRadius(  float radius){
    if (radius == mRadius) {
      return;
    }
    mRadius=radius;
    updateBounds(null);
    invalidateSelf();
  }
  public float getRadius(){
    return mRadius;
  }
  public void setColor(  ColorStateList color){
    setBackground(color);
    invalidateSelf();
  }
  public ColorStateList getColor(){
    return mBackground;
  }
}
