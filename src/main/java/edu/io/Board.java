package edu.io;

import edu.io.token.EmptyToken;
import edu.io.token.Token;

public class Board {
    public int size;
    public Token[][] grid;

    public record Coords(int col, int row){

    }

    public int size(){
        return size;
    }

    public Token peekToken(int col, int row){
        return grid[row][col];
    }

    public Board(){
        this.size = 8;
        this.grid = new Token[size][size];
        this.clean();
    }

    public void clean(){
        EmptyToken token = new EmptyToken();
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                grid[row][col] = token;
            }
        }
    }
    public void placeToken(int col, int row, Token token){
        grid[row][col] = token;
    }


    public void display(){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                System.out.print(grid[row][col].label());
            }
            System.out.println();
        }

    }

    public Coords getAvailableSquare(){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                if(grid[row][col] instanceof EmptyToken){
                    return new Coords(col, row);
                }
            }
        }
        throw new IllegalStateException();
    }

}
