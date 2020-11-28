package com.aaronxie.messaging;

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
        assertEquals(4, 2 + 2);
    }

    @Test
    public void main() throws NumberFormatException {
        String format = String.format("发送请求 %s on %s %n%s %nRequestParams:{%s}",
                "hello", "hello", "hello", "hello");
        System.out.println(format);
        Thread thread = new Thread();
        Object object = new Object();
    }

    @Test
    public void test1() {
        String a = "$adbc";
        a = a.replaceAll("\\$", "hao");
        System.out.println(a);
    }
}