package edu.io.player;

import edu.io.token.*;

public class Player{

    private PlayerToken token;
    private Token pickaxeToken;
    public final Gold gold = new Gold();
    public final Shed shed = new Shed();


    public void assignToken(PlayerToken player){
        token = player;

    }

     public PlayerToken token(){
        return token;
     }

     public void interactWithToken(Token token){
        if(token instanceof GoldToken gold){
            System.out.printf("GOLD!\n");
            double amount = gold.amount();
            if (pickaxeToken instanceof PickaxeToken pickaxe){
                if(pickaxe.durability()>0){
                  amount *= pickaxe.gainFactor();
                  pickaxe.use();
                  //System.out.print("Durability: " + pickaxe.durability() + "\n");
                }else pickaxeToken = new EmptyToken();
            }
            this.gold.gain(amount);
        }else if (token instanceof PickaxeToken pickaxe){
            pickaxeToken = pickaxe;
        }else if(token instanceof AnvilToken){
            if(pickaxeToken instanceof PickaxeToken pt){
                pt.repair();
            }
        }
    }
}

