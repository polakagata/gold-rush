package edu.io.player;

import edu.io.token.*;

import java.util.Objects;

public class Player{

    private PlayerToken token;
    private Token pickaxeToken;
    public final Gold gold = new Gold();
    public final Vitals vitals = new Vitals();
    public final Shed shed = new Shed();


    public void assignToken(PlayerToken player){
        Objects.requireNonNull(player);
        token = player;
    }

     public PlayerToken token(){
        return token;
     }

     public void interactWithToken(Token token){
         Objects.requireNonNull(token);
        if(!this.vitals.isAlive()){
            throw new IllegalStateException("Player is dead");
        }
        if(token instanceof GoldToken gold){
            vitals.dehydrate(VitalsValues.DEHYDRATION_GOLD);
            System.out.printf("GOLD!\n");
            double amount = gold.amount();
            if (pickaxeToken instanceof PickaxeToken pickaxe){
                if(pickaxe.durability()>0){
                  amount *= pickaxe.gainFactor();
                  pickaxe.use();
                }else pickaxeToken = new EmptyToken();
            }
            this.gold.gain(amount);
        }else if (token instanceof PickaxeToken pickaxe){
            pickaxeToken = pickaxe;
        }else if(token instanceof AnvilToken){
            vitals.dehydrate(VitalsValues.DEHYDRATION_ANVIL);
            if(pickaxeToken instanceof PickaxeToken pt){
                pt.repair();
            }
        }else if(token instanceof EmptyToken){
            vitals.dehydrate(VitalsValues.DEHYDRATION_MOVE);
        }else if(token instanceof WaterToken water){
            vitals.hydrate(water.amount());
        }
    }
}

