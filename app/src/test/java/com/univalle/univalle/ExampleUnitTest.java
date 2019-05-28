package com.univalle.univalle;

import org.junit.Test;

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
        long fac = ThreadActivity.factorial(25);
        long finalTime = System.currentTimeMillis();

        System.out.println("Factorial: " + fac);
        System.out.println("TiempoTotal: " + (finalTime - initialTime));
    }
}