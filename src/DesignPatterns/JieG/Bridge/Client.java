package DesignPatterns.JieG.Bridge;
//桥接模式

public class Client {
    public static void main(String[] args) {
        Product productA1 = new ProductA();  //实例化产品A1
        Product productA2 = new ProductA();
        Product productB1 = new ProductB();
        Product productB2 = new ProductB();

        Color red = new Red();  //实例化红色
        productA1.setName("产品1");  //命名为“产品1”
        productA1.setColor(red);  //设置为红色
        productA1.Operation();  //染上红色

        Color blue = new Blue();
        productA2.setName("产品2");
        productA2.setColor(blue);
        productA2.Operation();

        Color green = new Green();
        productB1.setName("产品3");
        productB1.setColor(green);
        productB1.Operation();

        Color pink = new Pink();
        productB2.setName("产品4");
        productB2.setColor(pink);
        productB2.Operation();
    }
}

abstract class Product{  //抽象产品
    protected Color color;
    private String name;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void Operation();  //operation：操作
}

class ProductA extends Product{  //A产品
    @Override
    public void Operation() {
        color.OperationColor(this.getName());
    }
}

class ProductB extends Product{  //B产品
    @Override
    public void Operation() {
        color.OperationColor(this.getName());
    }
}

interface Color{  //抽象颜色
    public void OperationColor(String name);
}

class Red implements Color{
    @Override
    public void OperationColor(String name) {
        System.out.println(name + "：红色");
    }
}

class Blue implements Color{
    @Override
    public void OperationColor(String name) {
        System.out.println(name + "：蓝色");
    }
}

class Green implements Color{
    @Override
    public void OperationColor(String name) {
        System.out.println(name + "：绿色");
    }
}

class Pink implements Color{
    @Override
    public void OperationColor(String name) {
        System.out.println(name + "：粉色");
    }
}