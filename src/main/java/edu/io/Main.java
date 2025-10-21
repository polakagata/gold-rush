package edu.io;

import edu.io.token.GoldToken;
import edu.io.token.PlayerToken;
import edu.io.token.Token;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gold Rush");
        Board board = new Board();
        board.placeToken(1,3,new GoldToken());
        PlayerToken player = new PlayerToken(board, 0,0);
        board.display();
    }
}
