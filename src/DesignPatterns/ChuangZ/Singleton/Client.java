package DesignPatterns.ChuangZ.Singleton;
//单例模式

public class Client {
    public static void main(String[] args) {
        Danl danl1 = Danl.getInstance();
        Danl danl2 = Danl.getInstance();
        System.out.println(danl1.getNumber() + " " + danl2.getNumber());

        danl1.setNumber(1314);
        System.out.println(danl1.getNumber() + " " + danl2.getNumber());
    }
}

class Danl {
    private int number = 521;

    private static final Danl instance = new Danl();

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private Danl() {
    }

    public static Danl getInstance() {
        return instance;
    }
}
