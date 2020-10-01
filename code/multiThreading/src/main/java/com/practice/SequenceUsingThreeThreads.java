package com.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tania.gupta
 * @date 06/07/20
 */
public class SequenceUsingThreeThreads {

    public static void main(String[] args) {

        final int NO_OF_THREADS = 3;

        ExecutorService executor = Executors.newFixedThreadPool(NO_OF_THREADS);

        for (int i = 0; i <= NO_OF_THREADS; i++)
            executor.submit(new Sequence("T" + i, i, NO_OF_THREADS));

    }
}

class Sequence implements Runnable {

    static int LIMIT = 10;
    static int count = 1;
    int sequence;
    int noOfThreads;
    String threadName;
    static Object lock = new Object();

    public Sequence(String threadName, int sequence, int noOfThreads) {
        this.threadName = threadName;
        this.sequence = sequence;
        this.noOfThreads = noOfThreads;
    }

    @Override
    public void run() {

        while (count < LIMIT - 1) {

            synchronized (lock) {
                while (count % noOfThreads != sequence) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        System.out.println("Exception occurred");
                    }
                }
                System.out.println(threadName + " " + count);
                count++;
                lock.notifyAll();
            }
        }

    }
}
