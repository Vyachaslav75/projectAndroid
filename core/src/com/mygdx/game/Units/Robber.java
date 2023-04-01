package com.mygdx.game.Units;
public class Robber extends Infantry {


    public Robber(String name, int x, int y) {
        super(10, 8, 2, 4, 3, 6, name, x, y, 1);;
    }

    public String getInfo(){
        return String.format("%s ", super.getInfo());
    }

    public String getType(){return "Разбойник";}
    public String getName(){return "Разбойник";}
}
