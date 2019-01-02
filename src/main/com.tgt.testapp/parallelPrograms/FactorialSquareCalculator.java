package com.tgt.testapp.parallelPrograms;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FactorialSquareCalculator extends RecursiveTask {

    private Long n;

    public FactorialSquareCalculator(long n) {
        this.n = n;
    }

    public static Long sequentialFactorialCalculator(long n) {

        if (n <= 1) {
            return n;
        } else {
            return n * sequentialFactorialCalculator(n - 1);
        }
    }

    @Override
    public Long compute() {

        if (this.n <= 1) {
            return this.n;
        } else {
            FactorialSquareCalculator calculator = new FactorialSquareCalculator(n - 1);
            calculator.fork();
            return this.n * (Long) calculator.join();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FactorialSquareCalculator calculator = new FactorialSquareCalculator(20);
        long startTimeParallel = System.nanoTime();
        Long parallelResult = (Long) ForkJoinPool.commonPool().invoke(calculator);
        long finishTimeParallelInMilliSeconds = (System.nanoTime() - startTimeParallel) / 1000000;
        System.out.print("process time for parallel operation: ");
        System.out.println(finishTimeParallelInMilliSeconds);
        System.out.println(parallelResult);

        long startTimeSerial = System.nanoTime();
        Long serialResult = FactorialSquareCalculator.sequentialFactorialCalculator(20);
        long processTimeForSerialInMilliSeconds = (System.nanoTime() - startTimeSerial) / 1000000;
        System.out.print("process time for serial operation: ");
        System.out.println(processTimeForSerialInMilliSeconds);
        System.out.println(serialResult);
    }

}

