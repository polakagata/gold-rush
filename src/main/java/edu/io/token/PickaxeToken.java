package edu.io.token;

import edu.io.player.Repairable;
import edu.io.player.Tool;

public class PickaxeToken extends Token implements Tool, Repairable {
    private double gainFactor;
    private Token pickaxeToken = new EmptyToken();
    private int durability;
    private Token withToken;
    private int maxDur;

    public PickaxeToken(){
        this(1.5, 3);
    }

    public PickaxeToken(double gainFactor){
        this(gainFactor, 3);
    }

    public PickaxeToken(double gainFactor, int durability){
        super(Label.PICKAXE_TOKEN_LABEL);
        if(durability<=0 || gainFactor<=0){
            throw new IllegalArgumentException();
        }
        this.gainFactor = gainFactor;
        this.durability = durability;
        this.maxDur = durability;
    }

    public PickaxeToken(int durability){
        this(1.5,durability);
    }


    public double gainFactor(){
        return gainFactor;
    }

    public int durability(){
        return durability;
    }

    public void use(){
        if(durability > 0){
            durability--;
        }
    }

    public boolean isBroken(){
        return this.durability <= 0;
    }

    public PickaxeToken useWith(Token token){
        this.withToken = token;
        return this;
    }

    public PickaxeToken isBroken(Runnable action){
        if(isBroken()){
            action.run();
        }
        return this;
    }

    public PickaxeToken ifWorking(Runnable action){
        if(this.withToken instanceof GoldToken){
            this.use();
            if(!this.isBroken()) action.run();
        }
        return this;
    }

    @Override
    public Tool ifBroken(Runnable action) {
        if(this.withToken instanceof GoldToken){
            this.use();
            if(this.isBroken()) action.run();
        }
        return this;
    }

    public PickaxeToken ifIdle(Runnable action){
        if(!(this.withToken instanceof GoldToken)){
            action.run();
        }
        return this;
    }


    @Override
    public void repair() {
        this.durability = maxDur;
    }
}
