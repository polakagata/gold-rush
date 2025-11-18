package edu.io.player;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public class Vitals {
    private int hydration;
    private Runnable onDeathCallback;

    public Vitals(){
        this.hydration = 100;
        onDeathCallback = () -> {};
    }

    public int hydration(){
        return hydration;
    }

    public void hydrate(int amount){
        if(amount<0){
            throw new IllegalArgumentException();
        }
        hydration += amount;
        if (hydration > 100) {
            hydration = 100;
        }

    }
     public void dehydrate(int amount){
         if(amount<=0){
             throw new IllegalArgumentException();
         }
        hydration -= amount;
        if(hydration<=0){
            hydration = 0;
            onDeathCallback.run();
        }
     }

     public boolean isAlive(){
        if(hydration>0){
            return true;
        }else{
            return false;
        }
     }

     public void setOnDeathHandler(@NotNull Runnable callback){
         onDeathCallback = Objects.requireNonNull(callback, "callback cannot be null");
    }




}
