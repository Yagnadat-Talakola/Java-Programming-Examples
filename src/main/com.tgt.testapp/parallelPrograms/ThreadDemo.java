package com.tgt.testapp.parallelPrograms;

import java.time.LocalDateTime;

public class ThreadDemo {

    public static void main(String[] args){
        NewThread nt = new NewThread(); // create a new thread

        nt.t.start(); // starts the child thread by calling its run method.

        Thread t = Thread.currentThread();
        System.out.println("Current Thread: " + t);
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i + " " + LocalDateTime.now());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exiting");
    }
}
