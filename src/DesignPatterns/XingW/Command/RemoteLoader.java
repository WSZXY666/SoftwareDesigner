package DesignPatterns.XingW.Command;

class Light {
    public Light() {
    }

    public Light(String name) { /* 代码省略 */ }

    public void on() { /* 代码省略 */ } // 开灯

    public void off() { /* 代码省略 */ } // 关灯
    // 其余代码省略
}

interface Command2 { // (1)
    public void execute();
}

class LightOnCommand implements Command2 { // 开灯命令
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    } // (2)
}

class LightOffCommand implements Command2 { // 关灯命令
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    } // (3)
}

class RemoteControl { // 遥控器
    Command2[] onCommands = new Command2[7];
    Command2[] offCommands = new Command2[7];

    public RemoteControl() { /* 代码省略 */ }

    public void setCommand(int slot, Command2 onCommand, Command2 offCommand) {
        onCommands[slot] = onCommand; // (4)
        offCommands[slot] = offCommand; //(5)
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute(); // (6)
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute(); // (7)
    }
}

class RemoteLoader {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl(); // new一个遥控器

        Light livingRoomLight = new Light("Living Room"); // new一个客厅
        Light kitchenLight = new Light("kitchen"); // new一个厨房

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight); // new一个客厅灯打开键
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight); // new一个客厅灯关闭键

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight); // new一个厨房灯打开键
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight); // new一个厨房灯关闭键

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff); // 设置数字0为客厅灯开关
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff); // 设置数字1为厨房灯开关

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);

        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
    }
}
