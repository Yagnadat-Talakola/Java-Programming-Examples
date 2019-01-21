package com.tgt.testapp.parallelPrograms;

public class Caller implements Runnable {

    String msg;
    CallMe target;
    Thread t;

    Caller(CallMe targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
    }

    public void run() {
        target.call(msg);
    }
}
