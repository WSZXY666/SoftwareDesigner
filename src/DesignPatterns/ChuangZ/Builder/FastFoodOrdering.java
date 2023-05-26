package DesignPatterns.ChuangZ.Builder;

class Pizza {
    private String parts;

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String toString() {
        return this.parts;
    }
}

abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizza() {
        pizza = new Pizza();
    }

    public abstract void buildParts(); // (1)
}

class HawaiianPizzaBuilder extends PizzaBuilder {
    public void buildParts() {
        pizza.setParts("cross + mild + ham&pineapp1e");
    }
}

class SpicyPizzaBuilder extends PizzaBuilder {
    public void buildParts() {
        pizza.setParts("panbaked + hot + pepperoni&salami");
    }
}

class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) { /* 设置构建器 */
        this.pizzaBuilder = pizzaBuilder; // (2)
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void construct() { /* 构建 */
        pizzaBuilder.createNewPizza();
        pizzaBuilder.buildParts(); // (3)
    }
}

class FastFoodOrdering {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder();
        waiter.setPizzaBuilder(hawaiian_pizzabuilder); // (4)
        waiter.construct(); // (5)
        System.out.println("pizza：" + waiter.getPizza());
    }
}