package com.tgt.testapp.parallelPrograms;
import java.time.LocalDateTime;

public class NewThread implements Runnable {
    Thread t;

    NewThread() {
        /* create a new second thread:
           Constructor: Thread(Runnable threadOb, String threadName)
                        /threadOb is any object that implements Runnable/.
        */
        t = new Thread(this, "Demo Thread");
        System.out.println("Child Thread: " + t);
    }

    // this is the entry point for the second thread
    public void run() {
        try {
            for (int i = 5; i > 0; i--){
                System.out.println("Child Thread: " + i + " " + LocalDateTime.now());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child Thread interrupted");
        }
        System.out.println("Exiting child thread");
    }
}
