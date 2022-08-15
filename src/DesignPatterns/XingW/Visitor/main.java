package DesignPatterns.XingW.Visitor;
//访问者模式

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        PersonStructure structure = new PersonStructure();

        System.out.println("访问者1的访问记录：");
        Visitor1 visitor1 = new Visitor1();
        structure.Accept(visitor1);  //1、访问者1想访问列表中的记录
        System.out.println("学生年龄总和：" + visitor1.getStudentAgeSum() + "\n" + "老师年龄总和：" + visitor1.getTeacherAgeSum());

        System.out.println("===================================");
        System.out.println("访问者2的访问记录：");
        Visitor2 visitor2 = new Visitor2();
        structure.Accept(visitor2);
        System.out.println("学生最高成绩：" + visitor2.getStudentSorceMax() + "\n" + "老师最大工龄：" + visitor2.getTeacherWorkyearMax());
    }
}

interface Visitor{
    public void visitstu(Student student);
    public void visittea(Teacher teacher);
}

class Visitor1 implements Visitor{
    private int studentAgeSum = 0;
    private int teacherAgeSum = 0;

    public int getStudentAgeSum() {
        return studentAgeSum;
    }

    public int getTeacherAgeSum() {
        return teacherAgeSum;
    }

    @Override
    public void visitstu(Student student) {
        System.out.println("访问者1访问学生：" + student.getName() + " " + "年龄：" + student.getAge());  //4、输出要访问的学生
        studentAgeSum += student.getAge();
    }

    @Override
    public void visittea(Teacher teacher) {
        System.out.println("访问者1访问老师：" + teacher.getName() + " " + "年龄：" + teacher.getAge());  //4、输出要访问的老师
        teacherAgeSum += teacher.getAge();
    }
}

class Visitor2 implements Visitor{
    private int studentSorceMax = -1;
    private int teacherWorkyearMax = -1;

    public int getStudentSorceMax() {
        return studentSorceMax;
    }

    public int getTeacherWorkyearMax() {
        return teacherWorkyearMax;
    }

    @Override
    public void visitstu(Student student) {
        System.out.println("访问者2访问学生：" + student.getName() + " " +"成绩：" + student.getScore());  //4、输出要访问的学生
        studentSorceMax = Math.max(student.getScore(),studentSorceMax);
    }

    @Override
    public void visittea(Teacher teacher) {
        System.out.println("访问者2访问老师：" + teacher.getName() + " " +"工龄：" + teacher.getWorkyear());  //4、输出要访问的老师
        teacherWorkyearMax = Math.max(teacher.getWorkyear(),teacherWorkyearMax);
    }
}

class PersonStructure{
    private List<Person> personList = new ArrayList<>();

    public PersonStructure(){
        personList.add(new Student("张三",21,89));
        personList.add(new Student("李四",22,75));
        personList.add(new Student("王五",20,95));

        personList.add(new Teacher("谢老师",35,7));
        personList.add(new Teacher("汪老师",40,15));
        personList.add(new Teacher("王老师",27,3));
    }

    public void Accept(Visitor visitor){
        for (Person person : personList){
            person.Accept(visitor);  //2、接收访问者的访问请求，遍历的人（person）传入Person类的Accept方法
        }
    }
}

abstract class Person{
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void Accept(Visitor visitor);
}

class Student extends Person{
    private int score;

    public Student(String name,int age,int score){
        super(name,age);

        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.visitstu(this);  //3、传入的学生再返回到访问学生方法中
    }
}

class Teacher extends Person{
    private int workyear;

    public Teacher(String name,int age,int workyear){
        super(name,age);

        this.workyear = workyear;
    }

    public int getWorkyear() {
        return workyear;
    }

    @Override
    public void Accept(Visitor visitor) {
        visitor.visittea(this);  //3、传入的老师再返回到访问老师方法中
    }
}
