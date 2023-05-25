package DesignPatterns.XingW.Memento;
//备忘录模式

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        originator.setState("1024");  //人想记录“1024”，然后记录
        Memento backup1 = originator.createMemento();  //备忘录1记录人创建“1024”的备忘录
        caretaker.addMemento(backup1);  //手机里面的虚拟管理员把备忘录1添加到备忘录列表中

        originator.setState("2048");
        Memento backup2 = originator.createMemento();
        caretaker.addMemento(backup2);

        originator.setState("4096");
        Memento backup3 = originator.createMemento();
        caretaker.addMemento(backup3);

        System.out.println(originator.getState() + "\n");  //输出人当前记录的备忘录
        caretaker.showMemento();  //手机里面的虚拟管理员显示出所有备忘录列表

        Memento memento1 = caretaker.getMemento(2);
        originator.setMemento(memento1);
        System.out.println("\n恢复后的状态：" + originator.getState());
    }
}

//原发器(人)
class Originator {
    private String state;

    public Memento createMemento() {
        return new Memento(state);
    }

    public void setMemento(Memento memento) {
        state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

//备忘录（软件里面的一条条备忘录）
class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}

//管理员（备忘录软件）
class Caretaker {
    private final List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(int index) {
        if (index >= 1 && index <= mementoList.size()) {
            return mementoList.get(index - 1);
        } else {
            return null;
        }
    }

    public void showMemento() {
        int count = 1;

        for (Memento memento : mementoList) {
            System.out.println("第" + count + "次备份，状态为：" + memento.getState());
            count += 1;
        }
    }
}
