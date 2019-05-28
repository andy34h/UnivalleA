package com.univalle.univalle;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.math.BigInteger;

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

        // Creamos un segundo hilo
        new Thread(new Runnable() {
            @Override
            public void run() {
                //region Proceso "largo"
                long initialTime = System.currentTimeMillis();
                String cadena = "";
                for (int i = 0; i < 90000; i++) {
                    cadena += "A";
                }

                long finalTime = System.currentTimeMillis();
                System.out.println("Concatenar String: " + cadena);
                System.out.println("TiempoTotal: " + (finalTime - initialTime));
                //endregion

                // Volvemos al hilo principal
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),"Finalizado",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }).start();

        FactorialTask factorialTask = new FactorialTask();
        factorialTask.execute(new BigInteger("5"));

    }


    public static long factorial(int number) {
        if (number <= 0) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }

    public static BigInteger factorial2(BigInteger number) {
        if (number.equals(new BigInteger("0"))) {
            return new BigInteger("1");
        } else {
            return number.multiply(
                    factorial2(number.add(new BigInteger("-1")))
            );
        }
    }



    class FactorialTask extends AsyncTask<BigInteger,Void,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            Toast.makeText(getApplicationContext(),"Finish",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Boolean doInBackground(BigInteger... bigIntegers) {
            BigInteger fac = factorial2(bigIntegers[0]);
            System.out.println("FAc: "+fac.toString());

            // Prueba
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return true;
        }
    }
}
