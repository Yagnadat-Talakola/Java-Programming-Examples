package com.tgt.testapp.parallelPrograms;

public class DemoJoin {

    public static void main(String[] args) {
        NewThreadTwo nt1 = new NewThreadTwo("One");
        NewThreadTwo nt2 = new NewThreadTwo("Two");
        NewThreadTwo nt3 = new NewThreadTwo("Three");

        //start the threads
        nt1.t.start();
        nt2.t.start();
        nt3.t.start();

        // determine if threads are running.
        System.out.println("Thread One is alive: " + nt1.t.isAlive());
        System.out.println("Thread Two is alive: " + nt2.t.isAlive());
        System.out.println("Thread Three is alive: " + nt3.t.isAlive());

        //wait for threads to finish
        try{
            System.out.println("waiting for threads to finish");
            // join() waits until the thread on which it is called terminates.
            nt1.t.join();
            nt2.t.join();
            nt3.t.join();
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted");
        }

        // determine if threads are running.
        System.out.println("Thread One is alive: " + nt1.t.isAlive());
        System.out.println("Thread Two is alive: " + nt2.t.isAlive());
        System.out.println("Thread Three is alive: " + nt3.t.isAlive());

        System.out.println("Main thread exiting");
    }
}
