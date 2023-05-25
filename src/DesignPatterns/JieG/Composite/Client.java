package DesignPatterns.JieG.Composite;
//组合模式

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        AbstractFile root = new Folder("root");  //实例化根文件夹

        AbstractFile folderA = new Folder("folderA");  //实例化文件夹A
        AbstractFile folderB = new Folder("folderB");  //实例化文件夹B

        AbstractFile fileC = new File("fileC");  //实例化文件C
        AbstractFile fileD = new File("fileD");  //实例化文件D
        AbstractFile fileE = new File("fileE");  //实例化文件E

        root.Add(folderA);  //将文件夹A添加到根文件夹下
        root.Add(fileC);  //将文件C添加到根文件夹下
        root.Add(fileE);  //将文件E添加到根文件夹下

        folderA.Add(folderB);  //将文件夹B添加到文件夹A下
        folderA.Add(fileD);  //将文件D添加到文件夹A下

        paint(root);  //输出根文件夹的子文件夹名和子文件名
        System.out.print("\n");

        root.Remove(fileC);  //删除文件E
        paint(root);

        /*System.out.println(root.Add(folderA));
        System.out.println(root.Add(fileA));fileA.printNane();  //打印名称

        System.out.println(root.Remove(fileA));
        System.out.println(root.Remove(fileA));*/
    }

    static void paint(AbstractFile file) {  //打印名称功能
        file.printNane();  //打印根名称

        List<AbstractFile> childrenList = file.getChildren();
        if (childrenList == null) {
            return;
        }
        for (AbstractFile children : childrenList) {  //遍历子目录
            paint(children);  //打印子目录。若子目录还有子目录，则再次遍历子目录的子目录
        }
    }
}

abstract class AbstractFile {
    protected String name;

    public void printNane() {
        System.out.println(name);
    }

    public abstract boolean Add(AbstractFile file);

    public abstract boolean Remove(AbstractFile file);

    public abstract List<AbstractFile> getChildren();
}

class Folder extends AbstractFile {
    private final List<AbstractFile> childrenList = new ArrayList<>();

    public Folder(String name) {  //设置名称
        this.name = name;
    }

    @Override
    public boolean Add(AbstractFile file) {  //添加
        return childrenList.add(file);
    }

    @Override
    public boolean Remove(AbstractFile file) {  //删除
        return childrenList.remove(file);
    }

    @Override
    public List<AbstractFile> getChildren() {  //获取子目录
        return childrenList;
    }
}

class File extends AbstractFile {
    public File(String name) {
        this.name = name;
    }

    @Override
    public boolean Add(AbstractFile file) {
        return false;
    }

    @Override
    public boolean Remove(AbstractFile file) {
        return false;
    }

    @Override
    public List<AbstractFile> getChildren() {
        return null;
    }
}
