package edu.io;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gold Rush");
        Board board = new Board();
        board.placeToken(1,3,new Token("\uD83D\uDCB0\uFE0E"));
        board.placeToken(1,1,new Token("웃"));
        board.display();
    }
}
