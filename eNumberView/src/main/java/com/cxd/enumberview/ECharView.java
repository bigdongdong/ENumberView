package com.cxd.enumberview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.util.Log;
import android.view.View;

/**
 * 单个数字字符View
 */
@SuppressLint("DrawAllocation")
public class ECharView extends View {
    private final String TAG = "ECharViewTAG" ;
    private int w ;
    private Blade[] blades; //刀片集
    private int[][] chars; //数字集
    private int curChar = -1;

    private int backgroundColor; //背景色
    private int foregroundColor; //前景色

    public ECharView(Context context , int bcolor , int fcolor) {
        super(context);

        this.setWillNotDraw(false);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE,null);

        this.backgroundColor = bcolor ;
        this.foregroundColor = fcolor ;

        /*计算numbers*/
        chars = new int[10][];
        chars[0] = new int[]{0,1,2,4,5,6};
        chars[1] = new int[]{2,5};
        chars[2] = new int[]{0,2,3,4,6};
        chars[3] = new int[]{0,2,3,5,6};
        chars[4] = new int[]{1,2,3,5};
        chars[5] = new int[]{0,1,3,5,6};
        chars[6] = new int[]{0,1,3,4,5,6};
        chars[7] = new int[]{0,2,5};
        chars[8] = new int[]{0,1,2,3,4,5,6};
        chars[9] = new int[]{0,1,2,3,5,6};
    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        final int width = MeasureSpec.getSize(widthMeasureSpec);
//        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (width*1.8f),heightMode);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        if(right != left && w == 0){
            w = right - left ;

            ECharShape ens = new ECharShape(w, backgroundColor);
            blades = ens.getBlades();
            this.setBackground(new ShapeDrawable(ens));
        }

    }

    /**
     * 设置单个数字char
     * @param nChar  [0,9]
     */
    public void set(int nChar){
        this.curChar = nChar ;
        postInvalidate();
    }

    private Paint paint ;
    private Paint getPaint(){
        if(paint == null){
            paint = new Paint();
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setAntiAlias(true);
            paint.setColor(foregroundColor);
        }
        return paint ;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(curChar >= 0 && curChar <= 9){
            for(int p : chars[curChar]){
                canvas.drawPath(blades[p].getPath(),getPaint());
            }
        }
    }
}
