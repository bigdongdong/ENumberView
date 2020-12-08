package com.cxd.enumberview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.shapes.Shape;

import com.cxd.enumberview.blades.Rhombus;

/**
 * {@link ECharView} 's background shape
 * 内部维护一个{@link Blade}数组
 * 可以通过{@link ECharShape#getBlades()}来获取
 */
public class ECharShape extends Shape {
    private int w,h;
    private int color ;
    private int thickness; //刀片的厚度[默认:W*0.2f]
    private int interval; //刀片间距离[默认:thickness/10]
    private Blade[] blades;
    private Rect[] rects ;

    public ECharShape(int w , int color) {
        this.w = w;
        this.color = color;

        thickness = (int) (w * 0.2f);
        h = w + (w-thickness) ;
        interval = thickness / 10 ;

        /*计算八个矩形位置*/
        Rect rect ;
        rects = new Rect[7];
        final int wl = w-thickness ; //横菱形的长
        final int hl = (h-thickness)/2 ; //竖菱形的长

        /*0*/
        rect = new Rect(thickness/2,0,thickness/2+wl,thickness);
        rects[0] = rect ;
        /*1*/
        rect = new Rect(0,thickness/2,thickness,thickness/2+hl);
        rects[1] = rect ;
        /*2*/
        rect = new Rect(w-thickness,thickness/2,w,thickness/2+hl);
        rects[2] = rect ;
        /*3*/
        rect = new Rect(thickness/2,hl,w-thickness/2,hl+thickness);
        rects[3] = rect ;
        /*4*/
        rect = new Rect(0,h/2,thickness,h-thickness/2);
        rects[4] = rect ;
        /*5*/
        rect = new Rect(w-thickness,h/2,w,h-thickness/2);
        rects[5] = rect ;
        /*6*/
        rect = new Rect(thickness/2,h-thickness,w-thickness/2,h);
        rects[6] = rect ;

        /*进行间距缩进*/
        final int inset = interval ;
        for(Rect r : rects){
            r.inset(inset,inset);
        }

        /*计算刀片集*/
        computeBlades();
    }

    /**
     * 返回刀片集
     * @return
     */
    public Blade[] getBlades(){
        return blades;
    }

    /**
     * 计算刀片集
     */
    private void computeBlades(){
        if(blades == null){
            blades = new Blade[7];
            for (int i = 0; i < 7; i++) {
                Rect rect = rects[i];
                blades[i] = new Rhombus(rect);
            }
        }
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        paint.setColor(color);

        for (Blade blase : blades){
            Path path = blase.getPath();
            canvas.drawPath(path,paint);
        }
    }
}
