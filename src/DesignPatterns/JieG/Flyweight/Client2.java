package DesignPatterns.JieG.Flyweight;
//享元模式

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Client2 {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Random random = new Random();
        String[] colors = {"red", "blue", "green", "white", "black"};

        for (int i = 1; i <= 10; i++) {
            int x = random.nextInt(colors.length); // [0 ~ 4]
            Shape shape = factory.getShape(colors[x]);

            System.out.print("第" + i + "个圆: ");
            System.out.println(shape);
            shape.draw(random.nextInt(2022), random.nextInt(528));
        }
    }
}

class ShapeFactory {
    private final Map<String, Shape> map = new HashMap<>();

    public Shape getShape(String key) {
        if (!map.containsKey(key)) {
            map.put(key, new Circle(key));
            System.out.println("create color:(" + key + " circle)");
        }
        return map.get(key);
    }
}

abstract class Shape {
    protected String color;

    public abstract void draw(int x, int y);
}

class Circle extends Shape {
    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("        x:" + x + " y:" + y);
    }
}

