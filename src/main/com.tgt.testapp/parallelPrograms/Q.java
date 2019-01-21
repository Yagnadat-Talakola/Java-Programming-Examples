package com.tgt.testapp.parallelPrograms;

// a correct implementation of producer and consumer.
public class Q {
    int n;
    boolean valueSet = false;

     synchronized int get() {
         while(!valueSet) {
             try {
                 wait();
             } catch (InterruptedException e) {
                 System.out.println("Interrupted Exception caught");
             }
         }

         System.out.println("Got: " + n);
         valueSet = false;
         notify();
         return n;
     }

     synchronized void put(int n) {
         while(valueSet) {
             try {
                 wait();
             } catch (InterruptedException e) {
                 System.out.println("Interrupted exception caught");
             }
         }

         this.n = n;
         valueSet = true;
         System.out.println("Put: " + n);
         notify();
     }
}
