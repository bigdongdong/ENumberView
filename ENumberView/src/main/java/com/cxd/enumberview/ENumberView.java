package com.cxd.enumberview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("DrawAllocation")
public class ENumberView extends ViewGroup {
    private final String TAG = "ENumberViewTAG" ;
    private int W , w;
    private final float spaceRatio = 0.05f ; //数字间的间隔与单数字宽度的比例
    private final int count ;
    private ECharView[] views ;
    private final int bColor ;
    private final int fColor ;

    public ENumberView(Context context) {
        this(context,null);
    }

    public ENumberView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.eNumber);
        bColor = typedArray.getColor(R.styleable.eNumber_backgroundColor,0xFFeaeaea);
        fColor = typedArray.getColor(R.styleable.eNumber_foregroundColor,0xFF111111);
        count = typedArray.getInt(R.styleable.eNumber_count,1);

        this.setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            this.setLayoutDirection(LAYOUT_DIRECTION_LTR);
        }

        this.removeAllViews();
        views = new ECharView[count];
        for (int i = 0; i < count; i++) {
            ECharView view = new ECharView(getContext(),bColor,fColor);
            views[i] = view ;
            this.addView(view);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(0 != getMeasuredWidth()){
            W = getMeasuredWidth();
            //count*w + (count-1)*(w*spaceRatio) = W
            w = (int) (W / (count + (count-1)*spaceRatio));
        }
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (w*1.8f),heightMode);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        for (int i = 0; i < count; i++) {
            views[i].setLayoutParams(new LayoutParams(w, (int) (w*1.8f)));

            final int left = (int) (w*i + w*spaceRatio*i);
            views[i].layout(left,0,left+w, (int) (w*1.8f));
        }
    }

    public void set(long number){
        set(number,false);
    }

    /**
     * @param number
     * @param isZero 空位是否用0代替
     */
    public void set(long number ,boolean isZero){
        String str = String.valueOf(number);
        int[] numbers = new int[str.length()];
        for (int i = 0; i < numbers.length; i++) {
            char c = str.charAt(i);
            numbers[i] = Integer.parseInt(String.valueOf(c));
        }
        if(numbers.length <= count){
            int start = 0 ;
            if(numbers.length < count){
                start = count - numbers.length ;
            }

            for (int i = 0; i < count; i++) {
                ECharView view = views[i];
                if(i < start){
                    view.set(isZero?0:-1);
                }else{
                    view.set(numbers[i-start]);
                }
            }
        }

    }
}
