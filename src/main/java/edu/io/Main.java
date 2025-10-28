package edu.io;

import java.util.Scanner;
import edu.io.token.GoldToken;
import edu.io.token.PlayerToken;
import edu.io.token.Token;

import static java.nio.file.Files.move;


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player player = new Player();
        game.join(player);
        game.start();
        }
    }

