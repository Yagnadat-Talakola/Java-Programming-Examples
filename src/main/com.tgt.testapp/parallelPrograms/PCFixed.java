package com.tgt.testapp.parallelPrograms;

public class PCFixed {
    public static void main(String[] args) {
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

        //start the threads
        producer.t.start();
        consumer.t.start();

        System.out.println("Press Control+C to stop.");
    }
}
