package com.shengli.concurrency;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by shengli on 8/21/15.
 */
//public class GuavaAsynFunctions {
//
//}

//class AsyncFuntionSample implements AsyncFunction<Long, String> {
//    private ConcurrentMap<Long, String> map = Maps.newConcurrentMap();
//    private ListeningExecutorService listeningExecutorService;
//
//    @Override
//    public ListenableFuture<String> apply(final Long input) throws
//            Exception {
//        if (map.containsKey(input)) {
//            SettableFuture<String> listenableFuture = SettableFuture.create();
//            listenableFuture.set(map.get(input));
//            return listenableFuture;
//        } else {
//            return listeningExecutorService.submit(new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    String retrieved = service.get(input);
//                    map.putIfAbsent(input, retrieved);
//                    return retrieved;
//                }
//            });
//        }
//    }
//}
