package com.tgt.testapp.parallelPrograms;

public class NewThreadOne implements Runnable {

    String name;
    Thread t;

    NewThreadOne(String threadName) {
        name = threadName;
        t = new Thread(this, name);
    }

    //entry point of thread
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }
        System.out.println(name + "exiting.");
    }
}
