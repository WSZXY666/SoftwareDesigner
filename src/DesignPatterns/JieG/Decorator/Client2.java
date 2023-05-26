package DesignPatterns.JieG.Decorator;

class Invoice {
    public void printInvoice() {
        System.out.println("This is the content of the invoice!");
    }
}

class DecoratorX extends Invoice {
    protected Invoice ticket;
    public DecoratorX(Invoice t) {
        ticket = t;
    }
    public void printInvoice() {
        if (ticket != null){
            ticket.printInvoice(); // (1)
        }
    }
}

class HeadDecorator extends DecoratorX {
    public HeadDecorator(Invoice t) {
        super(t);
    }
    public void printInvoice () {
        System.out.println("This is the header of the invoice!");
        super.printInvoice(); // (2)
    }
}

class FootDecorator extends DecoratorX {
    public FootDecorator(Invoice t) {
        super(t);
    }
    public void printInvoice() {
        super.printInvoice(); // (3)
        System.out.println("This is the footnote of the invoice!");
    }
}

class Client2 {
    public static void main(String[] args) {
        Invoice t = new Invoice();
        Invoice ticket;
        ticket = new HeadDecorator(new FootDecorator(t)); // (4)
        ticket.printInvoice();
        System.out.println("--------------------");
        ticket = new HeadDecorator(new FootDecorator(null)); // (5)
        ticket.printInvoice();
    }
}
