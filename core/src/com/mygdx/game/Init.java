package com.mygdx.game;

import static com.mygdx.game.MyGdxGame.GANG_SIZE;
import static com.mygdx.game.MyGdxGame.teamBlack;
import static com.mygdx.game.MyGdxGame.teamWhite;

import com.mygdx.game.Units.*;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Init {

    public static void createTeams() {

        teamWhite = new ArrayList<>();
        for (int i = GANG_SIZE; i > 0; i--) {
            switch (new Random().nextInt(4)) {
                case 0: teamWhite.add(new Monk(getName(), 1, i)); break;
                case 1: teamWhite.add(new Crossbowman(getName(), 1, i)); break;
                case 2: teamWhite.add(new Spearman(getName(), 1, i)); break;
                default: teamWhite.add(new Peasant(getName(), 1, i));
            }
        }

        teamBlack = new ArrayList<>();
        for (int i = GANG_SIZE; i > 0; i--) {
            switch (new Random().nextInt(4)) {
                case 0:  teamBlack.add(new Wizard(getName(), 10, i)); break;
                case 1:  teamBlack.add(new Sniper(getName(), 10, i)); break;
                case 2:  teamBlack.add(new Robber(getName(), 10, i)); break;
                default: teamBlack.add(new Peasant(getName(), 10, i));
            }
        }

    }

    public static void makeStep() {

        teamWhite.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                return o2.getSpeed() - o1.getSpeed();
            }
        });

        teamBlack.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                return o2.getSpeed() - o1.getSpeed();
            }
        });

        for (int i = 0; i < GANG_SIZE; i++) {
            teamWhite.get(i).step(teamWhite, teamBlack);
            teamBlack.get(i).step(teamBlack, teamWhite);
        }
    }

    private static String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

    public static boolean teamIsAlive(ArrayList<BaseHero>team) {
        for (BaseHero unit:team) {
            if (unit.health>0) return true;
        }
        return false;
    }

}
