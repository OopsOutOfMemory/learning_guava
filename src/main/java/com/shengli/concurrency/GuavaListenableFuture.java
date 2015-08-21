package com.shengli.concurrency;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by shengli on 8/21/15.
 */
public class GuavaListenableFuture {
    /*
    old way in jdk5

    ExecutorService executor = Executors.newCachedThreadPool();
    Future<Integer> future = executor.submit(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            return service.getCount();
        }
    });

    //Retrieve the value of computation
    Integer count = future.get();
     */

    //Use MoreExecutors.listeningDecorator to wrap a executor

//    ExecutorService executorService = Executors.newCachedThreadPool();
//
//    ListeningExecutorService service = MoreExecutors.listeningDecorator(executorService);
//
    public static void main(String[] args) {

        ListeningExecutorService executorService =
                MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(1));

        ListenableFuture<String> listenableFuture = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "FINAL";
            }
        });

        listenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                methodToRunOnFutureTaskComplete();
            }

            private void methodToRunOnFutureTaskComplete() {
                System.out.println("Task Complete.");
            }
        }, executorService);
    }


}
