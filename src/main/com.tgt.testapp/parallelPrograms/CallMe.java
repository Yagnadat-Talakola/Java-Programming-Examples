package com.tgt.testapp.parallelPrograms;

// this program is synchronized.
public class CallMe {

    /* synchronized prevents other threads from entering call() while another thread is using it.
     Once a thread enters any synchronized method on an instance, no other thread can enter any other
     synchronized method on the same instance. However, non-synchronized methods on that instance will
     continue to be callable.
    */
   synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}
