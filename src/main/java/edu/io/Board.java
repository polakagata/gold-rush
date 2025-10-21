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
        return grid[col][row];
    }

    public Board(){
        this.size = 8;
        this.grid = new Token[size][size];
        this.clean();
    }

    public void clean(){
        EmptyToken token = new EmptyToken();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                grid[i][j] = token;
            }
        }
    }
    public void placeToken(int col, int row, Token token){
        grid[row][col] = token;
    }


    public void display(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(grid[i][j].label());
            }
            System.out.println();
        }

    }

}
