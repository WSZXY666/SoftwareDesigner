package DesignPatterns.XingW.Observer;

import java.util.*;

interface Observer3 {
    public void update(); // (1)
}

class DocExplorer implements Observer3 {
    private final String myObsName;

    public DocExplorer(String name, Subject3 sub) { // (4)
        myObsName = name;
        sub.Attach(this); // (5)
    }

    @Override
    public void update() {
        System.out.println("update observer[" + myObsName + "]");
    }
}

interface Subject3 {
    void Attach(Observer3 obs);

    void Detach(Observer3 obs);

    void Notify();

    void setStatus(int status);

    int getStatus();
}

class OfficeDoc implements Subject3 {
    private final List<Observer3> myObs; // (2)
    private final String mySubjectName;
    private int m_status;

    public OfficeDoc(String name) {
        mySubjectName = name;
        this.myObs = new ArrayList<>();
        m_status = 0;
    }

    @Override
    public void Attach(Observer3 obs) {
        this.myObs.add(obs);
    }

    @Override
    public void Detach(Observer3 obs) {
        this.myObs.remove(obs);
    }

    @Override
    public void Notify() {
        for (Observer3 obs : this.myObs) {
            obs.update();
        } // (3)
    }

    @Override
    public void setStatus(int status) {
        m_status = status;
        System.out.println("SetStatus subject[" + mySubjectName + "]status:" + status);
    }

    @Override
    public int getStatus() {
        return m_status;
    }
}

class ObserverTest {
    public static void main(String[] args) {
        Subject3 subjectA = new OfficeDoc("subject A");
        Observer3 observerA = new DocExplorer("observer A", subjectA);
        subjectA.setStatus(1);
        subjectA.Notify();
    }
}
