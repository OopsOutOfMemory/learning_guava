package com.shengli.cache;

import com.google.common.cache.*;
import com.google.common.util.concurrent.Callables;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by shengli on 8/25/15.
 */
class SingletonGuavaCache {

    private static class CacheHolder {
        private static SingletonGuavaCache instance = new SingletonGuavaCache();
    }

    public static SingletonGuavaCache getInstance() {
        return CacheHolder.instance;
    }


    private final LoadingCache<String, String> cache;

    private SingletonGuavaCache() {
        cache = CacheBuilder.newBuilder().recordStats().maximumSize(10).removalListener(new RemovalListener<String, String>() {
            @Override
            public void onRemoval(RemovalNotification<String, String> notification) {
                System.out.println(notification.getKey()+notification.getValue()+" has been removed by "+notification.getCause().toString());
            }
        }).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return createRandom();
            }
        });
    }

//    LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
//            .maximumSize(1000)
//            .expireAfterWrite(10, TimeUnit.MINUTES)
//            .removalListener(MY_LISTENER)
//            .build(
//                    new CacheLoader<Key, Graph>() {
//                        public Graph load(Key key) throws AnyException {
//                            return createExpensiveGraph(key);
//                        }
//                    });

    /*
      never need to manually put a Foo in... will be loaded from DB if needed
     */
    public String getEntry( String key ) throws ExecutionException {
//        System.out.println(cache.getIfPresent("111"));
        System.out.println(cache.get("111", Callables.returning("1")));
        return cache.getUnchecked( key );
    }

    public void putEntry(String key, String value) {
        cache.put(key, value);
        System.out.println("put key->" + key + " value->" + value + " into cache");
        System.out.println(cache.stats());
    }

    private String createRandom() {
        return "I'm a random string or resource... Be creative ;)";
    }
}

public class GuavaCache {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SingletonGuavaCache cache = SingletonGuavaCache.getInstance();
        int i = 0;
        while (true) {
            if (i % 5 == 0) {
                System.out.println("get entry is ->" + cache.getEntry("hello"+(i-1)));
            }
//            cache.putEntry("hello"+i,"World"+i);
            i++;
            Thread.sleep(1000);
        }
    }
}


// OLD WAY TO CREATE A CACHE

class Cache {
    private static final int MAX_SIZE = 100;
    private final ConcurrentHashMap<String, String> map;

    public Cache() {
        map = new ConcurrentHashMap<String, String>();
    }
    public String getEntry(String key) {
        String result = getChacheEntry( key );
        evictOldestEntryIfNecessary();
        return result;
    }

    private String getChacheEntry( String key ) {
        String result = map.get( key );
        if( result == null ) {
            String putResult = map.putIfAbsent( key, createRandom() );
            if( putResult != null ) {
                result = putResult;
            }
        }
        return result;
    }
    private String createRandom() {
        return "I'm a random string or resource... Be creative ;)";
    }


    private void evictOldestEntryIfNecessary() {
        if (map.size() > MAX_SIZE) {
            String keyToMove = map.keys().nextElement();
            map.remove(keyToMove);
        }
    }
}