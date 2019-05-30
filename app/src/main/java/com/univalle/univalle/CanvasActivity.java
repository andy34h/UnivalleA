package com.univalle.univalle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class CanvasActivity extends AppCompatActivity {

    MyCanvas myCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        myCanvas = findViewById(R.id.vFrame);


    }

    public static class MyCanvas extends View {
        private Paint mPaint;

        public MyCanvas(Context context) {
            super(context);
        }

        public MyCanvas(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            System.out.println("-->" + canvas.getWidth());
            System.out.println("-->" + canvas.getHeight());
            mPaint = new Paint();
            //mPaint.setAntiAlias(true);
            mPaint.setColor(Color.BLUE);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(10f);

            float maxW = canvas.getWidth();
            float maxH = canvas.getHeight();

            float offset = 10;
            for (int i = 0; i < maxW; i += offset) {
                canvas.drawLine(
                        maxW - i,
                        0,
                        0,
                        i,
                        mPaint);
            }

        }

        @Override
        public void setOnTouchListener(OnTouchListener l) {
            super.setOnTouchListener(l);
        }
    }
}
