package DesignPatterns.JieG.Bridge;

public class Client3 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

interface Drawing { // (1)
    void drawLine(double x1, double y1, double x2, double y2); // (2)

    void drawCircle(double x, double y, double r); // (3)
}

class V1Drawing implements Drawing {
    public void drawLine(double x1, double y1, double x2, double y2) { /* 代码省略 */ }

    public void drawCircle(double x, double y, double r) {
        DP1.draw_a_circle(x, y, r);
    } // (4)
}

class V2Drawing implements Drawing {
    public void drawLine(double x1, double y1, double x2, double y2) { /* 代码省略 */ }

    public void drawCircle(double x, double y, double r) {
        DP2.drawcircle(x, y, r);
    } // (5)
}

class DP1 {
    static public void draw_a_line(double x1, double y1, double x2, double y2) { /* 代码省略 */ }

    static public void draw_a_circle(double x, double y, double r) { /* 代码省略 */ }
}

class DP2 {
    static public void drawline(double x1, double y1, double x2, double y2) { /* 代码省略 */ }

    static public void drawcircle(double x, double y, double r) { /* 代码省略 */ }
}

abstract class Shape {
    private final Drawing _dp;

    public abstract void draw(); // (6)

    Shape(Drawing dp) {
        _dp = dp;
    }

    public void drawLine(double x1, double y1, double x2, double y2) {
        _dp.drawLine(x1, y1, x2, y2);
    }

    public void drawCircle(double x, double y, double r) {
        _dp.drawCircle(x, y, r);
    }
}

class Rectangle extends Shape {
    private final double _x1;
    private final double _x2;
    private final double _y1;
    private final double _y2;

    public Rectangle(Drawing dp, double x1, double y1, double x2, double y2) {
        super(dp);
        this._x1 = x1;
        this._y1 = y1;
        this._x2 = x2;
        this._y2 = y2;
    }

    public void draw() { /* 代码省略 */ }
}

class Circle extends Shape {
    private final double _x;
    private final double _y;
    private final double _r;

    public Circle(Drawing dp, double x, double y, double r) {
        super(dp);
        this._x = x;
        this._y = y;
        this._r = r;
    }

    public void draw() {
        drawCircle(_x, _y, _r);
    }
}

