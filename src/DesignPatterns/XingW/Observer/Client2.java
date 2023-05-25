package DesignPatterns.XingW.Observer;

import java.util.*;

public class Client2 {
    public static void main(String[] args) {
        ConcreteSubject2 subject2 = new ConcreteSubject2(); //妈妈
        ConcreteObserver2 observer21 = new ConcreteObserver2("张三"); //大儿子
        ConcreteObserver2 observer22 = new ConcreteObserver2("李四"); //二儿子
        ConcreteObserver2 observer23 = new ConcreteObserver2("王五"); //小儿子

        subject2.Add(observer21); //大儿子出生
        subject2.Add(observer22); //二儿子出生
        subject2.Add(observer23); //小儿子出生

        subject2.setSubjectState("开饭了！"); //妈妈想通知儿子们吃饭
        subject2.Notify(); //妈妈通知儿子们开饭了

        System.out.println("========================================");
        subject2.Delete(observer22); //二儿子去世
        subject2.setSubjectState("睡觉了！"); //妈妈想通知儿子们睡觉
        subject2.Notify(); //妈妈通知儿子们睡觉了

    }
}

abstract class Subject2 {
    private final List<Observer2> observer2s = new ArrayList<>();

    public List<Observer2> getObserver2s() {
        return observer2s;
    }

    public void Notify() {
        for (Observer2 observer2 : observer2s) {
            observer2.update(this);
        }
    }

    public abstract void Add(Observer2 observer2);

    public abstract void Delete(Observer2 observer2);
}

class ConcreteSubject2 extends Subject2 {
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        System.out.println("妈妈在喊：" + subjectState);
    }

    @Override
    public void Add(Observer2 observer2) {
        getObserver2s().add(observer2);
    }

    @Override
    public void Delete(Observer2 observer2) {
        getObserver2s().remove(observer2);
    }
}

abstract class Observer2 {
    public abstract void update(Subject2 subject2);
}

class ConcreteObserver2 extends Observer2 {
    private final String name;

    public ConcreteObserver2(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject2 subject2) {
        String observerState = ((ConcreteSubject2) subject2).getSubjectState();
        System.out.println(name + "收到通知：" + observerState);
    }
}
