package DesignPatterns.ChuangZ.Builder;
//生成器模式

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Director director = new Director();

        Builder builder1 = new Builder1();
        director.Construct(builder1);
        Product product1 = builder1.getResult();
        product1.show();

        Builder builder2 = new Builder2();
        director.Construct(builder2);
        Product product2 = builder2.getResult();
        product2.show();
    }
}

class Director {
    public void Construct(Builder builder) {
        builder.BuildpartA();
        builder.BuildpartB();
    }
}

abstract class Builder {
    public abstract void BuildpartA();

    public abstract void BuildpartB();

    public abstract Product getResult();
}

class Builder1 extends Builder {
    Product product = new Product();

    @Override
    public void BuildpartA() {
        product.Add("瓶身");
    }

    @Override
    public void BuildpartB() {
        product.Add("瓶盖");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class Builder2 extends Builder {
    Product product = new Product();

    @Override
    public void BuildpartA() {
        product.Add("醋");
    }

    @Override
    public void BuildpartB() {
        product.Add("小苏打");
    }

    @Override
    public Product getResult() {
        return product;
    }
}

class Product {
    List<String> parts = new ArrayList<>();

    public void Add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.print("产品的组成：");
        for (String s : parts) {
            System.out.print(s + " ");
        }
        System.out.print("\n");
    }
}
