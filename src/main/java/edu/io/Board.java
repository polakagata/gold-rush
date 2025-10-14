package edu.io;

public class Board {
    public int size;
    public Token[][] grid;

    public Board(){
        this.size = 8;
        this.grid = new Token[size][size];
        this.clean();
    }

    public void clean(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                grid[i][j] = new Token("・");
            }
        }
    }
    public void placeToken(int col, int row, Token token){
        grid[row][col] = token;
    }

    public Token square(int col, int row){
        return grid[row][col];
    }

    public void display(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(grid[i][j].label);
            }
            System.out.println();
        }

    }

}
