package DesignPatterns.XingW.Memento;

import java.util.*;

class Memento3 {
    private final String state;

    public Memento3(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator3 {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento3 saveStateToMemento3() {
        return new Memento3(state); //  或 new Memento(this.state) 或 new Memento(getState())
    }

    public void getStateFromMemento3(Memento3 memento) {
        state = memento.getState(); // (2)
    }
}

class CareTaker3 {
    private final List<Memento3> mementoList = new ArrayList<>();

    public void add(Memento3 state) { // (3)
        mementoList.add(state);
    }

    public Memento3 get(int index) { // (4)
        return mementoList.get(index);
    }
}


class MementoPaneDemos {
    public static void main(String[] args) {
        Originator3 originator = new Originator3();
        CareTaker3 careTaker = new CareTaker3();

        originator.setState("State #1");

        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento3()); // (5)

        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento3()); // (6)

        originator.setState("State #4");
        careTaker.add(originator.saveStateToMemento3());

        System.out.println("Current State：" + originator.getState());

        originator.getStateFromMemento3(careTaker.get(0));
        System.out.println("First saved State：" + originator.getState());

        originator.getStateFromMemento3(careTaker.get(2));
        System.out.println("Third saved State：" + originator.getState());

        originator.getStateFromMemento3(careTaker.get(1));
        System.out.println("Second saved State：" + originator.getState());
    }
}