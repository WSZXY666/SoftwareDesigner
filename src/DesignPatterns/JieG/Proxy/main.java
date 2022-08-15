package DesignPatterns.JieG.Proxy;
//代理模式
public class main {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        proxy.buy();
    }
}

interface Subject{
    public void buy();
}

//真正的主题只顾付钱，不需要知道过程，只需要结果，过程由代理完成
class RealSubject implements Subject{

    @Override
    public void buy() {
        System.out.println("付钱");
    }
}

//代理负责代理工作
class Proxy implements Subject{
    protected RealSubject realSubject;

    public Proxy(RealSubject realSubject){
        this.realSubject = realSubject;
    }

    @Override
    public void buy() {
        System.out.println("办理购买前的手续");
        realSubject.buy(); //应真正的主题的要求付钱
        System.out.println("办理购买后的手续");
    }
}