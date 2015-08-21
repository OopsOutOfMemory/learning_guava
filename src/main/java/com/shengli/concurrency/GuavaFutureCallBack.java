package com.shengli.concurrency;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Created by shengli on 8/21/15.
 */
public class GuavaFutureCallBack {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ListeningExecutorService executorService =
                MoreExecutors.listeningDecorator(Executors.newSingleThreadExecutor());

        ListenableFuture<String> futureTask = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName()+"Begin to initialize a huge resource ...");
                Thread.sleep(5000);
                //option1:throw new RuntimeException("An runtime exception has occured!");
                //option2:return "TaskComplete";
                return Thread.currentThread().getName()+"TaskComplete";
            }
        });

        System.out.println(Thread.currentThread().getName()+"I'm not in blocking state.");
        System.out.println(Thread.currentThread().getName()+"Run! Run! Run!");


        Futures.addCallback(futureTask, new FutureCallback<String>() {
            private  StringBuilder builder = new StringBuilder();

            @Override
            public void onSuccess(String result) {
                builder.append(result).append(" successfully");
                System.out.println(builder.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                builder.append(t.toString());
                System.out.println(builder.toString());
            }
        }, executorService);


        SettableFuture<String> sf = SettableFuture.create();
        sf.set("Success");
        sf.setException(new RuntimeException("an runtime exception"));

        //The SettableFuture class is very valuable for cases when you have a method
        // that returns a Future instance, but you already have the value to be returned
        // and you don't need to run an asynchronous task.
    }
}
