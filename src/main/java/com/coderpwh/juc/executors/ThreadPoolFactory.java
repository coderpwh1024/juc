package com.coderpwh.juc.executors;


import java.util.concurrent.*;

/***
 * 线程池工厂
 */
public class ThreadPoolFactory {


    /***
     * 线程池核心线程数
     */
    private  static  final  int INIT_POOL_SIZE=4;

    /***
     * 线程池最大线程数
     */
    private  static  final  int MAX_POOL_SIZE=10;


    /***
     *  线程池
     */
    private  static  final ThreadPoolExecutor AttendanceTaskPool = new ThreadPoolExecutor(INIT_POOL_SIZE,MAX_POOL_SIZE,0,
            TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(1000),new ThreadPoolExecutor.AbortPolicy());


    /***
     *  异步
     * @param r
     * @return
     */
    public  static  String addTaskAttendanceRecordSubmit(Runnable r){

        System.out.println("当前运行线程数:"+getActiveCount(AttendanceTaskPool));

        System.out.println("当前阻塞线程数:"+getBlockingQueue(AttendanceTaskPool));

        AttendanceTaskPool.execute(r);

        return "success";
    }


    /***
     * 同步
     * @param c
     * @return
     */
    public static  String addTaskAttendanceRecordSubmit(Callable c ){

        String m=null;

        System.out.println("当前运行线程数:"+getActiveCount(AttendanceTaskPool));
        System.out.println("当前阻塞线程数:"+getBlockingQueue(AttendanceTaskPool));

        Future<?> future  = AttendanceTaskPool.submit(c);

        try {
            Object obj = future.get();
            if(obj!=null){
                m=(String) obj;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return  "success";
    }

    /***
     *
     *   运行线程数
     *
     * @param pool
     * @return
     */
    public static  int getActiveCount(ThreadPoolExecutor pool){

        return  pool.getActiveCount();
    }

    /***
     * 最大线程数
     * @param pool
     * @return
     */
    public static  int getMaxMunPoolSize(ThreadPoolExecutor pool){
        return  pool.getMaximumPoolSize();
    }

    /***
     * 阻塞线程数
     * @param pool
     * @return
     */
    public  static  int getBlockingQueue(ThreadPoolExecutor pool){
        return  pool.getQueue().size();
    }
}
