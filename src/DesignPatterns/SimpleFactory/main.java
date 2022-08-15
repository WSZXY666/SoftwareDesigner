package DesignPatterns.SimpleFactory;
//简单工厂模式

public class main {
    public static void main(String[] args) {
        Product product1 = Factory.createProduct("1");
        product1.info();

        Product product2 = Factory.createProduct("2");
        product2.info();
    }
}

class Factory{
    public static Product createProduct(String type){
        Product product = null;
        switch (type){
            case "1":
                product = new Product1();
                break;
            case "2":
                product = new Product2();
                break;
            default:
                System.out.println("没有" + type + "类型的产品！");
                break;
        }
        return product;
    }
}

abstract class Product{
    public abstract void info();
}

class Product1 extends Product{

    @Override
    public void info() {
        System.out.println("产品的信息：1");
    }
}

class Product2 extends Product{

    @Override
    public void info() {
        System.out.println("产品的信息：2");
    }
}