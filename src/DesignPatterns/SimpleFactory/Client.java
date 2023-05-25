package DesignPatterns.SimpleFactory;
//简单工厂模式

public class Client {
    public static void main(String[] args) {
        Product productA = Factory.createProduct("A");
        Product productB = Factory.createProduct("B");

        productA.info();
        productB.info();
    }
}

class Factory { //工厂
    public static Product createProduct(String type) { //工厂生产线
        Product product = null;
        switch (type) {
            case "A":
                product = new ProductA(); //美的电磁炉生产线
                break;
            case "B":
                product = new ProductB(); //九阳电磁炉生产线
                break;
            default:
                System.out.println("没有" + type + "类型的产品！");
                break;
        }
        return product;
    }
}

abstract class Product { //电磁炉
    public abstract void info();
}

class ProductA extends Product { //美的电磁炉

    @Override
    public void info() {
        System.out.println("产品的信息：A");
    }
}

class ProductB extends Product { //九阳电磁炉

    @Override
    public void info() {
        System.out.println("产品的信息：B");
    }
}