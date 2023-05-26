package DesignPatterns.JieG.Decorator;

import java.util.*;

abstract class Beverage { // (1) 饮料
    String description = "Unknown Beverage";

    public String getDescription() { // (2)
        return description;
    }

    public abstract int cost(); // (3)
}

class Espresso extends Beverage { // 蒸馏咖啡
    private final int ESPRESSO_PRICE = 25;

    public Espresso() {
        description = "Espresso";
    }

    public int cost() {
        return ESPRESSO_PRICE;
    }
}

class DarkRoast extends Beverage { // 深度烘焙咖啡
    private final int DARKROAST_PRICE = 20;

    public DarkRoast() {
        description = "DarkRoast";
    }

    public int cost() {
        return DARKROAST_PRICE;
    }
}

abstract class CondimentDecorator extends Beverage { // 配料
    public Beverage beverage; // (4)
}

class Mocha extends CondimentDecorator { // 摩卡
    private final int MOCHA_PRICE = 10;
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public int cost() {
        return MOCHA_PRICE + beverage.cost();
    }
}

class Whip extends CondimentDecorator { // 奶泡
    private final int WHIP_PRICE = 8;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    public int cost() {
        return WHIP_PRICE + beverage.cost();
    }
}

public class Coffee {
    public static void main(String[] args) {
        Beverage beverage = new DarkRoast();
        beverage = new Mocha(beverage); // (5)
        beverage = new Whip(beverage); // (6)
        System.out.println(beverage.getDescription() + " ￥" + beverage.cost());
    }
}
