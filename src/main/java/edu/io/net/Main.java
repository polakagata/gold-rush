package edu.io.net;

import edu.io.net.command.Handshake;
import edu.io.net.command.JoinGame;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        var gsc = new GameServerConnector("tcp://localhost:1313", new SocketConnector());
        gsc.connect();
        if (!gsc.isConnected()){
            System.err.println("Could not connect to server");
            return;
        }
        System.out.println("Połączono.");
        CountDownLatch latch1 = new CountDownLatch(1);
        gsc.issueCommand(new Handshake.Cmd(Version.FULL), res -> {latch1.countDown(); });
        latch1.await(1, TimeUnit.SECONDS);
        System.out.println("Handshake udany.");


        System.out.print("Podaj nazwę: ");
        String nazwa = new Scanner(System.in).nextLine();
        CountDownLatch latch2 = new CountDownLatch(1);
        gsc.issueCommand(new JoinGame.Cmd(nazwa), res ->{latch2.countDown();});
        latch2.await(1, TimeUnit.SECONDS);
        System.out.println("Połączono.");
        while (true){
        Thread.onSpinWait();
        }
    }
}