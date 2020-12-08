package com.cxd.enumberview;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * 刀片
 */
public abstract class Blade {

    private Point[] points ;
    private Path path ;

    public Blade(Rect rect) {
        int w = rect.width() ;
        int h = rect.height() ;

        points = w > h ? convertPointsByHorizontalRhombus(rect) : convertPointsByVerticalRhombus(rect) ;
    }

    /**
     * 获取水平方向刀片点集合
     * @param rect 刀片矩形
     * @return
     */
    public abstract Point[] convertPointsByHorizontalRhombus(Rect rect);

    /**
     * 获取垂直方向刀片点集合
     * @param rect 刀片矩形
     * @return
     */
    public abstract Point[] convertPointsByVerticalRhombus(Rect rect);

    /**
     * 获取刀片path
     * @return
     */
    public Path getPath(){
        if(path == null){
            path = new Path();
            Point p = points[0];
            path.moveTo(p.x,p.y);
            for (int i = 1; i < points.length; i++) {
                p = points[i];
                path.lineTo(p.x,p.y);

                if(i == points.length-1){
                    path.close();
                }
            }
        }
        return path ;
    }
}
