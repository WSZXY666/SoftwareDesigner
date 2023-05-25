package DesignPatterns.JieG.Facade;
//外观模式

public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();

        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}

class Facade {
    SubSystemA subSystemA;
    SubSystemB subSystemB;
    SubSystemC subSystemC;

    public Facade() {
        subSystemA = new SubSystemA();
        subSystemB = new SubSystemB();
        subSystemC = new SubSystemC();
    }

    public void methodA() {
        subSystemA.method();
    }

    public void methodB() {
        subSystemB.method();
    }

    public void methodC() {
        subSystemC.method();
    }
}

class SubSystemA {
    public void method() {
        System.out.println("执行子系统一的功能");
    }
}

class SubSystemB {
    public void method() {
        System.out.println("执行子系统二的功能");
    }
}

class SubSystemC {
    public void method() {
        System.out.println("执行子系统三的功能");
    }
}

