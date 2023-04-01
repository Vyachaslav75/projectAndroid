package com.mygdx.game.hmm;
import com.mygdx.game.Init;
import com.mygdx.game.Units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseHero> whiteSide = new ArrayList<>();
    public static ArrayList<BaseHero> darkSide = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();

        while (true){
            ConsoleView.view();
            step();
            sc.nextLine();
        }
    }
    public static void init(){
        for (int i = 1; i < GANG_SIZE+1; i++) {
            switch (new Random().nextInt(4)){
                case 0:
                    whiteSide.add(new Peasant(getName(), 1, i));
                    darkSide.add(new Peasant(getName(), 10, i));
                    break;
                case 1:
                    whiteSide.add(new Robber(getName(), 1, i));
                    darkSide.add(new Spearman(getName(), 10, i));
                    break;
                case 2:
                    whiteSide.add(new Sniper(getName(), 1, i));
                    darkSide.add(new Crossbowman(getName(), 10, i));
                    break;
                default:
                    whiteSide.add(new Wizard(getName(), 1, i));
                    darkSide.add(new Monk(getName(), 10, i));
                    break;
            }
        }
    }
    public static void step(){
        ArrayList<BaseHero> allHeroes = new ArrayList<>();
        allHeroes.addAll(whiteSide);
        allHeroes.addAll(darkSide);
        allHeroes.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                if (o1.getSpeed() == o2.getSpeed()){
                    return 0;
                } else if (o1.getSpeed() > o2.getSpeed()) {
                    return -1;
                }else
                    return 1;
            }
        });
        for (BaseHero hero: allHeroes) {
            if (whiteSide.contains(hero)){
                hero.step(darkSide, whiteSide);
            }else{
                hero.step(whiteSide, darkSide);
            }
        }
    }
    private static String getName(){
        return  Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
}