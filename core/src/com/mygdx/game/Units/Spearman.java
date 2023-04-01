package com.mygdx.game.Units;
public class Spearman extends Infantry {
    public Spearman(String name, int x, int y) {
        super(10, 4, 1, 3, 5, 4, name, x, y, 1);
    }

    public String getInfo(){
        return String.format("%s ", super.getInfo());
    }

    public String getType(){return "Копейщик";}
    public String getName(){return "Копейщик";}
}
