package com.cxd.enumberview.blades;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

import com.cxd.enumberview.Blade;

/**
 * 刀片[菱形块]
 */
public class Rhombus extends Blade {

    public Rhombus(Rect rect) {
        super(rect);
    }

    /**
     * 计算水平菱形点集合
     * @return
     */
    @Override
    public Point[] convertPointsByHorizontalRhombus(Rect rect){
        Point[] points = new Point[6];

        int h = rect.height() ;
        points[0] = new Point(rect.left,rect.centerY());
        points[1] = new Point(rect.left+h/2,rect.top);
        points[2] = new Point(rect.right-h/2,rect.top);
        points[3] = new Point(rect.right,rect.centerY());
        points[4] = new Point(rect.right-h/2,rect.bottom);
        points[5] = new Point(rect.left+h/2,rect.bottom);

        return points ;
    }

    /**
     * 计算垂直菱形点集合
     * @return
     */
    @Override
    public Point[] convertPointsByVerticalRhombus(Rect rect){
        Point[] points = new Point[6];

        int w = rect.width() ;
        points[0] = new Point(rect.centerX(),rect.top);
        points[1] = new Point(rect.right,rect.top+w/2);
        points[2] = new Point(rect.right,rect.bottom-w/2);
        points[3] = new Point(rect.centerX(),rect.bottom);
        points[4] = new Point(rect.left,rect.bottom-w/2);
        points[5] = new Point(rect.left,rect.top+w/2);

        return points ;
    }

}