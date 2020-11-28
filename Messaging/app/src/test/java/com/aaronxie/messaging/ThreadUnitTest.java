package com.aaronxie.messaging;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * create by Aaron Xie
 * on 2020/9/4
 * description:
 */
public class ThreadUnitTest {

    @Test
    public void main() {
        //
        /*Thread thread01 = new Thread(new MyRunnable01());
        Thread thread02 = new Thread(new MyRunnable02());
        Thread thread03 = new Thread(new MyRunnable03());
        thread01.start();
        thread01.join();
        thread02.start();
        thread02.join();
        thread03.start();*/
        String name = "hello world";
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new MyRunnable01());
        executorService.execute(new MyRunnable02());
        executorService.execute(new MyRunnable03());
    }

    class MyRunnable01 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("01");
            }
        }
    }

    class MyRunnable02 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("02");
            }
        }
    }

    class MyRunnable03 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("03");
            }
        }
    }

    @Test
    public void execute() {
        MyRunnable04 runnable = new MyRunnable04();
        Thread thread1 = new Thread(runnable, "1");
        Thread thread2 = new Thread(runnable, "2");
        Thread thread3 = new Thread(runnable, "3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class MyRunnable04 implements Runnable {
        private static char c = 'A';
        private static int i = 0;

        @Override
        public void run() {
            synchronized (this) {
                int threadId = Integer.parseInt(Thread.currentThread().getName());
                while (i < 26) {
                    if (i % 3 == threadId - 1) {
                        System.out.println(threadId + "" + c++);
                        i++;
                        if (i == 26) {
                            System.out.println("打印完毕");
                        }
                        notifyAll();
                    } else {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
