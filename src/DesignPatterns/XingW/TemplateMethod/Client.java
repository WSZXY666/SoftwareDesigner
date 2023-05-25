package DesignPatterns.XingW.TemplateMethod;
//模块方法模式

public class Client {
    public static void main(String[] args) {
        Person student = new Student();
        student.TemplateMethod();

        System.out.println("=====我是分割线=====");

        Person teacher = new Teacher();
        teacher.TemplateMethod();
    }
}

abstract class Person {
    public void TemplateMethod() {
        System.out.println("上课："); // 1
        PrimitiveOperation1(); // 2
        System.out.println("下课："); // 3
        PrimitiveOperation2(); // 4
    }

    public abstract void PrimitiveOperation1(); // 原语操作 1 ：上课过程  学生 听课……         老师 讲课

    public abstract void PrimitiveOperation2(); // 原语操作 2 ：作业     学生 写作业 提交作业…… 老师 批改作业 打分数
}

class Student extends Person {

    @Override
    public void PrimitiveOperation1() {
        System.out.println("学生：听课 学习 做笔记 提出问题");
    }

    @Override
    public void PrimitiveOperation2() {
        System.out.println("学生：写作业 提交作业");
    }
}

class Teacher extends Person {

    @Override
    public void PrimitiveOperation1() {
        System.out.println("老师：讲课 解答问题 布置作业");
    }

    @Override
    public void PrimitiveOperation2() {
        System.out.println("老师：批改作业 打分数");
    }
}
