package DesignPatterns.ChuangZ.AbstractFactory;
//抽象工厂模式

public class Client {
    public static void main(String[] args) {
        Factory factory1 = new Factory1(); //工厂
        ProductA productA1 = factory1.createProductA(); //生产线
        ProductB productB1 = factory1.createProductB();
        productA1.info(); //生产
        productB1.info();

        Factory factory2 = new Factory2();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();
        productA2.info();
        productB2.info();
    }
}

interface Factory { //工厂
    ProductA createProductA();

    ProductB createProductB();
}

class Factory1 implements Factory { //美的工厂

    @Override
    public ProductA createProductA() { //美的电饭煲生产线
        return new ProductA1();
    }

    @Override
    public ProductB createProductB() { //美的电磁炉生产线
        return new ProductB1();
    }
}

class Factory2 implements Factory { //九阳工厂

    @Override
    public ProductA createProductA() { //九阳电饭煲生产线
        return new ProductA2();
    }

    @Override
    public ProductB2 createProductB() { //九阳电磁炉生产线
        return new ProductB2();
    }
}

interface ProductA { //电饭煲
    void info();
}

class ProductA1 implements ProductA { //美的电饭煲

    @Override
    public void info() {
        System.out.println("产品的信息：A1");
    }
}

class ProductA2 implements ProductA { //九阳电饭煲

    @Override
    public void info() {
        System.out.println("产品的信息：A2");
    }
}

interface ProductB { //电磁炉
    void info();
}

class ProductB1 implements ProductB { //美的电磁炉

    @Override
    public void info() {
        System.out.println("产品的信息：B1");
    }
}

class ProductB2 implements ProductB { //九阳电磁炉

    @Override
    public void info() {
        System.out.println("产品的信息：B2");
    }
}
