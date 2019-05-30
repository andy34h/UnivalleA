package com.univalle.univalle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CanvasActivity extends AppCompatActivity {

    MyCanvas myCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        myCanvas = findViewById(R.id.vFrame);


    }

    public class MyCanvas extends View {
        private Paint mPaint;

        public MyCanvas(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            // and we set a new Paint with the desired attributes
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setColor(Color.BLACK);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(100, 100, 30, mPaint);
        }

        @Override
        public void setOnTouchListener(OnTouchListener l) {
            super.setOnTouchListener(l);
        }
    }
}
