package DesignPatterns.XingW.Strategy;

import java.util.*;

interface BrakeBehavior {
    public void stop(); // (1)
    /* 其余代码省略 */
}

class LongWheelBrake implements BrakeBehavior {

    @Override
    public void stop() {
        System.out.println("模拟长轮胎刹车痕迹！");
    }
    /* 其余代码省略 */
}

class ShortWheelBrake implements BrakeBehavior {

    @Override
    public void stop() {
        System.out.println("模拟短轮胎刹车痕迹！");
    }
    /* 其余代码省略 */
}

abstract class Car {
    protected BrakeBehavior wheel; // (2)

    public void brake() {
        wheel.stop();
    } // (3)
    /* 其余代码省略 */
}

class ShortWheelCar extends Car {
    public ShortWheelCar(BrakeBehavior behavior) {
        wheel = behavior; // (4)
    }
    /* 其余代码省略 */
}

class StrategyTest {
    public static void main(String[] args) {
        BrakeBehavior brake = new ShortWheelBrake();
        ShortWheelCar car1 = new ShortWheelCar(brake);
        car1.brake(); // (5)
    }
}