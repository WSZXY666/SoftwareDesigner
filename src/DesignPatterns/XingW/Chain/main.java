package DesignPatterns.XingW.Chain;
//责任链模式

public class main {
    public static void main(String[] args) {
        Handler fud = new FuD();
        Handler yuanz = new YuanZ();
        Handler xiaoz = new XiaoZ();

        fud.setNext(yuanz);
        yuanz.setNext(xiaoz);

        fud.HandlerRequest(14);
    }
}

abstract class Handler{
    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void HandlerRequest(int request);
}

class FuD extends Handler{

    @Override
    public void HandlerRequest(int request) {
        if (request <= 7){
            System.out.println("辅导员审批通过！");
        }
        else {
            if (next != null){
                next.HandlerRequest(request);
            }
            else {
                System.out.println("无法审批！");
            }
        }
    }
}

class YuanZ extends Handler{

    @Override
    public void HandlerRequest(int request) {
        if (request <= 15){
            System.out.println("院长审批通过！");
        }
        else {
            if (next != null){
                next.HandlerRequest(request);
            }
            else {
                System.out.println("无法审批！");
            }
        }
    }
}

class XiaoZ extends Handler{

    @Override
    public void HandlerRequest(int request) {
        if (request <= 30){
            System.out.println("校长审批通过！");
        }
        else {
            if (next != null){
                next.HandlerRequest(request);
            }
            else {
                System.out.println("无法审批！");
            }
        }
    }
}