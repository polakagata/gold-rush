package edu.io.token;

public class WaterToken extends Token {
    private int amount;

    public WaterToken(){
        super(Label.WATER_TOKEN_LABEL);
        this.amount = 10;
    }

    public WaterToken(int amount){
        super(Label.WATER_TOKEN_LABEL);
        if(amount>100){
            throw new IllegalArgumentException();
        }
        if (amount >= 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public int amount(){
        return amount;
    }
}

