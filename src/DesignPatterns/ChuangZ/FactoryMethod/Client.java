package DesignPatterns.ChuangZ.FactoryMethod;
//工厂方法模式

public class Client {
    public static void main(String[] args) {
        Factory factory2A = new FactoryA();
        Product product2A = factory2A.createProduct();
        product2A.info();

        Factory factory2B = new FactoryB();
        Product product2B = factory2B.createProduct();
        product2B.info();
    }
}

interface Factory { //工厂
    Product createProduct();
}

class FactoryA implements Factory { //美的工厂

    @Override
    public Product createProduct() { //美的电磁炉生产线
        return new ProductA();
    }
}

class FactoryB implements Factory { //九阳工厂

    @Override
    public Product createProduct() { //九阳电磁炉生产线
        return new ProductB();
    }
}

interface Product { //电磁炉
    void info();
}

class ProductA implements Product { //美的电磁炉

    @Override
    public void info() {
        System.out.println("产品的信息：A");
    }
}

class ProductB implements Product { //九阳电磁炉

    @Override
    public void info() {
        System.out.println("产品的信息：B");
    }
}