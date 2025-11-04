package edu.io.player;

import edu.io.token.Token;

public interface Tool {

    Tool useWith(Token token);
    Tool ifWorking(Runnable runnable);
    Tool ifBroken(Runnable runnable);
    Tool ifIdle(Runnable runnable);

    boolean isBroken();

}
