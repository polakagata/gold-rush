package edu.io;

import java.util.Scanner;
import edu.io.token.GoldToken;
import edu.io.token.PlayerToken;
import edu.io.token.Token;

import static java.nio.file.Files.move;


public class Main {
    public static void main(String[] args) {
        System.out.println("Gold Rush");
        Board board = new Board();
        board.placeToken(1,3,new GoldToken());
        PlayerToken player = new PlayerToken(board, 0,0);

        Scanner scanner = new Scanner(System.in);

        board.display();

        while(true){


            try{
                switch(scanner.nextLine().strip().toUpperCase()){
                    case "W": player.move(PlayerToken.Move.UP);
                        break;

                    case "A": player.move(PlayerToken.Move.LEFT);
                        break;

                    case "S": player.move(PlayerToken.Move.DOWN);
                        break;

                    case "D": player.move(PlayerToken.Move.RIGHT);
                        break;

                    default: System.err.println("Wrong button");
                        throw new Exception();
                }
                board.display();
            }catch (IllegalArgumentException e) {
                System.err.println("Cannot move outside the board");
            }catch(Exception e){}
        }





        }


    }

