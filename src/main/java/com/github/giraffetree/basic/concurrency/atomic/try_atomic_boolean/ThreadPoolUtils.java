package com.github.giraffetree.basic.concurrency.atomic.try_atomic_boolean;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author: GiraffeTree
 * @date: 2018/10/31
 */
public class ThreadPoolUtils {

    public static ExecutorService getThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("giraffe-poll-%d").build();

        return new ThreadPoolExecutor(5, 10,
                100L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                threadFactory, new ThreadPoolExecutor.AbortPolicy());

    }

}
