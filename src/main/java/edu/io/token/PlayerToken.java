package edu.io.token;

import edu.io.Board;

public class PlayerToken extends Token {

    int col;
    int row;
    Board board;
    int dir;



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
        switch (dir){
            case NONE -> {

            }

            case UP -> {
                if(row>0){
                    this.board.placeToken(col, row, new EmptyToken());
                    row -=1;
                    this.board.placeToken(col, row, this);
                }else{
                    throw new IllegalArgumentException("Cannot move outside the board");
                }

            }

            case LEFT -> {
                if(col>0){
                    this.board.placeToken(col, row, new EmptyToken());
                    col -=1;
                    this.board.placeToken(col, row, this);
                }else{
                    throw new IllegalArgumentException("Cannot move outside the board");
                }
            }

            case RIGHT -> {
                if(col < this.board.size-1){
                    this.board.placeToken(col, row, new EmptyToken());
                    col +=1;
                    this.board.placeToken(col, row, this);
                }else{
                    throw new IllegalArgumentException("Cannot move outside the board");
                }
            }

            case DOWN -> {
                if(row<this.board.size-1){
                    this.board.placeToken(col, row, new EmptyToken());
                    row+=1;
                    this.board.placeToken(col, row, this);
                }else{
                    throw new IllegalArgumentException("Cannot move outside the board");
                }
            }
        }
    }

    public PlayerToken(Board board, int col, int row){

        super(Label.PLAYER_TOKEN_LABEL);

        this.col = col;
        this.row = row;
        this.board = board;

        this.board.placeToken(this.col, this.row,this);


    }
    public PlayerToken(Board board){
        super(Label.PLAYER_TOKEN_LABEL);

        this.board=board;
        this.col = 0;
        this.row = 0;

        this.board.placeToken(this.col, this.row,this);
    }

}
