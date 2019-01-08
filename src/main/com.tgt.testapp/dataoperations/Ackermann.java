package com.tgt.testapp.dataoperations;

public class Ackermann {

    public static int ackermannFunction(int m, int n) {
        if (m == 0) return n + 1;
        else if (n == 0) return ackermannFunction(m - 1, 1);
        else return ackermannFunction(m - 1, ackermannFunction(m, n - 1));
    }

    public static void main(String[] args) {
        System.out.println(Ackermann.ackermannFunction(4,1));
    }
}
