package edu.io;

import edu.io.player.Player;
import edu.io.token.AnvilToken;
import edu.io.token.GoldToken;
import edu.io.token.PickaxeToken;
import edu.io.token.PlayerToken;

import java.util.Scanner;

public class Game {

    Board board;
    Player player;

    public Game(){
        board = new Board();
    }

    public void join(Player player){
        this.player = player;

        PlayerToken playerToken = new PlayerToken(player, board);
        player.assignToken(playerToken);
    }

    public void start(){
        System.out.println("Gold Rush");
        board.placeToken(1,3,new GoldToken());
        board.placeToken(2,4, new PickaxeToken());
        board.placeToken(3,3,new AnvilToken());

        Scanner scanner = new Scanner(System.in);

        board.display();

        while(true){


            try{
                switch(scanner.nextLine().strip().toUpperCase()){
                    case "W": player.token().move(PlayerToken.Move.UP);
                        break;

                    case "A": player.token().move(PlayerToken.Move.LEFT);
                        break;

                    case "S": player.token().move(PlayerToken.Move.DOWN);
                        break;

                    case "D": player.token().move(PlayerToken.Move.RIGHT);
                        break;

                    default: System.err.println("Wrong button");
                        throw new Exception();
                }
                board.display();
                System.out.println("GOLD: "+player.gold.amount());
            }catch (IllegalArgumentException e) {
                System.err.println("Cannot move outside the board");
            }catch(Exception e){}
        }

    }
}
