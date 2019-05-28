package com.univalle.univalle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        long initialTime = System.currentTimeMillis();
        long fac = factorial(5);
        long finalTime = System.currentTimeMillis();

        System.out.println("Factorial: " + fac);
        System.out.println("TiempoTotal: " + (finalTime - initialTime));
    }


    public static long factorial(int number) {
        if (number <= 0) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
