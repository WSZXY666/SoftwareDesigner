package DesignPatterns.ChuangZ.Builder;

import java.util.*;

class ProductX {
    private String partA;
    private String partB;

    public ProductX() {
    }

    public void setPartA(String s) {
        partA = s;
    }

    public void setPartB(String s) {
        partB = s;
    }
}

interface BuilderX {
    public void buildPartA(); // (1)

    public void buildPartB();

    public ProductX getResult(); // (2)
}

class ConcreteBuilder1 implements BuilderX {
    private final ProductX product;

    public ConcreteBuilder1() {
        product = new ProductX();
    }

    public void buildPartA() {
        product.setPartA("Component A");
    } // (3)

    public void buildPartB() {
        product.setPartB("Component B");
    } // (4)

    public ProductX getResult() {
        return product;
    }
}

class ConcreteBuilder2 implements BuilderX {
    @Override
    public void buildPartA() {

    }

    @Override
    public void buildPartB() {

    }

    @Override
    public ProductX getResult() {
        return null;
    }
    // 代码省略
}

class DirectorX {
    private final BuilderX builder;

    public DirectorX(BuilderX builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPartA(); // (5)
        builder.buildPartB();
        builder.getResult();
        // 代码省略
    }
}

class Client2 {
    public static void main(String[] args) {
        DirectorX director1 = new DirectorX(new ConcreteBuilder1());
        director1.construct();
    }
}
