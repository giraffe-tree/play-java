//package com.github.giraffetree.basic.concurrency.future.completable;
//
//import com.google.common.util.concurrent.ThreadFactoryBuilder;
//
//import java.util.concurrent.*;
//
///**
// * @author: GiraffeTree
// * @date: 2018/12/2 0002
// */
//public class CompletableWithRequestId {
//
//    private final static ConcurrentHashMap map = new ConcurrentHashMap<Integer, String>();
//
//    public static void main(String[] args) {
//        int size = 1000;
//        for (int i = 0; i < size; i++) {
//            task();
//        }
//
//        try {
//            new CountDownLatch(1).await(2000L, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void task() {
//        ExecutorService threadPool = getThreadPool();
//                CompletableFuture.runAsync(CompletableWithRequestId::runTask01, threadPool)
//                        .thenRunAsync(CompletableWithRequestId::runTask02, threadPool)
//                        .thenRunAsync(CompletableWithRequestId::runTask03, threadPool);
//    }
//
//    public static ExecutorService getThreadPool() {
//        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
//        ThreadFactory threadFactory = threadFactoryBuilder.setNameFormat("task-%d").build();
//        return new ThreadPoolExecutor(8, 16, 100,
//                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000), threadFactory);
//    }
//
//    public static int runTask01() {
//        int i = ThreadLocalRandom.current().nextInt(0, 100000);
//        try {
//            System.out.println("run task 01 " + Thread.currentThread().getName());
//            map.putIfAbsent(i, "第一阶段启动" + Thread.currentThread().getName());
//            Thread.sleep(500L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end task 01 " + Thread.currentThread().getName());
//
//        return i;
//    }
//
//    public static void runTask02(int i) {
//        try {
//            System.out.println("run task 02 " + Thread.currentThread().getName());
////            map.put(i,map.get(i)+)
//            Thread.sleep(500L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end task 02 " + Thread.currentThread().getName());
//    }
//
//    public static void runTask03() {
//        try {
//            System.out.println("run task 03 " + Thread.currentThread().getName());
//            Thread.sleep(500L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("end task 03 " + Thread.currentThread().getName());
//    }
//}
//
