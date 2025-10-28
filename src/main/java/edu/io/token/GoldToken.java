package edu.io.token;

public class GoldToken extends Token{
    double amount;

    public GoldToken(){
        super(Label.GOLD_TOKEN_LABEL);
        this.amount = 1;
    }

    public GoldToken(double amount){
        super(Label.GOLD_TOKEN_LABEL);
        if(amount>=0)
        {
            this.amount = amount;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public double amount(){
        return amount;
    }

}

