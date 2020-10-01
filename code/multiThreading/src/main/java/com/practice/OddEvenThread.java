package com.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tania.gupta
 * @date 06/07/20
 */
public class OddEvenThread {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++)
            executorService.submit(new OddEvenGenerator("T" + i, i));

    }
}

class OddEvenGenerator implements Runnable {

    static int limit = 10;
    static int count = 1;
    int remainder;
    String threadName;
    static Object lock = new Object();

    public OddEvenGenerator(String threadName, int remainder) {
        this.threadName = threadName;
        this.remainder = remainder;
    }

    @Override
    public void run() {

        while (count < limit) {

            synchronized (lock) {

                while (count % 2 != remainder) {
                    try {
                        lock.wait();
                    } catch (Exception e) {

                    }
                }
                System.out.println(threadName + " " + count);
                count++;
                lock.notifyAll();

            }

        }

    }
}
