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
