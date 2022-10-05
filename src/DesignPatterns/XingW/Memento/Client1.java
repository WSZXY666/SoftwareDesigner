package DesignPatterns.XingW.Memento;

import java.util.Stack;

public class Client1 {
    public static void main(String[] args) {
        History history = new History();
        Document document = new Document();

        document.change("abc");
        history.add(document.save());

        document.change("def");
        history.add(document.save());

        document.change("ghi");
        history.add(document.save());

        document.change("lmn");

        document.resume(history.getLastVersion());
        document.print();

        document.resume(history.getLastVersion());
        document.print();
    }

}

class Document {
    private String date; //需要备份的数据

    public BackUp save() {
        return new BackUp(date);
    }

    public void resume(BackUp backUp) {
        date = backUp.date;
    }

    public void change(String date) {
        this.date = date;
    }

    public void print() {
        System.out.println(date);
    }
}

interface Memento2 {
}

class BackUp implements Memento2 {
    String date;

    public BackUp(String date) {
        this.date = date;
    }
}

class History {
    Stack<BackUp> backUpStack = new Stack<>();

    public void add(BackUp backUp) {
        backUpStack.add(backUp);
    }

    public BackUp getLastVersion() {
        return backUpStack.pop();
    }
}