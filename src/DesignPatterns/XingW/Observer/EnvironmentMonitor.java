package DesignPatterns.XingW.Observer;

import java.util.*;

interface ObserverX {
    public void update(float temp, float humidity, float cleanness);
}

class CurrentConditionsDisplay implements ObserverX { // (5)
    private float temperature;
    private float humidity;
    private float cleanness;
    private SubjectX envData;

    public CurrentConditionsDisplay(SubjectX envData) {
        this.envData = envData;
        envData.registerObserver(this); // (6)
    }

    public void update(float temperature, float humidity, float cleanness) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.cleanness = cleanness;
        display();
    }

    public void display() { /* 代码省略 */ }
}

interface SubjectX {
    public void registerObserver(ObserverX o); // 注册对主题感兴趣的观察者

    public void removeObserver(ObserverX o); // 删除观察者

    public void notifyObservers(); // 当主题发生变化时通知观察者
}

class EnvironmentData implements SubjectX { // (1)
    private final ArrayList<ObserverX> observers;
    private float temperature, humidity, cleanness;

    public EnvironmentData() {
        observers = new ArrayList<>();
    }

    public void registerObserver(ObserverX o) {
        observers.add(o);
    }

    public void removeObserver(ObserverX o) { /* 代码省略 */ }

    public void notifyObservers() {
        for (ObserverX observer : observers) {
            observer.update(temperature, humidity, cleanness); // (2)
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    } // (3)

    public void setMeasurements(float temperature, float humidity, float cleanness) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.cleanness = cleanness;
        measurementsChanged(); // (4)
    }
}

class EnvironmentMonitor {
    public static void main(String[] args) {
        EnvironmentData envData = new EnvironmentData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(envData);

        envData.setMeasurements(80, 65, 30.4f);
    }
}

