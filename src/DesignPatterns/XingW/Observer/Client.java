package DesignPatterns.XingW.Observer;
//观察者模式

import java.util.*;

public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject("up主"); //up主
        Observer observerA = new ConcreteObserver("张三"); //粉丝1
        Observer observerB = new ConcreteObserver("李四"); //粉丝2
        Observer observerC = new ConcreteObserver("王五"); //粉丝3

        subject.Attach(observerA); //关注
        subject.Attach(observerB); //关注
        subject.Attach(observerC); //关注

        subject.setSubjectState("更新了"); //设置通知
        subject.Notify(); //发布通知

        System.out.println("======================================");

        subject.Detach(observerC); //粉丝3取关
        subject.Attach(new ConcreteObserver("二狗")); //新粉丝关注
        subject.setSubjectState("停更了"); //设置通知
        subject.Notify(); //发布通知
    }
}

abstract class Subject { // 抽象up主
    private final List<Observer> observers = new ArrayList<>(); //粉丝列表

    public List<Observer> getObservers() {
        return observers;
    }

    public abstract void Attach(Observer observer);

    public abstract void Detach(Observer observer);

    public void Notify() { // 通知改变后，发布通知给所有粉丝
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

class ConcreteSubject extends Subject { //up主
    private String subjectState;
    private final String subjectname;

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
    public void Attach(Observer observer) { // 粉丝关注
        getObservers().add(observer);
    }

    @Override
    public void Detach(Observer observer) { // 粉丝取关
        getObservers().remove(observer);
    }
}

abstract class Observer { // 抽象粉丝
    public abstract void update(Subject subject);
}

class ConcreteObserver extends Observer { //粉丝
    private final String observername;


    public ConcreteObserver(String observername) {
        this.observername = observername;
    }

    @Override
    public void update(Subject subject) { // 收到通知，更新粉丝收到的通知的状态
        String observerState = ((ConcreteSubject) subject).getSubjectState(); // 让当前粉丝收到通知的状态 和 改变了通知状态之后的up主发布的通知的状态保持一致
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