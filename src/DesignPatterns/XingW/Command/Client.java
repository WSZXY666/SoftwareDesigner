package DesignPatterns.XingW.Command;
//命令模式

public class Client {
    public static void main(String[] args) {
        Tv tv = new Tv(); // 接收者 对象 电视机
        Command onCommand = new OnCommand(tv); // 命令对象 开机命令
        Command offCommand = new OffCommand(tv); // 命令对象 关机命令
        Invoker invoker = new Invoker(); // 请求者

        invoker.setCommand(onCommand); // 给请求者设置 开机 命令
        invoker.call(); // 请求者去请求命令

        System.out.println("=======================");

        invoker.setCommand(offCommand); // 给请求者设置 关机命令
        invoker.call(); // 请求者去请求命令
    }
}

class Invoker { // 请求者
    private Command command; // 命令

    public void setCommand(Command command) { // 设置请求者 的 请求的命令
        this.command = command;
    }

    public void call() { // 调用
        command.Execute();
    }
}

interface Command { // 命令接口
    void Execute();
}

// 开机命令
class OnCommand implements Command {
    private final Tv tv;

    public OnCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OnAction();
    }
}

// 关机命令
class OffCommand implements Command {
    private final Tv tv;

    public OffCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OffAction();
    }
}

// 接收者 电视机
class Tv {
    public void OnAction() {
        System.out.println("电视机开机了..."); // 开机行为
    }

    public void OffAction() {
        System.out.println("电视机关机了..."); // 关机行为
    }
}