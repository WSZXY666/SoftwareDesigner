package DesignPatterns.ChuangZ.Singleton;
//单例模式

public class main {
    public static void main(String[] args) {
        Danl danl1 = Danl.getInstance();
        Danl danl2 = Danl.getInstance();
        Danl danl3 = Danl.getInstance();
        System.out.println(danl1.getNumber() + " " + danl2.getNumber() + " " + danl3.getNumber());

        danl1.setNumber(1314);
        System.out.println(danl1.getNumber() + " " + danl2.getNumber() + " " + danl3.getNumber());
    }
}

class Danl{
    private int number = 521;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private static Danl instance = new Danl();

    private Danl(){}

    public static Danl getInstance(){
        return instance;
    }
}
