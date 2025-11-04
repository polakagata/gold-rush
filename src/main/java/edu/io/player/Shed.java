package edu.io.player;

import java.util.Stack;

public class Shed {

    Stack<Tool> tools =new Stack<>();
    private final Tool noTool = new NoTool();

    public boolean isEmpty(){
        return tools.isEmpty();
    }

    public void add(Tool tool){
        if(tool == null){
            throw new IllegalArgumentException();
        }
        tools.add(tool);
    }

    public Tool getTool(){
        if(isEmpty()){
            return noTool;
        }
        return tools.peek();
    }

    public void dropTool(){
        tools.pop();
    }


}
