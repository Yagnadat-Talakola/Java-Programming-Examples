package com.tgt.testapp.parallelPrograms;

//using join() to wait for threads to finish.
public class NewThreadTwo implements Runnable {
    String name;
    Thread t;

    NewThreadTwo(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New Thread: " + t);
    }

    // This is the entry point for thread.
    public void run() {
        try {
            for  (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }
}
