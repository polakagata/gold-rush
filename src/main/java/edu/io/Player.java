package edu.io;

import edu.io.token.GoldToken;
import edu.io.token.PlayerToken;
import edu.io.token.Token;

public class Player{

    private PlayerToken token;
    double gold;

    public void assignToken(PlayerToken player){
        token = player;

    }

     public PlayerToken token(){
        return token;
     }

     public double gold(){
        return gold;
     }

     public void gainGold(double gold){
        if(gold>0){
            this.gold+=gold;
        }else{
            throw new IllegalArgumentException();
        }
     }

     public void loseGold(double gold){
        if(gold>0) {
            if(this.gold-gold>=0) {
                this.gold -= gold;
            }else{
                throw new IllegalArgumentException();
            }
        }else{
            throw new IllegalArgumentException();
        }
     }

     public void interactWithToken(Token token){
        if(token instanceof GoldToken gold){
            gainGold(gold.amount());
        }
     }

}
