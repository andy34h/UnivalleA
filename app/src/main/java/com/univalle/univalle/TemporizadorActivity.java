package com.univalle.univalle;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

public class TemporizadorActivity extends Activity {

    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporizador);

        countDownTimer = new CountDownTimer(20 * 1000, 1 * 1000) {
            @Override
            public void onTick(long l) {
                Log.d("Temporizador", "Tiempo: " + (l / 1000) + " segundos");
            }

            @Override
            public void onFinish() {
                Log.d("Temporizador", "Finalizado");
            }
        };
        countDownTimer.start();
    }
}
