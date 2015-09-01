package com.shengli.eventbus;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by shengli on 9/1/15.
 */
public class OldEventBus {
    //traditional observer pattern
}


abstract class Subject {

    private List<Observer> observerList = Lists.newArrayList();

    /**
     * 注册观察者
     * @param observer
     */
    public void register(Observer observer) {
        observerList.add(observer);
    }

    /**
     * 注销观察者
     *
     * @param observer
     */
    public void unregister(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * 通知观察者更新
     */
    public void post() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    /**
     * 获取被通知事件
     *
     * @return
     */
    public abstract Object getEvent();
}


 class ConcreteSubject1 extends Subject {

    /** 个性化的定制内容 */
    private String subjectState;

    public ConcreteSubject1(String subjectState) {
        this.subjectState = subjectState;
    }

    @Override
    public Object getEvent() {
        System.out.println("Custom ConcreteSubject1");
        return subjectState;
    }
}


 class ConcreteSubject2 extends Subject {

    private int subjectState;

    public ConcreteSubject2(int subjectState) {
        this.subjectState = subjectState;
    }

    @Override
    public Object getEvent() {
        System.out.println("Custom ConcreteSubject2");
        return subjectState;
    }
}


 abstract class Observer {

    /** 用于观察者获取被通知的事件 */
    protected Subject subject;

    /**
     * 用于给Subject通知时调用的更新方法
     */
    public abstract void update();
}


 class ConcreteObserver1 extends Observer {

    public ConcreteObserver1(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println("Subject " + subject.getEvent() + " ConcreteObserver1");
    }
}


 class ConcreteObserver2 extends Observer {

    public ConcreteObserver2(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println("Subject " + subject.getEvent() + " ConcreteObserver2");
    }
}


 class ConcreteObserver3 extends Observer {

    public ConcreteObserver3(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println("Subject " + subject.getEvent() + " ConcreteObserver2");
    }
}