package DesignPatterns.ChuangZ.Prototype;

//原型模式
public class Client {
    public static void main(String[] args) {
        Product product1 = new Product(2022,5.28);
        System.out.println("产品1：" + product1.getId() + " " + product1.getPrice());

        Product product2 = (Product) product1.Clone(); //让一个原型复制自身从而创建一个新的对象
        System.out.println("产品2：" + product2.getId() + " " + product2.getPrice());

        Product product3 = (Product) product1.Clone();
        System.out.println("产品3：" + product3.getId() + " " + product3.getPrice());
    }
}

interface Prototype{  //声明一个复制自身的接口
    public Object Clone();
}

class Product implements Prototype{ //实现一个复制自身的操作
    private int id;
    private double price;

    public Product(){}

    public Product(int id,double price){
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public Object Clone() {
        Product object = new Product();
        object.id = this.id;
        object.price = this.price;

        return object;
    }
}
/*public class main1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Product product1 = new Product(2022,5.28);
        System.out.println(product1.getId() + " " + product1.getPrice());
        Product product2 = (Product) product1.clone();
        System.out.println(product2.getId() + " " + product2.getPrice());
        Product product3 = (Product) product1.clone();
        System.out.println(product3.getId() + " " + product3.getPrice());
    }
}

class Product implements Cloneable{
    private int id;
    private double price;

    public Product(int id,double price){
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}*/