package com.mygdx.game.Units;
public class Monk extends Mages {
    //private int mana;
    //private int manaMax;
    public Monk(String name, int x, int y) { //, int manaMax) {
        super(30, 12, -4, -4, 7, 5, name, x, y, 1);
        //this.manaMax = 1;
        //this.mana = manaMax;
    }

    public String getInfo(){
        return String.format("%s Mana: %d", super.getInfo(), this.mana);
    }

    public String getType(){return "Монах";}
    public String getName(){return "Монах";}
}
