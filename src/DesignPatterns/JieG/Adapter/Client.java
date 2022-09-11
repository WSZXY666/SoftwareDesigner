package DesignPatterns.JieG.Adapter;
//适配器模式

public class Client {
    public static void main(String[] args) {
        USB usb = new Adapter();
        usb.Request();
    }
}

class USB{  //USB接口
    public void Request(){
        System.out.println("USB数据线");
    }
}

class Adapter extends USB{  //转接头
    TypeC typeC = new TypeC();

    @Override
    public void Request() {
        typeC.SpecificRequest();
    }
}

class TypeC{  //TypeC接口
    public void SpecificRequest(){
        System.out.println("TypeC数据线");
    }
}
