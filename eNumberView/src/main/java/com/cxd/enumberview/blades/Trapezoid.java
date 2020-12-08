package com.cxd.enumberview.blades;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;

import com.cxd.enumberview.Blade;

/**
 * 刀片[梯形块]
 */
public class Trapezoid extends Blade {
    public Trapezoid(Rect rect) {
        super(rect);
    }

    @Override
    public Point[] convertPointsByHorizontalRhombus(Rect rect) {
        return new Point[0];
    }

    @Override
    public Point[] convertPointsByVerticalRhombus(Rect rect) {
        return new Point[0];
    }
}
