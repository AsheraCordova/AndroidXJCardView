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
import r.android.graphics.Rect;
import r.android.graphics.drawable.Drawable;
import r.android.view.View;
import r.android.widget.FrameLayout;
public class CardView extends FrameLayout {
  private static final CardViewImpl IMPL;
  private boolean mCompatPadding;
  private boolean mPreventCornerOverlap;
  int mUserSetMinWidth, mUserSetMinHeight;
  final Rect mContentPadding=new Rect();
  final Rect mShadowBounds=new Rect();
  public void setPadding(  int left,  int top,  int right,  int bottom){
  }
  public void setPaddingRelative(  int start,  int top,  int end,  int bottom){
  }
  public boolean getUseCompatPadding(){
    return mCompatPadding;
  }
  public void setUseCompatPadding(  boolean useCompatPadding){
    if (mCompatPadding != useCompatPadding) {
      mCompatPadding=useCompatPadding;
      IMPL.onCompatPaddingChanged(mCardViewDelegate);
    }
  }
  public void setContentPadding(  int left,  int top,  int right,  int bottom){
    mContentPadding.set(left,top,right,bottom);
    IMPL.updatePadding(mCardViewDelegate);
  }
  protected void onMeasure(  int widthMeasureSpec,  int heightMeasureSpec){
    if (!(IMPL instanceof CardViewApi21Impl)) {
      final int widthMode=MeasureSpec.getMode(widthMeasureSpec);
switch (widthMode) {
case MeasureSpec.EXACTLY:
case MeasureSpec.AT_MOST:
        final int minWidth=(int)Math.ceil(IMPL.getMinWidth(mCardViewDelegate));
      widthMeasureSpec=MeasureSpec.makeMeasureSpec(Math.max(minWidth,MeasureSpec.getSize(widthMeasureSpec)),widthMode);
    break;
case MeasureSpec.UNSPECIFIED:
  break;
}
final int heightMode=MeasureSpec.getMode(heightMeasureSpec);
switch (heightMode) {
case MeasureSpec.EXACTLY:
case MeasureSpec.AT_MOST:
final int minHeight=(int)Math.ceil(IMPL.getMinHeight(mCardViewDelegate));
heightMeasureSpec=MeasureSpec.makeMeasureSpec(Math.max(minHeight,MeasureSpec.getSize(heightMeasureSpec)),heightMode);
break;
case MeasureSpec.UNSPECIFIED:
break;
}
super.onMeasure(widthMeasureSpec,heightMeasureSpec);
}
 else {
super.onMeasure(widthMeasureSpec,heightMeasureSpec);
}
}
public void setMinimumWidth(int minWidth){
mUserSetMinWidth=minWidth;
super.setMinimumWidth(minWidth);
}
public void setMinimumHeight(int minHeight){
mUserSetMinHeight=minHeight;
super.setMinimumHeight(minHeight);
}
public void setCardBackgroundColor(int color){
IMPL.setBackgroundColor(mCardViewDelegate,ColorStateList.valueOf(color));
}
public void setCardBackgroundColor(ColorStateList color){
IMPL.setBackgroundColor(mCardViewDelegate,color);setBackgroundColor(color);
}
public ColorStateList getCardBackgroundColor(){
return IMPL.getBackgroundColor(mCardViewDelegate);
}
public int getContentPaddingLeft(){
return mContentPadding.left;
}
public int getContentPaddingRight(){
return mContentPadding.right;
}
public int getContentPaddingTop(){
return mContentPadding.top;
}
public int getContentPaddingBottom(){
return mContentPadding.bottom;
}
public void setRadius(float radius){
IMPL.setRadius(mCardViewDelegate,radius);setMyAttribute("cornerRadius", radius);
}
public float getRadius(){
return IMPL.getRadius(mCardViewDelegate);
}
public void setCardElevation(float elevation){
IMPL.setElevation(mCardViewDelegate,elevation);setMyAttribute("shadowOffset", elevation * Math.tan(Math.toRadians(elevation)));
}
public float getCardElevation(){
return IMPL.getElevation(mCardViewDelegate);
}
public void setMaxCardElevation(float maxElevation){
IMPL.setMaxElevation(mCardViewDelegate,maxElevation);
}
public float getMaxCardElevation(){
return IMPL.getMaxElevation(mCardViewDelegate);
}
public boolean getPreventCornerOverlap(){
return mPreventCornerOverlap;
}
public void setPreventCornerOverlap(boolean preventCornerOverlap){
if (preventCornerOverlap != mPreventCornerOverlap) {
mPreventCornerOverlap=preventCornerOverlap;
IMPL.onPreventCornerOverlapChanged(mCardViewDelegate);
}
}
private final CardViewDelegate mCardViewDelegate=new CardViewDelegate(){
private Drawable mCardBackground;
public void setCardBackground(Drawable drawable){
mCardBackground=drawable;
setBackgroundDrawable(drawable);
}
public boolean getUseCompatPadding(){
return CardView.this.getUseCompatPadding();
}
public boolean getPreventCornerOverlap(){
return CardView.this.getPreventCornerOverlap();
}
public void setShadowPadding(int left,int top,int right,int bottom){
mShadowBounds.set(left,top,right,bottom);
CardView.super.setPadding(left + mContentPadding.left,top + mContentPadding.top,right + mContentPadding.right,bottom + mContentPadding.bottom);
}
public void setMinWidthHeightInternal(int width,int height){
if (width > mUserSetMinWidth) {
CardView.super.setMinimumWidth(width);
}
if (height > mUserSetMinHeight) {
CardView.super.setMinimumHeight(height);
}
}
public Drawable getCardBackground(){
return mCardBackground;
}
public View getCardView(){
return CardView.this;
}
}
;
public void initCardView(){
ColorStateList backgroundColor=ColorStateList.valueOf(r.android.graphics.Color.WHITE);
float radius=com.ashera.widget.PluginInvoker.convertDpToPixel("10dp");
float elevation=0;
float maxElevation=0;
mCompatPadding=false;
mPreventCornerOverlap=true;
int defaultPadding=0;
mContentPadding.left=defaultPadding;
mContentPadding.top=defaultPadding;
mContentPadding.right=defaultPadding;
mContentPadding.bottom=defaultPadding;
if (elevation > maxElevation) {
maxElevation=elevation;
}
mUserSetMinWidth=0;
mUserSetMinHeight=0;
IMPL.initialize(mCardViewDelegate,getContext(),backgroundColor,radius,elevation,maxElevation);
setRadius(radius);
}
static{
IMPL=new CardViewApi21Impl();
IMPL.initStatic();
}
private void setBackgroundDrawable(Drawable drawable){
setMyAttribute("background",drawable);
}
private void setBackgroundColor(ColorStateList color){
r.android.graphics.drawable.ColorDrawable value=new r.android.graphics.drawable.ColorDrawable();
value.setDrawable(color);
setMyAttribute("background",value);
}
}
