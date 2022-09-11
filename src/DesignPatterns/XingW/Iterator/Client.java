package DesignPatterns.XingW.Iterator;
//迭代器模式

import java.util.*;

public class Client {
    public static void main(String[] args) {
        BookAggregate bookAggregate = new BookAggregate();

        String[] books = {"数据结构", "操作系统", "计算机网络", "计算机组成原理"};
        double[] prices = {20.21, 48.49, 10.11, 24.25};

        for (int i = 0; i < 4; i ++ ) {
            bookAggregate.Add(new Book(books[i], prices[i]));
        }

        Iterator bookIterator = bookAggregate.CreateIterator();
        while (bookIterator.hasNext()) {
            Book book = (Book) bookIterator.next();
            System.out.println(book.getName() + " " + book.getPrice());
        }
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

//书的迭代器
class BookIterator implements Iterator {
    private int index;
    private BookAggregate bookAggregate;

    public BookIterator(BookAggregate bookAggregate) {
        this.index = 0;
        this.bookAggregate = bookAggregate;
    }

    @Override
    public boolean hasNext() {
        if (index < bookAggregate.getSize()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Object obj = bookAggregate.get(index);
        index ++ ;

        return obj;
    }
}

interface Aggregate {
    Iterator CreateIterator();
}

//书的聚合
class BookAggregate implements Aggregate {
    private List<Book> list = new ArrayList<Book>();

    public void Add(Book book) {
        list.add(book);
    }

    public Book get(int index) {
        return list.get(index);
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public Iterator CreateIterator() {
        return new BookIterator(this);
    }
}


/*public class main {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();

        String[] books = {"数据结构", "操作系统", "计算机网络", "计算机组成原理"};
        double[] prices = {10.24, 20.48, 40.96, 81.92};

        for (int i = 0; i < 4; i++) {
            bookList.add(new Book(books[i], prices[i]));
        }

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            System.out.println(book.getName() + " " + book.getPrice());
        }

        System.out.println("=========");

        for (Book book : bookList) {
            System.out.println(book.getName() + " " + book.getPrice());
        }

        System.out.println("=========");

        Iterator iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName() + " " + book.getPrice());
        }
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}*/




