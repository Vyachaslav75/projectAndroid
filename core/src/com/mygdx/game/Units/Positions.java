package com.mygdx.game.Units;

import java.util.ArrayList;

public class Positions {
    protected int x;
    protected int y;

    public Positions(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(int x1, int y1){
        return Math.sqrt(Math.pow((x1-this.x), 2)+Math.pow((y1-this.y), 2));
    }

    public boolean isEquals(Positions position){
        if ((position.x == this.x) & (position.y == this.y)) return  true;
        else return  false;
    }
}
