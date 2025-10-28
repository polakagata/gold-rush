package edu.io.token;

import edu.io.Board;
import edu.io.Player;

public class PlayerToken extends Token {

    int col;
    int row;
    Board board;
    int dir;
    Player player;


    public Board.Coords pos(){
        return new Board.Coords(col, row);
    }

    public enum Move{
        NONE,
        UP,
        LEFT,
        RIGHT,
        DOWN
    }

    public void move(Move dir){
       if(dir==Move.NONE){
           return;
       }
       int newCol = col;
       int newRow = row;

       switch(dir){
           case UP -> newRow -=1;
           case DOWN -> newRow +=1;
           case LEFT -> newCol -=1;
           case RIGHT -> newCol+=1;
       }

       if(!(newCol >= 0 && newCol < this.board.size &&
               newRow >= 0 && newRow < this.board.size)){
           throw new IllegalArgumentException("Cannot move outside the board");
       }

       this.player.interactWithToken(board.peekToken(newCol, newRow));

        this.board.placeToken(col, row, new EmptyToken());
        col = newCol;
        row = newRow;
        this.board.placeToken(col, row, this);
    }


    public PlayerToken(Player player,Board board){
        super(Label.PLAYER_TOKEN_LABEL);

        this.board=board;
        Board.Coords place = board.getAvailableSquare();
        this.col = place.col();
        this.row = place.row();
        this.player = player;

        this.board.placeToken(this.col, this.row,this);
    }

}
