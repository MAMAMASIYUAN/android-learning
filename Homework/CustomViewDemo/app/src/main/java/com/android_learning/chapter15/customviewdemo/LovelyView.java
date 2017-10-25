package com.android_learning.chapter15.customviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;


public class LovelyView  extends View {
    //circle and text colors
    private int circleCol, labelCol;
    //label text
    private String circleText;
    //paint for drawing custom view
    private Paint ovalPaint;
    private Context context;
    private AttributeSet attrs;

    public LovelyView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;
    }

    @Override
    public void onDraw(Canvas canvas) {
        ovalPaint = new Paint();
//        circleText = "hello";
        circleCol = Color.parseColor("#000000");
        labelCol = Color.parseColor("#ffff66");

        int viewWidthHalf = this.getMeasuredWidth()/2;
        int viewHeightHalf = this.getMeasuredHeight()/2;

        int radius = 0;
        if(viewWidthHalf>viewHeightHalf)
            radius=viewHeightHalf-10;
        else
            radius=viewWidthHalf-10;

//        circlePaint.setStyle(Style.STROKE);
//        circlePaint.setAntiAlias(true);
//
//        circlePaint.setColor(circleCol);
        ovalPaint.setStyle(Style.STROKE);
        ovalPaint.setAntiAlias(true);

        ovalPaint.setColor(circleCol);

//        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);
        canvas.drawOval(viewWidthHalf - 400, viewHeightHalf - 300, viewWidthHalf + 400, viewHeightHalf + 300, ovalPaint);

        ovalPaint.setColor(labelCol);
        ovalPaint.setStyle(Style.FILL);
        ovalPaint.setAntiAlias(true);

        canvas.drawCircle(viewWidthHalf + 100, viewHeightHalf, radius - 350, ovalPaint);
    }

    public int getCircleColor(){
        return circleCol;
    }

    public int getLabelColor(){
        return labelCol;
    }

    public String getLabelText(){
        return circleText;
    }
    public void setCircleColor(int newColor){
        //update the instance variable
        circleCol=newColor;
        //redraw the view
        invalidate();
        requestLayout();
    }
    public void setLabelColor(int newColor){
        //update the instance variable
        labelCol=newColor;
        //redraw the view
        invalidate();
        requestLayout();
    }

    public void setLabelText(String newLabel){
        //update the instance variable
        circleText=newLabel;
        //redraw the view
        invalidate();
        requestLayout();
    }
}
