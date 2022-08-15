package DesignPatterns.JieG.Decorator;
//装饰器模式

/*public class main {
    public static void main(String[] args) {
        Person zhangsan = new Student("汪圣哲");
        zhangsan.Operation();
        System.out.println("\n");

        zhangsan = new DecoratorA(zhangsan);
        zhangsan.Operation();
        System.out.println("\n");

        zhangsan = new DecoratorB(zhangsan);
        zhangsan.Operation();
        System.out.println("\n");

        zhangsan = new DecoratorC(new DecoratorB(new DecoratorA(new Student("汪圣哲"))));
        zhangsan.Operation();
    }
}

abstract class Person{
    protected String name;
    public abstract void Operation();
}

class Student extends Person{
    public Student(String name){
        this.name = name;
    }

    @Override
    public void Operation() {
        System.out.print(name + "的职责：学习");
    }
}

abstract class Decorator extends Person{
    protected Person person;
}

class DecoratorA extends Decorator{
    public DecoratorA(Person person){
        this.person = person;
    }

    @Override
    public void Operation() {
        person.Operation();
        System.out.print("、写作业");
    }
}

class DecoratorB extends Decorator{
    public DecoratorB(Person person){
        this.person = person;
    }

    @Override
    public void Operation() {
        person.Operation();
        System.out.print("、考试");
    }
}

class DecoratorC extends Decorator{
    public DecoratorC(Person person){
        this.person = person;
    }

    @Override
    public void Operation() {
        person.Operation();
        System.out.print("、吃鸡");
    }
}*/
public class main {
    public static void main(String[] args) {
        Person zhangsan = new Student("张三");

        zhangsan.Operation();
        System.out.println("\n===================");

        zhangsan = new DecoratorA(zhangsan);
        zhangsan.Operation();
        System.out.println("\n===================");

        zhangsan = new DecoratorB(zhangsan);
        zhangsan.Operation();
        System.out.println("\n===================");

        // 对象链
        Person list = new DecoratorB(new DecoratorA(new Student("李四")));
        list.Operation();
    }
}

abstract class Person {
    protected String name;

    public abstract void Operation(); // 职责
}

class Student extends Person {
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void Operation() {
        System.out.print(name + "的职责：学习 "); //基础职责
    }
}

abstract class Decorator extends Person {
    protected Person person;
}

//第一个装饰器
class DecoratorA extends Decorator {
    public DecoratorA(Person person) {
        this.person = person;
    }

    @Override
    public void Operation() {
        person.Operation(); // 基础职责
        System.out.print("写作业 "); //在基础职责后添加的职责
    }
}

//第二个装饰器
class DecoratorB extends Decorator {
    public DecoratorB(Person person) {
        this.person = person;
    }

    @Override
    public void Operation() {
        person.Operation(); // 原本的职责
        System.out.print("考试 "); //在基础职责后添加的职责
    }
}