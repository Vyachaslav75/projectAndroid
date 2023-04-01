package com.mygdx.game.Units;

import java.util.ArrayList;

public interface BaseInterface {
    void step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2);
    String getInfo();
}
