package DesignPatterns.JieG.Bridge;

import java.util.*;

class Matrix { // 各种格式的文件最终都被转化为像素矩阵
    // 此处代码省略
}

abstract class Implementor {
    public abstract void doPaint(Matrix m); // (1) 显示像素矩阵m
}

class WinImp extends Implementor {
    public void doPaint(Matrix m) { // 调用 Windows 系统的绘制函数绘制像素矩阵
        // 此处代码省略
    }
}
class LinuxImp extends Implementor {
    public void doPaint(Matrix m) { // 调用 Linux 系统的绘制函数绘制像素矩阵
        // 此处代码省略
    }
}

abstract class Image {
    public void setImp(Implementor imp) { this.imp = imp; }
    public abstract void parseFile(String fileName);
    protected Implementor imp;
}

class BMPImage extends Image {
    @Override
    public void parseFile(String fileName) {

    }
    // 此处代码省略
}

class GIFImage extends Image {
    public void parseFile(String fileName) {
        // 此处解析BMP文件并获得一个像素矩阵对象m
        // imp.doPaint(m); // (2) 显示像素矩阵m

    }
}

class JPEGImage extends Image {
    @Override
    public void parseFile(String fileName) {

    }
    // 此处代码省略
}

class Client2 {
    public static void main(String[]args) {
        // 在Linux操作系统上查看demo.gif图像文件
        Image image = new GIFImage(); // (3)
        Implementor imageImp = new LinuxImp(); // (4)
        image.setImp(imageImp); // (5)
        image.parseFile("demo.gif");
    }
}
