package DesignPatterns.XingW.Observer;

import java.util.*;
//标准写法
/*
class Client1 {
    public static void main(String[] args) {
        ConcreteSubject1 date = new ConcreteSubject1("三个数");

        Observer1 observer1 = new ConcreteObserver1("计算器1 ==> ");
        Observer1 observer2 = new ConcreteObserver1("计算器2 ==> ");
        Observer1 observer3 = new ConcreteObserver1("计算器3 ==> ");

        date.Add(observer1);
        date.Add(observer2);
        date.Add(observer3);
        date.setSubjectState(81, 65, 30.4f);
        date.Notify();

        System.out.println("======================================");
        date.Delete(observer1);
        date.setSubjectState(80, 64, 30.2f);
        date.Notify();

        System.out.println("======================================");
        date.Add(new ConcreteObserver1("计算器4 ==> "));
        date.setSubjectState(97, 56, 20.1f);
        date.Notify();
    }
}

interface Subject1 {
    void Add(Observer1 observer); // 注册观察者

    void Delete(Observer1 observer); // 删除观察者

    void Notify(); // 当主题发生变化时通知观察者
}

class ConcreteSubject1 implements Subject1 {
    private final ArrayList<Observer1> observers = new ArrayList<>();
    private float a, b, c;
    String name2;

    public ConcreteSubject1(String name2){
        this.name2 = name2;
    }

    public void setSubjectState(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.println(name2 + "的数值变化了！");
    }

    public float display() {
        return a + b + c;
    }

    @Override
    public void Add(Observer1 observer) {
        observers.add(observer);
    }

    @Override
    public void Delete(Observer1 observer) {
        observers.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observer1 observer : observers) {
            observer.update(this);
        }
    }
}

interface Observer1 {
    void update(Subject1 date);
}

class ConcreteObserver1 implements Observer1 {
    private final String name1;

    public ConcreteObserver1(String name1) {
        this.name1 = name1;
    }

    @Override
    public void update(Subject1 subject1) {
        float observerState = ((ConcreteSubject1) subject1).display();
        System.out.println(name1 + "三数相加：" + observerState);
    }
}
 */

//真题写法
class Client1 {
    public static void main(String[] args) {
        Subject1 date = new ConcreteSubject1();
        Observer1 observer1 = new ConcreteObserver1("计算器1 ==> ", date);
        Observer1 observer2 = new ConcreteObserver1("计算器2 ==> ", date);
        Observer1 observer3 = new ConcreteObserver1("计算器3 ==> ", date);
        date.setNumber(81, 65, 30.4f);

        System.out.println("======================================");
        date.Delete(observer2);
        date.setNumber(80, 64, 30.2f);

        System.out.println("======================================");
        //错误写法，因为ConcreteObserver1(String name, Subject1 date)方法里面就已经调用了一个add方法了
        //以下写法等于调用了两次add方法，这样就会打印出两个计算器4
        //date.Add(new ConcreteObserver1("计算器4 ==> ", date));

        //正确添加观察者的方法就是直接new一个实例，如下
        Observer1 observer4 = new ConcreteObserver1("计算器4 ==> ", date);
        date.setNumber(97, 56, 20.1f);
    }
}

interface Subject1 {
    void Add(Observer1 observer); // 注册观察者

    void Delete(Observer1 observer); // 删除观察者

    void Notify(); // 当主题发生变化时通知观察者

    void setNumber(float a, float b, float c);
}

class ConcreteSubject1 implements Subject1 {
    private ArrayList<Observer1> observers;
    private float a = 0, b = 0, c = 0;

    public ConcreteSubject1() {
        observers = new ArrayList<>();
    }

    public void setNumber(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        Notify();
    }

    @Override
    public void Add(Observer1 observer) {
        observers.add(observer);
    }

    @Override
    public void Delete(Observer1 observer) {
        observers.remove(observer);
    }

    @Override
    public void Notify() {
        for (int i = 0; i < observers.size(); i++) {
            Observer1 observer = observers.get(i);
            observer.update(a, b, c);
        }
    }
}

interface Observer1 {
    void update(float a, float b, float c);
}

class ConcreteObserver1 implements Observer1 {
    private float a;
    private float b;
    private float c;
    private String name;
    private Subject1 date;

    public ConcreteObserver1(String name, Subject1 date) {
        this.name = name;
        this.date = date;
        date.Add(this);
    }

    public void display() {
        float add = a + b + c;
        System.out.println(name + "三度相加：" + add);
    }

    @Override
    public void update(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        display();
    }
}
//真题小改写
/*
class Client1 {
    public static void main(String[] args) {
        Subject1 date = new ConcreteSubject1();
        Observer1 observer1 = new ConcreteObserver1("计算器1 ==> ");
        Observer1 observer2 = new ConcreteObserver1("计算器2 ==> ");
        Observer1 observer3 = new ConcreteObserver1("计算器3 ==> ");

        date.Add(observer1);
        date.Add(observer2);
        date.Add(observer3);
        date.setNumber(81, 65, 30.4f);

        System.out.println("======================================");
        date.Delete(observer2);
        date.setNumber(80, 64, 30.2f);

        System.out.println("======================================");
        date.Add(new ConcreteObserver1("计算器4 ==> "));
        date.setNumber(97, 56, 20.1f);
    }
}

interface Subject1 {
    void Add(Observer1 observer); // 注册观察者

    void Delete(Observer1 observer); // 删除观察者

    void Notify(); // 当主题发生变化时通知观察者

    void setNumber(float a, float b, float c);
}

class ConcreteSubject1 implements Subject1 {
    private ArrayList<Observer1> observers;
    private float a = 0, b = 0, c = 0;

    public ConcreteSubject1() {
        observers = new ArrayList<>();
    }

    public void setNumber(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        Notify();
    }

    @Override
    public void Add(Observer1 observer) {
        observers.add(observer);
    }

    @Override
    public void Delete(Observer1 observer) {
        observers.remove(observer);
    }

    @Override
    public void Notify() {
        for (int i = 0; i < observers.size(); i++) {
            Observer1 observer = observers.get(i);
            observer.update(a, b, c);
        }
    }
}

interface Observer1 {
    void update(float a, float b, float c);
}

class ConcreteObserver1 implements Observer1 {
    private float a;
    private float b;
    private float c;
    private String name;

    public ConcreteObserver1(String name) { //此处把add去掉了
        this.name = name;
    }

    public void display() {
        float add = a + b + c;
        System.out.println(name + "三度相加：" + add);
    }

    @Override
    public void update(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
        display();
    }
}
*/