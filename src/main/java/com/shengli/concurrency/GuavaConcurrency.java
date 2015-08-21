package com.shengli.concurrency;

import com.google.common.util.concurrent.Monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengli on 8/19/15.
 */
public class GuavaConcurrency {

    private List<String> list = new ArrayList<>();

    public static final int MAX_SIZE = 20;

    private Monitor monitor = new Monitor();

    private Monitor.Guard listBelowCapacity = new Monitor.Guard(monitor) {
        @Override
        public boolean isSatisfied() {
            return list.size() < MAX_SIZE;
        }
    };

    public void addToList(String item) throws InterruptedException {
        monitor.enterWhen(listBelowCapacity);
        try {
            list.add(item);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            monitor.leave();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        GuavaConcurrency concurrency = new GuavaConcurrency();
        concurrency.addToList("Add");
        concurrency.addToList("Add");
        concurrency.addToList("Add");
        concurrency.addToList("Add");
    }

}


