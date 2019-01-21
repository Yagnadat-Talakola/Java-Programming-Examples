package com.tgt.testapp.parallelPrograms;

public class MultiThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        NewThreadOne nt1 = new NewThreadOne("One");
        NewThreadOne nt2 = new NewThreadOne("Two");
        NewThreadOne nt3 = new NewThreadOne("Three");

        //start the threads
        nt1.t.start();
        nt2.t.start();
        nt3.t.start();

        try{
            //wait for other threads to end.
            Thread.sleep(10000);
        } catch(InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread exited");
    }
}
