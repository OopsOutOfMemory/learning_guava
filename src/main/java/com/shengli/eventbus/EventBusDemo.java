package com.shengli.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created by shengli on 9/1/15.
 */
public class EventBusDemo {

    public static void main(String[] args) throws InterruptedException {
        EventBus eventBus = new EventBus();

        //observerList   observer equals listener
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();

        eventBus.register(observer1);
        eventBus.register(observer2);

        // 只有注册的参数类型为String的方法会被调用
        eventBus.post("post string method");

        // 注销observer2
//        eventBus.unregister(observer2);
//        eventBus.post("post string method after unregister");
    }
}


 class MsgCenter {

    /** EventBus的定位跟接近于消息中心,而他的post()方法跟接近于一个自定义的Subject */
    public static EventBus eventBus = new EventBus();
}


 class Observer1 {

    /**
     * 只有通过@Subscribe注解的方法才会被注册进EventBus
     * 而且方法有且只能有1个参数
     * @param msg
     */
    @Subscribe
    public void ob1Mthod1(String msg) {
        System.out.println(msg + " test1!" + " from ob1");
    }

    @Subscribe
    public void ob1Method2(String msg) {
        System.out.println(msg + " test2!" + " from ob1");
    }
}

 class Observer2 {
    @Subscribe
    public void ob2Method1(String msg) {
        System.out.println(msg + " test3!" + " from ob2");
    }

    // 错误的基本型参数
    // @Subscribe
    // public void ob2Method2(int msg) {
    // System.out.println(msg + " test4!"  + " from ob2");
    // }
    /**
     * post() 不支持自动装箱功能,只能使用Integer,不能使用int,否则handlersByType的Class会是int而不是Integer
     * 而传入的int msg参数在post(int msg)的时候会被包装成Integer,导致无法匹配到
     */
    @Subscribe
    public void ob2Method2(Integer msg) {
        System.out.println(msg + " test4!"  + " from ob2");
    }
}

