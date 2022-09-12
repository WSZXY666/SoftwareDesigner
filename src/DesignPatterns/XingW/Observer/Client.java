package DesignPatterns.XingW.Observer;
//观察者模式

import java.util.*;

public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject("up主");

        Observer observerA = new ConcreteObserver("张三");
        Observer observerB = new ConcreteObserver("李四");
        Observer observerC = new ConcreteObserver("王五");

        subject.Attach(observerA);
        subject.Attach(observerB);
        subject.Attach(observerC);

        subject.setSubjectState("更新了");
        subject.Notify();

        System.out.println("======================================");

        subject.Detach(observerC);
        subject.Attach(new ConcreteObserver("二狗"));
        subject.setSubjectState("停更了");
        subject.Notify();
    }
}

abstract class Subject { // 目标
    private List<Observer> observers = new ArrayList<>();

    public List<Observer> getObservers() {
        return observers;
    }

    public abstract void Attach(Observer observer); // 添加观察者

    public abstract void Detach(Observer observer); // 删除观察者

    public void Notify() { // 状态改变后 通知所有观察者
        // for (遍历对象类型 对象名 : 遍历对象)
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

class ConcreteSubject extends Subject {
    private String subjectState;
    private String subjectname;

    public ConcreteSubject(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        System.out.println(subjectname + "的作品状态为：" + subjectState);
    }

    @Override
    public void Attach(Observer observer) {
        getObservers().add(observer);
    }

    @Override
    public void Detach(Observer observer) {
        getObservers().remove(observer);
    }
}

abstract class Observer { // 观察者接口
    public abstract void update(Subject subject); // 收到通知 更新观察者的状态
}

class ConcreteObserver extends Observer {
    private String observername;
    private String observerState;

    public ConcreteObserver(String observername) {
        this.observername = observername;
    }

    @Override
    public void update(Subject subject) {
        observerState = ((ConcreteSubject) subject).getSubjectState(); // 让当前观察者的状态 和 改变了状态之后的目标的状态保持一致
        System.out.println(observername + " 收到通知：" + observerState);
    }
}
//仿照真题方法
/*
public class Client {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject("目标");

        Observer observerA = new ConcreteObserver("张三", subject);
        Observer observerB = new ConcreteObserver("李四", subject);
        Observer observerC = new ConcreteObserver("王五", subject);

        subject.setSubjectStat("更新了");

        System.out.println("======================================");

        subject.Detach(observerC);
        subject.Attach(new ConcreteObserver("二狗", subject));

        subject.setSubjectStat("停更了");
    }
}

interface Subject { // 目标
    void Attach(Observer observer); // 添加观察者
    void Detach(Observer observer); // 删除观察者
    void Notify(); // 状态改变后 通知所有观察者

    void setSubjectStat(String state); // 设置状态（改变状态）
    String getSubjectState(); // 获取状态
}

class ConcreteSubject implements Subject {
    private String name;
    private String state;

    private List<Observer> observerList;

    public ConcreteSubject(String name) {
        state = "未更新";
        this.name = name;
        observerList = new ArrayList<Observer>();
    }

    public void setSubjectStat(String state) {
        this.state = state;

        System.out.println(name + "的状态变化为：" + state);
        Notify();
    }

    public String getSubjectState() {
        return state;
    }

    public void Attach(Observer observer) {
        observerList.add(observer);
    }

    public void Detach(Observer observer) {
        observerList.remove(observer);
    }

    public void Notify() {
        // for (遍历对象类型 对象名 : 遍历对象)
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}

interface Observer { // 观察者接口
    void update(); // 收到通知 更新观察者的状态
}

class ConcreteObserver implements Observer {
    private String name;
    private String state;

    private Subject subject;

    public ConcreteObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
        subject.Attach(this);

        state = subject.getSubjectState();
    }

    @Override
    public void update() {
        state = subject.getSubjectState(); // 让当前观察者的状态 和 改变了状态之后的目标的状态保持一致
        System.out.println(name + " 收到通知：" + state);
    }
}
*/