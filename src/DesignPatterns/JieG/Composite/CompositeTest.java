package DesignPatterns.JieG.Composite;

import java.util.*;

abstract class MenuComponent {  // 构成层叠菜单的元素
    protected String name; // (1)            // 菜单项或子菜单名称

    public void printName() {
        System.out.println(name);
    }

    public abstract boolean addMenuElement(MenuComponent element); // (2)

    public abstract boolean removeMenuElement(MenuComponent element);

    public abstract List<MenuComponent> getElement(); // (3)
}


class MenuItem extends MenuComponent {
    public MenuItem(String name) {
        this.name = name;
    }

    public boolean addMenuElement(MenuComponent element) {
        return false;
    }

    public boolean removeMenuElement(MenuComponent element) {
        return false;
    }

    public List<MenuComponent> getElement() {
        return null;
    }
}

class Menu extends MenuComponent {
    private final List<MenuComponent> elementList; // (4)

    public Menu(String name) {
        this.name = name;
        this.elementList = new ArrayList<>();
    }

    public boolean addMenuElement(MenuComponent element) {
        return elementList.add(element);
    }

    public boolean removeMenuElement(MenuComponent element) {
        return elementList.remove(element);
    }

    public List<MenuComponent> getElement() {
        return elementList;
    }
}

class CompositeTest {
    public static void main(String[] args) {
        MenuComponent root = new Menu("Root");
        MenuComponent folder1 = new Menu("Folder1");
        MenuComponent folder2 = new Menu("Folder2");
        MenuComponent folder3 = new Menu("Folder3");
        MenuComponent file1 = new MenuItem("File1");
        MenuComponent file2 = new MenuItem("File2");
        MenuComponent file3 = new MenuItem("File3");
        root.addMenuElement(file1); // (5)
        root.addMenuElement(folder1);
        root.addMenuElement(folder2);

        folder1.addMenuElement(folder3);
        folder1.addMenuElement(file2);

        folder3.addMenuElement(file3);
        printMenus(root);
    }

    private static void printMenus(MenuComponent ifile) {
        ifile.printName();
        List<MenuComponent> children = ifile.getElement();
        if (children == null) return;
        for (MenuComponent element : children) {
            printMenus(element);
        }
    }
}
