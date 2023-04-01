package com.mygdx.game.Units;
public class Crossbowman extends Shooter {


    public Crossbowman(String name, int x, int y) {

        super(10, 6, 2, 3, 3, 4, name, x, y, 16);
    }

    public String getInfo(){
        return String.format("%s Arrows: %d", super.getInfo(), this.arrows);
    }

    public String getType(){return "Арбалетчик";}
    public String getName(){return "Арбалетчик";}


}
