package DesignPatterns.ChuangZ.FactoryMethod;
//工厂方法模式

public class main {
    public static void main(String[] args) {
        Factory factory2A = new FactoryA();
        Product product2A = factory2A.createProduct();
        product2A.info();

        Factory factory2B = new FactoryB();
        Product product2B = factory2B.createProduct();
        product2B.info();
    }
}

interface Factory{
    Product createProduct();
}

class FactoryA implements Factory{

    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

class FactoryB implements Factory{

    @Override
    public Product createProduct() {
        return new ProductB();
    }
}

interface Product{
    void info();
}

class ProductA implements Product{

    @Override
    public void info() {
        System.out.println("产品的信息：A");
    }
}

class ProductB implements Product{

    @Override
    public void info() {
        System.out.println("产品的信息：B");
    }
}