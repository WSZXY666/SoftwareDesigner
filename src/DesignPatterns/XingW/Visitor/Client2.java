package DesignPatterns.XingW.Visitor;

import java.util.*;

public class Client2 {
    public static void main(String[] args) {
        Book book = new Book("zst", "《软设下午》", 446);
        Article article = new Article("wsz", "《论吃饭》", 1, 66);

        LibraryVisitor librarySumPrintVisitor = new LibrarySumPrintVisitor();

        librarySumPrintVisitor.visit(book);
        librarySumPrintVisitor.visit(article);

        librarySumPrintVisitor.printSum();
    }
}

interface LibraryVisitor {
    void visit(Book p_book);// (1)

    void visit(Article p_article);// (2)

    void printSum();
}

class LibrarySumPrintVisitor implements LibraryVisitor { // 打印总页数
    private int sum = 0;

    public void visit(Book p_book) {
        sum = sum + p_book.getNumberOfPages();
    }

    public void visit(Article p_article) {
        sum = sum + p_article.getNumberOfPages();
    }

    public void printSum() {
        System.out.println("SUM = " + sum);
    }
}

interface LibraryItemInterface {
    void accept(LibraryVisitor visitor);// (3)
}

class Article implements LibraryItemInterface {
    private final String m_title; // 论文名
    private final String m_author; // 论文作者
    private final int m_start_page;
    private final int m_end_page;

    public Article(String p_author, String p_title, int p_start_page, int p_end_page) {
        m_title = p_title;
        m_author = p_author;
        m_start_page = p_start_page;
        m_end_page = p_end_page;
    }

    public int getNumberOfPages() {
        return m_end_page - m_start_page;
    }

    public void accept(LibraryVisitor visitor) {
        visitor.visit(this); // (4);
    }
}

class Book implements LibraryItemInterface {
    private final String m_title; // 书名
    private final String m_author; // 书作者
    private final int m_pages; // 页教

    public Book(String p_author, String p_title, int p_pages) {
        m_title = p_title;
        m_author = p_author;
        m_pages = p_pages;
    }

    public int getNumberOfPages() {
        return m_pages;
    }

    public void accept(LibraryVisitor visitor) {
        visitor.visit(this); // (5)
    }
}