package com.univalle.univalle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class EventActivity extends AppCompatActivity {

    Button btnOnClick;
    Button btnOnLongClick;
    Button btnOnTouch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        btnOnClick = findViewById(R.id.btnOnClick);
        btnOnLongClick = findViewById(R.id.btnOnLongClick);
        btnOnTouch = findViewById(R.id.btnOnTouch);

        btnOnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnOnLongClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });

        btnOnTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                return false;
            }
        });



    }
}
