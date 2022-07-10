package com.coderpwh.juc.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableThread implements Callable {


    @Override
    public Object call() throws Exception {


        TimeUnit.SECONDS.sleep(10);

        return "complete the job";
    }

}
