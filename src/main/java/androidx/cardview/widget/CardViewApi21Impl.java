package androidx.cardview.widget;
import r.android.content.Context;
import r.android.content.res.ColorStateList;
import r.android.view.View;
class CardViewApi21Impl implements CardViewImpl {
  public void initialize(  CardViewDelegate cardView,  Context context,  ColorStateList backgroundColor,  float radius,  float elevation,  float maxElevation){
    final RoundRectDrawable background=new RoundRectDrawable(backgroundColor,radius);
    cardView.setCardBackground(background);
    View view=cardView.getCardView();
    //view.setClipToOutline(true);
    view.setElevation(elevation);
    setMaxElevation(cardView,maxElevation);
  }
  public void setRadius(  CardViewDelegate cardView,  float radius){
    getCardBackground(cardView).setRadius(radius);
  }
  public void initStatic(){
  }
  public void setMaxElevation(  CardViewDelegate cardView,  float maxElevation){
    getCardBackground(cardView).setPadding(maxElevation,cardView.getUseCompatPadding(),cardView.getPreventCornerOverlap());
    updatePadding(cardView);
  }
  public float getMaxElevation(  CardViewDelegate cardView){
    return getCardBackground(cardView).getPadding();
  }
  public float getMinWidth(  CardViewDelegate cardView){
    return getRadius(cardView) * 2;
  }
  public float getMinHeight(  CardViewDelegate cardView){
    return getRadius(cardView) * 2;
  }
  public float getRadius(  CardViewDelegate cardView){
    return getCardBackground(cardView).getRadius();
  }
  public void setElevation(  CardViewDelegate cardView,  float elevation){
    cardView.getCardView().setElevation(elevation);
  }
  public float getElevation(  CardViewDelegate cardView){
    return cardView.getCardView().getElevation();
  }
  public void updatePadding(  CardViewDelegate cardView){
    if (!cardView.getUseCompatPadding()) {
      cardView.setShadowPadding(0,0,0,0);
      return;
    }
    float elevation=getMaxElevation(cardView);
    final float radius=getRadius(cardView);
    int hPadding=(int)Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(elevation,radius,cardView.getPreventCornerOverlap()));
    int vPadding=(int)Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(elevation,radius,cardView.getPreventCornerOverlap()));
    cardView.setShadowPadding(hPadding,vPadding,hPadding,vPadding);
  }
  public void onCompatPaddingChanged(  CardViewDelegate cardView){
    setMaxElevation(cardView,getMaxElevation(cardView));
  }
  public void onPreventCornerOverlapChanged(  CardViewDelegate cardView){
    setMaxElevation(cardView,getMaxElevation(cardView));
  }
  public void setBackgroundColor(  CardViewDelegate cardView,  ColorStateList color){
    getCardBackground(cardView).setColor(color);
  }
  public ColorStateList getBackgroundColor(  CardViewDelegate cardView){
    return getCardBackground(cardView).getColor();
  }
  private RoundRectDrawable getCardBackground(  CardViewDelegate cardView){
    return ((RoundRectDrawable)cardView.getCardBackground());
  }
}
