package com.aaronxie.messaging;

import org.junit.Test;

/**
 * create by Aaron Xie
 * on 2020/9/4
 * description:
 */
public class GenericUnitTest {

    @Test
    public void main() {
        System.out.println(getData(123));
        System.out.println(getData(456));
    }

    public <T> T getData(T arg) {
        return arg;
    }

    @Test
    public <T> void getUser(T arg) {

    }
}
