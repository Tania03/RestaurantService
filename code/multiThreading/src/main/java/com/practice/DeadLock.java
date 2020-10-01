package com.practice;

import java.util.HashMap;

/**
 * @author tania.gupta
 * @date 16/07/20
 */
public class DeadLock {

    public static void main(String[] args) throws InterruptedException {

        DeadLockThread.mainThread = Thread.currentThread();

        DeadLockThread deadLockThread = new DeadLockThread();
        deadLockThread.start();

        System.out.println("Main thread waiting for child thread");
        deadLockThread.join();

        System.out.println("Main thread execution completed");


    }
}

class DeadLockThread extends Thread {

    static Thread mainThread;

    public void run() {
        System.out.println("Child thread waiting for main thread");
        try {

            mainThread.join();
        } catch (InterruptedException e) {
            System.out.println("Child thread execution completed");
        }

    }
}
