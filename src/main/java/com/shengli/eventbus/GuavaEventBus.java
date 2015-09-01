package com.shengli.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * Created by shengli on 9/1/15.
 */
public class GuavaEventBus {

    public static void main(String[] args) {

        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();

        eventBus.register(listener);

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        eventBus.post(new TestEvent(400));

        System.out.println("LastMessage:"+listener.getLastMessage());
    }

}
