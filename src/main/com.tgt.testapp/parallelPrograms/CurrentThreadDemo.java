package com.tgt.testapp.parallelPrograms;

// controlling the main thread.
public class CurrentThreadDemo {

    public static void main(String[] args) {
        // method returns a reference to the thread in which it is called.
        Thread t = Thread.currentThread();

        System.out.println("current thread: " + t);

        //change the name of the thread
        t.setName("my thread");
        System.out.println("after name change: " + t);

        try{
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
                // sleep suspends thread for a period of time.
            }
        } catch (InterruptedException e){
            System.out.println("main thread interrupted");
        }
    }
}

/*
    current thread: Thread[main /name of the thread/, 5 /priority/, main /name of its group/]
    after name change: Thread[my thread, 5, main]
 */