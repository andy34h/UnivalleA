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
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class CanvasActivity extends AppCompatActivity {

    MyCanvas myCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        myCanvas = findViewById(R.id.vFrame);
        Button btn = findViewById(R.id.color);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });



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
            Random random = new Random();
            int maxX = canvas.getWidth();
            int maxY = canvas.getHeight();
            float centerX = maxX / 10;
            float centerY = maxY / 10;
            Paint mPaint = new Paint();
            mPaint.setColor(Color.RED);
            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);


            int q=0;
            int AUX=1;
            int c2=1;
            for (int j=0;j<maxY;j+=centerY)
            {
                for (int i = 0; i < maxX; i += centerX) {
                    if (AUX % 2 == 0) {
                        mPaint.setColor(Color.WHITE);
                        canvas.drawRect(i, j, centerX + i, centerY+j, mPaint);
                        AUX = AUX + 1;
                    } else {

                        int val1=random.nextInt(255);
                        int val2=random.nextInt(255);
                        int val3=random.nextInt(255);
                        mPaint.setColor(Color.rgb(val1,val2,val3));
                        //mPaint.setColor(Color.BLACK);
                        canvas.drawRect(i, j, centerX + i, centerY+j, mPaint);
                        AUX = AUX + 1;
                    }
                }
                AUX=AUX+1;
            }




            System.out.println("-->" + canvas.getWidth());
            System.out.println("-->" + canvas.getHeight());
            mPaint = new Paint();
            //mPaint.setAntiAlias(true);
            mPaint.setColor(Color.BLUE);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(10f);
            float maxW = getWidth();
            float maxH =getHeight();

          //  mPaint.setColor(Color.RED);
            mPaint.setColor(Color.BLUE);
            /*canvas.drawLine(50,0,50,1000, mPaint);
            canvas.drawLine(260,0,260,1000, mPaint);
            canvas.drawLine(460,0,460,1000, mPaint);
            canvas.drawLine(667,0,667,1000, mPaint);
            canvas.drawLine(0,50,1000,50, mPaint);
            canvas.drawLine(0,250,1000,250, mPaint);
            canvas.drawLine(0,460,1000,460, mPaint);
            canvas.drawLine(0,660,1000,660, mPaint);
            canvas.drawLine(0,860,1000,860, mPaint);
            canvas.drawLine(0,1060,1000,1060, mPaint);
            mPaint.setColor(Color.WHITE);
            canvas.drawLine(100,100,100,100, mPaint);*/



            float offset = 25;
            int c=0;
            for (int i = 0; i < maxW; i += offset) {
                canvas.drawLine(
                        maxW-i ,
                        0,
                        0,
                        i,
                        mPaint);
                c++;
                if(c%2!=0){ mPaint.setColor(Color.BLUE);}
                else{ mPaint.setColor(Color.BLACK);}
            }

            c=0;
            for (int i = 0; i < maxW; i += offset) {
                canvas.drawLine(
                        i ,
                        0,
                        maxW,
                        i,
                        mPaint);
                c++;
                if(c%2!=0){ mPaint.setColor(Color.BLUE);}
                else{ mPaint.setColor(Color.BLACK);}
            }
            c=0;
            for (int i = 0; i < maxW; i += offset) {
                canvas.drawLine(
                        i
                        ,maxH,
                        maxW,

                        maxH-i,
                        mPaint);
                c++;
                if(c%2!=0){ mPaint.setColor(Color.BLUE);}
                else{ mPaint.setColor(Color.BLACK);}
            }
            c=0;
            for (int i = 0; i <= maxW; i += offset) {
                canvas.drawLine(
                        maxW-i
                        ,maxH,
                        0,
                        maxH-i,
                        mPaint);
                c++;
                if(c%2!=0){ mPaint.setColor(Color.BLUE);}
                else{ mPaint.setColor(Color.BLACK);}
            }







        }

        @Override
        public void setOnTouchListener(OnTouchListener l) {
            super.setOnTouchListener(l);
        }
    }
}
