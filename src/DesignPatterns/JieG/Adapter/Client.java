package DesignPatterns.JieG.Adapter;
//适配器模式

public class Client {
    public static void main(String[] args) {
        USB usb1 = new USB();
        usb1.Request();

        USB usb2 = new Adapter();
        usb2.Request();
    }
}

class USB {  //USB接口
    public void Request() {
        System.out.println("USB数据线");
    }
}

class Adapter extends USB {  //转接头
    TypeC typeC = new TypeC();

    @Override
    public void Request() {
        typeC.SpecificRequest();
    }
}

class TypeC {  //TypeC接口
    public void SpecificRequest() {
        System.out.println("TypeC数据线");
    }
}
