package com.coderpwh.juc.executors;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class ExecutorsTest {

    public static void main(String[] args) {

        // 通过Executors 创建newCachedThreadPool线程池
//        createCachedThreadPool();

        // 通过Executors 创建 newFixedThreadTool线程池
//        createFixedThreadTool();

        // 通过Executors 创建scheduledThreadPool 线程池
//        createScheduledThreadPool();

        // 通过Executors 创建singThreadPool 线程池
//        createSingThreadPool();


        // 通过ThreadPoolExecutor 来创建线程池
        createThreadPool();

    }


    public static void createCachedThreadPool() {

        ExecutorService executorService = Executors.newCachedThreadPool();


        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {

                Date dNow = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                System.out.println("时间为:" + ft.format(dNow) + ", " + "线程名称为: " + Thread.currentThread().getName() + ", " + "线程编号为: " + index);

                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            });
        }
    }

    public static void createFixedThreadTool() {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                Date dNow = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                System.out.println("时间为:" + ft.format(dNow) + ", " + "线程名称为: " + Thread.currentThread().getName() + ", " + "线程编号为: " + index);

                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }

    }

    public static void createScheduledThreadPool() {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);


        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println("当前时间是:" + ft.format(dNow) + " ,提交任务");

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {

                Date date = new Date();

                System.out.println("时间为:" + ft.format(date) + ", " + "线程名称为: " + Thread.currentThread().getName() + ", " + "线程编号为: " + index);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }

    }

    public static void createSingThreadPool() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = i;

            executorService.execute(() -> {

                Date date = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                System.out.println("时间为:" + ft.format(date) + ", " + "线程名称为: " + Thread.currentThread().getName() + ", " + "线程编号为: " + index);


                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

        }

    }


    /***
     *  通过ThreadPoolExecutor 来创建线程池
     *
     */
    public static void createThreadPool() {

        ExecutorService executorService = new ThreadPoolExecutor(2, 10, 1,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                Date date = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                System.out.println("时间为:" + ft.format(date) + ", " + "线程名称为: " + Thread.currentThread().getName() + ", " + "线程编号为: " + index);

                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }



    }


}
