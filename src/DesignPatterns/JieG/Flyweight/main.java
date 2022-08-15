package DesignPatterns.JieG.Flyweight;
//享元模式

public class main {
    public static void main(String[] args) {
        PieceFactory pieceFactory = new PieceFactory();

        Piece whitePiece1 = pieceFactory.getPiece(0);
        System.out.println(whitePiece1);
        whitePiece1.draw(2022,528);

        Piece whitePiece2 = pieceFactory.getPiece(0); //共享pieceFactory.getPiece(0);
        System.out.println(whitePiece2);
        whitePiece2.draw(2023,529); //两个白色棋子坐标不同，但地址相同，都是@1b6d3586

        System.out.println("============================================");
        Piece blackPiece1 = pieceFactory.getPiece(1);
        System.out.println(blackPiece1);
        blackPiece1.draw(2024,610);

        Piece blackPiece2 = pieceFactory.getPiece(1); //共享pieceFactory.getPiece(1);
        System.out.println(blackPiece2);
        blackPiece2.draw(2001,121); //两个黑色棋子坐标不同，但地址相同，都是@4554617c
    }
}

class PieceFactory{
    private Piece[] pieces= {new WhitePiece(),new BlackPiece()};

    public Piece getPiece(int key){
        if (key == 0){
            return pieces[0];
        }
        else {
            return pieces[1];
        }
    }
}

abstract class Piece{
    protected String color;
    public abstract void draw(int x,int y);

}

class WhitePiece extends Piece{
    public WhitePiece(){
        this.color = "white";
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("draw a color:" + color + "piece x:" + x + " y:" + y + "\n");
    }
}

class BlackPiece extends Piece{
    public BlackPiece(){
        this.color = "black";
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("draw a color:" + color + "piece x:" + x + " y:" + y + "\n");
    }
}