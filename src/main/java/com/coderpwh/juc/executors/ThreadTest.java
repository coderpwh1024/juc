package com.coderpwh.juc.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadTest {

    public static void main(String[] args) {

        try {

            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test() throws ExecutionException, InterruptedException, TimeoutException {

        FutureTask<String> futureTask = new FutureTask<>(new CallableThread());

        Thread callable = new Thread(futureTask);

        callable.start();

        boolean done = futureTask.isDone();

        boolean cancelled = futureTask.isCancelled();

        futureTask.cancel(true);

        String s = futureTask.get(1, TimeUnit.SECONDS);

        String result = futureTask.get();

        System.out.println(result);


    }


}
