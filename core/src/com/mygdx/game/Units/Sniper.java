package com.mygdx.game.Units;
public class Sniper extends Shooter {
    public Sniper(String name, int x, int y) {

        super(15, 12, 8, 10, 10, 9, name, x, y, 32);
    }

    public String getInfo(){
        return String.format("%s Arrows: %d", super.getInfo(), this.arrows);
    }

    public String getType(){return "Снайпер";}
    public String getName(){return "Снайпер";}
}
