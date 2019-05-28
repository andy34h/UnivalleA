package com.univalle.univalle;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        long initialTime = System.currentTimeMillis();
//        long fac = ThreadActivity.factorial(25);
        BigInteger fac2 = ThreadActivity.factorial2(new BigInteger("1001"));
        long finalTime = System.currentTimeMillis();

        System.out.println("Factorial: " + fac2.toString());
        System.out.println("TiempoTotal: " + (finalTime - initialTime));

        initialTime = System.currentTimeMillis();
        String cadena = "";
        for (int i = 0; i < 90000; i++) {
            cadena += "A";
        }

        finalTime = System.currentTimeMillis();
        System.out.println("Concatenar String: " + cadena);
        System.out.println("TiempoTotal: " + (finalTime - initialTime));


        initialTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 90000; i++) {
            stringBuilder.append("A");
        }

        finalTime = System.currentTimeMillis();
        System.out.println("Concatenar StringBuilder: " + stringBuilder.toString());
        System.out.println("TiempoTotal: " + (finalTime - initialTime));


    }
}